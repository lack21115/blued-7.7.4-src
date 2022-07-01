package com.geetest.onelogin.e.a;

import android.util.Base64;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class h {
  public static String a(String paramString, RSAPublicKey paramRSAPublicKey) throws Exception {
    return i.a(a(paramRSAPublicKey, paramString.getBytes()));
  }
  
  public static PublicKey a(String paramString) throws Exception {
    X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decode(paramString, 0));
    return KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec);
  }
  
  private static byte[] a(RSAPublicKey paramRSAPublicKey, byte[] paramArrayOfbyte) throws Exception {
    if (paramRSAPublicKey != null)
      try {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, paramRSAPublicKey);
        return cipher.doFinal(paramArrayOfbyte);
      } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
        throw new Exception("无此加密算法");
      } catch (NoSuchPaddingException noSuchPaddingException) {
        noSuchPaddingException.printStackTrace();
        return null;
      } catch (InvalidKeyException invalidKeyException) {
        throw new Exception("加密公钥非法,请检查");
      } catch (IllegalBlockSizeException illegalBlockSizeException) {
        throw new Exception("明文长度非法");
      } catch (BadPaddingException badPaddingException) {
        throw new Exception("明文数据已损坏");
      }  
    throw new Exception("加密公钥为空, 请设置");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\e\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */