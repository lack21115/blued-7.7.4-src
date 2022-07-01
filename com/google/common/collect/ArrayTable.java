package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class ArrayTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable {
  private final ImmutableList<R> a;
  
  private final ImmutableList<C> b;
  
  private final ImmutableMap<R, Integer> c;
  
  private final ImmutableMap<C, Integer> d;
  
  private final V[][] e;
  
  @NullableDecl
  private transient ColumnMap f;
  
  @NullableDecl
  private transient RowMap g;
  
  private Table.Cell<R, C, V> a(int paramInt) {
    return new Tables.AbstractCell<R, C, V>(this, paramInt) {
        final int a = this.c / ArrayTable.a(this.d).size();
        
        final int b = this.c % ArrayTable.a(this.d).size();
        
        public R a() {
          return ArrayTable.b(this.d).get(this.a);
        }
        
        public C b() {
          return ArrayTable.a(this.d).get(this.b);
        }
        
        public V c() {
          return (V)this.d.a(this.a, this.b);
        }
      };
  }
  
  private V b(int paramInt) {
    return a(paramInt / this.b.size(), paramInt % this.b.size());
  }
  
  public V a(int paramInt1, int paramInt2) {
    Preconditions.a(paramInt1, this.a.size());
    Preconditions.a(paramInt2, this.b.size());
    return this.e[paramInt1][paramInt2];
  }
  
  public V a(int paramInt1, int paramInt2, @NullableDecl V paramV) {
    Preconditions.a(paramInt1, this.a.size());
    Preconditions.a(paramInt2, this.b.size());
    V[][] arrayOfV = this.e;
    V v = arrayOfV[paramInt1][paramInt2];
    arrayOfV[paramInt1][paramInt2] = paramV;
    return v;
  }
  
  public V a(R paramR, C paramC, @NullableDecl V paramV) {
    boolean bool1;
    Preconditions.a(paramR);
    Preconditions.a(paramC);
    Integer integer2 = this.c.get(paramR);
    boolean bool2 = true;
    if (integer2 != null) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    Preconditions.a(bool1, "Row %s not in %s", paramR, this.a);
    Integer integer1 = this.d.get(paramC);
    if (integer1 != null) {
      bool1 = bool2;
    } else {
      bool1 = false;
    } 
    Preconditions.a(bool1, "Column %s not in %s", paramC, this.b);
    return a(integer2.intValue(), integer1.intValue(), paramV);
  }
  
  public boolean a(@NullableDecl Object paramObject) {
    return this.c.containsKey(paramObject);
  }
  
  public boolean a(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2) {
    return (a(paramObject1) && b(paramObject2));
  }
  
  public V b(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2) {
    paramObject1 = this.c.get(paramObject1);
    paramObject2 = this.d.get(paramObject2);
    return (paramObject1 == null || paramObject2 == null) ? null : a(paramObject1.intValue(), paramObject2.intValue());
  }
  
  public boolean b(@NullableDecl Object paramObject) {
    return this.d.containsKey(paramObject);
  }
  
  @Deprecated
  public V c(Object paramObject1, Object paramObject2) {
    throw new UnsupportedOperationException();
  }
  
  public boolean c() {
    return (this.a.isEmpty() || this.b.isEmpty());
  }
  
  public boolean c(@NullableDecl Object paramObject) {
    for (V[] arrayOfV : this.e) {
      int j = arrayOfV.length;
      for (int i = 0; i < j; i++) {
        if (Objects.a(paramObject, arrayOfV[i]))
          return true; 
      } 
    } 
    return false;
  }
  
  public Map<R, V> d(C paramC) {
    Preconditions.a(paramC);
    Integer integer = this.d.get(paramC);
    return (Map<R, V>)((integer == null) ? ImmutableMap.j() : new Column(this, integer.intValue()));
  }
  
  @Deprecated
  public void d() {
    throw new UnsupportedOperationException();
  }
  
  public Map<C, V> e(R paramR) {
    Preconditions.a(paramR);
    Integer integer = this.c.get(paramR);
    return (Map<C, V>)((integer == null) ? ImmutableMap.j() : new Row(this, integer.intValue()));
  }
  
  public Set<Table.Cell<R, C, V>> e() {
    return super.e();
  }
  
  Iterator<Table.Cell<R, C, V>> g() {
    return new AbstractIndexedListIterator<Table.Cell<R, C, V>>(this, k()) {
        protected Table.Cell<R, C, V> b(int param1Int) {
          return ArrayTable.a(this.a, param1Int);
        }
      };
  }
  
  public Collection<V> h() {
    return super.h();
  }
  
  Iterator<V> j() {
    return new AbstractIndexedListIterator<V>(this, k()) {
        protected V a(int param1Int) {
          return (V)ArrayTable.b(this.a, param1Int);
        }
      };
  }
  
  public int k() {
    return this.a.size() * this.b.size();
  }
  
  public ImmutableSet<C> l() {
    return this.d.n();
  }
  
  public Map<C, Map<R, V>> m() {
    ColumnMap columnMap2 = this.f;
    ColumnMap columnMap1 = columnMap2;
    if (columnMap2 == null) {
      columnMap1 = new ColumnMap();
      this.f = columnMap1;
    } 
    return columnMap1;
  }
  
  public ImmutableSet<R> n() {
    return this.c.n();
  }
  
  public Map<R, Map<C, V>> o() {
    RowMap rowMap2 = this.g;
    RowMap rowMap1 = rowMap2;
    if (rowMap2 == null) {
      rowMap1 = new RowMap();
      this.g = rowMap1;
    } 
    return rowMap1;
  }
  
  static abstract class ArrayMap<K, V> extends Maps.IteratorBasedAbstractMap<K, V> {
    private final ImmutableMap<K, Integer> a;
    
    private ArrayMap(ImmutableMap<K, Integer> param1ImmutableMap) {
      this.a = param1ImmutableMap;
    }
    
    K a(int param1Int) {
      return this.a.n().h().get(param1Int);
    }
    
    @NullableDecl
    abstract V a(int param1Int, V param1V);
    
    abstract String a();
    
    @NullableDecl
    abstract V b(int param1Int);
    
    Iterator<Map.Entry<K, V>> b() {
      return new AbstractIndexedListIterator<Map.Entry<K, V>>(this, size()) {
          protected Map.Entry<K, V> b(int param2Int) {
            return this.a.c(param2Int);
          }
        };
    }
    
    Map.Entry<K, V> c(int param1Int) {
      Preconditions.a(param1Int, size());
      return new AbstractMapEntry<K, V>(this, param1Int) {
          public K getKey() {
            return (K)this.b.a(this.a);
          }
          
          public V getValue() {
            return (V)this.b.b(this.a);
          }
          
          public V setValue(V param2V) {
            return (V)this.b.a(this.a, param2V);
          }
        };
    }
    
    public void clear() {
      throw new UnsupportedOperationException();
    }
    
    public boolean containsKey(@NullableDecl Object param1Object) {
      return this.a.containsKey(param1Object);
    }
    
    public V get(@NullableDecl Object param1Object) {
      param1Object = this.a.get(param1Object);
      return (param1Object == null) ? null : b(param1Object.intValue());
    }
    
    public boolean isEmpty() {
      return this.a.isEmpty();
    }
    
    public Set<K> keySet() {
      return this.a.n();
    }
    
    public V put(K param1K, V param1V) {
      Integer integer = this.a.get(param1K);
      if (integer != null)
        return a(integer.intValue(), param1V); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(a());
      stringBuilder.append(" ");
      stringBuilder.append(param1K);
      stringBuilder.append(" not in ");
      stringBuilder.append(this.a.n());
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public V remove(Object param1Object) {
      throw new UnsupportedOperationException();
    }
    
    public int size() {
      return this.a.size();
    }
  }
  
  class null extends AbstractMapEntry<K, V> {
    null(ArrayTable this$0, int param1Int) {}
    
    public K getKey() {
      return (K)this.b.a(this.a);
    }
    
    public V getValue() {
      return (V)this.b.b(this.a);
    }
    
    public V setValue(V param1V) {
      return (V)this.b.a(this.a, param1V);
    }
  }
  
  class null extends AbstractIndexedListIterator<Map.Entry<K, V>> {
    null(ArrayTable this$0, int param1Int) {
      super(param1Int);
    }
    
    protected Map.Entry<K, V> b(int param1Int) {
      return this.a.c(param1Int);
    }
  }
  
  class Column extends ArrayMap<R, V> {
    final int a;
    
    Column(ArrayTable this$0, int param1Int) {
      super(ArrayTable.c(this$0));
      this.a = param1Int;
    }
    
    V a(int param1Int, V param1V) {
      return (V)this.b.a(param1Int, this.a, param1V);
    }
    
    String a() {
      return "Row";
    }
    
    V b(int param1Int) {
      return (V)this.b.a(param1Int, this.a);
    }
  }
  
  class ColumnMap extends ArrayMap<C, Map<R, V>> {
    private ColumnMap(ArrayTable this$0) {
      super(ArrayTable.d(ArrayTable.this));
    }
    
    String a() {
      return "Column";
    }
    
    Map<R, V> a(int param1Int, Map<R, V> param1Map) {
      throw new UnsupportedOperationException();
    }
    
    public Map<R, V> a(C param1C, Map<R, V> param1Map) {
      throw new UnsupportedOperationException();
    }
    
    Map<R, V> d(int param1Int) {
      return new ArrayTable.Column(this.a, param1Int);
    }
  }
  
  class Row extends ArrayMap<C, V> {
    final int a;
    
    Row(ArrayTable this$0, int param1Int) {
      super(ArrayTable.d(this$0));
      this.a = param1Int;
    }
    
    V a(int param1Int, V param1V) {
      return (V)this.b.a(this.a, param1Int, param1V);
    }
    
    String a() {
      return "Column";
    }
    
    V b(int param1Int) {
      return (V)this.b.a(this.a, param1Int);
    }
  }
  
  class RowMap extends ArrayMap<R, Map<C, V>> {
    private RowMap(ArrayTable this$0) {
      super(ArrayTable.c(ArrayTable.this));
    }
    
    String a() {
      return "Row";
    }
    
    Map<C, V> a(int param1Int, Map<C, V> param1Map) {
      throw new UnsupportedOperationException();
    }
    
    public Map<C, V> a(R param1R, Map<C, V> param1Map) {
      throw new UnsupportedOperationException();
    }
    
    Map<C, V> d(int param1Int) {
      return new ArrayTable.Row(this.a, param1Int);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ArrayTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */