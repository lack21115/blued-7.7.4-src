package com.google.common.collect;

import com.google.errorprone.annotations.Immutable;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Immutable(containerOf = {"R", "C", "V"})
final class DenseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
  private final ImmutableMap<R, Integer> a;
  
  private final ImmutableMap<C, Integer> b;
  
  private final ImmutableMap<R, ImmutableMap<C, V>> c;
  
  private final ImmutableMap<C, ImmutableMap<R, V>> d;
  
  private final int[] e;
  
  private final int[] f;
  
  private final V[][] g;
  
  private final int[] h;
  
  private final int[] i;
  
  Table.Cell<R, C, V> a(int paramInt) {
    int i = this.h[paramInt];
    paramInt = this.i[paramInt];
    return b(v().h().get(i), u().h().get(paramInt), this.g[i][paramInt]);
  }
  
  V b(int paramInt) {
    return this.g[this.h[paramInt]][this.i[paramInt]];
  }
  
  public V b(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2) {
    paramObject1 = this.a.get(paramObject1);
    paramObject2 = this.b.get(paramObject2);
    return (paramObject1 == null || paramObject2 == null) ? null : this.g[paramObject1.intValue()][paramObject2.intValue()];
  }
  
  public int k() {
    return this.h.length;
  }
  
  public ImmutableMap<C, Map<R, V>> l() {
    return ImmutableMap.a((Map)this.d);
  }
  
  public ImmutableMap<R, Map<C, V>> n() {
    return ImmutableMap.a((Map)this.c);
  }
  
  final class Column extends ImmutableArrayMap<R, V> {
    private final int c;
    
    Column(DenseImmutableTable this$0, int param1Int) {
      super(DenseImmutableTable.d(this$0)[param1Int]);
      this.c = param1Int;
    }
    
    V a(int param1Int) {
      return (V)DenseImmutableTable.c(this.a)[param1Int][this.c];
    }
    
    ImmutableMap<R, Integer> at_() {
      return DenseImmutableTable.e(this.a);
    }
    
    boolean b() {
      return true;
    }
  }
  
  final class ColumnMap extends ImmutableArrayMap<C, ImmutableMap<R, V>> {
    ImmutableMap<C, Integer> at_() {
      return DenseImmutableTable.b(this.a);
    }
    
    ImmutableMap<R, V> b(int param1Int) {
      return new DenseImmutableTable.Column(this.a, param1Int);
    }
    
    boolean b() {
      return false;
    }
  }
  
  static abstract class ImmutableArrayMap<K, V> extends ImmutableMap.IteratorBasedImmutableMap<K, V> {
    private final int a;
    
    ImmutableArrayMap(int param1Int) {
      this.a = param1Int;
    }
    
    private boolean e() {
      return (this.a == at_().size());
    }
    
    @NullableDecl
    abstract V a(int param1Int);
    
    abstract ImmutableMap<K, Integer> at_();
    
    ImmutableSet<K> c() {
      return e() ? at_().n() : super.c();
    }
    
    K c(int param1Int) {
      return at_().n().h().get(param1Int);
    }
    
    UnmodifiableIterator<Map.Entry<K, V>> d() {
      return new AbstractIterator<Map.Entry<K, V>>(this) {
          private int b = -1;
          
          private final int c = this.a.at_().size();
          
          protected Map.Entry<K, V> c() {
            int i = this.b;
            while (true) {
              this.b = i + 1;
              i = this.b;
              if (i < this.c) {
                Object object = this.a.a(i);
                if (object != null)
                  return Maps.a((K)this.a.c(this.b), (V)object); 
                i = this.b;
                continue;
              } 
              return b();
            } 
          }
        };
    }
    
    public V get(@NullableDecl Object param1Object) {
      param1Object = at_().get(param1Object);
      return (param1Object == null) ? null : a(param1Object.intValue());
    }
    
    public int size() {
      return this.a;
    }
  }
  
  class null extends AbstractIterator<Map.Entry<K, V>> {
    private int b = -1;
    
    private final int c = this.a.at_().size();
    
    null(DenseImmutableTable this$0) {}
    
    protected Map.Entry<K, V> c() {
      int i = this.b;
      while (true) {
        this.b = i + 1;
        i = this.b;
        if (i < this.c) {
          Object object = this.a.a(i);
          if (object != null)
            return Maps.a((K)this.a.c(this.b), (V)object); 
          i = this.b;
          continue;
        } 
        return b();
      } 
    }
  }
  
  final class Row extends ImmutableArrayMap<C, V> {
    private final int c;
    
    Row(DenseImmutableTable this$0, int param1Int) {
      super(DenseImmutableTable.a(this$0)[param1Int]);
      this.c = param1Int;
    }
    
    V a(int param1Int) {
      return (V)DenseImmutableTable.c(this.a)[this.c][param1Int];
    }
    
    ImmutableMap<C, Integer> at_() {
      return DenseImmutableTable.b(this.a);
    }
    
    boolean b() {
      return true;
    }
  }
  
  final class RowMap extends ImmutableArrayMap<R, ImmutableMap<C, V>> {
    ImmutableMap<R, Integer> at_() {
      return DenseImmutableTable.e(this.a);
    }
    
    ImmutableMap<C, V> b(int param1Int) {
      return new DenseImmutableTable.Row(this.a, param1Int);
    }
    
    boolean b() {
      return false;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\DenseImmutableTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */