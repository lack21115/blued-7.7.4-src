package com.ss.android.downloadlib;

import com.ss.android.downloadad.a.b.a;
import com.ss.android.downloadlib.a.b.c;
import com.ss.android.downloadlib.a.c.b;
import com.ss.android.downloadlib.a.c.d;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.d.a;
import com.ss.android.downloadlib.e.g;
import com.ss.android.socialbase.appdownloader.c.h;
import com.ss.android.socialbase.downloader.e.a;
import com.ss.android.socialbase.downloader.k.a;

public class c implements h {
  private static String a = c.class.getSimpleName();
  
  private void a(com.ss.android.socialbase.downloader.g.c paramc, a parama) {
    if (a.a(paramc.g()).a("exec_clear_space_switch", 0) != 1)
      return; 
    a.a().a("cleanspace_switch_open", parama);
    d.a().a((Runnable)new b(paramc));
  }
  
  public void a(com.ss.android.socialbase.downloader.g.c paramc, a parama, int paramInt) {
    a a1;
    if (paramc == null)
      return; 
    if (paramInt == -1) {
      a a2 = null;
      if (parama != null) {
        try {
          if (g.a(parama)) {
            a2 = c.a().a(paramc);
            if (a2 != null) {
              if (j.l() != null)
                j.l().a(a2.a()); 
              a.a().a("download_failed_for_space", a2);
              if (d.a().c(paramc.j())) {
                a.a().a("download_can_restart", a2);
                a(paramc, a2);
              } 
            } 
          } 
          paramInt = j.i().optInt("exception_msg_length", 500);
          String str = g.a(parama.getMessage(), paramInt);
          a1 = new a(parama.a(), str);
          a.a().a(paramc, a1);
          g.a().a(paramc, parama, "");
          return;
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
        return;
      } 
    } else {
      if (paramInt == -3) {
        a.a((com.ss.android.socialbase.downloader.g.c)exception, c.a().a((com.ss.android.socialbase.downloader.g.c)exception));
        return;
      } 
      return;
    } 
    a.a().a((com.ss.android.socialbase.downloader.g.c)exception, a1);
    g.a().a((com.ss.android.socialbase.downloader.g.c)exception, parama, "");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */