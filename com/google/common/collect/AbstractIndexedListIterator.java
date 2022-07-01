package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.NoSuchElementException;

abstract class AbstractIndexedListIterator<E> extends UnmodifiableListIterator<E> {
  private final int a;
  
  private int b;
  
  protected AbstractIndexedListIterator(int paramInt) {
    this(paramInt, 0);
  }
  
  protected AbstractIndexedListIterator(int paramInt1, int paramInt2) {
    Preconditions.b(paramInt2, paramInt1);
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  protected abstract E a(int paramInt);
  
  public final boolean hasNext() {
    return (this.b < this.a);
  }
  
  public final boolean hasPrevious() {
    return (this.b > 0);
  }
  
  public final E next() {
    if (hasNext()) {
      int i = this.b;
      this.b = i + 1;
      return a(i);
    } 
    throw new NoSuchElementException();
  }
  
  public final int nextIndex() {
    return this.b;
  }
  
  public final E previous() {
    if (hasPrevious()) {
      int i = this.b - 1;
      this.b = i;
      return a(i);
    } 
    throw new NoSuchElementException();
  }
  
  public final int previousIndex() {
    return this.b - 1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\AbstractIndexedListIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */