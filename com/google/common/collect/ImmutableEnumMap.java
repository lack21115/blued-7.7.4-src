package com.google.common.collect;

import java.io.Serializable;
import java.util.EnumMap;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class ImmutableEnumMap<K extends Enum<K>, V> extends ImmutableMap.IteratorBasedImmutableMap<K, V> {
  private final transient EnumMap<K, V> a;
  
  UnmodifiableIterator<K> a() {
    return Iterators.a(this.a.keySet().iterator());
  }
  
  boolean b() {
    return false;
  }
  
  public boolean containsKey(@NullableDecl Object paramObject) {
    return this.a.containsKey(paramObject);
  }
  
  UnmodifiableIterator<Map.Entry<K, V>> d() {
    return Maps.c(this.a.entrySet().iterator());
  }
  
  public boolean equals(Object<K, V> paramObject) {
    if (paramObject == this)
      return true; 
    Object<K, V> object = paramObject;
    if (paramObject instanceof ImmutableEnumMap)
      object = (Object<K, V>)((ImmutableEnumMap)paramObject).a; 
    return this.a.equals(object);
  }
  
  public V get(Object paramObject) {
    return this.a.get(paramObject);
  }
  
  public int size() {
    return this.a.size();
  }
  
  static class EnumSerializedForm<K extends Enum<K>, V> implements Serializable {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ImmutableEnumMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */