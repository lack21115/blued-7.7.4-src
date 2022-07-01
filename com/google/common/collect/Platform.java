package com.google.common.collect;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

final class Platform {
  static MapMaker a(MapMaker paramMapMaker) {
    return paramMapMaker.d();
  }
  
  static <K, V> Map<K, V> a() {
    return CompactHashMap.a();
  }
  
  static <K, V> Map<K, V> a(int paramInt) {
    return CompactHashMap.a(paramInt);
  }
  
  static <T> T[] a(T[] paramArrayOfT, int paramInt) {
    return (T[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), paramInt);
  }
  
  static <T> T[] a(Object[] paramArrayOfObject, int paramInt1, int paramInt2, T[] paramArrayOfT) {
    return Arrays.copyOfRange(paramArrayOfObject, paramInt1, paramInt2, (Class)paramArrayOfT.getClass());
  }
  
  static <K, V> Map<K, V> b(int paramInt) {
    return CompactLinkedHashMap.g(paramInt);
  }
  
  static <E> Set<E> b() {
    return CompactHashSet.a();
  }
  
  static <E> Set<E> c(int paramInt) {
    return CompactHashSet.a(paramInt);
  }
  
  static <E> Set<E> d(int paramInt) {
    return CompactLinkedHashSet.e(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */