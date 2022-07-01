package com.google.common.cache;

public abstract class ForwardingLoadingCache<K, V> extends ForwardingCache<K, V> implements LoadingCache<K, V> {
  public static abstract class SimpleForwardingLoadingCache<K, V> extends ForwardingLoadingCache<K, V> {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\cache\ForwardingLoadingCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */