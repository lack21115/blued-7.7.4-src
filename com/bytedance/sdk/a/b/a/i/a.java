package com.bytedance.sdk.a.b.a.i;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class a extends c {
  private final f a;
  
  public a(f paramf) {
    this.a = paramf;
  }
  
  private boolean a(X509Certificate paramX509Certificate1, X509Certificate paramX509Certificate2) {
    if (!paramX509Certificate1.getIssuerDN().equals(paramX509Certificate2.getSubjectDN()))
      return false; 
    try {
      paramX509Certificate1.verify(paramX509Certificate2.getPublicKey());
      return true;
    } catch (GeneralSecurityException generalSecurityException) {
      return false;
    } 
  }
  
  public List<Certificate> a(List<Certificate> paramList, String paramString) throws SSLPeerUnverifiedException {
    StringBuilder stringBuilder1;
    ArrayDeque<Certificate> arrayDeque = new ArrayDeque<Certificate>(paramList);
    paramList = new ArrayList<Certificate>();
    paramList.add(arrayDeque.removeFirst());
    int i = 0;
    boolean bool = false;
    while (i < 9) {
      X509Certificate x509Certificate1 = (X509Certificate)paramList.get(paramList.size() - 1);
      X509Certificate x509Certificate2 = this.a.a(x509Certificate1);
      if (x509Certificate2 != null) {
        if (paramList.size() > 1 || !x509Certificate1.equals(x509Certificate2))
          paramList.add(x509Certificate2); 
        if (a(x509Certificate2, x509Certificate2))
          return paramList; 
        bool = true;
      } else {
        Iterator<Certificate> iterator = arrayDeque.iterator();
        while (iterator.hasNext()) {
          X509Certificate x509Certificate = (X509Certificate)iterator.next();
          if (a(x509Certificate1, x509Certificate)) {
            iterator.remove();
            paramList.add(x509Certificate);
            continue;
          } 
        } 
        if (bool)
          return paramList; 
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Failed to find a trusted cert that signed ");
        stringBuilder1.append(x509Certificate1);
        throw new SSLPeerUnverifiedException(stringBuilder1.toString());
      } 
      i++;
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("Certificate chain too long: ");
    stringBuilder2.append(stringBuilder1);
    throw new SSLPeerUnverifiedException(stringBuilder2.toString());
  }
  
  public boolean equals(Object paramObject) {
    return (paramObject == this) ? true : ((paramObject instanceof a && ((a)paramObject).a.equals(this.a)));
  }
  
  public int hashCode() {
    return this.a.hashCode();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\i\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */