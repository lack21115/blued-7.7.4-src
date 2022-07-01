package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Iterator;

abstract class TransformedIterator<F, T> implements Iterator<T> {
  final Iterator<? extends F> c;
  
  TransformedIterator(Iterator<? extends F> paramIterator) {
    this.c = (Iterator<? extends F>)Preconditions.a(paramIterator);
  }
  
  abstract T a(F paramF);
  
  public final boolean hasNext() {
    return this.c.hasNext();
  }
  
  public final T next() {
    return a(this.c.next());
  }
  
  public final void remove() {
    this.c.remove();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\TransformedIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */