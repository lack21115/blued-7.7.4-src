package com.tencent.bugly.yaq;

import android.content.Context;
import com.tencent.bugly.yaq.crashreport.common.info.a;
import com.tencent.bugly.yaq.proguard.p;
import java.util.ArrayList;
import java.util.List;

public final class b {
  public static boolean a = true;
  
  public static List<a> b = new ArrayList<a>();
  
  public static boolean c;
  
  private static p d;
  
  private static boolean e;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static void a(Context paramContext) {
    // Byte code:
    //   0: ldc com/tencent/bugly/yaq/b
    //   2: monitorenter
    //   3: aload_0
    //   4: aconst_null
    //   5: invokestatic a : (Landroid/content/Context;Lcom/tencent/bugly/yaq/BuglyStrategy;)V
    //   8: ldc com/tencent/bugly/yaq/b
    //   10: monitorexit
    //   11: new java/lang/VerifyError
    //   14: dup
    //   15: ldc 'bad dex opcode'
    //   17: invokespecial <init> : (Ljava/lang/String;)V
    //   20: athrow
    //   21: astore_0
    //   22: ldc com/tencent/bugly/yaq/b
    //   24: monitorexit
    //   25: aload_0
    //   26: athrow
    // Exception table:
    //   from	to	target	type
    //   3	8	21	finally
  }
  
  public static void a(Context paramContext, BuglyStrategy paramBuglyStrategy) {
    // Byte code:
    //   0: ldc com/tencent/bugly/yaq/b
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/yaq/b.e : Z
    //   6: ifeq -> 32
    //   9: ldc '[init] initial Multi-times, ignore this.'
    //   11: iconst_0
    //   12: anewarray java/lang/Object
    //   15: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   18: pop
    //   19: ldc com/tencent/bugly/yaq/b
    //   21: monitorexit
    //   22: new java/lang/VerifyError
    //   25: dup
    //   26: ldc 'bad dex opcode'
    //   28: invokespecial <init> : (Ljava/lang/String;)V
    //   31: athrow
    //   32: aload_0
    //   33: ifnonnull -> 54
    //   36: getstatic com/tencent/bugly/yaq/proguard/x.a : Ljava/lang/String;
    //   39: ldc '[init] context of init() is null, check it.'
    //   41: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   44: pop
    //   45: goto -> 19
    //   48: astore_0
    //   49: ldc com/tencent/bugly/yaq/b
    //   51: monitorexit
    //   52: aload_0
    //   53: athrow
    //   54: aload_0
    //   55: invokestatic a : (Landroid/content/Context;)Lcom/tencent/bugly/yaq/crashreport/common/info/a;
    //   58: invokestatic a : (Lcom/tencent/bugly/yaq/crashreport/common/info/a;)Z
    //   61: ifeq -> 71
    //   64: iconst_0
    //   65: putstatic com/tencent/bugly/yaq/b.a : Z
    //   68: goto -> 19
    //   71: new java/lang/VerifyError
    //   74: dup
    //   75: ldc 'bad dex opcode'
    //   77: invokespecial <init> : (Ljava/lang/String;)V
    //   80: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	48	finally
    //   36	45	48	finally
    //   54	68	48	finally
    //   71	81	48	finally
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean, BuglyStrategy paramBuglyStrategy) {
    // Byte code:
    //   0: ldc com/tencent/bugly/yaq/b
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/yaq/b.e : Z
    //   6: ifeq -> 32
    //   9: ldc '[init] initial Multi-times, ignore this.'
    //   11: iconst_0
    //   12: anewarray java/lang/Object
    //   15: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   18: pop
    //   19: ldc com/tencent/bugly/yaq/b
    //   21: monitorexit
    //   22: new java/lang/VerifyError
    //   25: dup
    //   26: ldc 'bad dex opcode'
    //   28: invokespecial <init> : (Ljava/lang/String;)V
    //   31: athrow
    //   32: aload_0
    //   33: ifnonnull -> 54
    //   36: getstatic com/tencent/bugly/yaq/proguard/x.a : Ljava/lang/String;
    //   39: ldc '[init] context is null, check it.'
    //   41: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   44: pop
    //   45: goto -> 19
    //   48: astore_0
    //   49: ldc com/tencent/bugly/yaq/b
    //   51: monitorexit
    //   52: aload_0
    //   53: athrow
    //   54: aload_1
    //   55: ifnonnull -> 70
    //   58: getstatic com/tencent/bugly/yaq/proguard/x.a : Ljava/lang/String;
    //   61: ldc 'init arg 'crashReportAppID' should not be null!'
    //   63: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   66: pop
    //   67: goto -> 19
    //   70: iconst_1
    //   71: putstatic com/tencent/bugly/yaq/b.e : Z
    //   74: iload_2
    //   75: ifeq -> 166
    //   78: iconst_1
    //   79: putstatic com/tencent/bugly/yaq/b.c : Z
    //   82: iconst_1
    //   83: putstatic com/tencent/bugly/yaq/proguard/x.b : Z
    //   86: ldc 'Bugly debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.'
    //   88: iconst_0
    //   89: anewarray java/lang/Object
    //   92: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   95: pop
    //   96: ldc '--------------------------------------------------------------------------------------------'
    //   98: iconst_0
    //   99: anewarray java/lang/Object
    //   102: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   105: pop
    //   106: ldc 'Bugly debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: '
    //   108: iconst_0
    //   109: anewarray java/lang/Object
    //   112: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   115: pop
    //   116: ldc '[1] 输出详细的Bugly SDK的Log -- More detailed log of Bugly SDK will be output to logcat;'
    //   118: iconst_0
    //   119: anewarray java/lang/Object
    //   122: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   125: pop
    //   126: ldc '[2] 每一条Crash都会被立即上报 -- Every crash caught by Bugly will be uploaded immediately.'
    //   128: iconst_0
    //   129: anewarray java/lang/Object
    //   132: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   135: pop
    //   136: ldc '[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.'
    //   138: iconst_0
    //   139: anewarray java/lang/Object
    //   142: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   145: pop
    //   146: ldc '--------------------------------------------------------------------------------------------'
    //   148: iconst_0
    //   149: anewarray java/lang/Object
    //   152: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   155: pop
    //   156: ldc '[init] Open debug mode of Bugly.'
    //   158: iconst_0
    //   159: anewarray java/lang/Object
    //   162: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   165: pop
    //   166: ldc '[init] Bugly version: v%s'
    //   168: iconst_1
    //   169: anewarray java/lang/Object
    //   172: dup
    //   173: iconst_0
    //   174: ldc '2.8.8'
    //   176: aastore
    //   177: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   180: pop
    //   181: ldc 'yaq crash report start initializing...'
    //   183: iconst_0
    //   184: anewarray java/lang/Object
    //   187: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   190: pop
    //   191: ldc '[init] Bugly start initializing...'
    //   193: iconst_0
    //   194: anewarray java/lang/Object
    //   197: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   200: pop
    //   201: ldc '[init] Bugly complete version: v%s'
    //   203: iconst_1
    //   204: anewarray java/lang/Object
    //   207: dup
    //   208: iconst_0
    //   209: ldc '2.8.8'
    //   211: aastore
    //   212: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   215: pop
    //   216: aload_0
    //   217: invokestatic a : (Landroid/content/Context;)Landroid/content/Context;
    //   220: invokestatic a : (Landroid/content/Context;)Lcom/tencent/bugly/yaq/crashreport/common/info/a;
    //   223: pop
    //   224: new java/lang/VerifyError
    //   227: dup
    //   228: ldc 'bad dex opcode'
    //   230: invokespecial <init> : (Ljava/lang/String;)V
    //   233: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	48	finally
    //   36	45	48	finally
    //   58	67	48	finally
    //   70	74	48	finally
    //   78	166	48	finally
    //   166	234	48	finally
  }
  
  public static void a(a parama) {
    // Byte code:
    //   0: ldc com/tencent/bugly/yaq/b
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/yaq/b.b : Ljava/util/List;
    //   6: aload_0
    //   7: invokeinterface contains : (Ljava/lang/Object;)Z
    //   12: ifne -> 25
    //   15: getstatic com/tencent/bugly/yaq/b.b : Ljava/util/List;
    //   18: aload_0
    //   19: invokeinterface add : (Ljava/lang/Object;)Z
    //   24: pop
    //   25: ldc com/tencent/bugly/yaq/b
    //   27: monitorexit
    //   28: new java/lang/VerifyError
    //   31: dup
    //   32: ldc 'bad dex opcode'
    //   34: invokespecial <init> : (Ljava/lang/String;)V
    //   37: athrow
    //   38: astore_0
    //   39: ldc com/tencent/bugly/yaq/b
    //   41: monitorexit
    //   42: aload_0
    //   43: athrow
    // Exception table:
    //   from	to	target	type
    //   3	25	38	finally
  }
  
  private static boolean a(a parama) {
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */