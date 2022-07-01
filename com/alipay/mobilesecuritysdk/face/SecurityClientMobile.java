package com.alipay.mobilesecuritysdk.face;

import android.content.Context;
import java.util.Map;

public class SecurityClientMobile {
  public static String GetApdid(Context paramContext, Map<String, String> paramMap) {
    // Byte code:
    //   0: ldc com/alipay/mobilesecuritysdk/face/SecurityClientMobile
    //   2: monitorenter
    //   3: new java/util/HashMap
    //   6: dup
    //   7: invokespecial <init> : ()V
    //   10: astore_2
    //   11: aload_2
    //   12: ldc 'utdid'
    //   14: aload_1
    //   15: ldc 'utdid'
    //   17: ldc ''
    //   19: invokestatic a : (Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   22: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   27: pop
    //   28: aload_2
    //   29: ldc 'tid'
    //   31: aload_1
    //   32: ldc 'tid'
    //   34: ldc ''
    //   36: invokestatic a : (Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   39: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   44: pop
    //   45: aload_2
    //   46: ldc 'userId'
    //   48: aload_1
    //   49: ldc 'userId'
    //   51: ldc ''
    //   53: invokestatic a : (Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   56: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   61: pop
    //   62: aload_0
    //   63: invokestatic getInstance : (Landroid/content/Context;)Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
    //   66: iconst_0
    //   67: aload_2
    //   68: aconst_null
    //   69: invokevirtual initToken : (ILjava/util/Map;Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$InitResultListener;)V
    //   72: aload_0
    //   73: invokestatic a : (Landroid/content/Context;)Ljava/lang/String;
    //   76: astore_0
    //   77: ldc com/alipay/mobilesecuritysdk/face/SecurityClientMobile
    //   79: monitorexit
    //   80: aload_0
    //   81: areturn
    //   82: astore_0
    //   83: ldc com/alipay/mobilesecuritysdk/face/SecurityClientMobile
    //   85: monitorexit
    //   86: aload_0
    //   87: athrow
    // Exception table:
    //   from	to	target	type
    //   3	77	82	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\mobilesecuritysdk\face\SecurityClientMobile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */