package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class AbstractBaseGraph<N> implements BaseGraph<N> {
  protected long a() {
    boolean bool;
    Iterator<N> iterator = c().iterator();
    long l;
    for (l = 0L; iterator.hasNext(); l += b(iterator.next()));
    if ((0x1L & l) == 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.b(bool);
    return l >>> 1L;
  }
  
  public Set<EndpointPair<N>> a(N paramN) {
    Preconditions.a(paramN);
    Preconditions.a(c().contains(paramN), "Node %s is not an element of this graph.", paramN);
    return new IncidentEdgeSet<N>(this, this, paramN) {
        public UnmodifiableIterator<EndpointPair<N>> a() {
          return this.c.d() ? Iterators.a(Iterators.b(Iterators.a(this.c.f(this.b).iterator(), new Function<N, EndpointPair<N>>(this) {
                    public EndpointPair<N> a(N param2N) {
                      return EndpointPair.a(param2N, this.a.b);
                    }
                  }), Iterators.a((Iterator)Sets.c(this.c.g(this.b), (Set)ImmutableSet.d(this.b)).a(), new Function<N, EndpointPair<N>>(this) {
                    public EndpointPair<N> a(N param2N) {
                      return EndpointPair.a(this.a.b, param2N);
                    }
                  }))) : Iterators.a(Iterators.a(this.c.e(this.b).iterator(), new Function<N, EndpointPair<N>>(this) {
                  public EndpointPair<N> a(N param2N) {
                    return EndpointPair.b(this.a.b, param2N);
                  }
                }));
        }
      };
  }
  
  protected final boolean a(EndpointPair<?> paramEndpointPair) {
    return (paramEndpointPair.e() || !d());
  }
  
  public int b(N paramN) {
    boolean bool;
    if (d())
      return IntMath.e(f(paramN).size(), g(paramN).size()); 
    Set<N> set = e(paramN);
    if (e() && set.contains(paramN)) {
      bool = true;
    } else {
      bool = false;
    } 
    return IntMath.e(set.size(), bool);
  }
  
  public Set<EndpointPair<N>> b() {
    return new AbstractSet<EndpointPair<N>>(this) {
        public UnmodifiableIterator<EndpointPair<N>> a() {
          return (UnmodifiableIterator)EndpointPairIterator.a(this.a);
        }
        
        public boolean contains(@NullableDecl Object param1Object) {
          boolean bool = param1Object instanceof EndpointPair;
          boolean bool1 = false;
          if (!bool)
            return false; 
          param1Object = param1Object;
          bool = bool1;
          if (this.a.a((EndpointPair<?>)param1Object)) {
            bool = bool1;
            if (this.a.c().contains(param1Object.c())) {
              bool = bool1;
              if (this.a.g(param1Object.c()).contains(param1Object.d()))
                bool = true; 
            } 
          } 
          return bool;
        }
        
        public boolean remove(Object param1Object) {
          throw new UnsupportedOperationException();
        }
        
        public int size() {
          return Ints.b(this.a.a());
        }
      };
  }
  
  public int c(N paramN) {
    return d() ? f(paramN).size() : b(paramN);
  }
  
  public int d(N paramN) {
    return d() ? g(paramN).size() : b(paramN);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\graph\AbstractBaseGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */