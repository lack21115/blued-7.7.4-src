package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V> implements BiMap<K, V> {
  public static <K, V> ImmutableBiMap<K, V> ax_() {
    return (ImmutableBiMap)RegularImmutableBiMap.a;
  }
  
  public abstract ImmutableBiMap<V, K> e();
  
  public ImmutableSet<V> f() {
    return e().n();
  }
  
  final ImmutableSet<V> g() {
    throw new AssertionError("should never be called");
  }
  
  public static final class Builder<K, V> extends ImmutableMap.Builder<K, V> {
    public Builder<K, V> a(Iterable<? extends Map.Entry<? extends K, ? extends V>> param1Iterable) {
      super.b(param1Iterable);
      return this;
    }
    
    public Builder<K, V> a(K param1K, V param1V) {
      super.b(param1K, param1V);
      return this;
    }
    
    public Builder<K, V> a(Map.Entry<? extends K, ? extends V> param1Entry) {
      super.b(param1Entry);
      return this;
    }
    
    public Builder<K, V> a(Map<? extends K, ? extends V> param1Map) {
      super.b(param1Map);
      return this;
    }
    
    public ImmutableBiMap<K, V> a() {
      if (this.c == 0)
        return ImmutableBiMap.ax_(); 
      c();
      this.d = true;
      return new RegularImmutableBiMap<K, V>(this.b, this.c);
    }
  }
  
  static class SerializedForm extends ImmutableMap.SerializedForm {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ImmutableBiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */