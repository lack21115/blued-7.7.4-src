package com.blued.android.chat.core.worker.chat;

import com.blued.android.chat.core.pack.BasePackage;
import com.blued.android.chat.core.pack.PushMsgPackage;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.chat.core.pack.ReqEmptyBodyPackage;
import com.blued.android.chat.core.pack.ReqWawajiCancelQueueUpPackage;
import com.blued.android.chat.core.pack.ReqWawajiEnterPackage;
import com.blued.android.chat.core.pack.ReqWawajiGetInfoPackage;
import com.blued.android.chat.core.pack.ReqWawajiLeavePackage;
import com.blued.android.chat.core.pack.ReqWawajiQueueUpPackage;
import com.blued.android.chat.core.pack.ReqWawajiRecoverPackage;
import com.blued.android.chat.core.worker.Connector;
import com.blued.android.chat.core.worker.PackSendHelper;
import com.blued.android.chat.data.ProfileData;
import com.blued.android.chat.listener.ConnectListener;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.chat.utils.MsgPackHelper;
import java.util.List;
import java.util.Map;

public class WawajiChat implements ConnectListener {
  private final Chat chat;
  
  private final Connector connector;
  
  private IWawajiChatCallback wawajiChatCallback;
  
  private IWawajiResultCallback wawajiResultCallback;
  
  public WawajiChat(Connector paramConnector, Chat paramChat) {
    this.connector = paramConnector;
    this.chat = paramChat;
    this.chat.wawajiChat = this;
    this.connector.registerConnectListener(this);
  }
  
  private void notifyCancelQueueUpFailed(long paramLong, String paramString) {
    IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
    if (iWawajiChatCallback != null)
      iWawajiChatCallback.onCancelQueueUpFailed(paramLong, paramString); 
  }
  
  private void notifyCancelQueueUpSuccess(long paramLong) {
    IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
    if (iWawajiChatCallback != null)
      iWawajiChatCallback.onCancelQueueUpSuccess(paramLong); 
  }
  
  private void notifyEnterRoomFailed(long paramLong, String paramString) {
    IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
    if (iWawajiChatCallback != null)
      iWawajiChatCallback.onEnterRoomFailed(paramLong, paramString); 
  }
  
  private void notifyEnterRoomSuccess(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString1, String paramString2, String paramString3, Map<String, Object> paramMap) {
    IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
    if (iWawajiChatCallback != null)
      iWawajiChatCallback.onEnterRoomSuccess(paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramString1, paramString2, paramString3, paramMap); 
  }
  
  private void notifyGetRoomInfoFailed(long paramLong, String paramString) {
    IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
    if (iWawajiChatCallback != null)
      iWawajiChatCallback.onGetInfoFailed(paramLong, paramString); 
  }
  
  private void notifyGetRoomInfoSuccess(long paramLong) {
    IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
    if (iWawajiChatCallback != null)
      iWawajiChatCallback.onGetInfoSuccess(paramLong); 
  }
  
  private void notifyLeaveRoomFailed(long paramLong, String paramString) {
    IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
    if (iWawajiChatCallback != null)
      iWawajiChatCallback.onLeaveRoomFailed(paramLong, paramString); 
  }
  
  private void notifyLeaveRoomSuccess(long paramLong) {
    IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
    if (iWawajiChatCallback != null)
      iWawajiChatCallback.onLeaveRoomSuccess(paramLong); 
  }
  
  private void notifyQueueUpFailed(long paramLong, String paramString) {
    IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
    if (iWawajiChatCallback != null)
      iWawajiChatCallback.onQueueUpFailed(paramLong, paramString); 
  }
  
  private void notifyQueueUpSuccess(long paramLong, int paramInt) {
    IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
    if (iWawajiChatCallback != null)
      iWawajiChatCallback.onQueueUpSuccess(paramLong, paramInt); 
  }
  
  private void notifyViewerIn(long paramLong, ProfileData paramProfileData, int paramInt) {
    IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
    if (iWawajiChatCallback != null)
      iWawajiChatCallback.onViewIn(paramLong, paramProfileData, paramInt); 
  }
  
  private void notifyViewerOut(long paramLong, ProfileData paramProfileData, int paramInt) {
    IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
    if (iWawajiChatCallback != null)
      iWawajiChatCallback.onViewOut(paramLong, paramProfileData, paramInt); 
  }
  
  private void recvGameResultUpdateMessage(PushMsgPackage paramPushMsgPackage) {
    int i = MsgPackHelper.getIntValue(paramPushMsgPackage.msgMapExtra, "result");
    ProfileData profileData = ProfileData.parseProfile(paramPushMsgPackage.msgMapExtra, "player");
    String str4 = MsgPackHelper.getStringValue(paramPushMsgPackage.msgMapExtra, "tips_player");
    String str1 = MsgPackHelper.getStringValue(paramPushMsgPackage.msgMapExtra, "tips_viewer");
    String str2 = MsgPackHelper.getStringValue(paramPushMsgPackage.msgMapExtra, "wawa_image");
    String str3 = MsgPackHelper.getStringValue(paramPushMsgPackage.msgMapExtra, "wawa_name");
    int j = MsgPackHelper.getIntValue(paramPushMsgPackage.msgMapExtra, "gift_bonus");
    IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
    if (iWawajiChatCallback != null)
      iWawajiChatCallback.onGameResultUpdate(paramPushMsgPackage.sessionId, i, profileData, str4, str1, str2, str3, j, paramPushMsgPackage.msgMapExtra); 
    IWawajiResultCallback iWawajiResultCallback = this.wawajiResultCallback;
    if (iWawajiResultCallback != null)
      iWawajiResultCallback.onGameResultReceive(paramPushMsgPackage.sessionId, i, profileData, str1, str2, str3); 
  }
  
  private void recvPlayQueueCountUpdateMessage(PushMsgPackage paramPushMsgPackage) {
    int i = MsgPackHelper.getIntValue(paramPushMsgPackage.msgMapExtra, "count");
    IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
    if (iWawajiChatCallback != null)
      iWawajiChatCallback.onQueueCountUpdate(paramPushMsgPackage.sessionId, i); 
  }
  
  private void recvPlayQueueRankUpdateMessage(PushMsgPackage paramPushMsgPackage) {
    int i = MsgPackHelper.getIntValue(paramPushMsgPackage.msgMapExtra, "rank", -1);
    IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
    if (iWawajiChatCallback != null)
      iWawajiChatCallback.onQueueRankUpdate(paramPushMsgPackage.sessionId, i); 
  }
  
  private void recvPlayingUpdateMessage(PushMsgPackage paramPushMsgPackage) {
    ProfileData profileData = ProfileData.parseProfile(paramPushMsgPackage.msgMapExtra, "player");
    IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
    if (iWawajiChatCallback != null)
      iWawajiChatCallback.onPlayerUpdate(paramPushMsgPackage.sessionId, profileData); 
  }
  
  private void recvViewerUpdateMessage(PushMsgPackage paramPushMsgPackage) {
    int i = MsgPackHelper.getIntValue(paramPushMsgPackage.msgMapExtra, "count");
    List<ProfileData> list = ProfileData.parseProfileList(MsgPackHelper.getListValue(paramPushMsgPackage.msgMapExtra, "members"));
    IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
    if (iWawajiChatCallback != null)
      iWawajiChatCallback.onViewerUpdate(paramPushMsgPackage.sessionId, i, list); 
  }
  
  public void attach(IWawajiChatCallback paramIWawajiChatCallback) {
    this.wawajiChatCallback = paramIWawajiChatCallback;
  }
  
  public void attachResultCallback(IWawajiResultCallback paramIWawajiResultCallback) {
    this.wawajiResultCallback = paramIWawajiResultCallback;
  }
  
  public void cancelQueueUp(final long sessionId) {
    ReqWawajiCancelQueueUpPackage reqWawajiCancelQueueUpPackage = new ReqWawajiCancelQueueUpPackage(sessionId, ChatHelper.getLocalId());
    this.connector.getPackageSendHelper().sendPackage((BasePackage)reqWawajiCancelQueueUpPackage, new PackSendHelper.PackCallback() {
          public void onAckTimeout(BasePackage param1BasePackage) {
            WawajiChat.this.notifyCancelQueueUpFailed(sessionId, "请求回应等待超时");
          }
          
          public void onReceiveAck(BasePackage param1BasePackage1, BasePackage param1BasePackage2) {
            if (param1BasePackage2 instanceof ReqAckPackage) {
              ReqAckPackage reqAckPackage = (ReqAckPackage)param1BasePackage2;
              if (reqAckPackage.error == 0) {
                WawajiChat.this.notifyCancelQueueUpSuccess(sessionId);
                return;
              } 
              WawajiChat wawajiChat = WawajiChat.this;
              long l = sessionId;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("请求失败, errorCode:");
              stringBuilder.append(reqAckPackage.error);
              wawajiChat.notifyCancelQueueUpFailed(l, stringBuilder.toString());
            } 
          }
          
          public void onSendFailed(BasePackage param1BasePackage) {
            WawajiChat.this.notifyCancelQueueUpFailed(sessionId, "请求发送失败");
          }
          
          public void onSendFinish(BasePackage param1BasePackage) {}
          
          public void onSendTimeout(BasePackage param1BasePackage) {
            WawajiChat.this.notifyCancelQueueUpFailed(sessionId, "请求发送超时");
          }
        });
  }
  
  public void detach(IWawajiChatCallback paramIWawajiChatCallback) {
    if (this.wawajiChatCallback == paramIWawajiChatCallback)
      this.wawajiChatCallback = null; 
  }
  
  public void detachResultCallback(IWawajiResultCallback paramIWawajiResultCallback) {
    if (this.wawajiResultCallback == paramIWawajiResultCallback)
      this.wawajiResultCallback = null; 
  }
  
  public void enterRoom(final long sessionId) {
    ReqWawajiEnterPackage reqWawajiEnterPackage = new ReqWawajiEnterPackage(sessionId, ChatHelper.getLocalId());
    this.connector.getPackageSendHelper().sendPackage((BasePackage)reqWawajiEnterPackage, new PackSendHelper.PackCallback() {
          public void onAckTimeout(BasePackage param1BasePackage) {
            WawajiChat.this.notifyEnterRoomFailed(sessionId, "请求发送回应等待超时");
          }
          
          public void onReceiveAck(BasePackage param1BasePackage1, BasePackage param1BasePackage2) {
            if (param1BasePackage2 instanceof ReqAckPackage) {
              Map map;
              ReqAckPackage reqAckPackage = (ReqAckPackage)param1BasePackage2;
              if (reqAckPackage.error == 0) {
                int i = MsgPackHelper.getIntValue(reqAckPackage.reqResponse, "price_android");
                int j = MsgPackHelper.getIntValue(reqAckPackage.reqResponse, "goods_id_android");
                int k = MsgPackHelper.getIntValue(reqAckPackage.reqResponse, "lifetime");
                int m = MsgPackHelper.getIntValue(reqAckPackage.reqResponse, "rank", -1);
                int n = MsgPackHelper.getIntValue(reqAckPackage.reqResponse, "queue_count");
                int i1 = MsgPackHelper.getIntValue(reqAckPackage.reqResponse, "beans_android");
                String str1 = MsgPackHelper.getStringValue(reqAckPackage.reqResponse, "room_id");
                String str2 = MsgPackHelper.getStringValue(reqAckPackage.reqResponse, "stream_id_1");
                String str3 = MsgPackHelper.getStringValue(reqAckPackage.reqResponse, "stream_id_2");
                map = MsgPackHelper.getMapValue(reqAckPackage.reqResponse, "extra");
                WawajiChat.this.notifyEnterRoomSuccess(sessionId, i, j, k, m, n, i1, str1, str2, str3, map);
                return;
              } 
              WawajiChat wawajiChat = WawajiChat.this;
              long l = sessionId;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("ack错误, 错误码:");
              stringBuilder.append(((ReqAckPackage)map).error);
              wawajiChat.notifyEnterRoomFailed(l, stringBuilder.toString());
            } 
          }
          
          public void onSendFailed(BasePackage param1BasePackage) {
            WawajiChat.this.notifyEnterRoomFailed(sessionId, "请求发送失败");
          }
          
          public void onSendFinish(BasePackage param1BasePackage) {}
          
          public void onSendTimeout(BasePackage param1BasePackage) {
            WawajiChat.this.notifyEnterRoomFailed(sessionId, "请求发送超时");
          }
        });
  }
  
  public void getRoomInfo(final long sessionId) {
    ReqWawajiGetInfoPackage reqWawajiGetInfoPackage = new ReqWawajiGetInfoPackage(sessionId, ChatHelper.getLocalId());
    this.connector.getPackageSendHelper().sendPackage((BasePackage)reqWawajiGetInfoPackage, new PackSendHelper.PackCallback() {
          public void onAckTimeout(BasePackage param1BasePackage) {
            WawajiChat.this.notifyGetRoomInfoFailed(sessionId, "请求回应等待超时");
          }
          
          public void onReceiveAck(BasePackage param1BasePackage1, BasePackage param1BasePackage2) {
            if (param1BasePackage2 instanceof ReqAckPackage) {
              ReqAckPackage reqAckPackage = (ReqAckPackage)param1BasePackage2;
              if (reqAckPackage.error == 0) {
                WawajiChat.this.notifyGetRoomInfoSuccess(sessionId);
                return;
              } 
              WawajiChat wawajiChat = WawajiChat.this;
              long l = sessionId;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("请求失败, errorCode:");
              stringBuilder.append(reqAckPackage.error);
              wawajiChat.notifyGetRoomInfoFailed(l, stringBuilder.toString());
            } 
          }
          
          public void onSendFailed(BasePackage param1BasePackage) {
            WawajiChat.this.notifyGetRoomInfoFailed(sessionId, "请求发送失败");
          }
          
          public void onSendFinish(BasePackage param1BasePackage) {}
          
          public void onSendTimeout(BasePackage param1BasePackage) {
            WawajiChat.this.notifyGetRoomInfoFailed(sessionId, "请求发送超时");
          }
        });
  }
  
  protected boolean handlePushMessage(PushMsgPackage paramPushMsgPackage) {
    if (paramPushMsgPackage.msgType == 84) {
      recvPlayQueueCountUpdateMessage(paramPushMsgPackage);
      return true;
    } 
    if (paramPushMsgPackage.msgType == 78) {
      recvPlayQueueRankUpdateMessage(paramPushMsgPackage);
      return true;
    } 
    if (paramPushMsgPackage.msgType == 79) {
      recvPlayingUpdateMessage(paramPushMsgPackage);
      return true;
    } 
    if (paramPushMsgPackage.msgType == 80) {
      recvViewerUpdateMessage(paramPushMsgPackage);
      return true;
    } 
    if (paramPushMsgPackage.msgType == 81) {
      recvGameResultUpdateMessage(paramPushMsgPackage);
      return true;
    } 
    if (paramPushMsgPackage.msgType == 82) {
      ProfileData profileData = ProfileData.parseProfile(paramPushMsgPackage.msgMapExtra, "viewer");
      int i = MsgPackHelper.getIntValue(paramPushMsgPackage.msgMapExtra, "count");
      notifyViewerIn(paramPushMsgPackage.sessionId, profileData, i);
      return true;
    } 
    if (paramPushMsgPackage.msgType == 83) {
      ProfileData profileData = ProfileData.parseProfile(paramPushMsgPackage.msgMapExtra, "viewer");
      int i = MsgPackHelper.getIntValue(paramPushMsgPackage.msgMapExtra, "count");
      notifyViewerOut(paramPushMsgPackage.sessionId, profileData, i);
      return true;
    } 
    return false;
  }
  
  public void leaveRoom(final long sessionId) {
    ReqWawajiLeavePackage reqWawajiLeavePackage = new ReqWawajiLeavePackage(sessionId, ChatHelper.getLocalId());
    this.connector.getPackageSendHelper().sendPackage((BasePackage)reqWawajiLeavePackage, new PackSendHelper.PackCallback() {
          public void onAckTimeout(BasePackage param1BasePackage) {
            WawajiChat.this.notifyLeaveRoomFailed(sessionId, "请求回应等待超时");
          }
          
          public void onReceiveAck(BasePackage param1BasePackage1, BasePackage param1BasePackage2) {
            if (param1BasePackage2 instanceof ReqAckPackage) {
              ReqAckPackage reqAckPackage = (ReqAckPackage)param1BasePackage2;
              if (reqAckPackage.error == 0) {
                WawajiChat.this.notifyLeaveRoomSuccess(sessionId);
                return;
              } 
              WawajiChat wawajiChat = WawajiChat.this;
              long l = sessionId;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("请求失败, errorCode:");
              stringBuilder.append(reqAckPackage.error);
              wawajiChat.notifyLeaveRoomFailed(l, stringBuilder.toString());
            } 
          }
          
          public void onSendFailed(BasePackage param1BasePackage) {
            WawajiChat.this.notifyLeaveRoomFailed(sessionId, "请求发送失败");
          }
          
          public void onSendFinish(BasePackage param1BasePackage) {}
          
          public void onSendTimeout(BasePackage param1BasePackage) {
            WawajiChat.this.notifyLeaveRoomFailed(sessionId, "请求发送超时");
          }
        });
  }
  
  public void onConnected() {
    IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
    if (iWawajiChatCallback != null)
      iWawajiChatCallback.onIMConnected(); 
  }
  
  public void onConnecting() {}
  
  public void onDisconnected() {}
  
  public void queueUp(final long sessionId) {
    ReqWawajiQueueUpPackage reqWawajiQueueUpPackage = new ReqWawajiQueueUpPackage(sessionId, ChatHelper.getLocalId());
    this.connector.getPackageSendHelper().sendPackage((BasePackage)reqWawajiQueueUpPackage, new PackSendHelper.PackCallback() {
          public void onAckTimeout(BasePackage param1BasePackage) {
            WawajiChat.this.notifyQueueUpFailed(sessionId, "请求回应接收超时");
          }
          
          public void onReceiveAck(BasePackage param1BasePackage1, BasePackage param1BasePackage2) {
            if (param1BasePackage2 instanceof ReqAckPackage) {
              ReqAckPackage reqAckPackage = (ReqAckPackage)param1BasePackage2;
              if (reqAckPackage.error == 0) {
                int i = MsgPackHelper.getIntValue(reqAckPackage.reqResponse, "rank", -1);
                WawajiChat.this.notifyQueueUpSuccess(sessionId, i);
                return;
              } 
              WawajiChat wawajiChat = WawajiChat.this;
              long l = sessionId;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("ack错误, 错误码:");
              stringBuilder.append(reqAckPackage.error);
              wawajiChat.notifyQueueUpFailed(l, stringBuilder.toString());
            } 
          }
          
          public void onSendFailed(BasePackage param1BasePackage) {
            WawajiChat.this.notifyQueueUpFailed(sessionId, "请求发送失败");
          }
          
          public void onSendFinish(BasePackage param1BasePackage) {}
          
          public void onSendTimeout(BasePackage param1BasePackage) {
            WawajiChat.this.notifyQueueUpFailed(sessionId, "请求发送超时");
          }
        });
  }
  
  public void recover(long paramLong) {
    ReqWawajiRecoverPackage reqWawajiRecoverPackage = new ReqWawajiRecoverPackage(paramLong, ChatHelper.getLocalId());
    this.connector.sendPackage((BasePackage)reqWawajiRecoverPackage);
  }
  
  public void startReceiveAllGameResult() {
    ReqEmptyBodyPackage reqEmptyBodyPackage = new ReqEmptyBodyPackage((short)33, ChatHelper.getLocalId());
    this.connector.sendPackage((BasePackage)reqEmptyBodyPackage);
  }
  
  public void stopReceiveAllGameResult() {
    ReqEmptyBodyPackage reqEmptyBodyPackage = new ReqEmptyBodyPackage((short)34, ChatHelper.getLocalId());
    this.connector.sendPackage((BasePackage)reqEmptyBodyPackage);
  }
  
  public static interface IWawajiChatCallback {
    void onCancelQueueUpFailed(long param1Long, String param1String);
    
    void onCancelQueueUpSuccess(long param1Long);
    
    void onEnterRoomFailed(long param1Long, String param1String);
    
    void onEnterRoomSuccess(long param1Long, int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5, int param1Int6, String param1String1, String param1String2, String param1String3, Map<String, Object> param1Map);
    
    void onGameResultUpdate(long param1Long, int param1Int1, ProfileData param1ProfileData, String param1String1, String param1String2, String param1String3, String param1String4, int param1Int2, Map<String, Object> param1Map);
    
    void onGetInfoFailed(long param1Long, String param1String);
    
    void onGetInfoSuccess(long param1Long);
    
    void onIMConnected();
    
    void onLeaveRoomFailed(long param1Long, String param1String);
    
    void onLeaveRoomSuccess(long param1Long);
    
    void onPlayerUpdate(long param1Long, ProfileData param1ProfileData);
    
    void onQueueCountUpdate(long param1Long, int param1Int);
    
    void onQueueRankUpdate(long param1Long, int param1Int);
    
    void onQueueUpFailed(long param1Long, String param1String);
    
    void onQueueUpSuccess(long param1Long, int param1Int);
    
    void onViewIn(long param1Long, ProfileData param1ProfileData, int param1Int);
    
    void onViewOut(long param1Long, ProfileData param1ProfileData, int param1Int);
    
    void onViewerUpdate(long param1Long, int param1Int, List<ProfileData> param1List);
  }
  
  public static interface IWawajiResultCallback {
    void onGameResultReceive(long param1Long, int param1Int, ProfileData param1ProfileData, String param1String1, String param1String2, String param1String3);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\worker\chat\WawajiChat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */