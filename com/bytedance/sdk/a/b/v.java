package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.a.a;
import com.bytedance.sdk.a.b.a.a.e;
import com.bytedance.sdk.a.b.a.b.c;
import com.bytedance.sdk.a.b.a.b.d;
import com.bytedance.sdk.a.b.a.b.g;
import com.bytedance.sdk.a.b.a.c;
import com.bytedance.sdk.a.b.a.i.c;
import com.bytedance.sdk.a.b.a.i.e;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class v implements Cloneable {
  static final List<w> a = c.a((Object[])new w[] { w.d, w.b });
  
  static final List<k> b = c.a((Object[])new k[] { k.a, k.c });
  
  final int A;
  
  final int B;
  
  final int C;
  
  final n c;
  
  final Proxy d;
  
  final List<w> e;
  
  final List<k> f;
  
  final List<t> g;
  
  final List<t> h;
  
  final p.a i;
  
  final ProxySelector j;
  
  final m k;
  
  final c l;
  
  final e m;
  
  final SocketFactory n;
  
  final SSLSocketFactory o;
  
  final c p;
  
  final HostnameVerifier q;
  
  final g r;
  
  final b s;
  
  final b t;
  
  final j u;
  
  final o v;
  
  final boolean w;
  
  final boolean x;
  
  final boolean y;
  
  final int z;
  
  static {
    a.a = new a() {
        public int a(aa.a param1a) {
          return param1a.c;
        }
        
        public c a(j param1j, a param1a, g param1g, ac param1ac) {
          return param1j.a(param1a, param1g, param1ac);
        }
        
        public d a(j param1j) {
          return param1j.a;
        }
        
        public Socket a(j param1j, a param1a, g param1g) {
          return param1j.a(param1a, param1g);
        }
        
        public void a(j param1j, c param1c) {
          param1j.a(param1c);
        }
        
        public void a(k param1k, SSLSocket param1SSLSocket, boolean param1Boolean) {
          param1k.a(param1SSLSocket, param1Boolean);
        }
        
        public void a(r.a param1a, String param1String) {
          param1a.a(param1String);
        }
        
        public void a(r.a param1a, String param1String1, String param1String2) {
          param1a.b(param1String1, param1String2);
        }
        
        public boolean a(a param1a1, a param1a2) {
          return param1a1.a(param1a2);
        }
        
        public boolean b(j param1j, c param1c) {
          return param1j.b(param1c);
        }
      };
  }
  
  public v() {
    this(new a());
  }
  
  v(a parama) {
    this.c = parama.a;
    this.d = parama.b;
    this.e = parama.c;
    this.f = parama.d;
    this.g = c.a(parama.e);
    this.h = c.a(parama.f);
    this.i = parama.g;
    this.j = parama.h;
    this.k = parama.i;
    this.l = parama.j;
    this.m = parama.k;
    this.n = parama.l;
    Iterator<k> iterator = this.f.iterator();
    label23: while (true) {
      boolean bool = false;
      while (iterator.hasNext()) {
        k k = iterator.next();
        if (bool || k.a()) {
          bool = true;
          continue;
        } 
        continue label23;
      } 
      if (parama.m != null || !bool) {
        this.o = parama.m;
        this.p = parama.n;
      } else {
        X509TrustManager x509TrustManager = z();
        this.o = a(x509TrustManager);
        this.p = c.a(x509TrustManager);
      } 
      this.q = parama.o;
      this.r = parama.p.a(this.p);
      this.s = parama.q;
      this.t = parama.r;
      this.u = parama.s;
      this.v = parama.t;
      this.w = parama.u;
      this.x = parama.v;
      this.y = parama.w;
      this.z = parama.x;
      this.A = parama.y;
      this.B = parama.z;
      this.C = parama.A;
      if (!this.g.contains(null)) {
        if (!this.h.contains(null))
          return; 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Null network interceptor: ");
        stringBuilder1.append(this.h);
        throw new IllegalStateException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Null interceptor: ");
      stringBuilder.append(this.g);
      throw new IllegalStateException(stringBuilder.toString());
    } 
  }
  
  private SSLSocketFactory a(X509TrustManager paramX509TrustManager) {
    try {
      SSLContext sSLContext = SSLContext.getInstance("TLS");
      sSLContext.init(null, new TrustManager[] { paramX509TrustManager }, null);
      return sSLContext.getSocketFactory();
    } catch (GeneralSecurityException generalSecurityException) {
      throw c.a("No System TLS", generalSecurityException);
    } 
  }
  
  private X509TrustManager z() {
    try {
      TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      trustManagerFactory.init((KeyStore)null);
      TrustManager[] arrayOfTrustManager = trustManagerFactory.getTrustManagers();
      if (arrayOfTrustManager.length == 1 && arrayOfTrustManager[0] instanceof X509TrustManager)
        return (X509TrustManager)arrayOfTrustManager[0]; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unexpected default trust managers:");
      stringBuilder.append(Arrays.toString((Object[])arrayOfTrustManager));
      throw new IllegalStateException(stringBuilder.toString());
    } catch (GeneralSecurityException generalSecurityException) {
      throw c.a("No System TLS", generalSecurityException);
    } 
  }
  
  public int a() {
    return this.z;
  }
  
  public e a(y paramy) {
    return x.a(this, paramy, false);
  }
  
  public int b() {
    return this.A;
  }
  
  public int c() {
    return this.B;
  }
  
  public Proxy d() {
    return this.d;
  }
  
  public ProxySelector e() {
    return this.j;
  }
  
  public m f() {
    return this.k;
  }
  
  e g() {
    c c1 = this.l;
    return (c1 != null) ? c1.a : this.m;
  }
  
  public o h() {
    return this.v;
  }
  
  public SocketFactory i() {
    return this.n;
  }
  
  public SSLSocketFactory j() {
    return this.o;
  }
  
  public HostnameVerifier k() {
    return this.q;
  }
  
  public g l() {
    return this.r;
  }
  
  public b m() {
    return this.t;
  }
  
  public b n() {
    return this.s;
  }
  
  public j o() {
    return this.u;
  }
  
  public boolean p() {
    return this.w;
  }
  
  public boolean q() {
    return this.x;
  }
  
  public boolean r() {
    return this.y;
  }
  
  public n s() {
    return this.c;
  }
  
  public List<w> t() {
    return this.e;
  }
  
  public List<k> u() {
    return this.f;
  }
  
  public List<t> v() {
    return this.g;
  }
  
  public List<t> w() {
    return this.h;
  }
  
  public p.a x() {
    return this.i;
  }
  
  public a y() {
    return new a(this);
  }
  
  public static final class a {
    int A;
    
    n a = new n();
    
    Proxy b;
    
    List<w> c;
    
    List<k> d;
    
    final List<t> e = new ArrayList<t>();
    
    final List<t> f = new ArrayList<t>();
    
    p.a g;
    
    ProxySelector h;
    
    m i;
    
    c j;
    
    e k;
    
    SocketFactory l;
    
    SSLSocketFactory m;
    
    c n;
    
    HostnameVerifier o;
    
    g p;
    
    b q;
    
    b r;
    
    j s;
    
    o t;
    
    boolean u;
    
    boolean v;
    
    boolean w;
    
    int x;
    
    int y;
    
    int z;
    
    public a() {
      this.c = v.a;
      this.d = v.b;
      this.g = p.a(p.a);
      this.h = ProxySelector.getDefault();
      this.i = m.a;
      this.l = SocketFactory.getDefault();
      this.o = (HostnameVerifier)e.a;
      this.p = g.a;
      this.q = b.a;
      this.r = b.a;
      this.s = new j();
      this.t = o.a;
      this.u = true;
      this.v = true;
      this.w = true;
      this.x = 10000;
      this.y = 10000;
      this.z = 10000;
      this.A = 0;
    }
    
    a(v param1v) {
      this.b = param1v.d;
      this.c = param1v.e;
      this.d = param1v.f;
      this.e.addAll(param1v.g);
      this.f.addAll(param1v.h);
      this.g = param1v.i;
      this.h = param1v.j;
      this.i = param1v.k;
      this.k = param1v.m;
      this.j = param1v.l;
      this.l = param1v.n;
      this.m = param1v.o;
      this.n = param1v.p;
      this.o = param1v.q;
      this.p = param1v.r;
      this.q = param1v.s;
      this.r = param1v.t;
      this.s = param1v.u;
      this.t = param1v.v;
      this.u = param1v.w;
      this.v = param1v.x;
      this.w = param1v.y;
      this.x = param1v.z;
      this.y = param1v.A;
      this.z = param1v.B;
      this.A = param1v.C;
    }
    
    public a a(long param1Long, TimeUnit param1TimeUnit) {
      this.x = c.a("timeout", param1Long, param1TimeUnit);
      return this;
    }
    
    public a a(HostnameVerifier param1HostnameVerifier) {
      if (param1HostnameVerifier != null) {
        this.o = param1HostnameVerifier;
        return this;
      } 
      throw new NullPointerException("hostnameVerifier == null");
    }
    
    public a a(SSLSocketFactory param1SSLSocketFactory, X509TrustManager param1X509TrustManager) {
      if (param1SSLSocketFactory != null) {
        if (param1X509TrustManager != null) {
          this.m = param1SSLSocketFactory;
          this.n = c.a(param1X509TrustManager);
          return this;
        } 
        throw new NullPointerException("trustManager == null");
      } 
      throw new NullPointerException("sslSocketFactory == null");
    }
    
    public a a(boolean param1Boolean) {
      this.u = param1Boolean;
      return this;
    }
    
    public v a() {
      return new v(this);
    }
    
    public a b(long param1Long, TimeUnit param1TimeUnit) {
      this.y = c.a("timeout", param1Long, param1TimeUnit);
      return this;
    }
    
    public a b(boolean param1Boolean) {
      this.v = param1Boolean;
      return this;
    }
    
    public a c(long param1Long, TimeUnit param1TimeUnit) {
      this.z = c.a("timeout", param1Long, param1TimeUnit);
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */