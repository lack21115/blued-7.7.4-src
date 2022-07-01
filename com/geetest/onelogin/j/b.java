package com.geetest.onelogin.j;

import android.content.Context;
import android.net.ConnectivityManager;
import android.telephony.TelephonyManager;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class b {
  public static int a(String paramString) {
    try {
      InetAddress inetAddress = InetAddress.getByName(paramString);
      byte[] arrayOfByte = inetAddress.getAddress();
      byte b1 = arrayOfByte[3];
      byte b2 = arrayOfByte[2];
      byte b3 = arrayOfByte[1];
      return arrayOfByte[0] & 0xFF | (b1 & 0xFF) << 24 | (b2 & 0xFF) << 16 | (b3 & 0xFF) << 8;
    } catch (UnknownHostException unknownHostException) {
      return -1;
    } 
  }
  
  public static String a(long paramLong) {
    return (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date(paramLong));
  }
  
  public static boolean a(Context paramContext) {
    int i = ((TelephonyManager)paramContext.getSystemService("phone")).getSimState();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i != 0) {
      bool1 = bool2;
      if (i != 1)
        bool1 = true; 
    } 
    return bool1;
  }
  
  public static boolean a(ConnectivityManager paramConnectivityManager) {
    try {
      Method method = Class.forName(paramConnectivityManager.getClass().getName()).getDeclaredMethod("getMobileDataEnabled", new Class[0]);
      method.setAccessible(true);
      return ((Boolean)method.invoke(paramConnectivityManager, new Object[0])).booleanValue();
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public static String b(String paramString) {
    int i = paramString.indexOf("://");
    String str = paramString;
    if (i > 0)
      str = paramString.substring(i + 3); 
    i = str.indexOf(':');
    paramString = str;
    if (i >= 0)
      paramString = str.substring(0, i); 
    i = paramString.indexOf('/');
    str = paramString;
    if (i >= 0)
      str = paramString.substring(0, i); 
    i = str.indexOf('?');
    paramString = str;
    if (i >= 0)
      paramString = str.substring(0, i); 
    return paramString;
  }
  
  public static boolean b(Context paramContext) {
    ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    try {
      Method method = Class.forName(connectivityManager.getClass().getName()).getDeclaredMethod("getMobileDataEnabled", new Class[0]);
      method.setAccessible(true);
      return ((Boolean)method.invoke(connectivityManager, new Object[0])).booleanValue();
    } catch (Exception exception) {
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\j\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */