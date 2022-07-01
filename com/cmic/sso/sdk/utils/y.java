package com.cmic.sso.sdk.utils;

import android.text.TextUtils;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class y {
  public static String a(boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    try {
      Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
      while (enumeration.hasMoreElements()) {
        NetworkInterface networkInterface = enumeration.nextElement();
        Enumeration<InetAddress> enumeration1 = networkInterface.getInetAddresses();
        while (enumeration1.hasMoreElements()) {
          InetAddress inetAddress = enumeration1.nextElement();
          if ((!paramBoolean || !networkInterface.getName().toLowerCase().contains("wlan")) && !inetAddress.isLoopbackAddress() && inetAddress instanceof java.net.Inet4Address) {
            stringBuilder.append(inetAddress.getHostAddress());
            stringBuilder.append(",");
          } 
        } 
      } 
      StringBuilder stringBuilder1 = stringBuilder;
      if (!TextUtils.isEmpty(stringBuilder))
        stringBuilder1 = stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length()); 
      stringBuilder = new StringBuilder();
      stringBuilder.append("IPV4 ip：");
      stringBuilder.append(stringBuilder1);
      f.b("UmcIPUtils", stringBuilder.toString());
      return stringBuilder1.toString();
    } catch (Exception exception) {
      exception.printStackTrace();
      return "";
    } 
  }
  
  public static String a(boolean paramBoolean1, boolean paramBoolean2) {
    StringBuilder stringBuilder = new StringBuilder();
    try {
      Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
      while (enumeration.hasMoreElements()) {
        NetworkInterface networkInterface = enumeration.nextElement();
        if (paramBoolean1 && networkInterface.getName().toLowerCase().contains("wlan"))
          continue; 
        Enumeration<InetAddress> enumeration1 = networkInterface.getInetAddresses();
        while (enumeration1.hasMoreElements()) {
          InetAddress inetAddress = enumeration1.nextElement();
          if (!inetAddress.isLoopbackAddress() && inetAddress instanceof java.net.Inet6Address && !inetAddress.isLinkLocalAddress()) {
            String str = inetAddress.getHostAddress();
            boolean bool = TextUtils.isEmpty(str);
            if (!bool) {
              if (paramBoolean2) {
                if (str.startsWith("2409:89")) {
                  stringBuilder.append(str);
                  stringBuilder.append(",");
                } 
                continue;
              } 
              stringBuilder.append(str);
              stringBuilder.append(",");
            } 
          } 
        } 
      } 
      StringBuilder stringBuilder1 = stringBuilder;
      if (!TextUtils.isEmpty(stringBuilder))
        stringBuilder1 = stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length()); 
      stringBuilder = new StringBuilder();
      stringBuilder.append("onlyMobileDataIp ");
      stringBuilder.append(paramBoolean1);
      stringBuilder.append(" IPV6 ip：");
      stringBuilder.append(stringBuilder1.toString());
      f.b("UmcIPUtils", stringBuilder.toString());
      return stringBuilder1.toString();
    } catch (Exception exception) {
      exception.printStackTrace();
      return "";
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sd\\utils\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */