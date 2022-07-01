package com.bytedance.sdk.a.b;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;

public final class n {
  private int a = 64;
  
  private int b = 5;
  
  private Runnable c;
  
  private ExecutorService d;
  
  private final Deque<x.a> e = new ArrayDeque<x.a>();
  
  private final Deque<x.a> f = new ArrayDeque<x.a>();
  
  private final Deque<x> g = new ArrayDeque<x>();
  
  private <T> void a(Deque<T> paramDeque, T paramT, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: aload_2
    //   4: invokeinterface remove : (Ljava/lang/Object;)Z
    //   9: ifeq -> 49
    //   12: iload_3
    //   13: ifeq -> 20
    //   16: aload_0
    //   17: invokespecial c : ()V
    //   20: aload_0
    //   21: invokevirtual b : ()I
    //   24: istore #4
    //   26: aload_0
    //   27: getfield c : Ljava/lang/Runnable;
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: iload #4
    //   35: ifne -> 48
    //   38: aload_1
    //   39: ifnull -> 48
    //   42: aload_1
    //   43: invokeinterface run : ()V
    //   48: return
    //   49: new java/lang/AssertionError
    //   52: dup
    //   53: ldc 'Call wasn't in-flight!'
    //   55: invokespecial <init> : (Ljava/lang/Object;)V
    //   58: athrow
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	59	finally
    //   16	20	59	finally
    //   20	33	59	finally
    //   49	59	59	finally
    //   60	62	59	finally
  }
  
  private int b(x.a parama) {
    Iterator<x.a> iterator = this.f.iterator();
    int i = 0;
    while (iterator.hasNext()) {
      if (((x.a)iterator.next()).b().equals(parama.b()))
        i++; 
    } 
    return i;
  }
  
  private void c() {
    if (this.f.size() >= this.a)
      return; 
    if (this.e.isEmpty())
      return; 
    Iterator<x.a> iterator = this.e.iterator();
    while (iterator.hasNext()) {
      x.a a = iterator.next();
      if (b(a) < this.b) {
        iterator.remove();
        this.f.add(a);
        a().execute((Runnable)a);
      } 
      if (this.f.size() >= this.a)
        break; 
    } 
  }
  
  public ExecutorService a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield d : Ljava/util/concurrent/ExecutorService;
    //   6: ifnonnull -> 42
    //   9: aload_0
    //   10: new java/util/concurrent/ThreadPoolExecutor
    //   13: dup
    //   14: iconst_0
    //   15: ldc 2147483647
    //   17: ldc2_w 60
    //   20: getstatic java/util/concurrent/TimeUnit.SECONDS : Ljava/util/concurrent/TimeUnit;
    //   23: new java/util/concurrent/SynchronousQueue
    //   26: dup
    //   27: invokespecial <init> : ()V
    //   30: ldc 'OkHttp Dispatcher'
    //   32: iconst_0
    //   33: invokestatic a : (Ljava/lang/String;Z)Ljava/util/concurrent/ThreadFactory;
    //   36: invokespecial <init> : (IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;)V
    //   39: putfield d : Ljava/util/concurrent/ExecutorService;
    //   42: aload_0
    //   43: getfield d : Ljava/util/concurrent/ExecutorService;
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: areturn
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Exception table:
    //   from	to	target	type
    //   2	42	51	finally
    //   42	47	51	finally
  }
  
  void a(x.a parama) {
    a(this.f, parama, true);
  }
  
  void a(x paramx) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield g : Ljava/util/Deque;
    //   6: aload_1
    //   7: invokeinterface add : (Ljava/lang/Object;)Z
    //   12: pop
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	16	finally
  }
  
  public int b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield f : Ljava/util/Deque;
    //   6: invokeinterface size : ()I
    //   11: istore_1
    //   12: aload_0
    //   13: getfield g : Ljava/util/Deque;
    //   16: invokeinterface size : ()I
    //   21: istore_2
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_1
    //   25: iload_2
    //   26: iadd
    //   27: ireturn
    //   28: astore_3
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_3
    //   32: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	28	finally
  }
  
  void b(x paramx) {
    a(this.g, paramx, false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */