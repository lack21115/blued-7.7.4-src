package com.cmic.sso.sdk.b.a;

import org.json.JSONException;
import org.json.JSONObject;

public class a extends f {
  private String a;
  
  private String b;
  
  private String c;
  
  private String d;
  
  private String e;
  
  private String f;
  
  private String g;
  
  private String h;
  
  private String i;
  
  private String j;
  
  private String k;
  
  private JSONObject l;
  
  private String m;
  
  public JSONObject a() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("version", this.a);
      jSONObject.put("msgid", this.b);
      jSONObject.put("appid", this.c);
      jSONObject.put("scrip", this.d);
      jSONObject.put("sign", this.e);
      jSONObject.put("interfacever", this.f);
      jSONObject.put("userCapaid", this.g);
      jSONObject.put("clienttype", this.h);
      jSONObject.put("sourceid", this.i);
      jSONObject.put("authenticated_appid", this.j);
      jSONObject.put("genTokenByAppid", this.k);
      jSONObject.put("rcData", this.l);
      return jSONObject;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return jSONObject;
    } 
  }
  
  public void a(String paramString) {
    this.h = paramString;
  }
  
  public void a(JSONObject paramJSONObject) {
    this.l = paramJSONObject;
  }
  
  public void b(String paramString) {
    this.i = paramString;
  }
  
  public void c(String paramString) {
    this.m = paramString;
  }
  
  public void d(String paramString) {
    this.f = paramString;
  }
  
  public void e(String paramString) {
    this.g = paramString;
  }
  
  public void f(String paramString) {
    this.a = paramString;
  }
  
  public void g(String paramString) {
    this.b = paramString;
  }
  
  public void h(String paramString) {
    this.c = paramString;
  }
  
  public void i(String paramString) {
    this.d = paramString;
  }
  
  public void j(String paramString) {
    this.e = paramString;
  }
  
  public void k(String paramString) {
    this.j = paramString;
  }
  
  public void l(String paramString) {
    this.k = paramString;
  }
  
  public String m(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.a);
    stringBuilder.append(this.c);
    stringBuilder.append(paramString);
    stringBuilder.append(this.d);
    return n(stringBuilder.toString());
  }
  
  public String toString() {
    return a().toString();
  }
  
  public static class a {
    private String a;
    
    private String b;
    
    private String c;
    
    private String d;
    
    private String e;
    
    private String f;
    
    private String g;
    
    private String h;
    
    private String i;
    
    private String j;
    
    private String k;
    
    public JSONObject a() {
      JSONObject jSONObject = new JSONObject();
      try {
        jSONObject.put("phone_id", this.a);
        jSONObject.put("os", this.b);
        jSONObject.put("dev_model", this.c);
        jSONObject.put("dev_brand", this.d);
        jSONObject.put("mnc", this.e);
        jSONObject.put("client_type", this.f);
        jSONObject.put("network_type", this.g);
        jSONObject.put("ipv4_list", this.h);
        jSONObject.put("ipv6_list", this.i);
        jSONObject.put("is_cert", this.j);
        jSONObject.put("is_root", this.k);
        return jSONObject;
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
        return jSONObject;
      } 
    }
    
    public void a(String param1String) {
      this.a = param1String;
    }
    
    public void b(String param1String) {
      this.b = param1String;
    }
    
    public void c(String param1String) {
      this.c = param1String;
    }
    
    public void d(String param1String) {
      this.d = param1String;
    }
    
    public void e(String param1String) {
      this.e = param1String;
    }
    
    public void f(String param1String) {
      this.f = param1String;
    }
    
    public void g(String param1String) {
      this.g = param1String;
    }
    
    public void h(String param1String) {
      this.h = param1String;
    }
    
    public void i(String param1String) {
      this.i = param1String;
    }
    
    public void j(String param1String) {
      this.j = param1String;
    }
    
    public void k(String param1String) {
      this.k = param1String;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sdk\b\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */