package com.bytedance.sdk.a.b.a.i;

import com.bytedance.sdk.a.b.a.g.e;
import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

public abstract class c {
  public static c a(X509TrustManager paramX509TrustManager) {
    return e.b().a(paramX509TrustManager);
  }
  
  public abstract List<Certificate> a(List<Certificate> paramList, String paramString) throws SSLPeerUnverifiedException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\i\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */