package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;

final class ReverseNaturalOrdering extends Ordering<Comparable> implements Serializable {
  static final ReverseNaturalOrdering a = new ReverseNaturalOrdering();
  
  public int a(Comparable paramComparable1, Comparable<Comparable> paramComparable2) {
    Preconditions.a(paramComparable1);
    return (paramComparable1 == paramComparable2) ? 0 : paramComparable2.compareTo(paramComparable1);
  }
  
  public <S extends Comparable> Ordering<S> a() {
    return Ordering.d();
  }
  
  public <E extends Comparable> E b(E paramE1, E paramE2) {
    return (E)NaturalOrdering.a.b(paramE1, paramE2);
  }
  
  public <E extends Comparable> E c(E paramE1, E paramE2) {
    return (E)NaturalOrdering.a.a(paramE1, paramE2);
  }
  
  public String toString() {
    return "Ordering.natural().reverse()";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ReverseNaturalOrdering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */