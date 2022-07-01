package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class AbstractValueGraph<N, V> extends AbstractBaseGraph<N> implements ValueGraph<N, V> {
  private static <N, V> Map<EndpointPair<N>, V> a(ValueGraph<N, V> paramValueGraph) {
    Function<EndpointPair<N>, V> function = new Function<EndpointPair<N>, V>(paramValueGraph) {
        public V a(EndpointPair<N> param1EndpointPair) {
          return (V)this.a.a(param1EndpointPair.c(), param1EndpointPair.d(), null);
        }
      };
    return Maps.a(paramValueGraph.b(), function);
  }
  
  public final boolean equals(@NullableDecl Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof ValueGraph))
      return false; 
    paramObject = paramObject;
    return (d() == paramObject.d() && c().equals(paramObject.c()) && a(this).equals(a((ValueGraph<?, ?>)paramObject)));
  }
  
  public final int hashCode() {
    return a(this).hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("isDirected: ");
    stringBuilder.append(d());
    stringBuilder.append(", allowsSelfLoops: ");
    stringBuilder.append(e());
    stringBuilder.append(", nodes: ");
    stringBuilder.append(c());
    stringBuilder.append(", edges: ");
    stringBuilder.append(a(this));
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\graph\AbstractValueGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */