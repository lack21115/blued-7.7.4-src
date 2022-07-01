package com.loc;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class ab extends y implements Thread.UncaughtExceptionHandler {
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
  
  private ab(Context paramContext) {
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
  
  public static ab a(Context paramContext, t paramt) throws j {
    // Byte code:
    //   0: ldc com/loc/ab
    //   2: monitorenter
    //   3: aload_1
    //   4: ifnull -> 128
    //   7: aload_1
    //   8: invokevirtual a : ()Ljava/lang/String;
    //   11: ifnull -> 118
    //   14: ldc ''
    //   16: aload_1
    //   17: invokevirtual a : ()Ljava/lang/String;
    //   20: invokevirtual equals : (Ljava/lang/Object;)Z
    //   23: istore_2
    //   24: iload_2
    //   25: ifne -> 118
    //   28: getstatic com/loc/ab.f : Ljava/util/Set;
    //   31: aload_1
    //   32: invokevirtual hashCode : ()I
    //   35: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   38: invokeinterface add : (Ljava/lang/Object;)Z
    //   43: ifne -> 58
    //   46: getstatic com/loc/y.a : Lcom/loc/y;
    //   49: checkcast com/loc/ab
    //   52: astore_0
    //   53: ldc com/loc/ab
    //   55: monitorexit
    //   56: aload_0
    //   57: areturn
    //   58: getstatic com/loc/y.a : Lcom/loc/y;
    //   61: ifnonnull -> 78
    //   64: new com/loc/ab
    //   67: dup
    //   68: aload_0
    //   69: invokespecial <init> : (Landroid/content/Context;)V
    //   72: putstatic com/loc/y.a : Lcom/loc/y;
    //   75: goto -> 85
    //   78: getstatic com/loc/y.a : Lcom/loc/y;
    //   81: iconst_0
    //   82: putfield c : Z
    //   85: getstatic com/loc/y.a : Lcom/loc/y;
    //   88: aload_1
    //   89: getstatic com/loc/y.a : Lcom/loc/y;
    //   92: getfield c : Z
    //   95: invokevirtual a : (Lcom/loc/t;Z)V
    //   98: goto -> 106
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual printStackTrace : ()V
    //   106: getstatic com/loc/y.a : Lcom/loc/y;
    //   109: checkcast com/loc/ab
    //   112: astore_0
    //   113: ldc com/loc/ab
    //   115: monitorexit
    //   116: aload_0
    //   117: areturn
    //   118: new com/loc/j
    //   121: dup
    //   122: ldc 'sdk name is invalid'
    //   124: invokespecial <init> : (Ljava/lang/String;)V
    //   127: athrow
    //   128: new com/loc/j
    //   131: dup
    //   132: ldc 'sdk info is null'
    //   134: invokespecial <init> : (Ljava/lang/String;)V
    //   137: athrow
    //   138: ldc com/loc/ab
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
  
  public static void a(t paramt, String paramString, j paramj) {
    if (paramj != null)
      a(paramt, paramString, paramj.c(), paramj.d(), paramj.e(), paramj.b()); 
  }
  
  public static void a(t paramt, String paramString1, String paramString2, String paramString3, String paramString4) {
    a(paramt, paramString1, paramString2, paramString3, "", paramString4);
  }
  
  public static void a(t paramt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    try {
      return;
    } finally {
      paramt = null;
    } 
  }
  
  public static void b() {
    // Byte code:
    //   0: ldc com/loc/ab
    //   2: monitorenter
    //   3: getstatic com/loc/ab.e : Ljava/util/concurrent/ExecutorService;
    //   6: ifnull -> 17
    //   9: getstatic com/loc/ab.e : Ljava/util/concurrent/ExecutorService;
    //   12: invokeinterface shutdown : ()V
    //   17: invokestatic a : ()V
    //   20: goto -> 28
    //   23: astore_0
    //   24: aload_0
    //   25: invokevirtual printStackTrace : ()V
    //   28: getstatic com/loc/y.a : Lcom/loc/y;
    //   31: ifnull -> 61
    //   34: invokestatic getDefaultUncaughtExceptionHandler : ()Ljava/lang/Thread$UncaughtExceptionHandler;
    //   37: getstatic com/loc/y.a : Lcom/loc/y;
    //   40: if_acmpne -> 61
    //   43: getstatic com/loc/y.a : Lcom/loc/y;
    //   46: getfield b : Ljava/lang/Thread$UncaughtExceptionHandler;
    //   49: ifnull -> 61
    //   52: getstatic com/loc/y.a : Lcom/loc/y;
    //   55: getfield b : Ljava/lang/Thread$UncaughtExceptionHandler;
    //   58: invokestatic setDefaultUncaughtExceptionHandler : (Ljava/lang/Thread$UncaughtExceptionHandler;)V
    //   61: aconst_null
    //   62: putstatic com/loc/y.a : Lcom/loc/y;
    //   65: ldc com/loc/ab
    //   67: monitorexit
    //   68: return
    //   69: astore_0
    //   70: aload_0
    //   71: invokevirtual printStackTrace : ()V
    //   74: ldc com/loc/ab
    //   76: monitorexit
    //   77: return
    //   78: astore_0
    //   79: ldc com/loc/ab
    //   81: monitorexit
    //   82: aload_0
    //   83: athrow
    // Exception table:
    //   from	to	target	type
    //   3	17	23	finally
    //   17	20	23	finally
    //   24	28	78	finally
    //   28	61	69	finally
    //   61	65	69	finally
    //   70	74	78	finally
  }
  
  public static void b(t paramt, String paramString1, String paramString2) {
    try {
      return;
    } finally {
      paramt = null;
    } 
  }
  
  public static void b(Throwable paramThrowable, String paramString1, String paramString2) {
    try {
      return;
    } finally {
      paramThrowable = null;
    } 
  }
  
  public static void c() {
    WeakReference<Context> weakReference = g;
    if (weakReference != null && weakReference.get() != null) {
      z.a(g.get());
      return;
    } 
    if (y.a != null)
      y.a.a(); 
  }
  
  public static ExecutorService d() {
    // Byte code:
    //   0: ldc com/loc/ab
    //   2: monitorenter
    //   3: getstatic com/loc/ab.e : Ljava/util/concurrent/ExecutorService;
    //   6: ifnull -> 20
    //   9: getstatic com/loc/ab.e : Ljava/util/concurrent/ExecutorService;
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
    //   40: getstatic com/loc/ab.h : Ljava/util/concurrent/ThreadFactory;
    //   43: invokespecial <init> : (IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;)V
    //   46: putstatic com/loc/ab.e : Ljava/util/concurrent/ExecutorService;
    //   49: getstatic com/loc/ab.e : Ljava/util/concurrent/ExecutorService;
    //   52: astore_0
    //   53: ldc com/loc/ab
    //   55: monitorexit
    //   56: aload_0
    //   57: areturn
    //   58: astore_0
    //   59: ldc com/loc/ab
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
  
  protected final void a() {
    z.a(this.d);
  }
  
  protected final void a(t paramt, String paramString1, String paramString2) {
    ac.a(paramt, this.d, paramString2, paramString1);
  }
  
  protected final void a(t paramt, boolean paramBoolean) {
    try {
      return;
    } catch (RejectedExecutionException rejectedExecutionException) {
      return;
    } finally {
      paramt = null;
      paramt.printStackTrace();
    } 
  }
  
  protected final void a(Throwable paramThrowable, int paramInt, String paramString1, String paramString2) {
    ac.a(this.d, paramThrowable, paramInt, paramString1, paramString2);
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */