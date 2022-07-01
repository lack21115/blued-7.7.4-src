package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class FilteredKeySetMultimap<K, V> extends FilteredKeyMultimap<K, V> implements FilteredSetMultimap<K, V> {
  public Set<V> a(K paramK) {
    return (Set<V>)super.c(paramK);
  }
  
  public Set<V> b(Object paramObject) {
    return (Set<V>)super.d(paramObject);
  }
  
  public SetMultimap<K, V> d() {
    return (SetMultimap<K, V>)this.a;
  }
  
  Set<Map.Entry<K, V>> i() {
    return new EntrySet(this);
  }
  
  public Set<Map.Entry<K, V>> t() {
    return (Set<Map.Entry<K, V>>)super.m();
  }
  
  class EntrySet extends FilteredKeyMultimap<K, V>.Entries implements Set<Map.Entry<K, V>> {
    EntrySet(FilteredKeySetMultimap this$0) {
      super(this$0);
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      return Sets.a(this, param1Object);
    }
    
    public int hashCode() {
      return Sets.a(this);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\FilteredKeySetMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */