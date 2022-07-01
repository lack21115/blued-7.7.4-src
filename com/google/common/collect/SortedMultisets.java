package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class SortedMultisets {
  private static <E> E c(Multiset.Entry<E> paramEntry) {
    if (paramEntry != null)
      return paramEntry.c(); 
    throw new NoSuchElementException();
  }
  
  private static <E> E d(@NullableDecl Multiset.Entry<E> paramEntry) {
    return (paramEntry == null) ? null : paramEntry.c();
  }
  
  static class ElementSet<E> extends Multisets.ElementSet<E> implements SortedSet<E> {
    private final SortedMultiset<E> a;
    
    ElementSet(SortedMultiset<E> param1SortedMultiset) {
      this.a = param1SortedMultiset;
    }
    
    final SortedMultiset<E> b() {
      return this.a;
    }
    
    public Comparator<? super E> comparator() {
      return b().comparator();
    }
    
    public E first() {
      return (E)SortedMultisets.a(b().j());
    }
    
    public SortedSet<E> headSet(E param1E) {
      return b().d(param1E, BoundType.a).au_();
    }
    
    public Iterator<E> iterator() {
      return Multisets.a(b().f().iterator());
    }
    
    public E last() {
      return (E)SortedMultisets.a(b().k());
    }
    
    public SortedSet<E> subSet(E param1E1, E param1E2) {
      return b().a(param1E1, BoundType.b, param1E2, BoundType.a).au_();
    }
    
    public SortedSet<E> tailSet(E param1E) {
      return b().c(param1E, BoundType.b).au_();
    }
  }
  
  static class NavigableElementSet<E> extends ElementSet<E> implements NavigableSet<E> {
    NavigableElementSet(SortedMultiset<E> param1SortedMultiset) {
      super(param1SortedMultiset);
    }
    
    public E ceiling(E param1E) {
      return (E)SortedMultisets.b(b().c(param1E, BoundType.b).j());
    }
    
    public Iterator<E> descendingIterator() {
      return descendingSet().iterator();
    }
    
    public NavigableSet<E> descendingSet() {
      return new NavigableElementSet(b().p());
    }
    
    public E floor(E param1E) {
      return (E)SortedMultisets.b(b().d(param1E, BoundType.b).k());
    }
    
    public NavigableSet<E> headSet(E param1E, boolean param1Boolean) {
      return new NavigableElementSet(b().d(param1E, BoundType.a(param1Boolean)));
    }
    
    public E higher(E param1E) {
      return (E)SortedMultisets.b(b().c(param1E, BoundType.a).j());
    }
    
    public E lower(E param1E) {
      return (E)SortedMultisets.b(b().d(param1E, BoundType.a).k());
    }
    
    public E pollFirst() {
      return (E)SortedMultisets.b(b().l());
    }
    
    public E pollLast() {
      return (E)SortedMultisets.b(b().m());
    }
    
    public NavigableSet<E> subSet(E param1E1, boolean param1Boolean1, E param1E2, boolean param1Boolean2) {
      return new NavigableElementSet(b().a(param1E1, BoundType.a(param1Boolean1), param1E2, BoundType.a(param1Boolean2)));
    }
    
    public NavigableSet<E> tailSet(E param1E, boolean param1Boolean) {
      return new NavigableElementSet(b().c(param1E, BoundType.a(param1Boolean)));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\SortedMultisets.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */