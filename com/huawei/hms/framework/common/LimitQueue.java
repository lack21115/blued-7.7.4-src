package com.huawei.hms.framework.common;

import java.util.Collection;
import java.util.LinkedList;

public class LimitQueue<E> extends LinkedList<E> {
  private static final long serialVersionUID = -4636313759149307798L;
  
  private boolean deduplication = false;
  
  private int limit;
  
  private final Object lock = new Object();
  
  public LimitQueue(int paramInt) {
    this.limit = paramInt;
  }
  
  public LimitQueue(int paramInt, boolean paramBoolean) {
    this.limit = paramInt;
    this.deduplication = paramBoolean;
  }
  
  public LimitQueue(Collection<? extends E> paramCollection, boolean paramBoolean) {
    this(paramCollection.size(), paramBoolean);
    addAll(paramCollection);
  }
  
  public boolean add(E paramE) {
    synchronized (this.lock) {
      if (this.deduplication)
        super.remove(paramE); 
      if (size() >= this.limit)
        super.poll(); 
      return super.add(paramE);
    } 
  }
  
  public boolean addAll(Collection<? extends E> paramCollection) {
    if (paramCollection.size() > this.limit)
      return false; 
    if (this.deduplication)
      removeAll(paramCollection); 
    for (int i = paramCollection.size() + size() - this.limit; i > 0; i--)
      super.poll(); 
    return super.addAll(paramCollection);
  }
  
  public void clear() {
    synchronized (this.lock) {
      super.clear();
      return;
    } 
  }
  
  public int getLimit() {
    return this.limit;
  }
  
  public boolean offer(E paramE) {
    synchronized (this.lock) {
      if (this.deduplication)
        super.remove(paramE); 
      if (size() >= this.limit)
        super.poll(); 
      return super.offer(paramE);
    } 
  }
  
  public E peekLast() {
    synchronized (this.lock) {
      return super.peekLast();
    } 
  }
  
  public E poll() {
    synchronized (this.lock) {
      return super.poll();
    } 
  }
  
  public E remove() {
    synchronized (this.lock) {
      return super.remove();
    } 
  }
  
  public E remove(int paramInt) {
    synchronized (this.lock) {
      return super.remove(paramInt);
    } 
  }
  
  public boolean remove(Object paramObject) {
    synchronized (this.lock) {
      return super.remove(paramObject);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\common\LimitQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */