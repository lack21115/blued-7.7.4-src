package com.bun.lib;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.Keep;
import android.text.TextUtils;

public class sysParamters {
  private static volatile sysParamters d;
  
  private String a;
  
  private String b;
  
  private String c;
  
  @Keep
  private String sdk_version = "10012";
  
  @Keep
  private String sdk_vname = "1.0.12";
  
  private static PackageInfo a(Context paramContext, String paramString) {
    try {
      return paramContext.getPackageManager().getPackageInfo(paramString, 0);
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static String a(Context paramContext) {
    if (paramContext == null)
      return "0.1.100"; 
    PackageInfo packageInfo = a(paramContext, paramContext.getPackageName());
    return (packageInfo == null) ? null : packageInfo.versionName;
  }
  
  public static String a(String paramString1, String paramString2) {
    try {
      return (String)clazz.getMethod("get", new Class[] { String.class, String.class }).invoke(clazz, new Object[] { paramString1, "unknown" });
    } catch (Exception exception) {
      return paramString2;
    } finally {
      paramString1 = null;
    } 
  }
  
  public static String e() {
    return "";
  }
  
  public static sysParamters f() {
    // Byte code:
    //   0: getstatic com/bun/lib/sysParamters.d : Lcom/bun/lib/sysParamters;
    //   3: ifnonnull -> 28
    //   6: ldc com/bun/lib/sysParamters
    //   8: monitorenter
    //   9: getstatic com/bun/lib/sysParamters.d : Lcom/bun/lib/sysParamters;
    //   12: ifnonnull -> 25
    //   15: new com/bun/lib/sysParamters
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/bun/lib/sysParamters.d : Lcom/bun/lib/sysParamters;
    //   25: ldc com/bun/lib/sysParamters
    //   27: monitorexit
    //   28: getstatic com/bun/lib/sysParamters.d : Lcom/bun/lib/sysParamters;
    //   31: areturn
    //   32: astore_0
    //   33: ldc com/bun/lib/sysParamters
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    // Exception table:
    //   from	to	target	type
    //   9	25	32	finally
    //   25	28	32	finally
    //   33	36	32	finally
  }
  
  public static String g() {
    ApplicationInfo applicationInfo = b.b().getApplicationInfo();
    return (applicationInfo != null && !TextUtils.isEmpty(applicationInfo.packageName)) ? applicationInfo.packageName : h();
  }
  
  private static String h() {
    return b.b().getPackageName();
  }
  
  public String a() {
    if (!TextUtils.isEmpty(this.a))
      return this.a; 
    this.a = a(b.b());
    return this.a;
  }
  
  public String b() {
    if (!TextUtils.isEmpty(this.c))
      return this.c; 
    this.c = Uri.encode(Build.MANUFACTURER);
    return this.c;
  }
  
  public String c() {
    if (!TextUtils.isEmpty(this.b))
      return this.b; 
    this.b = Build.MODEL;
    this.b = this.b.replace(" ", "-");
    return this.b;
  }
  
  public String d() {
    return this.sdk_version;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\lib\sysParamters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */