package com.huawei.hms.framework.network.grs.d.b;

import android.content.Context;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLSocketFactory;

public class a {
  public static SSLSocketFactory a(Context paramContext) {
    try {
      return c.a(paramContext, "grs_sp.bks");
    } catch (IOException iOException) {
      throw new AssertionError(iOException);
    } catch (CertificateException certificateException) {
      throw new AssertionError(certificateException);
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new AssertionError(noSuchAlgorithmException);
    } catch (IllegalAccessException illegalAccessException) {
      throw new AssertionError(illegalAccessException);
    } catch (KeyStoreException keyStoreException) {
      throw new AssertionError(keyStoreException);
    } catch (KeyManagementException keyManagementException) {
      throw new AssertionError(keyManagementException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\d\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */