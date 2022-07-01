package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class AbstractNetwork<N, E> implements Network<N, E> {
  private static <N, E> Map<E, EndpointPair<N>> a(Network<N, E> paramNetwork) {
    Function<E, EndpointPair<N>> function = new Function<E, EndpointPair<N>>(paramNetwork) {
        public EndpointPair<N> a(E param1E) {
          return this.a.d(param1E);
        }
      };
    return Maps.a(paramNetwork.c(), function);
  }
  
  public final boolean equals(@NullableDecl Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Network))
      return false; 
    paramObject = paramObject;
    return (d() == paramObject.d() && b().equals(paramObject.b()) && a(this).equals(a((Network<?, ?>)paramObject)));
  }
  
  public final int hashCode() {
    return a(this).hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("isDirected: ");
    stringBuilder.append(d());
    stringBuilder.append(", allowsParallelEdges: ");
    stringBuilder.append(e());
    stringBuilder.append(", allowsSelfLoops: ");
    stringBuilder.append(f());
    stringBuilder.append(", nodes: ");
    stringBuilder.append(b());
    stringBuilder.append(", edges: ");
    stringBuilder.append(a(this));
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\graph\AbstractNetwork.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */