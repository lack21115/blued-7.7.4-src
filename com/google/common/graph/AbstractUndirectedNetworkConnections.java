package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Map;
import java.util.Set;

abstract class AbstractUndirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {
  protected final Map<E, N> a;
  
  public N a(E paramE) {
    return (N)Preconditions.a(this.a.get(paramE));
  }
  
  public Set<N> b() {
    return a();
  }
  
  public Set<N> c() {
    return a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\graph\AbstractUndirectedNetworkConnections.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */