package com.google.common.collect;

import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class AbstractSequentialIterator<T> extends UnmodifiableIterator<T> {
  @NullableDecl
  private T a;
  
  public AbstractSequentialIterator(@NullableDecl T paramT) {
    this.a = paramT;
  }
  
  @NullableDecl
  protected abstract T a(T paramT);
  
  public final boolean hasNext() {
    return (this.a != null);
  }
  
  public final T next() {
    if (hasNext())
      try {
        return this.a;
      } finally {
        this.a = a(this.a);
      }  
    throw new NoSuchElementException();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\AbstractSequentialIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */