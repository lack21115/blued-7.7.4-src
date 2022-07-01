package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;

public abstract class ImmutableSortedMultiset<E> extends ImmutableSortedMultisetFauxverideShim<E> implements SortedMultiset<E> {
  @LazyInit
  transient ImmutableSortedMultiset<E> a;
  
  static <E> ImmutableSortedMultiset<E> a(Comparator<? super E> paramComparator) {
    return (ImmutableSortedMultiset<E>)(Ordering.<Comparable>d().equals(paramComparator) ? RegularImmutableSortedMultiset.b : new RegularImmutableSortedMultiset<E>(paramComparator));
  }
  
  public abstract ImmutableSortedMultiset<E> a(E paramE, BoundType paramBoundType);
  
  public abstract ImmutableSortedMultiset<E> b(E paramE, BoundType paramBoundType);
  
  public ImmutableSortedMultiset<E> b(E paramE1, BoundType paramBoundType1, E paramE2, BoundType paramBoundType2) {
    boolean bool;
    if (comparator().compare(paramE1, paramE2) <= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool, "Expected lowerBound <= upperBound but %s > %s", paramE1, paramE2);
    return b(paramE1, paramBoundType1).a(paramE2, paramBoundType2);
  }
  
  public abstract ImmutableSortedSet<E> b();
  
  public ImmutableSortedMultiset<E> c() {
    ImmutableSortedMultiset<E> immutableSortedMultiset2 = this.a;
    ImmutableSortedMultiset<E> immutableSortedMultiset1 = immutableSortedMultiset2;
    if (immutableSortedMultiset2 == null) {
      if (isEmpty()) {
        immutableSortedMultiset1 = a(Ordering.<E>a(comparator()).a());
      } else {
        immutableSortedMultiset1 = new DescendingImmutableSortedMultiset<E>(this);
      } 
      this.a = immutableSortedMultiset1;
    } 
    return immutableSortedMultiset1;
  }
  
  public final Comparator<? super E> comparator() {
    return b().comparator();
  }
  
  @Deprecated
  public final Multiset.Entry<E> l() {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final Multiset.Entry<E> m() {
    throw new UnsupportedOperationException();
  }
  
  public static class Builder<E> extends ImmutableMultiset.Builder<E> {
    E[] d;
    
    private final Comparator<? super E> e;
    
    private int[] f;
    
    private int g;
    
    private boolean h;
    
    private void a(boolean param1Boolean) {
      int i = this.g;
      if (i == 0)
        return; 
      Object[] arrayOfObject2 = Arrays.copyOf((Object[])this.d, i);
      Arrays.sort(arrayOfObject2, (Comparator)this.e);
      int j = 1;
      for (i = 1; j < arrayOfObject2.length; i = k) {
        int k = i;
        if (this.e.compare((E)arrayOfObject2[i - 1], (E)arrayOfObject2[j]) < 0) {
          arrayOfObject2[i] = arrayOfObject2[j];
          k = i + 1;
        } 
        j++;
      } 
      Arrays.fill(arrayOfObject2, i, this.g, (Object)null);
      Object[] arrayOfObject1 = arrayOfObject2;
      if (param1Boolean) {
        j = this.g;
        arrayOfObject1 = arrayOfObject2;
        if (i * 4 > j * 3)
          arrayOfObject1 = Arrays.copyOf(arrayOfObject2, IntMath.e(j, j / 2 + 1)); 
      } 
      int[] arrayOfInt = new int[arrayOfObject1.length];
      for (j = 0; j < this.g; j++) {
        int k = Arrays.binarySearch(arrayOfObject1, 0, i, this.d[j], (Comparator)this.e);
        int[] arrayOfInt1 = this.f;
        if (arrayOfInt1[j] >= 0) {
          arrayOfInt[k] = arrayOfInt[k] + arrayOfInt1[j];
        } else {
          arrayOfInt[k] = arrayOfInt1[j];
        } 
      } 
      this.d = (E[])arrayOfObject1;
      this.f = arrayOfInt;
      this.g = i;
    }
    
    private void c() {
      int i = this.g;
      E[] arrayOfE = this.d;
      if (i == arrayOfE.length) {
        a(true);
      } else if (this.h) {
        this.d = Arrays.copyOf(arrayOfE, arrayOfE.length);
      } 
      this.h = false;
    }
    
    private void d() {
      a(false);
      int i = 0;
      int j = 0;
      while (true) {
        int k = this.g;
        if (i < k) {
          int[] arrayOfInt = this.f;
          k = j;
          if (arrayOfInt[i] > 0) {
            E[] arrayOfE = this.d;
            arrayOfE[j] = arrayOfE[i];
            arrayOfInt[j] = arrayOfInt[i];
            k = j + 1;
          } 
          i++;
          j = k;
          continue;
        } 
        Arrays.fill((Object[])this.d, j, k, (Object)null);
        Arrays.fill(this.f, j, this.g, 0);
        this.g = j;
        return;
      } 
    }
    
    public Builder<E> b(E param1E, int param1Int) {
      Preconditions.a(param1E);
      CollectPreconditions.a(param1Int, "occurrences");
      if (param1Int == 0)
        return this; 
      c();
      E[] arrayOfE = this.d;
      int i = this.g;
      arrayOfE[i] = param1E;
      this.f[i] = param1Int;
      this.g = i + 1;
      return this;
    }
    
    public ImmutableSortedMultiset<E> b() {
      d();
      int i = this.g;
      if (i == 0)
        return ImmutableSortedMultiset.a(this.e); 
      RegularImmutableSortedSet<E> regularImmutableSortedSet = (RegularImmutableSortedSet)ImmutableSortedSet.<E>a(this.e, i, this.d);
      long[] arrayOfLong = new long[this.g + 1];
      i = 0;
      while (true) {
        int j = this.g;
        if (i < j) {
          j = i + 1;
          arrayOfLong[j] = arrayOfLong[i] + this.f[i];
          i = j;
          continue;
        } 
        this.h = true;
        return new RegularImmutableSortedMultiset<E>(regularImmutableSortedSet, arrayOfLong, 0, j);
      } 
    }
    
    public Builder<E> c(E param1E) {
      return b(param1E, 1);
    }
    
    public Builder<E> c(Iterator<? extends E> param1Iterator) {
      while (param1Iterator.hasNext())
        c(param1Iterator.next()); 
      return this;
    }
    
    public Builder<E> d(Iterable<? extends E> param1Iterable) {
      if (param1Iterable instanceof Multiset) {
        for (Multiset.Entry<E> entry : (Iterable<Multiset.Entry<E>>)((Multiset)param1Iterable).f())
          b(entry.c(), entry.b()); 
      } else {
        Iterator<? extends E> iterator = param1Iterable.iterator();
        while (iterator.hasNext())
          c(iterator.next()); 
      } 
      return this;
    }
  }
  
  static final class SerializedForm<E> implements Serializable {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ImmutableSortedMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */