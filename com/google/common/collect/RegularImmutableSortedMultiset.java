package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class RegularImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {
  static final ImmutableSortedMultiset<Comparable> b;
  
  private static final long[] d = new long[] { 0L };
  
  final transient RegularImmutableSortedSet<E> c;
  
  private final transient long[] e;
  
  private final transient int f;
  
  private final transient int g;
  
  static {
    b = new RegularImmutableSortedMultiset(Ordering.d());
  }
  
  RegularImmutableSortedMultiset(RegularImmutableSortedSet<E> paramRegularImmutableSortedSet, long[] paramArrayOflong, int paramInt1, int paramInt2) {
    this.c = paramRegularImmutableSortedSet;
    this.e = paramArrayOflong;
    this.f = paramInt1;
    this.g = paramInt2;
  }
  
  RegularImmutableSortedMultiset(Comparator<? super E> paramComparator) {
    this.c = ImmutableSortedSet.a(paramComparator);
    this.e = d;
    this.f = 0;
    this.g = 0;
  }
  
  private int b(int paramInt) {
    long[] arrayOfLong = this.e;
    int i = this.f;
    return (int)(arrayOfLong[i + paramInt + 1] - arrayOfLong[i + paramInt]);
  }
  
  public int a(@NullableDecl Object paramObject) {
    int i = this.c.c(paramObject);
    return (i >= 0) ? b(i) : 0;
  }
  
  ImmutableSortedMultiset<E> a(int paramInt1, int paramInt2) {
    Preconditions.a(paramInt1, paramInt2, this.g);
    return (paramInt1 == paramInt2) ? a(comparator()) : ((paramInt1 == 0 && paramInt2 == this.g) ? this : new RegularImmutableSortedMultiset(this.c.b(paramInt1, paramInt2), this.e, this.f + paramInt1, paramInt2 - paramInt1));
  }
  
  public ImmutableSortedMultiset<E> a(E paramE, BoundType paramBoundType) {
    boolean bool;
    RegularImmutableSortedSet<E> regularImmutableSortedSet = this.c;
    if (Preconditions.a(paramBoundType) == BoundType.b) {
      bool = true;
    } else {
      bool = false;
    } 
    return a(0, regularImmutableSortedSet.e(paramE, bool));
  }
  
  Multiset.Entry<E> a(int paramInt) {
    return Multisets.a(this.c.h().get(paramInt), b(paramInt));
  }
  
  boolean a() {
    int i = this.f;
    boolean bool = true;
    if (i <= 0) {
      if (this.g < this.e.length - 1)
        return true; 
      bool = false;
    } 
    return bool;
  }
  
  public ImmutableSortedMultiset<E> b(E paramE, BoundType paramBoundType) {
    boolean bool;
    RegularImmutableSortedSet<E> regularImmutableSortedSet = this.c;
    if (Preconditions.a(paramBoundType) == BoundType.b) {
      bool = true;
    } else {
      bool = false;
    } 
    return a(regularImmutableSortedSet.f(paramE, bool), this.g);
  }
  
  public ImmutableSortedSet<E> b() {
    return this.c;
  }
  
  public Multiset.Entry<E> j() {
    return isEmpty() ? null : a(0);
  }
  
  public Multiset.Entry<E> k() {
    return isEmpty() ? null : a(this.g - 1);
  }
  
  public int size() {
    long[] arrayOfLong = this.e;
    int i = this.f;
    return Ints.b(arrayOfLong[this.g + i] - arrayOfLong[i]);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\RegularImmutableSortedMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */