package com.facebook.stetho.server;

import android.net.LocalSocket;
import java.io.IOException;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class LazySocketHandler implements SocketHandler {
  @Nullable
  private SocketHandler mSocketHandler;
  
  private final SocketHandlerFactory mSocketHandlerFactory;
  
  public LazySocketHandler(SocketHandlerFactory paramSocketHandlerFactory) {
    this.mSocketHandlerFactory = paramSocketHandlerFactory;
  }
  
  @Nonnull
  private SocketHandler getSocketHandler() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mSocketHandler : Lcom/facebook/stetho/server/SocketHandler;
    //   6: ifnonnull -> 22
    //   9: aload_0
    //   10: aload_0
    //   11: getfield mSocketHandlerFactory : Lcom/facebook/stetho/server/SocketHandlerFactory;
    //   14: invokeinterface create : ()Lcom/facebook/stetho/server/SocketHandler;
    //   19: putfield mSocketHandler : Lcom/facebook/stetho/server/SocketHandler;
    //   22: aload_0
    //   23: getfield mSocketHandler : Lcom/facebook/stetho/server/SocketHandler;
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: areturn
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	31	finally
    //   22	27	31	finally
  }
  
  public void onAccepted(LocalSocket paramLocalSocket) throws IOException {
    getSocketHandler().onAccepted(paramLocalSocket);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\server\LazySocketHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */