package com.qq.e.comm.util;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class a {
  private PublicKey a;
  
  private final boolean b;
  
  private a() {
    boolean bool;
    try {
      this.a = b("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDKta2b5Vw5YkWHCAj4rJCwS227\r/35FZ29e4I6pS2B8zSq2RgBpXUuMg7oZF1Qt3x0iyg8PeyblyNeCRB6gIMehFThe\r1Y7m1FaQyaZp+CJYOTLM4/THKp9UndrEgJ/5a83vP1375YCV2lMvWARrNlBep4RN\rnESUJhQz58Gr/F39TwIDAQAB");
    } finally {
      Exception exception = null;
    } 
    this.b = bool;
  }
  
  public static a a() {
    return a.a;
  }
  
  private String a(String paramString) {
    if (this.a != null) {
      byte[] arrayOfByte = Base64.decode(paramString, 0);
      try {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        return (new String(cipher.doFinal(arrayOfByte), "UTF-8")).trim();
      } finally {
        arrayOfByte = null;
      } 
    } 
    return null;
  }
  
  private static PublicKey b(String paramString) throws Exception {
    try {
      byte[] arrayOfByte = Base64.decode(paramString, 0);
      return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(arrayOfByte));
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new Exception("无此算法");
    } catch (InvalidKeySpecException invalidKeySpecException) {
      throw new Exception("公钥非法");
    } catch (NullPointerException nullPointerException) {
      throw new Exception("公钥数据为空");
    } 
  }
  
  private boolean b(String paramString1, String paramString2) {
    if (StringUtil.isEmpty(paramString2))
      return false; 
    if (!this.b)
      return true; 
    paramString1 = a(paramString1);
    boolean bool = paramString2.equals(paramString1);
    StringBuilder stringBuilder = new StringBuilder("Verify Result");
    stringBuilder.append(bool);
    stringBuilder.append("src=");
    stringBuilder.append(paramString2);
    stringBuilder.append(" & target=");
    stringBuilder.append(paramString1);
    GDTLogger.d(stringBuilder.toString());
    return bool;
  }
  
  public final boolean a(String paramString1, String paramString2) {
    return b(paramString1, Md5Util.encode(paramString2));
  }
  
  static final class a {
    public static final a a = new a((byte)0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\com\\util\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */