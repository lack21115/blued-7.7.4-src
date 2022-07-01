package com.google.common.graph;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Set;

@DoNotMock("Use NetworkBuilder to create a real instance")
public interface Network<N, E> extends PredecessorsFunction<N>, SuccessorsFunction<N> {
  Set<N> a(N paramN);
  
  Set<N> b();
  
  Set<N> b(N paramN);
  
  Set<E> c();
  
  Set<N> c(N paramN);
  
  EndpointPair<N> d(E paramE);
  
  boolean d();
  
  boolean e();
  
  boolean f();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\graph\Network.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */