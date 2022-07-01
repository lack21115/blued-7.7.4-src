package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

final class SequentialExecutor implements Executor {
  private static final Logger a = Logger.getLogger(SequentialExecutor.class.getName());
  
  private final Executor b;
  
  private final Deque<Runnable> c;
  
  private WorkerRunningState d;
  
  private long e;
  
  private final QueueWorker f;
  
  public void execute(Runnable paramRunnable) {
    Preconditions.a(paramRunnable);
    synchronized (this.c) {
      if (this.d == WorkerRunningState.d || this.d == WorkerRunningState.c) {
        this.c.add(paramRunnable);
        return;
      } 
      long l = this.e;
      Runnable runnable = new Runnable(this, paramRunnable) {
          public void run() {
            this.a.run();
          }
        };
      this.c.add(runnable);
      this.d = WorkerRunningState.b;
      boolean bool2 = true;
      boolean bool1 = true;
      try {
        this.b.execute(this.f);
        if (this.d == WorkerRunningState.b)
          bool1 = false; 
        if (bool1)
          return; 
        synchronized (this.c) {
          if (this.e == l && this.d == WorkerRunningState.b)
            this.d = WorkerRunningState.c; 
          return;
        } 
      } catch (RuntimeException runtimeException) {
      
      } catch (Error null) {}
      synchronized (this.c) {
        if ((this.d == WorkerRunningState.a || this.d == WorkerRunningState.b) && this.c.removeLastOccurrence(runnable)) {
          bool1 = bool2;
        } else {
          bool1 = false;
        } 
        if (null instanceof java.util.concurrent.RejectedExecutionException && !bool1)
          return; 
        throw null;
      } 
    } 
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SequentialExecutor@");
    stringBuilder.append(System.identityHashCode(this));
    stringBuilder.append("{");
    stringBuilder.append(this.b);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
  
  final class QueueWorker implements Runnable {
    private void a() {
      // Byte code:
      //   0: iconst_0
      //   1: istore_2
      //   2: iconst_0
      //   3: istore_1
      //   4: iload_1
      //   5: istore #4
      //   7: aload_0
      //   8: getfield a : Lcom/google/common/util/concurrent/SequentialExecutor;
      //   11: invokestatic a : (Lcom/google/common/util/concurrent/SequentialExecutor;)Ljava/util/Deque;
      //   14: astore #7
      //   16: iload_1
      //   17: istore #4
      //   19: aload #7
      //   21: monitorenter
      //   22: iload_2
      //   23: istore_3
      //   24: iload_2
      //   25: ifne -> 76
      //   28: aload_0
      //   29: getfield a : Lcom/google/common/util/concurrent/SequentialExecutor;
      //   32: invokestatic b : (Lcom/google/common/util/concurrent/SequentialExecutor;)Lcom/google/common/util/concurrent/SequentialExecutor$WorkerRunningState;
      //   35: getstatic com/google/common/util/concurrent/SequentialExecutor$WorkerRunningState.d : Lcom/google/common/util/concurrent/SequentialExecutor$WorkerRunningState;
      //   38: if_acmpne -> 55
      //   41: aload #7
      //   43: monitorexit
      //   44: iload_1
      //   45: ifeq -> 54
      //   48: invokestatic currentThread : ()Ljava/lang/Thread;
      //   51: invokevirtual interrupt : ()V
      //   54: return
      //   55: aload_0
      //   56: getfield a : Lcom/google/common/util/concurrent/SequentialExecutor;
      //   59: invokestatic c : (Lcom/google/common/util/concurrent/SequentialExecutor;)J
      //   62: pop2
      //   63: aload_0
      //   64: getfield a : Lcom/google/common/util/concurrent/SequentialExecutor;
      //   67: getstatic com/google/common/util/concurrent/SequentialExecutor$WorkerRunningState.d : Lcom/google/common/util/concurrent/SequentialExecutor$WorkerRunningState;
      //   70: invokestatic a : (Lcom/google/common/util/concurrent/SequentialExecutor;Lcom/google/common/util/concurrent/SequentialExecutor$WorkerRunningState;)Lcom/google/common/util/concurrent/SequentialExecutor$WorkerRunningState;
      //   73: pop
      //   74: iconst_1
      //   75: istore_3
      //   76: aload_0
      //   77: getfield a : Lcom/google/common/util/concurrent/SequentialExecutor;
      //   80: invokestatic a : (Lcom/google/common/util/concurrent/SequentialExecutor;)Ljava/util/Deque;
      //   83: invokeinterface poll : ()Ljava/lang/Object;
      //   88: checkcast java/lang/Runnable
      //   91: astore #6
      //   93: aload #6
      //   95: ifnonnull -> 123
      //   98: aload_0
      //   99: getfield a : Lcom/google/common/util/concurrent/SequentialExecutor;
      //   102: getstatic com/google/common/util/concurrent/SequentialExecutor$WorkerRunningState.a : Lcom/google/common/util/concurrent/SequentialExecutor$WorkerRunningState;
      //   105: invokestatic a : (Lcom/google/common/util/concurrent/SequentialExecutor;Lcom/google/common/util/concurrent/SequentialExecutor$WorkerRunningState;)Lcom/google/common/util/concurrent/SequentialExecutor$WorkerRunningState;
      //   108: pop
      //   109: aload #7
      //   111: monitorexit
      //   112: iload_1
      //   113: ifeq -> 122
      //   116: invokestatic currentThread : ()Ljava/lang/Thread;
      //   119: invokevirtual interrupt : ()V
      //   122: return
      //   123: aload #7
      //   125: monitorexit
      //   126: iload_1
      //   127: istore #4
      //   129: invokestatic interrupted : ()Z
      //   132: istore #5
      //   134: iload_1
      //   135: iload #5
      //   137: ior
      //   138: istore_1
      //   139: iload_1
      //   140: istore #4
      //   142: aload #6
      //   144: invokeinterface run : ()V
      //   149: iload_3
      //   150: istore_2
      //   151: goto -> 4
      //   154: astore #7
      //   156: iload_1
      //   157: istore #4
      //   159: invokestatic a : ()Ljava/util/logging/Logger;
      //   162: astore #8
      //   164: iload_1
      //   165: istore #4
      //   167: getstatic java/util/logging/Level.SEVERE : Ljava/util/logging/Level;
      //   170: astore #9
      //   172: iload_1
      //   173: istore #4
      //   175: new java/lang/StringBuilder
      //   178: dup
      //   179: invokespecial <init> : ()V
      //   182: astore #10
      //   184: iload_1
      //   185: istore #4
      //   187: aload #10
      //   189: ldc 'Exception while executing runnable '
      //   191: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   194: pop
      //   195: iload_1
      //   196: istore #4
      //   198: aload #10
      //   200: aload #6
      //   202: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   205: pop
      //   206: iload_1
      //   207: istore #4
      //   209: aload #8
      //   211: aload #9
      //   213: aload #10
      //   215: invokevirtual toString : ()Ljava/lang/String;
      //   218: aload #7
      //   220: invokevirtual log : (Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   223: iload_3
      //   224: istore_2
      //   225: goto -> 4
      //   228: astore #6
      //   230: aload #7
      //   232: monitorexit
      //   233: iload_1
      //   234: istore #4
      //   236: aload #6
      //   238: athrow
      //   239: astore #6
      //   241: iload #4
      //   243: ifeq -> 252
      //   246: invokestatic currentThread : ()Ljava/lang/Thread;
      //   249: invokevirtual interrupt : ()V
      //   252: aload #6
      //   254: athrow
      // Exception table:
      //   from	to	target	type
      //   7	16	239	finally
      //   19	22	239	finally
      //   28	44	228	finally
      //   55	74	228	finally
      //   76	93	228	finally
      //   98	112	228	finally
      //   123	126	228	finally
      //   129	134	239	finally
      //   142	149	154	java/lang/RuntimeException
      //   142	149	239	finally
      //   159	164	239	finally
      //   167	172	239	finally
      //   175	184	239	finally
      //   187	195	239	finally
      //   198	206	239	finally
      //   209	223	239	finally
      //   230	233	228	finally
      //   236	239	239	finally
    }
    
    public void run() {
      try {
        a();
        return;
      } catch (Error null) {
        synchronized (SequentialExecutor.a(this.a)) {
          SequentialExecutor.a(this.a, SequentialExecutor.WorkerRunningState.a);
          throw null;
        } 
      } 
    }
  }
  
  enum WorkerRunningState {
    a, b, c, d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\SequentialExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */