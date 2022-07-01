package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class TreeMultimap<K, V> extends AbstractSortedKeySortedSetMultimap<K, V> {
  private transient Comparator<? super K> a;
  
  private transient Comparator<? super V> b;
  
  public NavigableMap<K, Collection<V>> A() {
    return (NavigableMap<K, Collection<V>>)super.u();
  }
  
  Collection<V> e(@NullableDecl K paramK) {
    if (paramK == null)
      y().compare(paramK, paramK); 
    return super.e(paramK);
  }
  
  public NavigableSet<V> j(@NullableDecl K paramK) {
    return (NavigableSet<V>)super.h(paramK);
  }
  
  Map<K, Collection<V>> p() {
    return q();
  }
  
  SortedSet<V> w() {
    return new TreeSet<V>(this.b);
  }
  
  @Deprecated
  public Comparator<? super K> y() {
    return this.a;
  }
  
  public NavigableSet<K> z() {
    return (NavigableSet<K>)super.v();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\TreeMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */