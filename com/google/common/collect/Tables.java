package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Tables {
  private static final Function<? extends Map<?, ?>, ? extends Map<?, ?>> a = new Function<Map<Object, Object>, Map<Object, Object>>() {
      public Map<Object, Object> a(Map<Object, Object> param1Map) {
        return Collections.unmodifiableMap(param1Map);
      }
    };
  
  public static <R, C, V> Table.Cell<R, C, V> a(@NullableDecl R paramR, @NullableDecl C paramC, @NullableDecl V paramV) {
    return new ImmutableCell<R, C, V>(paramR, paramC, paramV);
  }
  
  static boolean a(Table<?, ?, ?> paramTable, @NullableDecl Object paramObject) {
    if (paramObject == paramTable)
      return true; 
    if (paramObject instanceof Table) {
      paramObject = paramObject;
      return paramTable.e().equals(paramObject.e());
    } 
    return false;
  }
  
  private static <K, V> Function<Map<K, V>, Map<K, V>> b() {
    return (Function)a;
  }
  
  static abstract class AbstractCell<R, C, V> implements Table.Cell<R, C, V> {
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (param1Object instanceof Table.Cell) {
        param1Object = param1Object;
        return (Objects.a(a(), param1Object.a()) && Objects.a(b(), param1Object.b()) && Objects.a(c(), param1Object.c()));
      } 
      return false;
    }
    
    public int hashCode() {
      return Objects.a(new Object[] { a(), b(), c() });
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("(");
      stringBuilder.append(a());
      stringBuilder.append(",");
      stringBuilder.append(b());
      stringBuilder.append(")=");
      stringBuilder.append(c());
      return stringBuilder.toString();
    }
  }
  
  static final class ImmutableCell<R, C, V> extends AbstractCell<R, C, V> implements Serializable {
    @NullableDecl
    private final R a;
    
    @NullableDecl
    private final C b;
    
    @NullableDecl
    private final V c;
    
    ImmutableCell(@NullableDecl R param1R, @NullableDecl C param1C, @NullableDecl V param1V) {
      this.a = param1R;
      this.b = param1C;
      this.c = param1V;
    }
    
    public R a() {
      return this.a;
    }
    
    public C b() {
      return this.b;
    }
    
    public V c() {
      return this.c;
    }
  }
  
  static class TransformedTable<R, C, V1, V2> extends AbstractTable<R, C, V2> {
    final Table<R, C, V1> a;
    
    final Function<? super V1, V2> b;
    
    public V2 a(R param1R, C param1C, V2 param1V2) {
      throw new UnsupportedOperationException();
    }
    
    public Set<R> a() {
      return this.a.a();
    }
    
    public boolean a(Object param1Object1, Object param1Object2) {
      return this.a.a(param1Object1, param1Object2);
    }
    
    public V2 b(Object param1Object1, Object param1Object2) {
      return (V2)(a(param1Object1, param1Object2) ? this.b.f(this.a.b(param1Object1, param1Object2)) : null);
    }
    
    public Set<C> b() {
      return this.a.b();
    }
    
    public V2 c(Object param1Object1, Object param1Object2) {
      return (V2)(a(param1Object1, param1Object2) ? this.b.f(this.a.c(param1Object1, param1Object2)) : null);
    }
    
    public Map<R, V2> d(C param1C) {
      return Maps.a(this.a.d(param1C), this.b);
    }
    
    public void d() {
      this.a.d();
    }
    
    public Map<C, V2> e(R param1R) {
      return Maps.a(this.a.e(param1R), this.b);
    }
    
    Iterator<Table.Cell<R, C, V2>> g() {
      return Iterators.a(this.a.e().iterator(), l());
    }
    
    Collection<V2> i() {
      return Collections2.a(this.a.h(), this.b);
    }
    
    public int k() {
      return this.a.k();
    }
    
    Function<Table.Cell<R, C, V1>, Table.Cell<R, C, V2>> l() {
      return new Function<Table.Cell<R, C, V1>, Table.Cell<R, C, V2>>(this) {
          public Table.Cell<R, C, V2> a(Table.Cell<R, C, V1> param2Cell) {
            return Tables.a(param2Cell.a(), param2Cell.b(), (V2)this.a.b.f(param2Cell.c()));
          }
        };
    }
    
    public Map<C, Map<R, V2>> m() {
      Function<Map<R, V1>, Map<R, V2>> function = new Function<Map<R, V1>, Map<R, V2>>(this) {
          public Map<R, V2> a(Map<R, V1> param2Map) {
            return Maps.a(param2Map, this.a.b);
          }
        };
      return Maps.a(this.a.m(), function);
    }
    
    public Map<R, Map<C, V2>> o() {
      Function<Map<C, V1>, Map<C, V2>> function = new Function<Map<C, V1>, Map<C, V2>>(this) {
          public Map<C, V2> a(Map<C, V1> param2Map) {
            return Maps.a(param2Map, this.a.b);
          }
        };
      return Maps.a(this.a.o(), function);
    }
  }
  
  class null implements Function<Table.Cell<R, C, V1>, Table.Cell<R, C, V2>> {
    null(Tables this$0) {}
    
    public Table.Cell<R, C, V2> a(Table.Cell<R, C, V1> param1Cell) {
      return Tables.a(param1Cell.a(), param1Cell.b(), (V2)this.a.b.f(param1Cell.c()));
    }
  }
  
  class null implements Function<Map<C, V1>, Map<C, V2>> {
    null(Tables this$0) {}
    
    public Map<C, V2> a(Map<C, V1> param1Map) {
      return Maps.a(param1Map, this.a.b);
    }
  }
  
  class null implements Function<Map<R, V1>, Map<R, V2>> {
    null(Tables this$0) {}
    
    public Map<R, V2> a(Map<R, V1> param1Map) {
      return Maps.a(param1Map, this.a.b);
    }
  }
  
  static class TransposeTable<C, R, V> extends AbstractTable<C, R, V> {
    private static final Function<Table.Cell<?, ?, ?>, Table.Cell<?, ?, ?>> b = new Function<Table.Cell<?, ?, ?>, Table.Cell<?, ?, ?>>() {
        public Table.Cell<?, ?, ?> a(Table.Cell<?, ?, ?> param2Cell) {
          return Tables.a(param2Cell.b(), param2Cell.a(), param2Cell.c());
        }
      };
    
    final Table<R, C, V> a;
    
    public V a(C param1C, R param1R, V param1V) {
      return this.a.a(param1R, param1C, param1V);
    }
    
    public Set<C> a() {
      return this.a.b();
    }
    
    public boolean a(@NullableDecl Object param1Object) {
      return this.a.b(param1Object);
    }
    
    public boolean a(@NullableDecl Object param1Object1, @NullableDecl Object param1Object2) {
      return this.a.a(param1Object2, param1Object1);
    }
    
    public V b(@NullableDecl Object param1Object1, @NullableDecl Object param1Object2) {
      return this.a.b(param1Object2, param1Object1);
    }
    
    public Set<R> b() {
      return this.a.a();
    }
    
    public boolean b(@NullableDecl Object param1Object) {
      return this.a.a(param1Object);
    }
    
    public V c(@NullableDecl Object param1Object1, @NullableDecl Object param1Object2) {
      return this.a.c(param1Object2, param1Object1);
    }
    
    public boolean c(@NullableDecl Object param1Object) {
      return this.a.c(param1Object);
    }
    
    public Map<C, V> d(R param1R) {
      return this.a.e(param1R);
    }
    
    public void d() {
      this.a.d();
    }
    
    public Map<R, V> e(C param1C) {
      return this.a.d(param1C);
    }
    
    Iterator<Table.Cell<C, R, V>> g() {
      return (Iterator)Iterators.a(this.a.e().iterator(), b);
    }
    
    public Collection<V> h() {
      return this.a.h();
    }
    
    public int k() {
      return this.a.k();
    }
    
    public Map<R, Map<C, V>> m() {
      return this.a.o();
    }
    
    public Map<C, Map<R, V>> o() {
      return this.a.m();
    }
  }
  
  static final class null implements Function<Table.Cell<?, ?, ?>, Table.Cell<?, ?, ?>> {
    public Table.Cell<?, ?, ?> a(Table.Cell<?, ?, ?> param1Cell) {
      return Tables.a(param1Cell.b(), param1Cell.a(), param1Cell.c());
    }
  }
  
  static final class UnmodifiableRowSortedMap<R, C, V> extends UnmodifiableTable<R, C, V> implements RowSortedTable<R, C, V> {
    public SortedMap<R, Map<C, V>> aA_() {
      Function<?, ? extends Map<C, V>> function = Tables.a();
      return Collections.unmodifiableSortedMap(Maps.a(i().aA_(), function));
    }
    
    public SortedSet<R> az_() {
      return Collections.unmodifiableSortedSet(i().az_());
    }
    
    protected RowSortedTable<R, C, V> i() {
      return (RowSortedTable<R, C, V>)super.c();
    }
  }
  
  static class UnmodifiableTable<R, C, V> extends ForwardingTable<R, C, V> implements Serializable {
    final Table<? extends R, ? extends C, ? extends V> a;
    
    public V a(@NullableDecl R param1R, @NullableDecl C param1C, @NullableDecl V param1V) {
      throw new UnsupportedOperationException();
    }
    
    public Set<R> a() {
      return Collections.unmodifiableSet(super.a());
    }
    
    public Set<C> b() {
      return Collections.unmodifiableSet(super.b());
    }
    
    protected Table<R, C, V> c() {
      return (Table)this.a;
    }
    
    public V c(@NullableDecl Object param1Object1, @NullableDecl Object param1Object2) {
      throw new UnsupportedOperationException();
    }
    
    public Map<R, V> d(@NullableDecl C param1C) {
      return Collections.unmodifiableMap(super.d(param1C));
    }
    
    public void d() {
      throw new UnsupportedOperationException();
    }
    
    public Map<C, V> e(@NullableDecl R param1R) {
      return Collections.unmodifiableMap(super.e(param1R));
    }
    
    public Set<Table.Cell<R, C, V>> e() {
      return Collections.unmodifiableSet(super.e());
    }
    
    public Collection<V> h() {
      return Collections.unmodifiableCollection(super.h());
    }
    
    public Map<C, Map<R, V>> m() {
      Function<?, ? extends Map<R, V>> function = Tables.a();
      return Collections.unmodifiableMap(Maps.a(super.m(), function));
    }
    
    public Map<R, Map<C, V>> o() {
      Function<?, ? extends Map<C, V>> function = Tables.a();
      return Collections.unmodifiableMap(Maps.a(super.o(), function));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\Tables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */