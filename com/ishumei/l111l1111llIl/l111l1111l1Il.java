package com.ishumei.l111l1111llIl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class l111l1111l1Il {
  public static Object l1111l111111Il(Object paramObject, String paramString) {
    return l1111l111111Il(paramObject, l1111l111111Il(paramObject.getClass(), paramString, (Class[])null), new Object[0]);
  }
  
  public static Object l1111l111111Il(Object paramObject, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject) {
    return l1111l111111Il(paramObject, l1111l111111Il(paramObject.getClass(), paramString, paramArrayOfClass), paramArrayOfObject);
  }
  
  private static Object l1111l111111Il(Object paramObject, Field paramField) {
    paramField.setAccessible(true);
    return paramField.get(paramObject);
  }
  
  private static Object l1111l111111Il(Object paramObject, Method paramMethod, Object... paramVarArgs) {
    paramMethod.setAccessible(true);
    return paramMethod.invoke(paramObject, paramVarArgs);
  }
  
  public static Object l1111l111111Il(String paramString1, String paramString2) {
    return l1111l111111Il((Object)null, l1111l111111Il(Class.forName(paramString1), paramString2, (Class[])null), new Object[0]);
  }
  
  public static Object l1111l111111Il(String paramString1, String paramString2, Class[] paramArrayOfClass, Object[] paramArrayOfObject) {
    return l1111l111111Il((Object)null, l1111l111111Il(Class.forName(paramString1), paramString2, paramArrayOfClass), paramArrayOfObject);
  }
  
  private static Field l1111l111111Il(Class<?> paramClass, String paramString) {
    try {
      return paramClass.getField(paramString);
    } catch (NoSuchFieldException noSuchFieldException) {
      try {
        return paramClass.getDeclaredField(paramString);
      } catch (NoSuchFieldException noSuchFieldException1) {
        if (paramClass.getSuperclass() != null)
          return l1111l111111Il(paramClass.getSuperclass(), paramString); 
        throw noSuchFieldException1;
      } 
    } 
  }
  
  private static Method l1111l111111Il(Class<?> paramClass, String paramString, Class[] paramArrayOfClass) {
    try {
      return paramClass.getMethod(paramString, paramArrayOfClass);
    } catch (NoSuchMethodException noSuchMethodException) {
      try {
        return paramClass.getDeclaredMethod(paramString, paramArrayOfClass);
      } catch (NoSuchMethodException noSuchMethodException1) {
        if (paramClass.getSuperclass() != null)
          return l1111l111111Il(paramClass.getSuperclass(), paramString, paramArrayOfClass); 
        throw noSuchMethodException1;
      } 
    } 
  }
  
  private static Field[] l1111l111111Il(Class paramClass) {
    return paramClass.getDeclaredFields();
  }
  
  private static Field[] l1111l111111Il(Object paramObject) {
    return paramObject.getClass().getDeclaredFields();
  }
  
  public static Field[] l1111l111111Il(String paramString) {
    return Class.forName(paramString).getDeclaredFields();
  }
  
  public static Object l111l11111lIl(Object paramObject, String paramString) {
    return l1111l111111Il(paramObject, l1111l111111Il(paramObject.getClass(), paramString));
  }
  
  private static Object l111l11111lIl(String paramString1, String paramString2) {
    return l1111l111111Il((Object)null, l1111l111111Il(Class.forName(paramString1), paramString2));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l1111llIl\l111l1111l1Il.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */