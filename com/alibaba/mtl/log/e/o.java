package com.alibaba.mtl.log.e;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class o {
  public static Object a(Class paramClass, String paramString) {
    try {
      Method method = paramClass.getDeclaredMethod(paramString, new Class[0]);
      method.setAccessible(true);
      return method.invoke((Object)null, new Object[0]);
    } catch (SecurityException securityException) {
      securityException.printStackTrace();
      return null;
    } catch (NoSuchMethodException noSuchMethodException) {
      noSuchMethodException.printStackTrace();
      return null;
    } catch (IllegalArgumentException illegalArgumentException) {
      illegalArgumentException.printStackTrace();
      return null;
    } catch (IllegalAccessException illegalAccessException) {
      illegalAccessException.printStackTrace();
      return null;
    } catch (InvocationTargetException invocationTargetException) {
      invocationTargetException.printStackTrace();
      return null;
    } 
  }
  
  public static Object a(Object paramObject, String paramString) {
    try {
      Method method = paramObject.getClass().getDeclaredMethod(paramString, new Class[0]);
      method.setAccessible(true);
      return method.invoke(paramObject, new Object[0]);
    } catch (SecurityException securityException) {
      securityException.printStackTrace();
    } catch (NoSuchMethodException noSuchMethodException) {
      noSuchMethodException.printStackTrace();
    } catch (IllegalArgumentException illegalArgumentException) {
      illegalArgumentException.printStackTrace();
    } catch (IllegalAccessException illegalAccessException) {
      illegalAccessException.printStackTrace();
    } catch (InvocationTargetException invocationTargetException) {
      invocationTargetException.printStackTrace();
    } 
    return null;
  }
  
  public static Object a(Object paramObject, String paramString, Object[] paramArrayOfObject, Class... paramVarArgs) {
    try {
      Method method = paramObject.getClass().getDeclaredMethod(paramString, paramVarArgs);
      method.setAccessible(true);
      return method.invoke(paramObject, paramArrayOfObject);
    } catch (SecurityException securityException) {
      securityException.printStackTrace();
    } catch (NoSuchMethodException noSuchMethodException) {
      noSuchMethodException.printStackTrace();
    } catch (IllegalArgumentException illegalArgumentException) {
      illegalArgumentException.printStackTrace();
    } catch (IllegalAccessException illegalAccessException) {
      illegalAccessException.printStackTrace();
    } catch (InvocationTargetException invocationTargetException) {
      invocationTargetException.printStackTrace();
    } 
    return null;
  }
  
  public static Object a(String paramString1, String paramString2) {
    try {
      Class<?> clazz = Class.forName(paramString1);
      return (clazz != null) ? a(clazz, paramString2) : null;
    } catch (ClassNotFoundException classNotFoundException) {
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\log\e\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */