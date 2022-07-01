package com.google.common.graph;

import java.util.Set;

abstract class ForwardingNetwork<N, E> extends AbstractNetwork<N, E> {
  protected abstract Network<N, E> a();
  
  public Set<N> a(N paramN) {
    return a().a(paramN);
  }
  
  public Set<N> b() {
    return a().b();
  }
  
  public Set<N> b(N paramN) {
    return a().b(paramN);
  }
  
  public Set<E> c() {
    return a().c();
  }
  
  public Set<N> c(N paramN) {
    return a().c(paramN);
  }
  
  public EndpointPair<N> d(E paramE) {
    return a().d(paramE);
  }
  
  public boolean d() {
    return a().d();
  }
  
  public boolean e() {
    return a().e();
  }
  
  public boolean f() {
    return a().f();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\graph\ForwardingNetwork.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */