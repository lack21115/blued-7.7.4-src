package com.google.common.graph;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class DirectedMultiNetworkConnections<N, E> extends AbstractDirectedNetworkConnections<N, E> {
  @LazyInit
  private transient Reference<Multiset<N>> c;
  
  @LazyInit
  private transient Reference<Multiset<N>> d;
  
  @NullableDecl
  private static <T> T a(@NullableDecl Reference<T> paramReference) {
    return (paramReference == null) ? null : paramReference.get();
  }
  
  private Multiset<N> d() {
    HashMultiset hashMultiset;
    Multiset multiset2 = a((Reference)this.c);
    Multiset multiset1 = multiset2;
    if (multiset2 == null) {
      hashMultiset = HashMultiset.a(this.a.values());
      this.c = new SoftReference(hashMultiset);
    } 
    return (Multiset<N>)hashMultiset;
  }
  
  private Multiset<N> e() {
    HashMultiset hashMultiset;
    Multiset multiset2 = a((Reference)this.d);
    Multiset multiset1 = multiset2;
    if (multiset2 == null) {
      hashMultiset = HashMultiset.a(this.b.values());
      this.d = new SoftReference(hashMultiset);
    } 
    return (Multiset<N>)hashMultiset;
  }
  
  public Set<N> b() {
    return Collections.unmodifiableSet(d().d());
  }
  
  public Set<N> c() {
    return Collections.unmodifiableSet(e().d());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\graph\DirectedMultiNetworkConnections.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */