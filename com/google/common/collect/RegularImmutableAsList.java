package com.google.common.collect;

import java.util.ListIterator;

class RegularImmutableAsList<E> extends ImmutableAsList<E> {
  private final ImmutableCollection<E> a;
  
  private final ImmutableList<? extends E> b;
  
  int a(Object[] paramArrayOfObject, int paramInt) {
    return this.b.a(paramArrayOfObject, paramInt);
  }
  
  public UnmodifiableListIterator<E> a(int paramInt) {
    return (UnmodifiableListIterator)this.b.a(paramInt);
  }
  
  ImmutableCollection<E> c() {
    return this.a;
  }
  
  public E get(int paramInt) {
    return this.b.get(paramInt);
  }
  
  Object[] n() {
    return this.b.n();
  }
  
  int o() {
    return this.b.o();
  }
  
  int q() {
    return this.b.q();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\RegularImmutableAsList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */