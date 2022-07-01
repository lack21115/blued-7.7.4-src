package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

class StandardRowSortedTable<R, C, V> extends StandardTable<R, C, V> implements RowSortedTable<R, C, V> {
  StandardRowSortedTable(SortedMap<R, Map<C, V>> paramSortedMap, Supplier<? extends Map<C, V>> paramSupplier) {
    super(paramSortedMap, paramSupplier);
  }
  
  private SortedMap<R, Map<C, V>> q() {
    return (SortedMap<R, Map<C, V>>)this.a;
  }
  
  public SortedMap<R, Map<C, V>> aA_() {
    return (SortedMap<R, Map<C, V>>)super.o();
  }
  
  public SortedSet<R> az_() {
    return (SortedSet<R>)aA_().keySet();
  }
  
  SortedMap<R, Map<C, V>> l() {
    return new RowSortedMap();
  }
  
  class RowSortedMap extends StandardTable<R, C, V>.RowMap implements SortedMap<R, Map<C, V>> {
    private RowSortedMap(StandardRowSortedTable this$0) {}
    
    public SortedSet<R> c() {
      return (SortedSet<R>)super.keySet();
    }
    
    public Comparator<? super R> comparator() {
      return StandardRowSortedTable.a(this.a).comparator();
    }
    
    SortedSet<R> d() {
      return new Maps.SortedKeySet<R, Object>(this);
    }
    
    public R firstKey() {
      return (R)StandardRowSortedTable.a(this.a).firstKey();
    }
    
    public SortedMap<R, Map<C, V>> headMap(R param1R) {
      Preconditions.a(param1R);
      return (new StandardRowSortedTable<R, C, V>(StandardRowSortedTable.a(this.a).headMap(param1R), this.a.b)).aA_();
    }
    
    public R lastKey() {
      return (R)StandardRowSortedTable.a(this.a).lastKey();
    }
    
    public SortedMap<R, Map<C, V>> subMap(R param1R1, R param1R2) {
      Preconditions.a(param1R1);
      Preconditions.a(param1R2);
      return (new StandardRowSortedTable<R, C, V>(StandardRowSortedTable.a(this.a).subMap(param1R1, param1R2), this.a.b)).aA_();
    }
    
    public SortedMap<R, Map<C, V>> tailMap(R param1R) {
      Preconditions.a(param1R);
      return (new StandardRowSortedTable<R, C, V>(StandardRowSortedTable.a(this.a).tailMap(param1R), this.a.b)).aA_();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\StandardRowSortedTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */