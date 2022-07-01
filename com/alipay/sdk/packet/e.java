package com.alipay.sdk.packet;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.app.i;
import com.alipay.sdk.data.c;
import com.alipay.sdk.net.a;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.sys.b;
import com.alipay.sdk.tid.b;
import com.alipay.sdk.util.b;
import com.alipay.sdk.util.c;
import com.alipay.sdk.util.m;
import com.alipay.sdk.util.n;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class e {
  public static final String a = "msp-gzip";
  
  public static final String b = "Msp-Param";
  
  public static final String c = "Operation-Type";
  
  public static final String d = "content-type";
  
  public static final String e = "Version";
  
  public static final String f = "AppId";
  
  public static final String g = "des-mode";
  
  public static final String h = "namespace";
  
  public static final String i = "api_name";
  
  public static final String j = "api_version";
  
  public static final String k = "data";
  
  public static final String l = "params";
  
  public static final String m = "public_key";
  
  public static final String n = "device";
  
  public static final String o = "action";
  
  public static final String p = "type";
  
  public static final String q = "method";
  
  protected boolean r = true;
  
  protected boolean s = true;
  
  protected static String a(a.b paramb, String paramString) {
    if (paramb != null) {
      if (paramString == null)
        return null; 
      if (paramb.a == null)
        return null; 
      List list = (List)paramb.a.get(paramString);
      return (list == null) ? null : TextUtils.join(",", list);
    } 
    return null;
  }
  
  public static JSONObject a(String paramString1, String paramString2) throws JSONException {
    JSONObject jSONObject1 = new JSONObject();
    JSONObject jSONObject2 = new JSONObject();
    jSONObject2.put("type", paramString1);
    jSONObject2.put("method", paramString2);
    jSONObject1.put("action", jSONObject2);
    return jSONObject1;
  }
  
  protected static boolean a(a.b paramb) {
    return Boolean.valueOf(a(paramb, "msp-gzip")).booleanValue();
  }
  
  private static boolean a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return false; 
    try {
      JSONObject jSONObject = (new JSONObject(paramString)).getJSONObject("data");
      if (!jSONObject.has("params"))
        return false; 
      String str = jSONObject.getJSONObject("params").optString("public_key", null);
      if (!TextUtils.isEmpty(str)) {
        c.a(str);
        return true;
      } 
    } catch (JSONException jSONException) {
      c.a((Throwable)jSONException);
    } 
    return false;
  }
  
  public b a(a parama, Context paramContext) throws Throwable {
    return a(parama, paramContext, "");
  }
  
  public b a(a parama, Context paramContext, String paramString) throws Throwable {
    return a(parama, paramContext, paramString, m.a(paramContext));
  }
  
  public b a(a parama, Context paramContext, String paramString1, String paramString2) throws Throwable {
    return a(parama, paramContext, paramString1, paramString2, true);
  }
  
  protected b a(a parama, Context paramContext, String paramString1, String paramString2, boolean paramBoolean) throws Throwable {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Packet: ");
    stringBuilder.append(paramString2);
    c.a("mspl", stringBuilder.toString());
    c c = new c(this.s);
    b b1 = new b(c(), a(parama, paramString1, a()));
    Map<String, String> map = a(false, paramString1);
    d d = c.a(b1, this.r, map.get("iSr"));
    a.b b = a.a(paramContext, new a.a(paramString2, a(d.a(), paramString1), d.b()));
    if (b != null) {
      b b3 = c.a(new d(a(b), b.c), map.get("iSr"));
      b b2 = b3;
      if (b3 != null) {
        b2 = b3;
        if (a(b3.a())) {
          b2 = b3;
          if (paramBoolean)
            b2 = a(parama, paramContext, paramString1, paramString2, false); 
        } 
      } 
      return b2;
    } 
    throw new RuntimeException("Response is null.");
  }
  
  protected String a(a parama, String paramString, JSONObject paramJSONObject) {
    b b = b.a();
    b b1 = b.a(b.b());
    paramJSONObject = b.a(new JSONObject(), paramJSONObject);
    try {
      paramJSONObject.put("tid", b1.a());
      paramJSONObject.put("user_agent", b.c().a(parama, b1));
      paramJSONObject.put("has_alipay", n.b(parama, b.b(), i.a));
      paramJSONObject.put("has_msp_app", n.a(b.b()));
      paramJSONObject.put("external_info", paramString);
      paramJSONObject.put("app_key", "2014052600006128");
      paramJSONObject.put("utdid", b.e());
      paramJSONObject.put("new_client_key", b1.b());
      paramJSONObject.put("pa", c.a(b.b()));
    } finally {
      parama = null;
    } 
  }
  
  protected String a(HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2) throws JSONException {
    JSONObject jSONObject1 = new JSONObject();
    JSONObject jSONObject2 = new JSONObject();
    if (paramHashMap1 != null)
      for (Map.Entry<String, String> entry : paramHashMap1.entrySet())
        jSONObject2.put((String)entry.getKey(), entry.getValue());  
    if (paramHashMap2 != null) {
      JSONObject jSONObject = new JSONObject();
      for (Map.Entry<String, String> entry : paramHashMap2.entrySet())
        jSONObject.put((String)entry.getKey(), entry.getValue()); 
      jSONObject2.put("params", jSONObject);
    } 
    jSONObject1.put("data", jSONObject2);
    return jSONObject1.toString();
  }
  
  protected Map<String, String> a(boolean paramBoolean, String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("msp-gzip", String.valueOf(paramBoolean));
    hashMap.put("Operation-Type", "alipay.msp.cashier.dispatch.bytes");
    hashMap.put("content-type", "application/octet-stream");
    hashMap.put("Version", "2.0");
    hashMap.put("AppId", "TAOBAO");
    hashMap.put("Msp-Param", a.a(paramString));
    hashMap.put("des-mode", "CBC");
    return (Map)hashMap;
  }
  
  protected abstract JSONObject a() throws JSONException;
  
  protected String b() {
    return "4.9.0";
  }
  
  protected String c() throws JSONException {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("device", Build.MODEL);
    hashMap.put("namespace", "com.alipay.mobilecashier");
    hashMap.put("api_name", "com.alipay.mcpay");
    hashMap.put("api_version", b());
    return a((HashMap)hashMap, new HashMap<String, String>());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\packet\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */