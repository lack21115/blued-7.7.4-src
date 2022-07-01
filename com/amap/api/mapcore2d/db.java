package com.amap.api.mapcore2d;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

public class db {
  static String a;
  
  private static final String[] b = new String[] { "arm64-v8a", "x86_64" };
  
  private static final String[] c = new String[] { "arm", "x86" };
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < 80; i++)
      stringBuilder.append("="); 
    a = stringBuilder.toString();
  }
  
  public static da a() throws cp {
    return (new da.a("collection", "1.0", "AMap_collection_1.0")).a(new String[] { "com.amap.api.collection" }).a();
  }
  
  public static String a(long paramLong) {
    try {
      return (new SimpleDateFormat("yyyyMMdd HH:mm:ss:SSS", Locale.CHINA)).format(new Date(paramLong));
    } finally {
      Exception exception = null;
      exception.printStackTrace();
    } 
  }
  
  public static String a(long paramLong, String paramString) {
    try {
      return (new SimpleDateFormat(paramString, Locale.CHINA)).format(new Date(paramLong));
    } finally {
      paramString = null;
      paramString.printStackTrace();
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
        dl.a(exception, "ut", "gct");
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
    if (paramMap == null || paramMap.size() == 0)
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
  
  public static void a(Context paramContext, String paramString1, String paramString2, JSONObject paramJSONObject) {
    // Byte code:
    //   0: ldc ''
    //   2: astore #5
    //   4: aload_0
    //   5: invokestatic e : (Landroid/content/Context;)Ljava/lang/String;
    //   8: astore #7
    //   10: aload #7
    //   12: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   15: astore #9
    //   17: aload_0
    //   18: invokestatic a : (Landroid/content/Context;)Ljava/lang/String;
    //   21: astore #8
    //   23: aload_3
    //   24: ldc_w 'info'
    //   27: invokevirtual has : (Ljava/lang/String;)Z
    //   30: ifeq -> 82
    //   33: aload_3
    //   34: ldc_w 'info'
    //   37: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   40: astore #6
    //   42: new java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial <init> : ()V
    //   49: astore_0
    //   50: aload_0
    //   51: ldc_w '请在高德开放平台官网中搜索"'
    //   54: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload_0
    //   59: aload #6
    //   61: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload_0
    //   66: ldc_w '"相关内容进行解决'
    //   69: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload_0
    //   74: invokevirtual toString : ()Ljava/lang/String;
    //   77: astore #4
    //   79: goto -> 90
    //   82: ldc ''
    //   84: astore #6
    //   86: aload #6
    //   88: astore #4
    //   90: ldc_w 'INVALID_USER_SCODE'
    //   93: aload #6
    //   95: invokevirtual equals : (Ljava/lang/Object;)Z
    //   98: ifeq -> 166
    //   101: aload_3
    //   102: ldc_w 'sec_code'
    //   105: invokevirtual has : (Ljava/lang/String;)Z
    //   108: ifeq -> 441
    //   111: aload_3
    //   112: ldc_w 'sec_code'
    //   115: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   118: astore_0
    //   119: goto -> 122
    //   122: aload_3
    //   123: ldc_w 'sec_code_debug'
    //   126: invokevirtual has : (Ljava/lang/String;)Z
    //   129: ifeq -> 141
    //   132: aload_3
    //   133: ldc_w 'sec_code_debug'
    //   136: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   139: astore #5
    //   141: aload #9
    //   143: aload_0
    //   144: invokevirtual equals : (Ljava/lang/Object;)Z
    //   147: ifne -> 447
    //   150: aload #4
    //   152: astore_0
    //   153: aload #9
    //   155: aload #5
    //   157: invokevirtual equals : (Ljava/lang/Object;)Z
    //   160: ifeq -> 233
    //   163: goto -> 447
    //   166: aload #4
    //   168: astore_0
    //   169: ldc_w 'INVALID_USER_KEY'
    //   172: aload #6
    //   174: invokevirtual equals : (Ljava/lang/Object;)Z
    //   177: ifeq -> 233
    //   180: aload_3
    //   181: ldc_w 'key'
    //   184: invokevirtual has : (Ljava/lang/String;)Z
    //   187: ifeq -> 199
    //   190: aload_3
    //   191: ldc_w 'key'
    //   194: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   197: astore #5
    //   199: aload #4
    //   201: astore_0
    //   202: aload #5
    //   204: invokevirtual length : ()I
    //   207: ifle -> 233
    //   210: aload #4
    //   212: astore_0
    //   213: aload #8
    //   215: aload #5
    //   217: invokevirtual equals : (Ljava/lang/Object;)Z
    //   220: ifne -> 233
    //   223: ldc_w '请在高德开放平台官网上发起技术咨询工单—>账号与Key问题，咨询INVALID_USER_KEY如何解决'
    //   226: astore_0
    //   227: goto -> 233
    //   230: ldc ''
    //   232: astore_0
    //   233: getstatic com/amap/api/mapcore2d/db.a : Ljava/lang/String;
    //   236: invokestatic g : (Ljava/lang/String;)V
    //   239: ldc_w '                                   鉴权错误信息                                  '
    //   242: invokestatic g : (Ljava/lang/String;)V
    //   245: getstatic com/amap/api/mapcore2d/db.a : Ljava/lang/String;
    //   248: invokestatic g : (Ljava/lang/String;)V
    //   251: new java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial <init> : ()V
    //   258: astore #4
    //   260: aload #4
    //   262: ldc_w 'SHA1Package:'
    //   265: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload #4
    //   271: aload #7
    //   273: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload #4
    //   279: invokevirtual toString : ()Ljava/lang/String;
    //   282: invokestatic f : (Ljava/lang/String;)V
    //   285: new java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial <init> : ()V
    //   292: astore #4
    //   294: aload #4
    //   296: ldc_w 'key:'
    //   299: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload #4
    //   305: aload #8
    //   307: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload #4
    //   313: invokevirtual toString : ()Ljava/lang/String;
    //   316: invokestatic f : (Ljava/lang/String;)V
    //   319: new java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial <init> : ()V
    //   326: astore #4
    //   328: aload #4
    //   330: ldc_w 'csid:'
    //   333: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: aload #4
    //   339: aload_1
    //   340: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload #4
    //   346: invokevirtual toString : ()Ljava/lang/String;
    //   349: invokestatic f : (Ljava/lang/String;)V
    //   352: new java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial <init> : ()V
    //   359: astore_1
    //   360: aload_1
    //   361: ldc_w 'gsid:'
    //   364: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: aload_1
    //   369: aload_2
    //   370: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload_1
    //   375: invokevirtual toString : ()Ljava/lang/String;
    //   378: invokestatic f : (Ljava/lang/String;)V
    //   381: new java/lang/StringBuilder
    //   384: dup
    //   385: invokespecial <init> : ()V
    //   388: astore_1
    //   389: aload_1
    //   390: ldc_w 'json:'
    //   393: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: aload_1
    //   398: aload_3
    //   399: invokevirtual toString : ()Ljava/lang/String;
    //   402: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload_1
    //   407: invokevirtual toString : ()Ljava/lang/String;
    //   410: invokestatic f : (Ljava/lang/String;)V
    //   413: ldc_w '                                                                               '
    //   416: invokestatic g : (Ljava/lang/String;)V
    //   419: aload_0
    //   420: invokestatic g : (Ljava/lang/String;)V
    //   423: getstatic com/amap/api/mapcore2d/db.a : Ljava/lang/String;
    //   426: invokestatic g : (Ljava/lang/String;)V
    //   429: return
    //   430: astore_0
    //   431: goto -> 230
    //   434: astore_0
    //   435: aload #4
    //   437: astore_0
    //   438: goto -> 233
    //   441: ldc ''
    //   443: astore_0
    //   444: goto -> 122
    //   447: ldc_w '请在高德开放平台官网中搜索"请求内容过长导致业务调用失败"相关内容进行解决'
    //   450: astore_0
    //   451: goto -> 233
    // Exception table:
    //   from	to	target	type
    //   23	79	430	finally
    //   90	119	434	finally
    //   122	141	434	finally
    //   141	150	434	finally
    //   153	163	434	finally
    //   169	180	434	finally
    //   180	199	434	finally
    //   202	210	434	finally
    //   213	223	434	finally
  }
  
  public static void a(ByteArrayOutputStream paramByteArrayOutputStream, byte paramByte, byte[] paramArrayOfbyte) {
    try {
      paramByteArrayOutputStream.write(new byte[] { paramByte });
      int i = paramByte & 0xFF;
      if (i < 255 && i > 0) {
        paramByteArrayOutputStream.write(paramArrayOfbyte);
        return;
      } 
      if (i == 255) {
        paramByteArrayOutputStream.write(paramArrayOfbyte, 0, 255);
        return;
      } 
    } catch (IOException iOException) {
      dl.a(iOException, "ut", "wFie");
    } 
  }
  
  public static void a(ByteArrayOutputStream paramByteArrayOutputStream, String paramString) {
    if (TextUtils.isEmpty(paramString))
      try {
        paramByteArrayOutputStream.write(new byte[] { 0 });
        return;
      } catch (IOException iOException) {
        iOException.printStackTrace();
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
        return !(i != 0);
      } finally {
        paramContext = null;
      }  
    return true;
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean) {
    return dr.a(paramContext, paramBoolean);
  }
  
  public static boolean a(JSONObject paramJSONObject, String paramString) {
    return (paramJSONObject != null && paramJSONObject.has(paramString));
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
  
  public static da b() throws cp {
    return (new da.a("co", "1.0.0", "AMap_co_1.0.0")).a(new String[] { "com.amap.co", "com.amap.opensdk.co", "com.amap.location" }).a();
  }
  
  public static String b(String paramString) {
    if (paramString == null)
      return null; 
    paramString = cv.c(a(paramString));
    try {
      StringBuilder stringBuilder = new StringBuilder();
      return stringBuilder.toString();
    } finally {
      paramString = null;
      paramString.printStackTrace();
    } 
  }
  
  public static boolean b(Context paramContext) {
    PackageManager packageManager = paramContext.getPackageManager();
    try {
      packageManager.getPackageInfo("com.android.vending", 0);
      return true;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return false;
    } 
  }
  
  public static byte[] b(byte[] paramArrayOfbyte) {
    try {
      return h(paramArrayOfbyte);
    } finally {
      paramArrayOfbyte = null;
      dl.a((Throwable)paramArrayOfbyte, "ut", "gZp");
    } 
  }
  
  public static String c(String paramString) {
    return (paramString.length() < 2) ? "" : cv.a(paramString.substring(1));
  }
  
  public static byte[] c() {
    try {
      String[] arrayOfString = (new StringBuffer("16,16,18,77,15,911,121,77,121,911,38,77,911,99,86,67,611,96,48,77,84,911,38,67,021,301,86,67,611,98,48,77,511,77,48,97,511,58,48,97,511,84,501,87,511,96,48,77,221,911,38,77,121,37,86,67,25,301,86,67,021,96,86,67,021,701,86,67,35,56,86,67,611,37,221,87")).reverse().toString().split(",");
      byte[] arrayOfByte = new byte[arrayOfString.length];
      boolean bool = false;
      int i;
      for (i = 0; i < arrayOfString.length; i++)
        arrayOfByte[i] = Byte.parseByte(arrayOfString[i]); 
      arrayOfString = (new StringBuffer(new String(cv.b(new String(arrayOfByte))))).reverse().toString().split(",");
      return arrayOfByte;
    } finally {
      Exception exception = null;
      dl.a(exception, "ut", "gIV");
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
        dl.a(null, "ut", "zp");
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
  
  public static String d(String paramString) {
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
  
  static PublicKey d() throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException {
    InputStream inputStream;
    try {
      inputStream = new ByteArrayInputStream(cv.b("MIICnjCCAgegAwIBAgIJAJ0Pdzos7ZfYMA0GCSqGSIb3DQEBBQUAMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjAeFw0xMzA4MTUwNzU2NTVaFw0yMzA4MTMwNzU2NTVaMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA8eWAyHbFPoFPfdx5AD+D4nYFq4dbJ1p7SIKt19Oz1oivF/6H43v5Fo7s50pD1UF8+Qu4JoUQxlAgOt8OCyQ8DYdkaeB74XKb1wxkIYg/foUwN1CMHPZ9O9ehgna6K4EJXZxR7Y7XVZnbjHZIVn3VpPU/Rdr2v37LjTw+qrABJxMCAwEAAaNQME4wHQYDVR0OBBYEFOM/MLGP8xpVFuVd+3qZkw7uBvOTMB8GA1UdIwQYMBaAFOM/MLGP8xpVFuVd+3qZkw7uBvOTMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADgYEA4LY3g8aAD8JkxAOqUXDDyLuCCGOc2pTIhn0TwMNaVdH4hZlpTeC/wuRD5LJ0z3j+IQ0vLvuQA5uDjVyEOlBrvVIGwSem/1XGUo13DfzgAJ5k1161S5l+sFUo5TxpHOXr8Z5nqJMjieXmhnE/I99GFyHpQmw4cC6rhYUhdhtg+Zk="));
    } finally {
      null = null;
    } 
    try {
      null.printStackTrace();
      return null;
    } finally {
      if (inputStream != null)
        try {
          inputStream.close();
        } finally {
          inputStream = null;
        }  
    } 
  }
  
  public static byte[] d(byte[] paramArrayOfbyte) {
    try {
      return h(paramArrayOfbyte);
    } finally {
      paramArrayOfbyte = null;
      paramArrayOfbyte.printStackTrace();
    } 
  }
  
  static String e(byte[] paramArrayOfbyte) {
    try {
      return g(paramArrayOfbyte);
    } finally {
      paramArrayOfbyte = null;
      dl.a((Throwable)paramArrayOfbyte, "ut", "h2s");
    } 
  }
  
  public static byte[] e(String paramString) {
    String str = paramString;
    if (paramString.length() % 2 != 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("0");
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
  
  static String f(byte[] paramArrayOfbyte) {
    try {
      return g(paramArrayOfbyte);
    } finally {
      paramArrayOfbyte = null;
      paramArrayOfbyte.printStackTrace();
    } 
  }
  
  static void f(String paramString) {
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
      g(stringBuilder1.toString());
      return;
    } 
    String str = paramString.substring(0, 78);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("|");
    stringBuilder.append(str);
    stringBuilder.append("|");
    g(stringBuilder.toString());
    f(paramString.substring(78));
  }
  
  public static String g(byte[] paramArrayOfbyte) {
    StringBuilder stringBuilder = new StringBuilder();
    if (paramArrayOfbyte == null)
      return null; 
    for (int i = 0; i < paramArrayOfbyte.length; i++) {
      String str2 = Integer.toHexString(paramArrayOfbyte[i] & 0xFF);
      String str1 = str2;
      if (str2.length() == 1) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append('0');
        stringBuilder1.append(str2);
        str1 = stringBuilder1.toString();
      } 
      stringBuilder.append(str1);
    } 
    return stringBuilder.toString();
  }
  
  private static void g(String paramString) {
    Log.i("authErrLog", paramString);
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\db.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */