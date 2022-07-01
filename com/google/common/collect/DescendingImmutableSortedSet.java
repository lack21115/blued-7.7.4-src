package com.google.common.collect;

import java.util.Iterator;
import java.util.NavigableSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class DescendingImmutableSortedSet<E> extends ImmutableSortedSet<E> {
  private final ImmutableSortedSet<E> a;
  
  DescendingImmutableSortedSet(ImmutableSortedSet<E> paramImmutableSortedSet) {
    super(Ordering.a(paramImmutableSortedSet.comparator()).a());
    this.a = paramImmutableSortedSet;
  }
  
  ImmutableSortedSet<E> a(E paramE, boolean paramBoolean) {
    return this.a.d(paramE, paramBoolean).as_();
  }
  
  ImmutableSortedSet<E> a(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2) {
    return this.a.b(paramE2, paramBoolean2, paramE1, paramBoolean1).as_();
  }
  
  boolean a() {
    return this.a.a();
  }
  
  public ImmutableSortedSet<E> as_() {
    return this.a;
  }
  
  public UnmodifiableIterator<E> av_() {
    return this.a.e();
  }
  
  ImmutableSortedSet<E> b(E paramE, boolean paramBoolean) {
    return this.a.c(paramE, paramBoolean).as_();
  }
  
  int c(@NullableDecl Object paramObject) {
    int i = this.a.c(paramObject);
    return (i == -1) ? i : (size() - 1 - i);
  }
  
  ImmutableSortedSet<E> c() {
    throw new AssertionError("should never be called");
  }
  
  public E ceiling(E paramE) {
    return this.a.floor(paramE);
  }
  
  public boolean contains(@NullableDecl Object paramObject) {
    return this.a.contains(paramObject);
  }
  
  public UnmodifiableIterator<E> e() {
    return this.a.av_();
  }
  
  public E floor(E paramE) {
    return this.a.ceiling(paramE);
  }
  
  public E higher(E paramE) {
    return this.a.lower(paramE);
  }
  
  public E lower(E paramE) {
    return this.a.higher(paramE);
  }
  
  public int size() {
    return this.a.size();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\DescendingImmutableSortedSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */