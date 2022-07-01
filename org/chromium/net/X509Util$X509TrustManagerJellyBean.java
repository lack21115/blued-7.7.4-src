package org.chromium.net;

import android.annotation.SuppressLint;
import android.net.http.X509TrustManagerExtensions;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.X509TrustManager;

final class X509Util$X509TrustManagerJellyBean implements X509Util$X509TrustManagerImplementation {
  private final X509TrustManagerExtensions mTrustManagerExtensions;
  
  @SuppressLint({"NewApi"})
  public X509Util$X509TrustManagerJellyBean(X509TrustManager paramX509TrustManager) {
    this.mTrustManagerExtensions = new X509TrustManagerExtensions(paramX509TrustManager);
  }
  
  @SuppressLint({"NewApi"})
  public final List checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString1, String paramString2) {
    return this.mTrustManagerExtensions.checkServerTrusted(paramArrayOfX509Certificate, paramString1, paramString2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\X509Util$X509TrustManagerJellyBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */