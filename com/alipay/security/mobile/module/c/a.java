package com.alipay.security.mobile.module.c;

import android.content.Context;

public class a {
  public static String a(Context paramContext, String paramString1, String paramString2) {
    // Byte code:
    //   0: ldc com/alipay/security/mobile/module/c/a
    //   2: monitorenter
    //   3: aconst_null
    //   4: astore #4
    //   6: aload_0
    //   7: ifnull -> 65
    //   10: aload_1
    //   11: invokestatic a : (Ljava/lang/String;)Z
    //   14: ifne -> 65
    //   17: aload_2
    //   18: invokestatic a : (Ljava/lang/String;)Z
    //   21: istore_3
    //   22: iload_3
    //   23: ifeq -> 29
    //   26: goto -> 65
    //   29: aload_0
    //   30: aload_1
    //   31: aload_2
    //   32: ldc ''
    //   34: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   37: astore_0
    //   38: aload_0
    //   39: invokestatic a : (Ljava/lang/String;)Z
    //   42: istore_3
    //   43: iload_3
    //   44: ifeq -> 52
    //   47: ldc com/alipay/security/mobile/module/c/a
    //   49: monitorexit
    //   50: aconst_null
    //   51: areturn
    //   52: invokestatic a : ()Ljava/lang/String;
    //   55: aload_0
    //   56: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   59: astore_0
    //   60: ldc com/alipay/security/mobile/module/c/a
    //   62: monitorexit
    //   63: aload_0
    //   64: areturn
    //   65: ldc com/alipay/security/mobile/module/c/a
    //   67: monitorexit
    //   68: aconst_null
    //   69: areturn
    //   70: astore_0
    //   71: ldc com/alipay/security/mobile/module/c/a
    //   73: monitorexit
    //   74: aload_0
    //   75: athrow
    //   76: astore_0
    //   77: aload #4
    //   79: astore_0
    //   80: goto -> 60
    // Exception table:
    //   from	to	target	type
    //   10	22	70	finally
    //   29	43	76	finally
    //   47	50	70	finally
    //   52	60	76	finally
    //   60	63	70	finally
    //   65	68	70	finally
    //   71	74	70	finally
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3) {
    // Byte code:
    //   0: ldc com/alipay/security/mobile/module/c/a
    //   2: monitorenter
    //   3: aload_1
    //   4: invokestatic a : (Ljava/lang/String;)Z
    //   7: ifne -> 66
    //   10: aload_2
    //   11: invokestatic a : (Ljava/lang/String;)Z
    //   14: istore #4
    //   16: iload #4
    //   18: ifne -> 66
    //   21: aload_0
    //   22: ifnonnull -> 28
    //   25: goto -> 66
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
    //   62: ldc com/alipay/security/mobile/module/c/a
    //   64: monitorexit
    //   65: return
    //   66: ldc com/alipay/security/mobile/module/c/a
    //   68: monitorexit
    //   69: return
    //   70: astore_0
    //   71: ldc com/alipay/security/mobile/module/c/a
    //   73: monitorexit
    //   74: aload_0
    //   75: athrow
    //   76: astore_0
    //   77: goto -> 62
    // Exception table:
    //   from	to	target	type
    //   3	16	70	finally
    //   28	62	76	finally
    //   62	65	70	finally
    //   66	69	70	finally
    //   71	74	70	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\security\mobile\module\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */