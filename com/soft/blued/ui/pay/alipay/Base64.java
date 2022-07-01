package com.soft.blued.ui.pay.alipay;

public final class Base64 {
  private static final byte[] a = new byte[128];
  
  private static final char[] b = new char[64];
  
  static {
    byte b = 0;
    int i;
    for (i = 0; i < 128; i++)
      a[i] = -1; 
    for (i = 90; i >= 65; i--)
      a[i] = (byte)(i - 65); 
    i = 122;
    while (true) {
      int j = 26;
      if (i >= 97) {
        a[i] = (byte)(i - 97 + 26);
        i--;
        continue;
      } 
      i = 57;
      while (true) {
        int k;
        int m;
        byte b1 = 52;
        if (i >= 48) {
          a[i] = (byte)(i - 48 + 52);
          i--;
          continue;
        } 
        byte[] arrayOfByte = a;
        arrayOfByte[43] = 62;
        arrayOfByte[47] = 63;
        for (i = 0; i <= 25; i++)
          b[i] = (char)(i + 65); 
        i = 0;
        while (true) {
          k = b;
          m = b1;
          if (j <= 51) {
            b[j] = (char)(i + 97);
            j++;
            i++;
            continue;
          } 
          break;
        } 
        while (m <= 61) {
          b[m] = (char)(k + 48);
          m++;
          k++;
        } 
        char[] arrayOfChar = b;
        arrayOfChar[62] = '+';
        arrayOfChar[63] = '/';
        return;
      } 
      break;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\pay\alipay\Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */