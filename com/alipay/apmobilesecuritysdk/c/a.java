package com.alipay.apmobilesecuritysdk.c;

import android.content.Context;

public final class a {
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/c/a
    //   2: monitorenter
    //   3: aload_0
    //   4: aload_1
    //   5: aload_2
    //   6: aload_3
    //   7: invokestatic b : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/alipay/security/mobile/module/d/a;
    //   10: astore_1
    //   11: new java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial <init> : ()V
    //   18: astore_2
    //   19: aload_2
    //   20: aload_0
    //   21: invokevirtual getFilesDir : ()Ljava/io/File;
    //   24: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   27: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload_2
    //   32: ldc '/log/ap'
    //   34: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_2
    //   39: invokevirtual toString : ()Ljava/lang/String;
    //   42: astore_0
    //   43: invokestatic getInstance : ()Ljava/util/Calendar;
    //   46: invokevirtual getTime : ()Ljava/util/Date;
    //   49: astore_2
    //   50: new java/text/SimpleDateFormat
    //   53: dup
    //   54: ldc 'yyyyMMdd'
    //   56: invokespecial <init> : (Ljava/lang/String;)V
    //   59: aload_2
    //   60: invokevirtual format : (Ljava/util/Date;)Ljava/lang/String;
    //   63: astore_2
    //   64: new java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: astore_3
    //   72: aload_3
    //   73: aload_2
    //   74: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_3
    //   79: ldc '.log'
    //   81: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload_0
    //   86: aload_3
    //   87: invokevirtual toString : ()Ljava/lang/String;
    //   90: aload_1
    //   91: invokevirtual toString : ()Ljava/lang/String;
    //   94: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   97: ldc com/alipay/apmobilesecuritysdk/c/a
    //   99: monitorexit
    //   100: return
    //   101: astore_0
    //   102: ldc com/alipay/apmobilesecuritysdk/c/a
    //   104: monitorexit
    //   105: aload_0
    //   106: athrow
    // Exception table:
    //   from	to	target	type
    //   3	97	101	finally
  }
  
  public static void a(String paramString) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/c/a
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic a : (Ljava/lang/String;)V
    //   7: ldc com/alipay/apmobilesecuritysdk/c/a
    //   9: monitorexit
    //   10: return
    //   11: astore_0
    //   12: ldc com/alipay/apmobilesecuritysdk/c/a
    //   14: monitorexit
    //   15: aload_0
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	11	finally
  }
  
  public static void a(Throwable paramThrowable) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/c/a
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic a : (Ljava/lang/Throwable;)V
    //   7: ldc com/alipay/apmobilesecuritysdk/c/a
    //   9: monitorexit
    //   10: return
    //   11: astore_0
    //   12: ldc com/alipay/apmobilesecuritysdk/c/a
    //   14: monitorexit
    //   15: aload_0
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	11	finally
  }
  
  private static com.alipay.security.mobile.module.d.a b(Context paramContext, String paramString1, String paramString2, String paramString3) {
    String str;
    try {
      str = paramContext.getPackageName();
    } finally {
      paramContext = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\apmobilesecuritysdk\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */