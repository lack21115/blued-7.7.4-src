package com.google.common.collect;

import java.util.ArrayDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class Queues {
  public static <E> ArrayDeque<E> a() {
    return new ArrayDeque<E>();
  }
  
  public static <E> ConcurrentLinkedQueue<E> b() {
    return new ConcurrentLinkedQueue<E>();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\Queues.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */