package com.blued.android.chat.core.worker.chat;

import androidx.collection.ArrayMap;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.pack.BasePackage;
import com.blued.android.chat.core.pack.PushMsgPackage;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.chat.core.pack.ReqApplyJoinLivePackage;
import com.blued.android.chat.core.pack.ReqBasePackage;
import com.blued.android.chat.core.pack.ReqCloseLiveChatPackage;
import com.blued.android.chat.core.pack.ReqCreateLiveChatPackage;
import com.blued.android.chat.core.pack.ReqEnterLiveChatPackage;
import com.blued.android.chat.core.pack.ReqGetLiveChatInfoPackage;
import com.blued.android.chat.core.pack.ReqLeaveLiveChatPackage;
import com.blued.android.chat.core.pack.ReqLiveChatStatusChangePackage;
import com.blued.android.chat.core.pack.ReqLiveChatStopTalkPackage;
import com.blued.android.chat.core.pack.ReqNotifyLiveJoinEndPackage;
import com.blued.android.chat.core.pack.ReqNotifyLiveJoinStartPackage;
import com.blued.android.chat.core.pack.ReqRecoverLiveChatPackage;
import com.blued.android.chat.core.pack.ReqStartJoinLive;
import com.blued.android.chat.core.pack.SendAckPackage;
import com.blued.android.chat.core.pack.SendMsgPackage;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.core.worker.BaseWorker;
import com.blued.android.chat.core.worker.Connector;
import com.blued.android.chat.core.worker.PackSendHelper;
import com.blued.android.chat.data.EntranceData;
import com.blued.android.chat.data.JoinLiveResult;
import com.blued.android.chat.data.LiveChatInitData;
import com.blued.android.chat.data.LiveChatStatistics;
import com.blued.android.chat.data.LiveCloseReason;
import com.blued.android.chat.data.LiveCreateFailedReason;
import com.blued.android.chat.data.LiveEnterFailedReason;
import com.blued.android.chat.data.ProfileData;
import com.blued.android.chat.data.SessionHeader;
import com.blued.android.chat.listener.ChatTipsListener;
import com.blued.android.chat.listener.ConnectListener;
import com.blued.android.chat.listener.LiveChatCreateListener;
import com.blued.android.chat.listener.LiveChatEnterListener;
import com.blued.android.chat.listener.LiveChatInfoListener;
import com.blued.android.chat.listener.MsgPreProcesser;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionProfileModel;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.chat.utils.MsgPackHelper;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LiveChat extends BaseWorker implements ConnectListener {
  public static final int LIVE_GAME = 1;
  
  public static final int LIVE_GUY_MIRROR = 1;
  
  public static final int LIVE_NORMAL = 0;
  
  public static final int LIVE_NO_MIRROR = 0;
  
  public static final int LIVE_PRIVATE = 2;
  
  public static final int LIVE_VOICE = 3;
  
  public static final int MAX_VIEWER_LIST_SIZE = 50;
  
  public static final int MIN_VIEWER_LIST_SIZE = 20;
  
  private static final String TAG = "Chat_LiveChat";
  
  Chat chat;
  
  Connector connector;
  
  private LiveChatInfo liveChatInfo = null;
  
  private final Map<String, Set<LiveChatInfoListener>> liveChatInfoListenerMap = (Map<String, Set<LiveChatInfoListener>>)new ArrayMap();
  
  private long liveChatStartLocalId = 0L;
  
  private BasePackage liveChatStartPackage = null;
  
  PackSendHelper packSendHelper;
  
  private Object sessionLock = new Object();
  
  private boolean useHttp = false;
  
  public LiveChat(Connector paramConnector, Chat paramChat) {
    if (ChatManager.debug)
      Log.v("Chat_LiveChat", "LiveChat() create"); 
    this.chat = paramChat;
    this.connector = paramConnector;
    this.packSendHelper = paramConnector.getPackageSendHelper();
    paramChat.liveChat = this;
    this.connector.registerConnectListener(this);
  }
  
  private void createLiveChatFailed(long paramLong, int paramInt, String paramString, LiveChatCreateListener paramLiveChatCreateListener) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("createLiveChatFailed(), localId:");
      stringBuilder.append(paramLong);
      stringBuilder.append(", liveChatStartLocalId:");
      stringBuilder.append(this.liveChatStartLocalId);
      stringBuilder.append(", liveChatCreateListener:");
      stringBuilder.append(paramLiveChatCreateListener);
      Log.v("Chat_LiveChat", stringBuilder.toString());
    } 
    if (this.liveChatStartLocalId != paramLong)
      return; 
    if (paramLiveChatCreateListener != null) {
      if (paramInt == 2) {
        paramLiveChatCreateListener.onCreateFailed(LiveCreateFailedReason.FORBIDDEN_LIVE, paramString);
        return;
      } 
      if (paramInt == 1) {
        paramLiveChatCreateListener.onCreateFailed(LiveCreateFailedReason.NO_AUTHORITY_LIVE, paramString);
        return;
      } 
      if (paramInt == 7) {
        paramLiveChatCreateListener.onCreateFailed(LiveCreateFailedReason.DESCRIPTION_INVALID, paramString);
        return;
      } 
      paramLiveChatCreateListener.onCreateFailed(LiveCreateFailedReason.UNKNOWN, paramString);
    } 
  }
  
  private void createLiveChatSuccess(long paramLong, Map<String, Object> paramMap, LiveChatCreateListener paramLiveChatCreateListener) {
    short s = MsgPackHelper.getShortValue(paramMap, "session_type");
    long l = MsgPackHelper.getLongValue(paramMap, "session_id");
    if (this.liveChatStartLocalId != paramLong) {
      closeLiveChat(s, l);
      return;
    } 
    LiveChatInitData liveChatInitData = new LiveChatInitData();
    liveChatInitData.sessionType = s;
    liveChatInitData.sessionId = l;
    liveChatInitData.streamUrl = MsgPackHelper.getStringValue(paramMap, "live_info");
    liveChatInitData.publish_url = MsgPackHelper.getStringValue(paramMap, "publish_url");
    liveChatInitData.liveUrl = MsgPackHelper.getStringValue(paramMap, "live_url");
    liveChatInitData.topCardCount = MsgPackHelper.getLongValue(paramMap, "top_card_count");
    liveChatInitData.topCardUrl = MsgPackHelper.getStringValue(paramMap, "top_card_url");
    liveChatInitData.rank = MsgPackHelper.getLongValue(paramMap, "rank");
    liveChatInitData.beansCount = MsgPackHelper.getDoubleValue(paramMap, "beans_count");
    liveChatInitData.beansCurrentCount = MsgPackHelper.getDoubleValue(paramMap, "beans_current_count");
    liveChatInitData.badges = LiveChatInitData.parseBadgeMap(MsgPackHelper.getListValue(paramMap, "badges"));
    liveChatInitData.icon = MsgPackHelper.getStringValue(paramMap, "icon");
    liveChatInitData.liveType = MsgPackHelper.getIntValue(paramMap, "live_type");
    liveChatInitData.liveDescription = MsgPackHelper.getStringValue(paramMap, "description");
    liveChatInitData.joinLiveConferenceId = MsgPackHelper.getStringValue(paramMap, "conference_id");
    liveChatInitData.joinLiveToken = MsgPackHelper.getStringValue(paramMap, "token");
    liveChatInitData.live_quic = MsgPackHelper.getIntValue(paramMap, "live_quic");
    paramMap = MsgPackHelper.getMapValue(paramMap, "extra");
    liveChatInitData.liverProfile = new ProfileData();
    liveChatInitData.liverProfile.uid = ChatManager.getInstance().getUid();
    BasePackage basePackage = this.liveChatStartPackage;
    if (basePackage != null && basePackage instanceof ReqCreateLiveChatPackage)
      liveChatInitData.screenPattern = ((ReqCreateLiveChatPackage)basePackage).screenPattern; 
    this.liveChatInfo = new LiveChatInfo(s, l);
    if (paramLiveChatCreateListener != null) {
      paramLiveChatCreateListener.onCreateSuccess(s, l, liveChatInitData, paramMap);
      return;
    } 
    closeLiveChat(s, l);
  }
  
  private void destroy() {
    Connector connector = this.connector;
    if (connector != null)
      connector.unregisterConnectListener(this); 
    Chat chat = this.chat;
    if (chat != null) {
      chat.liveChat = null;
      chat.videoChat = null;
    } 
  }
  
  private void enterLiveChatFailed(long paramLong, int paramInt, Map<String, Object> paramMap, LiveChatEnterListener paramLiveChatEnterListener) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("createLiveChatFailed(), localId:");
      stringBuilder.append(paramLong);
      stringBuilder.append(", liveChatStartLocalId:");
      stringBuilder.append(this.liveChatStartLocalId);
      stringBuilder.append(", liveChatEnterListener:");
      stringBuilder.append(paramLiveChatEnterListener);
      Log.v("Chat_LiveChat", stringBuilder.toString());
    } 
    if (this.liveChatStartLocalId != paramLong)
      return; 
    if (paramLiveChatEnterListener != null) {
      if (paramInt == 3) {
        paramLiveChatEnterListener.onEnterFailed(LiveEnterFailedReason.BLOCKED_BY_PEER, null);
        return;
      } 
      if (paramInt == 4) {
        paramLiveChatEnterListener.onEnterFailed(LiveEnterFailedReason.BLOCK_PEER, null);
        return;
      } 
      if (paramInt == 5) {
        paramLiveChatEnterListener.onEnterFailed(LiveEnterFailedReason.LIVEROOM_FULL, null);
        return;
      } 
      if (paramInt == 6) {
        paramLiveChatEnterListener.onEnterFailed(LiveEnterFailedReason.LIVEROOM_CLOSE, LiveChatStatistics.parseData(paramMap));
        return;
      } 
      if (paramInt == 18) {
        paramLiveChatEnterListener.onEnterFailed(LiveEnterFailedReason.LIVEROOM_KICKED_OUT, LiveChatStatistics.parseData(paramMap));
        return;
      } 
      paramLiveChatEnterListener.onEnterFailed(LiveEnterFailedReason.UNKNOWN, null);
    } 
  }
  
  private void enterLiveChatSuccess(long paramLong, Map<String, Object> paramMap, LiveChatEnterListener paramLiveChatEnterListener) {
    StringBuilder stringBuilder;
    short s = MsgPackHelper.getShortValue(paramMap, "session_type");
    long l = MsgPackHelper.getLongValue(paramMap, "session_id");
    if (this.liveChatStartLocalId != paramLong) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("enterLivechat localId not match, ");
      stringBuilder.append(this.liveChatStartLocalId);
      stringBuilder.append("-");
      stringBuilder.append(paramLong);
      stringBuilder.append(", so leave live");
      Log.v("Chat_LiveChat", stringBuilder.toString());
      leaveLiveChat(s, l, "");
      return;
    } 
    LiveChatInitData liveChatInitData = new LiveChatInitData();
    liveChatInitData.sessionType = s;
    liveChatInitData.sessionId = l;
    liveChatInitData.streamUrl = MsgPackHelper.getStringValue((Map)stringBuilder, "live_url");
    liveChatInitData.liveUrl = MsgPackHelper.getStringValue((Map)stringBuilder, "live_url");
    liveChatInitData.elapseTimeSec = MsgPackHelper.getLongValue((Map)stringBuilder, "elapse_time");
    liveChatInitData.topCardCount = MsgPackHelper.getLongValue((Map)stringBuilder, "top_card_count");
    liveChatInitData.topCardUrl = MsgPackHelper.getStringValue((Map)stringBuilder, "top_card_url");
    liveChatInitData.rank = MsgPackHelper.getLongValue((Map)stringBuilder, "rank");
    liveChatInitData.beansCount = MsgPackHelper.getDoubleValue((Map)stringBuilder, "beans_count");
    liveChatInitData.beansCurrentCount = MsgPackHelper.getDoubleValue((Map)stringBuilder, "beans_current_count");
    liveChatInitData.badges = LiveChatInitData.parseBadgeMap(MsgPackHelper.getListValue((Map)stringBuilder, "badges"));
    liveChatInitData.entranceData = EntranceData.parseEntranceData(MsgPackHelper.getMapValue((Map)stringBuilder, "effects"));
    liveChatInitData.bluedBadgePic = MsgPackHelper.getStringValue((Map)stringBuilder, "blued_badge_pic");
    liveChatInitData.privateFlag = MsgPackHelper.getIntValue((Map)stringBuilder, "is_private");
    liveChatInitData.icon = MsgPackHelper.getStringValue((Map)stringBuilder, "icon");
    liveChatInitData.liveType = MsgPackHelper.getIntValue((Map)stringBuilder, "live_type");
    liveChatInitData.liveDescription = MsgPackHelper.getStringValue((Map)stringBuilder, "description");
    liveChatInitData.admin_type = MsgPackHelper.getIntValue((Map)stringBuilder, "admin_type");
    Map map1 = MsgPackHelper.getMapValue((Map)stringBuilder, "extra");
    Map map2 = MsgPackHelper.getMapValue((Map)stringBuilder, "profile");
    if (map2 != null) {
      liveChatInitData.liverProfile = new ProfileData();
      liveChatInitData.liverProfile.parseMsgPackData(map2);
    } 
    liveChatInitData.screenPattern = MsgPackHelper.getIntValue((Map)stringBuilder, "screen_pattern");
    this.liveChatInfo = new LiveChatInfo(s, l);
    if (paramLiveChatEnterListener != null) {
      paramLiveChatEnterListener.onEnterSuccess(s, l, liveChatInitData, map1);
      return;
    } 
    Log.v("Chat_LiveChat", "liveChatEnterListener is null, so leave live");
    leaveLiveChat(s, l, "");
  }
  
  private void notifyJoinLive(short paramShort, long paramLong, int paramInt, String paramString1, String paramString2, String paramString3) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("notifyJoinLive(), result:");
    stringBuilder.append(paramInt);
    Log.v("Chat_LiveChat", stringBuilder.toString());
    String str = SessionHeader.getSessionKey(paramShort, paramLong);
    synchronized (this.liveChatInfoListenerMap) {
      Set set = this.liveChatInfoListenerMap.get(str);
      if (set != null) {
        JoinLiveResult joinLiveResult;
        if (paramInt == 0) {
          joinLiveResult = JoinLiveResult.SUCCESS;
        } else if (paramInt == 8) {
          joinLiveResult = JoinLiveResult.FAILED_JOINLIVE_CLOSE;
        } else if (paramInt == 9) {
          joinLiveResult = JoinLiveResult.FAILED_JOINLIVE_FULL;
        } else if (paramInt == 10) {
          joinLiveResult = JoinLiveResult.FAILED_JOINLIVE_INVITE_OVERDUE;
        } else {
          joinLiveResult = JoinLiveResult.FAILED_UNKNOWN;
        } 
        Iterator<LiveChatInfoListener> iterator = set.iterator();
        while (iterator.hasNext())
          ((LiveChatInfoListener)iterator.next()).onJoinLive(joinLiveResult, paramString1, paramString2, paramString3); 
      } 
      return;
    } 
  }
  
  private void notifyLiveChatClose(short paramShort, long paramLong, LiveCloseReason paramLiveCloseReason, LiveChatStatistics paramLiveChatStatistics) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("notifyLiveChatClose(), reason:");
    stringBuilder.append(paramLiveCloseReason);
    Log.v("Chat_LiveChat", stringBuilder.toString());
    String str = SessionHeader.getSessionKey(paramShort, paramLong);
    synchronized (this.liveChatInfoListenerMap) {
      Set set = this.liveChatInfoListenerMap.get(str);
      if (set != null) {
        Iterator<LiveChatInfoListener> iterator = set.iterator();
        while (iterator.hasNext())
          ((LiveChatInfoListener)iterator.next()).onClose(paramLiveCloseReason, paramLiveChatStatistics); 
      } 
      synchronized (this.sessionLock) {
        if (this.liveChatInfo != null && this.liveChatInfo.equalSession(paramShort, paramLong))
          this.liveChatInfo = null; 
        return;
      } 
    } 
  }
  
  private void notifyRevNewMsg(ChattingModel paramChattingModel) {
    String str = SessionHeader.getSessionKey(paramChattingModel.sessionType, paramChattingModel.sessionId);
    synchronized (this.liveChatInfoListenerMap) {
      Set set = this.liveChatInfoListenerMap.get(str);
      if (set != null) {
        Iterator<LiveChatInfoListener> iterator = set.iterator();
        while (iterator.hasNext())
          ((LiveChatInfoListener)iterator.next()).onRecvNewMsg(paramChattingModel); 
      } 
      return;
    } 
  }
  
  private void notifyViewerEntrance(EntranceData paramEntranceData) {
    if (paramEntranceData != null) {
      String str = SessionHeader.getSessionKey(this.liveChatInfo.sessionType, this.liveChatInfo.sessionId);
      synchronized (this.liveChatInfoListenerMap) {
        Set set = this.liveChatInfoListenerMap.get(str);
        if (set != null && this.liveChatInfo != null) {
          Iterator<LiveChatInfoListener> iterator = set.iterator();
          while (iterator.hasNext())
            ((LiveChatInfoListener)iterator.next()).onViewerEntrance(paramEntranceData, this.liveChatInfo.viewerOnLineCount); 
        } 
        return;
      } 
    } 
  }
  
  private void notifyViewerListChanged(LiveChatInfo paramLiveChatInfo) {
    if (paramLiveChatInfo != null) {
      List<ProfileData> list = paramLiveChatInfo.getViewerList();
      String str = SessionHeader.getSessionKey(paramLiveChatInfo.sessionType, paramLiveChatInfo.sessionId);
      synchronized (this.liveChatInfoListenerMap) {
        Set set = this.liveChatInfoListenerMap.get(str);
        if (set != null) {
          Iterator<LiveChatInfoListener> iterator = set.iterator();
          while (iterator.hasNext())
            ((LiveChatInfoListener)iterator.next()).onViewerDataChanged(paramLiveChatInfo.viewerOnLineCount, list); 
        } 
        return;
      } 
    } 
  }
  
  public void applyJoinLive(short paramShort, long paramLong1, long paramLong2) {
    ReqApplyJoinLivePackage reqApplyJoinLivePackage = new ReqApplyJoinLivePackage(paramShort, paramLong1, ChatHelper.getLocalId(), paramLong2);
    this.packSendHelper.sendPackage((BasePackage)reqApplyJoinLivePackage, new PackSendHelper.PackCallback() {
          public void onAckTimeout(BasePackage param1BasePackage) {}
          
          public void onReceiveAck(BasePackage param1BasePackage1, BasePackage param1BasePackage2) {
            if (param1BasePackage2 instanceof ReqAckPackage)
              LiveChat.this.recvReqJoinLivePackage((ReqAckPackage)param1BasePackage2); 
          }
          
          public void onSendFailed(BasePackage param1BasePackage) {}
          
          public void onSendFinish(BasePackage param1BasePackage) {}
          
          public void onSendTimeout(BasePackage param1BasePackage) {}
        });
  }
  
  public void closeLiveChat(short paramShort, long paramLong) {
    closeLiveChat(paramShort, paramLong, 0);
  }
  
  public void closeLiveChat(short paramShort, long paramLong, int paramInt) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("closeLiveChat(), sessionType:");
      stringBuilder.append(paramShort);
      stringBuilder.append(", sessionId");
      Log.v("Chat_LiveChat", stringBuilder.toString());
    } 
    ReqCloseLiveChatPackage reqCloseLiveChatPackage = new ReqCloseLiveChatPackage(paramShort, paramLong, ChatHelper.getLocalId());
    reqCloseLiveChatPackage.setReason(paramInt);
    this.packSendHelper.sendPackage((BasePackage)reqCloseLiveChatPackage, new PackSendHelper.PackCallback() {
          public void onAckTimeout(BasePackage param1BasePackage) {
            LiveChat liveChat = LiveChat.this;
            ReqCloseLiveChatPackage reqCloseLiveChatPackage = (ReqCloseLiveChatPackage)param1BasePackage;
            liveChat.notifyLiveChatClose(reqCloseLiveChatPackage.sessionType, reqCloseLiveChatPackage.sessionId, LiveCloseReason.CLOSED_BY_SELF, null);
          }
          
          public void onReceiveAck(BasePackage param1BasePackage1, BasePackage param1BasePackage2) {
            if (param1BasePackage2 instanceof ReqAckPackage)
              LiveChat.this.recvReqCloseLiveChatPackage((ReqAckPackage)param1BasePackage2); 
          }
          
          public void onSendFailed(BasePackage param1BasePackage) {
            LiveChat liveChat = LiveChat.this;
            ReqCloseLiveChatPackage reqCloseLiveChatPackage = (ReqCloseLiveChatPackage)param1BasePackage;
            liveChat.notifyLiveChatClose(reqCloseLiveChatPackage.sessionType, reqCloseLiveChatPackage.sessionId, LiveCloseReason.CLOSED_BY_SELF, null);
          }
          
          public void onSendFinish(BasePackage param1BasePackage) {}
          
          public void onSendTimeout(BasePackage param1BasePackage) {
            LiveChat liveChat = LiveChat.this;
            ReqCloseLiveChatPackage reqCloseLiveChatPackage = (ReqCloseLiveChatPackage)param1BasePackage;
            liveChat.notifyLiveChatClose(reqCloseLiveChatPackage.sessionType, reqCloseLiveChatPackage.sessionId, LiveCloseReason.CLOSED_BY_SELF, null);
          }
        });
    synchronized (this.sessionLock) {
      if (this.liveChatInfo != null && this.liveChatInfo.equalSession(paramShort, paramLong))
        this.liveChatInfo = null; 
      return;
    } 
  }
  
  public void createLiveChat(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4, int paramInt5, final LiveChatCreateListener liveChatCreateListener) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("createLiveChat(), liveType:");
      stringBuilder.append(paramInt2);
      stringBuilder.append(", shareMirror:");
      stringBuilder.append(paramInt1);
      stringBuilder.append(", liveDescription:");
      stringBuilder.append(paramString1);
      stringBuilder.append(", liveCover:");
      stringBuilder.append(paramString2);
      stringBuilder.append(", screenPattern:");
      stringBuilder.append(paramInt3);
      stringBuilder.append(", showNearby:");
      stringBuilder.append(paramInt4);
      stringBuilder.append(", privateFlag:");
      stringBuilder.append(paramInt5);
      Log.v("Chat_LiveChat", stringBuilder.toString());
    } 
    this.liveChatStartLocalId = ChatHelper.getLocalId();
    this.liveChatStartPackage = (BasePackage)new ReqCreateLiveChatPackage(paramInt1, paramInt2, paramString1, paramString2, this.liveChatStartLocalId, paramInt3, paramInt4, paramInt5);
    this.packSendHelper.sendPackage(this.liveChatStartPackage, new PackSendHelper.PackCallback() {
          public void onAckTimeout(BasePackage param1BasePackage) {
            LiveChat.this.createLiveChatFailed(((ReqCreateLiveChatPackage)param1BasePackage).localId, -2, null, liveChatCreateListener);
          }
          
          public void onReceiveAck(BasePackage param1BasePackage1, BasePackage param1BasePackage2) {
            if (param1BasePackage2 instanceof ReqAckPackage)
              LiveChat.this.recvReqCreateLiveChatPackage((ReqAckPackage)param1BasePackage2, liveChatCreateListener); 
          }
          
          public void onSendFailed(BasePackage param1BasePackage) {
            LiveChat.this.createLiveChatFailed(((ReqCreateLiveChatPackage)param1BasePackage).localId, -1, null, liveChatCreateListener);
          }
          
          public void onSendFinish(BasePackage param1BasePackage) {}
          
          public void onSendTimeout(BasePackage param1BasePackage) {
            LiveChat.this.createLiveChatFailed(((ReqCreateLiveChatPackage)param1BasePackage).localId, -2, null, liveChatCreateListener);
          }
        });
  }
  
  public void enterLiveChat(short paramShort, long paramLong, String paramString, final LiveChatEnterListener listener) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("enterLiveChat(), sessionType:");
      stringBuilder.append(paramShort);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(paramLong);
      Log.v("Chat_LiveChat", stringBuilder.toString());
    } 
    this.liveChatStartLocalId = ChatHelper.getLocalId();
    this.liveChatStartPackage = (BasePackage)new ReqEnterLiveChatPackage(paramShort, paramLong, paramString, this.liveChatStartLocalId);
    this.packSendHelper.sendPackage(this.liveChatStartPackage, new PackSendHelper.PackCallback() {
          public void onAckTimeout(BasePackage param1BasePackage) {
            LiveChat.this.enterLiveChatFailed(((ReqEnterLiveChatPackage)param1BasePackage).localId, -2, null, listener);
          }
          
          public void onReceiveAck(BasePackage param1BasePackage1, BasePackage param1BasePackage2) {
            if (param1BasePackage2 instanceof ReqAckPackage)
              LiveChat.this.recvReqEnterLiveChatPackage((ReqAckPackage)param1BasePackage2, listener); 
          }
          
          public void onSendFailed(BasePackage param1BasePackage) {
            LiveChat.this.enterLiveChatFailed(((ReqEnterLiveChatPackage)param1BasePackage).localId, -1, null, listener);
          }
          
          public void onSendFinish(BasePackage param1BasePackage) {}
          
          public void onSendTimeout(BasePackage param1BasePackage) {
            LiveChat.this.enterLiveChatFailed(((ReqEnterLiveChatPackage)param1BasePackage).localId, -2, null, listener);
          }
        });
  }
  
  public String getWorkerName() {
    return "LiveChat";
  }
  
  public void initLiveChatInfo(short paramShort, long paramLong, boolean paramBoolean) {
    this.liveChatInfo = new LiveChatInfo(paramShort, paramLong);
    this.useHttp = paramBoolean;
  }
  
  public void leaveLiveChat(short paramShort, long paramLong, String paramString) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("leaveLiveChat(), sessionType:");
      stringBuilder.append(paramShort);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(paramLong);
      Log.v("Chat_LiveChat", stringBuilder.toString());
    } 
    if (paramLong <= 0L)
      return; 
    ReqLeaveLiveChatPackage reqLeaveLiveChatPackage = new ReqLeaveLiveChatPackage(paramShort, paramLong, ChatHelper.getLocalId(), paramString);
    this.packSendHelper.sendPackage((BasePackage)reqLeaveLiveChatPackage, null);
    synchronized (this.sessionLock) {
      if (this.liveChatInfo != null && this.liveChatInfo.equalSession(paramShort, paramLong))
        this.liveChatInfo = null; 
      return;
    } 
  }
  
  public void notifyJoinLiveEnd(short paramShort, long paramLong1, long paramLong2, long paramLong3) {
    ReqNotifyLiveJoinEndPackage reqNotifyLiveJoinEndPackage = new ReqNotifyLiveJoinEndPackage(paramShort, paramLong1, paramLong2, paramLong3, ChatHelper.getLocalId());
    this.packSendHelper.sendPackage((BasePackage)reqNotifyLiveJoinEndPackage, null);
  }
  
  public void notifyJoinLiveStart(short paramShort, long paramLong1, long paramLong2, String paramString, long paramLong3) {
    ReqNotifyLiveJoinStartPackage reqNotifyLiveJoinStartPackage = new ReqNotifyLiveJoinStartPackage(paramShort, paramLong1, paramLong2, paramString, paramLong3, ChatHelper.getLocalId());
    this.packSendHelper.sendPackage((BasePackage)reqNotifyLiveJoinStartPackage, null);
  }
  
  public void onConnected() {
    synchronized (this.sessionLock) {
      if (this.liveChatInfo != null) {
        ReqRecoverLiveChatPackage reqRecoverLiveChatPackage = new ReqRecoverLiveChatPackage(this.liveChatInfo.sessionType, this.liveChatInfo.sessionId, ChatHelper.getLocalId());
        this.connector.sendPackage((BasePackage)reqRecoverLiveChatPackage);
      } 
      return;
    } 
  }
  
  public void onConnecting() {}
  
  public void onDisconnected() {}
  
  public void pauseLive(short paramShort, long paramLong) {
    ReqLiveChatStatusChangePackage reqLiveChatStatusChangePackage = new ReqLiveChatStatusChangePackage(paramShort, paramLong, 1, ChatHelper.getLocalId());
    this.packSendHelper.sendPackage((BasePackage)reqLiveChatStatusChangePackage, null);
  }
  
  protected void recvPushMsgPackage(PushMsgPackage paramPushMsgPackage) {
    // Byte code:
    //   0: aload_0
    //   1: getfield sessionLock : Ljava/lang/Object;
    //   4: astore #7
    //   6: aload #7
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield liveChatInfo : Lcom/blued/android/chat/core/worker/chat/LiveChatInfo;
    //   13: ifnull -> 695
    //   16: aload_0
    //   17: getfield liveChatInfo : Lcom/blued/android/chat/core/worker/chat/LiveChatInfo;
    //   20: aload_1
    //   21: getfield sessionType : S
    //   24: aload_1
    //   25: getfield sessionId : J
    //   28: invokevirtual equalSession : (SJ)Z
    //   31: ifne -> 37
    //   34: goto -> 695
    //   37: aload_1
    //   38: invokestatic toMsgData : (Lcom/blued/android/chat/core/pack/PushMsgPackage;)Lcom/blued/android/chat/model/ChattingModel;
    //   41: astore #5
    //   43: aload #5
    //   45: getfield msgType : S
    //   48: istore_2
    //   49: iconst_0
    //   50: istore_3
    //   51: iload_2
    //   52: bipush #29
    //   54: if_icmpne -> 98
    //   57: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   60: ifeq -> 72
    //   63: ldc 'Chat_LiveChat'
    //   65: ldc_w '收到消息－被主播关闭'
    //   68: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   71: pop
    //   72: aload_0
    //   73: aload_1
    //   74: getfield sessionType : S
    //   77: aload_1
    //   78: getfield sessionId : J
    //   81: getstatic com/blued/android/chat/data/LiveCloseReason.CLOSED_BY_LIVER : Lcom/blued/android/chat/data/LiveCloseReason;
    //   84: aload #5
    //   86: getfield msgMapExtra : Ljava/util/Map;
    //   89: invokestatic parseData : (Ljava/util/Map;)Lcom/blued/android/chat/data/LiveChatStatistics;
    //   92: invokespecial notifyLiveChatClose : (SJLcom/blued/android/chat/data/LiveCloseReason;Lcom/blued/android/chat/data/LiveChatStatistics;)V
    //   95: goto -> 932
    //   98: aload #5
    //   100: getfield msgType : S
    //   103: bipush #30
    //   105: if_icmpne -> 149
    //   108: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   111: ifeq -> 123
    //   114: ldc 'Chat_LiveChat'
    //   116: ldc_w '收到消息－被场控关闭'
    //   119: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   122: pop
    //   123: aload_0
    //   124: aload_1
    //   125: getfield sessionType : S
    //   128: aload_1
    //   129: getfield sessionId : J
    //   132: getstatic com/blued/android/chat/data/LiveCloseReason.CLOSED_BY_MANAGER : Lcom/blued/android/chat/data/LiveCloseReason;
    //   135: aload #5
    //   137: getfield msgMapExtra : Ljava/util/Map;
    //   140: invokestatic parseData : (Ljava/util/Map;)Lcom/blued/android/chat/data/LiveChatStatistics;
    //   143: invokespecial notifyLiveChatClose : (SJLcom/blued/android/chat/data/LiveCloseReason;Lcom/blued/android/chat/data/LiveChatStatistics;)V
    //   146: goto -> 932
    //   149: aload #5
    //   151: getfield msgType : S
    //   154: bipush #27
    //   156: if_icmpne -> 494
    //   159: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   162: ifeq -> 174
    //   165: ldc 'Chat_LiveChat'
    //   167: ldc_w '收到消息－进入直播间'
    //   170: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   173: pop
    //   174: new com/blued/android/chat/data/ProfileData
    //   177: dup
    //   178: invokespecial <init> : ()V
    //   181: astore_1
    //   182: aload_1
    //   183: aload #5
    //   185: getfield fromId : J
    //   188: putfield uid : J
    //   191: aload_1
    //   192: aload #5
    //   194: getfield fromNickName : Ljava/lang/String;
    //   197: putfield name : Ljava/lang/String;
    //   200: aload_1
    //   201: aload #5
    //   203: getfield fromAvatar : Ljava/lang/String;
    //   206: putfield avatar : Ljava/lang/String;
    //   209: aload_1
    //   210: aload #5
    //   212: getfield fromVBadge : I
    //   215: putfield vBadge : I
    //   218: aload_1
    //   219: aload #5
    //   221: getfield fromRichLevel : I
    //   224: putfield richLevel : I
    //   227: aload_1
    //   228: aload #5
    //   230: getfield fromVipAnnual : I
    //   233: putfield vipAnnual : I
    //   236: aload_1
    //   237: aload #5
    //   239: getfield fromVipExpLvl : I
    //   242: putfield vipExpLvl : I
    //   245: aload_1
    //   246: aload #5
    //   248: getfield fromVipGrade : I
    //   251: putfield vipGrade : I
    //   254: aload_1
    //   255: aload #5
    //   257: getfield fromHideVipLook : I
    //   260: putfield hideVipLook : I
    //   263: aload_1
    //   264: aload #5
    //   266: getfield ofromVipGrade : I
    //   269: putfield ovipGrade : I
    //   272: aload_1
    //   273: aload #5
    //   275: getfield ofromHideVipLook : I
    //   278: putfield ohideVipLook : I
    //   281: aload_1
    //   282: aload #5
    //   284: getfield oFromFaceStatus : I
    //   287: putfield oFaceStatus : I
    //   290: aload #5
    //   292: getfield fromLiveManager : I
    //   295: iconst_1
    //   296: if_icmpne -> 921
    //   299: iconst_1
    //   300: istore #4
    //   302: goto -> 305
    //   305: aload_1
    //   306: iload #4
    //   308: putfield isLiveManager : Z
    //   311: aload_1
    //   312: aload #5
    //   314: getfield avatarPendant : Ljava/lang/String;
    //   317: putfield avatarPendant : Ljava/lang/String;
    //   320: aload #5
    //   322: getfield msgMapExtra : Ljava/util/Map;
    //   325: astore #6
    //   327: aload #6
    //   329: ifnull -> 476
    //   332: aload_1
    //   333: aload #6
    //   335: ldc_w 'channel_type'
    //   338: invokestatic getIntValue : (Ljava/util/Map;Ljava/lang/String;)I
    //   341: putfield channelType : I
    //   344: aload #6
    //   346: ldc_w 'is_open_privilege'
    //   349: iconst_0
    //   350: invokestatic getIntValue : (Ljava/util/Map;Ljava/lang/String;I)I
    //   353: iconst_1
    //   354: if_icmpne -> 369
    //   357: aload_1
    //   358: aload #6
    //   360: ldc_w 'true_uid'
    //   363: invokestatic getLongValue : (Ljava/util/Map;Ljava/lang/String;)J
    //   366: putfield invisibleUid : J
    //   369: aload_1
    //   370: aload #6
    //   372: ldc_w 'liang_type'
    //   375: invokestatic getIntValue : (Ljava/util/Map;Ljava/lang/String;)I
    //   378: putfield liangType : I
    //   381: aload_1
    //   382: aload #6
    //   384: ldc_w 'liang_id'
    //   387: invokestatic getStringValue : (Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   390: putfield liangId : Ljava/lang/String;
    //   393: aload_0
    //   394: getfield liveChatInfo : Lcom/blued/android/chat/core/worker/chat/LiveChatInfo;
    //   397: aload #6
    //   399: ldc_w 'count'
    //   402: aload_0
    //   403: getfield liveChatInfo : Lcom/blued/android/chat/core/worker/chat/LiveChatInfo;
    //   406: getfield viewerTotalCount : J
    //   409: invokestatic getLongValue : (Ljava/util/Map;Ljava/lang/String;J)J
    //   412: putfield viewerTotalCount : J
    //   415: aload_0
    //   416: getfield liveChatInfo : Lcom/blued/android/chat/core/worker/chat/LiveChatInfo;
    //   419: aload #6
    //   421: ldc_w 'realtime_count'
    //   424: aload_0
    //   425: getfield liveChatInfo : Lcom/blued/android/chat/core/worker/chat/LiveChatInfo;
    //   428: getfield viewerOnLineCount : J
    //   431: invokestatic getLongValue : (Ljava/util/Map;Ljava/lang/String;J)J
    //   434: putfield viewerOnLineCount : J
    //   437: aload #6
    //   439: ldc_w 'effects'
    //   442: invokestatic getMapValue : (Ljava/util/Map;Ljava/lang/String;)Ljava/util/Map;
    //   445: invokestatic parseEntranceData : (Ljava/util/Map;)Lcom/blued/android/chat/data/EntranceData;
    //   448: astore #6
    //   450: aload #6
    //   452: ifnull -> 470
    //   455: aload #6
    //   457: aload_1
    //   458: putfield userData : Lcom/blued/android/chat/data/ProfileData;
    //   461: aload_0
    //   462: aload #6
    //   464: invokespecial notifyViewerEntrance : (Lcom/blued/android/chat/data/EntranceData;)V
    //   467: goto -> 476
    //   470: aload_0
    //   471: aload #5
    //   473: invokespecial notifyRevNewMsg : (Lcom/blued/android/chat/model/ChattingModel;)V
    //   476: aload_0
    //   477: getfield useHttp : Z
    //   480: ifne -> 932
    //   483: aload_0
    //   484: getfield liveChatInfo : Lcom/blued/android/chat/core/worker/chat/LiveChatInfo;
    //   487: aload_1
    //   488: invokevirtual addProfileData : (Lcom/blued/android/chat/data/ProfileData;)V
    //   491: goto -> 927
    //   494: aload #5
    //   496: getfield msgType : S
    //   499: bipush #28
    //   501: if_icmpne -> 589
    //   504: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   507: ifeq -> 519
    //   510: ldc 'Chat_LiveChat'
    //   512: ldc_w '收到消息－离开直播间'
    //   515: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   518: pop
    //   519: aload #5
    //   521: getfield msgMapExtra : Ljava/util/Map;
    //   524: astore_1
    //   525: aload_1
    //   526: ifnull -> 557
    //   529: aload_0
    //   530: getfield liveChatInfo : Lcom/blued/android/chat/core/worker/chat/LiveChatInfo;
    //   533: aload_1
    //   534: ldc_w 'count'
    //   537: invokestatic getLongValue : (Ljava/util/Map;Ljava/lang/String;)J
    //   540: putfield viewerTotalCount : J
    //   543: aload_0
    //   544: getfield liveChatInfo : Lcom/blued/android/chat/core/worker/chat/LiveChatInfo;
    //   547: aload_1
    //   548: ldc_w 'realtime_count'
    //   551: invokestatic getLongValue : (Ljava/util/Map;Ljava/lang/String;)J
    //   554: putfield viewerOnLineCount : J
    //   557: aload_0
    //   558: getfield useHttp : Z
    //   561: ifne -> 580
    //   564: aload_0
    //   565: getfield liveChatInfo : Lcom/blued/android/chat/core/worker/chat/LiveChatInfo;
    //   568: aload #5
    //   570: getfield fromId : J
    //   573: invokevirtual removeProfileData : (J)Z
    //   576: pop
    //   577: goto -> 927
    //   580: aload_0
    //   581: aload #5
    //   583: invokespecial notifyRevNewMsg : (Lcom/blued/android/chat/model/ChattingModel;)V
    //   586: goto -> 932
    //   589: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   592: ifeq -> 604
    //   595: ldc 'Chat_LiveChat'
    //   597: ldc_w 'receive an new message, notify to business'
    //   600: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   603: pop
    //   604: aload_0
    //   605: aload #5
    //   607: invokespecial notifyRevNewMsg : (Lcom/blued/android/chat/model/ChattingModel;)V
    //   610: goto -> 932
    //   613: iload_2
    //   614: ifeq -> 691
    //   617: aload_0
    //   618: aload_0
    //   619: getfield liveChatInfo : Lcom/blued/android/chat/core/worker/chat/LiveChatInfo;
    //   622: invokespecial notifyViewerListChanged : (Lcom/blued/android/chat/core/worker/chat/LiveChatInfo;)V
    //   625: aload_0
    //   626: getfield liveChatInfo : Lcom/blued/android/chat/core/worker/chat/LiveChatInfo;
    //   629: getfield viewerProfileList : Ljava/util/List;
    //   632: ifnonnull -> 640
    //   635: iload_3
    //   636: istore_2
    //   637: goto -> 653
    //   640: aload_0
    //   641: getfield liveChatInfo : Lcom/blued/android/chat/core/worker/chat/LiveChatInfo;
    //   644: getfield viewerProfileList : Ljava/util/List;
    //   647: invokeinterface size : ()I
    //   652: istore_2
    //   653: iload_2
    //   654: i2l
    //   655: aload_0
    //   656: getfield liveChatInfo : Lcom/blued/android/chat/core/worker/chat/LiveChatInfo;
    //   659: getfield viewerOnLineCount : J
    //   662: lcmp
    //   663: ifge -> 691
    //   666: iload_2
    //   667: bipush #20
    //   669: if_icmpgt -> 691
    //   672: aload_0
    //   673: aload_0
    //   674: getfield liveChatInfo : Lcom/blued/android/chat/core/worker/chat/LiveChatInfo;
    //   677: getfield sessionType : S
    //   680: aload_0
    //   681: getfield liveChatInfo : Lcom/blued/android/chat/core/worker/chat/LiveChatInfo;
    //   684: getfield sessionId : J
    //   687: iconst_1
    //   688: invokevirtual updateLiveChatInfo : (SJI)V
    //   691: aload #7
    //   693: monitorexit
    //   694: return
    //   695: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   698: ifeq -> 911
    //   701: new java/lang/StringBuilder
    //   704: dup
    //   705: invokespecial <init> : ()V
    //   708: astore #5
    //   710: aload #5
    //   712: ldc_w 'can't match current liveChat, drop it, msgId:'
    //   715: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: pop
    //   719: aload #5
    //   721: aload_1
    //   722: getfield msgId : J
    //   725: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   728: pop
    //   729: aload #5
    //   731: invokevirtual toString : ()Ljava/lang/String;
    //   734: astore #6
    //   736: aload_0
    //   737: getfield liveChatInfo : Lcom/blued/android/chat/core/worker/chat/LiveChatInfo;
    //   740: ifnonnull -> 775
    //   743: new java/lang/StringBuilder
    //   746: dup
    //   747: invokespecial <init> : ()V
    //   750: astore_1
    //   751: aload_1
    //   752: aload #6
    //   754: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: pop
    //   758: aload_1
    //   759: ldc_w ', liveChatInfo is null'
    //   762: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: pop
    //   766: aload_1
    //   767: invokevirtual toString : ()Ljava/lang/String;
    //   770: astore #5
    //   772: goto -> 903
    //   775: aload #6
    //   777: astore #5
    //   779: aload_0
    //   780: getfield liveChatInfo : Lcom/blued/android/chat/core/worker/chat/LiveChatInfo;
    //   783: aload_1
    //   784: getfield sessionType : S
    //   787: aload_1
    //   788: getfield sessionId : J
    //   791: invokevirtual equalSession : (SJ)Z
    //   794: ifne -> 903
    //   797: new java/lang/StringBuilder
    //   800: dup
    //   801: invokespecial <init> : ()V
    //   804: astore #5
    //   806: aload #5
    //   808: aload #6
    //   810: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   813: pop
    //   814: aload #5
    //   816: ldc_w ', sessionType or sessionId not equal, current:'
    //   819: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: pop
    //   823: aload #5
    //   825: aload_0
    //   826: getfield liveChatInfo : Lcom/blued/android/chat/core/worker/chat/LiveChatInfo;
    //   829: getfield sessionType : S
    //   832: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   835: pop
    //   836: aload #5
    //   838: ldc_w '-'
    //   841: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   844: pop
    //   845: aload #5
    //   847: aload_0
    //   848: getfield liveChatInfo : Lcom/blued/android/chat/core/worker/chat/LiveChatInfo;
    //   851: getfield sessionId : J
    //   854: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   857: pop
    //   858: aload #5
    //   860: ldc_w ', message:'
    //   863: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: pop
    //   867: aload #5
    //   869: aload_1
    //   870: getfield sessionType : S
    //   873: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   876: pop
    //   877: aload #5
    //   879: ldc_w '-'
    //   882: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   885: pop
    //   886: aload #5
    //   888: aload_1
    //   889: getfield sessionId : J
    //   892: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   895: pop
    //   896: aload #5
    //   898: invokevirtual toString : ()Ljava/lang/String;
    //   901: astore #5
    //   903: ldc 'Chat_LiveChat'
    //   905: aload #5
    //   907: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   910: pop
    //   911: aload #7
    //   913: monitorexit
    //   914: return
    //   915: astore_1
    //   916: aload #7
    //   918: monitorexit
    //   919: aload_1
    //   920: athrow
    //   921: iconst_0
    //   922: istore #4
    //   924: goto -> 305
    //   927: iconst_1
    //   928: istore_2
    //   929: goto -> 613
    //   932: iconst_0
    //   933: istore_2
    //   934: goto -> 613
    // Exception table:
    //   from	to	target	type
    //   9	34	915	finally
    //   37	49	915	finally
    //   57	72	915	finally
    //   72	95	915	finally
    //   98	123	915	finally
    //   123	146	915	finally
    //   149	174	915	finally
    //   174	299	915	finally
    //   305	327	915	finally
    //   332	369	915	finally
    //   369	450	915	finally
    //   455	467	915	finally
    //   470	476	915	finally
    //   476	491	915	finally
    //   494	519	915	finally
    //   519	525	915	finally
    //   529	557	915	finally
    //   557	577	915	finally
    //   580	586	915	finally
    //   589	604	915	finally
    //   604	610	915	finally
    //   617	635	915	finally
    //   640	653	915	finally
    //   653	666	915	finally
    //   672	691	915	finally
    //   691	694	915	finally
    //   695	772	915	finally
    //   779	903	915	finally
    //   903	911	915	finally
    //   911	914	915	finally
    //   916	919	915	finally
  }
  
  protected void recvReqCloseLiveChatPackage(ReqAckPackage paramReqAckPackage) {
    if (ChatManager.debug)
      Log.v("Chat_LiveChat", "recvReqCloseLiveChatPackage()"); 
    if (paramReqAckPackage.result == 0) {
      short s = MsgPackHelper.getShortValue(paramReqAckPackage.reqResponse, "session_type");
      long l = MsgPackHelper.getLongValue(paramReqAckPackage.reqResponse, "session_id");
      LiveChatStatistics liveChatStatistics = LiveChatStatistics.parseData(paramReqAckPackage.reqResponse);
      notifyLiveChatClose(s, l, LiveCloseReason.CLOSED_BY_SELF, liveChatStatistics);
    } 
  }
  
  protected void recvReqCreateLiveChatPackage(ReqAckPackage paramReqAckPackage, LiveChatCreateListener paramLiveChatCreateListener) {
    if (ChatManager.debug)
      Log.v("Chat_LiveChat", "recvReqCreateLiveChatPackage()"); 
    if (paramReqAckPackage.result == 0) {
      if (paramReqAckPackage.error == 0) {
        createLiveChatSuccess(paramReqAckPackage.localId, paramReqAckPackage.reqResponse, paramLiveChatCreateListener);
        return;
      } 
      createLiveChatFailed(paramReqAckPackage.localId, paramReqAckPackage.error, paramReqAckPackage.errorContent, paramLiveChatCreateListener);
      return;
    } 
    createLiveChatFailed(paramReqAckPackage.localId, -1, null, paramLiveChatCreateListener);
  }
  
  protected void recvReqEnterLiveChatPackage(ReqAckPackage paramReqAckPackage, LiveChatEnterListener paramLiveChatEnterListener) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("recvReqEnterLiveChatPackage(), LiveChatEnterListener:");
      stringBuilder.append(paramLiveChatEnterListener);
      Log.v("Chat_LiveChat", stringBuilder.toString());
    } 
    if (paramReqAckPackage.result != 0) {
      enterLiveChatFailed(paramReqAckPackage.localId, -1, paramReqAckPackage.reqResponse, paramLiveChatEnterListener);
      return;
    } 
    if (paramReqAckPackage.error != 0) {
      enterLiveChatFailed(paramReqAckPackage.localId, paramReqAckPackage.error, paramReqAckPackage.reqResponse, paramLiveChatEnterListener);
      return;
    } 
    enterLiveChatSuccess(paramReqAckPackage.localId, paramReqAckPackage.reqResponse, paramLiveChatEnterListener);
  }
  
  protected void recvReqGetLiveChatInfoPackage(ReqAckPackage paramReqAckPackage) {
    if (ChatManager.debug)
      Log.v("Chat_LiveChat", "recvReqGetLiveChatInfoPackage()"); 
    if (paramReqAckPackage.result == 0 && paramReqAckPackage.error == 0) {
      short s = MsgPackHelper.getShortValue(paramReqAckPackage.reqResponse, "session_type");
      long l = MsgPackHelper.getLongValue(paramReqAckPackage.reqResponse, "session_id");
      synchronized (this.sessionLock) {
        if (this.liveChatInfo == null || !this.liveChatInfo.equalSession(s, l))
          return; 
        this.liveChatInfo.viewerTotalCount = MsgPackHelper.getLongValue(paramReqAckPackage.reqResponse, "count");
        this.liveChatInfo.viewerOnLineCount = MsgPackHelper.getLongValue(paramReqAckPackage.reqResponse, "realtime_count");
        this.liveChatInfo.viewerProfileList = ProfileData.parseProfileList(MsgPackHelper.getListValue(paramReqAckPackage.reqResponse, "profiles"));
        notifyViewerListChanged(this.liveChatInfo);
        return;
      } 
    } 
  }
  
  protected void recvReqJoinLivePackage(ReqAckPackage paramReqAckPackage) {
    String str1 = paramReqAckPackage.errorContent;
    short s = MsgPackHelper.getShortValue(paramReqAckPackage.reqResponse, "session_type");
    long l = MsgPackHelper.getLongValue(paramReqAckPackage.reqResponse, "session_id");
    String str2 = MsgPackHelper.getStringValue(paramReqAckPackage.reqResponse, "conference_id");
    String str3 = MsgPackHelper.getStringValue(paramReqAckPackage.reqResponse, "token");
    notifyJoinLive(s, l, paramReqAckPackage.error, str1, str2, str3);
  }
  
  protected void recvReqRecoverLiveChatPackage(ReqAckPackage paramReqAckPackage) {
    if (paramReqAckPackage.error == 6)
      notifyLiveChatClose(MsgPackHelper.getShortValue(paramReqAckPackage.reqResponse, "session_type"), MsgPackHelper.getLongValue(paramReqAckPackage.reqResponse, "session_id"), LiveCloseReason.CLOSED_BY_SELF, LiveChatStatistics.parseData(paramReqAckPackage.reqResponse)); 
  }
  
  protected void recvSendAckPackage(SendAckPackage paramSendAckPackage) {
    if (paramSendAckPackage.result != 0) {
      ChatTipsListener chatTipsListener = ChatManager.getInstance().getTipsListener();
      if (chatTipsListener != null) {
        LiveChatInfo liveChatInfo = this.liveChatInfo;
        if (liveChatInfo != null)
          chatTipsListener.onSendMsgFailed(liveChatInfo.sessionType, this.liveChatInfo.sessionId, paramSendAckPackage.result); 
      } 
    } 
  }
  
  public void registerLiveChatListener(short paramShort, long paramLong, LiveChatInfoListener paramLiveChatInfoListener) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("registerLiveChatListener(), sessionType:");
      stringBuilder.append(paramShort);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(paramLong);
      Log.v("Chat_LiveChat", stringBuilder.toString());
    } 
    String str = SessionHeader.getSessionKey(paramShort, paramLong);
    synchronized (this.liveChatInfoListenerMap) {
      Set<LiveChatInfoListener> set2 = this.liveChatInfoListenerMap.get(str);
      Set<LiveChatInfoListener> set1 = set2;
      if (set2 == null) {
        set1 = new HashSet();
        this.liveChatInfoListenerMap.put(str, set1);
      } 
      set1.add(paramLiveChatInfoListener);
      return;
    } 
  }
  
  public void resumeLive(short paramShort, long paramLong) {
    ReqLiveChatStatusChangePackage reqLiveChatStatusChangePackage = new ReqLiveChatStatusChangePackage(paramShort, paramLong, 0, ChatHelper.getLocalId());
    this.packSendHelper.sendPackage((BasePackage)reqLiveChatStatusChangePackage, null);
  }
  
  protected void sendMsg(ChattingModel paramChattingModel, SessionProfileModel paramSessionProfileModel) {
    sendMsg(paramChattingModel, paramSessionProfileModel, false, null);
  }
  
  protected void sendMsg(ChattingModel paramChattingModel, SessionProfileModel paramSessionProfileModel, boolean paramBoolean, MsgPreProcesser paramMsgPreProcesser) {
    if (ChatManager.debug)
      Log.v("Chat_LiveChat", "sendMsg()"); 
    paramChattingModel.msgStateCode = 1;
    if (!paramBoolean) {
      paramChattingModel.msgId = 0L;
      paramChattingModel.msgPreviousId = 0L;
      paramChattingModel.msgLocalId = ChatHelper.getLocalId();
      paramChattingModel.msgTimestamp = System.currentTimeMillis();
    } 
    synchronized (this.sessionLock) {
      if (this.liveChatInfo == null || !this.liveChatInfo.equalSession(paramChattingModel.sessionType, paramChattingModel.sessionId))
        return; 
      if (!paramBoolean && paramChattingModel.msgType != 31)
        notifyRevNewMsg(paramChattingModel); 
      if (paramChattingModel.msgType == 33)
        return; 
      SendMsgPackage sendMsgPackage = ChatHelper.getSendMsgPackageFromChattingModel(paramChattingModel);
      this.packSendHelper.sendPackage((BasePackage)sendMsgPackage, new PackSendHelper.PackCallback() {
            public void onAckTimeout(BasePackage param1BasePackage) {}
            
            public void onReceiveAck(BasePackage param1BasePackage1, BasePackage param1BasePackage2) {
              if (param1BasePackage2 instanceof SendAckPackage)
                LiveChat.this.recvSendAckPackage((SendAckPackage)param1BasePackage2); 
            }
            
            public void onSendFailed(BasePackage param1BasePackage) {}
            
            public void onSendFinish(BasePackage param1BasePackage) {}
            
            public void onSendTimeout(BasePackage param1BasePackage) {}
          });
      return;
    } 
  }
  
  protected void sendMsgPackageFailed(SendMsgPackage paramSendMsgPackage, int paramInt) {}
  
  protected void sendReqPackageFailed(ReqBasePackage paramReqBasePackage) {
    if (paramReqBasePackage instanceof ReqCreateLiveChatPackage) {
      createLiveChatFailed(((ReqCreateLiveChatPackage)paramReqBasePackage).localId, -1, null, null);
      return;
    } 
    if (paramReqBasePackage instanceof ReqEnterLiveChatPackage) {
      enterLiveChatFailed(((ReqEnterLiveChatPackage)paramReqBasePackage).localId, -1, null, null);
      return;
    } 
    if (paramReqBasePackage instanceof ReqCloseLiveChatPackage) {
      ReqCloseLiveChatPackage reqCloseLiveChatPackage = (ReqCloseLiveChatPackage)paramReqBasePackage;
      notifyLiveChatClose(reqCloseLiveChatPackage.sessionType, reqCloseLiveChatPackage.sessionId, LiveCloseReason.CLOSED_BY_SELF, null);
    } 
  }
  
  public void startJoinLive(short paramShort, long paramLong1, long paramLong2) {
    ReqStartJoinLive reqStartJoinLive = new ReqStartJoinLive(paramShort, paramLong1, paramLong2, ChatHelper.getLocalId());
    this.packSendHelper.sendPackage((BasePackage)reqStartJoinLive, null);
  }
  
  public void stopTalkSomebody(short paramShort, long paramLong1, long paramLong2, boolean paramBoolean) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void stopTalkSomebodyForever(short paramShort, long paramLong1, long paramLong2) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("stopTalkSomebody(), sessionType:");
      stringBuilder.append(paramShort);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(paramLong1);
      stringBuilder.append(", stopTalkUid:");
      stringBuilder.append(paramLong2);
      Log.v("Chat_LiveChat", stringBuilder.toString());
    } 
    ReqLiveChatStopTalkPackage reqLiveChatStopTalkPackage = new ReqLiveChatStopTalkPackage(paramShort, paramLong1, paramLong2, 2, ChatHelper.getLocalId());
    this.packSendHelper.sendPackage((BasePackage)reqLiveChatStopTalkPackage, null);
  }
  
  public void unregisterLiveChatListener(short paramShort, long paramLong, LiveChatInfoListener paramLiveChatInfoListener) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("unregisterLiveChatListener(), sessionType:");
      stringBuilder.append(paramShort);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(paramLong);
      Log.v("Chat_LiveChat", stringBuilder.toString());
    } 
    String str = SessionHeader.getSessionKey(paramShort, paramLong);
    synchronized (this.liveChatInfoListenerMap) {
      Set set = this.liveChatInfoListenerMap.get(str);
      if (set != null)
        set.remove(paramLiveChatInfoListener); 
      return;
    } 
  }
  
  public void updateLiveChatInfo(short paramShort, long paramLong) {
    updateLiveChatInfo(paramShort, paramLong, 0);
  }
  
  public void updateLiveChatInfo(short paramShort, long paramLong, int paramInt) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("updateLiveChatInfo(), sessionType:");
      stringBuilder.append(paramShort);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(paramLong);
      Log.v("Chat_LiveChat", stringBuilder.toString());
    } 
    if (this.useHttp)
      return; 
    ReqGetLiveChatInfoPackage reqGetLiveChatInfoPackage = new ReqGetLiveChatInfoPackage(paramShort, paramLong, paramInt, ChatHelper.getLocalId());
    this.packSendHelper.sendPackage((BasePackage)reqGetLiveChatInfoPackage, new PackSendHelper.PackCallback() {
          public void onAckTimeout(BasePackage param1BasePackage) {}
          
          public void onReceiveAck(BasePackage param1BasePackage1, BasePackage param1BasePackage2) {
            if (param1BasePackage2 instanceof ReqAckPackage)
              LiveChat.this.recvReqGetLiveChatInfoPackage((ReqAckPackage)param1BasePackage2); 
          }
          
          public void onSendFailed(BasePackage param1BasePackage) {}
          
          public void onSendFinish(BasePackage param1BasePackage) {}
          
          public void onSendTimeout(BasePackage param1BasePackage) {}
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\worker\chat\LiveChat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */