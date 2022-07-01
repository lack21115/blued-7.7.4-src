package com.squareup.okhttp.internal.tls;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class CertificateChainCleaner {
  private final TrustRootIndex trustRootIndex;
  
  public CertificateChainCleaner(TrustRootIndex paramTrustRootIndex) {
    this.trustRootIndex = paramTrustRootIndex;
  }
  
  private boolean verifySignature(X509Certificate paramX509Certificate1, X509Certificate paramX509Certificate2) {
    try {
      paramX509Certificate1.verify(paramX509Certificate2.getPublicKey());
      return true;
    } catch (GeneralSecurityException generalSecurityException) {
      return false;
    } 
  }
  
  public List<Certificate> clean(List<Certificate> paramList) throws SSLPeerUnverifiedException {
    ArrayDeque<Certificate> arrayDeque = new ArrayDeque<Certificate>(paramList);
    ArrayList<X509Certificate> arrayList = new ArrayList();
    arrayList.add(arrayDeque.removeFirst());
    while (true) {
      X509Certificate x509Certificate1 = arrayList.get(arrayList.size() - 1);
      X509Certificate x509Certificate2 = this.trustRootIndex.findByIssuerAndSignature(x509Certificate1);
      if (x509Certificate2 != null) {
        if (arrayList.size() > 1 || !x509Certificate1.equals(x509Certificate2))
          arrayList.add(x509Certificate2); 
        return (List)arrayList;
      } 
      Iterator<Certificate> iterator = arrayDeque.iterator();
      while (iterator.hasNext()) {
        X509Certificate x509Certificate = (X509Certificate)iterator.next();
        if (x509Certificate1.getIssuerDN().equals(x509Certificate.getSubjectDN()) && verifySignature(x509Certificate1, x509Certificate)) {
          iterator.remove();
          arrayList.add(x509Certificate);
        } 
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failed to find a cert that signed ");
      stringBuilder.append(x509Certificate1);
      throw new SSLPeerUnverifiedException(stringBuilder.toString());
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\internal\tls\CertificateChainCleaner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */