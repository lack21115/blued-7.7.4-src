package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class AbstractMapBasedMultiset<E> extends AbstractMultiset<E> implements Serializable {
  transient ObjectCountHashMap<E> a;
  
  transient long b;
  
  AbstractMapBasedMultiset(int paramInt) {
    a(paramInt);
  }
  
  public final int a(@NullableDecl Object paramObject) {
    return this.a.b(paramObject);
  }
  
  public final int a(@NullableDecl E paramE, int paramInt) {
    boolean bool1;
    if (paramInt == 0)
      return a(paramE); 
    boolean bool2 = true;
    if (paramInt > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    Preconditions.a(bool1, "occurrences cannot be negative: %s", paramInt);
    int i = this.a.a(paramE);
    if (i == -1) {
      this.a.a(paramE, paramInt);
      this.b += paramInt;
      return 0;
    } 
    int j = this.a.d(i);
    long l2 = j;
    long l1 = paramInt;
    l2 += l1;
    if (l2 <= 2147483647L) {
      bool1 = bool2;
    } else {
      bool1 = false;
    } 
    Preconditions.a(bool1, "too many occurrences: %s", l2);
    this.a.b(i, (int)l2);
    this.b += l1;
    return j;
  }
  
  final Iterator<E> a() {
    return new Itr<E>(this) {
        E a(int param1Int) {
          return this.a.a.c(param1Int);
        }
      };
  }
  
  abstract void a(int paramInt);
  
  void a(Multiset<? super E> paramMultiset) {
    Preconditions.a(paramMultiset);
    for (int i = this.a.b(); i >= 0; i = this.a.b(i))
      paramMultiset.a(this.a.c(i), this.a.d(i)); 
  }
  
  public final boolean a(@NullableDecl E paramE, int paramInt1, int paramInt2) {
    CollectPreconditions.a(paramInt1, "oldCount");
    CollectPreconditions.a(paramInt2, "newCount");
    int i = this.a.a(paramE);
    if (i == -1) {
      if (paramInt1 != 0)
        return false; 
      if (paramInt2 > 0) {
        this.a.a(paramE, paramInt2);
        this.b += paramInt2;
      } 
      return true;
    } 
    if (this.a.d(i) != paramInt1)
      return false; 
    if (paramInt2 == 0) {
      this.a.h(i);
      this.b -= paramInt1;
      return true;
    } 
    this.a.b(i, paramInt2);
    this.b += (paramInt2 - paramInt1);
    return true;
  }
  
  public final int b(@NullableDecl Object paramObject, int paramInt) {
    boolean bool;
    if (paramInt == 0)
      return a(paramObject); 
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool, "occurrences cannot be negative: %s", paramInt);
    int j = this.a.a(paramObject);
    if (j == -1)
      return 0; 
    int i = this.a.d(j);
    if (i > paramInt) {
      this.a.b(j, i - paramInt);
    } else {
      this.a.h(j);
      paramInt = i;
    } 
    this.b -= paramInt;
    return i;
  }
  
  final Iterator<Multiset.Entry<E>> b() {
    return new Itr<Multiset.Entry<E>>(this) {
        Multiset.Entry<E> b(int param1Int) {
          return this.a.a.e(param1Int);
        }
      };
  }
  
  final int c() {
    return this.a.c();
  }
  
  public final int c(@NullableDecl E paramE, int paramInt) {
    int i;
    CollectPreconditions.a(paramInt, "count");
    ObjectCountHashMap<E> objectCountHashMap = this.a;
    if (paramInt == 0) {
      i = objectCountHashMap.c(paramE);
    } else {
      i = objectCountHashMap.a(paramE, paramInt);
    } 
    this.b += (paramInt - i);
    return i;
  }
  
  public final void clear() {
    this.a.d();
    this.b = 0L;
  }
  
  public final Iterator<E> iterator() {
    return Multisets.a(this);
  }
  
  public final int size() {
    return Ints.b(this.b);
  }
  
  abstract class Itr<T> implements Iterator<T> {
    int b = this.e.a.b();
    
    int c = -1;
    
    int d = this.e.a.d;
    
    Itr(AbstractMapBasedMultiset this$0) {}
    
    private void a() {
      if (this.e.a.d == this.d)
        return; 
      throw new ConcurrentModificationException();
    }
    
    abstract T a(int param1Int);
    
    public boolean hasNext() {
      a();
      return (this.b >= 0);
    }
    
    public T next() {
      if (hasNext()) {
        T t = a(this.b);
        this.c = this.b;
        this.b = this.e.a.b(this.b);
        return t;
      } 
      throw new NoSuchElementException();
    }
    
    public void remove() {
      boolean bool;
      a();
      if (this.c != -1) {
        bool = true;
      } else {
        bool = false;
      } 
      CollectPreconditions.a(bool);
      AbstractMapBasedMultiset abstractMapBasedMultiset = this.e;
      abstractMapBasedMultiset.b -= this.e.a.h(this.c);
      this.b = this.e.a.a(this.b, this.c);
      this.c = -1;
      this.d = this.e.a.d;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\AbstractMapBasedMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */