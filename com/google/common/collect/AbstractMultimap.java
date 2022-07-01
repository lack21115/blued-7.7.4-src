package com.google.common.collect;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class AbstractMultimap<K, V> implements Multimap<K, V> {
  @NullableDecl
  private transient Collection<Map.Entry<K, V>> a;
  
  @NullableDecl
  private transient Set<K> b;
  
  @NullableDecl
  private transient Collection<V> c;
  
  @NullableDecl
  private transient Map<K, Collection<V>> d;
  
  public boolean a(@NullableDecl K paramK, @NullableDecl V paramV) {
    return c(paramK).add(paramV);
  }
  
  public boolean b(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2) {
    paramObject1 = c().get(paramObject1);
    return (paramObject1 != null && paramObject1.contains(paramObject2));
  }
  
  public Map<K, Collection<V>> c() {
    Map<K, Collection<V>> map2 = this.d;
    Map<K, Collection<V>> map1 = map2;
    if (map2 == null) {
      map1 = p();
      this.d = map1;
    } 
    return map1;
  }
  
  public boolean c(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2) {
    paramObject1 = c().get(paramObject1);
    return (paramObject1 != null && paramObject1.remove(paramObject2));
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    return Multimaps.a(this, paramObject);
  }
  
  public boolean g(@NullableDecl Object paramObject) {
    Iterator<Collection> iterator = c().values().iterator();
    while (iterator.hasNext()) {
      if (((Collection)iterator.next()).contains(paramObject))
        return true; 
    } 
    return false;
  }
  
  abstract Set<K> h();
  
  public int hashCode() {
    return c().hashCode();
  }
  
  public Collection<V> j() {
    Collection<V> collection2 = this.c;
    Collection<V> collection1 = collection2;
    if (collection2 == null) {
      collection1 = k();
      this.c = collection1;
    } 
    return collection1;
  }
  
  abstract Collection<V> k();
  
  Iterator<V> l() {
    return Maps.b(m().iterator());
  }
  
  public Collection<Map.Entry<K, V>> m() {
    Collection<Map.Entry<K, V>> collection2 = this.a;
    Collection<Map.Entry<K, V>> collection1 = collection2;
    if (collection2 == null) {
      collection1 = n();
      this.a = collection1;
    } 
    return collection1;
  }
  
  abstract Collection<Map.Entry<K, V>> n();
  
  abstract Iterator<Map.Entry<K, V>> o();
  
  abstract Map<K, Collection<V>> p();
  
  public boolean r() {
    return (f() == 0);
  }
  
  public Set<K> s() {
    Set<K> set2 = this.b;
    Set<K> set1 = set2;
    if (set2 == null) {
      set1 = h();
      this.b = set1;
    } 
    return set1;
  }
  
  public String toString() {
    return c().toString();
  }
  
  class Entries extends Multimaps.Entries<K, V> {
    Entries(AbstractMultimap this$0) {}
    
    Multimap<K, V> a() {
      return this.a;
    }
    
    public Iterator<Map.Entry<K, V>> iterator() {
      return this.a.o();
    }
  }
  
  class EntrySet extends Entries implements Set<Map.Entry<K, V>> {
    EntrySet(AbstractMultimap this$0) {
      super(this$0);
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      return Sets.a(this, param1Object);
    }
    
    public int hashCode() {
      return Sets.a(this);
    }
  }
  
  class Values extends AbstractCollection<V> {
    Values(AbstractMultimap this$0) {}
    
    public void clear() {
      this.a.g();
    }
    
    public boolean contains(@NullableDecl Object param1Object) {
      return this.a.g(param1Object);
    }
    
    public Iterator<V> iterator() {
      return this.a.l();
    }
    
    public int size() {
      return this.a.f();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\AbstractMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */