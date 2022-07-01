package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

abstract class AbstractSortedKeySortedSetMultimap<K, V> extends AbstractSortedSetMultimap<K, V> {
  Set<K> h() {
    return i();
  }
  
  public SortedMap<K, Collection<V>> u() {
    return (SortedMap<K, Collection<V>>)super.c();
  }
  
  public SortedSet<K> v() {
    return (SortedSet<K>)super.s();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\AbstractSortedKeySortedSetMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */