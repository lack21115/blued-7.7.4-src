package com.google.common.util.concurrent;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class ExecutionError extends Error {
  protected ExecutionError() {}
  
  public ExecutionError(@NullableDecl Error paramError) {
    super(paramError);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\ExecutionError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */