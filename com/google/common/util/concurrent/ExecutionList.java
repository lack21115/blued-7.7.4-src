package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class ExecutionList {
  private static final Logger a = Logger.getLogger(ExecutionList.class.getName());
  
  @NullableDecl
  private RunnableExecutorPair b;
  
  private boolean c;
  
  private static void b(Runnable paramRunnable, Executor paramExecutor) {
    try {
      paramExecutor.execute(paramRunnable);
      return;
    } catch (RuntimeException runtimeException) {
      Logger logger = a;
      Level level = Level.SEVERE;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("RuntimeException while executing runnable ");
      stringBuilder.append(paramRunnable);
      stringBuilder.append(" with executor ");
      stringBuilder.append(paramExecutor);
      logger.log(level, stringBuilder.toString(), runtimeException);
      return;
    } 
  }
  
  public void a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : Z
    //   6: ifeq -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield c : Z
    //   17: aload_0
    //   18: getfield b : Lcom/google/common/util/concurrent/ExecutionList$RunnableExecutorPair;
    //   21: astore_2
    //   22: aload_0
    //   23: aconst_null
    //   24: putfield b : Lcom/google/common/util/concurrent/ExecutionList$RunnableExecutorPair;
    //   27: aload_0
    //   28: monitorexit
    //   29: aconst_null
    //   30: astore_1
    //   31: aload_1
    //   32: astore_3
    //   33: aload_2
    //   34: ifnull -> 54
    //   37: aload_2
    //   38: getfield c : Lcom/google/common/util/concurrent/ExecutionList$RunnableExecutorPair;
    //   41: astore_3
    //   42: aload_2
    //   43: aload_1
    //   44: putfield c : Lcom/google/common/util/concurrent/ExecutionList$RunnableExecutorPair;
    //   47: aload_2
    //   48: astore_1
    //   49: aload_3
    //   50: astore_2
    //   51: goto -> 31
    //   54: aload_3
    //   55: ifnull -> 77
    //   58: aload_3
    //   59: getfield a : Ljava/lang/Runnable;
    //   62: aload_3
    //   63: getfield b : Ljava/util/concurrent/Executor;
    //   66: invokestatic b : (Ljava/lang/Runnable;Ljava/util/concurrent/Executor;)V
    //   69: aload_3
    //   70: getfield c : Lcom/google/common/util/concurrent/ExecutionList$RunnableExecutorPair;
    //   73: astore_3
    //   74: goto -> 54
    //   77: return
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	78	finally
    //   12	29	78	finally
    //   79	81	78	finally
  }
  
  public void a(Runnable paramRunnable, Executor paramExecutor) {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'Runnable was null.'
    //   3: invokestatic a : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_2
    //   8: ldc 'Executor was null.'
    //   10: invokestatic a : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   13: pop
    //   14: aload_0
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield c : Z
    //   20: ifne -> 43
    //   23: aload_0
    //   24: new com/google/common/util/concurrent/ExecutionList$RunnableExecutorPair
    //   27: dup
    //   28: aload_1
    //   29: aload_2
    //   30: aload_0
    //   31: getfield b : Lcom/google/common/util/concurrent/ExecutionList$RunnableExecutorPair;
    //   34: invokespecial <init> : (Ljava/lang/Runnable;Ljava/util/concurrent/Executor;Lcom/google/common/util/concurrent/ExecutionList$RunnableExecutorPair;)V
    //   37: putfield b : Lcom/google/common/util/concurrent/ExecutionList$RunnableExecutorPair;
    //   40: aload_0
    //   41: monitorexit
    //   42: return
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: aload_2
    //   47: invokestatic b : (Ljava/lang/Runnable;Ljava/util/concurrent/Executor;)V
    //   50: return
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Exception table:
    //   from	to	target	type
    //   16	42	51	finally
    //   43	45	51	finally
    //   52	54	51	finally
  }
  
  static final class RunnableExecutorPair {
    final Runnable a;
    
    final Executor b;
    
    @NullableDecl
    RunnableExecutorPair c;
    
    RunnableExecutorPair(Runnable param1Runnable, Executor param1Executor, RunnableExecutorPair param1RunnableExecutorPair) {
      this.a = param1Runnable;
      this.b = param1Executor;
      this.c = param1RunnableExecutorPair;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\ExecutionList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */