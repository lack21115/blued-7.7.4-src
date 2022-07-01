package cn.com.chinatelecom.account.a;

import android.content.Context;

public class a {
  public static String a(Context paramContext, String paramString1, String paramString2) {
    // Byte code:
    //   0: ldc ''
    //   2: astore_0
    //   3: aconst_null
    //   4: astore #5
    //   6: aconst_null
    //   7: astore #4
    //   9: new java/net/URL
    //   12: dup
    //   13: aload_1
    //   14: invokespecial <init> : (Ljava/lang/String;)V
    //   17: invokevirtual openConnection : ()Ljava/net/URLConnection;
    //   20: checkcast java/net/HttpURLConnection
    //   23: astore_1
    //   24: aload_1
    //   25: ldc 'accept'
    //   27: ldc '*/*'
    //   29: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_1
    //   33: ldc 'POST'
    //   35: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   38: aload_1
    //   39: iconst_1
    //   40: invokevirtual setDoOutput : (Z)V
    //   43: aload_1
    //   44: iconst_1
    //   45: invokevirtual setDoInput : (Z)V
    //   48: aload_1
    //   49: sipush #5000
    //   52: invokevirtual setConnectTimeout : (I)V
    //   55: aload_1
    //   56: sipush #5000
    //   59: invokevirtual setReadTimeout : (I)V
    //   62: aload_1
    //   63: iconst_0
    //   64: invokevirtual setUseCaches : (Z)V
    //   67: aload_1
    //   68: ldc 'Accept-Charset'
    //   70: ldc 'UTF-8'
    //   72: invokevirtual addRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   75: aload_2
    //   76: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   79: ifne -> 122
    //   82: new java/io/DataOutputStream
    //   85: dup
    //   86: new java/io/BufferedOutputStream
    //   89: dup
    //   90: aload_1
    //   91: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   94: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   97: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   100: astore_3
    //   101: aload_3
    //   102: aload_2
    //   103: ldc 'UTF-8'
    //   105: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   108: invokevirtual write : ([B)V
    //   111: aload_3
    //   112: invokevirtual flush : ()V
    //   115: aload_3
    //   116: invokevirtual close : ()V
    //   119: goto -> 126
    //   122: aload_1
    //   123: invokevirtual connect : ()V
    //   126: aload_1
    //   127: invokevirtual getResponseCode : ()I
    //   130: sipush #200
    //   133: if_icmpne -> 223
    //   136: aload_1
    //   137: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   140: astore_3
    //   141: new java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial <init> : ()V
    //   148: astore_2
    //   149: new java/io/BufferedReader
    //   152: dup
    //   153: new java/io/InputStreamReader
    //   156: dup
    //   157: aload_3
    //   158: invokespecial <init> : (Ljava/io/InputStream;)V
    //   161: invokespecial <init> : (Ljava/io/Reader;)V
    //   164: astore_1
    //   165: aload_1
    //   166: invokevirtual readLine : ()Ljava/lang/String;
    //   169: astore #4
    //   171: aload #4
    //   173: ifnull -> 193
    //   176: aload_2
    //   177: aload #4
    //   179: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload_2
    //   184: ldc '\\n'
    //   186: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: goto -> 165
    //   193: aload_2
    //   194: invokevirtual toString : ()Ljava/lang/String;
    //   197: astore_2
    //   198: aload_2
    //   199: astore_0
    //   200: aload_3
    //   201: astore_2
    //   202: goto -> 227
    //   205: astore_2
    //   206: goto -> 213
    //   209: astore_2
    //   210: aload #4
    //   212: astore_1
    //   213: aload_2
    //   214: astore #4
    //   216: aload_1
    //   217: astore_2
    //   218: aload_3
    //   219: astore_1
    //   220: goto -> 267
    //   223: aconst_null
    //   224: astore_2
    //   225: aload_2
    //   226: astore_1
    //   227: aload_1
    //   228: ifnull -> 240
    //   231: aload_0
    //   232: astore_3
    //   233: aload_1
    //   234: invokevirtual close : ()V
    //   237: goto -> 240
    //   240: aload_0
    //   241: astore_3
    //   242: aload_2
    //   243: ifnull -> 296
    //   246: aload_0
    //   247: astore_3
    //   248: aload_2
    //   249: invokevirtual close : ()V
    //   252: aload_0
    //   253: areturn
    //   254: aload_0
    //   255: invokevirtual printStackTrace : ()V
    //   258: aload_3
    //   259: areturn
    //   260: astore #4
    //   262: aconst_null
    //   263: astore_1
    //   264: aload #5
    //   266: astore_2
    //   267: aload #4
    //   269: invokevirtual printStackTrace : ()V
    //   272: aload_2
    //   273: ifnull -> 282
    //   276: aload_0
    //   277: astore_3
    //   278: aload_2
    //   279: invokevirtual close : ()V
    //   282: aload_0
    //   283: astore_3
    //   284: aload_1
    //   285: ifnull -> 296
    //   288: aload_0
    //   289: astore_3
    //   290: aload_1
    //   291: invokevirtual close : ()V
    //   294: aload_0
    //   295: astore_3
    //   296: aload_3
    //   297: areturn
    //   298: astore_0
    //   299: aload_2
    //   300: ifnull -> 310
    //   303: aload_2
    //   304: invokevirtual close : ()V
    //   307: goto -> 310
    //   310: aload_1
    //   311: ifnull -> 325
    //   314: aload_1
    //   315: invokevirtual close : ()V
    //   318: goto -> 325
    //   321: aload_1
    //   322: invokevirtual printStackTrace : ()V
    //   325: aload_0
    //   326: athrow
    //   327: astore_0
    //   328: goto -> 254
    //   331: astore_1
    //   332: goto -> 321
    // Exception table:
    //   from	to	target	type
    //   9	119	260	finally
    //   122	126	260	finally
    //   126	141	260	finally
    //   141	165	209	finally
    //   165	171	205	finally
    //   176	190	205	finally
    //   193	198	205	finally
    //   233	237	327	java/lang/Exception
    //   248	252	327	java/lang/Exception
    //   267	272	298	finally
    //   278	282	327	java/lang/Exception
    //   290	294	327	java/lang/Exception
    //   303	307	331	java/lang/Exception
    //   314	318	331	java/lang/Exception
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\com\chinatelecom\account\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */