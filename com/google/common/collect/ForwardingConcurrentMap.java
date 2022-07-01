package com.google.common.collect;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public abstract class ForwardingConcurrentMap<K, V> extends ForwardingMap<K, V> implements ConcurrentMap<K, V> {
  protected abstract ConcurrentMap<K, V> c();
  
  public V putIfAbsent(K paramK, V paramV) {
    return c().putIfAbsent(paramK, paramV);
  }
  
  public boolean remove(Object paramObject1, Object paramObject2) {
    return c().remove(paramObject1, paramObject2);
  }
  
  public V replace(K paramK, V paramV) {
    return c().replace(paramK, paramV);
  }
  
  public boolean replace(K paramK, V paramV1, V paramV2) {
    return c().replace(paramK, paramV1, paramV2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ForwardingConcurrentMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */