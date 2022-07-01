package com.alibaba.mtl.appmonitor.c;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

public class c<T extends b> {
  private static AtomicLong c = new AtomicLong(0L);
  
  private static AtomicLong d = new AtomicLong(0L);
  
  private ConcurrentLinkedQueue<T> a;
  
  private AtomicLong a = new AtomicLong(0L);
  
  private Integer b;
  
  private Set<Integer> b;
  
  private AtomicLong b = null;
  
  private final int m = 20;
  
  public c() {
    this.b = new AtomicLong(0L);
    this.a = (AtomicLong)new ConcurrentLinkedQueue();
    this.b = (AtomicLong)new HashSet();
  }
  
  public T a() {
    c.getAndIncrement();
    this.a.getAndIncrement();
    b b = this.a.poll();
    if (b != null) {
      this.b.remove(Integer.valueOf(System.identityHashCode(b)));
      this.b.getAndIncrement();
      d.getAndIncrement();
    } 
    return (T)b;
  }
  
  public void a(T paramT) {
    paramT.clean();
    if (this.a.size() < 20)
      synchronized (this.b) {
        int i = System.identityHashCode(paramT);
        if (!this.b.contains(Integer.valueOf(i))) {
          this.b.add(Integer.valueOf(i));
          this.a.offer(paramT);
        } 
        return;
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */