package com.alipay.sdk.encrypt;

import android.text.TextUtils;
import java.security.SecureRandom;
import javax.crypto.Cipher;

class d {
  static byte[] a(Cipher paramCipher, String paramString) {
    SecureRandom secureRandom = new SecureRandom();
    int j = paramCipher.getBlockSize();
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
      str = String.valueOf(secureRandom.nextDouble()); 
    byte[] arrayOfByte1 = new byte[j * 2];
    byte[] arrayOfByte2 = new byte[j];
    secureRandom.nextBytes(arrayOfByte2);
    int k = arrayOfByte1.length;
    for (int i = 1; i < k; i++) {
      arrayOfByte1[i] = (byte)(str.codePointAt(i % str.length()) & 0x7F);
      if (i >= j) {
        byte b = arrayOfByte1[i];
        arrayOfByte1[i] = (byte)(arrayOfByte1[0] & b);
      } 
    } 
    System.arraycopy(arrayOfByte1, j, arrayOfByte2, 0, j);
    return arrayOfByte2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\encrypt\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */