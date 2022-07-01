package com.facebook.stetho.inspector;

import com.facebook.stetho.common.LogRedirector;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcException;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.PendingRequest;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcRequest;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcResponse;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.websocket.SimpleEndpoint;
import com.facebook.stetho.websocket.SimpleSession;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ChromeDevtoolsServer implements SimpleEndpoint {
  public static final String PATH = "/inspector";
  
  private static final String TAG = "ChromeDevtoolsServer";
  
  private final MethodDispatcher mMethodDispatcher;
  
  private final ObjectMapper mObjectMapper = new ObjectMapper();
  
  private final Map<SimpleSession, JsonRpcPeer> mPeers = Collections.synchronizedMap(new HashMap<SimpleSession, JsonRpcPeer>());
  
  public ChromeDevtoolsServer(Iterable<ChromeDevtoolsDomain> paramIterable) {
    this.mMethodDispatcher = new MethodDispatcher(this.mObjectMapper, paramIterable);
  }
  
  private void closeSafely(SimpleSession paramSimpleSession, int paramInt, String paramString) {
    paramSimpleSession.close(paramInt, paramString);
  }
  
  private void handleRemoteMessage(JsonRpcPeer paramJsonRpcPeer, String paramString) throws IOException, MessageHandlingException, JSONException {
    JSONObject jSONObject = new JSONObject(paramString);
    if (jSONObject.has("method")) {
      handleRemoteRequest(paramJsonRpcPeer, jSONObject);
      return;
    } 
    if (jSONObject.has("result")) {
      handleRemoteResponse(paramJsonRpcPeer, jSONObject);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Improper JSON-RPC message: ");
    stringBuilder.append(paramString);
    throw new MessageHandlingException(stringBuilder.toString());
  }
  
  private void handleRemoteRequest(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) throws MessageHandlingException {
    JSONObject jSONObject;
    JsonRpcRequest jsonRpcRequest = (JsonRpcRequest)this.mObjectMapper.convertValue(paramJSONObject, JsonRpcRequest.class);
    try {
      paramJSONObject = this.mMethodDispatcher.dispatch(paramJsonRpcPeer, jsonRpcRequest.method, jsonRpcRequest.params);
      jSONObject = null;
    } catch (JsonRpcException jsonRpcException) {
      logDispatchException(jsonRpcException);
      jSONObject = (JSONObject)this.mObjectMapper.convertValue(jsonRpcException.getErrorMessage(), JSONObject.class);
      jsonRpcException = null;
    } 
    if (jsonRpcRequest.id != null) {
      String str;
      JsonRpcResponse jsonRpcResponse = new JsonRpcResponse();
      jsonRpcResponse.id = jsonRpcRequest.id.longValue();
      jsonRpcResponse.result = (JSONObject)jsonRpcException;
      jsonRpcResponse.error = jSONObject;
      JSONObject jSONObject1 = (JSONObject)this.mObjectMapper.convertValue(jsonRpcResponse, JSONObject.class);
      try {
        str = jSONObject1.toString();
      } catch (OutOfMemoryError outOfMemoryError) {
        jsonRpcResponse.result = null;
        jsonRpcResponse.error = (JSONObject)this.mObjectMapper.convertValue(outOfMemoryError.getMessage(), JSONObject.class);
        str = ((JSONObject)this.mObjectMapper.convertValue(jsonRpcResponse, JSONObject.class)).toString();
      } 
      paramJsonRpcPeer.getWebSocket().sendText(str);
    } 
  }
  
  private void handleRemoteResponse(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) throws MismatchedResponseException {
    JsonRpcResponse jsonRpcResponse = (JsonRpcResponse)this.mObjectMapper.convertValue(paramJSONObject, JsonRpcResponse.class);
    PendingRequest pendingRequest = paramJsonRpcPeer.getAndRemovePendingRequest(jsonRpcResponse.id);
    if (pendingRequest != null) {
      if (pendingRequest.callback != null)
        pendingRequest.callback.onResponse(paramJsonRpcPeer, jsonRpcResponse); 
      return;
    } 
    throw new MismatchedResponseException(jsonRpcResponse.id);
  }
  
  private static void logDispatchException(JsonRpcException paramJsonRpcException) {
    JsonRpcError jsonRpcError = paramJsonRpcException.getErrorMessage();
    if (null.$SwitchMap$com$facebook$stetho$inspector$jsonrpc$protocol$JsonRpcError$ErrorCode[jsonRpcError.code.ordinal()] != 1) {
      LogRedirector.w("ChromeDevtoolsServer", "Error processing remote message", (Throwable)paramJsonRpcException);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Method not implemented: ");
    stringBuilder.append(jsonRpcError.message);
    LogRedirector.d("ChromeDevtoolsServer", stringBuilder.toString());
  }
  
  public void onClose(SimpleSession paramSimpleSession, int paramInt, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onClose: reason=");
    stringBuilder.append(paramInt);
    stringBuilder.append(" ");
    stringBuilder.append(paramString);
    LogRedirector.d("ChromeDevtoolsServer", stringBuilder.toString());
    JsonRpcPeer jsonRpcPeer = this.mPeers.remove(paramSimpleSession);
    if (jsonRpcPeer != null)
      jsonRpcPeer.invokeDisconnectReceivers(); 
  }
  
  public void onError(SimpleSession paramSimpleSession, Throwable paramThrowable) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onError: ex=");
    stringBuilder.append(paramThrowable.toString());
    LogRedirector.e("ChromeDevtoolsServer", stringBuilder.toString());
  }
  
  public void onMessage(SimpleSession paramSimpleSession, String paramString) {
    if (LogRedirector.isLoggable("ChromeDevtoolsServer", 2)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onMessage: message=");
      stringBuilder.append(paramString);
      LogRedirector.v("ChromeDevtoolsServer", stringBuilder.toString());
    } 
    try {
      JsonRpcPeer jsonRpcPeer = this.mPeers.get(paramSimpleSession);
      Util.throwIfNull(jsonRpcPeer);
      handleRemoteMessage(jsonRpcPeer, paramString);
      return;
    } catch (IOException iOException) {
      if (LogRedirector.isLoggable("ChromeDevtoolsServer", 2)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected I/O exception processing message: ");
        stringBuilder.append(iOException);
        LogRedirector.v("ChromeDevtoolsServer", stringBuilder.toString());
      } 
      closeSafely(paramSimpleSession, 1011, iOException.getClass().getSimpleName());
      return;
    } catch (MessageHandlingException messageHandlingException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Message could not be processed by implementation: ");
      stringBuilder.append(messageHandlingException);
      LogRedirector.i("ChromeDevtoolsServer", stringBuilder.toString());
      closeSafely(paramSimpleSession, 1011, messageHandlingException.getClass().getSimpleName());
      return;
    } catch (JSONException jSONException) {
      LogRedirector.v("ChromeDevtoolsServer", "Unexpected JSON exception processing message", (Throwable)jSONException);
      closeSafely(paramSimpleSession, 1011, jSONException.getClass().getSimpleName());
      return;
    } 
  }
  
  public void onMessage(SimpleSession paramSimpleSession, byte[] paramArrayOfbyte, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Ignoring binary message of length ");
    stringBuilder.append(paramInt);
    LogRedirector.d("ChromeDevtoolsServer", stringBuilder.toString());
  }
  
  public void onOpen(SimpleSession paramSimpleSession) {
    LogRedirector.d("ChromeDevtoolsServer", "onOpen");
    this.mPeers.put(paramSimpleSession, new JsonRpcPeer(this.mObjectMapper, paramSimpleSession));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\ChromeDevtoolsServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */