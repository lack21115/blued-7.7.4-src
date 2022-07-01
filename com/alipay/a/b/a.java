package com.alipay.a.b;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public final class a {
  public static Class<?> a(Type paramType) {
    while (true) {
      if (paramType instanceof Class)
        return (Class)paramType; 
      if (paramType instanceof ParameterizedType) {
        paramType = ((ParameterizedType)paramType).getRawType();
        continue;
      } 
      throw new IllegalArgumentException("TODO");
    } 
  }
  
  public static boolean a(Class<?> paramClass) {
    return paramClass.isPrimitive() ? true : (paramClass.equals(String.class) ? true : (paramClass.equals(Integer.class) ? true : (paramClass.equals(Long.class) ? true : (paramClass.equals(Double.class) ? true : (paramClass.equals(Float.class) ? true : (paramClass.equals(Boolean.class) ? true : (paramClass.equals(Short.class) ? true : (paramClass.equals(Character.class) ? true : (paramClass.equals(Byte.class) ? true : (paramClass.equals(Void.class)))))))))));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\a\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */