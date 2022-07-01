package com.tencent.bugly.yaq.crashreport.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class BuglyBroadcastReceiver extends BroadcastReceiver {
  private static BuglyBroadcastReceiver d = null;
  
  private IntentFilter a;
  
  private Context b;
  
  private String c;
  
  private boolean e;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public BuglyBroadcastReceiver() {
    throw new VerifyError("bad dex opcode");
  }
  
  private boolean a(Context paramContext, Intent paramIntent) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 20
    //   6: aload_2
    //   7: ifnull -> 20
    //   10: new java/lang/VerifyError
    //   13: dup
    //   14: ldc 'bad dex opcode'
    //   16: invokespecial <init> : (Ljava/lang/String;)V
    //   19: athrow
    //   20: aload_0
    //   21: monitorexit
    //   22: iconst_0
    //   23: ireturn
    //   24: astore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Exception table:
    //   from	to	target	type
    //   10	20	24	finally
  }
  
  public static BuglyBroadcastReceiver getInstance() {
    // Byte code:
    //   0: ldc com/tencent/bugly/yaq/crashreport/crash/BuglyBroadcastReceiver
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/yaq/crashreport/crash/BuglyBroadcastReceiver.d : Lcom/tencent/bugly/yaq/crashreport/crash/BuglyBroadcastReceiver;
    //   6: ifnonnull -> 19
    //   9: new com/tencent/bugly/yaq/crashreport/crash/BuglyBroadcastReceiver
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/tencent/bugly/yaq/crashreport/crash/BuglyBroadcastReceiver.d : Lcom/tencent/bugly/yaq/crashreport/crash/BuglyBroadcastReceiver;
    //   19: getstatic com/tencent/bugly/yaq/crashreport/crash/BuglyBroadcastReceiver.d : Lcom/tencent/bugly/yaq/crashreport/crash/BuglyBroadcastReceiver;
    //   22: astore_0
    //   23: ldc com/tencent/bugly/yaq/crashreport/crash/BuglyBroadcastReceiver
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/tencent/bugly/yaq/crashreport/crash/BuglyBroadcastReceiver
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	23	28	finally
  }
  
  public void addFilter(String paramString) {
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
  
  public final void onReceive(Context paramContext, Intent paramIntent) {
    try {
      a(paramContext, paramIntent);
    } catch (Throwable throwable) {}
    throw new VerifyError("bad dex opcode");
  }
  
  public void register(Context paramContext) {
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
  
  public void unregister(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/VerifyError
    //   5: dup
    //   6: ldc 'bad dex opcode'
    //   8: invokespecial <init> : (Ljava/lang/String;)V
    //   11: athrow
    //   12: aload_0
    //   13: monitorexit
    //   14: new java/lang/VerifyError
    //   17: dup
    //   18: ldc 'bad dex opcode'
    //   20: invokespecial <init> : (Ljava/lang/String;)V
    //   23: athrow
    //   24: astore_1
    //   25: aload_1
    //   26: invokestatic a : (Ljava/lang/Throwable;)Z
    //   29: ifne -> 12
    //   32: new java/lang/VerifyError
    //   35: dup
    //   36: ldc 'bad dex opcode'
    //   38: invokespecial <init> : (Ljava/lang/String;)V
    //   41: athrow
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	24	java/lang/Throwable
    //   2	12	42	finally
    //   25	42	42	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\crashreport\crash\BuglyBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */