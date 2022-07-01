package com.geetest.onepassv2.e;

import android.net.ConnectivityManager;

public class a {
  public static void a(ConnectivityManager paramConnectivityManager, int paramInt, String paramString) {
    try {
      ConnectivityManager.class.getDeclaredMethod("startUsingNetworkFeature", new Class[] { int.class, String.class }).invoke(paramConnectivityManager, new Object[] { Integer.valueOf(paramInt), paramString });
      return;
    } catch (NoSuchMethodException|java.lang.reflect.InvocationTargetException|IllegalAccessException noSuchMethodException) {
      return;
    } 
  }
  
  public static boolean a(ConnectivityManager paramConnectivityManager, int paramInt1, int paramInt2) {
    try {
      return ((Boolean)ConnectivityManager.class.getDeclaredMethod("requestRouteToHost", new Class[] { int.class, int.class }).invoke(paramConnectivityManager, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) })).booleanValue();
    } catch (NoSuchMethodException|java.lang.reflect.InvocationTargetException|IllegalAccessException noSuchMethodException) {
      return false;
    } 
  }
  
  public static int b(ConnectivityManager paramConnectivityManager, int paramInt, String paramString) {
    try {
      return ((Integer)ConnectivityManager.class.getDeclaredMethod("stopUsingNetworkFeature", new Class[] { int.class, String.class }).invoke(paramConnectivityManager, new Object[] { Integer.valueOf(paramInt), paramString })).intValue();
    } catch (NoSuchMethodException|java.lang.reflect.InvocationTargetException|IllegalAccessException noSuchMethodException) {
      return -1;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onepassv2\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */