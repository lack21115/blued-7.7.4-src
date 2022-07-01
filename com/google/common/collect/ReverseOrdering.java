package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class ReverseOrdering<T> extends Ordering<T> implements Serializable {
  final Ordering<? super T> a;
  
  ReverseOrdering(Ordering<? super T> paramOrdering) {
    this.a = (Ordering<? super T>)Preconditions.a(paramOrdering);
  }
  
  public <S extends T> Ordering<S> a() {
    return (Ordering)this.a;
  }
  
  public <E extends T> E a(E paramE1, E paramE2) {
    return this.a.b(paramE1, paramE2);
  }
  
  public <E extends T> E b(E paramE1, E paramE2) {
    return this.a.a(paramE1, paramE2);
  }
  
  public int compare(T paramT1, T paramT2) {
    return this.a.compare(paramT2, paramT1);
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject instanceof ReverseOrdering) {
      paramObject = paramObject;
      return this.a.equals(((ReverseOrdering)paramObject).a);
    } 
    return false;
  }
  
  public int hashCode() {
    return -this.a.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.a);
    stringBuilder.append(".reverse()");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ReverseOrdering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */