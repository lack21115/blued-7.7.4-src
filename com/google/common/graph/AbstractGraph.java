package com.google.common.graph;

import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class AbstractGraph<N> extends AbstractBaseGraph<N> implements Graph<N> {
  public final boolean equals(@NullableDecl Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Graph))
      return false; 
    paramObject = paramObject;
    return (d() == paramObject.d() && c().equals(paramObject.c()) && b().equals(paramObject.b()));
  }
  
  public final int hashCode() {
    return b().hashCode();
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
    stringBuilder.append(b());
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\graph\AbstractGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */