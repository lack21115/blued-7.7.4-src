package com.google.common.util.concurrent;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class TimeoutFuture<V> extends FluentFuture.TrustedFuture<V> {
  @NullableDecl
  private ListenableFuture<V> a;
  
  @NullableDecl
  private ScheduledFuture<?> b;
  
  protected void afterDone() {
    maybePropagateCancellationTo(this.a);
    ScheduledFuture<?> scheduledFuture = this.b;
    if (scheduledFuture != null)
      scheduledFuture.cancel(false); 
    this.a = null;
    this.b = null;
  }
  
  protected String pendingToString() {
    ListenableFuture<V> listenableFuture = this.a;
    ScheduledFuture<?> scheduledFuture = this.b;
    if (listenableFuture != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("inputFuture=[");
      stringBuilder.append(listenableFuture);
      stringBuilder.append("]");
      String str2 = stringBuilder.toString();
      String str1 = str2;
      if (scheduledFuture != null) {
        long l = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        str1 = str2;
        if (l > 0L) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(str2);
          stringBuilder1.append(", remaining delay=[");
          stringBuilder1.append(l);
          stringBuilder1.append(" ms]");
          str1 = stringBuilder1.toString();
        } 
      } 
      return str1;
    } 
    return null;
  }
  
  static final class Fire<V> implements Runnable {
    @NullableDecl
    TimeoutFuture<V> a;
    
    public void run() {
      // Byte code:
      //   0: aload_0
      //   1: getfield a : Lcom/google/common/util/concurrent/TimeoutFuture;
      //   4: astore #7
      //   6: aload #7
      //   8: ifnonnull -> 12
      //   11: return
      //   12: aload #7
      //   14: invokestatic a : (Lcom/google/common/util/concurrent/TimeoutFuture;)Lcom/google/common/util/concurrent/ListenableFuture;
      //   17: astore #6
      //   19: aload #6
      //   21: ifnonnull -> 25
      //   24: return
      //   25: aload_0
      //   26: aconst_null
      //   27: putfield a : Lcom/google/common/util/concurrent/TimeoutFuture;
      //   30: aload #6
      //   32: invokeinterface isDone : ()Z
      //   37: ifeq -> 49
      //   40: aload #7
      //   42: aload #6
      //   44: invokevirtual setFuture : (Lcom/google/common/util/concurrent/ListenableFuture;)Z
      //   47: pop
      //   48: return
      //   49: aload #7
      //   51: invokestatic b : (Lcom/google/common/util/concurrent/TimeoutFuture;)Ljava/util/concurrent/ScheduledFuture;
      //   54: astore #8
      //   56: aload #7
      //   58: aconst_null
      //   59: invokestatic a : (Lcom/google/common/util/concurrent/TimeoutFuture;Ljava/util/concurrent/ScheduledFuture;)Ljava/util/concurrent/ScheduledFuture;
      //   62: pop
      //   63: ldc 'Timed out'
      //   65: astore #5
      //   67: aload #5
      //   69: astore_3
      //   70: aload #8
      //   72: ifnull -> 168
      //   75: aload #5
      //   77: astore #4
      //   79: aload #8
      //   81: getstatic java/util/concurrent/TimeUnit.MILLISECONDS : Ljava/util/concurrent/TimeUnit;
      //   84: invokeinterface getDelay : (Ljava/util/concurrent/TimeUnit;)J
      //   89: invokestatic abs : (J)J
      //   92: lstore_1
      //   93: aload #5
      //   95: astore_3
      //   96: lload_1
      //   97: ldc2_w 10
      //   100: lcmp
      //   101: ifle -> 168
      //   104: aload #5
      //   106: astore #4
      //   108: new java/lang/StringBuilder
      //   111: dup
      //   112: invokespecial <init> : ()V
      //   115: astore_3
      //   116: aload #5
      //   118: astore #4
      //   120: aload_3
      //   121: ldc 'Timed out'
      //   123: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   126: pop
      //   127: aload #5
      //   129: astore #4
      //   131: aload_3
      //   132: ldc ' (timeout delayed by '
      //   134: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   137: pop
      //   138: aload #5
      //   140: astore #4
      //   142: aload_3
      //   143: lload_1
      //   144: invokevirtual append : (J)Ljava/lang/StringBuilder;
      //   147: pop
      //   148: aload #5
      //   150: astore #4
      //   152: aload_3
      //   153: ldc ' ms after scheduled time)'
      //   155: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   158: pop
      //   159: aload #5
      //   161: astore #4
      //   163: aload_3
      //   164: invokevirtual toString : ()Ljava/lang/String;
      //   167: astore_3
      //   168: aload_3
      //   169: astore #4
      //   171: new java/lang/StringBuilder
      //   174: dup
      //   175: invokespecial <init> : ()V
      //   178: astore #5
      //   180: aload_3
      //   181: astore #4
      //   183: aload #5
      //   185: aload_3
      //   186: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   189: pop
      //   190: aload_3
      //   191: astore #4
      //   193: aload #5
      //   195: ldc ': '
      //   197: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   200: pop
      //   201: aload_3
      //   202: astore #4
      //   204: aload #5
      //   206: aload #6
      //   208: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   211: pop
      //   212: aload_3
      //   213: astore #4
      //   215: aload #5
      //   217: invokevirtual toString : ()Ljava/lang/String;
      //   220: astore_3
      //   221: aload #7
      //   223: new com/google/common/util/concurrent/TimeoutFuture$TimeoutFutureException
      //   226: dup
      //   227: aload_3
      //   228: aconst_null
      //   229: invokespecial <init> : (Ljava/lang/String;Lcom/google/common/util/concurrent/TimeoutFuture$1;)V
      //   232: invokevirtual setException : (Ljava/lang/Throwable;)Z
      //   235: pop
      //   236: aload #6
      //   238: iconst_1
      //   239: invokeinterface cancel : (Z)Z
      //   244: pop
      //   245: return
      //   246: astore_3
      //   247: aload #7
      //   249: new com/google/common/util/concurrent/TimeoutFuture$TimeoutFutureException
      //   252: dup
      //   253: aload #4
      //   255: aconst_null
      //   256: invokespecial <init> : (Ljava/lang/String;Lcom/google/common/util/concurrent/TimeoutFuture$1;)V
      //   259: invokevirtual setException : (Ljava/lang/Throwable;)Z
      //   262: pop
      //   263: aload_3
      //   264: athrow
      //   265: astore_3
      //   266: aload #6
      //   268: iconst_1
      //   269: invokeinterface cancel : (Z)Z
      //   274: pop
      //   275: aload_3
      //   276: athrow
      // Exception table:
      //   from	to	target	type
      //   49	63	265	finally
      //   79	93	246	finally
      //   108	116	246	finally
      //   120	127	246	finally
      //   131	138	246	finally
      //   142	148	246	finally
      //   152	159	246	finally
      //   163	168	246	finally
      //   171	180	246	finally
      //   183	190	246	finally
      //   193	201	246	finally
      //   204	212	246	finally
      //   215	221	246	finally
      //   221	236	265	finally
      //   247	265	265	finally
    }
  }
  
  static final class TimeoutFutureException extends TimeoutException {
    private TimeoutFutureException(String param1String) {
      super(param1String);
    }
    
    public Throwable fillInStackTrace() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: iconst_0
      //   4: anewarray java/lang/StackTraceElement
      //   7: invokevirtual setStackTrace : ([Ljava/lang/StackTraceElement;)V
      //   10: aload_0
      //   11: monitorexit
      //   12: aload_0
      //   13: areturn
      //   14: astore_1
      //   15: aload_0
      //   16: monitorexit
      //   17: aload_1
      //   18: athrow
      // Exception table:
      //   from	to	target	type
      //   2	10	14	finally
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\TimeoutFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */