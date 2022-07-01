package com.google.common.collect;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;

public interface SortedMultiset<E> extends SortedIterable<E>, SortedMultisetBridge<E> {
  SortedMultiset<E> a(E paramE1, BoundType paramBoundType1, E paramE2, BoundType paramBoundType2);
  
  NavigableSet<E> au_();
  
  SortedMultiset<E> c(E paramE, BoundType paramBoundType);
  
  Comparator<? super E> comparator();
  
  SortedMultiset<E> d(E paramE, BoundType paramBoundType);
  
  Set<Multiset.Entry<E>> f();
  
  Multiset.Entry<E> j();
  
  Multiset.Entry<E> k();
  
  Multiset.Entry<E> l();
  
  Multiset.Entry<E> m();
  
  SortedMultiset<E> p();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\SortedMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */