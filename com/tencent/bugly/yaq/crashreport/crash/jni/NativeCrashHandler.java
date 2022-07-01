package com.tencent.bugly.yaq.crashreport.crash.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.bugly.yaq.crashreport.a;
import com.tencent.bugly.yaq.crashreport.common.info.a;
import com.tencent.bugly.yaq.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.yaq.crashreport.common.strategy.a;
import com.tencent.bugly.yaq.crashreport.crash.b;
import com.tencent.bugly.yaq.crashreport.crash.c;
import com.tencent.bugly.yaq.proguard.w;
import com.tencent.bugly.yaq.proguard.x;
import com.tencent.bugly.yaq.proguard.z;

public class NativeCrashHandler implements a {
  private static NativeCrashHandler a;
  
  private static boolean l = false;
  
  private static boolean m = false;
  
  private static boolean o = true;
  
  private final Context b;
  
  private final a c;
  
  private final w d;
  
  private NativeExceptionHandler e;
  
  private String f;
  
  private final boolean g;
  
  private boolean h;
  
  private boolean i;
  
  private boolean j;
  
  private boolean k;
  
  private b n;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  @SuppressLint({"SdCardPath"})
  private NativeCrashHandler(Context paramContext, a parama, b paramb, w paramw, boolean paramBoolean, String paramString) {
    throw new VerifyError("bad dex opcode");
  }
  
  private void a(boolean paramBoolean) {
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
  
  private boolean a(int paramInt, String paramString) {
    throw new VerifyError("bad dex opcode");
  }
  
  private static boolean a(String paramString, boolean paramBoolean) {
    try {
      x.a("[Native] Trying to load so: %s", new Object[] { paramString });
      if (paramBoolean) {
        System.load(paramString);
      } else {
        System.loadLibrary(paramString);
      } 
      try {
        x.a("[Native] Successfully loaded SO: %s", new Object[] { paramString });
        return true;
      } catch (Throwable throwable) {}
    } catch (Throwable throwable) {}
    throw new VerifyError("bad dex opcode");
  }
  
  private void b(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: ifeq -> 28
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
    //   28: aload_0
    //   29: invokespecial c : ()V
    //   32: goto -> 16
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   6	16	35	finally
    //   28	32	35	finally
  }
  
  private void c() {
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
  
  public static NativeCrashHandler getInstance() {
    // Byte code:
    //   0: ldc com/tencent/bugly/yaq/crashreport/crash/jni/NativeCrashHandler
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/yaq/crashreport/crash/jni/NativeCrashHandler.a : Lcom/tencent/bugly/yaq/crashreport/crash/jni/NativeCrashHandler;
    //   6: astore_0
    //   7: ldc com/tencent/bugly/yaq/crashreport/crash/jni/NativeCrashHandler
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/tencent/bugly/yaq/crashreport/crash/jni/NativeCrashHandler
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static NativeCrashHandler getInstance(Context paramContext, a parama, b paramb, a parama1, w paramw, boolean paramBoolean, String paramString) {
    // Byte code:
    //   0: ldc com/tencent/bugly/yaq/crashreport/crash/jni/NativeCrashHandler
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/yaq/crashreport/crash/jni/NativeCrashHandler.a : Lcom/tencent/bugly/yaq/crashreport/crash/jni/NativeCrashHandler;
    //   6: ifnonnull -> 28
    //   9: new com/tencent/bugly/yaq/crashreport/crash/jni/NativeCrashHandler
    //   12: dup
    //   13: aload_0
    //   14: aload_1
    //   15: aload_2
    //   16: aload #4
    //   18: iload #5
    //   20: aload #6
    //   22: invokespecial <init> : (Landroid/content/Context;Lcom/tencent/bugly/yaq/crashreport/common/info/a;Lcom/tencent/bugly/yaq/crashreport/crash/b;Lcom/tencent/bugly/yaq/proguard/w;ZLjava/lang/String;)V
    //   25: putstatic com/tencent/bugly/yaq/crashreport/crash/jni/NativeCrashHandler.a : Lcom/tencent/bugly/yaq/crashreport/crash/jni/NativeCrashHandler;
    //   28: getstatic com/tencent/bugly/yaq/crashreport/crash/jni/NativeCrashHandler.a : Lcom/tencent/bugly/yaq/crashreport/crash/jni/NativeCrashHandler;
    //   31: astore_0
    //   32: ldc com/tencent/bugly/yaq/crashreport/crash/jni/NativeCrashHandler
    //   34: monitorexit
    //   35: aload_0
    //   36: areturn
    //   37: astore_0
    //   38: ldc com/tencent/bugly/yaq/crashreport/crash/jni/NativeCrashHandler
    //   40: monitorexit
    //   41: aload_0
    //   42: athrow
    // Exception table:
    //   from	to	target	type
    //   3	28	37	finally
    //   28	32	37	finally
  }
  
  public static boolean isShouldHandleInJava() {
    return o;
  }
  
  public static void setShouldHandleInJava(boolean paramBoolean) {
    o = paramBoolean;
    if (a != null) {
      NativeCrashHandler nativeCrashHandler = a;
      new StringBuilder();
      throw new VerifyError("bad dex opcode");
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  protected final void a() {
    z.b();
    long l = c.g;
    z.b();
    throw new VerifyError("bad dex opcode");
  }
  
  public boolean appendLogToNative(String paramString1, String paramString2, String paramString3) {
    throw new VerifyError("bad dex opcode");
  }
  
  protected native boolean appendNativeLog(String paramString1, String paramString2, String paramString3);
  
  protected native boolean appendWholeNativeLog(String paramString);
  
  public void checkUploadRecordCrash() {
    throw new VerifyError("bad dex opcode");
  }
  
  public boolean filterSigabrtSysLog() {
    return a(998, "true");
  }
  
  public String getDumpFilePath() {
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
  
  public String getLogFromNative() {
    throw new VerifyError("bad dex opcode");
  }
  
  public NativeExceptionHandler getNativeExceptionHandler() {
    throw new VerifyError("bad dex opcode");
  }
  
  protected native String getNativeKeyValueList();
  
  protected native String getNativeLog();
  
  public boolean isUserOpened() {
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
  
  public void onStrategyChanged(StrategyBean paramStrategyBean) {
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
    //   16: invokestatic a : ()Lcom/tencent/bugly/yaq/crashreport/common/strategy/a;
    //   19: pop
    //   20: new java/lang/VerifyError
    //   23: dup
    //   24: ldc 'bad dex opcode'
    //   26: invokespecial <init> : (Ljava/lang/String;)V
    //   29: athrow
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   6	16	30	finally
    //   16	30	30	finally
  }
  
  public boolean putKeyValueToNative(String paramString1, String paramString2) {
    throw new VerifyError("bad dex opcode");
  }
  
  protected native boolean putNativeKeyValue(String paramString1, String paramString2);
  
  protected native String regist(String paramString, boolean paramBoolean, int paramInt);
  
  public void removeEmptyNativeRecordFiles() {
    throw new VerifyError("bad dex opcode");
  }
  
  protected native String removeNativeKeyValue(String paramString);
  
  public void setDumpFilePath(String paramString) {
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
  
  public boolean setNativeAppChannel(String paramString) {
    return a(12, paramString);
  }
  
  public boolean setNativeAppPackage(String paramString) {
    return a(13, paramString);
  }
  
  public boolean setNativeAppVersion(String paramString) {
    return a(10, paramString);
  }
  
  protected native void setNativeInfo(int paramInt, String paramString);
  
  public boolean setNativeIsAppForeground(boolean paramBoolean) {
    if (paramBoolean) {
      String str1 = "true";
      return a(14, str1);
    } 
    String str = "false";
    return a(14, str);
  }
  
  public boolean setNativeLaunchTime(long paramLong) {
    try {
      return a(15, String.valueOf(paramLong));
    } catch (NumberFormatException numberFormatException) {
      if (!x.a(numberFormatException))
        throw new VerifyError("bad dex opcode"); 
      return false;
    } 
  }
  
  public boolean setNativeUserId(String paramString) {
    return a(11, paramString);
  }
  
  public void setUserOpened(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: invokespecial c : (Z)V
    //   7: new java/lang/VerifyError
    //   10: dup
    //   11: ldc 'bad dex opcode'
    //   13: invokespecial <init> : (Ljava/lang/String;)V
    //   16: athrow
    //   17: astore_2
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_2
    //   21: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	17	finally
  }
  
  public void startNativeMonitor() {
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
  
  protected native void testCrash();
  
  public void testNativeCrash() {
    throw new VerifyError("bad dex opcode");
  }
  
  public void testNativeCrash(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    new StringBuilder();
    throw new VerifyError("bad dex opcode");
  }
  
  protected native String unregist();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\crashreport\crash\jni\NativeCrashHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */