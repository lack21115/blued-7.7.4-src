package com.tencent.bugly;

import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.c;

public class CrashModule extends a {
  public static final int MODULE_ID = 1004;
  
  private static int c;
  
  private static CrashModule e = new CrashModule();
  
  private long a;
  
  private BuglyStrategy.a b;
  
  private boolean d = false;
  
  private void a(Context paramContext, BuglyStrategy paramBuglyStrategy) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ifnonnull -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_2
    //   10: invokevirtual getLibBuglySOFilePath : ()Ljava/lang/String;
    //   13: astore_3
    //   14: aload_3
    //   15: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   18: ifne -> 43
    //   21: aload_1
    //   22: invokestatic a : (Landroid/content/Context;)Lcom/tencent/bugly/crashreport/common/info/a;
    //   25: aload_3
    //   26: putfield n : Ljava/lang/String;
    //   29: ldc 'setted libBugly.so file path :%s'
    //   31: iconst_1
    //   32: anewarray java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: aload_3
    //   38: aastore
    //   39: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   42: pop
    //   43: aload_2
    //   44: invokevirtual getCrashHandleCallback : ()Lcom/tencent/bugly/BuglyStrategy$a;
    //   47: ifnull -> 68
    //   50: aload_0
    //   51: aload_2
    //   52: invokevirtual getCrashHandleCallback : ()Lcom/tencent/bugly/BuglyStrategy$a;
    //   55: putfield b : Lcom/tencent/bugly/BuglyStrategy$a;
    //   58: ldc 'setted CrashHanldeCallback'
    //   60: iconst_0
    //   61: anewarray java/lang/Object
    //   64: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   67: pop
    //   68: aload_2
    //   69: invokevirtual getAppReportDelay : ()J
    //   72: lconst_0
    //   73: lcmp
    //   74: ifle -> 105
    //   77: aload_0
    //   78: aload_2
    //   79: invokevirtual getAppReportDelay : ()J
    //   82: putfield a : J
    //   85: ldc 'setted delay: %d'
    //   87: iconst_1
    //   88: anewarray java/lang/Object
    //   91: dup
    //   92: iconst_0
    //   93: aload_0
    //   94: getfield a : J
    //   97: invokestatic valueOf : (J)Ljava/lang/Long;
    //   100: aastore
    //   101: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   104: pop
    //   105: aload_0
    //   106: monitorexit
    //   107: return
    //   108: astore_1
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_1
    //   112: athrow
    // Exception table:
    //   from	to	target	type
    //   9	43	108	finally
    //   43	68	108	finally
    //   68	105	108	finally
  }
  
  public static CrashModule getInstance() {
    CrashModule crashModule = e;
    crashModule.id = 1004;
    return crashModule;
  }
  
  public String[] getTables() {
    return new String[] { "t_cr" };
  }
  
  public boolean hasInitialized() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield d : Z
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public void init(Context paramContext, boolean paramBoolean, BuglyStrategy paramBuglyStrategy) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 268
    //   6: aload_0
    //   7: getfield d : Z
    //   10: ifeq -> 16
    //   13: goto -> 268
    //   16: ldc 'Initializing crash module.'
    //   18: iconst_0
    //   19: anewarray java/lang/Object
    //   22: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   25: pop
    //   26: invokestatic a : ()Lcom/tencent/bugly/proguard/n;
    //   29: astore #7
    //   31: getstatic com/tencent/bugly/CrashModule.c : I
    //   34: iconst_1
    //   35: iadd
    //   36: istore #4
    //   38: iload #4
    //   40: putstatic com/tencent/bugly/CrashModule.c : I
    //   43: aload #7
    //   45: sipush #1004
    //   48: iload #4
    //   50: invokevirtual a : (II)V
    //   53: aload_0
    //   54: iconst_1
    //   55: putfield d : Z
    //   58: aload_1
    //   59: invokestatic setContext : (Landroid/content/Context;)V
    //   62: aload_0
    //   63: aload_1
    //   64: aload_3
    //   65: invokespecial a : (Landroid/content/Context;Lcom/tencent/bugly/BuglyStrategy;)V
    //   68: sipush #1004
    //   71: aload_1
    //   72: iload_2
    //   73: aload_0
    //   74: getfield b : Lcom/tencent/bugly/BuglyStrategy$a;
    //   77: aconst_null
    //   78: aconst_null
    //   79: invokestatic a : (ILandroid/content/Context;ZLcom/tencent/bugly/BuglyStrategy$a;Lcom/tencent/bugly/proguard/o;Ljava/lang/String;)Lcom/tencent/bugly/crashreport/crash/c;
    //   82: astore #7
    //   84: aload #7
    //   86: invokevirtual e : ()V
    //   89: aload_3
    //   90: ifnull -> 111
    //   93: aload #7
    //   95: aload_3
    //   96: invokevirtual getCallBackType : ()I
    //   99: invokevirtual a : (I)V
    //   102: aload #7
    //   104: aload_3
    //   105: invokevirtual getCloseErrorCallback : ()Z
    //   108: invokevirtual a : (Z)V
    //   111: aload #7
    //   113: invokevirtual m : ()V
    //   116: aload_3
    //   117: ifnull -> 148
    //   120: aload_3
    //   121: invokevirtual isEnableNativeCrashMonitor : ()Z
    //   124: ifeq -> 130
    //   127: goto -> 148
    //   130: ldc '[crash] Closed native crash monitor!'
    //   132: iconst_0
    //   133: anewarray java/lang/Object
    //   136: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   139: pop
    //   140: aload #7
    //   142: invokevirtual f : ()V
    //   145: goto -> 153
    //   148: aload #7
    //   150: invokevirtual g : ()V
    //   153: aload_3
    //   154: ifnull -> 185
    //   157: aload_3
    //   158: invokevirtual isEnableANRCrashMonitor : ()Z
    //   161: ifeq -> 167
    //   164: goto -> 185
    //   167: ldc '[crash] Closed ANR monitor!'
    //   169: iconst_0
    //   170: anewarray java/lang/Object
    //   173: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   176: pop
    //   177: aload #7
    //   179: invokevirtual i : ()V
    //   182: goto -> 190
    //   185: aload #7
    //   187: invokevirtual h : ()V
    //   190: aload_3
    //   191: ifnull -> 271
    //   194: aload_3
    //   195: invokevirtual getAppReportDelay : ()J
    //   198: lstore #5
    //   200: goto -> 203
    //   203: aload #7
    //   205: lload #5
    //   207: invokevirtual a : (J)V
    //   210: aload #7
    //   212: invokevirtual l : ()V
    //   215: aload_1
    //   216: invokestatic a : (Landroid/content/Context;)Lcom/tencent/bugly/crashreport/crash/d;
    //   219: pop
    //   220: invokestatic getInstance : ()Lcom/tencent/bugly/crashreport/crash/BuglyBroadcastReceiver;
    //   223: astore_3
    //   224: aload_3
    //   225: ldc 'android.net.conn.CONNECTIVITY_CHANGE'
    //   227: invokevirtual addFilter : (Ljava/lang/String;)V
    //   230: aload_3
    //   231: aload_1
    //   232: invokevirtual register : (Landroid/content/Context;)V
    //   235: invokestatic a : ()Lcom/tencent/bugly/proguard/n;
    //   238: astore_1
    //   239: getstatic com/tencent/bugly/CrashModule.c : I
    //   242: iconst_1
    //   243: isub
    //   244: istore #4
    //   246: iload #4
    //   248: putstatic com/tencent/bugly/CrashModule.c : I
    //   251: aload_1
    //   252: sipush #1004
    //   255: iload #4
    //   257: invokevirtual a : (II)V
    //   260: aload_0
    //   261: monitorexit
    //   262: return
    //   263: astore_1
    //   264: aload_0
    //   265: monitorexit
    //   266: aload_1
    //   267: athrow
    //   268: aload_0
    //   269: monitorexit
    //   270: return
    //   271: lconst_0
    //   272: lstore #5
    //   274: goto -> 203
    // Exception table:
    //   from	to	target	type
    //   6	13	263	finally
    //   16	89	263	finally
    //   93	111	263	finally
    //   111	116	263	finally
    //   120	127	263	finally
    //   130	145	263	finally
    //   148	153	263	finally
    //   157	164	263	finally
    //   167	182	263	finally
    //   185	190	263	finally
    //   194	200	263	finally
    //   203	260	263	finally
  }
  
  public void onServerStrategyChanged(StrategyBean paramStrategyBean) {
    if (paramStrategyBean == null)
      return; 
    c c = c.a();
    if (c != null)
      c.a(paramStrategyBean); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\CrashModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */