package com.datavisor.vangogh.f.i;

import android.content.Context;
import android.net.Uri;
import com.datavisor.vangogh.f.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class b {
  private static OkHttpClient a = (new OkHttpClient()).A().a(30000L, TimeUnit.MILLISECONDS).c(30000L, TimeUnit.MILLISECONDS).b(30000L, TimeUnit.MILLISECONDS).b();
  
  private static int a(String paramString) {
    try {
      paramString = Uri.parse(paramString).getPath();
      if (f.a(paramString))
        return 0; 
      if (paramString.equals("/vangogh_data"))
        return 1; 
      if (paramString.equals("/config"))
        return 2; 
      if (paramString.equals("/vangogh_errlog"))
        return 3; 
      return bool ? 4 : 0;
    } finally {
      paramString = null;
    } 
  }
  
  private static c a(int paramInt1, int paramInt2, Map<String, String> paramMap, byte[] paramArrayOfbyte, Context paramContext) {
    String str3 = a(paramInt1, false);
    String str2 = a(paramInt1, true);
    a(paramMap, paramInt1);
    boolean bool = f.b(str2);
    interruptedException2 = null;
    String str1 = null;
    if (bool) {
      paramInt1 = 0;
      while (true) {
        c c;
        if (paramInt1 < paramInt2) {
          int i = paramInt1 % 2;
          if (i == 0) {
            str1 = str3;
          } else {
            str1 = str2;
          } 
          c = a(str1, paramMap, paramArrayOfbyte, paramContext, false);
          int j = c.c;
          if (j == 0 || j == 6 || j == 7)
            return c; 
          if (paramInt1 < paramInt2 - 1 && i == 1)
            try {
              Thread.sleep(4000L);
            } catch (InterruptedException interruptedException2) {} 
          paramInt1++;
          continue;
        } 
        return c;
      } 
    } 
    paramInt1 = 0;
    InterruptedException interruptedException1 = interruptedException2;
    while (true) {
      c c;
      if (paramInt1 < paramInt2) {
        c c1 = a(str3, paramMap, paramArrayOfbyte, paramContext, false);
        int i = c1.c;
        c = c1;
        if (i != 0) {
          c = c1;
          if (i != 6) {
            if (i == 7)
              return c1; 
            if (paramInt1 < paramInt2 - 1)
              try {
                Thread.sleep(((new Random()).nextInt(4001) + 2000));
              } catch (InterruptedException interruptedException) {} 
            paramInt1++;
            c = c1;
            continue;
          } 
        } 
      } 
      return c;
    } 
  }
  
  private static c a(String paramString, Map<String, String> paramMap, byte[] paramArrayOfbyte, Context paramContext, boolean paramBoolean) {
    Request.Builder builder = new Request.Builder();
    c c = new c();
    if (paramMap != null)
      for (Map.Entry<String, String> entry : paramMap.entrySet())
        builder.b((String)entry.getKey(), (String)entry.getValue());  
    if (paramArrayOfbyte != null)
      builder.a(RequestBody.create(MediaType.b("application/octet-stream"), paramArrayOfbyte)); 
    builder.a(paramString);
    Request request = builder.d();
    System.currentTimeMillis();
    try {
      Response response = a.a(request).b();
      if (response.d()) {
        c.a = response.g().c();
        c.b = response.h().e();
        response.g().toString();
      } else {
        if (response.c() >= 400 && response.c() < 500) {
          c.c = 6;
        } else {
          c.c = 7;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("postException errcode: ");
        stringBuilder.append(response.toString());
        com.datavisor.vangogh.f.b.a(stringBuilder.toString(), paramContext);
      } 
    } catch (IOException iOException) {
      StringBuilder stringBuilder;
      if (iOException instanceof java.net.SocketTimeoutException) {
        c.c = 9;
      } else if (iOException instanceof java.net.ConnectException) {
        c.c = 5;
      } else {
        c.c = 10;
      } 
      if (paramBoolean) {
        byte[] arrayOfByte = a(paramString, paramArrayOfbyte, paramMap);
        if (arrayOfByte != null && arrayOfByte.length > 1) {
          c.c = 0;
          HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
          if (arrayOfByte[0] != 0) {
            ArrayList<String> arrayList = new ArrayList();
            arrayList.add("1");
            hashMap.put("cv", arrayList);
          } 
          c.a = (Map)hashMap;
          byte[] arrayOfByte1 = new byte[arrayOfByte.length - 1];
          System.arraycopy(arrayOfByte, 1, arrayOfByte1, 0, arrayOfByte.length - 1);
          c.b = arrayOfByte1;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("postException udpSuccess: ");
          stringBuilder1.append(paramString);
          stringBuilder = stringBuilder1;
        } else {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("postException udpFail: ");
          stringBuilder1.append((String)stringBuilder);
          stringBuilder = stringBuilder1;
        } 
      } else {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("postException: ");
        stringBuilder1.append((String)stringBuilder);
        stringBuilder = stringBuilder1;
      } 
      String str = stringBuilder.toString();
      com.datavisor.vangogh.f.b.b(str, iOException, paramContext);
    } finally {}
    System.currentTimeMillis();
    return c;
  }
  
  public static c a(Map<String, String> paramMap, byte[] paramArrayOfbyte, Context paramContext) {
    return a(1, 60, paramMap, paramArrayOfbyte, paramContext);
  }
  
  private static String a(int paramInt, boolean paramBoolean) {
    StringBuilder stringBuilder;
    String str;
    if (paramBoolean) {
      str = a.b();
    } else {
      str = a.a();
    } 
    if (f.a(str))
      return ""; 
    if (paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt != 3) {
          if (paramInt != 4) {
            stringBuilder = new StringBuilder();
          } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            str = "/vangogh_event";
            stringBuilder.append(str);
          } 
        } else {
          stringBuilder = new StringBuilder();
          stringBuilder.append(str);
          str = "/vangogh_errlog";
          stringBuilder.append(str);
        } 
      } else {
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        str = "/config";
        stringBuilder.append(str);
      } 
    } else {
      stringBuilder = new StringBuilder();
    } 
    stringBuilder.append(str);
    stringBuilder.append("/vangogh_data");
    return stringBuilder.toString();
  }
  
  private static void a(Map<String, String> paramMap, int paramInt) {}
  
  private static byte[] a(String paramString, byte[] paramArrayOfbyte, Map<String, String> paramMap) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic a : (Ljava/lang/String;)Z
    //   4: istore #6
    //   6: aconst_null
    //   7: astore #7
    //   9: iload #6
    //   11: ifne -> 303
    //   14: aload_1
    //   15: ifnonnull -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: aload_0
    //   21: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   24: invokevirtual getHost : ()Ljava/lang/String;
    //   27: astore #8
    //   29: aload_1
    //   30: invokestatic reduce : ([B)[B
    //   33: astore #9
    //   35: aload #9
    //   37: ifnull -> 260
    //   40: aload #9
    //   42: invokestatic sign : ([B)[B
    //   45: astore #10
    //   47: aload #10
    //   49: ifnull -> 260
    //   52: aload #9
    //   54: arraylength
    //   55: iconst_2
    //   56: iadd
    //   57: aload #10
    //   59: arraylength
    //   60: iadd
    //   61: istore #5
    //   63: iload #5
    //   65: newarray byte
    //   67: astore_1
    //   68: aload_0
    //   69: invokestatic a : (Ljava/lang/String;)I
    //   72: sipush #255
    //   75: iand
    //   76: i2b
    //   77: istore #4
    //   79: aload_2
    //   80: ifnull -> 305
    //   83: aload_2
    //   84: ldc_w 'c'
    //   87: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   92: checkcast java/lang/String
    //   95: astore_0
    //   96: aload_0
    //   97: invokestatic b : (Ljava/lang/String;)Z
    //   100: ifeq -> 305
    //   103: aload_0
    //   104: ldc '1'
    //   106: invokevirtual equals : (Ljava/lang/Object;)Z
    //   109: ifeq -> 305
    //   112: iconst_1
    //   113: i2b
    //   114: istore_3
    //   115: goto -> 118
    //   118: aload_1
    //   119: iconst_0
    //   120: iload #4
    //   122: bastore
    //   123: aload_1
    //   124: iconst_1
    //   125: iload_3
    //   126: bastore
    //   127: aload #9
    //   129: iconst_0
    //   130: aload_1
    //   131: iconst_2
    //   132: aload #9
    //   134: arraylength
    //   135: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   138: aload #10
    //   140: iconst_0
    //   141: aload_1
    //   142: aload #9
    //   144: arraylength
    //   145: iconst_2
    //   146: iadd
    //   147: aload #10
    //   149: arraylength
    //   150: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   153: new java/net/DatagramSocket
    //   156: dup
    //   157: sipush #9111
    //   160: invokespecial <init> : (I)V
    //   163: astore_0
    //   164: aload_0
    //   165: sipush #20000
    //   168: invokevirtual setSoTimeout : (I)V
    //   171: aload_0
    //   172: new java/net/DatagramPacket
    //   175: dup
    //   176: aload_1
    //   177: iload #5
    //   179: aload #8
    //   181: invokestatic getByName : (Ljava/lang/String;)Ljava/net/InetAddress;
    //   184: sipush #9111
    //   187: invokespecial <init> : ([BILjava/net/InetAddress;I)V
    //   190: invokevirtual send : (Ljava/net/DatagramPacket;)V
    //   193: new java/net/DatagramPacket
    //   196: dup
    //   197: sipush #2048
    //   200: newarray byte
    //   202: sipush #2048
    //   205: invokespecial <init> : ([BI)V
    //   208: astore #8
    //   210: aload_0
    //   211: aload #8
    //   213: invokevirtual receive : (Ljava/net/DatagramPacket;)V
    //   216: aload #8
    //   218: invokevirtual getLength : ()I
    //   221: istore #5
    //   223: aload #7
    //   225: astore_2
    //   226: aload_0
    //   227: astore_1
    //   228: iload #5
    //   230: ifle -> 265
    //   233: iload #5
    //   235: newarray byte
    //   237: astore_2
    //   238: aload #8
    //   240: invokevirtual getData : ()[B
    //   243: iconst_0
    //   244: aload_2
    //   245: iconst_0
    //   246: iload #5
    //   248: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   251: aload_0
    //   252: astore_1
    //   253: goto -> 265
    //   256: astore_1
    //   257: goto -> 278
    //   260: aconst_null
    //   261: astore_1
    //   262: aload #7
    //   264: astore_2
    //   265: aload_1
    //   266: ifnull -> 273
    //   269: aload_1
    //   270: invokevirtual close : ()V
    //   273: aload_2
    //   274: areturn
    //   275: astore_1
    //   276: aconst_null
    //   277: astore_0
    //   278: aload_1
    //   279: invokestatic a : (Ljava/lang/Throwable;)V
    //   282: aload_0
    //   283: ifnull -> 290
    //   286: aload_0
    //   287: invokevirtual close : ()V
    //   290: aconst_null
    //   291: areturn
    //   292: astore_1
    //   293: aload_0
    //   294: ifnull -> 301
    //   297: aload_0
    //   298: invokevirtual close : ()V
    //   301: aload_1
    //   302: athrow
    //   303: aconst_null
    //   304: areturn
    //   305: iconst_0
    //   306: istore_3
    //   307: goto -> 118
    // Exception table:
    //   from	to	target	type
    //   20	35	275	finally
    //   40	47	275	finally
    //   52	79	275	finally
    //   83	112	275	finally
    //   127	164	275	finally
    //   164	223	256	finally
    //   233	251	256	finally
    //   278	282	292	finally
  }
  
  public static c b(Map<String, String> paramMap, byte[] paramArrayOfbyte, Context paramContext) {
    String str = a(2, false);
    a(paramMap, 2);
    return a(str, paramMap, paramArrayOfbyte, paramContext, false);
  }
  
  public static c c(Map<String, String> paramMap, byte[] paramArrayOfbyte, Context paramContext) {
    String str = a(3, false);
    a(paramMap, 3);
    return a(str, paramMap, paramArrayOfbyte, paramContext, false);
  }
  
  public static c d(Map<String, String> paramMap, byte[] paramArrayOfbyte, Context paramContext) {
    return a(4, 8, paramMap, paramArrayOfbyte, paramContext);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\datavisor\vangogh\f\i\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */