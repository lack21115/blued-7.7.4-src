package com.blued.android.framework.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SharedPreferencesUtils {
  private static SharedPreferences a;
  
  public static SharedPreferences a() {
    if (a == null)
      a = PreferenceManager.getDefaultSharedPreferences((Context)AppUtils.a()); 
    return a;
  }
  
  public static void b() {
    if (Build.VERSION.SDK_INT < 26)
      try {
        Class<?> clazz = Class.forName("android.app.ActivityThread");
        Object object = clazz.getDeclaredMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
        Field field = clazz.getDeclaredField("mH");
        field.setAccessible(true);
        object = field.get(object);
        field = Handler.class.getDeclaredField("mCallback");
        field.setAccessible(true);
        return;
      } catch (ClassNotFoundException classNotFoundException) {
      
      } catch (NoSuchFieldException noSuchFieldException) {
        return;
      } catch (NoSuchMethodException noSuchMethodException) {
        return;
      } catch (IllegalAccessException illegalAccessException) {
        return;
      } catch (InvocationTargetException invocationTargetException) {
        return;
      } finally {
        Exception exception = null;
        exception.printStackTrace();
      }  
  }
  
  public static class ActivityThreadHCallBack implements Handler.Callback {
    public boolean handleMessage(Message param1Message) {
      int i = param1Message.what;
      if (i != 115) {
        if (i != 116) {
          if (i != 137) {
            switch (i) {
              default:
                return false;
              case 104:
                SharedPreferencesUtils.SpBlockHelper.a("STOP_ACTIVITY_HIDE");
              case 103:
                SharedPreferencesUtils.SpBlockHelper.a("STOP_ACTIVITY_SHOW");
              case 102:
                SharedPreferencesUtils.SpBlockHelper.a("PAUSE_ACTIVITY_FINISHING");
              case 101:
                break;
            } 
            SharedPreferencesUtils.SpBlockHelper.a("PAUSE_ACTIVITY");
          } 
          SharedPreferencesUtils.SpBlockHelper.a("SLEEPING");
        } 
        SharedPreferencesUtils.SpBlockHelper.a("STOP_SERVICE");
      } 
      SharedPreferencesUtils.SpBlockHelper.a("SERVICE_ARGS");
    }
  }
  
  public static class SpBlockHelper {
    static boolean a = false;
    
    static String b = "android.app.QueuedWork";
    
    static String c = "sPendingWorkFinishers";
    
    static ConcurrentLinkedQueue<Runnable> d;
    
    static void a() {
      try {
        Field field = Class.forName(b).getDeclaredField(c);
        if (field != null) {
          field.setAccessible(true);
          d = (ConcurrentLinkedQueue<Runnable>)field.get((Object)null);
        } 
        Log.i("tryHackActivityThreadH", "getPendingWorkFinishers");
        return;
      } catch (Exception exception) {
        Log.e("tryHackActivityThreadH", "getPendingWorkFinishers", exception);
        return;
      } 
    }
    
    public static void a(String param1String) {
      if (!a) {
        a();
        a = true;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("beforeSPBlock ");
      stringBuilder.append(param1String);
      Log.d("tryHackActivityThreadH", stringBuilder.toString());
      ConcurrentLinkedQueue<Runnable> concurrentLinkedQueue = d;
      if (concurrentLinkedQueue != null) {
        concurrentLinkedQueue.clear();
        Log.i("tryHackActivityThreadH", "beforeSPBlock clear ----");
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\utils\SharedPreferencesUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */