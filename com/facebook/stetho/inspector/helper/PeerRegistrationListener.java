package com.facebook.stetho.inspector.helper;

import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;

public interface PeerRegistrationListener {
  void onPeerRegistered(JsonRpcPeer paramJsonRpcPeer);
  
  void onPeerUnregistered(JsonRpcPeer paramJsonRpcPeer);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\helper\PeerRegistrationListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */