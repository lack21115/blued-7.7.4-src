package com.cmic.sso.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.lang.reflect.Method;

public class t {
  public static int a(Context paramContext) {
    try {
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
      NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
      if (networkInfo != null) {
        if (!networkInfo.isAvailable())
          return 0; 
        int i = networkInfo.getType();
        if (i == 1) {
          f.b("TelephonyUtils", "WIFI");
          boolean bool = k.a(paramContext, "android.permission.CHANGE_NETWORK_STATE");
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("CHANGE_NETWORK_STATE=");
          stringBuilder.append(bool);
          f.a("TelephonyUtils", stringBuilder.toString());
          if (bool && a(paramContext, connectivityManager)) {
            f.b("TelephonyUtils", "流量数据 WIFI 同开");
            return 3;
          } 
        } else {
          if (i == 0) {
            f.b("TelephonyUtils", "流量");
            return 1;
          } 
          return 0;
        } 
      } else {
        return 0;
      } 
    } catch (Exception exception) {
      return 0;
    } 
    return 2;
  }
  
  public static String a() {
    return Build.BRAND;
  }
  
  private static boolean a(Context paramContext, ConnectivityManager paramConnectivityManager) {
    try {
      if (TextUtils.isEmpty(o.a(paramContext).a(false)))
        return false; 
      Method method = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
      method.setAccessible(true);
      boolean bool = ((Boolean)method.invoke(paramConnectivityManager, new Object[0])).booleanValue();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("data is on ---------");
      stringBuilder.append(bool);
      f.b("TelephonyUtils", stringBuilder.toString());
      return bool;
    } catch (Exception exception) {
      f.a("TelephonyUtils", "data is on ----反射出错-----");
      exception.printStackTrace();
      return false;
    } 
  }
  
  public static String b() {
    return Build.MODEL;
  }
  
  public static boolean b(Context paramContext) {
    TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    boolean bool = true;
    if (telephonyManager != null) {
      if (1 != telephonyManager.getSimState())
        return true; 
      bool = false;
    } 
    return bool;
  }
  
  public static String c() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("android");
    stringBuilder.append(Build.VERSION.RELEASE);
    return stringBuilder.toString();
  }
  
  public static boolean d() {
    String str = Build.MANUFACTURER;
    f.a("brand", str);
    return "HUAWEI".equalsIgnoreCase(str);
  }
  
  public static boolean e() {
    return (Build.VERSION.SDK_INT <= 28);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sd\\utils\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */