package com.google.protobuf;

import java.util.AbstractList;
import java.util.Collection;

abstract class AbstractProtobufList<E> extends AbstractList<E> implements Internal.ProtobufList<E> {
  protected static final int DEFAULT_CAPACITY = 10;
  
  private boolean isMutable = true;
  
  public void add(int paramInt, E paramE) {
    ensureIsMutable();
    super.add(paramInt, paramE);
  }
  
  public boolean add(E paramE) {
    ensureIsMutable();
    return super.add(paramE);
  }
  
  public boolean addAll(int paramInt, Collection<? extends E> paramCollection) {
    ensureIsMutable();
    return super.addAll(paramInt, paramCollection);
  }
  
  public boolean addAll(Collection<? extends E> paramCollection) {
    ensureIsMutable();
    return super.addAll(paramCollection);
  }
  
  public void clear() {
    ensureIsMutable();
    super.clear();
  }
  
  protected void ensureIsMutable() {
    if (this.isMutable)
      return; 
    throw new UnsupportedOperationException();
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof java.util.List))
      return false; 
    if (!(paramObject instanceof java.util.RandomAccess))
      return super.equals(paramObject); 
    paramObject = paramObject;
    int j = size();
    if (j != paramObject.size())
      return false; 
    for (int i = 0; i < j; i++) {
      if (!get(i).equals(paramObject.get(i)))
        return false; 
    } 
    return true;
  }
  
  public int hashCode() {
    int k = size();
    int j = 1;
    for (int i = 0; i < k; i++)
      j = j * 31 + get(i).hashCode(); 
    return j;
  }
  
  public boolean isModifiable() {
    return this.isMutable;
  }
  
  public final void makeImmutable() {
    this.isMutable = false;
  }
  
  public E remove(int paramInt) {
    ensureIsMutable();
    return super.remove(paramInt);
  }
  
  public boolean remove(Object paramObject) {
    ensureIsMutable();
    return super.remove(paramObject);
  }
  
  public boolean removeAll(Collection<?> paramCollection) {
    ensureIsMutable();
    return super.removeAll(paramCollection);
  }
  
  public boolean retainAll(Collection<?> paramCollection) {
    ensureIsMutable();
    return super.retainAll(paramCollection);
  }
  
  public E set(int paramInt, E paramE) {
    ensureIsMutable();
    return super.set(paramInt, paramE);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\AbstractProtobufList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */