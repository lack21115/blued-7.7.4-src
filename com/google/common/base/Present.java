package com.google.common.base;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class Present<T> extends Optional<T> {
  private final T a;
  
  Present(T paramT) {
    this.a = paramT;
  }
  
  public T a(T paramT) {
    Preconditions.a(paramT, "use Optional.orNull() instead of Optional.or(null)");
    return this.a;
  }
  
  public boolean b() {
    return true;
  }
  
  public T c() {
    return this.a;
  }
  
  public T d() {
    return this.a;
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    if (paramObject instanceof Present) {
      paramObject = paramObject;
      return this.a.equals(((Present)paramObject).a);
    } 
    return false;
  }
  
  public int hashCode() {
    return this.a.hashCode() + 1502476572;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Optional.of(");
    stringBuilder.append(this.a);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\base\Present.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */