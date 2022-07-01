package com.huawei.secure.android.common.encrypt.aes;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AesCbc {
  private static final String a = AesCbc.class.getSimpleName();
  
  private static String a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return ""; 
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString.substring(6, 12));
      stringBuilder.append(paramString.substring(16, 26));
      stringBuilder.append(paramString.substring(32, 48));
      return stringBuilder.toString();
    } catch (Exception exception) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getIv exception : ");
      stringBuilder.append(exception.getMessage());
      b.c(str, stringBuilder.toString());
      return "";
    } 
  }
  
  public static String a(String paramString1, String paramString2) {
    if (TextUtils.isEmpty(paramString1) || TextUtils.isEmpty(paramString2)) {
      b.c(a, "cbc encrypt param is not right");
      return "";
    } 
    byte[] arrayOfByte = HexUtil.a(paramString2);
    if (arrayOfByte.length < 16) {
      b.c(a, "key length is not right");
      return "";
    } 
    return a(paramString1, arrayOfByte);
  }
  
  public static String a(String paramString, byte[] paramArrayOfbyte) {
    if (TextUtils.isEmpty(paramString) || paramArrayOfbyte == null || paramArrayOfbyte.length < 16) {
      b.c(a, "cbc encrypt param is not right");
      return "";
    } 
    byte[] arrayOfByte2 = EncryptUtil.a(16);
    byte[] arrayOfByte1 = b(paramString, paramArrayOfbyte, arrayOfByte2);
    return (arrayOfByte1 != null) ? ((arrayOfByte1.length == 0) ? "" : c(HexUtil.a(arrayOfByte2), HexUtil.a(arrayOfByte1))) : "";
  }
  
  public static String a(String paramString, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    if (TextUtils.isEmpty(paramString) || paramArrayOfbyte1 == null || paramArrayOfbyte1.length < 16 || paramArrayOfbyte2 == null || paramArrayOfbyte2.length < 16) {
      b.c(a, "cbc decrypt param is not right");
      return "";
    } 
    try {
      return new String(b(HexUtil.a(paramString), paramArrayOfbyte1, paramArrayOfbyte2), "UTF-8");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(" cbc decrypt data error");
      stringBuilder.append(unsupportedEncodingException.getMessage());
      b.c(str, stringBuilder.toString());
      return "";
    } 
  }
  
  public static byte[] a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    byte[] arrayOfByte = EncryptUtil.a(16);
    return b(arrayOfByte, a(paramArrayOfbyte1, paramArrayOfbyte2, arrayOfByte));
  }
  
  public static byte[] a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, byte[] paramArrayOfbyte3) {
    if (paramArrayOfbyte1 == null || paramArrayOfbyte1.length == 0 || paramArrayOfbyte2 == null || paramArrayOfbyte2.length < 16 || paramArrayOfbyte3 == null || paramArrayOfbyte3.length < 16) {
      b.c(a, "cbc encrypt param is not right");
      return new byte[0];
    } 
    SecretKeySpec secretKeySpec = new SecretKeySpec(paramArrayOfbyte2, "AES");
    try {
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      cipher.init(1, secretKeySpec, new IvParameterSpec(paramArrayOfbyte3));
      return cipher.doFinal(paramArrayOfbyte1);
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("NoSuchAlgorithmException: ");
      stringBuilder.append(noSuchAlgorithmException.getMessage());
      b.c(str, stringBuilder.toString());
    } catch (NoSuchPaddingException noSuchPaddingException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("NoSuchPaddingException: ");
      stringBuilder.append(noSuchPaddingException.getMessage());
      b.c(str, stringBuilder.toString());
    } catch (InvalidKeyException invalidKeyException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("InvalidKeyException: ");
      stringBuilder.append(invalidKeyException.getMessage());
      b.c(str, stringBuilder.toString());
    } catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("InvalidAlgorithmParameterException: ");
      stringBuilder.append(invalidAlgorithmParameterException.getMessage());
      b.c(str, stringBuilder.toString());
    } catch (IllegalBlockSizeException illegalBlockSizeException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("IllegalBlockSizeException: ");
      stringBuilder.append(illegalBlockSizeException.getMessage());
      b.c(str, stringBuilder.toString());
    } catch (BadPaddingException badPaddingException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("BadPaddingException: ");
      stringBuilder.append(badPaddingException.getMessage());
      b.c(str, stringBuilder.toString());
    } 
    return new byte[0];
  }
  
  private static String b(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return ""; 
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString.substring(0, 6));
      stringBuilder.append(paramString.substring(12, 16));
      stringBuilder.append(paramString.substring(26, 32));
      stringBuilder.append(paramString.substring(48));
      return stringBuilder.toString();
    } catch (Exception exception) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("get encryptword exception : ");
      stringBuilder.append(exception.getMessage());
      b.c(str, stringBuilder.toString());
      return "";
    } 
  }
  
  public static String b(String paramString1, String paramString2) {
    if (TextUtils.isEmpty(paramString1) || TextUtils.isEmpty(paramString2)) {
      b.c(a, "content or key is null");
      return "";
    } 
    byte[] arrayOfByte = HexUtil.a(paramString2);
    if (arrayOfByte.length < 16) {
      b.c(a, "key length is not right");
      return "";
    } 
    return b(paramString1, arrayOfByte);
  }
  
  public static String b(String paramString, byte[] paramArrayOfbyte) {
    if (!TextUtils.isEmpty(paramString) && paramArrayOfbyte != null) {
      if (paramArrayOfbyte.length < 16)
        return ""; 
      String str = a(paramString);
      paramString = b(paramString);
      if (TextUtils.isEmpty(str) || TextUtils.isEmpty(paramString)) {
        b.c(a, "ivParameter or encrypedWord is null");
        return "";
      } 
      return a(paramString, paramArrayOfbyte, HexUtil.a(str));
    } 
    return "";
  }
  
  private static byte[] b(String paramString, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    if (TextUtils.isEmpty(paramString)) {
      b.c(a, "cbc encrypt param is not right");
      return new byte[0];
    } 
    try {
      return a(paramString.getBytes("UTF-8"), paramArrayOfbyte1, paramArrayOfbyte2);
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(" cbc encrypt data error");
      stringBuilder.append(unsupportedEncodingException.getMessage());
      b.c(str, stringBuilder.toString());
      return new byte[0];
    } 
  }
  
  private static byte[] b(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    byte[] arrayOfByte = new byte[paramArrayOfbyte1.length + paramArrayOfbyte2.length];
    System.arraycopy(paramArrayOfbyte1, 0, arrayOfByte, 0, paramArrayOfbyte1.length);
    System.arraycopy(paramArrayOfbyte2, 0, arrayOfByte, paramArrayOfbyte1.length, paramArrayOfbyte2.length);
    return arrayOfByte;
  }
  
  public static byte[] b(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, byte[] paramArrayOfbyte3) {
    if (paramArrayOfbyte1 == null || paramArrayOfbyte1.length == 0 || paramArrayOfbyte2 == null || paramArrayOfbyte2.length < 16 || paramArrayOfbyte3 == null || paramArrayOfbyte3.length < 16) {
      b.c(a, "cbc decrypt param is not right");
      return new byte[0];
    } 
    SecretKeySpec secretKeySpec = new SecretKeySpec(paramArrayOfbyte2, "AES");
    try {
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      cipher.init(2, secretKeySpec, new IvParameterSpec(paramArrayOfbyte3));
      return cipher.doFinal(paramArrayOfbyte1);
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("NoSuchAlgorithmException: ");
      stringBuilder.append(noSuchAlgorithmException.getMessage());
      b.c(str, stringBuilder.toString());
    } catch (NoSuchPaddingException noSuchPaddingException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("NoSuchPaddingException: ");
      stringBuilder.append(noSuchPaddingException.getMessage());
      b.c(str, stringBuilder.toString());
    } catch (InvalidKeyException invalidKeyException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("InvalidKeyException: ");
      stringBuilder.append(invalidKeyException.getMessage());
      b.c(str, stringBuilder.toString());
    } catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("InvalidAlgorithmParameterException: ");
      stringBuilder.append(invalidAlgorithmParameterException.getMessage());
      b.c(str, stringBuilder.toString());
    } catch (IllegalBlockSizeException illegalBlockSizeException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("IllegalBlockSizeException: ");
      stringBuilder.append(illegalBlockSizeException.getMessage());
      b.c(str, stringBuilder.toString());
    } catch (BadPaddingException badPaddingException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("BadPaddingException: ");
      stringBuilder.append(badPaddingException.getMessage());
      b.c(str, stringBuilder.toString());
    } 
    return new byte[0];
  }
  
  private static String c(String paramString1, String paramString2) {
    if (!TextUtils.isEmpty(paramString1)) {
      if (TextUtils.isEmpty(paramString2))
        return ""; 
      try {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramString2.substring(0, 6));
        stringBuilder.append(paramString1.substring(0, 6));
        stringBuilder.append(paramString2.substring(6, 10));
        stringBuilder.append(paramString1.substring(6, 16));
        stringBuilder.append(paramString2.substring(10, 16));
        stringBuilder.append(paramString1.substring(16));
        stringBuilder.append(paramString2.substring(16));
        return stringBuilder.toString();
      } catch (Exception exception) {
        paramString2 = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mix exception: ");
        stringBuilder.append(exception.getMessage());
        b.c(paramString2, stringBuilder.toString());
      } 
    } 
    return "";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\common\encrypt\aes\AesCbc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */