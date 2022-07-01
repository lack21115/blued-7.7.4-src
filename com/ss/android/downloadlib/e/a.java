package com.ss.android.downloadlib.e;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ss.android.downloadlib.a.j;
import com.ss.android.socialbase.downloader.m.i;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class a {
  public static String a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    File file = new File(paramString);
    return !file.exists() ? null : ((file.length() > 70000000L) ? null : g.a(file));
  }
  
  public static void a() {
    try {
      Field field1;
      if (Build.VERSION.SDK_INT < 26) {
        field1 = Class.forName("android.app.ActivityManagerNative").getDeclaredField("gDefault");
      } else {
        field1 = Class.forName("android.app.ActivityManager").getDeclaredField("IActivityManagerSingleton");
      } 
      field1.setAccessible(true);
      Object object1 = field1.get((Object)null);
      Field field2 = Class.forName("android.util.Singleton").getDeclaredField("mInstance");
      field2.setAccessible(true);
      Object object2 = field2.get(object1);
      if (object2 == null)
        return; 
      Class<?> clazz = Class.forName("android.app.IActivityManager");
      if (clazz == null)
        return; 
      object2 = new a(object2);
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  public static String b(String paramString) {
    return a(c(paramString));
  }
  
  public static String c(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    try {
      ApplicationInfo applicationInfo = j.a().getPackageManager().getApplicationInfo(paramString, 0);
      return (applicationInfo != null) ? applicationInfo.sourceDir : null;
    } catch (Exception exception) {
      return null;
    } 
  }
  
  static class a implements InvocationHandler {
    private Object a;
    
    private a(Object param1Object) {
      this.a = param1Object;
    }
    
    private Throwable a(Throwable param1Throwable) {
      Throwable throwable = param1Throwable;
      try {
        int i;
        Throwable throwable1;
        StackTraceElement[] arrayOfStackTraceElement1;
        StackTraceElement[] arrayOfStackTraceElement2 = param1Throwable.getStackTrace();
        throwable = param1Throwable;
        if (param1Throwable instanceof java.lang.reflect.InvocationTargetException) {
          throwable = param1Throwable;
          throwable1 = param1Throwable;
          throwable = param1Throwable;
          if (throwable1.getTargetException() != null) {
            throwable = param1Throwable;
            Throwable throwable2 = throwable1.getTargetException();
            throwable = throwable2;
            arrayOfStackTraceElement1 = throwable2.getStackTrace();
          } else {
            throwable = param1Throwable;
            param1Throwable = new RuntimeException();
            arrayOfStackTraceElement1 = arrayOfStackTraceElement2;
            Throwable throwable2 = param1Throwable;
          } 
        } else {
          arrayOfStackTraceElement1 = arrayOfStackTraceElement2;
          throwable1 = param1Throwable;
          throwable = param1Throwable;
          if (param1Throwable instanceof java.lang.reflect.UndeclaredThrowableException) {
            throwable = param1Throwable;
            throwable1 = param1Throwable;
            throwable = param1Throwable;
            if (throwable1.getUndeclaredThrowable() != null) {
              throwable = param1Throwable;
              throwable1 = throwable1.getUndeclaredThrowable();
              throwable = throwable1;
              arrayOfStackTraceElement1 = throwable1.getStackTrace();
            } else {
              throwable = param1Throwable;
              param1Throwable = new RuntimeException();
              arrayOfStackTraceElement1 = arrayOfStackTraceElement2;
              throwable1 = param1Throwable;
            } 
          } 
        } 
        throwable = throwable1;
        ArrayList<StackTraceElement> arrayList = new ArrayList();
        boolean bool = false;
      } finally {
        param1Throwable = null;
      } 
    }
    
    public Object invoke(Object param1Object, Method param1Method, Object[] param1ArrayOfObject) throws Throwable {
      try {
        if ("startActivity".contains(param1Method.getName())) {
          boolean bool = true;
          if (param1ArrayOfObject[1] instanceof String && param1ArrayOfObject[2] instanceof Intent) {
            param1Object = param1ArrayOfObject[2];
            if ("android.intent.action.VIEW".equals(param1Object.getAction()) && "application/vnd.android.package-archive".equals(param1Object.getType())) {
              boolean bool1 = i.c();
              if (bool1) {
                param1Object = j.i().optString("hook_vivo_arg", "com.android.settings");
                if (!"null".equals(param1Object))
                  param1ArrayOfObject[1] = param1Object; 
              } else if (i.d()) {
                String str1 = j.i().optString("hook_oppo_arg1", "com.android.settings");
                if (!"null".equals(str1))
                  param1ArrayOfObject[1] = str1; 
                str1 = j.i().optString("hook_oppo_arg2", "com.android.browser");
                String str2 = j.i().optString("hook_oppo_arg3", "m.store.oppomobile.com");
                param1Object.putExtra("oppo_extra_pkg_name", str1);
                param1Object.putExtra("refererHost", str2);
                if (j.i().optInt("hook_oppo_arg4", 0) != 1)
                  bool = false; 
                if (bool) {
                  Intent intent = new Intent();
                  intent.putExtra("oppo_extra_pkg_name", str1);
                  intent.putExtra("refererHost", str2);
                  param1Object.putExtra("android.intent.extra.INTENT", (Parcelable)intent);
                } 
              } else if (i.a()) {
                String str = j.i().optString("hook_huawei_arg1", "com.android.settings");
                if (!"null".equals(str))
                  param1ArrayOfObject[1] = str; 
                param1Object.putExtra("caller_package", j.i().optString("hook_huawei_arg2", "com.huawei.appmarket"));
              } 
            } 
          } 
        } 
      } finally {}
      try {
        return param1Method.invoke(this.a, param1ArrayOfObject);
      } finally {
        param1Object = null;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */