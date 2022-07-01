package com.facebook.stetho.inspector.network;

import android.os.SystemClock;
import com.facebook.stetho.common.Utf8Charset;
import com.facebook.stetho.inspector.console.CLog;
import com.facebook.stetho.inspector.protocol.module.Console;
import com.facebook.stetho.inspector.protocol.module.Network;
import com.facebook.stetho.inspector.protocol.module.Page;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class NetworkEventReporterImpl implements NetworkEventReporter {
  private static NetworkEventReporter sInstance;
  
  private final AtomicInteger mNextRequestId = new AtomicInteger(0);
  
  @Nullable
  private ResourceTypeHelper mResourceTypeHelper;
  
  private static Network.WebSocketFrame convertFrame(NetworkEventReporter.InspectorWebSocketFrame paramInspectorWebSocketFrame) {
    Network.WebSocketFrame webSocketFrame = new Network.WebSocketFrame();
    webSocketFrame.opcode = paramInspectorWebSocketFrame.opcode();
    webSocketFrame.mask = paramInspectorWebSocketFrame.mask();
    webSocketFrame.payloadData = paramInspectorWebSocketFrame.payloadData();
    return webSocketFrame;
  }
  
  @Nullable
  static AsyncPrettyPrinter createPrettyPrinterForResponse(NetworkEventReporter.InspectorResponse paramInspectorResponse, @Nullable AsyncPrettyPrinterRegistry paramAsyncPrettyPrinterRegistry) {
    if (paramAsyncPrettyPrinterRegistry != null) {
      int i = 0;
      int j = paramInspectorResponse.headerCount();
      while (i < j) {
        AsyncPrettyPrinterFactory asyncPrettyPrinterFactory = paramAsyncPrettyPrinterRegistry.lookup(paramInspectorResponse.headerName(i));
        if (asyncPrettyPrinterFactory != null)
          return asyncPrettyPrinterFactory.getInstance(paramInspectorResponse.headerName(i), paramInspectorResponse.headerValue(i)); 
        i++;
      } 
    } 
    return null;
  }
  
  private static Page.ResourceType determineResourceType(AsyncPrettyPrinter paramAsyncPrettyPrinter, String paramString, ResourceTypeHelper paramResourceTypeHelper) {
    return (paramAsyncPrettyPrinter != null) ? paramAsyncPrettyPrinter.getPrettifiedType().getResourceType() : ((paramString != null) ? paramResourceTypeHelper.determineResourceType(paramString) : Page.ResourceType.OTHER);
  }
  
  private static JSONObject formatHeadersAsJSON(NetworkEventReporter.InspectorHeaders paramInspectorHeaders) {
    JSONObject jSONObject = new JSONObject();
    int i = 0;
    while (i < paramInspectorHeaders.headerCount()) {
      String str1 = paramInspectorHeaders.headerName(i);
      String str2 = paramInspectorHeaders.headerValue(i);
      try {
        if (jSONObject.has(str1)) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(jSONObject.getString(str1));
          stringBuilder.append("\n");
          stringBuilder.append(str2);
          jSONObject.put(str1, stringBuilder.toString());
        } else {
          jSONObject.put(str1, str2);
        } 
        i++;
      } catch (JSONException jSONException) {
        throw new RuntimeException(jSONException);
      } 
    } 
    return jSONObject;
  }
  
  public static NetworkEventReporter get() {
    // Byte code:
    //   0: ldc com/facebook/stetho/inspector/network/NetworkEventReporterImpl
    //   2: monitorenter
    //   3: getstatic com/facebook/stetho/inspector/network/NetworkEventReporterImpl.sInstance : Lcom/facebook/stetho/inspector/network/NetworkEventReporter;
    //   6: ifnonnull -> 19
    //   9: new com/facebook/stetho/inspector/network/NetworkEventReporterImpl
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/facebook/stetho/inspector/network/NetworkEventReporterImpl.sInstance : Lcom/facebook/stetho/inspector/network/NetworkEventReporter;
    //   19: getstatic com/facebook/stetho/inspector/network/NetworkEventReporterImpl.sInstance : Lcom/facebook/stetho/inspector/network/NetworkEventReporter;
    //   22: astore_0
    //   23: ldc com/facebook/stetho/inspector/network/NetworkEventReporterImpl
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/facebook/stetho/inspector/network/NetworkEventReporterImpl
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	23	28	finally
  }
  
  @Nullable
  private String getContentType(NetworkEventReporter.InspectorHeaders paramInspectorHeaders) {
    return paramInspectorHeaders.firstHeaderValue("Content-Type");
  }
  
  @Nullable
  private NetworkPeerManager getPeerManagerIfEnabled() {
    NetworkPeerManager networkPeerManager = NetworkPeerManager.getInstanceOrNull();
    return (networkPeerManager != null && networkPeerManager.hasRegisteredPeers()) ? networkPeerManager : null;
  }
  
  @Nonnull
  private ResourceTypeHelper getResourceTypeHelper() {
    if (this.mResourceTypeHelper == null)
      this.mResourceTypeHelper = new ResourceTypeHelper(); 
    return this.mResourceTypeHelper;
  }
  
  @Nullable
  private static AsyncPrettyPrinter initAsyncPrettyPrinterForResponse(NetworkEventReporter.InspectorResponse paramInspectorResponse, NetworkPeerManager paramNetworkPeerManager) {
    AsyncPrettyPrinter asyncPrettyPrinter = createPrettyPrinterForResponse(paramInspectorResponse, paramNetworkPeerManager.getAsyncPrettyPrinterRegistry());
    if (asyncPrettyPrinter != null)
      paramNetworkPeerManager.getResponseBodyFileManager().associateAsyncPrettyPrinterWithId(paramInspectorResponse.requestId(), asyncPrettyPrinter); 
    return asyncPrettyPrinter;
  }
  
  private void loadingFailed(String paramString1, String paramString2) {
    NetworkPeerManager networkPeerManager = getPeerManagerIfEnabled();
    if (networkPeerManager != null) {
      Network.LoadingFailedParams loadingFailedParams = new Network.LoadingFailedParams();
      loadingFailedParams.requestId = paramString1;
      loadingFailedParams.timestamp = stethoNow() / 1000.0D;
      loadingFailedParams.errorText = paramString2;
      loadingFailedParams.type = Page.ResourceType.OTHER;
      networkPeerManager.sendNotificationToPeers("Network.loadingFailed", loadingFailedParams);
    } 
  }
  
  private void loadingFinished(String paramString) {
    NetworkPeerManager networkPeerManager = getPeerManagerIfEnabled();
    if (networkPeerManager != null) {
      Network.LoadingFinishedParams loadingFinishedParams = new Network.LoadingFinishedParams();
      loadingFinishedParams.requestId = paramString;
      loadingFinishedParams.timestamp = stethoNow() / 1000.0D;
      networkPeerManager.sendNotificationToPeers("Network.loadingFinished", loadingFinishedParams);
    } 
  }
  
  @Nullable
  private static String readBodyAsString(NetworkPeerManager paramNetworkPeerManager, NetworkEventReporter.InspectorRequest paramInspectorRequest) {
    try {
      byte[] arrayOfByte = paramInspectorRequest.body();
      if (arrayOfByte != null)
        return new String(arrayOfByte, Utf8Charset.INSTANCE); 
    } catch (IOException iOException) {
      Console.MessageLevel messageLevel = Console.MessageLevel.WARNING;
      Console.MessageSource messageSource = Console.MessageSource.NETWORK;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not reproduce POST body: ");
      stringBuilder.append(iOException);
      CLog.writeToConsole(paramNetworkPeerManager, messageLevel, messageSource, stringBuilder.toString());
    } catch (OutOfMemoryError outOfMemoryError) {}
    return null;
  }
  
  private static long stethoNow() {
    return SystemClock.elapsedRealtime();
  }
  
  public void dataReceived(String paramString, int paramInt1, int paramInt2) {
    NetworkPeerManager networkPeerManager = getPeerManagerIfEnabled();
    if (networkPeerManager != null) {
      Network.DataReceivedParams dataReceivedParams = new Network.DataReceivedParams();
      dataReceivedParams.requestId = paramString;
      dataReceivedParams.timestamp = stethoNow() / 1000.0D;
      dataReceivedParams.dataLength = paramInt1;
      dataReceivedParams.encodedDataLength = paramInt2;
      networkPeerManager.sendNotificationToPeers("Network.dataReceived", dataReceivedParams);
    } 
  }
  
  public void dataSent(String paramString, int paramInt1, int paramInt2) {
    dataReceived(paramString, paramInt1, paramInt2);
  }
  
  public void httpExchangeFailed(String paramString1, String paramString2) {
    loadingFailed(paramString1, paramString2);
  }
  
  public InputStream interpretResponseStream(String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable InputStream paramInputStream, ResponseHandler paramResponseHandler) {
    NetworkPeerManager networkPeerManager = getPeerManagerIfEnabled();
    if (networkPeerManager != null) {
      Page.ResourceType resourceType = null;
      if (paramInputStream == null) {
        paramResponseHandler.onEOF();
        return null;
      } 
      if (paramString2 != null)
        resourceType = getResourceTypeHelper().determineResourceType(paramString2); 
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (resourceType != null) {
        bool1 = bool2;
        if (resourceType == Page.ResourceType.IMAGE)
          bool1 = true; 
      } 
      try {
        return DecompressionHelper.teeInputWithDecompression(networkPeerManager, paramString1, paramInputStream, networkPeerManager.getResponseBodyFileManager().openResponseBodyFile(paramString1, bool1), paramString3, paramResponseHandler);
      } catch (IOException iOException) {
        Console.MessageLevel messageLevel = Console.MessageLevel.ERROR;
        Console.MessageSource messageSource = Console.MessageSource.NETWORK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Error writing response body data for request #");
        stringBuilder.append(paramString1);
        CLog.writeToConsole(networkPeerManager, messageLevel, messageSource, stringBuilder.toString());
      } 
    } 
    return paramInputStream;
  }
  
  public boolean isEnabled() {
    return (getPeerManagerIfEnabled() != null);
  }
  
  public String nextRequestId() {
    return String.valueOf(this.mNextRequestId.getAndIncrement());
  }
  
  public void requestWillBeSent(NetworkEventReporter.InspectorRequest paramInspectorRequest) {
    NetworkPeerManager networkPeerManager = getPeerManagerIfEnabled();
    if (networkPeerManager != null) {
      boolean bool;
      Network.Request request = new Network.Request();
      request.url = paramInspectorRequest.url();
      request.method = paramInspectorRequest.method();
      request.headers = formatHeadersAsJSON(paramInspectorRequest);
      request.postData = readBodyAsString(networkPeerManager, paramInspectorRequest);
      String str = paramInspectorRequest.friendlyName();
      Integer integer = paramInspectorRequest.friendlyNameExtra();
      Network.Initiator initiator = new Network.Initiator();
      initiator.type = Network.InitiatorType.SCRIPT;
      initiator.stackTrace = new ArrayList();
      List<Console.CallFrame> list = initiator.stackTrace;
      if (integer != null) {
        bool = integer.intValue();
      } else {
        bool = false;
      } 
      list.add(new Console.CallFrame(str, str, bool, 0));
      Network.RequestWillBeSentParams requestWillBeSentParams = new Network.RequestWillBeSentParams();
      requestWillBeSentParams.requestId = paramInspectorRequest.id();
      requestWillBeSentParams.frameId = "1";
      requestWillBeSentParams.loaderId = "1";
      requestWillBeSentParams.documentURL = paramInspectorRequest.url();
      requestWillBeSentParams.request = request;
      requestWillBeSentParams.timestamp = stethoNow() / 1000.0D;
      requestWillBeSentParams.initiator = initiator;
      requestWillBeSentParams.redirectResponse = null;
      requestWillBeSentParams.type = Page.ResourceType.OTHER;
      networkPeerManager.sendNotificationToPeers("Network.requestWillBeSent", requestWillBeSentParams);
    } 
  }
  
  public void responseHeadersReceived(NetworkEventReporter.InspectorResponse paramInspectorResponse) {
    NetworkPeerManager networkPeerManager = getPeerManagerIfEnabled();
    if (networkPeerManager != null) {
      String str1;
      Network.Response response = new Network.Response();
      response.url = paramInspectorResponse.url();
      response.status = paramInspectorResponse.statusCode();
      response.statusText = paramInspectorResponse.reasonPhrase();
      response.headers = formatHeadersAsJSON(paramInspectorResponse);
      String str2 = getContentType(paramInspectorResponse);
      if (str2 != null) {
        str1 = getResourceTypeHelper().stripContentExtras(str2);
      } else {
        str1 = "application/octet-stream";
      } 
      response.mimeType = str1;
      response.connectionReused = paramInspectorResponse.connectionReused();
      response.connectionId = paramInspectorResponse.connectionId();
      response.fromDiskCache = Boolean.valueOf(paramInspectorResponse.fromDiskCache());
      Network.ResponseReceivedParams responseReceivedParams = new Network.ResponseReceivedParams();
      responseReceivedParams.requestId = paramInspectorResponse.requestId();
      responseReceivedParams.frameId = "1";
      responseReceivedParams.loaderId = "1";
      responseReceivedParams.timestamp = stethoNow() / 1000.0D;
      responseReceivedParams.response = response;
      responseReceivedParams.type = determineResourceType(initAsyncPrettyPrinterForResponse(paramInspectorResponse, networkPeerManager), str2, getResourceTypeHelper());
      networkPeerManager.sendNotificationToPeers("Network.responseReceived", responseReceivedParams);
    } 
  }
  
  public void responseReadFailed(String paramString1, String paramString2) {
    loadingFailed(paramString1, paramString2);
  }
  
  public void responseReadFinished(String paramString) {
    loadingFinished(paramString);
  }
  
  public void webSocketClosed(String paramString) {
    NetworkPeerManager networkPeerManager = getPeerManagerIfEnabled();
    if (networkPeerManager != null) {
      Network.WebSocketClosedParams webSocketClosedParams = new Network.WebSocketClosedParams();
      webSocketClosedParams.requestId = paramString;
      webSocketClosedParams.timestamp = stethoNow() / 1000.0D;
      networkPeerManager.sendNotificationToPeers("Network.webSocketClosed", webSocketClosedParams);
    } 
  }
  
  public void webSocketCreated(String paramString1, String paramString2) {
    NetworkPeerManager networkPeerManager = getPeerManagerIfEnabled();
    if (networkPeerManager != null) {
      Network.WebSocketCreatedParams webSocketCreatedParams = new Network.WebSocketCreatedParams();
      webSocketCreatedParams.requestId = paramString1;
      webSocketCreatedParams.url = paramString2;
      networkPeerManager.sendNotificationToPeers("Network.webSocketCreated", webSocketCreatedParams);
    } 
  }
  
  public void webSocketFrameError(String paramString1, String paramString2) {
    NetworkPeerManager networkPeerManager = getPeerManagerIfEnabled();
    if (networkPeerManager != null) {
      Network.WebSocketFrameErrorParams webSocketFrameErrorParams = new Network.WebSocketFrameErrorParams();
      webSocketFrameErrorParams.requestId = paramString1;
      webSocketFrameErrorParams.timestamp = stethoNow() / 1000.0D;
      webSocketFrameErrorParams.errorMessage = paramString2;
      networkPeerManager.sendNotificationToPeers("Network.webSocketFrameError", webSocketFrameErrorParams);
    } 
  }
  
  public void webSocketFrameReceived(NetworkEventReporter.InspectorWebSocketFrame paramInspectorWebSocketFrame) {
    NetworkPeerManager networkPeerManager = getPeerManagerIfEnabled();
    if (networkPeerManager != null) {
      Network.WebSocketFrameReceivedParams webSocketFrameReceivedParams = new Network.WebSocketFrameReceivedParams();
      webSocketFrameReceivedParams.requestId = paramInspectorWebSocketFrame.requestId();
      webSocketFrameReceivedParams.timestamp = stethoNow() / 1000.0D;
      webSocketFrameReceivedParams.response = convertFrame(paramInspectorWebSocketFrame);
      networkPeerManager.sendNotificationToPeers("Network.webSocketFrameReceived", webSocketFrameReceivedParams);
    } 
  }
  
  public void webSocketFrameSent(NetworkEventReporter.InspectorWebSocketFrame paramInspectorWebSocketFrame) {
    NetworkPeerManager networkPeerManager = getPeerManagerIfEnabled();
    if (networkPeerManager != null) {
      Network.WebSocketFrameSentParams webSocketFrameSentParams = new Network.WebSocketFrameSentParams();
      webSocketFrameSentParams.requestId = paramInspectorWebSocketFrame.requestId();
      webSocketFrameSentParams.timestamp = stethoNow() / 1000.0D;
      webSocketFrameSentParams.response = convertFrame(paramInspectorWebSocketFrame);
      networkPeerManager.sendNotificationToPeers("Network.webSocketFrameSent", webSocketFrameSentParams);
    } 
  }
  
  public void webSocketHandshakeResponseReceived(NetworkEventReporter.InspectorWebSocketResponse paramInspectorWebSocketResponse) {
    if (getPeerManagerIfEnabled() != null) {
      Network.WebSocketHandshakeResponseReceivedParams webSocketHandshakeResponseReceivedParams = new Network.WebSocketHandshakeResponseReceivedParams();
      webSocketHandshakeResponseReceivedParams.requestId = paramInspectorWebSocketResponse.requestId();
      webSocketHandshakeResponseReceivedParams.timestamp = stethoNow() / 1000.0D;
      Network.WebSocketResponse webSocketResponse = new Network.WebSocketResponse();
      webSocketResponse.headers = formatHeadersAsJSON(paramInspectorWebSocketResponse);
      webSocketResponse.headersText = null;
      if (paramInspectorWebSocketResponse.requestHeaders() != null) {
        webSocketResponse.requestHeaders = formatHeadersAsJSON(paramInspectorWebSocketResponse.requestHeaders());
        webSocketResponse.requestHeadersText = null;
      } 
      webSocketResponse.status = paramInspectorWebSocketResponse.statusCode();
      webSocketResponse.statusText = paramInspectorWebSocketResponse.reasonPhrase();
      webSocketHandshakeResponseReceivedParams.response = webSocketResponse;
    } 
  }
  
  public void webSocketWillSendHandshakeRequest(NetworkEventReporter.InspectorWebSocketRequest paramInspectorWebSocketRequest) {
    NetworkPeerManager networkPeerManager = getPeerManagerIfEnabled();
    if (networkPeerManager != null) {
      Network.WebSocketWillSendHandshakeRequestParams webSocketWillSendHandshakeRequestParams = new Network.WebSocketWillSendHandshakeRequestParams();
      webSocketWillSendHandshakeRequestParams.requestId = paramInspectorWebSocketRequest.id();
      webSocketWillSendHandshakeRequestParams.timestamp = stethoNow() / 1000.0D;
      webSocketWillSendHandshakeRequestParams.wallTime = System.currentTimeMillis() / 1000.0D;
      Network.WebSocketRequest webSocketRequest = new Network.WebSocketRequest();
      webSocketRequest.headers = formatHeadersAsJSON(paramInspectorWebSocketRequest);
      webSocketWillSendHandshakeRequestParams.request = webSocketRequest;
      networkPeerManager.sendNotificationToPeers("Network.webSocketWillSendHandshakeRequest", webSocketWillSendHandshakeRequestParams);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\network\NetworkEventReporterImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */