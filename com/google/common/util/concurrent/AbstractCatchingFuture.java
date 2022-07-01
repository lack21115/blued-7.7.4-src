package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class AbstractCatchingFuture<V, X extends Throwable, F, T> extends FluentFuture.TrustedFuture<V> implements Runnable {
  @NullableDecl
  ListenableFuture<? extends V> a;
  
  @NullableDecl
  Class<X> b;
  
  @NullableDecl
  F c;
  
  @NullableDecl
  abstract T a(F paramF, X paramX) throws Exception;
  
  abstract void a(@NullableDecl T paramT);
  
  protected final void afterDone() {
    maybePropagateCancellationTo(this.a);
    this.a = null;
    this.b = null;
    this.c = null;
  }
  
  protected String pendingToString() {
    String str1;
    StringBuilder stringBuilder;
    ListenableFuture<? extends V> listenableFuture = this.a;
    Class<X> clazz = this.b;
    F f = this.c;
    String str2 = super.pendingToString();
    if (listenableFuture != null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("inputFuture=[");
      stringBuilder1.append(listenableFuture);
      stringBuilder1.append("], ");
      str1 = stringBuilder1.toString();
    } else {
      str1 = "";
    } 
    if (clazz != null && f != null) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(str1);
      stringBuilder.append("exceptionType=[");
      stringBuilder.append(clazz);
      stringBuilder.append("], fallback=[");
      stringBuilder.append(f);
      stringBuilder.append("]");
      return stringBuilder.toString();
    } 
    if (stringBuilder != null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str1);
      stringBuilder1.append((String)stringBuilder);
      return stringBuilder1.toString();
    } 
    return null;
  }
  
  public final void run() {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Lcom/google/common/util/concurrent/ListenableFuture;
    //   4: astore #7
    //   6: aload_0
    //   7: getfield b : Ljava/lang/Class;
    //   10: astore #8
    //   12: aload_0
    //   13: getfield c : Ljava/lang/Object;
    //   16: astore #9
    //   18: iconst_1
    //   19: istore_3
    //   20: aload #7
    //   22: ifnonnull -> 30
    //   25: iconst_1
    //   26: istore_1
    //   27: goto -> 32
    //   30: iconst_0
    //   31: istore_1
    //   32: aload #8
    //   34: ifnonnull -> 42
    //   37: iconst_1
    //   38: istore_2
    //   39: goto -> 44
    //   42: iconst_0
    //   43: istore_2
    //   44: aload #9
    //   46: ifnonnull -> 52
    //   49: goto -> 54
    //   52: iconst_0
    //   53: istore_3
    //   54: iload_3
    //   55: iload_1
    //   56: iload_2
    //   57: ior
    //   58: ior
    //   59: ifne -> 318
    //   62: aload_0
    //   63: invokevirtual isCancelled : ()Z
    //   66: ifeq -> 70
    //   69: return
    //   70: aload_0
    //   71: aconst_null
    //   72: putfield a : Lcom/google/common/util/concurrent/ListenableFuture;
    //   75: aload #7
    //   77: instanceof com/google/common/util/concurrent/internal/InternalFutureFailureAccess
    //   80: ifeq -> 319
    //   83: aload #7
    //   85: checkcast com/google/common/util/concurrent/internal/InternalFutureFailureAccess
    //   88: invokestatic a : (Lcom/google/common/util/concurrent/internal/InternalFutureFailureAccess;)Ljava/lang/Throwable;
    //   91: astore #4
    //   93: goto -> 96
    //   96: aload #4
    //   98: astore #5
    //   100: aload #4
    //   102: ifnonnull -> 117
    //   105: aload #7
    //   107: invokestatic a : (Ljava/util/concurrent/Future;)Ljava/lang/Object;
    //   110: astore #5
    //   112: goto -> 225
    //   115: astore #5
    //   117: aconst_null
    //   118: astore #6
    //   120: aload #5
    //   122: astore #4
    //   124: aload #6
    //   126: astore #5
    //   128: goto -> 225
    //   131: astore #6
    //   133: aload #6
    //   135: invokevirtual getCause : ()Ljava/lang/Throwable;
    //   138: astore #5
    //   140: aload #5
    //   142: astore #4
    //   144: aload #5
    //   146: ifnonnull -> 218
    //   149: new java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial <init> : ()V
    //   156: astore #4
    //   158: aload #4
    //   160: ldc 'Future type '
    //   162: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload #4
    //   168: aload #7
    //   170: invokevirtual getClass : ()Ljava/lang/Class;
    //   173: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload #4
    //   179: ldc ' threw '
    //   181: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload #4
    //   187: aload #6
    //   189: invokevirtual getClass : ()Ljava/lang/Class;
    //   192: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload #4
    //   198: ldc ' without a cause'
    //   200: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: new java/lang/NullPointerException
    //   207: dup
    //   208: aload #4
    //   210: invokevirtual toString : ()Ljava/lang/String;
    //   213: invokespecial <init> : (Ljava/lang/String;)V
    //   216: astore #4
    //   218: aload #4
    //   220: astore #5
    //   222: goto -> 117
    //   225: aload #4
    //   227: ifnonnull -> 238
    //   230: aload_0
    //   231: aload #5
    //   233: invokevirtual set : (Ljava/lang/Object;)Z
    //   236: pop
    //   237: return
    //   238: aload #4
    //   240: aload #8
    //   242: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/Class;)Z
    //   245: ifne -> 256
    //   248: aload_0
    //   249: aload #7
    //   251: invokevirtual setFuture : (Lcom/google/common/util/concurrent/ListenableFuture;)Z
    //   254: pop
    //   255: return
    //   256: aload_0
    //   257: aload #9
    //   259: aload #4
    //   261: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Throwable;)Ljava/lang/Object;
    //   264: astore #4
    //   266: aload_0
    //   267: aconst_null
    //   268: putfield b : Ljava/lang/Class;
    //   271: aload_0
    //   272: aconst_null
    //   273: putfield c : Ljava/lang/Object;
    //   276: aload_0
    //   277: aload #4
    //   279: invokevirtual a : (Ljava/lang/Object;)V
    //   282: return
    //   283: astore #4
    //   285: aload_0
    //   286: aload #4
    //   288: invokevirtual setException : (Ljava/lang/Throwable;)Z
    //   291: pop
    //   292: aload_0
    //   293: aconst_null
    //   294: putfield b : Ljava/lang/Class;
    //   297: aload_0
    //   298: aconst_null
    //   299: putfield c : Ljava/lang/Object;
    //   302: return
    //   303: astore #4
    //   305: aload_0
    //   306: aconst_null
    //   307: putfield b : Ljava/lang/Class;
    //   310: aload_0
    //   311: aconst_null
    //   312: putfield c : Ljava/lang/Object;
    //   315: aload #4
    //   317: athrow
    //   318: return
    //   319: aconst_null
    //   320: astore #4
    //   322: goto -> 96
    // Exception table:
    //   from	to	target	type
    //   75	93	131	java/util/concurrent/ExecutionException
    //   75	93	115	finally
    //   105	112	131	java/util/concurrent/ExecutionException
    //   105	112	115	finally
    //   256	266	283	finally
    //   285	292	303	finally
  }
  
  static final class AsyncCatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, AsyncFunction<? super X, ? extends V>, ListenableFuture<? extends V>> {
    ListenableFuture<? extends V> a(AsyncFunction<? super X, ? extends V> param1AsyncFunction, X param1X) throws Exception {
      ListenableFuture<? extends V> listenableFuture = param1AsyncFunction.a(param1X);
      Preconditions.a(listenableFuture, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", param1AsyncFunction);
      return listenableFuture;
    }
    
    void a(ListenableFuture<? extends V> param1ListenableFuture) {
      setFuture(param1ListenableFuture);
    }
  }
  
  static final class CatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, Function<? super X, ? extends V>, V> {
    @NullableDecl
    V a(Function<? super X, ? extends V> param1Function, X param1X) throws Exception {
      return (V)param1Function.f(param1X);
    }
    
    void a(@NullableDecl V param1V) {
      set(param1V);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\AbstractCatchingFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */