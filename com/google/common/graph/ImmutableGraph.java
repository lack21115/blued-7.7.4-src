package com.google.common.graph;

import com.google.errorprone.annotations.Immutable;
import java.util.Set;

@Immutable(containerOf = {"N"})
public class ImmutableGraph<N> extends ForwardingGraph<N> {
  private final BaseGraph<N> a;
  
  protected BaseGraph<N> f() {
    return this.a;
  }
  
  public static class Builder<N> {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\graph\ImmutableGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */