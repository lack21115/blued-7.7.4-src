package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class Primitives {
  private static final Map<Class<?>, Class<?>> a;
  
  private static final Map<Class<?>, Class<?>> b;
  
  static {
    LinkedHashMap<Object, Object> linkedHashMap1 = new LinkedHashMap<Object, Object>(16);
    LinkedHashMap<Object, Object> linkedHashMap2 = new LinkedHashMap<Object, Object>(16);
    a((Map)linkedHashMap1, (Map)linkedHashMap2, boolean.class, Boolean.class);
    a((Map)linkedHashMap1, (Map)linkedHashMap2, byte.class, Byte.class);
    a((Map)linkedHashMap1, (Map)linkedHashMap2, char.class, Character.class);
    a((Map)linkedHashMap1, (Map)linkedHashMap2, double.class, Double.class);
    a((Map)linkedHashMap1, (Map)linkedHashMap2, float.class, Float.class);
    a((Map)linkedHashMap1, (Map)linkedHashMap2, int.class, Integer.class);
    a((Map)linkedHashMap1, (Map)linkedHashMap2, long.class, Long.class);
    a((Map)linkedHashMap1, (Map)linkedHashMap2, short.class, Short.class);
    a((Map)linkedHashMap1, (Map)linkedHashMap2, void.class, Void.class);
    a = Collections.unmodifiableMap(linkedHashMap1);
    b = Collections.unmodifiableMap(linkedHashMap2);
  }
  
  public static <T> Class<T> a(Class<T> paramClass) {
    Preconditions.a(paramClass);
    Class<T> clazz = (Class)a.get(paramClass);
    return (clazz == null) ? paramClass : clazz;
  }
  
  private static void a(Map<Class<?>, Class<?>> paramMap1, Map<Class<?>, Class<?>> paramMap2, Class<?> paramClass1, Class<?> paramClass2) {
    paramMap1.put(paramClass1, paramClass2);
    paramMap2.put(paramClass2, paramClass1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\primitives\Primitives.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */