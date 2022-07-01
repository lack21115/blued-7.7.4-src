package com.facebook.stetho.websocket;

import android.util.Base64;
import com.facebook.stetho.common.Utf8Charset;
import com.facebook.stetho.server.SocketLike;
import com.facebook.stetho.server.http.HttpHandler;
import com.facebook.stetho.server.http.LightHttpBody;
import com.facebook.stetho.server.http.LightHttpMessage;
import com.facebook.stetho.server.http.LightHttpRequest;
import com.facebook.stetho.server.http.LightHttpResponse;
import com.facebook.stetho.server.http.LightHttpServer;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.Nullable;

public class WebSocketHandler implements HttpHandler {
  private static final String HEADER_CONNECTION = "Connection";
  
  private static final String HEADER_CONNECTION_UPGRADE = "Upgrade";
  
  private static final String HEADER_SEC_WEBSOCKET_ACCEPT = "Sec-WebSocket-Accept";
  
  private static final String HEADER_SEC_WEBSOCKET_KEY = "Sec-WebSocket-Key";
  
  private static final String HEADER_SEC_WEBSOCKET_PROTOCOL = "Sec-WebSocket-Protocol";
  
  private static final String HEADER_SEC_WEBSOCKET_VERSION = "Sec-WebSocket-Version";
  
  private static final String HEADER_SEC_WEBSOCKET_VERSION_13 = "13";
  
  private static final String HEADER_UPGRADE = "Upgrade";
  
  private static final String HEADER_UPGRADE_WEBSOCKET = "websocket";
  
  private static final String SERVER_KEY_GUID = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
  
  private final SimpleEndpoint mEndpoint;
  
  public WebSocketHandler(SimpleEndpoint paramSimpleEndpoint) {
    this.mEndpoint = paramSimpleEndpoint;
  }
  
  private void doUpgrade(SocketLike paramSocketLike, LightHttpRequest paramLightHttpRequest, LightHttpResponse paramLightHttpResponse) throws IOException {
    paramLightHttpResponse.code = 101;
    paramLightHttpResponse.reasonPhrase = "Switching Protocols";
    paramLightHttpResponse.addHeader("Upgrade", "websocket");
    paramLightHttpResponse.addHeader("Connection", "Upgrade");
    paramLightHttpResponse.body = null;
    String str = getFirstHeaderValue((LightHttpMessage)paramLightHttpRequest, "Sec-WebSocket-Key");
    if (str != null)
      paramLightHttpResponse.addHeader("Sec-WebSocket-Accept", generateServerKey(str)); 
    InputStream inputStream = paramSocketLike.getInput();
    OutputStream outputStream = paramSocketLike.getOutput();
    LightHttpServer.writeResponseMessage(paramLightHttpResponse, new LightHttpServer.HttpMessageWriter(new BufferedOutputStream(outputStream)));
    (new WebSocketSession(inputStream, outputStream, this.mEndpoint)).handle();
  }
  
  private static String generateServerKey(String paramString) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append("258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
      paramString = stringBuilder.toString();
      MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
      messageDigest.update(Utf8Charset.encodeUTF8(paramString));
      return Base64.encodeToString(messageDigest.digest(), 2);
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new RuntimeException(noSuchAlgorithmException);
    } 
  }
  
  @Nullable
  private static String getFirstHeaderValue(LightHttpMessage paramLightHttpMessage, String paramString) {
    return paramLightHttpMessage.getFirstHeaderValue(paramString);
  }
  
  private static boolean isSupportableUpgradeRequest(LightHttpRequest paramLightHttpRequest) {
    return ("websocket".equalsIgnoreCase(getFirstHeaderValue((LightHttpMessage)paramLightHttpRequest, "Upgrade")) && "Upgrade".equals(getFirstHeaderValue((LightHttpMessage)paramLightHttpRequest, "Connection")) && "13".equals(getFirstHeaderValue((LightHttpMessage)paramLightHttpRequest, "Sec-WebSocket-Version")));
  }
  
  public boolean handleRequest(SocketLike paramSocketLike, LightHttpRequest paramLightHttpRequest, LightHttpResponse paramLightHttpResponse) throws IOException {
    if (!isSupportableUpgradeRequest(paramLightHttpRequest)) {
      paramLightHttpResponse.code = 501;
      paramLightHttpResponse.reasonPhrase = "Not Implemented";
      paramLightHttpResponse.body = LightHttpBody.create("Not a supported WebSocket upgrade request\n", "text/plain");
      return true;
    } 
    doUpgrade(paramSocketLike, paramLightHttpRequest, paramLightHttpResponse);
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\websocket\WebSocketHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */