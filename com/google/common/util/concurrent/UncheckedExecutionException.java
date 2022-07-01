package com.google.common.util.concurrent;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class UncheckedExecutionException extends RuntimeException {
  protected UncheckedExecutionException() {}
  
  public UncheckedExecutionException(@NullableDecl Throwable paramThrowable) {
    super(paramThrowable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\UncheckedExecutionException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */