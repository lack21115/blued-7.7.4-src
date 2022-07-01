package com.facebook.stetho.server.http;

import com.facebook.stetho.server.SocketLike;
import java.io.IOException;

public interface HttpHandler {
  boolean handleRequest(SocketLike paramSocketLike, LightHttpRequest paramLightHttpRequest, LightHttpResponse paramLightHttpResponse) throws IOException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\server\http\HttpHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */