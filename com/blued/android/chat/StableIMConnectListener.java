package com.blued.android.chat;

import com.blued.android.chat.listener.IMStatusListener;
import com.blued.android.core.AppInfo;

public abstract class StableIMConnectListener implements IMStatusListener {
  private static final long MIN_CALLBACK_SPAN_MS = 500L;
  
  private long lastNotifyTime = -1L;
  
  private UICallbackTask uiCallback = new UICallbackTask();
  
  private void callBackNewState(IMStatus paramIMStatus) {
    this.uiCallback.setData(paramIMStatus);
    AppInfo.n().removeCallbacks(this.uiCallback);
    long l = System.currentTimeMillis();
    if (l - this.lastNotifyTime < 500L) {
      AppInfo.n().postDelayed(this.uiCallback, 500L);
      return;
    } 
    this.lastNotifyTime = l;
    AppInfo.n().post(this.uiCallback);
  }
  
  public final void onConnected() {
    callBackNewState(IMStatus.CONNECTED);
  }
  
  public final void onConnecting() {
    callBackNewState(IMStatus.CONNECTING);
  }
  
  public final void onDisconnected() {
    callBackNewState(IMStatus.DISCONNECT);
  }
  
  public final void onReceiving() {
    callBackNewState(IMStatus.RECEIVING);
  }
  
  public abstract void onUIConnected();
  
  public abstract void onUIConnecting();
  
  public abstract void onUIDisconnected();
  
  public abstract void onUIReceiving();
  
  public void reset() {
    this.lastNotifyTime = -1L;
  }
  
  public enum IMStatus {
    CONNECTED, CONNECTING, DISCONNECT, RECEIVING;
    
    static {
      CONNECTED = new IMStatus("CONNECTED", 2);
      RECEIVING = new IMStatus("RECEIVING", 3);
      $VALUES = new IMStatus[] { DISCONNECT, CONNECTING, CONNECTED, RECEIVING };
    }
  }
  
  class UICallbackTask implements Runnable {
    private StableIMConnectListener.IMStatus _state;
    
    private UICallbackTask() {}
    
    public void run() {
      int i = StableIMConnectListener.null.$SwitchMap$com$blued$android$chat$StableIMConnectListener$IMStatus[this._state.ordinal()];
      if (i != 1) {
        if (i != 2) {
          if (i != 3) {
            if (i != 4)
              return; 
            StableIMConnectListener.this.onUIReceiving();
            return;
          } 
          StableIMConnectListener.this.onUIConnected();
          return;
        } 
        StableIMConnectListener.this.onUIConnecting();
        return;
      } 
      StableIMConnectListener.this.onUIDisconnected();
    }
    
    public void setData(StableIMConnectListener.IMStatus param1IMStatus) {
      this._state = param1IMStatus;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\StableIMConnectListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */