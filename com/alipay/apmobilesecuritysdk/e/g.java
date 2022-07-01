package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import android.content.SharedPreferences;

public final class g {
  public static String a(Context paramContext, String paramString) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/g
    //   2: monitorenter
    //   3: new java/lang/StringBuilder
    //   6: dup
    //   7: ldc 'openApi'
    //   9: invokespecial <init> : (Ljava/lang/String;)V
    //   12: astore_2
    //   13: aload_2
    //   14: aload_1
    //   15: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: pop
    //   19: aload_0
    //   20: ldc 'openapi_file_pri'
    //   22: aload_2
    //   23: invokevirtual toString : ()Ljava/lang/String;
    //   26: ldc ''
    //   28: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   31: astore_0
    //   32: aload_0
    //   33: invokestatic a : (Ljava/lang/String;)Z
    //   36: ifeq -> 45
    //   39: ldc com/alipay/apmobilesecuritysdk/e/g
    //   41: monitorexit
    //   42: ldc ''
    //   44: areturn
    //   45: invokestatic a : ()Ljava/lang/String;
    //   48: aload_0
    //   49: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   52: astore_0
    //   53: aload_0
    //   54: invokestatic a : (Ljava/lang/String;)Z
    //   57: ifeq -> 66
    //   60: ldc com/alipay/apmobilesecuritysdk/e/g
    //   62: monitorexit
    //   63: ldc ''
    //   65: areturn
    //   66: ldc com/alipay/apmobilesecuritysdk/e/g
    //   68: monitorexit
    //   69: aload_0
    //   70: areturn
    //   71: astore_0
    //   72: ldc com/alipay/apmobilesecuritysdk/e/g
    //   74: monitorexit
    //   75: aload_0
    //   76: athrow
    // Exception table:
    //   from	to	target	type
    //   3	39	71	finally
    //   45	60	71	finally
  }
  
  public static void a() {
    /* monitor enter TypeReferenceDotClassExpression{ObjectType{com/alipay/apmobilesecuritysdk/e/g}} */
    /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/alipay/apmobilesecuritysdk/e/g}} */
  }
  
  public static void a(Context paramContext) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/g
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc 'openapi_file_pri'
    //   6: iconst_0
    //   7: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   10: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   15: astore_0
    //   16: aload_0
    //   17: ifnull -> 34
    //   20: aload_0
    //   21: invokeinterface clear : ()Landroid/content/SharedPreferences$Editor;
    //   26: pop
    //   27: aload_0
    //   28: invokeinterface commit : ()Z
    //   33: pop
    //   34: ldc com/alipay/apmobilesecuritysdk/e/g
    //   36: monitorexit
    //   37: return
    //   38: astore_0
    //   39: ldc com/alipay/apmobilesecuritysdk/e/g
    //   41: monitorexit
    //   42: aload_0
    //   43: athrow
    // Exception table:
    //   from	to	target	type
    //   3	16	38	finally
    //   20	34	38	finally
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2) {
    /* monitor enter TypeReferenceDotClassExpression{ObjectType{com/alipay/apmobilesecuritysdk/e/g}} */
    try {
      SharedPreferences.Editor editor = paramContext.getSharedPreferences("openapi_file_pri", 0).edit();
      return;
    } finally {
      paramContext = null;
      /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/alipay/apmobilesecuritysdk/e/g}} */
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\apmobilesecuritysdk\e\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */