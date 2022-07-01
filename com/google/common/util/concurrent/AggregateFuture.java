package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class AggregateFuture<InputT, OutputT> extends AggregateFutureState<OutputT> {
  private static final Logger a = Logger.getLogger(AggregateFuture.class.getName());
  
  @NullableDecl
  private ImmutableCollection<? extends ListenableFuture<? extends InputT>> b;
  
  private final boolean c;
  
  private void a(int paramInt, Future<? extends InputT> paramFuture) {
    try {
      return;
    } catch (ExecutionException executionException) {
      return;
    } finally {
      paramFuture = null;
      a((Throwable)paramFuture);
    } 
  }
  
  private void a(@NullableDecl ImmutableCollection<? extends Future<? extends InputT>> paramImmutableCollection) {
    boolean bool;
    int i = c();
    if (i >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.b(bool, "Less than 0 remaining futures");
    if (i == 0)
      b(paramImmutableCollection); 
  }
  
  private void a(Throwable paramThrowable) {
    Preconditions.a(paramThrowable);
    if (this.c && !setException(paramThrowable) && a(b(), paramThrowable)) {
      b(paramThrowable);
      return;
    } 
    if (paramThrowable instanceof Error)
      b(paramThrowable); 
  }
  
  private static boolean a(Set<Throwable> paramSet, Throwable paramThrowable) {
    while (paramThrowable != null) {
      if (!paramSet.add(paramThrowable))
        return false; 
      paramThrowable = paramThrowable.getCause();
    } 
    return true;
  }
  
  private void b(@NullableDecl ImmutableCollection<? extends Future<? extends InputT>> paramImmutableCollection) {
    if (paramImmutableCollection != null) {
      int i = 0;
      UnmodifiableIterator<Future> unmodifiableIterator = paramImmutableCollection.av_();
      while (unmodifiableIterator.hasNext()) {
        Future<? extends InputT> future = unmodifiableIterator.next();
        if (!future.isCancelled())
          a(i, future); 
        i++;
      } 
    } 
    d();
    a();
    a(ReleaseResourcesReason.b);
  }
  
  private static void b(Throwable paramThrowable) {
    String str;
    if (paramThrowable instanceof Error) {
      str = "Input Future failed with Error";
    } else {
      str = "Got more than one input Future failure. Logging failures after the first";
    } 
    a.log(Level.SEVERE, str, paramThrowable);
  }
  
  abstract void a();
  
  abstract void a(int paramInt, @NullableDecl InputT paramInputT);
  
  void a(ReleaseResourcesReason paramReleaseResourcesReason) {
    Preconditions.a(paramReleaseResourcesReason);
    this.b = null;
  }
  
  final void a(Set<Throwable> paramSet) {
    Preconditions.a(paramSet);
    if (!isCancelled())
      a(paramSet, tryInternalFastPathGetFailure()); 
  }
  
  protected final void afterDone() {
    boolean bool1;
    super.afterDone();
    ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection = this.b;
    a(ReleaseResourcesReason.a);
    boolean bool2 = isCancelled();
    if (immutableCollection != null) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (bool2 & bool1) {
      bool2 = wasInterrupted();
      UnmodifiableIterator<Future> unmodifiableIterator = immutableCollection.av_();
      while (unmodifiableIterator.hasNext())
        ((Future)unmodifiableIterator.next()).cancel(bool2); 
    } 
  }
  
  protected final String pendingToString() {
    ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection = this.b;
    if (immutableCollection != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("futures=");
      stringBuilder.append(immutableCollection);
      return stringBuilder.toString();
    } 
    return super.pendingToString();
  }
  
  enum ReleaseResourcesReason {
    a, b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\AggregateFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */