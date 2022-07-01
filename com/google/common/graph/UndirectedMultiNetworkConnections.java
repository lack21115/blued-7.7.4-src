package com.google.common.graph;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class UndirectedMultiNetworkConnections<N, E> extends AbstractUndirectedNetworkConnections<N, E> {
  @LazyInit
  private transient Reference<Multiset<N>> b;
  
  @NullableDecl
  private static <T> T a(@NullableDecl Reference<T> paramReference) {
    return (paramReference == null) ? null : paramReference.get();
  }
  
  private Multiset<N> d() {
    HashMultiset hashMultiset;
    Multiset multiset2 = a((Reference)this.b);
    Multiset multiset1 = multiset2;
    if (multiset2 == null) {
      hashMultiset = HashMultiset.a(this.a.values());
      this.b = new SoftReference(hashMultiset);
    } 
    return (Multiset<N>)hashMultiset;
  }
  
  public Set<N> a() {
    return Collections.unmodifiableSet(d().d());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\graph\UndirectedMultiNetworkConnections.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */