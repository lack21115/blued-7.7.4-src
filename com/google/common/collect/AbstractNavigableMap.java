package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class AbstractNavigableMap<K, V> extends Maps.IteratorBasedAbstractMap<K, V> implements NavigableMap<K, V> {
  abstract Iterator<Map.Entry<K, V>> a();
  
  @NullableDecl
  public Map.Entry<K, V> ceilingEntry(K paramK) {
    return tailMap(paramK, true).firstEntry();
  }
  
  public K ceilingKey(K paramK) {
    return Maps.b(ceilingEntry(paramK));
  }
  
  public NavigableSet<K> descendingKeySet() {
    return descendingMap().navigableKeySet();
  }
  
  public NavigableMap<K, V> descendingMap() {
    return new DescendingMap();
  }
  
  @NullableDecl
  public Map.Entry<K, V> firstEntry() {
    return Iterators.<Map.Entry<K, V>>b(b(), (Map.Entry<K, V>)null);
  }
  
  public K firstKey() {
    Map.Entry<K, V> entry = firstEntry();
    if (entry != null)
      return entry.getKey(); 
    throw new NoSuchElementException();
  }
  
  @NullableDecl
  public Map.Entry<K, V> floorEntry(K paramK) {
    return headMap(paramK, true).lastEntry();
  }
  
  public K floorKey(K paramK) {
    return Maps.b(floorEntry(paramK));
  }
  
  public SortedMap<K, V> headMap(K paramK) {
    return headMap(paramK, false);
  }
  
  @NullableDecl
  public Map.Entry<K, V> higherEntry(K paramK) {
    return tailMap(paramK, false).firstEntry();
  }
  
  public K higherKey(K paramK) {
    return Maps.b(higherEntry(paramK));
  }
  
  public Set<K> keySet() {
    return navigableKeySet();
  }
  
  @NullableDecl
  public Map.Entry<K, V> lastEntry() {
    return Iterators.<Map.Entry<K, V>>b(a(), (Map.Entry<K, V>)null);
  }
  
  public K lastKey() {
    Map.Entry<K, V> entry = lastEntry();
    if (entry != null)
      return entry.getKey(); 
    throw new NoSuchElementException();
  }
  
  @NullableDecl
  public Map.Entry<K, V> lowerEntry(K paramK) {
    return headMap(paramK, false).lastEntry();
  }
  
  public K lowerKey(K paramK) {
    return Maps.b(lowerEntry(paramK));
  }
  
  public NavigableSet<K> navigableKeySet() {
    return new Maps.NavigableKeySet<K, Object>(this);
  }
  
  @NullableDecl
  public Map.Entry<K, V> pollFirstEntry() {
    return Iterators.<Map.Entry<K, V>>g(b());
  }
  
  @NullableDecl
  public Map.Entry<K, V> pollLastEntry() {
    return Iterators.<Map.Entry<K, V>>g(a());
  }
  
  public SortedMap<K, V> subMap(K paramK1, K paramK2) {
    return subMap(paramK1, true, paramK2, false);
  }
  
  public SortedMap<K, V> tailMap(K paramK) {
    return tailMap(paramK, true);
  }
  
  final class DescendingMap extends Maps.DescendingMap<K, V> {
    private DescendingMap(AbstractNavigableMap this$0) {}
    
    NavigableMap<K, V> c() {
      return this.a;
    }
    
    Iterator<Map.Entry<K, V>> d() {
      return this.a.a();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\AbstractNavigableMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */