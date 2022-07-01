package com.blued.android.framework.utils;

import java.lang.reflect.Field;

public class ReflectionUtils {
  public static Field a(Object<?> paramObject, String paramString) {
    paramObject = (Object<?>)paramObject.getClass();
    while (paramObject != Object.class) {
      try {
        return paramObject.getDeclaredField(paramString);
      } catch (Exception exception) {
        exception.printStackTrace();
        paramObject = (Object<?>)paramObject.getSuperclass();
      } 
    } 
    return null;
  }
  
  public static void a(Object paramObject1, String paramString, Object paramObject2) {
    Field field = a(paramObject1, paramString);
    if (field != null)
      try {
        field.setAccessible(true);
        field.set(paramObject1, paramObject2);
        return;
      } catch (IllegalArgumentException illegalArgumentException) {
        illegalArgumentException.printStackTrace();
      } catch (IllegalAccessException illegalAccessException) {
        illegalAccessException.printStackTrace();
        return;
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\utils\ReflectionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */