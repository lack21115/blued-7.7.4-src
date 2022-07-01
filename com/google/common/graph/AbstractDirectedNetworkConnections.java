package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.math.IntMath;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class AbstractDirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {
  protected final Map<E, N> a;
  
  protected final Map<E, N> b;
  
  private int c;
  
  public N a(E paramE) {
    return (N)Preconditions.a(this.b.get(paramE));
  }
  
  public Set<N> a() {
    return (Set<N>)Sets.a(b(), c());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\graph\AbstractDirectedNetworkConnections.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */