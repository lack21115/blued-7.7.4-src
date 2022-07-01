package com.bytedance.embedapplog.a;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.b.h;
import com.bytedance.embedapplog.b.i;
import com.bytedance.embedapplog.d.f;
import com.bytedance.embedapplog.d.h;
import com.bytedance.embedapplog.d.j;
import java.util.ArrayList;

public class k {
  private static long f;
  
  private static a o;
  
  String a;
  
  private final h b;
  
  private final i c;
  
  private h d;
  
  private h e;
  
  private long g;
  
  private int h;
  
  private long i = -1L;
  
  private volatile boolean j;
  
  private long k;
  
  private int l;
  
  private String m;
  
  private f n;
  
  k(i parami, h paramh) {
    this.c = parami;
    this.b = paramh;
  }
  
  public static long a(h paramh) {
    long l = ++f;
    if (l % 1000L == 0L)
      paramh.a(l + 1000L); 
    return f;
  }
  
  private void a(com.bytedance.embedapplog.d.a parama, ArrayList<com.bytedance.embedapplog.d.a> paramArrayList, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: instanceof com/bytedance/embedapplog/a/k$a
    //   6: ifeq -> 17
    //   9: ldc2_w -1
    //   12: lstore #4
    //   14: goto -> 23
    //   17: aload_1
    //   18: getfield a : J
    //   21: lstore #4
    //   23: aload_0
    //   24: invokestatic randomUUID : ()Ljava/util/UUID;
    //   27: invokevirtual toString : ()Ljava/lang/String;
    //   30: putfield a : Ljava/lang/String;
    //   33: aload_0
    //   34: getfield b : Lcom/bytedance/embedapplog/b/h;
    //   37: invokevirtual F : ()J
    //   40: putstatic com/bytedance/embedapplog/a/k.f : J
    //   43: aload_0
    //   44: lload #4
    //   46: putfield i : J
    //   49: aload_0
    //   50: iload_3
    //   51: putfield j : Z
    //   54: aload_0
    //   55: lconst_0
    //   56: putfield k : J
    //   59: getstatic com/bytedance/embedapplog/util/h.b : Z
    //   62: ifeq -> 131
    //   65: new java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial <init> : ()V
    //   72: astore #6
    //   74: aload #6
    //   76: ldc 'startSession, '
    //   78: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload #6
    //   84: aload_0
    //   85: getfield a : Ljava/lang/String;
    //   88: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload #6
    //   94: ldc ', hadUi:'
    //   96: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload #6
    //   102: iload_3
    //   103: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload #6
    //   109: ldc ' data:'
    //   111: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload #6
    //   117: aload_1
    //   118: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload #6
    //   124: invokevirtual toString : ()Ljava/lang/String;
    //   127: aconst_null
    //   128: invokestatic a : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   131: iload_3
    //   132: ifeq -> 278
    //   135: invokestatic getInstance : ()Ljava/util/Calendar;
    //   138: astore_1
    //   139: new java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial <init> : ()V
    //   146: astore #6
    //   148: aload #6
    //   150: ldc ''
    //   152: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload #6
    //   158: aload_1
    //   159: iconst_1
    //   160: invokevirtual get : (I)I
    //   163: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload #6
    //   169: aload_1
    //   170: iconst_2
    //   171: invokevirtual get : (I)I
    //   174: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload #6
    //   180: aload_1
    //   181: iconst_5
    //   182: invokevirtual get : (I)I
    //   185: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload #6
    //   191: invokevirtual toString : ()Ljava/lang/String;
    //   194: astore_1
    //   195: aload_0
    //   196: getfield m : Ljava/lang/String;
    //   199: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   202: ifeq -> 227
    //   205: aload_0
    //   206: aload_0
    //   207: getfield b : Lcom/bytedance/embedapplog/b/h;
    //   210: invokevirtual b : ()Ljava/lang/String;
    //   213: putfield m : Ljava/lang/String;
    //   216: aload_0
    //   217: aload_0
    //   218: getfield b : Lcom/bytedance/embedapplog/b/h;
    //   221: invokevirtual c : ()I
    //   224: putfield l : I
    //   227: aload_1
    //   228: aload_0
    //   229: getfield m : Ljava/lang/String;
    //   232: invokevirtual equals : (Ljava/lang/Object;)Z
    //   235: ifne -> 251
    //   238: aload_0
    //   239: aload_1
    //   240: putfield m : Ljava/lang/String;
    //   243: aload_0
    //   244: iconst_1
    //   245: putfield l : I
    //   248: goto -> 261
    //   251: aload_0
    //   252: aload_0
    //   253: getfield l : I
    //   256: iconst_1
    //   257: iadd
    //   258: putfield l : I
    //   261: aload_0
    //   262: getfield b : Lcom/bytedance/embedapplog/b/h;
    //   265: aload_1
    //   266: aload_0
    //   267: getfield l : I
    //   270: invokevirtual a : (Ljava/lang/String;I)V
    //   273: aload_0
    //   274: iconst_0
    //   275: putfield h : I
    //   278: lload #4
    //   280: ldc2_w -1
    //   283: lcmp
    //   284: ifeq -> 430
    //   287: new com/bytedance/embedapplog/d/f
    //   290: dup
    //   291: invokespecial <init> : ()V
    //   294: astore_1
    //   295: aload_1
    //   296: aload_0
    //   297: getfield a : Ljava/lang/String;
    //   300: putfield c : Ljava/lang/String;
    //   303: aload_1
    //   304: aload_0
    //   305: getfield b : Lcom/bytedance/embedapplog/b/h;
    //   308: invokestatic a : (Lcom/bytedance/embedapplog/b/h;)J
    //   311: putfield b : J
    //   314: aload_1
    //   315: aload_0
    //   316: getfield i : J
    //   319: putfield a : J
    //   322: aload_1
    //   323: aload_0
    //   324: getfield c : Lcom/bytedance/embedapplog/b/i;
    //   327: invokevirtual d : ()Ljava/lang/String;
    //   330: putfield i : Ljava/lang/String;
    //   333: aload_1
    //   334: aload_0
    //   335: getfield c : Lcom/bytedance/embedapplog/b/i;
    //   338: invokevirtual c : ()I
    //   341: putfield h : I
    //   344: aload_0
    //   345: getfield b : Lcom/bytedance/embedapplog/b/h;
    //   348: invokevirtual y : ()Z
    //   351: ifeq -> 368
    //   354: aload_1
    //   355: invokestatic getAbConfigVersion : ()Ljava/lang/String;
    //   358: putfield e : Ljava/lang/String;
    //   361: aload_1
    //   362: invokestatic getAbSDKVersion : ()Ljava/lang/String;
    //   365: putfield f : Ljava/lang/String;
    //   368: aload_2
    //   369: aload_1
    //   370: invokevirtual add : (Ljava/lang/Object;)Z
    //   373: pop
    //   374: aload_0
    //   375: aload_1
    //   376: putfield n : Lcom/bytedance/embedapplog/d/f;
    //   379: getstatic com/bytedance/embedapplog/util/h.b : Z
    //   382: ifeq -> 430
    //   385: new java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial <init> : ()V
    //   392: astore_2
    //   393: aload_2
    //   394: ldc 'gen launch, '
    //   396: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: aload_2
    //   401: aload_1
    //   402: getfield c : Ljava/lang/String;
    //   405: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: aload_2
    //   410: ldc ', hadUi:'
    //   412: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: aload_2
    //   417: iload_3
    //   418: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: aload_2
    //   423: invokevirtual toString : ()Ljava/lang/String;
    //   426: aconst_null
    //   427: invokestatic a : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   430: aload_0
    //   431: monitorexit
    //   432: return
    //   433: astore_1
    //   434: aload_0
    //   435: monitorexit
    //   436: aload_1
    //   437: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	433	finally
    //   17	23	433	finally
    //   23	131	433	finally
    //   135	227	433	finally
    //   227	248	433	finally
    //   251	261	433	finally
    //   261	278	433	finally
    //   287	368	433	finally
    //   368	430	433	finally
  }
  
  public static boolean a(com.bytedance.embedapplog.d.a parama) {
    return (parama instanceof h) ? ((h)parama).i() : false;
  }
  
  static a d() {
    if (o == null)
      o = new a(); 
    o.a = System.currentTimeMillis();
    return o;
  }
  
  Bundle a(long paramLong1, long paramLong2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore #7
    //   5: aload #7
    //   7: astore #6
    //   9: aload_0
    //   10: getfield b : Lcom/bytedance/embedapplog/b/h;
    //   13: invokevirtual e : ()Z
    //   16: ifeq -> 124
    //   19: aload #7
    //   21: astore #6
    //   23: aload_0
    //   24: invokevirtual c : ()Z
    //   27: ifeq -> 124
    //   30: aload #7
    //   32: astore #6
    //   34: lload_1
    //   35: aload_0
    //   36: getfield g : J
    //   39: lsub
    //   40: lload_3
    //   41: lcmp
    //   42: ifle -> 124
    //   45: new android/os/Bundle
    //   48: dup
    //   49: invokespecial <init> : ()V
    //   52: astore #6
    //   54: aload #6
    //   56: ldc 'session_no'
    //   58: aload_0
    //   59: getfield l : I
    //   62: invokevirtual putInt : (Ljava/lang/String;I)V
    //   65: aload_0
    //   66: getfield h : I
    //   69: iconst_1
    //   70: iadd
    //   71: istore #5
    //   73: aload_0
    //   74: iload #5
    //   76: putfield h : I
    //   79: aload #6
    //   81: ldc 'send_times'
    //   83: iload #5
    //   85: invokevirtual putInt : (Ljava/lang/String;I)V
    //   88: aload #6
    //   90: ldc 'current_duration'
    //   92: lload_1
    //   93: aload_0
    //   94: getfield g : J
    //   97: lsub
    //   98: ldc2_w 1000
    //   101: ldiv
    //   102: invokevirtual putLong : (Ljava/lang/String;J)V
    //   105: aload #6
    //   107: ldc 'session_start_time'
    //   109: aload_0
    //   110: getfield i : J
    //   113: invokestatic a : (J)Ljava/lang/String;
    //   116: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   119: aload_0
    //   120: lload_1
    //   121: putfield g : J
    //   124: aload_0
    //   125: monitorexit
    //   126: aload #6
    //   128: areturn
    //   129: astore #6
    //   131: aload_0
    //   132: monitorexit
    //   133: aload #6
    //   135: athrow
    // Exception table:
    //   from	to	target	type
    //   9	19	129	finally
    //   23	30	129	finally
    //   34	124	129	finally
  }
  
  f a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield n : Lcom/bytedance/embedapplog/d/f;
    //   6: astore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_1
    //   10: areturn
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  boolean a(com.bytedance.embedapplog.d.a parama, ArrayList<com.bytedance.embedapplog.d.a> paramArrayList) {
    boolean bool1 = parama instanceof h;
    boolean bool2 = a(parama);
    long l = this.i;
    boolean bool = true;
    if (l == -1L) {
      a(parama, paramArrayList, a(parama));
    } else if (!this.j && bool2) {
      a(parama, paramArrayList, true);
    } else if (this.k != 0L && parama.a > this.k + this.b.A()) {
      a(parama, paramArrayList, bool2);
    } else if (this.i > parama.a + 7200000L) {
      a(parama, paramArrayList, bool2);
    } else {
      bool = false;
    } 
    if (bool1) {
      h h1 = (h)parama;
      if (h1.i()) {
        this.g = parama.a;
        this.k = 0L;
        paramArrayList.add(parama);
        if (TextUtils.isEmpty(h1.i))
          if (this.e != null && h1.a - this.e.a - this.e.h < 500L) {
            h1.i = this.e.j;
          } else if (this.d != null && h1.a - this.d.a - this.d.h < 500L) {
            h1.i = this.d.j;
          }  
      } else {
        Bundle bundle = a(parama.a, 0L);
        if (bundle != null)
          AppLog.onEventV3("play_session", bundle); 
        this.g = 0L;
        this.k = h1.a;
        paramArrayList.add(parama);
        if (h1.j()) {
          this.d = h1;
        } else {
          this.e = h1;
          this.d = null;
        } 
      } 
    } else if (!(parama instanceof a)) {
      paramArrayList.add(parama);
    } 
    b(parama);
    return bool;
  }
  
  public void b(com.bytedance.embedapplog.d.a parama) {
    if (parama != null) {
      parama.d = this.c.f();
      parama.c = this.a;
      parama.b = a(this.b);
      if (this.b.y()) {
        parama.e = AppLog.getAbConfigVersion();
        parama.f = AppLog.getAbSDKVersion();
      } 
    } 
  }
  
  public boolean b() {
    return this.j;
  }
  
  boolean c() {
    return (b() && this.k == 0L);
  }
  
  static class a extends j {
    private a() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */