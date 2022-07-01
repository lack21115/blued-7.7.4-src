package com.cmic.sso.sdk.b.c;

import android.os.Bundle;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

public class a {
  private static String d = "";
  
  private X509Certificate a;
  
  private SSLContext b;
  
  private Bundle c;
  
  public a(Bundle paramBundle) {
    this.c = paramBundle;
    b();
    try {
      KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
      keyStore.load(null, null);
      keyStore.setCertificateEntry("cert", this.a);
      TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      trustManagerFactory.init(keyStore);
      this.b = SSLContext.getInstance("SSL");
      this.b.init(null, trustManagerFactory.getTrustManagers(), null);
      return;
    } catch (KeyStoreException keyStoreException) {
    
    } catch (KeyManagementException keyManagementException) {
    
    } catch (IOException iOException) {
    
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
    
    } catch (CertificateException certificateException) {}
    paramBundle.putBoolean("isNeedToGetCert", true);
    certificateException.printStackTrace();
  }
  
  public static void a(String paramString) {
    d = paramString;
  }
  
  private void b() {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Ljava/security/cert/X509Certificate;
    //   4: ifnonnull -> 117
    //   7: new java/io/ByteArrayInputStream
    //   10: dup
    //   11: getstatic com/cmic/sso/sdk/b/c/a.d : Ljava/lang/String;
    //   14: invokevirtual getBytes : ()[B
    //   17: iconst_0
    //   18: invokestatic decode : ([BI)[B
    //   21: invokespecial <init> : ([B)V
    //   24: astore_2
    //   25: aload_2
    //   26: astore_1
    //   27: aload_0
    //   28: ldc 'X.509'
    //   30: invokestatic getInstance : (Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   33: aload_2
    //   34: invokevirtual generateCertificate : (Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   37: checkcast java/security/cert/X509Certificate
    //   40: putfield a : Ljava/security/cert/X509Certificate;
    //   43: aload_2
    //   44: invokevirtual close : ()V
    //   47: return
    //   48: astore_3
    //   49: goto -> 61
    //   52: astore_1
    //   53: aconst_null
    //   54: astore_2
    //   55: goto -> 99
    //   58: astore_3
    //   59: aconst_null
    //   60: astore_2
    //   61: aload_2
    //   62: astore_1
    //   63: aload_0
    //   64: getfield c : Landroid/os/Bundle;
    //   67: ldc 'isNeedToGetCert'
    //   69: iconst_1
    //   70: invokevirtual putBoolean : (Ljava/lang/String;Z)V
    //   73: aload_2
    //   74: astore_1
    //   75: aload_3
    //   76: invokevirtual printStackTrace : ()V
    //   79: aload_2
    //   80: ifnull -> 117
    //   83: aload_2
    //   84: invokevirtual close : ()V
    //   87: return
    //   88: astore_1
    //   89: aload_1
    //   90: invokevirtual printStackTrace : ()V
    //   93: return
    //   94: astore_3
    //   95: aload_1
    //   96: astore_2
    //   97: aload_3
    //   98: astore_1
    //   99: aload_2
    //   100: ifnull -> 115
    //   103: aload_2
    //   104: invokevirtual close : ()V
    //   107: goto -> 115
    //   110: astore_2
    //   111: aload_2
    //   112: invokevirtual printStackTrace : ()V
    //   115: aload_1
    //   116: athrow
    //   117: return
    // Exception table:
    //   from	to	target	type
    //   7	25	58	java/lang/Exception
    //   7	25	52	finally
    //   27	43	48	java/lang/Exception
    //   27	43	94	finally
    //   43	47	88	java/io/IOException
    //   63	73	94	finally
    //   75	79	94	finally
    //   83	87	88	java/io/IOException
    //   103	107	110	java/io/IOException
  }
  
  public SSLContext a() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sdk\b\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */