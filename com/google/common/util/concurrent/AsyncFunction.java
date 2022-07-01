package com.google.common.util.concurrent;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public interface AsyncFunction<I, O> {
  ListenableFuture<O> a(@NullableDecl I paramI) throws Exception;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\AsyncFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */