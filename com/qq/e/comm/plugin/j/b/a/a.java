package com.qq.e.comm.plugin.j.b.a;

import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class a {
  private static final Pattern a = Pattern.compile("bytes\\W+(\\d+)-(\\d+)/(\\d+)");
  
  private HttpURLConnection b;
  
  private int c;
  
  private String d;
  
  private AtomicBoolean e = new AtomicBoolean(false);
  
  public a(HttpURLConnection paramHttpURLConnection, int paramInt, String paramString) {
    this.b = paramHttpURLConnection;
    this.c = paramInt;
    this.d = paramString;
  }
  
  public boolean a() {
    return (this.c == 0);
  }
  
  public int b() {
    return this.c;
  }
  
  public boolean c() {
    String str = this.b.getHeaderField("Content-Range");
    return (!TextUtils.isEmpty(str) && a.matcher(str).matches() && d() >= 0L);
  }
  
  public long d() {
    HttpURLConnection httpURLConnection = this.b;
    return (httpURLConnection != null) ? httpURLConnection.getContentLength() : -1L;
  }
  
  public InputStream e() throws IllegalStateException, IOException {
    HttpURLConnection httpURLConnection = this.b;
    return (httpURLConnection != null) ? httpURLConnection.getInputStream() : null;
  }
  
  public void f() {
    HttpURLConnection httpURLConnection = this.b;
    if (httpURLConnection != null)
      try {
        return;
      } finally {
        httpURLConnection = null;
      }  
  }
  
  public String g() {
    return this.d;
  }
  
  public boolean h() {
    // Byte code:
    //   0: aload_0
    //   1: getfield e : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4: iconst_0
    //   5: iconst_1
    //   6: invokevirtual compareAndSet : (ZZ)Z
    //   9: ifeq -> 198
    //   12: aload_0
    //   13: aload_0
    //   14: getfield b : Ljava/net/HttpURLConnection;
    //   17: invokestatic a : (Ljava/net/HttpURLConnection;)Ljava/net/HttpURLConnection;
    //   20: putfield b : Ljava/net/HttpURLConnection;
    //   23: aload_0
    //   24: getfield b : Ljava/net/HttpURLConnection;
    //   27: invokevirtual getResponseCode : ()I
    //   30: istore_1
    //   31: ldc 'status code = %d'
    //   33: iconst_1
    //   34: anewarray java/lang/Object
    //   37: dup
    //   38: iconst_0
    //   39: iload_1
    //   40: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   43: aastore
    //   44: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: goto -> 140
    //   50: astore #4
    //   52: goto -> 59
    //   55: astore #4
    //   57: iconst_0
    //   58: istore_1
    //   59: aload_0
    //   60: aload_0
    //   61: getfield c : I
    //   64: ldc 4194304
    //   66: ior
    //   67: putfield c : I
    //   70: new java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial <init> : ()V
    //   77: astore #5
    //   79: aload #5
    //   81: ldc 'ExceptionWhileMakeupPartitionConnection:'
    //   83: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload #5
    //   89: aload #4
    //   91: invokevirtual getClass : ()Ljava/lang/Class;
    //   94: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload_0
    //   99: aload #5
    //   101: invokevirtual toString : ()Ljava/lang/String;
    //   104: putfield d : Ljava/lang/String;
    //   107: goto -> 140
    //   110: iconst_0
    //   111: istore_1
    //   112: aload_0
    //   113: getfield c : I
    //   116: istore_2
    //   117: ldc 131072
    //   119: istore_3
    //   120: goto -> 133
    //   123: iconst_0
    //   124: istore_1
    //   125: aload_0
    //   126: getfield c : I
    //   129: istore_2
    //   130: ldc 65536
    //   132: istore_3
    //   133: aload_0
    //   134: iload_2
    //   135: iload_3
    //   136: ior
    //   137: putfield c : I
    //   140: iload_1
    //   141: sipush #200
    //   144: if_icmpeq -> 198
    //   147: iload_1
    //   148: sipush #206
    //   151: if_icmpeq -> 198
    //   154: aload_0
    //   155: aload_0
    //   156: getfield c : I
    //   159: ldc 2097152
    //   161: ior
    //   162: putfield c : I
    //   165: new java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial <init> : ()V
    //   172: astore #4
    //   174: aload #4
    //   176: ldc 'HttpStatusErrWhileMakeupPartitionConnection:'
    //   178: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload #4
    //   184: iload_1
    //   185: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload_0
    //   190: aload #4
    //   192: invokevirtual toString : ()Ljava/lang/String;
    //   195: putfield d : Ljava/lang/String;
    //   198: aload_0
    //   199: invokevirtual a : ()Z
    //   202: ireturn
    //   203: astore #4
    //   205: goto -> 123
    //   208: astore #4
    //   210: goto -> 110
    //   213: astore #4
    //   215: goto -> 125
    //   218: astore #4
    //   220: goto -> 112
    // Exception table:
    //   from	to	target	type
    //   12	31	203	java/net/UnknownHostException
    //   12	31	208	java/net/SocketTimeoutException
    //   12	31	55	java/io/IOException
    //   31	47	213	java/net/UnknownHostException
    //   31	47	218	java/net/SocketTimeoutException
    //   31	47	50	java/io/IOException
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\j\b\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */