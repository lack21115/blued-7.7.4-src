package com.loc;

import android.content.Context;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Random;

public class bc {
  static boolean a = false;
  
  static int b = 20;
  
  private static int c = 20;
  
  private static WeakReference<ax> d;
  
  private static int e;
  
  public static void a(Context paramContext) {
    ab.d().submit(new a(paramContext, a.c));
  }
  
  public static void a(bb parambb, Context paramContext) {
    // Byte code:
    //   0: ldc com/loc/bc
    //   2: monitorenter
    //   3: invokestatic d : ()Ljava/util/concurrent/ExecutorService;
    //   6: new com/loc/bc$a
    //   9: dup
    //   10: aload_1
    //   11: getstatic com/loc/bc$a.a : I
    //   14: aload_0
    //   15: invokespecial <init> : (Landroid/content/Context;ILcom/loc/bb;)V
    //   18: invokeinterface submit : (Ljava/lang/Runnable;)Ljava/util/concurrent/Future;
    //   23: pop
    //   24: ldc com/loc/bc
    //   26: monitorexit
    //   27: return
    //   28: astore_0
    //   29: ldc com/loc/bc
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	24	28	finally
  }
  
  public static void a(List<bb> paramList, Context paramContext) {
    // Byte code:
    //   0: ldc com/loc/bc
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull -> 52
    //   7: aload_0
    //   8: invokeinterface size : ()I
    //   13: istore_2
    //   14: iload_2
    //   15: ifne -> 21
    //   18: goto -> 52
    //   21: invokestatic d : ()Ljava/util/concurrent/ExecutorService;
    //   24: new com/loc/bc$a
    //   27: dup
    //   28: aload_1
    //   29: getstatic com/loc/bc$a.b : I
    //   32: aload_0
    //   33: invokespecial <init> : (Landroid/content/Context;ILjava/util/List;)V
    //   36: invokeinterface submit : (Ljava/lang/Runnable;)Ljava/util/concurrent/Future;
    //   41: pop
    //   42: ldc com/loc/bc
    //   44: monitorexit
    //   45: return
    //   46: astore_0
    //   47: ldc com/loc/bc
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    //   52: ldc com/loc/bc
    //   54: monitorexit
    //   55: return
    //   56: astore_3
    //   57: goto -> 21
    // Exception table:
    //   from	to	target	type
    //   7	14	56	finally
    //   21	42	46	finally
  }
  
  public static void a(boolean paramBoolean, int paramInt) {
    // Byte code:
    //   0: ldc com/loc/bc
    //   2: monitorenter
    //   3: iload_0
    //   4: putstatic com/loc/bc.a : Z
    //   7: iconst_0
    //   8: iload_1
    //   9: invokestatic max : (II)I
    //   12: putstatic com/loc/bc.e : I
    //   15: ldc com/loc/bc
    //   17: monitorexit
    //   18: return
    //   19: astore_2
    //   20: ldc com/loc/bc
    //   22: monitorexit
    //   23: aload_2
    //   24: athrow
    // Exception table:
    //   from	to	target	type
    //   3	15	19	finally
  }
  
  public static void b(List<bb> paramList, Context paramContext) {
    // Byte code:
    //   0: ldc com/loc/bc
    //   2: monitorenter
    //   3: invokestatic b : ()Ljava/util/List;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull -> 28
    //   11: aload_2
    //   12: invokeinterface size : ()I
    //   17: ifle -> 28
    //   20: aload_0
    //   21: aload_2
    //   22: invokeinterface addAll : (Ljava/util/Collection;)Z
    //   27: pop
    //   28: aload_0
    //   29: aload_1
    //   30: invokestatic a : (Ljava/util/List;Landroid/content/Context;)V
    //   33: ldc com/loc/bc
    //   35: monitorexit
    //   36: return
    //   37: astore_0
    //   38: ldc com/loc/bc
    //   40: monitorexit
    //   41: aload_0
    //   42: athrow
    //   43: astore_2
    //   44: goto -> 28
    // Exception table:
    //   from	to	target	type
    //   3	7	43	finally
    //   11	28	43	finally
    //   28	33	37	finally
  }
  
  static final class a implements Runnable {
    static int a = 1;
    
    static int b = 2;
    
    static int c = 3;
    
    private Context d;
    
    private bb e;
    
    private int f;
    
    private List<bb> g;
    
    a(Context param1Context, int param1Int) {
      this.d = param1Context;
      this.f = param1Int;
    }
    
    a(Context param1Context, int param1Int, bb param1bb) {
      this(param1Context, param1Int);
      this.e = param1bb;
    }
    
    a(Context param1Context, int param1Int, List<bb> param1List) {
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
      //   7: if_icmpne -> 86
      //   10: aload_0
      //   11: getfield d : Landroid/content/Context;
      //   14: ifnull -> 73
      //   17: aload_0
      //   18: getfield e : Lcom/loc/bb;
      //   21: ifnonnull -> 25
      //   24: return
      //   25: ldc com/loc/bc
      //   27: monitorenter
      //   28: aload_0
      //   29: getfield d : Landroid/content/Context;
      //   32: ifnull -> 63
      //   35: aload_0
      //   36: getfield e : Lcom/loc/bb;
      //   39: ifnonnull -> 45
      //   42: goto -> 63
      //   45: aload_0
      //   46: getfield d : Landroid/content/Context;
      //   49: aload_0
      //   50: getfield e : Lcom/loc/bb;
      //   53: invokevirtual a : ()[B
      //   56: invokestatic a : (Landroid/content/Context;[B)V
      //   59: ldc com/loc/bc
      //   61: monitorexit
      //   62: return
      //   63: ldc com/loc/bc
      //   65: monitorexit
      //   66: return
      //   67: astore_2
      //   68: ldc com/loc/bc
      //   70: monitorexit
      //   71: aload_2
      //   72: athrow
      //   73: return
      //   74: astore_2
      //   75: ldc 'as'
      //   77: astore_3
      //   78: aload_2
      //   79: ldc 'stm'
      //   81: aload_3
      //   82: invokestatic b : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
      //   85: return
      //   86: iload_1
      //   87: iconst_2
      //   88: if_icmpne -> 288
      //   91: ldc com/loc/bc
      //   93: monitorenter
      //   94: aload_0
      //   95: getfield g : Ljava/util/List;
      //   98: ifnull -> 271
      //   101: aload_0
      //   102: getfield d : Landroid/content/Context;
      //   105: ifnonnull -> 111
      //   108: goto -> 271
      //   111: iconst_0
      //   112: newarray byte
      //   114: astore_3
      //   115: new java/io/ByteArrayOutputStream
      //   118: dup
      //   119: invokespecial <init> : ()V
      //   122: astore #4
      //   124: aload_0
      //   125: getfield g : Ljava/util/List;
      //   128: invokeinterface iterator : ()Ljava/util/Iterator;
      //   133: astore_2
      //   134: aload_2
      //   135: invokeinterface hasNext : ()Z
      //   140: ifeq -> 172
      //   143: aload_2
      //   144: invokeinterface next : ()Ljava/lang/Object;
      //   149: checkcast com/loc/bb
      //   152: astore #5
      //   154: aload #5
      //   156: ifnull -> 134
      //   159: aload #4
      //   161: aload #5
      //   163: invokevirtual a : ()[B
      //   166: invokevirtual write : ([B)V
      //   169: goto -> 134
      //   172: aload #4
      //   174: invokevirtual toByteArray : ()[B
      //   177: astore_2
      //   178: aload #4
      //   180: invokevirtual close : ()V
      //   183: goto -> 238
      //   186: astore_3
      //   187: aload_3
      //   188: astore #4
      //   190: aload #4
      //   192: invokevirtual printStackTrace : ()V
      //   195: goto -> 238
      //   198: astore_2
      //   199: goto -> 206
      //   202: astore_2
      //   203: aconst_null
      //   204: astore #4
      //   206: aload_2
      //   207: ldc 'stm'
      //   209: ldc 'aStB'
      //   211: invokestatic b : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
      //   214: aload_3
      //   215: astore_2
      //   216: aload #4
      //   218: ifnull -> 238
      //   221: aload #4
      //   223: invokevirtual close : ()V
      //   226: aload_3
      //   227: astore_2
      //   228: goto -> 238
      //   231: astore #4
      //   233: aload_3
      //   234: astore_2
      //   235: goto -> 190
      //   238: aload_0
      //   239: getfield d : Landroid/content/Context;
      //   242: aload_2
      //   243: invokestatic a : (Landroid/content/Context;[B)V
      //   246: ldc com/loc/bc
      //   248: monitorexit
      //   249: return
      //   250: astore_2
      //   251: aload #4
      //   253: ifnull -> 269
      //   256: aload #4
      //   258: invokevirtual close : ()V
      //   261: goto -> 269
      //   264: astore_3
      //   265: aload_3
      //   266: invokevirtual printStackTrace : ()V
      //   269: aload_2
      //   270: athrow
      //   271: ldc com/loc/bc
      //   273: monitorexit
      //   274: return
      //   275: astore_2
      //   276: ldc com/loc/bc
      //   278: monitorexit
      //   279: aload_2
      //   280: athrow
      //   281: astore_2
      //   282: ldc 'apb'
      //   284: astore_3
      //   285: goto -> 78
      //   288: iload_1
      //   289: iconst_3
      //   290: if_icmpne -> 491
      //   293: aload_0
      //   294: getfield d : Landroid/content/Context;
      //   297: ifnonnull -> 301
      //   300: return
      //   301: invokestatic a : ()Ljava/lang/ref/WeakReference;
      //   304: invokestatic a : (Ljava/lang/ref/WeakReference;)Lcom/loc/ax;
      //   307: astore_2
      //   308: aload_0
      //   309: getfield d : Landroid/content/Context;
      //   312: aload_2
      //   313: getstatic com/loc/z.h : Ljava/lang/String;
      //   316: sipush #1000
      //   319: ldc 307200
      //   321: ldc '2'
      //   323: invokestatic a : (Landroid/content/Context;Lcom/loc/ax;Ljava/lang/String;IILjava/lang/String;)V
      //   326: aload_2
      //   327: getfield g : Lcom/loc/bk;
      //   330: ifnonnull -> 376
      //   333: aload_2
      //   334: new com/loc/be
      //   337: dup
      //   338: new com/loc/bi
      //   341: dup
      //   342: aload_0
      //   343: getfield d : Landroid/content/Context;
      //   346: new com/loc/bf
      //   349: dup
      //   350: new com/loc/bj
      //   353: dup
      //   354: new com/loc/bl
      //   357: dup
      //   358: invokespecial <init> : ()V
      //   361: invokespecial <init> : (Lcom/loc/bk;)V
      //   364: invokespecial <init> : (Lcom/loc/bk;)V
      //   367: invokespecial <init> : (Landroid/content/Context;Lcom/loc/bk;)V
      //   370: invokespecial <init> : (Lcom/loc/bk;)V
      //   373: putfield g : Lcom/loc/bk;
      //   376: aload_2
      //   377: ldc 3600000
      //   379: putfield h : I
      //   382: aload_2
      //   383: getfield i : Ljava/lang/String;
      //   386: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   389: ifeq -> 398
      //   392: aload_2
      //   393: ldc 'cKey'
      //   395: putfield i : Ljava/lang/String;
      //   398: aload_2
      //   399: getfield f : Lcom/loc/bq;
      //   402: ifnonnull -> 476
      //   405: aload_2
      //   406: new com/loc/bp
      //   409: dup
      //   410: aload_0
      //   411: getfield d : Landroid/content/Context;
      //   414: aload_2
      //   415: getfield h : I
      //   418: aload_2
      //   419: getfield i : Ljava/lang/String;
      //   422: new com/loc/bm
      //   425: dup
      //   426: aload_2
      //   427: getfield a : Ljava/lang/String;
      //   430: new com/loc/bn
      //   433: dup
      //   434: aload_0
      //   435: getfield d : Landroid/content/Context;
      //   438: getstatic com/loc/bc.a : Z
      //   441: invokestatic b : ()I
      //   444: sipush #1024
      //   447: imul
      //   448: getstatic com/loc/bc.b : I
      //   451: sipush #1024
      //   454: imul
      //   455: ldc 'staticUpdate'
      //   457: invokestatic c : ()I
      //   460: sipush #1024
      //   463: imul
      //   464: invokespecial <init> : (Landroid/content/Context;ZIILjava/lang/String;I)V
      //   467: invokespecial <init> : (Ljava/lang/String;Lcom/loc/bq;)V
      //   470: invokespecial <init> : (Landroid/content/Context;ILjava/lang/String;Lcom/loc/bq;)V
      //   473: putfield f : Lcom/loc/bq;
      //   476: aload_2
      //   477: invokestatic a : (Lcom/loc/ax;)I
      //   480: pop
      //   481: return
      //   482: astore_2
      //   483: aload_2
      //   484: ldc 'stm'
      //   486: ldc 'usd'
      //   488: invokestatic b : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
      //   491: return
      // Exception table:
      //   from	to	target	type
      //   10	24	74	finally
      //   25	28	74	finally
      //   28	42	67	finally
      //   45	62	67	finally
      //   63	66	67	finally
      //   68	71	67	finally
      //   71	73	74	finally
      //   91	94	281	finally
      //   94	108	275	finally
      //   111	115	275	finally
      //   115	124	202	finally
      //   124	134	198	finally
      //   134	154	198	finally
      //   159	169	198	finally
      //   172	178	198	finally
      //   178	183	186	finally
      //   190	195	275	finally
      //   206	214	250	finally
      //   221	226	231	finally
      //   238	249	275	finally
      //   256	261	264	finally
      //   265	269	275	finally
      //   269	271	275	finally
      //   271	274	275	finally
      //   276	279	275	finally
      //   279	281	281	finally
      //   293	300	482	finally
      //   301	376	482	finally
      //   376	398	482	finally
      //   398	476	482	finally
      //   476	481	482	finally
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */