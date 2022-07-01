package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;

public abstract class ContiguousSet<C extends Comparable> extends ImmutableSortedSet<C> {
  final DiscreteDomain<C> a;
  
  ContiguousSet(DiscreteDomain<C> paramDiscreteDomain) {
    super(Ordering.d());
    this.a = paramDiscreteDomain;
  }
  
  public static <C extends Comparable> ContiguousSet<C> a(Range<C> paramRange, DiscreteDomain<C> paramDiscreteDomain) {
    Preconditions.a(paramRange);
    Preconditions.a(paramDiscreteDomain);
    try {
      boolean bool;
      Range<C> range1;
      if (!paramRange.e()) {
        range1 = paramRange.c((Range)Range.d((Comparable<?>)paramDiscreteDomain.a()));
      } else {
        range1 = paramRange;
      } 
      Range<C> range2 = range1;
      if (!paramRange.h())
        range2 = range1.c((Range)Range.b((Comparable<?>)paramDiscreteDomain.b())); 
      if (range2.k() || Range.a((Comparable)paramRange.a.a(paramDiscreteDomain), (Comparable)paramRange.b.b(paramDiscreteDomain)) > 0) {
        bool = true;
      } else {
        bool = false;
      } 
      return (ContiguousSet<C>)(bool ? new EmptyContiguousSet<C>(paramDiscreteDomain) : new RegularContiguousSet<C>(range2, paramDiscreteDomain));
    } catch (NoSuchElementException noSuchElementException) {
      throw new IllegalArgumentException(noSuchElementException);
    } 
  }
  
  public ContiguousSet<C> a(C paramC) {
    return c((C)Preconditions.a(paramC), false);
  }
  
  public ContiguousSet<C> a(C paramC1, C paramC2) {
    boolean bool;
    Preconditions.a(paramC1);
    Preconditions.a(paramC2);
    if (comparator().compare(paramC1, paramC2) <= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool);
    return b(paramC1, true, paramC2, false);
  }
  
  public ContiguousSet<C> a(C paramC, boolean paramBoolean) {
    return c((C)Preconditions.a(paramC), paramBoolean);
  }
  
  public ContiguousSet<C> a(C paramC1, boolean paramBoolean1, C paramC2, boolean paramBoolean2) {
    boolean bool;
    Preconditions.a(paramC1);
    Preconditions.a(paramC2);
    if (comparator().compare(paramC1, paramC2) <= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool);
    return b(paramC1, paramBoolean1, paramC2, paramBoolean2);
  }
  
  public abstract Range<C> ar_();
  
  public ContiguousSet<C> b(C paramC) {
    return d((C)Preconditions.a(paramC), true);
  }
  
  public ContiguousSet<C> b(C paramC, boolean paramBoolean) {
    return d((C)Preconditions.a(paramC), paramBoolean);
  }
  
  abstract ContiguousSet<C> b(C paramC1, boolean paramBoolean1, C paramC2, boolean paramBoolean2);
  
  abstract ContiguousSet<C> c(C paramC, boolean paramBoolean);
  
  ImmutableSortedSet<C> c() {
    return new DescendingImmutableSortedSet<C>(this);
  }
  
  abstract ContiguousSet<C> d(C paramC, boolean paramBoolean);
  
  public String toString() {
    return ar_().toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ContiguousSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */