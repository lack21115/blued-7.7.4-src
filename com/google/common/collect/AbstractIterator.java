package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class AbstractIterator<T> extends UnmodifiableIterator<T> {
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
  
  enum State {
    a, b, c, d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\AbstractIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */