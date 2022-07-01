package com.google.common.base;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class AbstractIterator<T> implements Iterator<T> {
  private State a = State.b;
  
  @NullableDecl
  private T b;
  
  private boolean c() {
    this.a = State.d;
    this.b = a();
    if (this.a != State.c) {
      this.a = State.a;
      return true;
    } 
    return false;
  }
  
  protected abstract T a();
  
  @NullableDecl
  protected final T b() {
    this.a = State.c;
    return null;
  }
  
  public final boolean hasNext() {
    boolean bool;
    if (this.a != State.d) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.b(bool);
    int i = null.a[this.a.ordinal()];
    return (i != 1) ? ((i != 2) ? c() : true) : false;
  }
  
  public final T next() {
    if (hasNext()) {
      this.a = State.b;
      T t = this.b;
      this.b = null;
      return t;
    } 
    throw new NoSuchElementException();
  }
  
  public final void remove() {
    throw new UnsupportedOperationException();
  }
  
  enum State {
    a, b, c, d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\base\AbstractIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */