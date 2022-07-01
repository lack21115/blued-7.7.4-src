package com.blued.android.chat.core.worker.chat;

import com.blued.android.chat.ChatManager;
import com.blued.android.chat.FlashVideoHelper;
import com.blued.android.chat.core.pack.BasePackage;
import com.blued.android.chat.core.pack.PushMsgPackage;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.chat.core.pack.ReqCancelFlashVideoMatchPackage;
import com.blued.android.chat.core.pack.ReqCloseFlashVideoPackage;
import com.blued.android.chat.core.pack.ReqFlashVideoApplyExtraTimePackage;
import com.blued.android.chat.core.pack.ReqFlashVideoApplyFriend;
import com.blued.android.chat.core.pack.ReqFlashVideoEmoji;
import com.blued.android.chat.core.pack.ReqFlashVideoMatchAgreePackage;
import com.blued.android.chat.core.pack.ReqFlashVideoSayHi;
import com.blued.android.chat.core.pack.ReqStartFlashVideoMatchPackage;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.core.worker.Connector;
import com.blued.android.chat.core.worker.PackSendHelper;
import com.blued.android.chat.data.RelationProfileData;
import com.blued.android.chat.model.FlashVideoGiftModel;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.chat.utils.MsgPackHelper;
import java.util.List;
import java.util.Map;

public class FlashVideo {
  private static final String TAG = "Chat_FlashVideo";
  
  private final Chat chat;
  
  private final Connector connector;
  
  private IFlashVideoCallback flashVideoCallback;
  
  public FlashVideo(Connector paramConnector, Chat paramChat) {
    this.connector = paramConnector;
    this.chat = paramChat;
    this.chat.flashVideo = this;
  }
  
  private void reqFlashVideoFriendApply(ReqAckPackage paramReqAckPackage) {
    if (paramReqAckPackage == null)
      return; 
    if (paramReqAckPackage.result == 0 && paramReqAckPackage.error == 0) {
      Map map = MsgPackHelper.getMapValue(paramReqAckPackage.reqResponse, "extra");
      IFlashVideoCallback iFlashVideoCallback = this.flashVideoCallback;
      if (iFlashVideoCallback != null && map != null)
        iFlashVideoCallback.onApplyFriends(map); 
    } 
  }
  
  public void applyExtraTime(long paramLong, String paramString) {
    ReqFlashVideoApplyExtraTimePackage reqFlashVideoApplyExtraTimePackage = new ReqFlashVideoApplyExtraTimePackage(paramLong, paramString, ChatHelper.getLocalId());
    this.connector.getPackageSendHelper().sendPackage((BasePackage)reqFlashVideoApplyExtraTimePackage, null);
  }
  
  public void applyFriend(long paramLong, String paramString) {
    ReqFlashVideoApplyFriend reqFlashVideoApplyFriend = new ReqFlashVideoApplyFriend(paramLong, paramString, ChatHelper.getLocalId());
    this.connector.getPackageSendHelper().sendPackage((BasePackage)reqFlashVideoApplyFriend, new PackSendHelper.PackCallback() {
          public void onAckTimeout(BasePackage param1BasePackage) {}
          
          public void onReceiveAck(BasePackage param1BasePackage1, BasePackage param1BasePackage2) {
            if (param1BasePackage2 instanceof ReqAckPackage)
              FlashVideo.this.reqFlashVideoFriendApply((ReqAckPackage)param1BasePackage2); 
          }
          
          public void onSendFailed(BasePackage param1BasePackage) {}
          
          public void onSendFinish(BasePackage param1BasePackage) {}
          
          public void onSendTimeout(BasePackage param1BasePackage) {}
        });
  }
  
  public void attach(IFlashVideoCallback paramIFlashVideoCallback) {
    this.flashVideoCallback = paramIFlashVideoCallback;
  }
  
  public void cancelMatch() {
    ReqCancelFlashVideoMatchPackage reqCancelFlashVideoMatchPackage = new ReqCancelFlashVideoMatchPackage(ChatHelper.getLocalId());
    this.connector.getPackageSendHelper().sendPackage((BasePackage)reqCancelFlashVideoMatchPackage, null);
  }
  
  public void closeFlashVideo(long paramLong, String paramString, int paramInt) {
    ReqCloseFlashVideoPackage reqCloseFlashVideoPackage = new ReqCloseFlashVideoPackage(paramLong, paramString, paramInt, ChatHelper.getLocalId());
    this.connector.getPackageSendHelper().sendPackage((BasePackage)reqCloseFlashVideoPackage, null);
  }
  
  public void detach(IFlashVideoCallback paramIFlashVideoCallback) {
    if (this.flashVideoCallback == paramIFlashVideoCallback)
      this.flashVideoCallback = null; 
  }
  
  public void matchAgree(long paramLong, String paramString) {
    ReqFlashVideoMatchAgreePackage reqFlashVideoMatchAgreePackage = new ReqFlashVideoMatchAgreePackage(paramLong, paramString, ChatHelper.getLocalId());
    this.connector.getPackageSendHelper().sendPackage((BasePackage)reqFlashVideoMatchAgreePackage, null);
  }
  
  public void receiveFlashVideoApplyExtraTime(PushMsgPackage paramPushMsgPackage) {
    String str = MsgPackHelper.getStringValue(paramPushMsgPackage.msgMapExtra, "room_id");
    int i = MsgPackHelper.getIntValue(paramPushMsgPackage.msgMapExtra, "add_time");
    IFlashVideoCallback iFlashVideoCallback = this.flashVideoCallback;
    if (iFlashVideoCallback != null)
      iFlashVideoCallback.onReceiveApplyExtraTime(str, i); 
  }
  
  public void receiveFlashVideoClosePush(PushMsgPackage paramPushMsgPackage) {
    if (paramPushMsgPackage.msgMapExtra != null) {
      String str2 = MsgPackHelper.getStringValue(paramPushMsgPackage.msgMapExtra, "room_id");
      int i = MsgPackHelper.getIntValue(paramPushMsgPackage.msgMapExtra, "reason");
      String str1 = MsgPackHelper.getStringValue(paramPushMsgPackage.msgMapExtra, "msg");
      IFlashVideoCallback iFlashVideoCallback = this.flashVideoCallback;
      if (iFlashVideoCallback != null)
        iFlashVideoCallback.onChatClose(str2, i, str1); 
    } 
  }
  
  public void receiveFlashVideoEmoji(PushMsgPackage paramPushMsgPackage) {
    String str2 = MsgPackHelper.getStringValue(paramPushMsgPackage.msgMapExtra, "room_id");
    String str1 = MsgPackHelper.getStringValue(paramPushMsgPackage.msgMapExtra, "emoji_tag");
    IFlashVideoCallback iFlashVideoCallback = this.flashVideoCallback;
    if (iFlashVideoCallback != null)
      iFlashVideoCallback.onReceiveEmoji(str2, str1); 
  }
  
  public void receiveFlashVideoFriendApply(PushMsgPackage paramPushMsgPackage) {
    String str = MsgPackHelper.getStringValue(paramPushMsgPackage.msgMapExtra, "room_id");
    IFlashVideoCallback iFlashVideoCallback = this.flashVideoCallback;
    if (iFlashVideoCallback != null)
      iFlashVideoCallback.onApplyFriends(str); 
  }
  
  public void receiveFlashVideoFriendApplyAgree(PushMsgPackage paramPushMsgPackage) {
    String str = MsgPackHelper.getStringValue(paramPushMsgPackage.msgMapExtra, "room_id");
    IFlashVideoCallback iFlashVideoCallback = this.flashVideoCallback;
    if (iFlashVideoCallback != null)
      iFlashVideoCallback.onApplyFriendsAgree(str); 
  }
  
  public void receiveFlashVideoGift(PushMsgPackage paramPushMsgPackage) {
    FlashVideoGiftModel flashVideoGiftModel = FlashVideoGiftModel.parseData(paramPushMsgPackage.msgMapExtra);
    IFlashVideoCallback iFlashVideoCallback = this.flashVideoCallback;
    if (iFlashVideoCallback != null)
      iFlashVideoCallback.onReceiveGift(flashVideoGiftModel); 
  }
  
  public void receiveFlashVideoMatchAgree(PushMsgPackage paramPushMsgPackage) {
    String str = MsgPackHelper.getStringValue(paramPushMsgPackage.msgMapExtra, "room_id");
    IFlashVideoCallback iFlashVideoCallback = this.flashVideoCallback;
    if (iFlashVideoCallback != null)
      iFlashVideoCallback.onReceiveMatchAgree(str); 
  }
  
  public void receiveFlashVideoSayHi(PushMsgPackage paramPushMsgPackage) {
    String str = MsgPackHelper.getStringValue(paramPushMsgPackage.msgMapExtra, "room_id");
    IFlashVideoCallback iFlashVideoCallback = this.flashVideoCallback;
    if (iFlashVideoCallback != null)
      iFlashVideoCallback.onSayHi(str); 
  }
  
  public void receiveMatchedPush(PushMsgPackage paramPushMsgPackage) {
    if (paramPushMsgPackage.msgMapExtra != null) {
      RelationProfileData relationProfileData = null;
      Map map = MsgPackHelper.getMapValue(paramPushMsgPackage.msgMapExtra, "profile");
      if (map != null) {
        relationProfileData = new RelationProfileData();
        relationProfileData.parseMsgPackData(map);
      } 
      int i = MsgPackHelper.getIntValue(paramPushMsgPackage.msgMapExtra, "other_like");
      String str1 = MsgPackHelper.getStringValue(paramPushMsgPackage.msgMapExtra, "room_id");
      int j = MsgPackHelper.getIntValue(paramPushMsgPackage.msgMapExtra, "max_time");
      String str2 = MsgPackHelper.getStringValue(paramPushMsgPackage.msgMapExtra, "chat_tips");
      String str3 = MsgPackHelper.getStringValue(paramPushMsgPackage.msgMapExtra, "stream_id");
      String str4 = MsgPackHelper.getStringValue(paramPushMsgPackage.msgMapExtra, "rtmp_url");
      int k = MsgPackHelper.getIntValue(paramPushMsgPackage.msgMapExtra, "remain_num");
      IFlashVideoCallback iFlashVideoCallback = this.flashVideoCallback;
      if (iFlashVideoCallback != null)
        iFlashVideoCallback.onMatched(str1, relationProfileData, i, j, str2, str3, str4, k); 
    } 
  }
  
  public void sayHi(long paramLong, String paramString) {
    ReqFlashVideoSayHi reqFlashVideoSayHi = new ReqFlashVideoSayHi(paramLong, paramString, ChatHelper.getLocalId());
    this.connector.getPackageSendHelper().sendPackage((BasePackage)reqFlashVideoSayHi, null);
  }
  
  public void sendEmoji(long paramLong, String paramString1, String paramString2) {
    ReqFlashVideoEmoji reqFlashVideoEmoji = new ReqFlashVideoEmoji(paramLong, paramString1, ChatHelper.getLocalId(), paramString2);
    this.connector.getPackageSendHelper().sendPackage((BasePackage)reqFlashVideoEmoji, null);
  }
  
  public void startMatch() {
    ReqStartFlashVideoMatchPackage reqStartFlashVideoMatchPackage = new ReqStartFlashVideoMatchPackage(ChatHelper.getLocalId());
    this.connector.getPackageSendHelper().sendPackage((BasePackage)reqStartFlashVideoMatchPackage, new PackSendHelper.PackCallback() {
          public void onAckTimeout(BasePackage param1BasePackage) {
            if (ChatManager.debug)
              Log.e("Chat_FlashVideo", "匹配Ack等待超时"); 
            if (FlashVideo.this.flashVideoCallback != null)
              FlashVideo.this.flashVideoCallback.onMatchFailed(FlashVideoHelper.MatchFailed.NETWORK, null, 0); 
          }
          
          public void onReceiveAck(BasePackage param1BasePackage1, BasePackage param1BasePackage2) {
            if (param1BasePackage2 instanceof ReqAckPackage) {
              List<String> list;
              ReqAckPackage reqAckPackage = (ReqAckPackage)param1BasePackage2;
              String str = reqAckPackage.errorContent;
              int i = MsgPackHelper.getIntValue(reqAckPackage.reqResponse, "remain_num");
              if (reqAckPackage.error == 0) {
                str = MsgPackHelper.getStringValue(reqAckPackage.reqResponse, "contents");
                list = MsgPackHelper.getListValue(reqAckPackage.reqResponse, "tips");
                if (FlashVideo.this.flashVideoCallback != null) {
                  FlashVideo.this.flashVideoCallback.onMatchAck(str, list);
                  return;
                } 
              } else if (((ReqAckPackage)list).error == 13) {
                if (FlashVideo.this.flashVideoCallback != null) {
                  FlashVideo.this.flashVideoCallback.onMatchFailed(FlashVideoHelper.MatchFailed.FUNCTION_LOCK, str, i);
                  return;
                } 
              } else if (((ReqAckPackage)list).error == 14) {
                if (FlashVideo.this.flashVideoCallback != null) {
                  FlashVideo.this.flashVideoCallback.onMatchFailed(FlashVideoHelper.MatchFailed.FUNCTION_LOCK, str, i);
                  return;
                } 
              } else if (FlashVideo.this.flashVideoCallback != null) {
                FlashVideo.this.flashVideoCallback.onMatchFailed(FlashVideoHelper.MatchFailed.UNKNOWN, str, i);
              } 
            } 
          }
          
          public void onSendFailed(BasePackage param1BasePackage) {
            if (ChatManager.debug)
              Log.e("Chat_FlashVideo", "匹配包发送失败"); 
            if (FlashVideo.this.flashVideoCallback != null)
              FlashVideo.this.flashVideoCallback.onMatchFailed(FlashVideoHelper.MatchFailed.NETWORK, null, 0); 
          }
          
          public void onSendFinish(BasePackage param1BasePackage) {}
          
          public void onSendTimeout(BasePackage param1BasePackage) {
            if (ChatManager.debug)
              Log.e("Chat_FlashVideo", "匹配包发送超时"); 
            if (FlashVideo.this.flashVideoCallback != null)
              FlashVideo.this.flashVideoCallback.onMatchFailed(FlashVideoHelper.MatchFailed.NETWORK, null, 0); 
          }
        });
  }
  
  public static interface IFlashVideoCallback {
    void onApplyFriends(String param1String);
    
    void onApplyFriends(Map param1Map);
    
    void onApplyFriendsAgree(String param1String);
    
    void onChatClose(String param1String1, int param1Int, String param1String2);
    
    void onMatchAck(String param1String, List<String> param1List);
    
    void onMatchFailed(FlashVideoHelper.MatchFailed param1MatchFailed, String param1String, int param1Int);
    
    void onMatched(String param1String1, RelationProfileData param1RelationProfileData, int param1Int1, int param1Int2, String param1String2, String param1String3, String param1String4, int param1Int3);
    
    void onReceiveApplyExtraTime(String param1String, int param1Int);
    
    void onReceiveEmoji(String param1String1, String param1String2);
    
    void onReceiveGift(FlashVideoGiftModel param1FlashVideoGiftModel);
    
    void onReceiveMatchAgree(String param1String);
    
    void onSayHi(String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\worker\chat\FlashVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */