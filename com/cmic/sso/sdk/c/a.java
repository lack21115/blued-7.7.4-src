package com.cmic.sso.sdk.c;

import com.cmic.sso.sdk.b.a.f;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends f {
  public static ArrayList<Throwable> a = new ArrayList<Throwable>();
  
  private String A = null;
  
  private String B = null;
  
  private String C = null;
  
  private String D;
  
  private String E = null;
  
  private String F = null;
  
  private String b = null;
  
  private String c = null;
  
  private String d = null;
  
  private String e = null;
  
  private String f = null;
  
  private String g = null;
  
  private String h = null;
  
  private String i = null;
  
  private String j = null;
  
  private String k = null;
  
  private String l = null;
  
  private String m = null;
  
  private String n = null;
  
  private String o = null;
  
  private String p = null;
  
  private JSONArray q = null;
  
  private String r = null;
  
  private String s = null;
  
  private String t = null;
  
  private String u = null;
  
  private String v = null;
  
  private String w = null;
  
  private String x = null;
  
  private String y = null;
  
  private JSONObject z = null;
  
  public void A(String paramString) {
    this.A = paramString;
  }
  
  public void B(String paramString) {
    this.e = paramString;
  }
  
  public void C(String paramString) {
    this.s = paramString;
  }
  
  public void D(String paramString) {
    this.F = paramString;
  }
  
  public JSONObject a() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("traceId", this.b);
      jSONObject.put("requestTime", this.h);
      jSONObject.put("responseTime", this.i);
      jSONObject.put("requestType", this.k);
      jSONObject.put("loginType", this.p);
      jSONObject.put("sdkVersion", this.e);
      jSONObject.put("networkType", this.s);
      jSONObject.put("networkClass", this.t);
      jSONObject.put("reqDevice", this.v);
      jSONObject.put("reqSystem", this.w);
      jSONObject.put("operatorType", this.r);
      jSONObject.put("simCardNum", this.x);
      jSONObject.put("exceptionStackTrace", this.q);
      jSONObject.put("appName", this.c);
      jSONObject.put("appVersion", this.d);
      jSONObject.put("interfaceCode", this.m);
      jSONObject.put("interfaceType", this.l);
      jSONObject.put("interfaceElasped", this.n);
      jSONObject.put("event", this.z);
      jSONObject.put("appid", this.A);
      jSONObject.put("brand", this.u);
      jSONObject.put("resultCode", this.y);
      jSONObject.put("is_root", this.B);
      jSONObject.put("imsiState", this.C);
      jSONObject.put("elapsedTime", this.j);
      jSONObject.put("loginTime", this.o);
      jSONObject.put("clientType", this.f);
      jSONObject.put("timeOut", this.g);
      jSONObject.put("is_phoneStatePermission", this.D);
      jSONObject.put("AID", this.E);
      jSONObject.put("sysOperType", this.F);
      return jSONObject;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return jSONObject;
    } 
  }
  
  public void a(String paramString) {
    this.D = paramString;
  }
  
  public void a(JSONArray paramJSONArray) {
    this.q = paramJSONArray;
  }
  
  public void a(JSONObject paramJSONObject) {
    this.z = paramJSONObject;
  }
  
  public void b(String paramString) {
    this.E = paramString;
  }
  
  public void c(String paramString) {
    this.C = paramString;
  }
  
  public void d(String paramString) {
    this.B = paramString;
  }
  
  public void e(String paramString) {
    this.y = paramString;
  }
  
  public void f(String paramString) {
    this.m = paramString;
  }
  
  public void g(String paramString) {
    this.n = paramString;
  }
  
  public void h(String paramString) {
    this.o = paramString;
  }
  
  public void i(String paramString) {
    this.u = paramString;
  }
  
  public void j(String paramString) {
    this.l = paramString;
  }
  
  public void k(String paramString) {
    this.j = paramString;
  }
  
  public void l(String paramString) {
    this.f = paramString;
  }
  
  public void m(String paramString) {
    this.g = paramString;
  }
  
  public void o(String paramString) {
    this.c = paramString;
  }
  
  public void p(String paramString) {
    this.d = paramString;
  }
  
  public void q(String paramString) {
    this.x = paramString;
  }
  
  public void r(String paramString) {
    this.r = paramString;
  }
  
  public void s(String paramString) {
    this.v = paramString;
  }
  
  public void t(String paramString) {
    this.w = paramString;
  }
  
  public void u(String paramString) {
    this.p = paramString;
  }
  
  public void v(String paramString) {
    this.b = paramString;
  }
  
  public void w(String paramString) {
    this.h = paramString;
  }
  
  public void x(String paramString) {
    this.t = paramString;
  }
  
  public void y(String paramString) {
    this.i = paramString;
  }
  
  public void z(String paramString) {
    this.k = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sdk\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */