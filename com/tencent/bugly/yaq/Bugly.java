package com.tencent.bugly.yaq;

import android.content.Context;

public class Bugly {
  public static final String SDK_IS_DEV = "false";
  
  private static boolean a;
  
  public static Context applicationContext;
  
  private static String[] b;
  
  private static String[] c;
  
  public static boolean enable = true;
  
  public static Boolean isDev;
  
  static {
    applicationContext = null;
    b = new String[] { "BuglyCrashModule", "BuglyRqdModule", "BuglyBetaModule" };
    c = new String[] { "BuglyRqdModule", "BuglyCrashModule", "BuglyBetaModule" };
    throw new VerifyError("bad dex opcode");
  }
  
  public Bugly() {
    throw new VerifyError("bad dex opcode");
  }
  
  public static String getAppChannel() {
    // Byte code:
    //   0: ldc com/tencent/bugly/yaq/Bugly
    //   2: monitorenter
    //   3: invokestatic b : ()Lcom/tencent/bugly/yaq/crashreport/common/info/a;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnonnull -> 16
    //   11: ldc com/tencent/bugly/yaq/Bugly
    //   13: monitorexit
    //   14: aconst_null
    //   15: areturn
    //   16: new java/lang/VerifyError
    //   19: dup
    //   20: ldc 'bad dex opcode'
    //   22: invokespecial <init> : (Ljava/lang/String;)V
    //   25: athrow
    //   26: astore_0
    //   27: ldc com/tencent/bugly/yaq/Bugly
    //   29: monitorexit
    //   30: aload_0
    //   31: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	26	finally
    //   16	26	26	finally
  }
  
  public static void init(Context paramContext, String paramString, boolean paramBoolean) {
    init(paramContext, paramString, paramBoolean, null);
    throw new VerifyError("bad dex opcode");
  }
  
  public static void init(Context paramContext, String paramString, boolean paramBoolean, BuglyStrategy paramBuglyStrategy) {
    // Byte code:
    //   0: ldc com/tencent/bugly/yaq/Bugly
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/yaq/Bugly.a : Z
    //   6: istore #6
    //   8: iload #6
    //   10: ifeq -> 26
    //   13: ldc com/tencent/bugly/yaq/Bugly
    //   15: monitorexit
    //   16: new java/lang/VerifyError
    //   19: dup
    //   20: ldc 'bad dex opcode'
    //   22: invokespecial <init> : (Ljava/lang/String;)V
    //   25: athrow
    //   26: iconst_1
    //   27: putstatic com/tencent/bugly/yaq/Bugly.a : Z
    //   30: aload_0
    //   31: invokestatic a : (Landroid/content/Context;)Landroid/content/Context;
    //   34: astore_0
    //   35: aload_0
    //   36: putstatic com/tencent/bugly/yaq/Bugly.applicationContext : Landroid/content/Context;
    //   39: aload_0
    //   40: ifnonnull -> 61
    //   43: getstatic com/tencent/bugly/yaq/proguard/x.a : Ljava/lang/String;
    //   46: ldc 'init arg 'context' should not be null!'
    //   48: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   51: pop
    //   52: goto -> 13
    //   55: astore_0
    //   56: ldc com/tencent/bugly/yaq/Bugly
    //   58: monitorexit
    //   59: aload_0
    //   60: athrow
    //   61: invokestatic isDev : ()Z
    //   64: ifeq -> 73
    //   67: getstatic com/tencent/bugly/yaq/Bugly.c : [Ljava/lang/String;
    //   70: putstatic com/tencent/bugly/yaq/Bugly.b : [Ljava/lang/String;
    //   73: getstatic com/tencent/bugly/yaq/Bugly.b : [Ljava/lang/String;
    //   76: astore_0
    //   77: aload_0
    //   78: arraylength
    //   79: istore #5
    //   81: iconst_0
    //   82: istore #4
    //   84: iload #4
    //   86: iload #5
    //   88: if_icmpge -> 118
    //   91: aload_0
    //   92: iload #4
    //   94: aaload
    //   95: astore #7
    //   97: new java/lang/VerifyError
    //   100: dup
    //   101: ldc 'bad dex opcode'
    //   103: invokespecial <init> : (Ljava/lang/String;)V
    //   106: athrow
    //   107: astore #7
    //   109: aload #7
    //   111: invokestatic b : (Ljava/lang/Throwable;)Z
    //   114: pop
    //   115: goto -> 136
    //   118: getstatic com/tencent/bugly/yaq/Bugly.enable : Z
    //   121: putstatic com/tencent/bugly/yaq/b.a : Z
    //   124: getstatic com/tencent/bugly/yaq/Bugly.applicationContext : Landroid/content/Context;
    //   127: aload_1
    //   128: iload_2
    //   129: aload_3
    //   130: invokestatic a : (Landroid/content/Context;Ljava/lang/String;ZLcom/tencent/bugly/yaq/BuglyStrategy;)V
    //   133: goto -> 13
    //   136: iload #4
    //   138: iconst_1
    //   139: iadd
    //   140: istore #4
    //   142: goto -> 84
    // Exception table:
    //   from	to	target	type
    //   3	8	55	finally
    //   26	39	55	finally
    //   43	52	55	finally
    //   61	73	55	finally
    //   73	81	55	finally
    //   97	107	107	java/lang/Throwable
    //   97	107	55	finally
    //   109	115	55	finally
    //   118	133	55	finally
  }
  
  public static boolean isDev() {
    if (isDev == null)
      throw new VerifyError("bad dex opcode"); 
    Boolean bool = isDev;
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\Bugly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */