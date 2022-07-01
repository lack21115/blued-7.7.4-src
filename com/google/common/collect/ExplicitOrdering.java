package com.google.common.collect;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class ExplicitOrdering<T> extends Ordering<T> implements Serializable {
  final ImmutableMap<T, Integer> a;
  
  private int a(T paramT) {
    Integer integer = this.a.get(paramT);
    if (integer != null)
      return integer.intValue(); 
    throw new Ordering.IncomparableValueException(paramT);
  }
  
  public int compare(T paramT1, T paramT2) {
    return a(paramT1) - a(paramT2);
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    if (paramObject instanceof ExplicitOrdering) {
      paramObject = paramObject;
      return this.a.equals(((ExplicitOrdering)paramObject).a);
    } 
    return false;
  }
  
  public int hashCode() {
    return this.a.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Ordering.explicit(");
    stringBuilder.append(this.a.n());
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ExplicitOrdering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */