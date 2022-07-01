package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class DescendingMultiset<E> extends ForwardingMultiset<E> implements SortedMultiset<E> {
  @NullableDecl
  private transient Comparator<? super E> a;
  
  @NullableDecl
  private transient NavigableSet<E> b;
  
  @NullableDecl
  private transient Set<Multiset.Entry<E>> c;
  
  abstract SortedMultiset<E> a();
  
  public SortedMultiset<E> a(E paramE1, BoundType paramBoundType1, E paramE2, BoundType paramBoundType2) {
    return a().a(paramE2, paramBoundType2, paramE1, paramBoundType1).p();
  }
  
  public NavigableSet<E> au_() {
    NavigableSet<E> navigableSet2 = this.b;
    NavigableSet<E> navigableSet1 = navigableSet2;
    if (navigableSet2 == null) {
      navigableSet1 = new SortedMultisets.NavigableElementSet<E>(this);
      this.b = navigableSet1;
    } 
    return navigableSet1;
  }
  
  public SortedMultiset<E> c(E paramE, BoundType paramBoundType) {
    return a().d(paramE, paramBoundType).p();
  }
  
  public Comparator<? super E> comparator() {
    Comparator<? super E> comparator2 = this.a;
    Comparator<? super E> comparator1 = comparator2;
    if (comparator2 == null) {
      comparator1 = Ordering.a(a().comparator()).a();
      this.a = comparator1;
    } 
    return comparator1;
  }
  
  public SortedMultiset<E> d(E paramE, BoundType paramBoundType) {
    return a().c(paramE, paramBoundType).p();
  }
  
  abstract Iterator<Multiset.Entry<E>> e();
  
  public Set<Multiset.Entry<E>> f() {
    Set<Multiset.Entry<E>> set2 = this.c;
    Set<Multiset.Entry<E>> set1 = set2;
    if (set2 == null) {
      set1 = i();
      this.c = set1;
    } 
    return set1;
  }
  
  protected Multiset<E> g() {
    return a();
  }
  
  Set<Multiset.Entry<E>> i() {
    class EntrySetImpl extends Multisets.EntrySet<E> {
      EntrySetImpl(DescendingMultiset this$0) {}
      
      Multiset<E> a() {
        return this.a;
      }
      
      public Iterator<Multiset.Entry<E>> iterator() {
        return this.a.e();
      }
      
      public int size() {
        return this.a.a().f().size();
      }
    };
    return new EntrySetImpl(this);
  }
  
  public Iterator<E> iterator() {
    return Multisets.a(this);
  }
  
  public Multiset.Entry<E> j() {
    return a().k();
  }
  
  public Multiset.Entry<E> k() {
    return a().j();
  }
  
  public Multiset.Entry<E> l() {
    return a().m();
  }
  
  public Multiset.Entry<E> m() {
    return a().l();
  }
  
  public SortedMultiset<E> p() {
    return a();
  }
  
  public Object[] toArray() {
    return o();
  }
  
  public <T> T[] toArray(T[] paramArrayOfT) {
    return (T[])a((Object[])paramArrayOfT);
  }
  
  public String toString() {
    return f().toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\DescendingMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */