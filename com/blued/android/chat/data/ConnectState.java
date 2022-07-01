package com.blued.android.chat.data;

public enum ConnectState {
  CONNECTED, CONNECTING, DISCONNECT;
  
  static {
    CONNECTING = new ConnectState("CONNECTING", 1);
    CONNECTED = new ConnectState("CONNECTED", 2);
    $VALUES = new ConnectState[] { DISCONNECT, CONNECTING, CONNECTED };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\data\ConnectState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */