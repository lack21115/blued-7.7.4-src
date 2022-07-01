package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import java.util.Map;

public final class b {
  public static Map<String, String> a(Context paramContext, Map<String, String> paramMap) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/d/b
    //   2: monitorenter
    //   3: new java/util/HashMap
    //   6: dup
    //   7: invokespecial <init> : ()V
    //   10: astore_2
    //   11: aload_1
    //   12: ldc 'tid'
    //   14: ldc ''
    //   16: invokestatic a : (Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   19: astore_3
    //   20: aload_1
    //   21: ldc 'utdid'
    //   23: ldc ''
    //   25: invokestatic a : (Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   28: astore #4
    //   30: aload_1
    //   31: ldc 'userId'
    //   33: ldc ''
    //   35: invokestatic a : (Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   38: astore #5
    //   40: aload_1
    //   41: ldc 'appName'
    //   43: ldc ''
    //   45: invokestatic a : (Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   48: astore #6
    //   50: aload_1
    //   51: ldc 'appKeyClient'
    //   53: ldc ''
    //   55: invokestatic a : (Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   58: astore #7
    //   60: aload_1
    //   61: ldc 'tmxSessionId'
    //   63: ldc ''
    //   65: invokestatic a : (Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   68: astore #8
    //   70: aload_0
    //   71: invokestatic f : (Landroid/content/Context;)Ljava/lang/String;
    //   74: astore_0
    //   75: aload_1
    //   76: ldc 'sessionId'
    //   78: ldc ''
    //   80: invokestatic a : (Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   83: astore_1
    //   84: aload_2
    //   85: ldc 'AC1'
    //   87: aload_3
    //   88: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   93: pop
    //   94: aload_2
    //   95: ldc 'AC2'
    //   97: aload #4
    //   99: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   104: pop
    //   105: aload_2
    //   106: ldc 'AC3'
    //   108: ldc ''
    //   110: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   115: pop
    //   116: aload_2
    //   117: ldc 'AC4'
    //   119: aload_0
    //   120: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   125: pop
    //   126: aload_2
    //   127: ldc 'AC5'
    //   129: aload #5
    //   131: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   136: pop
    //   137: aload_2
    //   138: ldc 'AC6'
    //   140: aload #8
    //   142: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   147: pop
    //   148: aload_2
    //   149: ldc 'AC7'
    //   151: ldc ''
    //   153: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   158: pop
    //   159: aload_2
    //   160: ldc 'AC8'
    //   162: aload #6
    //   164: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   169: pop
    //   170: aload_2
    //   171: ldc 'AC9'
    //   173: aload #7
    //   175: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   180: pop
    //   181: aload_1
    //   182: invokestatic b : (Ljava/lang/String;)Z
    //   185: ifeq -> 198
    //   188: aload_2
    //   189: ldc 'AC10'
    //   191: aload_1
    //   192: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   197: pop
    //   198: ldc com/alipay/apmobilesecuritysdk/d/b
    //   200: monitorexit
    //   201: aload_2
    //   202: areturn
    //   203: astore_0
    //   204: ldc com/alipay/apmobilesecuritysdk/d/b
    //   206: monitorexit
    //   207: aload_0
    //   208: athrow
    // Exception table:
    //   from	to	target	type
    //   3	198	203	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\apmobilesecuritysdk\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */