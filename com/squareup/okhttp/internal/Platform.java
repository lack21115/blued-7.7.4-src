package com.squareup.okhttp.internal;

import android.util.Log;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.tls.AndroidTrustRootIndex;
import com.squareup.okhttp.internal.tls.RealTrustRootIndex;
import com.squareup.okhttp.internal.tls.TrustRootIndex;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okio.Buffer;

public class Platform {
  private static final Platform PLATFORM = findPlatform();
  
  static byte[] concatLengthPrefixed(List<Protocol> paramList) {
    Buffer buffer = new Buffer();
    int j = paramList.size();
    for (int i = 0; i < j; i++) {
      Protocol protocol = paramList.get(i);
      if (protocol != Protocol.HTTP_1_0) {
        buffer.writeByte(protocol.toString().length());
        buffer.writeUtf8(protocol.toString());
      } 
    } 
    return buffer.readByteArray();
  }
  
  private static Platform findPlatform() {
    // Byte code:
    //   0: ldc 'com.android.org.conscrypt.SSLParametersImpl'
    //   2: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   5: astore_2
    //   6: goto -> 18
    //   9: ldc 'org.apache.harmony.xnet.provider.jsse.SSLParametersImpl'
    //   11: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   14: astore_2
    //   15: goto -> 6
    //   18: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
    //   21: astore_0
    //   22: aconst_null
    //   23: astore_3
    //   24: new com/squareup/okhttp/internal/OptionalMethod
    //   27: dup
    //   28: aconst_null
    //   29: ldc 'setUseSessionTickets'
    //   31: iconst_1
    //   32: anewarray java/lang/Class
    //   35: dup
    //   36: iconst_0
    //   37: aload_0
    //   38: aastore
    //   39: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   42: astore #6
    //   44: new com/squareup/okhttp/internal/OptionalMethod
    //   47: dup
    //   48: aconst_null
    //   49: ldc 'setHostname'
    //   51: iconst_1
    //   52: anewarray java/lang/Class
    //   55: dup
    //   56: iconst_0
    //   57: ldc java/lang/String
    //   59: aastore
    //   60: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   63: astore #7
    //   65: ldc 'android.net.TrafficStats'
    //   67: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   70: astore_0
    //   71: aload_0
    //   72: ldc 'tagSocket'
    //   74: iconst_1
    //   75: anewarray java/lang/Class
    //   78: dup
    //   79: iconst_0
    //   80: ldc java/net/Socket
    //   82: aastore
    //   83: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   86: astore #4
    //   88: aload_0
    //   89: ldc 'untagSocket'
    //   91: iconst_1
    //   92: anewarray java/lang/Class
    //   95: dup
    //   96: iconst_0
    //   97: ldc java/net/Socket
    //   99: aastore
    //   100: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   103: astore_1
    //   104: ldc 'android.net.Network'
    //   106: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   109: pop
    //   110: new com/squareup/okhttp/internal/OptionalMethod
    //   113: dup
    //   114: ldc [B
    //   116: ldc 'getAlpnSelectedProtocol'
    //   118: iconst_0
    //   119: anewarray java/lang/Class
    //   122: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   125: astore_0
    //   126: new com/squareup/okhttp/internal/OptionalMethod
    //   129: dup
    //   130: aconst_null
    //   131: ldc 'setAlpnProtocols'
    //   133: iconst_1
    //   134: anewarray java/lang/Class
    //   137: dup
    //   138: iconst_0
    //   139: ldc [B
    //   141: aastore
    //   142: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   145: astore #5
    //   147: aload #5
    //   149: astore_3
    //   150: goto -> 179
    //   153: aconst_null
    //   154: astore_0
    //   155: goto -> 179
    //   158: aconst_null
    //   159: astore_1
    //   160: aload_1
    //   161: astore_0
    //   162: goto -> 179
    //   165: aconst_null
    //   166: astore #5
    //   168: aload #5
    //   170: astore_1
    //   171: aload_1
    //   172: astore_0
    //   173: aload_1
    //   174: astore #4
    //   176: aload #5
    //   178: astore_1
    //   179: new com/squareup/okhttp/internal/Platform$Android
    //   182: dup
    //   183: aload_2
    //   184: aload #6
    //   186: aload #7
    //   188: aload #4
    //   190: aload_1
    //   191: aload_0
    //   192: aload_3
    //   193: invokespecial <init> : (Ljava/lang/Class;Lcom/squareup/okhttp/internal/OptionalMethod;Lcom/squareup/okhttp/internal/OptionalMethod;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Lcom/squareup/okhttp/internal/OptionalMethod;Lcom/squareup/okhttp/internal/OptionalMethod;)V
    //   196: astore_0
    //   197: aload_0
    //   198: areturn
    //   199: ldc 'sun.security.ssl.SSLContextImpl'
    //   201: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   204: astore_0
    //   205: ldc 'org.eclipse.jetty.alpn.ALPN'
    //   207: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   210: astore_1
    //   211: new java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial <init> : ()V
    //   218: astore_2
    //   219: aload_2
    //   220: ldc 'org.eclipse.jetty.alpn.ALPN'
    //   222: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload_2
    //   227: ldc '$Provider'
    //   229: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload_2
    //   234: invokevirtual toString : ()Ljava/lang/String;
    //   237: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   240: astore_2
    //   241: new java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial <init> : ()V
    //   248: astore_3
    //   249: aload_3
    //   250: ldc 'org.eclipse.jetty.alpn.ALPN'
    //   252: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload_3
    //   257: ldc '$ClientProvider'
    //   259: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload_3
    //   264: invokevirtual toString : ()Ljava/lang/String;
    //   267: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   270: astore_3
    //   271: new java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial <init> : ()V
    //   278: astore #4
    //   280: aload #4
    //   282: ldc 'org.eclipse.jetty.alpn.ALPN'
    //   284: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload #4
    //   290: ldc '$ServerProvider'
    //   292: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload #4
    //   298: invokevirtual toString : ()Ljava/lang/String;
    //   301: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   304: astore #4
    //   306: new com/squareup/okhttp/internal/Platform$JdkWithJettyBootPlatform
    //   309: dup
    //   310: aload_0
    //   311: aload_1
    //   312: ldc 'put'
    //   314: iconst_2
    //   315: anewarray java/lang/Class
    //   318: dup
    //   319: iconst_0
    //   320: ldc javax/net/ssl/SSLSocket
    //   322: aastore
    //   323: dup
    //   324: iconst_1
    //   325: aload_2
    //   326: aastore
    //   327: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   330: aload_1
    //   331: ldc 'get'
    //   333: iconst_1
    //   334: anewarray java/lang/Class
    //   337: dup
    //   338: iconst_0
    //   339: ldc javax/net/ssl/SSLSocket
    //   341: aastore
    //   342: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   345: aload_1
    //   346: ldc 'remove'
    //   348: iconst_1
    //   349: anewarray java/lang/Class
    //   352: dup
    //   353: iconst_0
    //   354: ldc javax/net/ssl/SSLSocket
    //   356: aastore
    //   357: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   360: aload_3
    //   361: aload #4
    //   363: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/Class;)V
    //   366: astore_1
    //   367: aload_1
    //   368: areturn
    //   369: new com/squareup/okhttp/internal/Platform$JdkPlatform
    //   372: dup
    //   373: aload_0
    //   374: invokespecial <init> : (Ljava/lang/Class;)V
    //   377: astore_0
    //   378: aload_0
    //   379: areturn
    //   380: new com/squareup/okhttp/internal/Platform
    //   383: dup
    //   384: invokespecial <init> : ()V
    //   387: areturn
    //   388: astore_0
    //   389: goto -> 9
    //   392: astore_0
    //   393: goto -> 199
    //   396: astore_0
    //   397: goto -> 165
    //   400: astore_0
    //   401: goto -> 158
    //   404: astore_0
    //   405: goto -> 153
    //   408: astore #5
    //   410: goto -> 179
    //   413: astore_0
    //   414: goto -> 380
    //   417: astore_1
    //   418: goto -> 369
    // Exception table:
    //   from	to	target	type
    //   0	6	388	java/lang/ClassNotFoundException
    //   9	15	392	java/lang/ClassNotFoundException
    //   18	22	392	java/lang/ClassNotFoundException
    //   24	65	392	java/lang/ClassNotFoundException
    //   65	88	396	java/lang/ClassNotFoundException
    //   65	88	396	java/lang/NoSuchMethodException
    //   88	104	400	java/lang/ClassNotFoundException
    //   88	104	400	java/lang/NoSuchMethodException
    //   104	126	404	java/lang/ClassNotFoundException
    //   104	126	404	java/lang/NoSuchMethodException
    //   126	147	408	java/lang/ClassNotFoundException
    //   126	147	408	java/lang/NoSuchMethodException
    //   179	197	392	java/lang/ClassNotFoundException
    //   199	205	413	java/lang/ClassNotFoundException
    //   205	367	417	java/lang/ClassNotFoundException
    //   205	367	417	java/lang/NoSuchMethodException
    //   369	378	413	java/lang/ClassNotFoundException
  }
  
  public static Platform get() {
    return PLATFORM;
  }
  
  static <T> T readFieldOrNull(Object paramObject, Class<T> paramClass, String paramString) {
    Class<?> clazz = paramObject.getClass();
    while (true) {
      if (clazz != Object.class)
        try {
          Field field = clazz.getDeclaredField(paramString);
          field.setAccessible(true);
          Object object = field.get(paramObject);
          return (object != null) ? (!paramClass.isInstance(object) ? null : paramClass.cast(object)) : null;
        } catch (NoSuchFieldException noSuchFieldException) {
          clazz = clazz.getSuperclass();
          continue;
        } catch (IllegalAccessException illegalAccessException) {
          throw new AssertionError();
        }  
      if (!paramString.equals("delegate")) {
        illegalAccessException = readFieldOrNull(illegalAccessException, Object.class, "delegate");
        if (illegalAccessException != null)
          return readFieldOrNull(illegalAccessException, paramClass, paramString); 
      } 
      return null;
    } 
  }
  
  public void afterHandshake(SSLSocket paramSSLSocket) {}
  
  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList) {}
  
  public void connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt) throws IOException {
    paramSocket.connect(paramInetSocketAddress, paramInt);
  }
  
  public String getPrefix() {
    return "OkHttp";
  }
  
  public String getSelectedProtocol(SSLSocket paramSSLSocket) {
    return null;
  }
  
  public void log(String paramString) {
    System.out.println(paramString);
  }
  
  public void logW(String paramString) {
    System.out.println(paramString);
  }
  
  public void tagSocket(Socket paramSocket) throws SocketException {}
  
  public X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory) {
    return null;
  }
  
  public TrustRootIndex trustRootIndex(X509TrustManager paramX509TrustManager) {
    return (TrustRootIndex)new RealTrustRootIndex(paramX509TrustManager.getAcceptedIssuers());
  }
  
  public void untagSocket(Socket paramSocket) throws SocketException {}
  
  static class Android extends Platform {
    private static final int MAX_LOG_LENGTH = 4000;
    
    private final OptionalMethod<Socket> getAlpnSelectedProtocol;
    
    private final OptionalMethod<Socket> setAlpnProtocols;
    
    private final OptionalMethod<Socket> setHostname;
    
    private final OptionalMethod<Socket> setUseSessionTickets;
    
    private final Class<?> sslParametersClass;
    
    private final Method trafficStatsTagSocket;
    
    private final Method trafficStatsUntagSocket;
    
    public Android(Class<?> param1Class, OptionalMethod<Socket> param1OptionalMethod1, OptionalMethod<Socket> param1OptionalMethod2, Method param1Method1, Method param1Method2, OptionalMethod<Socket> param1OptionalMethod3, OptionalMethod<Socket> param1OptionalMethod4) {
      this.sslParametersClass = param1Class;
      this.setUseSessionTickets = param1OptionalMethod1;
      this.setHostname = param1OptionalMethod2;
      this.trafficStatsTagSocket = param1Method1;
      this.trafficStatsUntagSocket = param1Method2;
      this.getAlpnSelectedProtocol = param1OptionalMethod3;
      this.setAlpnProtocols = param1OptionalMethod4;
    }
    
    public void configureTlsExtensions(SSLSocket param1SSLSocket, String param1String, List<Protocol> param1List) {
      if (param1String != null) {
        this.setUseSessionTickets.invokeOptionalWithoutCheckedException(param1SSLSocket, new Object[] { Boolean.valueOf(true) });
        this.setHostname.invokeOptionalWithoutCheckedException(param1SSLSocket, new Object[] { param1String });
      } 
      OptionalMethod<Socket> optionalMethod = this.setAlpnProtocols;
      if (optionalMethod != null && optionalMethod.isSupported(param1SSLSocket)) {
        byte[] arrayOfByte = concatLengthPrefixed(param1List);
        this.setAlpnProtocols.invokeWithoutCheckedException(param1SSLSocket, new Object[] { arrayOfByte });
      } 
    }
    
    public void connectSocket(Socket param1Socket, InetSocketAddress param1InetSocketAddress, int param1Int) throws IOException {
      try {
        param1Socket.connect(param1InetSocketAddress, param1Int);
        return;
      } catch (AssertionError assertionError) {
        if (Util.isAndroidGetsocknameError(assertionError))
          throw new IOException(assertionError); 
        throw assertionError;
      } catch (SecurityException securityException) {
        IOException iOException = new IOException("Exception in connect");
        iOException.initCause(securityException);
        throw iOException;
      } 
    }
    
    public String getSelectedProtocol(SSLSocket param1SSLSocket) {
      String str;
      OptionalMethod<Socket> optionalMethod = this.getAlpnSelectedProtocol;
      SSLSocket sSLSocket = null;
      if (optionalMethod == null)
        return null; 
      if (!optionalMethod.isSupported(param1SSLSocket))
        return null; 
      byte[] arrayOfByte = (byte[])this.getAlpnSelectedProtocol.invokeWithoutCheckedException(param1SSLSocket, new Object[0]);
      param1SSLSocket = sSLSocket;
      if (arrayOfByte != null)
        str = new String(arrayOfByte, Util.UTF_8); 
      return str;
    }
    
    public void log(String param1String) {
      int j = param1String.length();
      int i = 0;
      label16: while (i < j) {
        int k = param1String.indexOf('\n', i);
        if (k == -1)
          k = j; 
        while (true) {
          int m = Math.min(k, i + 4000);
          Log.d("OkHttp", param1String.substring(i, m));
          if (m >= k) {
            i = m + 1;
            continue label16;
          } 
          i = m;
        } 
      } 
    }
    
    public void tagSocket(Socket param1Socket) throws SocketException {
      Method method = this.trafficStatsTagSocket;
      if (method == null)
        return; 
      try {
        method.invoke(null, new Object[] { param1Socket });
        return;
      } catch (IllegalAccessException illegalAccessException) {
        throw new RuntimeException(illegalAccessException);
      } catch (InvocationTargetException invocationTargetException) {
        throw new RuntimeException(invocationTargetException.getCause());
      } 
    }
    
    public X509TrustManager trustManager(SSLSocketFactory param1SSLSocketFactory) {
      // Byte code:
      //   0: aload_1
      //   1: aload_0
      //   2: getfield sslParametersClass : Ljava/lang/Class;
      //   5: ldc 'sslParameters'
      //   7: invokestatic readFieldOrNull : (Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;
      //   10: astore_3
      //   11: aload_3
      //   12: astore_2
      //   13: aload_3
      //   14: ifnonnull -> 42
      //   17: aload_1
      //   18: ldc 'com.google.android.gms.org.conscrypt.SSLParametersImpl'
      //   20: iconst_0
      //   21: aload_1
      //   22: invokevirtual getClass : ()Ljava/lang/Class;
      //   25: invokevirtual getClassLoader : ()Ljava/lang/ClassLoader;
      //   28: invokestatic forName : (Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;
      //   31: ldc 'sslParameters'
      //   33: invokestatic readFieldOrNull : (Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;
      //   36: astore_2
      //   37: goto -> 42
      //   40: aconst_null
      //   41: areturn
      //   42: aload_2
      //   43: ldc javax/net/ssl/X509TrustManager
      //   45: ldc 'x509TrustManager'
      //   47: invokestatic readFieldOrNull : (Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;
      //   50: checkcast javax/net/ssl/X509TrustManager
      //   53: astore_1
      //   54: aload_1
      //   55: ifnull -> 60
      //   58: aload_1
      //   59: areturn
      //   60: aload_2
      //   61: ldc javax/net/ssl/X509TrustManager
      //   63: ldc 'trustManager'
      //   65: invokestatic readFieldOrNull : (Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;
      //   68: checkcast javax/net/ssl/X509TrustManager
      //   71: areturn
      //   72: astore_1
      //   73: goto -> 40
      // Exception table:
      //   from	to	target	type
      //   17	37	72	java/lang/ClassNotFoundException
    }
    
    public TrustRootIndex trustRootIndex(X509TrustManager param1X509TrustManager) {
      TrustRootIndex trustRootIndex = AndroidTrustRootIndex.get(param1X509TrustManager);
      return (trustRootIndex != null) ? trustRootIndex : super.trustRootIndex(param1X509TrustManager);
    }
    
    public void untagSocket(Socket param1Socket) throws SocketException {
      Method method = this.trafficStatsUntagSocket;
      if (method == null)
        return; 
      try {
        method.invoke(null, new Object[] { param1Socket });
        return;
      } catch (IllegalAccessException illegalAccessException) {
        throw new RuntimeException(illegalAccessException);
      } catch (InvocationTargetException invocationTargetException) {
        throw new RuntimeException(invocationTargetException.getCause());
      } 
    }
  }
  
  static class JdkPlatform extends Platform {
    private final Class<?> sslContextClass;
    
    public JdkPlatform(Class<?> param1Class) {
      this.sslContextClass = param1Class;
    }
    
    public X509TrustManager trustManager(SSLSocketFactory param1SSLSocketFactory) {
      param1SSLSocketFactory = readFieldOrNull(param1SSLSocketFactory, this.sslContextClass, "context");
      return (param1SSLSocketFactory == null) ? null : readFieldOrNull(param1SSLSocketFactory, X509TrustManager.class, "trustManager");
    }
  }
  
  static class JdkWithJettyBootPlatform extends JdkPlatform {
    private final Class<?> clientProviderClass;
    
    private final Method getMethod;
    
    private final Method putMethod;
    
    private final Method removeMethod;
    
    private final Class<?> serverProviderClass;
    
    public JdkWithJettyBootPlatform(Class<?> param1Class1, Method param1Method1, Method param1Method2, Method param1Method3, Class<?> param1Class2, Class<?> param1Class3) {
      super(param1Class1);
      this.putMethod = param1Method1;
      this.getMethod = param1Method2;
      this.removeMethod = param1Method3;
      this.clientProviderClass = param1Class2;
      this.serverProviderClass = param1Class3;
    }
    
    public void afterHandshake(SSLSocket param1SSLSocket) {
      try {
        this.removeMethod.invoke(null, new Object[] { param1SSLSocket });
        return;
      } catch (IllegalAccessException|InvocationTargetException illegalAccessException) {
        throw new AssertionError();
      } 
    }
    
    public void configureTlsExtensions(SSLSocket param1SSLSocket, String param1String, List<Protocol> param1List) {
      ArrayList<String> arrayList = new ArrayList(param1List.size());
      int j = param1List.size();
      int i;
      for (i = 0; i < j; i++) {
        Protocol protocol = param1List.get(i);
        if (protocol != Protocol.HTTP_1_0)
          arrayList.add(protocol.toString()); 
      } 
      try {
        ClassLoader classLoader = Platform.class.getClassLoader();
        Class<?> clazz1 = this.clientProviderClass;
        Class<?> clazz2 = this.serverProviderClass;
        Platform.JettyNegoProvider jettyNegoProvider = new Platform.JettyNegoProvider(arrayList);
        Object object = Proxy.newProxyInstance(classLoader, new Class[] { clazz1, clazz2 }, jettyNegoProvider);
        this.putMethod.invoke(null, new Object[] { param1SSLSocket, object });
        return;
      } catch (InvocationTargetException invocationTargetException) {
      
      } catch (IllegalAccessException illegalAccessException) {}
      throw new AssertionError(illegalAccessException);
    }
    
    public String getSelectedProtocol(SSLSocket param1SSLSocket) {
      try {
        Platform.JettyNegoProvider jettyNegoProvider = (Platform.JettyNegoProvider)Proxy.getInvocationHandler(this.getMethod.invoke(null, new Object[] { param1SSLSocket }));
        if (!jettyNegoProvider.unsupported && jettyNegoProvider.selected == null) {
          Internal.logger.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
          return null;
        } 
        return jettyNegoProvider.unsupported ? null : jettyNegoProvider.selected;
      } catch (InvocationTargetException|IllegalAccessException invocationTargetException) {
        throw new AssertionError();
      } 
    }
  }
  
  static class JettyNegoProvider implements InvocationHandler {
    private final List<String> protocols;
    
    private String selected;
    
    private boolean unsupported;
    
    public JettyNegoProvider(List<String> param1List) {
      this.protocols = param1List;
    }
    
    public Object invoke(Object param1Object, Method param1Method, Object[] param1ArrayOfObject) throws Throwable {
      String str = param1Method.getName();
      Class<?> clazz = param1Method.getReturnType();
      param1Object = param1ArrayOfObject;
      if (param1ArrayOfObject == null)
        param1Object = Util.EMPTY_STRING_ARRAY; 
      if (str.equals("supports") && boolean.class == clazz)
        return Boolean.valueOf(true); 
      if (str.equals("unsupported") && void.class == clazz) {
        this.unsupported = true;
        return null;
      } 
      if (str.equals("protocols") && param1Object.length == 0)
        return this.protocols; 
      if ((str.equals("selectProtocol") || str.equals("select")) && String.class == clazz && param1Object.length == 1 && param1Object[0] instanceof List) {
        param1Object = param1Object[0];
        int j = param1Object.size();
        int i;
        for (i = 0; i < j; i++) {
          if (this.protocols.contains(param1Object.get(i))) {
            param1Object = param1Object.get(i);
            this.selected = (String)param1Object;
            return param1Object;
          } 
        } 
        param1Object = this.protocols.get(0);
        this.selected = (String)param1Object;
        return param1Object;
      } 
      if ((str.equals("protocolSelected") || str.equals("selected")) && param1Object.length == 1) {
        this.selected = (String)param1Object[0];
        return null;
      } 
      return param1Method.invoke(this, (Object[])param1Object);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\internal\Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */