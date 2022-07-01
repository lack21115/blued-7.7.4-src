package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.a.c;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class k {
  public static final k a;
  
  public static final k b;
  
  public static final k c;
  
  private static final h[] h = new h[] { 
      h.aX, h.bb, h.aY, h.bc, h.bi, h.bh, h.ay, h.aI, h.az, h.aJ, 
      h.ag, h.ah, h.E, h.I, h.i };
  
  final boolean d;
  
  final boolean e;
  
  final String[] f;
  
  final String[] g;
  
  static {
    a = (new a(true)).a(h).a(new ad[] { ad.a, ad.b, ad.c, ad.d }).a(true).a();
    b = (new a(a)).a(new ad[] { ad.d }).a(true).a();
    c = (new a(false)).a();
  }
  
  k(a parama) {
    this.d = parama.a;
    this.f = parama.b;
    this.g = parama.c;
    this.e = parama.d;
  }
  
  private k b(SSLSocket paramSSLSocket, boolean paramBoolean) {
    String[] arrayOfString2;
    String[] arrayOfString3;
    if (this.f != null) {
      arrayOfString2 = c.a(h.a, paramSSLSocket.getEnabledCipherSuites(), this.f);
    } else {
      arrayOfString2 = paramSSLSocket.getEnabledCipherSuites();
    } 
    if (this.g != null) {
      arrayOfString3 = c.a(c.h, paramSSLSocket.getEnabledProtocols(), this.g);
    } else {
      arrayOfString3 = paramSSLSocket.getEnabledProtocols();
    } 
    String[] arrayOfString4 = paramSSLSocket.getSupportedCipherSuites();
    int i = c.a(h.a, arrayOfString4, "TLS_FALLBACK_SCSV");
    String[] arrayOfString1 = arrayOfString2;
    if (paramBoolean) {
      arrayOfString1 = arrayOfString2;
      if (i != -1)
        arrayOfString1 = c.a(arrayOfString2, arrayOfString4[i]); 
    } 
    return (new a(this)).a(arrayOfString1).b(arrayOfString3).a();
  }
  
  void a(SSLSocket paramSSLSocket, boolean paramBoolean) {
    k k1 = b(paramSSLSocket, paramBoolean);
    String[] arrayOfString2 = k1.g;
    if (arrayOfString2 != null)
      paramSSLSocket.setEnabledProtocols(arrayOfString2); 
    String[] arrayOfString1 = k1.f;
    if (arrayOfString1 != null)
      paramSSLSocket.setEnabledCipherSuites(arrayOfString1); 
  }
  
  public boolean a() {
    return this.d;
  }
  
  public boolean a(SSLSocket paramSSLSocket) {
    return !this.d ? false : ((this.g != null && !c.b(c.h, this.g, paramSSLSocket.getEnabledProtocols())) ? false : (!(this.f != null && !c.b(h.a, this.f, paramSSLSocket.getEnabledCipherSuites()))));
  }
  
  public List<h> b() {
    String[] arrayOfString = this.f;
    return (arrayOfString != null) ? h.a(arrayOfString) : null;
  }
  
  public List<ad> c() {
    String[] arrayOfString = this.g;
    return (arrayOfString != null) ? ad.a(arrayOfString) : null;
  }
  
  public boolean d() {
    return this.e;
  }
  
  public boolean equals(Object paramObject) {
    if (!(paramObject instanceof k))
      return false; 
    if (paramObject == this)
      return true; 
    paramObject = paramObject;
    boolean bool = this.d;
    if (bool != ((k)paramObject).d)
      return false; 
    if (bool) {
      if (!Arrays.equals((Object[])this.f, (Object[])((k)paramObject).f))
        return false; 
      if (!Arrays.equals((Object[])this.g, (Object[])((k)paramObject).g))
        return false; 
      if (this.e != ((k)paramObject).e)
        return false; 
    } 
    return true;
  }
  
  public int hashCode() {
    return this.d ? (((527 + Arrays.hashCode((Object[])this.f)) * 31 + Arrays.hashCode((Object[])this.g)) * 31 + (this.e ^ true)) : 17;
  }
  
  public String toString() {
    String str1;
    if (!this.d)
      return "ConnectionSpec()"; 
    String[] arrayOfString = this.f;
    String str2 = "[all enabled]";
    if (arrayOfString != null) {
      str1 = b().toString();
    } else {
      str1 = "[all enabled]";
    } 
    if (this.g != null)
      str2 = c().toString(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ConnectionSpec(cipherSuites=");
    stringBuilder.append(str1);
    stringBuilder.append(", tlsVersions=");
    stringBuilder.append(str2);
    stringBuilder.append(", supportsTlsExtensions=");
    stringBuilder.append(this.e);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  public static final class a {
    boolean a;
    
    String[] b;
    
    String[] c;
    
    boolean d;
    
    public a(k param1k) {
      this.a = param1k.d;
      this.b = param1k.f;
      this.c = param1k.g;
      this.d = param1k.e;
    }
    
    a(boolean param1Boolean) {
      this.a = param1Boolean;
    }
    
    public a a(boolean param1Boolean) {
      if (this.a) {
        this.d = param1Boolean;
        return this;
      } 
      throw new IllegalStateException("no TLS extensions for cleartext connections");
    }
    
    public a a(ad... param1VarArgs) {
      if (this.a) {
        String[] arrayOfString = new String[param1VarArgs.length];
        for (int i = 0; i < param1VarArgs.length; i++)
          arrayOfString[i] = (param1VarArgs[i]).f; 
        return b(arrayOfString);
      } 
      throw new IllegalStateException("no TLS versions for cleartext connections");
    }
    
    public a a(h... param1VarArgs) {
      if (this.a) {
        String[] arrayOfString = new String[param1VarArgs.length];
        for (int i = 0; i < param1VarArgs.length; i++)
          arrayOfString[i] = (param1VarArgs[i]).bj; 
        return a(arrayOfString);
      } 
      throw new IllegalStateException("no cipher suites for cleartext connections");
    }
    
    public a a(String... param1VarArgs) {
      if (this.a) {
        if (param1VarArgs.length != 0) {
          this.b = (String[])param1VarArgs.clone();
          return this;
        } 
        throw new IllegalArgumentException("At least one cipher suite is required");
      } 
      throw new IllegalStateException("no cipher suites for cleartext connections");
    }
    
    public k a() {
      return new k(this);
    }
    
    public a b(String... param1VarArgs) {
      if (this.a) {
        if (param1VarArgs.length != 0) {
          this.c = (String[])param1VarArgs.clone();
          return this;
        } 
        throw new IllegalArgumentException("At least one TLS version is required");
      } 
      throw new IllegalStateException("no TLS versions for cleartext connections");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */