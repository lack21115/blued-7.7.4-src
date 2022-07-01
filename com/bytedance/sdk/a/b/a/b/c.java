package com.bytedance.sdk.a.b.a.b;

import com.bytedance.sdk.a.a.d;
import com.bytedance.sdk.a.a.e;
import com.bytedance.sdk.a.a.l;
import com.bytedance.sdk.a.a.s;
import com.bytedance.sdk.a.b.a;
import com.bytedance.sdk.a.b.a.a;
import com.bytedance.sdk.a.b.a.c.e;
import com.bytedance.sdk.a.b.a.d;
import com.bytedance.sdk.a.b.a.d.a;
import com.bytedance.sdk.a.b.a.e.b;
import com.bytedance.sdk.a.b.a.e.f;
import com.bytedance.sdk.a.b.a.e.g;
import com.bytedance.sdk.a.b.a.e.i;
import com.bytedance.sdk.a.b.a.g.e;
import com.bytedance.sdk.a.b.a.i.e;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.ac;
import com.bytedance.sdk.a.b.e;
import com.bytedance.sdk.a.b.h;
import com.bytedance.sdk.a.b.i;
import com.bytedance.sdk.a.b.j;
import com.bytedance.sdk.a.b.k;
import com.bytedance.sdk.a.b.p;
import com.bytedance.sdk.a.b.q;
import com.bytedance.sdk.a.b.s;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.w;
import com.bytedance.sdk.a.b.y;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public final class c extends g.b implements i {
  public boolean a;
  
  public int b;
  
  public int c = 1;
  
  public final List<Reference<g>> d = new ArrayList<Reference<g>>();
  
  public long e = Long.MAX_VALUE;
  
  private final j g;
  
  private final ac h;
  
  private Socket i;
  
  private Socket j;
  
  private q k;
  
  private w l;
  
  private g m;
  
  private e n;
  
  private d o;
  
  public c(j paramj, ac paramac) {
    this.g = paramj;
    this.h = paramac;
  }
  
  private y a(int paramInt1, int paramInt2, y paramy, s params) throws IOException {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("CONNECT ");
    stringBuilder.append(com.bytedance.sdk.a.b.a.c.a(params, true));
    stringBuilder.append(" HTTP/1.1");
    String str = stringBuilder.toString();
    while (true) {
      a a = new a(null, null, this.n, this.o);
      this.n.a().a(paramInt1, TimeUnit.MILLISECONDS);
      this.o.a().a(paramInt2, TimeUnit.MILLISECONDS);
      a.a(paramy.c(), str);
      a.b();
      aa aa = a.a(false).a(paramy).a();
      long l2 = e.a(aa);
      long l1 = l2;
      if (l2 == -1L)
        l1 = 0L; 
      s s1 = a.b(l1);
      com.bytedance.sdk.a.b.a.c.b(s1, 2147483647, TimeUnit.MILLISECONDS);
      s1.close();
      int k = aa.c();
      if (k != 200) {
        if (k == 407) {
          y y1 = this.h.a().d().a(this.h, aa);
          if (y1 != null) {
            if ("close".equalsIgnoreCase(aa.a("Connection")))
              return y1; 
            continue;
          } 
          throw new IOException("Failed to authenticate with proxy");
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Unexpected response code for CONNECT: ");
        stringBuilder1.append(aa.c());
        throw new IOException(stringBuilder1.toString());
      } 
      if (this.n.c().e() && this.o.c().e())
        return null; 
      throw new IOException("TLS tunnel buffered too many bytes!");
    } 
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, e parame, p paramp) throws IOException {
    y y = e();
    s s = y.a();
    int k;
    for (k = 0; k < 21; k++) {
      a(paramInt1, paramInt2, parame, paramp);
      y = a(paramInt2, paramInt3, y, s);
      if (y == null)
        return; 
      com.bytedance.sdk.a.b.a.c.a(this.i);
      this.i = null;
      this.o = null;
      this.n = null;
      paramp.a(parame, this.h.c(), this.h.b(), null);
    } 
  }
  
  private void a(int paramInt1, int paramInt2, e parame, p paramp) throws IOException {
    Socket socket;
    Proxy proxy = this.h.b();
    a a = this.h.a();
    if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.HTTP) {
      socket = a.c().createSocket();
    } else {
      socket = new Socket(proxy);
    } 
    this.i = socket;
    paramp.a(parame, this.h.c(), proxy);
    this.i.setSoTimeout(paramInt2);
    try {
      e.b().a(this.i, this.h.c(), paramInt1);
      try {
        this.n = l.a(l.b(this.i));
        this.o = l.a(l.a(this.i));
        return;
      } catch (NullPointerException nullPointerException) {
        if (!"throw with null exception".equals(nullPointerException.getMessage()))
          return; 
        throw new IOException(nullPointerException);
      } 
    } catch (ConnectException connectException1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failed to connect to ");
      stringBuilder.append(this.h.c());
      ConnectException connectException2 = new ConnectException(stringBuilder.toString());
      connectException2.initCause(connectException1);
      throw connectException2;
    } 
  }
  
  private void a(b paramb) throws IOException {
    AssertionError assertionError2;
    a a = this.h.a();
    SSLSocketFactory sSLSocketFactory = a.i();
    q q1 = null;
    k k = null;
    b b2 = null;
    try {
      SSLSocket sSLSocket = (SSLSocket)sSLSocketFactory.createSocket(this.i, a.a().f(), a.a().g(), true);
    } catch (AssertionError null) {
    
    } finally {
      paramb = null;
    } 
    b b1 = paramb;
    if (com.bytedance.sdk.a.b.a.c.a(assertionError2)) {
      b1 = paramb;
      throw new IOException(assertionError2);
    } 
    b1 = paramb;
    throw assertionError2;
  }
  
  private void a(b paramb, e parame, p paramp) throws IOException {
    if (this.h.a().i() == null) {
      this.l = w.b;
      this.j = this.i;
      return;
    } 
    paramp.b(parame);
    a(paramb);
    paramp.a(parame, this.k);
    if (this.l == w.d) {
      this.j.setSoTimeout(0);
      this.m = (new g.a(true)).a(this.j, this.h.a().a().f(), this.n, this.o).a(this).a();
      this.m.c();
    } 
  }
  
  private y e() {
    return (new y.a()).a(this.h.a().a()).a("Host", com.bytedance.sdk.a.b.a.c.a(this.h.a().a(), true)).a("Proxy-Connection", "Keep-Alive").a("User-Agent", d.a()).d();
  }
  
  public com.bytedance.sdk.a.b.a.c.c a(v paramv, t.a parama, g paramg) throws SocketException {
    g g1 = this.m;
    if (g1 != null)
      return (com.bytedance.sdk.a.b.a.c.c)new f(paramv, parama, paramg, g1); 
    this.j.setSoTimeout(parama.c());
    this.n.a().a(parama.c(), TimeUnit.MILLISECONDS);
    this.o.a().a(parama.d(), TimeUnit.MILLISECONDS);
    return (com.bytedance.sdk.a.b.a.c.c)new a(paramv, paramg, this.n, this.o);
  }
  
  public ac a() {
    return this.h;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, e parame, p paramp) {
    // Byte code:
    //   0: aload_0
    //   1: getfield l : Lcom/bytedance/sdk/a/b/w;
    //   4: ifnonnull -> 449
    //   7: aload_0
    //   8: getfield h : Lcom/bytedance/sdk/a/b/ac;
    //   11: invokevirtual a : ()Lcom/bytedance/sdk/a/b/a;
    //   14: invokevirtual f : ()Ljava/util/List;
    //   17: astore #7
    //   19: new com/bytedance/sdk/a/b/a/b/b
    //   22: dup
    //   23: aload #7
    //   25: invokespecial <init> : (Ljava/util/List;)V
    //   28: astore #9
    //   30: aload_0
    //   31: getfield h : Lcom/bytedance/sdk/a/b/ac;
    //   34: invokevirtual a : ()Lcom/bytedance/sdk/a/b/a;
    //   37: invokevirtual i : ()Ljavax/net/ssl/SSLSocketFactory;
    //   40: ifnonnull -> 158
    //   43: aload #7
    //   45: getstatic com/bytedance/sdk/a/b/k.c : Lcom/bytedance/sdk/a/b/k;
    //   48: invokeinterface contains : (Ljava/lang/Object;)Z
    //   53: ifeq -> 140
    //   56: aload_0
    //   57: getfield h : Lcom/bytedance/sdk/a/b/ac;
    //   60: invokevirtual a : ()Lcom/bytedance/sdk/a/b/a;
    //   63: invokevirtual a : ()Lcom/bytedance/sdk/a/b/s;
    //   66: invokevirtual f : ()Ljava/lang/String;
    //   69: astore #7
    //   71: invokestatic b : ()Lcom/bytedance/sdk/a/b/a/g/e;
    //   74: aload #7
    //   76: invokevirtual b : (Ljava/lang/String;)Z
    //   79: ifeq -> 85
    //   82: goto -> 158
    //   85: new java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial <init> : ()V
    //   92: astore #5
    //   94: aload #5
    //   96: ldc_w 'CLEARTEXT communication to '
    //   99: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload #5
    //   105: aload #7
    //   107: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload #5
    //   113: ldc_w ' not permitted by network security policy'
    //   116: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: new com/bytedance/sdk/a/b/a/b/e
    //   123: dup
    //   124: new java/net/UnknownServiceException
    //   127: dup
    //   128: aload #5
    //   130: invokevirtual toString : ()Ljava/lang/String;
    //   133: invokespecial <init> : (Ljava/lang/String;)V
    //   136: invokespecial <init> : (Ljava/io/IOException;)V
    //   139: athrow
    //   140: new com/bytedance/sdk/a/b/a/b/e
    //   143: dup
    //   144: new java/net/UnknownServiceException
    //   147: dup
    //   148: ldc_w 'CLEARTEXT communication not enabled for client'
    //   151: invokespecial <init> : (Ljava/lang/String;)V
    //   154: invokespecial <init> : (Ljava/io/IOException;)V
    //   157: athrow
    //   158: aconst_null
    //   159: astore #7
    //   161: aload_0
    //   162: getfield h : Lcom/bytedance/sdk/a/b/ac;
    //   165: invokevirtual d : ()Z
    //   168: ifeq -> 199
    //   171: aload_0
    //   172: iload_1
    //   173: iload_2
    //   174: iload_3
    //   175: aload #5
    //   177: aload #6
    //   179: invokespecial a : (IIILcom/bytedance/sdk/a/b/e;Lcom/bytedance/sdk/a/b/p;)V
    //   182: aload_0
    //   183: getfield i : Ljava/net/Socket;
    //   186: astore #8
    //   188: aload #8
    //   190: ifnonnull -> 196
    //   193: goto -> 244
    //   196: goto -> 209
    //   199: aload_0
    //   200: iload_1
    //   201: iload_2
    //   202: aload #5
    //   204: aload #6
    //   206: invokespecial a : (IILcom/bytedance/sdk/a/b/e;Lcom/bytedance/sdk/a/b/p;)V
    //   209: aload_0
    //   210: aload #9
    //   212: aload #5
    //   214: aload #6
    //   216: invokespecial a : (Lcom/bytedance/sdk/a/b/a/b/b;Lcom/bytedance/sdk/a/b/e;Lcom/bytedance/sdk/a/b/p;)V
    //   219: aload #6
    //   221: aload #5
    //   223: aload_0
    //   224: getfield h : Lcom/bytedance/sdk/a/b/ac;
    //   227: invokevirtual c : ()Ljava/net/InetSocketAddress;
    //   230: aload_0
    //   231: getfield h : Lcom/bytedance/sdk/a/b/ac;
    //   234: invokevirtual b : ()Ljava/net/Proxy;
    //   237: aload_0
    //   238: getfield l : Lcom/bytedance/sdk/a/b/w;
    //   241: invokevirtual a : (Lcom/bytedance/sdk/a/b/e;Ljava/net/InetSocketAddress;Ljava/net/Proxy;Lcom/bytedance/sdk/a/b/w;)V
    //   244: aload_0
    //   245: getfield h : Lcom/bytedance/sdk/a/b/ac;
    //   248: invokevirtual d : ()Z
    //   251: ifeq -> 282
    //   254: aload_0
    //   255: getfield i : Ljava/net/Socket;
    //   258: ifnull -> 264
    //   261: goto -> 282
    //   264: new com/bytedance/sdk/a/b/a/b/e
    //   267: dup
    //   268: new java/net/ProtocolException
    //   271: dup
    //   272: ldc_w 'Too many tunnel connections attempted: 21'
    //   275: invokespecial <init> : (Ljava/lang/String;)V
    //   278: invokespecial <init> : (Ljava/io/IOException;)V
    //   281: athrow
    //   282: aload_0
    //   283: getfield m : Lcom/bytedance/sdk/a/b/a/e/g;
    //   286: ifnull -> 321
    //   289: aload_0
    //   290: getfield g : Lcom/bytedance/sdk/a/b/j;
    //   293: astore #5
    //   295: aload #5
    //   297: monitorenter
    //   298: aload_0
    //   299: aload_0
    //   300: getfield m : Lcom/bytedance/sdk/a/b/a/e/g;
    //   303: invokevirtual a : ()I
    //   306: putfield c : I
    //   309: aload #5
    //   311: monitorexit
    //   312: return
    //   313: astore #6
    //   315: aload #5
    //   317: monitorexit
    //   318: aload #6
    //   320: athrow
    //   321: return
    //   322: astore #8
    //   324: goto -> 329
    //   327: astore #8
    //   329: aload_0
    //   330: getfield j : Ljava/net/Socket;
    //   333: invokestatic a : (Ljava/net/Socket;)V
    //   336: aload_0
    //   337: getfield i : Ljava/net/Socket;
    //   340: invokestatic a : (Ljava/net/Socket;)V
    //   343: aload_0
    //   344: aconst_null
    //   345: putfield j : Ljava/net/Socket;
    //   348: aload_0
    //   349: aconst_null
    //   350: putfield i : Ljava/net/Socket;
    //   353: aload_0
    //   354: aconst_null
    //   355: putfield n : Lcom/bytedance/sdk/a/a/e;
    //   358: aload_0
    //   359: aconst_null
    //   360: putfield o : Lcom/bytedance/sdk/a/a/d;
    //   363: aload_0
    //   364: aconst_null
    //   365: putfield k : Lcom/bytedance/sdk/a/b/q;
    //   368: aload_0
    //   369: aconst_null
    //   370: putfield l : Lcom/bytedance/sdk/a/b/w;
    //   373: aload_0
    //   374: aconst_null
    //   375: putfield m : Lcom/bytedance/sdk/a/b/a/e/g;
    //   378: aload #6
    //   380: aload #5
    //   382: aload_0
    //   383: getfield h : Lcom/bytedance/sdk/a/b/ac;
    //   386: invokevirtual c : ()Ljava/net/InetSocketAddress;
    //   389: aload_0
    //   390: getfield h : Lcom/bytedance/sdk/a/b/ac;
    //   393: invokevirtual b : ()Ljava/net/Proxy;
    //   396: aconst_null
    //   397: aload #8
    //   399: invokevirtual a : (Lcom/bytedance/sdk/a/b/e;Ljava/net/InetSocketAddress;Ljava/net/Proxy;Lcom/bytedance/sdk/a/b/w;Ljava/io/IOException;)V
    //   402: aload #7
    //   404: ifnonnull -> 421
    //   407: new com/bytedance/sdk/a/b/a/b/e
    //   410: dup
    //   411: aload #8
    //   413: invokespecial <init> : (Ljava/io/IOException;)V
    //   416: astore #7
    //   418: goto -> 428
    //   421: aload #7
    //   423: aload #8
    //   425: invokevirtual a : (Ljava/io/IOException;)V
    //   428: iload #4
    //   430: ifeq -> 446
    //   433: aload #9
    //   435: aload #8
    //   437: invokevirtual a : (Ljava/io/IOException;)Z
    //   440: ifeq -> 446
    //   443: goto -> 161
    //   446: aload #7
    //   448: athrow
    //   449: new java/lang/IllegalStateException
    //   452: dup
    //   453: ldc_w 'already connected'
    //   456: invokespecial <init> : (Ljava/lang/String;)V
    //   459: athrow
    // Exception table:
    //   from	to	target	type
    //   161	188	327	java/io/IOException
    //   199	209	322	java/io/IOException
    //   209	244	322	java/io/IOException
    //   298	312	313	finally
    //   315	318	313	finally
  }
  
  public void a(g paramg) {
    synchronized (this.g) {
      this.c = paramg.a();
      return;
    } 
  }
  
  public void a(i parami) throws IOException {
    parami.a(b.e);
  }
  
  public boolean a(a parama, ac paramac) {
    if (this.d.size() < this.c) {
      if (this.a)
        return false; 
      if (!a.a.a(this.h.a(), parama))
        return false; 
      if (parama.a().f().equals(a().a().a().f()))
        return true; 
      if (this.m == null)
        return false; 
      if (paramac == null)
        return false; 
      if (paramac.b().type() != Proxy.Type.DIRECT)
        return false; 
      if (this.h.b().type() != Proxy.Type.DIRECT)
        return false; 
      if (!this.h.c().equals(paramac.c()))
        return false; 
      if (paramac.a().j() != e.a)
        return false; 
      if (!a(parama.a()))
        return false; 
      try {
        parama.k().a(parama.a().f(), c().b());
        return true;
      } catch (SSLPeerUnverifiedException sSLPeerUnverifiedException) {
        return false;
      } 
    } 
    return false;
  }
  
  public boolean a(s params) {
    if (params.g() != this.h.a().a().g())
      return false; 
    boolean bool1 = params.f().equals(this.h.a().a().f());
    boolean bool = true;
    if (!bool1) {
      if (this.k != null && e.a.a(params.f(), this.k.b().get(0)))
        return true; 
      bool = false;
    } 
    return bool;
  }
  
  public boolean a(boolean paramBoolean) {
    if (!this.j.isClosed() && !this.j.isInputShutdown()) {
      if (this.j.isOutputShutdown())
        return false; 
      g g1 = this.m;
      if (g1 != null)
        return g1.d() ^ true; 
      if (paramBoolean)
        try {
          int k = this.j.getSoTimeout();
          try {
            this.j.setSoTimeout(1);
            paramBoolean = this.n.e();
            if (paramBoolean)
              return false; 
            return true;
          } finally {
            this.j.setSoTimeout(k);
          } 
        } catch (SocketTimeoutException socketTimeoutException) {
          return true;
        } catch (IOException iOException) {
          return false;
        }  
      return true;
    } 
    return false;
  }
  
  public Socket b() {
    return this.j;
  }
  
  public q c() {
    return this.k;
  }
  
  public boolean d() {
    return (this.m != null);
  }
  
  public String toString() {
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Connection{");
    stringBuilder.append(this.h.a().a().f());
    stringBuilder.append(":");
    stringBuilder.append(this.h.a().a().g());
    stringBuilder.append(", proxy=");
    stringBuilder.append(this.h.b());
    stringBuilder.append(" hostAddress=");
    stringBuilder.append(this.h.c());
    stringBuilder.append(" cipherSuite=");
    q q1 = this.k;
    if (q1 != null) {
      h h = q1.a();
    } else {
      str = "none";
    } 
    stringBuilder.append(str);
    stringBuilder.append(" protocol=");
    stringBuilder.append(this.l);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */