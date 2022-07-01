package com.google.common.collect;

import com.google.common.base.Preconditions;

class RegularImmutableList<E> extends ImmutableList<E> {
  static final ImmutableList<Object> a = new RegularImmutableList(new Object[0], 0);
  
  final transient Object[] b;
  
  private final transient int c;
  
  RegularImmutableList(Object[] paramArrayOfObject, int paramInt) {
    this.b = paramArrayOfObject;
    this.c = paramInt;
  }
  
  int a(Object[] paramArrayOfObject, int paramInt) {
    System.arraycopy(this.b, 0, paramArrayOfObject, paramInt, this.c);
    return paramInt + this.c;
  }
  
  boolean a() {
    return false;
  }
  
  public E get(int paramInt) {
    Preconditions.a(paramInt, this.c);
    return (E)this.b[paramInt];
  }
  
  Object[] n() {
    return this.b;
  }
  
  int o() {
    return 0;
  }
  
  int q() {
    return this.c;
  }
  
  public int size() {
    return this.c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\RegularImmutableList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */