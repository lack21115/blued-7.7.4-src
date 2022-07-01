package com.google.common.collect;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class ForwardingList<E> extends ForwardingCollection<E> implements List<E> {
  protected abstract List<E> a();
  
  public void add(int paramInt, E paramE) {
    a().add(paramInt, paramE);
  }
  
  public boolean addAll(int paramInt, Collection<? extends E> paramCollection) {
    return a().addAll(paramInt, paramCollection);
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    return (paramObject == this || a().equals(paramObject));
  }
  
  public E get(int paramInt) {
    return a().get(paramInt);
  }
  
  public int hashCode() {
    return a().hashCode();
  }
  
  public int indexOf(Object paramObject) {
    return a().indexOf(paramObject);
  }
  
  public int lastIndexOf(Object paramObject) {
    return a().lastIndexOf(paramObject);
  }
  
  public ListIterator<E> listIterator() {
    return a().listIterator();
  }
  
  public ListIterator<E> listIterator(int paramInt) {
    return a().listIterator(paramInt);
  }
  
  public E remove(int paramInt) {
    return a().remove(paramInt);
  }
  
  public E set(int paramInt, E paramE) {
    return a().set(paramInt, paramE);
  }
  
  public List<E> subList(int paramInt1, int paramInt2) {
    return a().subList(paramInt1, paramInt2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ForwardingList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */