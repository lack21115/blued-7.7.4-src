package com.google.common.collect;

import java.util.Collection;
import java.util.Queue;

public abstract class ForwardingQueue<E> extends ForwardingCollection<E> implements Queue<E> {
  protected abstract Queue<E> a();
  
  public E element() {
    return a().element();
  }
  
  public boolean offer(E paramE) {
    return a().offer(paramE);
  }
  
  public E peek() {
    return a().peek();
  }
  
  public E poll() {
    return a().poll();
  }
  
  public E remove() {
    return a().remove();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ForwardingQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */