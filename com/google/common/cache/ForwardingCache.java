package com.google.common.cache;

import com.google.common.collect.ForwardingObject;

public abstract class ForwardingCache<K, V> extends ForwardingObject implements Cache<K, V> {
  protected abstract Cache<K, V> a();
  
  public static abstract class SimpleForwardingCache<K, V> extends ForwardingCache<K, V> {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\cache\ForwardingCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */