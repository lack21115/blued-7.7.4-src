package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public interface Multiset<E> extends Collection<E> {
  int a(@NullableDecl Object paramObject);
  
  int a(@NullableDecl E paramE, int paramInt);
  
  boolean a(E paramE, int paramInt1, int paramInt2);
  
  int b(@NullableDecl Object paramObject, int paramInt);
  
  int c(E paramE, int paramInt);
  
  boolean contains(@NullableDecl Object paramObject);
  
  boolean containsAll(Collection<?> paramCollection);
  
  Set<E> d();
  
  boolean equals(@NullableDecl Object paramObject);
  
  Set<Entry<E>> f();
  
  int hashCode();
  
  Iterator<E> iterator();
  
  boolean remove(@NullableDecl Object paramObject);
  
  int size();
  
  public static interface Entry<E> {
    int b();
    
    E c();
    
    String toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\Multiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */