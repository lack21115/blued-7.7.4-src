package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public abstract class ForwardingTable<R, C, V> extends ForwardingObject implements Table<R, C, V> {
  public V a(R paramR, C paramC, V paramV) {
    return c().a(paramR, paramC, paramV);
  }
  
  public Set<R> a() {
    return c().a();
  }
  
  public boolean a(Object paramObject) {
    return c().a(paramObject);
  }
  
  public boolean a(Object paramObject1, Object paramObject2) {
    return c().a(paramObject1, paramObject2);
  }
  
  public V b(Object paramObject1, Object paramObject2) {
    return c().b(paramObject1, paramObject2);
  }
  
  public Set<C> b() {
    return c().b();
  }
  
  public boolean b(Object paramObject) {
    return c().b(paramObject);
  }
  
  protected abstract Table<R, C, V> c();
  
  public V c(Object paramObject1, Object paramObject2) {
    return c().c(paramObject1, paramObject2);
  }
  
  public boolean c(Object paramObject) {
    return c().c(paramObject);
  }
  
  public Map<R, V> d(C paramC) {
    return c().d(paramC);
  }
  
  public void d() {
    c().d();
  }
  
  public Map<C, V> e(R paramR) {
    return c().e(paramR);
  }
  
  public Set<Table.Cell<R, C, V>> e() {
    return c().e();
  }
  
  public boolean equals(Object paramObject) {
    return (paramObject == this || c().equals(paramObject));
  }
  
  public Collection<V> h() {
    return c().h();
  }
  
  public int hashCode() {
    return c().hashCode();
  }
  
  public int k() {
    return c().k();
  }
  
  public Map<C, Map<R, V>> m() {
    return c().m();
  }
  
  public Map<R, Map<C, V>> o() {
    return c().o();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ForwardingTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */