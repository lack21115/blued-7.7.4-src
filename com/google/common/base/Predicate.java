package com.google.common.base;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public interface Predicate<T> {
  boolean a(@NullableDecl T paramT);
  
  boolean equals(@NullableDecl Object paramObject);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\base\Predicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */