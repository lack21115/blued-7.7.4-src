package com.blued.android.chat.core.worker.chat;

import com.blued.android.chat.WawajiControllerHelper;
import com.blued.android.chat.core.pack.BasePackage;
import com.blued.android.chat.core.pack.PushMsgPackage;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.chat.core.pack.ReqWawajiControllerCheckPlayPackage;
import com.blued.android.chat.core.pack.ReqWawajiControllerInitPackage;
import com.blued.android.chat.core.pack.ReqWawajiControllerReadyPackage;
import com.blued.android.chat.core.pack.ReqWawajiControllerUploadResultPackage;
import com.blued.android.chat.core.worker.Connector;
import com.blued.android.chat.core.worker.PackSendHelper;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.chat.utils.MsgPackHelper;

public class WawajiControllerChat {
  private final Chat chat;
  
  private final Connector connector;
  
  private IWawajiControllerCallback wawajiControllerCallback;
  
  public WawajiControllerChat(Connector paramConnector, Chat paramChat) {
    this.connector = paramConnector;
    this.chat = paramChat;
    this.chat.wawajiControllerChat = this;
  }
  
  public static boolean handleMessage(int paramInt) {
    return (paramInt == 76 || paramInt == 77);
  }
  
  private void initControllerFailed(String paramString) {
    IWawajiControllerCallback iWawajiControllerCallback = this.wawajiControllerCallback;
    if (iWawajiControllerCallback != null)
      iWawajiControllerCallback.onInitControllerFailed(paramString); 
  }
  
  private void initControllerSuccess(long paramLong, String paramString1, String paramString2, String paramString3) {
    IWawajiControllerCallback iWawajiControllerCallback = this.wawajiControllerCallback;
    if (iWawajiControllerCallback != null)
      iWawajiControllerCallback.onInitControllerSuccess(paramLong, paramString1, paramString2, paramString3); 
  }
  
  private void playCheckFailed(String paramString) {
    IWawajiControllerCallback iWawajiControllerCallback = this.wawajiControllerCallback;
    if (iWawajiControllerCallback != null)
      iWawajiControllerCallback.onPlayCheckFailed(paramString); 
  }
  
  private void playCheckSuccess() {
    IWawajiControllerCallback iWawajiControllerCallback = this.wawajiControllerCallback;
    if (iWawajiControllerCallback != null)
      iWawajiControllerCallback.onPlayCheckSuccess(); 
  }
  
  private void readyControllerFailed(String paramString) {
    IWawajiControllerCallback iWawajiControllerCallback = this.wawajiControllerCallback;
    if (iWawajiControllerCallback != null)
      iWawajiControllerCallback.onReadyControllerFailed(paramString); 
  }
  
  private void readyControllerSuccess() {
    IWawajiControllerCallback iWawajiControllerCallback = this.wawajiControllerCallback;
    if (iWawajiControllerCallback != null)
      iWawajiControllerCallback.onReadyControllerSuccess(); 
  }
  
  private void recvControllerUpdateMsg(PushMsgPackage paramPushMsgPackage) {
    if (paramPushMsgPackage.msgMapExtra != null) {
      long l = MsgPackHelper.getLongValue(paramPushMsgPackage.msgMapExtra, "version_code");
      String str = MsgPackHelper.getStringValue(paramPushMsgPackage.msgMapExtra, "url");
      IWawajiControllerCallback iWawajiControllerCallback = this.wawajiControllerCallback;
      if (iWawajiControllerCallback != null)
        iWawajiControllerCallback.onControllerUpdate(l, str); 
    } 
  }
  
  private void recvPlayConfigMsg(PushMsgPackage paramPushMsgPackage) {
    if (paramPushMsgPackage.msgMapExtra != null) {
      long l = MsgPackHelper.getLongValue(paramPushMsgPackage.msgMapExtra, "uid");
      String str = MsgPackHelper.getStringValue(paramPushMsgPackage.msgMapExtra, "order_id");
      WawajiControllerHelper.WawajiControllerConfig wawajiControllerConfig = WawajiControllerHelper.WawajiControllerConfig.parseData(MsgPackHelper.getMapValue(paramPushMsgPackage.msgMapExtra, "config"));
      IWawajiControllerCallback iWawajiControllerCallback = this.wawajiControllerCallback;
      if (iWawajiControllerCallback != null)
        iWawajiControllerCallback.onPlayConfig(l, str, wawajiControllerConfig); 
    } 
  }
  
  private void uploadGameResultFailed(WawajiControllerHelper.WawajiGameResult paramWawajiGameResult, String paramString) {
    IWawajiControllerCallback iWawajiControllerCallback = this.wawajiControllerCallback;
    if (iWawajiControllerCallback != null)
      iWawajiControllerCallback.onUploadGameResultFailed(paramWawajiGameResult, paramString); 
  }
  
  private void uploadGameResultSuccess(WawajiControllerHelper.WawajiGameResult paramWawajiGameResult) {
    IWawajiControllerCallback iWawajiControllerCallback = this.wawajiControllerCallback;
    if (iWawajiControllerCallback != null)
      iWawajiControllerCallback.onUploadGameResultSuccess(paramWawajiGameResult); 
  }
  
  public void attach(IWawajiControllerCallback paramIWawajiControllerCallback) {
    this.wawajiControllerCallback = paramIWawajiControllerCallback;
  }
  
  public void checkPlayingState(long paramLong) {
    ReqWawajiControllerCheckPlayPackage reqWawajiControllerCheckPlayPackage = new ReqWawajiControllerCheckPlayPackage(paramLong, ChatHelper.getLocalId());
    this.connector.getPackageSendHelper().sendPackage((BasePackage)reqWawajiControllerCheckPlayPackage, new PackSendHelper.PackCallback() {
          public void onAckTimeout(BasePackage param1BasePackage) {
            WawajiControllerChat.this.playCheckFailed("ack timeout");
          }
          
          public void onReceiveAck(BasePackage param1BasePackage1, BasePackage param1BasePackage2) {
            if (param1BasePackage2 instanceof ReqAckPackage) {
              ReqAckPackage reqAckPackage = (ReqAckPackage)param1BasePackage2;
              if (reqAckPackage.error == 0) {
                WawajiControllerChat.this.playCheckSuccess();
                return;
              } 
              WawajiControllerChat wawajiControllerChat = WawajiControllerChat.this;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("ack errorCode:");
              stringBuilder.append(reqAckPackage.error);
              wawajiControllerChat.playCheckFailed(stringBuilder.toString());
            } 
          }
          
          public void onSendFailed(BasePackage param1BasePackage) {
            WawajiControllerChat.this.playCheckFailed("send failed");
          }
          
          public void onSendFinish(BasePackage param1BasePackage) {}
          
          public void onSendTimeout(BasePackage param1BasePackage) {
            WawajiControllerChat.this.playCheckFailed("send timeout");
          }
        });
  }
  
  public void detach(IWawajiControllerCallback paramIWawajiControllerCallback) {
    if (this.wawajiControllerCallback == paramIWawajiControllerCallback)
      this.wawajiControllerCallback = null; 
  }
  
  protected boolean handlePushMessage(PushMsgPackage paramPushMsgPackage) {
    if (paramPushMsgPackage.msgType == 76) {
      recvPlayConfigMsg(paramPushMsgPackage);
      return true;
    } 
    if (paramPushMsgPackage.msgType == 77) {
      recvControllerUpdateMsg(paramPushMsgPackage);
      return true;
    } 
    return false;
  }
  
  public void initController() {
    ReqWawajiControllerInitPackage reqWawajiControllerInitPackage = new ReqWawajiControllerInitPackage(ChatHelper.getLocalId());
    this.connector.getPackageSendHelper().sendPackage((BasePackage)reqWawajiControllerInitPackage, new PackSendHelper.PackCallback() {
          public void onAckTimeout(BasePackage param1BasePackage) {
            WawajiControllerChat.this.initControllerFailed("init ack timeout");
          }
          
          public void onReceiveAck(BasePackage param1BasePackage1, BasePackage param1BasePackage2) {
            if (param1BasePackage2 instanceof ReqAckPackage) {
              String str;
              ReqAckPackage reqAckPackage = (ReqAckPackage)param1BasePackage2;
              if (reqAckPackage.error == 0) {
                long l = MsgPackHelper.getLongValue(reqAckPackage.reqResponse, "session_id");
                String str1 = MsgPackHelper.getStringValue(reqAckPackage.reqResponse, "room_id");
                String str2 = MsgPackHelper.getStringValue(reqAckPackage.reqResponse, "stream_id1");
                str = MsgPackHelper.getStringValue(reqAckPackage.reqResponse, "stream_id2");
                WawajiControllerChat.this.initControllerSuccess(l, str1, str2, str);
                return;
              } 
              WawajiControllerChat wawajiControllerChat = WawajiControllerChat.this;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("ack errorCode:");
              stringBuilder.append(((ReqAckPackage)str).error);
              wawajiControllerChat.initControllerFailed(stringBuilder.toString());
            } 
          }
          
          public void onSendFailed(BasePackage param1BasePackage) {
            WawajiControllerChat.this.initControllerFailed("init send failed");
          }
          
          public void onSendFinish(BasePackage param1BasePackage) {}
          
          public void onSendTimeout(BasePackage param1BasePackage) {
            WawajiControllerChat.this.initControllerFailed("init send timeout");
          }
        });
  }
  
  public void readyController(long paramLong) {
    ReqWawajiControllerReadyPackage reqWawajiControllerReadyPackage = new ReqWawajiControllerReadyPackage(paramLong, ChatHelper.getLocalId());
    this.connector.getPackageSendHelper().sendPackage((BasePackage)reqWawajiControllerReadyPackage, new PackSendHelper.PackCallback() {
          public void onAckTimeout(BasePackage param1BasePackage) {
            WawajiControllerChat.this.readyControllerFailed("ack timeout");
          }
          
          public void onReceiveAck(BasePackage param1BasePackage1, BasePackage param1BasePackage2) {
            if (param1BasePackage2 instanceof ReqAckPackage) {
              ReqAckPackage reqAckPackage = (ReqAckPackage)param1BasePackage2;
              if (reqAckPackage.error == 0) {
                WawajiControllerChat.this.readyControllerSuccess();
                return;
              } 
              WawajiControllerChat wawajiControllerChat = WawajiControllerChat.this;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("ack errorCode:");
              stringBuilder.append(reqAckPackage.error);
              wawajiControllerChat.readyControllerFailed(stringBuilder.toString());
            } 
          }
          
          public void onSendFailed(BasePackage param1BasePackage) {
            WawajiControllerChat.this.readyControllerFailed("send failed");
          }
          
          public void onSendFinish(BasePackage param1BasePackage) {}
          
          public void onSendTimeout(BasePackage param1BasePackage) {
            WawajiControllerChat.this.readyControllerFailed("send timeout");
          }
        });
  }
  
  public void uploadGameResult(final WawajiControllerHelper.WawajiGameResult result) {
    ReqWawajiControllerUploadResultPackage reqWawajiControllerUploadResultPackage = new ReqWawajiControllerUploadResultPackage(result.sessionId, result.playerUid, result.orderId, result.result, ChatHelper.getLocalId());
    this.connector.getPackageSendHelper().sendPackage((BasePackage)reqWawajiControllerUploadResultPackage, new PackSendHelper.PackCallback() {
          public void onAckTimeout(BasePackage param1BasePackage) {
            WawajiControllerChat.this.uploadGameResultFailed(result, "ack timeout");
          }
          
          public void onReceiveAck(BasePackage param1BasePackage1, BasePackage param1BasePackage2) {
            if (param1BasePackage2 instanceof ReqAckPackage) {
              ReqAckPackage reqAckPackage = (ReqAckPackage)param1BasePackage2;
              if (reqAckPackage.error == 0) {
                WawajiControllerChat.this.uploadGameResultSuccess(result);
                return;
              } 
              WawajiControllerChat wawajiControllerChat = WawajiControllerChat.this;
              WawajiControllerHelper.WawajiGameResult wawajiGameResult = result;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("ack errorCode:");
              stringBuilder.append(reqAckPackage.error);
              wawajiControllerChat.uploadGameResultFailed(wawajiGameResult, stringBuilder.toString());
            } 
          }
          
          public void onSendFailed(BasePackage param1BasePackage) {
            WawajiControllerChat.this.uploadGameResultFailed(result, "send failed");
          }
          
          public void onSendFinish(BasePackage param1BasePackage) {}
          
          public void onSendTimeout(BasePackage param1BasePackage) {
            WawajiControllerChat.this.uploadGameResultFailed(result, "send timeout");
          }
        });
  }
  
  public static interface IWawajiControllerCallback {
    void onControllerUpdate(long param1Long, String param1String);
    
    void onInitControllerFailed(String param1String);
    
    void onInitControllerSuccess(long param1Long, String param1String1, String param1String2, String param1String3);
    
    void onPlayCheckFailed(String param1String);
    
    void onPlayCheckSuccess();
    
    void onPlayConfig(long param1Long, String param1String, WawajiControllerHelper.WawajiControllerConfig param1WawajiControllerConfig);
    
    void onReadyControllerFailed(String param1String);
    
    void onReadyControllerSuccess();
    
    void onUploadGameResultFailed(WawajiControllerHelper.WawajiGameResult param1WawajiGameResult, String param1String);
    
    void onUploadGameResultSuccess(WawajiControllerHelper.WawajiGameResult param1WawajiGameResult);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\worker\chat\WawajiControllerChat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */