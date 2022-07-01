package com.tencent.bugly.yaq;

import android.content.Context;
import com.tencent.bugly.yaq.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.yaq.crashreport.crash.c;

public class CrashModule extends a {
  public static final int MODULE_ID = 1004;
  
  private static int c = 0;
  
  private static CrashModule e = new CrashModule();
  
  private long a;
  
  private BuglyStrategy.a b;
  
  private boolean d;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public CrashModule() {
    throw new VerifyError("bad dex opcode");
  }
  
  private void a(Context paramContext, BuglyStrategy paramBuglyStrategy) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
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
  
  public static CrashModule getInstance() {
    CrashModule crashModule = e;
    throw new VerifyError("bad dex opcode");
  }
  
  public String[] getTables() {
    return new String[] { "t_cr" };
  }
  
  public boolean hasInitialized() {
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
  
  public void init(Context paramContext, boolean paramBoolean, BuglyStrategy paramBuglyStrategy) {
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
  
  public void onServerStrategyChanged(StrategyBean paramStrategyBean) {
    if (paramStrategyBean != null && c.a() != null)
      throw new VerifyError("bad dex opcode"); 
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\CrashModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */