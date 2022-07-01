package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.a.c;
import com.bytedance.sdk.a.a.d;
import com.bytedance.sdk.a.a.g;
import com.bytedance.sdk.a.a.l;
import com.bytedance.sdk.a.a.r;
import com.bytedance.sdk.a.b.a.b.c;
import com.bytedance.sdk.a.b.a.b.g;
import com.bytedance.sdk.a.b.a.c;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.y;
import java.io.IOException;
import java.net.ProtocolException;

public final class b implements t {
  private final boolean a;
  
  public b(boolean paramBoolean) {
    this.a = paramBoolean;
  }
  
  public aa a(t.a parama) throws IOException {
    aa.a a1;
    g g1 = (g)parama;
    c c = g1.f();
    g g = g1.e();
    c c1 = (c)g1.a();
    y y = g1.i();
    long l = System.currentTimeMillis();
    g1.h().c(g1.g());
    c.a(y);
    g1.h().a(g1.g(), y);
    boolean bool = f.c(y.b());
    t.a a3 = null;
    aa.a a2 = null;
    parama = a3;
    if (bool) {
      parama = a3;
      if (y.d() != null) {
        if ("100-continue".equalsIgnoreCase(y.a("Expect"))) {
          c.a();
          g1.h().e(g1.g());
          a2 = c.a(true);
        } 
        if (a2 == null) {
          g1.h().d(g1.g());
          a a4 = new a(c.a(y, y.d().b()));
          d d = l.a((r)a4);
          y.d().a(d);
          d.close();
          g1.h().a(g1.g(), a4.a);
          a1 = a2;
        } else {
          a1 = a2;
          if (!c1.d()) {
            g.d();
            a1 = a2;
          } 
        } 
      } 
    } 
    c.b();
    a2 = a1;
    if (a1 == null) {
      g1.h().e(g1.g());
      a2 = c.a(false);
    } 
    aa aa = a2.a(y).a(g.b().c()).a(l).b(System.currentTimeMillis()).a();
    g1.h().a(g1.g(), aa);
    int i = aa.c();
    if (this.a && i == 101) {
      aa = aa.h().a(c.c).a();
    } else {
      aa = aa.h().a(c.a(aa)).a();
    } 
    if ("close".equalsIgnoreCase(aa.a().a("Connection")) || "close".equalsIgnoreCase(aa.a("Connection")))
      g.d(); 
    if ((i != 204 && i != 205) || aa.g().a() <= 0L)
      return aa; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("HTTP ");
    stringBuilder.append(i);
    stringBuilder.append(" had non-zero Content-Length: ");
    stringBuilder.append(aa.g().a());
    throw new ProtocolException(stringBuilder.toString());
  }
  
  static final class a extends g {
    long a;
    
    a(r param1r) {
      super(param1r);
    }
    
    public void a_(c param1c, long param1Long) throws IOException {
      super.a_(param1c, param1Long);
      this.a += param1Long;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */