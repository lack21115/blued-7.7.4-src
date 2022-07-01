package com.google.common.cache;

import com.google.common.base.Function;

public interface LoadingCache<K, V> extends Function<K, V>, Cache<K, V> {
  @Deprecated
  V f(K paramK);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\cache\LoadingCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */