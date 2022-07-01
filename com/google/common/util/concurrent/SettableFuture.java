package com.google.common.util.concurrent;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class SettableFuture<V> extends AbstractFuture.TrustedFuture<V> {
  public static <V> SettableFuture<V> a() {
    return new SettableFuture<V>();
  }
  
  public boolean set(@NullableDecl V paramV) {
    return super.set(paramV);
  }
  
  public boolean setException(Throwable paramThrowable) {
    return super.setException(paramThrowable);
  }
  
  public boolean setFuture(ListenableFuture<? extends V> paramListenableFuture) {
    return super.setFuture(paramListenableFuture);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\SettableFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */