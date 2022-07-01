package com.geetest.onelogin.j;

import java.util.UUID;
import java.util.concurrent.ThreadFactory;

public class n {
  private static volatile ThreadFactory a;
  
  public static ThreadFactory a() {
    // Byte code:
    //   0: getstatic com/geetest/onelogin/j/n.a : Ljava/util/concurrent/ThreadFactory;
    //   3: ifnonnull -> 37
    //   6: ldc com/geetest/onelogin/j/n
    //   8: monitorenter
    //   9: getstatic com/geetest/onelogin/j/n.a : Ljava/util/concurrent/ThreadFactory;
    //   12: ifnonnull -> 25
    //   15: new com/geetest/onelogin/j/n$1
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/geetest/onelogin/j/n.a : Ljava/util/concurrent/ThreadFactory;
    //   25: ldc com/geetest/onelogin/j/n
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/geetest/onelogin/j/n
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/geetest/onelogin/j/n.a : Ljava/util/concurrent/ThreadFactory;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\j\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */