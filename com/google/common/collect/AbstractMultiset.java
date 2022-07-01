package com.google.common.collect;

import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class AbstractMultiset<E> extends AbstractCollection<E> implements Multiset<E> {
  @LazyInit
  @NullableDecl
  private transient Set<E> a;
  
  @LazyInit
  @NullableDecl
  private transient Set<Multiset.Entry<E>> b;
  
  public int a(@NullableDecl E paramE, int paramInt) {
    throw new UnsupportedOperationException();
  }
  
  abstract Iterator<E> a();
  
  public boolean a(@NullableDecl E paramE, int paramInt1, int paramInt2) {
    return Multisets.a(this, paramE, paramInt1, paramInt2);
  }
  
  public final boolean add(@NullableDecl E paramE) {
    a(paramE, 1);
    return true;
  }
  
  public final boolean addAll(Collection<? extends E> paramCollection) {
    return Multisets.a(this, paramCollection);
  }
  
  public int b(@NullableDecl Object paramObject, int paramInt) {
    throw new UnsupportedOperationException();
  }
  
  abstract Iterator<Multiset.Entry<E>> b();
  
  abstract int c();
  
  public int c(@NullableDecl E paramE, int paramInt) {
    return Multisets.a(this, paramE, paramInt);
  }
  
  public boolean contains(@NullableDecl Object paramObject) {
    return (a(paramObject) > 0);
  }
  
  public Set<E> d() {
    Set<E> set2 = this.a;
    Set<E> set1 = set2;
    if (set2 == null) {
      set1 = e();
      this.a = set1;
    } 
    return set1;
  }
  
  Set<E> e() {
    return new ElementSet(this);
  }
  
  public final boolean equals(@NullableDecl Object paramObject) {
    return Multisets.a(this, paramObject);
  }
  
  public Set<Multiset.Entry<E>> f() {
    Set<Multiset.Entry<E>> set2 = this.b;
    Set<Multiset.Entry<E>> set1 = set2;
    if (set2 == null) {
      set1 = g();
      this.b = set1;
    } 
    return set1;
  }
  
  Set<Multiset.Entry<E>> g() {
    return new EntrySet(this);
  }
  
  public final int hashCode() {
    return f().hashCode();
  }
  
  public boolean isEmpty() {
    return f().isEmpty();
  }
  
  public final boolean remove(@NullableDecl Object paramObject) {
    return (b(paramObject, 1) > 0);
  }
  
  public final boolean removeAll(Collection<?> paramCollection) {
    return Multisets.b(this, paramCollection);
  }
  
  public final boolean retainAll(Collection<?> paramCollection) {
    return Multisets.c(this, paramCollection);
  }
  
  public final String toString() {
    return f().toString();
  }
  
  class ElementSet extends Multisets.ElementSet<E> {
    ElementSet(AbstractMultiset this$0) {}
    
    Multiset<E> a() {
      return this.a;
    }
    
    public Iterator<E> iterator() {
      return this.a.a();
    }
  }
  
  class EntrySet extends Multisets.EntrySet<E> {
    EntrySet(AbstractMultiset this$0) {}
    
    Multiset<E> a() {
      return this.a;
    }
    
    public Iterator<Multiset.Entry<E>> iterator() {
      return this.a.b();
    }
    
    public int size() {
      return this.a.c();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\AbstractMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */