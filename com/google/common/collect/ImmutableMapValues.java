package com.google.common.collect;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class ImmutableMapValues<K, V> extends ImmutableCollection<V> {
  private final ImmutableMap<K, V> a;
  
  ImmutableMapValues(ImmutableMap<K, V> paramImmutableMap) {
    this.a = paramImmutableMap;
  }
  
  boolean a() {
    return true;
  }
  
  public UnmodifiableIterator<V> av_() {
    return new UnmodifiableIterator<V>(this) {
        final UnmodifiableIterator<Map.Entry<K, V>> a = ImmutableMapValues.a(this.b).l().av_();
        
        public boolean hasNext() {
          return this.a.hasNext();
        }
        
        public V next() {
          return (V)((Map.Entry)this.a.next()).getValue();
        }
      };
  }
  
  public boolean contains(@NullableDecl Object paramObject) {
    return (paramObject != null && Iterators.a(av_(), paramObject));
  }
  
  public ImmutableList<V> h() {
    return new ImmutableList<V>(this, this.a.l().h()) {
        boolean a() {
          return true;
        }
        
        public V get(int param1Int) {
          return (V)((Map.Entry)this.a.get(param1Int)).getValue();
        }
        
        public int size() {
          return this.a.size();
        }
      };
  }
  
  public int size() {
    return this.a.size();
  }
  
  static class SerializedForm<V> implements Serializable {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ImmutableMapValues.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */