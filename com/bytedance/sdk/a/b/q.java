package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.a.c;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class q {
  private final ad a;
  
  private final h b;
  
  private final List<Certificate> c;
  
  private final List<Certificate> d;
  
  private q(ad paramad, h paramh, List<Certificate> paramList1, List<Certificate> paramList2) {
    this.a = paramad;
    this.b = paramh;
    this.c = paramList1;
    this.d = paramList2;
  }
  
  public static q a(SSLSession paramSSLSession) {
    String str = paramSSLSession.getCipherSuite();
    if (str != null) {
      h h1 = h.a(str);
      str = paramSSLSession.getProtocol();
      if (str != null) {
        List<?> list1;
        List<?> list2;
        ad ad1 = ad.a(str);
        try {
          Certificate[] arrayOfCertificate1 = paramSSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException sSLPeerUnverifiedException) {
          sSLPeerUnverifiedException = null;
        } 
        if (sSLPeerUnverifiedException != null) {
          list2 = c.a((Object[])sSLPeerUnverifiedException);
        } else {
          list2 = Collections.emptyList();
        } 
        Certificate[] arrayOfCertificate = paramSSLSession.getLocalCertificates();
        if (arrayOfCertificate != null) {
          list1 = c.a((Object[])arrayOfCertificate);
        } else {
          list1 = Collections.emptyList();
        } 
        return new q(ad1, h1, (List)list2, (List)list1);
      } 
      throw new IllegalStateException("tlsVersion == null");
    } 
    throw new IllegalStateException("cipherSuite == null");
  }
  
  public h a() {
    return this.b;
  }
  
  public List<Certificate> b() {
    return this.c;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof q;
    boolean bool1 = false;
    if (!bool)
      return false; 
    paramObject = paramObject;
    bool = bool1;
    if (this.a.equals(((q)paramObject).a)) {
      bool = bool1;
      if (this.b.equals(((q)paramObject).b)) {
        bool = bool1;
        if (this.c.equals(((q)paramObject).c)) {
          bool = bool1;
          if (this.d.equals(((q)paramObject).d))
            bool = true; 
        } 
      } 
    } 
    return bool;
  }
  
  public int hashCode() {
    return (((527 + this.a.hashCode()) * 31 + this.b.hashCode()) * 31 + this.c.hashCode()) * 31 + this.d.hashCode();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */