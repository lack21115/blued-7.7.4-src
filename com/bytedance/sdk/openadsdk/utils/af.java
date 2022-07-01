package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.a;
import com.bytedance.sdk.openadsdk.core.h.i;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.widget.webview.a.a;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

public class af implements Thread.UncaughtExceptionHandler {
  private Thread.UncaughtExceptionHandler a = Thread.getDefaultUncaughtExceptionHandler();
  
  private String b;
  
  private af() {
    Thread.setDefaultUncaughtExceptionHandler(this);
    b();
  }
  
  public static af a() {
    return new af();
  }
  
  private void a(Thread paramThread, Throwable paramThrowable) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #13
    //   3: aconst_null
    //   4: astore #11
    //   6: aconst_null
    //   7: astore #12
    //   9: aconst_null
    //   10: astore_1
    //   11: aload_0
    //   12: getfield b : Ljava/lang/String;
    //   15: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   18: ifeq -> 25
    //   21: aload_0
    //   22: invokespecial b : ()V
    //   25: aload_0
    //   26: getfield b : Ljava/lang/String;
    //   29: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   32: ifeq -> 36
    //   35: return
    //   36: new java/io/File
    //   39: dup
    //   40: aload_0
    //   41: getfield b : Ljava/lang/String;
    //   44: ldc 'tt_crash_count.properties'
    //   46: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   49: astore #14
    //   51: aload #14
    //   53: invokevirtual exists : ()Z
    //   56: istore #5
    //   58: iconst_1
    //   59: istore #6
    //   61: iload #5
    //   63: ifeq -> 391
    //   66: aload #14
    //   68: invokevirtual isFile : ()Z
    //   71: ifeq -> 391
    //   74: aload #14
    //   76: invokevirtual canRead : ()Z
    //   79: ifeq -> 391
    //   82: new java/util/Properties
    //   85: dup
    //   86: invokespecial <init> : ()V
    //   89: astore #15
    //   91: new java/io/FileInputStream
    //   94: dup
    //   95: aload #14
    //   97: invokespecial <init> : (Ljava/io/File;)V
    //   100: astore #11
    //   102: aload #13
    //   104: astore_2
    //   105: aload #15
    //   107: aload #11
    //   109: invokevirtual load : (Ljava/io/InputStream;)V
    //   112: aload #13
    //   114: astore_2
    //   115: aload #15
    //   117: ldc 'crash_count'
    //   119: ldc '0'
    //   121: invokevirtual getProperty : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   124: astore #12
    //   126: aload #13
    //   128: astore_2
    //   129: aload #15
    //   131: ldc 'crash_last_time'
    //   133: ldc '0'
    //   135: invokevirtual getProperty : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   138: astore #16
    //   140: aload #13
    //   142: astore_2
    //   143: aload #12
    //   145: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Integer;
    //   148: invokevirtual intValue : ()I
    //   151: istore_3
    //   152: aload #13
    //   154: astore_2
    //   155: aload #16
    //   157: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Long;
    //   160: invokevirtual longValue : ()J
    //   163: lstore #7
    //   165: aload #13
    //   167: astore_2
    //   168: invokestatic currentTimeMillis : ()J
    //   171: lstore #9
    //   173: iconst_0
    //   174: istore #4
    //   176: lload #9
    //   178: lload #7
    //   180: lsub
    //   181: ldc2_w 300000
    //   184: lcmp
    //   185: ifge -> 560
    //   188: iload_3
    //   189: iconst_1
    //   190: iadd
    //   191: istore_3
    //   192: iconst_0
    //   193: istore #5
    //   195: goto -> 565
    //   198: aload #13
    //   200: astore_2
    //   201: new java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial <init> : ()V
    //   208: astore #12
    //   210: aload #13
    //   212: astore_2
    //   213: aload #12
    //   215: ldc '=='
    //   217: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload #13
    //   223: astore_2
    //   224: aload #12
    //   226: iload_3
    //   227: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload #13
    //   233: astore_2
    //   234: aload #12
    //   236: ldc ', '
    //   238: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload #13
    //   244: astore_2
    //   245: aload #12
    //   247: iload #6
    //   249: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload #13
    //   255: astore_2
    //   256: aload #12
    //   258: ldc ', '
    //   260: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload #13
    //   266: astore_2
    //   267: aload #12
    //   269: iload #5
    //   271: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: aload #13
    //   277: astore_2
    //   278: ldc 'TTCrashHandler'
    //   280: aload #12
    //   282: invokevirtual toString : ()Ljava/lang/String;
    //   285: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   288: iload #6
    //   290: ifeq -> 305
    //   293: aload #14
    //   295: invokevirtual delete : ()Z
    //   298: pop
    //   299: goto -> 363
    //   302: goto -> 363
    //   305: aload #13
    //   307: astore_2
    //   308: aload #15
    //   310: ldc 'crash_count'
    //   312: iload_3
    //   313: invokestatic valueOf : (I)Ljava/lang/String;
    //   316: invokevirtual setProperty : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   319: pop
    //   320: iload #5
    //   322: ifeq -> 342
    //   325: aload #13
    //   327: astore_2
    //   328: aload #15
    //   330: ldc 'crash_last_time'
    //   332: invokestatic currentTimeMillis : ()J
    //   335: invokestatic valueOf : (J)Ljava/lang/String;
    //   338: invokevirtual setProperty : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   341: pop
    //   342: aload #13
    //   344: astore_2
    //   345: new java/io/FileOutputStream
    //   348: dup
    //   349: aload #14
    //   351: invokespecial <init> : (Ljava/io/File;)V
    //   354: astore_1
    //   355: aload #15
    //   357: aload_1
    //   358: ldc 'tt_crash_info'
    //   360: invokevirtual store : (Ljava/io/OutputStream;Ljava/lang/String;)V
    //   363: iload #6
    //   365: ifeq -> 374
    //   368: aload_1
    //   369: astore_2
    //   370: aload_0
    //   371: invokespecial c : ()V
    //   374: goto -> 447
    //   377: astore_2
    //   378: goto -> 388
    //   381: astore #12
    //   383: aload_2
    //   384: astore_1
    //   385: aload #12
    //   387: astore_2
    //   388: goto -> 484
    //   391: new java/util/Properties
    //   394: dup
    //   395: invokespecial <init> : ()V
    //   398: astore_2
    //   399: aload_2
    //   400: ldc 'crash_count'
    //   402: iconst_1
    //   403: invokestatic valueOf : (I)Ljava/lang/String;
    //   406: invokevirtual setProperty : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   409: pop
    //   410: aload_2
    //   411: ldc 'crash_last_time'
    //   413: invokestatic currentTimeMillis : ()J
    //   416: invokestatic valueOf : (J)Ljava/lang/String;
    //   419: invokevirtual setProperty : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   422: pop
    //   423: new java/io/FileOutputStream
    //   426: dup
    //   427: aload #14
    //   429: invokespecial <init> : (Ljava/io/File;)V
    //   432: astore_1
    //   433: aload_2
    //   434: aload_1
    //   435: ldc 'tt_crash_info'
    //   437: invokevirtual store : (Ljava/io/OutputStream;Ljava/lang/String;)V
    //   440: ldc 'TTCrashHandler'
    //   442: ldc '==first'
    //   444: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   447: aload #11
    //   449: ifnull -> 460
    //   452: aload #11
    //   454: invokevirtual close : ()V
    //   457: goto -> 460
    //   460: aload_1
    //   461: ifnull -> 512
    //   464: aload_1
    //   465: invokevirtual close : ()V
    //   468: return
    //   469: astore_2
    //   470: aload #12
    //   472: astore #11
    //   474: goto -> 484
    //   477: astore_2
    //   478: aconst_null
    //   479: astore_1
    //   480: aload #12
    //   482: astore #11
    //   484: ldc 'TTCrashHandler'
    //   486: ldc 'crash count error'
    //   488: aload_2
    //   489: invokestatic c : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   492: aload #11
    //   494: ifnull -> 505
    //   497: aload #11
    //   499: invokevirtual close : ()V
    //   502: goto -> 505
    //   505: aload_1
    //   506: ifnull -> 512
    //   509: goto -> 464
    //   512: return
    //   513: astore_2
    //   514: aload #11
    //   516: ifnull -> 527
    //   519: aload #11
    //   521: invokevirtual close : ()V
    //   524: goto -> 527
    //   527: aload_1
    //   528: ifnull -> 535
    //   531: aload_1
    //   532: invokevirtual close : ()V
    //   535: aload_2
    //   536: athrow
    //   537: astore_2
    //   538: goto -> 302
    //   541: astore_2
    //   542: goto -> 460
    //   545: astore_1
    //   546: return
    //   547: astore_2
    //   548: goto -> 505
    //   551: astore #11
    //   553: goto -> 527
    //   556: astore_1
    //   557: goto -> 535
    //   560: iconst_1
    //   561: istore_3
    //   562: iconst_1
    //   563: istore #5
    //   565: iload_3
    //   566: iconst_3
    //   567: if_icmplt -> 573
    //   570: goto -> 576
    //   573: iconst_0
    //   574: istore #6
    //   576: iload #6
    //   578: ifeq -> 587
    //   581: iload #4
    //   583: istore_3
    //   584: goto -> 198
    //   587: goto -> 198
    // Exception table:
    //   from	to	target	type
    //   11	25	477	finally
    //   25	35	477	finally
    //   36	58	477	finally
    //   66	102	477	finally
    //   105	112	381	finally
    //   115	126	381	finally
    //   129	140	381	finally
    //   143	152	381	finally
    //   155	165	381	finally
    //   168	173	381	finally
    //   201	210	381	finally
    //   213	221	381	finally
    //   224	231	381	finally
    //   234	242	381	finally
    //   245	253	381	finally
    //   256	264	381	finally
    //   267	275	381	finally
    //   278	288	381	finally
    //   293	299	537	finally
    //   308	320	381	finally
    //   328	342	381	finally
    //   345	355	381	finally
    //   355	363	377	finally
    //   370	374	381	finally
    //   391	433	477	finally
    //   433	447	469	finally
    //   452	457	541	finally
    //   464	468	545	finally
    //   484	492	513	finally
    //   497	502	547	finally
    //   519	524	551	finally
    //   531	535	556	finally
  }
  
  private void b() {
    Context context = o.a();
    if (context == null)
      return; 
    try {
      boolean bool = "mounted".equals(Environment.getExternalStorageState());
      if (bool) {
        File file = context.getExternalFilesDir("TTCache");
        if (file != null) {
          file.mkdirs();
          this.b = file.getPath();
        } 
      } 
      return;
    } finally {
      context = null;
    } 
  }
  
  private void c() {
    try {
      Method method = ag.a("com.bytedance.sdk.openadsdk.TTC2Proxy", "a", new Class[] { Context.class });
      if (method != null)
        method.invoke(null, new Object[] { o.a() }); 
    } finally {
      Exception exception;
    } 
    try {
      Method method = ag.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "a", new Class[] { Context.class });
      if (method != null)
        method.invoke(null, new Object[] { o.a() }); 
    } finally {
      Exception exception;
    } 
    try {
      i.a();
    } finally {
      Exception exception;
    } 
    try {
      a.b();
    } finally {
      Exception exception;
    } 
    try {
      String str = a.b(o.a());
      if (!TextUtils.isEmpty(str)) {
        File file = new File(str);
        if (file.exists())
          k.c(file); 
      } 
    } finally {
      Exception exception = null;
    } 
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
    boolean bool1;
    boolean bool2 = false;
    try {
      StringWriter stringWriter = new StringWriter();
      paramThrowable.printStackTrace(new PrintWriter(stringWriter));
      String str = stringWriter.toString();
      bool1 = bool2;
    } finally {
      Exception exception = null;
    } 
    if (bool1)
      a(paramThread, paramThrowable); 
    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a;
    if (uncaughtExceptionHandler != null && uncaughtExceptionHandler != this)
      uncaughtExceptionHandler.uncaughtException(paramThread, paramThrowable); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsd\\utils\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */