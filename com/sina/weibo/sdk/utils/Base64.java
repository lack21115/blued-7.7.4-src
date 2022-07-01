package com.sina.weibo.sdk.utils;

public final class Base64 {
  private static char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();
  
  private static byte[] codes = new byte[256];
  
  static {
    for (int i = 0;; i++) {
      if (i >= 256) {
        for (i = 65;; i++) {
          if (i > 90) {
            for (i = 97;; i++) {
              if (i > 122) {
                for (i = 48;; i++) {
                  if (i > 57) {
                    byte[] arrayOfByte = codes;
                    arrayOfByte[43] = 62;
                    arrayOfByte[47] = 63;
                    return;
                  } 
                  codes[i] = (byte)(i + 52 - 48);
                } 
                break;
              } 
              codes[i] = (byte)(i + 26 - 97);
            } 
            break;
          } 
          codes[i] = (byte)(i - 65);
        } 
        break;
      } 
      codes[i] = -1;
    } 
  }
  
  public static byte[] decode(byte[] paramArrayOfbyte) {
    int j = (paramArrayOfbyte.length + 3) / 4 * 3;
    int i = j;
    if (paramArrayOfbyte.length > 0) {
      i = j;
      if (paramArrayOfbyte[paramArrayOfbyte.length - 1] == 61)
        i = j - 1; 
    } 
    j = i;
    if (paramArrayOfbyte.length > 1) {
      j = i;
      if (paramArrayOfbyte[paramArrayOfbyte.length - 2] == 61)
        j = i - 1; 
    } 
    byte[] arrayOfByte = new byte[j];
    j = 0;
    int k = 0;
    int m = 0;
    int n;
    for (n = 0;; n = i) {
      if (j >= paramArrayOfbyte.length) {
        if (k == arrayOfByte.length)
          return arrayOfByte; 
        throw new RuntimeException("miscalculated data length!");
      } 
      byte b = codes[paramArrayOfbyte[j] & 0xFF];
      int i2 = k;
      int i1 = m;
      i = n;
      if (b >= 0) {
        n += 6;
        m = m << 6 | b;
        i2 = k;
        i1 = m;
        i = n;
        if (n >= 8) {
          i = n - 8;
          arrayOfByte[k] = (byte)(m >> i & 0xFF);
          i2 = k + 1;
          i1 = m;
        } 
      } 
      j++;
      k = i2;
      m = i1;
    } 
  }
  
  public static char[] encode(byte[] paramArrayOfbyte) {
    char[] arrayOfChar = new char[(paramArrayOfbyte.length + 2) / 3 * 4];
    int j = 0;
    for (int i = 0;; i += 4) {
      if (j >= paramArrayOfbyte.length)
        return arrayOfChar; 
      int m = (paramArrayOfbyte[j] & 0xFF) << 8;
      int k = j + 1;
      int i1 = paramArrayOfbyte.length;
      int n = 1;
      if (k < i1) {
        m |= paramArrayOfbyte[k] & 0xFF;
        k = 1;
      } else {
        k = 0;
      } 
      m <<= 8;
      i1 = j + 2;
      if (i1 < paramArrayOfbyte.length) {
        m |= paramArrayOfbyte[i1] & 0xFF;
      } else {
        n = 0;
      } 
      char[] arrayOfChar1 = alphabet;
      i1 = 64;
      if (n) {
        n = m & 0x3F;
      } else {
        n = 64;
      } 
      arrayOfChar[i + 3] = arrayOfChar1[n];
      n = m >> 6;
      arrayOfChar1 = alphabet;
      m = i1;
      if (k != 0)
        m = n & 0x3F; 
      arrayOfChar[i + 2] = arrayOfChar1[m];
      k = n >> 6;
      arrayOfChar1 = alphabet;
      arrayOfChar[i + 1] = arrayOfChar1[k & 0x3F];
      arrayOfChar[i + 0] = arrayOfChar1[k >> 6 & 0x3F];
      j += 3;
    } 
  }
  
  public static byte[] encodebyte(byte[] paramArrayOfbyte) {
    byte[] arrayOfByte = new byte[(paramArrayOfbyte.length + 2) / 3 * 4];
    int j = 0;
    for (int i = 0;; i += 4) {
      if (j >= paramArrayOfbyte.length)
        return arrayOfByte; 
      int m = (paramArrayOfbyte[j] & 0xFF) << 8;
      int k = j + 1;
      int i1 = paramArrayOfbyte.length;
      int n = 1;
      if (k < i1) {
        m |= paramArrayOfbyte[k] & 0xFF;
        k = 1;
      } else {
        k = 0;
      } 
      m <<= 8;
      i1 = j + 2;
      if (i1 < paramArrayOfbyte.length) {
        m |= paramArrayOfbyte[i1] & 0xFF;
      } else {
        n = 0;
      } 
      char[] arrayOfChar = alphabet;
      i1 = 64;
      if (n) {
        n = m & 0x3F;
      } else {
        n = 64;
      } 
      arrayOfByte[i + 3] = (byte)arrayOfChar[n];
      n = m >> 6;
      arrayOfChar = alphabet;
      m = i1;
      if (k != 0)
        m = n & 0x3F; 
      arrayOfByte[i + 2] = (byte)arrayOfChar[m];
      k = n >> 6;
      arrayOfChar = alphabet;
      arrayOfByte[i + 1] = (byte)arrayOfChar[k & 0x3F];
      arrayOfByte[i + 0] = (byte)arrayOfChar[k >> 6 & 0x3F];
      j += 3;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sd\\utils\Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */