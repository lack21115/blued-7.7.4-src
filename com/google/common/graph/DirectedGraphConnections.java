package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class DirectedGraphConnections<N, V> implements GraphConnections<N, V> {
  private static final Object a = new Object();
  
  private final Map<N, Object> b;
  
  @NullableDecl
  private final List<NodeConnection<N>> c;
  
  private int d;
  
  private int e;
  
  private static boolean e(@NullableDecl Object paramObject) {
    return (paramObject == a || paramObject instanceof PredAndSucc);
  }
  
  private static boolean f(@NullableDecl Object paramObject) {
    return (paramObject != a && paramObject != null);
  }
  
  public Iterator<EndpointPair<N>> a(N paramN) {
    Iterator iterator;
    Preconditions.a(paramN);
    List<NodeConnection<N>> list = this.c;
    if (list == null) {
      iterator = Iterators.b(Iterators.a(b().iterator(), new Function<N, EndpointPair<N>>(this, paramN) {
              public EndpointPair<N> a(N param1N) {
                return EndpointPair.a(param1N, (N)this.a);
              }
            }), Iterators.a(c().iterator(), new Function<N, EndpointPair<N>>(this, paramN) {
              public EndpointPair<N> a(N param1N) {
                return EndpointPair.a((N)this.a, param1N);
              }
            }));
    } else {
      iterator = Iterators.a(list.iterator(), new Function<NodeConnection<N>, EndpointPair<N>>(this, iterator) {
            public EndpointPair<N> a(DirectedGraphConnections.NodeConnection<N> param1NodeConnection) {
              return (param1NodeConnection instanceof DirectedGraphConnections.NodeConnection.Succ) ? EndpointPair.a((N)this.a, param1NodeConnection.a) : EndpointPair.a(param1NodeConnection.a, (N)this.a);
            }
          });
    } 
    return (Iterator<EndpointPair<N>>)new AbstractIterator<EndpointPair<N>>(this, iterator, new AtomicBoolean(false)) {
        protected EndpointPair<N> c() {
          while (this.a.hasNext()) {
            EndpointPair<N> endpointPair = this.a.next();
            if (!endpointPair.c().equals(endpointPair.d()) || !this.b.getAndSet(true))
              return endpointPair; 
          } 
          return (EndpointPair<N>)b();
        }
      };
  }
  
  public Set<N> a() {
    return (this.c == null) ? Collections.unmodifiableSet(this.b.keySet()) : new AbstractSet<N>(this) {
        public UnmodifiableIterator<N> a() {
          return (UnmodifiableIterator<N>)new AbstractIterator<N>(this, DirectedGraphConnections.a(this.a).iterator(), new HashSet()) {
              public N a() {
                while (this.a.hasNext()) {
                  DirectedGraphConnections.NodeConnection nodeConnection = this.a.next();
                  if (this.b.add(nodeConnection.a))
                    return nodeConnection.a; 
                } 
                return (N)b();
              }
            };
        }
        
        public boolean contains(@NullableDecl Object param1Object) {
          return DirectedGraphConnections.b(this.a).containsKey(param1Object);
        }
        
        public int size() {
          return DirectedGraphConnections.b(this.a).size();
        }
      };
  }
  
  public V b(N paramN) {
    Preconditions.a(paramN);
    Object object = this.b.get(paramN);
    if (object == a)
      return null; 
    paramN = (N)object;
    if (object instanceof PredAndSucc)
      paramN = (N)PredAndSucc.a((PredAndSucc)object); 
    return (V)paramN;
  }
  
  public Set<N> b() {
    return new AbstractSet<N>(this) {
        public UnmodifiableIterator<N> a() {
          return (UnmodifiableIterator<N>)((DirectedGraphConnections.a(this.a) == null) ? new AbstractIterator<N>(this, DirectedGraphConnections.b(this.a).entrySet().iterator()) {
              public N a() {
                while (this.a.hasNext()) {
                  Map.Entry entry = this.a.next();
                  if (DirectedGraphConnections.c(entry.getValue()))
                    return (N)entry.getKey(); 
                } 
                return (N)b();
              }
            } : new AbstractIterator<N>(this, DirectedGraphConnections.a(this.a).iterator()) {
              public N a() {
                while (this.a.hasNext()) {
                  DirectedGraphConnections.NodeConnection nodeConnection = this.a.next();
                  if (nodeConnection instanceof DirectedGraphConnections.NodeConnection.Pred)
                    return nodeConnection.a; 
                } 
                return (N)b();
              }
            });
        }
        
        public boolean contains(@NullableDecl Object param1Object) {
          return DirectedGraphConnections.c(DirectedGraphConnections.b(this.a).get(param1Object));
        }
        
        public int size() {
          return DirectedGraphConnections.c(this.a);
        }
      };
  }
  
  public Set<N> c() {
    return new AbstractSet<N>(this) {
        public UnmodifiableIterator<N> a() {
          return (UnmodifiableIterator<N>)((DirectedGraphConnections.a(this.a) == null) ? new AbstractIterator<N>(this, DirectedGraphConnections.b(this.a).entrySet().iterator()) {
              public N a() {
                while (this.a.hasNext()) {
                  Map.Entry entry = this.a.next();
                  if (DirectedGraphConnections.d(entry.getValue()))
                    return (N)entry.getKey(); 
                } 
                return (N)b();
              }
            } : new AbstractIterator<N>(this, DirectedGraphConnections.a(this.a).iterator()) {
              public N a() {
                while (this.a.hasNext()) {
                  DirectedGraphConnections.NodeConnection nodeConnection = this.a.next();
                  if (nodeConnection instanceof DirectedGraphConnections.NodeConnection.Succ)
                    return nodeConnection.a; 
                } 
                return (N)b();
              }
            });
        }
        
        public boolean contains(@NullableDecl Object param1Object) {
          return DirectedGraphConnections.d(DirectedGraphConnections.b(this.a).get(param1Object));
        }
        
        public int size() {
          return DirectedGraphConnections.d(this.a);
        }
      };
  }
  
  static abstract class NodeConnection<N> {
    final N a;
    
    static final class Pred<N> extends NodeConnection<N> {
      public boolean equals(Object param2Object) {
        return (param2Object instanceof Pred) ? this.a.equals(((Pred)param2Object).a) : false;
      }
      
      public int hashCode() {
        return Pred.class.hashCode() + this.a.hashCode();
      }
    }
    
    static final class Succ<N> extends NodeConnection<N> {
      public boolean equals(Object param2Object) {
        return (param2Object instanceof Succ) ? this.a.equals(((Succ)param2Object).a) : false;
      }
      
      public int hashCode() {
        return Succ.class.hashCode() + this.a.hashCode();
      }
    }
  }
  
  static final class Pred<N> extends NodeConnection<N> {
    public boolean equals(Object param1Object) {
      return (param1Object instanceof Pred) ? this.a.equals(((Pred)param1Object).a) : false;
    }
    
    public int hashCode() {
      return Pred.class.hashCode() + this.a.hashCode();
    }
  }
  
  static final class Succ<N> extends NodeConnection<N> {
    public boolean equals(Object param1Object) {
      return (param1Object instanceof Succ) ? this.a.equals(((Succ)param1Object).a) : false;
    }
    
    public int hashCode() {
      return Succ.class.hashCode() + this.a.hashCode();
    }
  }
  
  static final class PredAndSucc {
    private final Object a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\graph\DirectedGraphConnections.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */