package com.huawei.hianalytics.ab.cd.bc;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.Pair;
import com.huawei.hianalytics.ab.bc.bc.ab;
import com.huawei.hianalytics.ab.bc.ef.ab;
import com.huawei.hianalytics.ab.bc.kl.bc;
import java.lang.reflect.InvocationTargetException;

public class cd extends ab {
  public static String cd() {
    String str2;
    try {
      Class<?> clazz = Class.forName("com.huawei.android.os.BuildEx");
      String str = (String)clazz.getMethod("getUDID", new Class[0]).invoke(null, new Object[0]);
      try {
        ab.cd("hmsSdk", "getUDID success");
        return str;
      } catch (ClassNotFoundException classNotFoundException) {
        String str3 = "getUDID method invoke failed";
        str2 = str;
        str = str3;
        ab.fg("hmsSdk", str);
        return str2;
      } catch (AndroidRuntimeException androidRuntimeException) {
        str2 = str;
        str = "getUDID getudid failed, RuntimeException is AndroidRuntimeException";
        ab.fg("hmsSdk", str);
        return str2;
      } catch (NoSuchMethodException noSuchMethodException) {
        str2 = str;
        str = "getUDID method invoke failed : NoSuchMethodException";
        ab.fg("hmsSdk", str);
        return str2;
      } catch (IllegalAccessException illegalAccessException) {
        str2 = str;
        str = "getUDID method invoke failed : Illegal AccessException";
        ab.fg("hmsSdk", str);
        return str2;
      } catch (IllegalArgumentException illegalArgumentException) {
        str2 = str;
        str = "getUDID method invoke failed : Illegal ArgumentException";
        ab.fg("hmsSdk", str);
        return str2;
      } catch (InvocationTargetException invocationTargetException) {
        str2 = str;
      } 
    } catch (ClassNotFoundException classNotFoundException) {
      String str3 = "";
      String str4 = "getUDID method invoke failed";
      str2 = str3;
      str3 = str4;
      ab.fg("hmsSdk", str3);
      return str2;
    } catch (AndroidRuntimeException androidRuntimeException) {
      str2 = "";
      String str = "getUDID getudid failed, RuntimeException is AndroidRuntimeException";
      ab.fg("hmsSdk", str);
      return str2;
    } catch (NoSuchMethodException noSuchMethodException) {
      str2 = "";
      String str = "getUDID method invoke failed : NoSuchMethodException";
      ab.fg("hmsSdk", str);
      return str2;
    } catch (IllegalAccessException illegalAccessException) {
      str2 = "";
      String str = "getUDID method invoke failed : Illegal AccessException";
      ab.fg("hmsSdk", str);
      return str2;
    } catch (IllegalArgumentException illegalArgumentException) {
      str2 = "";
      String str = "getUDID method invoke failed : Illegal ArgumentException";
      ab.fg("hmsSdk", str);
      return str2;
    } catch (InvocationTargetException invocationTargetException) {
      str2 = "";
    } 
    String str1 = "getUDID method invoke failed : InvocationTargetException";
    ab.fg("hmsSdk", str1);
    return str2;
  }
  
  public static Pair<String, String> ef(Context paramContext) {
    if (bc.ab(paramContext, "android.permission.READ_PHONE_STATE")) {
      ab.fg("hmsSdk", "getMccAndMnc() Pair value is empty");
      return new Pair("", "");
    } 
    TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    if (telephonyManager == null)
      return new Pair("", ""); 
    if (telephonyManager.getSimState() != 5)
      return new Pair("", ""); 
    String str = telephonyManager.getNetworkOperator();
    return (TextUtils.isEmpty(str) || TextUtils.equals(str, "null")) ? new Pair("", "") : ((str.length() > 3) ? new Pair(str.substring(0, 3), str.substring(3)) : new Pair("", ""));
  }
  
  public static String fg(Context paramContext) {
    if (bc.ab(paramContext, "android.permission.READ_PHONE_STATE"))
      return ""; 
    try {
      TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (telephonyManager != null)
        return telephonyManager.getDeviceId(); 
    } catch (SecurityException securityException) {
      ab.bc("hmsSdk", "getDeviceID Incorrect permissions!");
    } 
    return "";
  }
  
  private static String gh(Context paramContext) {
    ab.ab("hmsSdk", "getSerial : is executed.");
    if (paramContext == null)
      return ""; 
    if (bc.ab(paramContext, "android.permission.READ_PHONE_STATE"))
      return ""; 
    try {
      if (Build.VERSION.SDK_INT >= 26)
        return Build.getSerial(); 
    } catch (SecurityException securityException) {
      ab.fg("hmsSdk", "getSerial() Incorrect permissions!");
    } 
    return "";
  }
  
  public static String hi(Context paramContext) {
    String str = Build.SERIAL;
    return (TextUtils.isEmpty(str) || str.equalsIgnoreCase("unknown")) ? gh(paramContext) : str;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\cd\bc\cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */