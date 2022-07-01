package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

final class FilteredEntrySetMultimap<K, V> extends FilteredEntryMultimap<K, V> implements FilteredSetMultimap<K, V> {
  public Set<V> a(K paramK) {
    return (Set<V>)super.c(paramK);
  }
  
  public Set<V> b(Object paramObject) {
    return (Set<V>)super.d(paramObject);
  }
  
  public SetMultimap<K, V> e() {
    return (SetMultimap<K, V>)this.a;
  }
  
  Set<Map.Entry<K, V>> i() {
    return Sets.a(e().t(), b());
  }
  
  public Set<Map.Entry<K, V>> t() {
    return (Set<Map.Entry<K, V>>)super.m();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\FilteredEntrySetMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */