package com.alipay.sdk.encrypt;

public final class a {
  private static final int a = 128;
  
  private static final int b = 64;
  
  private static final int c = 24;
  
  private static final int d = 8;
  
  private static final int e = 16;
  
  private static final int f = 4;
  
  private static final int g = -128;
  
  private static final char h = '=';
  
  private static final byte[] i = new byte[128];
  
  private static final char[] j = new char[64];
  
  static {
    byte b = 0;
    int i;
    for (i = 0; i < 128; i++)
      i[i] = -1; 
    for (i = 90; i >= 65; i--)
      i[i] = (byte)(i - 65); 
    i = 122;
    while (true) {
      int j = 26;
      if (i >= 97) {
        i[i] = (byte)(i - 97 + 26);
        i--;
        continue;
      } 
      i = 57;
      while (true) {
        int k;
        int m;
        byte b1 = 52;
        if (i >= 48) {
          i[i] = (byte)(i - 48 + 52);
          i--;
          continue;
        } 
        byte[] arrayOfByte = i;
        arrayOfByte[43] = 62;
        arrayOfByte[47] = 63;
        for (i = 0; i <= 25; i++)
          j[i] = (char)(i + 65); 
        i = 0;
        while (true) {
          k = b;
          m = b1;
          if (j <= 51) {
            j[j] = (char)(i + 97);
            j++;
            i++;
            continue;
          } 
          break;
        } 
        while (m <= 61) {
          j[m] = (char)(k + 48);
          m++;
          k++;
        } 
        char[] arrayOfChar = j;
        arrayOfChar[62] = '+';
        arrayOfChar[63] = '/';
        return;
      } 
      break;
    } 
  }
  
  private static int a(char[] paramArrayOfchar) {
    int i = 0;
    if (paramArrayOfchar == null)
      return 0; 
    int k = paramArrayOfchar.length;
    int j;
    for (j = 0; i < k; j = m) {
      int m = j;
      if (!a(paramArrayOfchar[i])) {
        paramArrayOfchar[j] = paramArrayOfchar[i];
        m = j + 1;
      } 
      i++;
    } 
    return j;
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    char[] arrayOfChar1;
    if (paramArrayOfbyte == null)
      return null; 
    int i = paramArrayOfbyte.length * 8;
    if (i == 0)
      return ""; 
    int n = i % 24;
    int m = i / 24;
    if (n != 0) {
      i = m + 1;
    } else {
      i = m;
    } 
    char[] arrayOfChar2 = new char[i * 4];
    int j = 0;
    int k = 0;
    i = 0;
    while (j < m) {
      int i2 = k + 1;
      byte b3 = paramArrayOfbyte[k];
      int i1 = i2 + 1;
      byte b4 = paramArrayOfbyte[i2];
      i2 = paramArrayOfbyte[i1];
      byte b1 = (byte)(b4 & 0xF);
      byte b2 = (byte)(b3 & 0x3);
      k = b3 >> 2;
      if ((b3 & Byte.MIN_VALUE) != 0)
        k ^= 0xC0; 
      b3 = (byte)k;
      k = b4 >> 4;
      if ((b4 & Byte.MIN_VALUE) != 0)
        k ^= 0xF0; 
      b4 = (byte)k;
      if ((i2 & 0xFFFFFF80) == 0) {
        k = i2 >> 6;
      } else {
        k = i2 >> 6 ^ 0xFC;
      } 
      k = (byte)k;
      int i4 = i + 1;
      char[] arrayOfChar = j;
      arrayOfChar2[i] = arrayOfChar[b3];
      i = i4 + 1;
      arrayOfChar2[i4] = arrayOfChar[b2 << 4 | b4];
      int i3 = i + 1;
      arrayOfChar2[i] = arrayOfChar[b1 << 2 | k];
      arrayOfChar2[i3] = arrayOfChar[i2 & 0x3F];
      j++;
      i = i3 + 1;
      k = i1 + 1;
    } 
    if (n == 8) {
      m = paramArrayOfbyte[k];
      k = (byte)(m & 0x3);
      j = m >> 2;
      if ((m & 0xFFFFFF80) != 0)
        j ^= 0xC0; 
      m = (byte)j;
      j = i + 1;
      arrayOfChar1 = j;
      arrayOfChar2[i] = arrayOfChar1[m];
      i = j + 1;
      arrayOfChar2[j] = arrayOfChar1[k << 4];
      arrayOfChar2[i] = '=';
      arrayOfChar2[i + 1] = '=';
    } else if (n == 16) {
      char c = arrayOfChar1[k];
      n = arrayOfChar1[k + 1];
      k = (byte)(n & 0xF);
      m = (byte)(c & 0x3);
      j = c >> 2;
      if ((c & 0xFFFFFF80) != 0)
        j ^= 0xC0; 
      byte b = (byte)j;
      j = n >> 4;
      if ((n & 0xFFFFFF80) != 0)
        j ^= 0xF0; 
      j = (byte)j;
      n = i + 1;
      arrayOfChar1 = j;
      arrayOfChar2[i] = arrayOfChar1[b];
      i = n + 1;
      arrayOfChar2[n] = arrayOfChar1[j | m << 4];
      arrayOfChar2[i] = arrayOfChar1[k << 2];
      arrayOfChar2[i + 1] = '=';
    } 
    return new String(arrayOfChar2);
  }
  
  private static boolean a(char paramChar) {
    return (paramChar == ' ' || paramChar == '\r' || paramChar == '\n' || paramChar == '\t');
  }
  
  public static byte[] a(String paramString) {
    byte[] arrayOfByte1;
    String str = null;
    if (paramString == null)
      return null; 
    char[] arrayOfChar = paramString.toCharArray();
    int i = a(arrayOfChar);
    if (i % 4 != 0)
      return null; 
    int m = i / 4;
    if (m == 0)
      return new byte[0]; 
    byte[] arrayOfByte2 = new byte[m * 3];
    int j = 0;
    int k = 0;
    i = 0;
    while (j < m - 1) {
      int n = k + 1;
      char c1 = arrayOfChar[k];
      if (c(c1)) {
        int i1 = n + 1;
        char c2 = arrayOfChar[n];
        if (c(c2)) {
          k = i1 + 1;
          char c3 = arrayOfChar[i1];
          if (c(c3)) {
            char c4 = arrayOfChar[k];
            if (!c(c4))
              return null; 
            arrayOfByte1 = i;
            byte b2 = arrayOfByte1[c1];
            byte b1 = arrayOfByte1[c2];
            n = arrayOfByte1[c3];
            i1 = arrayOfByte1[c4];
            int i2 = i + 1;
            arrayOfByte2[i] = (byte)(b2 << 2 | b1 >> 4);
            int i3 = i2 + 1;
            arrayOfByte2[i2] = (byte)((b1 & 0xF) << 4 | n >> 2 & 0xF);
            i = i3 + 1;
            arrayOfByte2[i3] = (byte)(n << 6 | i1);
            j++;
            k++;
            continue;
          } 
        } 
      } 
      return null;
    } 
    m = k + 1;
    char c = arrayOfChar[k];
    paramString = str;
    if (c(c)) {
      int n = m + 1;
      char c1 = arrayOfChar[m];
      if (!c(c1))
        return null; 
      arrayOfByte1 = i;
      k = arrayOfByte1[c];
      m = arrayOfByte1[c1];
      c = arrayOfChar[n];
      c1 = arrayOfChar[n + 1];
      if (!c(c) || !c(c1)) {
        byte[] arrayOfByte;
        if (b(c) && b(c1)) {
          if ((m & 0xF) != 0)
            return null; 
          j *= 3;
          arrayOfByte1 = new byte[j + 1];
          System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, j);
          arrayOfByte1[i] = (byte)(k << 2 | m >> 4);
          return arrayOfByte1;
        } 
        String str1 = str;
        if (!b(c)) {
          str1 = str;
          if (b(c1)) {
            n = i[c];
            if ((n & 0x3) != 0)
              return null; 
            j *= 3;
            arrayOfByte = new byte[j + 2];
            System.arraycopy(arrayOfByte2, 0, arrayOfByte, 0, j);
            arrayOfByte[i] = (byte)(k << 2 | m >> 4);
            arrayOfByte[i + 1] = (byte)(n >> 2 & 0xF | (m & 0xF) << 4);
          } 
        } 
        return arrayOfByte;
      } 
      arrayOfByte1 = i;
      j = arrayOfByte1[c];
      n = arrayOfByte1[c1];
      int i1 = i + 1;
      arrayOfByte2[i] = (byte)(k << 2 | m >> 4);
      arrayOfByte2[i1] = (byte)((m & 0xF) << 4 | j >> 2 & 0xF);
      arrayOfByte2[i1 + 1] = (byte)(n | j << 6);
      return arrayOfByte2;
    } 
    return arrayOfByte1;
  }
  
  private static boolean b(char paramChar) {
    return (paramChar == '=');
  }
  
  private static boolean c(char paramChar) {
    return (paramChar < '' && i[paramChar] != -1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\encrypt\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */