package com.geetest.onelogin.e.a;

import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;

public class d {
  private final int[] a = new int[] { 1732584193, -271733879, -1732584194, 271733878, -1009589776 };
  
  private final int[] b = new int[5];
  
  private final int[] c = new int[80];
  
  private int a(int paramInt1, int paramInt2) {
    return paramInt1 >>> 32 - paramInt2 | paramInt1 << paramInt2;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3) {
    return paramInt1 & paramInt3 | paramInt2 & paramInt1;
  }
  
  private int a(byte[] paramArrayOfbyte, int paramInt) {
    byte b1 = paramArrayOfbyte[paramInt];
    byte b2 = paramArrayOfbyte[paramInt + 1];
    byte b3 = paramArrayOfbyte[paramInt + 2];
    return paramArrayOfbyte[paramInt + 3] & 0xFF | (b1 & 0xFF) << 24 | (b2 & 0xFF) << 16 | (b3 & 0xFF) << 8;
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    StringBuilder stringBuilder = new StringBuilder("");
    if (paramArrayOfbyte == null || paramArrayOfbyte.length <= 0)
      return null; 
    for (int i = 0; i < paramArrayOfbyte.length; i++) {
      String str = Integer.toHexString(paramArrayOfbyte[i] & 0xFF).toUpperCase(Locale.CHINA);
      if (str.length() < 2)
        stringBuilder.append(0); 
      stringBuilder.append(str);
    } 
    return stringBuilder.toString();
  }
  
  private void a() {
    int i;
    for (i = 16; i <= 79; i++) {
      int[] arrayOfInt1 = this.c;
      arrayOfInt1[i] = a(arrayOfInt1[i - 3] ^ arrayOfInt1[i - 8] ^ arrayOfInt1[i - 14] ^ arrayOfInt1[i - 16], 1);
    } 
    int[] arrayOfInt = new int[5];
    for (i = 0; i < arrayOfInt.length; i++)
      arrayOfInt[i] = this.b[i]; 
    for (i = 0; i <= 19; i++) {
      int j = a(arrayOfInt[0], 5);
      int k = a(arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]);
      int m = arrayOfInt[4];
      int n = this.c[i];
      arrayOfInt[4] = arrayOfInt[3];
      arrayOfInt[3] = arrayOfInt[2];
      arrayOfInt[2] = a(arrayOfInt[1], 30);
      arrayOfInt[1] = arrayOfInt[0];
      arrayOfInt[0] = j + k + m + n + 1518500249;
    } 
    for (i = 20; i <= 39; i++) {
      int j = a(arrayOfInt[0], 5);
      int k = b(arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]);
      int m = arrayOfInt[4];
      int n = this.c[i];
      arrayOfInt[4] = arrayOfInt[3];
      arrayOfInt[3] = arrayOfInt[2];
      arrayOfInt[2] = a(arrayOfInt[1], 30);
      arrayOfInt[1] = arrayOfInt[0];
      arrayOfInt[0] = j + k + m + n + 1859775393;
    } 
    for (i = 40; i <= 59; i++) {
      int j = a(arrayOfInt[0], 5);
      int k = c(arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]);
      int m = arrayOfInt[4];
      int n = this.c[i];
      arrayOfInt[4] = arrayOfInt[3];
      arrayOfInt[3] = arrayOfInt[2];
      arrayOfInt[2] = a(arrayOfInt[1], 30);
      arrayOfInt[1] = arrayOfInt[0];
      arrayOfInt[0] = j + k + m + n - 1894007588;
    } 
    for (i = 60; i <= 79; i++) {
      int j = a(arrayOfInt[0], 5);
      int k = b(arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]);
      int m = arrayOfInt[4];
      int n = this.c[i];
      arrayOfInt[4] = arrayOfInt[3];
      arrayOfInt[3] = arrayOfInt[2];
      arrayOfInt[2] = a(arrayOfInt[1], 30);
      arrayOfInt[1] = arrayOfInt[0];
      arrayOfInt[0] = j + k + m + n - 899497514;
    } 
    for (i = 0; i < arrayOfInt.length; i++) {
      int[] arrayOfInt1 = this.b;
      arrayOfInt1[i] = arrayOfInt1[i] + arrayOfInt[i];
    } 
    i = 0;
    while (true) {
      arrayOfInt = this.c;
      if (i < arrayOfInt.length) {
        arrayOfInt[i] = 0;
        i++;
        continue;
      } 
      break;
    } 
  }
  
  private void a(int paramInt1, byte[] paramArrayOfbyte, int paramInt2) {
    paramArrayOfbyte[paramInt2] = (byte)(paramInt1 >>> 24);
    paramArrayOfbyte[paramInt2 + 1] = (byte)(paramInt1 >>> 16);
    paramArrayOfbyte[paramInt2 + 2] = (byte)(paramInt1 >>> 8);
    paramArrayOfbyte[paramInt2 + 3] = (byte)paramInt1;
  }
  
  public static byte[] a(String paramString1, String paramString2) {
    byte[] arrayOfByte1;
    int j;
    if (TextUtils.isEmpty(paramString2)) {
      Log.d("HMAC_SHA1", "when getHmacSHA1,the key is null");
      return null;
    } 
    byte[] arrayOfByte2 = new byte[64];
    byte[] arrayOfByte3 = new byte[64];
    byte[] arrayOfByte4 = new byte[64];
    int k = paramString2.length();
    d d1 = new d();
    int i = paramString2.length();
    byte b = 0;
    if (i > 64) {
      arrayOfByte1 = d1.d(i.b(paramString2));
      k = arrayOfByte1.length;
      j = 0;
      while (true) {
        i = k;
        if (j < k) {
          arrayOfByte4[j] = arrayOfByte1[j];
          j++;
          continue;
        } 
        break;
      } 
    } else {
      arrayOfByte1 = i.b((String)arrayOfByte1);
      j = 0;
      while (true) {
        i = k;
        if (j < arrayOfByte1.length) {
          arrayOfByte4[j] = arrayOfByte1[j];
          j++;
          continue;
        } 
        break;
      } 
    } 
    while (true) {
      j = b;
      if (i < 64) {
        arrayOfByte4[i] = 0;
        i++;
        continue;
      } 
      break;
    } 
    while (j < 64) {
      arrayOfByte2[j] = (byte)(arrayOfByte4[j] ^ 0x36);
      arrayOfByte3[j] = (byte)(arrayOfByte4[j] ^ 0x5C);
      j++;
    } 
    return d1.d(a(arrayOfByte3, d1.d(a(arrayOfByte2, i.b(paramString1)))));
  }
  
  private static byte[] a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    int j;
    byte[] arrayOfByte = new byte[paramArrayOfbyte1.length + paramArrayOfbyte2.length];
    byte b = 0;
    int i = 0;
    while (true) {
      j = b;
      if (i < paramArrayOfbyte1.length) {
        arrayOfByte[i] = paramArrayOfbyte1[i];
        i++;
        continue;
      } 
      break;
    } 
    while (j < paramArrayOfbyte2.length) {
      arrayOfByte[paramArrayOfbyte1.length + j] = paramArrayOfbyte2[j];
      j++;
    } 
    return arrayOfByte;
  }
  
  private int b(int paramInt1, int paramInt2, int paramInt3) {
    return paramInt1 ^ paramInt2 ^ paramInt3;
  }
  
  private int b(byte[] paramArrayOfbyte) {
    int[] arrayOfInt = this.a;
    System.arraycopy(arrayOfInt, 0, this.b, 0, arrayOfInt.length);
    paramArrayOfbyte = c(paramArrayOfbyte);
    int j = paramArrayOfbyte.length / 64;
    for (int i = 0; i < j; i++) {
      for (int k = 0; k < 16; k++)
        this.c[k] = a(paramArrayOfbyte, i * 64 + k * 4); 
      a();
    } 
    return 20;
  }
  
  private int c(int paramInt1, int paramInt2, int paramInt3) {
    return paramInt1 & paramInt3 | paramInt1 & paramInt2 | paramInt2 & paramInt3;
  }
  
  private byte[] c(byte[] paramArrayOfbyte) {
    int k = paramArrayOfbyte.length;
    int j = k % 64;
    int i = 63;
    if (j < 56) {
      i = 55 - j;
      j = k - j;
    } else if (j == 56) {
      j = k + 8;
    } else {
      i = 63 - j + 56;
      j = k + 64 - j + 64;
      byte[] arrayOfByte1 = new byte[j];
      System.arraycopy(paramArrayOfbyte, 0, arrayOfByte1, 0, k);
      arrayOfByte1[k] = Byte.MIN_VALUE;
      j = k + 1;
      boolean bool1 = false;
    } 
    j += 64;
    byte[] arrayOfByte = new byte[j];
    System.arraycopy(paramArrayOfbyte, 0, arrayOfByte, 0, k);
    arrayOfByte[k] = Byte.MIN_VALUE;
    j = k + 1;
    boolean bool = false;
  }
  
  private byte[] d(byte[] paramArrayOfbyte) {
    b(paramArrayOfbyte);
    paramArrayOfbyte = new byte[20];
    int i = 0;
    while (true) {
      int[] arrayOfInt = this.b;
      if (i < arrayOfInt.length) {
        a(arrayOfInt[i], paramArrayOfbyte, i * 4);
        i++;
        continue;
      } 
      return paramArrayOfbyte;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\e\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */