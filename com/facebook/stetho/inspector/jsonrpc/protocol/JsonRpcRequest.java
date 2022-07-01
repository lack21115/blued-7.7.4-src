package com.facebook.stetho.inspector.jsonrpc.protocol;

import com.facebook.stetho.json.annotation.JsonProperty;
import org.json.JSONObject;

public class JsonRpcRequest {
  @JsonProperty
  public Long id;
  
  @JsonProperty(required = true)
  public String method;
  
  @JsonProperty
  public JSONObject params;
  
  public JsonRpcRequest() {}
  
  public JsonRpcRequest(Long paramLong, String paramString, JSONObject paramJSONObject) {
    this.id = paramLong;
    this.method = paramString;
    this.params = paramJSONObject;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\jsonrpc\protocol\JsonRpcRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */