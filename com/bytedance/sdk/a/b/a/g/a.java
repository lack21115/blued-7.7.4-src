package com.bytedance.sdk.a.b.a.g;

import android.os.Build;
import android.util.Log;
import com.bytedance.sdk.a.b.a.i.f;
import com.bytedance.sdk.a.b.w;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

class a extends e {
  private final Class<?> a;
  
  private final d<Socket> b;
  
  private final d<Socket> c;
  
  private final d<Socket> d;
  
  private final d<Socket> e;
  
  private final c f = c.a();
  
  a(Class<?> paramClass, d<Socket> paramd1, d<Socket> paramd2, d<Socket> paramd3, d<Socket> paramd4) {
    this.a = paramClass;
    this.b = paramd1;
    this.c = paramd2;
    this.d = paramd3;
    this.e = paramd4;
  }
  
  public static e a() {
    // Byte code:
    //   0: ldc 'com.android.org.conscrypt.SSLParametersImpl'
    //   2: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   5: astore_0
    //   6: goto -> 18
    //   9: ldc 'org.apache.harmony.xnet.provider.jsse.SSLParametersImpl'
    //   11: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   14: astore_0
    //   15: goto -> 6
    //   18: new com/bytedance/sdk/a/b/a/g/d
    //   21: dup
    //   22: aconst_null
    //   23: ldc 'setUseSessionTickets'
    //   25: iconst_1
    //   26: anewarray java/lang/Class
    //   29: dup
    //   30: iconst_0
    //   31: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
    //   34: aastore
    //   35: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   38: astore_3
    //   39: new com/bytedance/sdk/a/b/a/g/d
    //   42: dup
    //   43: aconst_null
    //   44: ldc 'setHostname'
    //   46: iconst_1
    //   47: anewarray java/lang/Class
    //   50: dup
    //   51: iconst_0
    //   52: ldc java/lang/String
    //   54: aastore
    //   55: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   58: astore #4
    //   60: invokestatic c : ()Z
    //   63: ifeq -> 128
    //   66: new com/bytedance/sdk/a/b/a/g/d
    //   69: dup
    //   70: ldc [B
    //   72: ldc 'getAlpnSelectedProtocol'
    //   74: iconst_0
    //   75: anewarray java/lang/Class
    //   78: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   81: astore_1
    //   82: new com/bytedance/sdk/a/b/a/g/d
    //   85: dup
    //   86: aconst_null
    //   87: ldc 'setAlpnProtocols'
    //   89: iconst_1
    //   90: anewarray java/lang/Class
    //   93: dup
    //   94: iconst_0
    //   95: ldc [B
    //   97: aastore
    //   98: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   101: astore_2
    //   102: goto -> 105
    //   105: new com/bytedance/sdk/a/b/a/g/a
    //   108: dup
    //   109: aload_0
    //   110: aload_3
    //   111: aload #4
    //   113: aload_1
    //   114: aload_2
    //   115: invokespecial <init> : (Ljava/lang/Class;Lcom/bytedance/sdk/a/b/a/g/d;Lcom/bytedance/sdk/a/b/a/g/d;Lcom/bytedance/sdk/a/b/a/g/d;Lcom/bytedance/sdk/a/b/a/g/d;)V
    //   118: astore_0
    //   119: aload_0
    //   120: areturn
    //   121: astore_0
    //   122: goto -> 9
    //   125: astore_0
    //   126: aconst_null
    //   127: areturn
    //   128: aconst_null
    //   129: astore_1
    //   130: aload_1
    //   131: astore_2
    //   132: goto -> 105
    // Exception table:
    //   from	to	target	type
    //   0	6	121	java/lang/ClassNotFoundException
    //   9	15	125	java/lang/ClassNotFoundException
    //   18	102	125	java/lang/ClassNotFoundException
    //   105	119	125	java/lang/ClassNotFoundException
  }
  
  private boolean a(String paramString, Class<?> paramClass, Object paramObject) throws InvocationTargetException, IllegalAccessException {
    try {
      return ((Boolean)paramClass.getMethod("isCleartextTrafficPermitted", new Class[] { String.class }).invoke(paramObject, new Object[] { paramString })).booleanValue();
    } catch (NoSuchMethodException noSuchMethodException) {
      return b(paramString, paramClass, paramObject);
    } 
  }
  
  private boolean b(String paramString, Class<?> paramClass, Object paramObject) throws InvocationTargetException, IllegalAccessException {
    try {
      return ((Boolean)paramClass.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(paramObject, new Object[0])).booleanValue();
    } catch (NoSuchMethodException noSuchMethodException) {
      return super.b(paramString);
    } 
  }
  
  private static boolean c() {
    if (Security.getProvider("GMSCore_OpenSSL") != null)
      return true; 
    try {
      Class.forName("android.net.Network");
      return true;
    } catch (ClassNotFoundException classNotFoundException) {
      return false;
    } 
  }
  
  public com.bytedance.sdk.a.b.a.i.c a(X509TrustManager paramX509TrustManager) {
    try {
      Class<?> clazz = Class.forName("android.net.http.X509TrustManagerExtensions");
      return new a(clazz.getConstructor(new Class[] { X509TrustManager.class }, ).newInstance(new Object[] { paramX509TrustManager }, ), clazz.getMethod("checkServerTrusted", new Class[] { X509Certificate[].class, String.class, String.class }));
    } catch (Exception exception) {
      return super.a(paramX509TrustManager);
    } 
  }
  
  public Object a(String paramString) {
    return this.f.a(paramString);
  }
  
  public String a(SSLSocket paramSSLSocket) {
    String str;
    d<Socket> d1 = this.d;
    SSLSocket sSLSocket = null;
    if (d1 == null)
      return null; 
    if (!d1.a(paramSSLSocket))
      return null; 
    byte[] arrayOfByte = (byte[])this.d.d(paramSSLSocket, new Object[0]);
    paramSSLSocket = sSLSocket;
    if (arrayOfByte != null)
      str = new String(arrayOfByte, com.bytedance.sdk.a.b.a.c.e); 
    return str;
  }
  
  public void a(int paramInt, String paramString, Throwable paramThrowable) {
    byte b = 5;
    if (paramInt != 5)
      b = 3; 
    String str = paramString;
    if (paramThrowable != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append('\n');
      stringBuilder.append(Log.getStackTraceString(paramThrowable));
      str = stringBuilder.toString();
    } 
    paramInt = 0;
    int i = str.length();
    label23: while (paramInt < i) {
      int j = str.indexOf('\n', paramInt);
      if (j == -1)
        j = i; 
      while (true) {
        int k = Math.min(j, paramInt + 4000);
        Log.println(b, "OkHttp", str.substring(paramInt, k));
        if (k >= j) {
          paramInt = k + 1;
          continue label23;
        } 
        paramInt = k;
      } 
    } 
  }
  
  public void a(String paramString, Object paramObject) {
    if (!this.f.a(paramObject))
      a(5, paramString, (Throwable)null); 
  }
  
  public void a(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt) throws IOException {
    try {
      paramSocket.connect(paramInetSocketAddress, paramInt);
      return;
    } catch (AssertionError assertionError) {
      if (com.bytedance.sdk.a.b.a.c.a(assertionError))
        throw new IOException(assertionError); 
      throw assertionError;
    } catch (SecurityException securityException) {
      IOException iOException = new IOException("Exception in connect");
      iOException.initCause(securityException);
      throw iOException;
    } catch (ClassCastException classCastException) {
      if (Build.VERSION.SDK_INT == 26) {
        IOException iOException = new IOException("Exception in connect");
        iOException.initCause(classCastException);
        throw iOException;
      } 
      throw classCastException;
    } 
  }
  
  public void a(SSLSocket paramSSLSocket, String paramString, List<w> paramList) {
    if (paramString != null) {
      this.b.b(paramSSLSocket, new Object[] { Boolean.valueOf(true) });
      this.c.b(paramSSLSocket, new Object[] { paramString });
    } 
    d<Socket> d1 = this.e;
    if (d1 != null && d1.a(paramSSLSocket)) {
      byte[] arrayOfByte = b(paramList);
      this.e.d(paramSSLSocket, new Object[] { arrayOfByte });
    } 
  }
  
  public f b(X509TrustManager paramX509TrustManager) {
    try {
      Method method = paramX509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[] { X509Certificate.class });
      method.setAccessible(true);
      return new b(paramX509TrustManager, method);
    } catch (NoSuchMethodException noSuchMethodException) {
      return super.b(paramX509TrustManager);
    } 
  }
  
  public boolean b(String paramString) {
    try {
      Class<?> clazz = Class.forName("android.security.NetworkSecurityPolicy");
      return a(paramString, clazz, clazz.getMethod("getInstance", new Class[0]).invoke((Object)null, new Object[0]));
    } catch (ClassNotFoundException|NoSuchMethodException classNotFoundException) {
      return super.b(paramString);
    } catch (IllegalAccessException illegalAccessException) {
      throw com.bytedance.sdk.a.b.a.c.a("unable to determine cleartext support", illegalAccessException);
    } catch (IllegalArgumentException illegalArgumentException) {
      throw com.bytedance.sdk.a.b.a.c.a("unable to determine cleartext support", illegalArgumentException);
    } catch (InvocationTargetException invocationTargetException) {
      throw com.bytedance.sdk.a.b.a.c.a("unable to determine cleartext support", invocationTargetException);
    } 
  }
  
  static final class a extends com.bytedance.sdk.a.b.a.i.c {
    private final Object a;
    
    private final Method b;
    
    a(Object param1Object, Method param1Method) {
      this.a = param1Object;
      this.b = param1Method;
    }
    
    public List<Certificate> a(List<Certificate> param1List, String param1String) throws SSLPeerUnverifiedException {
      try {
        X509Certificate[] arrayOfX509Certificate = param1List.<X509Certificate>toArray(new X509Certificate[param1List.size()]);
        return (List)this.b.invoke(this.a, new Object[] { arrayOfX509Certificate, "RSA", param1String });
      } catch (InvocationTargetException invocationTargetException) {
        SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(invocationTargetException.getMessage());
        sSLPeerUnverifiedException.initCause(invocationTargetException);
        throw sSLPeerUnverifiedException;
      } catch (IllegalAccessException illegalAccessException) {
        throw new AssertionError(illegalAccessException);
      } 
    }
    
    public boolean equals(Object param1Object) {
      return param1Object instanceof a;
    }
    
    public int hashCode() {
      return 0;
    }
  }
  
  static final class b implements f {
    private final X509TrustManager a;
    
    private final Method b;
    
    b(X509TrustManager param1X509TrustManager, Method param1Method) {
      this.b = param1Method;
      this.a = param1X509TrustManager;
    }
    
    public X509Certificate a(X509Certificate param1X509Certificate) {
      X509Certificate x509Certificate = null;
      try {
        TrustAnchor trustAnchor = (TrustAnchor)this.b.invoke(this.a, new Object[] { param1X509Certificate });
        param1X509Certificate = x509Certificate;
        if (trustAnchor != null)
          param1X509Certificate = trustAnchor.getTrustedCert(); 
        return param1X509Certificate;
      } catch (IllegalAccessException illegalAccessException) {
        throw com.bytedance.sdk.a.b.a.c.a("unable to get issues and signature", illegalAccessException);
      } catch (InvocationTargetException invocationTargetException) {
        return null;
      } 
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof b))
        return false; 
      param1Object = param1Object;
      return (this.a.equals(((b)param1Object).a) && this.b.equals(((b)param1Object).b));
    }
    
    public int hashCode() {
      return this.a.hashCode() + this.b.hashCode() * 31;
    }
  }
  
  static final class c {
    private final Method a;
    
    private final Method b;
    
    private final Method c;
    
    c(Method param1Method1, Method param1Method2, Method param1Method3) {
      this.a = param1Method1;
      this.b = param1Method2;
      this.c = param1Method3;
    }
    
    static c a() {
      Exception exception2;
      Method method = null;
      try {
        Class<?> clazz = Class.forName("dalvik.system.CloseGuard");
        Method method3 = clazz.getMethod("get", new Class[0]);
        Method method2 = clazz.getMethod("open", new Class[] { String.class });
        Method method1 = clazz.getMethod("warnIfOpen", new Class[0]);
        method = method3;
      } catch (Exception exception1) {
        exception1 = null;
        exception2 = exception1;
      } 
      return new c(method, (Method)exception2, (Method)exception1);
    }
    
    Object a(String param1String) {
      Method method = this.a;
      if (method != null)
        try {
          Object object = method.invoke((Object)null, new Object[0]);
          this.b.invoke(object, new Object[] { param1String });
          return object;
        } catch (Exception exception) {
          return null;
        }  
      return null;
    }
    
    boolean a(Object param1Object) {
      boolean bool = false;
      if (param1Object != null)
        try {
          this.c.invoke(param1Object, new Object[0]);
          return true;
        } catch (Exception exception) {
          return false;
        }  
      return bool;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */