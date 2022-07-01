package com.google.common.graph;

import com.google.common.collect.BiMap;
import java.util.Collections;
import java.util.Set;

final class DirectedNetworkConnections<N, E> extends AbstractDirectedNetworkConnections<N, E> {
  public Set<N> b() {
    return Collections.unmodifiableSet(((BiMap)this.a).d());
  }
  
  public Set<N> c() {
    return Collections.unmodifiableSet(((BiMap)this.b).d());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\graph\DirectedNetworkConnections.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */