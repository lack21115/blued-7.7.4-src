package com.amap.api.col.s;

import android.content.Context;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Random;

public class df {
  static boolean a = false;
  
  static int b = 20;
  
  private static int c = 20;
  
  private static WeakReference<da> d;
  
  private static int e;
  
  public static void a(Context paramContext) {
    cg.c().submit(new a(paramContext, a.c));
  }
  
  public static void a(de paramde, Context paramContext) {
    // Byte code:
    //   0: ldc com/amap/api/col/s/df
    //   2: monitorenter
    //   3: invokestatic c : ()Ljava/util/concurrent/ExecutorService;
    //   6: new com/amap/api/col/s/df$a
    //   9: dup
    //   10: aload_1
    //   11: getstatic com/amap/api/col/s/df$a.a : I
    //   14: aload_0
    //   15: invokespecial <init> : (Landroid/content/Context;ILcom/amap/api/col/s/de;)V
    //   18: invokeinterface submit : (Ljava/lang/Runnable;)Ljava/util/concurrent/Future;
    //   23: pop
    //   24: ldc com/amap/api/col/s/df
    //   26: monitorexit
    //   27: return
    //   28: astore_0
    //   29: ldc com/amap/api/col/s/df
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	24	28	finally
  }
  
  public static void a(List<de> paramList, Context paramContext) {
    // Byte code:
    //   0: ldc com/amap/api/col/s/df
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull -> 52
    //   7: aload_0
    //   8: invokeinterface size : ()I
    //   13: istore_2
    //   14: iload_2
    //   15: ifne -> 21
    //   18: goto -> 52
    //   21: invokestatic c : ()Ljava/util/concurrent/ExecutorService;
    //   24: new com/amap/api/col/s/df$a
    //   27: dup
    //   28: aload_1
    //   29: getstatic com/amap/api/col/s/df$a.b : I
    //   32: aload_0
    //   33: invokespecial <init> : (Landroid/content/Context;ILjava/util/List;)V
    //   36: invokeinterface submit : (Ljava/lang/Runnable;)Ljava/util/concurrent/Future;
    //   41: pop
    //   42: ldc com/amap/api/col/s/df
    //   44: monitorexit
    //   45: return
    //   46: astore_0
    //   47: ldc com/amap/api/col/s/df
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    //   52: ldc com/amap/api/col/s/df
    //   54: monitorexit
    //   55: return
    //   56: astore_3
    //   57: goto -> 21
    // Exception table:
    //   from	to	target	type
    //   7	14	56	finally
    //   21	42	46	finally
  }
  
  static final class a implements Runnable {
    static int a = 1;
    
    static int b = 2;
    
    static int c = 3;
    
    private Context d;
    
    private de e;
    
    private int f;
    
    private List<de> g;
    
    a(Context param1Context, int param1Int) {
      this.d = param1Context;
      this.f = param1Int;
    }
    
    a(Context param1Context, int param1Int, de param1de) {
      this(param1Context, param1Int);
      this.e = param1de;
    }
    
    a(Context param1Context, int param1Int, List<de> param1List) {
      this(param1Context, param1Int);
      this.g = param1List;
    }
    
    public final void run() {
      // Byte code:
      //   0: aload_0
      //   1: getfield f : I
      //   4: istore_1
      //   5: iload_1
      //   6: iconst_1
      //   7: if_icmpne -> 84
      //   10: aload_0
      //   11: getfield d : Landroid/content/Context;
      //   14: ifnull -> 73
      //   17: aload_0
      //   18: getfield e : Lcom/amap/api/col/s/de;
      //   21: ifnonnull -> 25
      //   24: return
      //   25: ldc com/amap/api/col/s/df
      //   27: monitorenter
      //   28: aload_0
      //   29: getfield d : Landroid/content/Context;
      //   32: ifnull -> 63
      //   35: aload_0
      //   36: getfield e : Lcom/amap/api/col/s/de;
      //   39: ifnonnull -> 45
      //   42: goto -> 63
      //   45: aload_0
      //   46: getfield d : Landroid/content/Context;
      //   49: aload_0
      //   50: getfield e : Lcom/amap/api/col/s/de;
      //   53: invokevirtual a : ()[B
      //   56: invokestatic a : (Landroid/content/Context;[B)V
      //   59: ldc com/amap/api/col/s/df
      //   61: monitorexit
      //   62: return
      //   63: ldc com/amap/api/col/s/df
      //   65: monitorexit
      //   66: return
      //   67: astore_2
      //   68: ldc com/amap/api/col/s/df
      //   70: monitorexit
      //   71: aload_2
      //   72: athrow
      //   73: return
      //   74: astore_2
      //   75: aload_2
      //   76: ldc 'stm'
      //   78: ldc 'as'
      //   80: invokestatic c : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
      //   83: return
      //   84: iload_1
      //   85: iconst_2
      //   86: if_icmpne -> 289
      //   89: ldc com/amap/api/col/s/df
      //   91: monitorenter
      //   92: aload_0
      //   93: getfield g : Ljava/util/List;
      //   96: ifnull -> 269
      //   99: aload_0
      //   100: getfield d : Landroid/content/Context;
      //   103: ifnonnull -> 109
      //   106: goto -> 269
      //   109: iconst_0
      //   110: newarray byte
      //   112: astore_3
      //   113: new java/io/ByteArrayOutputStream
      //   116: dup
      //   117: invokespecial <init> : ()V
      //   120: astore #4
      //   122: aload_0
      //   123: getfield g : Ljava/util/List;
      //   126: invokeinterface iterator : ()Ljava/util/Iterator;
      //   131: astore_2
      //   132: aload_2
      //   133: invokeinterface hasNext : ()Z
      //   138: ifeq -> 170
      //   141: aload_2
      //   142: invokeinterface next : ()Ljava/lang/Object;
      //   147: checkcast com/amap/api/col/s/de
      //   150: astore #5
      //   152: aload #5
      //   154: ifnull -> 132
      //   157: aload #4
      //   159: aload #5
      //   161: invokevirtual a : ()[B
      //   164: invokevirtual write : ([B)V
      //   167: goto -> 132
      //   170: aload #4
      //   172: invokevirtual toByteArray : ()[B
      //   175: astore_2
      //   176: aload #4
      //   178: invokevirtual close : ()V
      //   181: goto -> 236
      //   184: astore_3
      //   185: aload_3
      //   186: astore #4
      //   188: aload #4
      //   190: invokevirtual printStackTrace : ()V
      //   193: goto -> 236
      //   196: astore_2
      //   197: goto -> 204
      //   200: astore_2
      //   201: aconst_null
      //   202: astore #4
      //   204: aload_2
      //   205: ldc 'stm'
      //   207: ldc 'aStB'
      //   209: invokestatic c : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
      //   212: aload_3
      //   213: astore_2
      //   214: aload #4
      //   216: ifnull -> 236
      //   219: aload #4
      //   221: invokevirtual close : ()V
      //   224: aload_3
      //   225: astore_2
      //   226: goto -> 236
      //   229: astore #4
      //   231: aload_3
      //   232: astore_2
      //   233: goto -> 188
      //   236: aload_0
      //   237: getfield d : Landroid/content/Context;
      //   240: aload_2
      //   241: invokestatic a : (Landroid/content/Context;[B)V
      //   244: ldc com/amap/api/col/s/df
      //   246: monitorexit
      //   247: return
      //   248: astore_2
      //   249: aload #4
      //   251: ifnull -> 267
      //   254: aload #4
      //   256: invokevirtual close : ()V
      //   259: goto -> 267
      //   262: astore_3
      //   263: aload_3
      //   264: invokevirtual printStackTrace : ()V
      //   267: aload_2
      //   268: athrow
      //   269: ldc com/amap/api/col/s/df
      //   271: monitorexit
      //   272: return
      //   273: astore_2
      //   274: ldc com/amap/api/col/s/df
      //   276: monitorexit
      //   277: aload_2
      //   278: athrow
      //   279: astore_2
      //   280: aload_2
      //   281: ldc 'stm'
      //   283: ldc 'apb'
      //   285: invokestatic c : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
      //   288: return
      //   289: iload_1
      //   290: iconst_3
      //   291: if_icmpne -> 492
      //   294: aload_0
      //   295: getfield d : Landroid/content/Context;
      //   298: ifnonnull -> 302
      //   301: return
      //   302: invokestatic a : ()Ljava/lang/ref/WeakReference;
      //   305: invokestatic a : (Ljava/lang/ref/WeakReference;)Lcom/amap/api/col/s/da;
      //   308: astore_2
      //   309: aload_0
      //   310: getfield d : Landroid/content/Context;
      //   313: aload_2
      //   314: getstatic com/amap/api/col/s/ce.h : Ljava/lang/String;
      //   317: sipush #1000
      //   320: ldc 307200
      //   322: ldc '2'
      //   324: invokestatic a : (Landroid/content/Context;Lcom/amap/api/col/s/da;Ljava/lang/String;IILjava/lang/String;)V
      //   327: aload_2
      //   328: getfield g : Lcom/amap/api/col/s/dn;
      //   331: ifnonnull -> 377
      //   334: aload_2
      //   335: new com/amap/api/col/s/dh
      //   338: dup
      //   339: new com/amap/api/col/s/dl
      //   342: dup
      //   343: aload_0
      //   344: getfield d : Landroid/content/Context;
      //   347: new com/amap/api/col/s/di
      //   350: dup
      //   351: new com/amap/api/col/s/dm
      //   354: dup
      //   355: new com/amap/api/col/s/do
      //   358: dup
      //   359: invokespecial <init> : ()V
      //   362: invokespecial <init> : (Lcom/amap/api/col/s/dn;)V
      //   365: invokespecial <init> : (Lcom/amap/api/col/s/dn;)V
      //   368: invokespecial <init> : (Landroid/content/Context;Lcom/amap/api/col/s/dn;)V
      //   371: invokespecial <init> : (Lcom/amap/api/col/s/dn;)V
      //   374: putfield g : Lcom/amap/api/col/s/dn;
      //   377: aload_2
      //   378: ldc 3600000
      //   380: putfield h : I
      //   383: aload_2
      //   384: getfield i : Ljava/lang/String;
      //   387: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   390: ifeq -> 399
      //   393: aload_2
      //   394: ldc 'cKey'
      //   396: putfield i : Ljava/lang/String;
      //   399: aload_2
      //   400: getfield f : Lcom/amap/api/col/s/dt;
      //   403: ifnonnull -> 477
      //   406: aload_2
      //   407: new com/amap/api/col/s/ds
      //   410: dup
      //   411: aload_0
      //   412: getfield d : Landroid/content/Context;
      //   415: aload_2
      //   416: getfield h : I
      //   419: aload_2
      //   420: getfield i : Ljava/lang/String;
      //   423: new com/amap/api/col/s/dp
      //   426: dup
      //   427: aload_2
      //   428: getfield a : Ljava/lang/String;
      //   431: new com/amap/api/col/s/dq
      //   434: dup
      //   435: aload_0
      //   436: getfield d : Landroid/content/Context;
      //   439: getstatic com/amap/api/col/s/df.a : Z
      //   442: invokestatic b : ()I
      //   445: sipush #1024
      //   448: imul
      //   449: getstatic com/amap/api/col/s/df.b : I
      //   452: sipush #1024
      //   455: imul
      //   456: ldc 'staticUpdate'
      //   458: invokestatic c : ()I
      //   461: sipush #1024
      //   464: imul
      //   465: invokespecial <init> : (Landroid/content/Context;ZIILjava/lang/String;I)V
      //   468: invokespecial <init> : (Ljava/lang/String;Lcom/amap/api/col/s/dt;)V
      //   471: invokespecial <init> : (Landroid/content/Context;ILjava/lang/String;Lcom/amap/api/col/s/dt;)V
      //   474: putfield f : Lcom/amap/api/col/s/dt;
      //   477: aload_2
      //   478: invokestatic a : (Lcom/amap/api/col/s/da;)I
      //   481: pop
      //   482: return
      //   483: astore_2
      //   484: aload_2
      //   485: ldc 'stm'
      //   487: ldc 'usd'
      //   489: invokestatic c : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
      //   492: return
      // Exception table:
      //   from	to	target	type
      //   10	24	74	finally
      //   25	28	74	finally
      //   28	42	67	finally
      //   45	62	67	finally
      //   63	66	67	finally
      //   68	71	67	finally
      //   71	73	74	finally
      //   89	92	279	finally
      //   92	106	273	finally
      //   109	113	273	finally
      //   113	122	200	finally
      //   122	132	196	finally
      //   132	152	196	finally
      //   157	167	196	finally
      //   170	176	196	finally
      //   176	181	184	finally
      //   188	193	273	finally
      //   204	212	248	finally
      //   219	224	229	finally
      //   236	247	273	finally
      //   254	259	262	finally
      //   263	267	273	finally
      //   267	269	273	finally
      //   269	272	273	finally
      //   274	277	273	finally
      //   277	279	279	finally
      //   294	301	483	finally
      //   302	377	483	finally
      //   377	399	483	finally
      //   399	477	483	finally
      //   477	482	483	finally
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\df.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */