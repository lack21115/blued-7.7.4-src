package com.blued.android.chat.core.worker.chat;

import android.text.TextUtils;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.VideoChatHelper;
import com.blued.android.chat.core.pack.BasePackage;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.chat.core.pack.ReqCloseVideoChatPackage;
import com.blued.android.chat.core.pack.ReqCreateVideoChatPackage;
import com.blued.android.chat.core.pack.ReqUpdateCallTimePackage;
import com.blued.android.chat.core.pack.ReqVideoChatGetLeftTimePackage;
import com.blued.android.chat.core.pack.ReqVideoChatSwitchToAudioPackage;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.core.utils.TimeoutUtils;
import com.blued.android.chat.core.worker.Connector;
import com.blued.android.chat.listener.ChatTipsListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.VideoChatMsgContentModel;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.chat.utils.MsgPackHelper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class VideoChat {
  private static final String TAG = "Chat_VideoChat";
  
  private final Chat chat;
  
  private final Connector connector;
  
  private IVideoChatCallback videoChatCallback;
  
  public VideoChat(Connector paramConnector, Chat paramChat) {
    this.connector = paramConnector;
    this.chat = paramChat;
    this.chat.videoChat = this;
  }
  
  private void notifyBusyCalling(long paramLong) {
    ChatTipsListener chatTipsListener = ChatManager.getInstance().getTipsListener();
    if (chatTipsListener != null)
      chatTipsListener.onBusyCalling(paramLong); 
  }
  
  private void notifyTipsCalling(long paramLong, int paramInt) {
    ChatTipsListener chatTipsListener = ChatManager.getInstance().getTipsListener();
    if (chatTipsListener != null)
      chatTipsListener.onVideoCalling(paramLong, paramInt); 
  }
  
  private void notifyTipsCallingCancel(long paramLong, int paramInt) {
    ChatTipsListener chatTipsListener = ChatManager.getInstance().getTipsListener();
    if (chatTipsListener != null)
      chatTipsListener.onVideoCallingCancel(paramLong, paramInt); 
  }
  
  public void answer(long paramLong, String paramString, int paramInt) {
    notifyTipsCallingCancel(paramLong, paramInt);
    ReqVideoChatGetLeftTimePackage reqVideoChatGetLeftTimePackage = new ReqVideoChatGetLeftTimePackage(ChatHelper.getLocalId());
    reqVideoChatGetLeftTimePackage.invited_uid = paramLong;
    this.connector.sendPackage((BasePackage)reqVideoChatGetLeftTimePackage);
  }
  
  public void attach(IVideoChatCallback paramIVideoChatCallback) {
    this.videoChatCallback = paramIVideoChatCallback;
    long l = this.videoChatCallback.getCallUid();
    if (l != ChatManager.getInstance().getUid())
      notifyTipsCallingCancel(l, paramIVideoChatCallback.getRoomType()); 
  }
  
  public void call(long paramLong, String paramString, int paramInt1, int paramInt2) {
    ReqCreateVideoChatPackage reqCreateVideoChatPackage = new ReqCreateVideoChatPackage(paramLong, paramString, paramInt1, ChatHelper.getLocalId(), paramInt2);
    TimeoutUtils.addTimeoutPackage(reqCreateVideoChatPackage.localId, reqCreateVideoChatPackage, 30000L, this.chat);
    this.connector.sendPackage((BasePackage)reqCreateVideoChatPackage);
  }
  
  protected void callPackageFailed(ReqCreateVideoChatPackage paramReqCreateVideoChatPackage) {
    IVideoChatCallback iVideoChatCallback = this.videoChatCallback;
    if (iVideoChatCallback != null)
      iVideoChatCallback.onCallFailed(VideoChatHelper.CallFailed.NETWORK, null, -1); 
  }
  
  public void close(String paramString, int paramInt, long paramLong) {
    ReqCloseVideoChatPackage reqCloseVideoChatPackage = new ReqCloseVideoChatPackage(paramString, paramInt, paramLong, ChatHelper.getLocalId());
    this.connector.sendPackage((BasePackage)reqCloseVideoChatPackage);
    IVideoChatCallback iVideoChatCallback = this.videoChatCallback;
    if (iVideoChatCallback != null) {
      paramLong = iVideoChatCallback.getCallUid();
      if (paramLong != ChatManager.getInstance().getUid())
        notifyTipsCallingCancel(paramLong, this.videoChatCallback.getRoomType()); 
    } 
  }
  
  public void detach(IVideoChatCallback paramIVideoChatCallback) {
    if (this.videoChatCallback == paramIVideoChatCallback)
      this.videoChatCallback = null; 
  }
  
  public void getLeftTimeAndCount() {
    ReqVideoChatGetLeftTimePackage reqVideoChatGetLeftTimePackage = new ReqVideoChatGetLeftTimePackage(ChatHelper.getLocalId());
    this.connector.sendPackage((BasePackage)reqVideoChatGetLeftTimePackage);
  }
  
  public void getLeftTimePackageFailed() {
    IVideoChatCallback iVideoChatCallback = this.videoChatCallback;
    if (iVideoChatCallback != null)
      iVideoChatCallback.onGetLeftTimeFail(); 
  }
  
  protected boolean recvPushCallMessageAndNotifyOrNot(ChattingModel paramChattingModel) {
    IVideoChatCallback iVideoChatCallback1;
    boolean bool;
    IVideoChatCallback iVideoChatCallback2;
    String str1;
    if (ChatManager.debug) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("recvPushCallMessage(), pushMessage:");
      stringBuilder1.append(paramChattingModel);
      Log.v("Chat_VideoChat", stringBuilder1.toString());
    } 
    String str2 = null;
    try {
      VideoChatMsgContentModel videoChatMsgContentModel = (VideoChatMsgContentModel)(new Gson()).fromJson(paramChattingModel.msgContent, (new TypeToken<VideoChatMsgContentModel>() {
          
          }).getType());
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    if (exception != null) {
      bool = ((VideoChatMsgContentModel)exception).room_type;
    } else {
      bool = false;
    } 
    if (exception != null) {
      str1 = ((VideoChatMsgContentModel)exception).room_id;
    } else {
      str1 = null;
    } 
    IVideoChatCallback iVideoChatCallback3 = this.videoChatCallback;
    if (iVideoChatCallback3 != null)
      str2 = iVideoChatCallback3.getRoomId(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("currentRoomId:");
    stringBuilder.append(str2);
    stringBuilder.append(", pushRoomId:");
    stringBuilder.append(str1);
    Log.v("Chat_VideoChat", stringBuilder.toString());
    if (paramChattingModel.msgType == 52) {
      if (paramChattingModel.fromId != ChatManager.getInstance().getUid()) {
        if (str2 != null && !TextUtils.equals(str1, str2)) {
          if (ChatManager.debug) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("calling busy, current roomId:");
            stringBuilder1.append(this.videoChatCallback.getRoomId());
            stringBuilder1.append(", new roomId:");
            stringBuilder1.append(str1);
            Log.v("Chat_VideoChat", stringBuilder1.toString());
          } 
          close(str1, 6, 0L);
          notifyBusyCalling(paramChattingModel.fromId);
          return false;
        } 
        notifyTipsCalling(paramChattingModel.fromId, bool);
      } 
      iVideoChatCallback2 = this.videoChatCallback;
      if (iVideoChatCallback2 != null)
        iVideoChatCallback2.onReceiveCallingMsg(paramChattingModel.fromId); 
      return true;
    } 
    if (paramChattingModel.msgType == 53) {
      if (str2 != null && !TextUtils.equals(str2, str1))
        return false; 
      if (paramChattingModel.fromId != ChatManager.getInstance().getUid())
        notifyTipsCallingCancel(paramChattingModel.fromId, bool); 
      iVideoChatCallback1 = this.videoChatCallback;
      if (iVideoChatCallback1 != null) {
        if (iVideoChatCallback2 != null) {
          iVideoChatCallback1.onClose(((VideoChatMsgContentModel)iVideoChatCallback2).close_type);
          return false;
        } 
        iVideoChatCallback1.onClose(0);
        return false;
      } 
    } else if (((ChattingModel)iVideoChatCallback1).msgType == 54 && this.videoChatCallback != null && TextUtils.equals(str1, str2)) {
      this.videoChatCallback.onSwitchToAudio();
    } 
    return false;
  }
  
  protected void recvReqCreateVideoChatPackage(ReqAckPackage paramReqAckPackage) {
    IVideoChatCallback iVideoChatCallback;
    if (paramReqAckPackage.result == 0 && paramReqAckPackage.error == 0) {
      int i = MsgPackHelper.getIntValue(paramReqAckPackage.reqResponse, "own_time");
      int j = MsgPackHelper.getIntValue(paramReqAckPackage.reqResponse, "remaining_call_count");
      boolean bool = MsgPackHelper.getBooleanValue(paramReqAckPackage.reqResponse, "switch_sdk");
      String str = MsgPackHelper.getStringValue(paramReqAckPackage.reqResponse, "user_sig");
      int k = MsgPackHelper.getIntValue(paramReqAckPackage.reqResponse, "app_id");
      iVideoChatCallback = this.videoChatCallback;
      if (iVideoChatCallback != null) {
        iVideoChatCallback.onCallSuccess(i, j, bool, str, k);
        return;
      } 
    } else if (this.videoChatCallback != null && iVideoChatCallback != null) {
      String str = ((ReqAckPackage)iVideoChatCallback).errorContent;
      int i = ((ReqAckPackage)iVideoChatCallback).error;
      switch (i) {
        default:
          this.videoChatCallback.onCallFailed(VideoChatHelper.CallFailed.SERVER_LIMIT, str, i);
          return;
        case 17:
          this.videoChatCallback.onCallFailed(VideoChatHelper.CallFailed.APP_NOT_RECEIVE, str, i);
          return;
        case 16:
          this.videoChatCallback.onCallFailed(VideoChatHelper.CallFailed.APP_NOT_ONLINE, str, i);
          return;
        case 15:
          break;
      } 
      this.videoChatCallback.onCallFailed(VideoChatHelper.CallFailed.APP_NOT_SUPPORT, str, i);
    } 
  }
  
  protected void recvReqGetLeftTime(ReqAckPackage paramReqAckPackage) {
    if (paramReqAckPackage.result == 0 && paramReqAckPackage.error == 0) {
      int i = MsgPackHelper.getIntValue(paramReqAckPackage.reqResponse, "own_time");
      int j = MsgPackHelper.getIntValue(paramReqAckPackage.reqResponse, "remaining_call_count");
      IVideoChatCallback iVideoChatCallback = this.videoChatCallback;
      if (iVideoChatCallback != null) {
        iVideoChatCallback.onGetLeftTime(i, j);
        return;
      } 
    } else {
      IVideoChatCallback iVideoChatCallback = this.videoChatCallback;
      if (iVideoChatCallback != null)
        iVideoChatCallback.onGetLeftTimeFail(); 
    } 
  }
  
  public void switchToAudio(String paramString) {
    ReqVideoChatSwitchToAudioPackage reqVideoChatSwitchToAudioPackage = new ReqVideoChatSwitchToAudioPackage(paramString, ChatHelper.getLocalId());
    this.connector.sendPackage((BasePackage)reqVideoChatSwitchToAudioPackage);
  }
  
  public void updateCallMessage(long paramLong1, long paramLong2, int paramInt1, int paramInt2) {
    ChattingModel chattingModel = this.chat.findMessage((short)2, paramLong1, paramLong2, 0L, null);
    if (chattingModel != null && chattingModel.msgType == 52) {
      chattingModel.msgType = 53;
      VideoChatMsgContentModel videoChatMsgContentModel = null;
      Gson gson = new Gson();
      try {
        VideoChatMsgContentModel videoChatMsgContentModel1 = (VideoChatMsgContentModel)gson.fromJson(chattingModel.msgContent, (new TypeToken<VideoChatMsgContentModel>() {
            
            }).getType());
        videoChatMsgContentModel = videoChatMsgContentModel1;
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
      if (videoChatMsgContentModel != null) {
        videoChatMsgContentModel.close_type = paramInt1;
        videoChatMsgContentModel.total_time = paramInt2;
        chattingModel.msgContent = gson.toJson(videoChatMsgContentModel);
        this.chat.updateMsgData(chattingModel);
      } 
    } 
  }
  
  public void updateCallTimeToServer(String paramString, int paramInt) {
    ReqUpdateCallTimePackage reqUpdateCallTimePackage = new ReqUpdateCallTimePackage(paramString, paramInt, ChatHelper.getLocalId());
    this.connector.sendPackage((BasePackage)reqUpdateCallTimePackage);
  }
  
  public static interface IVideoChatCallback {
    long getCallUid();
    
    String getRoomId();
    
    int getRoomType();
    
    void onCallFailed(VideoChatHelper.CallFailed param1CallFailed, String param1String, int param1Int);
    
    void onCallSuccess(int param1Int1, int param1Int2, boolean param1Boolean, String param1String, int param1Int3);
    
    void onClose(int param1Int);
    
    void onGetLeftTime(int param1Int1, int param1Int2);
    
    void onGetLeftTimeFail();
    
    void onReceiveCallingMsg(long param1Long);
    
    void onSwitchToAudio();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\worker\chat\VideoChat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */