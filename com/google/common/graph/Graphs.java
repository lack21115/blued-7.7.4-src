package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.collect.Iterators;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Graphs {
  enum NodeVisitState {
    a, b;
  }
  
  static class TransposedGraph<N> extends ForwardingGraph<N> {
    private final Graph<N> a;
    
    public Set<EndpointPair<N>> a(N param1N) {
      return new IncidentEdgeSet<N>(this, this, param1N) {
          public Iterator<EndpointPair<N>> iterator() {
            return Iterators.a(this.a.g().a(this.b).iterator(), new Function<EndpointPair<N>, EndpointPair<N>>(this) {
                  public EndpointPair<N> a(EndpointPair<N> param3EndpointPair) {
                    return EndpointPair.a(this.a.a.g(), param3EndpointPair.d(), param3EndpointPair.c());
                  }
                });
          }
        };
    }
    
    public int c(N param1N) {
      return g().d(param1N);
    }
    
    public int d(N param1N) {
      return g().c(param1N);
    }
    
    public Set<N> f(N param1N) {
      return g().g(param1N);
    }
    
    protected Graph<N> g() {
      return this.a;
    }
    
    public Set<N> g(N param1N) {
      return g().f(param1N);
    }
  }
  
  class null extends IncidentEdgeSet<N> {
    null(Graphs this$0, BaseGraph<N> param1BaseGraph, Object param1Object) {
      super(param1BaseGraph, (N)param1Object);
    }
    
    public Iterator<EndpointPair<N>> iterator() {
      return Iterators.a(this.a.g().a(this.b).iterator(), new Function<EndpointPair<N>, EndpointPair<N>>(this) {
            public EndpointPair<N> a(EndpointPair<N> param3EndpointPair) {
              return EndpointPair.a(this.a.a.g(), param3EndpointPair.d(), param3EndpointPair.c());
            }
          });
    }
  }
  
  class null implements Function<EndpointPair<N>, EndpointPair<N>> {
    public EndpointPair<N> a(EndpointPair<N> param1EndpointPair) {
      return EndpointPair.a(this.a.a.g(), param1EndpointPair.d(), param1EndpointPair.c());
    }
  }
  
  static class TransposedNetwork<N, E> extends ForwardingNetwork<N, E> {
    private final Network<N, E> a;
    
    protected Network<N, E> a() {
      return this.a;
    }
    
    public Set<N> b(N param1N) {
      return a().c(param1N);
    }
    
    public Set<N> c(N param1N) {
      return a().b(param1N);
    }
    
    public EndpointPair<N> d(E param1E) {
      EndpointPair<N> endpointPair = a().d(param1E);
      return EndpointPair.a(this.a, endpointPair.d(), endpointPair.c());
    }
  }
  
  static class TransposedValueGraph<N, V> extends ForwardingValueGraph<N, V> {
    private final ValueGraph<N, V> a;
    
    @NullableDecl
    public V a(N param1N1, N param1N2, @NullableDecl V param1V) {
      return f().a(param1N2, param1N1, param1V);
    }
    
    public int c(N param1N) {
      return f().d(param1N);
    }
    
    public int d(N param1N) {
      return f().c(param1N);
    }
    
    protected ValueGraph<N, V> f() {
      return this.a;
    }
    
    public Set<N> f(N param1N) {
      return f().g(param1N);
    }
    
    public Set<N> g(N param1N) {
      return f().f(param1N);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\graph\Graphs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */