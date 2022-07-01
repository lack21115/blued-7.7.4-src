package com.pgl.a.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;

public abstract class b {
  private static HostnameVerifier p = new c();
  
  public String a;
  
  private Context b;
  
  private String c;
  
  private int d;
  
  private int e;
  
  private byte[] f;
  
  private int g;
  
  private byte[] h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private boolean l;
  
  private HandlerThread m;
  
  private Handler n;
  
  private boolean o;
  
  private HttpURLConnection q;
  
  public b(Context paramContext, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial <init> : ()V
    //   4: aload_0
    //   5: ldc ''
    //   7: putfield a : Ljava/lang/String;
    //   10: aload_0
    //   11: iconst_m1
    //   12: putfield g : I
    //   15: aload_0
    //   16: aconst_null
    //   17: putfield h : [B
    //   20: aload_0
    //   21: sipush #10000
    //   24: putfield i : I
    //   27: aload_0
    //   28: iconst_1
    //   29: putfield j : I
    //   32: aload_0
    //   33: iconst_0
    //   34: putfield k : I
    //   37: aload_0
    //   38: iconst_0
    //   39: putfield l : Z
    //   42: aload_0
    //   43: iconst_0
    //   44: putfield o : Z
    //   47: aload_0
    //   48: aconst_null
    //   49: putfield q : Ljava/net/HttpURLConnection;
    //   52: aload_2
    //   53: ifnull -> 65
    //   56: aload_2
    //   57: astore_3
    //   58: aload_2
    //   59: invokevirtual length : ()I
    //   62: ifgt -> 68
    //   65: ldc ''
    //   67: astore_3
    //   68: aload_0
    //   69: aload_1
    //   70: putfield b : Landroid/content/Context;
    //   73: aload_0
    //   74: aload_3
    //   75: putfield c : Ljava/lang/String;
    //   78: return
  }
  
  private void a(int paramInt) {
    String str2 = "GET";
    String str1 = str2;
    switch (paramInt) {
      default:
        str1 = str2;
        break;
      case 6:
        str1 = "TRACE";
        break;
      case 5:
        str1 = "HEAD";
        break;
      case 4:
        str1 = "DELETE";
        break;
      case 3:
        str1 = "PUT";
        break;
      case 1:
        str1 = "POST";
        break;
      case 2:
        break;
    } 
    this.q.setRequestMethod(str1);
  }
  
  private boolean a() {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new java/net/URL
    //   5: dup
    //   6: aload_0
    //   7: getfield a : Ljava/lang/String;
    //   10: invokespecial <init> : (Ljava/lang/String;)V
    //   13: astore #4
    //   15: aload_0
    //   16: getfield o : Z
    //   19: ifeq -> 90
    //   22: new com/pgl/a/a/d
    //   25: dup
    //   26: invokespecial <init> : ()V
    //   29: astore_3
    //   30: ldc 'TLS'
    //   32: invokestatic getInstance : (Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   35: astore #5
    //   37: new java/security/SecureRandom
    //   40: dup
    //   41: invokespecial <init> : ()V
    //   44: astore #6
    //   46: aload #5
    //   48: aconst_null
    //   49: iconst_1
    //   50: anewarray javax/net/ssl/TrustManager
    //   53: dup
    //   54: iconst_0
    //   55: aload_3
    //   56: aastore
    //   57: aload #6
    //   59: invokevirtual init : ([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   62: aload #5
    //   64: invokevirtual getSocketFactory : ()Ljavax/net/ssl/SSLSocketFactory;
    //   67: invokestatic setDefaultSSLSocketFactory : (Ljavax/net/ssl/SSLSocketFactory;)V
    //   70: aload #4
    //   72: getstatic java/net/Proxy.NO_PROXY : Ljava/net/Proxy;
    //   75: invokevirtual openConnection : (Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   78: checkcast java/net/HttpURLConnection
    //   81: astore_3
    //   82: aload_0
    //   83: aload_3
    //   84: putfield q : Ljava/net/HttpURLConnection;
    //   87: goto -> 102
    //   90: aload #4
    //   92: invokevirtual openConnection : ()Ljava/net/URLConnection;
    //   95: checkcast java/net/HttpURLConnection
    //   98: astore_3
    //   99: goto -> 82
    //   102: ldc 'https'
    //   104: aload #4
    //   106: invokevirtual getProtocol : ()Ljava/lang/String;
    //   109: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   112: invokevirtual equals : (Ljava/lang/Object;)Z
    //   115: ifeq -> 131
    //   118: aload_0
    //   119: getfield q : Ljava/net/HttpURLConnection;
    //   122: checkcast javax/net/ssl/HttpsURLConnection
    //   125: getstatic com/pgl/a/a/b.p : Ljavax/net/ssl/HostnameVerifier;
    //   128: invokevirtual setHostnameVerifier : (Ljavax/net/ssl/HostnameVerifier;)V
    //   131: aload_0
    //   132: getfield q : Ljava/net/HttpURLConnection;
    //   135: aload_0
    //   136: getfield i : I
    //   139: invokevirtual setConnectTimeout : (I)V
    //   142: aload_0
    //   143: getfield q : Ljava/net/HttpURLConnection;
    //   146: aload_0
    //   147: getfield i : I
    //   150: invokevirtual setReadTimeout : (I)V
    //   153: aload_0
    //   154: aload_0
    //   155: getfield d : I
    //   158: invokespecial a : (I)V
    //   161: aload_0
    //   162: aload_0
    //   163: getfield e : I
    //   166: invokespecial b : (I)V
    //   169: aload_0
    //   170: getfield f : [B
    //   173: ifnull -> 216
    //   176: aload_0
    //   177: getfield f : [B
    //   180: arraylength
    //   181: ifle -> 216
    //   184: aload_0
    //   185: getfield q : Ljava/net/HttpURLConnection;
    //   188: iconst_1
    //   189: invokevirtual setDoOutput : (Z)V
    //   192: aload_0
    //   193: getfield q : Ljava/net/HttpURLConnection;
    //   196: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   199: astore_3
    //   200: aload_3
    //   201: aload_0
    //   202: getfield f : [B
    //   205: invokevirtual write : ([B)V
    //   208: aload_3
    //   209: invokevirtual flush : ()V
    //   212: aload_3
    //   213: invokevirtual close : ()V
    //   216: aload_0
    //   217: getfield q : Ljava/net/HttpURLConnection;
    //   220: invokevirtual connect : ()V
    //   223: aload_0
    //   224: aload_0
    //   225: getfield q : Ljava/net/HttpURLConnection;
    //   228: invokevirtual getResponseCode : ()I
    //   231: putfield g : I
    //   234: aload_0
    //   235: getfield q : Ljava/net/HttpURLConnection;
    //   238: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   241: astore_3
    //   242: aload_0
    //   243: aload_0
    //   244: aload_3
    //   245: invokespecial a : (Ljava/io/InputStream;)[B
    //   248: putfield h : [B
    //   251: aload_3
    //   252: ifnull -> 274
    //   255: aload_3
    //   256: invokevirtual close : ()V
    //   259: goto -> 274
    //   262: goto -> 267
    //   265: aconst_null
    //   266: astore_3
    //   267: aload_3
    //   268: ifnull -> 274
    //   271: goto -> 255
    //   274: aload_0
    //   275: getfield q : Ljava/net/HttpURLConnection;
    //   278: astore_3
    //   279: aload_3
    //   280: ifnull -> 292
    //   283: aload_3
    //   284: invokevirtual disconnect : ()V
    //   287: aload_0
    //   288: aconst_null
    //   289: putfield q : Ljava/net/HttpURLConnection;
    //   292: iconst_1
    //   293: istore_1
    //   294: goto -> 324
    //   297: astore_3
    //   298: aload_3
    //   299: invokevirtual printStackTrace : ()V
    //   302: aload_0
    //   303: getfield q : Ljava/net/HttpURLConnection;
    //   306: astore_3
    //   307: iload_2
    //   308: istore_1
    //   309: aload_3
    //   310: ifnull -> 324
    //   313: aload_3
    //   314: invokevirtual disconnect : ()V
    //   317: aload_0
    //   318: aconst_null
    //   319: putfield q : Ljava/net/HttpURLConnection;
    //   322: iload_2
    //   323: istore_1
    //   324: iload_1
    //   325: ifeq -> 341
    //   328: aload_0
    //   329: aload_0
    //   330: getfield g : I
    //   333: aload_0
    //   334: getfield h : [B
    //   337: invokevirtual a : (I[B)Z
    //   340: pop
    //   341: iload_1
    //   342: ireturn
    //   343: astore_3
    //   344: aload_0
    //   345: getfield q : Ljava/net/HttpURLConnection;
    //   348: astore #4
    //   350: aload #4
    //   352: ifnull -> 365
    //   355: aload #4
    //   357: invokevirtual disconnect : ()V
    //   360: aload_0
    //   361: aconst_null
    //   362: putfield q : Ljava/net/HttpURLConnection;
    //   365: aload_3
    //   366: athrow
    //   367: astore_3
    //   368: goto -> 265
    //   371: astore #4
    //   373: goto -> 262
    // Exception table:
    //   from	to	target	type
    //   2	82	297	finally
    //   82	87	297	finally
    //   90	99	297	finally
    //   102	131	297	finally
    //   131	216	297	finally
    //   216	223	297	finally
    //   223	242	367	finally
    //   242	251	371	finally
    //   255	259	297	finally
    //   298	302	343	finally
  }
  
  private byte[] a(InputStream paramInputStream) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[1024];
    while (true) {
      int i = paramInputStream.read(arrayOfByte, 0, 1024);
      if (i > 0) {
        byteArrayOutputStream.write(arrayOfByte, 0, i);
        continue;
      } 
      return byteArrayOutputStream.toByteArray();
    } 
  }
  
  private void b(int paramInt) {
    String str;
    if (paramInt != 1) {
      if (paramInt != 2) {
        str = "";
      } else {
        str = "application/octet-stream";
      } 
    } else {
      str = "application/json; charset=utf-8";
    } 
    if (str.length() > 0)
      this.q.addRequestProperty("Content-Type", str); 
    HttpURLConnection httpURLConnection = this.q;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("sessionid=");
    stringBuilder.append(this.c);
    httpURLConnection.addRequestProperty("Cookie", stringBuilder.toString());
    try {
      String str1 = Locale.getDefault().getLanguage();
      boolean bool = str1.equalsIgnoreCase("zh");
      if (bool) {
        httpURLConnection = this.q;
        stringBuilder = new StringBuilder();
        stringBuilder.append(Locale.getDefault().toString());
        stringBuilder.append(",");
        stringBuilder.append(str1);
        stringBuilder.append(";q=0.9");
      } else {
        httpURLConnection = this.q;
        stringBuilder = new StringBuilder();
        stringBuilder.append(Locale.getDefault().toString());
        stringBuilder.append(",");
        stringBuilder.append(str1);
        stringBuilder.append(";q=0.9,en-US;q=0.6,en;q=0.4");
      } 
      return;
    } finally {
      httpURLConnection = null;
    } 
  }
  
  private void b(int paramInt1, int paramInt2, byte[] paramArrayOfbyte) {
    this.d = paramInt1;
    this.e = paramInt2;
    this.f = paramArrayOfbyte;
  }
  
  public void a(int paramInt1, int paramInt2, byte[] paramArrayOfbyte) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield l : Z
    //   6: istore #4
    //   8: iload #4
    //   10: ifeq -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: iconst_2
    //   18: putfield j : I
    //   21: aload_0
    //   22: iload_1
    //   23: iload_2
    //   24: aload_3
    //   25: invokespecial b : (II[B)V
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield l : Z
    //   33: aload_0
    //   34: iconst_0
    //   35: putfield k : I
    //   38: aload_0
    //   39: new android/os/HandlerThread
    //   42: dup
    //   43: ldc_w 'request'
    //   46: invokespecial <init> : (Ljava/lang/String;)V
    //   49: putfield m : Landroid/os/HandlerThread;
    //   52: aload_0
    //   53: getfield m : Landroid/os/HandlerThread;
    //   56: invokevirtual start : ()V
    //   59: aload_0
    //   60: new android/os/Handler
    //   63: dup
    //   64: aload_0
    //   65: getfield m : Landroid/os/HandlerThread;
    //   68: invokevirtual getLooper : ()Landroid/os/Looper;
    //   71: new com/pgl/a/a/b$1
    //   74: dup
    //   75: aload_0
    //   76: invokespecial <init> : (Lcom/pgl/a/a/b;)V
    //   79: invokespecial <init> : (Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   82: putfield n : Landroid/os/Handler;
    //   85: aload_0
    //   86: getfield n : Landroid/os/Handler;
    //   89: iconst_1
    //   90: invokevirtual sendEmptyMessage : (I)Z
    //   93: pop
    //   94: aload_0
    //   95: monitorexit
    //   96: return
    //   97: astore_3
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_3
    //   101: athrow
    // Exception table:
    //   from	to	target	type
    //   2	8	97	finally
    //   16	94	97	finally
  }
  
  public abstract boolean a(int paramInt, byte[] paramArrayOfbyte);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\pgl\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */