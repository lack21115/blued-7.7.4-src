package com.huawei.hianalytics.ab.bc.bc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.huawei.hianalytics.ab.bc.ef.ab;

public class cd {
  private static String ab(int paramInt, String paramString) {
    switch (paramInt) {
      default:
        if (!paramString.equalsIgnoreCase("TD-SCDMA") && !paramString.equalsIgnoreCase("WCDMA")) {
          String str = paramString;
          if (paramString.equalsIgnoreCase("CDMA2000"))
            break; 
          return str;
        } 
        break;
      case 13:
        return "4G";
      case 1:
      case 2:
      case 4:
      case 7:
      case 11:
        return "2G";
      case 3:
      case 5:
      case 6:
      case 8:
      case 9:
      case 10:
      case 12:
      case 14:
      case 15:
        break;
    } 
    return "3G";
  }
  
  public static String ab(Context paramContext) {
    String str2 = "";
    if (paramContext == null || paramContext.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", paramContext.getPackageName()) != 0) {
      ab.fg("hmsSdk", "not have network state phone permission!");
      return "";
    } 
    ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    String str1 = str2;
    if (connectivityManager != null) {
      NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
      str1 = str2;
      if (networkInfo != null) {
        str1 = str2;
        if (networkInfo.isConnected()) {
          if (networkInfo.getType() == 1)
            return "WIFI"; 
          if (networkInfo.getType() == 0) {
            str1 = networkInfo.getSubtypeName();
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("Network getSubtypeName : ");
            stringBuilder1.append(str1);
            ab.cd("hmsSdk", stringBuilder1.toString());
            return ab(networkInfo.getSubtype(), str1);
          } 
          if (networkInfo.getType() == 16) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("type name = ");
            stringBuilder1.append("COMPANION_PROXY");
            ab.fg("hmsSdk", stringBuilder1.toString());
            return "COMPANION_PROXY";
          } 
          if (networkInfo.getType() == 9) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("type name = ");
            stringBuilder1.append("ETHERNET");
            ab.cd("hmsSdk", stringBuilder1.toString());
            return "ETHERNET";
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("type name = ");
          stringBuilder.append(networkInfo.getType());
          ab.cd("hmsSdk", stringBuilder.toString());
          str1 = "OTHER_NETWORK_TYPE";
        } 
      } 
    } 
    return str1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\bc\cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */