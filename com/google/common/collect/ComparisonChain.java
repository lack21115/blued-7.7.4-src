package com.google.common.collect;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class ComparisonChain {
  private static final ComparisonChain a = new ComparisonChain() {
      ComparisonChain a(int param1Int) {
        return (param1Int < 0) ? ComparisonChain.c() : ((param1Int > 0) ? ComparisonChain.d() : ComparisonChain.e());
      }
      
      public ComparisonChain a(Comparable<Comparable> param1Comparable1, Comparable param1Comparable2) {
        return a(param1Comparable1.compareTo(param1Comparable2));
      }
      
      public int b() {
        return 0;
      }
    };
  
  private static final ComparisonChain b = new InactiveComparisonChain(-1);
  
  private static final ComparisonChain c = new InactiveComparisonChain(1);
  
  private ComparisonChain() {}
  
  public static ComparisonChain a() {
    return a;
  }
  
  public abstract ComparisonChain a(Comparable<?> paramComparable1, Comparable<?> paramComparable2);
  
  public abstract int b();
  
  static final class InactiveComparisonChain extends ComparisonChain {
    final int a;
    
    InactiveComparisonChain(int param1Int) {
      this.a = param1Int;
    }
    
    public ComparisonChain a(@NullableDecl Comparable param1Comparable1, @NullableDecl Comparable param1Comparable2) {
      return this;
    }
    
    public int b() {
      return this.a;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ComparisonChain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */