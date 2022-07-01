package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class ForwardingMap<K, V> extends ForwardingObject implements Map<K, V> {
  protected abstract Map<K, V> a();
  
  public void clear() {
    a().clear();
  }
  
  public boolean containsKey(@NullableDecl Object paramObject) {
    return a().containsKey(paramObject);
  }
  
  public boolean containsValue(@NullableDecl Object paramObject) {
    return a().containsValue(paramObject);
  }
  
  public Set<Map.Entry<K, V>> entrySet() {
    return a().entrySet();
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    return (paramObject == this || a().equals(paramObject));
  }
  
  protected String f() {
    return Maps.a(this);
  }
  
  public V get(@NullableDecl Object paramObject) {
    return a().get(paramObject);
  }
  
  public int hashCode() {
    return a().hashCode();
  }
  
  public boolean isEmpty() {
    return a().isEmpty();
  }
  
  public Set<K> keySet() {
    return a().keySet();
  }
  
  public V put(K paramK, V paramV) {
    return a().put(paramK, paramV);
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap) {
    a().putAll(paramMap);
  }
  
  public V remove(Object paramObject) {
    return a().remove(paramObject);
  }
  
  public int size() {
    return a().size();
  }
  
  public Collection<V> values() {
    return a().values();
  }
  
  public abstract class StandardEntrySet extends Maps.EntrySet<K, V> {}
  
  public class StandardKeySet extends Maps.KeySet<K, V> {}
  
  public class StandardValues extends Maps.Values<K, V> {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ForwardingMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */