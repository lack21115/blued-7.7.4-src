package com.loc;

import android.content.Context;
import android.net.SSLSessionCache;
import android.os.Build;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSocketFactory;

public final class au extends SSLSocketFactory {
  private SSLSocketFactory a;
  
  private Context b;
  
  private SSLContext c;
  
  public au(Context paramContext, SSLContext paramSSLContext) {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial <init> : ()V
    //   4: aload_1
    //   5: ifnull -> 16
    //   8: aload_0
    //   9: aload_1
    //   10: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   13: putfield b : Landroid/content/Context;
    //   16: aload_0
    //   17: aload_2
    //   18: putfield c : Ljavax/net/ssl/SSLContext;
    //   21: aload_2
    //   22: ifnull -> 33
    //   25: aload_0
    //   26: aload_2
    //   27: invokevirtual getSocketFactory : ()Ljavax/net/ssl/SSLSocketFactory;
    //   30: putfield a : Ljavax/net/ssl/SSLSocketFactory;
    //   33: aload_0
    //   34: getfield c : Ljavax/net/ssl/SSLContext;
    //   37: ifnonnull -> 67
    //   40: getstatic android/os/Build$VERSION.SDK_INT : I
    //   43: bipush #9
    //   45: if_icmplt -> 67
    //   48: aload_0
    //   49: invokestatic getDefault : ()Ljavax/net/ssl/SSLContext;
    //   52: putfield c : Ljavax/net/ssl/SSLContext;
    //   55: goto -> 67
    //   58: astore_1
    //   59: aload_1
    //   60: ldc 'myssl'
    //   62: ldc '<init2>'
    //   64: invokestatic b : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload_0
    //   68: getfield a : Ljavax/net/ssl/SSLSocketFactory;
    //   71: ifnonnull -> 94
    //   74: aload_0
    //   75: invokestatic getDefault : ()Ljavax/net/SocketFactory;
    //   78: checkcast javax/net/ssl/SSLSocketFactory
    //   81: putfield a : Ljavax/net/ssl/SSLSocketFactory;
    //   84: return
    //   85: astore_1
    //   86: aload_1
    //   87: ldc 'myssl'
    //   89: ldc '<init3>'
    //   91: invokestatic b : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   94: return
    //   95: astore_1
    //   96: aload_1
    //   97: ldc 'myssl'
    //   99: ldc '<init>'
    //   101: invokestatic b : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   104: aload_0
    //   105: getfield c : Ljavax/net/ssl/SSLContext;
    //   108: ifnonnull -> 138
    //   111: getstatic android/os/Build$VERSION.SDK_INT : I
    //   114: bipush #9
    //   116: if_icmplt -> 138
    //   119: aload_0
    //   120: invokestatic getDefault : ()Ljavax/net/ssl/SSLContext;
    //   123: putfield c : Ljavax/net/ssl/SSLContext;
    //   126: goto -> 138
    //   129: astore_1
    //   130: aload_1
    //   131: ldc 'myssl'
    //   133: ldc '<init2>'
    //   135: invokestatic b : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   138: aload_0
    //   139: getfield a : Ljavax/net/ssl/SSLSocketFactory;
    //   142: ifnonnull -> 165
    //   145: aload_0
    //   146: invokestatic getDefault : ()Ljavax/net/SocketFactory;
    //   149: checkcast javax/net/ssl/SSLSocketFactory
    //   152: putfield a : Ljavax/net/ssl/SSLSocketFactory;
    //   155: return
    //   156: astore_1
    //   157: aload_1
    //   158: ldc 'myssl'
    //   160: ldc '<init3>'
    //   162: invokestatic b : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   165: return
    //   166: astore_1
    //   167: aload_0
    //   168: getfield c : Ljavax/net/ssl/SSLContext;
    //   171: ifnonnull -> 201
    //   174: getstatic android/os/Build$VERSION.SDK_INT : I
    //   177: bipush #9
    //   179: if_icmplt -> 201
    //   182: aload_0
    //   183: invokestatic getDefault : ()Ljavax/net/ssl/SSLContext;
    //   186: putfield c : Ljavax/net/ssl/SSLContext;
    //   189: goto -> 201
    //   192: astore_2
    //   193: aload_2
    //   194: ldc 'myssl'
    //   196: ldc '<init2>'
    //   198: invokestatic b : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   201: aload_0
    //   202: getfield a : Ljavax/net/ssl/SSLSocketFactory;
    //   205: ifnonnull -> 230
    //   208: aload_0
    //   209: invokestatic getDefault : ()Ljavax/net/SocketFactory;
    //   212: checkcast javax/net/ssl/SSLSocketFactory
    //   215: putfield a : Ljavax/net/ssl/SSLSocketFactory;
    //   218: goto -> 230
    //   221: astore_2
    //   222: aload_2
    //   223: ldc 'myssl'
    //   225: ldc '<init3>'
    //   227: invokestatic b : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   230: aload_1
    //   231: athrow
    // Exception table:
    //   from	to	target	type
    //   8	16	95	finally
    //   16	21	95	finally
    //   25	33	95	finally
    //   33	55	58	finally
    //   67	84	85	finally
    //   96	104	166	finally
    //   104	126	129	finally
    //   138	155	156	finally
    //   167	189	192	finally
    //   201	218	221	finally
  }
  
  private static Socket a(Socket paramSocket) {
    try {
      if (Build.VERSION.SDK_INT < 21)
        return paramSocket; 
    } finally {
      Exception exception = null;
    } 
    return paramSocket;
  }
  
  private void a(SSLSessionCache paramSSLSessionCache) {
    SSLContext sSLContext = this.c;
    if (sSLContext == null)
      return; 
    try {
      int i;
      SSLSessionContext sSLSessionContext = sSLContext.getClientSessionContext();
      Field field = paramSSLSessionCache.getClass().getDeclaredField(u.c("UbVNlc3Npb25DYWNoZQ"));
      field.setAccessible(true);
      Object object = field.get(paramSSLSessionCache);
      Method[] arrayOfMethod = sSLSessionContext.getClass().getMethods();
      String str = u.c("Yc2V0UGVyc2lzdGVudENhY2hl");
      return;
    } finally {
      paramSSLSessionCache = null;
      ab.b((Throwable)paramSSLSessionCache, "myssl", "isc2");
    } 
  }
  
  private static void b(Socket paramSocket) {
    if (Build.VERSION.SDK_INT < 17)
      return; 
    if (l.f.c) {
      int i;
      if (!l.f.e)
        return; 
      if (!(paramSocket instanceof javax.net.ssl.SSLSocket))
        return; 
      if (l.f.f > l.f.d) {
        i = l.f.d;
      } else {
        i = l.f.f;
      } 
      if (i > 17 && Build.VERSION.SDK_INT > i)
        return; 
      Class<?> clazz = paramSocket.getClass();
      try {
        return;
      } finally {
        paramSocket = null;
      } 
    } 
  }
  
  public final void a() {
    if (Build.VERSION.SDK_INT < 17)
      return; 
    if (!l.f.c)
      return; 
    if (this.b != null) {
      if (this.c == null)
        return; 
      int i = l.f.d;
      if (i > 17 && Build.VERSION.SDK_INT > i)
        return; 
      SSLSessionCache sSLSessionCache = new SSLSessionCache(this.b);
      if (Build.VERSION.SDK_INT > 20 && Build.VERSION.SDK_INT < 28)
        try {
          return;
        } finally {
          Exception exception = null;
          ab.b(exception, "myssl", "isc1");
          a(sSLSessionCache);
        }  
      a(sSLSessionCache);
    } 
  }
  
  public final Socket createSocket() throws IOException {
    try {
      if (this.a != null)
        return socket; 
    } finally {
      Exception exception = null;
      ab.b(exception, "myssl", "cs1");
    } 
    return null;
  }
  
  public final Socket createSocket(String paramString, int paramInt) throws IOException, UnknownHostException {
    try {
      if (this.a != null)
        return socket; 
    } finally {
      paramString = null;
      ab.b((Throwable)paramString, "myssl", "cs3");
    } 
    return null;
  }
  
  public final Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2) throws IOException, UnknownHostException {
    try {
      if (this.a != null)
        return socket; 
    } finally {
      paramString = null;
      ab.b((Throwable)paramString, "myssl", "cs4");
    } 
    return null;
  }
  
  public final Socket createSocket(InetAddress paramInetAddress, int paramInt) throws IOException {
    try {
      if (this.a != null)
        return socket; 
    } finally {
      paramInetAddress = null;
      ab.b((Throwable)paramInetAddress, "myssl", "cs5");
    } 
    return null;
  }
  
  public final Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2) throws IOException {
    try {
      if (this.a != null)
        return socket; 
    } finally {
      paramInetAddress1 = null;
      ab.b((Throwable)paramInetAddress1, "myssl", "cs6");
    } 
    return null;
  }
  
  public final Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean) throws IOException {
    try {
      if (this.a != null)
        return paramSocket; 
    } finally {
      paramSocket = null;
      ab.b((Throwable)paramSocket, "myssl", "cs2");
    } 
    return null;
  }
  
  public final String[] getDefaultCipherSuites() {
    try {
      if (this.a != null)
        return this.a.getDefaultCipherSuites(); 
    } finally {
      Exception exception = null;
    } 
  }
  
  public final String[] getSupportedCipherSuites() {
    try {
      if (this.a != null)
        return this.a.getSupportedCipherSuites(); 
    } finally {
      Exception exception = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */