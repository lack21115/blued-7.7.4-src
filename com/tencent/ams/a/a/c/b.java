package com.tencent.ams.a.a.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.qq.e.comm.plugin.util.ac;
import java.util.HashMap;
import java.util.Map;

public class b {
  private static String a;
  
  private static String b;
  
  private static String c;
  
  private static HashMap<String, String> d = new HashMap<String, String>();
  
  public static String a() {
    return Build.VERSION.RELEASE;
  }
  
  private static String a(int paramInt, String paramString1, String paramString2) {
    StringBuilder stringBuilder;
    if (paramInt == 1) {
      StringBuilder stringBuilder1 = new StringBuilder();
      String str = paramString1;
      stringBuilder = stringBuilder1;
      stringBuilder.append(str);
      stringBuilder.append(paramString2);
      return a.b(stringBuilder.toString());
    } 
    if (paramInt == 2) {
      StringBuilder stringBuilder1 = new StringBuilder();
      String str2 = a.b((String)stringBuilder);
      stringBuilder = stringBuilder1;
      String str1 = str2;
      stringBuilder.append(str1);
      stringBuilder.append(paramString2);
      return a.b(stringBuilder.toString());
    } 
    return a.b((String)stringBuilder);
  }
  
  public static String a(Context paramContext) {
    String str1;
    String str2 = c;
    if (str2 != null)
      return str2; 
    WindowManager windowManager = (WindowManager)paramContext.getSystemService("window");
    if (windowManager == null) {
      str1 = "";
    } else {
      DisplayMetrics displayMetrics = new DisplayMetrics();
      windowManager.getDefaultDisplay().getMetrics(displayMetrics);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(displayMetrics.widthPixels);
      stringBuilder.append("x");
      stringBuilder.append(displayMetrics.heightPixels);
      str1 = stringBuilder.toString();
    } 
    c = str1;
    return c;
  }
  
  public static HashMap<String, String> a(Context paramContext, String paramString, int paramInt) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(3);
    hashMap.put("MAC", c(paramContext, paramString, paramInt));
    hashMap.put("IMEI", b(paramContext, paramString, paramInt));
    hashMap.put("ANDROIDID", d(paramContext, paramString, paramInt));
    return (HashMap)hashMap;
  }
  
  public static String b() {
    return Build.MODEL;
  }
  
  private static String b(Context paramContext, String paramString, int paramInt) {
    String str1;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(paramInt);
    stringBuilder.append("imei");
    String str4 = stringBuilder.toString();
    String str3 = d.get(str4);
    if (str3 != null)
      return str3; 
    if (!ac.b() || paramContext.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0)
      return ""; 
    String str2 = str3;
    try {
      TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      str1 = str3;
    } finally {
      paramContext = null;
    } 
    paramString = str1;
    if (str1 == null)
      paramString = ""; 
    d.put(str4, paramString);
    return paramString;
  }
  
  public static boolean b(Context paramContext) {
    boolean bool2 = false;
    if (paramContext == null)
      return false; 
    ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    boolean bool1 = bool2;
    if (connectivityManager != null) {
      NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
      bool1 = bool2;
      if (networkInfo != null) {
        bool1 = bool2;
        if (networkInfo.getState() == NetworkInfo.State.CONNECTED)
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  public static String c(Context paramContext) {
    String str = a;
    if (str != null)
      return str; 
    PackageManager packageManager = paramContext.getPackageManager();
    try {
      a = packageManager.getApplicationInfo(paramContext.getPackageName(), 128).loadLabel(packageManager).toString();
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {}
    return a;
  }
  
  private static String c(Context paramContext, String paramString, int paramInt) {
    String str1;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(paramInt);
    stringBuilder.append("mac");
    String str4 = stringBuilder.toString();
    String str3 = d.get(str4);
    if (str3 != null)
      return str3; 
    if (!ac.a())
      return ""; 
    String str2 = str3;
    try {
      WifiManager wifiManager = (WifiManager)paramContext.getSystemService("wifi");
      str1 = str3;
    } finally {
      paramContext = null;
    } 
    paramString = str1;
    if (str1 == null)
      paramString = ""; 
    d.put(str4, paramString);
    return paramString;
  }
  
  public static String d(Context paramContext) {
    if (b == null && paramContext != null)
      b = paramContext.getPackageName(); 
    return b;
  }
  
  private static String d(Context paramContext, String paramString, int paramInt) {
    String str1;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(paramInt);
    stringBuilder.append("androidId");
    String str3 = stringBuilder.toString();
    String str2 = d.get(str3);
    if (str2 != null)
      return str2; 
    if (!ac.c())
      return ""; 
    try {
      str1 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    } finally {
      paramContext = null;
    } 
    d.put(str3, str1);
    return str1;
  }
  
  public static Map<String, String> e(Context paramContext) {
    String str;
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (paramContext == null)
      return (Map)hashMap; 
    hashMap.put("OSVS", a());
    hashMap.put("TERM", b());
    if (b(paramContext)) {
      str = "1";
    } else {
      str = "0";
    } 
    hashMap.put("WIFI", str);
    hashMap.put("ANAME", c(paramContext));
    hashMap.put("AKEY", d(paramContext));
    hashMap.put("OSVS", a());
    hashMap.put("OS", "0");
    hashMap.put("SCWH", a(paramContext));
    hashMap.put("SDKVS", "1.2");
    return (Map)hashMap;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\ams\a\a\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */