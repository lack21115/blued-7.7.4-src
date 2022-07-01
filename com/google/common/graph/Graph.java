package com.google.common.graph;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Set;

@DoNotMock("Use GraphBuilder to create a real instance")
public interface Graph<N> extends BaseGraph<N> {
  Set<EndpointPair<N>> a(N paramN);
  
  Set<EndpointPair<N>> b();
  
  int c(N paramN);
  
  Set<N> c();
  
  int d(N paramN);
  
  boolean d();
  
  Set<N> f(N paramN);
  
  Set<N> g(N paramN);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\graph\Graph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */