package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.b.a;
import com.bytedance.sdk.a.b.a.b.c;
import com.bytedance.sdk.a.b.a.b.e;
import com.bytedance.sdk.a.b.a.b.g;
import com.bytedance.sdk.a.b.a.c;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.ac;
import com.bytedance.sdk.a.b.e;
import com.bytedance.sdk.a.b.g;
import com.bytedance.sdk.a.b.p;
import com.bytedance.sdk.a.b.s;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.y;
import com.bytedance.sdk.a.b.z;
import java.io.Closeable;
import java.io.IOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class j implements t {
  private final v a;
  
  private final boolean b;
  
  private g c;
  
  private Object d;
  
  private volatile boolean e;
  
  public j(v paramv, boolean paramBoolean) {
    this.a = paramv;
    this.b = paramBoolean;
  }
  
  private a a(s params) {
    SSLSocketFactory sSLSocketFactory1;
    SSLSocketFactory sSLSocketFactory2;
    SSLSocketFactory sSLSocketFactory3;
    if (params.c()) {
      sSLSocketFactory2 = this.a.j();
      sSLSocketFactory1 = (SSLSocketFactory)this.a.k();
      g g1 = this.a.l();
      sSLSocketFactory3 = (SSLSocketFactory)g1;
    } else {
      SSLSocketFactory sSLSocketFactory = null;
      sSLSocketFactory1 = sSLSocketFactory;
      sSLSocketFactory3 = sSLSocketFactory1;
      sSLSocketFactory2 = sSLSocketFactory;
    } 
    return new a(params.f(), params.g(), this.a.h(), this.a.i(), sSLSocketFactory2, (HostnameVerifier)sSLSocketFactory1, (g)sSLSocketFactory3, this.a.n(), this.a.d(), this.a.t(), this.a.u(), this.a.e());
  }
  
  private y a(aa paramaa) throws IOException {
    if (paramaa != null) {
      c c = this.c.b();
      Proxy proxy = null;
      if (c != null) {
        ac ac = c.a();
      } else {
        c = null;
      } 
      int i = paramaa.c();
      String str2 = paramaa.a().b();
      if (i != 307 && i != 308) {
        if (i != 401) {
          if (i != 407) {
            if (i != 408) {
              switch (i) {
                default:
                  return null;
                case 300:
                case 301:
                case 302:
                case 303:
                  break;
              } 
            } else {
              return !this.a.r() ? null : ((paramaa.a().d() instanceof l) ? null : ((paramaa.i() != null && paramaa.i().c() == 408) ? null : paramaa.a()));
            } 
          } else {
            if (c != null) {
              proxy = c.b();
            } else {
              proxy = this.a.d();
            } 
            if (proxy.type() == Proxy.Type.HTTP)
              return this.a.n().a((ac)c, paramaa); 
            throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
          } 
        } else {
          return this.a.m().a((ac)c, paramaa);
        } 
      } else if (!str2.equals("GET") && !str2.equals("HEAD")) {
        return null;
      } 
      if (!this.a.q())
        return null; 
      String str1 = paramaa.a("Location");
      if (str1 == null)
        return null; 
      s s = paramaa.a().a().c(str1);
      if (s == null)
        return null; 
      if (!s.b().equals(paramaa.a().a().b()) && !this.a.p())
        return null; 
      y.a a = paramaa.a().e();
      if (f.c(str2)) {
        boolean bool = f.d(str2);
        if (f.e(str2)) {
          a.a("GET", null);
        } else {
          z z;
          Proxy proxy1 = proxy;
          if (bool)
            z = paramaa.a().d(); 
          a.a(str2, z);
        } 
        if (!bool) {
          a.a("Transfer-Encoding");
          a.a("Content-Length");
          a.a("Content-Type");
        } 
      } 
      if (!a(paramaa, s))
        a.a("Authorization"); 
      return a.a(s).d();
    } 
    throw new IllegalStateException();
  }
  
  private boolean a(aa paramaa, s params) {
    s s1 = paramaa.a().a();
    return (s1.f().equals(params.f()) && s1.g() == params.g() && s1.b().equals(params.b()));
  }
  
  private boolean a(IOException paramIOException, boolean paramBoolean) {
    boolean bool = paramIOException instanceof ProtocolException;
    boolean bool1 = false;
    if (bool)
      return false; 
    if (paramIOException instanceof java.io.InterruptedIOException) {
      bool = bool1;
      if (paramIOException instanceof java.net.SocketTimeoutException) {
        bool = bool1;
        if (!paramBoolean)
          bool = true; 
      } 
      return bool;
    } 
    return (paramIOException instanceof javax.net.ssl.SSLHandshakeException && paramIOException.getCause() instanceof java.security.cert.CertificateException) ? false : (!(paramIOException instanceof javax.net.ssl.SSLPeerUnverifiedException));
  }
  
  private boolean a(IOException paramIOException, boolean paramBoolean, y paramy) {
    this.c.a(paramIOException);
    return !this.a.r() ? false : ((paramBoolean && paramy.d() instanceof l) ? false : (!a(paramIOException, paramBoolean) ? false : (!!this.c.e())));
  }
  
  public aa a(t.a parama) throws IOException {
    y y2 = parama.i();
    g g1 = (g)parama;
    e e = g1.g();
    p p = g1.h();
    this.c = new g(this.a.o(), a(y2.a()), e, p, this.d);
    aa aa = null;
    int i = 0;
    y y1 = y2;
    while (true) {
      if (!this.e) {
        StringBuilder stringBuilder;
        try {
          aa aa2 = g1.a(y1, this.c, null, null);
          aa aa1 = aa2;
          if (aa != null)
            aa1 = aa2.h().c(aa.h().a(null).a()).a(); 
          y y = a(aa1);
          if (y == null) {
            if (!this.b)
              this.c.c(); 
            return aa1;
          } 
          c.a((Closeable)aa1.g());
          if (++i <= 20) {
            y y3;
            if (!(y.d() instanceof l)) {
              if (!a(aa1, y.a())) {
                this.c.c();
                this.c = new g(this.a.o(), a(y.a()), e, p, this.d);
              } else if (this.c.a() != null) {
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append("Closing the body of ");
                stringBuilder1.append(aa1);
                stringBuilder1.append(" didn't close its backing stream. Bad interceptor?");
                throw new IllegalStateException(stringBuilder1.toString());
              } 
              aa = aa1;
              y3 = y;
              continue;
            } 
            this.c.c();
            throw new HttpRetryException("Cannot retry streamed HTTP body", y3.c());
          } 
          this.c.c();
          stringBuilder = new StringBuilder();
          stringBuilder.append("Too many follow-up requests: ");
          stringBuilder.append(i);
          throw new ProtocolException(stringBuilder.toString());
        } catch (e e1) {
          if (a(e1.a(), false, (y)stringBuilder))
            continue; 
          throw e1.a();
        } catch (IOException iOException) {
          boolean bool;
          if (!(iOException instanceof com.bytedance.sdk.a.b.a.e.a)) {
            bool = true;
          } else {
            bool = false;
          } 
          if (a(iOException, bool, (y)stringBuilder))
            continue; 
          throw iOException;
        } finally {}
        this.c.a(null);
        this.c.c();
        throw stringBuilder;
      } 
      this.c.c();
      throw new IOException("Canceled");
    } 
  }
  
  public void a(Object paramObject) {
    this.d = paramObject;
  }
  
  public boolean a() {
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\c\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */