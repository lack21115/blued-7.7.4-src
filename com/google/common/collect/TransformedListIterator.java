package com.google.common.collect;

import java.util.ListIterator;

abstract class TransformedListIterator<F, T> extends TransformedIterator<F, T> implements ListIterator<T> {
  TransformedListIterator(ListIterator<? extends F> paramListIterator) {
    super(paramListIterator);
  }
  
  private ListIterator<? extends F> a() {
    return Iterators.j(this.c);
  }
  
  public void add(T paramT) {
    throw new UnsupportedOperationException();
  }
  
  public final boolean hasPrevious() {
    return a().hasPrevious();
  }
  
  public final int nextIndex() {
    return a().nextIndex();
  }
  
  public final T previous() {
    return a(a().previous());
  }
  
  public final int previousIndex() {
    return a().previousIndex();
  }
  
  public void set(T paramT) {
    throw new UnsupportedOperationException();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\TransformedListIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */