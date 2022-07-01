package com.google.common.graph;

import com.google.common.collect.BiMap;
import java.util.Collections;
import java.util.Set;

final class UndirectedNetworkConnections<N, E> extends AbstractUndirectedNetworkConnections<N, E> {
  public Set<N> a() {
    return Collections.unmodifiableSet(((BiMap)this.a).d());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\graph\UndirectedNetworkConnections.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */