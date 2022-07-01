package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.collect.Iterators;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class UndirectedGraphConnections<N, V> implements GraphConnections<N, V> {
  private final Map<N, V> a;
  
  public Iterator<EndpointPair<N>> a(N paramN) {
    return Iterators.a(this.a.keySet().iterator(), new Function<N, EndpointPair<N>>(this, paramN) {
          public EndpointPair<N> a(N param1N) {
            return EndpointPair.b((N)this.a, param1N);
          }
        });
  }
  
  public Set<N> a() {
    return Collections.unmodifiableSet(this.a.keySet());
  }
  
  public V b(N paramN) {
    return this.a.get(paramN);
  }
  
  public Set<N> b() {
    return a();
  }
  
  public Set<N> c() {
    return a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\graph\UndirectedGraphConnections.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */