package com.blued.android.core.net.deque;

public class LIFOLinkedBlockingDeque<T> extends LinkedBlockingDeque<T> {
  public boolean offer(T paramT) {
    return b((E)paramT);
  }
  
  public T remove() {
    return (T)a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\net\deque\LIFOLinkedBlockingDeque.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */