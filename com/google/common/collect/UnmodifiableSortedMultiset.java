package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class UnmodifiableSortedMultiset<E> extends Multisets.UnmodifiableMultiset<E> implements SortedMultiset<E> {
  @NullableDecl
  private transient UnmodifiableSortedMultiset<E> d;
  
  UnmodifiableSortedMultiset(SortedMultiset<E> paramSortedMultiset) {
    super(paramSortedMultiset);
  }
  
  public SortedMultiset<E> a(E paramE1, BoundType paramBoundType1, E paramE2, BoundType paramBoundType2) {
    return Multisets.a(e().a(paramE1, paramBoundType1, paramE2, paramBoundType2));
  }
  
  public NavigableSet<E> au_() {
    return (NavigableSet<E>)super.d();
  }
  
  public SortedMultiset<E> c(E paramE, BoundType paramBoundType) {
    return Multisets.a(e().c(paramE, paramBoundType));
  }
  
  public Comparator<? super E> comparator() {
    return e().comparator();
  }
  
  public SortedMultiset<E> d(E paramE, BoundType paramBoundType) {
    return Multisets.a(e().d(paramE, paramBoundType));
  }
  
  protected SortedMultiset<E> e() {
    return (SortedMultiset<E>)super.g();
  }
  
  NavigableSet<E> i() {
    return Sets.a(e().au_());
  }
  
  public Multiset.Entry<E> j() {
    return e().j();
  }
  
  public Multiset.Entry<E> k() {
    return e().k();
  }
  
  public Multiset.Entry<E> l() {
    throw new UnsupportedOperationException();
  }
  
  public Multiset.Entry<E> m() {
    throw new UnsupportedOperationException();
  }
  
  public SortedMultiset<E> p() {
    UnmodifiableSortedMultiset<E> unmodifiableSortedMultiset2 = this.d;
    UnmodifiableSortedMultiset<E> unmodifiableSortedMultiset1 = unmodifiableSortedMultiset2;
    if (unmodifiableSortedMultiset2 == null) {
      unmodifiableSortedMultiset1 = new UnmodifiableSortedMultiset(e().p());
      unmodifiableSortedMultiset1.d = this;
      this.d = unmodifiableSortedMultiset1;
    } 
    return unmodifiableSortedMultiset1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\UnmodifiableSortedMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */