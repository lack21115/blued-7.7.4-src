package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class AbstractSetMultimap<K, V> extends AbstractMapBasedMultimap<K, V> implements SetMultimap<K, V> {
  protected AbstractSetMultimap(Map<K, Collection<V>> paramMap) {
    super(paramMap);
  }
  
  Collection<V> a(K paramK, Collection<V> paramCollection) {
    return new AbstractMapBasedMultimap.WrappedSet(this, paramK, (Set<V>)paramCollection);
  }
  
  <E> Collection<E> a(Collection<E> paramCollection) {
    return Collections.unmodifiableSet((Set<? extends E>)paramCollection);
  }
  
  abstract Set<V> a();
  
  public Set<V> a(@NullableDecl K paramK) {
    return (Set<V>)super.c(paramK);
  }
  
  public boolean a(@NullableDecl K paramK, @NullableDecl V paramV) {
    return super.a(paramK, paramV);
  }
  
  Set<V> b() {
    return Collections.emptySet();
  }
  
  public Set<V> b(@NullableDecl Object paramObject) {
    return (Set<V>)super.d(paramObject);
  }
  
  public Map<K, Collection<V>> c() {
    return super.c();
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    return super.equals(paramObject);
  }
  
  public Set<Map.Entry<K, V>> t() {
    return (Set<Map.Entry<K, V>>)super.m();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\AbstractSetMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */