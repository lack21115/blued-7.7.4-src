package com.ss.android.socialbase.downloader.downloader;

import android.app.AlarmManager;
import android.content.Context;
import android.content.IntentFilter;
import com.ss.android.socialbase.downloader.b.d;
import com.ss.android.socialbase.downloader.d.ac;
import com.ss.android.socialbase.downloader.d.ag;
import com.ss.android.socialbase.downloader.d.k;
import com.ss.android.socialbase.downloader.e.a;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.g.e;
import com.ss.android.socialbase.downloader.i.c;
import com.ss.android.socialbase.downloader.i.d;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.impls.a;
import com.ss.android.socialbase.downloader.k.a;
import com.ss.android.socialbase.downloader.m.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import okhttp3.OkHttpClient;
import org.json.JSONObject;

public class b {
  private static int A;
  
  private static final int B;
  
  private static final int C;
  
  private static final int D;
  
  private static int E;
  
  private static boolean F;
  
  private static volatile List<k> G;
  
  private static int H;
  
  private static JSONObject I;
  
  private static com.ss.android.socialbase.downloader.h.b J;
  
  private static volatile boolean K;
  
  private static volatile Context a;
  
  private static volatile k b;
  
  private static volatile l c;
  
  private static volatile i d;
  
  private static volatile ac e;
  
  private static volatile a f;
  
  private static volatile p g;
  
  private static volatile p h;
  
  private static volatile f i;
  
  private static volatile d j;
  
  private static volatile f k;
  
  private static volatile d l;
  
  private static volatile m m;
  
  private static volatile ExecutorService n;
  
  private static volatile ExecutorService o;
  
  private static volatile ExecutorService p;
  
  private static volatile ExecutorService q;
  
  private static volatile h r;
  
  private static volatile DownloadReceiver s;
  
  private static volatile r t;
  
  private static volatile q u;
  
  private static volatile List<ag> v = new ArrayList<ag>();
  
  private static volatile boolean w = false;
  
  private static volatile OkHttpClient x = null;
  
  private static volatile AlarmManager y;
  
  private static boolean z = false;
  
  static {
    B = Runtime.getRuntime().availableProcessors() + 1;
    C = Runtime.getRuntime().availableProcessors() * 2 + 1;
    D = Runtime.getRuntime().availableProcessors() + 1;
    E = 8192;
    G = new ArrayList<k>();
    K = false;
  }
  
  public static r A() {
    // Byte code:
    //   0: getstatic com/ss/android/socialbase/downloader/downloader/b.t : Lcom/ss/android/socialbase/downloader/downloader/r;
    //   3: ifnonnull -> 37
    //   6: ldc com/ss/android/socialbase/downloader/downloader/b
    //   8: monitorenter
    //   9: getstatic com/ss/android/socialbase/downloader/downloader/b.t : Lcom/ss/android/socialbase/downloader/downloader/r;
    //   12: ifnonnull -> 25
    //   15: new com/ss/android/socialbase/downloader/impls/j
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/ss/android/socialbase/downloader/downloader/b.t : Lcom/ss/android/socialbase/downloader/downloader/r;
    //   25: ldc com/ss/android/socialbase/downloader/downloader/b
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/ss/android/socialbase/downloader/downloader/b
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/ss/android/socialbase/downloader/downloader/b.t : Lcom/ss/android/socialbase/downloader/downloader/r;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public static Context B() {
    // Byte code:
    //   0: ldc com/ss/android/socialbase/downloader/downloader/b
    //   2: monitorenter
    //   3: getstatic com/ss/android/socialbase/downloader/downloader/b.a : Landroid/content/Context;
    //   6: astore_0
    //   7: ldc com/ss/android/socialbase/downloader/downloader/b
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/ss/android/socialbase/downloader/downloader/b
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static boolean C() {
    // Byte code:
    //   0: ldc com/ss/android/socialbase/downloader/downloader/b
    //   2: monitorenter
    //   3: getstatic com/ss/android/socialbase/downloader/downloader/b.F : Z
    //   6: istore_0
    //   7: ldc com/ss/android/socialbase/downloader/downloader/b
    //   9: monitorexit
    //   10: iload_0
    //   11: ireturn
    //   12: astore_1
    //   13: ldc com/ss/android/socialbase/downloader/downloader/b
    //   15: monitorexit
    //   16: aload_1
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static com.ss.android.socialbase.downloader.h.b D() {
    return J;
  }
  
  private static void E() {
    if (s == null)
      s = new DownloadReceiver(); 
    if (z)
      return; 
    try {
      IntentFilter intentFilter = new IntentFilter();
      intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      return;
    } finally {
      Exception exception = null;
      exception.printStackTrace();
    } 
  }
  
  private static int F() {
    int j = A;
    if (j <= 0 || j > B)
      A = B; 
    return A;
  }
  
  public static int a(c paramc) {
    return (paramc == null) ? 0 : a(paramc.j(), paramc.k());
  }
  
  public static int a(String paramString1, String paramString2) {
    l l1 = s();
    return (l1 == null) ? 0 : l1.a(paramString1, paramString2);
  }
  
  public static c a(String paramString, List<e> paramList) throws a, IOException {
    d d1 = e();
    c c1 = null;
    if (d1 != null) {
      try {
        c c = d1.a(paramString, paramList);
        c1 = c;
        c = null;
      } catch (IOException iOException) {}
    } else {
      d1 = null;
    } 
    c c2 = c1;
    if (c1 == null) {
      d d2 = g();
      c2 = c1;
      if (d2 != null)
        c2 = d2.a(paramString, paramList); 
    } 
    if (c2 == null) {
      if (d1 == null)
        return c2; 
      throw d1;
    } 
    return c2;
  }
  
  public static e a(boolean paramBoolean, int paramInt, String paramString, List<e> paramList) throws a, IOException {
    // Byte code:
    //   0: invokestatic c : ()Lcom/ss/android/socialbase/downloader/i/f;
    //   3: astore #7
    //   5: aload #7
    //   7: ifnonnull -> 37
    //   10: iload_0
    //   11: ifeq -> 17
    //   14: goto -> 37
    //   17: new com/ss/android/socialbase/downloader/e/a
    //   20: dup
    //   21: sipush #1022
    //   24: new java/io/IOException
    //   27: dup
    //   28: ldc 'download can't continue, because httpService not exist'
    //   30: invokespecial <init> : (Ljava/lang/String;)V
    //   33: invokespecial <init> : (ILjava/lang/Throwable;)V
    //   36: athrow
    //   37: aconst_null
    //   38: astore #4
    //   40: aload #7
    //   42: ifnull -> 72
    //   45: aload #7
    //   47: iload_1
    //   48: aload_2
    //   49: aload_3
    //   50: invokeinterface a : (ILjava/lang/String;Ljava/util/List;)Lcom/ss/android/socialbase/downloader/i/e;
    //   55: astore #6
    //   57: aconst_null
    //   58: astore #5
    //   60: aload #6
    //   62: astore #4
    //   64: goto -> 75
    //   67: astore #5
    //   69: goto -> 75
    //   72: aconst_null
    //   73: astore #5
    //   75: aload #4
    //   77: astore #6
    //   79: iload_0
    //   80: ifeq -> 137
    //   83: aload #4
    //   85: astore #6
    //   87: aload #4
    //   89: ifnonnull -> 137
    //   92: aload #7
    //   94: ifnull -> 111
    //   97: aload #4
    //   99: astore #6
    //   101: aload #7
    //   103: invokevirtual getClass : ()Ljava/lang/Class;
    //   106: ldc com/ss/android/socialbase/downloader/impls/g
    //   108: if_acmpeq -> 137
    //   111: invokestatic f : ()Lcom/ss/android/socialbase/downloader/i/f;
    //   114: astore #7
    //   116: aload #4
    //   118: astore #6
    //   120: aload #7
    //   122: ifnull -> 137
    //   125: aload #7
    //   127: iload_1
    //   128: aload_2
    //   129: aload_3
    //   130: invokeinterface a : (ILjava/lang/String;Ljava/util/List;)Lcom/ss/android/socialbase/downloader/i/e;
    //   135: astore #6
    //   137: aload #6
    //   139: ifnonnull -> 153
    //   142: aload #5
    //   144: ifnonnull -> 150
    //   147: aload #6
    //   149: areturn
    //   150: aload #5
    //   152: athrow
    //   153: aload #6
    //   155: areturn
    // Exception table:
    //   from	to	target	type
    //   45	57	67	java/io/IOException
  }
  
  public static void a() {
    // Byte code:
    //   0: ldc com/ss/android/socialbase/downloader/downloader/b
    //   2: monitorenter
    //   3: getstatic com/ss/android/socialbase/downloader/downloader/b.w : Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq -> 15
    //   11: ldc com/ss/android/socialbase/downloader/downloader/b
    //   13: monitorexit
    //   14: return
    //   15: iconst_1
    //   16: putstatic com/ss/android/socialbase/downloader/downloader/b.w : Z
    //   19: new android/content/Intent
    //   22: dup
    //   23: invokestatic B : ()Landroid/content/Context;
    //   26: ldc com/ss/android/socialbase/downloader/impls/DownloadHandleService
    //   28: invokespecial <init> : (Landroid/content/Context;Ljava/lang/Class;)V
    //   31: astore_1
    //   32: aload_1
    //   33: ldc 'com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY'
    //   35: invokevirtual setAction : (Ljava/lang/String;)Landroid/content/Intent;
    //   38: pop
    //   39: invokestatic B : ()Landroid/content/Context;
    //   42: aload_1
    //   43: invokevirtual startService : (Landroid/content/Intent;)Landroid/content/ComponentName;
    //   46: pop
    //   47: invokestatic c : ()Z
    //   50: ifne -> 74
    //   53: iconst_1
    //   54: invokestatic a : (Z)Lcom/ss/android/socialbase/downloader/downloader/n;
    //   57: invokeinterface d : ()V
    //   62: goto -> 74
    //   65: astore_1
    //   66: iconst_0
    //   67: putstatic com/ss/android/socialbase/downloader/downloader/b.w : Z
    //   70: aload_1
    //   71: invokevirtual printStackTrace : ()V
    //   74: ldc com/ss/android/socialbase/downloader/downloader/b
    //   76: monitorexit
    //   77: return
    //   78: astore_1
    //   79: ldc com/ss/android/socialbase/downloader/downloader/b
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	78	finally
    //   15	19	78	finally
    //   19	62	65	finally
    //   66	74	78	finally
  }
  
  private static void a(int paramInt) {
    if (paramInt > 0)
      A = paramInt; 
  }
  
  public static void a(Context paramContext) {
    // Byte code:
    //   0: ldc com/ss/android/socialbase/downloader/downloader/b
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull -> 35
    //   7: getstatic com/ss/android/socialbase/downloader/downloader/b.a : Landroid/content/Context;
    //   10: ifnonnull -> 35
    //   13: aload_0
    //   14: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   17: putstatic com/ss/android/socialbase/downloader/downloader/b.a : Landroid/content/Context;
    //   20: invokestatic a : ()Lcom/ss/android/socialbase/downloader/a/a;
    //   23: invokevirtual b : ()V
    //   26: goto -> 35
    //   29: astore_0
    //   30: ldc com/ss/android/socialbase/downloader/downloader/b
    //   32: monitorexit
    //   33: aload_0
    //   34: athrow
    //   35: ldc com/ss/android/socialbase/downloader/downloader/b
    //   37: monitorexit
    //   38: return
    // Exception table:
    //   from	to	target	type
    //   7	26	29	finally
  }
  
  public static void a(d paramd) {
    synchronized (G) {
      if (G == null)
        return; 
      for (k k1 : G) {
        if (k1 != null) {
          if (paramd == d.b) {
            k1.a();
            continue;
          } 
          if (paramd == d.c)
            k1.b(); 
        } 
      } 
      G.clear();
      return;
    } 
  }
  
  public static void a(ac paramac) {
    if (paramac != null)
      e = paramac; 
  }
  
  public static void a(ag paramag) {
    if (paramag == null)
      return; 
    synchronized (v) {
      v.add(paramag);
      return;
    } 
  }
  
  static void a(g paramg) {
    // Byte code:
    //   0: ldc com/ss/android/socialbase/downloader/downloader/b
    //   2: monitorenter
    //   3: getstatic com/ss/android/socialbase/downloader/downloader/b.K : Z
    //   6: ifeq -> 22
    //   9: ldc_w 'DownloadComponentManager'
    //   12: ldc_w 'component has init'
    //   15: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   18: ldc com/ss/android/socialbase/downloader/downloader/b
    //   20: monitorexit
    //   21: return
    //   22: getstatic com/ss/android/socialbase/downloader/downloader/b.w : Z
    //   25: istore_1
    //   26: aload_0
    //   27: ifnull -> 184
    //   30: aload_0
    //   31: invokevirtual a : ()Landroid/content/Context;
    //   34: invokestatic a : (Landroid/content/Context;)V
    //   37: aload_0
    //   38: invokevirtual b : ()Lcom/ss/android/socialbase/downloader/downloader/k;
    //   41: invokestatic a : (Lcom/ss/android/socialbase/downloader/downloader/k;)V
    //   44: aload_0
    //   45: invokevirtual c : ()Lcom/ss/android/socialbase/downloader/downloader/l;
    //   48: invokestatic a : (Lcom/ss/android/socialbase/downloader/downloader/l;)V
    //   51: aload_0
    //   52: invokevirtual l : ()Lcom/ss/android/socialbase/downloader/downloader/i;
    //   55: invokestatic a : (Lcom/ss/android/socialbase/downloader/downloader/i;)V
    //   58: aload_0
    //   59: invokevirtual r : ()Lcom/ss/android/socialbase/downloader/d/ac;
    //   62: invokestatic a : (Lcom/ss/android/socialbase/downloader/d/ac;)V
    //   65: aload_0
    //   66: invokevirtual k : ()I
    //   69: invokestatic a : (I)V
    //   72: aload_0
    //   73: invokevirtual d : ()Lcom/ss/android/socialbase/downloader/i/f;
    //   76: invokestatic a : (Lcom/ss/android/socialbase/downloader/i/f;)V
    //   79: aload_0
    //   80: invokevirtual e : ()Lcom/ss/android/socialbase/downloader/i/d;
    //   83: invokestatic a : (Lcom/ss/android/socialbase/downloader/i/d;)V
    //   86: aload_0
    //   87: invokevirtual f : ()Lcom/ss/android/socialbase/downloader/downloader/m;
    //   90: invokestatic a : (Lcom/ss/android/socialbase/downloader/downloader/m;)V
    //   93: aload_0
    //   94: invokevirtual g : ()Ljava/util/concurrent/ExecutorService;
    //   97: invokestatic b : (Ljava/util/concurrent/ExecutorService;)V
    //   100: aload_0
    //   101: invokevirtual h : ()Ljava/util/concurrent/ExecutorService;
    //   104: invokestatic c : (Ljava/util/concurrent/ExecutorService;)V
    //   107: aload_0
    //   108: invokevirtual i : ()Ljava/util/concurrent/ExecutorService;
    //   111: invokestatic d : (Ljava/util/concurrent/ExecutorService;)V
    //   114: aload_0
    //   115: invokevirtual j : ()Ljava/util/concurrent/ExecutorService;
    //   118: invokestatic a : (Ljava/util/concurrent/ExecutorService;)V
    //   121: aload_0
    //   122: invokevirtual p : ()Lcom/ss/android/socialbase/downloader/downloader/q;
    //   125: ifnull -> 135
    //   128: aload_0
    //   129: invokevirtual p : ()Lcom/ss/android/socialbase/downloader/downloader/q;
    //   132: putstatic com/ss/android/socialbase/downloader/downloader/b.u : Lcom/ss/android/socialbase/downloader/downloader/q;
    //   135: aload_0
    //   136: invokevirtual n : ()I
    //   139: sipush #1024
    //   142: if_icmple -> 152
    //   145: aload_0
    //   146: invokevirtual n : ()I
    //   149: putstatic com/ss/android/socialbase/downloader/downloader/b.E : I
    //   152: aload_0
    //   153: invokevirtual m : ()Lcom/ss/android/socialbase/downloader/downloader/h;
    //   156: invokestatic a : (Lcom/ss/android/socialbase/downloader/downloader/h;)V
    //   159: aload_0
    //   160: invokevirtual o : ()Z
    //   163: ifeq -> 170
    //   166: iconst_1
    //   167: putstatic com/ss/android/socialbase/downloader/downloader/b.w : Z
    //   170: aload_0
    //   171: invokevirtual q : ()I
    //   174: putstatic com/ss/android/socialbase/downloader/downloader/b.H : I
    //   177: aload_0
    //   178: invokevirtual s : ()Lorg/json/JSONObject;
    //   181: invokestatic a : (Lorg/json/JSONObject;)V
    //   184: getstatic com/ss/android/socialbase/downloader/downloader/b.b : Lcom/ss/android/socialbase/downloader/downloader/k;
    //   187: ifnonnull -> 200
    //   190: new com/ss/android/socialbase/downloader/impls/d
    //   193: dup
    //   194: invokespecial <init> : ()V
    //   197: putstatic com/ss/android/socialbase/downloader/downloader/b.b : Lcom/ss/android/socialbase/downloader/downloader/k;
    //   200: getstatic com/ss/android/socialbase/downloader/downloader/b.g : Lcom/ss/android/socialbase/downloader/downloader/p;
    //   203: ifnonnull -> 216
    //   206: new com/ss/android/socialbase/downloader/impls/h
    //   209: dup
    //   210: invokespecial <init> : ()V
    //   213: putstatic com/ss/android/socialbase/downloader/downloader/b.g : Lcom/ss/android/socialbase/downloader/downloader/p;
    //   216: getstatic com/ss/android/socialbase/downloader/downloader/b.h : Lcom/ss/android/socialbase/downloader/downloader/p;
    //   219: ifnonnull -> 232
    //   222: new com/ss/android/socialbase/downloader/impls/n
    //   225: dup
    //   226: invokespecial <init> : ()V
    //   229: putstatic com/ss/android/socialbase/downloader/downloader/b.h : Lcom/ss/android/socialbase/downloader/downloader/p;
    //   232: getstatic com/ss/android/socialbase/downloader/downloader/b.c : Lcom/ss/android/socialbase/downloader/downloader/l;
    //   235: ifnonnull -> 248
    //   238: new com/ss/android/socialbase/downloader/impls/i
    //   241: dup
    //   242: invokespecial <init> : ()V
    //   245: putstatic com/ss/android/socialbase/downloader/downloader/b.c : Lcom/ss/android/socialbase/downloader/downloader/l;
    //   248: getstatic com/ss/android/socialbase/downloader/downloader/b.f : Lcom/ss/android/socialbase/downloader/impls/a;
    //   251: ifnonnull -> 264
    //   254: new com/ss/android/socialbase/downloader/impls/e
    //   257: dup
    //   258: invokespecial <init> : ()V
    //   261: putstatic com/ss/android/socialbase/downloader/downloader/b.f : Lcom/ss/android/socialbase/downloader/impls/a;
    //   264: getstatic com/ss/android/socialbase/downloader/downloader/b.d : Lcom/ss/android/socialbase/downloader/downloader/i;
    //   267: ifnonnull -> 280
    //   270: new com/ss/android/socialbase/downloader/impls/c
    //   273: dup
    //   274: invokespecial <init> : ()V
    //   277: putstatic com/ss/android/socialbase/downloader/downloader/b.d : Lcom/ss/android/socialbase/downloader/downloader/i;
    //   280: getstatic com/ss/android/socialbase/downloader/downloader/b.r : Lcom/ss/android/socialbase/downloader/downloader/h;
    //   283: ifnonnull -> 296
    //   286: new com/ss/android/socialbase/downloader/impls/b
    //   289: dup
    //   290: invokespecial <init> : ()V
    //   293: putstatic com/ss/android/socialbase/downloader/downloader/b.r : Lcom/ss/android/socialbase/downloader/downloader/h;
    //   296: getstatic com/ss/android/socialbase/downloader/downloader/b.t : Lcom/ss/android/socialbase/downloader/downloader/r;
    //   299: ifnonnull -> 312
    //   302: new com/ss/android/socialbase/downloader/impls/j
    //   305: dup
    //   306: invokespecial <init> : ()V
    //   309: putstatic com/ss/android/socialbase/downloader/downloader/b.t : Lcom/ss/android/socialbase/downloader/downloader/r;
    //   312: getstatic com/ss/android/socialbase/downloader/downloader/b.A : I
    //   315: ifle -> 327
    //   318: getstatic com/ss/android/socialbase/downloader/downloader/b.A : I
    //   321: getstatic com/ss/android/socialbase/downloader/downloader/b.B : I
    //   324: if_icmple -> 333
    //   327: getstatic com/ss/android/socialbase/downloader/downloader/b.B : I
    //   330: putstatic com/ss/android/socialbase/downloader/downloader/b.A : I
    //   333: invokestatic E : ()V
    //   336: getstatic com/ss/android/socialbase/downloader/downloader/b.w : Z
    //   339: ifeq -> 364
    //   342: iload_1
    //   343: ifne -> 364
    //   346: invokestatic c : ()Z
    //   349: ifne -> 364
    //   352: iconst_1
    //   353: invokestatic a : (Z)Lcom/ss/android/socialbase/downloader/downloader/n;
    //   356: invokeinterface d : ()V
    //   361: goto -> 407
    //   364: invokestatic d : ()Z
    //   367: ifeq -> 394
    //   370: invokestatic k : ()Ljava/util/concurrent/ExecutorService;
    //   373: astore_0
    //   374: aload_0
    //   375: ifnull -> 407
    //   378: aload_0
    //   379: new com/ss/android/socialbase/downloader/downloader/b$1
    //   382: dup
    //   383: invokespecial <init> : ()V
    //   386: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   391: goto -> 407
    //   394: invokestatic B : ()Landroid/content/Context;
    //   397: astore_0
    //   398: aload_0
    //   399: ifnull -> 407
    //   402: aload_0
    //   403: invokestatic c : (Landroid/content/Context;)Ljava/lang/String;
    //   406: pop
    //   407: invokestatic a : ()V
    //   410: iconst_1
    //   411: putstatic com/ss/android/socialbase/downloader/downloader/b.K : Z
    //   414: ldc com/ss/android/socialbase/downloader/downloader/b
    //   416: monitorexit
    //   417: return
    //   418: astore_0
    //   419: ldc com/ss/android/socialbase/downloader/downloader/b
    //   421: monitorexit
    //   422: aload_0
    //   423: athrow
    // Exception table:
    //   from	to	target	type
    //   3	18	418	finally
    //   22	26	418	finally
    //   30	135	418	finally
    //   135	152	418	finally
    //   152	170	418	finally
    //   170	184	418	finally
    //   184	200	418	finally
    //   200	216	418	finally
    //   216	232	418	finally
    //   232	248	418	finally
    //   248	264	418	finally
    //   264	280	418	finally
    //   280	296	418	finally
    //   296	312	418	finally
    //   312	327	418	finally
    //   327	333	418	finally
    //   333	342	418	finally
    //   346	361	418	finally
    //   364	374	418	finally
    //   378	391	418	finally
    //   394	398	418	finally
    //   402	407	418	finally
    //   407	414	418	finally
  }
  
  private static void a(h paramh) {
    if (paramh != null)
      r = paramh; 
  }
  
  private static void a(i parami) {
    if (parami != null)
      d = parami; 
  }
  
  private static void a(k paramk) {
    if (paramk != null)
      b = paramk; 
  }
  
  private static void a(l paraml) {
    if (paraml != null)
      c = paraml; 
  }
  
  public static void a(m paramm) {
    // Byte code:
    //   0: ldc com/ss/android/socialbase/downloader/downloader/b
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull -> 38
    //   7: aload_0
    //   8: putstatic com/ss/android/socialbase/downloader/downloader/b.m : Lcom/ss/android/socialbase/downloader/downloader/m;
    //   11: getstatic com/ss/android/socialbase/downloader/downloader/b.b : Lcom/ss/android/socialbase/downloader/downloader/k;
    //   14: instanceof com/ss/android/socialbase/downloader/impls/d
    //   17: ifeq -> 38
    //   20: getstatic com/ss/android/socialbase/downloader/downloader/b.b : Lcom/ss/android/socialbase/downloader/downloader/k;
    //   23: checkcast com/ss/android/socialbase/downloader/impls/d
    //   26: invokevirtual g : ()V
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/ss/android/socialbase/downloader/downloader/b
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: ldc com/ss/android/socialbase/downloader/downloader/b
    //   40: monitorexit
    //   41: return
    // Exception table:
    //   from	to	target	type
    //   7	29	32	finally
  }
  
  private static void a(d paramd) {
    if (paramd != null)
      j = paramd; 
  }
  
  private static void a(f paramf) {
    boolean bool;
    if (paramf != null)
      i = paramf; 
    if (i != null) {
      bool = true;
    } else {
      bool = false;
    } 
    F = bool;
  }
  
  public static void a(ExecutorService paramExecutorService) {
    if (paramExecutorService != null)
      q = paramExecutorService; 
  }
  
  public static void a(JSONObject paramJSONObject) {
    if (I != paramJSONObject) {
      JSONObject jSONObject = paramJSONObject;
      if (paramJSONObject == null)
        jSONObject = new JSONObject(); 
      I = jSONObject;
      a.a();
    } 
  }
  
  private static void b(ExecutorService paramExecutorService) {
    if (paramExecutorService != null)
      n = paramExecutorService; 
  }
  
  public static boolean b() {
    // Byte code:
    //   0: ldc com/ss/android/socialbase/downloader/downloader/b
    //   2: monitorenter
    //   3: getstatic com/ss/android/socialbase/downloader/downloader/b.w : Z
    //   6: istore_0
    //   7: ldc com/ss/android/socialbase/downloader/downloader/b
    //   9: monitorexit
    //   10: iload_0
    //   11: ireturn
    //   12: astore_1
    //   13: ldc com/ss/android/socialbase/downloader/downloader/b
    //   15: monitorexit
    //   16: aload_1
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static f c() {
    // Byte code:
    //   0: getstatic com/ss/android/socialbase/downloader/downloader/b.i : Lcom/ss/android/socialbase/downloader/i/f;
    //   3: ifnonnull -> 37
    //   6: ldc com/ss/android/socialbase/downloader/downloader/b
    //   8: monitorenter
    //   9: getstatic com/ss/android/socialbase/downloader/downloader/b.i : Lcom/ss/android/socialbase/downloader/i/f;
    //   12: ifnonnull -> 25
    //   15: new com/ss/android/socialbase/downloader/impls/g
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/ss/android/socialbase/downloader/downloader/b.i : Lcom/ss/android/socialbase/downloader/i/f;
    //   25: ldc com/ss/android/socialbase/downloader/downloader/b
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/ss/android/socialbase/downloader/downloader/b
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/ss/android/socialbase/downloader/downloader/b.i : Lcom/ss/android/socialbase/downloader/i/f;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private static void c(ExecutorService paramExecutorService) {
    if (paramExecutorService != null)
      o = paramExecutorService; 
  }
  
  public static List<ag> d() {
    synchronized (v) {
      return v;
    } 
  }
  
  private static void d(ExecutorService paramExecutorService) {
    if (paramExecutorService != null)
      p = paramExecutorService; 
  }
  
  public static d e() {
    // Byte code:
    //   0: getstatic com/ss/android/socialbase/downloader/downloader/b.j : Lcom/ss/android/socialbase/downloader/i/d;
    //   3: ifnonnull -> 37
    //   6: ldc com/ss/android/socialbase/downloader/downloader/b
    //   8: monitorenter
    //   9: getstatic com/ss/android/socialbase/downloader/downloader/b.j : Lcom/ss/android/socialbase/downloader/i/d;
    //   12: ifnonnull -> 25
    //   15: new com/ss/android/socialbase/downloader/impls/f
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/ss/android/socialbase/downloader/downloader/b.j : Lcom/ss/android/socialbase/downloader/i/d;
    //   25: ldc com/ss/android/socialbase/downloader/downloader/b
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/ss/android/socialbase/downloader/downloader/b
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/ss/android/socialbase/downloader/downloader/b.j : Lcom/ss/android/socialbase/downloader/i/d;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public static f f() {
    // Byte code:
    //   0: getstatic com/ss/android/socialbase/downloader/downloader/b.k : Lcom/ss/android/socialbase/downloader/i/f;
    //   3: ifnonnull -> 37
    //   6: ldc com/ss/android/socialbase/downloader/downloader/b
    //   8: monitorenter
    //   9: getstatic com/ss/android/socialbase/downloader/downloader/b.k : Lcom/ss/android/socialbase/downloader/i/f;
    //   12: ifnonnull -> 25
    //   15: new com/ss/android/socialbase/downloader/impls/g
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/ss/android/socialbase/downloader/downloader/b.k : Lcom/ss/android/socialbase/downloader/i/f;
    //   25: ldc com/ss/android/socialbase/downloader/downloader/b
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/ss/android/socialbase/downloader/downloader/b
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/ss/android/socialbase/downloader/downloader/b.k : Lcom/ss/android/socialbase/downloader/i/f;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public static d g() {
    // Byte code:
    //   0: getstatic com/ss/android/socialbase/downloader/downloader/b.l : Lcom/ss/android/socialbase/downloader/i/d;
    //   3: ifnonnull -> 37
    //   6: ldc com/ss/android/socialbase/downloader/downloader/b
    //   8: monitorenter
    //   9: getstatic com/ss/android/socialbase/downloader/downloader/b.l : Lcom/ss/android/socialbase/downloader/i/d;
    //   12: ifnonnull -> 25
    //   15: new com/ss/android/socialbase/downloader/impls/f
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/ss/android/socialbase/downloader/downloader/b.l : Lcom/ss/android/socialbase/downloader/i/d;
    //   25: ldc com/ss/android/socialbase/downloader/downloader/b
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/ss/android/socialbase/downloader/downloader/b
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/ss/android/socialbase/downloader/downloader/b.l : Lcom/ss/android/socialbase/downloader/i/d;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public static AlarmManager h() {
    // Byte code:
    //   0: getstatic com/ss/android/socialbase/downloader/downloader/b.y : Landroid/app/AlarmManager;
    //   3: ifnonnull -> 48
    //   6: ldc com/ss/android/socialbase/downloader/downloader/b
    //   8: monitorenter
    //   9: getstatic com/ss/android/socialbase/downloader/downloader/b.y : Landroid/app/AlarmManager;
    //   12: ifnonnull -> 36
    //   15: getstatic com/ss/android/socialbase/downloader/downloader/b.a : Landroid/content/Context;
    //   18: ifnull -> 36
    //   21: getstatic com/ss/android/socialbase/downloader/downloader/b.a : Landroid/content/Context;
    //   24: ldc_w 'alarm'
    //   27: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   30: checkcast android/app/AlarmManager
    //   33: putstatic com/ss/android/socialbase/downloader/downloader/b.y : Landroid/app/AlarmManager;
    //   36: ldc com/ss/android/socialbase/downloader/downloader/b
    //   38: monitorexit
    //   39: goto -> 48
    //   42: astore_0
    //   43: ldc com/ss/android/socialbase/downloader/downloader/b
    //   45: monitorexit
    //   46: aload_0
    //   47: athrow
    //   48: getstatic com/ss/android/socialbase/downloader/downloader/b.y : Landroid/app/AlarmManager;
    //   51: areturn
    // Exception table:
    //   from	to	target	type
    //   9	36	42	finally
    //   36	39	42	finally
    //   43	46	42	finally
  }
  
  public static q i() {
    // Byte code:
    //   0: ldc com/ss/android/socialbase/downloader/downloader/b
    //   2: monitorenter
    //   3: getstatic com/ss/android/socialbase/downloader/downloader/b.u : Lcom/ss/android/socialbase/downloader/downloader/q;
    //   6: astore_0
    //   7: ldc com/ss/android/socialbase/downloader/downloader/b
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/ss/android/socialbase/downloader/downloader/b
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static ExecutorService j() {
    // Byte code:
    //   0: getstatic com/ss/android/socialbase/downloader/downloader/b.n : Ljava/util/concurrent/ExecutorService;
    //   3: ifnonnull -> 82
    //   6: ldc com/ss/android/socialbase/downloader/downloader/b
    //   8: monitorenter
    //   9: getstatic com/ss/android/socialbase/downloader/downloader/b.n : Ljava/util/concurrent/ExecutorService;
    //   12: ifnonnull -> 70
    //   15: invokestatic F : ()I
    //   18: istore_0
    //   19: new java/util/concurrent/ThreadPoolExecutor
    //   22: dup
    //   23: iload_0
    //   24: iload_0
    //   25: ldc2_w 15
    //   28: getstatic java/util/concurrent/TimeUnit.SECONDS : Ljava/util/concurrent/TimeUnit;
    //   31: new java/util/concurrent/LinkedBlockingQueue
    //   34: dup
    //   35: invokespecial <init> : ()V
    //   38: new com/ss/android/socialbase/downloader/l/a
    //   41: dup
    //   42: ldc_w 'DownloadThreadPool-cpu-fixed'
    //   45: iconst_1
    //   46: invokespecial <init> : (Ljava/lang/String;Z)V
    //   49: invokespecial <init> : (IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;)V
    //   52: astore_1
    //   53: aload_1
    //   54: iconst_1
    //   55: invokevirtual allowCoreThreadTimeOut : (Z)V
    //   58: goto -> 66
    //   61: astore_2
    //   62: aload_2
    //   63: invokevirtual printStackTrace : ()V
    //   66: aload_1
    //   67: putstatic com/ss/android/socialbase/downloader/downloader/b.n : Ljava/util/concurrent/ExecutorService;
    //   70: ldc com/ss/android/socialbase/downloader/downloader/b
    //   72: monitorexit
    //   73: goto -> 82
    //   76: astore_1
    //   77: ldc com/ss/android/socialbase/downloader/downloader/b
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    //   82: getstatic com/ss/android/socialbase/downloader/downloader/b.n : Ljava/util/concurrent/ExecutorService;
    //   85: areturn
    // Exception table:
    //   from	to	target	type
    //   9	53	76	finally
    //   53	58	61	finally
    //   62	66	76	finally
    //   66	70	76	finally
    //   70	73	76	finally
    //   77	80	76	finally
  }
  
  public static ExecutorService k() {
    // Byte code:
    //   0: getstatic com/ss/android/socialbase/downloader/downloader/b.o : Ljava/util/concurrent/ExecutorService;
    //   3: ifnonnull -> 82
    //   6: ldc com/ss/android/socialbase/downloader/downloader/b
    //   8: monitorenter
    //   9: getstatic com/ss/android/socialbase/downloader/downloader/b.o : Ljava/util/concurrent/ExecutorService;
    //   12: ifnonnull -> 70
    //   15: new java/util/concurrent/ThreadPoolExecutor
    //   18: dup
    //   19: getstatic com/ss/android/socialbase/downloader/downloader/b.C : I
    //   22: getstatic com/ss/android/socialbase/downloader/downloader/b.C : I
    //   25: ldc2_w 15
    //   28: getstatic java/util/concurrent/TimeUnit.SECONDS : Ljava/util/concurrent/TimeUnit;
    //   31: new java/util/concurrent/LinkedBlockingQueue
    //   34: dup
    //   35: invokespecial <init> : ()V
    //   38: new com/ss/android/socialbase/downloader/l/a
    //   41: dup
    //   42: ldc_w 'DownloadThreadPool-io-fixed'
    //   45: iconst_1
    //   46: invokespecial <init> : (Ljava/lang/String;Z)V
    //   49: invokespecial <init> : (IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;)V
    //   52: astore_0
    //   53: aload_0
    //   54: iconst_1
    //   55: invokevirtual allowCoreThreadTimeOut : (Z)V
    //   58: goto -> 66
    //   61: astore_1
    //   62: aload_1
    //   63: invokevirtual printStackTrace : ()V
    //   66: aload_0
    //   67: putstatic com/ss/android/socialbase/downloader/downloader/b.o : Ljava/util/concurrent/ExecutorService;
    //   70: ldc com/ss/android/socialbase/downloader/downloader/b
    //   72: monitorexit
    //   73: goto -> 82
    //   76: astore_0
    //   77: ldc com/ss/android/socialbase/downloader/downloader/b
    //   79: monitorexit
    //   80: aload_0
    //   81: athrow
    //   82: getstatic com/ss/android/socialbase/downloader/downloader/b.o : Ljava/util/concurrent/ExecutorService;
    //   85: areturn
    // Exception table:
    //   from	to	target	type
    //   9	53	76	finally
    //   53	58	61	finally
    //   62	66	76	finally
    //   66	70	76	finally
    //   70	73	76	finally
    //   77	80	76	finally
  }
  
  public static ExecutorService l() {
    // Byte code:
    //   0: getstatic com/ss/android/socialbase/downloader/downloader/b.q : Ljava/util/concurrent/ExecutorService;
    //   3: ifnonnull -> 82
    //   6: ldc com/ss/android/socialbase/downloader/downloader/b
    //   8: monitorenter
    //   9: getstatic com/ss/android/socialbase/downloader/downloader/b.q : Ljava/util/concurrent/ExecutorService;
    //   12: ifnonnull -> 70
    //   15: new java/util/concurrent/ThreadPoolExecutor
    //   18: dup
    //   19: getstatic com/ss/android/socialbase/downloader/downloader/b.C : I
    //   22: getstatic com/ss/android/socialbase/downloader/downloader/b.C : I
    //   25: ldc2_w 15
    //   28: getstatic java/util/concurrent/TimeUnit.SECONDS : Ljava/util/concurrent/TimeUnit;
    //   31: new java/util/concurrent/LinkedBlockingQueue
    //   34: dup
    //   35: invokespecial <init> : ()V
    //   38: new com/ss/android/socialbase/downloader/l/a
    //   41: dup
    //   42: ldc_w 'DownloadThreadPool-chunk-fixed'
    //   45: iconst_1
    //   46: invokespecial <init> : (Ljava/lang/String;Z)V
    //   49: invokespecial <init> : (IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;)V
    //   52: astore_0
    //   53: aload_0
    //   54: iconst_1
    //   55: invokevirtual allowCoreThreadTimeOut : (Z)V
    //   58: goto -> 66
    //   61: astore_1
    //   62: aload_1
    //   63: invokevirtual printStackTrace : ()V
    //   66: aload_0
    //   67: putstatic com/ss/android/socialbase/downloader/downloader/b.q : Ljava/util/concurrent/ExecutorService;
    //   70: ldc com/ss/android/socialbase/downloader/downloader/b
    //   72: monitorexit
    //   73: goto -> 82
    //   76: astore_0
    //   77: ldc com/ss/android/socialbase/downloader/downloader/b
    //   79: monitorexit
    //   80: aload_0
    //   81: athrow
    //   82: getstatic com/ss/android/socialbase/downloader/downloader/b.q : Ljava/util/concurrent/ExecutorService;
    //   85: areturn
    // Exception table:
    //   from	to	target	type
    //   9	53	76	finally
    //   53	58	61	finally
    //   62	66	76	finally
    //   66	70	76	finally
    //   70	73	76	finally
    //   77	80	76	finally
  }
  
  public static ExecutorService m() {
    // Byte code:
    //   0: getstatic com/ss/android/socialbase/downloader/downloader/b.p : Ljava/util/concurrent/ExecutorService;
    //   3: ifnonnull -> 82
    //   6: ldc com/ss/android/socialbase/downloader/downloader/b
    //   8: monitorenter
    //   9: getstatic com/ss/android/socialbase/downloader/downloader/b.p : Ljava/util/concurrent/ExecutorService;
    //   12: ifnonnull -> 70
    //   15: new java/util/concurrent/ThreadPoolExecutor
    //   18: dup
    //   19: getstatic com/ss/android/socialbase/downloader/downloader/b.D : I
    //   22: getstatic com/ss/android/socialbase/downloader/downloader/b.D : I
    //   25: ldc2_w 15
    //   28: getstatic java/util/concurrent/TimeUnit.SECONDS : Ljava/util/concurrent/TimeUnit;
    //   31: new java/util/concurrent/LinkedBlockingQueue
    //   34: dup
    //   35: invokespecial <init> : ()V
    //   38: new com/ss/android/socialbase/downloader/l/a
    //   41: dup
    //   42: ldc_w 'DownloadThreadPool-db-fixed'
    //   45: iconst_1
    //   46: invokespecial <init> : (Ljava/lang/String;Z)V
    //   49: invokespecial <init> : (IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;)V
    //   52: astore_0
    //   53: aload_0
    //   54: iconst_1
    //   55: invokevirtual allowCoreThreadTimeOut : (Z)V
    //   58: goto -> 66
    //   61: astore_1
    //   62: aload_1
    //   63: invokevirtual printStackTrace : ()V
    //   66: aload_0
    //   67: putstatic com/ss/android/socialbase/downloader/downloader/b.p : Ljava/util/concurrent/ExecutorService;
    //   70: ldc com/ss/android/socialbase/downloader/downloader/b
    //   72: monitorexit
    //   73: goto -> 82
    //   76: astore_0
    //   77: ldc com/ss/android/socialbase/downloader/downloader/b
    //   79: monitorexit
    //   80: aload_0
    //   81: athrow
    //   82: getstatic com/ss/android/socialbase/downloader/downloader/b.p : Ljava/util/concurrent/ExecutorService;
    //   85: areturn
    // Exception table:
    //   from	to	target	type
    //   9	53	76	finally
    //   53	58	61	finally
    //   62	66	76	finally
    //   66	70	76	finally
    //   70	73	76	finally
    //   77	80	76	finally
  }
  
  public static OkHttpClient n() {
    // Byte code:
    //   0: getstatic com/ss/android/socialbase/downloader/downloader/b.x : Lokhttp3/OkHttpClient;
    //   3: ifnonnull -> 101
    //   6: ldc com/ss/android/socialbase/downloader/downloader/b
    //   8: monitorenter
    //   9: getstatic com/ss/android/socialbase/downloader/downloader/b.x : Lokhttp3/OkHttpClient;
    //   12: ifnonnull -> 89
    //   15: new okhttp3/OkHttpClient$Builder
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: astore_0
    //   23: aload_0
    //   24: ldc2_w 30000
    //   27: getstatic java/util/concurrent/TimeUnit.MILLISECONDS : Ljava/util/concurrent/TimeUnit;
    //   30: invokevirtual a : (JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;
    //   33: ldc2_w 30000
    //   36: getstatic java/util/concurrent/TimeUnit.MILLISECONDS : Ljava/util/concurrent/TimeUnit;
    //   39: invokevirtual b : (JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;
    //   42: ldc2_w 30000
    //   45: getstatic java/util/concurrent/TimeUnit.MILLISECONDS : Ljava/util/concurrent/TimeUnit;
    //   48: invokevirtual c : (JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;
    //   51: iconst_1
    //   52: invokevirtual c : (Z)Lokhttp3/OkHttpClient$Builder;
    //   55: new okhttp3/Dispatcher
    //   58: dup
    //   59: invokestatic k : ()Ljava/util/concurrent/ExecutorService;
    //   62: invokespecial <init> : (Ljava/util/concurrent/ExecutorService;)V
    //   65: invokevirtual a : (Lokhttp3/Dispatcher;)Lokhttp3/OkHttpClient$Builder;
    //   68: iconst_1
    //   69: invokevirtual b : (Z)Lokhttp3/OkHttpClient$Builder;
    //   72: getstatic okhttp3/Protocol.b : Lokhttp3/Protocol;
    //   75: invokestatic singletonList : (Ljava/lang/Object;)Ljava/util/List;
    //   78: invokevirtual a : (Ljava/util/List;)Lokhttp3/OkHttpClient$Builder;
    //   81: pop
    //   82: aload_0
    //   83: invokevirtual b : ()Lokhttp3/OkHttpClient;
    //   86: putstatic com/ss/android/socialbase/downloader/downloader/b.x : Lokhttp3/OkHttpClient;
    //   89: ldc com/ss/android/socialbase/downloader/downloader/b
    //   91: monitorexit
    //   92: goto -> 101
    //   95: astore_0
    //   96: ldc com/ss/android/socialbase/downloader/downloader/b
    //   98: monitorexit
    //   99: aload_0
    //   100: athrow
    //   101: getstatic com/ss/android/socialbase/downloader/downloader/b.x : Lokhttp3/OkHttpClient;
    //   104: areturn
    // Exception table:
    //   from	to	target	type
    //   9	89	95	finally
    //   89	92	95	finally
    //   96	99	95	finally
  }
  
  public static m o() {
    // Byte code:
    //   0: ldc com/ss/android/socialbase/downloader/downloader/b
    //   2: monitorenter
    //   3: getstatic com/ss/android/socialbase/downloader/downloader/b.m : Lcom/ss/android/socialbase/downloader/downloader/m;
    //   6: astore_0
    //   7: ldc com/ss/android/socialbase/downloader/downloader/b
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/ss/android/socialbase/downloader/downloader/b
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static k p() {
    // Byte code:
    //   0: getstatic com/ss/android/socialbase/downloader/downloader/b.b : Lcom/ss/android/socialbase/downloader/downloader/k;
    //   3: ifnonnull -> 37
    //   6: ldc com/ss/android/socialbase/downloader/downloader/b
    //   8: monitorenter
    //   9: getstatic com/ss/android/socialbase/downloader/downloader/b.b : Lcom/ss/android/socialbase/downloader/downloader/k;
    //   12: ifnonnull -> 25
    //   15: new com/ss/android/socialbase/downloader/impls/d
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/ss/android/socialbase/downloader/downloader/b.b : Lcom/ss/android/socialbase/downloader/downloader/k;
    //   25: ldc com/ss/android/socialbase/downloader/downloader/b
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/ss/android/socialbase/downloader/downloader/b
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/ss/android/socialbase/downloader/downloader/b.b : Lcom/ss/android/socialbase/downloader/downloader/k;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public static p q() {
    // Byte code:
    //   0: getstatic com/ss/android/socialbase/downloader/downloader/b.g : Lcom/ss/android/socialbase/downloader/downloader/p;
    //   3: ifnonnull -> 37
    //   6: ldc com/ss/android/socialbase/downloader/downloader/b
    //   8: monitorenter
    //   9: getstatic com/ss/android/socialbase/downloader/downloader/b.g : Lcom/ss/android/socialbase/downloader/downloader/p;
    //   12: ifnonnull -> 25
    //   15: new com/ss/android/socialbase/downloader/impls/h
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/ss/android/socialbase/downloader/downloader/b.g : Lcom/ss/android/socialbase/downloader/downloader/p;
    //   25: ldc com/ss/android/socialbase/downloader/downloader/b
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/ss/android/socialbase/downloader/downloader/b
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/ss/android/socialbase/downloader/downloader/b.g : Lcom/ss/android/socialbase/downloader/downloader/p;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public static p r() {
    // Byte code:
    //   0: getstatic com/ss/android/socialbase/downloader/downloader/b.h : Lcom/ss/android/socialbase/downloader/downloader/p;
    //   3: ifnonnull -> 37
    //   6: ldc com/ss/android/socialbase/downloader/downloader/b
    //   8: monitorenter
    //   9: getstatic com/ss/android/socialbase/downloader/downloader/b.h : Lcom/ss/android/socialbase/downloader/downloader/p;
    //   12: ifnonnull -> 25
    //   15: new com/ss/android/socialbase/downloader/impls/n
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/ss/android/socialbase/downloader/downloader/b.h : Lcom/ss/android/socialbase/downloader/downloader/p;
    //   25: ldc com/ss/android/socialbase/downloader/downloader/b
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/ss/android/socialbase/downloader/downloader/b
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/ss/android/socialbase/downloader/downloader/b.h : Lcom/ss/android/socialbase/downloader/downloader/p;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public static l s() {
    // Byte code:
    //   0: getstatic com/ss/android/socialbase/downloader/downloader/b.c : Lcom/ss/android/socialbase/downloader/downloader/l;
    //   3: ifnonnull -> 37
    //   6: ldc com/ss/android/socialbase/downloader/downloader/b
    //   8: monitorenter
    //   9: getstatic com/ss/android/socialbase/downloader/downloader/b.c : Lcom/ss/android/socialbase/downloader/downloader/l;
    //   12: ifnonnull -> 25
    //   15: new com/ss/android/socialbase/downloader/impls/i
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/ss/android/socialbase/downloader/downloader/b.c : Lcom/ss/android/socialbase/downloader/downloader/l;
    //   25: ldc com/ss/android/socialbase/downloader/downloader/b
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/ss/android/socialbase/downloader/downloader/b
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/ss/android/socialbase/downloader/downloader/b.c : Lcom/ss/android/socialbase/downloader/downloader/l;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public static a t() {
    // Byte code:
    //   0: getstatic com/ss/android/socialbase/downloader/downloader/b.f : Lcom/ss/android/socialbase/downloader/impls/a;
    //   3: ifnonnull -> 37
    //   6: ldc com/ss/android/socialbase/downloader/downloader/b
    //   8: monitorenter
    //   9: getstatic com/ss/android/socialbase/downloader/downloader/b.f : Lcom/ss/android/socialbase/downloader/impls/a;
    //   12: ifnonnull -> 25
    //   15: new com/ss/android/socialbase/downloader/impls/e
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/ss/android/socialbase/downloader/downloader/b.f : Lcom/ss/android/socialbase/downloader/impls/a;
    //   25: ldc com/ss/android/socialbase/downloader/downloader/b
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/ss/android/socialbase/downloader/downloader/b
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/ss/android/socialbase/downloader/downloader/b.f : Lcom/ss/android/socialbase/downloader/impls/a;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public static int u() {
    return H;
  }
  
  public static JSONObject v() {
    // Byte code:
    //   0: getstatic com/ss/android/socialbase/downloader/downloader/b.I : Lorg/json/JSONObject;
    //   3: ifnonnull -> 37
    //   6: ldc com/ss/android/socialbase/downloader/downloader/b
    //   8: monitorenter
    //   9: getstatic com/ss/android/socialbase/downloader/downloader/b.I : Lorg/json/JSONObject;
    //   12: ifnonnull -> 25
    //   15: new org/json/JSONObject
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/ss/android/socialbase/downloader/downloader/b.I : Lorg/json/JSONObject;
    //   25: ldc com/ss/android/socialbase/downloader/downloader/b
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/ss/android/socialbase/downloader/downloader/b
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/ss/android/socialbase/downloader/downloader/b.I : Lorg/json/JSONObject;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public static int w() {
    // Byte code:
    //   0: ldc com/ss/android/socialbase/downloader/downloader/b
    //   2: monitorenter
    //   3: getstatic com/ss/android/socialbase/downloader/downloader/b.E : I
    //   6: istore_0
    //   7: ldc com/ss/android/socialbase/downloader/downloader/b
    //   9: monitorexit
    //   10: iload_0
    //   11: ireturn
    //   12: astore_1
    //   13: ldc com/ss/android/socialbase/downloader/downloader/b
    //   15: monitorexit
    //   16: aload_1
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static i x() {
    // Byte code:
    //   0: getstatic com/ss/android/socialbase/downloader/downloader/b.d : Lcom/ss/android/socialbase/downloader/downloader/i;
    //   3: ifnonnull -> 37
    //   6: ldc com/ss/android/socialbase/downloader/downloader/b
    //   8: monitorenter
    //   9: getstatic com/ss/android/socialbase/downloader/downloader/b.d : Lcom/ss/android/socialbase/downloader/downloader/i;
    //   12: ifnonnull -> 25
    //   15: new com/ss/android/socialbase/downloader/impls/c
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/ss/android/socialbase/downloader/downloader/b.d : Lcom/ss/android/socialbase/downloader/downloader/i;
    //   25: ldc com/ss/android/socialbase/downloader/downloader/b
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/ss/android/socialbase/downloader/downloader/b
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/ss/android/socialbase/downloader/downloader/b.d : Lcom/ss/android/socialbase/downloader/downloader/i;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public static ac y() {
    return e;
  }
  
  public static h z() {
    // Byte code:
    //   0: getstatic com/ss/android/socialbase/downloader/downloader/b.r : Lcom/ss/android/socialbase/downloader/downloader/h;
    //   3: ifnonnull -> 37
    //   6: ldc com/ss/android/socialbase/downloader/downloader/b
    //   8: monitorenter
    //   9: getstatic com/ss/android/socialbase/downloader/downloader/b.r : Lcom/ss/android/socialbase/downloader/downloader/h;
    //   12: ifnonnull -> 25
    //   15: new com/ss/android/socialbase/downloader/impls/b
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/ss/android/socialbase/downloader/downloader/b.r : Lcom/ss/android/socialbase/downloader/downloader/h;
    //   25: ldc com/ss/android/socialbase/downloader/downloader/b
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/ss/android/socialbase/downloader/downloader/b
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/ss/android/socialbase/downloader/downloader/b.r : Lcom/ss/android/socialbase/downloader/downloader/h;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\downloader\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */