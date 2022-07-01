package com.bytedance.tea.crash.upload;

import android.text.TextUtils;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.bytedance.tea.crash.g.j;
import com.bytedance.tea.crash.h;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
  public static boolean a = false;
  
  private static c b;
  
  public static f a(long paramLong, String paramString1, byte[] paramArrayOfbyte, a parama, String paramString2, boolean paramBoolean) throws IOException {
    byte[] arrayOfByte1;
    byte[] arrayOfByte2;
    String str1;
    if (paramString1 == null)
      return new f(201); 
    byte[] arrayOfByte3 = paramArrayOfbyte;
    if (paramArrayOfbyte == null)
      arrayOfByte3 = new byte[0]; 
    int i = arrayOfByte3.length;
    String str2 = null;
    if (a.b == parama && i > 128) {
      paramArrayOfbyte = b(arrayOfByte3);
      str1 = "gzip";
    } else {
      str1 = str2;
      paramArrayOfbyte = arrayOfByte3;
      if (a.c == parama) {
        str1 = str2;
        paramArrayOfbyte = arrayOfByte3;
        if (i > 128) {
          paramArrayOfbyte = a(arrayOfByte3);
          str1 = "deflate";
        } 
      } 
    } 
    if (paramArrayOfbyte == null)
      return new f(202); 
    if (paramBoolean) {
      String str3;
      String str4;
      byte[] arrayOfByte = TTEncryptUtils.a(paramArrayOfbyte, paramArrayOfbyte.length);
      if (arrayOfByte != null) {
        if (TextUtils.isEmpty((new URL(paramString1)).getQuery())) {
          str3 = paramString1;
          if (!paramString1.endsWith("?")) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(paramString1);
            stringBuilder1.append("?");
            String str = stringBuilder1.toString();
          } 
        } else {
          str3 = paramString1;
          if (!paramString1.endsWith("&")) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(paramString1);
            stringBuilder1.append("&");
            str3 = stringBuilder1.toString();
          } 
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str3);
        stringBuilder.append("tt_data=a");
        str3 = stringBuilder.toString();
        arrayOfByte1 = arrayOfByte;
        paramString2 = "application/octet-stream;tt-data=a";
        arrayOfByte = arrayOfByte1;
      } else {
        str4 = str3;
        arrayOfByte2 = arrayOfByte1;
      } 
      return a((String)arrayOfByte2, (byte[])str4, paramString2, str1, "POST", true, true);
    } 
    return a((String)arrayOfByte1, arrayOfByte2, paramString2, str1, "POST", true, false);
  }
  
  public static f a(String paramString1, String paramString2) {
    return a(paramString1, paramString2, b());
  }
  
  public static f a(String paramString1, String paramString2, String paramString3) {
    try {
      e e = new e(paramString1, "UTF-8", true);
      e.a("json", paramString2);
      e.a("file", new File(paramString3));
      String str = e.a();
      try {
        JSONObject jSONObject = new JSONObject(str);
        return "succ".equals(jSONObject.optString("succ_kind")) ? new f(0, jSONObject) : new f(204, str);
      } catch (JSONException jSONException) {
        return new f(205, (Throwable)jSONException);
      } 
    } catch (IOException iOException) {
      iOException.printStackTrace();
      return new f(207);
    } 
  }
  
  public static f a(String paramString1, String paramString2, boolean paramBoolean) {
    try {
      return (TextUtils.isEmpty(paramString2) || TextUtils.isEmpty(paramString1)) ? new f(201) : a(2097152L, paramString1, paramString2.getBytes(), a.b, "application/json; charset=utf-8", paramBoolean);
    } finally {
      paramString1 = null;
      j.b((Throwable)paramString1);
    } 
  }
  
  private static f a(String paramString1, byte[] paramArrayOfbyte, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #9
    //   3: aconst_null
    //   4: astore #10
    //   6: aload_0
    //   7: astore #8
    //   9: getstatic com/bytedance/tea/crash/upload/b.b : Lcom/bytedance/tea/crash/upload/c;
    //   12: ifnull -> 27
    //   15: getstatic com/bytedance/tea/crash/upload/b.b : Lcom/bytedance/tea/crash/upload/c;
    //   18: aload_0
    //   19: aload_1
    //   20: invokeinterface a : (Ljava/lang/String;[B)Ljava/lang/String;
    //   25: astore #8
    //   27: new java/util/LinkedList
    //   30: dup
    //   31: invokespecial <init> : ()V
    //   34: astore #11
    //   36: iload #6
    //   38: ifeq -> 59
    //   41: new java/net/URL
    //   44: dup
    //   45: aload #8
    //   47: aload #11
    //   49: invokestatic a : (Ljava/lang/String;Ljava/util/List;)Ljava/lang/String;
    //   52: invokespecial <init> : (Ljava/lang/String;)V
    //   55: astore_0
    //   56: goto -> 69
    //   59: new java/net/URL
    //   62: dup
    //   63: aload #8
    //   65: invokespecial <init> : (Ljava/lang/String;)V
    //   68: astore_0
    //   69: aload_0
    //   70: invokevirtual openConnection : ()Ljava/net/URLConnection;
    //   73: checkcast java/net/HttpURLConnection
    //   76: astore #8
    //   78: iload #6
    //   80: ifeq -> 153
    //   83: aload #11
    //   85: invokeinterface isEmpty : ()Z
    //   90: ifne -> 153
    //   93: aload #11
    //   95: invokeinterface iterator : ()Ljava/util/Iterator;
    //   100: astore_0
    //   101: aload_0
    //   102: invokeinterface hasNext : ()Z
    //   107: ifeq -> 153
    //   110: aload_0
    //   111: invokeinterface next : ()Ljava/lang/Object;
    //   116: checkcast android/util/Pair
    //   119: astore #11
    //   121: aload #11
    //   123: ifnonnull -> 129
    //   126: goto -> 101
    //   129: aload #8
    //   131: aload #11
    //   133: getfield first : Ljava/lang/Object;
    //   136: checkcast java/lang/String
    //   139: aload #11
    //   141: getfield second : Ljava/lang/Object;
    //   144: checkcast java/lang/String
    //   147: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   150: goto -> 101
    //   153: iload #5
    //   155: ifeq -> 167
    //   158: aload #8
    //   160: iconst_1
    //   161: invokevirtual setDoOutput : (Z)V
    //   164: goto -> 173
    //   167: aload #8
    //   169: iconst_0
    //   170: invokevirtual setDoOutput : (Z)V
    //   173: aload_2
    //   174: ifnull -> 185
    //   177: aload #8
    //   179: ldc 'Content-Type'
    //   181: aload_2
    //   182: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   185: aload_3
    //   186: ifnull -> 197
    //   189: aload #8
    //   191: ldc 'Content-Encoding'
    //   193: aload_3
    //   194: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   197: aload #8
    //   199: ldc 'Accept-Encoding'
    //   201: ldc 'gzip'
    //   203: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   206: aload #4
    //   208: ifnull -> 422
    //   211: aload #8
    //   213: aload #4
    //   215: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   218: aload_1
    //   219: ifnull -> 266
    //   222: aload_1
    //   223: arraylength
    //   224: istore #7
    //   226: iload #7
    //   228: ifle -> 266
    //   231: new java/io/DataOutputStream
    //   234: dup
    //   235: aload #8
    //   237: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   240: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   243: astore_2
    //   244: aload_2
    //   245: aload_1
    //   246: invokevirtual write : ([B)V
    //   249: aload_2
    //   250: invokevirtual flush : ()V
    //   253: aload_2
    //   254: invokestatic a : (Ljava/io/Closeable;)V
    //   257: goto -> 266
    //   260: aload_1
    //   261: invokestatic a : (Ljava/io/Closeable;)V
    //   264: aload_0
    //   265: athrow
    //   266: aload #8
    //   268: invokevirtual getResponseCode : ()I
    //   271: istore #7
    //   273: iload #7
    //   275: sipush #200
    //   278: if_icmpne -> 368
    //   281: aload #8
    //   283: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   286: astore_2
    //   287: ldc 'gzip'
    //   289: aload #8
    //   291: invokevirtual getContentEncoding : ()Ljava/lang/String;
    //   294: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   297: istore #5
    //   299: iload #5
    //   301: ifeq -> 333
    //   304: new java/util/zip/GZIPInputStream
    //   307: dup
    //   308: aload_2
    //   309: invokespecial <init> : (Ljava/io/InputStream;)V
    //   312: astore_0
    //   313: aload_0
    //   314: invokestatic a : (Ljava/io/InputStream;)[B
    //   317: astore_1
    //   318: aload_0
    //   319: invokestatic a : (Ljava/io/Closeable;)V
    //   322: aload_1
    //   323: astore_0
    //   324: goto -> 338
    //   327: aload_0
    //   328: invokestatic a : (Ljava/io/Closeable;)V
    //   331: aload_1
    //   332: athrow
    //   333: aload_2
    //   334: invokestatic a : (Ljava/io/InputStream;)[B
    //   337: astore_0
    //   338: aload_0
    //   339: invokestatic c : ([B)Lcom/bytedance/tea/crash/upload/f;
    //   342: astore_0
    //   343: aload #8
    //   345: ifnull -> 353
    //   348: aload #8
    //   350: invokevirtual disconnect : ()V
    //   353: aload_2
    //   354: invokestatic a : (Ljava/io/Closeable;)V
    //   357: aload_0
    //   358: areturn
    //   359: astore_0
    //   360: aload_2
    //   361: astore_1
    //   362: aload #8
    //   364: astore_2
    //   365: goto -> 439
    //   368: new java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial <init> : ()V
    //   375: astore_0
    //   376: aload_0
    //   377: ldc_w 'http response code '
    //   380: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: aload_0
    //   385: iload #7
    //   387: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: new com/bytedance/tea/crash/upload/f
    //   394: dup
    //   395: sipush #206
    //   398: aload_0
    //   399: invokevirtual toString : ()Ljava/lang/String;
    //   402: invokespecial <init> : (ILjava/lang/String;)V
    //   405: astore_0
    //   406: aload #8
    //   408: ifnull -> 416
    //   411: aload #8
    //   413: invokevirtual disconnect : ()V
    //   416: aconst_null
    //   417: invokestatic a : (Ljava/io/Closeable;)V
    //   420: aload_0
    //   421: areturn
    //   422: new java/lang/IllegalArgumentException
    //   425: dup
    //   426: ldc_w 'request method is not null'
    //   429: invokespecial <init> : (Ljava/lang/String;)V
    //   432: athrow
    //   433: astore_0
    //   434: aconst_null
    //   435: astore_2
    //   436: aload #9
    //   438: astore_1
    //   439: aload_0
    //   440: invokestatic b : (Ljava/lang/Throwable;)V
    //   443: new com/bytedance/tea/crash/upload/f
    //   446: dup
    //   447: sipush #207
    //   450: aload_0
    //   451: invokespecial <init> : (ILjava/lang/Throwable;)V
    //   454: astore_0
    //   455: aload_2
    //   456: ifnull -> 463
    //   459: aload_2
    //   460: invokevirtual disconnect : ()V
    //   463: aload_1
    //   464: invokestatic a : (Ljava/io/Closeable;)V
    //   467: aload_0
    //   468: areturn
    //   469: astore_0
    //   470: aload_2
    //   471: ifnull -> 478
    //   474: aload_2
    //   475: invokevirtual disconnect : ()V
    //   478: aload_1
    //   479: invokestatic a : (Ljava/io/Closeable;)V
    //   482: aload_0
    //   483: athrow
    //   484: astore_1
    //   485: goto -> 353
    //   488: astore_1
    //   489: goto -> 416
    //   492: astore_2
    //   493: goto -> 463
    //   496: astore_2
    //   497: goto -> 478
    //   500: astore_0
    //   501: aload #9
    //   503: astore_1
    //   504: aload #8
    //   506: astore_2
    //   507: goto -> 439
    //   510: astore_0
    //   511: aload_2
    //   512: astore_1
    //   513: goto -> 260
    //   516: astore_0
    //   517: aconst_null
    //   518: astore_1
    //   519: goto -> 260
    //   522: astore_1
    //   523: goto -> 327
    //   526: astore_1
    //   527: aload #10
    //   529: astore_0
    //   530: goto -> 327
    // Exception table:
    //   from	to	target	type
    //   9	27	433	finally
    //   27	36	433	finally
    //   41	56	433	finally
    //   59	69	433	finally
    //   69	78	433	finally
    //   83	101	500	finally
    //   101	121	500	finally
    //   129	150	500	finally
    //   158	164	500	finally
    //   167	173	500	finally
    //   177	185	500	finally
    //   189	197	500	finally
    //   197	206	500	finally
    //   211	218	500	finally
    //   222	226	500	finally
    //   231	244	516	finally
    //   244	253	510	finally
    //   253	257	500	finally
    //   260	266	500	finally
    //   266	273	500	finally
    //   281	287	500	finally
    //   287	299	359	finally
    //   304	313	526	finally
    //   313	318	522	finally
    //   318	322	359	finally
    //   327	333	359	finally
    //   333	338	359	finally
    //   338	343	359	finally
    //   348	353	484	java/lang/Exception
    //   368	406	500	finally
    //   411	416	488	java/lang/Exception
    //   422	433	500	finally
    //   439	455	469	finally
    //   459	463	492	java/lang/Exception
    //   474	478	496	java/lang/Exception
  }
  
  public static String a(Map paramMap) {
    return h.e().a();
  }
  
  public static boolean a() {
    return true;
  }
  
  private static byte[] a(InputStream paramInputStream) throws IOException {
    // Byte code:
    //   0: new java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_2
    //   8: sipush #8192
    //   11: newarray byte
    //   13: astore_3
    //   14: aload_0
    //   15: aload_3
    //   16: invokevirtual read : ([B)I
    //   19: istore_1
    //   20: iconst_m1
    //   21: iload_1
    //   22: if_icmpeq -> 35
    //   25: aload_2
    //   26: aload_3
    //   27: iconst_0
    //   28: iload_1
    //   29: invokevirtual write : ([BII)V
    //   32: goto -> 14
    //   35: aload_0
    //   36: invokevirtual close : ()V
    //   39: aload_2
    //   40: invokevirtual toByteArray : ()[B
    //   43: astore_0
    //   44: aload_2
    //   45: invokestatic a : (Ljava/io/Closeable;)V
    //   48: aload_0
    //   49: areturn
    //   50: astore_0
    //   51: aload_2
    //   52: invokestatic a : (Ljava/io/Closeable;)V
    //   55: aload_0
    //   56: athrow
    // Exception table:
    //   from	to	target	type
    //   39	44	50	finally
  }
  
  private static byte[] a(byte[] paramArrayOfbyte) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
    Deflater deflater = new Deflater();
    deflater.setInput(paramArrayOfbyte);
    deflater.finish();
    paramArrayOfbyte = new byte[8192];
    while (!deflater.finished())
      byteArrayOutputStream.write(paramArrayOfbyte, 0, deflater.deflate(paramArrayOfbyte)); 
    deflater.end();
    return byteArrayOutputStream.toByteArray();
  }
  
  public static f b(String paramString1, String paramString2) {
    return a(paramString1, paramString2, a());
  }
  
  public static boolean b() {
    return true;
  }
  
  private static byte[] b(byte[] paramArrayOfbyte) throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
    try {
      gZIPOutputStream.write(paramArrayOfbyte);
      return byteArrayOutputStream.toByteArray();
    } finally {
      paramArrayOfbyte = null;
    } 
  }
  
  private static f c(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0)
      return new f(203); 
    String str = new String(paramArrayOfbyte, Charset.forName("utf-8"));
    try {
      JSONObject jSONObject = new JSONObject(str);
      return (jSONObject.length() > 0) ? new f(0, jSONObject) : new f(204, str);
    } catch (JSONException jSONException) {
      return new f(204, str);
    } 
  }
  
  public enum a {
    a(0),
    b(1),
    c(2);
    
    final int d;
    
    a(int param1Int1) {
      this.d = param1Int1;
    }
  }
  
  public enum b {
    a(0),
    b(1),
    c(2),
    d(3),
    e(4),
    f(5);
    
    final int g;
    
    b(int param1Int1) {
      this.g = param1Int1;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\cras\\upload\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */