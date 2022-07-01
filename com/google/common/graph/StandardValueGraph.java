package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class StandardValueGraph<N, V> extends AbstractValueGraph<N, V> {
  protected final MapIteratorCache<N, GraphConnections<N, V>> a;
  
  protected long b;
  
  private final boolean c;
  
  private final boolean d;
  
  protected long a() {
    return this.b;
  }
  
  @NullableDecl
  public V a(N paramN1, N paramN2, @NullableDecl V paramV) {
    return b((N)Preconditions.a(paramN1), (N)Preconditions.a(paramN2), paramV);
  }
  
  public Set<EndpointPair<N>> a(N paramN) {
    return new IncidentEdgeSet<N>(this, this, paramN, i(paramN)) {
        public Iterator<EndpointPair<N>> iterator() {
          return this.a.a(this.b);
        }
      };
  }
  
  protected final V b(N paramN1, N paramN2, V paramV) {
    V v;
    GraphConnections<N, GraphConnections> graphConnections1 = (GraphConnections)this.a.a(paramN1);
    if (graphConnections1 == null) {
      graphConnections1 = null;
    } else {
      graphConnections1 = graphConnections1.b(paramN2);
    } 
    GraphConnections<N, GraphConnections> graphConnections2 = graphConnections1;
    if (graphConnections1 == null)
      v = paramV; 
    return v;
  }
  
  public Set<N> c() {
    return this.a.a();
  }
  
  public boolean d() {
    return this.c;
  }
  
  public Set<N> e(N paramN) {
    return i(paramN).a();
  }
  
  public boolean e() {
    return this.d;
  }
  
  public Set<N> f(N paramN) {
    return i(paramN).b();
  }
  
  public Set<N> g(N paramN) {
    return i(paramN).c();
  }
  
  protected final GraphConnections<N, V> i(N paramN) {
    GraphConnections<N, V> graphConnections = this.a.a(paramN);
    if (graphConnections != null)
      return graphConnections; 
    Preconditions.a(paramN);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Node ");
    stringBuilder.append(paramN);
    stringBuilder.append(" is not an element of this graph.");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\graph\StandardValueGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */