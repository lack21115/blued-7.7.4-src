package com.squareup.okhttp.internal.tls;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public final class AndroidTrustRootIndex implements TrustRootIndex {
  private final Method findByIssuerAndSignatureMethod;
  
  private final X509TrustManager trustManager;
  
  public AndroidTrustRootIndex(X509TrustManager paramX509TrustManager, Method paramMethod) {
    this.findByIssuerAndSignatureMethod = paramMethod;
    this.trustManager = paramX509TrustManager;
  }
  
  public static TrustRootIndex get(X509TrustManager paramX509TrustManager) {
    try {
      Method method = paramX509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[] { X509Certificate.class });
      method.setAccessible(true);
      return new AndroidTrustRootIndex(paramX509TrustManager, method);
    } catch (NoSuchMethodException noSuchMethodException) {
      return null;
    } 
  }
  
  public X509Certificate findByIssuerAndSignature(X509Certificate paramX509Certificate) {
    try {
      return ((TrustAnchor)this.findByIssuerAndSignatureMethod.invoke(this.trustManager, new Object[] { paramX509Certificate })).getTrustedCert();
    } catch (IllegalAccessException illegalAccessException) {
      throw new AssertionError();
    } catch (InvocationTargetException invocationTargetException) {
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\internal\tls\AndroidTrustRootIndex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */