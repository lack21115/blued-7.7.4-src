package com.tencent.bugly.proguard;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class w {
  private static final AtomicInteger a = new AtomicInteger(1);
  
  private static w b;
  
  private ScheduledExecutorService c = null;
  
  protected w() {
    this.c = Executors.newScheduledThreadPool(3, new ThreadFactory(this) {
          public final Thread newThread(Runnable param1Runnable) {
            param1Runnable = new Thread(param1Runnable);
            StringBuilder stringBuilder = new StringBuilder("BuglyThread-");
            stringBuilder.append(w.d().getAndIncrement());
            param1Runnable.setName(stringBuilder.toString());
            return (Thread)param1Runnable;
          }
        });
    ScheduledExecutorService scheduledExecutorService = this.c;
    if (scheduledExecutorService == null || scheduledExecutorService.isShutdown())
      x.d("[AsyncTaskHandler] ScheduledExecutorService is not valiable!", new Object[0]); 
  }
  
  public static w a() {
    // Byte code:
    //   0: ldc com/tencent/bugly/proguard/w
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/proguard/w.b : Lcom/tencent/bugly/proguard/w;
    //   6: ifnonnull -> 19
    //   9: new com/tencent/bugly/proguard/w
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/tencent/bugly/proguard/w.b : Lcom/tencent/bugly/proguard/w;
    //   19: getstatic com/tencent/bugly/proguard/w.b : Lcom/tencent/bugly/proguard/w;
    //   22: astore_0
    //   23: ldc com/tencent/bugly/proguard/w
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/tencent/bugly/proguard/w
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	23	28	finally
  }
  
  public final boolean a(Runnable paramRunnable) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual c : ()Z
    //   6: ifne -> 23
    //   9: ldc '[AsyncTaskHandler] Async handler was closed, should not post task.'
    //   11: iconst_0
    //   12: anewarray java/lang/Object
    //   15: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   18: pop
    //   19: aload_0
    //   20: monitorexit
    //   21: iconst_0
    //   22: ireturn
    //   23: aload_1
    //   24: ifnonnull -> 41
    //   27: ldc '[AsyncTaskHandler] Task input is null.'
    //   29: iconst_0
    //   30: anewarray java/lang/Object
    //   33: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   36: pop
    //   37: aload_0
    //   38: monitorexit
    //   39: iconst_0
    //   40: ireturn
    //   41: ldc '[AsyncTaskHandler] Post a normal task: %s'
    //   43: iconst_1
    //   44: anewarray java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: aload_1
    //   50: invokevirtual getClass : ()Ljava/lang/Class;
    //   53: invokevirtual getName : ()Ljava/lang/String;
    //   56: aastore
    //   57: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   60: pop
    //   61: aload_0
    //   62: getfield c : Ljava/util/concurrent/ScheduledExecutorService;
    //   65: aload_1
    //   66: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   71: aload_0
    //   72: monitorexit
    //   73: iconst_1
    //   74: ireturn
    //   75: astore_1
    //   76: getstatic com/tencent/bugly/b.c : Z
    //   79: ifeq -> 86
    //   82: aload_1
    //   83: invokevirtual printStackTrace : ()V
    //   86: aload_0
    //   87: monitorexit
    //   88: iconst_0
    //   89: ireturn
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	90	finally
    //   27	37	90	finally
    //   41	61	90	finally
    //   61	71	75	finally
    //   76	86	90	finally
  }
  
  public final boolean a(Runnable paramRunnable, long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual c : ()Z
    //   6: ifne -> 23
    //   9: ldc '[AsyncTaskHandler] Async handler was closed, should not post task.'
    //   11: iconst_0
    //   12: anewarray java/lang/Object
    //   15: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   18: pop
    //   19: aload_0
    //   20: monitorexit
    //   21: iconst_0
    //   22: ireturn
    //   23: aload_1
    //   24: ifnonnull -> 41
    //   27: ldc '[AsyncTaskHandler] Task input is null.'
    //   29: iconst_0
    //   30: anewarray java/lang/Object
    //   33: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   36: pop
    //   37: aload_0
    //   38: monitorexit
    //   39: iconst_0
    //   40: ireturn
    //   41: lload_2
    //   42: lconst_0
    //   43: lcmp
    //   44: ifle -> 50
    //   47: goto -> 52
    //   50: lconst_0
    //   51: lstore_2
    //   52: ldc '[AsyncTaskHandler] Post a delay(time: %dms) task: %s'
    //   54: iconst_2
    //   55: anewarray java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: lload_2
    //   61: invokestatic valueOf : (J)Ljava/lang/Long;
    //   64: aastore
    //   65: dup
    //   66: iconst_1
    //   67: aload_1
    //   68: invokevirtual getClass : ()Ljava/lang/Class;
    //   71: invokevirtual getName : ()Ljava/lang/String;
    //   74: aastore
    //   75: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   78: pop
    //   79: aload_0
    //   80: getfield c : Ljava/util/concurrent/ScheduledExecutorService;
    //   83: aload_1
    //   84: lload_2
    //   85: getstatic java/util/concurrent/TimeUnit.MILLISECONDS : Ljava/util/concurrent/TimeUnit;
    //   88: invokeinterface schedule : (Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;
    //   93: pop
    //   94: aload_0
    //   95: monitorexit
    //   96: iconst_1
    //   97: ireturn
    //   98: astore_1
    //   99: getstatic com/tencent/bugly/b.c : Z
    //   102: ifeq -> 109
    //   105: aload_1
    //   106: invokevirtual printStackTrace : ()V
    //   109: aload_0
    //   110: monitorexit
    //   111: iconst_0
    //   112: ireturn
    //   113: astore_1
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_1
    //   117: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	113	finally
    //   27	37	113	finally
    //   52	79	113	finally
    //   79	94	98	finally
    //   99	109	113	finally
  }
  
  public final void b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : Ljava/util/concurrent/ScheduledExecutorService;
    //   6: ifnull -> 41
    //   9: aload_0
    //   10: getfield c : Ljava/util/concurrent/ScheduledExecutorService;
    //   13: invokeinterface isShutdown : ()Z
    //   18: ifne -> 41
    //   21: ldc '[AsyncTaskHandler] Close async handler.'
    //   23: iconst_0
    //   24: anewarray java/lang/Object
    //   27: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   30: pop
    //   31: aload_0
    //   32: getfield c : Ljava/util/concurrent/ScheduledExecutorService;
    //   35: invokeinterface shutdownNow : ()Ljava/util/List;
    //   40: pop
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Exception table:
    //   from	to	target	type
    //   2	41	44	finally
  }
  
  public final boolean c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : Ljava/util/concurrent/ScheduledExecutorService;
    //   6: ifnull -> 29
    //   9: aload_0
    //   10: getfield c : Ljava/util/concurrent/ScheduledExecutorService;
    //   13: invokeinterface isShutdown : ()Z
    //   18: istore_1
    //   19: iload_1
    //   20: ifne -> 29
    //   23: iconst_1
    //   24: istore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: iload_1
    //   28: ireturn
    //   29: iconst_0
    //   30: istore_1
    //   31: goto -> 25
    //   34: astore_2
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	34	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\proguard\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */