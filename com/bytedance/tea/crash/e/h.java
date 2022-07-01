package com.bytedance.tea.crash.e;

import android.os.Handler;
import android.os.HandlerThread;

public class h {
  private static volatile HandlerThread a;
  
  private static volatile Handler b;
  
  private static volatile Handler c;
  
  public static HandlerThread a() {
    // Byte code:
    //   0: getstatic com/bytedance/tea/crash/e/h.a : Landroid/os/HandlerThread;
    //   3: ifnonnull -> 61
    //   6: ldc com/bytedance/tea/crash/e/h
    //   8: monitorenter
    //   9: getstatic com/bytedance/tea/crash/e/h.a : Landroid/os/HandlerThread;
    //   12: ifnonnull -> 49
    //   15: new android/os/HandlerThread
    //   18: dup
    //   19: ldc 'default_npth_thread'
    //   21: invokespecial <init> : (Ljava/lang/String;)V
    //   24: putstatic com/bytedance/tea/crash/e/h.a : Landroid/os/HandlerThread;
    //   27: getstatic com/bytedance/tea/crash/e/h.a : Landroid/os/HandlerThread;
    //   30: invokevirtual start : ()V
    //   33: new android/os/Handler
    //   36: dup
    //   37: getstatic com/bytedance/tea/crash/e/h.a : Landroid/os/HandlerThread;
    //   40: invokevirtual getLooper : ()Landroid/os/Looper;
    //   43: invokespecial <init> : (Landroid/os/Looper;)V
    //   46: putstatic com/bytedance/tea/crash/e/h.b : Landroid/os/Handler;
    //   49: ldc com/bytedance/tea/crash/e/h
    //   51: monitorexit
    //   52: goto -> 61
    //   55: astore_0
    //   56: ldc com/bytedance/tea/crash/e/h
    //   58: monitorexit
    //   59: aload_0
    //   60: athrow
    //   61: getstatic com/bytedance/tea/crash/e/h.a : Landroid/os/HandlerThread;
    //   64: areturn
    // Exception table:
    //   from	to	target	type
    //   9	49	55	finally
    //   49	52	55	finally
    //   56	59	55	finally
  }
  
  public static Handler b() {
    if (b == null)
      a(); 
    return b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\e\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */