package com.facebook.stetho.inspector.jsonrpc.protocol;

import com.facebook.stetho.json.annotation.JsonProperty;
import org.json.JSONObject;

public class JsonRpcResponse {
  @JsonProperty
  public JSONObject error;
  
  @JsonProperty(required = true)
  public long id;
  
  @JsonProperty
  public JSONObject result;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\jsonrpc\protocol\JsonRpcResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */