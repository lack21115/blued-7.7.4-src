package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class ImmutableRangeSet<C extends Comparable> extends AbstractRangeSet<C> implements Serializable {
  private static final ImmutableRangeSet<Comparable<?>> a = new ImmutableRangeSet(ImmutableList.d());
  
  private static final ImmutableRangeSet<Comparable<?>> b = new ImmutableRangeSet(ImmutableList.a((Range)Range.d()));
  
  private final transient ImmutableList<Range<C>> c;
  
  ImmutableRangeSet(ImmutableList<Range<C>> paramImmutableList) {
    this.c = paramImmutableList;
  }
  
  private ImmutableList<Range<C>> b(Range<C> paramRange) {
    byte b;
    int i;
    if (this.c.isEmpty() || paramRange.k())
      return ImmutableList.d(); 
    if (paramRange.a(c()))
      return this.c; 
    if (paramRange.e()) {
      b = SortedLists.a(this.c, (Function)Range.b(), paramRange.a, SortedLists.KeyPresentBehavior.d, SortedLists.KeyAbsentBehavior.b);
    } else {
      b = 0;
    } 
    if (paramRange.h()) {
      i = SortedLists.a(this.c, (Function)Range.a(), paramRange.b, SortedLists.KeyPresentBehavior.c, SortedLists.KeyAbsentBehavior.b);
    } else {
      i = this.c.size();
    } 
    i -= b;
    return (i == 0) ? ImmutableList.d() : new ImmutableList<Range<C>>(this, i, b, paramRange) {
        boolean a() {
          return true;
        }
        
        public Range<C> b(int param1Int) {
          Preconditions.a(param1Int, this.a);
          return (param1Int == 0 || param1Int == this.a - 1) ? ((Range<C>)ImmutableRangeSet.a(this.d).get(param1Int + this.b)).c(this.c) : ImmutableRangeSet.a(this.d).get(param1Int + this.b);
        }
        
        public int size() {
          return this.a;
        }
      };
  }
  
  public static <C extends Comparable> ImmutableRangeSet<C> b() {
    return (ImmutableRangeSet)a;
  }
  
  public ImmutableRangeSet<C> a(Range<C> paramRange) {
    if (!a()) {
      Range<C> range = c();
      if (paramRange.a(range))
        return this; 
      if (paramRange.b(range))
        return new ImmutableRangeSet(b(paramRange)); 
    } 
    return b();
  }
  
  public ImmutableSortedSet<C> a(DiscreteDomain<C> paramDiscreteDomain) {
    Preconditions.a(paramDiscreteDomain);
    if (a())
      return ImmutableSortedSet.l(); 
    Range<C> range = c().a(paramDiscreteDomain);
    if (range.e()) {
      if (!range.h())
        try {
          paramDiscreteDomain.b();
          return new AsSet(this, paramDiscreteDomain);
        } catch (NoSuchElementException noSuchElementException) {
          throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
        }  
      return new AsSet(this, (DiscreteDomain<C>)noSuchElementException);
    } 
    throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
  }
  
  public boolean a() {
    return this.c.isEmpty();
  }
  
  public Range<C> b(C paramC) {
    int i = SortedLists.a(this.c, (Function)Range.a(), Cut.b(paramC), Ordering.d(), SortedLists.KeyPresentBehavior.a, SortedLists.KeyAbsentBehavior.a);
    if (i != -1) {
      Range<C> range = this.c.get(i);
      return range.e(paramC) ? range : null;
    } 
    return null;
  }
  
  public Range<C> c() {
    if (!this.c.isEmpty()) {
      Cut<Comparable<?>> cut = ((Range)this.c.get(0)).a;
      ImmutableList<Range<C>> immutableList = this.c;
      return (Range)Range.a(cut, ((Range)immutableList.get(immutableList.size() - 1)).b);
    } 
    throw new NoSuchElementException();
  }
  
  public ImmutableSet<Range<C>> d() {
    return this.c.isEmpty() ? ImmutableSet.j() : new RegularImmutableSortedSet<Range<C>>(this.c, (Comparator)Range.c());
  }
  
  final class AsSet extends ImmutableSortedSet<C> {
    private final DiscreteDomain<C> d;
    
    @NullableDecl
    private transient Integer e;
    
    AsSet(ImmutableRangeSet this$0, DiscreteDomain<C> param1DiscreteDomain) {
      super(Ordering.d());
      this.d = param1DiscreteDomain;
    }
    
    ImmutableSortedSet<C> a(Range<C> param1Range) {
      return this.a.a(param1Range).a(this.d);
    }
    
    ImmutableSortedSet<C> a(C param1C, boolean param1Boolean) {
      return a((Range)Range.a((Comparable<?>)param1C, BoundType.a(param1Boolean)));
    }
    
    ImmutableSortedSet<C> a(C param1C1, boolean param1Boolean1, C param1C2, boolean param1Boolean2) {
      return (!param1Boolean1 && !param1Boolean2 && Range.a((Comparable)param1C1, (Comparable)param1C2) == 0) ? ImmutableSortedSet.l() : a((Range)Range.a((Comparable<?>)param1C1, BoundType.a(param1Boolean1), (Comparable<?>)param1C2, BoundType.a(param1Boolean2)));
    }
    
    boolean a() {
      return ImmutableRangeSet.a(this.a).a();
    }
    
    public UnmodifiableIterator<C> av_() {
      return new AbstractIterator<C>(this) {
          final Iterator<Range<C>> a = ImmutableRangeSet.a(this.c.a).av_();
          
          Iterator<C> b = Iterators.a();
          
          protected C c() {
            while (!this.b.hasNext()) {
              if (this.a.hasNext()) {
                this.b = ContiguousSet.<C>a(this.a.next(), ImmutableRangeSet.AsSet.a(this.c)).av_();
                continue;
              } 
              return b();
            } 
            return this.b.next();
          }
        };
    }
    
    ImmutableSortedSet<C> b(C param1C, boolean param1Boolean) {
      return a((Range)Range.b((Comparable<?>)param1C, BoundType.a(param1Boolean)));
    }
    
    int c(Object param1Object) {
      if (contains(param1Object)) {
        param1Object = param1Object;
        long l = 0L;
        UnmodifiableIterator<Range> unmodifiableIterator = ImmutableRangeSet.a(this.a).av_();
        while (unmodifiableIterator.hasNext()) {
          Range<Object> range = unmodifiableIterator.next();
          if (range.e(param1Object))
            return Ints.b(l + ContiguousSet.<Object>a(range, this.d).c(param1Object)); 
          l += ContiguousSet.<Object>a(range, this.d).size();
        } 
        throw new AssertionError("impossible");
      } 
      return -1;
    }
    
    ImmutableSortedSet<C> c() {
      return new DescendingImmutableSortedSet<C>(this);
    }
    
    public boolean contains(@NullableDecl Object param1Object) {
      if (param1Object == null)
        return false; 
      try {
        param1Object = param1Object;
        return this.a.a((Comparable)param1Object);
      } catch (ClassCastException classCastException) {
        return false;
      } 
    }
    
    public UnmodifiableIterator<C> e() {
      return new AbstractIterator<C>(this) {
          final Iterator<Range<C>> a = ImmutableRangeSet.a(this.c.a).f().av_();
          
          Iterator<C> b = Iterators.a();
          
          protected C c() {
            while (!this.b.hasNext()) {
              if (this.a.hasNext()) {
                this.b = ContiguousSet.<C>a(this.a.next(), ImmutableRangeSet.AsSet.a(this.c)).e();
                continue;
              } 
              return b();
            } 
            return this.b.next();
          }
        };
    }
    
    public int size() {
      Integer integer2 = this.e;
      Integer integer1 = integer2;
      if (integer2 == null) {
        long l2;
        long l1 = 0L;
        UnmodifiableIterator<Range<C>> unmodifiableIterator = ImmutableRangeSet.a(this.a).av_();
        while (true) {
          l2 = l1;
          if (unmodifiableIterator.hasNext()) {
            l2 = l1 + ContiguousSet.<C>a(unmodifiableIterator.next(), this.d).size();
            l1 = l2;
            if (l2 >= 2147483647L)
              break; 
            continue;
          } 
          break;
        } 
        integer1 = Integer.valueOf(Ints.b(l2));
        this.e = integer1;
      } 
      return integer1.intValue();
    }
    
    public String toString() {
      return ImmutableRangeSet.a(this.a).toString();
    }
  }
  
  class null extends AbstractIterator<C> {
    final Iterator<Range<C>> a = ImmutableRangeSet.a(this.c.a).av_();
    
    Iterator<C> b = Iterators.a();
    
    null(ImmutableRangeSet this$0) {}
    
    protected C c() {
      while (!this.b.hasNext()) {
        if (this.a.hasNext()) {
          this.b = ContiguousSet.<C>a(this.a.next(), ImmutableRangeSet.AsSet.a(this.c)).av_();
          continue;
        } 
        return b();
      } 
      return this.b.next();
    }
  }
  
  class null extends AbstractIterator<C> {
    final Iterator<Range<C>> a = ImmutableRangeSet.a(this.c.a).f().av_();
    
    Iterator<C> b = Iterators.a();
    
    null(ImmutableRangeSet this$0) {}
    
    protected C c() {
      while (!this.b.hasNext()) {
        if (this.a.hasNext()) {
          this.b = ContiguousSet.<C>a(this.a.next(), ImmutableRangeSet.AsSet.a(this.c)).e();
          continue;
        } 
        return b();
      } 
      return this.b.next();
    }
  }
  
  static class AsSetSerializedForm<C extends Comparable> implements Serializable {}
  
  public static class Builder<C extends Comparable<?>> {
    private final List<Range<C>> a = Lists.a();
  }
  
  final class ComplementRanges extends ImmutableList<Range<C>> {
    private final boolean b;
    
    private final boolean c;
    
    private final int d;
    
    boolean a() {
      return true;
    }
    
    public Range<C> b(int param1Int) {
      Cut<Comparable<?>> cut1;
      Cut<Comparable<?>> cut2;
      Preconditions.a(param1Int, this.d);
      if (this.b) {
        if (param1Int == 0) {
          cut1 = Cut.d();
        } else {
          cut1 = ((Range)ImmutableRangeSet.a(this.a).get(param1Int - 1)).b;
        } 
      } else {
        cut1 = ((Range)ImmutableRangeSet.a(this.a).get(param1Int)).b;
      } 
      if (this.c && param1Int == this.d - 1) {
        cut2 = Cut.e();
      } else {
        cut2 = ((Range)ImmutableRangeSet.a(this.a).get(param1Int + (this.b ^ true))).a;
      } 
      return (Range)Range.a(cut1, cut2);
    }
    
    public int size() {
      return this.d;
    }
  }
  
  static final class SerializedForm<C extends Comparable> implements Serializable {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ImmutableRangeSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */