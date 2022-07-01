package com.facebook.stetho.common;

import java.lang.reflect.Field;
import javax.annotation.Nullable;

public final class ReflectionUtil {
  @Nullable
  public static Object getFieldValue(Field paramField, Object paramObject) {
    try {
      return paramField.get(paramObject);
    } catch (IllegalAccessException illegalAccessException) {
      throw new RuntimeException(illegalAccessException);
    } 
  }
  
  @Nullable
  public static Class<?> tryGetClassForName(String paramString) {
    try {
      return Class.forName(paramString);
    } catch (ClassNotFoundException classNotFoundException) {
      return null;
    } 
  }
  
  @Nullable
  public static Field tryGetDeclaredField(Class<?> paramClass, String paramString) {
    try {
      return paramClass.getDeclaredField(paramString);
    } catch (NoSuchFieldException noSuchFieldException) {
      LogUtil.d(noSuchFieldException, "Could not retrieve %s field from %s", new Object[] { paramString, paramClass });
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\common\ReflectionUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */