package com.alipay.apmobilesecuritysdk.f;

import android.content.Context;
import com.alipay.security.mobile.module.a.a.c;
import java.util.HashMap;

public class a {
  public static String a(Context paramContext, String paramString1, String paramString2) {
    String str2 = null;
    String str1 = str2;
    if (paramContext != null) {
      str1 = str2;
      if (!com.alipay.security.mobile.module.a.a.a(paramString1)) {
        if (com.alipay.security.mobile.module.a.a.a(paramString2))
          return null; 
        try {
          return com.alipay.security.mobile.module.a.a.a(str) ? null : c.b(c.a(), str);
        } finally {
          paramContext = null;
        } 
      } 
    } 
    return str1;
  }
  
  public static String a(String paramString1, String paramString2) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/f/a
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic a : (Ljava/lang/String;)Z
    //   7: ifne -> 86
    //   10: aload_1
    //   11: invokestatic a : (Ljava/lang/String;)Z
    //   14: istore_2
    //   15: iload_2
    //   16: ifeq -> 22
    //   19: goto -> 86
    //   22: aload_0
    //   23: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   26: astore_0
    //   27: aload_0
    //   28: invokestatic a : (Ljava/lang/String;)Z
    //   31: istore_2
    //   32: iload_2
    //   33: ifeq -> 41
    //   36: ldc com/alipay/apmobilesecuritysdk/f/a
    //   38: monitorexit
    //   39: aconst_null
    //   40: areturn
    //   41: new org/json/JSONObject
    //   44: dup
    //   45: aload_0
    //   46: invokespecial <init> : (Ljava/lang/String;)V
    //   49: aload_1
    //   50: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   53: astore_0
    //   54: aload_0
    //   55: invokestatic a : (Ljava/lang/String;)Z
    //   58: istore_2
    //   59: iload_2
    //   60: ifeq -> 68
    //   63: ldc com/alipay/apmobilesecuritysdk/f/a
    //   65: monitorexit
    //   66: aconst_null
    //   67: areturn
    //   68: invokestatic a : ()Ljava/lang/String;
    //   71: aload_0
    //   72: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   75: astore_0
    //   76: ldc com/alipay/apmobilesecuritysdk/f/a
    //   78: monitorexit
    //   79: aload_0
    //   80: areturn
    //   81: ldc com/alipay/apmobilesecuritysdk/f/a
    //   83: monitorexit
    //   84: aconst_null
    //   85: areturn
    //   86: ldc com/alipay/apmobilesecuritysdk/f/a
    //   88: monitorexit
    //   89: aconst_null
    //   90: areturn
    //   91: astore_0
    //   92: ldc com/alipay/apmobilesecuritysdk/f/a
    //   94: monitorexit
    //   95: aload_0
    //   96: athrow
    //   97: astore_0
    //   98: goto -> 81
    // Exception table:
    //   from	to	target	type
    //   3	15	91	finally
    //   22	32	97	finally
    //   36	39	91	finally
    //   41	59	97	finally
    //   63	66	91	finally
    //   68	76	97	finally
    //   76	79	91	finally
    //   81	84	91	finally
    //   86	89	91	finally
    //   92	95	91	finally
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3) {
    if (!com.alipay.security.mobile.module.a.a.a(paramString1) && !com.alipay.security.mobile.module.a.a.a(paramString2)) {
      if (paramContext == null)
        return; 
      try {
        paramString3 = c.a(c.a(), paramString3);
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        hashMap.put(paramString2, paramString3);
        return;
      } finally {
        paramContext = null;
      } 
    } 
  }
  
  public static void a(String paramString1, String paramString2, String paramString3) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/f/a
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic a : (Ljava/lang/String;)Z
    //   7: ifne -> 171
    //   10: aload_1
    //   11: invokestatic a : (Ljava/lang/String;)Z
    //   14: istore_3
    //   15: iload_3
    //   16: ifeq -> 22
    //   19: goto -> 171
    //   22: aload_0
    //   23: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   26: astore #5
    //   28: new org/json/JSONObject
    //   31: dup
    //   32: invokespecial <init> : ()V
    //   35: astore #4
    //   37: aload #5
    //   39: invokestatic b : (Ljava/lang/String;)Z
    //   42: istore_3
    //   43: iload_3
    //   44: ifeq -> 70
    //   47: new org/json/JSONObject
    //   50: dup
    //   51: aload #5
    //   53: invokespecial <init> : (Ljava/lang/String;)V
    //   56: astore #4
    //   58: goto -> 70
    //   61: new org/json/JSONObject
    //   64: dup
    //   65: invokespecial <init> : ()V
    //   68: astore #4
    //   70: aload #4
    //   72: aload_1
    //   73: invokestatic a : ()Ljava/lang/String;
    //   76: aload_2
    //   77: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   80: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   83: pop
    //   84: aload #4
    //   86: invokevirtual toString : ()Ljava/lang/String;
    //   89: pop
    //   90: aload_0
    //   91: invokestatic clearProperty : (Ljava/lang/String;)Ljava/lang/String;
    //   94: pop
    //   95: invokestatic a : ()Z
    //   98: ifeq -> 167
    //   101: new java/lang/StringBuilder
    //   104: dup
    //   105: ldc '.SystemConfig'
    //   107: invokespecial <init> : (Ljava/lang/String;)V
    //   110: astore_1
    //   111: aload_1
    //   112: getstatic java/io/File.separator : Ljava/lang/String;
    //   115: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload_1
    //   120: aload_0
    //   121: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload_1
    //   126: invokevirtual toString : ()Ljava/lang/String;
    //   129: astore_0
    //   130: invokestatic a : ()Z
    //   133: ifeq -> 167
    //   136: new java/io/File
    //   139: dup
    //   140: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   143: aload_0
    //   144: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   147: astore_0
    //   148: aload_0
    //   149: invokevirtual exists : ()Z
    //   152: ifeq -> 167
    //   155: aload_0
    //   156: invokevirtual isFile : ()Z
    //   159: ifeq -> 167
    //   162: aload_0
    //   163: invokevirtual delete : ()Z
    //   166: pop
    //   167: ldc com/alipay/apmobilesecuritysdk/f/a
    //   169: monitorexit
    //   170: return
    //   171: ldc com/alipay/apmobilesecuritysdk/f/a
    //   173: monitorexit
    //   174: return
    //   175: astore_0
    //   176: ldc com/alipay/apmobilesecuritysdk/f/a
    //   178: monitorexit
    //   179: aload_0
    //   180: athrow
    //   181: astore_0
    //   182: goto -> 167
    //   185: astore #4
    //   187: goto -> 61
    //   190: astore_1
    //   191: goto -> 95
    // Exception table:
    //   from	to	target	type
    //   3	15	175	finally
    //   22	43	181	finally
    //   47	58	185	java/lang/Exception
    //   47	58	181	finally
    //   61	70	181	finally
    //   70	90	181	finally
    //   90	95	190	finally
    //   95	130	181	finally
    //   130	167	181	java/lang/Exception
    //   130	167	181	finally
    //   167	170	175	finally
    //   171	174	175	finally
    //   176	179	175	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\apmobilesecuritysdk\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */