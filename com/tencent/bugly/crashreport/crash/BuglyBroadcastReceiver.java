package com.tencent.bugly.crashreport.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.bugly.proguard.x;

public class BuglyBroadcastReceiver extends BroadcastReceiver {
  private static BuglyBroadcastReceiver d;
  
  private IntentFilter a = new IntentFilter();
  
  private Context b;
  
  private String c;
  
  private boolean e = true;
  
  private boolean a(Context paramContext, Intent paramIntent) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 310
    //   6: aload_2
    //   7: ifnull -> 310
    //   10: aload_2
    //   11: invokevirtual getAction : ()Ljava/lang/String;
    //   14: ldc 'android.net.conn.CONNECTIVITY_CHANGE'
    //   16: invokevirtual equals : (Ljava/lang/Object;)Z
    //   19: ifne -> 25
    //   22: goto -> 310
    //   25: aload_0
    //   26: getfield e : Z
    //   29: ifeq -> 41
    //   32: aload_0
    //   33: iconst_0
    //   34: putfield e : Z
    //   37: aload_0
    //   38: monitorexit
    //   39: iconst_1
    //   40: ireturn
    //   41: aload_0
    //   42: getfield b : Landroid/content/Context;
    //   45: invokestatic c : (Landroid/content/Context;)Ljava/lang/String;
    //   48: astore_2
    //   49: new java/lang/StringBuilder
    //   52: dup
    //   53: ldc 'is Connect BC '
    //   55: invokespecial <init> : (Ljava/lang/String;)V
    //   58: astore #5
    //   60: aload #5
    //   62: aload_2
    //   63: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload #5
    //   69: invokevirtual toString : ()Ljava/lang/String;
    //   72: iconst_0
    //   73: anewarray java/lang/Object
    //   76: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   79: pop
    //   80: new java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial <init> : ()V
    //   87: astore #5
    //   89: aload #5
    //   91: aload_0
    //   92: getfield c : Ljava/lang/String;
    //   95: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload #5
    //   101: invokevirtual toString : ()Ljava/lang/String;
    //   104: astore #5
    //   106: new java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial <init> : ()V
    //   113: astore #6
    //   115: aload #6
    //   117: aload_2
    //   118: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: ldc 'network %s changed to %s'
    //   124: iconst_2
    //   125: anewarray java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: aload #5
    //   132: aastore
    //   133: dup
    //   134: iconst_1
    //   135: aload #6
    //   137: invokevirtual toString : ()Ljava/lang/String;
    //   140: aastore
    //   141: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   144: pop
    //   145: aload_2
    //   146: ifnonnull -> 158
    //   149: aload_0
    //   150: aconst_null
    //   151: putfield c : Ljava/lang/String;
    //   154: aload_0
    //   155: monitorexit
    //   156: iconst_1
    //   157: ireturn
    //   158: aload_0
    //   159: getfield c : Ljava/lang/String;
    //   162: astore #6
    //   164: aload_0
    //   165: aload_2
    //   166: putfield c : Ljava/lang/String;
    //   169: invokestatic currentTimeMillis : ()J
    //   172: lstore_3
    //   173: invokestatic a : ()Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   176: astore #7
    //   178: invokestatic a : ()Lcom/tencent/bugly/proguard/u;
    //   181: astore #5
    //   183: aload_1
    //   184: invokestatic a : (Landroid/content/Context;)Lcom/tencent/bugly/crashreport/common/info/a;
    //   187: astore_1
    //   188: aload #7
    //   190: ifnull -> 291
    //   193: aload #5
    //   195: ifnull -> 291
    //   198: aload_1
    //   199: ifnonnull -> 205
    //   202: goto -> 291
    //   205: aload_2
    //   206: aload #6
    //   208: invokevirtual equals : (Ljava/lang/Object;)Z
    //   211: ifne -> 287
    //   214: lload_3
    //   215: aload #5
    //   217: getstatic com/tencent/bugly/crashreport/crash/c.a : I
    //   220: invokevirtual a : (I)J
    //   223: lsub
    //   224: ldc2_w 30000
    //   227: lcmp
    //   228: ifle -> 254
    //   231: ldc 'try to upload crash on network changed.'
    //   233: iconst_0
    //   234: anewarray java/lang/Object
    //   237: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   240: pop
    //   241: invokestatic a : ()Lcom/tencent/bugly/crashreport/crash/c;
    //   244: astore_1
    //   245: aload_1
    //   246: ifnull -> 254
    //   249: aload_1
    //   250: lconst_0
    //   251: invokevirtual a : (J)V
    //   254: lload_3
    //   255: aload #5
    //   257: sipush #1001
    //   260: invokevirtual a : (I)J
    //   263: lsub
    //   264: ldc2_w 30000
    //   267: lcmp
    //   268: ifle -> 287
    //   271: ldc 'try to upload userinfo on network changed.'
    //   273: iconst_0
    //   274: anewarray java/lang/Object
    //   277: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   280: pop
    //   281: getstatic com/tencent/bugly/crashreport/biz/b.a : Lcom/tencent/bugly/crashreport/biz/a;
    //   284: invokevirtual b : ()V
    //   287: aload_0
    //   288: monitorexit
    //   289: iconst_1
    //   290: ireturn
    //   291: ldc 'not inited BC not work'
    //   293: iconst_0
    //   294: anewarray java/lang/Object
    //   297: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   300: pop
    //   301: aload_0
    //   302: monitorexit
    //   303: iconst_1
    //   304: ireturn
    //   305: astore_1
    //   306: aload_0
    //   307: monitorexit
    //   308: aload_1
    //   309: athrow
    //   310: aload_0
    //   311: monitorexit
    //   312: iconst_0
    //   313: ireturn
    // Exception table:
    //   from	to	target	type
    //   10	22	305	finally
    //   25	37	305	finally
    //   41	145	305	finally
    //   149	154	305	finally
    //   158	188	305	finally
    //   205	245	305	finally
    //   249	254	305	finally
    //   254	287	305	finally
    //   291	301	305	finally
  }
  
  public static BuglyBroadcastReceiver getInstance() {
    // Byte code:
    //   0: ldc com/tencent/bugly/crashreport/crash/BuglyBroadcastReceiver
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/crashreport/crash/BuglyBroadcastReceiver.d : Lcom/tencent/bugly/crashreport/crash/BuglyBroadcastReceiver;
    //   6: ifnonnull -> 19
    //   9: new com/tencent/bugly/crashreport/crash/BuglyBroadcastReceiver
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/tencent/bugly/crashreport/crash/BuglyBroadcastReceiver.d : Lcom/tencent/bugly/crashreport/crash/BuglyBroadcastReceiver;
    //   19: getstatic com/tencent/bugly/crashreport/crash/BuglyBroadcastReceiver.d : Lcom/tencent/bugly/crashreport/crash/BuglyBroadcastReceiver;
    //   22: astore_0
    //   23: ldc com/tencent/bugly/crashreport/crash/BuglyBroadcastReceiver
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/tencent/bugly/crashreport/crash/BuglyBroadcastReceiver
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
    //   2: aload_0
    //   3: getfield a : Landroid/content/IntentFilter;
    //   6: aload_1
    //   7: invokevirtual hasAction : (Ljava/lang/String;)Z
    //   10: ifne -> 21
    //   13: aload_0
    //   14: getfield a : Landroid/content/IntentFilter;
    //   17: aload_1
    //   18: invokevirtual addAction : (Ljava/lang/String;)V
    //   21: ldc 'add action %s'
    //   23: iconst_1
    //   24: anewarray java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: aload_1
    //   30: aastore
    //   31: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   34: pop
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	38	finally
    //   21	35	38	finally
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent) {
    try {
      return;
    } finally {
      paramContext = null;
      if (!x.a((Throwable)paramContext))
        paramContext.printStackTrace(); 
    } 
  }
  
  public void register(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: putfield b : Landroid/content/Context;
    //   7: new com/tencent/bugly/crashreport/crash/BuglyBroadcastReceiver$1
    //   10: dup
    //   11: aload_0
    //   12: aload_0
    //   13: invokespecial <init> : (Lcom/tencent/bugly/crashreport/crash/BuglyBroadcastReceiver;Lcom/tencent/bugly/crashreport/crash/BuglyBroadcastReceiver;)V
    //   16: invokestatic a : (Ljava/lang/Runnable;)Z
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	23	finally
  }
  
  public void unregister(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual getClass : ()Ljava/lang/Class;
    //   6: ldc 'Unregister broadcast receiver of Bugly.'
    //   8: iconst_0
    //   9: anewarray java/lang/Object
    //   12: invokestatic a : (Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)Z
    //   15: pop
    //   16: aload_1
    //   17: aload_0
    //   18: invokevirtual unregisterReceiver : (Landroid/content/BroadcastReceiver;)V
    //   21: aload_0
    //   22: aload_1
    //   23: putfield b : Landroid/content/Context;
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: astore_1
    //   30: aload_1
    //   31: invokestatic a : (Ljava/lang/Throwable;)Z
    //   34: ifne -> 41
    //   37: aload_1
    //   38: invokevirtual printStackTrace : ()V
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Exception table:
    //   from	to	target	type
    //   2	26	29	finally
    //   30	41	44	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\crashreport\crash\BuglyBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */