package com.baidu.mobads.utils;

import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class b {
  public static String a(String paramString1, String paramString2) {
    if (!TextUtils.isEmpty(paramString2)) {
      if (TextUtils.isEmpty(paramString1))
        return ""; 
      try {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1PADDING");
        RSAPublicKey rSAPublicKey = (RSAPublicKey)a(paramString1);
        cipher.init(1, rSAPublicKey);
        byte[] arrayOfByte = paramString2.getBytes("UTF-8");
        int k = rSAPublicKey.getModulus().bitLength() / 8;
        int m = arrayOfByte.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int j = 0;
        while (true) {
          int n = m - i;
          if (n > 0) {
            byte[] arrayOfByte2;
            if (n > k) {
              arrayOfByte2 = cipher.doFinal(arrayOfByte, i, k);
            } else {
              arrayOfByte2 = cipher.doFinal(arrayOfByte, i, n);
            } 
            byteArrayOutputStream.write(arrayOfByte2, 0, arrayOfByte2.length);
            i = ++j * k;
            continue;
          } 
          byte[] arrayOfByte1 = byteArrayOutputStream.toByteArray();
          return Base64.encodeToString(arrayOfByte1, 8);
        } 
      } finally {
        paramString1 = null;
      } 
    } 
    return "";
  }
  
  private static PublicKey a(String paramString) {
    try {
      return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(arrayOfByte));
    } finally {
      paramString = null;
      q.a().d((Throwable)paramString);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\\utils\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */