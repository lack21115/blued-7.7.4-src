package com.amap.api.col.s;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
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

public final class bs {
  static String a;
  
  private static final String[] b = new String[] { "arm64-v8a", "x86_64" };
  
  private static final String[] c = new String[] { "arm", "x86" };
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < 80; i++)
      stringBuilder.append("="); 
    a = stringBuilder.toString();
  }
  
  public static br a() throws bh {
    return (new br.a("collection", "1.0", "AMap_collection_1.0")).a(new String[] { "com.amap.api.collection" }).a();
  }
  
  public static String a(long paramLong) {
    return a(paramLong, "yyyyMMdd HH:mm:ss:SSS");
  }
  
  public static String a(long paramLong, String paramString) {
    try {
      return (new SimpleDateFormat(paramString, Locale.CHINA)).format(new Date(paramLong));
    } finally {
      paramString = null;
      cd.a((Throwable)paramString, "ut", "ctt");
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
        cd.a(exception, "ut", "gct");
      } 
      String str1 = str2;
      if (TextUtils.isEmpty(str2))
        str1 = Build.CPU_ABI; 
      return str1;
    } 
    String str = "";
  }
  
  public static String a(Throwable paramThrowable) {
    Throwable throwable;
    try {
      StringWriter stringWriter;
    } finally {
      null = null;
      throwable = null;
    } 
    try {
      null.printStackTrace();
      return null;
    } finally {
      if (throwable != null)
        try {
          throwable.close();
        } finally {
          throwable = null;
        }  
      if (paramThrowable != null)
        try {
          paramThrowable.close();
        } finally {
          paramThrowable = null;
        }  
    } 
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
      cd.a(parseException, "ut", "ctt");
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
    //   101: ifeq -> 384
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
    //   142: ifne -> 391
    //   145: aload_0
    //   146: astore #4
    //   148: aload #9
    //   150: aload #5
    //   152: invokevirtual equals : (Ljava/lang/Object;)Z
    //   155: ifeq -> 223
    //   158: goto -> 391
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
    //   235: getstatic com/amap/api/col/s/bs.a : Ljava/lang/String;
    //   238: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   241: pop
    //   242: ldc_w 'authErrLog'
    //   245: ldc_w '                                   鉴权错误信息                                  '
    //   248: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   251: pop
    //   252: ldc_w 'authErrLog'
    //   255: getstatic com/amap/api/col/s/bs.a : Ljava/lang/String;
    //   258: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   261: pop
    //   262: ldc_w 'SHA1Package:'
    //   265: aload #7
    //   267: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   270: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   273: invokestatic f : (Ljava/lang/String;)V
    //   276: ldc_w 'key:'
    //   279: aload #8
    //   281: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   284: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   287: invokestatic f : (Ljava/lang/String;)V
    //   290: ldc_w 'csid:'
    //   293: aload_1
    //   294: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   297: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   300: invokestatic f : (Ljava/lang/String;)V
    //   303: ldc_w 'gsid:'
    //   306: aload_2
    //   307: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   310: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   313: invokestatic f : (Ljava/lang/String;)V
    //   316: new java/lang/StringBuilder
    //   319: dup
    //   320: ldc_w 'json:'
    //   323: invokespecial <init> : (Ljava/lang/String;)V
    //   326: astore_1
    //   327: aload_1
    //   328: aload_3
    //   329: invokevirtual toString : ()Ljava/lang/String;
    //   332: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload_1
    //   337: invokevirtual toString : ()Ljava/lang/String;
    //   340: invokestatic f : (Ljava/lang/String;)V
    //   343: ldc_w 'authErrLog'
    //   346: ldc_w '                                                                               '
    //   349: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   352: pop
    //   353: ldc_w 'authErrLog'
    //   356: aload_0
    //   357: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   360: pop
    //   361: ldc_w 'authErrLog'
    //   364: getstatic com/amap/api/col/s/bs.a : Ljava/lang/String;
    //   367: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   370: pop
    //   371: return
    //   372: astore_0
    //   373: goto -> 229
    //   376: astore #4
    //   378: aload_0
    //   379: astore #4
    //   381: goto -> 223
    //   384: ldc ''
    //   386: astore #4
    //   388: goto -> 116
    //   391: ldc_w '请在高德开放平台官网中搜索"请求内容过长导致业务调用失败"相关内容进行解决'
    //   394: astore_0
    //   395: goto -> 232
    // Exception table:
    //   from	to	target	type
    //   23	73	372	finally
    //   83	113	376	finally
    //   116	135	376	finally
    //   135	145	376	finally
    //   148	158	376	finally
    //   164	175	376	finally
    //   175	194	376	finally
    //   197	205	376	finally
    //   208	218	376	finally
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
      cd.a(iOException, "ut", "wFie");
      return;
    } 
  }
  
  public static void a(ByteArrayOutputStream paramByteArrayOutputStream, String paramString) {
    if (TextUtils.isEmpty(paramString))
      try {
        paramByteArrayOutputStream.write(new byte[] { 0 });
        return;
      } catch (IOException iOException) {
        cd.a(iOException, "ut", "wsf");
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
  
  public static br b() throws bh {
    return (new br.a("co", "1.0.0", "AMap_co_1.0.0")).a(new String[] { "com.amap.co", "com.amap.opensdk.co", "com.amap.location" }).a();
  }
  
  public static String b(String paramString) {
    if (paramString == null)
      return null; 
    paramString = bn.c(a(paramString));
    try {
      StringBuilder stringBuilder = new StringBuilder();
      return stringBuilder.toString();
    } finally {
      paramString = null;
      cd.a((Throwable)paramString, "ut", "tsfb64");
    } 
  }
  
  public static String b(Map<String, String> paramMap) {
    StringBuilder stringBuilder = new StringBuilder();
    for (Map.Entry<String, String> entry : paramMap.entrySet()) {
      if (stringBuilder.length() > 0)
        stringBuilder.append("&"); 
      stringBuilder.append((String)entry.getKey());
      stringBuilder.append("=");
      stringBuilder.append((String)entry.getValue());
    } 
    return e(stringBuilder.toString());
  }
  
  public static byte[] b(byte[] paramArrayOfbyte) {
    try {
      return h(paramArrayOfbyte);
    } finally {
      paramArrayOfbyte = null;
      cd.a((Throwable)paramArrayOfbyte, "ut", "gZp");
    } 
  }
  
  public static String c(String paramString) {
    return (paramString.length() < 2) ? "" : bn.a(paramString.substring(1));
  }
  
  public static byte[] c() {
    try {
      String[] arrayOfString = (new StringBuffer("16,16,18,77,15,911,121,77,121,911,38,77,911,99,86,67,611,96,48,77,84,911,38,67,021,301,86,67,611,98,48,77,511,77,48,97,511,58,48,97,511,84,501,87,511,96,48,77,221,911,38,77,121,37,86,67,25,301,86,67,021,96,86,67,021,701,86,67,35,56,86,67,611,37,221,87")).reverse().toString().split(",");
      byte[] arrayOfByte = new byte[arrayOfString.length];
      boolean bool = false;
      int i;
      for (i = 0; i < arrayOfString.length; i++)
        arrayOfByte[i] = Byte.parseByte(arrayOfString[i]); 
      arrayOfString = (new StringBuffer(new String(bn.b(new String(arrayOfByte))))).reverse().toString().split(",");
      return arrayOfByte;
    } finally {
      Exception exception = null;
      cd.a(exception, "ut", "gIV");
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
        cd.a(null, "ut", "zp");
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
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bn.b("MIICnjCCAgegAwIBAgIJAJ0Pdzos7ZfYMA0GCSqGSIb3DQEBBQUAMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjAeFw0xMzA4MTUwNzU2NTVaFw0yMzA4MTMwNzU2NTVaMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA8eWAyHbFPoFPfdx5AD+D4nYFq4dbJ1p7SIKt19Oz1oivF/6H43v5Fo7s50pD1UF8+Qu4JoUQxlAgOt8OCyQ8DYdkaeB74XKb1wxkIYg/foUwN1CMHPZ9O9ehgna6K4EJXZxR7Y7XVZnbjHZIVn3VpPU/Rdr2v37LjTw+qrABJxMCAwEAAaNQME4wHQYDVR0OBBYEFOM/MLGP8xpVFuVd+3qZkw7uBvOTMB8GA1UdIwQYMBaAFOM/MLGP8xpVFuVd+3qZkw7uBvOTMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADgYEA4LY3g8aAD8JkxAOqUXDDyLuCCGOc2pTIhn0TwMNaVdH4hZlpTeC/wuRD5LJ0z3j+IQ0vLvuQA5uDjVyEOlBrvVIGwSem/1XGUo13DfzgAJ5k1161S5l+sFUo5TxpHOXr8Z5nqJMjieXmhnE/I99GFyHpQmw4cC6rhYUhdhtg+Zk="));
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
    if (paramString.length() % 2 != 0)
      str = "0".concat(String.valueOf(paramString)); 
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
      cd.a((Throwable)paramArrayOfbyte, "ut", "h2s");
    } 
  }
  
  static String f(byte[] paramArrayOfbyte) {
    try {
      return g(paramArrayOfbyte);
    } finally {
      paramArrayOfbyte = null;
      cd.a((Throwable)paramArrayOfbyte, "ut", "csb2h");
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
      if (str2.length() == 1)
        str1 = "0".concat(String.valueOf(str2)); 
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */