package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.d.ab;
import com.ss.android.socialbase.downloader.d.af;
import com.ss.android.socialbase.downloader.d.g;
import com.ss.android.socialbase.downloader.d.i;
import com.ss.android.socialbase.downloader.d.y;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.downloader.j;
import com.ss.android.socialbase.downloader.downloader.n;
import com.ss.android.socialbase.downloader.g.a;
import com.ss.android.socialbase.downloader.g.b;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.m.f;
import com.ss.android.socialbase.downloader.m.g;
import java.util.List;

public class m extends j.a {
  private static final String a = m.class.getSimpleName();
  
  private final n b = new p(true);
  
  public int a(String paramString1, String paramString2) throws RemoteException {
    n n1 = this.b;
    return (n1 == null) ? 0 : n1.a(paramString1, paramString2);
  }
  
  public List<c> a(String paramString) throws RemoteException {
    n n1 = this.b;
    return (n1 == null) ? null : n1.a(paramString);
  }
  
  public void a() throws RemoteException {
    n n1 = this.b;
    if (n1 == null)
      return; 
    n1.a();
  }
  
  public void a(int paramInt) throws RemoteException {
    n n1 = this.b;
    if (n1 == null)
      return; 
    n1.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2) throws RemoteException {
    n n1 = this.b;
    if (n1 == null)
      return; 
    n1.a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) throws RemoteException {
    n n1 = this.b;
    if (n1 == null)
      return; 
    n1.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong) throws RemoteException {
    n n1 = this.b;
    if (n1 == null)
      return; 
    n1.a(paramInt1, paramInt2, paramInt3, paramLong);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong) throws RemoteException {
    n n1 = this.b;
    if (n1 == null)
      return; 
    n1.a(paramInt1, paramInt2, paramLong);
  }
  
  public void a(int paramInt1, int paramInt2, i parami, int paramInt3, boolean paramBoolean) throws RemoteException {
    n n1 = this.b;
    if (n1 == null)
      return; 
    n1.b(paramInt1, paramInt2, g.a(parami), f.c(paramInt3), paramBoolean);
  }
  
  public void a(int paramInt, Notification paramNotification) throws RemoteException {
    n n1 = this.b;
    if (n1 == null)
      return; 
    n1.a(paramInt, paramNotification);
  }
  
  public void a(int paramInt, y paramy) throws RemoteException {
    n n1 = this.b;
    if (n1 == null)
      return; 
    n1.a(paramInt, g.a(paramy));
  }
  
  public void a(int paramInt, List<b> paramList) throws RemoteException {
    n n1 = this.b;
    if (n1 == null)
      return; 
    n1.b(paramInt, paramList);
  }
  
  public void a(int paramInt, boolean paramBoolean) throws RemoteException {
    n n1 = this.b;
    if (n1 == null)
      return; 
    n1.a(paramInt, paramBoolean);
  }
  
  public void a(af paramaf) throws RemoteException {
    n n1 = this.b;
    if (n1 == null)
      return; 
    n1.a(g.a(paramaf));
  }
  
  public void a(a parama) throws RemoteException {
    n n1 = this.b;
    if (n1 == null)
      return; 
    n1.b(g.a(parama));
  }
  
  public void a(b paramb) throws RemoteException {
    n n1 = this.b;
    if (n1 == null)
      return; 
    n1.a(paramb);
  }
  
  public void a(List<String> paramList) throws RemoteException {
    n n1 = this.b;
    if (n1 == null)
      return; 
    n1.a(paramList);
  }
  
  public void a(boolean paramBoolean) throws RemoteException {
    n n1 = this.b;
    if (n1 == null)
      return; 
    n1.a(true, paramBoolean);
  }
  
  public boolean a(c paramc) throws RemoteException {
    n n1 = this.b;
    return (n1 == null) ? false : n1.a(paramc);
  }
  
  public c b(String paramString1, String paramString2) throws RemoteException {
    n n1 = this.b;
    return (n1 == null) ? null : n1.b(paramString1, paramString2);
  }
  
  public List<c> b(String paramString) throws RemoteException {
    n n1 = this.b;
    return (n1 == null) ? null : n1.b(paramString);
  }
  
  public void b(int paramInt1, int paramInt2, i parami, int paramInt3, boolean paramBoolean) throws RemoteException {
    n n1 = this.b;
    if (n1 == null)
      return; 
    n1.a(paramInt1, paramInt2, g.a(parami), f.c(paramInt3), paramBoolean);
  }
  
  public void b(int paramInt, List<b> paramList) throws RemoteException {
    n n1 = this.b;
    if (n1 == null)
      return; 
    n1.a(paramInt, paramList);
  }
  
  public void b(int paramInt, boolean paramBoolean) throws RemoteException {
    n n1 = this.b;
    if (n1 == null)
      return; 
    n1.b(paramInt, paramBoolean);
  }
  
  public boolean b() throws RemoteException {
    n n1 = this.b;
    return (n1 == null) ? false : n1.c();
  }
  
  public boolean b(int paramInt) throws RemoteException {
    n n1 = this.b;
    return (n1 == null) ? false : n1.b(paramInt);
  }
  
  public boolean b(c paramc) throws RemoteException {
    n n1 = this.b;
    return (n1 == null) ? false : n1.c(paramc);
  }
  
  public List<c> c(String paramString) throws RemoteException {
    n n1 = this.b;
    return (n1 == null) ? null : n1.c(paramString);
  }
  
  public void c(int paramInt) throws RemoteException {
    n n1 = this.b;
    if (n1 == null)
      return; 
    n1.c(paramInt);
  }
  
  public void c(int paramInt, boolean paramBoolean) throws RemoteException {
    c.a().b(paramInt, paramBoolean);
  }
  
  public boolean c() throws RemoteException {
    n n1 = this.b;
    return (n1 == null) ? false : n1.e();
  }
  
  public List<c> d(String paramString) throws RemoteException {
    n n1 = this.b;
    return (n1 == null) ? null : n1.e(paramString);
  }
  
  public void d() throws RemoteException {
    n n1 = this.b;
    if (n1 == null)
      return; 
    n1.f();
  }
  
  public void d(int paramInt) throws RemoteException {
    n n1 = this.b;
    if (n1 == null)
      return; 
    n1.d(paramInt);
  }
  
  public long e(int paramInt) throws RemoteException {
    n n1 = this.b;
    return (n1 == null) ? 0L : n1.e(paramInt);
  }
  
  public List<c> e(String paramString) throws RemoteException {
    n n1 = this.b;
    return (n1 == null) ? null : n1.d(paramString);
  }
  
  public boolean e() throws RemoteException {
    n n1 = this.b;
    return (n1 == null) ? false : n1.b();
  }
  
  public int f(int paramInt) throws RemoteException {
    n n1 = this.b;
    return (n1 == null) ? 0 : n1.f(paramInt);
  }
  
  public boolean g(int paramInt) throws RemoteException {
    n n1 = this.b;
    return (n1 == null) ? false : n1.g(paramInt);
  }
  
  public c h(int paramInt) throws RemoteException {
    n n1 = this.b;
    return (n1 == null) ? null : n1.h(paramInt);
  }
  
  public List<b> i(int paramInt) throws RemoteException {
    n n1 = this.b;
    return (n1 == null) ? null : n1.i(paramInt);
  }
  
  public void j(int paramInt) throws RemoteException {
    n n1 = this.b;
    if (n1 == null)
      return; 
    n1.j(paramInt);
  }
  
  public boolean k(int paramInt) throws RemoteException {
    n n1 = this.b;
    return (n1 == null) ? false : n1.l(paramInt);
  }
  
  public void l(int paramInt) throws RemoteException {
    n n1 = this.b;
    if (n1 == null)
      return; 
    n1.k(paramInt);
  }
  
  public int m(int paramInt) throws RemoteException {
    return c.a().b(paramInt);
  }
  
  public boolean n(int paramInt) throws RemoteException {
    n n1 = this.b;
    return (n1 == null) ? false : n1.n(paramInt);
  }
  
  public void o(int paramInt) throws RemoteException {
    n n1 = this.b;
    if (n1 == null)
      return; 
    n1.o(paramInt);
  }
  
  public boolean p(int paramInt) throws RemoteException {
    n n1 = this.b;
    return (n1 == null) ? false : n1.p(paramInt);
  }
  
  public y q(int paramInt) throws RemoteException {
    n n1 = this.b;
    return (n1 == null) ? null : g.a(n1.q(paramInt));
  }
  
  public ab r(int paramInt) throws RemoteException {
    n n1 = this.b;
    return (n1 == null) ? null : g.a(n1.r(paramInt));
  }
  
  public g s(int paramInt) throws RemoteException {
    n n1 = this.b;
    return (n1 == null) ? null : g.a(n1.s(paramInt));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\impls\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */