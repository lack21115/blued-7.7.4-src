package com.alibaba.mtl.log.b;

import android.text.TextUtils;
import com.alibaba.mtl.log.e.l;
import java.util.List;

public class a {
  private static StringBuilder a = new StringBuilder();
  
  private static volatile long e;
  
  private static long f;
  
  private static long g;
  
  private static long h;
  
  private static long i;
  
  private static long j;
  
  private static long k;
  
  private static long l;
  
  private static long m;
  
  private static long n;
  
  private static long o;
  
  private static long p;
  
  private static long q;
  
  private static long r;
  
  private static long s;
  
  private static long t;
  
  private static int u;
  
  private static long u;
  
  private static int v;
  
  private static long v;
  
  private static int w;
  
  private static long w;
  
  private static long x;
  
  private static long y;
  
  public static void A() {
    // Byte code:
    //   0: ldc com/alibaba/mtl/log/b/a
    //   2: monitorenter
    //   3: getstatic com/alibaba/mtl/log/b/a.s : J
    //   6: lconst_1
    //   7: ladd
    //   8: putstatic com/alibaba/mtl/log/b/a.s : J
    //   11: ldc com/alibaba/mtl/log/b/a
    //   13: monitorexit
    //   14: return
    //   15: astore_0
    //   16: ldc com/alibaba/mtl/log/b/a
    //   18: monitorexit
    //   19: aload_0
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   3	11	15	finally
  }
  
  public static void B() {
    // Byte code:
    //   0: ldc com/alibaba/mtl/log/b/a
    //   2: monitorenter
    //   3: getstatic com/alibaba/mtl/log/b/a.t : J
    //   6: lconst_1
    //   7: ladd
    //   8: putstatic com/alibaba/mtl/log/b/a.t : J
    //   11: ldc com/alibaba/mtl/log/b/a
    //   13: monitorexit
    //   14: return
    //   15: astore_0
    //   16: ldc com/alibaba/mtl/log/b/a
    //   18: monitorexit
    //   19: aload_0
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   3	11	15	finally
  }
  
  public static void C() {
    // Byte code:
    //   0: ldc com/alibaba/mtl/log/b/a
    //   2: monitorenter
    //   3: getstatic com/alibaba/mtl/log/b/a.u : J
    //   6: lconst_1
    //   7: ladd
    //   8: putstatic com/alibaba/mtl/log/b/a.u : J
    //   11: ldc com/alibaba/mtl/log/b/a
    //   13: monitorexit
    //   14: return
    //   15: astore_0
    //   16: ldc com/alibaba/mtl/log/b/a
    //   18: monitorexit
    //   19: aload_0
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   3	11	15	finally
  }
  
  private static void D() {
    String str = l.u();
    if ("wifi".equalsIgnoreCase(str)) {
      m++;
      return;
    } 
    if ("3G".equalsIgnoreCase(str)) {
      k++;
      return;
    } 
    if ("4G".equalsIgnoreCase(str)) {
      l++;
      return;
    } 
    if ("2G".equalsIgnoreCase(str)) {
      j++;
      return;
    } 
    v++;
  }
  
  public static void E() {
    // Byte code:
    //   0: ldc com/alibaba/mtl/log/b/a
    //   2: monitorenter
    //   3: getstatic com/alibaba/mtl/log/b/a.w : I
    //   6: iconst_1
    //   7: iadd
    //   8: putstatic com/alibaba/mtl/log/b/a.w : I
    //   11: getstatic com/alibaba/mtl/log/b/a.e : J
    //   14: lconst_0
    //   15: lcmp
    //   16: ifne -> 33
    //   19: getstatic com/alibaba/mtl/log/b/a.g : J
    //   22: lstore_0
    //   23: lload_0
    //   24: lconst_0
    //   25: lcmp
    //   26: ifne -> 33
    //   29: ldc com/alibaba/mtl/log/b/a
    //   31: monitorexit
    //   32: return
    //   33: getstatic com/alibaba/mtl/log/a.o : Z
    //   36: ifne -> 47
    //   39: getstatic com/alibaba/mtl/log/b/a.w : I
    //   42: bipush #6
    //   44: if_icmplt -> 51
    //   47: iconst_1
    //   48: invokestatic c : (Z)V
    //   51: ldc com/alibaba/mtl/log/b/a
    //   53: monitorexit
    //   54: return
    //   55: astore_2
    //   56: ldc com/alibaba/mtl/log/b/a
    //   58: monitorexit
    //   59: aload_2
    //   60: athrow
    // Exception table:
    //   from	to	target	type
    //   3	23	55	finally
    //   33	47	55	finally
    //   47	51	55	finally
  }
  
  public static void a(List<com.alibaba.mtl.log.model.a> paramList, int paramInt) {
    // Byte code:
    //   0: ldc com/alibaba/mtl/log/b/a
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnonnull -> 11
    //   7: ldc com/alibaba/mtl/log/b/a
    //   9: monitorexit
    //   10: return
    //   11: iconst_0
    //   12: istore #4
    //   14: iconst_0
    //   15: istore_2
    //   16: iload #4
    //   18: aload_0
    //   19: invokeinterface size : ()I
    //   24: if_icmpge -> 110
    //   27: aload_0
    //   28: iload #4
    //   30: invokeinterface get : (I)Ljava/lang/Object;
    //   35: checkcast com/alibaba/mtl/log/model/a
    //   38: astore #6
    //   40: iload_2
    //   41: istore #5
    //   43: aload #6
    //   45: ifnull -> 199
    //   48: iload_2
    //   49: istore_3
    //   50: ldc '6005'
    //   52: aload #6
    //   54: getfield T : Ljava/lang/String;
    //   57: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   60: ifne -> 67
    //   63: iload_2
    //   64: iconst_1
    //   65: iadd
    //   66: istore_3
    //   67: getstatic com/alibaba/mtl/log/b/a.a : Ljava/lang/StringBuilder;
    //   70: aload #6
    //   72: getfield X : Ljava/lang/String;
    //   75: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: iload_3
    //   80: istore #5
    //   82: iload #4
    //   84: aload_0
    //   85: invokeinterface size : ()I
    //   90: iconst_1
    //   91: isub
    //   92: if_icmpeq -> 199
    //   95: getstatic com/alibaba/mtl/log/b/a.a : Ljava/lang/StringBuilder;
    //   98: ldc ','
    //   100: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: iload_3
    //   105: istore #5
    //   107: goto -> 199
    //   110: ldc 'CoreStatics'
    //   112: iconst_4
    //   113: anewarray java/lang/Object
    //   116: dup
    //   117: iconst_0
    //   118: ldc '[uploadInc]:'
    //   120: aastore
    //   121: dup
    //   122: iconst_1
    //   123: getstatic com/alibaba/mtl/log/b/a.g : J
    //   126: invokestatic valueOf : (J)Ljava/lang/Long;
    //   129: aastore
    //   130: dup
    //   131: iconst_2
    //   132: ldc 'count:'
    //   134: aastore
    //   135: dup
    //   136: iconst_3
    //   137: iload_1
    //   138: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   141: aastore
    //   142: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   145: getstatic com/alibaba/mtl/log/b/a.g : J
    //   148: iload_1
    //   149: i2l
    //   150: ladd
    //   151: putstatic com/alibaba/mtl/log/b/a.g : J
    //   154: ldc 'CoreStatics'
    //   156: iconst_2
    //   157: anewarray java/lang/Object
    //   160: dup
    //   161: iconst_0
    //   162: ldc '[uploadInc]:'
    //   164: aastore
    //   165: dup
    //   166: iconst_1
    //   167: getstatic com/alibaba/mtl/log/b/a.g : J
    //   170: invokestatic valueOf : (J)Ljava/lang/Long;
    //   173: aastore
    //   174: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   177: iload_2
    //   178: iload_1
    //   179: if_icmpeq -> 189
    //   182: ldc 'CoreStatics'
    //   184: ldc 'Mutil Process Upload Error'
    //   186: invokestatic a : (Ljava/lang/String;Ljava/lang/Object;)V
    //   189: ldc com/alibaba/mtl/log/b/a
    //   191: monitorexit
    //   192: return
    //   193: astore_0
    //   194: ldc com/alibaba/mtl/log/b/a
    //   196: monitorexit
    //   197: aload_0
    //   198: athrow
    //   199: iload #4
    //   201: iconst_1
    //   202: iadd
    //   203: istore #4
    //   205: iload #5
    //   207: istore_2
    //   208: goto -> 16
    // Exception table:
    //   from	to	target	type
    //   16	40	193	finally
    //   50	63	193	finally
    //   67	79	193	finally
    //   82	104	193	finally
    //   110	177	193	finally
    //   182	189	193	finally
  }
  
  public static void c(boolean paramBoolean) {
    /* monitor enter TypeReferenceDotClassExpression{ObjectType{com/alibaba/mtl/log/b/a}} */
    /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/alibaba/mtl/log/b/a}} */
  }
  
  public static void d(int paramInt) {
    // Byte code:
    //   0: ldc com/alibaba/mtl/log/b/a
    //   2: monitorenter
    //   3: getstatic com/alibaba/mtl/log/b/a.u : I
    //   6: iload_0
    //   7: iadd
    //   8: putstatic com/alibaba/mtl/log/b/a.u : I
    //   11: ldc com/alibaba/mtl/log/b/a
    //   13: monitorexit
    //   14: return
    //   15: astore_1
    //   16: ldc com/alibaba/mtl/log/b/a
    //   18: monitorexit
    //   19: aload_1
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   3	11	15	finally
  }
  
  private static boolean d(String paramString) {
    return TextUtils.isEmpty(paramString) ? false : "6005".equalsIgnoreCase(paramString.trim());
  }
  
  public static void l(String paramString) {
    // Byte code:
    //   0: ldc com/alibaba/mtl/log/b/a
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic d : (Ljava/lang/String;)Z
    //   7: istore_1
    //   8: iload_1
    //   9: ifeq -> 16
    //   12: ldc com/alibaba/mtl/log/b/a
    //   14: monitorexit
    //   15: return
    //   16: ldc '65501'
    //   18: aload_0
    //   19: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   22: ifeq -> 36
    //   25: getstatic com/alibaba/mtl/log/b/a.y : J
    //   28: lconst_1
    //   29: ladd
    //   30: putstatic com/alibaba/mtl/log/b/a.y : J
    //   33: goto -> 93
    //   36: ldc '65133'
    //   38: aload_0
    //   39: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   42: ifeq -> 56
    //   45: getstatic com/alibaba/mtl/log/b/a.w : J
    //   48: lconst_1
    //   49: ladd
    //   50: putstatic com/alibaba/mtl/log/b/a.w : J
    //   53: goto -> 93
    //   56: ldc '65502'
    //   58: aload_0
    //   59: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   62: ifeq -> 76
    //   65: getstatic com/alibaba/mtl/log/b/a.x : J
    //   68: lconst_1
    //   69: ladd
    //   70: putstatic com/alibaba/mtl/log/b/a.x : J
    //   73: goto -> 93
    //   76: ldc '65503'
    //   78: aload_0
    //   79: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   82: ifeq -> 93
    //   85: getstatic com/alibaba/mtl/log/b/a.v : J
    //   88: lconst_1
    //   89: ladd
    //   90: putstatic com/alibaba/mtl/log/b/a.v : J
    //   93: getstatic com/alibaba/mtl/log/b/a.e : J
    //   96: lconst_1
    //   97: ladd
    //   98: putstatic com/alibaba/mtl/log/b/a.e : J
    //   101: ldc com/alibaba/mtl/log/b/a
    //   103: monitorexit
    //   104: return
    //   105: astore_0
    //   106: ldc com/alibaba/mtl/log/b/a
    //   108: monitorexit
    //   109: aload_0
    //   110: athrow
    // Exception table:
    //   from	to	target	type
    //   3	8	105	finally
    //   16	33	105	finally
    //   36	53	105	finally
    //   56	73	105	finally
    //   76	93	105	finally
    //   93	101	105	finally
  }
  
  public static void m(String paramString) {
    // Byte code:
    //   0: ldc com/alibaba/mtl/log/b/a
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic d : (Ljava/lang/String;)Z
    //   7: istore_1
    //   8: iload_1
    //   9: ifeq -> 16
    //   12: ldc com/alibaba/mtl/log/b/a
    //   14: monitorexit
    //   15: return
    //   16: getstatic com/alibaba/mtl/log/b/a.f : J
    //   19: lconst_1
    //   20: ladd
    //   21: putstatic com/alibaba/mtl/log/b/a.f : J
    //   24: invokestatic D : ()V
    //   27: ldc com/alibaba/mtl/log/b/a
    //   29: monitorexit
    //   30: return
    //   31: astore_0
    //   32: ldc com/alibaba/mtl/log/b/a
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   3	8	31	finally
    //   16	27	31	finally
  }
  
  public static void t() {
    // Byte code:
    //   0: ldc com/alibaba/mtl/log/b/a
    //   2: monitorenter
    //   3: getstatic com/alibaba/mtl/log/b/a.h : J
    //   6: lconst_1
    //   7: ladd
    //   8: putstatic com/alibaba/mtl/log/b/a.h : J
    //   11: ldc com/alibaba/mtl/log/b/a
    //   13: monitorexit
    //   14: return
    //   15: astore_0
    //   16: ldc com/alibaba/mtl/log/b/a
    //   18: monitorexit
    //   19: aload_0
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   3	11	15	finally
  }
  
  public static void u() {
    // Byte code:
    //   0: ldc com/alibaba/mtl/log/b/a
    //   2: monitorenter
    //   3: getstatic com/alibaba/mtl/log/b/a.i : J
    //   6: lconst_1
    //   7: ladd
    //   8: putstatic com/alibaba/mtl/log/b/a.i : J
    //   11: ldc com/alibaba/mtl/log/b/a
    //   13: monitorexit
    //   14: return
    //   15: astore_0
    //   16: ldc com/alibaba/mtl/log/b/a
    //   18: monitorexit
    //   19: aload_0
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   3	11	15	finally
  }
  
  public static void v() {
    // Byte code:
    //   0: ldc com/alibaba/mtl/log/b/a
    //   2: monitorenter
    //   3: getstatic com/alibaba/mtl/log/b/a.n : J
    //   6: lconst_1
    //   7: ladd
    //   8: putstatic com/alibaba/mtl/log/b/a.n : J
    //   11: ldc com/alibaba/mtl/log/b/a
    //   13: monitorexit
    //   14: return
    //   15: astore_0
    //   16: ldc com/alibaba/mtl/log/b/a
    //   18: monitorexit
    //   19: aload_0
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   3	11	15	finally
  }
  
  public static void w() {
    // Byte code:
    //   0: ldc com/alibaba/mtl/log/b/a
    //   2: monitorenter
    //   3: getstatic com/alibaba/mtl/log/b/a.o : J
    //   6: lconst_1
    //   7: ladd
    //   8: putstatic com/alibaba/mtl/log/b/a.o : J
    //   11: ldc com/alibaba/mtl/log/b/a
    //   13: monitorexit
    //   14: return
    //   15: astore_0
    //   16: ldc com/alibaba/mtl/log/b/a
    //   18: monitorexit
    //   19: aload_0
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   3	11	15	finally
  }
  
  public static void x() {
    // Byte code:
    //   0: ldc com/alibaba/mtl/log/b/a
    //   2: monitorenter
    //   3: getstatic com/alibaba/mtl/log/b/a.p : J
    //   6: lconst_1
    //   7: ladd
    //   8: putstatic com/alibaba/mtl/log/b/a.p : J
    //   11: ldc com/alibaba/mtl/log/b/a
    //   13: monitorexit
    //   14: return
    //   15: astore_0
    //   16: ldc com/alibaba/mtl/log/b/a
    //   18: monitorexit
    //   19: aload_0
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   3	11	15	finally
  }
  
  public static void y() {
    // Byte code:
    //   0: ldc com/alibaba/mtl/log/b/a
    //   2: monitorenter
    //   3: getstatic com/alibaba/mtl/log/b/a.q : J
    //   6: lconst_1
    //   7: ladd
    //   8: putstatic com/alibaba/mtl/log/b/a.q : J
    //   11: ldc com/alibaba/mtl/log/b/a
    //   13: monitorexit
    //   14: return
    //   15: astore_0
    //   16: ldc com/alibaba/mtl/log/b/a
    //   18: monitorexit
    //   19: aload_0
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   3	11	15	finally
  }
  
  public static void z() {
    // Byte code:
    //   0: ldc com/alibaba/mtl/log/b/a
    //   2: monitorenter
    //   3: getstatic com/alibaba/mtl/log/b/a.r : J
    //   6: lconst_1
    //   7: ladd
    //   8: putstatic com/alibaba/mtl/log/b/a.r : J
    //   11: ldc com/alibaba/mtl/log/b/a
    //   13: monitorexit
    //   14: return
    //   15: astore_0
    //   16: ldc com/alibaba/mtl/log/b/a
    //   18: monitorexit
    //   19: aload_0
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   3	11	15	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\log\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */