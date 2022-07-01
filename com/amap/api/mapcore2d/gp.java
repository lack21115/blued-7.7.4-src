package com.amap.api.mapcore2d;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;

public final class gp {
  private static final char[] a = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'a', 'b', 'c', 'd', 'e', 'f' };
  
  private static final byte[] b = new byte[] { 
      0, 1, 1, 2, 3, 5, 8, 13, 8, 7, 
      6, 5, 4, 3, 2, 1 };
  
  private static final IvParameterSpec c = new IvParameterSpec(b);
  
  public static byte[] a(byte[] paramArrayOfbyte) {
    int i = 0;
    try {
      byte[] arrayOfByte = new byte[16];
      null = new byte[paramArrayOfbyte.length - 16];
      return cipher.doFinal(null);
    } finally {
      Exception exception = null;
      if (paramArrayOfbyte != null)
        i = paramArrayOfbyte.length; 
      StringBuilder stringBuilder = new StringBuilder("decryptRsponse length = ");
      stringBuilder.append(i);
      gu.a(exception, "Encrypt", stringBuilder.toString());
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\gp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */