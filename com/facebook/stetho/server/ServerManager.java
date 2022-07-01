package com.facebook.stetho.server;

import com.facebook.stetho.common.LogUtil;
import java.io.IOException;

public class ServerManager {
  private static final String THREAD_PREFIX = "StethoListener";
  
  private final LocalSocketServer mServer;
  
  private volatile boolean mStarted;
  
  public ServerManager(LocalSocketServer paramLocalSocketServer) {
    this.mServer = paramLocalSocketServer;
  }
  
  private void startServer(final LocalSocketServer server) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("StethoListener-");
    stringBuilder.append(server.getName());
    (new Thread(stringBuilder.toString()) {
        public void run() {
          try {
            server.run();
            return;
          } catch (IOException iOException) {
            LogUtil.e(iOException, "Could not start Stetho server: %s", new Object[] { this.val$server.getName() });
            return;
          } 
        }
      }).start();
  }
  
  public void start() {
    if (!this.mStarted) {
      this.mStarted = true;
      startServer(this.mServer);
      return;
    } 
    throw new IllegalStateException("Already started");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\server\ServerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */