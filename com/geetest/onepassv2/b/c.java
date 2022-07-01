package com.geetest.onepassv2.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import com.geetest.common.support.ContextCompat;
import com.geetest.onelogin.e.a.i;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class c {
  public static String a() {
    try {
      Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
      while (enumeration.hasMoreElements()) {
        NetworkInterface networkInterface = enumeration.nextElement();
        if (networkInterface.getName().toLowerCase().contains("wlan"))
          continue; 
        Enumeration<InetAddress> enumeration1 = networkInterface.getInetAddresses();
        while (enumeration1.hasMoreElements()) {
          InetAddress inetAddress = enumeration1.nextElement();
          if (!inetAddress.isLoopbackAddress() && inetAddress instanceof java.net.Inet4Address)
            return inetAddress.getHostAddress(); 
        } 
      } 
    } catch (Exception exception) {}
    return "";
  }
  
  public static String a(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt & 0xFF);
    stringBuilder.append(".");
    stringBuilder.append(paramInt >> 8 & 0xFF);
    stringBuilder.append(".");
    stringBuilder.append(paramInt >> 16 & 0xFF);
    stringBuilder.append(".");
    stringBuilder.append(paramInt >> 24 & 0xFF);
    return stringBuilder.toString();
  }
  
  public static String a(Context paramContext) {
    try {
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
      if (networkInfo != null && networkInfo.isConnected()) {
        String str;
        if (networkInfo.getType() == 0) {
          str = a();
        } else if (networkInfo.getType() == 1) {
          if (ContextCompat.b((Context)str, "android.permission.CHANGE_NETWORK_STATE") && a(connectivityManager)) {
            str = a();
          } else {
            str = b((Context)str);
          } 
        } else {
          return "";
        } 
      } else {
        return "";
      } 
    } catch (Exception exception) {
      return "";
    } 
    return (String)exception;
  }
  
  public static String a(String paramString1, String paramString2) {
    try {
      SecretKeySpec secretKeySpec = new SecretKeySpec(paramString2.getBytes(), "HmacSHA256");
      Mac mac = Mac.getInstance("HmacSHA256");
      mac.init(secretKeySpec);
      return i.b(mac.doFinal(paramString1.getBytes()));
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static boolean a(ConnectivityManager paramConnectivityManager) {
    try {
      Method method = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
      method.setAccessible(true);
      return ((Boolean)method.invoke(paramConnectivityManager, new Object[0])).booleanValue();
    } catch (Exception exception) {
      exception.printStackTrace();
      return false;
    } 
  }
  
  public static String b(Context paramContext) {
    try {
      return a(((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getIpAddress());
    } catch (Exception exception) {
      return "";
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onepassv2\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */