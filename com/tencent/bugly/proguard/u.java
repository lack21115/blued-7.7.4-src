package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.bugly.b;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

public final class u {
  private static u b;
  
  public boolean a = true;
  
  private final p c;
  
  private final Context d;
  
  private Map<Integer, Long> e = new HashMap<Integer, Long>();
  
  private long f;
  
  private long g;
  
  private LinkedBlockingQueue<Runnable> h = new LinkedBlockingQueue<Runnable>();
  
  private LinkedBlockingQueue<Runnable> i = new LinkedBlockingQueue<Runnable>();
  
  private final Object j = new Object();
  
  private String k = null;
  
  private byte[] l = null;
  
  private long m = 0L;
  
  private byte[] n = null;
  
  private long o = 0L;
  
  private String p = null;
  
  private long q = 0L;
  
  private final Object r = new Object();
  
  private boolean s = false;
  
  private final Object t = new Object();
  
  private int u = 0;
  
  private u(Context paramContext) {
    this.d = paramContext;
    this.c = p.a();
    try {
      Class.forName("android.util.Base64");
    } catch (ClassNotFoundException classNotFoundException) {
      x.a("[UploadManager] Error: Can not find Base64 class, will not use stronger security way to upload", new Object[0]);
      this.a = false;
    } 
    if (this.a) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDP9x32s5pPtZBXzJBz2GWM/sbTvVO2+RvW0PH01IdaBxc/");
      stringBuilder.append("fB6fbHZocC9T3nl1+J5eAFjIRVuV8vHDky7Qo82Mnh0PVvcZIEQvMMVKU8dsMQopxgsOs2gkSHJwgWdinKNS8CmWobo6pFwPUW11lMv714jAUZRq2GBOqiO2vQI6iwIDAQAB");
      this.k = stringBuilder.toString();
    } 
  }
  
  public static u a() {
    // Byte code:
    //   0: ldc com/tencent/bugly/proguard/u
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/proguard/u.b : Lcom/tencent/bugly/proguard/u;
    //   6: astore_0
    //   7: ldc com/tencent/bugly/proguard/u
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/tencent/bugly/proguard/u
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static u a(Context paramContext) {
    // Byte code:
    //   0: ldc com/tencent/bugly/proguard/u
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/proguard/u.b : Lcom/tencent/bugly/proguard/u;
    //   6: ifnonnull -> 20
    //   9: new com/tencent/bugly/proguard/u
    //   12: dup
    //   13: aload_0
    //   14: invokespecial <init> : (Landroid/content/Context;)V
    //   17: putstatic com/tencent/bugly/proguard/u.b : Lcom/tencent/bugly/proguard/u;
    //   20: getstatic com/tencent/bugly/proguard/u.b : Lcom/tencent/bugly/proguard/u;
    //   23: astore_0
    //   24: ldc com/tencent/bugly/proguard/u
    //   26: monitorexit
    //   27: aload_0
    //   28: areturn
    //   29: astore_0
    //   30: ldc com/tencent/bugly/proguard/u
    //   32: monitorexit
    //   33: aload_0
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   3	20	29	finally
    //   20	24	29	finally
  }
  
  private void a(Runnable paramRunnable, long paramLong) {
    if (paramRunnable == null) {
      x.d("[UploadManager] Upload task should not be null", new Object[0]);
      return;
    } 
    x.c("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    Thread thread = z.a(paramRunnable, "BUGLY_SYNC_UPLOAD");
    if (thread == null) {
      x.e("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
      a(paramRunnable, true);
      return;
    } 
    try {
      return;
    } finally {
      thread = null;
      x.e("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", new Object[] { thread.getMessage() });
      a(paramRunnable, true);
      c(0);
    } 
  }
  
  private void a(Runnable paramRunnable, boolean paramBoolean1, boolean paramBoolean2, long paramLong) {
    if (paramRunnable == null)
      x.d("[UploadManager] Upload task should not be null", new Object[0]); 
    x.c("[UploadManager] Add upload task (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    if (this.p != null) {
      if (b()) {
        x.c("[UploadManager] Sucessfully got session ID, try to execute upload task now (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
        if (paramBoolean2) {
          a(paramRunnable, paramLong);
          return;
        } 
        a(paramRunnable, paramBoolean1);
        c(0);
        return;
      } 
      x.a("[UploadManager] Session ID is expired, drop it (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      b(false);
    } 
    synchronized (this.t) {
      if (this.s) {
        a(paramRunnable, paramBoolean1);
        return;
      } 
      this.s = true;
      x.c("[UploadManager] Initialize security context now (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      if (paramBoolean2) {
        a(new a(this, this.d, paramRunnable, paramLong), 0L);
        return;
      } 
      a(paramRunnable, paramBoolean1);
      paramRunnable = new a(this, this.d);
      x.a("[UploadManager] Create and start a new thread to execute a task of initializing security context: %s", new Object[] { "BUGLY_ASYNC_UPLOAD" });
      if (z.a(paramRunnable, "BUGLY_ASYNC_UPLOAD") == null) {
        x.d("[UploadManager] Failed to start a thread to execute task of initializing security context, try to post it into thread pool.", new Object[0]);
        null = w.a();
        if (null != null) {
          null.a(paramRunnable);
          return;
        } 
        x.e("[UploadManager] Asynchronous thread pool is unavailable now, try next time.", new Object[0]);
        synchronized (this.t) {
          this.s = false;
          return;
        } 
      } 
      return;
    } 
  }
  
  private boolean a(Runnable paramRunnable, boolean paramBoolean) {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull -> 16
    //   4: ldc '[UploadManager] Upload task should not be null'
    //   6: iconst_0
    //   7: anewarray java/lang/Object
    //   10: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   13: pop
    //   14: iconst_0
    //   15: ireturn
    //   16: ldc '[UploadManager] Add upload task to queue (pid=%d | tid=%d)'
    //   18: iconst_2
    //   19: anewarray java/lang/Object
    //   22: dup
    //   23: iconst_0
    //   24: invokestatic myPid : ()I
    //   27: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   30: aastore
    //   31: dup
    //   32: iconst_1
    //   33: invokestatic myTid : ()I
    //   36: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   39: aastore
    //   40: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   43: pop
    //   44: aload_0
    //   45: getfield j : Ljava/lang/Object;
    //   48: astore_3
    //   49: aload_3
    //   50: monitorenter
    //   51: iload_2
    //   52: ifeq -> 66
    //   55: aload_0
    //   56: getfield h : Ljava/util/concurrent/LinkedBlockingQueue;
    //   59: aload_1
    //   60: invokevirtual put : (Ljava/lang/Object;)V
    //   63: goto -> 74
    //   66: aload_0
    //   67: getfield i : Ljava/util/concurrent/LinkedBlockingQueue;
    //   70: aload_1
    //   71: invokevirtual put : (Ljava/lang/Object;)V
    //   74: aload_3
    //   75: monitorexit
    //   76: iconst_1
    //   77: ireturn
    //   78: astore_1
    //   79: aload_3
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    //   83: astore_1
    //   84: ldc '[UploadManager] Failed to add upload task to queue: %s'
    //   86: iconst_1
    //   87: anewarray java/lang/Object
    //   90: dup
    //   91: iconst_0
    //   92: aload_1
    //   93: invokevirtual getMessage : ()Ljava/lang/String;
    //   96: aastore
    //   97: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   100: pop
    //   101: iconst_0
    //   102: ireturn
    // Exception table:
    //   from	to	target	type
    //   16	51	83	finally
    //   55	63	78	finally
    //   66	74	78	finally
    //   74	76	78	finally
    //   79	83	83	finally
  }
  
  private void c(int paramInt) {
    // Byte code:
    //   0: iload_1
    //   1: ifge -> 15
    //   4: ldc '[UploadManager] Number of task to execute should >= 0'
    //   6: iconst_0
    //   7: anewarray java/lang/Object
    //   10: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   13: pop
    //   14: return
    //   15: invokestatic a : ()Lcom/tencent/bugly/proguard/w;
    //   18: astore #4
    //   20: new java/util/concurrent/LinkedBlockingQueue
    //   23: dup
    //   24: invokespecial <init> : ()V
    //   27: astore #5
    //   29: new java/util/concurrent/LinkedBlockingQueue
    //   32: dup
    //   33: invokespecial <init> : ()V
    //   36: astore #6
    //   38: aload_0
    //   39: getfield j : Ljava/lang/Object;
    //   42: astore #7
    //   44: aload #7
    //   46: monitorenter
    //   47: ldc '[UploadManager] Try to poll all upload task need and put them into temp queue (pid=%d | tid=%d)'
    //   49: iconst_2
    //   50: anewarray java/lang/Object
    //   53: dup
    //   54: iconst_0
    //   55: invokestatic myPid : ()I
    //   58: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   61: aastore
    //   62: dup
    //   63: iconst_1
    //   64: invokestatic myTid : ()I
    //   67: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   70: aastore
    //   71: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   74: pop
    //   75: aload_0
    //   76: getfield h : Ljava/util/concurrent/LinkedBlockingQueue;
    //   79: invokevirtual size : ()I
    //   82: istore_2
    //   83: aload_0
    //   84: getfield i : Ljava/util/concurrent/LinkedBlockingQueue;
    //   87: invokevirtual size : ()I
    //   90: istore_3
    //   91: iload_2
    //   92: ifne -> 533
    //   95: iload_3
    //   96: ifne -> 533
    //   99: ldc '[UploadManager] There is no upload task in queue.'
    //   101: iconst_0
    //   102: anewarray java/lang/Object
    //   105: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   108: pop
    //   109: aload #7
    //   111: monitorexit
    //   112: return
    //   113: aload #4
    //   115: ifnull -> 570
    //   118: aload #4
    //   120: invokevirtual c : ()Z
    //   123: ifne -> 572
    //   126: goto -> 570
    //   129: iload_3
    //   130: iload_2
    //   131: if_icmpge -> 584
    //   134: aload_0
    //   135: getfield h : Ljava/util/concurrent/LinkedBlockingQueue;
    //   138: invokevirtual peek : ()Ljava/lang/Object;
    //   141: checkcast java/lang/Runnable
    //   144: astore #8
    //   146: aload #8
    //   148: ifnull -> 584
    //   151: aload #5
    //   153: aload #8
    //   155: invokevirtual put : (Ljava/lang/Object;)V
    //   158: aload_0
    //   159: getfield h : Ljava/util/concurrent/LinkedBlockingQueue;
    //   162: invokevirtual poll : ()Ljava/lang/Object;
    //   165: pop
    //   166: goto -> 577
    //   169: astore #8
    //   171: ldc_w '[UploadManager] Failed to add upload task to temp urgent queue: %s'
    //   174: iconst_1
    //   175: anewarray java/lang/Object
    //   178: dup
    //   179: iconst_0
    //   180: aload #8
    //   182: invokevirtual getMessage : ()Ljava/lang/String;
    //   185: aastore
    //   186: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   189: pop
    //   190: goto -> 577
    //   193: iload_3
    //   194: iload_1
    //   195: if_icmpge -> 257
    //   198: aload_0
    //   199: getfield i : Ljava/util/concurrent/LinkedBlockingQueue;
    //   202: invokevirtual peek : ()Ljava/lang/Object;
    //   205: checkcast java/lang/Runnable
    //   208: astore #8
    //   210: aload #8
    //   212: ifnull -> 257
    //   215: aload #6
    //   217: aload #8
    //   219: invokevirtual put : (Ljava/lang/Object;)V
    //   222: aload_0
    //   223: getfield i : Ljava/util/concurrent/LinkedBlockingQueue;
    //   226: invokevirtual poll : ()Ljava/lang/Object;
    //   229: pop
    //   230: goto -> 589
    //   233: astore #8
    //   235: ldc_w '[UploadManager] Failed to add upload task to temp urgent queue: %s'
    //   238: iconst_1
    //   239: anewarray java/lang/Object
    //   242: dup
    //   243: iconst_0
    //   244: aload #8
    //   246: invokevirtual getMessage : ()Ljava/lang/String;
    //   249: aastore
    //   250: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   253: pop
    //   254: goto -> 589
    //   257: aload #7
    //   259: monitorexit
    //   260: iload_2
    //   261: ifle -> 300
    //   264: ldc_w '[UploadManager] Execute urgent upload tasks of queue which has %d tasks (pid=%d | tid=%d)'
    //   267: iconst_3
    //   268: anewarray java/lang/Object
    //   271: dup
    //   272: iconst_0
    //   273: iload_2
    //   274: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   277: aastore
    //   278: dup
    //   279: iconst_1
    //   280: invokestatic myPid : ()I
    //   283: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   286: aastore
    //   287: dup
    //   288: iconst_2
    //   289: invokestatic myTid : ()I
    //   292: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   295: aastore
    //   296: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   299: pop
    //   300: iconst_0
    //   301: istore_3
    //   302: iload_3
    //   303: iload_2
    //   304: if_icmpge -> 462
    //   307: aload #5
    //   309: invokevirtual poll : ()Ljava/lang/Object;
    //   312: checkcast java/lang/Runnable
    //   315: astore #8
    //   317: aload #8
    //   319: ifnull -> 462
    //   322: aload_0
    //   323: getfield j : Ljava/lang/Object;
    //   326: astore #7
    //   328: aload #7
    //   330: monitorenter
    //   331: aload_0
    //   332: getfield u : I
    //   335: iconst_2
    //   336: if_icmplt -> 358
    //   339: aload #4
    //   341: ifnull -> 358
    //   344: aload #4
    //   346: aload #8
    //   348: invokevirtual a : (Ljava/lang/Runnable;)Z
    //   351: pop
    //   352: aload #7
    //   354: monitorexit
    //   355: goto -> 447
    //   358: aload #7
    //   360: monitorexit
    //   361: ldc_w '[UploadManager] Create and start a new thread to execute a upload task: %s'
    //   364: iconst_1
    //   365: anewarray java/lang/Object
    //   368: dup
    //   369: iconst_0
    //   370: ldc 'BUGLY_ASYNC_UPLOAD'
    //   372: aastore
    //   373: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   376: pop
    //   377: new com/tencent/bugly/proguard/u$1
    //   380: dup
    //   381: aload_0
    //   382: aload #8
    //   384: invokespecial <init> : (Lcom/tencent/bugly/proguard/u;Ljava/lang/Runnable;)V
    //   387: ldc 'BUGLY_ASYNC_UPLOAD'
    //   389: invokestatic a : (Ljava/lang/Runnable;Ljava/lang/String;)Ljava/lang/Thread;
    //   392: ifnull -> 428
    //   395: aload_0
    //   396: getfield j : Ljava/lang/Object;
    //   399: astore #7
    //   401: aload #7
    //   403: monitorenter
    //   404: aload_0
    //   405: aload_0
    //   406: getfield u : I
    //   409: iconst_1
    //   410: iadd
    //   411: putfield u : I
    //   414: aload #7
    //   416: monitorexit
    //   417: goto -> 447
    //   420: astore #4
    //   422: aload #7
    //   424: monitorexit
    //   425: aload #4
    //   427: athrow
    //   428: ldc_w '[UploadManager] Failed to start a thread to execute asynchronous upload task, will try again next time.'
    //   431: iconst_0
    //   432: anewarray java/lang/Object
    //   435: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   438: pop
    //   439: aload_0
    //   440: aload #8
    //   442: iconst_1
    //   443: invokespecial a : (Ljava/lang/Runnable;Z)Z
    //   446: pop
    //   447: iload_3
    //   448: iconst_1
    //   449: iadd
    //   450: istore_3
    //   451: goto -> 302
    //   454: astore #4
    //   456: aload #7
    //   458: monitorexit
    //   459: aload #4
    //   461: athrow
    //   462: iload_1
    //   463: ifle -> 502
    //   466: ldc_w '[UploadManager] Execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)'
    //   469: iconst_3
    //   470: anewarray java/lang/Object
    //   473: dup
    //   474: iconst_0
    //   475: iload_1
    //   476: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   479: aastore
    //   480: dup
    //   481: iconst_1
    //   482: invokestatic myPid : ()I
    //   485: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   488: aastore
    //   489: dup
    //   490: iconst_2
    //   491: invokestatic myTid : ()I
    //   494: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   497: aastore
    //   498: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   501: pop
    //   502: aload #4
    //   504: ifnull -> 524
    //   507: aload #4
    //   509: new com/tencent/bugly/proguard/u$2
    //   512: dup
    //   513: aload_0
    //   514: iload_1
    //   515: aload #6
    //   517: invokespecial <init> : (Lcom/tencent/bugly/proguard/u;ILjava/util/concurrent/LinkedBlockingQueue;)V
    //   520: invokevirtual a : (Ljava/lang/Runnable;)Z
    //   523: pop
    //   524: return
    //   525: astore #4
    //   527: aload #7
    //   529: monitorexit
    //   530: aload #4
    //   532: athrow
    //   533: iload_1
    //   534: ifeq -> 565
    //   537: iload_1
    //   538: iload_2
    //   539: if_icmpge -> 551
    //   542: iconst_0
    //   543: istore_3
    //   544: iload_1
    //   545: istore_2
    //   546: iload_3
    //   547: istore_1
    //   548: goto -> 113
    //   551: iload_1
    //   552: iload_2
    //   553: iload_3
    //   554: iadd
    //   555: if_icmpge -> 565
    //   558: iload_1
    //   559: iload_2
    //   560: isub
    //   561: istore_1
    //   562: goto -> 113
    //   565: iload_3
    //   566: istore_1
    //   567: goto -> 113
    //   570: iconst_0
    //   571: istore_1
    //   572: iconst_0
    //   573: istore_3
    //   574: goto -> 129
    //   577: iload_3
    //   578: iconst_1
    //   579: iadd
    //   580: istore_3
    //   581: goto -> 129
    //   584: iconst_0
    //   585: istore_3
    //   586: goto -> 193
    //   589: iload_3
    //   590: iconst_1
    //   591: iadd
    //   592: istore_3
    //   593: goto -> 193
    // Exception table:
    //   from	to	target	type
    //   47	91	525	finally
    //   99	112	525	finally
    //   118	126	525	finally
    //   134	146	525	finally
    //   151	166	169	finally
    //   171	190	525	finally
    //   198	210	525	finally
    //   215	230	233	finally
    //   235	254	525	finally
    //   257	260	525	finally
    //   331	339	454	finally
    //   344	355	454	finally
    //   404	417	420	finally
  }
  
  private static boolean c() {
    x.c("[UploadManager] Drop security info of database (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    try {
      return p1.a(555, "security_info", (o)null, true);
    } finally {
      Exception exception = null;
      x.a(exception);
    } 
  }
  
  private boolean d() {
    x.c("[UploadManager] Record security info to database (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    try {
      p p1 = p.a();
      if (p1 == null)
        return false; 
      return false;
    } finally {
      Exception exception = null;
      x.a(exception);
      c();
    } 
  }
  
  private boolean e() {
    // Byte code:
    //   0: ldc_w '[UploadManager] Load security info from database (pid=%d | tid=%d)'
    //   3: iconst_2
    //   4: anewarray java/lang/Object
    //   7: dup
    //   8: iconst_0
    //   9: invokestatic myPid : ()I
    //   12: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   15: aastore
    //   16: dup
    //   17: iconst_1
    //   18: invokestatic myTid : ()I
    //   21: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   24: aastore
    //   25: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   28: pop
    //   29: invokestatic a : ()Lcom/tencent/bugly/proguard/p;
    //   32: astore #4
    //   34: aload #4
    //   36: ifnonnull -> 52
    //   39: ldc_w '[UploadManager] Failed to get database'
    //   42: iconst_0
    //   43: anewarray java/lang/Object
    //   46: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   49: pop
    //   50: iconst_0
    //   51: ireturn
    //   52: aload #4
    //   54: sipush #555
    //   57: aconst_null
    //   58: iconst_1
    //   59: invokevirtual a : (ILcom/tencent/bugly/proguard/o;Z)Ljava/util/Map;
    //   62: astore #4
    //   64: aload #4
    //   66: ifnull -> 370
    //   69: aload #4
    //   71: ldc_w 'security_info'
    //   74: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   79: ifeq -> 370
    //   82: new java/lang/String
    //   85: dup
    //   86: aload #4
    //   88: ldc_w 'security_info'
    //   91: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   96: checkcast [B
    //   99: invokespecial <init> : ([B)V
    //   102: astore #5
    //   104: aload #5
    //   106: ldc_w '#'
    //   109: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   112: astore #4
    //   114: aload #4
    //   116: arraylength
    //   117: iconst_4
    //   118: if_icmpne -> 334
    //   121: aload #4
    //   123: iconst_0
    //   124: aaload
    //   125: invokevirtual isEmpty : ()Z
    //   128: istore_3
    //   129: iload_3
    //   130: ifne -> 382
    //   133: aload #4
    //   135: iconst_0
    //   136: aaload
    //   137: ldc_w 'null'
    //   140: invokevirtual equals : (Ljava/lang/Object;)Z
    //   143: istore_3
    //   144: iload_3
    //   145: ifne -> 382
    //   148: aload_0
    //   149: aload #4
    //   151: iconst_0
    //   152: aaload
    //   153: iconst_0
    //   154: invokestatic decode : (Ljava/lang/String;I)[B
    //   157: putfield n : [B
    //   160: goto -> 382
    //   163: astore #5
    //   165: aload #5
    //   167: invokestatic a : (Ljava/lang/Throwable;)Z
    //   170: pop
    //   171: iconst_1
    //   172: istore_2
    //   173: goto -> 176
    //   176: iload_2
    //   177: istore_1
    //   178: iload_2
    //   179: ifne -> 237
    //   182: iload_2
    //   183: istore_1
    //   184: aload #4
    //   186: iconst_1
    //   187: aaload
    //   188: invokevirtual isEmpty : ()Z
    //   191: ifne -> 237
    //   194: aload #4
    //   196: iconst_1
    //   197: aaload
    //   198: ldc_w 'null'
    //   201: invokevirtual equals : (Ljava/lang/Object;)Z
    //   204: istore_3
    //   205: iload_2
    //   206: istore_1
    //   207: iload_3
    //   208: ifne -> 237
    //   211: aload_0
    //   212: aload #4
    //   214: iconst_1
    //   215: aaload
    //   216: invokestatic parseLong : (Ljava/lang/String;)J
    //   219: putfield o : J
    //   222: iload_2
    //   223: istore_1
    //   224: goto -> 237
    //   227: astore #5
    //   229: aload #5
    //   231: invokestatic a : (Ljava/lang/Throwable;)Z
    //   234: pop
    //   235: iconst_1
    //   236: istore_1
    //   237: iload_1
    //   238: ifne -> 272
    //   241: aload #4
    //   243: iconst_2
    //   244: aaload
    //   245: invokevirtual isEmpty : ()Z
    //   248: ifne -> 272
    //   251: aload #4
    //   253: iconst_2
    //   254: aaload
    //   255: ldc_w 'null'
    //   258: invokevirtual equals : (Ljava/lang/Object;)Z
    //   261: ifne -> 272
    //   264: aload_0
    //   265: aload #4
    //   267: iconst_2
    //   268: aaload
    //   269: putfield p : Ljava/lang/String;
    //   272: iload_1
    //   273: istore_2
    //   274: iload_1
    //   275: ifne -> 362
    //   278: iload_1
    //   279: istore_2
    //   280: aload #4
    //   282: iconst_3
    //   283: aaload
    //   284: invokevirtual isEmpty : ()Z
    //   287: ifne -> 362
    //   290: aload #4
    //   292: iconst_3
    //   293: aaload
    //   294: ldc_w 'null'
    //   297: invokevirtual equals : (Ljava/lang/Object;)Z
    //   300: istore_3
    //   301: iload_1
    //   302: istore_2
    //   303: iload_3
    //   304: ifne -> 362
    //   307: aload_0
    //   308: aload #4
    //   310: iconst_3
    //   311: aaload
    //   312: invokestatic parseLong : (Ljava/lang/String;)J
    //   315: putfield q : J
    //   318: iload_1
    //   319: istore_2
    //   320: goto -> 362
    //   323: astore #4
    //   325: aload #4
    //   327: invokestatic a : (Ljava/lang/Throwable;)Z
    //   330: pop
    //   331: goto -> 387
    //   334: ldc_w 'SecurityInfo = %s, Strings.length = %d'
    //   337: iconst_2
    //   338: anewarray java/lang/Object
    //   341: dup
    //   342: iconst_0
    //   343: aload #5
    //   345: aastore
    //   346: dup
    //   347: iconst_1
    //   348: aload #4
    //   350: arraylength
    //   351: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   354: aastore
    //   355: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   358: pop
    //   359: goto -> 387
    //   362: iload_2
    //   363: ifeq -> 370
    //   366: invokestatic c : ()Z
    //   369: pop
    //   370: iconst_1
    //   371: ireturn
    //   372: astore #4
    //   374: aload #4
    //   376: invokestatic a : (Ljava/lang/Throwable;)Z
    //   379: pop
    //   380: iconst_0
    //   381: ireturn
    //   382: iconst_0
    //   383: istore_2
    //   384: goto -> 176
    //   387: iconst_1
    //   388: istore_2
    //   389: goto -> 362
    // Exception table:
    //   from	to	target	type
    //   29	34	372	finally
    //   39	50	372	finally
    //   52	64	372	finally
    //   69	129	372	finally
    //   133	144	372	finally
    //   148	160	163	finally
    //   165	171	372	finally
    //   184	205	372	finally
    //   211	222	227	finally
    //   229	235	372	finally
    //   241	272	372	finally
    //   280	301	372	finally
    //   307	318	323	finally
    //   325	331	372	finally
    //   334	359	372	finally
    //   366	370	372	finally
  }
  
  public final long a(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: lconst_0
    //   3: lstore #4
    //   5: iload_1
    //   6: iflt -> 180
    //   9: aload_0
    //   10: getfield e : Ljava/util/Map;
    //   13: iload_1
    //   14: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   17: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   22: checkcast java/lang/Long
    //   25: astore #6
    //   27: aload #6
    //   29: ifnull -> 42
    //   32: aload #6
    //   34: invokevirtual longValue : ()J
    //   37: lstore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: lload_2
    //   41: lreturn
    //   42: aload_0
    //   43: getfield c : Lcom/tencent/bugly/proguard/p;
    //   46: iload_1
    //   47: invokevirtual a : (I)Ljava/util/List;
    //   50: astore #6
    //   52: lload #4
    //   54: lstore_2
    //   55: aload #6
    //   57: ifnull -> 201
    //   60: lload #4
    //   62: lstore_2
    //   63: aload #6
    //   65: invokeinterface size : ()I
    //   70: ifle -> 201
    //   73: aload #6
    //   75: invokeinterface size : ()I
    //   80: iconst_1
    //   81: if_icmple -> 148
    //   84: aload #6
    //   86: invokeinterface iterator : ()Ljava/util/Iterator;
    //   91: astore #6
    //   93: lload #4
    //   95: lstore_2
    //   96: aload #6
    //   98: invokeinterface hasNext : ()Z
    //   103: ifeq -> 137
    //   106: aload #6
    //   108: invokeinterface next : ()Ljava/lang/Object;
    //   113: checkcast com/tencent/bugly/proguard/r
    //   116: astore #7
    //   118: aload #7
    //   120: getfield e : J
    //   123: lload_2
    //   124: lcmp
    //   125: ifle -> 96
    //   128: aload #7
    //   130: getfield e : J
    //   133: lstore_2
    //   134: goto -> 96
    //   137: aload_0
    //   138: getfield c : Lcom/tencent/bugly/proguard/p;
    //   141: iload_1
    //   142: invokevirtual b : (I)V
    //   145: goto -> 201
    //   148: aload #6
    //   150: iconst_0
    //   151: invokeinterface get : (I)Ljava/lang/Object;
    //   156: checkcast com/tencent/bugly/proguard/r
    //   159: getfield e : J
    //   162: lstore_2
    //   163: goto -> 201
    //   166: astore #6
    //   168: aload #6
    //   170: invokestatic a : (Ljava/lang/Throwable;)Z
    //   173: pop
    //   174: lload #4
    //   176: lstore_2
    //   177: goto -> 201
    //   180: ldc_w '[UploadManager] Unknown upload ID: %d'
    //   183: iconst_1
    //   184: anewarray java/lang/Object
    //   187: dup
    //   188: iconst_0
    //   189: iload_1
    //   190: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   193: aastore
    //   194: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   197: pop
    //   198: lload #4
    //   200: lstore_2
    //   201: aload_0
    //   202: monitorexit
    //   203: lload_2
    //   204: lreturn
    //   205: astore #6
    //   207: aload_0
    //   208: monitorexit
    //   209: aload #6
    //   211: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	205	finally
    //   32	38	205	finally
    //   42	52	205	finally
    //   63	93	205	finally
    //   96	134	205	finally
    //   137	145	205	finally
    //   148	163	166	finally
    //   168	174	205	finally
    //   180	198	205	finally
  }
  
  public final long a(boolean paramBoolean) {
    byte b;
    long l1;
    long l2 = z.b();
    if (paramBoolean) {
      b = 5;
    } else {
      b = 3;
    } 
    List<r> list = this.c.a(b);
    if (list != null && list.size() > 0) {
      long l3;
      long l4 = 0L;
      l1 = l4;
      try {
        r r = list.get(0);
        l1 = l4;
      } finally {
        Exception exception = null;
        x.a(exception);
      } 
      l1 = l3;
      if (list.size() > 0) {
        this.c.a(list);
        l1 = l3;
      } 
    } else {
      long l;
      if (paramBoolean) {
        l = this.g;
      } else {
        l = this.f;
      } 
      l1 = l;
    } 
    x.c("[UploadManager] Local network consume: %d KB", new Object[] { Long.valueOf(l1 / 1024L) });
    return l1;
  }
  
  public final void a(int paramInt1, int paramInt2, byte[] paramArrayOfbyte, String paramString1, String paramString2, t paramt, int paramInt3, int paramInt4, boolean paramBoolean, Map<String, String> paramMap) {
    try {
      return;
    } finally {
      paramArrayOfbyte = null;
      if (!x.a((Throwable)paramArrayOfbyte))
        paramArrayOfbyte.printStackTrace(); 
    } 
  }
  
  public final void a(int paramInt, long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: iflt -> 115
    //   6: aload_0
    //   7: getfield e : Ljava/util/Map;
    //   10: iload_1
    //   11: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   14: lload_2
    //   15: invokestatic valueOf : (J)Ljava/lang/Long;
    //   18: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   23: pop
    //   24: new com/tencent/bugly/proguard/r
    //   27: dup
    //   28: invokespecial <init> : ()V
    //   31: astore #4
    //   33: aload #4
    //   35: iload_1
    //   36: putfield b : I
    //   39: aload #4
    //   41: lload_2
    //   42: putfield e : J
    //   45: aload #4
    //   47: ldc_w ''
    //   50: putfield c : Ljava/lang/String;
    //   53: aload #4
    //   55: ldc_w ''
    //   58: putfield d : Ljava/lang/String;
    //   61: aload #4
    //   63: iconst_0
    //   64: newarray byte
    //   66: putfield g : [B
    //   69: aload_0
    //   70: getfield c : Lcom/tencent/bugly/proguard/p;
    //   73: iload_1
    //   74: invokevirtual b : (I)V
    //   77: aload_0
    //   78: getfield c : Lcom/tencent/bugly/proguard/p;
    //   81: aload #4
    //   83: invokevirtual a : (Lcom/tencent/bugly/proguard/r;)Z
    //   86: pop
    //   87: ldc_w '[UploadManager] Uploading(ID:%d) time: %s'
    //   90: iconst_2
    //   91: anewarray java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: iload_1
    //   97: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   100: aastore
    //   101: dup
    //   102: iconst_1
    //   103: lload_2
    //   104: invokestatic a : (J)Ljava/lang/String;
    //   107: aastore
    //   108: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   111: pop
    //   112: aload_0
    //   113: monitorexit
    //   114: return
    //   115: ldc_w '[UploadManager] Unknown uploading ID: %d'
    //   118: iconst_1
    //   119: anewarray java/lang/Object
    //   122: dup
    //   123: iconst_0
    //   124: iload_1
    //   125: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   128: aastore
    //   129: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   132: pop
    //   133: aload_0
    //   134: monitorexit
    //   135: return
    //   136: astore #4
    //   138: aload_0
    //   139: monitorexit
    //   140: aload #4
    //   142: athrow
    // Exception table:
    //   from	to	target	type
    //   6	112	136	finally
    //   115	133	136	finally
  }
  
  public final void a(int paramInt, ap paramap, String paramString1, String paramString2, t paramt, long paramLong, boolean paramBoolean) {
    int i = paramap.g;
    byte[] arrayOfByte = a.a(paramap);
    try {
      return;
    } finally {
      arrayOfByte = null;
      if (!x.a((Throwable)arrayOfByte))
        arrayOfByte.printStackTrace(); 
    } 
  }
  
  public final void a(int paramInt, ap paramap, String paramString1, String paramString2, t paramt, boolean paramBoolean) {
    a(paramInt, paramap.g, a.a(paramap), paramString1, paramString2, paramt, 0, 0, paramBoolean, null);
  }
  
  public final void a(int paramInt, aq paramaq) {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Z
    //   4: ifne -> 8
    //   7: return
    //   8: iconst_1
    //   9: istore #5
    //   11: iconst_1
    //   12: istore #6
    //   14: iconst_1
    //   15: istore #4
    //   17: iload_1
    //   18: iconst_2
    //   19: if_icmpne -> 59
    //   22: ldc_w '[UploadManager] Session ID is invalid, will clear security context (pid=%d | tid=%d)'
    //   25: iconst_2
    //   26: anewarray java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: invokestatic myPid : ()I
    //   34: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   37: aastore
    //   38: dup
    //   39: iconst_1
    //   40: invokestatic myTid : ()I
    //   43: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   46: aastore
    //   47: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   50: pop
    //   51: aload_0
    //   52: iconst_1
    //   53: invokevirtual b : (Z)V
    //   56: goto -> 510
    //   59: aload_0
    //   60: getfield t : Ljava/lang/Object;
    //   63: astore #7
    //   65: aload #7
    //   67: monitorenter
    //   68: aload_0
    //   69: getfield s : Z
    //   72: ifne -> 79
    //   75: aload #7
    //   77: monitorexit
    //   78: return
    //   79: aload #7
    //   81: monitorexit
    //   82: aload_2
    //   83: ifnull -> 476
    //   86: ldc_w '[UploadManager] Record security context (pid=%d | tid=%d)'
    //   89: iconst_2
    //   90: anewarray java/lang/Object
    //   93: dup
    //   94: iconst_0
    //   95: invokestatic myPid : ()I
    //   98: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   101: aastore
    //   102: dup
    //   103: iconst_1
    //   104: invokestatic myTid : ()I
    //   107: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   110: aastore
    //   111: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   114: pop
    //   115: iload #5
    //   117: istore_3
    //   118: aload_2
    //   119: getfield g : Ljava/util/Map;
    //   122: astore #7
    //   124: iload #6
    //   126: istore_1
    //   127: aload #7
    //   129: ifnull -> 464
    //   132: iload #5
    //   134: istore_3
    //   135: iload #6
    //   137: istore_1
    //   138: aload #7
    //   140: ldc_w 'S1'
    //   143: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   148: ifeq -> 464
    //   151: iload #5
    //   153: istore_3
    //   154: iload #6
    //   156: istore_1
    //   157: aload #7
    //   159: ldc_w 'S2'
    //   162: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   167: ifeq -> 464
    //   170: iload #5
    //   172: istore_3
    //   173: aload_0
    //   174: aload_2
    //   175: getfield e : J
    //   178: invokestatic currentTimeMillis : ()J
    //   181: lsub
    //   182: putfield m : J
    //   185: iload #5
    //   187: istore_3
    //   188: ldc_w '[UploadManager] Time lag of server is: %d'
    //   191: iconst_1
    //   192: anewarray java/lang/Object
    //   195: dup
    //   196: iconst_0
    //   197: aload_0
    //   198: getfield m : J
    //   201: invokestatic valueOf : (J)Ljava/lang/Long;
    //   204: aastore
    //   205: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   208: pop
    //   209: iload #5
    //   211: istore_3
    //   212: aload_0
    //   213: aload #7
    //   215: ldc_w 'S1'
    //   218: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   223: checkcast java/lang/String
    //   226: putfield p : Ljava/lang/String;
    //   229: iload #5
    //   231: istore_3
    //   232: ldc_w '[UploadManager] Session ID from server is: %s'
    //   235: iconst_1
    //   236: anewarray java/lang/Object
    //   239: dup
    //   240: iconst_0
    //   241: aload_0
    //   242: getfield p : Ljava/lang/String;
    //   245: aastore
    //   246: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   249: pop
    //   250: iload #5
    //   252: istore_3
    //   253: aload_0
    //   254: getfield p : Ljava/lang/String;
    //   257: invokevirtual length : ()I
    //   260: istore_1
    //   261: iload_1
    //   262: ifle -> 436
    //   265: iload #5
    //   267: istore_3
    //   268: aload_0
    //   269: aload #7
    //   271: ldc_w 'S2'
    //   274: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   279: checkcast java/lang/String
    //   282: invokestatic parseLong : (Ljava/lang/String;)J
    //   285: putfield q : J
    //   288: iload #5
    //   290: istore_3
    //   291: ldc_w '[UploadManager] Session expired time from server is: %d(%s)'
    //   294: iconst_2
    //   295: anewarray java/lang/Object
    //   298: dup
    //   299: iconst_0
    //   300: aload_0
    //   301: getfield q : J
    //   304: invokestatic valueOf : (J)Ljava/lang/Long;
    //   307: aastore
    //   308: dup
    //   309: iconst_1
    //   310: new java/util/Date
    //   313: dup
    //   314: aload_0
    //   315: getfield q : J
    //   318: invokespecial <init> : (J)V
    //   321: invokevirtual toString : ()Ljava/lang/String;
    //   324: aastore
    //   325: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   328: pop
    //   329: iload #5
    //   331: istore_3
    //   332: aload_0
    //   333: getfield q : J
    //   336: ldc2_w 1000
    //   339: lcmp
    //   340: ifge -> 394
    //   343: iload #5
    //   345: istore_3
    //   346: ldc_w '[UploadManager] Session expired time from server is less than 1 second, will set to default value'
    //   349: iconst_0
    //   350: anewarray java/lang/Object
    //   353: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   356: pop
    //   357: iload #5
    //   359: istore_3
    //   360: aload_0
    //   361: ldc2_w 259200000
    //   364: putfield q : J
    //   367: goto -> 394
    //   370: iload #5
    //   372: istore_3
    //   373: ldc_w '[UploadManager] Session expired time is invalid, will set to default value'
    //   376: iconst_0
    //   377: anewarray java/lang/Object
    //   380: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   383: pop
    //   384: iload #5
    //   386: istore_3
    //   387: aload_0
    //   388: ldc2_w 259200000
    //   391: putfield q : J
    //   394: iload #5
    //   396: istore_3
    //   397: aload_0
    //   398: invokespecial d : ()Z
    //   401: ifeq -> 409
    //   404: iconst_0
    //   405: istore_1
    //   406: goto -> 426
    //   409: iload #5
    //   411: istore_3
    //   412: ldc_w '[UploadManager] Failed to record database'
    //   415: iconst_0
    //   416: anewarray java/lang/Object
    //   419: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   422: pop
    //   423: iload #4
    //   425: istore_1
    //   426: iload_1
    //   427: istore_3
    //   428: aload_0
    //   429: iconst_0
    //   430: invokespecial c : (I)V
    //   433: goto -> 464
    //   436: iload #5
    //   438: istore_3
    //   439: ldc_w '[UploadManager] Session ID from server is invalid, try next time'
    //   442: iconst_0
    //   443: anewarray java/lang/Object
    //   446: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   449: pop
    //   450: iload #6
    //   452: istore_1
    //   453: goto -> 464
    //   456: astore_2
    //   457: aload_2
    //   458: invokestatic a : (Ljava/lang/Throwable;)Z
    //   461: pop
    //   462: iload_3
    //   463: istore_1
    //   464: iload_1
    //   465: ifeq -> 510
    //   468: aload_0
    //   469: iconst_0
    //   470: invokevirtual b : (Z)V
    //   473: goto -> 510
    //   476: ldc_w '[UploadManager] Fail to init security context and clear local info (pid=%d | tid=%d)'
    //   479: iconst_2
    //   480: anewarray java/lang/Object
    //   483: dup
    //   484: iconst_0
    //   485: invokestatic myPid : ()I
    //   488: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   491: aastore
    //   492: dup
    //   493: iconst_1
    //   494: invokestatic myTid : ()I
    //   497: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   500: aastore
    //   501: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   504: pop
    //   505: aload_0
    //   506: iconst_0
    //   507: invokevirtual b : (Z)V
    //   510: aload_0
    //   511: getfield t : Ljava/lang/Object;
    //   514: astore_2
    //   515: aload_2
    //   516: monitorenter
    //   517: aload_0
    //   518: getfield s : Z
    //   521: ifeq -> 540
    //   524: aload_0
    //   525: iconst_0
    //   526: putfield s : Z
    //   529: aload_0
    //   530: getfield d : Landroid/content/Context;
    //   533: ldc_w 'security_info'
    //   536: invokestatic b : (Landroid/content/Context;Ljava/lang/String;)Z
    //   539: pop
    //   540: aload_2
    //   541: monitorexit
    //   542: return
    //   543: astore #7
    //   545: aload_2
    //   546: monitorexit
    //   547: aload #7
    //   549: athrow
    //   550: astore_2
    //   551: aload #7
    //   553: monitorexit
    //   554: aload_2
    //   555: athrow
    //   556: astore_2
    //   557: goto -> 370
    // Exception table:
    //   from	to	target	type
    //   68	78	550	finally
    //   118	124	456	finally
    //   138	151	456	finally
    //   157	170	456	finally
    //   173	185	456	finally
    //   188	209	456	finally
    //   212	229	456	finally
    //   232	250	456	finally
    //   253	261	456	finally
    //   268	288	556	java/lang/NumberFormatException
    //   268	288	456	finally
    //   291	329	556	java/lang/NumberFormatException
    //   291	329	456	finally
    //   332	343	556	java/lang/NumberFormatException
    //   332	343	456	finally
    //   346	357	556	java/lang/NumberFormatException
    //   346	357	456	finally
    //   360	367	556	java/lang/NumberFormatException
    //   360	367	456	finally
    //   373	384	456	finally
    //   387	394	456	finally
    //   397	404	456	finally
    //   412	423	456	finally
    //   428	433	456	finally
    //   439	450	456	finally
    //   517	540	543	finally
    //   540	542	543	finally
  }
  
  protected final void a(long paramLong, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_3
    //   3: ifeq -> 12
    //   6: iconst_5
    //   7: istore #4
    //   9: goto -> 15
    //   12: iconst_3
    //   13: istore #4
    //   15: new com/tencent/bugly/proguard/r
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: astore #5
    //   24: aload #5
    //   26: iload #4
    //   28: putfield b : I
    //   31: aload #5
    //   33: invokestatic b : ()J
    //   36: putfield e : J
    //   39: aload #5
    //   41: ldc_w ''
    //   44: putfield c : Ljava/lang/String;
    //   47: aload #5
    //   49: ldc_w ''
    //   52: putfield d : Ljava/lang/String;
    //   55: aload #5
    //   57: lload_1
    //   58: invokestatic c : (J)[B
    //   61: putfield g : [B
    //   64: aload_0
    //   65: getfield c : Lcom/tencent/bugly/proguard/p;
    //   68: iload #4
    //   70: invokevirtual b : (I)V
    //   73: aload_0
    //   74: getfield c : Lcom/tencent/bugly/proguard/p;
    //   77: aload #5
    //   79: invokevirtual a : (Lcom/tencent/bugly/proguard/r;)Z
    //   82: pop
    //   83: iload_3
    //   84: ifeq -> 95
    //   87: aload_0
    //   88: lload_1
    //   89: putfield g : J
    //   92: goto -> 100
    //   95: aload_0
    //   96: lload_1
    //   97: putfield f : J
    //   100: ldc_w '[UploadManager] Network total consume: %d KB'
    //   103: iconst_1
    //   104: anewarray java/lang/Object
    //   107: dup
    //   108: iconst_0
    //   109: lload_1
    //   110: ldc2_w 1024
    //   113: ldiv
    //   114: invokestatic valueOf : (J)Ljava/lang/Long;
    //   117: aastore
    //   118: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   121: pop
    //   122: aload_0
    //   123: monitorexit
    //   124: return
    //   125: astore #5
    //   127: aload_0
    //   128: monitorexit
    //   129: aload #5
    //   131: athrow
    // Exception table:
    //   from	to	target	type
    //   15	83	125	finally
    //   87	92	125	finally
    //   95	100	125	finally
    //   100	122	125	finally
  }
  
  public final boolean a(Map<String, String> paramMap) {
    if (paramMap == null)
      return false; 
    x.c("[UploadManager] Integrate security to HTTP headers (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    String str2 = this.p;
    if (str2 != null) {
      paramMap.put("secureSessionId", str2);
      return true;
    } 
    byte[] arrayOfByte = this.n;
    if (arrayOfByte == null || arrayOfByte.length << 3 != 128) {
      x.d("[UploadManager] AES key is invalid", new Object[0]);
      return false;
    } 
    if (this.l == null) {
      this.l = Base64.decode(this.k, 0);
      if (this.l == null) {
        x.d("[UploadManager] Failed to decode RSA public key", new Object[0]);
        return false;
      } 
    } 
    arrayOfByte = z.b(1, this.n, this.l);
    if (arrayOfByte == null) {
      x.d("[UploadManager] Failed to encrypt AES key", new Object[0]);
      return false;
    } 
    String str1 = Base64.encodeToString(arrayOfByte, 0);
    if (TextUtils.isEmpty(str1)) {
      x.e("[UploadManager] Failed to encode AES key", new Object[0]);
      return false;
    } 
    paramMap.put("raKey", str1);
    return true;
  }
  
  public final byte[] a(byte[] paramArrayOfbyte) {
    byte[] arrayOfByte = this.n;
    if (arrayOfByte == null || arrayOfByte.length << 3 != 128) {
      x.d("[UploadManager] AES key is invalid (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      return null;
    } 
    return z.a(1, paramArrayOfbyte, arrayOfByte);
  }
  
  public final void b(boolean paramBoolean) {
    synchronized (this.r) {
      x.c("[UploadManager] Clear security context (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      this.n = null;
      this.p = null;
      this.q = 0L;
      if (paramBoolean)
        c(); 
      return;
    } 
  }
  
  protected final boolean b() {
    if (this.p != null) {
      if (this.q == 0L)
        return false; 
      long l1 = System.currentTimeMillis() + this.m;
      long l2 = this.q;
      if (l2 < l1) {
        x.c("[UploadManager] Session ID expired time from server is: %d(%s), but now is: %d(%s)", new Object[] { Long.valueOf(l2), (new Date(this.q)).toString(), Long.valueOf(l1), (new Date(l1)).toString() });
        return false;
      } 
      return true;
    } 
    return false;
  }
  
  public final boolean b(int paramInt) {
    if (b.c) {
      x.c("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
      return true;
    } 
    long l = System.currentTimeMillis() - a(paramInt);
    x.c("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", new Object[] { Long.valueOf(l / 1000L), Integer.valueOf(paramInt) });
    if (l < 30000L) {
      x.a("[UploadManager] Data only be uploaded once in %d seconds.", new Object[] { Long.valueOf(30L) });
      return false;
    } 
    return true;
  }
  
  public final byte[] b(byte[] paramArrayOfbyte) {
    byte[] arrayOfByte = this.n;
    if (arrayOfByte == null || arrayOfByte.length << 3 != 128) {
      x.d("[UploadManager] AES key is invalid (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      return null;
    } 
    return z.a(2, paramArrayOfbyte, arrayOfByte);
  }
  
  final class a implements Runnable {
    private final Context a;
    
    private final Runnable b;
    
    private final long c;
    
    public a(u this$0, Context param1Context) {
      this.a = param1Context;
      this.b = null;
      this.c = 0L;
    }
    
    public a(u this$0, Context param1Context, Runnable param1Runnable, long param1Long) {
      this.a = param1Context;
      this.b = param1Runnable;
      this.c = param1Long;
    }
    
    public final void run() {
      if (!z.a(this.a, "security_info", 30000L)) {
        x.c("[UploadManager] Sleep %d try to lock security file again (pid=%d | tid=%d)", new Object[] { Integer.valueOf(5000), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
        z.b(5000L);
        if (z.a(this, "BUGLY_ASYNC_UPLOAD") == null) {
          x.d("[UploadManager] Failed to start a thread to execute task of initializing security context, try to post it into thread pool.", new Object[0]);
          w w = w.a();
          if (w != null) {
            w.a(this);
            return;
          } 
          x.e("[UploadManager] Asynchronous thread pool is unavailable now, try next time.", new Object[0]);
        } 
        return;
      } 
      if (!u.c(this.d)) {
        x.d("[UploadManager] Failed to load security info from database", new Object[0]);
        this.d.b(false);
      } 
      if (u.d(this.d) != null) {
        if (this.d.b()) {
          x.c("[UploadManager] Sucessfully got session ID, try to execute upload tasks now (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
          Runnable runnable = this.b;
          if (runnable != null)
            u.a(this.d, runnable, this.c); 
          u.a(this.d, 0);
          z.b(this.a, "security_info");
          synchronized (u.e(this.d)) {
            u.a(this.d, false);
            return;
          } 
        } 
        x.a("[UploadManager] Session ID is expired, drop it.", new Object[0]);
        this.d.b(true);
      } 
      byte[] arrayOfByte = z.a(128);
      if (arrayOfByte != null && arrayOfByte.length << 3 == 128) {
        u.a(this.d, arrayOfByte);
        x.c("[UploadManager] Execute one upload task for requesting session ID (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
        Runnable runnable = this.b;
        if (runnable != null) {
          u.a(this.d, runnable, this.c);
          return;
        } 
        u.a(this.d, 1);
        return;
      } 
      x.d("[UploadManager] Failed to create AES key (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      this.d.b(false);
      z.b(this.a, "security_info");
      synchronized (u.e(this.d)) {
        u.a(this.d, false);
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\proguar\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */