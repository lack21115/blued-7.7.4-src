package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Collection;
import java.util.Queue;

public final class EvictingQueue<E> extends ForwardingQueue<E> implements Serializable {
  final int a;
  
  private final Queue<E> b;
  
  protected Queue<E> a() {
    return this.b;
  }
  
  public boolean add(E paramE) {
    Preconditions.a(paramE);
    if (this.a == 0)
      return true; 
    if (size() == this.a)
      this.b.remove(); 
    this.b.add(paramE);
    return true;
  }
  
  public boolean addAll(Collection<? extends E> paramCollection) {
    int i = paramCollection.size();
    if (i >= this.a) {
      clear();
      return Iterables.a(this, Iterables.a(paramCollection, i - this.a));
    } 
    return b(paramCollection);
  }
  
  public boolean contains(Object paramObject) {
    return a().contains(Preconditions.a(paramObject));
  }
  
  public boolean offer(E paramE) {
    return add(paramE);
  }
  
  public boolean remove(Object paramObject) {
    return a().remove(Preconditions.a(paramObject));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\EvictingQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */