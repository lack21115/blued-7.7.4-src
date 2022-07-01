package com.tencent.bugly.yaq.crashreport.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.bugly.yaq.crashreport.biz.a;
import com.tencent.bugly.yaq.crashreport.biz.b;

public class BuglyBroadcastRecevier extends BroadcastReceiver {
  private static BuglyBroadcastRecevier d = null;
  
  private IntentFilter a = new IntentFilter();
  
  private Context b;
  
  private String c;
  
  private boolean e = true;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public BuglyBroadcastRecevier() {
    throw new VerifyError("bad dex opcode");
  }
  
  private boolean a(Context paramContext, Intent paramIntent) {
    // Byte code:
    //   0: iconst_1
    //   1: istore #4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_1
    //   6: ifnull -> 27
    //   9: aload_2
    //   10: ifnull -> 27
    //   13: aload_2
    //   14: invokevirtual getAction : ()Ljava/lang/String;
    //   17: ldc 'android.net.conn.CONNECTIVITY_CHANGE'
    //   19: invokevirtual equals : (Ljava/lang/Object;)Z
    //   22: istore_3
    //   23: iload_3
    //   24: ifne -> 33
    //   27: iconst_0
    //   28: istore_3
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_3
    //   32: ireturn
    //   33: aload_0
    //   34: getfield e : Z
    //   37: ifeq -> 56
    //   40: aload_0
    //   41: iconst_0
    //   42: putfield e : Z
    //   45: iload #4
    //   47: istore_3
    //   48: goto -> 29
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    //   56: aload_0
    //   57: getfield b : Landroid/content/Context;
    //   60: invokestatic e : (Landroid/content/Context;)Ljava/lang/String;
    //   63: astore #7
    //   65: new java/lang/StringBuilder
    //   68: dup
    //   69: ldc 'is Connect BC '
    //   71: invokespecial <init> : (Ljava/lang/String;)V
    //   74: aload #7
    //   76: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual toString : ()Ljava/lang/String;
    //   82: iconst_0
    //   83: anewarray java/lang/Object
    //   86: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   89: pop
    //   90: ldc 'network %s changed to %s'
    //   92: iconst_2
    //   93: anewarray java/lang/Object
    //   96: dup
    //   97: iconst_0
    //   98: new java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial <init> : ()V
    //   105: aload_0
    //   106: getfield c : Ljava/lang/String;
    //   109: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual toString : ()Ljava/lang/String;
    //   115: aastore
    //   116: dup
    //   117: iconst_1
    //   118: new java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial <init> : ()V
    //   125: aload #7
    //   127: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual toString : ()Ljava/lang/String;
    //   133: aastore
    //   134: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   137: pop
    //   138: aload #7
    //   140: ifnonnull -> 154
    //   143: aload_0
    //   144: aconst_null
    //   145: putfield c : Ljava/lang/String;
    //   148: iload #4
    //   150: istore_3
    //   151: goto -> 29
    //   154: aload_0
    //   155: getfield c : Ljava/lang/String;
    //   158: astore #8
    //   160: aload_0
    //   161: aload #7
    //   163: putfield c : Ljava/lang/String;
    //   166: invokestatic currentTimeMillis : ()J
    //   169: lstore #5
    //   171: invokestatic a : ()Lcom/tencent/bugly/yaq/crashreport/common/strategy/a;
    //   174: astore #9
    //   176: invokestatic a : ()Lcom/tencent/bugly/yaq/proguard/t;
    //   179: astore_2
    //   180: aload_1
    //   181: invokestatic a : (Landroid/content/Context;)Lcom/tencent/bugly/yaq/crashreport/common/info/a;
    //   184: astore_1
    //   185: aload #9
    //   187: ifnull -> 198
    //   190: aload_2
    //   191: ifnull -> 198
    //   194: aload_1
    //   195: ifnonnull -> 214
    //   198: ldc 'not inited BC not work'
    //   200: iconst_0
    //   201: anewarray java/lang/Object
    //   204: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   207: pop
    //   208: iload #4
    //   210: istore_3
    //   211: goto -> 29
    //   214: iload #4
    //   216: istore_3
    //   217: aload #7
    //   219: aload #8
    //   221: invokevirtual equals : (Ljava/lang/Object;)Z
    //   224: ifne -> 29
    //   227: lload #5
    //   229: aload_2
    //   230: getstatic com/tencent/bugly/yaq/crashreport/crash/c.a : I
    //   233: invokevirtual a : (I)J
    //   236: lsub
    //   237: ldc2_w 60000
    //   240: lcmp
    //   241: ifle -> 267
    //   244: ldc 'try to upload crash on network changed.'
    //   246: iconst_0
    //   247: anewarray java/lang/Object
    //   250: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   253: pop
    //   254: invokestatic a : ()Lcom/tencent/bugly/yaq/crashreport/crash/c;
    //   257: astore_1
    //   258: aload_1
    //   259: ifnull -> 267
    //   262: aload_1
    //   263: lconst_0
    //   264: invokevirtual a : (J)V
    //   267: iload #4
    //   269: istore_3
    //   270: lload #5
    //   272: aload_2
    //   273: sipush #1001
    //   276: invokevirtual a : (I)J
    //   279: lsub
    //   280: ldc2_w 60000
    //   283: lcmp
    //   284: ifle -> 29
    //   287: ldc 'try to upload userinfo on network changed.'
    //   289: iconst_0
    //   290: anewarray java/lang/Object
    //   293: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   296: pop
    //   297: getstatic com/tencent/bugly/yaq/crashreport/biz/b.a : Lcom/tencent/bugly/yaq/crashreport/biz/a;
    //   300: iconst_0
    //   301: invokevirtual a : (Z)V
    //   304: iload #4
    //   306: istore_3
    //   307: goto -> 29
    // Exception table:
    //   from	to	target	type
    //   13	23	51	finally
    //   33	45	51	finally
    //   56	138	51	finally
    //   143	148	51	finally
    //   154	185	51	finally
    //   198	208	51	finally
    //   217	258	51	finally
    //   262	267	51	finally
    //   270	304	51	finally
  }
  
  public static BuglyBroadcastRecevier getInstance() {
    // Byte code:
    //   0: ldc com/tencent/bugly/yaq/crashreport/crash/BuglyBroadcastRecevier
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/yaq/crashreport/crash/BuglyBroadcastRecevier.d : Lcom/tencent/bugly/yaq/crashreport/crash/BuglyBroadcastRecevier;
    //   6: ifnonnull -> 19
    //   9: new com/tencent/bugly/yaq/crashreport/crash/BuglyBroadcastRecevier
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/tencent/bugly/yaq/crashreport/crash/BuglyBroadcastRecevier.d : Lcom/tencent/bugly/yaq/crashreport/crash/BuglyBroadcastRecevier;
    //   19: getstatic com/tencent/bugly/yaq/crashreport/crash/BuglyBroadcastRecevier.d : Lcom/tencent/bugly/yaq/crashreport/crash/BuglyBroadcastRecevier;
    //   22: astore_0
    //   23: ldc com/tencent/bugly/yaq/crashreport/crash/BuglyBroadcastRecevier
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/tencent/bugly/yaq/crashreport/crash/BuglyBroadcastRecevier
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
    //   37: new java/lang/VerifyError
    //   40: dup
    //   41: ldc 'bad dex opcode'
    //   43: invokespecial <init> : (Ljava/lang/String;)V
    //   46: athrow
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	47	finally
    //   21	35	47	finally
  }
  
  protected void finalize() throws Throwable {
    super.finalize();
    if (this.b != null)
      this.b.unregisterReceiver(this); 
    throw new VerifyError("bad dex opcode");
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent) {
    try {
      a(paramContext, paramIntent);
    } catch (Throwable throwable) {}
    throw new VerifyError("bad dex opcode");
  }
  
  public void regist(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'regis BC'
    //   4: iconst_0
    //   5: anewarray java/lang/Object
    //   8: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   11: pop
    //   12: aload_0
    //   13: aload_1
    //   14: putfield b : Landroid/content/Context;
    //   17: aload_1
    //   18: aload_0
    //   19: aload_0
    //   20: getfield a : Landroid/content/IntentFilter;
    //   23: invokevirtual registerReceiver : (Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   26: pop
    //   27: aload_0
    //   28: monitorexit
    //   29: new java/lang/VerifyError
    //   32: dup
    //   33: ldc 'bad dex opcode'
    //   35: invokespecial <init> : (Ljava/lang/String;)V
    //   38: athrow
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual printStackTrace : ()V
    //   44: goto -> 27
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Exception table:
    //   from	to	target	type
    //   2	27	39	java/lang/Throwable
    //   2	27	47	finally
    //   40	44	47	finally
  }
  
  public void unregist(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'unregis BC'
    //   4: iconst_0
    //   5: anewarray java/lang/Object
    //   8: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   11: pop
    //   12: aload_1
    //   13: aload_0
    //   14: invokevirtual unregisterReceiver : (Landroid/content/BroadcastReceiver;)V
    //   17: aload_0
    //   18: aload_1
    //   19: putfield b : Landroid/content/Context;
    //   22: aload_0
    //   23: monitorexit
    //   24: new java/lang/VerifyError
    //   27: dup
    //   28: ldc 'bad dex opcode'
    //   30: invokespecial <init> : (Ljava/lang/String;)V
    //   33: athrow
    //   34: astore_1
    //   35: aload_1
    //   36: invokestatic a : (Ljava/lang/Throwable;)Z
    //   39: ifne -> 22
    //   42: aload_1
    //   43: invokevirtual printStackTrace : ()V
    //   46: goto -> 22
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	34	java/lang/Throwable
    //   2	22	49	finally
    //   35	46	49	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\crashreport\crash\BuglyBroadcastRecevier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */