package org.chromium.android_webview;

import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.util.Log;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import org.chromium.net.X509Util;

public class SslUtil {
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static SslCertificate getCertificateFromDerBytes(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null)
      return null; 
    try {
      return new SslCertificate(X509Util.createCertificateFromBytes(paramArrayOfbyte));
    } catch (CertificateException certificateException) {
      StringBuilder stringBuilder = new StringBuilder("Could not read certificate: ");
      stringBuilder.append(certificateException);
      Log.w("SslUtil", stringBuilder.toString());
    } catch (KeyStoreException keyStoreException) {
      StringBuilder stringBuilder = new StringBuilder("Could not read certificate: ");
      stringBuilder.append(keyStoreException);
      Log.w("SslUtil", stringBuilder.toString());
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      StringBuilder stringBuilder = new StringBuilder("Could not read certificate: ");
      stringBuilder.append(noSuchAlgorithmException);
      Log.w("SslUtil", stringBuilder.toString());
      return null;
    } 
    return null;
  }
  
  public static SslError sslErrorFromNetErrorCode(int paramInt, SslCertificate paramSslCertificate, String paramString) {
    assert false;
    throw new AssertionError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\SslUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */