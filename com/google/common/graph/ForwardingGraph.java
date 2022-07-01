package com.google.common.graph;

import java.util.Set;

abstract class ForwardingGraph<N> extends AbstractGraph<N> {
  protected long a() {
    return f().b().size();
  }
  
  public Set<EndpointPair<N>> a(N paramN) {
    return f().a(paramN);
  }
  
  public int b(N paramN) {
    return f().b(paramN);
  }
  
  public int c(N paramN) {
    return f().c(paramN);
  }
  
  public Set<N> c() {
    return f().c();
  }
  
  public int d(N paramN) {
    return f().d(paramN);
  }
  
  public boolean d() {
    return f().d();
  }
  
  public Set<N> e(N paramN) {
    return f().e(paramN);
  }
  
  public boolean e() {
    return f().e();
  }
  
  protected abstract BaseGraph<N> f();
  
  public Set<N> f(N paramN) {
    return f().f(paramN);
  }
  
  public Set<N> g(N paramN) {
    return f().g(paramN);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\graph\ForwardingGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */