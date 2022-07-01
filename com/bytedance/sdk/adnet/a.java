package com.bytedance.sdk.adnet;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.a.a;
import com.bytedance.sdk.adnet.c.a;
import com.bytedance.sdk.adnet.c.b;
import com.bytedance.sdk.adnet.c.f;
import com.bytedance.sdk.adnet.core.l;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.core.o;
import com.bytedance.sdk.adnet.d.d;
import com.bytedance.sdk.adnet.d.g;
import com.bytedance.sdk.adnet.face.IHttpStack;
import java.io.File;

public class a {
  public static o a;
  
  private static String b;
  
  private static b c;
  
  private static boolean d = true;
  
  private static a e;
  
  public static b a() {
    b b1 = c;
    if (b1 != null)
      return b1; 
    throw new IllegalArgumentException("sITTNetDepend is null");
  }
  
  public static m a(Context paramContext) {
    return l.a(paramContext);
  }
  
  public static m a(Context paramContext, IHttpStack paramIHttpStack) {
    return l.a(paramContext, paramIHttpStack);
  }
  
  public static void a(Activity paramActivity) {
    if (paramActivity == null)
      return; 
    (new Thread("load_config", paramActivity.getApplicationContext()) {
        public void run() {
          a.a(this.a).c();
          a.a(this.a);
          a.b(this.a);
        }
      }).start();
  }
  
  public static void a(Context paramContext, Application paramApplication, boolean paramBoolean) {
    if (paramContext != null) {
      f.a().a(paramContext, g.b(paramContext));
      if (g.a(paramContext) || (!g.b(paramContext) && paramBoolean)) {
        a.a(paramContext).c();
        a.a(paramContext).a();
      } 
      if (!g.b(paramContext))
        return; 
      a.a(paramContext);
      if (paramApplication != null)
        paramApplication.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
              public void onActivityCreated(Activity param1Activity, Bundle param1Bundle) {}
              
              public void onActivityDestroyed(Activity param1Activity) {}
              
              public void onActivityPaused(Activity param1Activity) {}
              
              public void onActivityResumed(Activity param1Activity) {
                a.a(param1Activity);
              }
              
              public void onActivitySaveInstanceState(Activity param1Activity, Bundle param1Bundle) {}
              
              public void onActivityStarted(Activity param1Activity) {}
              
              public void onActivityStopped(Activity param1Activity) {}
            }); 
      return;
    } 
    throw new IllegalArgumentException("tryInitAdTTNet context is null");
  }
  
  public static void a(a parama) {
    e = parama;
  }
  
  public static void a(b paramb) {
    c = paramb;
  }
  
  public static void a(o paramo) {
    a = paramo;
  }
  
  public static void a(boolean paramBoolean) {
    d = paramBoolean;
  }
  
  public static String b(Context paramContext) {
    try {
      if (TextUtils.isEmpty(b)) {
        File file = new File(paramContext.getCacheDir(), "VAdNetSdk");
        file.mkdirs();
        b = file.getAbsolutePath();
      } 
    } finally {
      paramContext = null;
    } 
  }
  
  public static boolean b() {
    return d;
  }
  
  public static void c() {
    d.a(d.a.a);
  }
  
  public static a d() {
    return e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */