package com.bytedance.sdk.a.b.a.a;

import com.bytedance.sdk.a.b.a.c.d;
import com.bytedance.sdk.a.b.a.c.e;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.d;
import com.bytedance.sdk.a.b.r;
import com.bytedance.sdk.a.b.y;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class c {
  public final y a;
  
  public final aa b;
  
  c(y paramy, aa paramaa) {
    this.a = paramy;
    this.b = paramaa;
  }
  
  public static boolean a(aa paramaa, y paramy) {
    int i = paramaa.c();
    boolean bool2 = false;
    if (i != 200 && i != 410 && i != 414 && i != 501 && i != 203 && i != 204)
      if (i != 307) {
        if (i != 308 && i != 404 && i != 405)
          switch (i) {
            default:
              return false;
            case 302:
              if (paramaa.a("Expires") != null || paramaa.j().c() != -1 || paramaa.j().e() || paramaa.j().d())
                break; 
              return false;
            case 300:
            case 301:
              break;
          }  
      } else {
      
      }  
    boolean bool1 = bool2;
    if (!paramaa.j().b()) {
      bool1 = bool2;
      if (!paramy.f().b())
        bool1 = true; 
    } 
    return bool1;
  }
  
  public static class a {
    final long a;
    
    final y b;
    
    final aa c;
    
    private Date d;
    
    private String e;
    
    private Date f;
    
    private String g;
    
    private Date h;
    
    private long i;
    
    private long j;
    
    private String k;
    
    private int l = -1;
    
    public a(long param1Long, y param1y, aa param1aa) {
      this.a = param1Long;
      this.b = param1y;
      this.c = param1aa;
      if (param1aa != null) {
        this.i = param1aa.k();
        this.j = param1aa.l();
        r r = param1aa.f();
        int i = 0;
        int j = r.a();
        while (i < j) {
          String str1 = r.a(i);
          String str2 = r.b(i);
          if ("Date".equalsIgnoreCase(str1)) {
            this.d = d.a(str2);
            this.e = str2;
          } else if ("Expires".equalsIgnoreCase(str1)) {
            this.h = d.a(str2);
          } else if ("Last-Modified".equalsIgnoreCase(str1)) {
            this.f = d.a(str2);
            this.g = str2;
          } else if ("ETag".equalsIgnoreCase(str1)) {
            this.k = str2;
          } else if ("Age".equalsIgnoreCase(str1)) {
            this.l = e.b(str2, -1);
          } 
          i++;
        } 
      } 
    }
    
    private static boolean a(y param1y) {
      return (param1y.a("If-Modified-Since") != null || param1y.a("If-None-Match") != null);
    }
    
    private c b() {
      if (this.c == null)
        return new c(this.b, null); 
      if (this.b.g() && this.c.e() == null)
        return new c(this.b, null); 
      if (!c.a(this.c, this.b))
        return new c(this.b, null); 
      d d1 = this.b.f();
      if (d1.a() || a(this.b))
        return new c(this.b, null); 
      d d2 = this.c.j();
      if (d2.j())
        return new c(null, this.c); 
      long l5 = d();
      long l2 = c();
      long l1 = l2;
      if (d1.c() != -1)
        l1 = Math.min(l2, TimeUnit.SECONDS.toMillis(d1.c())); 
      int i = d1.h();
      long l4 = 0L;
      if (i != -1) {
        l2 = TimeUnit.SECONDS.toMillis(d1.h());
      } else {
        l2 = 0L;
      } 
      long l3 = l4;
      if (!d2.f()) {
        l3 = l4;
        if (d1.g() != -1)
          l3 = TimeUnit.SECONDS.toMillis(d1.g()); 
      } 
      if (!d2.a()) {
        l2 += l5;
        if (l2 < l3 + l1) {
          aa.a a2 = this.c.h();
          if (l2 >= l1)
            a2.a("Warning", "110 HttpURLConnection \"Response is stale\""); 
          if (l5 > 86400000L && e())
            a2.a("Warning", "113 HttpURLConnection \"Heuristic expiration\""); 
          return new c(null, a2.a());
        } 
      } 
      String str1 = this.k;
      String str2 = "If-Modified-Since";
      if (str1 != null) {
        str2 = "If-None-Match";
      } else if (this.f != null) {
        str1 = this.g;
      } else {
        if (this.d != null) {
          str1 = this.e;
          r.a a2 = this.b.c().b();
          com.bytedance.sdk.a.b.a.a.a.a(a2, str2, str1);
          return new c(this.b.e().a(a2.a()).d(), this.c);
        } 
        return new c(this.b, null);
      } 
      r.a a1 = this.b.c().b();
      com.bytedance.sdk.a.b.a.a.a.a(a1, str2, str1);
      return new c(this.b.e().a(a1.a()).d(), this.c);
    }
    
    private long c() {
      d d = this.c.j();
      if (d.c() != -1)
        return TimeUnit.SECONDS.toMillis(d.c()); 
      Date date = this.h;
      long l1 = 0L;
      if (date != null) {
        date = this.d;
        if (date != null) {
          l = date.getTime();
        } else {
          l = this.j;
        } 
        long l = this.h.getTime() - l;
        if (l > 0L)
          l1 = l; 
        return l1;
      } 
      long l2 = l1;
      if (this.f != null) {
        l2 = l1;
        if (this.c.a().a().k() == null) {
          date = this.d;
          if (date != null) {
            l2 = date.getTime();
          } else {
            l2 = this.i;
          } 
          long l = l2 - this.f.getTime();
          l2 = l1;
          if (l > 0L)
            l2 = l / 10L; 
        } 
      } 
      return l2;
    }
    
    private long d() {
      Date date = this.d;
      long l1 = 0L;
      if (date != null)
        l1 = Math.max(0L, this.j - date.getTime()); 
      long l2 = l1;
      if (this.l != -1)
        l2 = Math.max(l1, TimeUnit.SECONDS.toMillis(this.l)); 
      l1 = this.j;
      return l2 + l1 - this.i + this.a - l1;
    }
    
    private boolean e() {
      return (this.c.j().c() == -1 && this.h == null);
    }
    
    public c a() {
      c c2 = b();
      c c1 = c2;
      if (c2.a != null) {
        c1 = c2;
        if (this.b.f().i())
          c1 = new c(null, null); 
      } 
      return c1;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */