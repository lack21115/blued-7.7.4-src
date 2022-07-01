package com.bytedance.sdk.adnet.b;

import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.n;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class i<T> implements n.a<T>, Future<n<T>> {
  private Request<?> a;
  
  private boolean b = false;
  
  private n<T> c;
  
  public static <E> i<E> a() {
    return new i<E>();
  }
  
  private n<T> a(Long paramLong) throws InterruptedException, TimeoutException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Z
    //   6: ifeq -> 18
    //   9: aload_0
    //   10: getfield c : Lcom/bytedance/sdk/adnet/core/n;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_1
    //   19: ifnonnull -> 37
    //   22: aload_0
    //   23: invokevirtual isDone : ()Z
    //   26: ifne -> 87
    //   29: aload_0
    //   30: lconst_0
    //   31: invokevirtual wait : (J)V
    //   34: goto -> 22
    //   37: aload_1
    //   38: invokevirtual longValue : ()J
    //   41: lconst_0
    //   42: lcmp
    //   43: ifle -> 87
    //   46: invokestatic uptimeMillis : ()J
    //   49: lstore_2
    //   50: aload_1
    //   51: invokevirtual longValue : ()J
    //   54: lload_2
    //   55: ladd
    //   56: lstore #4
    //   58: aload_0
    //   59: invokevirtual isDone : ()Z
    //   62: ifne -> 87
    //   65: lload_2
    //   66: lload #4
    //   68: lcmp
    //   69: ifge -> 87
    //   72: aload_0
    //   73: lload #4
    //   75: lload_2
    //   76: lsub
    //   77: invokevirtual wait : (J)V
    //   80: invokestatic uptimeMillis : ()J
    //   83: lstore_2
    //   84: goto -> 58
    //   87: aload_0
    //   88: getfield b : Z
    //   91: ifeq -> 103
    //   94: aload_0
    //   95: getfield c : Lcom/bytedance/sdk/adnet/core/n;
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_1
    //   102: areturn
    //   103: new java/util/concurrent/TimeoutException
    //   106: dup
    //   107: invokespecial <init> : ()V
    //   110: athrow
    //   111: astore_1
    //   112: aload_0
    //   113: monitorexit
    //   114: aload_1
    //   115: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	111	finally
    //   22	34	111	finally
    //   37	58	111	finally
    //   58	65	111	finally
    //   72	84	111	finally
    //   87	99	111	finally
    //   103	111	111	finally
  }
  
  public n<T> a(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException, TimeoutException {
    return a(Long.valueOf(TimeUnit.MILLISECONDS.convert(paramLong, paramTimeUnit)));
  }
  
  public void a(n<T> paramn) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield b : Z
    //   7: aload_0
    //   8: aload_1
    //   9: putfield c : Lcom/bytedance/sdk/adnet/core/n;
    //   12: aload_0
    //   13: invokevirtual notifyAll : ()V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	19	finally
  }
  
  public n<T> b() throws InterruptedException {
    try {
      return a((Long)null);
    } catch (TimeoutException timeoutException) {
      throw new AssertionError(timeoutException);
    } 
  }
  
  public void b(n<T> paramn) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield b : Z
    //   7: aload_0
    //   8: aload_1
    //   9: putfield c : Lcom/bytedance/sdk/adnet/core/n;
    //   12: aload_0
    //   13: invokevirtual notifyAll : ()V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	19	finally
  }
  
  public boolean cancel(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Lcom/bytedance/sdk/adnet/core/Request;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: iconst_0
    //   14: ireturn
    //   15: aload_0
    //   16: invokevirtual isDone : ()Z
    //   19: ifne -> 33
    //   22: aload_0
    //   23: getfield a : Lcom/bytedance/sdk/adnet/core/Request;
    //   26: invokevirtual cancel : ()V
    //   29: aload_0
    //   30: monitorexit
    //   31: iconst_1
    //   32: ireturn
    //   33: aload_0
    //   34: monitorexit
    //   35: iconst_0
    //   36: ireturn
    //   37: astore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_2
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	37	finally
    //   15	29	37	finally
  }
  
  public boolean isCancelled() {
    Request<?> request = this.a;
    return (request == null) ? false : request.isCanceled();
  }
  
  public boolean isDone() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Z
    //   6: ifne -> 26
    //   9: aload_0
    //   10: invokevirtual isCancelled : ()Z
    //   13: istore_1
    //   14: iload_1
    //   15: ifeq -> 21
    //   18: goto -> 26
    //   21: iconst_0
    //   22: istore_1
    //   23: goto -> 28
    //   26: iconst_1
    //   27: istore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_1
    //   31: ireturn
    //   32: astore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	32	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\b\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */