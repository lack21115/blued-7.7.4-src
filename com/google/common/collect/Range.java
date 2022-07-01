package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Range<C extends Comparable> extends RangeGwtSerializationDependencies implements Predicate<C>, Serializable {
  private static final Range<Comparable> c = new Range((Cut)Cut.d(), (Cut)Cut.e());
  
  final Cut<C> a;
  
  final Cut<C> b;
  
  private Range(Cut<C> paramCut1, Cut<C> paramCut2) {
    this.a = (Cut<C>)Preconditions.a(paramCut1);
    this.b = (Cut<C>)Preconditions.a(paramCut2);
    if (paramCut1.a(paramCut2) <= 0 && paramCut1 != Cut.e() && paramCut2 != Cut.d())
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Invalid range: ");
    stringBuilder.append(b(paramCut1, paramCut2));
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  static int a(Comparable<Comparable> paramComparable1, Comparable paramComparable2) {
    return paramComparable1.compareTo(paramComparable2);
  }
  
  static <C extends Comparable<?>> Function<Range<C>, Cut<C>> a() {
    return LowerBoundFn.a;
  }
  
  static <C extends Comparable<?>> Range<C> a(Cut<C> paramCut1, Cut<C> paramCut2) {
    return (Range)new Range<Comparable>(paramCut1, paramCut2);
  }
  
  public static <C extends Comparable<?>> Range<C> a(C paramC) {
    return a((Cut)Cut.d(), (Cut)Cut.b((Comparable)paramC));
  }
  
  public static <C extends Comparable<?>> Range<C> a(C paramC, BoundType paramBoundType) {
    int i = null.a[paramBoundType.ordinal()];
    if (i != 1) {
      if (i == 2)
        return b(paramC); 
      throw new AssertionError();
    } 
    return a(paramC);
  }
  
  public static <C extends Comparable<?>> Range<C> a(C paramC1, BoundType paramBoundType1, C paramC2, BoundType paramBoundType2) {
    Cut<Comparable> cut1;
    Cut<Comparable> cut2;
    Preconditions.a(paramBoundType1);
    Preconditions.a(paramBoundType2);
    if (paramBoundType1 == BoundType.a) {
      cut1 = Cut.c((Comparable)paramC1);
    } else {
      cut1 = Cut.b(cut1);
    } 
    if (paramBoundType2 == BoundType.a) {
      cut2 = Cut.b((Comparable)paramC2);
    } else {
      cut2 = Cut.c((Comparable)paramC2);
    } 
    return a((Cut)cut1, (Cut)cut2);
  }
  
  static <C extends Comparable<?>> Function<Range<C>, Cut<C>> b() {
    return UpperBoundFn.a;
  }
  
  public static <C extends Comparable<?>> Range<C> b(C paramC) {
    return a((Cut)Cut.d(), (Cut)Cut.c((Comparable)paramC));
  }
  
  public static <C extends Comparable<?>> Range<C> b(C paramC, BoundType paramBoundType) {
    int i = null.a[paramBoundType.ordinal()];
    if (i != 1) {
      if (i == 2)
        return d(paramC); 
      throw new AssertionError();
    } 
    return c(paramC);
  }
  
  private static String b(Cut<?> paramCut1, Cut<?> paramCut2) {
    StringBuilder stringBuilder = new StringBuilder(16);
    paramCut1.a(stringBuilder);
    stringBuilder.append("..");
    paramCut2.b(stringBuilder);
    return stringBuilder.toString();
  }
  
  static <C extends Comparable<?>> Ordering<Range<C>> c() {
    return (Ordering)RangeLexOrdering.a;
  }
  
  public static <C extends Comparable<?>> Range<C> c(C paramC) {
    return a((Cut)Cut.c((Comparable)paramC), (Cut)Cut.e());
  }
  
  public static <C extends Comparable<?>> Range<C> d() {
    return (Range)c;
  }
  
  public static <C extends Comparable<?>> Range<C> d(C paramC) {
    return a((Cut)Cut.b((Comparable)paramC), (Cut)Cut.e());
  }
  
  public Range<C> a(DiscreteDomain<C> paramDiscreteDomain) {
    Preconditions.a(paramDiscreteDomain);
    Cut<C> cut2 = this.a.c(paramDiscreteDomain);
    Cut<C> cut1 = this.b.c(paramDiscreteDomain);
    return (cut2 == this.a && cut1 == this.b) ? this : a(cut2, cut1);
  }
  
  public boolean a(Range<C> paramRange) {
    return (this.a.a(paramRange.a) <= 0 && this.b.a(paramRange.b) >= 0);
  }
  
  public boolean b(Range<C> paramRange) {
    return (this.a.a(paramRange.b) <= 0 && paramRange.a.a(this.b) <= 0);
  }
  
  public Range<C> c(Range<C> paramRange) {
    Cut<C> cut1;
    Cut<C> cut2;
    int i = this.a.a(paramRange.a);
    int j = this.b.a(paramRange.b);
    if (i >= 0 && j <= 0)
      return this; 
    if (i <= 0 && j >= 0)
      return paramRange; 
    if (i >= 0) {
      cut2 = this.a;
    } else {
      cut2 = paramRange.a;
    } 
    if (j <= 0) {
      cut1 = this.b;
    } else {
      cut1 = ((Range)cut1).b;
    } 
    return (Range)a(cut2, cut1);
  }
  
  public boolean e() {
    return (this.a != Cut.d());
  }
  
  public boolean e(C paramC) {
    Preconditions.a(paramC);
    return (this.a.a(paramC) && !this.b.a(paramC));
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    boolean bool = paramObject instanceof Range;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool) {
      paramObject = paramObject;
      bool1 = bool2;
      if (this.a.equals(((Range)paramObject).a)) {
        bool1 = bool2;
        if (this.b.equals(((Range)paramObject).b))
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  public C f() {
    return this.a.c();
  }
  
  @Deprecated
  public boolean f(C paramC) {
    return e(paramC);
  }
  
  public BoundType g() {
    return this.a.a();
  }
  
  public boolean h() {
    return (this.b != Cut.e());
  }
  
  public int hashCode() {
    return this.a.hashCode() * 31 + this.b.hashCode();
  }
  
  public C i() {
    return this.b.c();
  }
  
  public BoundType j() {
    return this.b.b();
  }
  
  public boolean k() {
    return this.a.equals(this.b);
  }
  
  public String toString() {
    return b(this.a, this.b);
  }
  
  static class LowerBoundFn implements Function<Range, Cut> {
    static final LowerBoundFn a = new LowerBoundFn();
    
    public Cut a(Range param1Range) {
      return param1Range.a;
    }
  }
  
  static class RangeLexOrdering extends Ordering<Range<?>> implements Serializable {
    static final Ordering<Range<?>> a = new RangeLexOrdering();
    
    public int a(Range<?> param1Range1, Range<?> param1Range2) {
      return ComparisonChain.a().a(param1Range1.a, param1Range2.a).a(param1Range1.b, param1Range2.b).b();
    }
  }
  
  static class UpperBoundFn implements Function<Range, Cut> {
    static final UpperBoundFn a = new UpperBoundFn();
    
    public Cut a(Range param1Range) {
      return param1Range.b;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\Range.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */