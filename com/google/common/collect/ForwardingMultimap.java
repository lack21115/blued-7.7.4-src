package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class ForwardingMultimap<K, V> extends ForwardingObject implements Multimap<K, V> {
  protected abstract Multimap<K, V> a();
  
  public boolean a(K paramK, V paramV) {
    return a().a(paramK, paramV);
  }
  
  public boolean b(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2) {
    return a().b(paramObject1, paramObject2);
  }
  
  public Collection<V> c(@NullableDecl K paramK) {
    return a().c(paramK);
  }
  
  public Map<K, Collection<V>> c() {
    return a().c();
  }
  
  public boolean c(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2) {
    return a().c(paramObject1, paramObject2);
  }
  
  public Collection<V> d(@NullableDecl Object paramObject) {
    return a().d(paramObject);
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    return (paramObject == this || a().equals(paramObject));
  }
  
  public int f() {
    return a().f();
  }
  
  public boolean f(@NullableDecl Object paramObject) {
    return a().f(paramObject);
  }
  
  public void g() {
    a().g();
  }
  
  public boolean g(@NullableDecl Object paramObject) {
    return a().g(paramObject);
  }
  
  public int hashCode() {
    return a().hashCode();
  }
  
  public Collection<Map.Entry<K, V>> m() {
    return a().m();
  }
  
  public boolean r() {
    return a().r();
  }
  
  public Set<K> s() {
    return a().s();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ForwardingMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */