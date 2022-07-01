package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.b.h;
import com.ss.android.socialbase.downloader.d.ac;
import com.ss.android.socialbase.downloader.d.ag;
import com.ss.android.socialbase.downloader.d.q;
import com.ss.android.socialbase.downloader.d.w;
import com.ss.android.socialbase.downloader.d.z;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.downloader.f;
import com.ss.android.socialbase.downloader.downloader.j;
import com.ss.android.socialbase.downloader.downloader.n;
import com.ss.android.socialbase.downloader.downloader.o;
import com.ss.android.socialbase.downloader.downloader.p;
import com.ss.android.socialbase.downloader.f.a;
import com.ss.android.socialbase.downloader.g.b;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.g.d;
import com.ss.android.socialbase.downloader.m.f;
import com.ss.android.socialbase.downloader.m.g;
import java.util.List;

public class o implements n, o {
  private static final String a = o.class.getSimpleName();
  
  private volatile j b;
  
  private p<IndependentProcessDownloadService> c = b.r();
  
  private n d = new p();
  
  public o() {
    this.c.a(this);
  }
  
  public int a(String paramString1, String paramString2) {
    return b.a(paramString1, paramString2);
  }
  
  public List<c> a(String paramString) {
    if (this.b == null)
      return this.d.a(paramString); 
    try {
      return this.b.a(paramString);
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return null;
    } 
  }
  
  public void a() {
    if (this.b == null)
      return; 
    try {
      this.b.a();
      return;
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return;
    } 
  }
  
  public void a(int paramInt) {
    if (this.b == null)
      return; 
    try {
      this.b.a(paramInt);
      return;
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return;
    } 
  }
  
  public void a(int paramInt1, int paramInt2) {
    if (this.b != null)
      try {
        this.b.a(paramInt1, paramInt2);
        return;
      } catch (RemoteException remoteException) {
        remoteException.printStackTrace();
      }  
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (this.b == null) {
      this.d.a(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    } 
    try {
      this.b.a(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return;
    } 
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
    if (this.b == null) {
      this.d.a(paramInt1, paramInt2, paramInt3, paramLong);
      return;
    } 
    try {
      this.b.a(paramInt1, paramInt2, paramInt3, paramLong);
      return;
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return;
    } 
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong) {
    if (this.b == null) {
      this.d.a(paramInt1, paramInt2, paramLong);
      return;
    } 
    try {
      this.b.a(paramInt1, paramInt2, paramLong);
      return;
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return;
    } 
  }
  
  public void a(int paramInt1, int paramInt2, w paramw, h paramh, boolean paramBoolean) {
    if (this.b == null)
      return; 
    try {
      boolean bool;
      j j1 = this.b;
      if (paramh == h.b) {
        bool = false;
      } else {
        bool = true;
      } 
      j1.b(paramInt1, paramInt2, g.a(paramw, bool), paramh.ordinal(), paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return;
    } 
  }
  
  public void a(int paramInt, Notification paramNotification) {
    if (this.b == null) {
      a.d(a, "startForeground, aidlService is null");
      return;
    } 
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("aidlService.startForeground, id = ");
    stringBuilder.append(paramInt);
    a.c(str, stringBuilder.toString());
    try {
      this.b.a(paramInt, paramNotification);
      return;
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return;
    } 
  }
  
  public void a(int paramInt, z paramz) {
    if (this.b != null)
      try {
        this.b.a(paramInt, g.a(paramz));
        return;
      } catch (RemoteException remoteException) {
        remoteException.printStackTrace();
      }  
  }
  
  public void a(int paramInt, List<b> paramList) {
    if (this.b == null)
      return; 
    try {
      this.b.b(paramInt, paramList);
      return;
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return;
    } 
  }
  
  public void a(int paramInt, boolean paramBoolean) {
    if (this.b == null) {
      this.d.a(paramInt, paramBoolean);
      return;
    } 
    try {
      this.b.a(paramInt, paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return;
    } 
  }
  
  public void a(IBinder paramIBinder) {
    this.b = j.a.a(paramIBinder);
    if (f.a())
      a(new ag(this) {
            public void a(int param1Int1, int param1Int2) {
              if (param1Int2 == 1) {
                f.a(b.B()).a(param1Int1);
                List list = l.a(false).i(param1Int1);
                if (list != null) {
                  list = f.a(list);
                  l.a(true).a(param1Int1, list);
                  return;
                } 
              } else if (param1Int2 == 2) {
                f.a(b.B()).b(param1Int1);
              } 
            }
          }); 
  }
  
  public void a(ag paramag) {
    if (this.b != null)
      try {
        this.b.a(g.a(paramag));
        return;
      } catch (RemoteException remoteException) {
        remoteException.printStackTrace();
      }  
  }
  
  public void a(b paramb) {
    if (this.b == null) {
      this.d.a(paramb);
      return;
    } 
    try {
      this.b.a(paramb);
      return;
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return;
    } 
  }
  
  public void a(d paramd) {
    if (paramd == null)
      return; 
    p<IndependentProcessDownloadService> p1 = this.c;
    if (p1 != null)
      p1.b(paramd); 
  }
  
  public void a(List<String> paramList) {
    if (this.b == null) {
      this.d.a(paramList);
      return;
    } 
    try {
      this.b.a(paramList);
      return;
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return;
    } 
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {
    if (this.b == null) {
      a.d(a, "stopForeground, aidlService is null");
      return;
    } 
    a.c(a, "aidlService.stopForeground");
    try {
      this.b.a(paramBoolean2);
      return;
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return;
    } 
  }
  
  public boolean a(c paramc) {
    if (this.b == null)
      return this.d.a(paramc); 
    try {
      this.b.a(paramc);
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
    return false;
  }
  
  public c b(String paramString1, String paramString2) {
    return h(a(paramString1, paramString2));
  }
  
  public List<c> b(String paramString) {
    if (this.b == null)
      return this.d.b(paramString); 
    try {
      return this.b.b(paramString);
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return null;
    } 
  }
  
  public void b(int paramInt1, int paramInt2, w paramw, h paramh, boolean paramBoolean) {
    if (this.b == null)
      return; 
    try {
      boolean bool;
      j j1 = this.b;
      if (paramh == h.b) {
        bool = false;
      } else {
        bool = true;
      } 
      j1.a(paramInt1, paramInt2, g.a(paramw, bool), paramh.ordinal(), paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return;
    } 
  }
  
  public void b(int paramInt, List<b> paramList) {
    if (this.b == null) {
      this.d.b(paramInt, paramList);
      return;
    } 
    try {
      this.b.a(paramInt, paramList);
      return;
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return;
    } 
  }
  
  public void b(int paramInt, boolean paramBoolean) {
    if (this.b == null) {
      this.d.b(paramInt, paramBoolean);
      return;
    } 
    try {
      this.b.b(paramInt, paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return;
    } 
  }
  
  public void b(c paramc) {}
  
  public void b(d paramd) {
    if (paramd == null)
      return; 
    p<IndependentProcessDownloadService> p1 = this.c;
    if (p1 != null)
      p1.c(paramd); 
  }
  
  public boolean b() {
    if (this.b == null) {
      a.d(a, "isServiceForeground, aidlService is null");
      return false;
    } 
    a.c(a, "aidlService.isServiceForeground");
    try {
      return this.b.e();
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return false;
    } 
  }
  
  public boolean b(int paramInt) {
    if (this.b == null)
      return false; 
    try {
      return this.b.b(paramInt);
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return false;
    } 
  }
  
  public List<c> c(String paramString) {
    if (this.b == null)
      return this.d.c(paramString); 
    try {
      return this.b.c(paramString);
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return null;
    } 
  }
  
  public void c(int paramInt) {
    if (this.b == null)
      return; 
    try {
      this.b.c(paramInt);
      return;
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return;
    } 
  }
  
  public void c(int paramInt, boolean paramBoolean) {
    if (this.b == null)
      return; 
    try {
      this.b.c(paramInt, paramBoolean);
      return;
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return;
    } 
  }
  
  public boolean c() {
    return b.C();
  }
  
  public boolean c(c paramc) {
    if (this.b == null)
      return this.d.c(paramc); 
    try {
      return this.b.b(paramc);
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return false;
    } 
  }
  
  public List<c> d(String paramString) {
    if (this.b == null)
      return this.d.d(paramString); 
    try {
      return this.b.e(paramString);
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return null;
    } 
  }
  
  public void d() {
    p<IndependentProcessDownloadService> p1 = this.c;
    if (p1 != null)
      p1.f(); 
  }
  
  public void d(int paramInt) {
    if (this.b == null)
      return; 
    try {
      this.b.d(paramInt);
      return;
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return;
    } 
  }
  
  public long e(int paramInt) {
    if (this.b == null)
      return 0L; 
    try {
      return this.b.e(paramInt);
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return 0L;
    } 
  }
  
  public List<c> e(String paramString) {
    if (this.b != null)
      try {
        return this.b.d(paramString);
      } catch (RemoteException remoteException) {
        remoteException.printStackTrace();
      }  
    return null;
  }
  
  public boolean e() {
    if (this.b == null)
      return this.d.e(); 
    try {
      return this.b.c();
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return false;
    } 
  }
  
  public int f(int paramInt) {
    if (this.b == null)
      return 0; 
    try {
      return this.b.f(paramInt);
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return 0;
    } 
  }
  
  public void f() {
    if (this.b == null) {
      this.d.f();
      return;
    } 
    try {
      this.b.d();
      return;
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return;
    } 
  }
  
  public boolean g() {
    return (this.b != null);
  }
  
  public boolean g(int paramInt) {
    if (this.b == null)
      return false; 
    try {
      return this.b.g(paramInt);
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return false;
    } 
  }
  
  public c h(int paramInt) {
    if (this.b == null)
      return this.d.h(paramInt); 
    try {
      return this.b.h(paramInt);
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return null;
    } 
  }
  
  public void h() {
    this.b = null;
  }
  
  public List<b> i(int paramInt) {
    if (this.b == null)
      return this.d.i(paramInt); 
    try {
      return this.b.i(paramInt);
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return null;
    } 
  }
  
  public void j(int paramInt) {
    if (this.b == null) {
      this.d.j(paramInt);
      return;
    } 
    try {
      this.b.j(paramInt);
      return;
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return;
    } 
  }
  
  public void k(int paramInt) {
    p<IndependentProcessDownloadService> p1 = this.c;
    if (p1 != null)
      p1.a(paramInt); 
  }
  
  public boolean l(int paramInt) {
    if (this.b == null)
      return false; 
    try {
      return this.b.k(paramInt);
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return false;
    } 
  }
  
  public int m(int paramInt) {
    if (this.b == null)
      return c.a().b(paramInt); 
    try {
      return this.b.m(paramInt);
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return -1;
    } 
  }
  
  public boolean n(int paramInt) {
    if (this.b == null)
      return this.d.n(paramInt); 
    try {
      return this.b.n(paramInt);
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return false;
    } 
  }
  
  public void o(int paramInt) {
    if (this.b == null) {
      this.d.o(paramInt);
      return;
    } 
    try {
      this.b.o(paramInt);
      return;
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return;
    } 
  }
  
  public boolean p(int paramInt) {
    if (this.b == null)
      return this.d.p(paramInt); 
    try {
      return this.b.p(paramInt);
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return false;
    } 
  }
  
  public z q(int paramInt) {
    if (this.b != null)
      try {
        return g.a(this.b.q(paramInt));
      } catch (RemoteException remoteException) {
        remoteException.printStackTrace();
      }  
    return null;
  }
  
  public ac r(int paramInt) {
    if (this.b != null)
      try {
        return g.a(this.b.r(paramInt));
      } catch (RemoteException remoteException) {
        remoteException.printStackTrace();
      }  
    return null;
  }
  
  public q s(int paramInt) {
    if (this.b != null)
      try {
        return g.a(this.b.s(paramInt));
      } catch (RemoteException remoteException) {
        remoteException.printStackTrace();
      }  
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\impls\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */