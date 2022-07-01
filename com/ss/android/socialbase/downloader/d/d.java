package com.ss.android.socialbase.downloader.d;

import com.ss.android.socialbase.downloader.e.a;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.notification.a;
import com.ss.android.socialbase.downloader.notification.b;

public abstract class d extends b {
  private void a(int paramInt, c paramc, a parama, boolean paramBoolean) {
    if (paramc == null)
      return; 
    if (paramc.af()) {
      if (paramInt == 4)
        return; 
      a a2 = b.a().e(paramc.g());
      a a1 = a2;
      if (a2 == null)
        a1 = a(); 
      a1.b(paramc.ab());
      if (paramInt == -3) {
        a1.a(paramc.ab());
      } else {
        a1.a(paramc.Z());
      } 
      a1.a(paramInt, parama, paramBoolean, false);
    } 
  }
  
  private void j(c paramc) {
    if (paramc != null) {
      a a1;
      if (!paramc.af())
        return; 
      a a2 = b.a().e(paramc.g());
      if (a2 == null) {
        a1 = a();
        b.a().a(a1);
        return;
      } 
      a2.a((c)a1);
    } 
  }
  
  private void k(c paramc) {
    if (paramc != null && paramc.af()) {
      if (paramc.q() != 4)
        return; 
      a a2 = b.a().e(paramc.g());
      a a1 = a2;
      if (a2 == null)
        a1 = a(); 
      a1.a(paramc.Z(), paramc.ab());
    } 
  }
  
  protected abstract a a();
  
  public void a(c paramc) {
    super.a(paramc);
    j(paramc);
    a(1, paramc, null, true);
  }
  
  public void a(c paramc, a parama) {
    super.a(paramc, parama);
    a(-1, paramc, parama, false);
  }
  
  public void b(c paramc) {
    super.b(paramc);
    a(2, paramc, null, false);
  }
  
  public void c(c paramc) {
    super.c(paramc);
    k(paramc);
  }
  
  public void d(c paramc) {
    super.d(paramc);
    a(-2, paramc, null, false);
  }
  
  public void e(c paramc) {
    super.e(paramc);
    a(-3, paramc, null, false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\d\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */