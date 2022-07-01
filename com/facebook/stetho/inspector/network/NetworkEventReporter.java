package com.facebook.stetho.inspector.network;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;

public interface NetworkEventReporter {
  void dataReceived(String paramString, int paramInt1, int paramInt2);
  
  void dataSent(String paramString, int paramInt1, int paramInt2);
  
  void httpExchangeFailed(String paramString1, String paramString2);
  
  @Nullable
  InputStream interpretResponseStream(String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable InputStream paramInputStream, ResponseHandler paramResponseHandler);
  
  boolean isEnabled();
  
  String nextRequestId();
  
  void requestWillBeSent(InspectorRequest paramInspectorRequest);
  
  void responseHeadersReceived(InspectorResponse paramInspectorResponse);
  
  void responseReadFailed(String paramString1, String paramString2);
  
  void responseReadFinished(String paramString);
  
  void webSocketClosed(String paramString);
  
  void webSocketCreated(String paramString1, String paramString2);
  
  void webSocketFrameError(String paramString1, String paramString2);
  
  void webSocketFrameReceived(InspectorWebSocketFrame paramInspectorWebSocketFrame);
  
  void webSocketFrameSent(InspectorWebSocketFrame paramInspectorWebSocketFrame);
  
  void webSocketHandshakeResponseReceived(InspectorWebSocketResponse paramInspectorWebSocketResponse);
  
  void webSocketWillSendHandshakeRequest(InspectorWebSocketRequest paramInspectorWebSocketRequest);
  
  public static interface InspectorHeaders {
    @Nullable
    String firstHeaderValue(String param1String);
    
    int headerCount();
    
    String headerName(int param1Int);
    
    String headerValue(int param1Int);
  }
  
  public static interface InspectorRequest extends InspectorRequestCommon {
    @Nullable
    byte[] body() throws IOException;
    
    @Nullable
    Integer friendlyNameExtra();
    
    String method();
    
    String url();
  }
  
  public static interface InspectorRequestCommon extends InspectorHeaders {
    String friendlyName();
    
    String id();
  }
  
  public static interface InspectorResponse extends InspectorResponseCommon {
    int connectionId();
    
    boolean connectionReused();
    
    boolean fromDiskCache();
    
    String url();
  }
  
  public static interface InspectorResponseCommon extends InspectorHeaders {
    String reasonPhrase();
    
    String requestId();
    
    int statusCode();
  }
  
  public static interface InspectorWebSocketFrame {
    public static final int OPCODE_BINARY = 2;
    
    public static final int OPCODE_CONNECTION_CLOSE = 8;
    
    public static final int OPCODE_CONTINUATION = 0;
    
    public static final int OPCODE_PING = 9;
    
    public static final int OPCODE_PONG = 10;
    
    public static final int OPCODE_TEXT = 1;
    
    boolean mask();
    
    int opcode();
    
    String payloadData();
    
    String requestId();
  }
  
  public static interface InspectorWebSocketRequest extends InspectorRequestCommon {}
  
  public static interface InspectorWebSocketResponse extends InspectorResponseCommon {
    @Nullable
    NetworkEventReporter.InspectorHeaders requestHeaders();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\network\NetworkEventReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */