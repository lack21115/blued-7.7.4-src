package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class AbstractSortedMultiset<E> extends AbstractMultiset<E> implements SortedMultiset<E> {
  @GwtTransient
  final Comparator<? super E> a;
  
  @NullableDecl
  private transient SortedMultiset<E> b;
  
  AbstractSortedMultiset() {
    this(Ordering.d());
  }
  
  AbstractSortedMultiset(Comparator<? super E> paramComparator) {
    this.a = (Comparator<? super E>)Preconditions.a(paramComparator);
  }
  
  public SortedMultiset<E> a(@NullableDecl E paramE1, BoundType paramBoundType1, @NullableDecl E paramE2, BoundType paramBoundType2) {
    Preconditions.a(paramBoundType1);
    Preconditions.a(paramBoundType2);
    return c(paramE1, paramBoundType1).d(paramE2, paramBoundType2);
  }
  
  public NavigableSet<E> au_() {
    return (NavigableSet<E>)super.d();
  }
  
  public Comparator<? super E> comparator() {
    return this.a;
  }
  
  NavigableSet<E> i() {
    return new SortedMultisets.NavigableElementSet<E>(this);
  }
  
  public Multiset.Entry<E> j() {
    Iterator<Multiset.Entry<E>> iterator = b();
    return iterator.hasNext() ? iterator.next() : null;
  }
  
  public Multiset.Entry<E> k() {
    Iterator<Multiset.Entry<E>> iterator = n();
    return iterator.hasNext() ? iterator.next() : null;
  }
  
  public Multiset.Entry<E> l() {
    Iterator<Multiset.Entry<E>> iterator = b();
    if (iterator.hasNext()) {
      Multiset.Entry<?> entry = iterator.next();
      entry = Multisets.a(entry.c(), entry.b());
      iterator.remove();
      return (Multiset.Entry)entry;
    } 
    return null;
  }
  
  public Multiset.Entry<E> m() {
    Iterator<Multiset.Entry<E>> iterator = n();
    if (iterator.hasNext()) {
      Multiset.Entry<?> entry = iterator.next();
      entry = Multisets.a(entry.c(), entry.b());
      iterator.remove();
      return (Multiset.Entry)entry;
    } 
    return null;
  }
  
  abstract Iterator<Multiset.Entry<E>> n();
  
  Iterator<E> o() {
    return Multisets.a(p());
  }
  
  public SortedMultiset<E> p() {
    SortedMultiset<E> sortedMultiset2 = this.b;
    SortedMultiset<E> sortedMultiset1 = sortedMultiset2;
    if (sortedMultiset2 == null) {
      sortedMultiset1 = q();
      this.b = sortedMultiset1;
    } 
    return sortedMultiset1;
  }
  
  SortedMultiset<E> q() {
    class DescendingMultisetImpl extends DescendingMultiset<E> {
      DescendingMultisetImpl(AbstractSortedMultiset this$0) {}
      
      SortedMultiset<E> a() {
        return this.a;
      }
      
      Iterator<Multiset.Entry<E>> e() {
        return this.a.n();
      }
      
      public Iterator<E> iterator() {
        return this.a.o();
      }
    };
    return new DescendingMultisetImpl(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\AbstractSortedMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */