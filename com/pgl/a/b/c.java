package com.pgl.a.b;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class c {
  private static final Map<Class<?>, Class<?>> a = new HashMap<Class<?>, Class<?>>();
  
  static {
    a.put(Boolean.class, boolean.class);
    a.put(Byte.class, byte.class);
    a.put(Character.class, char.class);
    a.put(Short.class, short.class);
    a.put(Integer.class, int.class);
    a.put(Float.class, float.class);
    a.put(Long.class, long.class);
    a.put(Double.class, double.class);
    a.put(boolean.class, boolean.class);
    a.put(byte.class, byte.class);
    a.put(char.class, char.class);
    a.put(short.class, short.class);
    a.put(int.class, int.class);
    a.put(float.class, float.class);
    a.put(long.class, long.class);
    a.put(double.class, double.class);
  }
  
  private static Method a(Class<?> paramClass, String paramString, Class... paramVarArgs) {
    Method method = a(paramClass.getDeclaredMethods(), paramString, paramVarArgs);
    if (method == null) {
      if (paramClass.getSuperclass() != null)
        return a(paramClass.getSuperclass(), paramString, paramVarArgs); 
      throw new NoSuchMethodException();
    } 
    method.setAccessible(true);
    return method;
  }
  
  private static Method a(Method[] paramArrayOfMethod, String paramString, Class<?>[] paramArrayOfClass) {
    if (paramString != null) {
      int j = paramArrayOfMethod.length;
      for (int i = 0; i < j; i++) {
        Method method = paramArrayOfMethod[i];
        if (method.getName().equals(paramString) && a(method.getParameterTypes(), paramArrayOfClass))
          return method; 
      } 
      return null;
    } 
    throw new NullPointerException("Method name must not be null.");
  }
  
  public static void a(Class<?> paramClass, String paramString, Object... paramVarArgs) {
    a(paramClass, paramString, a(paramVarArgs)).invoke((Object)null, b(paramVarArgs));
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs) {
    try {
      a(Class.forName(paramString1), paramString2, paramVarArgs);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private static boolean a(Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2) {
    boolean bool = true;
    if (paramArrayOfClass1 == null) {
      if (paramArrayOfClass2 != null) {
        if (paramArrayOfClass2.length == 0)
          return true; 
        bool = false;
      } 
      return bool;
    } 
    if (paramArrayOfClass2 == null)
      return (paramArrayOfClass1.length == 0); 
    if (paramArrayOfClass1.length != paramArrayOfClass2.length)
      return false; 
    for (int i = 0; i < paramArrayOfClass1.length; i++) {
      if (!paramArrayOfClass1[i].isAssignableFrom(paramArrayOfClass2[i]) && (!a.containsKey(paramArrayOfClass1[i]) || !((Class)a.get(paramArrayOfClass1[i])).equals(a.get(paramArrayOfClass2[i]))))
        return false; 
    } 
    return true;
  }
  
  private static Class<?>[] a(Object... paramVarArgs) {
    Class[] arrayOfClass2 = null;
    Class[] arrayOfClass1 = arrayOfClass2;
    if (paramVarArgs != null) {
      arrayOfClass1 = arrayOfClass2;
      if (paramVarArgs.length > 0) {
        arrayOfClass2 = new Class[paramVarArgs.length];
        for (int i = 0; i < paramVarArgs.length; i++) {
          Object<?> object = (Object<?>)paramVarArgs[i];
          if (object != null && object instanceof a) {
            arrayOfClass2[i] = ((a)object).a;
          } else {
            if (object == null) {
              object = null;
            } else {
              object = (Object<?>)object.getClass();
            } 
            arrayOfClass2[i] = (Class)object;
          } 
        } 
        arrayOfClass1 = arrayOfClass2;
      } 
    } 
    return arrayOfClass1;
  }
  
  private static Object[] b(Object... paramVarArgs) {
    Object[] arrayOfObject;
    if (paramVarArgs != null && paramVarArgs.length > 0) {
      Object[] arrayOfObject1 = new Object[paramVarArgs.length];
      int i = 0;
      while (true) {
        arrayOfObject = arrayOfObject1;
        if (i < paramVarArgs.length) {
          Object object = paramVarArgs[i];
          if (object != null && object instanceof a) {
            arrayOfObject1[i] = ((a)object).b;
          } else {
            arrayOfObject1[i] = object;
          } 
          i++;
          continue;
        } 
        break;
      } 
    } else {
      arrayOfObject = null;
    } 
    return arrayOfObject;
  }
  
  public static class a<T> {
    public final Class<? extends T> a;
    
    public final T b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\pgl\a\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */