package com.ishumei.l111l11111Il.l111l11111lIl;

import java.math.BigInteger;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Set;

class l111l1111l1Il extends X509Certificate {
  private final X509Certificate l1111l111111Il;
  
  l111l1111l1Il(X509Certificate paramX509Certificate) {
    this.l1111l111111Il = paramX509Certificate;
  }
  
  public void checkValidity() {
    this.l1111l111111Il.checkValidity();
  }
  
  public void checkValidity(Date paramDate) {
    this.l1111l111111Il.checkValidity(paramDate);
  }
  
  public int getBasicConstraints() {
    return this.l1111l111111Il.getBasicConstraints();
  }
  
  public Set<String> getCriticalExtensionOIDs() {
    return this.l1111l111111Il.getCriticalExtensionOIDs();
  }
  
  public byte[] getEncoded() {
    return this.l1111l111111Il.getEncoded();
  }
  
  public byte[] getExtensionValue(String paramString) {
    return this.l1111l111111Il.getExtensionValue(paramString);
  }
  
  public Principal getIssuerDN() {
    return this.l1111l111111Il.getIssuerDN();
  }
  
  public boolean[] getIssuerUniqueID() {
    return this.l1111l111111Il.getIssuerUniqueID();
  }
  
  public boolean[] getKeyUsage() {
    return this.l1111l111111Il.getKeyUsage();
  }
  
  public Set<String> getNonCriticalExtensionOIDs() {
    return this.l1111l111111Il.getNonCriticalExtensionOIDs();
  }
  
  public Date getNotAfter() {
    return this.l1111l111111Il.getNotAfter();
  }
  
  public Date getNotBefore() {
    return this.l1111l111111Il.getNotBefore();
  }
  
  public PublicKey getPublicKey() {
    return this.l1111l111111Il.getPublicKey();
  }
  
  public BigInteger getSerialNumber() {
    return this.l1111l111111Il.getSerialNumber();
  }
  
  public String getSigAlgName() {
    return this.l1111l111111Il.getSigAlgName();
  }
  
  public String getSigAlgOID() {
    return this.l1111l111111Il.getSigAlgOID();
  }
  
  public byte[] getSigAlgParams() {
    return this.l1111l111111Il.getSigAlgParams();
  }
  
  public byte[] getSignature() {
    return this.l1111l111111Il.getSignature();
  }
  
  public Principal getSubjectDN() {
    return this.l1111l111111Il.getSubjectDN();
  }
  
  public boolean[] getSubjectUniqueID() {
    return this.l1111l111111Il.getSubjectUniqueID();
  }
  
  public byte[] getTBSCertificate() {
    return this.l1111l111111Il.getTBSCertificate();
  }
  
  public int getVersion() {
    return this.l1111l111111Il.getVersion();
  }
  
  public boolean hasUnsupportedCriticalExtension() {
    return this.l1111l111111Il.hasUnsupportedCriticalExtension();
  }
  
  public String toString() {
    return this.l1111l111111Il.toString();
  }
  
  public void verify(PublicKey paramPublicKey) {
    this.l1111l111111Il.verify(paramPublicKey);
  }
  
  public void verify(PublicKey paramPublicKey, String paramString) {
    this.l1111l111111Il.verify(paramPublicKey, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111Il\l111l11111lIl\l111l1111l1Il.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */