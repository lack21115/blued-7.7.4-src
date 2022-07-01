package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class AbstractListMultimap<K, V> extends AbstractMapBasedMultimap<K, V> implements ListMultimap<K, V> {
  protected AbstractListMultimap(Map<K, Collection<V>> paramMap) {
    super(paramMap);
  }
  
  Collection<V> a(K paramK, Collection<V> paramCollection) {
    return a(paramK, (List<V>)paramCollection, (AbstractMapBasedMultimap<K, V>.WrappedCollection)null);
  }
  
  <E> Collection<E> a(Collection<E> paramCollection) {
    return Collections.unmodifiableList((List<? extends E>)paramCollection);
  }
  
  abstract List<V> a();
  
  public List<V> a(@NullableDecl K paramK) {
    return (List<V>)super.c(paramK);
  }
  
  public boolean a(@NullableDecl K paramK, @NullableDecl V paramV) {
    return super.a(paramK, paramV);
  }
  
  List<V> b() {
    return Collections.emptyList();
  }
  
  public List<V> b(@NullableDecl Object paramObject) {
    return (List<V>)super.d(paramObject);
  }
  
  public Map<K, Collection<V>> c() {
    return super.c();
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    return super.equals(paramObject);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\AbstractListMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */