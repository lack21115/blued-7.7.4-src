package com.cmic.sso.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.security.auth.x500.X500Principal;

public class e {
  static String a(Context paramContext, String paramString) {
    byte[] arrayOfByte = b(paramContext);
    return (arrayOfByte != null) ? a.a(arrayOfByte, paramString) : null;
  }
  
  private static void a(String paramString) {
    p.a("AES_KEY", paramString);
  }
  
  public static boolean a(Context paramContext) {
    /* monitor enter TypeReferenceDotClassExpression{ObjectType{com/cmic/sso/sdk/utils/e}} */
    try {
      KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
      keyStore.load(null);
      Certificate certificate = keyStore.getCertificate("CMCC_SDK");
      if (certificate != null) {
        /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/cmic/sso/sdk/utils/e}} */
        return true;
      } 
      int i = Build.VERSION.SDK_INT;
      if (i >= 23)
        try {
          KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
          keyPairGenerator.initialize((AlgorithmParameterSpec)(new KeyGenParameterSpec.Builder("CMCC_SDK", 3)).setDigests(new String[] { "SHA-256", "SHA-512" }).setEncryptionPaddings(new String[] { "PKCS1Padding" }).build());
          Thread.sleep(1000L);
          keyPairGenerator.generateKeyPair();
          /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/cmic/sso/sdk/utils/e}} */
          return true;
        } catch (Exception exception) {
          f.a("KeystoreUtil", exception.getMessage());
          /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/cmic/sso/sdk/utils/e}} */
          return false;
        }  
      Calendar calendar1 = Calendar.getInstance();
      Calendar calendar2 = Calendar.getInstance();
      calendar2.add(1, 30);
      try {
        if (Build.VERSION.SDK_INT >= 18) {
          KeyPairGeneratorSpec keyPairGeneratorSpec = (new KeyPairGeneratorSpec.Builder((Context)exception)).setAlias("CMCC_SDK").setSubject(new X500Principal("CN=CMCC_SDK")).setSerialNumber(BigInteger.TEN).setStartDate(calendar1.getTime()).setEndDate(calendar2.getTime()).build();
          KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
          keyPairGenerator.initialize((AlgorithmParameterSpec)keyPairGeneratorSpec);
          Thread.sleep(1000L);
          keyPairGenerator.generateKeyPair();
          /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/cmic/sso/sdk/utils/e}} */
          return true;
        } 
        /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/cmic/sso/sdk/utils/e}} */
        return false;
      } catch (Exception exception1) {
        f.a("KeystoreUtil", exception1.getMessage());
        /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/cmic/sso/sdk/utils/e}} */
        return false;
      } 
    } catch (Exception exception) {
      f.a("KeystoreUtil", exception.getMessage());
      /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/cmic/sso/sdk/utils/e}} */
      return false;
    } finally {}
    /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/cmic/sso/sdk/utils/e}} */
    throw paramContext;
  }
  
  private static byte[] a() {
    byte[] arrayOfByte = new byte[16];
    (new SecureRandom()).nextBytes(arrayOfByte);
    return arrayOfByte;
  }
  
  private static String b() {
    return p.b("AES_KEY", "");
  }
  
  static String b(Context paramContext, String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      byte[] arrayOfByte = b(paramContext);
      if (arrayOfByte != null)
        return a.b(arrayOfByte, paramString); 
    } 
    return null;
  }
  
  private static byte[] b(Context paramContext) {
    PublicKey publicKey = null;
    try {
      byte[] arrayOfByte;
      Cipher cipher;
      KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
      keyStore.load(null);
      boolean bool = TextUtils.isEmpty(b());
      if (bool) {
        if (!a(paramContext))
          return null; 
        arrayOfByte = a();
        publicKey = keyStore.getCertificate("CMCC_SDK").getPublicKey();
        cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, publicKey);
        a(Base64.encodeToString(cipher.doFinal(arrayOfByte), 0));
        return arrayOfByte;
      } 
      String str = b();
      PublicKey publicKey1 = publicKey;
      if (!TextUtils.isEmpty(str)) {
        arrayOfByte = Base64.decode(str, 0);
        PrivateKey privateKey = (PrivateKey)cipher.getKey("CMCC_SDK", null);
        if (privateKey == null)
          return null; 
        cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, privateKey);
        arrayOfByte = cipher.doFinal(arrayOfByte);
      } 
      return arrayOfByte;
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sd\\utils\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */