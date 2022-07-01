package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import java.util.Map;

public final class a {
  public static Map<String, String> a(Context paramContext, Map<String, String> paramMap) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/d/a
    //   2: monitorenter
    //   3: aload_1
    //   4: ldc 'appchannel'
    //   6: ldc ''
    //   8: invokestatic a : (Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11: astore_1
    //   12: new java/util/HashMap
    //   15: dup
    //   16: invokespecial <init> : ()V
    //   19: astore_2
    //   20: aload_2
    //   21: ldc 'AA1'
    //   23: aload_0
    //   24: invokevirtual getPackageName : ()Ljava/lang/String;
    //   27: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   32: pop
    //   33: invokestatic a : ()Lcom/alipay/security/mobile/module/b/a;
    //   36: pop
    //   37: aload_2
    //   38: ldc 'AA2'
    //   40: aload_0
    //   41: invokestatic a : (Landroid/content/Context;)Ljava/lang/String;
    //   44: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   49: pop
    //   50: aload_2
    //   51: ldc 'AA3'
    //   53: ldc 'APPSecuritySDK-ALIPAYSDK'
    //   55: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   60: pop
    //   61: aload_2
    //   62: ldc 'AA4'
    //   64: ldc '3.4.0.201910161639'
    //   66: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   71: pop
    //   72: aload_2
    //   73: ldc 'AA6'
    //   75: aload_1
    //   76: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   81: pop
    //   82: ldc com/alipay/apmobilesecuritysdk/d/a
    //   84: monitorexit
    //   85: aload_2
    //   86: areturn
    //   87: astore_0
    //   88: ldc com/alipay/apmobilesecuritysdk/d/a
    //   90: monitorexit
    //   91: aload_0
    //   92: athrow
    // Exception table:
    //   from	to	target	type
    //   3	82	87	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\apmobilesecuritysdk\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */