package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

class SingletonImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {
  final R a;
  
  final C b;
  
  final V c;
  
  public ImmutableMap<R, V> f(C paramC) {
    Preconditions.a(paramC);
    return b(paramC) ? ImmutableMap.a(this.a, this.c) : ImmutableMap.j();
  }
  
  public int k() {
    return 1;
  }
  
  public ImmutableMap<C, Map<R, V>> l() {
    return ImmutableMap.a(this.b, ImmutableMap.a(this.a, this.c));
  }
  
  public ImmutableMap<R, Map<C, V>> n() {
    return ImmutableMap.a(this.a, ImmutableMap.a(this.b, this.c));
  }
  
  ImmutableSet<Table.Cell<R, C, V>> q() {
    return ImmutableSet.d(b(this.a, this.b, this.c));
  }
  
  ImmutableCollection<V> t() {
    return ImmutableSet.d(this.c);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\SingletonImmutableTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */