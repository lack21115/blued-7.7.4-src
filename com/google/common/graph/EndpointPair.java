package com.google.common.graph;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.Immutable;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Immutable(containerOf = {"N"})
public abstract class EndpointPair<N> implements Iterable<N> {
  private final N a;
  
  private final N b;
  
  private EndpointPair(N paramN1, N paramN2) {
    this.a = (N)Preconditions.a(paramN1);
    this.b = (N)Preconditions.a(paramN2);
  }
  
  static <N> EndpointPair<N> a(Graph<?> paramGraph, N paramN1, N paramN2) {
    return paramGraph.d() ? a(paramN1, paramN2) : b(paramN1, paramN2);
  }
  
  static <N> EndpointPair<N> a(Network<?, ?> paramNetwork, N paramN1, N paramN2) {
    return paramNetwork.d() ? a(paramN1, paramN2) : b(paramN1, paramN2);
  }
  
  public static <N> EndpointPair<N> a(N paramN1, N paramN2) {
    return new Ordered<N>(paramN1, paramN2);
  }
  
  public static <N> EndpointPair<N> b(N paramN1, N paramN2) {
    return new Unordered<N>(paramN2, paramN1);
  }
  
  public abstract N a();
  
  public final N a(Object paramObject) {
    if (paramObject.equals(this.a))
      return this.b; 
    if (paramObject.equals(this.b))
      return this.a; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("EndpointPair ");
    stringBuilder.append(this);
    stringBuilder.append(" does not contain node ");
    stringBuilder.append(paramObject);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public abstract N b();
  
  public final N c() {
    return this.a;
  }
  
  public final N d() {
    return this.b;
  }
  
  public abstract boolean e();
  
  public final UnmodifiableIterator<N> f() {
    return Iterators.a(new Object[] { this.a, this.b });
  }
  
  static final class Ordered<N> extends EndpointPair<N> {
    private Ordered(N param1N1, N param1N2) {
      super(param1N1, param1N2);
    }
    
    public N a() {
      return c();
    }
    
    public N b() {
      return d();
    }
    
    public boolean e() {
      return true;
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof EndpointPair))
        return false; 
      param1Object = param1Object;
      return (e() != param1Object.e()) ? false : ((a().equals(param1Object.a()) && b().equals(param1Object.b())));
    }
    
    public int hashCode() {
      return Objects.a(new Object[] { a(), b() });
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("<");
      stringBuilder.append(a());
      stringBuilder.append(" -> ");
      stringBuilder.append(b());
      stringBuilder.append(">");
      return stringBuilder.toString();
    }
  }
  
  static final class Unordered<N> extends EndpointPair<N> {
    private Unordered(N param1N1, N param1N2) {
      super(param1N1, param1N2);
    }
    
    public N a() {
      throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
    }
    
    public N b() {
      throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
    }
    
    public boolean e() {
      return false;
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof EndpointPair))
        return false; 
      param1Object = param1Object;
      return (e() != param1Object.e()) ? false : (c().equals(param1Object.c()) ? d().equals(param1Object.d()) : ((c().equals(param1Object.d()) && d().equals(param1Object.c()))));
    }
    
    public int hashCode() {
      return c().hashCode() + d().hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("[");
      stringBuilder.append(c());
      stringBuilder.append(", ");
      stringBuilder.append(d());
      stringBuilder.append("]");
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\graph\EndpointPair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */