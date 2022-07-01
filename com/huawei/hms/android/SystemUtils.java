package com.huawei.hms.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.Locale;

public class SystemUtils {
  private static String a() {
    return getSystemProperties("ro.product.locale.region", "");
  }
  
  private static String b() {
    return getSystemProperties("ro.product.locale", "");
  }
  
  public static String getLocalCountry() {
    Locale locale = Locale.getDefault();
    return (locale != null) ? locale.getCountry() : "";
  }
  
  public static String getNetType(Context paramContext) {
    if (paramContext != null) {
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (connectivityManager != null) {
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isAvailable())
          return networkInfo.getTypeName(); 
      } 
    } 
    return "";
  }
  
  public static String getSystemProperties(String paramString1, String paramString2) {
    try {
      Class<?> clazz = Class.forName("android.os.SystemProperties");
      return (String)clazz.getDeclaredMethod("get", new Class[] { String.class, String.class }).invoke(clazz, new Object[] { paramString1, paramString2 });
    } catch (ClassNotFoundException|NoSuchMethodException|IllegalAccessException|IllegalArgumentException|java.lang.reflect.InvocationTargetException|ClassCastException classNotFoundException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("An exception occurred while reading: getSystemProperties:");
      stringBuilder.append(paramString1);
      HMSLog.e("SystemUtils", stringBuilder.toString());
      return paramString2;
    } 
  }
  
  public static boolean isChinaROM() {
    String str = a();
    if (!TextUtils.isEmpty(str))
      return "cn".equalsIgnoreCase(str); 
    str = b();
    if (!TextUtils.isEmpty(str))
      return str.toLowerCase(Locale.US).contains("cn"); 
    str = getLocalCountry();
    return !TextUtils.isEmpty(str) ? "cn".equalsIgnoreCase(str) : false;
  }
  
  public static boolean isEMUI() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("is Emui :");
    stringBuilder.append(HwBuildEx.VERSION.EMUI_SDK_INT);
    HMSLog.i("SystemUtils", stringBuilder.toString());
    return (HwBuildEx.VERSION.EMUI_SDK_INT > 0);
  }
  
  public static boolean isSystemApp(Context paramContext, String paramString) {
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(paramString, 16384);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("isSystemApp Exception: ");
      stringBuilder.append(nameNotFoundException);
      HMSLog.e("SystemUtils", stringBuilder.toString());
      nameNotFoundException = null;
    } 
    return (nameNotFoundException != null && (((PackageInfo)nameNotFoundException).applicationInfo.flags & 0x1) > 0);
  }
  
  public static boolean isTVDevice() {
    return getSystemProperties("ro.build.characteristics", "default").equalsIgnoreCase("tv");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\android\SystemUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */