package com.alibaba.mtl.appmonitor;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.d.j;
import com.alibaba.mtl.log.e.b;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.r;

class a implements Runnable {
  private static boolean j = false;
  
  private static boolean l = false;
  
  private Application b;
  
  private boolean k;
  
  public a(Application paramApplication) {
    this.b = paramApplication;
    this.k = true;
  }
  
  private static boolean a(Context paramContext) {
    String str = b.a(paramContext);
    i.a("BackgroundTrigger", new Object[] { "[checkRuningProcess]:", str });
    return (!TextUtils.isEmpty(str) && str.indexOf(":") != -1);
  }
  
  public static void init(Application paramApplication) {
    if (!j) {
      i.a("BackgroundTrigger", new Object[] { "init BackgroundTrigger" });
      l = a(paramApplication.getApplicationContext());
      a a1 = new a(paramApplication);
      if (l) {
        r.a().a(4, a1, 60000L);
      } else if (Build.VERSION.SDK_INT >= 14) {
        a1.getClass();
        paramApplication.registerActivityLifecycleCallbacks(new a(a1, a1));
      } 
      j = true;
    } 
  }
  
  public void run() {
    int j = 0;
    int i = 0;
    i.a("BackgroundTrigger", new Object[] { "[bg check]" });
    boolean bool = b.b(this.b.getApplicationContext());
    if (this.k != bool) {
      this.k = bool;
      if (bool) {
        j.a().k();
        f[] arrayOfF = f.a();
        j = arrayOfF.length;
        while (i < j) {
          f f = arrayOfF[i];
          AppMonitorDelegate.setStatisticsInterval(f, f.c());
          i++;
        } 
        com.alibaba.mtl.log.a.m();
      } else {
        f[] arrayOfF = f.a();
        int k = arrayOfF.length;
        for (i = j; i < k; i++) {
          f f = arrayOfF[i];
          AppMonitorDelegate.setStatisticsInterval(f, f.d());
        } 
        AppMonitorDelegate.triggerUpload();
        com.alibaba.mtl.log.a.l();
      } 
    } 
    if (l)
      r.a().a(4, this, 60000L); 
  }
  
  class a implements Application.ActivityLifecycleCallbacks {
    private Runnable a;
    
    a(a this$0, Runnable param1Runnable) {
      this.a = param1Runnable;
    }
    
    public void onActivityCreated(Activity param1Activity, Bundle param1Bundle) {}
    
    public void onActivityDestroyed(Activity param1Activity) {}
    
    public void onActivityPaused(Activity param1Activity) {}
    
    public void onActivityResumed(Activity param1Activity) {}
    
    public void onActivitySaveInstanceState(Activity param1Activity, Bundle param1Bundle) {}
    
    public void onActivityStarted(Activity param1Activity) {
      r.a().f(4);
      r.a().a(4, this.a, 60000L);
    }
    
    public void onActivityStopped(Activity param1Activity) {
      r.a().f(4);
      r.a().a(4, this.a, 60000L);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */