package com.huawei.hms.update.b;

import android.content.Context;
import com.huawei.hms.support.log.HMSLog;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class b implements d {
  private HttpURLConnection a;
  
  private volatile int b = -1;
  
  private void a(InputStream paramInputStream, OutputStream paramOutputStream) throws IOException, a {
    byte[] arrayOfByte = new byte[4096];
    while (true) {
      int i = paramInputStream.read(arrayOfByte);
      if (-1 != i) {
        paramOutputStream.write(arrayOfByte, 0, i);
        if (this.b != 1)
          continue; 
        throw new a("HTTP(s) request was canceled.");
      } 
      break;
    } 
  }
  
  private void a(String paramString, Context paramContext) throws IOException {
    if (this.b == 0)
      HMSLog.e("HttpRequestHelper", "Not allowed to repeat open http(s) connection."); 
    this.a = (HttpURLConnection)(new URL(paramString)).openConnection();
    HttpURLConnection httpURLConnection = this.a;
    if (httpURLConnection instanceof HttpsURLConnection)
      c.a((HttpsURLConnection)httpURLConnection, paramContext); 
    this.a.setConnectTimeout(30000);
    this.a.setReadTimeout(30000);
    this.a.setDoInput(true);
    this.a.setDoOutput(true);
    this.a.setUseCaches(false);
    this.a.setInstanceFollowRedirects(true);
    this.b = 0;
  }
  
  public int a(String paramString, OutputStream paramOutputStream, int paramInt1, int paramInt2, Context paramContext) throws IOException, a {
    // Byte code:
    //   0: aconst_null
    //   1: astore #8
    //   3: aconst_null
    //   4: astore #7
    //   6: aload #8
    //   8: astore #6
    //   10: aload_0
    //   11: aload_1
    //   12: aload #5
    //   14: invokespecial a : (Ljava/lang/String;Landroid/content/Context;)V
    //   17: aload #8
    //   19: astore #6
    //   21: aload_0
    //   22: getfield a : Ljava/net/HttpURLConnection;
    //   25: ldc 'GET'
    //   27: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   30: iload_3
    //   31: ifle -> 118
    //   34: aload #8
    //   36: astore #6
    //   38: aload_0
    //   39: getfield a : Ljava/net/HttpURLConnection;
    //   42: astore_1
    //   43: aload #8
    //   45: astore #6
    //   47: new java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial <init> : ()V
    //   54: astore #5
    //   56: aload #8
    //   58: astore #6
    //   60: aload #5
    //   62: ldc 'bytes='
    //   64: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload #8
    //   70: astore #6
    //   72: aload #5
    //   74: iload_3
    //   75: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload #8
    //   81: astore #6
    //   83: aload #5
    //   85: ldc '-'
    //   87: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload #8
    //   93: astore #6
    //   95: aload #5
    //   97: iload #4
    //   99: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload #8
    //   105: astore #6
    //   107: aload_1
    //   108: ldc 'Range'
    //   110: aload #5
    //   112: invokevirtual toString : ()Ljava/lang/String;
    //   115: invokevirtual addRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   118: aload #8
    //   120: astore #6
    //   122: aload_0
    //   123: getfield a : Ljava/net/HttpURLConnection;
    //   126: invokevirtual getResponseCode : ()I
    //   129: istore #4
    //   131: iload_3
    //   132: ifle -> 199
    //   135: iload #4
    //   137: sipush #206
    //   140: if_icmpeq -> 146
    //   143: goto -> 199
    //   146: aload #8
    //   148: astore #6
    //   150: aload_0
    //   151: getfield a : Ljava/net/HttpURLConnection;
    //   154: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   157: astore_1
    //   158: aload_1
    //   159: astore #6
    //   161: aload_0
    //   162: new java/io/BufferedInputStream
    //   165: dup
    //   166: aload_1
    //   167: sipush #4096
    //   170: invokespecial <init> : (Ljava/io/InputStream;I)V
    //   173: aload_2
    //   174: invokespecial a : (Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   177: aload_1
    //   178: astore #6
    //   180: aload_2
    //   181: invokevirtual flush : ()V
    //   184: aload_1
    //   185: invokestatic closeQuietly : (Ljava/io/InputStream;)V
    //   188: iload #4
    //   190: ireturn
    //   191: astore_1
    //   192: aload #6
    //   194: invokestatic closeQuietly : (Ljava/io/InputStream;)V
    //   197: aload_1
    //   198: athrow
    //   199: aload #7
    //   201: astore_1
    //   202: iload_3
    //   203: ifgt -> 184
    //   206: aload #7
    //   208: astore_1
    //   209: iload #4
    //   211: sipush #200
    //   214: if_icmpne -> 184
    //   217: goto -> 146
    // Exception table:
    //   from	to	target	type
    //   10	17	191	finally
    //   21	30	191	finally
    //   38	43	191	finally
    //   47	56	191	finally
    //   60	68	191	finally
    //   72	79	191	finally
    //   83	91	191	finally
    //   95	103	191	finally
    //   107	118	191	finally
    //   122	131	191	finally
    //   150	158	191	finally
    //   161	177	191	finally
    //   180	184	191	finally
  }
  
  public void a() {
    this.b = -1;
    HttpURLConnection httpURLConnection = this.a;
    if (httpURLConnection != null)
      httpURLConnection.disconnect(); 
  }
  
  public void b() {
    this.b = 1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\update\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */