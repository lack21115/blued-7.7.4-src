package com.huawei.hianalytics.ab.bc.ab;

import com.huawei.hianalytics.ab.bc.ef.ab;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class bc {
  public static String ab(String paramString1, String paramString2) {
    try {
      return ab(paramString1, paramString2.getBytes("UTF-8"));
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      ab.cd("hmsSdk", "Unsupported encoding exception,utf-8");
      return "";
    } 
  }
  
  public static String ab(String paramString, byte[] paramArrayOfbyte) {
    String str;
    if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0) {
      ab.fg("hmsSdk", "encrypt: content is empty or null");
      return "";
    } 
    try {
      return HexUtil.a(ab(paramArrayOfbyte, ab(HexUtil.a(paramString))));
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      str = "encrypt(): getInstance - No such algorithm,transformation";
    } catch (InvalidKeySpecException invalidKeySpecException) {
      str = "encrypt(): Invalid key specification";
    } 
    ab.fg("hmsSdk", str);
    return "";
  }
  
  private static PublicKey ab(byte[] paramArrayOfbyte) {
    X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(paramArrayOfbyte);
    return KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec);
  }
  
  private static byte[] ab(byte[] paramArrayOfbyte, PublicKey paramPublicKey) {
    String str;
    if (paramPublicKey != null) {
      try {
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING");
        cipher.init(1, paramPublicKey);
        return cipher.doFinal(paramArrayOfbyte);
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        str = "rsaEncrypt(): getBytes - Unsupported coding format!";
      } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
        str = "rsaEncrypt(): getInstance - No such algorithm,transformation";
      } catch (InvalidKeyException invalidKeyException) {
        str = "rsaEncrypt(): init - Invalid key!";
      } catch (NoSuchPaddingException noSuchPaddingException) {
        str = "rsaEncrypt():  No such filling parameters ";
      } catch (BadPaddingException badPaddingException) {
        str = "rsaEncrypt():False filling parameters!";
      } catch (IllegalBlockSizeException illegalBlockSizeException) {
        str = "rsaEncrypt(): doFinal - The provided block is not filled with";
      } 
    } else {
      throw new UnsupportedEncodingException("The loaded public key is null");
    } 
    ab.fg("hmsSdk", str);
    return new byte[0];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\ab\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */