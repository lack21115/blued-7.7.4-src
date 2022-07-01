package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Set;

class StandardNetwork<N, E> extends AbstractNetwork<N, E> {
  protected final MapIteratorCache<N, NetworkConnections<N, E>> a;
  
  protected final MapIteratorCache<E, N> b;
  
  private final boolean c;
  
  private final boolean d;
  
  private final boolean e;
  
  public Set<N> a(N paramN) {
    return e(paramN).a();
  }
  
  public Set<N> b() {
    return this.a.a();
  }
  
  public Set<N> b(N paramN) {
    return e(paramN).b();
  }
  
  public Set<E> c() {
    return this.b.a();
  }
  
  public Set<N> c(N paramN) {
    return e(paramN).c();
  }
  
  public EndpointPair<N> d(E paramE) {
    N n = f(paramE);
    return EndpointPair.a(this, n, ((NetworkConnections<N, E>)this.a.a(n)).a(paramE));
  }
  
  public boolean d() {
    return this.c;
  }
  
  protected final NetworkConnections<N, E> e(N paramN) {
    NetworkConnections<N, E> networkConnections = this.a.a(paramN);
    if (networkConnections != null)
      return networkConnections; 
    Preconditions.a(paramN);
    throw new IllegalArgumentException(String.format("Node %s is not an element of this graph.", new Object[] { paramN }));
  }
  
  public boolean e() {
    return this.d;
  }
  
  protected final N f(E paramE) {
    N n = this.b.a(paramE);
    if (n != null)
      return n; 
    Preconditions.a(paramE);
    throw new IllegalArgumentException(String.format("Edge %s is not an element of this graph.", new Object[] { paramE }));
  }
  
  public boolean f() {
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\graph\StandardNetwork.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */