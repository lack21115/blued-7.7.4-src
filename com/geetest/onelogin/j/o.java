package com.geetest.onelogin.j;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public class o {
  private static o a;
  
  private static Executor b;
  
  private static volatile ScheduledExecutorService c;
  
  public static o a() {
    // Byte code:
    //   0: getstatic com/geetest/onelogin/j/o.a : Lcom/geetest/onelogin/j/o;
    //   3: ifnonnull -> 52
    //   6: ldc com/geetest/onelogin/j/o
    //   8: monitorenter
    //   9: getstatic com/geetest/onelogin/j/o.a : Lcom/geetest/onelogin/j/o;
    //   12: ifnonnull -> 40
    //   15: new com/geetest/onelogin/j/o
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/geetest/onelogin/j/o.a : Lcom/geetest/onelogin/j/o;
    //   25: bipush #15
    //   27: invokestatic newFixedThreadPool : (I)Ljava/util/concurrent/ExecutorService;
    //   30: putstatic com/geetest/onelogin/j/o.b : Ljava/util/concurrent/Executor;
    //   33: iconst_5
    //   34: invokestatic newScheduledThreadPool : (I)Ljava/util/concurrent/ScheduledExecutorService;
    //   37: putstatic com/geetest/onelogin/j/o.c : Ljava/util/concurrent/ScheduledExecutorService;
    //   40: ldc com/geetest/onelogin/j/o
    //   42: monitorexit
    //   43: goto -> 52
    //   46: astore_0
    //   47: ldc com/geetest/onelogin/j/o
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    //   52: getstatic com/geetest/onelogin/j/o.a : Lcom/geetest/onelogin/j/o;
    //   55: areturn
    // Exception table:
    //   from	to	target	type
    //   9	40	46	finally
    //   40	43	46	finally
    //   47	50	46	finally
  }
  
  public void a(Runnable paramRunnable) {
    if (paramRunnable != null)
      try {
        b.execute(paramRunnable);
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\j\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */