package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

public abstract class ForwardingNavigableSet<E> extends ForwardingSortedSet<E> implements NavigableSet<E> {
  protected SortedSet<E> a(E paramE) {
    return headSet(paramE, false);
  }
  
  protected SortedSet<E> a(E paramE1, E paramE2) {
    return subSet(paramE1, true, paramE2, false);
  }
  
  protected SortedSet<E> b(E paramE) {
    return tailSet(paramE, true);
  }
  
  public E ceiling(E paramE) {
    return d().ceiling(paramE);
  }
  
  protected abstract NavigableSet<E> d();
  
  public Iterator<E> descendingIterator() {
    return d().descendingIterator();
  }
  
  public NavigableSet<E> descendingSet() {
    return d().descendingSet();
  }
  
  public E floor(E paramE) {
    return d().floor(paramE);
  }
  
  public NavigableSet<E> headSet(E paramE, boolean paramBoolean) {
    return d().headSet(paramE, paramBoolean);
  }
  
  public E higher(E paramE) {
    return d().higher(paramE);
  }
  
  public E lower(E paramE) {
    return d().lower(paramE);
  }
  
  public E pollFirst() {
    return d().pollFirst();
  }
  
  public E pollLast() {
    return d().pollLast();
  }
  
  public NavigableSet<E> subSet(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2) {
    return d().subSet(paramE1, paramBoolean1, paramE2, paramBoolean2);
  }
  
  public NavigableSet<E> tailSet(E paramE, boolean paramBoolean) {
    return d().tailSet(paramE, paramBoolean);
  }
  
  public class StandardDescendingSet extends Sets.DescendingSet<E> {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ForwardingNavigableSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */