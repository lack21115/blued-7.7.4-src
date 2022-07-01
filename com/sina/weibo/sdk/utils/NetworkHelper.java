package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.util.List;

public class NetworkHelper {
  public static void clearCookies(Context paramContext) {
    CookieSyncManager.createInstance(paramContext);
    CookieManager.getInstance().removeAllCookie();
    CookieSyncManager.getInstance().sync();
  }
  
  public static String generateUA(Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Android");
    stringBuilder.append("__");
    stringBuilder.append("weibo");
    stringBuilder.append("__");
    stringBuilder.append("sdk");
    stringBuilder.append("__");
    try {
      stringBuilder.append((paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 16)).versionName.replaceAll("\\s+", "_"));
    } catch (Exception exception) {
      stringBuilder.append("unknown");
    } 
    return stringBuilder.toString();
  }
  
  public static NetworkInfo getActiveNetworkInfo(Context paramContext) {
    return ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
  }
  
  public static NetworkInfo getNetworkInfo(Context paramContext, int paramInt) {
    return ((ConnectivityManager)paramContext.getSystemService("connectivity")).getNetworkInfo(paramInt);
  }
  
  public static int getNetworkType(Context paramContext) {
    int i = -1;
    if (paramContext != null) {
      NetworkInfo networkInfo = getActiveNetworkInfo(paramContext);
      if (networkInfo == null)
        return -1; 
      i = networkInfo.getType();
    } 
    return i;
  }
  
  public static NetworkInfo.DetailedState getWifiConnectivityState(Context paramContext) {
    NetworkInfo networkInfo = getNetworkInfo(paramContext, 1);
    return (networkInfo == null) ? NetworkInfo.DetailedState.FAILED : networkInfo.getDetailedState();
  }
  
  public static int getWifiState(Context paramContext) {
    WifiManager wifiManager = (WifiManager)paramContext.getSystemService("wifi");
    return (wifiManager == null) ? 4 : wifiManager.getWifiState();
  }
  
  public static boolean hasInternetPermission(Context paramContext) {
    return (paramContext != null) ? ((paramContext.checkCallingOrSelfPermission("android.permission.INTERNET") == 0)) : true;
  }
  
  public static boolean isMobileNetwork(Context paramContext) {
    if (paramContext != null) {
      NetworkInfo networkInfo = getActiveNetworkInfo(paramContext);
      if (networkInfo == null)
        return false; 
      if (networkInfo != null && networkInfo.getType() == 0 && networkInfo.isConnected())
        return true; 
    } 
    return false;
  }
  
  public static boolean isNetworkAvailable(Context paramContext) {
    if (paramContext != null) {
      NetworkInfo networkInfo = getActiveNetworkInfo(paramContext);
      if (networkInfo != null && networkInfo.isConnected())
        return true; 
    } 
    return false;
  }
  
  public static boolean isWifiValid(Context paramContext) {
    if (paramContext != null) {
      NetworkInfo networkInfo = getActiveNetworkInfo(paramContext);
      if (networkInfo != null && 1 == networkInfo.getType() && networkInfo.isConnected())
        return true; 
    } 
    return false;
  }
  
  public static boolean wifiConnection(Context paramContext, String paramString1, String paramString2) {
    WifiManager wifiManager = (WifiManager)paramContext.getSystemService("wifi");
    StringBuilder stringBuilder = new StringBuilder("\"");
    stringBuilder.append(paramString1);
    stringBuilder.append("\"");
    String str = stringBuilder.toString();
    WifiInfo wifiInfo = wifiManager.getConnectionInfo();
    null = true;
    if (wifiInfo != null)
      if (!paramString1.equals(wifiInfo.getSSID())) {
        if (str.equals(wifiInfo.getSSID()))
          return true; 
      } else {
        return null;
      }  
    List list = wifiManager.getScanResults();
    if (list != null && list.size() != 0)
      for (int i = list.size() - 1; i >= 0; i--) {
        String str1 = ((ScanResult)list.get(i)).SSID;
        if (paramString1.equals(str1) || str.equals(str1)) {
          WifiConfiguration wifiConfiguration = new WifiConfiguration();
          wifiConfiguration.SSID = str;
          StringBuilder stringBuilder1 = new StringBuilder("\"");
          stringBuilder1.append(paramString2);
          stringBuilder1.append("\"");
          wifiConfiguration.preSharedKey = stringBuilder1.toString();
          wifiConfiguration.status = 2;
          return wifiManager.enableNetwork(wifiManager.addNetwork(wifiConfiguration), false);
        } 
      }  
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sd\\utils\NetworkHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */