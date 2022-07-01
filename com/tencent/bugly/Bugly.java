package com.tencent.bugly;

import android.content.Context;

public class Bugly {
  public static final String SDK_IS_DEV = "false";
  
  private static boolean a = false;
  
  public static Context applicationContext;
  
  private static String[] b = new String[] { "BuglyCrashModule", "BuglyRqdModule", "BuglyBetaModule" };
  
  private static String[] c = new String[] { "BuglyRqdModule", "BuglyCrashModule", "BuglyBetaModule" };
  
  public static boolean enable = true;
  
  public static Boolean isDev;
  
  public static String getAppChannel() {
    // Byte code:
    //   0: ldc com/tencent/bugly/Bugly
    //   2: monitorenter
    //   3: invokestatic b : ()Lcom/tencent/bugly/crashreport/common/info/a;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnonnull -> 16
    //   11: ldc com/tencent/bugly/Bugly
    //   13: monitorexit
    //   14: aconst_null
    //   15: areturn
    //   16: aload_0
    //   17: getfield m : Ljava/lang/String;
    //   20: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   23: ifeq -> 88
    //   26: invokestatic a : ()Lcom/tencent/bugly/proguard/p;
    //   29: astore_1
    //   30: aload_1
    //   31: ifnonnull -> 44
    //   34: aload_0
    //   35: getfield m : Ljava/lang/String;
    //   38: astore_0
    //   39: ldc com/tencent/bugly/Bugly
    //   41: monitorexit
    //   42: aload_0
    //   43: areturn
    //   44: aload_1
    //   45: sipush #556
    //   48: aconst_null
    //   49: iconst_1
    //   50: invokevirtual a : (ILcom/tencent/bugly/proguard/o;Z)Ljava/util/Map;
    //   53: astore_1
    //   54: aload_1
    //   55: ifnull -> 88
    //   58: aload_1
    //   59: ldc 'app_channel'
    //   61: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   66: checkcast [B
    //   69: astore_1
    //   70: aload_1
    //   71: ifnull -> 88
    //   74: new java/lang/String
    //   77: dup
    //   78: aload_1
    //   79: invokespecial <init> : ([B)V
    //   82: astore_0
    //   83: ldc com/tencent/bugly/Bugly
    //   85: monitorexit
    //   86: aload_0
    //   87: areturn
    //   88: aload_0
    //   89: getfield m : Ljava/lang/String;
    //   92: astore_0
    //   93: ldc com/tencent/bugly/Bugly
    //   95: monitorexit
    //   96: aload_0
    //   97: areturn
    //   98: astore_0
    //   99: ldc com/tencent/bugly/Bugly
    //   101: monitorexit
    //   102: aload_0
    //   103: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	98	finally
    //   16	30	98	finally
    //   34	39	98	finally
    //   44	54	98	finally
    //   58	70	98	finally
    //   74	83	98	finally
    //   88	93	98	finally
  }
  
  public static void init(Context paramContext, String paramString, boolean paramBoolean) {
    init(paramContext, paramString, paramBoolean, null);
  }
  
  public static void init(Context paramContext, String paramString, boolean paramBoolean, BuglyStrategy paramBuglyStrategy) {
    // Byte code:
    //   0: ldc com/tencent/bugly/Bugly
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/Bugly.a : Z
    //   6: istore #6
    //   8: iload #6
    //   10: ifeq -> 17
    //   13: ldc com/tencent/bugly/Bugly
    //   15: monitorexit
    //   16: return
    //   17: iconst_1
    //   18: putstatic com/tencent/bugly/Bugly.a : Z
    //   21: aload_0
    //   22: invokestatic a : (Landroid/content/Context;)Landroid/content/Context;
    //   25: astore_0
    //   26: aload_0
    //   27: putstatic com/tencent/bugly/Bugly.applicationContext : Landroid/content/Context;
    //   30: aload_0
    //   31: ifnonnull -> 47
    //   34: getstatic com/tencent/bugly/proguard/x.a : Ljava/lang/String;
    //   37: ldc 'init arg 'context' should not be null!'
    //   39: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   42: pop
    //   43: ldc com/tencent/bugly/Bugly
    //   45: monitorexit
    //   46: return
    //   47: invokestatic isDev : ()Z
    //   50: ifeq -> 59
    //   53: getstatic com/tencent/bugly/Bugly.c : [Ljava/lang/String;
    //   56: putstatic com/tencent/bugly/Bugly.b : [Ljava/lang/String;
    //   59: getstatic com/tencent/bugly/Bugly.b : [Ljava/lang/String;
    //   62: astore_0
    //   63: aload_0
    //   64: arraylength
    //   65: istore #5
    //   67: iconst_0
    //   68: istore #4
    //   70: iload #4
    //   72: iload #5
    //   74: if_icmpge -> 144
    //   77: aload_0
    //   78: iload #4
    //   80: aaload
    //   81: astore #7
    //   83: aload #7
    //   85: ldc 'BuglyCrashModule'
    //   87: invokevirtual equals : (Ljava/lang/Object;)Z
    //   90: ifeq -> 102
    //   93: invokestatic getInstance : ()Lcom/tencent/bugly/CrashModule;
    //   96: invokestatic a : (Lcom/tencent/bugly/a;)V
    //   99: goto -> 169
    //   102: aload #7
    //   104: ldc 'BuglyBetaModule'
    //   106: invokevirtual equals : (Ljava/lang/Object;)Z
    //   109: ifne -> 169
    //   112: aload #7
    //   114: ldc 'BuglyRqdModule'
    //   116: invokevirtual equals : (Ljava/lang/Object;)Z
    //   119: ifne -> 169
    //   122: aload #7
    //   124: ldc 'BuglyFeedbackModule'
    //   126: invokevirtual equals : (Ljava/lang/Object;)Z
    //   129: pop
    //   130: goto -> 169
    //   133: astore #7
    //   135: aload #7
    //   137: invokestatic b : (Ljava/lang/Throwable;)Z
    //   140: pop
    //   141: goto -> 169
    //   144: getstatic com/tencent/bugly/Bugly.enable : Z
    //   147: putstatic com/tencent/bugly/b.a : Z
    //   150: getstatic com/tencent/bugly/Bugly.applicationContext : Landroid/content/Context;
    //   153: aload_1
    //   154: iload_2
    //   155: aload_3
    //   156: invokestatic a : (Landroid/content/Context;Ljava/lang/String;ZLcom/tencent/bugly/BuglyStrategy;)V
    //   159: ldc com/tencent/bugly/Bugly
    //   161: monitorexit
    //   162: return
    //   163: astore_0
    //   164: ldc com/tencent/bugly/Bugly
    //   166: monitorexit
    //   167: aload_0
    //   168: athrow
    //   169: iload #4
    //   171: iconst_1
    //   172: iadd
    //   173: istore #4
    //   175: goto -> 70
    // Exception table:
    //   from	to	target	type
    //   3	8	163	finally
    //   17	30	163	finally
    //   34	43	163	finally
    //   47	59	163	finally
    //   59	67	163	finally
    //   83	99	133	finally
    //   102	130	133	finally
    //   135	141	163	finally
    //   144	159	163	finally
  }
  
  public static boolean isDev() {
    if (isDev == null)
      isDev = Boolean.valueOf(Boolean.parseBoolean("false".replace("@", ""))); 
    return isDev.booleanValue();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\Bugly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */