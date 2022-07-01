package com.blued.android.module.common.utils;

import java.lang.reflect.Field;

public class ReflectionUtils {
  public static Field a(Object<?> paramObject, String paramString) {
    paramObject = (Object<?>)paramObject.getClass();
    while (true) {
      if (paramObject != Object.class)
        try {
          return paramObject.getDeclaredField(paramString);
        } catch (Exception exception) {
          paramObject = (Object<?>)paramObject.getSuperclass();
          continue;
        }  
      return null;
    } 
  }
  
  public static void a(Object paramObject1, Object paramObject2) {
    a(paramObject1, paramObject2, false);
  }
  
  public static void a(Object paramObject1, Object paramObject2, boolean paramBoolean) {
    if (paramObject1 != null) {
      if (paramObject2 == null)
        return; 
      Field[] arrayOfField1 = paramObject1.getClass().getDeclaredFields();
      Field[] arrayOfField2 = paramObject2.getClass().getDeclaredFields();
      int j = arrayOfField1.length;
      int i;
      for (i = 0; i < j; i++) {
        String str = arrayOfField1[i].getName();
        Object object = b(paramObject1, str);
        int m = arrayOfField2.length;
        int k;
        for (k = 0; k < m; k++) {
          String str1 = arrayOfField2[k].getName();
          if (str1.toUpperCase().equals(str.toUpperCase())) {
            if (!paramBoolean || object != null)
              a(paramObject2, str1, object); 
            break;
          } 
        } 
      } 
      arrayOfField1 = paramObject1.getClass().getFields();
      arrayOfField2 = paramObject2.getClass().getFields();
      j = arrayOfField1.length;
      for (i = 0; i < j; i++) {
        String str = arrayOfField1[i].getName();
        Object object = b(paramObject1, str);
        int m = arrayOfField2.length;
        int k;
        for (k = 0; k < m; k++) {
          String str1 = arrayOfField2[k].getName();
          if (str1.toUpperCase().equals(str.toUpperCase())) {
            if (!paramBoolean || object != null)
              a(paramObject2, str1, object); 
            break;
          } 
        } 
      } 
    } 
  }
  
  public static void a(Object paramObject1, String paramString, Object paramObject2) {
    Field field = a(paramObject1, paramString);
    field.setAccessible(true);
    try {
      field.set(paramObject1, paramObject2);
      return;
    } catch (IllegalArgumentException illegalArgumentException) {
      illegalArgumentException.printStackTrace();
      return;
    } catch (IllegalAccessException illegalAccessException) {
      illegalAccessException.printStackTrace();
      return;
    } 
  }
  
  public static Object b(Object paramObject, String paramString) {
    Field field = a(paramObject, paramString);
    field.setAccessible(true);
    try {
      return field.get(paramObject);
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\commo\\utils\ReflectionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */