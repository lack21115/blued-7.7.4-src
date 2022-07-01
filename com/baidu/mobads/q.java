package com.baidu.mobads;

import android.content.Context;
import android.util.Log;
import com.baidu.mobads.f.g;
import com.baidu.mobads.utils.q;
import dalvik.system.DexClassLoader;
import java.lang.reflect.Method;

public class q {
  static q a;
  
  private static final String b = q.class.getName();
  
  static {
    a = q.a();
  }
  
  public static DexClassLoader a(Context paramContext) {
    ClassLoader classLoader = q.class.getClass().getClassLoader();
    try {
      return new DexClassLoader(g.a(paramContext), paramContext.getFilesDir().getAbsolutePath(), null, classLoader);
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static Class<?> a(String paramString, ClassLoader paramClassLoader) {
    if (paramClassLoader != null)
      try {
        return paramClassLoader.loadClass(paramString);
      } catch (Exception exception) {
        a.d(b, Log.getStackTraceString(exception));
      }  
    return null;
  }
  
  public static Object a(Class<?> paramClass, Object paramObject, String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject) {
    try {
      return a(paramClass, paramString, paramArrayOfClass) ? b(paramClass, paramString, paramArrayOfClass).invoke(paramObject, paramArrayOfObject) : null;
    } catch (Exception exception) {
      a.i(b, Log.getStackTraceString(exception));
      return null;
    } 
  }
  
  public static Object a(Object paramObject, String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject) {
    try {
      return a(paramObject.getClass(), paramObject, paramString, paramArrayOfClass, paramArrayOfObject);
    } catch (Exception exception) {
      a.i(b, Log.getStackTraceString(exception));
      return null;
    } 
  }
  
  public static Object a(String paramString, ClassLoader paramClassLoader, Class<?>[] paramArrayOfClass, Object... paramVarArgs) {
    try {
      Class<?> clazz = a(paramString, paramClassLoader);
      return (clazz != null) ? clazz.getDeclaredConstructor(paramArrayOfClass).newInstance(paramVarArgs) : null;
    } catch (Exception exception) {
      a.i(b, Log.getStackTraceString(exception));
      return null;
    } 
  }
  
  public static Object a(String paramString1, Object paramObject, ClassLoader paramClassLoader, String paramString2, Class<?>[] paramArrayOfClass, Object... paramVarArgs) {
    try {
      Class<?> clazz = a(paramString1, paramClassLoader);
      if (clazz != null) {
        Method method = clazz.getDeclaredMethod(paramString2, paramArrayOfClass);
        if (method != null) {
          method.setAccessible(true);
          return method.invoke(paramObject, paramVarArgs);
        } 
      } 
      return null;
    } catch (Exception exception) {
      a.i(b, Log.getStackTraceString(exception));
      return null;
    } 
  }
  
  public static boolean a(Class<?> paramClass, String paramString, Class<?>... paramVarArgs) {
    boolean bool = false;
    try {
      Method method = paramClass.getDeclaredMethod(paramString, paramVarArgs);
      if (method != null)
        bool = true; 
      return bool;
    } catch (Exception exception) {
      a.i(b, Log.getStackTraceString(exception));
      return false;
    } 
  }
  
  public static Method b(Class<?> paramClass, String paramString, Class<?>... paramVarArgs) {
    try {
      Method method = paramClass.getDeclaredMethod(paramString, paramVarArgs);
      if (method != null) {
        method.setAccessible(true);
        return method;
      } 
      return null;
    } catch (Exception exception) {
      a.i(b, Log.getStackTraceString(exception));
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */