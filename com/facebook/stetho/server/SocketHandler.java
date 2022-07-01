package com.facebook.stetho.server;

import android.net.LocalSocket;
import java.io.IOException;

public interface SocketHandler {
  void onAccepted(LocalSocket paramLocalSocket) throws IOException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\server\SocketHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */