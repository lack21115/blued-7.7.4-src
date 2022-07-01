package com.google.common.base;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public interface Function<F, T> {
  boolean equals(@NullableDecl Object paramObject);
  
  @NullableDecl
  T f(@NullableDecl F paramF);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\base\Function.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */