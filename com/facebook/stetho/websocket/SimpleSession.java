package com.facebook.stetho.websocket;

public interface SimpleSession {
  void close(int paramInt, String paramString);
  
  boolean isOpen();
  
  void sendBinary(byte[] paramArrayOfbyte);
  
  void sendText(String paramString);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\websocket\SimpleSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */