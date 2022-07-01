package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Set;

abstract class EndpointPairIterator<N> extends AbstractIterator<EndpointPair<N>> {
  protected N a = null;
  
  protected Iterator<N> b = (Iterator<N>)ImmutableSet.j().av_();
  
  private final BaseGraph<N> c;
  
  private final Iterator<N> d;
  
  private EndpointPairIterator(BaseGraph<N> paramBaseGraph) {
    this.c = paramBaseGraph;
    this.d = paramBaseGraph.c().iterator();
  }
  
  static <N> EndpointPairIterator<N> a(BaseGraph<N> paramBaseGraph) {
    return (EndpointPairIterator<N>)(paramBaseGraph.d() ? new Directed<N>(paramBaseGraph) : new Undirected<N>(paramBaseGraph));
  }
  
  protected final boolean c() {
    Preconditions.b(this.b.hasNext() ^ true);
    if (!this.d.hasNext())
      return false; 
    this.a = this.d.next();
    this.b = this.c.g(this.a).iterator();
    return true;
  }
  
  static final class Directed<N> extends EndpointPairIterator<N> {
    private Directed(BaseGraph<N> param1BaseGraph) {
      super(param1BaseGraph);
    }
    
    protected EndpointPair<N> d() {
      while (true) {
        if (this.b.hasNext())
          return EndpointPair.a(this.a, this.b.next()); 
        if (!c())
          return (EndpointPair<N>)b(); 
      } 
    }
  }
  
  static final class Undirected<N> extends EndpointPairIterator<N> {
    private Set<N> c;
    
    private Undirected(BaseGraph<N> param1BaseGraph) {
      super(param1BaseGraph);
      this.c = Sets.a(param1BaseGraph.c().size());
    }
    
    protected EndpointPair<N> d() {
      while (true) {
        while (this.b.hasNext()) {
          N n = this.b.next();
          if (!this.c.contains(n))
            return EndpointPair.b(this.a, n); 
        } 
        this.c.add(this.a);
        if (!c()) {
          this.c = null;
          return (EndpointPair<N>)b();
        } 
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\graph\EndpointPairIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */