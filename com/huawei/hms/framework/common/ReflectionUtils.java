package com.huawei.hms.framework.common;

import android.text.TextUtils;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class ReflectionUtils {
  private static final String TAG = "ReflectionUtils";
  
  public static Class<?> getClass(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    if (!"com.huawei.android.os.BuildEx$VERSION".equals(paramString) && !"com.huawei.android.immersion.ImmersionStyle".equals(paramString))
      return null; 
    try {
      return Class.forName(paramString);
    } catch (ClassNotFoundException classNotFoundException) {
      Logger.w("ReflectionUtils", "ClassNotFoundException occur in method ReflectionUtils.getClass()");
      return null;
    } 
  }
  
  private static Method getMethod(Class<?> paramClass, String paramString, Class<?>... paramVarArgs) {
    if (paramClass == null || paramString == null) {
      Logger.w("ReflectionUtils", "targetClass is  null pr name is null:");
      return null;
    } 
    if (!"getPrimaryColor".equals(paramString) && !"getSuggestionForgroundColorStyle".equals(paramString))
      return null; 
    try {
      return paramClass.getDeclaredMethod(paramString, paramVarArgs);
    } catch (SecurityException securityException) {
      paramString = "SecurityException:";
    } catch (NoSuchMethodException noSuchMethodException) {
      paramString = "NoSuchMethodException:";
    } 
    Logger.e("ReflectionUtils", paramString, noSuchMethodException);
    return null;
  }
  
  public static Object getStaticFieldObj(String paramString1, String paramString2) {
    Class<?> clazz = getClass(paramString1);
    if (clazz != null) {
      if (TextUtils.isEmpty(paramString2))
        return null; 
      if ("com.huawei.android.os.BuildEx$VERSION".equals(paramString1)) {
        if (!"EMUI_SDK_INT".equals(paramString2))
          return null; 
        try {
          Field field = clazz.getDeclaredField(paramString2);
          AccessibleObject.setAccessible((AccessibleObject[])new Field[] { field }, true);
          return field.get(clazz);
        } catch (IllegalAccessException illegalAccessException) {
          paramString2 = "Exception in getFieldObj :: IllegalAccessException:";
        } catch (IllegalArgumentException illegalArgumentException) {
          paramString2 = "Exception in getFieldObj :: IllegalArgumentException:";
        } catch (NoSuchFieldException noSuchFieldException) {
          paramString2 = "Exception in getFieldObj :: NoSuchFieldException:";
        } catch (SecurityException securityException) {
          paramString2 = "not security int method getStaticFieldObj,SecurityException:";
        } 
        Logger.e("ReflectionUtils", paramString2, securityException);
      } 
    } 
    return null;
  }
  
  private static Object invoke(Object paramObject, Method paramMethod, Object... paramVarArgs) {
    String str;
    if (paramMethod == null)
      return null; 
    try {
      return paramMethod.invoke(paramObject, paramVarArgs);
    } catch (RuntimeException null) {
      str = "RuntimeException in invoke:";
    } catch (Exception exception) {
      str = "Exception in invoke:";
    } 
    Logger.e("ReflectionUtils", str, exception);
    return null;
  }
  
  public static Object invokeStaticMethod(String paramString1, String paramString2, Class<?>[] paramArrayOfClass, Object... paramVarArgs) {
    Method method = getMethod(getClass(paramString1), paramString2, paramArrayOfClass);
    return (method == null) ? null : invoke(null, method, paramVarArgs);
  }
  
  public static Object invokeStaticMethod(String paramString1, String paramString2, Object... paramVarArgs) {
    Class[] arrayOfClass;
    if (paramVarArgs != null) {
      int j = paramVarArgs.length;
      Class[] arrayOfClass1 = new Class[j];
      int i = 0;
      while (true) {
        arrayOfClass = arrayOfClass1;
        if (i < j) {
          setClassType(arrayOfClass1, paramVarArgs[i], i);
          i++;
          continue;
        } 
        break;
      } 
    } else {
      arrayOfClass = null;
    } 
    Method method = getMethod(getClass(paramString1), paramString2, arrayOfClass);
    return (method == null) ? null : invoke(null, method, paramVarArgs);
  }
  
  private static void setClassType(Class<?>[] paramArrayOfClass, Object paramObject, int paramInt) {
    if (paramObject instanceof Integer) {
      paramArrayOfClass[paramInt] = int.class;
      return;
    } 
    if (paramObject instanceof Long) {
      paramArrayOfClass[paramInt] = long.class;
      return;
    } 
    if (paramObject instanceof Double) {
      paramArrayOfClass[paramInt] = double.class;
      return;
    } 
    if (paramObject instanceof Float) {
      paramArrayOfClass[paramInt] = float.class;
      return;
    } 
    if (paramObject instanceof Boolean) {
      paramArrayOfClass[paramInt] = boolean.class;
      return;
    } 
    if (paramObject instanceof Character) {
      paramArrayOfClass[paramInt] = char.class;
      return;
    } 
    if (paramObject instanceof Byte) {
      paramArrayOfClass[paramInt] = byte.class;
      return;
    } 
    if (paramObject instanceof Void) {
      paramArrayOfClass[paramInt] = void.class;
      return;
    } 
    if (paramObject instanceof Short) {
      paramArrayOfClass[paramInt] = short.class;
      return;
    } 
    paramArrayOfClass[paramInt] = paramObject.getClass();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\common\ReflectionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */