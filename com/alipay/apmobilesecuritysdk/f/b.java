package com.alipay.apmobilesecuritysdk.f;

import java.util.LinkedList;

public final class b {
  private static b a = new b();
  
  private Thread b = null;
  
  private LinkedList<Runnable> c = new LinkedList<Runnable>();
  
  public static b a() {
    return a;
  }
  
  public final void a(Runnable paramRunnable) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : Ljava/util/LinkedList;
    //   6: aload_1
    //   7: invokevirtual add : (Ljava/lang/Object;)Z
    //   10: pop
    //   11: aload_0
    //   12: getfield b : Ljava/lang/Thread;
    //   15: ifnonnull -> 44
    //   18: aload_0
    //   19: new java/lang/Thread
    //   22: dup
    //   23: new com/alipay/apmobilesecuritysdk/f/c
    //   26: dup
    //   27: aload_0
    //   28: invokespecial <init> : (Lcom/alipay/apmobilesecuritysdk/f/b;)V
    //   31: invokespecial <init> : (Ljava/lang/Runnable;)V
    //   34: putfield b : Ljava/lang/Thread;
    //   37: aload_0
    //   38: getfield b : Ljava/lang/Thread;
    //   41: invokevirtual start : ()V
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Exception table:
    //   from	to	target	type
    //   2	44	47	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\apmobilesecuritysdk\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */