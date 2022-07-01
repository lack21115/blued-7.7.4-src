package cn.com.chinatelecom.account.api.a;

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

public class b {
  private static String a = "RSA/ECB/PKCS1Padding";
  
  public static String a(String paramString, RSAPublicKey paramRSAPublicKey) {
    try {
      return c.a(a(paramRSAPublicKey, paramString.getBytes()));
    } catch (Exception exception) {
      exception.printStackTrace();
      return "";
    } 
  }
  
  public static PublicKey a(String paramString) {
    X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(a.a(paramString));
    return KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec);
  }
  
  public static byte[] a(RSAPublicKey paramRSAPublicKey, byte[] paramArrayOfbyte) {
    if (paramRSAPublicKey != null)
      try {
        Cipher cipher = Cipher.getInstance(a);
        cipher.init(1, paramRSAPublicKey);
        return cipher.doFinal(paramArrayOfbyte);
      } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
        throw new Exception(d.a(new byte[] { 
                -20, -99, -86, -20, -89, -82, -17, Byte.MIN_VALUE, -86, -17, 
                -91, -116, -19, -92, -99, -20, -71, -97 }));
      } catch (NoSuchPaddingException noSuchPaddingException) {
        noSuchPaddingException.printStackTrace();
        return null;
      } catch (InvalidKeyException invalidKeyException) {
        throw new Exception(d.a(new byte[] { 
                -17, Byte.MIN_VALUE, -86, -17, -91, -116, -17, -113, -90, -29, 
                -104, -81, -29, -105, -108, -20, -71, -97, 38, -30, 
                -91, -67, -20, -87, -118, -20, -107, -81 }));
      } catch (IllegalBlockSizeException illegalBlockSizeException) {
        throw new Exception(d.a(new byte[] { 
                -20, -110, -124, -20, -100, -115, -29, -97, -75, -17, 
                -80, -84, -29, -105, -108, -20, -71, -97 }));
      } catch (BadPaddingException badPaddingException) {
        throw new Exception(d.a(new byte[] { 
                -20, -110, -124, -20, -100, -115, -20, -97, -70, -20, 
                -121, -92, -17, -67, -72, -20, -121, -107, -17, -105, 
                -123 }));
      }  
    throw new Exception(d.a(new byte[] { 
            -17, Byte.MIN_VALUE, -86, -17, -91, -116, -17, -113, -90, -29, 
            -104, -81, -18, -78, -80, -19, -93, -80, 38, 42, 
            -30, -91, -67, -30, -92, -76, -19, -73, -92 }));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\com\chinatelecom\account\api\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */