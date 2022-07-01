package com.qq.e.comm.plugin.util;

import android.util.Base64;
import com.qq.e.comm.util.GDTLogger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
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

public class ao {
  public static String a(String paramString) {
    byte[] arrayOfByte2 = paramString.getBytes();
    byte[] arrayOfByte1 = new byte[0];
    try {
      arrayOfByte2 = a(arrayOfByte2, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAw41hNBphwAvvOJ5Ruzq1\rEYxmKXMh2cRtxu9RsZKcELezpJhjYB1IfqhE9rBJFL2gxk7cb9GrzuaeukXAL5uA\r3tYEbZ8q3oRE2faRmlsCByktcfT68ngsTk2arqBewBwcbgcjAPt/onySpsf9wKUg\rEhrWoeR92BPNCaVEWpBDqKcIgGDr/W4lpU8hmY9DYrv0BM8qpFYYDnr+AcrgREb4\rvPq+B06GUwTLVh/NAA4Afb7R1dDpxuXT2CMfX/2vPgWW+GiqAl8b1Q2CjGWL6PU/\rmcjJUwSycdsoRr+hVjIOMImNpDd8mON6zPsEccJMC/+srcRTjZn78zNtDeMtYiOt\rDwIDAQAB");
      arrayOfByte1 = arrayOfByte2;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Rsa encrypt encounter error: ");
      stringBuilder.append(exception.getMessage());
      GDTLogger.d(stringBuilder.toString());
    } 
    return Base64.encodeToString(arrayOfByte1, 2);
  }
  
  private static byte[] a(byte[] paramArrayOfbyte, String paramString) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, IOException {
    X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decode(paramString, 0));
    PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec);
    Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    cipher.init(1, publicKey);
    int k = paramArrayOfbyte.length;
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    int i = 0;
    int j = 0;
    while (true) {
      int m = k - i;
      if (m > 0) {
        byte[] arrayOfByte;
        if (m > 245) {
          arrayOfByte = cipher.doFinal(paramArrayOfbyte, i, 245);
        } else {
          arrayOfByte = cipher.doFinal(paramArrayOfbyte, i, m);
        } 
        byteArrayOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
        i = ++j * 245;
        continue;
      } 
      paramArrayOfbyte = byteArrayOutputStream.toByteArray();
      byteArrayOutputStream.close();
      return paramArrayOfbyte;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */