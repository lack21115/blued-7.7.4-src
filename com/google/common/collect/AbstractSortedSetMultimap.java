package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class AbstractSortedSetMultimap<K, V> extends AbstractSetMultimap<K, V> implements SortedSetMultimap<K, V> {
  protected AbstractSortedSetMultimap(Map<K, Collection<V>> paramMap) {
    super(paramMap);
  }
  
  Collection<V> a(K paramK, Collection<V> paramCollection) {
    return (paramCollection instanceof NavigableSet) ? new AbstractMapBasedMultimap.WrappedNavigableSet(this, paramK, (NavigableSet<V>)paramCollection, null) : new AbstractMapBasedMultimap.WrappedSortedSet(this, paramK, (SortedSet<V>)paramCollection, null);
  }
  
  public Map<K, Collection<V>> c() {
    return super.c();
  }
  
  <E> SortedSet<E> c(Collection<E> paramCollection) {
    return (paramCollection instanceof NavigableSet) ? Sets.a((NavigableSet<E>)paramCollection) : Collections.unmodifiableSortedSet((SortedSet<E>)paramCollection);
  }
  
  public SortedSet<V> h(@NullableDecl K paramK) {
    return (SortedSet<V>)super.a(paramK);
  }
  
  public SortedSet<V> i(@NullableDecl Object paramObject) {
    return (SortedSet<V>)super.b(paramObject);
  }
  
  public Collection<V> j() {
    return super.j();
  }
  
  abstract SortedSet<V> w();
  
  SortedSet<V> x() {
    return c(w());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\AbstractSortedSetMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */