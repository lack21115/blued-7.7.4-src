package com.geetest.onelogin.e.a;

public class b {
  private static char[] a = new char[64];
  
  private static byte[] b = new byte[128];
  
  static {
    i = 0;
    while (true) {
      byte[] arrayOfByte = b;
      j = b1;
      if (i < arrayOfByte.length) {
        arrayOfByte[i] = -1;
        i++;
        continue;
      } 
      break;
    } 
    while (j < 64) {
      b[a[j]] = (byte)j;
      j++;
    } 
  }
  
  public static char[] a(byte[] paramArrayOfbyte) {
    return a(paramArrayOfbyte, paramArrayOfbyte.length);
  }
  
  public static char[] a(byte[] paramArrayOfbyte, int paramInt) {
    int k = (paramInt * 4 + 2) / 3;
    char[] arrayOfChar = new char[(paramInt + 2) / 3 * 4];
    int i = 0;
    int j;
    for (j = 0; i < paramInt; j++) {
      byte b1;
      int m = i + 1;
      int i1 = paramArrayOfbyte[i] & 0xFF;
      if (m < paramInt) {
        i = m + 1;
        m = paramArrayOfbyte[m] & 0xFF;
      } else {
        i = m;
        m = 0;
      } 
      if (i < paramInt) {
        int i2 = i + 1;
        b1 = paramArrayOfbyte[i] & 0xFF;
        i = i2;
      } else {
        b1 = 0;
      } 
      int n = j + 1;
      char[] arrayOfChar1 = a;
      arrayOfChar[j] = arrayOfChar1[i1 >>> 2];
      j = n + 1;
      arrayOfChar[n] = arrayOfChar1[(i1 & 0x3) << 4 | m >>> 4];
      char c2 = '=';
      if (j < k) {
        c1 = arrayOfChar1[(m & 0xF) << 2 | b1 >>> 6];
      } else {
        c1 = '=';
      } 
      arrayOfChar[j] = c1;
      j++;
      char c1 = c2;
      if (j < k)
        c1 = a[b1 & 0x3F]; 
      arrayOfChar[j] = c1;
    } 
    return arrayOfChar;
  }
  
  static {
    int j;
  }
  
  static {
    byte b1 = 0;
    char c = 'A';
    int i;
    for (i = 0; c <= 'Z'; i++) {
      a[i] = c;
      c = (char)(c + 1);
    } 
    c = 'a';
    while (c <= 'z') {
      a[i] = c;
      c = (char)(c + 1);
      i++;
    } 
    c = '0';
    while (c <= '9') {
      a[i] = c;
      c = (char)(c + 1);
      i++;
    } 
    char[] arrayOfChar = a;
    arrayOfChar[i] = '+';
    arrayOfChar[i + 1] = '/';
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\e\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */