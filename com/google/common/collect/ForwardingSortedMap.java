package com.google.common.collect;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;

public abstract class ForwardingSortedMap<K, V> extends ForwardingMap<K, V> implements SortedMap<K, V> {
  protected abstract SortedMap<K, V> c();
  
  public Comparator<? super K> comparator() {
    return c().comparator();
  }
  
  public K firstKey() {
    return c().firstKey();
  }
  
  public SortedMap<K, V> headMap(K paramK) {
    return c().headMap(paramK);
  }
  
  public K lastKey() {
    return c().lastKey();
  }
  
  public SortedMap<K, V> subMap(K paramK1, K paramK2) {
    return c().subMap(paramK1, paramK2);
  }
  
  public SortedMap<K, V> tailMap(K paramK) {
    return c().tailMap(paramK);
  }
  
  public class StandardKeySet extends Maps.SortedKeySet<K, V> {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ForwardingSortedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */