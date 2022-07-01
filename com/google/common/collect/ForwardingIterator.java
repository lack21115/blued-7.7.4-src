package com.google.common.collect;

import java.util.Iterator;

public abstract class ForwardingIterator<T> extends ForwardingObject implements Iterator<T> {
  protected abstract Iterator<T> a();
  
  public boolean hasNext() {
    return a().hasNext();
  }
  
  public T next() {
    return a().next();
  }
  
  public void remove() {
    a().remove();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ForwardingIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */