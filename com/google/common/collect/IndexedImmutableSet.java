package com.google.common.collect;

import java.util.Iterator;

abstract class IndexedImmutableSet<E> extends ImmutableSet<E> {
  int a(Object[] paramArrayOfObject, int paramInt) {
    return h().a(paramArrayOfObject, paramInt);
  }
  
  abstract E a(int paramInt);
  
  public UnmodifiableIterator<E> av_() {
    return h().av_();
  }
  
  ImmutableList<E> d() {
    return new ImmutableList<E>(this) {
        boolean a() {
          return this.a.a();
        }
        
        public E get(int param1Int) {
          return this.a.a(param1Int);
        }
        
        public int size() {
          return this.a.size();
        }
      };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\IndexedImmutableSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */