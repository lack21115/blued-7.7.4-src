package com.bytedance.sdk.openadsdk.utils;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.SignatureException;
import javax.security.cert.Certificate;
import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;

public class aj {
  public static boolean a(Certificate[] paramArrayOfCertificate) {
    if (paramArrayOfCertificate != null) {
      int j = paramArrayOfCertificate.length;
      for (int i = 0; i < j; i += arrayOfX509Certificate.length) {
        X509Certificate[] arrayOfX509Certificate = a(paramArrayOfCertificate, i);
        if (!a(arrayOfX509Certificate))
          return false; 
      } 
    } 
    return true;
  }
  
  private static boolean a(X509Certificate[] paramArrayOfX509Certificate) {
    int j = paramArrayOfX509Certificate.length;
    int i = 0;
    while (i < j - 1) {
      X509Certificate x509Certificate1 = paramArrayOfX509Certificate[i];
      X509Certificate x509Certificate2 = paramArrayOfX509Certificate[++i];
      try {
        x509Certificate1.verify(x509Certificate2.getPublicKey());
        continue;
      } catch (CertificateException certificateException) {
        continue;
      } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
        continue;
      } catch (InvalidKeyException invalidKeyException) {
        continue;
      } catch (NoSuchProviderException noSuchProviderException) {
      
      } catch (SignatureException signatureException) {
        continue;
      } 
      signatureException.printStackTrace();
      return false;
    } 
    return true;
  }
  
  private static X509Certificate[] a(Certificate[] paramArrayOfCertificate, int paramInt) {
    int i;
    for (i = paramInt; i < paramArrayOfCertificate.length - 1; i = k) {
      Principal principal = ((X509Certificate)paramArrayOfCertificate[i]).getIssuerDN();
      int k = i + 1;
      if (!principal.equals(((X509Certificate)paramArrayOfCertificate[k]).getSubjectDN()))
        break; 
    } 
    int j = i - paramInt + 1;
    X509Certificate[] arrayOfX509Certificate = new X509Certificate[j];
    for (i = 0; i < j; i++)
      arrayOfX509Certificate[i] = (X509Certificate)paramArrayOfCertificate[paramInt + i]; 
    return arrayOfX509Certificate;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsd\\utils\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */