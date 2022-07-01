package com.loc;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

public final class u {
  static String a;
  
  private static final String[] b = new String[] { "arm64-v8a", "x86_64" };
  
  private static final String[] c = new String[] { "arm", "x86" };
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < 80; i++)
      stringBuilder.append("="); 
    a = stringBuilder.toString();
  }
  
  public static t a() throws j {
    return (new t.a("collection", "1.0", "AMap_collection_1.0")).a(new String[] { "com.amap.api.collection" }).a();
  }
  
  public static String a(long paramLong) {
    return a(paramLong, "yyyyMMdd HH:mm:ss:SSS");
  }
  
  public static String a(long paramLong, String paramString) {
    try {
      return (new SimpleDateFormat(paramString, Locale.CHINA)).format(new Date(paramLong));
    } finally {
      paramString = null;
      y.a((Throwable)paramString, "ut", "ctt");
    } 
  }
  
  public static String a(Context paramContext) {
    if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT < 28) {
      String str2;
      String str3;
      try {
        ApplicationInfo applicationInfo = paramContext.getApplicationInfo();
        Field field = Class.forName(ApplicationInfo.class.getName()).getDeclaredField("primaryCpuAbi");
        field.setAccessible(true);
        str3 = (String)field.get(applicationInfo);
      } finally {
        Exception exception = null;
        y.a(exception, "ut", "gct");
      } 
      String str1 = str2;
      if (TextUtils.isEmpty(str2))
        str1 = Build.CPU_ABI; 
      return str1;
    } 
    String str = "";
  }
  
  public static String a(Throwable paramThrowable) {
    // Byte code:
    //   0: new java/io/StringWriter
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_2
    //   8: new java/io/PrintWriter
    //   11: dup
    //   12: aload_2
    //   13: invokespecial <init> : (Ljava/io/Writer;)V
    //   16: astore_1
    //   17: aload_0
    //   18: aload_1
    //   19: invokevirtual printStackTrace : (Ljava/io/PrintWriter;)V
    //   22: aload_0
    //   23: invokevirtual getCause : ()Ljava/lang/Throwable;
    //   26: astore_0
    //   27: aload_0
    //   28: ifnull -> 39
    //   31: aload_0
    //   32: aload_1
    //   33: invokevirtual printStackTrace : (Ljava/io/PrintWriter;)V
    //   36: goto -> 22
    //   39: aload_2
    //   40: invokevirtual toString : ()Ljava/lang/String;
    //   43: astore_0
    //   44: aload_2
    //   45: invokevirtual close : ()V
    //   48: goto -> 56
    //   51: astore_2
    //   52: aload_2
    //   53: invokevirtual printStackTrace : ()V
    //   56: aload_1
    //   57: invokevirtual close : ()V
    //   60: aload_0
    //   61: areturn
    //   62: astore_1
    //   63: aload_1
    //   64: invokevirtual printStackTrace : ()V
    //   67: aload_0
    //   68: areturn
    //   69: astore_3
    //   70: aload_1
    //   71: astore_0
    //   72: aload_3
    //   73: astore_1
    //   74: goto -> 88
    //   77: astore_1
    //   78: aconst_null
    //   79: astore_0
    //   80: goto -> 88
    //   83: astore_1
    //   84: aconst_null
    //   85: astore_2
    //   86: aload_2
    //   87: astore_0
    //   88: aload_1
    //   89: invokevirtual printStackTrace : ()V
    //   92: aload_2
    //   93: ifnull -> 108
    //   96: aload_2
    //   97: invokevirtual close : ()V
    //   100: goto -> 108
    //   103: astore_1
    //   104: aload_1
    //   105: invokevirtual printStackTrace : ()V
    //   108: aload_0
    //   109: ifnull -> 123
    //   112: aload_0
    //   113: invokevirtual close : ()V
    //   116: aconst_null
    //   117: areturn
    //   118: astore_0
    //   119: aload_0
    //   120: invokevirtual printStackTrace : ()V
    //   123: aconst_null
    //   124: areturn
    //   125: astore_1
    //   126: aload_2
    //   127: ifnull -> 142
    //   130: aload_2
    //   131: invokevirtual close : ()V
    //   134: goto -> 142
    //   137: astore_2
    //   138: aload_2
    //   139: invokevirtual printStackTrace : ()V
    //   142: aload_0
    //   143: ifnull -> 158
    //   146: aload_0
    //   147: invokevirtual close : ()V
    //   150: goto -> 158
    //   153: astore_0
    //   154: aload_0
    //   155: invokevirtual printStackTrace : ()V
    //   158: aload_1
    //   159: athrow
    // Exception table:
    //   from	to	target	type
    //   0	8	83	finally
    //   8	17	77	finally
    //   17	22	69	finally
    //   22	27	69	finally
    //   31	36	69	finally
    //   39	44	69	finally
    //   44	48	51	finally
    //   56	60	62	finally
    //   88	92	125	finally
    //   96	100	103	finally
    //   112	116	118	finally
    //   130	134	137	finally
    //   146	150	153	finally
  }
  
  public static String a(Map<String, String> paramMap) {
    if (paramMap.size() == 0)
      return null; 
    StringBuffer stringBuffer = new StringBuffer();
    boolean bool = true;
    try {
    
    } finally {
      paramMap = null;
    } 
    return stringBuffer.toString();
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0)
      return ""; 
    try {
      return new String(paramArrayOfbyte, "UTF-8");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      return new String(paramArrayOfbyte);
    } 
  }
  
  public static Method a(Class paramClass, String paramString, Class<?>... paramVarArgs) {
    try {
      return paramClass.getDeclaredMethod(c(paramString), paramVarArgs);
    } finally {
      paramClass = null;
    } 
  }
  
  public static Calendar a(String paramString1, String paramString2) {
    try {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat(paramString2, Locale.CHINA);
      Calendar calendar1 = Calendar.getInstance();
      Calendar calendar2 = Calendar.getInstance();
      calendar2.setTime(simpleDateFormat.parse(paramString1));
      calendar1.set(calendar1.get(1), calendar1.get(2), calendar1.get(5), calendar2.get(11), calendar2.get(12), calendar2.get(13));
      return calendar1;
    } catch (ParseException parseException) {
      y.a(parseException, "ut", "ctt");
      return null;
    } 
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, JSONObject paramJSONObject) {
    // Byte code:
    //   0: ldc ''
    //   2: astore #5
    //   4: aload_0
    //   5: invokestatic e : (Landroid/content/Context;)Ljava/lang/String;
    //   8: astore #7
    //   10: aload #7
    //   12: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   15: astore #9
    //   17: aload_0
    //   18: invokestatic a : (Landroid/content/Context;)Ljava/lang/String;
    //   21: astore #8
    //   23: aload_3
    //   24: ldc_w 'info'
    //   27: invokevirtual has : (Ljava/lang/String;)Z
    //   30: ifeq -> 76
    //   33: aload_3
    //   34: ldc_w 'info'
    //   37: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   40: astore #6
    //   42: new java/lang/StringBuilder
    //   45: dup
    //   46: ldc_w '请在高德开放平台官网中搜索"'
    //   49: invokespecial <init> : (Ljava/lang/String;)V
    //   52: astore_0
    //   53: aload_0
    //   54: aload #6
    //   56: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload_0
    //   61: ldc_w '"相关内容进行解决'
    //   64: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload_0
    //   69: invokevirtual toString : ()Ljava/lang/String;
    //   72: astore_0
    //   73: goto -> 83
    //   76: ldc ''
    //   78: astore #6
    //   80: aload #6
    //   82: astore_0
    //   83: ldc_w 'INVALID_USER_SCODE'
    //   86: aload #6
    //   88: invokevirtual equals : (Ljava/lang/Object;)Z
    //   91: ifeq -> 161
    //   94: aload_3
    //   95: ldc_w 'sec_code'
    //   98: invokevirtual has : (Ljava/lang/String;)Z
    //   101: ifeq -> 437
    //   104: aload_3
    //   105: ldc_w 'sec_code'
    //   108: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   111: astore #4
    //   113: goto -> 116
    //   116: aload_3
    //   117: ldc_w 'sec_code_debug'
    //   120: invokevirtual has : (Ljava/lang/String;)Z
    //   123: ifeq -> 135
    //   126: aload_3
    //   127: ldc_w 'sec_code_debug'
    //   130: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   133: astore #5
    //   135: aload #9
    //   137: aload #4
    //   139: invokevirtual equals : (Ljava/lang/Object;)Z
    //   142: ifne -> 444
    //   145: aload_0
    //   146: astore #4
    //   148: aload #9
    //   150: aload #5
    //   152: invokevirtual equals : (Ljava/lang/Object;)Z
    //   155: ifeq -> 223
    //   158: goto -> 444
    //   161: aload_0
    //   162: astore #4
    //   164: ldc_w 'INVALID_USER_KEY'
    //   167: aload #6
    //   169: invokevirtual equals : (Ljava/lang/Object;)Z
    //   172: ifeq -> 223
    //   175: aload_3
    //   176: ldc_w 'key'
    //   179: invokevirtual has : (Ljava/lang/String;)Z
    //   182: ifeq -> 194
    //   185: aload_3
    //   186: ldc_w 'key'
    //   189: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   192: astore #5
    //   194: aload_0
    //   195: astore #4
    //   197: aload #5
    //   199: invokevirtual length : ()I
    //   202: ifle -> 223
    //   205: aload_0
    //   206: astore #4
    //   208: aload #8
    //   210: aload #5
    //   212: invokevirtual equals : (Ljava/lang/Object;)Z
    //   215: ifne -> 223
    //   218: ldc_w '请在高德开放平台官网上发起技术咨询工单—>账号与Key问题，咨询INVALID_USER_KEY如何解决'
    //   221: astore #4
    //   223: aload #4
    //   225: astore_0
    //   226: goto -> 232
    //   229: ldc ''
    //   231: astore_0
    //   232: ldc_w 'authErrLog'
    //   235: getstatic com/loc/u.a : Ljava/lang/String;
    //   238: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   241: pop
    //   242: ldc_w 'authErrLog'
    //   245: ldc_w '                                   鉴权错误信息                                  '
    //   248: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   251: pop
    //   252: ldc_w 'authErrLog'
    //   255: getstatic com/loc/u.a : Ljava/lang/String;
    //   258: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   261: pop
    //   262: new java/lang/StringBuilder
    //   265: dup
    //   266: ldc_w 'SHA1Package:'
    //   269: invokespecial <init> : (Ljava/lang/String;)V
    //   272: astore #4
    //   274: aload #4
    //   276: aload #7
    //   278: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload #4
    //   284: invokevirtual toString : ()Ljava/lang/String;
    //   287: invokestatic f : (Ljava/lang/String;)V
    //   290: new java/lang/StringBuilder
    //   293: dup
    //   294: ldc_w 'key:'
    //   297: invokespecial <init> : (Ljava/lang/String;)V
    //   300: astore #4
    //   302: aload #4
    //   304: aload #8
    //   306: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload #4
    //   312: invokevirtual toString : ()Ljava/lang/String;
    //   315: invokestatic f : (Ljava/lang/String;)V
    //   318: new java/lang/StringBuilder
    //   321: dup
    //   322: ldc_w 'csid:'
    //   325: invokespecial <init> : (Ljava/lang/String;)V
    //   328: astore #4
    //   330: aload #4
    //   332: aload_1
    //   333: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: aload #4
    //   339: invokevirtual toString : ()Ljava/lang/String;
    //   342: invokestatic f : (Ljava/lang/String;)V
    //   345: new java/lang/StringBuilder
    //   348: dup
    //   349: ldc_w 'gsid:'
    //   352: invokespecial <init> : (Ljava/lang/String;)V
    //   355: astore_1
    //   356: aload_1
    //   357: aload_2
    //   358: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload_1
    //   363: invokevirtual toString : ()Ljava/lang/String;
    //   366: invokestatic f : (Ljava/lang/String;)V
    //   369: new java/lang/StringBuilder
    //   372: dup
    //   373: ldc_w 'json:'
    //   376: invokespecial <init> : (Ljava/lang/String;)V
    //   379: astore_1
    //   380: aload_1
    //   381: aload_3
    //   382: invokevirtual toString : ()Ljava/lang/String;
    //   385: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload_1
    //   390: invokevirtual toString : ()Ljava/lang/String;
    //   393: invokestatic f : (Ljava/lang/String;)V
    //   396: ldc_w 'authErrLog'
    //   399: ldc_w '                                                                               '
    //   402: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   405: pop
    //   406: ldc_w 'authErrLog'
    //   409: aload_0
    //   410: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   413: pop
    //   414: ldc_w 'authErrLog'
    //   417: getstatic com/loc/u.a : Ljava/lang/String;
    //   420: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   423: pop
    //   424: return
    //   425: astore_0
    //   426: goto -> 229
    //   429: astore #4
    //   431: aload_0
    //   432: astore #4
    //   434: goto -> 223
    //   437: ldc ''
    //   439: astore #4
    //   441: goto -> 116
    //   444: ldc_w '请在高德开放平台官网中搜索"请求内容过长导致业务调用失败"相关内容进行解决'
    //   447: astore_0
    //   448: goto -> 232
    // Exception table:
    //   from	to	target	type
    //   23	73	425	finally
    //   83	113	429	finally
    //   116	135	429	finally
    //   135	145	429	finally
    //   148	158	429	finally
    //   164	175	429	finally
    //   175	194	429	finally
    //   197	205	429	finally
    //   208	218	429	finally
  }
  
  public static void a(ByteArrayOutputStream paramByteArrayOutputStream, byte paramByte, byte[] paramArrayOfbyte) {
    try {
      paramByteArrayOutputStream.write(new byte[] { paramByte });
      int i = paramByte & 0xFF;
      if (i < 255 && i > 0) {
        paramByteArrayOutputStream.write(paramArrayOfbyte);
        return;
      } 
      if (i == 255)
        paramByteArrayOutputStream.write(paramArrayOfbyte, 0, 255); 
      return;
    } catch (IOException iOException) {
      y.a(iOException, "ut", "wFie");
      return;
    } 
  }
  
  public static void a(ByteArrayOutputStream paramByteArrayOutputStream, String paramString) {
    if (TextUtils.isEmpty(paramString))
      try {
        paramByteArrayOutputStream.write(new byte[] { 0 });
        return;
      } catch (IOException iOException) {
        y.a(iOException, "ut", "wsf");
        return;
      }  
    int j = paramString.length();
    int i = j;
    if (j > 255)
      i = 255; 
    a((ByteArrayOutputStream)iOException, (byte)i, a(paramString));
  }
  
  public static boolean a(Context paramContext, String paramString) {
    if (paramContext == null)
      return false; 
    if (paramContext.checkCallingOrSelfPermission(paramString) != 0)
      return false; 
    if (Build.VERSION.SDK_INT >= 23 && (paramContext.getApplicationInfo()).targetSdkVersion >= 23)
      try {
        int i = ((Integer)paramContext.getClass().getMethod("checkSelfPermission", new Class[] { String.class }).invoke(paramContext, new Object[] { paramString })).intValue();
      } finally {
        paramContext = null;
      }  
    return true;
  }
  
  public static boolean a(JSONObject paramJSONObject, String paramString) {
    return (paramJSONObject != null && paramJSONObject.has(paramString));
  }
  
  public static byte[] a(int paramInt) {
    return new byte[] { (byte)(paramInt / 256), (byte)(paramInt % 256) };
  }
  
  public static byte[] a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return new byte[0]; 
    try {
      return paramString.getBytes("UTF-8");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      return paramString.getBytes();
    } 
  }
  
  public static t b() throws j {
    return (new t.a("co", "1.0.0", "AMap_co_1.0.0")).a(new String[] { "com.amap.co", "com.amap.opensdk.co", "com.amap.location" }).a();
  }
  
  public static String b(String paramString) {
    if (paramString == null)
      return null; 
    paramString = o.c(a(paramString));
    try {
      StringBuilder stringBuilder = new StringBuilder();
      return stringBuilder.toString();
    } finally {
      paramString = null;
      y.a((Throwable)paramString, "ut", "tsfb64");
    } 
  }
  
  public static String b(Map<String, String> paramMap) {
    if (paramMap != null) {
      StringBuilder stringBuilder = new StringBuilder();
      for (Map.Entry<String, String> entry : paramMap.entrySet()) {
        if (stringBuilder.length() > 0)
          stringBuilder.append("&"); 
        stringBuilder.append((String)entry.getKey());
        stringBuilder.append("=");
        stringBuilder.append((String)entry.getValue());
      } 
      String str = stringBuilder.toString();
    } else {
      paramMap = null;
    } 
    return e((String)paramMap);
  }
  
  public static boolean b(Context paramContext) {
    return w.a(paramContext);
  }
  
  public static byte[] b(byte[] paramArrayOfbyte) {
    try {
      return h(paramArrayOfbyte);
    } finally {
      paramArrayOfbyte = null;
      y.a((Throwable)paramArrayOfbyte, "ut", "gZp");
    } 
  }
  
  public static String c(String paramString) {
    return (paramString.length() < 2) ? "" : o.a(paramString.substring(1));
  }
  
  public static byte[] c() {
    try {
      String[] arrayOfString = (new StringBuffer("16,16,18,77,15,911,121,77,121,911,38,77,911,99,86,67,611,96,48,77,84,911,38,67,021,301,86,67,611,98,48,77,511,77,48,97,511,58,48,97,511,84,501,87,511,96,48,77,221,911,38,77,121,37,86,67,25,301,86,67,021,96,86,67,021,701,86,67,35,56,86,67,611,37,221,87")).reverse().toString().split(",");
      byte[] arrayOfByte = new byte[arrayOfString.length];
      boolean bool = false;
      int i;
      for (i = 0; i < arrayOfString.length; i++)
        arrayOfByte[i] = Byte.parseByte(arrayOfString[i]); 
      arrayOfString = (new StringBuffer(new String(o.b(new String(arrayOfByte))))).reverse().toString().split(",");
      return arrayOfByte;
    } finally {
      Exception exception = null;
      y.a(exception, "ut", "gIV");
    } 
  }
  
  public static byte[] c(byte[] paramArrayOfbyte) {
    byte[] arrayOfByte = null;
    if (paramArrayOfbyte != null) {
      byte[] arrayOfByte1;
      if (paramArrayOfbyte.length == 0)
        return null; 
      try {
      
      } finally {
        null = null;
        arrayOfByte1 = null;
      } 
      try {
        y.a(null, "ut", "zp");
        return null;
      } finally {
        if (paramArrayOfbyte != null)
          try {
            paramArrayOfbyte.close();
          } finally {
            paramArrayOfbyte = null;
          }  
        if (arrayOfByte1 != null)
          try {
            arrayOfByte1.close();
          } finally {
            paramArrayOfbyte = null;
          }  
      } 
    } 
    return null;
  }
  
  static PublicKey d() throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException {
    Exception exception;
    try {
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(o.b("MIICnjCCAgegAwIBAgIJAJ0Pdzos7ZfYMA0GCSqGSIb3DQEBBQUAMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjAeFw0xMzA4MTUwNzU2NTVaFw0yMzA4MTMwNzU2NTVaMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA8eWAyHbFPoFPfdx5AD+D4nYFq4dbJ1p7SIKt19Oz1oivF/6H43v5Fo7s50pD1UF8+Qu4JoUQxlAgOt8OCyQ8DYdkaeB74XKb1wxkIYg/foUwN1CMHPZ9O9ehgna6K4EJXZxR7Y7XVZnbjHZIVn3VpPU/Rdr2v37LjTw+qrABJxMCAwEAAaNQME4wHQYDVR0OBBYEFOM/MLGP8xpVFuVd+3qZkw7uBvOTMB8GA1UdIwQYMBaAFOM/MLGP8xpVFuVd+3qZkw7uBvOTMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADgYEA4LY3g8aAD8JkxAOqUXDDyLuCCGOc2pTIhn0TwMNaVdH4hZlpTeC/wuRD5LJ0z3j+IQ0vLvuQA5uDjVyEOlBrvVIGwSem/1XGUo13DfzgAJ5k1161S5l+sFUo5TxpHOXr8Z5nqJMjieXmhnE/I99GFyHpQmw4cC6rhYUhdhtg+Zk="));
    } finally {
      exception = null;
    } 
    if (exception != null)
      try {
        return null;
      } finally {
        exception = null;
      }  
    return null;
  }
  
  public static byte[] d(String paramString) {
    String str = paramString;
    if (paramString.length() % 2 != 0) {
      StringBuilder stringBuilder = new StringBuilder("0");
      stringBuilder.append(paramString);
      str = stringBuilder.toString();
    } 
    byte[] arrayOfByte = new byte[str.length() / 2];
    for (int i = 0; i < arrayOfByte.length; i++) {
      int j = i * 2;
      arrayOfByte[i] = (byte)Integer.parseInt(str.substring(j, j + 2), 16);
    } 
    return arrayOfByte;
  }
  
  public static byte[] d(byte[] paramArrayOfbyte) {
    try {
      return h(paramArrayOfbyte);
    } finally {
      paramArrayOfbyte = null;
      paramArrayOfbyte.printStackTrace();
    } 
  }
  
  private static String e(String paramString) {
    try {
      if (TextUtils.isEmpty(paramString))
        return ""; 
      String[] arrayOfString = paramString.split("&");
      Arrays.sort((Object[])arrayOfString);
      StringBuffer stringBuffer = new StringBuffer();
      int j = arrayOfString.length;
      for (int i = 0; i < j; i++) {
        stringBuffer.append(arrayOfString[i]);
        stringBuffer.append("&");
      } 
      String str = stringBuffer.toString();
    } finally {
      Exception exception = null;
    } 
    return paramString;
  }
  
  static String e(byte[] paramArrayOfbyte) {
    try {
      return g(paramArrayOfbyte);
    } finally {
      paramArrayOfbyte = null;
      y.a((Throwable)paramArrayOfbyte, "ut", "h2s");
    } 
  }
  
  static String f(byte[] paramArrayOfbyte) {
    try {
      return g(paramArrayOfbyte);
    } finally {
      paramArrayOfbyte = null;
      y.a((Throwable)paramArrayOfbyte, "ut", "csb2h");
    } 
  }
  
  private static void f(String paramString) {
    while (true) {
      int j = paramString.length();
      int i = 0;
      if (j < 78) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("|");
        stringBuilder1.append(paramString);
        while (i < 78 - paramString.length()) {
          stringBuilder1.append(" ");
          i++;
        } 
        stringBuilder1.append("|");
        Log.i("authErrLog", stringBuilder1.toString());
        return;
      } 
      String str = paramString.substring(0, 78);
      StringBuilder stringBuilder = new StringBuilder("|");
      stringBuilder.append(str);
      stringBuilder.append("|");
      Log.i("authErrLog", stringBuilder.toString());
      paramString = paramString.substring(78);
    } 
  }
  
  public static String g(byte[] paramArrayOfbyte) {
    StringBuilder stringBuilder = new StringBuilder();
    if (paramArrayOfbyte == null)
      return null; 
    for (int i = 0; i < paramArrayOfbyte.length; i++) {
      String str2 = Integer.toHexString(paramArrayOfbyte[i] & 0xFF);
      String str1 = str2;
      if (str2.length() == 1) {
        StringBuilder stringBuilder1 = new StringBuilder("0");
        stringBuilder1.append(str2);
        str1 = stringBuilder1.toString();
      } 
      stringBuilder.append(str1);
    } 
    return stringBuilder.toString();
  }
  
  private static byte[] h(byte[] paramArrayOfbyte) throws IOException, Throwable {
    ByteArrayOutputStream byteArrayOutputStream;
    GZIPOutputStream gZIPOutputStream = null;
    if (paramArrayOfbyte == null)
      return null; 
    try {
      byteArrayOutputStream = new ByteArrayOutputStream();
    } finally {
      paramArrayOfbyte = null;
    } 
    try {
      throw paramArrayOfbyte;
    } finally {
      if (gZIPOutputStream != null)
        try {
          gZIPOutputStream.close();
        } finally {} 
      if (byteArrayOutputStream != null)
        try {
          byteArrayOutputStream.close();
        } finally {} 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\lo\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */