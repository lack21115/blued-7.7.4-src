package com.facebook.stetho.inspector.protocol.module;

import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.json.annotation.JsonProperty;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

public class HeapProfiler implements ChromeDevtoolsDomain {
  @ChromeDevtoolsMethod
  public JsonRpcResult getProfileHeaders(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {
    ProfileHeaderResponse profileHeaderResponse = new ProfileHeaderResponse();
    profileHeaderResponse.headers = Collections.emptyList();
    return profileHeaderResponse;
  }
  
  static class ProfileHeader {
    @JsonProperty(required = true)
    public String title;
    
    @JsonProperty(required = true)
    public int uid;
  }
  
  static class ProfileHeaderResponse implements JsonRpcResult {
    @JsonProperty(required = true)
    public List<HeapProfiler.ProfileHeader> headers;
    
    private ProfileHeaderResponse() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\protocol\module\HeapProfiler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */