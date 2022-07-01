package com.bytedance.sdk.openadsdk.downloadnew;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.h.l;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.downloadnew.a.a;
import com.bytedance.sdk.openadsdk.downloadnew.a.b;
import com.bytedance.sdk.openadsdk.downloadnew.a.c;
import com.bytedance.sdk.openadsdk.downloadnew.a.d;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.b;
import com.bytedance.sdk.openadsdk.utils.t;

public class a {
  public static a a(Context paramContext, k paramk, String paramString) {
    return (a)new b(paramContext, paramk, paramString);
  }
  
  public static a a(Context paramContext, String paramString1, String paramString2) {
    return (a)new c(paramContext, paramString1, paramString2);
  }
  
  public static String a() {
    try {
      return d.d().f();
    } catch (Exception exception) {
      t.a("TTDownloadFactory", "get download sdk version error", exception);
      return "0.0.0";
    } 
  }
  
  public static boolean a(Context paramContext, ExitInstallListener paramExitInstallListener) {
    boolean bool;
    l l = o.h();
    if (l != null) {
      bool = l.w();
    } else {
      bool = true;
    } 
    return !bool ? false : com.ss.android.downloadlib.a.a.a.a().a(paramContext, false, new com.ss.android.downloadlib.a.a.a.a(paramExitInstallListener) {
          public void a() {
            ExitInstallListener exitInstallListener = this.a;
            if (exitInstallListener != null)
              exitInstallListener.onExitInstall(); 
          }
        });
  }
  
  public static b b(Context paramContext, k paramk, String paramString) {
    return (b)new a(paramContext, paramk, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\downloadnew\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */