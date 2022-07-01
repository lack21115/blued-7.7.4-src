package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class RegularContiguousSet<C extends Comparable> extends ContiguousSet<C> {
  private final Range<C> d;
  
  RegularContiguousSet(Range<C> paramRange, DiscreteDomain<C> paramDiscreteDomain) {
    super(paramDiscreteDomain);
    this.d = paramRange;
  }
  
  private ContiguousSet<C> a(Range<C> paramRange) {
    return this.d.b(paramRange) ? ContiguousSet.a(this.d.c(paramRange), this.a) : new EmptyContiguousSet<C>(this.a);
  }
  
  private static boolean c(Comparable<?> paramComparable1, @NullableDecl Comparable<?> paramComparable2) {
    return (paramComparable2 != null && Range.a(paramComparable1, paramComparable2) == 0);
  }
  
  public Range<C> a(BoundType paramBoundType1, BoundType paramBoundType2) {
    return (Range)Range.a(this.d.a.a(paramBoundType1, this.a), this.d.b.b(paramBoundType2, this.a));
  }
  
  boolean a() {
    return false;
  }
  
  public Range<C> ar_() {
    return a(BoundType.b, BoundType.b);
  }
  
  public UnmodifiableIterator<C> av_() {
    return new AbstractSequentialIterator<C>(this, (Comparable)f()) {
        final C a = this.b.g();
        
        protected C a(C param1C) {
          return RegularContiguousSet.b((Comparable)param1C, (Comparable)this.a) ? null : this.b.a.a(param1C);
        }
      };
  }
  
  ContiguousSet<C> b(C paramC1, boolean paramBoolean1, C paramC2, boolean paramBoolean2) {
    return (paramC1.compareTo(paramC2) == 0 && !paramBoolean1 && !paramBoolean2) ? new EmptyContiguousSet<C>(this.a) : a((Range)Range.a((Comparable<?>)paramC1, BoundType.a(paramBoolean1), (Comparable<?>)paramC2, BoundType.a(paramBoolean2)));
  }
  
  int c(Object paramObject) {
    return contains(paramObject) ? (int)this.a.a(f(), (C)paramObject) : -1;
  }
  
  ContiguousSet<C> c(C paramC, boolean paramBoolean) {
    return a((Range)Range.a((Comparable<?>)paramC, BoundType.a(paramBoolean)));
  }
  
  public boolean contains(@NullableDecl Object paramObject) {
    if (paramObject == null)
      return false; 
    try {
      return this.d.e((C)paramObject);
    } catch (ClassCastException classCastException) {
      return false;
    } 
  }
  
  public boolean containsAll(Collection<?> paramCollection) {
    return Collections2.a(this, paramCollection);
  }
  
  ContiguousSet<C> d(C paramC, boolean paramBoolean) {
    return a((Range)Range.b((Comparable<?>)paramC, BoundType.a(paramBoolean)));
  }
  
  ImmutableList<C> d() {
    return this.a.a ? new ImmutableAsList<C>(this) {
        public C b(int param1Int) {
          Preconditions.a(param1Int, size());
          return this.a.a.a(this.a.f(), param1Int);
        }
        
        ImmutableSortedSet<C> i() {
          return this.a;
        }
      } : super.d();
  }
  
  public UnmodifiableIterator<C> e() {
    return new AbstractSequentialIterator<C>(this, (Comparable)g()) {
        final C a = this.b.f();
        
        protected C a(C param1C) {
          return RegularContiguousSet.b((Comparable)param1C, (Comparable)this.a) ? null : this.b.a.b(param1C);
        }
      };
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject instanceof RegularContiguousSet) {
      RegularContiguousSet regularContiguousSet = (RegularContiguousSet)paramObject;
      if (this.a.equals(regularContiguousSet.a))
        return (f().equals(regularContiguousSet.f()) && g().equals(regularContiguousSet.g())); 
    } 
    return super.equals(paramObject);
  }
  
  public C f() {
    return this.d.a.a(this.a);
  }
  
  public C g() {
    return this.d.b.b(this.a);
  }
  
  public int hashCode() {
    return Sets.a(this);
  }
  
  public boolean isEmpty() {
    return false;
  }
  
  public int size() {
    long l = this.a.a(f(), g());
    return (l >= 2147483647L) ? Integer.MAX_VALUE : ((int)l + 1);
  }
  
  static final class SerializedForm<C extends Comparable> implements Serializable {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\RegularContiguousSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */