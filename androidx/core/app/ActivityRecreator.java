package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

final class ActivityRecreator {
  protected static final Class<?> a;
  
  protected static final Field b;
  
  protected static final Field c;
  
  protected static final Method d;
  
  protected static final Method e;
  
  protected static final Method f;
  
  private static final Handler g = new Handler(Looper.getMainLooper());
  
  static {
    a = d();
    b = b();
    c = c();
    d = a(a);
    e = b(a);
    f = c(a);
  }
  
  private static Method a(Class<?> paramClass) {
    if (paramClass == null)
      return null; 
    try {
      Method method = paramClass.getDeclaredMethod("performStopActivity", new Class[] { IBinder.class, boolean.class, String.class });
      return method;
    } finally {
      paramClass = null;
    } 
  }
  
  private static boolean a() {
    return (Build.VERSION.SDK_INT == 26 || Build.VERSION.SDK_INT == 27);
  }
  
  static boolean a(Activity paramActivity) {
    if (Build.VERSION.SDK_INT >= 28) {
      paramActivity.recreate();
      return true;
    } 
    if (a() && f == null)
      return false; 
    if (e == null && d == null)
      return false; 
    try {
      Object object1 = c.get(paramActivity);
      if (object1 == null)
        return false; 
      Object object2 = b.get(paramActivity);
      if (object2 == null)
        return false; 
      Application application = paramActivity.getApplication();
      LifecycleCheckCallbacks lifecycleCheckCallbacks = new LifecycleCheckCallbacks(paramActivity);
      application.registerActivityLifecycleCallbacks(lifecycleCheckCallbacks);
      g.post(new Runnable(lifecycleCheckCallbacks, object1) {
            public void run() {
              this.a.a = this.b;
            }
          });
    } finally {
      paramActivity = null;
    } 
  }
  
  protected static boolean a(Object paramObject, Activity paramActivity) {
    try {
      Object object = c.get(paramActivity);
      if (object != paramObject)
        return false; 
      return true;
    } finally {
      paramObject = null;
      Log.e("ActivityRecreator", "Exception while fetching field values", (Throwable)paramObject);
    } 
  }
  
  private static Field b() {
    try {
      Field field = Activity.class.getDeclaredField("mMainThread");
      return field;
    } finally {
      Exception exception = null;
    } 
  }
  
  private static Method b(Class<?> paramClass) {
    if (paramClass == null)
      return null; 
    try {
      Method method = paramClass.getDeclaredMethod("performStopActivity", new Class[] { IBinder.class, boolean.class });
      return method;
    } finally {
      paramClass = null;
    } 
  }
  
  private static Field c() {
    try {
      Field field = Activity.class.getDeclaredField("mToken");
      return field;
    } finally {
      Exception exception = null;
    } 
  }
  
  private static Method c(Class<?> paramClass) {
    if (a()) {
      if (paramClass == null)
        return null; 
      try {
        Method method = paramClass.getDeclaredMethod("requestRelaunchActivity", new Class[] { IBinder.class, List.class, List.class, int.class, boolean.class, Configuration.class, Configuration.class, boolean.class, boolean.class });
        return method;
      } finally {
        paramClass = null;
      } 
    } 
    return null;
  }
  
  private static Class<?> d() {
    try {
      return Class.forName("android.app.ActivityThread");
    } finally {
      Exception exception = null;
    } 
  }
  
  static final class LifecycleCheckCallbacks implements Application.ActivityLifecycleCallbacks {
    Object a;
    
    private Activity b;
    
    private boolean c = false;
    
    private boolean d = false;
    
    private boolean e = false;
    
    LifecycleCheckCallbacks(Activity param1Activity) {
      this.b = param1Activity;
    }
    
    public void onActivityCreated(Activity param1Activity, Bundle param1Bundle) {}
    
    public void onActivityDestroyed(Activity param1Activity) {
      if (this.b == param1Activity) {
        this.b = null;
        this.d = true;
      } 
    }
    
    public void onActivityPaused(Activity param1Activity) {
      if (this.d && !this.e && !this.c && ActivityRecreator.a(this.a, param1Activity)) {
        this.e = true;
        this.a = null;
      } 
    }
    
    public void onActivityResumed(Activity param1Activity) {}
    
    public void onActivitySaveInstanceState(Activity param1Activity, Bundle param1Bundle) {}
    
    public void onActivityStarted(Activity param1Activity) {
      if (this.b == param1Activity)
        this.c = true; 
    }
    
    public void onActivityStopped(Activity param1Activity) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\app\ActivityRecreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */