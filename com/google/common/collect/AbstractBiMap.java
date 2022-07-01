package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class AbstractBiMap<K, V> extends ForwardingMap<K, V> implements BiMap<K, V>, Serializable {
  @NullableDecl
  transient AbstractBiMap<V, K> a;
  
  @NullableDecl
  private transient Map<K, V> b;
  
  @NullableDecl
  private transient Set<K> c;
  
  @NullableDecl
  private transient Set<V> d;
  
  @NullableDecl
  private transient Set<Map.Entry<K, V>> e;
  
  private V a(@NullableDecl K paramK, @NullableDecl V paramV, boolean paramBoolean) {
    a(paramK);
    b(paramV);
    boolean bool = containsKey(paramK);
    if (bool && Objects.a(paramV, get(paramK)))
      return paramV; 
    if (paramBoolean) {
      ay_().remove(paramV);
    } else {
      Preconditions.a(containsValue(paramV) ^ true, "value already present: %s", paramV);
    } 
    V v = this.b.put(paramK, paramV);
    a(paramK, bool, v, paramV);
    return v;
  }
  
  private void a(K paramK, boolean paramBoolean, V paramV1, V paramV2) {
    if (paramBoolean)
      d(paramV1); 
    this.a.b.put((K)paramV2, (V)paramK);
  }
  
  private V c(Object paramObject) {
    paramObject = this.b.remove(paramObject);
    d((V)paramObject);
    return (V)paramObject;
  }
  
  private void d(V paramV) {
    this.a.b.remove(paramV);
  }
  
  K a(@NullableDecl K paramK) {
    return paramK;
  }
  
  protected Map<K, V> a() {
    return this.b;
  }
  
  public BiMap<V, K> ay_() {
    return this.a;
  }
  
  V b(@NullableDecl V paramV) {
    return paramV;
  }
  
  public void clear() {
    this.b.clear();
    this.a.b.clear();
  }
  
  public boolean containsValue(@NullableDecl Object paramObject) {
    return this.a.containsKey(paramObject);
  }
  
  public Set<V> d() {
    Set<V> set2 = this.d;
    Set<V> set1 = set2;
    if (set2 == null) {
      set1 = new ValueSet();
      this.d = set1;
    } 
    return set1;
  }
  
  Iterator<Map.Entry<K, V>> e() {
    return new Iterator<Map.Entry<K, V>>(this, this.b.entrySet().iterator()) {
        @NullableDecl
        Map.Entry<K, V> a;
        
        public Map.Entry<K, V> a() {
          this.a = this.b.next();
          return new AbstractBiMap.BiMapEntry(this.c, this.a);
        }
        
        public boolean hasNext() {
          return this.b.hasNext();
        }
        
        public void remove() {
          boolean bool;
          if (this.a != null) {
            bool = true;
          } else {
            bool = false;
          } 
          CollectPreconditions.a(bool);
          V v = this.a.getValue();
          this.b.remove();
          AbstractBiMap.b(this.c, v);
          this.a = null;
        }
      };
  }
  
  public Set<Map.Entry<K, V>> entrySet() {
    Set<Map.Entry<K, V>> set2 = this.e;
    Set<Map.Entry<K, V>> set1 = set2;
    if (set2 == null) {
      set1 = new EntrySet();
      this.e = set1;
    } 
    return set1;
  }
  
  public Set<K> keySet() {
    Set<K> set2 = this.c;
    Set<K> set1 = set2;
    if (set2 == null) {
      set1 = new KeySet();
      this.c = set1;
    } 
    return set1;
  }
  
  public V put(@NullableDecl K paramK, @NullableDecl V paramV) {
    return a(paramK, paramV, false);
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap) {
    for (Map.Entry<? extends K, ? extends V> entry : paramMap.entrySet())
      put((K)entry.getKey(), (V)entry.getValue()); 
  }
  
  public V remove(@NullableDecl Object paramObject) {
    return containsKey(paramObject) ? c(paramObject) : null;
  }
  
  class BiMapEntry extends ForwardingMapEntry<K, V> {
    private final Map.Entry<K, V> b;
    
    BiMapEntry(AbstractBiMap this$0, Map.Entry<K, V> param1Entry) {
      this.b = param1Entry;
    }
    
    protected Map.Entry<K, V> a() {
      return this.b;
    }
    
    public V setValue(V param1V) {
      this.a.b(param1V);
      Preconditions.b(this.a.entrySet().contains(this), "entry no longer in map");
      if (Objects.a(param1V, getValue()))
        return param1V; 
      Preconditions.a(this.a.containsValue(param1V) ^ true, "value already present: %s", param1V);
      V v = this.b.setValue(param1V);
      Preconditions.b(Objects.a(param1V, this.a.get(getKey())), "entry no longer in map");
      AbstractBiMap.a(this.a, getKey(), true, v, param1V);
      return v;
    }
  }
  
  class EntrySet extends ForwardingSet<Map.Entry<K, V>> {
    final Set<Map.Entry<K, V>> a = AbstractBiMap.a(this.b).entrySet();
    
    private EntrySet(AbstractBiMap this$0) {}
    
    protected Set<Map.Entry<K, V>> a() {
      return this.a;
    }
    
    public void clear() {
      this.b.clear();
    }
    
    public boolean contains(Object param1Object) {
      return Maps.a(a(), param1Object);
    }
    
    public boolean containsAll(Collection<?> param1Collection) {
      return a(param1Collection);
    }
    
    public Iterator<Map.Entry<K, V>> iterator() {
      return this.b.e();
    }
    
    public boolean remove(Object param1Object) {
      if (!this.a.contains(param1Object))
        return false; 
      param1Object = param1Object;
      AbstractBiMap.a(this.b.a).remove(param1Object.getValue());
      this.a.remove(param1Object);
      return true;
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      return c(param1Collection);
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return d(param1Collection);
    }
    
    public Object[] toArray() {
      return o();
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      return (T[])a((Object[])param1ArrayOfT);
    }
  }
  
  static class Inverse<K, V> extends AbstractBiMap<K, V> {
    K a(K param1K) {
      return this.a.b(param1K);
    }
    
    V b(V param1V) {
      return this.a.a(param1V);
    }
  }
  
  class KeySet extends ForwardingSet<K> {
    private KeySet(AbstractBiMap this$0) {}
    
    protected Set<K> a() {
      return AbstractBiMap.a(this.a).keySet();
    }
    
    public void clear() {
      this.a.clear();
    }
    
    public Iterator<K> iterator() {
      return Maps.a(this.a.entrySet().iterator());
    }
    
    public boolean remove(Object param1Object) {
      if (!contains(param1Object))
        return false; 
      AbstractBiMap.a(this.a, param1Object);
      return true;
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      return c(param1Collection);
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return d(param1Collection);
    }
  }
  
  class ValueSet extends ForwardingSet<V> {
    final Set<V> a = this.b.a.keySet();
    
    private ValueSet(AbstractBiMap this$0) {}
    
    protected Set<V> a() {
      return this.a;
    }
    
    public Iterator<V> iterator() {
      return Maps.b(this.b.entrySet().iterator());
    }
    
    public Object[] toArray() {
      return o();
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      return (T[])a((Object[])param1ArrayOfT);
    }
    
    public String toString() {
      return n();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\AbstractBiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */