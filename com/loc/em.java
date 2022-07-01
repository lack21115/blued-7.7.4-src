package com.loc;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class em {
  public static Object a(Object paramObject, Class<?> paramClass, String paramString, Object... paramVarArgs) throws Exception {
    Class[] arrayOfClass = new Class[paramVarArgs.length];
    int j = paramVarArgs.length;
    int i;
    for (i = 0; i < j; i++) {
      arrayOfClass[i] = paramVarArgs[i].getClass();
      if (arrayOfClass[i] == Integer.class)
        arrayOfClass[i] = int.class; 
      if (arrayOfClass[i] == Boolean.class)
        arrayOfClass[i] = boolean.class; 
      if (arrayOfClass[i] == Double.class)
        arrayOfClass[i] = double.class; 
    } 
    Method method = paramClass.getDeclaredMethod(paramString, arrayOfClass);
    if (!method.isAccessible())
      method.setAccessible(true); 
    try {
      return method.invoke(paramObject, paramVarArgs);
    } finally {
      paramObject = null;
    } 
  }
  
  public static Object a(Object paramObject, String paramString, Object... paramVarArgs) {
    try {
      return a(paramObject, paramObject.getClass(), paramString, paramVarArgs);
    } finally {
      paramObject = null;
    } 
  }
  
  public static Object a(String paramString1, String paramString2) throws Exception {
    Class<?> clazz = Class.forName(paramString1);
    Field field = clazz.getField(paramString2);
    field.setAccessible(true);
    return field.get(clazz);
  }
  
  public static Object a(String paramString1, String paramString2, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass) throws Exception {
    Method method = Class.forName(paramString1).getDeclaredMethod(paramString2, paramArrayOfClass);
    if (!method.isAccessible())
      method.setAccessible(true); 
    return method.invoke((Object)null, paramArrayOfObject);
  }
  
  public static int b(Object paramObject, String paramString, Object... paramVarArgs) throws Exception {
    return ((Integer)a(paramObject, paramString, paramVarArgs)).intValue();
  }
  
  public static int b(String paramString1, String paramString2) throws Exception {
    return ((Integer)a(paramString1, paramString2)).intValue();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\em.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */