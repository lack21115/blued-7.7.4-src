package com.bytedance.sdk.a.b;

import java.io.Closeable;

public final class aa implements Closeable {
  final y a;
  
  final w b;
  
  final int c;
  
  final String d;
  
  final q e;
  
  final r f;
  
  final ab g;
  
  final aa h;
  
  final aa i;
  
  final aa j;
  
  final long k;
  
  final long l;
  
  private volatile d m;
  
  aa(a parama) {
    this.a = parama.a;
    this.b = parama.b;
    this.c = parama.c;
    this.d = parama.d;
    this.e = parama.e;
    this.f = parama.f.a();
    this.g = parama.g;
    this.h = parama.h;
    this.i = parama.i;
    this.j = parama.j;
    this.k = parama.k;
    this.l = parama.l;
  }
  
  public y a() {
    return this.a;
  }
  
  public String a(String paramString) {
    return a(paramString, null);
  }
  
  public String a(String paramString1, String paramString2) {
    paramString1 = this.f.a(paramString1);
    return (paramString1 != null) ? paramString1 : paramString2;
  }
  
  public w b() {
    return this.b;
  }
  
  public int c() {
    return this.c;
  }
  
  public void close() {
    ab ab1 = this.g;
    if (ab1 != null) {
      ab1.close();
      return;
    } 
    throw new IllegalStateException("response is not eligible for a body and must not be closed");
  }
  
  public String d() {
    return this.d;
  }
  
  public q e() {
    return this.e;
  }
  
  public r f() {
    return this.f;
  }
  
  public ab g() {
    return this.g;
  }
  
  public a h() {
    return new a(this);
  }
  
  public aa i() {
    return this.j;
  }
  
  public d j() {
    d d1 = this.m;
    if (d1 != null)
      return d1; 
    d1 = d.a(this.f);
    this.m = d1;
    return d1;
  }
  
  public long k() {
    return this.k;
  }
  
  public long l() {
    return this.l;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Response{protocol=");
    stringBuilder.append(this.b);
    stringBuilder.append(", code=");
    stringBuilder.append(this.c);
    stringBuilder.append(", message=");
    stringBuilder.append(this.d);
    stringBuilder.append(", url=");
    stringBuilder.append(this.a.a());
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  public static class a {
    y a;
    
    w b;
    
    int c = -1;
    
    String d;
    
    q e;
    
    r.a f;
    
    ab g;
    
    aa h;
    
    aa i;
    
    aa j;
    
    long k;
    
    long l;
    
    public a() {
      this.f = new r.a();
    }
    
    a(aa param1aa) {
      this.a = param1aa.a;
      this.b = param1aa.b;
      this.c = param1aa.c;
      this.d = param1aa.d;
      this.e = param1aa.e;
      this.f = param1aa.f.b();
      this.g = param1aa.g;
      this.h = param1aa.h;
      this.i = param1aa.i;
      this.j = param1aa.j;
      this.k = param1aa.k;
      this.l = param1aa.l;
    }
    
    private void a(String param1String, aa param1aa) {
      if (param1aa.g == null) {
        if (param1aa.h == null) {
          if (param1aa.i == null) {
            if (param1aa.j == null)
              return; 
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(param1String);
            stringBuilder3.append(".priorResponse != null");
            throw new IllegalArgumentException(stringBuilder3.toString());
          } 
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append(param1String);
          stringBuilder2.append(".cacheResponse != null");
          throw new IllegalArgumentException(stringBuilder2.toString());
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(param1String);
        stringBuilder1.append(".networkResponse != null");
        throw new IllegalArgumentException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(param1String);
      stringBuilder.append(".body != null");
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    private void d(aa param1aa) {
      if (param1aa.g == null)
        return; 
      throw new IllegalArgumentException("priorResponse.body != null");
    }
    
    public a a(int param1Int) {
      this.c = param1Int;
      return this;
    }
    
    public a a(long param1Long) {
      this.k = param1Long;
      return this;
    }
    
    public a a(aa param1aa) {
      if (param1aa != null)
        a("networkResponse", param1aa); 
      this.h = param1aa;
      return this;
    }
    
    public a a(ab param1ab) {
      this.g = param1ab;
      return this;
    }
    
    public a a(q param1q) {
      this.e = param1q;
      return this;
    }
    
    public a a(r param1r) {
      this.f = param1r.b();
      return this;
    }
    
    public a a(w param1w) {
      this.b = param1w;
      return this;
    }
    
    public a a(y param1y) {
      this.a = param1y;
      return this;
    }
    
    public a a(String param1String) {
      this.d = param1String;
      return this;
    }
    
    public a a(String param1String1, String param1String2) {
      this.f.a(param1String1, param1String2);
      return this;
    }
    
    public aa a() {
      if (this.a != null) {
        if (this.b != null) {
          if (this.c >= 0) {
            if (this.d != null)
              return new aa(this); 
            throw new IllegalStateException("message == null");
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("code < 0: ");
          stringBuilder.append(this.c);
          throw new IllegalStateException(stringBuilder.toString());
        } 
        throw new IllegalStateException("protocol == null");
      } 
      throw new IllegalStateException("request == null");
    }
    
    public a b(long param1Long) {
      this.l = param1Long;
      return this;
    }
    
    public a b(aa param1aa) {
      if (param1aa != null)
        a("cacheResponse", param1aa); 
      this.i = param1aa;
      return this;
    }
    
    public a c(aa param1aa) {
      if (param1aa != null)
        d(param1aa); 
      this.j = param1aa;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */