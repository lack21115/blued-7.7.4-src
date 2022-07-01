package com.google.common.collect;

import java.io.Serializable;

abstract class ImmutableAsList<E> extends ImmutableList<E> {
  boolean a() {
    return c().a();
  }
  
  abstract ImmutableCollection<E> c();
  
  public boolean contains(Object paramObject) {
    return c().contains(paramObject);
  }
  
  public boolean isEmpty() {
    return c().isEmpty();
  }
  
  public int size() {
    return c().size();
  }
  
  static class SerializedForm implements Serializable {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ImmutableAsList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */