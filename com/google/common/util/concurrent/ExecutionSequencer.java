package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public final class ExecutionSequencer {
  private final AtomicReference<ListenableFuture<Object>> a = new AtomicReference<ListenableFuture<Object>>(Futures.a((Object)null));
  
  enum RunningState {
    a, b, c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\ExecutionSequencer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */