package com.bytedance.sdk.a.b.a.e;

import com.bytedance.sdk.a.a.c;
import com.bytedance.sdk.a.a.h;
import com.bytedance.sdk.a.a.l;
import com.bytedance.sdk.a.a.r;
import com.bytedance.sdk.a.a.s;
import com.bytedance.sdk.a.b.a.b.g;
import com.bytedance.sdk.a.b.a.c;
import com.bytedance.sdk.a.b.a.c.c;
import com.bytedance.sdk.a.b.a.c.e;
import com.bytedance.sdk.a.b.a.c.h;
import com.bytedance.sdk.a.b.a.c.i;
import com.bytedance.sdk.a.b.a.c.k;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.r;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.w;
import com.bytedance.sdk.a.b.y;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class f implements c {
  private static final com.bytedance.sdk.a.a.f b = com.bytedance.sdk.a.a.f.a("connection");
  
  private static final com.bytedance.sdk.a.a.f c = com.bytedance.sdk.a.a.f.a("host");
  
  private static final com.bytedance.sdk.a.a.f d = com.bytedance.sdk.a.a.f.a("keep-alive");
  
  private static final com.bytedance.sdk.a.a.f e = com.bytedance.sdk.a.a.f.a("proxy-connection");
  
  private static final com.bytedance.sdk.a.a.f f = com.bytedance.sdk.a.a.f.a("transfer-encoding");
  
  private static final com.bytedance.sdk.a.a.f g = com.bytedance.sdk.a.a.f.a("te");
  
  private static final com.bytedance.sdk.a.a.f h = com.bytedance.sdk.a.a.f.a("encoding");
  
  private static final com.bytedance.sdk.a.a.f i = com.bytedance.sdk.a.a.f.a("upgrade");
  
  private static final List<com.bytedance.sdk.a.a.f> j = c.a((Object[])new com.bytedance.sdk.a.a.f[] { 
        b, c, d, e, g, f, h, i, c.c, c.d, 
        c.e, c.f });
  
  private static final List<com.bytedance.sdk.a.a.f> k = c.a((Object[])new com.bytedance.sdk.a.a.f[] { b, c, d, e, g, f, h, i });
  
  final g a;
  
  private final v l;
  
  private final t.a m;
  
  private final g n;
  
  private i o;
  
  public f(v paramv, t.a parama, g paramg, g paramg1) {
    this.l = paramv;
    this.m = parama;
    this.a = paramg;
    this.n = paramg1;
  }
  
  public static aa.a a(List<c> paramList) throws IOException {
    r.a a1 = new r.a();
    int k = paramList.size();
    int j = 0;
    c c1 = null;
    while (j < k) {
      r.a a2;
      c c2 = paramList.get(j);
      if (c2 == null) {
        c2 = c1;
        a2 = a1;
        if (c1 != null) {
          c2 = c1;
          a2 = a1;
          if (((k)c1).b == 100) {
            a2 = new r.a();
            c2 = null;
          } 
        } 
      } else {
        com.bytedance.sdk.a.a.f f1 = c2.g;
        String str = c2.h.a();
        if (f1.equals(c.b)) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("HTTP/1.1 ");
          stringBuilder.append(str);
          k k1 = k.a(stringBuilder.toString());
          a2 = a1;
        } else {
          c2 = c1;
          a2 = a1;
          if (!k.contains(f1)) {
            com.bytedance.sdk.a.b.a.a.a.a(a1, f1.a(), str);
            a2 = a1;
            c2 = c1;
          } 
        } 
      } 
      j++;
      c1 = c2;
      a1 = a2;
    } 
    if (c1 != null)
      return (new aa.a()).a(w.d).a(((k)c1).b).a(((k)c1).c).a(a1.a()); 
    throw new ProtocolException("Expected ':status' header not present");
  }
  
  public static List<c> b(y paramy) {
    r r = paramy.c();
    ArrayList<c> arrayList = new ArrayList(r.a() + 4);
    arrayList.add(new c(c.c, paramy.b()));
    arrayList.add(new c(c.d, i.a(paramy.a())));
    String str = paramy.a("Host");
    if (str != null)
      arrayList.add(new c(c.f, str)); 
    arrayList.add(new c(c.e, paramy.a().b()));
    int j = 0;
    int k = r.a();
    while (j < k) {
      com.bytedance.sdk.a.a.f f1 = com.bytedance.sdk.a.a.f.a(r.a(j).toLowerCase(Locale.US));
      if (!j.contains(f1))
        arrayList.add(new c(f1, r.b(j))); 
      j++;
    } 
    return arrayList;
  }
  
  public r a(y paramy, long paramLong) {
    return this.o.h();
  }
  
  public aa.a a(boolean paramBoolean) throws IOException {
    aa.a a1 = a(this.o.d());
    return (paramBoolean && com.bytedance.sdk.a.b.a.a.a.a(a1) == 100) ? null : a1;
  }
  
  public ab a(aa paramaa) throws IOException {
    this.a.c.f(this.a.b);
    return (ab)new h(paramaa.a("Content-Type"), e.a(paramaa), l.a((s)new a(this, this.o.g())));
  }
  
  public void a() throws IOException {
    this.n.b();
  }
  
  public void a(y paramy) throws IOException {
    boolean bool;
    if (this.o != null)
      return; 
    if (paramy.d() != null) {
      bool = true;
    } else {
      bool = false;
    } 
    List<c> list = b(paramy);
    this.o = this.n.a(list, bool);
    this.o.e().a(this.m.c(), TimeUnit.MILLISECONDS);
    this.o.f().a(this.m.d(), TimeUnit.MILLISECONDS);
  }
  
  public void b() throws IOException {
    this.o.h().close();
  }
  
  class a extends h {
    boolean a = false;
    
    long b = 0L;
    
    a(f this$0, s param1s) {
      super(param1s);
    }
    
    private void a(IOException param1IOException) {
      if (this.a)
        return; 
      this.a = true;
      this.c.a.a(false, this.c, this.b, param1IOException);
    }
    
    public long a(c param1c, long param1Long) throws IOException {
      try {
        param1Long = b().a(param1c, param1Long);
        if (param1Long > 0L)
          this.b += param1Long; 
        return param1Long;
      } catch (IOException iOException) {
        a(iOException);
        throw iOException;
      } 
    }
    
    public void close() throws IOException {
      super.close();
      a(null);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\e\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */