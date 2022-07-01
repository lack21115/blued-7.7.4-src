package com.cmic.sso.sdk.b.a;

import com.cmic.sso.sdk.utils.f;
import com.cmic.sso.sdk.utils.h;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends f {
  private a a;
  
  private String b;
  
  private String c;
  
  public JSONObject a() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("encrypted", this.c);
      jSONObject.put("reqdata", com.cmic.sso.sdk.utils.a.a(this.b, this.a.toString()));
      f.a("GETpre", this.a.toString());
      return jSONObject;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return jSONObject;
    } 
  }
  
  public void a(a parama) {
    this.a = parama;
  }
  
  public void a(String paramString) {
    this.b = paramString;
  }
  
  public a b() {
    return this.a;
  }
  
  public void b(String paramString) {
    this.c = paramString;
  }
  
  public static class a {
    private String A = "";
    
    private String B = "";
    
    private String C = "";
    
    private String D;
    
    private String a = "";
    
    private String b = "";
    
    private String c = "";
    
    private String d = "";
    
    private String e = "";
    
    private String f = "";
    
    private String g = "";
    
    private String h = "";
    
    private String i = "";
    
    private String j = "";
    
    private String k = "";
    
    private String l = "";
    
    private String m = "";
    
    private String n = "";
    
    private String o = "";
    
    private String p = "";
    
    private String q = "";
    
    private String r = "";
    
    private String s = "";
    
    private String t = "";
    
    private String u = "";
    
    private String v = "";
    
    private String w = "";
    
    private String x = "";
    
    private String y = "";
    
    private String z = "";
    
    private String x(String param1String) {
      String str = param1String;
      if (param1String == null)
        str = ""; 
      return str;
    }
    
    public void a(String param1String) {
      this.B = param1String;
    }
    
    public void b(String param1String) {
      this.C = param1String;
    }
    
    public void c(String param1String) {
      this.x = x(param1String);
    }
    
    public void d(String param1String) {
      this.y = x(param1String);
    }
    
    public void e(String param1String) {
      this.a = x(param1String);
    }
    
    public void f(String param1String) {
      this.b = x(param1String);
    }
    
    public void g(String param1String) {
      this.c = x(param1String);
    }
    
    public void h(String param1String) {
      this.d = x(param1String);
    }
    
    public void i(String param1String) {
      this.e = x(param1String);
    }
    
    public void j(String param1String) {
      this.f = x(param1String);
    }
    
    public void k(String param1String) {
      this.g = x(param1String);
    }
    
    public void l(String param1String) {
      this.h = x(param1String);
    }
    
    public void m(String param1String) {
      this.i = x(param1String);
    }
    
    public void n(String param1String) {
      param1String = x(param1String);
      try {
        this.j = URLEncoder.encode(param1String, "UTF-8");
        return;
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        unsupportedEncodingException.printStackTrace();
        this.j = param1String;
        return;
      } 
    }
    
    public void o(String param1String) {
      param1String = x(param1String);
      try {
        this.k = URLEncoder.encode(param1String, "UTF-8");
        return;
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        unsupportedEncodingException.printStackTrace();
        this.k = param1String;
        return;
      } 
    }
    
    public void p(String param1String) {
      this.l = x(param1String);
    }
    
    public void q(String param1String) {
      this.m = x(param1String);
    }
    
    public void r(String param1String) {
      this.o = x(param1String);
    }
    
    public void s(String param1String) {
      this.p = x(param1String);
    }
    
    public void t(String param1String) {
      this.z = x(param1String);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.a);
      stringBuilder.append("&");
      stringBuilder.append(this.b);
      stringBuilder.append("&");
      stringBuilder.append(this.c);
      stringBuilder.append("&");
      stringBuilder.append(this.d);
      stringBuilder.append("&");
      stringBuilder.append(this.e);
      stringBuilder.append("&");
      stringBuilder.append(this.f);
      stringBuilder.append("&");
      stringBuilder.append(this.g);
      stringBuilder.append("&");
      stringBuilder.append(this.h);
      stringBuilder.append("&");
      stringBuilder.append(this.i);
      stringBuilder.append("&");
      stringBuilder.append(this.j);
      stringBuilder.append("&");
      stringBuilder.append(this.k);
      stringBuilder.append("&");
      stringBuilder.append(this.l);
      stringBuilder.append("&");
      stringBuilder.append(this.m);
      stringBuilder.append("&");
      stringBuilder.append("7.0");
      stringBuilder.append("&");
      stringBuilder.append(this.n);
      stringBuilder.append("&");
      stringBuilder.append(this.o);
      stringBuilder.append("&");
      stringBuilder.append(this.p);
      stringBuilder.append("&");
      stringBuilder.append(this.q);
      stringBuilder.append("&");
      stringBuilder.append(this.r);
      stringBuilder.append("&");
      stringBuilder.append(this.s);
      stringBuilder.append("&");
      stringBuilder.append(this.t);
      stringBuilder.append("&");
      stringBuilder.append(this.u);
      stringBuilder.append("&");
      stringBuilder.append(this.v);
      stringBuilder.append("&");
      stringBuilder.append(this.w);
      stringBuilder.append("&");
      stringBuilder.append(this.x);
      stringBuilder.append("&");
      stringBuilder.append(this.y);
      stringBuilder.append("&");
      stringBuilder.append(this.z);
      stringBuilder.append("&");
      stringBuilder.append(this.A);
      stringBuilder.append("&");
      stringBuilder.append(this.D);
      stringBuilder.append("&&");
      stringBuilder.append(this.B);
      stringBuilder.append("&");
      stringBuilder.append(this.C);
      return stringBuilder.toString();
    }
    
    public void u(String param1String) {
      this.A = x(param1String);
    }
    
    public void v(String param1String) {
      this.D = x(param1String);
    }
    
    public String w(String param1String) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.b);
      stringBuilder.append(this.c);
      stringBuilder.append(this.d);
      stringBuilder.append(this.e);
      stringBuilder.append(this.f);
      stringBuilder.append(this.g);
      stringBuilder.append(this.h);
      stringBuilder.append(this.i);
      stringBuilder.append(this.j);
      stringBuilder.append(this.k);
      stringBuilder.append(this.l);
      stringBuilder.append(this.m);
      stringBuilder.append(this.o);
      stringBuilder.append(this.p);
      stringBuilder.append(param1String);
      stringBuilder.append(this.q);
      stringBuilder.append(this.r);
      stringBuilder.append(this.s);
      stringBuilder.append(this.t);
      stringBuilder.append(this.u);
      stringBuilder.append(this.v);
      stringBuilder.append(this.w);
      stringBuilder.append(this.x);
      stringBuilder.append(this.y);
      stringBuilder.append(this.z);
      stringBuilder.append(this.A);
      stringBuilder.append(this.B);
      stringBuilder.append(this.C);
      return h.a(stringBuilder.toString());
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sdk\b\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */