package com.blued.android.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.blued.android.core.ui.AppLifecycleCallbacks;
import com.blued.android.core.ui.UIPageCallback;
import com.blued.android.core.utils.Log;
import com.blued.android.core.utils.toast.ToastUtils;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AppInfo {
  private static String G;
  
  public static String a = "";
  
  public static String b;
  
  public static String c = "";
  
  public static String d = "";
  
  public static String e = "";
  
  public static String f = "";
  
  public static String g = "";
  
  public static int h = 0;
  
  public static String i = "";
  
  public static float j = 0.0F;
  
  public static int k = 0;
  
  public static int l = 0;
  
  public static int m = 0;
  
  public static String n = "";
  
  public static boolean o = false;
  
  public static int p = 17170445;
  
  public static int q = 17170445;
  
  public static int r = 17170445;
  
  public static float s = 0.4F;
  
  public static float t = 0.4F;
  
  public static long u = 524288000L;
  
  public static boolean v = false;
  
  private static AppInfo w;
  
  private boolean A = true;
  
  private boolean B = false;
  
  private Handler C = null;
  
  private Set<AppHandoverListener> D = null;
  
  private UIPageCallback E = null;
  
  private Gson F = null;
  
  private Application x;
  
  private AppLifecycleCallbacks y;
  
  private String z;
  
  private AppInfo(Application paramApplication, boolean paramBoolean) {
    this.x = paramApplication;
    this.y = new AppLifecycleCallbacks(paramApplication);
    this.B = paramBoolean;
    this.C = new Handler(Looper.getMainLooper());
    a = paramApplication.getPackageName();
    this.F = new Gson();
    if (paramBoolean)
      if (paramBoolean) {
        try {
          File file = s();
          if (file != null) {
            Log.a((Context)paramApplication, true, file);
            G = file.getAbsolutePath();
            return;
          } 
          Log.a((Context)paramApplication, false, null);
          return;
        } catch (IOException iOException) {
          iOException.printStackTrace();
        } 
      } else {
        Log.a((Context)iOException, false, null);
        return;
      }  
  }
  
  public static File a(Context paramContext) {
    File file = new File(paramContext.getFilesDir(), "blued_debug_log");
    if (!file.exists())
      file.mkdirs(); 
    return file;
  }
  
  public static void a() {
    b = AppMethods.b(AppMethods.g(), null);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("useragent:");
    stringBuilder.append(b);
    Log.a("AppInfo", stringBuilder.toString());
  }
  
  public static void a(Activity paramActivity) {
    if (!c())
      return; 
    AppInfo appInfo = w;
    appInfo.A = false;
    Set<AppHandoverListener> set = appInfo.D;
    if (set != null) {
      Iterator<AppHandoverListener> iterator = set.iterator();
      while (iterator.hasNext())
        ((AppHandoverListener)iterator.next()).a(paramActivity); 
    } 
  }
  
  private void a(Application paramApplication) {
    ToastUtils.a(paramApplication);
  }
  
  public static void a(Application paramApplication, String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: ldc com/blued/android/core/AppInfo
    //   2: monitorenter
    //   3: getstatic com/blued/android/core/AppInfo.w : Lcom/blued/android/core/AppInfo;
    //   6: ifnonnull -> 41
    //   9: new com/blued/android/core/AppInfo
    //   12: dup
    //   13: aload_0
    //   14: iload_2
    //   15: invokespecial <init> : (Landroid/app/Application;Z)V
    //   18: putstatic com/blued/android/core/AppInfo.w : Lcom/blued/android/core/AppInfo;
    //   21: getstatic com/blued/android/core/AppInfo.w : Lcom/blued/android/core/AppInfo;
    //   24: aload_1
    //   25: putfield z : Ljava/lang/String;
    //   28: getstatic com/blued/android/core/AppInfo.w : Lcom/blued/android/core/AppInfo;
    //   31: invokespecial r : ()V
    //   34: getstatic com/blued/android/core/AppInfo.w : Lcom/blued/android/core/AppInfo;
    //   37: aload_0
    //   38: invokespecial a : (Landroid/app/Application;)V
    //   41: ldc com/blued/android/core/AppInfo
    //   43: monitorexit
    //   44: return
    //   45: astore_0
    //   46: ldc com/blued/android/core/AppInfo
    //   48: monitorexit
    //   49: aload_0
    //   50: athrow
    // Exception table:
    //   from	to	target	type
    //   3	41	45	finally
  }
  
  public static void a(AppHandoverListener paramAppHandoverListener) {
    if (!c())
      return; 
    if (paramAppHandoverListener != null) {
      AppInfo appInfo = w;
      if (appInfo.D == null)
        appInfo.D = new HashSet<AppHandoverListener>(); 
      w.D.add(paramAppHandoverListener);
    } 
  }
  
  public static void a(UIPageCallback paramUIPageCallback) {
    if (!c())
      return; 
    w.E = paramUIPageCallback;
  }
  
  public static void a(String paramString) {
    AppInfo appInfo = w;
    c = paramString;
  }
  
  public static void a(boolean paramBoolean, int paramInt1, int paramInt2) {
    a(paramBoolean, paramInt1, 17170445, paramInt2);
  }
  
  public static void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3) {
    if (!c())
      return; 
    AppInfo appInfo = w;
    o = paramBoolean;
    p = paramInt1;
    q = paramInt2;
    r = paramInt3;
  }
  
  public static UIPageCallback b() {
    return !c() ? null : w.E;
  }
  
  public static void b(Activity paramActivity) {
    if (j != 0.0F)
      return; 
    DisplayMetrics displayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    j = displayMetrics.density;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(displayMetrics.widthPixels);
    stringBuilder.append("*");
    stringBuilder.append(displayMetrics.heightPixels);
    i = stringBuilder.toString();
    k = displayMetrics.widthPixels * displayMetrics.heightPixels;
    if (displayMetrics.heightPixels >= displayMetrics.widthPixels) {
      l = displayMetrics.widthPixels;
      m = displayMetrics.heightPixels;
    } else {
      l = displayMetrics.heightPixels;
      m = displayMetrics.widthPixels;
    } 
    a();
  }
  
  public static void b(String paramString) {
    AppLifecycleCallbacks.a(paramString);
  }
  
  public static void c(String paramString) {
    if (!c())
      return; 
    AppInfo appInfo = w;
    d = paramString;
  }
  
  public static boolean c() {
    return (w != null);
  }
  
  public static Context d() {
    return (Context)(!c() ? null : w.x);
  }
  
  public static String e() {
    return !c() ? null : w.z;
  }
  
  public static Gson f() {
    return !c() ? null : w.F;
  }
  
  public static boolean g() {
    return w.A;
  }
  
  public static void h() {
    if (!c())
      return; 
    AppInfo appInfo = w;
    appInfo.A = true;
    Set<AppHandoverListener> set = appInfo.D;
    if (set != null) {
      Iterator<AppHandoverListener> iterator = set.iterator();
      while (iterator.hasNext())
        ((AppHandoverListener)iterator.next()).a(); 
    } 
  }
  
  public static boolean i() {
    if (!c())
      return false; 
    AppInfo appInfo = w;
    return o;
  }
  
  public static int j() {
    if (!c())
      return 17170445; 
    AppInfo appInfo = w;
    return r;
  }
  
  public static int k() {
    if (!c())
      return 17170445; 
    AppInfo appInfo = w;
    return p;
  }
  
  public static int l() {
    if (!c())
      return 17170445; 
    AppInfo appInfo = w;
    return q;
  }
  
  public static boolean m() {
    return !c() ? false : w.B;
  }
  
  public static Handler n() {
    return !c() ? null : w.C;
  }
  
  public static boolean o() {
    return (TextUtils.equals("2", w.z) || TextUtils.equals("4", w.z));
  }
  
  public static boolean p() {
    return (TextUtils.equals("1", w.z) || TextUtils.equals("6", w.z) || TextUtils.equals("7", w.z));
  }
  
  public static void q() {
    e = AppMethods.e();
    if (!AppMethods.d(e))
      e = ""; 
  }
  
  private void r() {
    f = ((TelephonyManager)this.x.getSystemService("phone")).getSimOperator();
    try {
      PackageInfo packageInfo = this.x.getPackageManager().getPackageInfo(this.x.getPackageName(), 0);
      g = packageInfo.versionName;
      h = packageInfo.versionCode;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      nameNotFoundException.printStackTrace();
    } 
    a();
  }
  
  private File s() {
    File file = new File(a((Context)this.x), "blued_core.txt");
    if (file.exists() && file.length() > 1024000L && !file.delete()) {
      Log.e("AppInfo", "文件大小超过限制, 但删除失败");
      return null;
    } 
    try {
      file.createNewFile();
      return file;
    } catch (IOException iOException) {
      iOException.printStackTrace();
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\AppInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */