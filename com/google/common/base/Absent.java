package com.google.common.base;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class Absent<T> extends Optional<T> {
  static final Absent<Object> a = new Absent();
  
  static <T> Optional<T> a() {
    return a;
  }
  
  public T a(T paramT) {
    return Preconditions.a(paramT, "use Optional.orNull() instead of Optional.or(null)");
  }
  
  public boolean b() {
    return false;
  }
  
  public T c() {
    throw new IllegalStateException("Optional.get() cannot be called on an absent value");
  }
  
  @NullableDecl
  public T d() {
    return null;
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    return (paramObject == this);
  }
  
  public int hashCode() {
    return 2040732332;
  }
  
  public String toString() {
    return "Optional.absent()";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\base\Absent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */