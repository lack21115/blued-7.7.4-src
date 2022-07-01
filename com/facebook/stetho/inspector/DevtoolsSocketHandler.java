package com.facebook.stetho.inspector;

import android.content.Context;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.server.SocketLike;
import com.facebook.stetho.server.SocketLikeHandler;
import com.facebook.stetho.server.http.ExactPathMatcher;
import com.facebook.stetho.server.http.HandlerRegistry;
import com.facebook.stetho.server.http.HttpHandler;
import com.facebook.stetho.server.http.LightHttpServer;
import com.facebook.stetho.server.http.PathMatcher;
import com.facebook.stetho.websocket.WebSocketHandler;
import java.io.IOException;

public class DevtoolsSocketHandler implements SocketLikeHandler {
  private final Context mContext;
  
  private final Iterable<ChromeDevtoolsDomain> mModules;
  
  private final LightHttpServer mServer;
  
  public DevtoolsSocketHandler(Context paramContext, Iterable<ChromeDevtoolsDomain> paramIterable) {
    this.mContext = paramContext;
    this.mModules = paramIterable;
    this.mServer = createServer();
  }
  
  private LightHttpServer createServer() {
    HandlerRegistry handlerRegistry = new HandlerRegistry();
    (new ChromeDiscoveryHandler(this.mContext, "/inspector")).register(handlerRegistry);
    handlerRegistry.register((PathMatcher)new ExactPathMatcher("/inspector"), (HttpHandler)new WebSocketHandler(new ChromeDevtoolsServer(this.mModules)));
    return new LightHttpServer(handlerRegistry);
  }
  
  public void onAccepted(SocketLike paramSocketLike) throws IOException {
    this.mServer.serve(paramSocketLike);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\DevtoolsSocketHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */