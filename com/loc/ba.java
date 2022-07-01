package com.loc;

import android.content.Context;
import java.lang.ref.WeakReference;

public class ba {
  static int a = 1000;
  
  static boolean b = false;
  
  static int c = 20;
  
  static int d = 0;
  
  private static WeakReference<ax> e;
  
  private static int f = 10;
  
  public static void a(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3) {
    // Byte code:
    //   0: ldc com/loc/ba
    //   2: monitorenter
    //   3: iload_0
    //   4: putstatic com/loc/ba.a : I
    //   7: iload_1
    //   8: putstatic com/loc/ba.b : Z
    //   11: iload_2
    //   12: bipush #10
    //   14: if_icmplt -> 65
    //   17: iload_2
    //   18: istore_0
    //   19: iload_2
    //   20: bipush #100
    //   22: if_icmple -> 28
    //   25: goto -> 65
    //   28: iload_0
    //   29: putstatic com/loc/ba.c : I
    //   32: iload_0
    //   33: iconst_5
    //   34: idiv
    //   35: getstatic com/loc/ba.f : I
    //   38: if_icmple -> 49
    //   41: getstatic com/loc/ba.c : I
    //   44: iconst_5
    //   45: idiv
    //   46: putstatic com/loc/ba.f : I
    //   49: iload_3
    //   50: putstatic com/loc/ba.d : I
    //   53: ldc com/loc/ba
    //   55: monitorexit
    //   56: return
    //   57: astore #4
    //   59: ldc com/loc/ba
    //   61: monitorexit
    //   62: aload #4
    //   64: athrow
    //   65: bipush #20
    //   67: istore_0
    //   68: goto -> 28
    // Exception table:
    //   from	to	target	type
    //   3	11	57	finally
    //   28	49	57	finally
    //   49	53	57	finally
  }
  
  public static void a(Context paramContext) {
    ab.d().submit(new a(paramContext, 2));
  }
  
  public static void a(az paramaz, Context paramContext) {
    // Byte code:
    //   0: ldc com/loc/ba
    //   2: monitorenter
    //   3: invokestatic d : ()Ljava/util/concurrent/ExecutorService;
    //   6: new com/loc/ba$a
    //   9: dup
    //   10: aload_1
    //   11: aload_0
    //   12: invokespecial <init> : (Landroid/content/Context;Lcom/loc/az;)V
    //   15: invokeinterface submit : (Ljava/lang/Runnable;)Ljava/util/concurrent/Future;
    //   20: pop
    //   21: ldc com/loc/ba
    //   23: monitorexit
    //   24: return
    //   25: astore_0
    //   26: ldc com/loc/ba
    //   28: monitorexit
    //   29: aload_0
    //   30: athrow
    // Exception table:
    //   from	to	target	type
    //   3	21	25	finally
  }
  
  static final class a implements Runnable {
    private int a;
    
    private Context b;
    
    private az c;
    
    a(Context param1Context, int param1Int) {
      this.b = param1Context;
      this.a = param1Int;
    }
    
    a(Context param1Context, az param1az) {
      this(param1Context, 1);
      this.c = param1az;
    }
    
    public final void run() {
      // Byte code:
      //   0: aload_0
      //   1: getfield a : I
      //   4: istore_1
      //   5: iload_1
      //   6: iconst_1
      //   7: if_icmpne -> 116
      //   10: ldc com/loc/ba
      //   12: monitorenter
      //   13: invokestatic currentTimeMillis : ()J
      //   16: invokestatic toString : (J)Ljava/lang/String;
      //   19: astore_2
      //   20: invokestatic a : ()Ljava/lang/ref/WeakReference;
      //   23: invokestatic a : (Ljava/lang/ref/WeakReference;)Lcom/loc/ax;
      //   26: astore_3
      //   27: aload_0
      //   28: getfield b : Landroid/content/Context;
      //   31: aload_3
      //   32: getstatic com/loc/z.i : Ljava/lang/String;
      //   35: getstatic com/loc/ba.a : I
      //   38: ldc 2097152
      //   40: ldc '6'
      //   42: invokestatic a : (Landroid/content/Context;Lcom/loc/ax;Ljava/lang/String;IILjava/lang/String;)V
      //   45: aload_3
      //   46: getfield e : Lcom/loc/ak;
      //   49: ifnonnull -> 84
      //   52: aload_3
      //   53: new com/loc/aj
      //   56: dup
      //   57: new com/loc/al
      //   60: dup
      //   61: new com/loc/an
      //   64: dup
      //   65: new com/loc/al
      //   68: dup
      //   69: invokespecial <init> : ()V
      //   72: invokespecial <init> : (Lcom/loc/ak;)V
      //   75: invokespecial <init> : (Lcom/loc/ak;)V
      //   78: invokespecial <init> : (Lcom/loc/ak;)V
      //   81: putfield e : Lcom/loc/ak;
      //   84: aload_2
      //   85: aload_0
      //   86: getfield c : Lcom/loc/az;
      //   89: invokevirtual a : ()[B
      //   92: aload_3
      //   93: invokestatic a : (Ljava/lang/String;[BLcom/loc/ax;)V
      //   96: ldc com/loc/ba
      //   98: monitorexit
      //   99: return
      //   100: astore_2
      //   101: ldc com/loc/ba
      //   103: monitorexit
      //   104: aload_2
      //   105: athrow
      //   106: astore_2
      //   107: aload_2
      //   108: ldc 'ofm'
      //   110: ldc 'aple'
      //   112: invokestatic b : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
      //   115: return
      //   116: iload_1
      //   117: iconst_2
      //   118: if_icmpne -> 429
      //   121: invokestatic a : ()Ljava/lang/ref/WeakReference;
      //   124: invokestatic a : (Ljava/lang/ref/WeakReference;)Lcom/loc/ax;
      //   127: astore_2
      //   128: aload_0
      //   129: getfield b : Landroid/content/Context;
      //   132: aload_2
      //   133: getstatic com/loc/z.i : Ljava/lang/String;
      //   136: getstatic com/loc/ba.a : I
      //   139: ldc 2097152
      //   141: ldc '6'
      //   143: invokestatic a : (Landroid/content/Context;Lcom/loc/ax;Ljava/lang/String;IILjava/lang/String;)V
      //   146: aload_2
      //   147: ldc 14400000
      //   149: putfield h : I
      //   152: aload_2
      //   153: getfield g : Lcom/loc/bk;
      //   156: ifnonnull -> 338
      //   159: new com/loc/aj
      //   162: dup
      //   163: new com/loc/al
      //   166: dup
      //   167: new com/loc/an
      //   170: dup
      //   171: invokespecial <init> : ()V
      //   174: invokespecial <init> : (Lcom/loc/ak;)V
      //   177: invokespecial <init> : (Lcom/loc/ak;)V
      //   180: astore_3
      //   181: aload_2
      //   182: new com/loc/bh
      //   185: dup
      //   186: new com/loc/bg
      //   189: dup
      //   190: aload_0
      //   191: getfield b : Landroid/content/Context;
      //   194: new com/loc/bl
      //   197: dup
      //   198: invokespecial <init> : ()V
      //   201: aload_3
      //   202: new java/lang/String
      //   205: dup
      //   206: bipush #10
      //   208: invokestatic a : (I)[B
      //   211: invokespecial <init> : ([B)V
      //   214: bipush #12
      //   216: anewarray java/lang/Object
      //   219: dup
      //   220: iconst_0
      //   221: aload_0
      //   222: getfield b : Landroid/content/Context;
      //   225: invokestatic f : (Landroid/content/Context;)Ljava/lang/String;
      //   228: aastore
      //   229: dup
      //   230: iconst_1
      //   231: aload_0
      //   232: getfield b : Landroid/content/Context;
      //   235: invokestatic x : (Landroid/content/Context;)Ljava/lang/String;
      //   238: aastore
      //   239: dup
      //   240: iconst_2
      //   241: aload_0
      //   242: getfield b : Landroid/content/Context;
      //   245: invokestatic m : (Landroid/content/Context;)Ljava/lang/String;
      //   248: aastore
      //   249: dup
      //   250: iconst_3
      //   251: aload_0
      //   252: getfield b : Landroid/content/Context;
      //   255: invokestatic h : (Landroid/content/Context;)Ljava/lang/String;
      //   258: aastore
      //   259: dup
      //   260: iconst_4
      //   261: invokestatic a : ()Ljava/lang/String;
      //   264: aastore
      //   265: dup
      //   266: iconst_5
      //   267: getstatic android/os/Build.MANUFACTURER : Ljava/lang/String;
      //   270: aastore
      //   271: dup
      //   272: bipush #6
      //   274: getstatic android/os/Build.DEVICE : Ljava/lang/String;
      //   277: aastore
      //   278: dup
      //   279: bipush #7
      //   281: aload_0
      //   282: getfield b : Landroid/content/Context;
      //   285: invokestatic A : (Landroid/content/Context;)Ljava/lang/String;
      //   288: aastore
      //   289: dup
      //   290: bipush #8
      //   292: aload_0
      //   293: getfield b : Landroid/content/Context;
      //   296: invokestatic c : (Landroid/content/Context;)Ljava/lang/String;
      //   299: aastore
      //   300: dup
      //   301: bipush #9
      //   303: getstatic android/os/Build.MODEL : Ljava/lang/String;
      //   306: aastore
      //   307: dup
      //   308: bipush #10
      //   310: aload_0
      //   311: getfield b : Landroid/content/Context;
      //   314: invokestatic d : (Landroid/content/Context;)Ljava/lang/String;
      //   317: aastore
      //   318: dup
      //   319: bipush #11
      //   321: aload_0
      //   322: getfield b : Landroid/content/Context;
      //   325: invokestatic b : (Landroid/content/Context;)Ljava/lang/String;
      //   328: aastore
      //   329: invokespecial <init> : (Landroid/content/Context;Lcom/loc/bk;Lcom/loc/ak;Ljava/lang/String;[Ljava/lang/Object;)V
      //   332: invokespecial <init> : (Lcom/loc/bk;)V
      //   335: putfield g : Lcom/loc/bk;
      //   338: aload_2
      //   339: getfield i : Ljava/lang/String;
      //   342: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   345: ifeq -> 354
      //   348: aload_2
      //   349: ldc 'fKey'
      //   351: putfield i : Ljava/lang/String;
      //   354: aload_2
      //   355: new com/loc/bp
      //   358: dup
      //   359: aload_0
      //   360: getfield b : Landroid/content/Context;
      //   363: aload_2
      //   364: getfield h : I
      //   367: aload_2
      //   368: getfield i : Ljava/lang/String;
      //   371: new com/loc/bn
      //   374: dup
      //   375: aload_0
      //   376: getfield b : Landroid/content/Context;
      //   379: getstatic com/loc/ba.b : Z
      //   382: invokestatic b : ()I
      //   385: sipush #1024
      //   388: imul
      //   389: getstatic com/loc/ba.c : I
      //   392: sipush #1024
      //   395: imul
      //   396: ldc 'offLocKey'
      //   398: getstatic com/loc/ba.d : I
      //   401: sipush #1024
      //   404: imul
      //   405: invokespecial <init> : (Landroid/content/Context;ZIILjava/lang/String;I)V
      //   408: invokespecial <init> : (Landroid/content/Context;ILjava/lang/String;Lcom/loc/bq;)V
      //   411: putfield f : Lcom/loc/bq;
      //   414: aload_2
      //   415: invokestatic a : (Lcom/loc/ax;)I
      //   418: pop
      //   419: return
      //   420: astore_2
      //   421: aload_2
      //   422: ldc 'ofm'
      //   424: ldc 'uold'
      //   426: invokestatic b : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
      //   429: return
      // Exception table:
      //   from	to	target	type
      //   10	13	106	finally
      //   13	84	100	finally
      //   84	99	100	finally
      //   101	104	100	finally
      //   104	106	106	finally
      //   121	338	420	finally
      //   338	354	420	finally
      //   354	419	420	finally
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */