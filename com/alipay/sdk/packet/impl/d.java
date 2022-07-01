package com.alipay.sdk.packet.impl;

import android.content.Context;
import com.alipay.sdk.packet.b;
import com.alipay.sdk.packet.e;
import com.alipay.sdk.sys.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends e {
  public static final String t = "log_v";
  
  public b a(a parama, Context paramContext, String paramString) throws Throwable {
    return a(parama, paramContext, paramString, "https://mcgw.alipay.com/sdklog.do", true);
  }
  
  public String a(a parama, String paramString, JSONObject paramJSONObject) {
    return paramString;
  }
  
  public Map<String, String> a(boolean paramBoolean, String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("msp-gzip", String.valueOf(paramBoolean));
    hashMap.put("content-type", "application/octet-stream");
    hashMap.put("des-mode", "CBC");
    return (Map)hashMap;
  }
  
  public JSONObject a() throws JSONException {
    return null;
  }
  
  public String c() throws JSONException {
    HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
    hashMap1.put("api_name", "/sdk/log");
    hashMap1.put("api_version", "1.0.0");
    HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
    hashMap2.put("log_v", "1.0");
    return a(hashMap1, hashMap2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\packet\impl\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */