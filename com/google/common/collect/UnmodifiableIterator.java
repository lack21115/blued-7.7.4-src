package com.google.common.collect;

import java.util.Iterator;

public abstract class UnmodifiableIterator<E> implements Iterator<E> {
  @Deprecated
  public final void remove() {
    throw new UnsupportedOperationException();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\UnmodifiableIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */