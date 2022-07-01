package com.qq.e.comm.plugin.util;

import android.text.TextUtils;
import com.qq.e.comm.util.GDTLogger;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ap {
  public static Class a(String paramString) {
    try {
      return Class.forName(paramString);
    } catch (ClassNotFoundException classNotFoundException) {
      GDTLogger.d(classNotFoundException.toString());
      return null;
    } 
  }
  
  public static Object a(Class<Class<?>> paramClass) {
    if (paramClass != null)
      try {
        return paramClass.newInstance();
      } catch (IllegalAccessException illegalAccessException) {
        illegalAccessException.printStackTrace();
      } catch (InstantiationException instantiationException) {
        instantiationException.printStackTrace();
      }  
    return null;
  }
  
  public static Object a(Object paramObject, Method paramMethod, boolean paramBoolean, Object... paramVarArgs) {
    if (paramObject != null && paramMethod != null)
      if (!paramBoolean) {
        try {
          if (!paramMethod.isAccessible())
            paramMethod.setAccessible(true); 
          return paramMethod.invoke(paramObject, paramVarArgs);
        } catch (IllegalAccessException illegalAccessException) {
          illegalAccessException.printStackTrace();
        } catch (InvocationTargetException invocationTargetException) {
          invocationTargetException.printStackTrace();
        } 
      } else {
        return paramMethod.invoke(invocationTargetException, paramVarArgs);
      }  
    return null;
  }
  
  public static Object a(Object paramObject, Method paramMethod, Object... paramVarArgs) {
    return a(paramObject, paramMethod, true, paramVarArgs);
  }
  
  public static Field a(Class paramClass, String paramString) {
    return a(paramClass, paramString, true);
  }
  
  public static Field a(Class paramClass, String paramString, boolean paramBoolean) {
    if (paramClass != null && !TextUtils.isEmpty(paramString))
      if (paramBoolean) {
        try {
          return paramClass.getField(paramString);
        } catch (NoSuchFieldException noSuchFieldException) {
          noSuchFieldException.printStackTrace();
        } 
      } else {
        return noSuchFieldException.getDeclaredField(paramString);
      }  
    return null;
  }
  
  public static Method a(Class paramClass, String paramString, boolean paramBoolean, Class... paramVarArgs) {
    if (paramClass != null && !TextUtils.isEmpty(paramString))
      if (paramBoolean) {
        try {
          return paramClass.getMethod(paramString, paramVarArgs);
        } catch (NoSuchMethodException noSuchMethodException) {
          noSuchMethodException.printStackTrace();
        } 
      } else {
        return noSuchMethodException.getDeclaredMethod(paramString, paramVarArgs);
      }  
    return null;
  }
  
  public static Method a(Class paramClass, String paramString, Class... paramVarArgs) {
    return a(paramClass, paramString, true, paramVarArgs);
  }
  
  public static boolean a(Field paramField, Object paramObject1, Object paramObject2) {
    return a(paramField, paramObject1, true, paramObject2);
  }
  
  public static boolean a(Field paramField, Object paramObject1, boolean paramBoolean, Object paramObject2) {
    if (paramField != null && paramObject1 != null)
      if (!paramBoolean) {
        try {
          if (!paramField.isAccessible())
            paramField.setAccessible(true); 
          paramField.set(paramObject1, paramObject2);
          return true;
        } catch (IllegalAccessException illegalAccessException) {
          illegalAccessException.printStackTrace();
        } 
      } else {
        illegalAccessException.set(paramObject1, paramObject2);
        return true;
      }  
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */