package com.facebook.stetho.inspector.protocol.module;

import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import org.json.JSONObject;

public class Worker implements ChromeDevtoolsDomain {
  @ChromeDevtoolsMethod
  public JsonRpcResult canInspectWorkers(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {
    return new SimpleBooleanResult(true);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\protocol\module\Worker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */