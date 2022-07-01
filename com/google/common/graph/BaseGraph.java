package com.google.common.graph;

import java.util.Set;

interface BaseGraph<N> extends PredecessorsFunction<N>, SuccessorsFunction<N> {
  Set<EndpointPair<N>> a(N paramN);
  
  int b(N paramN);
  
  Set<EndpointPair<N>> b();
  
  int c(N paramN);
  
  Set<N> c();
  
  int d(N paramN);
  
  boolean d();
  
  Set<N> e(N paramN);
  
  boolean e();
  
  Set<N> f(N paramN);
  
  Set<N> g(N paramN);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\graph\BaseGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */