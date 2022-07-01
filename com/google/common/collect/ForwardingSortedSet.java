package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;

public abstract class ForwardingSortedSet<E> extends ForwardingSet<E> implements SortedSet<E> {
  protected SortedSet<E> a(E paramE1, E paramE2) {
    return tailSet(paramE1).headSet(paramE2);
  }
  
  public Comparator<? super E> comparator() {
    return e().comparator();
  }
  
  protected abstract SortedSet<E> e();
  
  public E first() {
    return e().first();
  }
  
  public SortedSet<E> headSet(E paramE) {
    return e().headSet(paramE);
  }
  
  public E last() {
    return e().last();
  }
  
  public SortedSet<E> subSet(E paramE1, E paramE2) {
    return e().subSet(paramE1, paramE2);
  }
  
  public SortedSet<E> tailSet(E paramE) {
    return e().tailSet(paramE);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ForwardingSortedSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */