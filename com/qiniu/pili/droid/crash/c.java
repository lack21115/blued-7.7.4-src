package com.qiniu.pili.droid.crash;

import android.content.Context;

public class c {
  private static boolean a = false;
  
  public static void a(Context paramContext) {
    // Byte code:
    //   0: ldc com/qiniu/pili/droid/crash/c
    //   2: monitorenter
    //   3: getstatic com/qiniu/pili/droid/crash/c.a : Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq -> 15
    //   11: ldc com/qiniu/pili/droid/crash/c
    //   13: monitorexit
    //   14: return
    //   15: aload_0
    //   16: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   19: astore_0
    //   20: aload_0
    //   21: invokestatic a : (Landroid/content/Context;)Z
    //   24: istore_1
    //   25: iload_1
    //   26: ifne -> 33
    //   29: ldc com/qiniu/pili/droid/crash/c
    //   31: monitorexit
    //   32: return
    //   33: invokestatic a : ()Lcom/qiniu/pili/droid/crash/f;
    //   36: aload_0
    //   37: invokevirtual a : (Landroid/content/Context;)V
    //   40: invokestatic a : ()Lcom/qiniu/pili/droid/crash/NativeCrashHandler;
    //   43: aload_0
    //   44: invokevirtual a : (Landroid/content/Context;)V
    //   47: invokestatic a : ()Lcom/qiniu/pili/droid/crash/h;
    //   50: aload_0
    //   51: invokevirtual a : (Landroid/content/Context;)V
    //   54: iconst_1
    //   55: putstatic com/qiniu/pili/droid/crash/c.a : Z
    //   58: ldc com/qiniu/pili/droid/crash/c
    //   60: monitorexit
    //   61: return
    //   62: astore_0
    //   63: ldc com/qiniu/pili/droid/crash/c
    //   65: monitorexit
    //   66: aload_0
    //   67: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	62	finally
    //   15	25	62	finally
    //   33	58	62	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\crash\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */