package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class ByFunctionOrdering<F, T> extends Ordering<F> implements Serializable {
  final Function<F, ? extends T> a;
  
  final Ordering<T> b;
  
  ByFunctionOrdering(Function<F, ? extends T> paramFunction, Ordering<T> paramOrdering) {
    this.a = (Function<F, ? extends T>)Preconditions.a(paramFunction);
    this.b = (Ordering<T>)Preconditions.a(paramOrdering);
  }
  
  public int compare(F paramF1, F paramF2) {
    return this.b.compare((T)this.a.f(paramF1), (T)this.a.f(paramF2));
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject instanceof ByFunctionOrdering) {
      paramObject = paramObject;
      return (this.a.equals(((ByFunctionOrdering)paramObject).a) && this.b.equals(((ByFunctionOrdering)paramObject).b));
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ByFunctionOrdering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */