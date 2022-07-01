package com.google.common.graph;

import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

interface GraphConnections<N, V> {
  Iterator<EndpointPair<N>> a(N paramN);
  
  Set<N> a();
  
  @NullableDecl
  V b(N paramN);
  
  Set<N> b();
  
  Set<N> c();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\graph\GraphConnections.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */