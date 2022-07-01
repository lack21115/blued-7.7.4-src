package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class NaturalOrdering extends Ordering<Comparable> implements Serializable {
  static final NaturalOrdering a = new NaturalOrdering();
  
  @NullableDecl
  private transient Ordering<Comparable> b;
  
  @NullableDecl
  private transient Ordering<Comparable> c;
  
  public int a(Comparable<Comparable> paramComparable1, Comparable paramComparable2) {
    Preconditions.a(paramComparable1);
    Preconditions.a(paramComparable2);
    return paramComparable1.compareTo(paramComparable2);
  }
  
  public <S extends Comparable> Ordering<S> a() {
    return ReverseNaturalOrdering.a;
  }
  
  public <S extends Comparable> Ordering<S> b() {
    Ordering<Comparable> ordering2 = this.b;
    Ordering<Comparable> ordering1 = ordering2;
    if (ordering2 == null) {
      ordering1 = super.b();
      this.b = ordering1;
    } 
    return (Ordering)ordering1;
  }
  
  public <S extends Comparable> Ordering<S> c() {
    Ordering<Comparable> ordering2 = this.c;
    Ordering<Comparable> ordering1 = ordering2;
    if (ordering2 == null) {
      ordering1 = super.c();
      this.c = ordering1;
    } 
    return (Ordering)ordering1;
  }
  
  public String toString() {
    return "Ordering.natural()";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\NaturalOrdering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */