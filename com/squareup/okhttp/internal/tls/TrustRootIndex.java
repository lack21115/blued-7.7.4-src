package com.squareup.okhttp.internal.tls;

import java.security.cert.X509Certificate;

public interface TrustRootIndex {
  X509Certificate findByIssuerAndSignature(X509Certificate paramX509Certificate);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\internal\tls\TrustRootIndex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */