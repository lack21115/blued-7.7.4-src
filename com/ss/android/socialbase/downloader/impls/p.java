package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import com.ss.android.socialbase.downloader.b.h;
import com.ss.android.socialbase.downloader.d.ac;
import com.ss.android.socialbase.downloader.d.ag;
import com.ss.android.socialbase.downloader.d.q;
import com.ss.android.socialbase.downloader.d.w;
import com.ss.android.socialbase.downloader.d.x;
import com.ss.android.socialbase.downloader.d.z;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.downloader.k;
import com.ss.android.socialbase.downloader.downloader.n;
import com.ss.android.socialbase.downloader.e.a;
import com.ss.android.socialbase.downloader.f.a;
import com.ss.android.socialbase.downloader.g.b;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.g.d;
import com.ss.android.socialbase.downloader.h.a;
import com.ss.android.socialbase.downloader.k.a;
import com.ss.android.socialbase.downloader.m.c;
import com.ss.android.socialbase.downloader.m.f;
import java.util.List;

public class p implements n {
  private final a a = b.t();
  
  private final k b = b.p();
  
  private final com.ss.android.socialbase.downloader.downloader.p c;
  
  private final boolean d;
  
  public p() {
    this(false);
  }
  
  public p(boolean paramBoolean) {
    if (!paramBoolean) {
      this.c = b.q();
    } else {
      this.c = b.r();
    } 
    this.d = a.b().b("judge_service_alive", false);
  }
  
  public int a(String paramString1, String paramString2) {
    return b.a(paramString1, paramString2);
  }
  
  public List<c> a(String paramString) {
    a a1 = this.a;
    return (a1 != null) ? a1.a(paramString) : null;
  }
  
  public void a() {
    a a1 = this.a;
    if (a1 != null)
      a1.b(); 
  }
  
  public void a(int paramInt) {
    a a1 = this.a;
    if (a1 != null)
      a1.e(paramInt); 
  }
  
  public void a(int paramInt1, int paramInt2) {
    if (b.d() != null)
      for (ag ag : b.d()) {
        if (ag != null)
          ag.a(paramInt2, paramInt1); 
      }  
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.b.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
    this.b.a(paramInt1, paramInt2, paramInt3, paramLong);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong) {
    this.b.a(paramInt1, paramInt2, paramLong);
  }
  
  public void a(int paramInt1, int paramInt2, w paramw, h paramh, boolean paramBoolean) {
    a a1 = this.a;
    if (a1 != null)
      a1.b(paramInt1, paramInt2, paramw, paramh, paramBoolean); 
  }
  
  public void a(int paramInt, Notification paramNotification) {
    com.ss.android.socialbase.downloader.downloader.p p1 = this.c;
    if (p1 != null)
      p1.a(paramInt, paramNotification); 
  }
  
  public void a(int paramInt, z paramz) {
    a a1 = this.a;
    if (a1 != null)
      a1.a(paramInt, paramz); 
  }
  
  public void a(int paramInt, List<b> paramList) {
    this.b.a(paramInt, paramList);
  }
  
  public void a(int paramInt, boolean paramBoolean) {
    a a1 = this.a;
    if (a1 != null)
      a1.a(paramInt, paramBoolean); 
  }
  
  public void a(ag paramag) {
    b.a(paramag);
  }
  
  public void a(b paramb) {
    this.b.a(paramb);
  }
  
  public void a(d paramd) {
    com.ss.android.socialbase.downloader.downloader.p p1 = this.c;
    if (p1 != null) {
      p1.b(paramd);
      return;
    } 
    if (paramd != null) {
      boolean bool;
      x x = paramd.e();
      c c = paramd.a();
      a a1 = new a(1003, "downloadServiceHandler is null");
      if (paramd.a() != null) {
        bool = paramd.a().q();
      } else {
        bool = false;
      } 
      a.a(x, c, a1, bool);
    } 
  }
  
  public void a(List<String> paramList) {
    a a1 = this.a;
    if (a1 != null)
      a1.a(paramList); 
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {
    com.ss.android.socialbase.downloader.downloader.p p1 = this.c;
    if (p1 != null)
      p1.a(paramBoolean2); 
  }
  
  public boolean a(c paramc) {
    if (paramc == null)
      return false; 
    boolean bool = f.a(paramc.q(), paramc.k(), paramc.h());
    if (bool && c.a(33554432))
      b(paramc.g(), true); 
    return bool;
  }
  
  public c b(String paramString1, String paramString2) {
    return h(b.a(paramString1, paramString2));
  }
  
  public List<c> b(String paramString) {
    k k1 = this.b;
    return (k1 != null) ? k1.b(paramString) : null;
  }
  
  public void b(int paramInt1, int paramInt2, w paramw, h paramh, boolean paramBoolean) {
    a a1 = this.a;
    if (a1 != null)
      a1.a(paramInt1, paramInt2, paramw, paramh, paramBoolean); 
  }
  
  public void b(int paramInt, List<b> paramList) {
    this.b.b(paramInt, paramList);
  }
  
  public void b(int paramInt, boolean paramBoolean) {
    a a1 = this.a;
    if (a1 != null)
      a1.b(paramInt, paramBoolean); 
  }
  
  public void b(c paramc) {
    this.b.b(paramc);
  }
  
  public void b(d paramd) {
    com.ss.android.socialbase.downloader.downloader.p p1 = this.c;
    if (p1 != null)
      p1.c(paramd); 
  }
  
  public boolean b() {
    com.ss.android.socialbase.downloader.downloader.p p1 = this.c;
    return (p1 != null) ? p1.b() : false;
  }
  
  public boolean b(int paramInt) {
    a a1 = this.a;
    return (a1 != null) ? a1.n(paramInt) : false;
  }
  
  public List<c> c(String paramString) {
    k k1 = this.b;
    return (k1 != null) ? k1.c(paramString) : null;
  }
  
  public void c(int paramInt) {
    a a1 = this.a;
    if (a1 != null)
      a1.f(paramInt); 
  }
  
  public void c(int paramInt, boolean paramBoolean) {
    c.a().a(paramInt, paramBoolean);
  }
  
  public boolean c() {
    return b.C();
  }
  
  public boolean c(c paramc) {
    return this.b.a(paramc);
  }
  
  public List<c> d(String paramString) {
    k k1 = this.b;
    return (k1 != null) ? k1.d(paramString) : null;
  }
  
  public void d() {}
  
  public void d(int paramInt) {
    a a1 = this.a;
    if (a1 != null)
      a1.g(paramInt); 
  }
  
  public long e(int paramInt) {
    k k1 = this.b;
    if (k1 == null)
      return 0L; 
    c c = k1.b(paramInt);
    if (c == null)
      return 0L; 
    int i = c.aV();
    if (i <= 1)
      return c.Z(); 
    List list = this.b.c(paramInt);
    return (list != null) ? ((list.size() != i) ? 0L : f.b(list)) : 0L;
  }
  
  public List<c> e(String paramString) {
    a a1 = this.a;
    return (a1 != null) ? a1.b(paramString) : null;
  }
  
  public boolean e() {
    return this.b.c();
  }
  
  public int f(int paramInt) {
    a a1 = this.a;
    if (a1 == null)
      return 0; 
    c c = a1.d(paramInt);
    return (c == null) ? 0 : c.q();
  }
  
  public void f() {
    this.b.b();
  }
  
  public boolean g() {
    boolean bool = this.d;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool) {
      com.ss.android.socialbase.downloader.downloader.p p1 = this.c;
      bool1 = bool2;
      if (p1 != null) {
        bool1 = bool2;
        if (p1.a())
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  public boolean g(int paramInt) {
    a a1 = this.a;
    return (a1 != null) ? a1.a(paramInt) : false;
  }
  
  public c h(int paramInt) {
    a a1 = this.a;
    return (a1 != null) ? a1.d(paramInt) : null;
  }
  
  public List<b> i(int paramInt) {
    return this.b.c(paramInt);
  }
  
  public void j(int paramInt) {
    a a1 = this.a;
    if (a1 != null)
      a1.m(paramInt); 
  }
  
  public void k(int paramInt) {
    a.a(paramInt);
  }
  
  public boolean l(int paramInt) {
    a a1 = this.a;
    return (a1 != null) ? a1.k(paramInt) : false;
  }
  
  public int m(int paramInt) {
    return c.a().a(paramInt);
  }
  
  public boolean n(int paramInt) {
    return this.b.e(paramInt);
  }
  
  public void o(int paramInt) {
    this.b.d(paramInt);
  }
  
  public boolean p(int paramInt) {
    return this.b.f(paramInt);
  }
  
  public z q(int paramInt) {
    a a1 = this.a;
    return (a1 != null) ? a1.i(paramInt) : null;
  }
  
  public ac r(int paramInt) {
    ac ac;
    a a1 = this.a;
    if (a1 != null) {
      ac ac1 = a1.h(paramInt);
    } else {
      a1 = null;
    } 
    a a2 = a1;
    if (a1 == null)
      ac = b.y(); 
    return ac;
  }
  
  public q s(int paramInt) {
    a a1 = this.a;
    return (a1 != null) ? a1.j(paramInt) : null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\impls\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */