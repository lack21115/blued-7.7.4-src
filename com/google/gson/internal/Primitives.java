package com.google.gson.internal;

import java.lang.reflect.Type;

public final class Primitives {
  public static boolean isPrimitive(Type paramType) {
    return (paramType instanceof Class && ((Class)paramType).isPrimitive());
  }
  
  public static boolean isWrapperType(Type paramType) {
    return (paramType == Integer.class || paramType == Float.class || paramType == Byte.class || paramType == Double.class || paramType == Long.class || paramType == Character.class || paramType == Boolean.class || paramType == Short.class || paramType == Void.class);
  }
  
  public static <T> Class<T> unwrap(Class<T> paramClass) {
    Class<void> clazz;
    if (paramClass == Integer.class)
      return (Class)int.class; 
    if (paramClass == Float.class)
      return (Class)float.class; 
    if (paramClass == Byte.class)
      return (Class)byte.class; 
    if (paramClass == Double.class)
      return (Class)double.class; 
    if (paramClass == Long.class)
      return (Class)long.class; 
    if (paramClass == Character.class)
      return (Class)char.class; 
    if (paramClass == Boolean.class)
      return (Class)boolean.class; 
    if (paramClass == Short.class)
      return (Class)short.class; 
    Class<T> clazz1 = paramClass;
    if (paramClass == Void.class)
      clazz = void.class; 
    return (Class)clazz;
  }
  
  public static <T> Class<T> wrap(Class<T> paramClass) {
    Class<Void> clazz;
    if (paramClass == int.class)
      return (Class)Integer.class; 
    if (paramClass == float.class)
      return (Class)Float.class; 
    if (paramClass == byte.class)
      return (Class)Byte.class; 
    if (paramClass == double.class)
      return (Class)Double.class; 
    if (paramClass == long.class)
      return (Class)Long.class; 
    if (paramClass == char.class)
      return (Class)Character.class; 
    if (paramClass == boolean.class)
      return (Class)Boolean.class; 
    if (paramClass == short.class)
      return (Class)Short.class; 
    Class<T> clazz1 = paramClass;
    if (paramClass == void.class)
      clazz = Void.class; 
    return (Class)clazz;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\gson\internal\Primitives.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */