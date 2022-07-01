package com.google.common.graph;

import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class MapIteratorCache<K, V> {
  private final Map<K, V> a;
  
  @NullableDecl
  private volatile transient Map.Entry<K, V> b;
  
  public V a(@NullableDecl Object paramObject) {
    V v = d(paramObject);
    return (v != null) ? v : b(paramObject);
  }
  
  public final Set<K> a() {
    return new AbstractSet<K>(this) {
        public UnmodifiableIterator<K> a() {
          return new UnmodifiableIterator<K>(this, MapIteratorCache.a(this.a).entrySet().iterator()) {
              public boolean hasNext() {
                return this.a.hasNext();
              }
              
              public K next() {
                Map.Entry entry = this.a.next();
                MapIteratorCache.a(this.b.a, entry);
                return (K)entry.getKey();
              }
            };
        }
        
        public boolean contains(@NullableDecl Object param1Object) {
          return this.a.c(param1Object);
        }
        
        public int size() {
          return MapIteratorCache.a(this.a).size();
        }
      };
  }
  
  public final V b(@NullableDecl Object paramObject) {
    return this.a.get(paramObject);
  }
  
  public final boolean c(@NullableDecl Object paramObject) {
    return (d(paramObject) != null || this.a.containsKey(paramObject));
  }
  
  protected V d(@NullableDecl Object paramObject) {
    Map.Entry<K, V> entry = this.b;
    return (entry != null && entry.getKey() == paramObject) ? entry.getValue() : null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\graph\MapIteratorCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */