package com.facebook.stetho.inspector.protocol.module;

import android.content.Context;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcException;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError;
import com.facebook.stetho.inspector.network.AsyncPrettyPrinterInitializer;
import com.facebook.stetho.inspector.network.NetworkPeerManager;
import com.facebook.stetho.inspector.network.ResponseBodyData;
import com.facebook.stetho.inspector.network.ResponseBodyFileManager;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.json.annotation.JsonProperty;
import com.facebook.stetho.json.annotation.JsonValue;
import java.io.IOException;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class Network implements ChromeDevtoolsDomain {
  private final NetworkPeerManager mNetworkPeerManager;
  
  private final ResponseBodyFileManager mResponseBodyFileManager;
  
  public Network(Context paramContext) {
    this.mNetworkPeerManager = NetworkPeerManager.getOrCreateInstance(paramContext);
    this.mResponseBodyFileManager = this.mNetworkPeerManager.getResponseBodyFileManager();
  }
  
  private GetResponseBodyResponse readResponseBody(String paramString) throws IOException, JsonRpcException {
    GetResponseBodyResponse getResponseBodyResponse = new GetResponseBodyResponse();
    try {
      ResponseBodyData responseBodyData = this.mResponseBodyFileManager.readFile(paramString);
      getResponseBodyResponse.body = responseBodyData.data;
      getResponseBodyResponse.base64Encoded = responseBodyData.base64Encoded;
      return getResponseBodyResponse;
    } catch (OutOfMemoryError outOfMemoryError) {
      throw new JsonRpcException(new JsonRpcError(JsonRpcError.ErrorCode.INTERNAL_ERROR, outOfMemoryError.toString(), null));
    } 
  }
  
  @ChromeDevtoolsMethod
  public void disable(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {
    this.mNetworkPeerManager.removePeer(paramJsonRpcPeer);
  }
  
  @ChromeDevtoolsMethod
  public void enable(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {
    this.mNetworkPeerManager.addPeer(paramJsonRpcPeer);
  }
  
  @ChromeDevtoolsMethod
  public JsonRpcResult getResponseBody(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) throws JsonRpcException {
    try {
      return readResponseBody(paramJSONObject.getString("requestId"));
    } catch (IOException iOException) {
      throw new JsonRpcException(new JsonRpcError(JsonRpcError.ErrorCode.INTERNAL_ERROR, iOException.toString(), null));
    } catch (JSONException jSONException) {
      throw new JsonRpcException(new JsonRpcError(JsonRpcError.ErrorCode.INTERNAL_ERROR, jSONException.toString(), null));
    } 
  }
  
  public void setPrettyPrinterInitializer(AsyncPrettyPrinterInitializer paramAsyncPrettyPrinterInitializer) {
    Util.throwIfNull(paramAsyncPrettyPrinterInitializer);
    this.mNetworkPeerManager.setPrettyPrinterInitializer(paramAsyncPrettyPrinterInitializer);
  }
  
  @ChromeDevtoolsMethod
  public void setUserAgentOverride(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {}
  
  public static class DataReceivedParams {
    @JsonProperty(required = true)
    public int dataLength;
    
    @JsonProperty(required = true)
    public int encodedDataLength;
    
    @JsonProperty(required = true)
    public String requestId;
    
    @JsonProperty(required = true)
    public double timestamp;
  }
  
  static class GetResponseBodyResponse implements JsonRpcResult {
    @JsonProperty(required = true)
    public boolean base64Encoded;
    
    @JsonProperty(required = true)
    public String body;
    
    private GetResponseBodyResponse() {}
  }
  
  public static class Initiator {
    @JsonProperty
    public List<Console.CallFrame> stackTrace;
    
    @JsonProperty(required = true)
    public Network.InitiatorType type;
  }
  
  public enum InitiatorType {
    OTHER,
    PARSER("parser"),
    SCRIPT("script");
    
    private final String mProtocolValue;
    
    static {
      $VALUES = new InitiatorType[] { PARSER, SCRIPT, OTHER };
    }
    
    InitiatorType(String param1String1) {
      this.mProtocolValue = param1String1;
    }
    
    @JsonValue
    public String getProtocolValue() {
      return this.mProtocolValue;
    }
  }
  
  public static class LoadingFailedParams {
    @JsonProperty(required = true)
    public String errorText;
    
    @JsonProperty(required = true)
    public String requestId;
    
    @JsonProperty(required = true)
    public double timestamp;
    
    @JsonProperty
    public Page.ResourceType type;
  }
  
  public static class LoadingFinishedParams {
    @JsonProperty(required = true)
    public String requestId;
    
    @JsonProperty(required = true)
    public double timestamp;
  }
  
  public static class Request {
    @JsonProperty(required = true)
    public JSONObject headers;
    
    @JsonProperty(required = true)
    public String method;
    
    @JsonProperty
    public String postData;
    
    @JsonProperty(required = true)
    public String url;
  }
  
  public static class RequestWillBeSentParams {
    @JsonProperty(required = true)
    public String documentURL;
    
    @JsonProperty(required = true)
    public String frameId;
    
    @JsonProperty(required = true)
    public Network.Initiator initiator;
    
    @JsonProperty(required = true)
    public String loaderId;
    
    @JsonProperty
    public Network.Response redirectResponse;
    
    @JsonProperty(required = true)
    public Network.Request request;
    
    @JsonProperty(required = true)
    public String requestId;
    
    @JsonProperty(required = true)
    public double timestamp;
    
    @JsonProperty
    public Page.ResourceType type;
  }
  
  public static class ResourceTiming {
    @JsonProperty(required = true)
    public double connectionEnd;
    
    @JsonProperty(required = true)
    public double connectionStart;
    
    @JsonProperty(required = true)
    public double dnsEnd;
    
    @JsonProperty(required = true)
    public double dnsStart;
    
    @JsonProperty(required = true)
    public double proxyEnd;
    
    @JsonProperty(required = true)
    public double proxyStart;
    
    @JsonProperty(required = true)
    public double receivedHeadersEnd;
    
    @JsonProperty(required = true)
    public double requestTime;
    
    @JsonProperty(required = true)
    public double sendEnd;
    
    @JsonProperty(required = true)
    public double sendStart;
    
    @JsonProperty(required = true)
    public double sslEnd;
    
    @JsonProperty(required = true)
    public double sslStart;
  }
  
  public static class Response {
    @JsonProperty(required = true)
    public int connectionId;
    
    @JsonProperty(required = true)
    public boolean connectionReused;
    
    @JsonProperty(required = true)
    public Boolean fromDiskCache;
    
    @JsonProperty(required = true)
    public JSONObject headers;
    
    @JsonProperty
    public String headersText;
    
    @JsonProperty(required = true)
    public String mimeType;
    
    @JsonProperty
    public JSONObject requestHeaders;
    
    @JsonProperty
    public String requestHeadersTest;
    
    @JsonProperty(required = true)
    public int status;
    
    @JsonProperty(required = true)
    public String statusText;
    
    @JsonProperty
    public Network.ResourceTiming timing;
    
    @JsonProperty(required = true)
    public String url;
  }
  
  public static class ResponseReceivedParams {
    @JsonProperty(required = true)
    public String frameId;
    
    @JsonProperty(required = true)
    public String loaderId;
    
    @JsonProperty(required = true)
    public String requestId;
    
    @JsonProperty(required = true)
    public Network.Response response;
    
    @JsonProperty(required = true)
    public double timestamp;
    
    @JsonProperty(required = true)
    public Page.ResourceType type;
  }
  
  public static class WebSocketClosedParams {
    @JsonProperty(required = true)
    public String requestId;
    
    @JsonProperty(required = true)
    public double timestamp;
  }
  
  public static class WebSocketCreatedParams {
    @JsonProperty(required = true)
    public String requestId;
    
    @JsonProperty(required = true)
    public String url;
  }
  
  public static class WebSocketFrame {
    @JsonProperty(required = true)
    public boolean mask;
    
    @JsonProperty(required = true)
    public int opcode;
    
    @JsonProperty(required = true)
    public String payloadData;
  }
  
  public static class WebSocketFrameErrorParams {
    @JsonProperty(required = true)
    public String errorMessage;
    
    @JsonProperty(required = true)
    public String requestId;
    
    @JsonProperty(required = true)
    public double timestamp;
  }
  
  public static class WebSocketFrameReceivedParams {
    @JsonProperty(required = true)
    public String requestId;
    
    @JsonProperty(required = true)
    public Network.WebSocketFrame response;
    
    @JsonProperty(required = true)
    public double timestamp;
  }
  
  public static class WebSocketFrameSentParams {
    @JsonProperty(required = true)
    public String requestId;
    
    @JsonProperty(required = true)
    public Network.WebSocketFrame response;
    
    @JsonProperty(required = true)
    public double timestamp;
  }
  
  public static class WebSocketHandshakeResponseReceivedParams {
    @JsonProperty(required = true)
    public String requestId;
    
    @JsonProperty(required = true)
    public Network.WebSocketResponse response;
    
    @JsonProperty(required = true)
    public double timestamp;
  }
  
  public static class WebSocketRequest {
    @JsonProperty(required = true)
    public JSONObject headers;
  }
  
  public static class WebSocketResponse {
    @JsonProperty(required = true)
    public JSONObject headers;
    
    @JsonProperty
    public String headersText;
    
    @JsonProperty
    public JSONObject requestHeaders;
    
    @JsonProperty
    public String requestHeadersText;
    
    @JsonProperty(required = true)
    public int status;
    
    @JsonProperty(required = true)
    public String statusText;
  }
  
  public static class WebSocketWillSendHandshakeRequestParams {
    @JsonProperty(required = true)
    public Network.WebSocketRequest request;
    
    @JsonProperty(required = true)
    public String requestId;
    
    @JsonProperty(required = true)
    public double timestamp;
    
    @JsonProperty(required = true)
    public double wallTime;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\protocol\module\Network.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */