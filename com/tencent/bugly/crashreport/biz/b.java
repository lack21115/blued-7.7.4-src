package com.tencent.bugly.crashreport.biz;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.common.strategy.a;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.List;

public class b {
  public static a a;
  
  private static boolean b = false;
  
  private static int c = 10;
  
  private static long d = 300000L;
  
  private static long e = 30000L;
  
  private static long f = 0L;
  
  private static int g = 0;
  
  private static long h = 0L;
  
  private static long i = 0L;
  
  private static long j = 0L;
  
  private static Application.ActivityLifecycleCallbacks k;
  
  private static Class<?> l;
  
  private static boolean m = true;
  
  public static void a() {
    a a1 = a;
    if (a1 != null)
      a1.a(2, false, 0L); 
  }
  
  public static void a(long paramLong) {
    long l = paramLong;
    if (paramLong < 0L)
      l = (a.a().c()).q; 
    f = l;
  }
  
  public static void a(Context paramContext) {
    if (b) {
      if (paramContext == null)
        return; 
      Application application = null;
      if (Build.VERSION.SDK_INT >= 14) {
        if (paramContext.getApplicationContext() instanceof Application)
          application = (Application)paramContext.getApplicationContext(); 
        if (application != null)
          try {
            if (k != null)
              application.unregisterActivityLifecycleCallbacks(k); 
          } catch (Exception exception) {
            if (!x.a(exception))
              exception.printStackTrace(); 
          }  
      } 
      b = false;
    } 
  }
  
  public static void a(Context paramContext, BuglyStrategy paramBuglyStrategy) {
    long l;
    if (b)
      return; 
    m = (a.a(paramContext)).e;
    a = new a(paramContext, m);
    b = true;
    if (paramBuglyStrategy != null) {
      l = paramBuglyStrategy.getUserInfoActivity();
      l = paramBuglyStrategy.getAppReportDelay();
    } else {
      l = 0L;
    } 
    if (l <= 0L) {
      c(paramContext, paramBuglyStrategy);
      return;
    } 
    w.a().a(new Runnable(paramContext, paramBuglyStrategy) {
          public final void run() {
            b.b(this.a, this.b);
          }
        }l);
  }
  
  public static void a(StrategyBean paramStrategyBean, boolean paramBoolean) {
    a a1 = a;
    if (a1 != null && !paramBoolean) {
      w w = w.a();
      if (w != null)
        w.a((Runnable)new Object(a1)); 
    } 
    if (paramStrategyBean == null)
      return; 
    if (paramStrategyBean.q > 0L)
      e = paramStrategyBean.q; 
    if (paramStrategyBean.w > 0)
      c = paramStrategyBean.w; 
    if (paramStrategyBean.x > 0L)
      d = paramStrategyBean.x; 
  }
  
  private static void c(Context paramContext, BuglyStrategy paramBuglyStrategy) {
    boolean bool1;
    boolean bool2;
    if (paramBuglyStrategy != null) {
      bool2 = paramBuglyStrategy.recordUserInfoOnceADay();
      bool1 = paramBuglyStrategy.isEnableUserInfo();
    } else {
      bool1 = true;
      bool2 = false;
    } 
    if (bool2) {
      a a2 = a.a(paramContext);
      String str = a2.d;
      List<UserInfoBean> list = a.a(str);
      if (list != null)
        for (int i = 0; i < list.size(); i++) {
          UserInfoBean userInfoBean = list.get(i);
          if (userInfoBean.n.equals(a2.k) && userInfoBean.b == 1) {
            long l = z.b();
            if (l > 0L) {
              if (userInfoBean.e >= l) {
                if (userInfoBean.f <= 0L) {
                  a a3 = a;
                  w w = w.a();
                  if (w != null)
                    w.a((Runnable)new Object(a3)); 
                } 
                i = 0;
                // Byte code: goto -> 181
              } 
            } else {
              break;
            } 
          } 
        }  
      boolean bool = true;
      if (!bool)
        return; 
      bool1 = false;
    } 
    a a1 = a.b();
    BuglyStrategy buglyStrategy = null;
    if (a1 != null) {
      String str;
      StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
      int j = arrayOfStackTraceElement.length;
      paramBuglyStrategy = null;
      int i = 0;
      boolean bool = false;
      while (i < j) {
        StackTraceElement stackTraceElement = arrayOfStackTraceElement[i];
        if (stackTraceElement.getMethodName().equals("onCreate"))
          str = stackTraceElement.getClassName(); 
        if (stackTraceElement.getClassName().equals("android.app.Activity"))
          bool = true; 
        i++;
      } 
      if (str != null) {
        if (bool) {
          a1.a(true);
        } else {
          str = "background";
        } 
      } else {
        str = "unknown";
      } 
      a1.q = str;
    } 
    if (bool1 && Build.VERSION.SDK_INT >= 14) {
      Application application;
      paramBuglyStrategy = buglyStrategy;
      if (paramContext.getApplicationContext() instanceof Application)
        application = (Application)paramContext.getApplicationContext(); 
      if (application != null)
        try {
          if (k == null)
            k = new Application.ActivityLifecycleCallbacks() {
                public final void onActivityCreated(Activity param1Activity, Bundle param1Bundle) {
                  String str;
                  if (param1Activity != null) {
                    str = param1Activity.getClass().getName();
                  } else {
                    str = "unknown";
                  } 
                  if (b.b() != null && !b.b().getName().equals(str))
                    return; 
                  x.c(">>> %s onCreated <<<", new Object[] { str });
                  a a = a.b();
                  if (a != null)
                    a.E.add(b.a(str, "onCreated")); 
                }
                
                public final void onActivityDestroyed(Activity param1Activity) {
                  String str;
                  if (param1Activity != null) {
                    str = param1Activity.getClass().getName();
                  } else {
                    str = "unknown";
                  } 
                  if (b.b() != null && !b.b().getName().equals(str))
                    return; 
                  x.c(">>> %s onDestroyed <<<", new Object[] { str });
                  a a = a.b();
                  if (a != null)
                    a.E.add(b.a(str, "onDestroyed")); 
                }
                
                public final void onActivityPaused(Activity param1Activity) {
                  String str;
                  if (param1Activity != null) {
                    str = param1Activity.getClass().getName();
                  } else {
                    str = "unknown";
                  } 
                  if (b.b() != null && !b.b().getName().equals(str))
                    return; 
                  x.c(">>> %s onPaused <<<", new Object[] { str });
                  a a = a.b();
                  if (a == null)
                    return; 
                  a.E.add(b.a(str, "onPaused"));
                  a.a(false);
                  a.s = System.currentTimeMillis();
                  a.t = a.s - a.r;
                  b.c(a.s);
                  if (a.t < 0L)
                    a.t = 0L; 
                  if (param1Activity != null) {
                    a.q = "background";
                    return;
                  } 
                  a.q = "unknown";
                }
                
                public final void onActivityResumed(Activity param1Activity) {
                  String str;
                  long l1;
                  if (param1Activity != null) {
                    str = param1Activity.getClass().getName();
                  } else {
                    str = "unknown";
                  } 
                  if (b.b() != null && !b.b().getName().equals(str))
                    return; 
                  x.c(">>> %s onResumed <<<", new Object[] { str });
                  a a = a.b();
                  if (a == null)
                    return; 
                  a.E.add(b.a(str, "onResumed"));
                  a.a(true);
                  a.q = str;
                  a.r = System.currentTimeMillis();
                  a.u = a.r - b.c();
                  long l2 = a.r - b.d();
                  if (b.e() > 0L) {
                    l1 = b.e();
                  } else {
                    l1 = b.f();
                  } 
                  if (l2 > l1) {
                    a.d();
                    b.g();
                    x.a("[session] launch app one times (app in background %d seconds and over %d seconds)", new Object[] { Long.valueOf(l2 / 1000L), Long.valueOf(b.f() / 1000L) });
                    if (b.h() % b.i() == 0) {
                      b.a.a(4, b.j(), 0L);
                      return;
                    } 
                    b.a.a(4, false, 0L);
                    l1 = System.currentTimeMillis();
                    if (l1 - b.k() > b.l()) {
                      b.b(l1);
                      x.a("add a timer to upload hot start user info", new Object[0]);
                      if (b.j()) {
                        a a1 = b.a;
                        l1 = b.l();
                        w.a().a(new a.a(a1, null, true), l1);
                      } 
                    } 
                  } 
                }
                
                public final void onActivitySaveInstanceState(Activity param1Activity, Bundle param1Bundle) {}
                
                public final void onActivityStarted(Activity param1Activity) {}
                
                public final void onActivityStopped(Activity param1Activity) {}
              }; 
          application.registerActivityLifecycleCallbacks(k);
        } catch (Exception exception) {
          if (!x.a(exception))
            exception.printStackTrace(); 
        }  
    } 
    if (m) {
      i = System.currentTimeMillis();
      a.a(1, false, 0L);
      x.a("[session] launch app, new start", new Object[0]);
      a.a();
      a a2 = a;
      w.a().a(new a.c(a2, 21600000L), 21600000L);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\crashreport\biz\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */