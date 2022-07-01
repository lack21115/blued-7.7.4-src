package com.facebook.stetho.inspector.jsonrpc;

import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError;

public class JsonRpcException extends Exception {
  private final JsonRpcError mErrorMessage;
  
  public JsonRpcException(JsonRpcError paramJsonRpcError) {
    super(stringBuilder.toString());
    this.mErrorMessage = (JsonRpcError)Util.throwIfNull(paramJsonRpcError);
  }
  
  public JsonRpcError getErrorMessage() {
    return this.mErrorMessage;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\jsonrpc\JsonRpcException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */