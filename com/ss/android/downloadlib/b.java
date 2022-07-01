package com.ss.android.downloadlib;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.a.a.b.a;
import com.ss.android.a.a.b.c;
import com.ss.android.downloadad.a.a.a;
import com.ss.android.downloadad.a.b;
import com.ss.android.downloadad.a.b.a;
import com.ss.android.downloadlib.a.a;
import com.ss.android.downloadlib.a.b.c;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.d.a;
import com.ss.android.downloadlib.e.d;

public class b implements b {
  private static String a = b.class.getSimpleName();
  
  private static volatile b b;
  
  private h c = h.a(j.a());
  
  public static b a() {
    // Byte code:
    //   0: getstatic com/ss/android/downloadlib/b.b : Lcom/ss/android/downloadlib/b;
    //   3: ifnonnull -> 37
    //   6: ldc com/ss/android/downloadlib/b
    //   8: monitorenter
    //   9: getstatic com/ss/android/downloadlib/b.b : Lcom/ss/android/downloadlib/b;
    //   12: ifnonnull -> 25
    //   15: new com/ss/android/downloadlib/b
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/ss/android/downloadlib/b.b : Lcom/ss/android/downloadlib/b;
    //   25: ldc com/ss/android/downloadlib/b
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/ss/android/downloadlib/b
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/ss/android/downloadlib/b.b : Lcom/ss/android/downloadlib/b;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public static a b() {
    return (a)(new a.a()).a(0).b(0).a(true).c(false).d(false).a();
  }
  
  public static com.ss.android.a.a.b.b c() {
    return (com.ss.android.a.a.b.b)(new com.ss.android.downloadad.a.a.b.a()).a("landing_h5_download_ad_button").b("landing_h5_download_ad_button").k("click_start_detail").l("click_pause_detail").m("click_continue_detail").n("click_install_detail").o("click_open_detail").q("storage_deny_detail").a(1).a(false).b(true).d(false).a();
  }
  
  public boolean a(Context paramContext, Uri paramUri, c paramc) {
    a a;
    if (j.i().optInt("disable_market") == 1)
      return false; 
    if (paramUri == null)
      return false; 
    Context context = paramContext;
    if (paramContext == null)
      context = j.a(); 
    if (paramc == null)
      return (d.a(context, paramUri).a() == 5); 
    c.a a1 = new c.a(paramc.d(), paramc, c(), b());
    a.a().a("market_click_open", paramc, a1.c);
    String str = paramUri.getQueryParameter("id");
    if (d.a(context, str).a() == 5) {
      a.a().a("market_open_success", a1);
      j.c().a(context, a1.b, a1.d, a1.c, a1.b.t());
      a.a().a(a1.b);
      a = new a(a1.b, a1.c, a1.d);
      if (!TextUtils.isEmpty(str))
        a.a(str); 
      a.a(2);
      a.c(System.currentTimeMillis());
      a.d(4);
      c.a().a(a);
      return true;
    } 
    a.a().a("market_open_failed", (c.a)a);
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */