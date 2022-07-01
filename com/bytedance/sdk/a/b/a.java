package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.a.c;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class a {
  final s a;
  
  final o b;
  
  final SocketFactory c;
  
  final b d;
  
  final List<w> e;
  
  final List<k> f;
  
  final ProxySelector g;
  
  final Proxy h;
  
  final SSLSocketFactory i;
  
  final HostnameVerifier j;
  
  final g k;
  
  public a(String paramString, int paramInt, o paramo, SocketFactory paramSocketFactory, SSLSocketFactory paramSSLSocketFactory, HostnameVerifier paramHostnameVerifier, g paramg, b paramb, Proxy paramProxy, List<w> paramList, List<k> paramList1, ProxySelector paramProxySelector) {
    String str;
    s.a a1 = new s.a();
    if (paramSSLSocketFactory != null) {
      str = "https";
    } else {
      str = "http";
    } 
    this.a = a1.a(str).d(paramString).a(paramInt).c();
    if (paramo != null) {
      this.b = paramo;
      if (paramSocketFactory != null) {
        this.c = paramSocketFactory;
        if (paramb != null) {
          this.d = paramb;
          if (paramList != null) {
            this.e = c.a(paramList);
            if (paramList1 != null) {
              this.f = c.a(paramList1);
              if (paramProxySelector != null) {
                this.g = paramProxySelector;
                this.h = paramProxy;
                this.i = paramSSLSocketFactory;
                this.j = paramHostnameVerifier;
                this.k = paramg;
                return;
              } 
              throw new NullPointerException("proxySelector == null");
            } 
            throw new NullPointerException("connectionSpecs == null");
          } 
          throw new NullPointerException("protocols == null");
        } 
        throw new NullPointerException("proxyAuthenticator == null");
      } 
      throw new NullPointerException("socketFactory == null");
    } 
    throw new NullPointerException("dns == null");
  }
  
  public s a() {
    return this.a;
  }
  
  boolean a(a parama) {
    return (this.b.equals(parama.b) && this.d.equals(parama.d) && this.e.equals(parama.e) && this.f.equals(parama.f) && this.g.equals(parama.g) && c.a(this.h, parama.h) && c.a(this.i, parama.i) && c.a(this.j, parama.j) && c.a(this.k, parama.k) && a().g() == parama.a().g());
  }
  
  public o b() {
    return this.b;
  }
  
  public SocketFactory c() {
    return this.c;
  }
  
  public b d() {
    return this.d;
  }
  
  public List<w> e() {
    return this.e;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject instanceof a) {
      s s1 = this.a;
      paramObject = paramObject;
      if (s1.equals(((a)paramObject).a) && a((a)paramObject))
        return true; 
    } 
    return false;
  }
  
  public List<k> f() {
    return this.f;
  }
  
  public ProxySelector g() {
    return this.g;
  }
  
  public Proxy h() {
    return this.h;
  }
  
  public int hashCode() {
    byte b1;
    byte b2;
    byte b3;
    int j = this.a.hashCode();
    int k = this.b.hashCode();
    int m = this.d.hashCode();
    int n = this.e.hashCode();
    int i1 = this.f.hashCode();
    int i2 = this.g.hashCode();
    Proxy proxy = this.h;
    int i = 0;
    if (proxy != null) {
      b1 = proxy.hashCode();
    } else {
      b1 = 0;
    } 
    SSLSocketFactory sSLSocketFactory = this.i;
    if (sSLSocketFactory != null) {
      b2 = sSLSocketFactory.hashCode();
    } else {
      b2 = 0;
    } 
    HostnameVerifier hostnameVerifier = this.j;
    if (hostnameVerifier != null) {
      b3 = hostnameVerifier.hashCode();
    } else {
      b3 = 0;
    } 
    g g1 = this.k;
    if (g1 != null)
      i = g1.hashCode(); 
    return (((((((((527 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + b1) * 31 + b2) * 31 + b3) * 31 + i;
  }
  
  public SSLSocketFactory i() {
    return this.i;
  }
  
  public HostnameVerifier j() {
    return this.j;
  }
  
  public g k() {
    return this.k;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Address{");
    stringBuilder.append(this.a.f());
    stringBuilder.append(":");
    stringBuilder.append(this.a.g());
    if (this.h != null) {
      stringBuilder.append(", proxy=");
      stringBuilder.append(this.h);
    } else {
      stringBuilder.append(", proxySelector=");
      stringBuilder.append(this.g);
    } 
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */