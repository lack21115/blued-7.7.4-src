package com.tencent.tbs.sdk.extension.partner.c;

import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class e {
  public static String a(String paramString, Map<String, String> paramMap, byte[] paramArrayOfbyte, a parama, boolean paramBoolean1, boolean paramBoolean2) {
    String str = null;
    if (paramArrayOfbyte == null)
      return null; 
    HttpURLConnection httpURLConnection = a(paramString, paramMap);
    paramString = str;
    if (httpURLConnection != null) {
      if (paramBoolean1) {
        a(httpURLConnection, paramArrayOfbyte);
      } else {
        b(httpURLConnection, paramArrayOfbyte);
      } 
      paramString = a(httpURLConnection, parama, paramBoolean2);
    } 
    return paramString;
  }
  
  public static String a(String paramString, byte[] paramArrayOfbyte, a parama, boolean paramBoolean) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #7
    //   3: aconst_null
    //   4: astore #6
    //   6: invokestatic a : ()Lcom/tencent/tbs/sdk/extension/partner/c/f;
    //   9: invokevirtual b : ()Ljava/lang/String;
    //   12: astore #5
    //   14: new java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial <init> : ()V
    //   21: astore #8
    //   23: aload #8
    //   25: aload_0
    //   26: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload #8
    //   32: aload #5
    //   34: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload #8
    //   40: invokevirtual toString : ()Ljava/lang/String;
    //   43: astore_0
    //   44: new java/net/URL
    //   47: dup
    //   48: aload_0
    //   49: invokespecial <init> : (Ljava/lang/String;)V
    //   52: astore #5
    //   54: new java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial <init> : ()V
    //   61: astore #8
    //   63: aload #8
    //   65: ldc '[postData] - postUrl: '
    //   67: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload #8
    //   73: aload_0
    //   74: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload #8
    //   80: invokevirtual toString : ()Ljava/lang/String;
    //   83: pop
    //   84: aload #5
    //   86: invokevirtual openConnection : ()Ljava/net/URLConnection;
    //   89: checkcast java/net/HttpURLConnection
    //   92: astore #8
    //   94: aload #8
    //   96: ldc 'POST'
    //   98: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   101: aload #8
    //   103: iconst_1
    //   104: invokevirtual setDoOutput : (Z)V
    //   107: aload #8
    //   109: iconst_1
    //   110: invokevirtual setDoInput : (Z)V
    //   113: aload #8
    //   115: iconst_0
    //   116: invokevirtual setUseCaches : (Z)V
    //   119: aload #8
    //   121: sipush #20000
    //   124: invokevirtual setConnectTimeout : (I)V
    //   127: getstatic android/os/Build$VERSION.SDK_INT : I
    //   130: bipush #13
    //   132: if_icmple -> 145
    //   135: ldc 'Connection'
    //   137: astore_0
    //   138: ldc 'close'
    //   140: astore #5
    //   142: goto -> 152
    //   145: ldc 'http.keepAlive'
    //   147: astore_0
    //   148: ldc 'false'
    //   150: astore #5
    //   152: aload #8
    //   154: aload_0
    //   155: aload #5
    //   157: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   160: invokestatic a : ()Lcom/tencent/tbs/sdk/extension/partner/c/f;
    //   163: aload_1
    //   164: invokevirtual a : ([B)[B
    //   167: astore_0
    //   168: aload_0
    //   169: astore_1
    //   170: goto -> 178
    //   173: astore_0
    //   174: aload_0
    //   175: invokevirtual printStackTrace : ()V
    //   178: aload_1
    //   179: ifnonnull -> 184
    //   182: aconst_null
    //   183: areturn
    //   184: aload #8
    //   186: ldc 'Content-Type'
    //   188: ldc 'application/x-www-form-urlencoded'
    //   190: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   193: aload #8
    //   195: ldc 'Content-Length'
    //   197: aload_1
    //   198: arraylength
    //   199: invokestatic valueOf : (I)Ljava/lang/String;
    //   202: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   205: aload #6
    //   207: astore_0
    //   208: aload #8
    //   210: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   213: astore #5
    //   215: aload #6
    //   217: astore_0
    //   218: aload #5
    //   220: aload_1
    //   221: invokevirtual write : ([B)V
    //   224: aload #6
    //   226: astore_0
    //   227: aload #5
    //   229: invokevirtual flush : ()V
    //   232: aload #6
    //   234: astore_0
    //   235: aload #8
    //   237: invokevirtual getResponseCode : ()I
    //   240: istore #4
    //   242: aload_2
    //   243: ifnull -> 257
    //   246: aload #6
    //   248: astore_0
    //   249: aload_2
    //   250: iload #4
    //   252: invokeinterface a : (I)V
    //   257: aload #7
    //   259: astore_0
    //   260: iload #4
    //   262: sipush #200
    //   265: if_icmpne -> 549
    //   268: aload #6
    //   270: astore_0
    //   271: aload #8
    //   273: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   276: astore_1
    //   277: aload #6
    //   279: astore_0
    //   280: aload #8
    //   282: invokevirtual getContentEncoding : ()Ljava/lang/String;
    //   285: astore_2
    //   286: aload_2
    //   287: ifnull -> 317
    //   290: aload #6
    //   292: astore_0
    //   293: aload_2
    //   294: ldc 'gzip'
    //   296: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   299: ifeq -> 317
    //   302: aload #6
    //   304: astore_0
    //   305: new java/util/zip/GZIPInputStream
    //   308: dup
    //   309: aload_1
    //   310: invokespecial <init> : (Ljava/io/InputStream;)V
    //   313: astore_1
    //   314: goto -> 356
    //   317: aload_2
    //   318: ifnull -> 554
    //   321: aload #6
    //   323: astore_0
    //   324: aload_2
    //   325: ldc 'deflate'
    //   327: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   330: ifeq -> 554
    //   333: aload #6
    //   335: astore_0
    //   336: new java/util/zip/InflaterInputStream
    //   339: dup
    //   340: aload_1
    //   341: new java/util/zip/Inflater
    //   344: dup
    //   345: iconst_1
    //   346: invokespecial <init> : (Z)V
    //   349: invokespecial <init> : (Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   352: astore_1
    //   353: goto -> 356
    //   356: aload #6
    //   358: astore_0
    //   359: new java/io/ByteArrayOutputStream
    //   362: dup
    //   363: invokespecial <init> : ()V
    //   366: astore_2
    //   367: aload #6
    //   369: astore_0
    //   370: sipush #128
    //   373: newarray byte
    //   375: astore #5
    //   377: aload #6
    //   379: astore_0
    //   380: aload_1
    //   381: aload #5
    //   383: invokevirtual read : ([B)I
    //   386: istore #4
    //   388: iload #4
    //   390: iconst_m1
    //   391: if_icmpeq -> 409
    //   394: aload #6
    //   396: astore_0
    //   397: aload_2
    //   398: aload #5
    //   400: iconst_0
    //   401: iload #4
    //   403: invokevirtual write : ([BII)V
    //   406: goto -> 377
    //   409: aload #6
    //   411: astore_0
    //   412: new java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial <init> : ()V
    //   419: astore_1
    //   420: aload #6
    //   422: astore_0
    //   423: aload_1
    //   424: ldc '[postData] - bos: '
    //   426: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: pop
    //   430: aload #6
    //   432: astore_0
    //   433: aload_1
    //   434: aload_2
    //   435: invokevirtual toString : ()Ljava/lang/String;
    //   438: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: aload #6
    //   444: astore_0
    //   445: aload_1
    //   446: ldc ', bos.len: '
    //   448: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: aload #6
    //   454: astore_0
    //   455: aload_1
    //   456: aload_2
    //   457: invokevirtual size : ()I
    //   460: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   463: pop
    //   464: aload #6
    //   466: astore_0
    //   467: aload_1
    //   468: ldc ', bos-array: '
    //   470: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: pop
    //   474: aload #6
    //   476: astore_0
    //   477: aload_1
    //   478: aload_2
    //   479: invokevirtual toByteArray : ()[B
    //   482: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   485: pop
    //   486: aload #6
    //   488: astore_0
    //   489: aload_1
    //   490: invokevirtual toString : ()Ljava/lang/String;
    //   493: pop
    //   494: iload_3
    //   495: ifeq -> 524
    //   498: aload #6
    //   500: astore_0
    //   501: new java/lang/String
    //   504: dup
    //   505: invokestatic a : ()Lcom/tencent/tbs/sdk/extension/partner/c/f;
    //   508: aload_2
    //   509: invokevirtual toByteArray : ()[B
    //   512: invokevirtual c : ([B)[B
    //   515: invokespecial <init> : ([B)V
    //   518: astore_1
    //   519: aload_1
    //   520: astore_0
    //   521: goto -> 534
    //   524: aload #6
    //   526: astore_0
    //   527: aload_2
    //   528: invokevirtual toString : ()Ljava/lang/String;
    //   531: astore_1
    //   532: aload_1
    //   533: astore_0
    //   534: aload_0
    //   535: astore_1
    //   536: aload_1
    //   537: astore_0
    //   538: aload_2
    //   539: invokevirtual close : ()V
    //   542: aload_1
    //   543: areturn
    //   544: astore_1
    //   545: aload_1
    //   546: invokevirtual printStackTrace : ()V
    //   549: aload_0
    //   550: areturn
    //   551: astore_0
    //   552: aconst_null
    //   553: areturn
    //   554: goto -> 356
    // Exception table:
    //   from	to	target	type
    //   6	101	551	java/lang/Exception
    //   160	168	173	java/lang/Exception
    //   208	215	544	java/lang/Throwable
    //   218	224	544	java/lang/Throwable
    //   227	232	544	java/lang/Throwable
    //   235	242	544	java/lang/Throwable
    //   249	257	544	java/lang/Throwable
    //   271	277	544	java/lang/Throwable
    //   280	286	544	java/lang/Throwable
    //   293	302	544	java/lang/Throwable
    //   305	314	544	java/lang/Throwable
    //   324	333	544	java/lang/Throwable
    //   336	353	544	java/lang/Throwable
    //   359	367	544	java/lang/Throwable
    //   370	377	544	java/lang/Throwable
    //   380	388	544	java/lang/Throwable
    //   397	406	544	java/lang/Throwable
    //   412	420	544	java/lang/Throwable
    //   423	430	544	java/lang/Throwable
    //   433	442	544	java/lang/Throwable
    //   445	452	544	java/lang/Throwable
    //   455	464	544	java/lang/Throwable
    //   467	474	544	java/lang/Throwable
    //   477	486	544	java/lang/Throwable
    //   489	494	544	java/lang/Throwable
    //   501	519	544	java/lang/Throwable
    //   527	532	544	java/lang/Throwable
    //   538	542	544	java/lang/Throwable
  }
  
  private static String a(HttpURLConnection paramHttpURLConnection, a parama, boolean paramBoolean) {
    Throwable throwable1;
    Exception exception;
    a a1;
    ByteArrayOutputStream byteArrayOutputStream = null;
    String str = null;
    try {
    
    } catch (Throwable throwable2) {
    
    } finally {
      parama = null;
      Throwable throwable = null;
      throwable1 = throwable2;
    } 
    try {
      throwable2.printStackTrace();
      return null;
    } finally {
      Exception exception1 = null;
      a1 = parama;
    } 
    a((Closeable)throwable1);
    a((Closeable)a1);
    throw exception;
  }
  
  private static HttpURLConnection a(String paramString, Map<String, String> paramMap) {
    String str = null;
    try {
      HttpURLConnection httpURLConnection = (HttpURLConnection)(new URL(paramString)).openConnection();
      try {
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setConnectTimeout(20000);
        if (Build.VERSION.SDK_INT > 13) {
          paramString = "Connection";
          str = "close";
        } else {
          paramString = "http.keepAlive";
          str = "false";
        } 
        httpURLConnection.setRequestProperty(paramString, str);
        for (Map.Entry<String, String> entry : paramMap.entrySet())
          httpURLConnection.setRequestProperty((String)entry.getKey(), (String)entry.getValue()); 
        return httpURLConnection;
      } catch (Exception null) {
        HttpURLConnection httpURLConnection1 = httpURLConnection;
      } 
    } catch (Exception exception) {
      paramString = str;
    } 
    exception.printStackTrace();
    return (HttpURLConnection)paramString;
  }
  
  private static void a(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
        return;
      } catch (Exception exception) {
        return;
      }  
  }
  
  private static void a(HttpURLConnection paramHttpURLConnection, byte[] paramArrayOfbyte) {
    // Byte code:
    //   0: new java/util/zip/GZIPOutputStream
    //   3: dup
    //   4: new java/io/BufferedOutputStream
    //   7: dup
    //   8: aload_0
    //   9: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   12: ldc 204800
    //   14: invokespecial <init> : (Ljava/io/OutputStream;I)V
    //   17: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   20: astore_0
    //   21: aload_0
    //   22: astore_2
    //   23: aload_0
    //   24: aload_1
    //   25: invokevirtual write : ([B)V
    //   28: aload_0
    //   29: astore_2
    //   30: aload_0
    //   31: invokevirtual flush : ()V
    //   34: goto -> 56
    //   37: astore_1
    //   38: goto -> 50
    //   41: astore_0
    //   42: aconst_null
    //   43: astore_2
    //   44: goto -> 66
    //   47: astore_1
    //   48: aconst_null
    //   49: astore_0
    //   50: aload_0
    //   51: astore_2
    //   52: aload_1
    //   53: invokevirtual printStackTrace : ()V
    //   56: aconst_null
    //   57: invokestatic a : (Ljava/io/Closeable;)V
    //   60: aload_0
    //   61: invokestatic a : (Ljava/io/Closeable;)V
    //   64: return
    //   65: astore_0
    //   66: aconst_null
    //   67: invokestatic a : (Ljava/io/Closeable;)V
    //   70: aload_2
    //   71: invokestatic a : (Ljava/io/Closeable;)V
    //   74: aload_0
    //   75: athrow
    // Exception table:
    //   from	to	target	type
    //   0	21	47	java/lang/Exception
    //   0	21	41	finally
    //   23	28	37	java/lang/Exception
    //   23	28	65	finally
    //   30	34	37	java/lang/Exception
    //   30	34	65	finally
    //   52	56	65	finally
  }
  
  private static void b(HttpURLConnection paramHttpURLConnection, byte[] paramArrayOfbyte) {
    try {
      OutputStream outputStream = paramHttpURLConnection.getOutputStream();
      outputStream.write(paramArrayOfbyte);
      outputStream.flush();
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public static interface a {
    void a(int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\partner\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */