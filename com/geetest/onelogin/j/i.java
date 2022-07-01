package com.geetest.onelogin.j;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;

public class i {
  public static boolean a(Context paramContext) {
    try {
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (connectivityManager == null)
        return false; 
      if (Build.VERSION.SDK_INT >= 21) {
        Network[] arrayOfNetwork = connectivityManager.getAllNetworks();
        int k = arrayOfNetwork.length;
        for (int j = 0;; j++) {
          if (j < k) {
            if (connectivityManager.getNetworkInfo(arrayOfNetwork[j]).getState().equals(NetworkInfo.State.CONNECTED))
              return true; 
          } else {
            return false;
          } 
        } 
      } 
      NetworkInfo[] arrayOfNetworkInfo = connectivityManager.getAllNetworkInfo();
      if (arrayOfNetworkInfo != null) {
        int k = arrayOfNetworkInfo.length;
        for (int j = 0; j < k; j++) {
          NetworkInfo.State state1 = arrayOfNetworkInfo[j].getState();
          NetworkInfo.State state2 = NetworkInfo.State.CONNECTED;
          if (state1 == state2)
            return true; 
        } 
      } 
      return false;
    } catch (Exception exception) {
      return true;
    } 
  }
  
  public static String b(Context paramContext) {
    ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (connectivityManager != null) {
      NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
      if (networkInfo != null && networkInfo.isConnectedOrConnecting())
        return "WIFI"; 
    } 
    switch (((TelephonyManager)paramContext.getSystemService("phone")).getNetworkType()) {
      default:
        return "NULL";
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
    return "2G";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\j\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */