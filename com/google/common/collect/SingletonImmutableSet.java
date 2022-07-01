package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.Iterator;

final class SingletonImmutableSet<E> extends ImmutableSet<E> {
  final transient E a;
  
  @LazyInit
  private transient int b;
  
  SingletonImmutableSet(E paramE) {
    this.a = (E)Preconditions.a(paramE);
  }
  
  SingletonImmutableSet(E paramE, int paramInt) {
    this.a = paramE;
    this.b = paramInt;
  }
  
  int a(Object[] paramArrayOfObject, int paramInt) {
    paramArrayOfObject[paramInt] = this.a;
    return paramInt + 1;
  }
  
  boolean a() {
    return false;
  }
  
  public UnmodifiableIterator<E> av_() {
    return Iterators.a(this.a);
  }
  
  public boolean contains(Object paramObject) {
    return this.a.equals(paramObject);
  }
  
  ImmutableList<E> d() {
    return ImmutableList.a(this.a);
  }
  
  public final int hashCode() {
    int j = this.b;
    int i = j;
    if (j == 0) {
      i = this.a.hashCode();
      this.b = i;
    } 
    return i;
  }
  
  boolean i() {
    return (this.b != 0);
  }
  
  public int size() {
    return 1;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append('[');
    stringBuilder.append(this.a.toString());
    stringBuilder.append(']');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\SingletonImmutableSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */