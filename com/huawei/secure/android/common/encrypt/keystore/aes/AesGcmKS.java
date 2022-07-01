package com.huawei.secure.android.common.encrypt.keystore.aes;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

public class AesGcmKS {
  private static final String a = AesGcmKS.class.getSimpleName();
  
  public static String a(String paramString1, String paramString2) {
    if (TextUtils.isEmpty(paramString1) || TextUtils.isEmpty(paramString2)) {
      b.c(a, "alias or encrypt content is null");
      return "";
    } 
    try {
      return HexUtil.a(a(paramString1, paramString2.getBytes("UTF-8")));
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      paramString2 = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("encrypt: UnsupportedEncodingException : ");
      stringBuilder.append(unsupportedEncodingException.getMessage());
      b.c(paramString2, stringBuilder.toString());
      return "";
    } 
  }
  
  private static SecretKey a(String paramString) {
    /* monitor enter TypeReferenceDotClassExpression{ObjectType{com/huawei/secure/android/common/encrypt/keystore/aes/AesGcmKS}} */
    KeyStoreException keyStoreException = null;
    try {
      SecretKey secretKey;
      KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
      keyStore.load(null);
      Key key = keyStore.getKey(paramString, null);
      if (key != null && key instanceof SecretKey) {
        secretKey = (SecretKey)key;
      } else {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
        keyGenerator.init((AlgorithmParameterSpec)(new KeyGenParameterSpec.Builder((String)secretKey, 3)).setBlockModes(new String[] { "GCM" }).setEncryptionPaddings(new String[] { "NoPadding" }).setKeySize(256).build());
        secretKey = keyGenerator.generateKey();
      } 
    } catch (KeyStoreException keyStoreException1) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("KeyStoreException : ");
      stringBuilder.append(keyStoreException1.getMessage());
      b.c(str, stringBuilder.toString());
      keyStoreException1 = keyStoreException;
    } catch (IOException iOException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("IOException : ");
      stringBuilder.append(iOException.getMessage());
      b.c(str, stringBuilder.toString());
      KeyStoreException keyStoreException1 = keyStoreException;
    } catch (CertificateException certificateException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("CertificateException : ");
      stringBuilder.append(certificateException.getMessage());
      b.c(str, stringBuilder.toString());
      KeyStoreException keyStoreException1 = keyStoreException;
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("NoSuchAlgorithmException : ");
      stringBuilder.append(noSuchAlgorithmException.getMessage());
      b.c(str, stringBuilder.toString());
      KeyStoreException keyStoreException1 = keyStoreException;
    } catch (UnrecoverableKeyException unrecoverableKeyException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("UnrecoverableKeyException : ");
      stringBuilder.append(unrecoverableKeyException.getMessage());
      b.c(str, stringBuilder.toString());
      KeyStoreException keyStoreException1 = keyStoreException;
    } catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("InvalidAlgorithmParameterException : ");
      stringBuilder.append(invalidAlgorithmParameterException.getMessage());
      b.c(str, stringBuilder.toString());
      KeyStoreException keyStoreException1 = keyStoreException;
    } catch (NoSuchProviderException noSuchProviderException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("NoSuchProviderException : ");
      stringBuilder.append(noSuchProviderException.getMessage());
      b.c(str, stringBuilder.toString());
      KeyStoreException keyStoreException1 = keyStoreException;
    } catch (Exception exception) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Exception: ");
      stringBuilder.append(exception.getMessage());
      b.c(str, stringBuilder.toString());
      exception = keyStoreException;
    } finally {}
    /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/huawei/secure/android/common/encrypt/keystore/aes/AesGcmKS}} */
    return (SecretKey)paramString;
  }
  
  private static boolean a() {
    return (Build.VERSION.SDK_INT >= 23);
  }
  
  public static byte[] a(String paramString, byte[] paramArrayOfbyte) {
    byte[] arrayOfByte1 = new byte[0];
    if (TextUtils.isEmpty(paramString) || paramArrayOfbyte == null) {
      b.c(a, "alias or encrypt content is null");
      return arrayOfByte1;
    } 
    if (!a()) {
      b.c(a, "sdk version is too low");
      return arrayOfByte1;
    } 
    byte[] arrayOfByte2 = arrayOfByte1;
    byte[] arrayOfByte3 = arrayOfByte1;
    byte[] arrayOfByte4 = arrayOfByte1;
    byte[] arrayOfByte5 = arrayOfByte1;
    byte[] arrayOfByte6 = arrayOfByte1;
    byte[] arrayOfByte7 = arrayOfByte1;
    try {
      Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
      arrayOfByte2 = arrayOfByte1;
      arrayOfByte3 = arrayOfByte1;
      arrayOfByte4 = arrayOfByte1;
      arrayOfByte5 = arrayOfByte1;
      arrayOfByte6 = arrayOfByte1;
      arrayOfByte7 = arrayOfByte1;
      SecretKey secretKey = a(paramString);
      if (secretKey == null) {
        arrayOfByte2 = arrayOfByte1;
        arrayOfByte3 = arrayOfByte1;
        arrayOfByte4 = arrayOfByte1;
        arrayOfByte5 = arrayOfByte1;
        arrayOfByte6 = arrayOfByte1;
        arrayOfByte7 = arrayOfByte1;
        b.c(a, "Encrypt secret key is null");
        return arrayOfByte1;
      } 
      arrayOfByte2 = arrayOfByte1;
      arrayOfByte3 = arrayOfByte1;
      arrayOfByte4 = arrayOfByte1;
      arrayOfByte5 = arrayOfByte1;
      arrayOfByte6 = arrayOfByte1;
      arrayOfByte7 = arrayOfByte1;
      cipher.init(1, secretKey);
      arrayOfByte2 = arrayOfByte1;
      arrayOfByte3 = arrayOfByte1;
      arrayOfByte4 = arrayOfByte1;
      arrayOfByte5 = arrayOfByte1;
      arrayOfByte6 = arrayOfByte1;
      arrayOfByte7 = arrayOfByte1;
      paramArrayOfbyte = cipher.doFinal(paramArrayOfbyte);
      arrayOfByte2 = arrayOfByte1;
      arrayOfByte3 = arrayOfByte1;
      arrayOfByte4 = arrayOfByte1;
      arrayOfByte5 = arrayOfByte1;
      arrayOfByte6 = arrayOfByte1;
      arrayOfByte7 = arrayOfByte1;
      byte[] arrayOfByte = cipher.getIV();
      if (arrayOfByte != null) {
        arrayOfByte2 = arrayOfByte1;
        arrayOfByte3 = arrayOfByte1;
        arrayOfByte4 = arrayOfByte1;
        arrayOfByte5 = arrayOfByte1;
        arrayOfByte6 = arrayOfByte1;
        arrayOfByte7 = arrayOfByte1;
        if (arrayOfByte.length == 12) {
          arrayOfByte2 = arrayOfByte1;
          arrayOfByte3 = arrayOfByte1;
          arrayOfByte4 = arrayOfByte1;
          arrayOfByte5 = arrayOfByte1;
          arrayOfByte6 = arrayOfByte1;
          arrayOfByte7 = arrayOfByte1;
          byte[] arrayOfByte8 = Arrays.copyOf(arrayOfByte, arrayOfByte.length + paramArrayOfbyte.length);
          arrayOfByte2 = arrayOfByte8;
          arrayOfByte3 = arrayOfByte8;
          arrayOfByte4 = arrayOfByte8;
          arrayOfByte5 = arrayOfByte8;
          arrayOfByte6 = arrayOfByte8;
          arrayOfByte7 = arrayOfByte8;
          System.arraycopy(paramArrayOfbyte, 0, arrayOfByte8, arrayOfByte.length, paramArrayOfbyte.length);
          return arrayOfByte8;
        } 
      } 
      arrayOfByte2 = arrayOfByte1;
      arrayOfByte3 = arrayOfByte1;
      arrayOfByte4 = arrayOfByte1;
      arrayOfByte5 = arrayOfByte1;
      arrayOfByte6 = arrayOfByte1;
      arrayOfByte7 = arrayOfByte1;
      b.c(a, "IV is invalid.");
      return arrayOfByte1;
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("NoSuchAlgorithmException : ");
      stringBuilder.append(noSuchAlgorithmException.getMessage());
      b.c(str, stringBuilder.toString());
      return arrayOfByte7;
    } catch (NoSuchPaddingException noSuchPaddingException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("NoSuchPaddingException : ");
      stringBuilder.append(noSuchPaddingException.getMessage());
      b.c(str, stringBuilder.toString());
      return arrayOfByte6;
    } catch (BadPaddingException badPaddingException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("BadPaddingException : ");
      stringBuilder.append(badPaddingException.getMessage());
      b.c(str, stringBuilder.toString());
      return arrayOfByte5;
    } catch (IllegalBlockSizeException illegalBlockSizeException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("IllegalBlockSizeException : ");
      stringBuilder.append(illegalBlockSizeException.getMessage());
      b.c(str, stringBuilder.toString());
      return arrayOfByte4;
    } catch (InvalidKeyException invalidKeyException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("InvalidKeyException : ");
      stringBuilder.append(invalidKeyException.getMessage());
      b.c(str, stringBuilder.toString());
      return arrayOfByte3;
    } catch (Exception exception) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Exception: ");
      stringBuilder.append(exception.getMessage());
      b.c(str, stringBuilder.toString());
      return arrayOfByte2;
    } 
  }
  
  public static String b(String paramString1, String paramString2) {
    if (TextUtils.isEmpty(paramString1) || TextUtils.isEmpty(paramString2)) {
      b.c(a, "alias or encrypt content is null");
      return "";
    } 
    try {
      return new String(b(paramString1, HexUtil.a(paramString2)), "UTF-8");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      paramString2 = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("decrypt: UnsupportedEncodingException : ");
      stringBuilder.append(unsupportedEncodingException.getMessage());
      b.c(paramString2, stringBuilder.toString());
      return "";
    } 
  }
  
  public static byte[] b(String paramString, byte[] paramArrayOfbyte) {
    byte[] arrayOfByte1 = new byte[0];
    if (TextUtils.isEmpty(paramString) || paramArrayOfbyte == null) {
      b.c(a, "alias or encrypt content is null");
      return arrayOfByte1;
    } 
    if (!a()) {
      b.c(a, "sdk version is too low");
      return arrayOfByte1;
    } 
    if (paramArrayOfbyte.length <= 12) {
      b.c(a, "Decrypt source data is invalid.");
      return arrayOfByte1;
    } 
    SecretKey secretKey = a(paramString);
    if (secretKey == null) {
      b.c(a, "Decrypt secret key is null");
      return arrayOfByte1;
    } 
    byte[] arrayOfByte2 = Arrays.copyOf(paramArrayOfbyte, 12);
    try {
      Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
      cipher.init(2, secretKey, new GCMParameterSpec(128, arrayOfByte2));
      return cipher.doFinal(paramArrayOfbyte, 12, paramArrayOfbyte.length - 12);
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("NoSuchAlgorithmException : ");
      stringBuilder.append(noSuchAlgorithmException.getMessage());
      b.c(str, stringBuilder.toString());
      return arrayOfByte1;
    } catch (NoSuchPaddingException noSuchPaddingException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("NoSuchPaddingException : ");
      stringBuilder.append(noSuchPaddingException.getMessage());
      b.c(str, stringBuilder.toString());
      return arrayOfByte1;
    } catch (InvalidKeyException invalidKeyException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("InvalidKeyException : ");
      stringBuilder.append(invalidKeyException.getMessage());
      b.c(str, stringBuilder.toString());
      return arrayOfByte1;
    } catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("InvalidAlgorithmParameterException : ");
      stringBuilder.append(invalidAlgorithmParameterException.getMessage());
      b.c(str, stringBuilder.toString());
      return arrayOfByte1;
    } catch (IllegalBlockSizeException illegalBlockSizeException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("IllegalBlockSizeException : ");
      stringBuilder.append(illegalBlockSizeException.getMessage());
      b.c(str, stringBuilder.toString());
      return arrayOfByte1;
    } catch (BadPaddingException badPaddingException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("BadPaddingException : ");
      stringBuilder.append(badPaddingException.getMessage());
      b.c(str, stringBuilder.toString());
      return arrayOfByte1;
    } catch (Exception exception) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Exception: ");
      stringBuilder.append(exception.getMessage());
      b.c(str, stringBuilder.toString());
      return arrayOfByte1;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\common\encrypt\keystore\aes\AesGcmKS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */