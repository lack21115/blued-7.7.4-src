package com.qq.e.comm.plugin.y;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.o;
import com.qq.e.comm.util.GDTLogger;
import yaq.gdtadv;

class s {
  private Handler a;
  
  private Context b = GDTADManager.getInstance().getAppContext();
  
  private m c = new m(this.b);
  
  private q d = new q(this.b);
  
  private Runnable e = new Runnable(this) {
      public void run() {
        s.b(this.a);
      }
    };
  
  private Runnable f = new Runnable(this) {
      public void run() {
        s.c(this.a);
      }
    };
  
  private Runnable g = new Runnable(this) {
      public void run() {
        if (!o.a(s.a(this.a)))
          this.a.a(s.b.b); 
      }
    };
  
  private s() {
    HandlerThread handlerThread = new HandlerThread("gdt_stat_service");
    handlerThread.start();
    Looper looper = handlerThread.getLooper();
    if (looper != null) {
      this.a = new Handler(looper);
    } else {
      GDTLogger.e("Create stat handler failed!");
    } 
    if (Build.VERSION.SDK_INT >= 14 && this.b instanceof Application) {
      ak.a("Stat register activity listener", new Object[0]);
      ((Application)this.b).registerActivityLifecycleCallbacks(new a(this));
    } 
    a(this.b);
    a(b.a);
    Handler handler = this.a;
    if (handler != null)
      handler.post(new Runnable(this) {
            public void run() {
              i.a(s.a(this.a).getApplicationContext()).a();
            }
          }); 
  }
  
  public static s a() {
    return (s)gdtadv.getobjresult(14, 1, new Object[0]);
  }
  
  private <T extends n> void a(a<T> parama, T paramT) {
    gdtadv.getVresult(15, 0, new Object[] { this, parama, paramT });
  }
  
  private void b() {
    gdtadv.getVresult(16, 0, new Object[] { this });
  }
  
  private void c() {
    gdtadv.getVresult(18, 0, new Object[] { this });
  }
  
  private void d() {
    gdtadv.getVresult(21, 0, new Object[] { this });
  }
  
  private void e() {
    gdtadv.getVresult(23, 0, new Object[] { this });
  }
  
  private void f() {
    gdtadv.getVresult(24, 0, new Object[] { this });
  }
  
  public void a(Context paramContext) {
    gdtadv.getVresult(28, 0, new Object[] { this, paramContext });
  }
  
  void a(k paramk) {
    gdtadv.getVresult(29, 0, new Object[] { this, paramk });
  }
  
  void a(o paramo) {
    gdtadv.getVresult(30, 0, new Object[] { this, paramo });
  }
  
  void a(b paramb) {
    gdtadv.getVresult(31, 0, new Object[] { this, paramb });
  }
  
  static final class a implements Application.ActivityLifecycleCallbacks {
    private s a;
    
    public a(s param1s) {
      this.a = param1s;
    }
    
    public void onActivityCreated(Activity param1Activity, Bundle param1Bundle) {}
    
    public void onActivityDestroyed(Activity param1Activity) {}
    
    public void onActivityPaused(Activity param1Activity) {
      s.g(this.a);
      s.h(this.a);
    }
    
    public void onActivityResumed(Activity param1Activity) {}
    
    public void onActivitySaveInstanceState(Activity param1Activity, Bundle param1Bundle) {}
    
    public void onActivityStarted(Activity param1Activity) {
      this.a.a(s.b.d);
    }
    
    public void onActivityStopped(Activity param1Activity) {}
  }
  
  enum b {
    a, b, c, d, e;
    
    public static b[] a() {
      return (b[])f.clone();
    }
  }
  
  static final class c {
    private static final s a = new s();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\y\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */