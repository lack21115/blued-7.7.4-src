package com.facebook.stetho.websocket;

import java.io.IOException;

interface WriteCallback {
  void onFailure(IOException paramIOException);
  
  void onSuccess();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\websocket\WriteCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */