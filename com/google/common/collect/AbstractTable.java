package com.google.common.collect;

import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class AbstractTable<R, C, V> implements Table<R, C, V> {
  @LazyInit
  @NullableDecl
  private transient Set<Table.Cell<R, C, V>> a;
  
  @LazyInit
  @NullableDecl
  private transient Collection<V> b;
  
  public V a(R paramR, C paramC, V paramV) {
    return e(paramR).put(paramC, paramV);
  }
  
  public Set<R> a() {
    return o().keySet();
  }
  
  public boolean a(@NullableDecl Object paramObject) {
    return Maps.b(o(), paramObject);
  }
  
  public boolean a(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2) {
    paramObject1 = Maps.<Map>a((Map)o(), paramObject1);
    return (paramObject1 != null && Maps.b((Map<?, ?>)paramObject1, paramObject2));
  }
  
  public V b(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2) {
    paramObject1 = Maps.<Map>a((Map)o(), paramObject1);
    return (paramObject1 == null) ? null : Maps.a((Map<?, V>)paramObject1, paramObject2);
  }
  
  public Set<C> b() {
    return m().keySet();
  }
  
  public boolean b(@NullableDecl Object paramObject) {
    return Maps.b(m(), paramObject);
  }
  
  public V c(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2) {
    paramObject1 = Maps.<Map>a((Map)o(), paramObject1);
    return (paramObject1 == null) ? null : Maps.c((Map<?, V>)paramObject1, paramObject2);
  }
  
  public boolean c() {
    return (k() == 0);
  }
  
  public boolean c(@NullableDecl Object paramObject) {
    Iterator<Map> iterator = o().values().iterator();
    while (iterator.hasNext()) {
      if (((Map)iterator.next()).containsValue(paramObject))
        return true; 
    } 
    return false;
  }
  
  public void d() {
    Iterators.h(e().iterator());
  }
  
  public Set<Table.Cell<R, C, V>> e() {
    Set<Table.Cell<R, C, V>> set2 = this.a;
    Set<Table.Cell<R, C, V>> set1 = set2;
    if (set2 == null) {
      set1 = f();
      this.a = set1;
    } 
    return set1;
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    return Tables.a(this, paramObject);
  }
  
  Set<Table.Cell<R, C, V>> f() {
    return new CellSet(this);
  }
  
  abstract Iterator<Table.Cell<R, C, V>> g();
  
  public Collection<V> h() {
    Collection<V> collection2 = this.b;
    Collection<V> collection1 = collection2;
    if (collection2 == null) {
      collection1 = i();
      this.b = collection1;
    } 
    return collection1;
  }
  
  public int hashCode() {
    return e().hashCode();
  }
  
  Collection<V> i() {
    return new Values(this);
  }
  
  Iterator<V> j() {
    return new TransformedIterator<Table.Cell<R, C, V>, V>(this, e().iterator()) {
        V a(Table.Cell<R, C, V> param1Cell) {
          return param1Cell.c();
        }
      };
  }
  
  public String toString() {
    return o().toString();
  }
  
  class CellSet extends AbstractSet<Table.Cell<R, C, V>> {
    CellSet(AbstractTable this$0) {}
    
    public void clear() {
      this.a.d();
    }
    
    public boolean contains(Object param1Object) {
      boolean bool = param1Object instanceof Table.Cell;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool) {
        param1Object = param1Object;
        Map map = Maps.<Map>a(this.a.o(), param1Object.a());
        bool1 = bool2;
        if (map != null) {
          bool1 = bool2;
          if (Collections2.a(map.entrySet(), Maps.a(param1Object.b(), param1Object.c())))
            bool1 = true; 
        } 
      } 
      return bool1;
    }
    
    public Iterator<Table.Cell<R, C, V>> iterator() {
      return this.a.g();
    }
    
    public boolean remove(@NullableDecl Object param1Object) {
      boolean bool = param1Object instanceof Table.Cell;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool) {
        param1Object = param1Object;
        Map map = Maps.<Map>a(this.a.o(), param1Object.a());
        bool1 = bool2;
        if (map != null) {
          bool1 = bool2;
          if (Collections2.b(map.entrySet(), Maps.a(param1Object.b(), param1Object.c())))
            bool1 = true; 
        } 
      } 
      return bool1;
    }
    
    public int size() {
      return this.a.k();
    }
  }
  
  class Values extends AbstractCollection<V> {
    Values(AbstractTable this$0) {}
    
    public void clear() {
      this.a.d();
    }
    
    public boolean contains(Object param1Object) {
      return this.a.c(param1Object);
    }
    
    public Iterator<V> iterator() {
      return this.a.j();
    }
    
    public int size() {
      return this.a.k();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\AbstractTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */