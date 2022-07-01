package com.datavisor.vangogh.face;

import android.content.Context;
import android.os.Environment;
import com.datavisor.vangogh.f.d;
import com.datavisor.vangogh.storage.local.DVJS2Native;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class DVTokenClient {
  private static DVTokenClient a;
  
  private static final String b = com.datavisor.vangogh.c.a.a;
  
  private AtomicBoolean c = new AtomicBoolean(false);
  
  private Context d = null;
  
  private ExecutorService e = null;
  
  private DVJS2Native f = null;
  
  private DVTokenClient(Context paramContext) {
    if (paramContext instanceof android.app.Application) {
      this.d = paramContext;
      this.e = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
      return;
    } 
    throw new IllegalArgumentException("DVTokenClient initialization error: mContext is null or not ApplicationContext.");
  }
  
  public static DVTokenClient a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/datavisor/vangogh/face/DVTokenClient.a : Lcom/datavisor/vangogh/face/DVTokenClient;
    //   3: ifnonnull -> 38
    //   6: ldc com/datavisor/vangogh/face/DVTokenClient
    //   8: monitorenter
    //   9: getstatic com/datavisor/vangogh/face/DVTokenClient.a : Lcom/datavisor/vangogh/face/DVTokenClient;
    //   12: ifnonnull -> 26
    //   15: new com/datavisor/vangogh/face/DVTokenClient
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/datavisor/vangogh/face/DVTokenClient.a : Lcom/datavisor/vangogh/face/DVTokenClient;
    //   26: ldc com/datavisor/vangogh/face/DVTokenClient
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/datavisor/vangogh/face/DVTokenClient
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/datavisor/vangogh/face/DVTokenClient.a : Lcom/datavisor/vangogh/face/DVTokenClient;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  private RandomAccessFile b() {
    try {
      return new RandomAccessFile(new File(Environment.getExternalStorageDirectory().getAbsolutePath(), ".__ppsk.sys"), "rw");
    } finally {
      Exception exception = null;
      d.a(exception);
    } 
  }
  
  public void a(String paramString) {
    if (!com.datavisor.vangogh.b.a.a().a(this.d))
      return; 
    com.datavisor.vangogh.f.i.a.a(paramString);
  }
  
  public boolean a(String paramString1, String paramString2, Map<String, String> paramMap, InitResultListener paramInitResultListener) {
    d.a(com.datavisor.vangogh.c.a.a, "Start init DV token");
    if (!com.datavisor.vangogh.b.a.a().a(this.d))
      return false; 
    if (this.c.compareAndSet(false, true)) {
      this.e.execute(new a(this, paramString1, paramString2, paramMap, paramInitResultListener));
      return true;
    } 
    d.a(b, "inInit is true");
    return false;
  }
  
  public static interface EventResultListener {
    void a(int param1Int);
  }
  
  public static interface InitResultListener {
    void a(String param1String, int param1Int);
  }
  
  class a implements Runnable {
    a(DVTokenClient this$0, String param1String1, String param1String2, Map param1Map, DVTokenClient.InitResultListener param1InitResultListener) {}
    
    public void run() {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: aconst_null
      //   3: astore #4
      //   5: aconst_null
      //   6: astore_3
      //   7: aload_0
      //   8: getfield e : Lcom/datavisor/vangogh/face/DVTokenClient;
      //   11: invokestatic a : (Lcom/datavisor/vangogh/face/DVTokenClient;)Ljava/io/RandomAccessFile;
      //   14: astore #7
      //   16: aload #7
      //   18: ifnull -> 487
      //   21: aload #7
      //   23: invokevirtual getChannel : ()Ljava/nio/channels/FileChannel;
      //   26: astore #6
      //   28: aload #6
      //   30: astore #5
      //   32: aload #6
      //   34: ifnull -> 56
      //   37: aload_2
      //   38: astore #4
      //   40: aload #6
      //   42: astore_2
      //   43: aload #6
      //   45: invokevirtual lock : ()Ljava/nio/channels/FileLock;
      //   48: astore_3
      //   49: aload #6
      //   51: astore #5
      //   53: goto -> 56
      //   56: aload_3
      //   57: astore #4
      //   59: aload #5
      //   61: astore_2
      //   62: aload_0
      //   63: getfield e : Lcom/datavisor/vangogh/face/DVTokenClient;
      //   66: invokestatic b : (Lcom/datavisor/vangogh/face/DVTokenClient;)Landroid/content/Context;
      //   69: invokestatic a : (Landroid/content/Context;)Lcom/datavisor/vangogh/d/c;
      //   72: aload_0
      //   73: getfield a : Ljava/lang/String;
      //   76: aload_0
      //   77: getfield b : Ljava/lang/String;
      //   80: aload_0
      //   81: getfield c : Ljava/util/Map;
      //   84: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)I
      //   87: istore_1
      //   88: iload_1
      //   89: ifne -> 164
      //   92: aload_3
      //   93: astore #4
      //   95: aload #5
      //   97: astore_2
      //   98: invokestatic a : ()Ljava/lang/String;
      //   101: astore #6
      //   103: aload_3
      //   104: astore #4
      //   106: aload #5
      //   108: astore_2
      //   109: new java/lang/StringBuilder
      //   112: dup
      //   113: invokespecial <init> : ()V
      //   116: astore #8
      //   118: aload_3
      //   119: astore #4
      //   121: aload #5
      //   123: astore_2
      //   124: aload #8
      //   126: ldc 'resultCode:'
      //   128: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   131: pop
      //   132: aload_3
      //   133: astore #4
      //   135: aload #5
      //   137: astore_2
      //   138: aload #8
      //   140: iload_1
      //   141: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   144: pop
      //   145: aload_3
      //   146: astore #4
      //   148: aload #5
      //   150: astore_2
      //   151: aload #6
      //   153: aload #8
      //   155: invokevirtual toString : ()Ljava/lang/String;
      //   158: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
      //   161: goto -> 247
      //   164: aload_3
      //   165: astore #4
      //   167: aload #5
      //   169: astore_2
      //   170: invokestatic a : ()Ljava/lang/String;
      //   173: astore #6
      //   175: aload_3
      //   176: astore #4
      //   178: aload #5
      //   180: astore_2
      //   181: new java/lang/StringBuilder
      //   184: dup
      //   185: invokespecial <init> : ()V
      //   188: astore #8
      //   190: aload_3
      //   191: astore #4
      //   193: aload #5
      //   195: astore_2
      //   196: aload #8
      //   198: ldc 'resultCode:'
      //   200: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   203: pop
      //   204: aload_3
      //   205: astore #4
      //   207: aload #5
      //   209: astore_2
      //   210: aload #8
      //   212: iload_1
      //   213: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   216: pop
      //   217: aload_3
      //   218: astore #4
      //   220: aload #5
      //   222: astore_2
      //   223: aload #8
      //   225: ldc ' failed'
      //   227: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   230: pop
      //   231: aload_3
      //   232: astore #4
      //   234: aload #5
      //   236: astore_2
      //   237: aload #6
      //   239: aload #8
      //   241: invokevirtual toString : ()Ljava/lang/String;
      //   244: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
      //   247: aload_3
      //   248: astore #4
      //   250: aload #5
      //   252: astore_2
      //   253: aload_0
      //   254: getfield d : Lcom/datavisor/vangogh/face/DVTokenClient$InitResultListener;
      //   257: ifnull -> 289
      //   260: aload_3
      //   261: astore #4
      //   263: aload #5
      //   265: astore_2
      //   266: aload_0
      //   267: getfield d : Lcom/datavisor/vangogh/face/DVTokenClient$InitResultListener;
      //   270: aload_0
      //   271: getfield e : Lcom/datavisor/vangogh/face/DVTokenClient;
      //   274: invokestatic b : (Lcom/datavisor/vangogh/face/DVTokenClient;)Landroid/content/Context;
      //   277: invokestatic a : (Landroid/content/Context;)Lcom/datavisor/vangogh/d/c;
      //   280: invokevirtual a : ()Ljava/lang/String;
      //   283: iload_1
      //   284: invokeinterface a : (Ljava/lang/String;I)V
      //   289: aload_0
      //   290: getfield e : Lcom/datavisor/vangogh/face/DVTokenClient;
      //   293: invokestatic c : (Lcom/datavisor/vangogh/face/DVTokenClient;)Ljava/util/concurrent/atomic/AtomicBoolean;
      //   296: iconst_0
      //   297: invokevirtual set : (Z)V
      //   300: aload_3
      //   301: ifnull -> 308
      //   304: aload_3
      //   305: invokevirtual release : ()V
      //   308: aload #5
      //   310: ifnull -> 318
      //   313: aload #5
      //   315: invokevirtual close : ()V
      //   318: aload #7
      //   320: ifnull -> 424
      //   323: aload #7
      //   325: invokevirtual close : ()V
      //   328: return
      //   329: astore_3
      //   330: aload #7
      //   332: astore #5
      //   334: goto -> 344
      //   337: astore_3
      //   338: aconst_null
      //   339: astore #5
      //   341: aload #5
      //   343: astore_2
      //   344: ldc 'initToken'
      //   346: aload_3
      //   347: aload_0
      //   348: getfield e : Lcom/datavisor/vangogh/face/DVTokenClient;
      //   351: invokestatic b : (Lcom/datavisor/vangogh/face/DVTokenClient;)Landroid/content/Context;
      //   354: invokestatic a : (Ljava/lang/String;Ljava/lang/Throwable;Landroid/content/Context;)V
      //   357: aload_0
      //   358: getfield d : Lcom/datavisor/vangogh/face/DVTokenClient$InitResultListener;
      //   361: ifnull -> 377
      //   364: aload_0
      //   365: getfield d : Lcom/datavisor/vangogh/face/DVTokenClient$InitResultListener;
      //   368: ldc ''
      //   370: bipush #11
      //   372: invokeinterface a : (Ljava/lang/String;I)V
      //   377: aload_0
      //   378: getfield e : Lcom/datavisor/vangogh/face/DVTokenClient;
      //   381: invokestatic c : (Lcom/datavisor/vangogh/face/DVTokenClient;)Ljava/util/concurrent/atomic/AtomicBoolean;
      //   384: iconst_0
      //   385: invokevirtual set : (Z)V
      //   388: aload #4
      //   390: ifnull -> 401
      //   393: aload #4
      //   395: invokevirtual release : ()V
      //   398: goto -> 401
      //   401: aload_2
      //   402: ifnull -> 409
      //   405: aload_2
      //   406: invokevirtual close : ()V
      //   409: aload #5
      //   411: ifnull -> 424
      //   414: aload #5
      //   416: invokevirtual close : ()V
      //   419: return
      //   420: aload_2
      //   421: invokestatic a : (Ljava/lang/Throwable;)V
      //   424: return
      //   425: astore_3
      //   426: aload_0
      //   427: getfield e : Lcom/datavisor/vangogh/face/DVTokenClient;
      //   430: invokestatic c : (Lcom/datavisor/vangogh/face/DVTokenClient;)Ljava/util/concurrent/atomic/AtomicBoolean;
      //   433: iconst_0
      //   434: invokevirtual set : (Z)V
      //   437: aload #4
      //   439: ifnull -> 450
      //   442: aload #4
      //   444: invokevirtual release : ()V
      //   447: goto -> 450
      //   450: aload_2
      //   451: ifnull -> 458
      //   454: aload_2
      //   455: invokevirtual close : ()V
      //   458: aload #5
      //   460: ifnull -> 475
      //   463: aload #5
      //   465: invokevirtual close : ()V
      //   468: goto -> 475
      //   471: aload_2
      //   472: invokestatic a : (Ljava/lang/Throwable;)V
      //   475: aload_3
      //   476: athrow
      //   477: astore_3
      //   478: aconst_null
      //   479: astore_2
      //   480: aload #7
      //   482: astore #5
      //   484: goto -> 344
      //   487: aconst_null
      //   488: astore #5
      //   490: goto -> 56
      //   493: astore_2
      //   494: goto -> 420
      //   497: astore_2
      //   498: goto -> 471
      // Exception table:
      //   from	to	target	type
      //   7	16	337	finally
      //   21	28	477	finally
      //   43	49	329	finally
      //   62	88	329	finally
      //   98	103	329	finally
      //   109	118	329	finally
      //   124	132	329	finally
      //   138	145	329	finally
      //   151	161	329	finally
      //   170	175	329	finally
      //   181	190	329	finally
      //   196	204	329	finally
      //   210	217	329	finally
      //   223	231	329	finally
      //   237	247	329	finally
      //   253	260	329	finally
      //   266	289	329	finally
      //   304	308	493	finally
      //   313	318	493	finally
      //   323	328	493	finally
      //   344	377	425	finally
      //   393	398	493	finally
      //   405	409	493	finally
      //   414	419	493	finally
      //   442	447	497	finally
      //   454	458	497	finally
      //   463	468	497	finally
    }
  }
  
  class b implements Runnable {
    public void run() {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: aconst_null
      //   3: astore #4
      //   5: aconst_null
      //   6: astore_3
      //   7: aload_0
      //   8: getfield f : Lcom/datavisor/vangogh/face/DVTokenClient;
      //   11: invokestatic a : (Lcom/datavisor/vangogh/face/DVTokenClient;)Ljava/io/RandomAccessFile;
      //   14: astore #7
      //   16: aload #7
      //   18: ifnull -> 443
      //   21: aload #7
      //   23: invokevirtual getChannel : ()Ljava/nio/channels/FileChannel;
      //   26: astore #6
      //   28: aload #6
      //   30: astore #5
      //   32: aload #6
      //   34: ifnull -> 56
      //   37: aload_2
      //   38: astore #4
      //   40: aload #6
      //   42: astore_2
      //   43: aload #6
      //   45: invokevirtual lock : ()Ljava/nio/channels/FileLock;
      //   48: astore_3
      //   49: aload #6
      //   51: astore #5
      //   53: goto -> 56
      //   56: aload_3
      //   57: astore #4
      //   59: aload #5
      //   61: astore_2
      //   62: aload_0
      //   63: getfield f : Lcom/datavisor/vangogh/face/DVTokenClient;
      //   66: invokestatic b : (Lcom/datavisor/vangogh/face/DVTokenClient;)Landroid/content/Context;
      //   69: invokestatic a : (Landroid/content/Context;)Lcom/datavisor/vangogh/d/c;
      //   72: aload_0
      //   73: getfield a : Ljava/lang/String;
      //   76: aload_0
      //   77: getfield b : Ljava/lang/String;
      //   80: aload_0
      //   81: getfield c : Ljava/lang/String;
      //   84: aload_0
      //   85: getfield d : Ljava/util/Map;
      //   88: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)I
      //   91: istore_1
      //   92: iload_1
      //   93: ifne -> 168
      //   96: aload_3
      //   97: astore #4
      //   99: aload #5
      //   101: astore_2
      //   102: invokestatic a : ()Ljava/lang/String;
      //   105: astore #6
      //   107: aload_3
      //   108: astore #4
      //   110: aload #5
      //   112: astore_2
      //   113: new java/lang/StringBuilder
      //   116: dup
      //   117: invokespecial <init> : ()V
      //   120: astore #8
      //   122: aload_3
      //   123: astore #4
      //   125: aload #5
      //   127: astore_2
      //   128: aload #8
      //   130: ldc 'resultCode:'
      //   132: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   135: pop
      //   136: aload_3
      //   137: astore #4
      //   139: aload #5
      //   141: astore_2
      //   142: aload #8
      //   144: iload_1
      //   145: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   148: pop
      //   149: aload_3
      //   150: astore #4
      //   152: aload #5
      //   154: astore_2
      //   155: aload #6
      //   157: aload #8
      //   159: invokevirtual toString : ()Ljava/lang/String;
      //   162: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
      //   165: goto -> 251
      //   168: aload_3
      //   169: astore #4
      //   171: aload #5
      //   173: astore_2
      //   174: invokestatic a : ()Ljava/lang/String;
      //   177: astore #6
      //   179: aload_3
      //   180: astore #4
      //   182: aload #5
      //   184: astore_2
      //   185: new java/lang/StringBuilder
      //   188: dup
      //   189: invokespecial <init> : ()V
      //   192: astore #8
      //   194: aload_3
      //   195: astore #4
      //   197: aload #5
      //   199: astore_2
      //   200: aload #8
      //   202: ldc 'resultCode:'
      //   204: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   207: pop
      //   208: aload_3
      //   209: astore #4
      //   211: aload #5
      //   213: astore_2
      //   214: aload #8
      //   216: iload_1
      //   217: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   220: pop
      //   221: aload_3
      //   222: astore #4
      //   224: aload #5
      //   226: astore_2
      //   227: aload #8
      //   229: ldc ' failed'
      //   231: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   234: pop
      //   235: aload_3
      //   236: astore #4
      //   238: aload #5
      //   240: astore_2
      //   241: aload #6
      //   243: aload #8
      //   245: invokevirtual toString : ()Ljava/lang/String;
      //   248: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
      //   251: aload_3
      //   252: astore #4
      //   254: aload #5
      //   256: astore_2
      //   257: aload_0
      //   258: getfield e : Lcom/datavisor/vangogh/face/DVTokenClient$EventResultListener;
      //   261: ifnull -> 280
      //   264: aload_3
      //   265: astore #4
      //   267: aload #5
      //   269: astore_2
      //   270: aload_0
      //   271: getfield e : Lcom/datavisor/vangogh/face/DVTokenClient$EventResultListener;
      //   274: iload_1
      //   275: invokeinterface a : (I)V
      //   280: aload_3
      //   281: ifnull -> 288
      //   284: aload_3
      //   285: invokevirtual release : ()V
      //   288: aload #5
      //   290: ifnull -> 298
      //   293: aload #5
      //   295: invokevirtual close : ()V
      //   298: aload #7
      //   300: ifnull -> 391
      //   303: aload #7
      //   305: invokevirtual close : ()V
      //   308: return
      //   309: astore_3
      //   310: aload #7
      //   312: astore #5
      //   314: goto -> 324
      //   317: astore_3
      //   318: aconst_null
      //   319: astore #5
      //   321: aload #5
      //   323: astore_2
      //   324: ldc 'postEvent'
      //   326: aload_3
      //   327: aload_0
      //   328: getfield f : Lcom/datavisor/vangogh/face/DVTokenClient;
      //   331: invokestatic b : (Lcom/datavisor/vangogh/face/DVTokenClient;)Landroid/content/Context;
      //   334: invokestatic a : (Ljava/lang/String;Ljava/lang/Throwable;Landroid/content/Context;)V
      //   337: aload_0
      //   338: getfield e : Lcom/datavisor/vangogh/face/DVTokenClient$EventResultListener;
      //   341: ifnull -> 355
      //   344: aload_0
      //   345: getfield e : Lcom/datavisor/vangogh/face/DVTokenClient$EventResultListener;
      //   348: bipush #11
      //   350: invokeinterface a : (I)V
      //   355: aload #4
      //   357: ifnull -> 368
      //   360: aload #4
      //   362: invokevirtual release : ()V
      //   365: goto -> 368
      //   368: aload_2
      //   369: ifnull -> 376
      //   372: aload_2
      //   373: invokevirtual close : ()V
      //   376: aload #5
      //   378: ifnull -> 391
      //   381: aload #5
      //   383: invokevirtual close : ()V
      //   386: return
      //   387: aload_2
      //   388: invokestatic a : (Ljava/lang/Throwable;)V
      //   391: return
      //   392: astore_3
      //   393: aload #4
      //   395: ifnull -> 406
      //   398: aload #4
      //   400: invokevirtual release : ()V
      //   403: goto -> 406
      //   406: aload_2
      //   407: ifnull -> 414
      //   410: aload_2
      //   411: invokevirtual close : ()V
      //   414: aload #5
      //   416: ifnull -> 431
      //   419: aload #5
      //   421: invokevirtual close : ()V
      //   424: goto -> 431
      //   427: aload_2
      //   428: invokestatic a : (Ljava/lang/Throwable;)V
      //   431: aload_3
      //   432: athrow
      //   433: astore_3
      //   434: aconst_null
      //   435: astore_2
      //   436: aload #7
      //   438: astore #5
      //   440: goto -> 324
      //   443: aconst_null
      //   444: astore #5
      //   446: goto -> 56
      //   449: astore_2
      //   450: goto -> 387
      //   453: astore_2
      //   454: goto -> 427
      // Exception table:
      //   from	to	target	type
      //   7	16	317	finally
      //   21	28	433	finally
      //   43	49	309	finally
      //   62	92	309	finally
      //   102	107	309	finally
      //   113	122	309	finally
      //   128	136	309	finally
      //   142	149	309	finally
      //   155	165	309	finally
      //   174	179	309	finally
      //   185	194	309	finally
      //   200	208	309	finally
      //   214	221	309	finally
      //   227	235	309	finally
      //   241	251	309	finally
      //   257	264	309	finally
      //   270	280	309	finally
      //   284	288	449	finally
      //   293	298	449	finally
      //   303	308	449	finally
      //   324	355	392	finally
      //   360	365	449	finally
      //   372	376	449	finally
      //   381	386	449	finally
      //   398	403	453	finally
      //   410	414	453	finally
      //   419	424	453	finally
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\datavisor\vangogh\face\DVTokenClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */