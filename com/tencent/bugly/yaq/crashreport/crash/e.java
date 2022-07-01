package com.tencent.bugly.yaq.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.yaq.crashreport.common.info.a;
import com.tencent.bugly.yaq.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.yaq.crashreport.common.strategy.a;
import com.tencent.bugly.yaq.proguard.x;

public final class e implements Thread.UncaughtExceptionHandler {
  private static String h = null;
  
  private static final Object i = new Object();
  
  private Context a;
  
  private b b;
  
  private a c;
  
  private a d;
  
  private Thread.UncaughtExceptionHandler e;
  
  private Thread.UncaughtExceptionHandler f;
  
  private boolean g;
  
  private int j;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public e(Context paramContext, b paramb, a parama, a parama1) {
    throw new VerifyError("bad dex opcode");
  }
  
  private static String a(Throwable paramThrowable, int paramInt) {
    if (paramThrowable == null)
      return null; 
    new StringBuilder();
    try {
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      Object[] arrayOfObject = new Object[1];
      throw new VerifyError("bad dex opcode");
    } 
  }
  
  private static boolean a(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler) {
    if (paramUncaughtExceptionHandler == null)
      return true; 
    throw new VerifyError("bad dex opcode");
  }
  
  private static boolean a(Thread paramThread) {
    synchronized (i) {
      if (h != null)
        throw new VerifyError("bad dex opcode"); 
      throw new VerifyError("bad dex opcode");
    } 
  }
  
  private CrashDetailBean b(Thread paramThread, Throwable paramThrowable, boolean paramBoolean, String paramString, byte[] paramArrayOfbyte) {
    if (paramThrowable == null) {
      x.d("We can do nothing with a null throwable.", new Object[0]);
      return null;
    } 
    c.a();
    throw new VerifyError("bad dex opcode");
  }
  
  private static String b(Throwable paramThrowable, int paramInt) {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void a() {
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
  
  public final void a(StrategyBean paramStrategyBean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 16
    //   6: new java/lang/VerifyError
    //   9: dup
    //   10: ldc 'bad dex opcode'
    //   12: invokespecial <init> : (Ljava/lang/String;)V
    //   15: athrow
    //   16: aload_0
    //   17: monitorexit
    //   18: new java/lang/VerifyError
    //   21: dup
    //   22: ldc 'bad dex opcode'
    //   24: invokespecial <init> : (Ljava/lang/String;)V
    //   27: athrow
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Exception table:
    //   from	to	target	type
    //   6	16	28	finally
  }
  
  public final void a(Thread paramThread, Throwable paramThrowable, boolean paramBoolean, String paramString, byte[] paramArrayOfbyte) {
    if (paramBoolean) {
      Object[] arrayOfObject = new Object[2];
      throw new VerifyError("bad dex opcode");
    } 
    x.e("Java Catch Happen", new Object[0]);
    try {
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throw new VerifyError("bad dex opcode"); 
      if (paramBoolean)
        throw new VerifyError("bad dex opcode"); 
      throw new VerifyError("bad dex opcode");
    } finally {
      if (paramBoolean)
        throw new VerifyError("bad dex opcode"); 
    } 
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
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable) {
    synchronized (i) {
      throw new VerifyError("bad dex opcode");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\crashreport\crash\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */