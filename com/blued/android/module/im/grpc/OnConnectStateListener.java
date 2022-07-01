package com.blued.android.module.im.grpc;

import com.google.protobuf.Any;

public interface OnConnectStateListener {
  void onConnected();
  
  void onConnecting();
  
  void onDisconnected();
  
  void onReceive(Any paramAny);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\im\grpc\OnConnectStateListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */