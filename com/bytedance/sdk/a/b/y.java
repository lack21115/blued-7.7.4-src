package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.a.c;
import com.bytedance.sdk.a.b.a.c.f;
import java.net.URL;

public final class y {
  final s a;
  
  final String b;
  
  final r c;
  
  final z d;
  
  final Object e;
  
  private volatile d f;
  
  y(a parama) {
    Object object;
    this.a = parama.a;
    this.b = parama.b;
    this.c = parama.c.a();
    this.d = parama.d;
    if (parama.e != null) {
      object = parama.e;
    } else {
      object = this;
    } 
    this.e = object;
  }
  
  public s a() {
    return this.a;
  }
  
  public String a(String paramString) {
    return this.c.a(paramString);
  }
  
  public String b() {
    return this.b;
  }
  
  public r c() {
    return this.c;
  }
  
  public z d() {
    return this.d;
  }
  
  public a e() {
    return new a(this);
  }
  
  public d f() {
    d d1 = this.f;
    if (d1 != null)
      return d1; 
    d1 = d.a(this.c);
    this.f = d1;
    return d1;
  }
  
  public boolean g() {
    return this.a.c();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Request{method=");
    stringBuilder.append(this.b);
    stringBuilder.append(", url=");
    stringBuilder.append(this.a);
    stringBuilder.append(", tag=");
    Object object = this.e;
    if (object == this)
      object = null; 
    stringBuilder.append(object);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  public static class a {
    s a;
    
    String b;
    
    r.a c;
    
    z d;
    
    Object e;
    
    public a() {
      this.b = "GET";
      this.c = new r.a();
    }
    
    a(y param1y) {
      this.a = param1y.a;
      this.b = param1y.b;
      this.d = param1y.d;
      this.e = param1y.e;
      this.c = param1y.c.b();
    }
    
    public a a() {
      return a("GET", (z)null);
    }
    
    public a a(r param1r) {
      this.c = param1r.b();
      return this;
    }
    
    public a a(s param1s) {
      if (param1s != null) {
        this.a = param1s;
        return this;
      } 
      throw new NullPointerException("url == null");
    }
    
    public a a(z param1z) {
      return a("POST", param1z);
    }
    
    public a a(String param1String) {
      this.c.b(param1String);
      return this;
    }
    
    public a a(String param1String, z param1z) {
      if (param1String != null) {
        if (param1String.length() != 0) {
          if (param1z == null || f.c(param1String)) {
            if (param1z != null || !f.b(param1String)) {
              this.b = param1String;
              this.d = param1z;
              return this;
            } 
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("method ");
            stringBuilder1.append(param1String);
            stringBuilder1.append(" must have a request body.");
            throw new IllegalArgumentException(stringBuilder1.toString());
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("method ");
          stringBuilder.append(param1String);
          stringBuilder.append(" must not have a request body.");
          throw new IllegalArgumentException(stringBuilder.toString());
        } 
        throw new IllegalArgumentException("method.length() == 0");
      } 
      throw new NullPointerException("method == null");
    }
    
    public a a(String param1String1, String param1String2) {
      this.c.c(param1String1, param1String2);
      return this;
    }
    
    public a a(URL param1URL) {
      if (param1URL != null) {
        s s1 = s.a(param1URL);
        if (s1 != null)
          return a(s1); 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unexpected url: ");
        stringBuilder.append(param1URL);
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      throw new NullPointerException("url == null");
    }
    
    public a b() {
      return a("HEAD", (z)null);
    }
    
    public a b(z param1z) {
      return a("DELETE", param1z);
    }
    
    public a b(String param1String1, String param1String2) {
      this.c.a(param1String1, param1String2);
      return this;
    }
    
    public a c() {
      return b(c.d);
    }
    
    public a c(z param1z) {
      return a("PUT", param1z);
    }
    
    public a d(z param1z) {
      return a("PATCH", param1z);
    }
    
    public y d() {
      if (this.a != null)
        return new y(this); 
      throw new IllegalStateException("url == null");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */