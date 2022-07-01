package com.blued.android.framework.qrcode.camera;

import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class FlashlightManager {
  private static final String a = FlashlightManager.class.getSimpleName();
  
  private static final Object b = c();
  
  private static final Method c = a(b);
  
  static {
    if (b == null) {
      Log.v(a, "This device does supports control of a flashlight");
      return;
    } 
    Log.v(a, "This device does not support control of a flashlight");
  }
  
  private static Class<?> a(String paramString) {
    try {
      return Class.forName(paramString);
    } catch (ClassNotFoundException classNotFoundException) {
      return null;
    } catch (RuntimeException runtimeException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unexpected error while finding class ");
      stringBuilder.append((String)classNotFoundException);
      Log.w(str, stringBuilder.toString(), runtimeException);
      return null;
    } 
  }
  
  private static Object a(Method paramMethod, Object paramObject, Object... paramVarArgs) {
    try {
      return paramMethod.invoke(paramObject, paramVarArgs);
    } catch (IllegalAccessException illegalAccessException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unexpected error while invoking ");
      stringBuilder.append(paramMethod);
      Log.w(str, stringBuilder.toString(), illegalAccessException);
      return null;
    } catch (InvocationTargetException invocationTargetException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unexpected error while invoking ");
      stringBuilder.append(paramMethod);
      Log.w(str, stringBuilder.toString(), invocationTargetException.getCause());
      return null;
    } catch (RuntimeException runtimeException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unexpected error while invoking ");
      stringBuilder.append(paramMethod);
      Log.w(str, stringBuilder.toString(), runtimeException);
      return null;
    } 
  }
  
  private static Method a(Class<?> paramClass, String paramString, Class<?>... paramVarArgs) {
    try {
      return paramClass.getMethod(paramString, paramVarArgs);
    } catch (NoSuchMethodException noSuchMethodException) {
      return null;
    } catch (RuntimeException runtimeException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unexpected error while finding method ");
      stringBuilder.append(paramString);
      Log.w(str, stringBuilder.toString(), runtimeException);
      return null;
    } 
  }
  
  private static Method a(Object paramObject) {
    return (paramObject == null) ? null : a(paramObject.getClass(), "setFlashlightEnabled", new Class[] { boolean.class });
  }
  
  static void a() {
    a(true);
  }
  
  private static void a(boolean paramBoolean) {
    Object object = b;
    if (object != null)
      a(c, object, new Object[] { Boolean.valueOf(paramBoolean) }); 
  }
  
  static void b() {
    a(false);
  }
  
  private static Object c() {
    Class<?> clazz1 = a("android.os.ServiceManager");
    if (clazz1 == null)
      return null; 
    Method method1 = a(clazz1, "getService", new Class[] { String.class });
    if (method1 == null)
      return null; 
    Object object = a(method1, (Object)null, new Object[] { "hardware" });
    if (object == null)
      return null; 
    Class<?> clazz2 = a("android.os.IHardwareService$Stub");
    if (clazz2 == null)
      return null; 
    Method method2 = a(clazz2, "asInterface", new Class[] { IBinder.class });
    return (method2 == null) ? null : a(method2, (Object)null, new Object[] { object });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\qrcode\camera\FlashlightManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */