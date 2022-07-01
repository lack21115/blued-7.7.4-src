package com.google.common.collect;

import com.google.common.base.Objects;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class AbstractMapEntry<K, V> implements Map.Entry<K, V> {
  public boolean equals(@NullableDecl Object paramObject) {
    boolean bool = paramObject instanceof Map.Entry;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool) {
      paramObject = paramObject;
      bool1 = bool2;
      if (Objects.a(getKey(), paramObject.getKey())) {
        bool1 = bool2;
        if (Objects.a(getValue(), paramObject.getValue()))
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  public abstract K getKey();
  
  public abstract V getValue();
  
  public int hashCode() {
    int i;
    K k = getKey();
    V v = getValue();
    int j = 0;
    if (k == null) {
      i = 0;
    } else {
      i = k.hashCode();
    } 
    if (v != null)
      j = v.hashCode(); 
    return i ^ j;
  }
  
  public V setValue(V paramV) {
    throw new UnsupportedOperationException();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getKey());
    stringBuilder.append("=");
    stringBuilder.append(getValue());
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\AbstractMapEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */