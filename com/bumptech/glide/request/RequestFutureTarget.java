package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RequestFutureTarget<R> implements FutureTarget<R>, RequestListener<R> {
  private static final Waiter a = new Waiter();
  
  private final int b;
  
  private final int c;
  
  private final boolean d;
  
  private final Waiter e;
  
  private R f;
  
  private Request g;
  
  private boolean h;
  
  private boolean i;
  
  private boolean j;
  
  private GlideException k;
  
  public RequestFutureTarget(int paramInt1, int paramInt2) {
    this(paramInt1, paramInt2, true, a);
  }
  
  RequestFutureTarget(int paramInt1, int paramInt2, boolean paramBoolean, Waiter paramWaiter) {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramBoolean;
    this.e = paramWaiter;
  }
  
  private R a(Long paramLong) throws ExecutionException, InterruptedException, TimeoutException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield d : Z
    //   6: ifeq -> 19
    //   9: aload_0
    //   10: invokevirtual isDone : ()Z
    //   13: ifne -> 19
    //   16: invokestatic b : ()V
    //   19: aload_0
    //   20: getfield h : Z
    //   23: ifne -> 203
    //   26: aload_0
    //   27: getfield j : Z
    //   30: ifne -> 191
    //   33: aload_0
    //   34: getfield i : Z
    //   37: ifeq -> 49
    //   40: aload_0
    //   41: getfield f : Ljava/lang/Object;
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: areturn
    //   49: aload_1
    //   50: ifnonnull -> 65
    //   53: aload_0
    //   54: getfield e : Lcom/bumptech/glide/request/RequestFutureTarget$Waiter;
    //   57: aload_0
    //   58: lconst_0
    //   59: invokevirtual a : (Ljava/lang/Object;J)V
    //   62: goto -> 119
    //   65: aload_1
    //   66: invokevirtual longValue : ()J
    //   69: lconst_0
    //   70: lcmp
    //   71: ifle -> 119
    //   74: invokestatic currentTimeMillis : ()J
    //   77: lstore_2
    //   78: aload_1
    //   79: invokevirtual longValue : ()J
    //   82: lload_2
    //   83: ladd
    //   84: lstore #4
    //   86: aload_0
    //   87: invokevirtual isDone : ()Z
    //   90: ifne -> 119
    //   93: lload_2
    //   94: lload #4
    //   96: lcmp
    //   97: ifge -> 119
    //   100: aload_0
    //   101: getfield e : Lcom/bumptech/glide/request/RequestFutureTarget$Waiter;
    //   104: aload_0
    //   105: lload #4
    //   107: lload_2
    //   108: lsub
    //   109: invokevirtual a : (Ljava/lang/Object;J)V
    //   112: invokestatic currentTimeMillis : ()J
    //   115: lstore_2
    //   116: goto -> 86
    //   119: invokestatic interrupted : ()Z
    //   122: ifne -> 183
    //   125: aload_0
    //   126: getfield j : Z
    //   129: ifne -> 171
    //   132: aload_0
    //   133: getfield h : Z
    //   136: ifne -> 163
    //   139: aload_0
    //   140: getfield i : Z
    //   143: ifeq -> 155
    //   146: aload_0
    //   147: getfield f : Ljava/lang/Object;
    //   150: astore_1
    //   151: aload_0
    //   152: monitorexit
    //   153: aload_1
    //   154: areturn
    //   155: new java/util/concurrent/TimeoutException
    //   158: dup
    //   159: invokespecial <init> : ()V
    //   162: athrow
    //   163: new java/util/concurrent/CancellationException
    //   166: dup
    //   167: invokespecial <init> : ()V
    //   170: athrow
    //   171: new java/util/concurrent/ExecutionException
    //   174: dup
    //   175: aload_0
    //   176: getfield k : Lcom/bumptech/glide/load/engine/GlideException;
    //   179: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   182: athrow
    //   183: new java/lang/InterruptedException
    //   186: dup
    //   187: invokespecial <init> : ()V
    //   190: athrow
    //   191: new java/util/concurrent/ExecutionException
    //   194: dup
    //   195: aload_0
    //   196: getfield k : Lcom/bumptech/glide/load/engine/GlideException;
    //   199: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   202: athrow
    //   203: new java/util/concurrent/CancellationException
    //   206: dup
    //   207: invokespecial <init> : ()V
    //   210: athrow
    //   211: astore_1
    //   212: aload_0
    //   213: monitorexit
    //   214: aload_1
    //   215: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	211	finally
    //   19	45	211	finally
    //   53	62	211	finally
    //   65	86	211	finally
    //   86	93	211	finally
    //   100	116	211	finally
    //   119	151	211	finally
    //   155	163	211	finally
    //   163	171	211	finally
    //   171	183	211	finally
    //   183	191	211	finally
    //   191	203	211	finally
    //   203	211	211	finally
  }
  
  public Request a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield g : Lcom/bumptech/glide/request/Request;
    //   6: astore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_1
    //   10: areturn
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public void a(Drawable paramDrawable) {}
  
  public void a(Request paramRequest) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: putfield g : Lcom/bumptech/glide/request/Request;
    //   7: aload_0
    //   8: monitorexit
    //   9: return
    //   10: astore_1
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_1
    //   14: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	10	finally
  }
  
  public void a(SizeReadyCallback paramSizeReadyCallback) {
    paramSizeReadyCallback.a(this.b, this.c);
  }
  
  public void a(R paramR, Transition<? super R> paramTransition) {
    /* monitor enter ThisExpression{ObjectType{com/bumptech/glide/request/RequestFutureTarget}} */
    /* monitor exit ThisExpression{ObjectType{com/bumptech/glide/request/RequestFutureTarget}} */
  }
  
  public boolean a(GlideException paramGlideException, Object paramObject, Target<R> paramTarget, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield j : Z
    //   7: aload_0
    //   8: aload_1
    //   9: putfield k : Lcom/bumptech/glide/load/engine/GlideException;
    //   12: aload_0
    //   13: getfield e : Lcom/bumptech/glide/request/RequestFutureTarget$Waiter;
    //   16: aload_0
    //   17: invokevirtual a : (Ljava/lang/Object;)V
    //   20: aload_0
    //   21: monitorexit
    //   22: iconst_0
    //   23: ireturn
    //   24: astore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	24	finally
  }
  
  public boolean a(R paramR, Object paramObject, Target<R> paramTarget, DataSource paramDataSource, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield i : Z
    //   7: aload_0
    //   8: aload_1
    //   9: putfield f : Ljava/lang/Object;
    //   12: aload_0
    //   13: getfield e : Lcom/bumptech/glide/request/RequestFutureTarget$Waiter;
    //   16: aload_0
    //   17: invokevirtual a : (Ljava/lang/Object;)V
    //   20: aload_0
    //   21: monitorexit
    //   22: iconst_0
    //   23: ireturn
    //   24: astore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	24	finally
  }
  
  public void b(Drawable paramDrawable) {
    /* monitor enter ThisExpression{ObjectType{com/bumptech/glide/request/RequestFutureTarget}} */
    /* monitor exit ThisExpression{ObjectType{com/bumptech/glide/request/RequestFutureTarget}} */
  }
  
  public void b(SizeReadyCallback paramSizeReadyCallback) {}
  
  public void c(Drawable paramDrawable) {}
  
  public boolean cancel(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual isDone : ()Z
    //   6: ifeq -> 13
    //   9: aload_0
    //   10: monitorexit
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_0
    //   14: iconst_1
    //   15: putfield h : Z
    //   18: aload_0
    //   19: getfield e : Lcom/bumptech/glide/request/RequestFutureTarget$Waiter;
    //   22: aload_0
    //   23: invokevirtual a : (Ljava/lang/Object;)V
    //   26: iload_1
    //   27: ifeq -> 62
    //   30: aload_0
    //   31: getfield g : Lcom/bumptech/glide/request/Request;
    //   34: astore_2
    //   35: aload_0
    //   36: aconst_null
    //   37: putfield g : Lcom/bumptech/glide/request/Request;
    //   40: goto -> 43
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_2
    //   46: ifnull -> 55
    //   49: aload_2
    //   50: invokeinterface b : ()V
    //   55: iconst_1
    //   56: ireturn
    //   57: astore_2
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_2
    //   61: athrow
    //   62: aconst_null
    //   63: astore_2
    //   64: goto -> 43
    // Exception table:
    //   from	to	target	type
    //   2	11	57	finally
    //   13	26	57	finally
    //   30	40	57	finally
    //   43	45	57	finally
    //   58	60	57	finally
  }
  
  public R get() throws InterruptedException, ExecutionException {
    try {
      return a((Long)null);
    } catch (TimeoutException timeoutException) {
      throw new AssertionError(timeoutException);
    } 
  }
  
  public R get(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException, ExecutionException, TimeoutException {
    return a(Long.valueOf(paramTimeUnit.toMillis(paramLong)));
  }
  
  public boolean isCancelled() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield h : Z
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public boolean isDone() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield h : Z
    //   6: ifne -> 33
    //   9: aload_0
    //   10: getfield i : Z
    //   13: ifne -> 33
    //   16: aload_0
    //   17: getfield j : Z
    //   20: istore_1
    //   21: iload_1
    //   22: ifeq -> 28
    //   25: goto -> 33
    //   28: iconst_0
    //   29: istore_1
    //   30: goto -> 35
    //   33: iconst_1
    //   34: istore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: iload_1
    //   38: ireturn
    //   39: astore_2
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_2
    //   43: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	39	finally
  }
  
  public void o_() {}
  
  public void p_() {}
  
  public void q_() {}
  
  static class Waiter {
    void a(Object param1Object) {
      param1Object.notifyAll();
    }
    
    void a(Object param1Object, long param1Long) throws InterruptedException {
      param1Object.wait(param1Long);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\request\RequestFutureTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */