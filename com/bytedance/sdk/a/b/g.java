package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.a.f;
import com.bytedance.sdk.a.b.a.c;
import com.bytedance.sdk.a.b.a.i.c;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class g {
  public static final g a = (new a()).a();
  
  private final Set<b> b;
  
  private final c c;
  
  g(Set<b> paramSet, c paramc) {
    this.b = paramSet;
    this.c = paramc;
  }
  
  static f a(X509Certificate paramX509Certificate) {
    return f.a(paramX509Certificate.getPublicKey().getEncoded()).c();
  }
  
  public static String a(Certificate paramCertificate) {
    if (paramCertificate instanceof X509Certificate) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("sha256/");
      stringBuilder.append(b((X509Certificate)paramCertificate).b());
      return stringBuilder.toString();
    } 
    throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
  }
  
  static f b(X509Certificate paramX509Certificate) {
    return f.a(paramX509Certificate.getPublicKey().getEncoded()).d();
  }
  
  g a(c paramc) {
    return c.a(this.c, paramc) ? this : new g(this.b, paramc);
  }
  
  List<b> a(String paramString) {
    List<?> list = Collections.emptyList();
    for (b b : this.b) {
      if (b.a(paramString)) {
        List<?> list1 = list;
        if (list.isEmpty())
          list1 = new ArrayList(); 
        list1.add(b);
        list = list1;
      } 
    } 
    return (List)list;
  }
  
  public void a(String paramString, List<Certificate> paramList) throws SSLPeerUnverifiedException {
    StringBuilder stringBuilder1;
    List<b> list1 = a(paramString);
    if (list1.isEmpty())
      return; 
    c c1 = this.c;
    List<Certificate> list = paramList;
    if (c1 != null)
      list = c1.a(paramList, paramString); 
    int k = list.size();
    boolean bool = false;
    int i;
    for (i = 0; i < k; i++) {
      X509Certificate x509Certificate = (X509Certificate)list.get(i);
      int n = list1.size();
      c1 = null;
      c c2 = c1;
      for (int m = 0; m < n; m++) {
        b b = list1.get(m);
        if (b.c.equals("sha256/")) {
          f f2;
          c c3 = c1;
          if (c1 == null)
            f2 = b(x509Certificate); 
          f f1 = f2;
          if (b.d.equals(f2))
            return; 
        } else if (b.c.equals("sha1/")) {
          f f2;
          c c3 = c2;
          if (c2 == null)
            f2 = a(x509Certificate); 
          f f1 = f2;
          if (b.d.equals(f2))
            return; 
        } else {
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("unsupported hashAlgorithm: ");
          stringBuilder1.append(b.c);
          throw new AssertionError(stringBuilder1.toString());
        } 
      } 
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("Certificate pinning failure!");
    stringBuilder2.append("\n  Peer certificate chain:");
    int j = list.size();
    for (i = 0; i < j; i++) {
      X509Certificate x509Certificate = (X509Certificate)list.get(i);
      stringBuilder2.append("\n    ");
      stringBuilder2.append(a(x509Certificate));
      stringBuilder2.append(": ");
      stringBuilder2.append(x509Certificate.getSubjectDN().getName());
    } 
    stringBuilder2.append("\n  Pinned certificates for ");
    stringBuilder2.append((String)stringBuilder1);
    stringBuilder2.append(":");
    j = list1.size();
    for (i = bool; i < j; i++) {
      b b = list1.get(i);
      stringBuilder2.append("\n    ");
      stringBuilder2.append(b);
    } 
    throw new SSLPeerUnverifiedException(stringBuilder2.toString());
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject instanceof g) {
      c c1 = this.c;
      paramObject = paramObject;
      if (c.a(c1, ((g)paramObject).c) && this.b.equals(((g)paramObject).b))
        return true; 
    } 
    return false;
  }
  
  public int hashCode() {
    byte b;
    c c1 = this.c;
    if (c1 != null) {
      b = c1.hashCode();
    } else {
      b = 0;
    } 
    return b * 31 + this.b.hashCode();
  }
  
  public static final class a {
    private final List<g.b> a = new ArrayList<g.b>();
    
    public g a() {
      return new g(new LinkedHashSet<g.b>(this.a), null);
    }
  }
  
  static final class b {
    final String a;
    
    final String b;
    
    final String c;
    
    final f d;
    
    boolean a(String param1String) {
      if (this.a.startsWith("*.")) {
        int i = param1String.indexOf('.');
        if (param1String.length() - i - 1 == this.b.length()) {
          String str = this.b;
          if (param1String.regionMatches(false, i + 1, str, 0, str.length()))
            return true; 
        } 
        return false;
      } 
      return param1String.equals(this.b);
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object instanceof b) {
        String str = this.a;
        param1Object = param1Object;
        if (str.equals(((b)param1Object).a) && this.c.equals(((b)param1Object).c) && this.d.equals(((b)param1Object).d))
          return true; 
      } 
      return false;
    }
    
    public int hashCode() {
      return ((527 + this.a.hashCode()) * 31 + this.c.hashCode()) * 31 + this.d.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.c);
      stringBuilder.append(this.d.b());
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */