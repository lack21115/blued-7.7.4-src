package com.bytedance.sdk.a.b.a.a;

import com.bytedance.sdk.a.a.c;
import com.bytedance.sdk.a.a.d;
import com.bytedance.sdk.a.a.e;
import com.bytedance.sdk.a.a.l;
import com.bytedance.sdk.a.a.r;
import com.bytedance.sdk.a.a.s;
import com.bytedance.sdk.a.a.t;
import com.bytedance.sdk.a.b.a.c;
import com.bytedance.sdk.a.b.a.c.h;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.r;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.w;
import com.bytedance.sdk.a.b.y;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public final class a implements t {
  final e a;
  
  public a(e parame) {
    this.a = parame;
  }
  
  private aa a(b paramb, aa paramaa) throws IOException {
    if (paramb == null)
      return paramaa; 
    r r = paramb.a();
    if (r == null)
      return paramaa; 
    s s = new s(this, paramaa.g().b(), paramb, l.a(r)) {
        boolean a;
        
        public long a(c param1c, long param1Long) throws IOException {
          try {
            param1Long = this.b.a(param1c, param1Long);
            if (param1Long == -1L) {
              if (!this.a) {
                this.a = true;
                this.d.close();
              } 
              return -1L;
            } 
            param1c.a(this.d.c(), param1c.b() - param1Long, param1Long);
            this.d.u();
            return param1Long;
          } catch (IOException iOException) {
            if (!this.a) {
              this.a = true;
              this.c.b();
            } 
            throw iOException;
          } 
        }
        
        public t a() {
          return this.b.a();
        }
        
        public void close() throws IOException {
          if (!this.a && !c.a(this, 100, TimeUnit.MILLISECONDS)) {
            this.a = true;
            this.c.b();
          } 
          this.b.close();
        }
      };
    String str = paramaa.a("Content-Type");
    long l = paramaa.g().a();
    return paramaa.h().a((ab)new h(str, l, l.a(s))).a();
  }
  
  private static aa a(aa paramaa) {
    aa aa1 = paramaa;
    if (paramaa != null) {
      aa1 = paramaa;
      if (paramaa.g() != null)
        aa1 = paramaa.h().a(null).a(); 
    } 
    return aa1;
  }
  
  private static r a(r paramr1, r paramr2) {
    r.a a1 = new r.a();
    int j = paramr1.a();
    boolean bool = false;
    int i;
    for (i = 0; i < j; i++) {
      String str1 = paramr1.a(i);
      String str2 = paramr1.b(i);
      if ((!"Warning".equalsIgnoreCase(str1) || !str2.startsWith("1")) && (!a(str1) || paramr2.a(str1) == null))
        com.bytedance.sdk.a.b.a.a.a.a(a1, str1, str2); 
    } 
    j = paramr2.a();
    for (i = bool; i < j; i++) {
      String str = paramr2.a(i);
      if (!"Content-Length".equalsIgnoreCase(str) && a(str))
        com.bytedance.sdk.a.b.a.a.a.a(a1, str, paramr2.b(i)); 
    } 
    return a1.a();
  }
  
  static boolean a(String paramString) {
    return (!"Connection".equalsIgnoreCase(paramString) && !"Keep-Alive".equalsIgnoreCase(paramString) && !"Proxy-Authenticate".equalsIgnoreCase(paramString) && !"Proxy-Authorization".equalsIgnoreCase(paramString) && !"TE".equalsIgnoreCase(paramString) && !"Trailers".equalsIgnoreCase(paramString) && !"Transfer-Encoding".equalsIgnoreCase(paramString) && !"Upgrade".equalsIgnoreCase(paramString));
  }
  
  public aa a(t.a parama) throws IOException {
    e e1 = this.a;
    if (e1 != null) {
      aa aa1 = e1.a(parama.i());
    } else {
      e1 = null;
    } 
    c c = (new c.a(System.currentTimeMillis(), parama.i(), (aa)e1)).a();
    y y = c.a;
    aa aa = c.b;
    e e2 = this.a;
    if (e2 != null)
      e2.a(c); 
    if (e1 != null && aa == null)
      c.a((Closeable)e1.g()); 
    if (y == null && aa == null)
      return (new aa.a()).a(parama.i()).a(w.b).a(504).a("Unsatisfiable Request (only-if-cached)").a(c.c).a(-1L).b(System.currentTimeMillis()).a(); 
    if (y == null)
      return aa.h().b(a(aa)).a(); 
    try {
      aa aa1 = parama.a(y);
      if (aa1 == null && e1 != null)
        c.a((Closeable)e1.g()); 
      if (aa != null) {
        if (aa1.c() == 304) {
          aa aa2 = aa.h().a(a(aa.f(), aa1.f())).a(aa1.k()).b(aa1.l()).b(a(aa)).a(a(aa1)).a();
          aa1.g().close();
          this.a.a();
          return aa2;
        } 
        c.a((Closeable)aa.g());
      } 
      aa1 = aa1.h().b(a(aa)).a(a(aa1)).a();
      return aa1;
    } finally {
      if (iOException != null)
        c.a((Closeable)iOException.g()); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */