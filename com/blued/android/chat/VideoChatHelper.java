package com.blued.android.chat;

import android.os.Handler;
import android.util.Log;
import com.blued.android.chat.core.worker.chat.VideoChat;

public class VideoChatHelper implements VideoChat.IVideoChatCallback {
  private static final String TAG = "Chat_VideoChatHelper";
  
  private CallInfoListener callInfoListener;
  
  private CallListener callListener;
  
  private Handler callbackHandler;
  
  private long callingMsgId;
  
  public final int chatSdkType;
  
  public final long communicateUid;
  
  private boolean destroyed = false;
  
  public final ROLE role;
  
  public final String roomId;
  
  public final int roomType;
  
  final VideoChat videoChatImpl;
  
  public VideoChatHelper(ROLE paramROLE, long paramLong, String paramString, int paramInt1, int paramInt2, CallInfoListener paramCallInfoListener) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("VideoChatHelper(), selfRole:");
      stringBuilder.append(paramROLE);
      stringBuilder.append(", communicateUid:");
      stringBuilder.append(paramLong);
      stringBuilder.append(", roomId:");
      stringBuilder.append(paramString);
      Log.v("Chat_VideoChatHelper", stringBuilder.toString());
    } 
    this.role = paramROLE;
    this.communicateUid = paramLong;
    this.roomId = paramString;
    this.roomType = paramInt1;
    this.chatSdkType = paramInt2;
    this.callInfoListener = paramCallInfoListener;
    this.videoChatImpl = ChatManager.getInstance().registerVideoChatHelper(this);
  }
  
  private void notifyCallFailed(final CallFailed failed, final String failedReason, final int failedCode) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("notifyCallFailed(), failed:");
      stringBuilder.append(failed);
      stringBuilder.append(", failedReason:");
      stringBuilder.append(failedReason);
      Log.v("Chat_VideoChatHelper", stringBuilder.toString());
    } 
    CallListener callListener = this.callListener;
    if (callListener != null) {
      Handler handler = this.callbackHandler;
      if (handler != null) {
        handler.post(new Runnable() {
              public void run() {
                VideoChatHelper.this.callListener.onCallFailed(failed, failedReason, failedCode);
              }
            });
        return;
      } 
      callListener.onCallFailed(failed, failedReason, failedCode);
    } 
  }
  
  private void notifyCallLeftTime(final int leftTimeSec, final int leftCount) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("notifyCallLeftTime(), leftTimeSec:");
      stringBuilder.append(leftTimeSec);
      Log.v("Chat_VideoChatHelper", stringBuilder.toString());
    } 
    CallInfoListener callInfoListener = this.callInfoListener;
    if (callInfoListener != null) {
      Handler handler = this.callbackHandler;
      if (handler != null) {
        handler.post(new Runnable() {
              public void run() {
                VideoChatHelper.this.callInfoListener.onCallLeftTime(leftTimeSec, leftCount);
              }
            });
        return;
      } 
      callInfoListener.onCallLeftTime(leftTimeSec, leftCount);
    } 
  }
  
  private void notifyCallLeftTimeFail() {
    CallInfoListener callInfoListener = this.callInfoListener;
    if (callInfoListener != null) {
      Handler handler = this.callbackHandler;
      if (handler != null) {
        handler.post(new Runnable() {
              public void run() {
                VideoChatHelper.this.callInfoListener.onCallLeftTimeFail();
              }
            });
        return;
      } 
      callInfoListener.onCallLeftTimeFail();
    } 
  }
  
  private void notifyCallSuccess(final int leftTimeMin, final int leftCount, final boolean isSwitchSdk, final String userSig, final int appId) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("notifyCallSuccess(), leftTimeMin:");
      stringBuilder.append(leftTimeMin);
      Log.v("Chat_VideoChatHelper", stringBuilder.toString());
    } 
    CallListener callListener = this.callListener;
    if (callListener != null) {
      Handler handler = this.callbackHandler;
      if (handler != null) {
        handler.post(new Runnable() {
              public void run() {
                VideoChatHelper.this.callListener.onCallSuccess(leftTimeMin, leftCount, isSwitchSdk, userSig, appId);
              }
            });
      } else {
        callListener.onCallSuccess(leftTimeMin, leftCount, isSwitchSdk, userSig, appId);
      } 
    } 
    CallInfoListener callInfoListener = this.callInfoListener;
    if (callInfoListener != null) {
      Handler handler = this.callbackHandler;
      if (handler != null) {
        handler.post(new Runnable() {
              public void run() {
                VideoChatHelper.this.callInfoListener.onCallLeftTime(leftTimeMin, leftCount);
              }
            });
        return;
      } 
      callInfoListener.onCallLeftTime(leftTimeMin, leftCount);
    } 
  }
  
  private void notifyClose(final int closeType) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("notifyClose(), closeType:");
      stringBuilder.append(closeType);
      Log.v("Chat_VideoChatHelper", stringBuilder.toString());
    } 
    CallInfoListener callInfoListener = this.callInfoListener;
    if (callInfoListener != null) {
      Handler handler = this.callbackHandler;
      if (handler != null) {
        handler.post(new Runnable() {
              public void run() {
                VideoChatHelper.this.callInfoListener.onCallClose(closeType);
              }
            });
      } else {
        callInfoListener.onCallClose(closeType);
      } 
    } 
    destroy();
  }
  
  private void notifySwitchToAudio() {
    if (ChatManager.debug)
      Log.v("Chat_VideoChatHelper", "notifySwitchToAudio()"); 
    CallInfoListener callInfoListener = this.callInfoListener;
    if (callInfoListener != null) {
      Handler handler = this.callbackHandler;
      if (handler != null) {
        handler.post(new Runnable() {
              public void run() {
                VideoChatHelper.this.callInfoListener.onSwitchToAudio();
              }
            });
        return;
      } 
      callInfoListener.onSwitchToAudio();
    } 
  }
  
  private void updateCallMsg(int paramInt1, int paramInt2) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("updateCallMsg(), closeType:");
      stringBuilder.append(paramInt1);
      stringBuilder.append(", callTimeSec:");
      stringBuilder.append(paramInt2);
      Log.v("Chat_VideoChatHelper", stringBuilder.toString());
    } 
    long l = this.callingMsgId;
    if (l > 0L)
      this.videoChatImpl.updateCallMessage(this.communicateUid, l, paramInt1, paramInt2); 
  }
  
  public void answer() {
    if (ChatManager.debug)
      Log.v("Chat_VideoChatHelper", "answer()"); 
    if (this.destroyed)
      return; 
    this.videoChatImpl.answer(this.communicateUid, this.roomId, this.roomType);
  }
  
  public void call(CallListener paramCallListener) {
    if (ChatManager.debug)
      Log.v("Chat_VideoChatHelper", "call()"); 
    if (this.destroyed)
      return; 
    this.callListener = paramCallListener;
    this.videoChatImpl.call(this.communicateUid, this.roomId, this.roomType, this.chatSdkType);
  }
  
  public void cancel(boolean paramBoolean) {
    byte b;
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("cancel(), timeout:");
      stringBuilder.append(paramBoolean);
      Log.v("Chat_VideoChatHelper", stringBuilder.toString());
    } 
    if (this.destroyed)
      return; 
    if (this.role == ROLE.CALLER) {
      if (paramBoolean) {
        b = 5;
      } else {
        b = 3;
      } 
    } else if (paramBoolean) {
      b = 7;
    } else {
      b = 4;
    } 
    this.videoChatImpl.close(this.roomId, b, 0L);
    updateCallMsg(b, 0);
    notifyClose(b);
    destroy();
  }
  
  public void cancelByBusy() {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("cancelByBusy(), role:");
      stringBuilder.append(this.role);
      Log.v("Chat_VideoChatHelper", stringBuilder.toString());
    } 
    if (this.destroyed)
      return; 
    this.videoChatImpl.close(this.roomId, 6, 0L);
    updateCallMsg(6, 0);
    notifyClose(6);
    destroy();
  }
  
  public void destroy() {
    if (ChatManager.debug)
      Log.v("Chat_VideoChatHelper", "destroy()"); 
    ChatManager.getInstance().unregisterVideoChatHelper(this);
    this.destroyed = true;
  }
  
  public long getCallUid() {
    return (this.role == ROLE.CALLER) ? ChatManager.getInstance().getUid() : this.communicateUid;
  }
  
  public void getLeftTimeAndCount() {
    if (this.destroyed)
      return; 
    this.videoChatImpl.getLeftTimeAndCount();
  }
  
  public String getRoomId() {
    return this.roomId;
  }
  
  public int getRoomType() {
    return this.roomType;
  }
  
  public void hangup(int paramInt) {
    byte b;
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("hangup(), callTimeSec:");
      stringBuilder.append(paramInt);
      Log.v("Chat_VideoChatHelper", stringBuilder.toString());
    } 
    if (this.destroyed)
      return; 
    if (this.role == ROLE.CALLER) {
      b = 1;
    } else {
      b = 2;
    } 
    this.videoChatImpl.close(this.roomId, b, paramInt);
    updateCallMsg(b, paramInt);
    notifyClose(b);
  }
  
  public boolean isDestroyed() {
    return this.destroyed;
  }
  
  public void onCallFailed(CallFailed paramCallFailed, String paramString, int paramInt) {
    notifyCallFailed(paramCallFailed, paramString, paramInt);
  }
  
  public void onCallSuccess(int paramInt1, int paramInt2, boolean paramBoolean, String paramString, int paramInt3) {
    notifyCallSuccess(paramInt1, paramInt2, paramBoolean, paramString, paramInt3);
  }
  
  public void onClose(int paramInt) {
    notifyClose(paramInt);
  }
  
  public void onGetLeftTime(int paramInt1, int paramInt2) {
    notifyCallLeftTime(paramInt1, paramInt2);
  }
  
  public void onGetLeftTimeFail() {
    notifyCallLeftTimeFail();
  }
  
  public void onReceiveCallingMsg(long paramLong) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onReceiveCallingMsg(), msgId:");
      stringBuilder.append(paramLong);
      Log.v("Chat_VideoChatHelper", stringBuilder.toString());
    } 
    this.callingMsgId = paramLong;
  }
  
  public void onSwitchToAudio() {
    if (ChatManager.debug)
      Log.v("Chat_VideoChatHelper", "onSwitchToAudio()"); 
    notifySwitchToAudio();
  }
  
  public void setCallbackHandler(Handler paramHandler) {
    this.callbackHandler = paramHandler;
  }
  
  public void switchToAudio() {
    if (ChatManager.debug)
      Log.v("Chat_VideoChatHelper", "switchToAudio()"); 
    if (this.destroyed)
      return; 
    this.videoChatImpl.switchToAudio(this.roomId);
  }
  
  public void updateCallTime(int paramInt) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("updateCallTime(), chatTimeSec:");
      stringBuilder.append(paramInt);
      Log.v("Chat_VideoChatHelper", stringBuilder.toString());
    } 
    if (this.destroyed)
      return; 
    this.videoChatImpl.updateCallTimeToServer(this.roomId, paramInt);
  }
  
  public enum CallFailed {
    APP_NOT_ONLINE, APP_NOT_RECEIVE, APP_NOT_SUPPORT, NETWORK, SERVER_LIMIT, UNKNOWN;
    
    static {
      APP_NOT_ONLINE = new CallFailed("APP_NOT_ONLINE", 2);
      APP_NOT_RECEIVE = new CallFailed("APP_NOT_RECEIVE", 3);
      NETWORK = new CallFailed("NETWORK", 4);
      UNKNOWN = new CallFailed("UNKNOWN", 5);
      $VALUES = new CallFailed[] { SERVER_LIMIT, APP_NOT_SUPPORT, APP_NOT_ONLINE, APP_NOT_RECEIVE, NETWORK, UNKNOWN };
    }
  }
  
  public static interface CallInfoListener {
    void onCallClose(int param1Int);
    
    void onCallLeftTime(int param1Int1, int param1Int2);
    
    void onCallLeftTimeFail();
    
    void onSwitchToAudio();
  }
  
  public static interface CallListener {
    void onCallFailed(VideoChatHelper.CallFailed param1CallFailed, String param1String, int param1Int);
    
    void onCallSuccess(int param1Int1, int param1Int2, boolean param1Boolean, String param1String, int param1Int3);
  }
  
  public static interface CloseType {
    public static final int BUSY_BY_RECEIVER = 6;
    
    public static final int CANCEL_BY_CALLER = 3;
    
    public static final int HANGUP_BY_CALLER = 1;
    
    public static final int HANGUP_BY_RECEIVER = 2;
    
    public static final int REJECT_BY_RECEIVER = 4;
    
    public static final int TIMEOUT_BY_CALLER = 5;
    
    public static final int TIMEOUT_BY_RECEIVER = 7;
    
    public static final int UNKNOWN = 0;
  }
  
  public enum ROLE {
    CALLER, RECEIVER;
    
    static {
    
    }
  }
  
  public static interface RoomType {
    public static final int AUDIO = 1;
    
    public static final int VIDEO = 2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\VideoChatHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */