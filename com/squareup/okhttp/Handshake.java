package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class Handshake {
  private final String cipherSuite;
  
  private final List<Certificate> localCertificates;
  
  private final List<Certificate> peerCertificates;
  
  private Handshake(String paramString, List<Certificate> paramList1, List<Certificate> paramList2) {
    this.cipherSuite = paramString;
    this.peerCertificates = paramList1;
    this.localCertificates = paramList2;
  }
  
  public static Handshake get(String paramString, List<Certificate> paramList1, List<Certificate> paramList2) {
    if (paramString != null)
      return new Handshake(paramString, Util.immutableList(paramList1), Util.immutableList(paramList2)); 
    throw new IllegalArgumentException("cipherSuite == null");
  }
  
  public static Handshake get(SSLSession paramSSLSession) {
    String str = paramSSLSession.getCipherSuite();
    if (str != null) {
      List<?> list1;
      List<?> list2;
      try {
        Certificate[] arrayOfCertificate1 = paramSSLSession.getPeerCertificates();
      } catch (SSLPeerUnverifiedException sSLPeerUnverifiedException) {
        sSLPeerUnverifiedException = null;
      } 
      if (sSLPeerUnverifiedException != null) {
        list2 = Util.immutableList((Object[])sSLPeerUnverifiedException);
      } else {
        list2 = Collections.emptyList();
      } 
      Certificate[] arrayOfCertificate = paramSSLSession.getLocalCertificates();
      if (arrayOfCertificate != null) {
        list1 = Util.immutableList((Object[])arrayOfCertificate);
      } else {
        list1 = Collections.emptyList();
      } 
      return new Handshake(str, (List)list2, (List)list1);
    } 
    throw new IllegalStateException("cipherSuite == null");
  }
  
  public String cipherSuite() {
    return this.cipherSuite;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof Handshake;
    boolean bool1 = false;
    if (!bool)
      return false; 
    paramObject = paramObject;
    bool = bool1;
    if (this.cipherSuite.equals(((Handshake)paramObject).cipherSuite)) {
      bool = bool1;
      if (this.peerCertificates.equals(((Handshake)paramObject).peerCertificates)) {
        bool = bool1;
        if (this.localCertificates.equals(((Handshake)paramObject).localCertificates))
          bool = true; 
      } 
    } 
    return bool;
  }
  
  public int hashCode() {
    return ((527 + this.cipherSuite.hashCode()) * 31 + this.peerCertificates.hashCode()) * 31 + this.localCertificates.hashCode();
  }
  
  public List<Certificate> localCertificates() {
    return this.localCertificates;
  }
  
  public Principal localPrincipal() {
    return !this.localCertificates.isEmpty() ? ((X509Certificate)this.localCertificates.get(0)).getSubjectX500Principal() : null;
  }
  
  public List<Certificate> peerCertificates() {
    return this.peerCertificates;
  }
  
  public Principal peerPrincipal() {
    return !this.peerCertificates.isEmpty() ? ((X509Certificate)this.peerCertificates.get(0)).getSubjectX500Principal() : null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\Handshake.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */