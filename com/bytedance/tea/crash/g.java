package com.bytedance.tea.crash;

import android.content.Context;
import com.bytedance.tea.crash.a.f;
import com.bytedance.tea.crash.b.a;
import com.bytedance.tea.crash.upload.d;

public final class g {
  private static boolean a = false;
  
  private static boolean b = false;
  
  private static boolean c = false;
  
  private static boolean d = false;
  
  public static void a(Context paramContext, d paramd, boolean paramBoolean1, boolean paramBoolean2) {
    // Byte code:
    //   0: ldc com/bytedance/tea/crash/g
    //   2: monitorenter
    //   3: aload_0
    //   4: aload_1
    //   5: iload_2
    //   6: iconst_0
    //   7: iload_3
    //   8: invokestatic a : (Landroid/content/Context;Lcom/bytedance/tea/crash/d;ZZZ)V
    //   11: ldc com/bytedance/tea/crash/g
    //   13: monitorexit
    //   14: return
    //   15: astore_0
    //   16: ldc com/bytedance/tea/crash/g
    //   18: monitorexit
    //   19: aload_0
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   3	11	15	finally
  }
  
  public static void a(Context paramContext, d paramd, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    // Byte code:
    //   0: ldc com/bytedance/tea/crash/g
    //   2: monitorenter
    //   3: aload_0
    //   4: aload_1
    //   5: iload_2
    //   6: iload_2
    //   7: iload_3
    //   8: iload #4
    //   10: invokestatic a : (Landroid/content/Context;Lcom/bytedance/tea/crash/d;ZZZZ)V
    //   13: ldc com/bytedance/tea/crash/g
    //   15: monitorexit
    //   16: return
    //   17: astore_0
    //   18: ldc com/bytedance/tea/crash/g
    //   20: monitorexit
    //   21: aload_0
    //   22: athrow
    // Exception table:
    //   from	to	target	type
    //   3	13	17	finally
  }
  
  public static void a(Context paramContext, d paramd, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
    // Byte code:
    //   0: ldc com/bytedance/tea/crash/g
    //   2: monitorenter
    //   3: getstatic com/bytedance/tea/crash/g.a : Z
    //   6: istore #6
    //   8: iload #6
    //   10: ifeq -> 17
    //   13: ldc com/bytedance/tea/crash/g
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: ifnull -> 147
    //   21: aload_1
    //   22: ifnull -> 137
    //   25: aload_0
    //   26: astore #7
    //   28: aload_0
    //   29: instanceof android/app/Application
    //   32: ifne -> 41
    //   35: aload_0
    //   36: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   39: astore #7
    //   41: aload #7
    //   43: invokestatic c : (Landroid/content/Context;)Z
    //   46: istore #6
    //   48: iload #6
    //   50: ifeq -> 57
    //   53: ldc com/bytedance/tea/crash/g
    //   55: monitorexit
    //   56: return
    //   57: aload #7
    //   59: aload_1
    //   60: invokestatic a : (Landroid/content/Context;Lcom/bytedance/tea/crash/d;)V
    //   63: aload #7
    //   65: invokestatic a : (Landroid/content/Context;)V
    //   68: iload_2
    //   69: ifne -> 76
    //   72: iload_3
    //   73: ifeq -> 101
    //   76: invokestatic a : ()Lcom/bytedance/tea/crash/d/a;
    //   79: astore_0
    //   80: iload_2
    //   81: ifeq -> 97
    //   84: aload_0
    //   85: new com/bytedance/tea/crash/d/c
    //   88: dup
    //   89: aload #7
    //   91: invokespecial <init> : (Landroid/content/Context;)V
    //   94: invokevirtual a : (Lcom/bytedance/tea/crash/d/b;)V
    //   97: iconst_1
    //   98: putstatic com/bytedance/tea/crash/g.b : Z
    //   101: iload #4
    //   103: putstatic com/bytedance/tea/crash/g.d : Z
    //   106: iconst_1
    //   107: putstatic com/bytedance/tea/crash/g.a : Z
    //   110: iload #5
    //   112: putstatic com/bytedance/tea/crash/g.c : Z
    //   115: invokestatic b : ()Landroid/os/Handler;
    //   118: new com/bytedance/tea/crash/g$1
    //   121: dup
    //   122: aload #7
    //   124: iload #5
    //   126: invokespecial <init> : (Landroid/content/Context;Z)V
    //   129: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   132: pop
    //   133: ldc com/bytedance/tea/crash/g
    //   135: monitorexit
    //   136: return
    //   137: new java/lang/IllegalArgumentException
    //   140: dup
    //   141: ldc 'params must be not null.'
    //   143: invokespecial <init> : (Ljava/lang/String;)V
    //   146: athrow
    //   147: new java/lang/IllegalArgumentException
    //   150: dup
    //   151: ldc 'context must be not null.'
    //   153: invokespecial <init> : (Ljava/lang/String;)V
    //   156: athrow
    //   157: astore_0
    //   158: ldc com/bytedance/tea/crash/g
    //   160: monitorexit
    //   161: aload_0
    //   162: athrow
    // Exception table:
    //   from	to	target	type
    //   3	8	157	finally
    //   28	41	157	finally
    //   41	48	157	finally
    //   57	68	157	finally
    //   76	80	157	finally
    //   84	97	157	finally
    //   97	101	157	finally
    //   101	133	157	finally
    //   137	147	157	finally
    //   147	157	157	finally
  }
  
  public static void a(f paramf) {
    h.b().a(paramf);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */