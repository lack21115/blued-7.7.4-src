package com.huawei.updatesdk.b.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.updatesdk.a.a.c.d;
import com.huawei.updatesdk.service.otaupdate.h;
import java.io.File;
import java.lang.reflect.Field;

public class b {
  private static Integer a;
  
  private static boolean b = false;
  
  private static boolean c = false;
  
  private static Field d;
  
  public static int a(PackageInfo paramPackageInfo) {
    ApplicationInfo applicationInfo = paramPackageInfo.applicationInfo;
    return ((applicationInfo.flags & 0x1) == 0) ? 0 : (a(applicationInfo) ? 1 : 2);
  }
  
  public static int a(String paramString) {
    ApplicationInfo applicationInfo;
    Context context = com.huawei.updatesdk.a.b.a.a.c().a();
    try {
      PackageInfo packageInfo = context.getPackageManager().getPackageInfo(paramString, 128);
      if (packageInfo != null) {
        applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo != null && applicationInfo.metaData != null && packageInfo.applicationInfo.metaData.containsKey("com.huawei.maple.flag"))
          return 1; 
      } 
      return 0;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getMapleStatus not found: ");
      stringBuilder.append((String)applicationInfo);
      com.huawei.updatesdk.a.a.b.a.a.a.b("PackageUtils", stringBuilder.toString());
      return 0;
    } 
  }
  
  public static PackageInfo a(String paramString, Context paramContext) {
    try {
      return paramContext.getPackageManager().getPackageInfo(paramString, 64);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("not found: ");
      stringBuilder.append(paramString);
      com.huawei.updatesdk.a.a.b.a.a.a.b("PackageUtils", stringBuilder.toString());
      return null;
    } 
  }
  
  public static b a(Context paramContext, String paramString) {
    b b1 = b.a;
    if (paramContext == null)
      return b1; 
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      if (packageInfo != null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("appmarket info,");
        stringBuilder.append("versioncode = ");
        stringBuilder.append(packageInfo.versionCode);
        stringBuilder.append("versioncode = ");
        stringBuilder.append(packageInfo.versionName);
        Log.i("PackageUtils", stringBuilder.toString());
        return (packageInfo.versionCode < 70203000) ? b.c : b.b;
      } 
      return b1;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("isInstallByPackage Exception:");
      stringBuilder.append(exception.toString());
      com.huawei.updatesdk.a.a.b.a.a.a.d("PackageUtils", stringBuilder.toString());
      return b1;
    } 
  }
  
  public static void a() {
    Thread thread = new Thread(new c(null));
    thread.setName("delete market file task");
    thread.setUncaughtExceptionHandler(new a());
    thread.start();
  }
  
  private static boolean a(ApplicationInfo paramApplicationInfo) {
    int i = paramApplicationInfo.flags;
    Integer integer = c();
    if (integer != null && (i & integer.intValue()) != 0)
      return true; 
    Field field = b();
    if (field != null)
      try {
        i = field.getInt(paramApplicationInfo);
        if ((i & 0x2000000) != 0)
          return true; 
      } catch (IllegalAccessException illegalAccessException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("can not get hwflags");
        String str = illegalAccessException.toString();
        stringBuilder.append(str);
        com.huawei.updatesdk.a.a.b.a.a.a.a("PackageUtils", stringBuilder.toString());
      } catch (IllegalArgumentException illegalArgumentException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("can not get hwflags");
        String str = illegalArgumentException.toString();
      }  
    return false;
  }
  
  private static int b(Context paramContext, String paramString) {
    String str1;
    StringBuilder stringBuilder;
    String str2 = paramString;
    if (TextUtils.isEmpty(paramString))
      str2 = "com.huawei.appmarket"; 
    try {
      return (paramContext.getPackageManager().getPackageInfo(str2, 0)).versionCode;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("isInstallByPackage NameNotFoundException:");
      str1 = nameNotFoundException.toString();
    } catch (UnsupportedOperationException unsupportedOperationException) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("isInstallByPackage UnsupportedOperationException:");
      str1 = unsupportedOperationException.toString();
    } 
    stringBuilder.append(str1);
    com.huawei.updatesdk.a.a.b.a.a.a.d("PackageUtils", stringBuilder.toString());
    return 0;
  }
  
  public static Field b() {
    if (c)
      return d; 
    try {
      d = ApplicationInfo.class.getField("hwFlags");
    } catch (NoSuchFieldException noSuchFieldException) {
      com.huawei.updatesdk.a.a.b.a.a.a.a("PackageUtils", "can not find hwFlags");
    } 
    c = true;
    return d;
  }
  
  public static Integer c() {
    if (b)
      return a; 
    try {
      Class<?> clazz = Class.forName("android.content.pm.PackageParser");
      a = Integer.valueOf(clazz.getDeclaredField("PARSE_IS_REMOVABLE_PREINSTALLED_APK").getInt(clazz));
    } catch (NoSuchFieldException noSuchFieldException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("isDelApp error NoSuchFieldException:");
      String str = noSuchFieldException.toString();
      stringBuilder.append(str);
      str = stringBuilder.toString();
      com.huawei.updatesdk.a.a.b.a.a.a.a("PackageUtils", str);
    } catch (ClassNotFoundException classNotFoundException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("isDelApp error ClassNotFoundException:");
      String str = classNotFoundException.toString();
    } catch (IllegalAccessException illegalAccessException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("isDelApp error IllegalAccessException:");
      String str = illegalAccessException.toString();
    } catch (IllegalArgumentException illegalArgumentException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("isDelApp error IllegalArgumentException:");
      String str = illegalArgumentException.toString();
    } catch (Exception exception) {
      String str = exception.toString();
    } 
    b = true;
    return a;
  }
  
  public static boolean c(Context paramContext, String paramString) {
    boolean bool = false;
    if (paramContext != null) {
      if (TextUtils.isEmpty(paramString))
        return false; 
      try {
        PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(paramString, 0);
        if (packageInfo != null)
          bool = true; 
        return bool;
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("isAppInstalled NameNotFoundException:");
        stringBuilder.append(exception.toString());
        com.huawei.updatesdk.a.a.b.a.a.a.d("PackageUtils", stringBuilder.toString());
      } 
    } 
    return false;
  }
  
  public static boolean d(Context paramContext, String paramString) {
    return h.g().e() ? true : ((b(paramContext, paramString) > 90000000));
  }
  
  public static boolean e(Context paramContext, String paramString) {
    return h.g().e() ? true : ((b(paramContext, paramString) > 100200000));
  }
  
  static final class a implements Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread param1Thread, Throwable param1Throwable) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(param1Thread.getName());
      stringBuilder.append(" : ");
      stringBuilder.append(param1Throwable.getMessage());
      com.huawei.updatesdk.a.a.b.a.a.a.a("PackageUtils", stringBuilder.toString());
    }
  }
  
  public enum b {
    a, b, c;
  }
  
  static class c implements Runnable {
    private c() {}
    
    public void run() {
      com.huawei.updatesdk.a.a.b.a.a.a.a("PackageManagerRunnable", "PackageManagerRunnable run!!!!");
      d.a(new File(com.huawei.updatesdk.a.b.b.c.b()));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\b\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */