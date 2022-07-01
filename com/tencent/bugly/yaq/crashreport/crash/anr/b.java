package com.tencent.bugly.yaq.crashreport.crash.anr;

import android.content.Context;
import android.os.FileObserver;
import com.tencent.bugly.yaq.crashreport.common.info.a;
import com.tencent.bugly.yaq.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.yaq.crashreport.common.strategy.a;
import com.tencent.bugly.yaq.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.yaq.crashreport.crash.c;
import com.tencent.bugly.yaq.proguard.w;
import com.tencent.bugly.yaq.proguard.x;
import com.tencent.bugly.yaq.proguard.z;
import java.util.concurrent.atomic.AtomicInteger;

public final class b {
  private AtomicInteger a;
  
  private long b;
  
  private final Context c;
  
  private final a d;
  
  private final w e;
  
  private final a f;
  
  private final String g;
  
  private final com.tencent.bugly.yaq.crashreport.crash.b h;
  
  private FileObserver i;
  
  private boolean j;
  
  public b(Context paramContext, a parama, a parama1, w paramw, com.tencent.bugly.yaq.crashreport.crash.b paramb) {
    new AtomicInteger(0);
    throw new VerifyError("bad dex opcode");
  }
  
  private CrashDetailBean a(a parama) {
    CrashDetailBean crashDetailBean = new CrashDetailBean();
    try {
      com.tencent.bugly.yaq.crashreport.common.info.b.k();
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throw new VerifyError("bad dex opcode"); 
      return crashDetailBean;
    } 
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3) {
    if (TraceFileHelper.readTargetDumpInfo(paramString3, paramString1, true) != null)
      throw new VerifyError("bad dex opcode"); 
    x.e("not found trace dump for %s", new Object[] { paramString3 });
    return false;
  }
  
  private void b(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: ifeq -> 22
    //   6: aload_0
    //   7: invokespecial c : ()V
    //   10: aload_0
    //   11: monitorexit
    //   12: new java/lang/VerifyError
    //   15: dup
    //   16: ldc 'bad dex opcode'
    //   18: invokespecial <init> : (Ljava/lang/String;)V
    //   21: athrow
    //   22: aload_0
    //   23: invokespecial d : ()V
    //   26: goto -> 10
    //   29: astore_2
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_2
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   6	10	29	finally
    //   22	26	29	finally
  }
  
  private void c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial e : ()Z
    //   6: ifeq -> 31
    //   9: ldc 'start when started!'
    //   11: iconst_0
    //   12: anewarray java/lang/Object
    //   15: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   18: pop
    //   19: aload_0
    //   20: monitorexit
    //   21: new java/lang/VerifyError
    //   24: dup
    //   25: ldc 'bad dex opcode'
    //   27: invokespecial <init> : (Ljava/lang/String;)V
    //   30: athrow
    //   31: new com/tencent/bugly/yaq/crashreport/crash/anr/b$1
    //   34: dup
    //   35: aload_0
    //   36: ldc '/data/anr/'
    //   38: bipush #8
    //   40: invokespecial <init> : (Lcom/tencent/bugly/yaq/crashreport/crash/anr/b;Ljava/lang/String;I)V
    //   43: pop
    //   44: new java/lang/VerifyError
    //   47: dup
    //   48: ldc 'bad dex opcode'
    //   50: invokespecial <init> : (Ljava/lang/String;)V
    //   53: athrow
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	54	finally
    //   31	54	54	finally
  }
  
  private void c(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/VerifyError
    //   5: dup
    //   6: ldc 'bad dex opcode'
    //   8: invokespecial <init> : (Ljava/lang/String;)V
    //   11: athrow
    //   12: astore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_2
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	12	finally
  }
  
  private void d() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial e : ()Z
    //   6: ifne -> 31
    //   9: ldc 'close when closed!'
    //   11: iconst_0
    //   12: anewarray java/lang/Object
    //   15: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   18: pop
    //   19: aload_0
    //   20: monitorexit
    //   21: new java/lang/VerifyError
    //   24: dup
    //   25: ldc 'bad dex opcode'
    //   27: invokespecial <init> : (Ljava/lang/String;)V
    //   30: athrow
    //   31: new java/lang/VerifyError
    //   34: dup
    //   35: ldc 'bad dex opcode'
    //   37: invokespecial <init> : (Ljava/lang/String;)V
    //   40: athrow
    //   41: astore_1
    //   42: ldc 'stop anr monitor failed!'
    //   44: iconst_0
    //   45: anewarray java/lang/Object
    //   48: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   51: pop
    //   52: aload_1
    //   53: invokestatic a : (Ljava/lang/Throwable;)Z
    //   56: ifne -> 19
    //   59: new java/lang/VerifyError
    //   62: dup
    //   63: ldc 'bad dex opcode'
    //   65: invokespecial <init> : (Ljava/lang/String;)V
    //   68: athrow
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	69	finally
    //   31	41	41	java/lang/Throwable
    //   31	41	69	finally
    //   42	69	69	finally
  }
  
  private boolean e() {
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
  
  private boolean f() {
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
    //   3: ifnonnull -> 18
    //   6: aload_0
    //   7: monitorexit
    //   8: new java/lang/VerifyError
    //   11: dup
    //   12: ldc 'bad dex opcode'
    //   14: invokespecial <init> : (Ljava/lang/String;)V
    //   17: athrow
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
    //   18	28	28	finally
  }
  
  public final void a(String paramString) {
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
  
  public final void a(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokespecial c : (Z)V
    //   5: aload_0
    //   6: invokespecial f : ()Z
    //   9: istore_2
    //   10: iload_2
    //   11: istore_1
    //   12: invokestatic a : ()Lcom/tencent/bugly/yaq/crashreport/common/strategy/a;
    //   15: ifnull -> 32
    //   18: iload_2
    //   19: ifeq -> 72
    //   22: new java/lang/VerifyError
    //   25: dup
    //   26: ldc 'bad dex opcode'
    //   28: invokespecial <init> : (Ljava/lang/String;)V
    //   31: athrow
    //   32: iload_1
    //   33: aload_0
    //   34: invokespecial e : ()Z
    //   37: if_icmpeq -> 62
    //   40: ldc 'anr changed to %b'
    //   42: iconst_1
    //   43: anewarray java/lang/Object
    //   46: dup
    //   47: iconst_0
    //   48: iload_1
    //   49: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   52: aastore
    //   53: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   56: pop
    //   57: aload_0
    //   58: iload_1
    //   59: invokespecial b : (Z)V
    //   62: new java/lang/VerifyError
    //   65: dup
    //   66: ldc 'bad dex opcode'
    //   68: invokespecial <init> : (Ljava/lang/String;)V
    //   71: athrow
    //   72: iconst_0
    //   73: istore_1
    //   74: goto -> 32
  }
  
  public final boolean a() {
    throw new VerifyError("bad dex opcode");
  }
  
  protected final void b() {
    z.b();
    long l = c.g;
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\crashreport\crash\anr\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */