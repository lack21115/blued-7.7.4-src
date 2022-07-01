package com.google.common.base;

import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@DoNotMock("Use Optional.of(value) or Optional.absent()")
public abstract class Optional<T> implements Serializable {
  public static <T> Optional<T> b(T paramT) {
    return new Present<T>(Preconditions.a(paramT));
  }
  
  public static <T> Optional<T> c(@NullableDecl T paramT) {
    return (paramT == null) ? e() : new Present<T>(paramT);
  }
  
  public static <T> Optional<T> e() {
    return Absent.a();
  }
  
  public abstract T a(T paramT);
  
  public abstract boolean b();
  
  public abstract T c();
  
  @NullableDecl
  public abstract T d();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\base\Optional.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */