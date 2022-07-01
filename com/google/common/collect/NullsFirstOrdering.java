package com.google.common.collect;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class NullsFirstOrdering<T> extends Ordering<T> implements Serializable {
  final Ordering<? super T> a;
  
  NullsFirstOrdering(Ordering<? super T> paramOrdering) {
    this.a = paramOrdering;
  }
  
  public <S extends T> Ordering<S> a() {
    return this.a.<T>a().c();
  }
  
  public <S extends T> Ordering<S> b() {
    return this;
  }
  
  public <S extends T> Ordering<S> c() {
    return this.a.c();
  }
  
  public int compare(@NullableDecl T paramT1, @NullableDecl T paramT2) {
    return (paramT1 == paramT2) ? 0 : ((paramT1 == null) ? -1 : ((paramT2 == null) ? 1 : this.a.compare(paramT1, paramT2)));
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject instanceof NullsFirstOrdering) {
      paramObject = paramObject;
      return this.a.equals(((NullsFirstOrdering)paramObject).a);
    } 
    return false;
  }
  
  public int hashCode() {
    return this.a.hashCode() ^ 0x39153A74;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.a);
    stringBuilder.append(".nullsFirst()");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\NullsFirstOrdering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */