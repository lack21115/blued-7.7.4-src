package com.google.common.graph;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class MapRetrievalCache<K, V> extends MapIteratorCache<K, V> {
  @NullableDecl
  private volatile transient CacheEntry<K, V> a;
  
  @NullableDecl
  private volatile transient CacheEntry<K, V> b;
  
  private void a(CacheEntry<K, V> paramCacheEntry) {
    this.b = this.a;
    this.a = paramCacheEntry;
  }
  
  private void a(K paramK, V paramV) {
    a(new CacheEntry<K, V>(paramK, paramV));
  }
  
  public V a(@NullableDecl Object paramObject) {
    V v = d(paramObject);
    if (v != null)
      return v; 
    v = b(paramObject);
    if (v != null)
      a((K)paramObject, v); 
    return v;
  }
  
  protected V d(@NullableDecl Object paramObject) {
    V v = super.d(paramObject);
    if (v != null)
      return v; 
    CacheEntry<K, V> cacheEntry = this.a;
    if (cacheEntry != null && cacheEntry.a == paramObject)
      return cacheEntry.b; 
    cacheEntry = this.b;
    if (cacheEntry != null && cacheEntry.a == paramObject) {
      a(cacheEntry);
      return cacheEntry.b;
    } 
    return null;
  }
  
  static final class CacheEntry<K, V> {
    final K a;
    
    final V b;
    
    CacheEntry(K param1K, V param1V) {
      this.a = param1K;
      this.b = param1V;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\graph\MapRetrievalCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */