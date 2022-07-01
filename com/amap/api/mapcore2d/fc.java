package com.amap.api.mapcore2d;

import android.content.Context;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

public class fc {
  static WeakReference<fa> a;
  
  public static void a(Context paramContext) {
    do.d().submit(new Runnable(paramContext) {
          public void run() {
            // Byte code:
            //   0: ldc com/amap/api/mapcore2d/fc
            //   2: monitorenter
            //   3: getstatic com/amap/api/mapcore2d/fc.a : Ljava/lang/ref/WeakReference;
            //   6: invokestatic a : (Ljava/lang/ref/WeakReference;)Lcom/amap/api/mapcore2d/fa;
            //   9: astore_1
            //   10: aload_0
            //   11: getfield a : Landroid/content/Context;
            //   14: aload_1
            //   15: getstatic com/amap/api/mapcore2d/dm.j : Ljava/lang/String;
            //   18: bipush #50
            //   20: ldc 102400
            //   22: ldc '10'
            //   24: invokestatic a : (Landroid/content/Context;Lcom/amap/api/mapcore2d/fa;Ljava/lang/String;IILjava/lang/String;)V
            //   27: aload_1
            //   28: getfield g : Lcom/amap/api/mapcore2d/fo;
            //   31: ifnonnull -> 122
            //   34: aload_0
            //   35: getfield a : Landroid/content/Context;
            //   38: invokestatic b : (Landroid/content/Context;)Ljava/lang/String;
            //   41: astore_2
            //   42: aload_1
            //   43: new com/amap/api/mapcore2d/fl
            //   46: dup
            //   47: new com/amap/api/mapcore2d/fk
            //   50: dup
            //   51: aload_0
            //   52: getfield a : Landroid/content/Context;
            //   55: new com/amap/api/mapcore2d/fp
            //   58: dup
            //   59: invokespecial <init> : ()V
            //   62: new com/amap/api/mapcore2d/de
            //   65: dup
            //   66: new com/amap/api/mapcore2d/di
            //   69: dup
            //   70: new com/amap/api/mapcore2d/dg
            //   73: dup
            //   74: invokespecial <init> : ()V
            //   77: invokespecial <init> : (Lcom/amap/api/mapcore2d/df;)V
            //   80: invokespecial <init> : (Lcom/amap/api/mapcore2d/df;)V
            //   83: ldc 'WImFwcG5hbWUiOiIlcyIsInBrZyI6IiVzIiwiZGl1IjoiJXMi'
            //   85: iconst_3
            //   86: anewarray java/lang/Object
            //   89: dup
            //   90: iconst_0
            //   91: aload_0
            //   92: getfield a : Landroid/content/Context;
            //   95: invokestatic b : (Landroid/content/Context;)Ljava/lang/String;
            //   98: aastore
            //   99: dup
            //   100: iconst_1
            //   101: aload_0
            //   102: getfield a : Landroid/content/Context;
            //   105: invokestatic c : (Landroid/content/Context;)Ljava/lang/String;
            //   108: aastore
            //   109: dup
            //   110: iconst_2
            //   111: aload_2
            //   112: aastore
            //   113: invokespecial <init> : (Landroid/content/Context;Lcom/amap/api/mapcore2d/fo;Lcom/amap/api/mapcore2d/df;Ljava/lang/String;[Ljava/lang/Object;)V
            //   116: invokespecial <init> : (Lcom/amap/api/mapcore2d/fo;)V
            //   119: putfield g : Lcom/amap/api/mapcore2d/fo;
            //   122: aload_1
            //   123: ldc 14400000
            //   125: putfield h : I
            //   128: aload_1
            //   129: getfield i : Ljava/lang/String;
            //   132: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
            //   135: ifeq -> 144
            //   138: aload_1
            //   139: ldc 'eKey'
            //   141: putfield i : Ljava/lang/String;
            //   144: aload_1
            //   145: getfield f : Lcom/amap/api/mapcore2d/fu;
            //   148: ifnonnull -> 198
            //   151: aload_1
            //   152: new com/amap/api/mapcore2d/ft
            //   155: dup
            //   156: aload_0
            //   157: getfield a : Landroid/content/Context;
            //   160: aload_1
            //   161: getfield h : I
            //   164: aload_1
            //   165: getfield i : Ljava/lang/String;
            //   168: new com/amap/api/mapcore2d/fq
            //   171: dup
            //   172: iconst_5
            //   173: aload_1
            //   174: getfield a : Ljava/lang/String;
            //   177: new com/amap/api/mapcore2d/fv
            //   180: dup
            //   181: aload_0
            //   182: getfield a : Landroid/content/Context;
            //   185: iconst_0
            //   186: invokespecial <init> : (Landroid/content/Context;Z)V
            //   189: invokespecial <init> : (ILjava/lang/String;Lcom/amap/api/mapcore2d/fu;)V
            //   192: invokespecial <init> : (Landroid/content/Context;ILjava/lang/String;Lcom/amap/api/mapcore2d/fu;)V
            //   195: putfield f : Lcom/amap/api/mapcore2d/fu;
            //   198: aload_1
            //   199: invokestatic a : (Lcom/amap/api/mapcore2d/fa;)V
            //   202: ldc com/amap/api/mapcore2d/fc
            //   204: monitorexit
            //   205: return
            //   206: astore_1
            //   207: ldc com/amap/api/mapcore2d/fc
            //   209: monitorexit
            //   210: aload_1
            //   211: athrow
            // Exception table:
            //   from	to	target	type
            //   3	122	206	finally
            //   122	144	206	finally
            //   144	198	206	finally
            //   198	205	206	finally
            //   207	210	206	finally
          }
        });
  }
  
  private static String c(Context paramContext) {
    String str = cu.v(paramContext);
    if (!TextUtils.isEmpty(str))
      return str; 
    str = cu.h(paramContext);
    if (!TextUtils.isEmpty(str))
      return str; 
    str = cu.m(paramContext);
    return !TextUtils.isEmpty(str) ? str : cu.b(paramContext);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\fc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */