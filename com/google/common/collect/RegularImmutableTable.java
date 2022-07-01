package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class RegularImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {
  abstract Table.Cell<R, C, V> a(int paramInt);
  
  final void a(R paramR, C paramC, V paramV1, V paramV2) {
    boolean bool;
    if (paramV1 == null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool, "Duplicate key: (row=%s, column=%s), values: [%s, %s].", paramR, paramC, paramV2, paramV1);
  }
  
  abstract V b(int paramInt);
  
  final ImmutableSet<Table.Cell<R, C, V>> q() {
    return c() ? ImmutableSet.j() : new CellSet();
  }
  
  final ImmutableCollection<V> t() {
    return c() ? ImmutableList.d() : new Values();
  }
  
  final class CellSet extends IndexedImmutableSet<Table.Cell<R, C, V>> {
    private CellSet(RegularImmutableTable this$0) {}
    
    boolean a() {
      return false;
    }
    
    Table.Cell<R, C, V> b(int param1Int) {
      return this.a.a(param1Int);
    }
    
    public boolean contains(@NullableDecl Object param1Object) {
      boolean bool = param1Object instanceof Table.Cell;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool) {
        param1Object = param1Object;
        Object object = this.a.b(param1Object.a(), param1Object.b());
        bool1 = bool2;
        if (object != null) {
          bool1 = bool2;
          if (object.equals(param1Object.c()))
            bool1 = true; 
        } 
      } 
      return bool1;
    }
    
    public int size() {
      return this.a.k();
    }
  }
  
  final class Values extends ImmutableList<V> {
    private Values(RegularImmutableTable this$0) {}
    
    boolean a() {
      return true;
    }
    
    public V get(int param1Int) {
      return (V)this.a.b(param1Int);
    }
    
    public int size() {
      return this.a.k();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\RegularImmutableTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */