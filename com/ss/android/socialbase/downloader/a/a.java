package com.ss.android.socialbase.downloader.a;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class a {
  private Application a;
  
  private final List<a> b = new ArrayList<a>();
  
  private WeakReference<Activity> c;
  
  private volatile int d = -1;
  
  private final Application.ActivityLifecycleCallbacks e = new Application.ActivityLifecycleCallbacks(this) {
      public void onActivityCreated(Activity param1Activity, Bundle param1Bundle) {}
      
      public void onActivityDestroyed(Activity param1Activity) {}
      
      public void onActivityPaused(Activity param1Activity) {}
      
      public void onActivityResumed(Activity param1Activity) {
        Activity activity;
        WeakReference<Activity> weakReference = a.a(this.a);
        if (weakReference == null) {
          weakReference = null;
        } else {
          activity = weakReference.get();
        } 
        if (activity != param1Activity)
          a.a(this.a, new WeakReference<Activity>(param1Activity)); 
        if (activity == null)
          a.b(this.a); 
      }
      
      public void onActivitySaveInstanceState(Activity param1Activity, Bundle param1Bundle) {}
      
      public void onActivityStarted(Activity param1Activity) {
        WeakReference weakReference = a.a(this.a);
        a.a(this.a, new WeakReference<Activity>(param1Activity));
        if (weakReference == null || weakReference.get() == null)
          a.b(this.a); 
      }
      
      public void onActivityStopped(Activity param1Activity) {
        WeakReference<Activity> weakReference = a.a(this.a);
        if (weakReference == null || weakReference.get() == param1Activity) {
          a.a(this.a, null);
          a.c(this.a);
        } 
      }
    };
  
  private a() {
    b();
  }
  
  public static a a() {
    return b.a();
  }
  
  private Object[] d() {
    synchronized (this.b) {
      if (this.b.size() > 0)
        return this.b.toArray(); 
    } 
    Object[] arrayOfObject = null;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return arrayOfObject;
  }
  
  private void e() {
    com.ss.android.socialbase.downloader.f.a.c("AppStatusManager", "dispatchAppForeground");
    this.d = 1;
    Object[] arrayOfObject = d();
    if (arrayOfObject != null) {
      int j = arrayOfObject.length;
      for (int i = 0; i < j; i++)
        ((a)arrayOfObject[i]).b(); 
    } 
  }
  
  private void f() {
    com.ss.android.socialbase.downloader.f.a.c("AppStatusManager", "dispatchAppBackground");
    int i = 0;
    this.d = 0;
    Object[] arrayOfObject = d();
    if (arrayOfObject != null) {
      int j = arrayOfObject.length;
      while (i < j) {
        ((a)arrayOfObject[i]).c();
        i++;
      } 
    } 
  }
  
  private void g() {
    Activity activity = h();
    if (this.d == -1) {
      if (activity != null) {
        this.c = new WeakReference<Activity>(activity);
        this.d = 1;
        return;
      } 
      this.d = 0;
    } 
  }
  
  private Activity h() {
    try {
      Class<?> clazz = Class.forName("android.app.ActivityThread");
      Object object = clazz.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
      Field field = clazz.getDeclaredField("mActivities");
      field.setAccessible(true);
      object = field.get(object);
    } finally {
      Exception exception = null;
    } 
    return null;
  }
  
  public void a(a parama) {
    if (parama == null)
      return; 
    synchronized (this.b) {
      if (!this.b.contains(parama))
        this.b.add(parama); 
      return;
    } 
  }
  
  public void b() {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Landroid/app/Application;
    //   4: ifnonnull -> 57
    //   7: invokestatic B : ()Landroid/content/Context;
    //   10: astore_1
    //   11: aload_1
    //   12: instanceof android/app/Application
    //   15: ifeq -> 57
    //   18: ldc com/ss/android/socialbase/downloader/a/a
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield a : Landroid/app/Application;
    //   25: ifnonnull -> 47
    //   28: aload_0
    //   29: aload_1
    //   30: checkcast android/app/Application
    //   33: putfield a : Landroid/app/Application;
    //   36: aload_0
    //   37: getfield a : Landroid/app/Application;
    //   40: aload_0
    //   41: getfield e : Landroid/app/Application$ActivityLifecycleCallbacks;
    //   44: invokevirtual registerActivityLifecycleCallbacks : (Landroid/app/Application$ActivityLifecycleCallbacks;)V
    //   47: ldc com/ss/android/socialbase/downloader/a/a
    //   49: monitorexit
    //   50: return
    //   51: astore_1
    //   52: ldc com/ss/android/socialbase/downloader/a/a
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    //   57: return
    // Exception table:
    //   from	to	target	type
    //   21	47	51	finally
    //   47	50	51	finally
    //   52	55	51	finally
  }
  
  public void b(a parama) {
    synchronized (this.b) {
      this.b.remove(parama);
      return;
    } 
  }
  
  public boolean c() {
    int j = this.d;
    int i = j;
    if (j == -1) {
      g();
      i = this.d;
    } 
    return (i == 1);
  }
  
  public static interface a {
    void b();
    
    void c();
  }
  
  static class b {
    private static final a a = new a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */