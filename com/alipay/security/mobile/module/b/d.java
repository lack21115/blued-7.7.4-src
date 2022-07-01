package com.alipay.security.mobile.module.b;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.alipay.security.mobile.module.a.a;
import java.io.File;

public final class d {
  private static d a = new d();
  
  public static d a() {
    return a;
  }
  
  private static String a(String paramString1, String paramString2) {
    try {
      return (String)Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class, String.class }).invoke(null, new Object[] { paramString1, paramString2 });
    } catch (Exception exception) {
      return paramString2;
    } 
  }
  
  public static boolean a(Context paramContext) {
    try {
      if (!Build.HARDWARE.contains("goldfish") && !Build.PRODUCT.contains("sdk")) {
        if (Build.FINGERPRINT.contains("generic"))
          return true; 
        TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
        if (telephonyManager != null) {
          String str = telephonyManager.getDeviceId();
          if (str != null) {
            int i = str.length();
            if (i != 0)
              for (int j = 0; j < i; j++) {
                if (!Character.isWhitespace(str.charAt(j)) && str.charAt(j) != '0') {
                  j = 0;
                  // Byte code: goto -> 143
                } 
              }  
          } 
        } else {
          return a.a(Settings.Secure.getString(paramContext.getContentResolver(), "android_id"));
        } 
      } else {
        return true;
      } 
    } catch (Exception exception) {
      return false;
    } 
    boolean bool = true;
    return bool ? true : a.a(Settings.Secure.getString(exception.getContentResolver(), "android_id"));
  }
  
  public static String b() {
    return "android";
  }
  
  public static boolean c() {
    int i = 0;
    while (true) {
      if (i < 5) {
        try {
          StringBuilder stringBuilder = new StringBuilder();
          (new String[5])[0] = "/system/bin/";
          (new String[5])[1] = "/system/xbin/";
          (new String[5])[2] = "/system/sbin/";
          (new String[5])[3] = "/sbin/";
          (new String[5])[4] = "/vendor/bin/";
          stringBuilder.append((new String[5])[i]);
          stringBuilder.append("su");
          boolean bool = (new File(stringBuilder.toString())).exists();
          if (bool)
            return true; 
          i++;
        } catch (Exception exception) {
          return false;
        } 
        continue;
      } 
      return false;
    } 
  }
  
  public static String d() {
    return Build.BOARD;
  }
  
  public static String e() {
    return Build.BRAND;
  }
  
  public static String f() {
    return Build.DEVICE;
  }
  
  public static String g() {
    return Build.DISPLAY;
  }
  
  public static String h() {
    return Build.VERSION.INCREMENTAL;
  }
  
  public static String i() {
    return Build.MANUFACTURER;
  }
  
  public static String j() {
    return Build.MODEL;
  }
  
  public static String k() {
    return Build.PRODUCT;
  }
  
  public static String l() {
    return Build.VERSION.RELEASE;
  }
  
  public static String m() {
    return Build.VERSION.SDK;
  }
  
  public static String n() {
    return Build.TAGS;
  }
  
  public static String o() {
    return a("ro.kernel.qemu", "0");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\security\mobile\module\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */