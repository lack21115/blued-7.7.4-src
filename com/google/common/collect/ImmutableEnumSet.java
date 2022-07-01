package com.google.common.collect;

import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;

final class ImmutableEnumSet<E extends Enum<E>> extends ImmutableSet<E> {
  private final transient EnumSet<E> a;
  
  @LazyInit
  private transient int b;
  
  boolean a() {
    return false;
  }
  
  public UnmodifiableIterator<E> av_() {
    return Iterators.a(this.a.iterator());
  }
  
  public boolean contains(Object paramObject) {
    return this.a.contains(paramObject);
  }
  
  public boolean containsAll(Collection<?> paramCollection) {
    Collection<?> collection = paramCollection;
    if (paramCollection instanceof ImmutableEnumSet)
      collection = ((ImmutableEnumSet)paramCollection).a; 
    return this.a.containsAll(collection);
  }
  
  public boolean equals(Object<E> paramObject) {
    if (paramObject == this)
      return true; 
    Object<E> object = paramObject;
    if (paramObject instanceof ImmutableEnumSet)
      object = (Object<E>)((ImmutableEnumSet)paramObject).a; 
    return this.a.equals(object);
  }
  
  public int hashCode() {
    int j = this.b;
    int i = j;
    if (j == 0) {
      i = this.a.hashCode();
      this.b = i;
    } 
    return i;
  }
  
  boolean i() {
    return true;
  }
  
  public boolean isEmpty() {
    return this.a.isEmpty();
  }
  
  public int size() {
    return this.a.size();
  }
  
  public String toString() {
    return this.a.toString();
  }
  
  static class EnumSerializedForm<E extends Enum<E>> implements Serializable {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ImmutableEnumSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */