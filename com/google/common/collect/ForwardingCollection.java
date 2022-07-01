package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

public abstract class ForwardingCollection<E> extends ForwardingObject implements Collection<E> {
  protected boolean a(Collection<?> paramCollection) {
    return Collections2.a(this, paramCollection);
  }
  
  protected <T> T[] a(T[] paramArrayOfT) {
    return ObjectArrays.a(this, paramArrayOfT);
  }
  
  public boolean add(E paramE) {
    return c().add(paramE);
  }
  
  public boolean addAll(Collection<? extends E> paramCollection) {
    return c().addAll(paramCollection);
  }
  
  protected boolean b(Collection<? extends E> paramCollection) {
    return Iterators.a(this, paramCollection.iterator());
  }
  
  protected abstract Collection<E> c();
  
  protected boolean c(Collection<?> paramCollection) {
    return Iterators.a(iterator(), paramCollection);
  }
  
  public void clear() {
    c().clear();
  }
  
  public boolean contains(Object paramObject) {
    return c().contains(paramObject);
  }
  
  public boolean containsAll(Collection<?> paramCollection) {
    return c().containsAll(paramCollection);
  }
  
  protected boolean d(Collection<?> paramCollection) {
    return Iterators.b(iterator(), paramCollection);
  }
  
  public boolean isEmpty() {
    return c().isEmpty();
  }
  
  public Iterator<E> iterator() {
    return c().iterator();
  }
  
  protected String n() {
    return Collections2.a(this);
  }
  
  protected Object[] o() {
    return toArray(new Object[size()]);
  }
  
  public boolean remove(Object paramObject) {
    return c().remove(paramObject);
  }
  
  public boolean removeAll(Collection<?> paramCollection) {
    return c().removeAll(paramCollection);
  }
  
  public boolean retainAll(Collection<?> paramCollection) {
    return c().retainAll(paramCollection);
  }
  
  public int size() {
    return c().size();
  }
  
  public Object[] toArray() {
    return c().toArray();
  }
  
  public <T> T[] toArray(T[] paramArrayOfT) {
    return c().toArray(paramArrayOfT);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ForwardingCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */