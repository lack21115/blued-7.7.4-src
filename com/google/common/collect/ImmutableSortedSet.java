package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class ImmutableSortedSet<E> extends ImmutableSortedSetFauxverideShim<E> implements SortedIterable<E>, NavigableSet<E> {
  final transient Comparator<? super E> b;
  
  @LazyInit
  transient ImmutableSortedSet<E> c;
  
  ImmutableSortedSet(Comparator<? super E> paramComparator) {
    this.b = paramComparator;
  }
  
  static int a(Comparator<?> paramComparator, Object paramObject1, Object paramObject2) {
    return paramComparator.compare(paramObject1, paramObject2);
  }
  
  static <E> ImmutableSortedSet<E> a(Comparator<? super E> paramComparator, int paramInt, E... paramVarArgs) {
    if (paramInt == 0)
      return a(paramComparator); 
    ObjectArrays.b((Object[])paramVarArgs, paramInt);
    Arrays.sort(paramVarArgs, 0, paramInt, paramComparator);
    int i = 1;
    int j;
    for (j = 1; i < paramInt; j = k) {
      E e = paramVarArgs[i];
      int k = j;
      if (paramComparator.compare(e, paramVarArgs[j - 1]) != 0) {
        paramVarArgs[j] = e;
        k = j + 1;
      } 
      i++;
    } 
    Arrays.fill((Object[])paramVarArgs, j, paramInt, (Object)null);
    E[] arrayOfE = paramVarArgs;
    if (j < paramVarArgs.length / 2)
      arrayOfE = Arrays.copyOf(paramVarArgs, j); 
    return new RegularImmutableSortedSet<E>(ImmutableList.b((Object[])arrayOfE, j), paramComparator);
  }
  
  public static <E> ImmutableSortedSet<E> a(Comparator<? super E> paramComparator, Iterable<? extends E> paramIterable) {
    Preconditions.a(paramComparator);
    if (SortedIterables.a(paramComparator, paramIterable) && paramIterable instanceof ImmutableSortedSet) {
      ImmutableSortedSet<E> immutableSortedSet = (ImmutableSortedSet)paramIterable;
      if (!immutableSortedSet.a())
        return immutableSortedSet; 
    } 
    Object[] arrayOfObject = Iterables.b(paramIterable);
    return a(paramComparator, arrayOfObject.length, (E[])arrayOfObject);
  }
  
  public static <E> ImmutableSortedSet<E> a(Comparator<? super E> paramComparator, Collection<? extends E> paramCollection) {
    return a(paramComparator, paramCollection);
  }
  
  static <E> RegularImmutableSortedSet<E> a(Comparator<? super E> paramComparator) {
    return (RegularImmutableSortedSet<E>)(Ordering.<Comparable>d().equals(paramComparator) ? RegularImmutableSortedSet.a : new RegularImmutableSortedSet<E>(ImmutableList.d(), paramComparator));
  }
  
  public static <E> ImmutableSortedSet<E> l() {
    return (ImmutableSortedSet)RegularImmutableSortedSet.a;
  }
  
  public ImmutableSortedSet<E> a(E paramE) {
    return c(paramE, true);
  }
  
  public ImmutableSortedSet<E> a(E paramE1, E paramE2) {
    return b(paramE1, true, paramE2, false);
  }
  
  abstract ImmutableSortedSet<E> a(E paramE, boolean paramBoolean);
  
  abstract ImmutableSortedSet<E> a(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2);
  
  public ImmutableSortedSet<E> as_() {
    ImmutableSortedSet<E> immutableSortedSet2 = this.c;
    ImmutableSortedSet<E> immutableSortedSet1 = immutableSortedSet2;
    if (immutableSortedSet2 == null) {
      immutableSortedSet1 = c();
      this.c = immutableSortedSet1;
      immutableSortedSet1.c = this;
    } 
    return immutableSortedSet1;
  }
  
  public abstract UnmodifiableIterator<E> av_();
  
  int b(Object paramObject1, Object paramObject2) {
    return a(this.b, paramObject1, paramObject2);
  }
  
  public ImmutableSortedSet<E> b(E paramE) {
    return d(paramE, false);
  }
  
  abstract ImmutableSortedSet<E> b(E paramE, boolean paramBoolean);
  
  public ImmutableSortedSet<E> b(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2) {
    boolean bool;
    Preconditions.a(paramE1);
    Preconditions.a(paramE2);
    if (this.b.compare(paramE1, paramE2) <= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool);
    return a(paramE1, paramBoolean1, paramE2, paramBoolean2);
  }
  
  abstract int c(@NullableDecl Object paramObject);
  
  abstract ImmutableSortedSet<E> c();
  
  public ImmutableSortedSet<E> c(E paramE, boolean paramBoolean) {
    return a((E)Preconditions.a(paramE), paramBoolean);
  }
  
  public E ceiling(E paramE) {
    return Iterables.a(c(paramE, true), (E)null);
  }
  
  public Comparator<? super E> comparator() {
    return this.b;
  }
  
  public ImmutableSortedSet<E> d(E paramE, boolean paramBoolean) {
    return b((E)Preconditions.a(paramE), paramBoolean);
  }
  
  public abstract UnmodifiableIterator<E> e();
  
  public E first() {
    return av_().next();
  }
  
  public E floor(E paramE) {
    return Iterators.b(d(paramE, true).e(), (E)null);
  }
  
  public E higher(E paramE) {
    return Iterables.a(c(paramE, false), (E)null);
  }
  
  public E last() {
    return e().next();
  }
  
  public E lower(E paramE) {
    return Iterators.b(d(paramE, false).e(), (E)null);
  }
  
  @Deprecated
  public final E pollFirst() {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final E pollLast() {
    throw new UnsupportedOperationException();
  }
  
  public static final class Builder<E> extends ImmutableSet.Builder<E> {
    private final Comparator<? super E> e;
    
    public ImmutableSortedSet<E> b() {
      Object[] arrayOfObject = this.a;
      ImmutableSortedSet<E> immutableSortedSet = ImmutableSortedSet.a(this.e, this.b, (E[])arrayOfObject);
      this.b = immutableSortedSet.size();
      this.c = true;
      return immutableSortedSet;
    }
    
    public Builder<E> c(Iterable<? extends E> param1Iterable) {
      super.b(param1Iterable);
      return this;
    }
    
    public Builder<E> c(Iterator<? extends E> param1Iterator) {
      super.b(param1Iterator);
      return this;
    }
    
    public Builder<E> d(E param1E) {
      super.c(param1E);
      return this;
    }
  }
  
  static class SerializedForm<E> implements Serializable {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ImmutableSortedSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */