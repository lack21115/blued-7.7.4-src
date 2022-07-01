package com.huawei.hms.support.gentyref;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public final class GenericTypeReflector {
  public static Class<?> getType(Type paramType) {
    if (paramType instanceof Class)
      return (Class)paramType; 
    if (paramType instanceof ParameterizedType)
      return (Class)((ParameterizedType)paramType).getRawType(); 
    if (paramType instanceof java.lang.reflect.TypeVariable) {
      paramType = paramType;
      return ((paramType.getBounds()).length == 0) ? Object.class : getType(paramType.getBounds()[0]);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("not supported: ");
    stringBuilder.append(paramType.getClass());
    throw new IllegalArgumentException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\gentyref\GenericTypeReflector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */