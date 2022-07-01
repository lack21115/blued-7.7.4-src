package com.facebook.stetho.inspector.jsonrpc.protocol;

import com.facebook.stetho.json.annotation.JsonProperty;
import com.facebook.stetho.json.annotation.JsonValue;
import javax.annotation.Nullable;
import org.json.JSONObject;

public class JsonRpcError {
  @JsonProperty(required = true)
  public ErrorCode code;
  
  @JsonProperty
  public JSONObject data;
  
  @JsonProperty(required = true)
  public String message;
  
  public JsonRpcError() {}
  
  public JsonRpcError(ErrorCode paramErrorCode, String paramString, @Nullable JSONObject paramJSONObject) {
    this.code = paramErrorCode;
    this.message = paramString;
    this.data = paramJSONObject;
  }
  
  public enum ErrorCode {
    INTERNAL_ERROR,
    INVALID_PARAMS,
    INVALID_REQUEST,
    METHOD_NOT_FOUND,
    PARSER_ERROR(-32700);
    
    private final int mProtocolValue;
    
    static {
      INVALID_PARAMS = new ErrorCode("INVALID_PARAMS", 3, -32602);
      INTERNAL_ERROR = new ErrorCode("INTERNAL_ERROR", 4, -32603);
      $VALUES = new ErrorCode[] { PARSER_ERROR, INVALID_REQUEST, METHOD_NOT_FOUND, INVALID_PARAMS, INTERNAL_ERROR };
    }
    
    ErrorCode(int param1Int1) {
      this.mProtocolValue = param1Int1;
    }
    
    @JsonValue
    public int getProtocolValue() {
      return this.mProtocolValue;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\jsonrpc\protocol\JsonRpcError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */