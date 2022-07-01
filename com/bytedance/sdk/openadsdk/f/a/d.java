package com.bytedance.sdk.openadsdk.f.a;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.w;
import com.bytedance.sdk.openadsdk.utils.x;
import org.json.JSONObject;

public class d<T extends d> implements b {
  private String a;
  
  private String b;
  
  private String c;
  
  private String d = "2.9.5.6";
  
  private String e;
  
  private long f = System.currentTimeMillis() / 1000L;
  
  private int g = 0;
  
  private String h;
  
  private int i = 0;
  
  private String j;
  
  private String k;
  
  private String l;
  
  private String m;
  
  public static d<d> b() {
    return new d<d>();
  }
  
  private JSONObject p() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("os", 1);
      jSONObject.put("imei", j.d(o.a()));
      jSONObject.put("oaid", x.a());
      return jSONObject;
    } catch (Exception exception) {
      return jSONObject;
    } 
  }
  
  private T q() {
    return (T)this;
  }
  
  public T a(int paramInt) {
    this.g = paramInt;
    return q();
  }
  
  public T a(String paramString) {
    this.a = paramString;
    return q();
  }
  
  public JSONObject a() {
    JSONObject jSONObject = new JSONObject();
    try {
      if (!TextUtils.isEmpty(c()))
        jSONObject.put("type", c()); 
      if (!TextUtils.isEmpty(e()))
        jSONObject.put("rit", e()); 
      if (!TextUtils.isEmpty(f()))
        jSONObject.put("creative_id", f()); 
      if (!TextUtils.isEmpty(g()))
        jSONObject.put("ad_sdk_version", g()); 
      boolean bool = TextUtils.isEmpty(h());
      if (!bool) {
        jSONObject.put("app_version", h());
      } else {
        jSONObject.put("app_version", ah.f());
      } 
      if (i() > 0L)
        jSONObject.put("timestamp", i()); 
      if (j() > 0)
        jSONObject.put("adtype", j()); 
      if (!TextUtils.isEmpty(k()))
        jSONObject.put("req_id", k()); 
      jSONObject.put("error_code", l());
      if (!TextUtils.isEmpty(m()))
        jSONObject.put("error_msg", m()); 
      if (!TextUtils.isEmpty(n()))
        jSONObject.put("extra", n()); 
      if (!TextUtils.isEmpty(o()))
        jSONObject.put("image_url", o()); 
      if (!TextUtils.isEmpty(d()))
        jSONObject.put("event_extra", d()); 
      jSONObject.put("conn_type", w.b(o.a()));
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    try {
      return jSONObject;
    } finally {
      Exception exception = null;
    } 
  }
  
  public T b(int paramInt) {
    this.i = paramInt;
    return q();
  }
  
  public T b(String paramString) {
    this.m = paramString;
    return q();
  }
  
  public T c(long paramLong) {
    this.f = paramLong;
    return q();
  }
  
  public T c(String paramString) {
    this.b = paramString;
    return q();
  }
  
  public String c() {
    return this.a;
  }
  
  public T d(String paramString) {
    this.c = paramString;
    return q();
  }
  
  public String d() {
    return this.m;
  }
  
  public T e(String paramString) {
    this.d = paramString;
    return q();
  }
  
  public String e() {
    return this.b;
  }
  
  public T f(String paramString) {
    this.h = paramString;
    return q();
  }
  
  public String f() {
    return this.c;
  }
  
  public T g(String paramString) {
    this.j = paramString;
    return q();
  }
  
  public String g() {
    return this.d;
  }
  
  public T h(String paramString) {
    this.k = paramString;
    return q();
  }
  
  public String h() {
    return this.e;
  }
  
  public long i() {
    return this.f;
  }
  
  public T i(String paramString) {
    this.l = paramString;
    return q();
  }
  
  public int j() {
    return this.g;
  }
  
  public String k() {
    return this.h;
  }
  
  public int l() {
    return this.i;
  }
  
  public String m() {
    return this.j;
  }
  
  public String n() {
    return this.k;
  }
  
  public String o() {
    return this.l;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\f\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */