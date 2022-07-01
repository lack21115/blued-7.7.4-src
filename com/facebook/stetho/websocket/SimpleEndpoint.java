package com.facebook.stetho.websocket;

public interface SimpleEndpoint {
  void onClose(SimpleSession paramSimpleSession, int paramInt, String paramString);
  
  void onError(SimpleSession paramSimpleSession, Throwable paramThrowable);
  
  void onMessage(SimpleSession paramSimpleSession, String paramString);
  
  void onMessage(SimpleSession paramSimpleSession, byte[] paramArrayOfbyte, int paramInt);
  
  void onOpen(SimpleSession paramSimpleSession);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\websocket\SimpleEndpoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */