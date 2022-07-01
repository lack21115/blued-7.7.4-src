package com.alipay.security.mobile.module.c;

import android.content.Context;

public final class d {
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3) {
    // Byte code:
    //   0: ldc com/alipay/security/mobile/module/c/d
    //   2: monitorenter
    //   3: aload_1
    //   4: invokestatic a : (Ljava/lang/String;)Z
    //   7: ifne -> 70
    //   10: aload_2
    //   11: invokestatic a : (Ljava/lang/String;)Z
    //   14: istore #4
    //   16: iload #4
    //   18: ifne -> 70
    //   21: aload_0
    //   22: ifnonnull -> 28
    //   25: goto -> 70
    //   28: invokestatic a : ()Ljava/lang/String;
    //   31: aload_3
    //   32: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   35: astore_3
    //   36: new java/util/HashMap
    //   39: dup
    //   40: invokespecial <init> : ()V
    //   43: astore #5
    //   45: aload #5
    //   47: aload_2
    //   48: aload_3
    //   49: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   54: pop
    //   55: aload_0
    //   56: aload_1
    //   57: aload #5
    //   59: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;)V
    //   62: ldc com/alipay/security/mobile/module/c/d
    //   64: monitorexit
    //   65: return
    //   66: ldc com/alipay/security/mobile/module/c/d
    //   68: monitorexit
    //   69: return
    //   70: ldc com/alipay/security/mobile/module/c/d
    //   72: monitorexit
    //   73: return
    //   74: astore_0
    //   75: ldc com/alipay/security/mobile/module/c/d
    //   77: monitorexit
    //   78: aload_0
    //   79: athrow
    //   80: astore_0
    //   81: goto -> 66
    // Exception table:
    //   from	to	target	type
    //   3	16	74	finally
    //   28	62	80	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\security\mobile\module\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */