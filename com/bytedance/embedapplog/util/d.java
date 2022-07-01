package com.bytedance.embedapplog.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;

public class d {
  public static boolean a(Context paramContext) {
    boolean bool = false;
    try {
      NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      boolean bool1 = bool;
      if (networkInfo != null) {
        boolean bool2 = networkInfo.isAvailable();
        bool1 = bool;
        if (bool2)
          bool1 = true; 
      } 
      return bool1;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public static String b(Context paramContext) {
    WifiManager wifiManager = (WifiManager)paramContext.getSystemService("wifi");
    if (wifiManager == null)
      return null; 
    try {
      WifiInfo wifiInfo = wifiManager.getConnectionInfo();
      return (wifiInfo != null) ? wifiInfo.getBSSID() : null;
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static String c(Context paramContext) {
    String str2 = null;
    try {
      NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    } catch (SecurityException securityException) {
      h.a(securityException);
      securityException = null;
    } 
    String str1 = str2;
    if (securityException != null) {
      str1 = str2;
      if (securityException.isAvailable()) {
        int i = securityException.getType();
        if (1 == i)
          return "wifi"; 
        str1 = str2;
        if (i == 0) {
          switch (((TelephonyManager)paramContext.getSystemService("phone")).getNetworkType()) {
            default:
              return "mobile";
            case 13:
            case 18:
            case 19:
              return "4g";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
              return "3g";
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
              break;
          } 
          str1 = "2g";
        } 
      } 
    } 
    return str1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplo\\util\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */