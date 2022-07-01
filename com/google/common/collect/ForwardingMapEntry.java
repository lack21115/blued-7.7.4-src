package com.google.common.collect;

import com.google.common.base.Objects;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class ForwardingMapEntry<K, V> extends ForwardingObject implements Map.Entry<K, V> {
  protected abstract Map.Entry<K, V> a();
  
  protected boolean a(@NullableDecl Object paramObject) {
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
  
  public boolean equals(@NullableDecl Object paramObject) {
    return a().equals(paramObject);
  }
  
  public K getKey() {
    return a().getKey();
  }
  
  public V getValue() {
    return a().getValue();
  }
  
  public int hashCode() {
    return a().hashCode();
  }
  
  public V setValue(V paramV) {
    return a().setValue(paramV);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ForwardingMapEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */