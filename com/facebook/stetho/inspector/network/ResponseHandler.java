package com.facebook.stetho.inspector.network;

import java.io.IOException;

public interface ResponseHandler {
  void onEOF();
  
  void onError(IOException paramIOException);
  
  void onRead(int paramInt);
  
  void onReadDecoded(int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\network\ResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */