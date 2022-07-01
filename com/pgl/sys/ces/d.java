package com.pgl.sys.ces;

import android.content.Context;
import com.pgl.sys.ces.c.b;

public class d {
  public static int a = 0;
  
  public static long b = 3600L;
  
  public static long c;
  
  public static void a(Context paramContext) {
    // Byte code:
    //   0: ldc com/pgl/sys/ces/d
    //   2: monitorenter
    //   3: invokestatic currentTimeMillis : ()J
    //   6: ldc2_w 1000
    //   9: ldiv
    //   10: lstore_2
    //   11: lload_2
    //   12: getstatic com/pgl/sys/ces/d.c : J
    //   15: lsub
    //   16: getstatic com/pgl/sys/ces/d.b : J
    //   19: lcmp
    //   20: iflt -> 90
    //   23: iconst_0
    //   24: istore_1
    //   25: iconst_0
    //   26: putstatic com/pgl/sys/ces/b.h : Z
    //   29: iconst_0
    //   30: putstatic com/pgl/sys/ces/d.a : I
    //   33: lload_2
    //   34: putstatic com/pgl/sys/ces/d.c : J
    //   37: iload_1
    //   38: iconst_3
    //   39: if_icmpge -> 90
    //   42: getstatic com/pgl/sys/ces/b.h : Z
    //   45: ifne -> 67
    //   48: getstatic com/pgl/sys/ces/d.a : I
    //   51: iconst_3
    //   52: if_icmpge -> 67
    //   55: aload_0
    //   56: invokestatic b : (Landroid/content/Context;)V
    //   59: getstatic com/pgl/sys/ces/d.a : I
    //   62: iconst_1
    //   63: iadd
    //   64: putstatic com/pgl/sys/ces/d.a : I
    //   67: iload_1
    //   68: iconst_1
    //   69: iadd
    //   70: istore_1
    //   71: iload_1
    //   72: sipush #5000
    //   75: imul
    //   76: i2l
    //   77: invokestatic a : (J)V
    //   80: getstatic com/pgl/sys/ces/b.h : Z
    //   83: istore #4
    //   85: iload #4
    //   87: ifeq -> 37
    //   90: ldc com/pgl/sys/ces/d
    //   92: monitorexit
    //   93: return
    //   94: astore_0
    //   95: ldc com/pgl/sys/ces/d
    //   97: monitorexit
    //   98: aload_0
    //   99: athrow
    // Exception table:
    //   from	to	target	type
    //   3	23	94	finally
    //   25	37	94	finally
    //   42	67	94	finally
    //   71	85	94	finally
  }
  
  private static void b(Context paramContext) {
    (new b(paramContext, b.d())).a(2, 2, null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\pgl\sys\ces\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */