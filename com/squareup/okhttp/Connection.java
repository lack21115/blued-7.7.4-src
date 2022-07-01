package com.squareup.okhttp;

import java.net.Socket;

public interface Connection {
  Handshake getHandshake();
  
  Protocol getProtocol();
  
  Route getRoute();
  
  Socket getSocket();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\Connection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */