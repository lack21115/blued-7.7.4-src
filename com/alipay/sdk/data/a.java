package com.alipay.sdk.data;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.sys.b;
import com.alipay.sdk.util.c;
import com.alipay.sdk.util.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
  private static a F;
  
  private static final String b = "DynCon";
  
  private static final int c = 10000;
  
  private static final String d = "https://h5.m.taobao.com/mlapp/olist.html";
  
  private static final int e = 10;
  
  private static final boolean f = true;
  
  private static final boolean g = true;
  
  private static final boolean h = false;
  
  private static final boolean i = false;
  
  private static final int j = 1000;
  
  private static final int k = 20000;
  
  private static final String l = "alipay_cashier_dynamic_config";
  
  private static final String m = "timeout";
  
  private static final String n = "h5_port_degrade";
  
  private static final String o = "st_sdk_config";
  
  private static final String p = "tbreturl";
  
  private static final String q = "launchAppSwitch";
  
  private static final String r = "configQueryInterval";
  
  private static final String s = "deg_log_mcgw";
  
  private static final String t = "deg_start_srv_first";
  
  private static final String u = "scheme_pay_2";
  
  private static final String v = "intercept_batch";
  
  private boolean A = true;
  
  private boolean B = true;
  
  private boolean C = false;
  
  private boolean D = false;
  
  private List<a> E = null;
  
  public boolean a = false;
  
  private int w = 10000;
  
  private boolean x = false;
  
  private String y = "https://h5.m.taobao.com/mlapp/olist.html";
  
  private int z = 10;
  
  private void a(com.alipay.sdk.sys.a parama) {
    try {
      JSONObject jSONObject = l();
      j.a(parama, b.a().b(), "alipay_cashier_dynamic_config", jSONObject.toString());
      return;
    } catch (Exception exception) {
      c.a(exception);
      return;
    } 
  }
  
  private void a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    try {
      return;
    } finally {
      paramString = null;
      c.a((Throwable)paramString);
    } 
  }
  
  private void a(JSONObject paramJSONObject) {
    this.w = paramJSONObject.optInt("timeout", 10000);
    this.x = paramJSONObject.optBoolean("h5_port_degrade", false);
    this.y = paramJSONObject.optString("tbreturl", "https://h5.m.taobao.com/mlapp/olist.html").trim();
    this.z = paramJSONObject.optInt("configQueryInterval", 10);
    this.E = a.a(paramJSONObject.optJSONArray("launchAppSwitch"));
    this.A = paramJSONObject.optBoolean("scheme_pay_2", true);
    this.B = paramJSONObject.optBoolean("intercept_batch", true);
    this.C = paramJSONObject.optBoolean("deg_log_mcgw", false);
    this.D = paramJSONObject.optBoolean("deg_start_srv_first", false);
  }
  
  private void b(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    try {
      JSONObject jSONObject = (new JSONObject(paramString)).optJSONObject("st_sdk_config");
      return;
    } finally {
      paramString = null;
      c.a((Throwable)paramString);
    } 
  }
  
  public static a j() {
    if (F == null) {
      F = new a();
      F.k();
    } 
    return F;
  }
  
  private void k() {
    Context context = b.a().b();
    a(j.b(com.alipay.sdk.sys.a.a(), context, "alipay_cashier_dynamic_config", null));
  }
  
  private JSONObject l() throws JSONException {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("timeout", a());
    jSONObject.put("h5_port_degrade", b());
    jSONObject.put("tbreturl", e());
    jSONObject.put("configQueryInterval", f());
    jSONObject.put("launchAppSwitch", a.a(i()));
    jSONObject.put("scheme_pay_2", c());
    jSONObject.put("intercept_batch", d());
    jSONObject.put("deg_log_mcgw", g());
    jSONObject.put("deg_start_srv_first", h());
    return jSONObject;
  }
  
  public int a() {
    int i = this.w;
    if (i < 1000 || i > 20000) {
      c.a("DynCon", "time(def) = 10000");
      return 10000;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("time = ");
    stringBuilder.append(this.w);
    c.a("DynCon", stringBuilder.toString());
    return this.w;
  }
  
  public void a(com.alipay.sdk.sys.a parama, Context paramContext) {
    (new Thread(new b(this, parama, paramContext))).start();
  }
  
  public void a(boolean paramBoolean) {
    this.a = paramBoolean;
  }
  
  public boolean b() {
    return this.x;
  }
  
  public boolean c() {
    return this.A;
  }
  
  public boolean d() {
    return this.B;
  }
  
  public String e() {
    return this.y;
  }
  
  public int f() {
    return this.z;
  }
  
  public boolean g() {
    return this.C;
  }
  
  public boolean h() {
    return this.D;
  }
  
  public List<a> i() {
    return this.E;
  }
  
  public static final class a {
    public final String a;
    
    public final int b;
    
    public final String c;
    
    public a(String param1String1, int param1Int, String param1String2) {
      this.a = param1String1;
      this.b = param1Int;
      this.c = param1String2;
    }
    
    public static a a(JSONObject param1JSONObject) {
      return (param1JSONObject == null) ? null : new a(param1JSONObject.optString("pn"), param1JSONObject.optInt("v", 0), param1JSONObject.optString("pk"));
    }
    
    public static List<a> a(JSONArray param1JSONArray) {
      if (param1JSONArray == null)
        return null; 
      ArrayList<a> arrayList = new ArrayList();
      int j = param1JSONArray.length();
      for (int i = 0; i < j; i++) {
        a a1 = a(param1JSONArray.optJSONObject(i));
        if (a1 != null)
          arrayList.add(a1); 
      } 
      return arrayList;
    }
    
    public static JSONArray a(List<a> param1List) {
      if (param1List == null)
        return null; 
      JSONArray jSONArray = new JSONArray();
      Iterator<a> iterator = param1List.iterator();
      while (iterator.hasNext())
        jSONArray.put(a(iterator.next())); 
      return jSONArray;
    }
    
    public static JSONObject a(a param1a) {
      if (param1a == null)
        return null; 
      try {
        return (new JSONObject()).put("pn", param1a.a).put("v", param1a.b).put("pk", param1a.c);
      } catch (JSONException jSONException) {
        c.a((Throwable)jSONException);
        return null;
      } 
    }
    
    public String toString() {
      return String.valueOf(a(this));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\data\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */