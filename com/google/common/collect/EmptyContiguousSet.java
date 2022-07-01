package com.google.common.collect;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class EmptyContiguousSet<C extends Comparable> extends ContiguousSet<C> {
  EmptyContiguousSet(DiscreteDomain<C> paramDiscreteDomain) {
    super(paramDiscreteDomain);
  }
  
  boolean a() {
    return false;
  }
  
  public Range<C> ar_() {
    throw new NoSuchElementException();
  }
  
  public UnmodifiableIterator<C> av_() {
    return Iterators.a();
  }
  
  ContiguousSet<C> b(C paramC1, boolean paramBoolean1, C paramC2, boolean paramBoolean2) {
    return this;
  }
  
  int c(Object paramObject) {
    return -1;
  }
  
  ContiguousSet<C> c(C paramC, boolean paramBoolean) {
    return this;
  }
  
  ImmutableSortedSet<C> c() {
    return ImmutableSortedSet.a(Ordering.<Comparable>d().a());
  }
  
  public boolean contains(Object paramObject) {
    return false;
  }
  
  ContiguousSet<C> d(C paramC, boolean paramBoolean) {
    return this;
  }
  
  public UnmodifiableIterator<C> e() {
    return Iterators.a();
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    return (paramObject instanceof Set) ? ((Set)paramObject).isEmpty() : false;
  }
  
  public C f() {
    throw new NoSuchElementException();
  }
  
  public C g() {
    throw new NoSuchElementException();
  }
  
  public ImmutableList<C> h() {
    return ImmutableList.d();
  }
  
  public int hashCode() {
    return 0;
  }
  
  boolean i() {
    return true;
  }
  
  public boolean isEmpty() {
    return true;
  }
  
  public int size() {
    return 0;
  }
  
  public String toString() {
    return "[]";
  }
  
  static final class SerializedForm<C extends Comparable> implements Serializable {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\EmptyContiguousSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */