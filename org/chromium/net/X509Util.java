package org.chromium.net;

import android.os.Build;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

public class X509Util {
  private static final char[] HEX_DIGITS;
  
  private static CertificateFactory sCertificateFactory;
  
  private static X509Util$X509TrustManagerImplementation sDefaultTrustManager;
  
  private static boolean sDisableNativeCodeForTest;
  
  private static boolean sLoadedSystemKeyStore;
  
  private static final Object sLock;
  
  private static File sSystemCertificateDirectory;
  
  private static KeyStore sSystemKeyStore;
  
  private static Set sSystemTrustAnchorCache;
  
  private static KeyStore sTestKeyStore;
  
  private static X509Util$X509TrustManagerImplementation sTestTrustManager;
  
  private static X509Util$TrustStorageListener sTrustStorageListener;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static void addTestRootCertificate(byte[] paramArrayOfbyte) {
    ensureInitialized();
    null = createCertificateFromBytes(paramArrayOfbyte);
    synchronized (sLock) {
      KeyStore keyStore = sTestKeyStore;
      StringBuilder stringBuilder = new StringBuilder("root_cert_");
      stringBuilder.append(Integer.toString(sTestKeyStore.size()));
      keyStore.setCertificateEntry(stringBuilder.toString(), null);
      reloadTestTrustManager();
      return;
    } 
  }
  
  public static void clearTestRootCertificates() {
    ensureInitialized();
    Object object = sLock;
    /* monitor enter ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
    try {
      sTestKeyStore.load(null);
      reloadTestTrustManager();
    } catch (IOException iOException) {
    
    } finally {
      Exception exception;
    } 
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
  }
  
  public static X509Certificate createCertificateFromBytes(byte[] paramArrayOfbyte) {
    ensureInitialized();
    return (X509Certificate)sCertificateFactory.generateCertificate(new ByteArrayInputStream(paramArrayOfbyte));
  }
  
  private static X509Util$X509TrustManagerImplementation createTrustManager(KeyStore paramKeyStore) {
    TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    trustManagerFactory.init(paramKeyStore);
    for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
      if (trustManager instanceof X509TrustManager)
        try {
          return (X509Util$X509TrustManagerImplementation)((Build.VERSION.SDK_INT >= 17) ? new X509Util$X509TrustManagerJellyBean((X509TrustManager)trustManager) : new X509Util$X509TrustManagerIceCreamSandwich((X509TrustManager)trustManager));
        } catch (IllegalArgumentException illegalArgumentException) {
          String str = trustManager.getClass().getName();
          StringBuilder stringBuilder = new StringBuilder("Error creating trust manager (");
          stringBuilder.append(str);
          stringBuilder.append("): ");
          stringBuilder.append(illegalArgumentException);
          Log.e("X509Util", stringBuilder.toString());
        }  
    } 
    Log.e("X509Util", "Could not find suitable trust manager");
    return null;
  }
  
  private static void ensureInitialized() {
    synchronized (sLock) {
      ensureInitializedLocked();
      return;
    } 
  }
  
  private static void ensureInitializedLocked() {
    assert false;
    throw new AssertionError();
  }
  
  private static String hashPrincipal(X500Principal paramX500Principal) {
    byte[] arrayOfByte = MessageDigest.getInstance("MD5").digest(paramX500Principal.getEncoded());
    char[] arrayOfChar = new char[8];
    for (int i = 0; i < 4; i++) {
      int j = i * 2;
      char[] arrayOfChar1 = HEX_DIGITS;
      int k = 3 - i;
      arrayOfChar[j] = arrayOfChar1[arrayOfByte[k] >> 4 & 0xF];
      arrayOfChar[j + 1] = HEX_DIGITS[arrayOfByte[k] & 0xF];
    } 
    return new String(arrayOfChar);
  }
  
  private static boolean isKnownRoot(X509Certificate paramX509Certificate) {
    assert false;
    throw new AssertionError();
  }
  
  private static native void nativeNotifyKeyChainChanged();
  
  private static void reloadTestTrustManager() {
    assert false;
    throw new AssertionError();
  }
  
  private static boolean verifyKeyUsage(X509Certificate paramX509Certificate) {
    try {
      List<String> list = paramX509Certificate.getExtendedKeyUsage();
      if (list == null)
        return true; 
      for (String str : list) {
        if (!str.equals("1.3.6.1.5.5.7.3.1") && !str.equals("2.5.29.37.0") && !str.equals("2.16.840.1.113730.4.1")) {
          if (str.equals("1.3.6.1.4.1.311.10.3.3"))
            return true; 
          continue;
        } 
        return true;
      } 
      return false;
    } catch (NullPointerException nullPointerException) {
      return false;
    } 
  }
  
  public static AndroidCertVerifyResult verifyServerCertificates(byte[][] paramArrayOfbyte, String paramString1, String paramString2) {
    if (paramArrayOfbyte != null && paramArrayOfbyte.length != 0 && paramArrayOfbyte[0] != null)
      try {
        ensureInitialized();
        ArrayList<X509Certificate> arrayList = new ArrayList();
        try {
          arrayList.add(createCertificateFromBytes(paramArrayOfbyte[0]));
          for (int i = 1; i < paramArrayOfbyte.length; i++) {
            try {
              arrayList.add(createCertificateFromBytes(paramArrayOfbyte[i]));
            } catch (CertificateException certificateException1) {
              StringBuilder stringBuilder1 = new StringBuilder("intermediate ");
              stringBuilder1.append(i);
              stringBuilder1.append(" failed parsing");
              Log.w("X509Util", stringBuilder1.toString());
            } 
          } 
          X509Certificate[] arrayOfX509Certificate = arrayList.<X509Certificate>toArray(new X509Certificate[arrayList.size()]);
          try {
            arrayOfX509Certificate[0].checkValidity();
            if (!verifyKeyUsage(arrayOfX509Certificate[0]))
              return new AndroidCertVerifyResult(-6); 
            synchronized (sLock) {
              AndroidCertVerifyResult androidCertVerifyResult;
              if (sDefaultTrustManager == null) {
                androidCertVerifyResult = new AndroidCertVerifyResult(-1);
                return androidCertVerifyResult;
              } 
              try {
                List list = sDefaultTrustManager.checkServerTrusted(arrayOfX509Certificate, paramString1, paramString2);
              } catch (CertificateException certificateException1) {
                try {
                  List<X509Certificate> list = sTestTrustManager.checkServerTrusted(arrayOfX509Certificate, paramString1, paramString2);
                  if (list.size() > 0) {
                    boolean bool = isKnownRoot(list.get(list.size() - 1));
                    androidCertVerifyResult = new AndroidCertVerifyResult(0, bool, list);
                    return androidCertVerifyResult;
                  } 
                } catch (CertificateException certificateException2) {
                  StringBuilder stringBuilder1 = new StringBuilder("Failed to validate the certificate chain, error: ");
                  stringBuilder1.append(certificateException1.getMessage());
                  Log.i("X509Util", stringBuilder1.toString());
                  androidCertVerifyResult = new AndroidCertVerifyResult(-2);
                  return androidCertVerifyResult;
                } 
              } 
              if (androidCertVerifyResult.size() > 0) {
                boolean bool = isKnownRoot(androidCertVerifyResult.get(androidCertVerifyResult.size() - 1));
                androidCertVerifyResult = new AndroidCertVerifyResult(0, bool, (List)androidCertVerifyResult);
                return androidCertVerifyResult;
              } 
            } 
          } catch (CertificateExpiredException null) {
            return new AndroidCertVerifyResult(-3);
          } catch (CertificateNotYetValidException null) {
            return new AndroidCertVerifyResult(-4);
          } catch (CertificateException null) {
            return new AndroidCertVerifyResult(-1);
          } 
        } catch (CertificateException null) {
          return new AndroidCertVerifyResult(-5);
        } 
      } catch (CertificateException certificateException) {
        return new AndroidCertVerifyResult(-1);
      }  
    StringBuilder stringBuilder = new StringBuilder("Expected non-null and non-empty certificate chain passed as |certChain|. |certChain|=");
    stringBuilder.append(Arrays.deepToString((Object[])certificateException));
    throw new IllegalArgumentException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\X509Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */