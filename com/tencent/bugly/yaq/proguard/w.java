package com.tencent.bugly.yaq.proguard;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class w {
  private static final AtomicInteger a = new AtomicInteger(1);
  
  private static w b;
  
  private ScheduledExecutorService c;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  protected w() {
    throw new VerifyError("bad dex opcode");
  }
  
  public static w a() {
    // Byte code:
    //   0: ldc com/tencent/bugly/yaq/proguard/w
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/yaq/proguard/w.b : Lcom/tencent/bugly/yaq/proguard/w;
    //   6: ifnonnull -> 19
    //   9: new com/tencent/bugly/yaq/proguard/w
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/tencent/bugly/yaq/proguard/w.b : Lcom/tencent/bugly/yaq/proguard/w;
    //   19: getstatic com/tencent/bugly/yaq/proguard/w.b : Lcom/tencent/bugly/yaq/proguard/w;
    //   22: astore_0
    //   23: ldc com/tencent/bugly/yaq/proguard/w
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/tencent/bugly/yaq/proguard/w
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
    //   2: new java/lang/VerifyError
    //   5: dup
    //   6: ldc 'bad dex opcode'
    //   8: invokespecial <init> : (Ljava/lang/String;)V
    //   11: athrow
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	12	finally
  }
  
  public final boolean a(Runnable paramRunnable, long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/VerifyError
    //   5: dup
    //   6: ldc 'bad dex opcode'
    //   8: invokespecial <init> : (Ljava/lang/String;)V
    //   11: athrow
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	12	finally
  }
  
  public final void b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/VerifyError
    //   5: dup
    //   6: ldc 'bad dex opcode'
    //   8: invokespecial <init> : (Ljava/lang/String;)V
    //   11: athrow
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	12	finally
  }
  
  public final boolean c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/VerifyError
    //   5: dup
    //   6: ldc 'bad dex opcode'
    //   8: invokespecial <init> : (Ljava/lang/String;)V
    //   11: athrow
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	12	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\proguard\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */