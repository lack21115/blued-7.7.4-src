package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class RegularImmutableSortedSet<E> extends ImmutableSortedSet<E> {
  static final RegularImmutableSortedSet<Comparable> a = new RegularImmutableSortedSet(ImmutableList.d(), Ordering.d());
  
  final transient ImmutableList<E> d;
  
  RegularImmutableSortedSet(ImmutableList<E> paramImmutableList, Comparator<? super E> paramComparator) {
    super(paramComparator);
    this.d = paramImmutableList;
  }
  
  private int e(Object paramObject) throws ClassCastException {
    return Collections.binarySearch(this.d, (E)paramObject, (Comparator)f());
  }
  
  int a(Object[] paramArrayOfObject, int paramInt) {
    return this.d.a(paramArrayOfObject, paramInt);
  }
  
  ImmutableSortedSet<E> a(E paramE, boolean paramBoolean) {
    return b(f(paramE, paramBoolean), size());
  }
  
  ImmutableSortedSet<E> a(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2) {
    return a(paramE1, paramBoolean1).b(paramE2, paramBoolean2);
  }
  
  boolean a() {
    return this.d.a();
  }
  
  public UnmodifiableIterator<E> av_() {
    return this.d.av_();
  }
  
  ImmutableSortedSet<E> b(E paramE, boolean paramBoolean) {
    return b(0, e(paramE, paramBoolean));
  }
  
  RegularImmutableSortedSet<E> b(int paramInt1, int paramInt2) {
    return (paramInt1 == 0 && paramInt2 == size()) ? this : ((paramInt1 < paramInt2) ? new RegularImmutableSortedSet(this.d.a(paramInt1, paramInt2), this.b) : a(this.b));
  }
  
  int c(@NullableDecl Object paramObject) {
    if (paramObject == null)
      return -1; 
    try {
      int i = Collections.binarySearch(this.d, (E)paramObject, (Comparator)f());
      return (i >= 0) ? i : -1;
    } catch (ClassCastException classCastException) {
      return -1;
    } 
  }
  
  ImmutableSortedSet<E> c() {
    Comparator<? super E> comparator = Collections.reverseOrder(this.b);
    return isEmpty() ? a(comparator) : new RegularImmutableSortedSet(this.d.f(), comparator);
  }
  
  public E ceiling(E paramE) {
    int i = f(paramE, true);
    return (i == size()) ? null : this.d.get(i);
  }
  
  public boolean contains(@NullableDecl Object paramObject) {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
      try {
        int i = e(paramObject);
        bool1 = bool2;
        if (i >= 0)
          bool1 = true; 
        return bool1;
      } catch (ClassCastException classCastException) {
        return false;
      }  
    return bool1;
  }
  
  public boolean containsAll(Collection<?> paramCollection) {
    Collection<?> collection = paramCollection;
    if (paramCollection instanceof Multiset)
      collection = ((Multiset)paramCollection).d(); 
    if (!SortedIterables.a(comparator(), collection) || collection.size() <= 1)
      return super.containsAll(collection); 
    UnmodifiableIterator<E> unmodifiableIterator = av_();
    Iterator<?> iterator = collection.iterator();
    if (!unmodifiableIterator.hasNext())
      return false; 
    collection = (Collection<?>)iterator.next();
    paramCollection = (Collection<?>)unmodifiableIterator.next();
    try {
      while (true) {
        int i = b(paramCollection, collection);
        if (i < 0) {
          if (!unmodifiableIterator.hasNext())
            return false; 
          paramCollection = (Collection<?>)unmodifiableIterator.next();
          continue;
        } 
        if (i == 0) {
          if (!iterator.hasNext())
            return true; 
          collection = (Collection<?>)iterator.next();
          continue;
        } 
        if (i > 0)
          return false; 
      } 
    } catch (NullPointerException|ClassCastException nullPointerException) {
      return false;
    } 
  }
  
  int e(E paramE, boolean paramBoolean) {
    int i = Collections.binarySearch(this.d, (E)Preconditions.a(paramE), comparator());
    if (i >= 0) {
      int j = i;
      if (paramBoolean)
        j = i + 1; 
      return j;
    } 
    return i;
  }
  
  public UnmodifiableIterator<E> e() {
    return this.d.f().av_();
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof java.util.Set))
      return false; 
    paramObject = paramObject;
    if (size() != paramObject.size())
      return false; 
    if (isEmpty())
      return true; 
    if (SortedIterables.a(this.b, (Iterable<?>)paramObject)) {
      paramObject = paramObject.iterator();
      try {
        UnmodifiableIterator<E> unmodifiableIterator = av_();
        while (unmodifiableIterator.hasNext()) {
          E e = unmodifiableIterator.next();
          Object object = paramObject.next();
          if (object != null) {
            int i = b(e, object);
            if (i != 0)
              return false; 
            continue;
          } 
          return false;
        } 
        return true;
      } catch (ClassCastException|NoSuchElementException classCastException) {
        return false;
      } 
    } 
    return containsAll((Collection<?>)classCastException);
  }
  
  int f(E paramE, boolean paramBoolean) {
    int i = Collections.binarySearch(this.d, (E)Preconditions.a(paramE), comparator());
    return (i >= 0) ? (paramBoolean ? i : (i + 1)) : i;
  }
  
  Comparator<Object> f() {
    return (Comparator)this.b;
  }
  
  public E first() {
    if (!isEmpty())
      return this.d.get(0); 
    throw new NoSuchElementException();
  }
  
  public E floor(E paramE) {
    int i = e(paramE, true) - 1;
    return (i == -1) ? null : this.d.get(i);
  }
  
  public ImmutableList<E> h() {
    return this.d;
  }
  
  public E higher(E paramE) {
    int i = f(paramE, false);
    return (i == size()) ? null : this.d.get(i);
  }
  
  public E last() {
    if (!isEmpty())
      return this.d.get(size() - 1); 
    throw new NoSuchElementException();
  }
  
  public E lower(E paramE) {
    int i = e(paramE, false) - 1;
    return (i == -1) ? null : this.d.get(i);
  }
  
  Object[] n() {
    return this.d.n();
  }
  
  int o() {
    return this.d.o();
  }
  
  int q() {
    return this.d.q();
  }
  
  public int size() {
    return this.d.size();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\RegularImmutableSortedSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */