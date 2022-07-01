package com.amap.api.col.s;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class cg extends cd implements Thread.UncaughtExceptionHandler {
  private static ExecutorService e;
  
  private static Set<Integer> f = Collections.synchronizedSet(new HashSet<Integer>());
  
  private static WeakReference<Context> g;
  
  private static final ThreadFactory h = new ThreadFactory() {
      private final AtomicInteger a = new AtomicInteger(1);
      
      public final Thread newThread(Runnable param1Runnable) {
        StringBuilder stringBuilder = new StringBuilder("pama#");
        stringBuilder.append(this.a.getAndIncrement());
        return new Thread(this, param1Runnable, stringBuilder.toString()) {
            public final void run() {
              try {
                return;
              } finally {
                Exception exception = null;
              } 
            }
          };
      }
    };
  
  private Context d;
  
  private cg(Context paramContext) {
    this.d = paramContext;
    try {
      this.b = Thread.getDefaultUncaughtExceptionHandler();
      if (this.b == null)
        return; 
      String str = this.b.toString();
      if (!str.startsWith("com.amap.apis.utils.core.dynamiccore") && (str.indexOf("com.amap.api") != -1 || str.indexOf("com.loc") != -1))
        return; 
      return;
    } finally {
      paramContext = null;
      paramContext.printStackTrace();
    } 
  }
  
  public static cg a(Context paramContext, br parambr) throws bh {
    // Byte code:
    //   0: ldc com/amap/api/col/s/cg
    //   2: monitorenter
    //   3: aload_1
    //   4: ifnull -> 128
    //   7: aload_1
    //   8: invokevirtual b : ()Ljava/lang/String;
    //   11: ifnull -> 118
    //   14: ldc ''
    //   16: aload_1
    //   17: invokevirtual b : ()Ljava/lang/String;
    //   20: invokevirtual equals : (Ljava/lang/Object;)Z
    //   23: istore_2
    //   24: iload_2
    //   25: ifne -> 118
    //   28: getstatic com/amap/api/col/s/cg.f : Ljava/util/Set;
    //   31: aload_1
    //   32: invokevirtual hashCode : ()I
    //   35: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   38: invokeinterface add : (Ljava/lang/Object;)Z
    //   43: ifne -> 58
    //   46: getstatic com/amap/api/col/s/cd.a : Lcom/amap/api/col/s/cd;
    //   49: checkcast com/amap/api/col/s/cg
    //   52: astore_0
    //   53: ldc com/amap/api/col/s/cg
    //   55: monitorexit
    //   56: aload_0
    //   57: areturn
    //   58: getstatic com/amap/api/col/s/cd.a : Lcom/amap/api/col/s/cd;
    //   61: ifnonnull -> 78
    //   64: new com/amap/api/col/s/cg
    //   67: dup
    //   68: aload_0
    //   69: invokespecial <init> : (Landroid/content/Context;)V
    //   72: putstatic com/amap/api/col/s/cd.a : Lcom/amap/api/col/s/cd;
    //   75: goto -> 85
    //   78: getstatic com/amap/api/col/s/cd.a : Lcom/amap/api/col/s/cd;
    //   81: iconst_0
    //   82: putfield c : Z
    //   85: getstatic com/amap/api/col/s/cd.a : Lcom/amap/api/col/s/cd;
    //   88: aload_1
    //   89: getstatic com/amap/api/col/s/cd.a : Lcom/amap/api/col/s/cd;
    //   92: getfield c : Z
    //   95: invokevirtual a : (Lcom/amap/api/col/s/br;Z)V
    //   98: goto -> 106
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual printStackTrace : ()V
    //   106: getstatic com/amap/api/col/s/cd.a : Lcom/amap/api/col/s/cd;
    //   109: checkcast com/amap/api/col/s/cg
    //   112: astore_0
    //   113: ldc com/amap/api/col/s/cg
    //   115: monitorexit
    //   116: aload_0
    //   117: areturn
    //   118: new com/amap/api/col/s/bh
    //   121: dup
    //   122: ldc 'sdk name is invalid'
    //   124: invokespecial <init> : (Ljava/lang/String;)V
    //   127: athrow
    //   128: new com/amap/api/col/s/bh
    //   131: dup
    //   132: ldc 'sdk info is null'
    //   134: invokespecial <init> : (Ljava/lang/String;)V
    //   137: athrow
    //   138: ldc com/amap/api/col/s/cg
    //   140: monitorexit
    //   141: aload_0
    //   142: athrow
    //   143: astore_0
    //   144: goto -> 138
    // Exception table:
    //   from	to	target	type
    //   7	24	143	finally
    //   28	53	101	finally
    //   58	75	101	finally
    //   78	85	101	finally
    //   85	98	101	finally
    //   102	106	143	finally
    //   106	113	143	finally
    //   118	128	143	finally
    //   128	138	143	finally
  }
  
  public static void a(br parambr, String paramString, bh parambh) {
    a(parambr, paramString, parambh.c(), parambh.d(), parambh.e(), parambh.b());
  }
  
  public static void a(br parambr, String paramString1, String paramString2, String paramString3, String paramString4) {
    a(parambr, paramString1, paramString2, paramString3, "", paramString4);
  }
  
  public static void a(br parambr, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    try {
      return;
    } finally {
      parambr = null;
    } 
  }
  
  public static void b() {
    WeakReference<Context> weakReference = g;
    if (weakReference != null && weakReference.get() != null) {
      ce.a(g.get());
      return;
    } 
    if (cd.a != null)
      cd.a.a(); 
  }
  
  public static void b(br parambr, String paramString1, String paramString2) {
    try {
      return;
    } finally {
      parambr = null;
    } 
  }
  
  public static ExecutorService c() {
    // Byte code:
    //   0: ldc com/amap/api/col/s/cg
    //   2: monitorenter
    //   3: getstatic com/amap/api/col/s/cg.e : Ljava/util/concurrent/ExecutorService;
    //   6: ifnull -> 20
    //   9: getstatic com/amap/api/col/s/cg.e : Ljava/util/concurrent/ExecutorService;
    //   12: invokeinterface isShutdown : ()Z
    //   17: ifeq -> 49
    //   20: new java/util/concurrent/ThreadPoolExecutor
    //   23: dup
    //   24: iconst_1
    //   25: iconst_1
    //   26: lconst_0
    //   27: getstatic java/util/concurrent/TimeUnit.MILLISECONDS : Ljava/util/concurrent/TimeUnit;
    //   30: new java/util/concurrent/LinkedBlockingQueue
    //   33: dup
    //   34: sipush #256
    //   37: invokespecial <init> : (I)V
    //   40: getstatic com/amap/api/col/s/cg.h : Ljava/util/concurrent/ThreadFactory;
    //   43: invokespecial <init> : (IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;)V
    //   46: putstatic com/amap/api/col/s/cg.e : Ljava/util/concurrent/ExecutorService;
    //   49: getstatic com/amap/api/col/s/cg.e : Ljava/util/concurrent/ExecutorService;
    //   52: astore_0
    //   53: ldc com/amap/api/col/s/cg
    //   55: monitorexit
    //   56: aload_0
    //   57: areturn
    //   58: astore_0
    //   59: ldc com/amap/api/col/s/cg
    //   61: monitorexit
    //   62: aload_0
    //   63: athrow
    //   64: astore_0
    //   65: goto -> 49
    // Exception table:
    //   from	to	target	type
    //   3	20	64	finally
    //   20	49	64	finally
    //   49	53	58	finally
  }
  
  public static void c(Throwable paramThrowable, String paramString1, String paramString2) {
    try {
      return;
    } finally {
      paramThrowable = null;
    } 
  }
  
  public static cg d() {
    // Byte code:
    //   0: ldc com/amap/api/col/s/cg
    //   2: monitorenter
    //   3: getstatic com/amap/api/col/s/cd.a : Lcom/amap/api/col/s/cd;
    //   6: checkcast com/amap/api/col/s/cg
    //   9: astore_0
    //   10: ldc com/amap/api/col/s/cg
    //   12: monitorexit
    //   13: aload_0
    //   14: areturn
    //   15: astore_0
    //   16: ldc com/amap/api/col/s/cg
    //   18: monitorexit
    //   19: aload_0
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   3	10	15	finally
  }
  
  protected final void a() {
    ce.a(this.d);
  }
  
  protected final void a(br parambr, String paramString1, String paramString2) {
    ch.a(parambr, this.d, paramString2, paramString1);
  }
  
  protected final void a(br parambr, boolean paramBoolean) {
    try {
      return;
    } catch (RejectedExecutionException rejectedExecutionException) {
      return;
    } finally {
      parambr = null;
      parambr.printStackTrace();
    } 
  }
  
  protected final void a(Throwable paramThrowable, int paramInt, String paramString1, String paramString2) {
    ch.a(this.d, paramThrowable, paramInt, paramString1, paramString2);
  }
  
  public final void b(Throwable paramThrowable, String paramString1, String paramString2) {
    if (paramThrowable == null)
      return; 
    try {
      return;
    } finally {
      paramThrowable = null;
      paramThrowable.printStackTrace();
    } 
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable) {
    if (paramThrowable == null)
      return; 
    a(paramThrowable, 0, (String)null, (String)null);
    if (this.b != null) {
      try {
        Thread.setDefaultUncaughtExceptionHandler(this.b);
      } finally {
        Exception exception;
      } 
      this.b.uncaughtException(paramThread, paramThrowable);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */