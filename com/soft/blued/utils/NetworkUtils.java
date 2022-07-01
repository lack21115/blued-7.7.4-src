package com.soft.blued.utils;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.soft.blued.app.permission.PermissionHelper;

public class NetworkUtils {
  private static final String a = NetworkUtils.class.getSimpleName();
  
  public static boolean a() {
    NetworkInfo networkInfo = ((ConnectivityManager)AppInfo.d().getSystemService("connectivity")).getActiveNetworkInfo();
    if (networkInfo != null && networkInfo.isAvailable()) {
      if (networkInfo != null && networkInfo.getType() == 1) {
        Logger.b(a, new Object[] { "  wifi状态" });
        return false;
      } 
      Logger.b(a, new Object[] { "  正常联网的非wifi状态" });
      return true;
    } 
    return false;
  }
  
  public static boolean b() {
    NetworkInfo networkInfo = ((ConnectivityManager)AppInfo.d().getSystemService("connectivity")).getActiveNetworkInfo();
    return (networkInfo != null && networkInfo.isAvailable());
  }
  
  public static boolean c() {
    if (!b()) {
      AppMethods.d(2131756082);
      return false;
    } 
    return true;
  }
  
  public static String d() {
    String str = "";
    try {
      NetworkInfo networkInfo = ((ConnectivityManager)AppInfo.d().getSystemService("connectivity")).getActiveNetworkInfo();
      String str1 = str;
      if (networkInfo != null) {
        str1 = str;
        if (networkInfo.isConnected()) {
          if (networkInfo.getType() == 1)
            return "wifi"; 
          str1 = str;
          if (networkInfo.getType() == 0) {
            str1 = networkInfo.getSubtypeName();
            switch (networkInfo.getSubtype()) {
              default:
                if (!str1.equalsIgnoreCase("TD-SCDMA") && !str1.equalsIgnoreCase("WCDMA")) {
                  boolean bool = str1.equalsIgnoreCase("CDMA2000");
                  return bool ? "3G" : str1;
                } 
              case 13:
                return "4G";
              case 3:
              case 5:
              case 6:
              case 8:
              case 9:
              case 10:
              case 12:
              case 14:
              case 15:
                return "3G";
              case 1:
              case 2:
              case 4:
              case 7:
              case 11:
                break;
            } 
          } else {
            return str1;
          } 
        } else {
          return str1;
        } 
      } else {
        return str1;
      } 
    } catch (Exception exception) {
      return "";
    } 
    return "2G";
  }
  
  public static String e() {
    TelephonyManager telephonyManager = (TelephonyManager)AppInfo.d().getSystemService("phone");
    return PermissionHelper.a(new String[] { "android.permission.READ_PHONE_STATE" }) ? telephonyManager.getNetworkOperatorName() : "";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\NetworkUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */