package com.amap.api.mapcore2d;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class do extends dl implements Thread.UncaughtExceptionHandler {
  private static ExecutorService e;
  
  private static Set<Integer> f = Collections.synchronizedSet(new HashSet<Integer>());
  
  private static WeakReference<Context> g;
  
  private static final ThreadFactory h = new ThreadFactory() {
      private final AtomicInteger a = new AtomicInteger(1);
      
      public Thread newThread(Runnable param1Runnable) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("pama#");
        stringBuilder.append(this.a.getAndIncrement());
        return new Thread(param1Runnable, stringBuilder.toString());
      }
    };
  
  private Context d;
  
  private List<a> i;
  
  private do(Context paramContext, da paramda) {
    this.d = paramContext;
    f();
  }
  
  public static do a(Context paramContext, da paramda) throws cp {
    // Byte code:
    //   0: ldc com/amap/api/mapcore2d/do
    //   2: monitorenter
    //   3: aload_1
    //   4: ifnull -> 141
    //   7: aload_1
    //   8: invokevirtual a : ()Ljava/lang/String;
    //   11: ifnull -> 131
    //   14: ldc ''
    //   16: aload_1
    //   17: invokevirtual a : ()Ljava/lang/String;
    //   20: invokevirtual equals : (Ljava/lang/Object;)Z
    //   23: istore_2
    //   24: iload_2
    //   25: ifne -> 131
    //   28: new com/amap/api/mapcore2d/dq
    //   31: dup
    //   32: invokespecial <init> : ()V
    //   35: aload_0
    //   36: invokevirtual a : (Landroid/content/Context;)V
    //   39: getstatic com/amap/api/mapcore2d/do.f : Ljava/util/Set;
    //   42: aload_1
    //   43: invokevirtual hashCode : ()I
    //   46: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   49: invokeinterface add : (Ljava/lang/Object;)Z
    //   54: ifne -> 69
    //   57: getstatic com/amap/api/mapcore2d/dl.a : Lcom/amap/api/mapcore2d/dl;
    //   60: checkcast com/amap/api/mapcore2d/do
    //   63: astore_0
    //   64: ldc com/amap/api/mapcore2d/do
    //   66: monitorexit
    //   67: aload_0
    //   68: areturn
    //   69: getstatic com/amap/api/mapcore2d/dl.a : Lcom/amap/api/mapcore2d/dl;
    //   72: ifnonnull -> 90
    //   75: new com/amap/api/mapcore2d/do
    //   78: dup
    //   79: aload_0
    //   80: aload_1
    //   81: invokespecial <init> : (Landroid/content/Context;Lcom/amap/api/mapcore2d/da;)V
    //   84: putstatic com/amap/api/mapcore2d/dl.a : Lcom/amap/api/mapcore2d/dl;
    //   87: goto -> 97
    //   90: getstatic com/amap/api/mapcore2d/dl.a : Lcom/amap/api/mapcore2d/dl;
    //   93: iconst_0
    //   94: putfield c : Z
    //   97: getstatic com/amap/api/mapcore2d/dl.a : Lcom/amap/api/mapcore2d/dl;
    //   100: aload_0
    //   101: aload_1
    //   102: getstatic com/amap/api/mapcore2d/dl.a : Lcom/amap/api/mapcore2d/dl;
    //   105: getfield c : Z
    //   108: invokevirtual a : (Landroid/content/Context;Lcom/amap/api/mapcore2d/da;Z)V
    //   111: goto -> 119
    //   114: astore_0
    //   115: aload_0
    //   116: invokevirtual printStackTrace : ()V
    //   119: getstatic com/amap/api/mapcore2d/dl.a : Lcom/amap/api/mapcore2d/dl;
    //   122: checkcast com/amap/api/mapcore2d/do
    //   125: astore_0
    //   126: ldc com/amap/api/mapcore2d/do
    //   128: monitorexit
    //   129: aload_0
    //   130: areturn
    //   131: new com/amap/api/mapcore2d/cp
    //   134: dup
    //   135: ldc 'sdk name is invalid'
    //   137: invokespecial <init> : (Ljava/lang/String;)V
    //   140: athrow
    //   141: new com/amap/api/mapcore2d/cp
    //   144: dup
    //   145: ldc 'sdk info is null'
    //   147: invokespecial <init> : (Ljava/lang/String;)V
    //   150: athrow
    //   151: ldc com/amap/api/mapcore2d/do
    //   153: monitorexit
    //   154: aload_0
    //   155: athrow
    //   156: astore_0
    //   157: goto -> 151
    // Exception table:
    //   from	to	target	type
    //   7	24	156	finally
    //   28	64	114	finally
    //   69	87	114	finally
    //   90	97	114	finally
    //   97	111	114	finally
    //   115	119	156	finally
    //   119	126	156	finally
    //   131	141	156	finally
    //   141	151	156	finally
  }
  
  public static void a(da paramda, String paramString, cp paramcp) {
    if (paramcp != null)
      a(paramda, paramString, paramcp.c(), paramcp.d(), paramcp.b()); 
  }
  
  public static void a(da paramda, String paramString1, String paramString2, String paramString3, String paramString4) {
    try {
      return;
    } finally {
      paramda = null;
    } 
  }
  
  private void a(Thread paramThread, Throwable paramThrowable) {
    int i = 0;
    try {
      return;
    } finally {
      paramThread = null;
    } 
  }
  
  public static void b() {
    // Byte code:
    //   0: ldc com/amap/api/mapcore2d/do
    //   2: monitorenter
    //   3: getstatic com/amap/api/mapcore2d/do.e : Ljava/util/concurrent/ExecutorService;
    //   6: ifnull -> 17
    //   9: getstatic com/amap/api/mapcore2d/do.e : Ljava/util/concurrent/ExecutorService;
    //   12: invokeinterface shutdown : ()V
    //   17: invokestatic a : ()V
    //   20: goto -> 28
    //   23: astore_0
    //   24: aload_0
    //   25: invokevirtual printStackTrace : ()V
    //   28: getstatic com/amap/api/mapcore2d/dl.a : Lcom/amap/api/mapcore2d/dl;
    //   31: ifnull -> 61
    //   34: invokestatic getDefaultUncaughtExceptionHandler : ()Ljava/lang/Thread$UncaughtExceptionHandler;
    //   37: getstatic com/amap/api/mapcore2d/dl.a : Lcom/amap/api/mapcore2d/dl;
    //   40: if_acmpne -> 61
    //   43: getstatic com/amap/api/mapcore2d/dl.a : Lcom/amap/api/mapcore2d/dl;
    //   46: getfield b : Ljava/lang/Thread$UncaughtExceptionHandler;
    //   49: ifnull -> 61
    //   52: getstatic com/amap/api/mapcore2d/dl.a : Lcom/amap/api/mapcore2d/dl;
    //   55: getfield b : Ljava/lang/Thread$UncaughtExceptionHandler;
    //   58: invokestatic setDefaultUncaughtExceptionHandler : (Ljava/lang/Thread$UncaughtExceptionHandler;)V
    //   61: aconst_null
    //   62: putstatic com/amap/api/mapcore2d/dl.a : Lcom/amap/api/mapcore2d/dl;
    //   65: goto -> 73
    //   68: astore_0
    //   69: aload_0
    //   70: invokevirtual printStackTrace : ()V
    //   73: ldc com/amap/api/mapcore2d/do
    //   75: monitorexit
    //   76: return
    //   77: astore_0
    //   78: ldc com/amap/api/mapcore2d/do
    //   80: monitorexit
    //   81: aload_0
    //   82: athrow
    // Exception table:
    //   from	to	target	type
    //   3	17	23	finally
    //   17	20	23	finally
    //   24	28	77	finally
    //   28	61	68	finally
    //   61	65	68	finally
    //   69	73	77	finally
  }
  
  public static void b(da paramda, String paramString1, String paramString2) {
    try {
      return;
    } finally {
      paramda = null;
    } 
  }
  
  public static void c() {
    WeakReference<Context> weakReference = g;
    if (weakReference != null && weakReference.get() != null) {
      dm.b(g.get());
      return;
    } 
    if (dl.a != null)
      dl.a.a(); 
  }
  
  public static void c(Throwable paramThrowable, String paramString1, String paramString2) {
    try {
      return;
    } finally {
      paramThrowable = null;
    } 
  }
  
  public static ExecutorService d() {
    // Byte code:
    //   0: ldc com/amap/api/mapcore2d/do
    //   2: monitorenter
    //   3: getstatic com/amap/api/mapcore2d/do.e : Ljava/util/concurrent/ExecutorService;
    //   6: ifnull -> 20
    //   9: getstatic com/amap/api/mapcore2d/do.e : Ljava/util/concurrent/ExecutorService;
    //   12: invokeinterface isShutdown : ()Z
    //   17: ifeq -> 57
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
    //   40: getstatic com/amap/api/mapcore2d/do.h : Ljava/util/concurrent/ThreadFactory;
    //   43: invokespecial <init> : (IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;)V
    //   46: putstatic com/amap/api/mapcore2d/do.e : Ljava/util/concurrent/ExecutorService;
    //   49: goto -> 57
    //   52: astore_0
    //   53: aload_0
    //   54: invokevirtual printStackTrace : ()V
    //   57: getstatic com/amap/api/mapcore2d/do.e : Ljava/util/concurrent/ExecutorService;
    //   60: astore_0
    //   61: ldc com/amap/api/mapcore2d/do
    //   63: monitorexit
    //   64: aload_0
    //   65: areturn
    //   66: astore_0
    //   67: ldc com/amap/api/mapcore2d/do
    //   69: monitorexit
    //   70: aload_0
    //   71: athrow
    // Exception table:
    //   from	to	target	type
    //   3	20	52	finally
    //   20	49	52	finally
    //   53	57	66	finally
    //   57	61	66	finally
  }
  
  public static do e() {
    // Byte code:
    //   0: ldc com/amap/api/mapcore2d/do
    //   2: monitorenter
    //   3: getstatic com/amap/api/mapcore2d/dl.a : Lcom/amap/api/mapcore2d/dl;
    //   6: checkcast com/amap/api/mapcore2d/do
    //   9: astore_0
    //   10: ldc com/amap/api/mapcore2d/do
    //   12: monitorexit
    //   13: aload_0
    //   14: areturn
    //   15: astore_0
    //   16: ldc com/amap/api/mapcore2d/do
    //   18: monitorexit
    //   19: aload_0
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   3	10	15	finally
  }
  
  private void f() {
    try {
      this.b = Thread.getDefaultUncaughtExceptionHandler();
      if (this.b == null)
        return; 
      String str = this.b.toString();
      if (!str.startsWith("com.amap.apis.utils.core.dynamiccore") && (str.indexOf("com.amap.api") != -1 || str.indexOf("com.loc") != -1))
        return; 
      return;
    } finally {
      Exception exception = null;
      exception.printStackTrace();
    } 
  }
  
  protected void a() {
    dm.b(this.d);
  }
  
  protected void a(Context paramContext, da paramda, boolean paramBoolean) {
    try {
      return;
    } catch (RejectedExecutionException rejectedExecutionException) {
      return;
    } finally {
      paramContext = null;
      paramContext.printStackTrace();
    } 
  }
  
  protected void a(da paramda, String paramString1, String paramString2) {
    dp.b(paramda, this.d, paramString2, paramString1);
  }
  
  protected void a(Throwable paramThrowable, int paramInt, String paramString1, String paramString2) {
    dp.a(this.d, paramThrowable, paramInt, paramString1, paramString2);
  }
  
  public void b(Throwable paramThrowable, String paramString1, String paramString2) {
    if (paramThrowable == null)
      return; 
    try {
      return;
    } finally {
      paramThrowable = null;
      paramThrowable.printStackTrace();
    } 
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
    a(paramThread, paramThrowable);
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
  
  public static interface a {
    void a(Thread param1Thread, Throwable param1Throwable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\do.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */