package com.alipay.sdk.app;

import android.app.Activity;
import android.os.Bundle;
import java.util.concurrent.ConcurrentHashMap;

public class AlipayResultActivity extends Activity {
  public static final ConcurrentHashMap<String, a> a = new ConcurrentHashMap<String, a>();
  
  private void a(String paramString, Bundle paramBundle) {
    null = a.remove(paramString);
    if (null == null) {
      finish();
      return;
    } 
    try {
      null.a(paramBundle.getInt("endCode"), paramBundle.getString("memo"), paramBundle.getString("result"));
      return;
    } finally {
      finish();
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial onCreate : (Landroid/os/Bundle;)V
    //   5: aload_0
    //   6: invokevirtual getIntent : ()Landroid/content/Intent;
    //   9: astore #7
    //   11: aconst_null
    //   12: astore_3
    //   13: aload_3
    //   14: astore_1
    //   15: aload #7
    //   17: ldc 'session'
    //   19: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   22: astore #5
    //   24: aload_3
    //   25: astore_1
    //   26: aload #7
    //   28: ldc 'result'
    //   30: invokevirtual getBundleExtra : (Ljava/lang/String;)Landroid/os/Bundle;
    //   33: astore #4
    //   35: aload_3
    //   36: astore_1
    //   37: aload #7
    //   39: ldc 'scene'
    //   41: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   44: astore #8
    //   46: aload_3
    //   47: astore_1
    //   48: aload #5
    //   50: invokestatic a : (Ljava/lang/String;)Lcom/alipay/sdk/sys/a;
    //   53: astore #6
    //   55: aload #6
    //   57: ifnonnull -> 68
    //   60: aload #6
    //   62: astore_1
    //   63: aload_0
    //   64: invokevirtual finish : ()V
    //   67: return
    //   68: aload #6
    //   70: astore_1
    //   71: new java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial <init> : ()V
    //   78: astore_3
    //   79: aload #6
    //   81: astore_1
    //   82: aload_3
    //   83: aload #5
    //   85: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload #6
    //   91: astore_1
    //   92: aload_3
    //   93: ldc '|'
    //   95: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload #6
    //   101: astore_1
    //   102: aload_3
    //   103: invokestatic elapsedRealtime : ()J
    //   106: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload #6
    //   112: astore_1
    //   113: aload #6
    //   115: ldc 'biz'
    //   117: ldc 'BSPSession'
    //   119: aload_3
    //   120: invokevirtual toString : ()Ljava/lang/String;
    //   123: invokestatic b : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   126: ldc 'mqpSchemePay'
    //   128: aload #8
    //   130: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   133: ifeq -> 145
    //   136: aload_0
    //   137: aload #5
    //   139: aload #4
    //   141: invokespecial a : (Ljava/lang/String;Landroid/os/Bundle;)V
    //   144: return
    //   145: aload #5
    //   147: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   150: ifne -> 164
    //   153: aload #5
    //   155: astore_1
    //   156: aload #4
    //   158: astore_3
    //   159: aload #4
    //   161: ifnonnull -> 345
    //   164: aload #7
    //   166: invokevirtual getData : ()Landroid/net/Uri;
    //   169: astore #8
    //   171: aload #5
    //   173: astore_1
    //   174: aload #4
    //   176: astore_3
    //   177: aload #8
    //   179: ifnull -> 345
    //   182: aload #5
    //   184: astore_3
    //   185: new org/json/JSONObject
    //   188: dup
    //   189: new java/lang/String
    //   192: dup
    //   193: aload #7
    //   195: invokevirtual getData : ()Landroid/net/Uri;
    //   198: invokevirtual getQuery : ()Ljava/lang/String;
    //   201: iconst_2
    //   202: invokestatic decode : (Ljava/lang/String;I)[B
    //   205: ldc 'UTF-8'
    //   207: invokespecial <init> : ([BLjava/lang/String;)V
    //   210: invokespecial <init> : (Ljava/lang/String;)V
    //   213: astore_1
    //   214: aload #5
    //   216: astore_3
    //   217: aload_1
    //   218: ldc 'result'
    //   220: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   223: astore #7
    //   225: aload #5
    //   227: astore_3
    //   228: aload_1
    //   229: ldc 'session'
    //   231: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   234: astore_1
    //   235: aload_1
    //   236: astore_3
    //   237: aload #6
    //   239: ldc 'biz'
    //   241: ldc 'BSPUriSession'
    //   243: aload_1
    //   244: invokestatic b : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   247: aload_1
    //   248: astore_3
    //   249: new android/os/Bundle
    //   252: dup
    //   253: invokespecial <init> : ()V
    //   256: astore #5
    //   258: aload #7
    //   260: invokevirtual keys : ()Ljava/util/Iterator;
    //   263: astore_3
    //   264: aload_3
    //   265: invokeinterface hasNext : ()Z
    //   270: ifeq -> 301
    //   273: aload_3
    //   274: invokeinterface next : ()Ljava/lang/Object;
    //   279: checkcast java/lang/String
    //   282: astore #4
    //   284: aload #5
    //   286: aload #4
    //   288: aload #7
    //   290: aload #4
    //   292: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   295: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   298: goto -> 264
    //   301: aload #5
    //   303: astore_3
    //   304: goto -> 345
    //   307: astore_3
    //   308: aload #5
    //   310: astore #4
    //   312: goto -> 322
    //   315: astore #5
    //   317: aload_3
    //   318: astore_1
    //   319: aload #5
    //   321: astore_3
    //   322: aload #6
    //   324: ldc 'biz'
    //   326: ldc 'BSPResEx'
    //   328: aload_3
    //   329: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   332: aload #6
    //   334: ldc 'biz'
    //   336: ldc 'ParseSchemeQueryError'
    //   338: aload_3
    //   339: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   342: aload #4
    //   344: astore_3
    //   345: aload_1
    //   346: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   349: istore_2
    //   350: iload_2
    //   351: ifne -> 449
    //   354: aload_3
    //   355: ifnonnull -> 361
    //   358: goto -> 449
    //   361: new java/lang/StringBuilder
    //   364: dup
    //   365: invokespecial <init> : ()V
    //   368: astore #4
    //   370: aload #4
    //   372: ldc ''
    //   374: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: pop
    //   378: aload #4
    //   380: invokestatic elapsedRealtime : ()J
    //   383: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   386: pop
    //   387: aload #6
    //   389: ldc 'biz'
    //   391: ldc 'PgReturn'
    //   393: aload #4
    //   395: invokevirtual toString : ()Ljava/lang/String;
    //   398: invokestatic b : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   401: aload_1
    //   402: sipush #9000
    //   405: ldc 'OK'
    //   407: aload_3
    //   408: invokestatic a : (Ljava/lang/String;ILjava/lang/String;Landroid/os/Bundle;)V
    //   411: aload_0
    //   412: aload #6
    //   414: ldc ''
    //   416: aload #6
    //   418: getfield p : Ljava/lang/String;
    //   421: invokestatic b : (Landroid/content/Context;Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;)V
    //   424: aload_0
    //   425: invokevirtual finish : ()V
    //   428: return
    //   429: astore_1
    //   430: aload_0
    //   431: aload #6
    //   433: ldc ''
    //   435: aload #6
    //   437: getfield p : Ljava/lang/String;
    //   440: invokestatic b : (Landroid/content/Context;Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;)V
    //   443: aload_0
    //   444: invokevirtual finish : ()V
    //   447: aload_1
    //   448: athrow
    //   449: aload_0
    //   450: aload #6
    //   452: ldc ''
    //   454: aload #6
    //   456: getfield p : Ljava/lang/String;
    //   459: invokestatic b : (Landroid/content/Context;Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;)V
    //   462: aload_0
    //   463: invokevirtual finish : ()V
    //   466: return
    //   467: astore_3
    //   468: aload_1
    //   469: ldc 'biz'
    //   471: ldc 'BSPSerError'
    //   473: aload_3
    //   474: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   477: aload_1
    //   478: ldc 'biz'
    //   480: ldc 'ParseBundleSerializableError'
    //   482: aload_3
    //   483: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   486: aload_0
    //   487: invokevirtual finish : ()V
    //   490: return
    //   491: aload_0
    //   492: invokevirtual finish : ()V
    //   495: return
    //   496: astore_1
    //   497: goto -> 491
    // Exception table:
    //   from	to	target	type
    //   5	11	496	finally
    //   15	24	467	finally
    //   26	35	467	finally
    //   37	46	467	finally
    //   48	55	467	finally
    //   63	67	467	finally
    //   71	79	467	finally
    //   82	89	467	finally
    //   92	99	467	finally
    //   102	110	467	finally
    //   113	126	467	finally
    //   126	144	496	finally
    //   145	153	496	finally
    //   164	171	496	finally
    //   185	214	315	finally
    //   217	225	315	finally
    //   228	235	315	finally
    //   237	247	315	finally
    //   249	258	315	finally
    //   258	264	307	finally
    //   264	298	307	finally
    //   322	342	496	finally
    //   345	350	496	finally
    //   361	411	429	finally
    //   411	428	496	finally
    //   430	449	496	finally
    //   449	466	496	finally
    //   468	490	496	finally
  }
  
  public static interface a {
    void a(int param1Int, String param1String1, String param1String2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\app\AlipayResultActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */