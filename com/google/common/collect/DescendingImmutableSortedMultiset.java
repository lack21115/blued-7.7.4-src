package com.google.common.collect;

import java.util.NavigableSet;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class DescendingImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {
  private final transient ImmutableSortedMultiset<E> b;
  
  DescendingImmutableSortedMultiset(ImmutableSortedMultiset<E> paramImmutableSortedMultiset) {
    this.b = paramImmutableSortedMultiset;
  }
  
  public int a(@NullableDecl Object paramObject) {
    return this.b.a(paramObject);
  }
  
  public ImmutableSortedMultiset<E> a(E paramE, BoundType paramBoundType) {
    return this.b.b(paramE, paramBoundType).c();
  }
  
  Multiset.Entry<E> a(int paramInt) {
    return this.b.i().h().f().get(paramInt);
  }
  
  boolean a() {
    return this.b.a();
  }
  
  public ImmutableSortedMultiset<E> b(E paramE, BoundType paramBoundType) {
    return this.b.a(paramE, paramBoundType).c();
  }
  
  public ImmutableSortedSet<E> b() {
    return this.b.b().as_();
  }
  
  public ImmutableSortedMultiset<E> c() {
    return this.b;
  }
  
  public Multiset.Entry<E> j() {
    return this.b.k();
  }
  
  public Multiset.Entry<E> k() {
    return this.b.j();
  }
  
  public int size() {
    return this.b.size();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\DescendingImmutableSortedMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */