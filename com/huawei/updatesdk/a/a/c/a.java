package com.huawei.updatesdk.a.a.c;

public class a {
  private static char[] a = new char[] { 
      'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
      'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
      'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 
      'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 
      'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 
      'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', 
      '8', '9', '+', '/', '=' };
  
  public static String a(byte[] paramArrayOfbyte) {
    return a(paramArrayOfbyte, paramArrayOfbyte.length);
  }
  
  public static String a(byte[] paramArrayOfbyte, int paramInt) {
    char[] arrayOfChar = new char[(paramInt + 2) / 3 * 4];
    int j = 0;
    for (int i = 0; j < paramInt; i += 4) {
      int m = (paramArrayOfbyte[j] & 0xFF) << 8;
      int k = j + 1;
      int n = 1;
      if (k < paramInt) {
        m |= paramArrayOfbyte[k] & 0xFF;
        k = 1;
      } else {
        k = 0;
      } 
      m <<= 8;
      int i1 = j + 2;
      if (i1 < paramInt) {
        m |= paramArrayOfbyte[i1] & 0xFF;
      } else {
        n = 0;
      } 
      char[] arrayOfChar1 = a;
      i1 = 64;
      if (n) {
        n = m & 0x3F;
      } else {
        n = 64;
      } 
      arrayOfChar[i + 3] = arrayOfChar1[n];
      n = m >> 6;
      arrayOfChar1 = a;
      m = i1;
      if (k != 0)
        m = n & 0x3F; 
      arrayOfChar[i + 2] = arrayOfChar1[m];
      k = n >> 6;
      arrayOfChar1 = a;
      arrayOfChar[i + 1] = arrayOfChar1[k & 0x3F];
      arrayOfChar[i + 0] = arrayOfChar1[k >> 6 & 0x3F];
      j += 3;
    } 
    return String.valueOf(arrayOfChar);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\a\a\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */