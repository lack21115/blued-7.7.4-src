package com.tencent.tbs.sdk.extension.partner.c;

import android.annotation.SuppressLint;
import android.util.Base64;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public class f {
  protected static final char[] a;
  
  private static String b = "";
  
  private static byte[] c;
  
  private static f f;
  
  private static String g;
  
  private Cipher d = null;
  
  private Cipher e = null;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  @SuppressLint({"NewApi"})
  private f() {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(String.valueOf((new Random()).nextInt(89999999) + 10000000));
    stringBuilder1.append(String.valueOf((new Random()).nextInt(89999999) + 10000000));
    stringBuilder1.append(String.valueOf((new Random()).nextInt(89999999) + 10000000));
    g = stringBuilder1.toString();
    String str = "00000000";
    for (int i = 0; i < 12; i++) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append(String.valueOf((new Random()).nextInt(89999999) + 10000000));
      str = stringBuilder.toString();
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str);
    stringBuilder2.append(g);
    c = stringBuilder2.toString().getBytes();
    this.d = Cipher.getInstance("RSA/ECB/NoPadding");
    X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDcEQ3TCNWPBqgIiY7WQ/IqTOTTV2w8aZ/GPm68FK0fAJBemZKtYR3Li46VJ+Hwnor7ZpQnblGWPFaLv5JoPqvavgB0GInuhm+T+syPs1mw0uPLWaqwvZsCfoaIvUuxy5xHJgmWARrK4/9pHyDxRlZte0PCIoR1ko5B8lVVH1X1dQIDAQAB".getBytes(), 0));
    PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec);
    this.d.init(1, publicKey);
    b = b(this.d.doFinal(c));
    DESedeKeySpec dESedeKeySpec = new DESedeKeySpec(g.getBytes());
    SecretKey secretKey = SecretKeyFactory.getInstance("DESede").generateSecret(dESedeKeySpec);
    this.e = Cipher.getInstance("DESede/ECB/PKCS5Padding");
    this.e.init(1, secretKey);
  }
  
  public static f a() {
    try {
      if (f == null)
        f = new f(); 
      return f;
    } catch (Exception exception) {
      f = null;
      exception.printStackTrace();
      return null;
    } 
  }
  
  public static String b(byte[] paramArrayOfbyte) {
    char[] arrayOfChar = new char[paramArrayOfbyte.length * 2];
    for (int i = 0; i < paramArrayOfbyte.length; i++) {
      int j = paramArrayOfbyte[i] & 0xFF;
      int k = i * 2;
      char[] arrayOfChar1 = a;
      arrayOfChar[k] = arrayOfChar1[j >>> 4];
      arrayOfChar[k + 1] = arrayOfChar1[j & 0xF];
    } 
    return new String(arrayOfChar);
  }
  
  public byte[] a(byte[] paramArrayOfbyte) {
    return this.e.doFinal(paramArrayOfbyte);
  }
  
  public String b() {
    return b;
  }
  
  public byte[] c(byte[] paramArrayOfbyte) {
    byte[] arrayOfByte = g.getBytes();
    try {
      SecretKey secretKey = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(arrayOfByte));
      Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
      cipher.init(2, secretKey);
      return cipher.doFinal(paramArrayOfbyte);
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\partner\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */