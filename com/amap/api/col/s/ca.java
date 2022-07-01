package com.amap.api.col.s;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class ca {
  private static byte[] a;
  
  private static String[] b = new String[] { "kp6SsA", "cHE4dQ", "JKekrA", "XBxOHQ", "CSnpKw", "VwcThw", "wkp6Sg", "1cHE4Q" };
  
  private static int[] c = null;
  
  private static int a(int paramInt1, int paramInt2) {
    int i = 0;
    int j = 0;
    while (i < paramInt2) {
      j = j >> 1 | Integer.MIN_VALUE;
      i++;
    } 
    return paramInt1 << paramInt2 | (paramInt1 & j) >>> 32 - paramInt2;
  }
  
  public static String a() {
    SecureRandom secureRandom = new SecureRandom();
    try {
      KeyGenerator keyGenerator = KeyGenerator.getInstance(bs.c("EQUVT"));
      return bv.a(keyGenerator.generateKey().getEncoded());
    } finally {
      secureRandom = null;
    } 
  }
  
  private static String a(int paramInt) {
    char[] arrayOfChar = new char[4];
    for (int i = 0; i < 4; i++) {
      int j = 4 - i - 1;
      arrayOfChar[j] = (char)(paramInt >>> i * 8 & 0xFF);
      char c = arrayOfChar[j];
      String str = " ";
      for (j = 0; j < 32; j++) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append((Integer.MIN_VALUE >>> j & c) >>> 31 - j);
        str = stringBuilder.toString();
      } 
    } 
    return new String(arrayOfChar);
  }
  
  public static String a(String paramString) {
    return bq.a(paramString);
  }
  
  private static String a(int[] paramArrayOfint) {
    StringBuilder stringBuilder = new StringBuilder();
    if (paramArrayOfint != null)
      for (int i = 0; i < paramArrayOfint.length; i++)
        stringBuilder.append(a(a(b(paramArrayOfint[i]), i)));  
    return stringBuilder.toString();
  }
  
  private static byte[] a(byte[] paramArrayOfbyte) {
    try {
      if (a == null)
        a = bs.c("YAAAAAAAAAAAAAAAAAAAAAA").getBytes(); 
      IvParameterSpec ivParameterSpec = new IvParameterSpec(a);
      SecretKeySpec secretKeySpec = new SecretKeySpec(a(b()).getBytes("UTF-8"), bs.c("EQUVT"));
      Cipher cipher = Cipher.getInstance(bs.c("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
      cipher.init(1, secretKeySpec, ivParameterSpec);
      return cipher.doFinal(paramArrayOfbyte);
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  private static int b(int paramInt) {
    int i = 0;
    int j = 1;
    while (i < 15) {
      j = j << 2 | 0x1;
      i++;
    } 
    return (paramInt & j) << 1 | (j << 1 & paramInt) >>> 1;
  }
  
  public static String b(String paramString) {
    try {
      return bv.a(a(paramString.getBytes("UTF-8")));
    } finally {
      paramString = null;
    } 
  }
  
  private static int[] b() {
    int[] arrayOfInt = c;
    if (arrayOfInt != null)
      return arrayOfInt; 
    arrayOfInt = new int[8];
    int i = 0;
    while (true) {
      String[] arrayOfString = b;
      if (i < arrayOfString.length) {
        byte[] arrayOfByte = bn.b(arrayOfString[i]);
        byte b1 = arrayOfByte[3];
        byte b2 = arrayOfByte[2];
        byte b3 = arrayOfByte[1];
        arrayOfInt[i] = (arrayOfByte[0] & 0xFF) << 24 | b1 & 0xFF | (b2 & 0xFF) << 8 | (b3 & 0xFF) << 16;
        i++;
        continue;
      } 
      return arrayOfInt;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */