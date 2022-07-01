package com.google.common.base;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class FunctionalEquivalence<F, T> extends Equivalence<F> implements Serializable {
  private final Function<F, ? extends T> a;
  
  private final Equivalence<T> b;
  
  protected int b(F paramF) {
    return this.b.a(this.a.f(paramF));
  }
  
  protected boolean b(F paramF1, F paramF2) {
    return this.b.a(this.a.f(paramF1), this.a.f(paramF2));
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject instanceof FunctionalEquivalence) {
      paramObject = paramObject;
      return (this.a.equals(((FunctionalEquivalence)paramObject).a) && this.b.equals(((FunctionalEquivalence)paramObject).b));
    } 
    return false;
  }
  
  public int hashCode() {
    return Objects.a(new Object[] { this.a, this.b });
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.b);
    stringBuilder.append(".onResultOf(");
    stringBuilder.append(this.a);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\base\FunctionalEquivalence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */