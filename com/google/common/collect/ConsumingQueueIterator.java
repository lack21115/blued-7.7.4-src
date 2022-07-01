package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Queue;

class ConsumingQueueIterator<T> extends AbstractIterator<T> {
  private final Queue<T> a;
  
  ConsumingQueueIterator(Queue<T> paramQueue) {
    this.a = (Queue<T>)Preconditions.a(paramQueue);
  }
  
  public T a() {
    return this.a.isEmpty() ? b() : this.a.remove();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ConsumingQueueIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */