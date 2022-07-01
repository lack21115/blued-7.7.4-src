package com.huawei.secure.android.common.ssl.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Date;

public class b {
  public static boolean a(X509Certificate paramX509Certificate1, X509Certificate paramX509Certificate2) {
    PublicKey publicKey = paramX509Certificate1.getPublicKey();
    try {
      paramX509Certificate2.verify(publicKey);
      if (!a(new X509Certificate[] { paramX509Certificate1, paramX509Certificate2 })) {
        g.d("CertificateChainVerify", "verify: date not right");
        return false;
      } 
      return true;
    } catch (CertificateException certificateException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("verify: publickey CertificateException ");
      stringBuilder.append(certificateException.getMessage());
      g.d("CertificateChainVerify", stringBuilder.toString());
      return false;
    } catch (InvalidKeyException invalidKeyException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("verify: publickey InvalidKeyException ");
      stringBuilder.append(invalidKeyException.getMessage());
      g.d("CertificateChainVerify", stringBuilder.toString());
      return false;
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("verify: publickey NoSuchAlgorithmException ");
      stringBuilder.append(noSuchAlgorithmException.getMessage());
      g.d("CertificateChainVerify", stringBuilder.toString());
      return false;
    } catch (NoSuchProviderException noSuchProviderException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("verify: publickey NoSuchProviderException ");
      stringBuilder.append(noSuchProviderException.getMessage());
      g.d("CertificateChainVerify", stringBuilder.toString());
      return false;
    } catch (SignatureException signatureException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("verify: publickey SignatureException ");
      stringBuilder.append(signatureException.getMessage());
      g.d("CertificateChainVerify", stringBuilder.toString());
      return false;
    } 
  }
  
  public static boolean a(X509Certificate paramX509Certificate, X509Certificate[] paramArrayOfX509Certificate) throws NoSuchProviderException, CertificateException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
    PublicKey publicKey = null;
    int i = 0;
    while (i < paramArrayOfX509Certificate.length) {
      X509Certificate x509Certificate = paramArrayOfX509Certificate[i];
      Principal principal3 = x509Certificate.getIssuerDN();
      Principal principal2 = x509Certificate.getSubjectDN();
      if (publicKey != null)
        if (principal3.equals(publicKey)) {
          publicKey = paramArrayOfX509Certificate[i - 1].getPublicKey();
          paramArrayOfX509Certificate[i].verify(publicKey);
        } else {
          g.d("CertificateChainVerify", "verify: principalIssuer not match");
          return false;
        }  
      i++;
      Principal principal1 = principal2;
    } 
    return !a(paramX509Certificate, paramArrayOfX509Certificate[0]) ? false : (!!a(paramArrayOfX509Certificate));
  }
  
  public static boolean a(X509Certificate[] paramArrayOfX509Certificate) {
    Date date = new Date();
    int j = paramArrayOfX509Certificate.length;
    int i = 0;
    while (i < j) {
      X509Certificate x509Certificate = paramArrayOfX509Certificate[i];
      try {
        x509Certificate.checkValidity(date);
        i++;
      } catch (CertificateExpiredException certificateExpiredException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("verifyCertificateDate: exception : ");
        stringBuilder.append(certificateExpiredException.getMessage());
        g.d("CertificateChainVerify", stringBuilder.toString());
        return false;
      } catch (CertificateNotYetValidException certificateNotYetValidException) {
        continue;
      } 
    } 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\common\ss\\util\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */