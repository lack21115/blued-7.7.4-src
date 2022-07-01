package com.google.common.collect;

import java.util.ListIterator;

public abstract class UnmodifiableListIterator<E> extends UnmodifiableIterator<E> implements ListIterator<E> {
  @Deprecated
  public final void add(E paramE) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final void set(E paramE) {
    throw new UnsupportedOperationException();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\UnmodifiableListIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */