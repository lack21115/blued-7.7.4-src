package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class TreeBasedTable<R, C, V> extends StandardRowSortedTable<R, C, V> {
  private final Comparator<? super C> c;
  
  public SortedMap<R, Map<C, V>> aA_() {
    return super.aA_();
  }
  
  public SortedSet<R> az_() {
    return super.az_();
  }
  
  public SortedMap<C, V> f(R paramR) {
    return new TreeRow(paramR);
  }
  
  Iterator<C> p() {
    Comparator<? super C> comparator = q();
    return new AbstractIterator<C>(this, Iterators.a(Iterables.a(this.a.values(), new Function<Map<C, V>, Iterator<C>>(this) {
              public Iterator<C> a(Map<C, V> param1Map) {
                return param1Map.keySet().iterator();
              }
            }), comparator), comparator) {
        @NullableDecl
        C a;
        
        protected C a() {
          while (this.b.hasNext()) {
            boolean bool;
            C c1 = (C)this.b.next();
            C c2 = this.a;
            if (c2 != null && this.c.compare(c1, c2) == 0) {
              bool = true;
            } else {
              bool = false;
            } 
            if (!bool) {
              this.a = c1;
              return this.a;
            } 
          } 
          this.a = null;
          return b();
        }
      };
  }
  
  @Deprecated
  public Comparator<? super C> q() {
    return this.c;
  }
  
  static class Factory<C, V> implements Supplier<TreeMap<C, V>>, Serializable {
    final Comparator<? super C> a;
    
    public TreeMap<C, V> a() {
      return new TreeMap<C, V>(this.a);
    }
  }
  
  class TreeRow extends StandardTable<R, C, V>.Row implements SortedMap<C, V> {
    @NullableDecl
    final C d;
    
    @NullableDecl
    final C e;
    
    @NullableDecl
    transient SortedMap<C, V> f;
    
    TreeRow(R param1R) {
      this(param1R, null, null);
    }
    
    TreeRow(@NullableDecl R param1R, @NullableDecl C param1C1, C param1C2) {
      super(param1R);
      boolean bool;
      this.d = param1C1;
      this.e = param1C2;
      if (param1C1 == null || param1C2 == null || a(param1C1, param1C2) <= 0) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.a(bool);
    }
    
    int a(Object param1Object1, Object param1Object2) {
      return comparator().compare((C)param1Object1, (C)param1Object2);
    }
    
    boolean a(@NullableDecl Object param1Object) {
      if (param1Object != null) {
        C c = this.d;
        if (c == null || a(c, param1Object) <= 0) {
          c = this.e;
          if (c == null || a(c, param1Object) > 0)
            return true; 
        } 
      } 
      return false;
    }
    
    public Comparator<? super C> comparator() {
      return this.g.q();
    }
    
    public boolean containsKey(Object param1Object) {
      return (a(param1Object) && super.containsKey(param1Object));
    }
    
    void d() {
      if (f() != null && this.f.isEmpty()) {
        this.g.a.remove(this.a);
        this.f = null;
        this.b = null;
      } 
    }
    
    public SortedSet<C> e() {
      return new Maps.SortedKeySet<C, Object>(this);
    }
    
    SortedMap<C, V> f() {
      SortedMap<C, V> sortedMap = this.f;
      if (sortedMap == null || (sortedMap.isEmpty() && this.g.a.containsKey(this.a)))
        this.f = (SortedMap<C, V>)this.g.a.get(this.a); 
      return this.f;
    }
    
    public C firstKey() {
      if (g() != null)
        return g().firstKey(); 
      throw new NoSuchElementException();
    }
    
    SortedMap<C, V> g() {
      return (SortedMap<C, V>)super.a();
    }
    
    SortedMap<C, V> h() {
      SortedMap<C, V> sortedMap = f();
      if (sortedMap != null) {
        C c = this.d;
        SortedMap<C, V> sortedMap1 = sortedMap;
        if (c != null)
          sortedMap1 = sortedMap.tailMap(c); 
        c = this.e;
        sortedMap = sortedMap1;
        if (c != null)
          sortedMap = sortedMap1.headMap(c); 
        return sortedMap;
      } 
      return null;
    }
    
    public SortedMap<C, V> headMap(C param1C) {
      Preconditions.a(a(Preconditions.a(param1C)));
      return new TreeRow(this.a, this.d, param1C);
    }
    
    public C lastKey() {
      if (g() != null)
        return g().lastKey(); 
      throw new NoSuchElementException();
    }
    
    public V put(C param1C, V param1V) {
      Preconditions.a(a(Preconditions.a(param1C)));
      return super.put(param1C, param1V);
    }
    
    public SortedMap<C, V> subMap(C param1C1, C param1C2) {
      boolean bool;
      if (a(Preconditions.a(param1C1)) && a(Preconditions.a(param1C2))) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.a(bool);
      return new TreeRow(this.a, param1C1, param1C2);
    }
    
    public SortedMap<C, V> tailMap(C param1C) {
      Preconditions.a(a(Preconditions.a(param1C)));
      return new TreeRow(this.a, param1C, this.e);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\TreeBasedTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */