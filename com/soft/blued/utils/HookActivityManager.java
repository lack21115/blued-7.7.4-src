package com.soft.blued.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import com.blued.android.core.AppInfo;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HookActivityManager {
  private static WifiInfo a;
  
  public static void a() {
    try {
      Field field1 = ActivityManager.class.getDeclaredField("IActivityManagerSingleton");
      field1.setAccessible(true);
      Object object1 = field1.get((Object)null);
      Field field2 = object1.getClass().getSuperclass().getDeclaredField("mInstance");
      field2.setAccessible(true);
      Object object2 = field2.get(object1);
      Class<?> clazz = Class.forName("android.app.IActivityManager");
      ClassLoader classLoader = clazz.getClassLoader();
      object2 = new IActivityManagerProxy(object2);
      field2.set(object1, Proxy.newProxyInstance(classLoader, new Class[] { clazz }, (InvocationHandler)object2));
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("");
      stringBuilder.append(exception);
      Log.d("HookActivityManager", stringBuilder.toString());
      return;
    } 
  }
  
  public static void a(String paramString, Context paramContext) {
    try {
      Class<?> clazz = Class.forName("android.net.wifi.IWifiManager");
      Field field = WifiManager.class.getDeclaredField("mService");
      field.setAccessible(true);
      WifiManager wifiManager = (WifiManager)paramContext.getSystemService("wifi");
      Object object = field.get(wifiManager);
      ClassLoader classLoader = clazz.getClassLoader();
      object = new WifiInvocationHandler(paramString, "getConnectionInfo", object);
      field.set(wifiManager, Proxy.newProxyInstance(classLoader, new Class[] { clazz }, (InvocationHandler)object));
      Log.i(paramString, "wifiManager hook success");
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("printStackTrace:");
      stringBuilder.append(exception.getMessage());
      Log.e(paramString, stringBuilder.toString());
      exception.printStackTrace();
      return;
    } 
  }
  
  static class IActivityManagerProxy implements InvocationHandler {
    private Object a;
    
    public IActivityManagerProxy(Object param1Object) {
      this.a = param1Object;
    }
    
    public Object invoke(Object param1Object, Method param1Method, Object[] param1ArrayOfObject) throws Throwable {
      StringBuilder stringBuilder;
      boolean bool = "reportSizeConfigurations".equals(param1Method.getName());
      param1Object = Boolean.valueOf(false);
      if (bool)
        try {
          Log.w("HookActivityManager", "reportSizeConfigurations invoke execute ");
          return param1Method.invoke(this.a, param1ArrayOfObject);
        } catch (Exception exception) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("reportSizeConfigurations exception: ");
          stringBuilder.append(exception.getMessage());
          Log.w("HookActivityManager", stringBuilder.toString());
          return param1Object;
        }  
      try {
        return exception.invoke(this.a, (Object[])stringBuilder);
      } catch (Exception exception1) {
        return param1Object;
      } 
    }
  }
  
  public static class WifiInvocationHandler implements InvocationHandler {
    private final String a;
    
    private final String b;
    
    private Object c;
    
    public WifiInvocationHandler(String param1String1, String param1String2, Object param1Object) {
      this.c = param1Object;
      this.b = param1String2;
      this.a = param1String1;
    }
    
    public Object invoke(Object param1Object, Method param1Method, Object[] param1ArrayOfObject) throws Throwable {
      String str;
      param1Object = this.a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("method invoke ");
      stringBuilder.append(param1Method.getName());
      Log.d((String)param1Object, stringBuilder.toString());
      if (this.b.equals(param1Method.getName())) {
        if (BluedPreferences.aA() != 1 && !BluedPreferences.aB())
          return null; 
        if (AppInfo.m())
          (new Exception("this is a log")).printStackTrace(); 
        if (HookActivityManager.b() != null) {
          param1Object = this.a;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("cacheWifiInfo:");
          stringBuilder1.append(HookActivityManager.b());
          Log.d((String)param1Object, stringBuilder1.toString());
          return HookActivityManager.b();
        } 
        try {
          param1Object = WifiInfo.class.newInstance();
          try {
            Field field = WifiInfo.class.getDeclaredField("mMacAddress");
            field.setAccessible(true);
            field.set(param1Object, "");
            HookActivityManager.a((WifiInfo)param1Object);
            String str1 = this.a;
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("wifiInfo:");
            stringBuilder1.append(param1Object);
            Log.d(str1, stringBuilder1.toString());
            return param1Object;
          } catch (Exception null) {}
        } catch (Exception exception) {
          param1Object = null;
        } 
        str = this.a;
        stringBuilder = new StringBuilder();
        stringBuilder.append("WifiInfo error:");
        stringBuilder.append(exception.getMessage());
        Log.e(str, stringBuilder.toString());
        return param1Object;
      } 
      return exception.invoke(this.c, (Object[])str);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\HookActivityManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */