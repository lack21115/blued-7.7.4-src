package com.google.common.graph;

final class StandardMutableGraph<N> extends ForwardingGraph<N> implements MutableGraph<N> {
  private final MutableValueGraph<N, GraphConstants.Presence> a;
  
  protected BaseGraph<N> f() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\graph\StandardMutableGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */