package com.tencent.bugly.yaq.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.yaq.BuglyStrategy;
import com.tencent.bugly.yaq.crashreport.common.info.a;
import com.tencent.bugly.yaq.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.yaq.crashreport.common.strategy.a;
import com.tencent.bugly.yaq.crashreport.crash.anr.b;
import com.tencent.bugly.yaq.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.yaq.proguard.o;
import com.tencent.bugly.yaq.proguard.w;
import com.tencent.bugly.yaq.proguard.x;
import com.tencent.bugly.yaq.proguard.z;

public final class c {
  public static int a = 0;
  
  public static boolean b = false;
  
  public static int c = 2;
  
  public static boolean d = true;
  
  public static int e = 20480;
  
  public static int f = 20480;
  
  public static long g = 604800000L;
  
  public static String h = null;
  
  public static boolean i = false;
  
  public static String j = null;
  
  public static int k = 5000;
  
  public static boolean l = true;
  
  public static boolean m = false;
  
  public static String n = null;
  
  public static String o = null;
  
  private static c r;
  
  public final b p;
  
  private final Context q;
  
  private final e s;
  
  private final NativeCrashHandler t;
  
  private a u;
  
  private w v;
  
  private final b w;
  
  private Boolean x;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private c(int paramInt, Context paramContext, w paramw, boolean paramBoolean, BuglyStrategy.a parama, o paramo, String paramString) {
    a = paramInt;
    z.a(paramContext);
    throw new VerifyError("bad dex opcode");
  }
  
  public static c a() {
    // Byte code:
    //   0: ldc com/tencent/bugly/yaq/crashreport/crash/c
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/yaq/crashreport/crash/c.r : Lcom/tencent/bugly/yaq/crashreport/crash/c;
    //   6: astore_0
    //   7: ldc com/tencent/bugly/yaq/crashreport/crash/c
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/tencent/bugly/yaq/crashreport/crash/c
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static c a(int paramInt, Context paramContext, boolean paramBoolean, BuglyStrategy.a parama, o paramo, String paramString) {
    // Byte code:
    //   0: ldc com/tencent/bugly/yaq/crashreport/crash/c
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/yaq/crashreport/crash/c.r : Lcom/tencent/bugly/yaq/crashreport/crash/c;
    //   6: ifnonnull -> 30
    //   9: new com/tencent/bugly/yaq/crashreport/crash/c
    //   12: dup
    //   13: sipush #1004
    //   16: aload_1
    //   17: invokestatic a : ()Lcom/tencent/bugly/yaq/proguard/w;
    //   20: iload_2
    //   21: aload_3
    //   22: aconst_null
    //   23: aconst_null
    //   24: invokespecial <init> : (ILandroid/content/Context;Lcom/tencent/bugly/yaq/proguard/w;ZLcom/tencent/bugly/yaq/BuglyStrategy$a;Lcom/tencent/bugly/yaq/proguard/o;Ljava/lang/String;)V
    //   27: putstatic com/tencent/bugly/yaq/crashreport/crash/c.r : Lcom/tencent/bugly/yaq/crashreport/crash/c;
    //   30: getstatic com/tencent/bugly/yaq/crashreport/crash/c.r : Lcom/tencent/bugly/yaq/crashreport/crash/c;
    //   33: astore_1
    //   34: ldc com/tencent/bugly/yaq/crashreport/crash/c
    //   36: monitorexit
    //   37: aload_1
    //   38: areturn
    //   39: astore_1
    //   40: ldc com/tencent/bugly/yaq/crashreport/crash/c
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    // Exception table:
    //   from	to	target	type
    //   3	30	39	finally
    //   30	34	39	finally
  }
  
  public final void a(long paramLong) {
    w.a();
    new Thread(this) {
        public final void run() {
          throw new VerifyError("bad dex opcode");
        }
      };
    throw new VerifyError("bad dex opcode");
  }
  
  public final void a(StrategyBean paramStrategyBean) {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void a(CrashDetailBean paramCrashDetailBean) {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void a(Thread paramThread, Throwable paramThrowable, boolean paramBoolean1, String paramString, byte[] paramArrayOfbyte, boolean paramBoolean2) {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/VerifyError
    //   5: dup
    //   6: ldc 'bad dex opcode'
    //   8: invokespecial <init> : (Ljava/lang/String;)V
    //   11: athrow
    //   12: astore #4
    //   14: aload_0
    //   15: monitorexit
    //   16: aload #4
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	12	finally
  }
  
  public final boolean b() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void c() {
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
  
  public final void d() {
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
  
  public final void e() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void f() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void g() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void h() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void i() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void j() {
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
  
  public final boolean k() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void l() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void m() {
    a.b();
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\crashreport\crash\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */