package com.huawei.hms.support.log.common;

public final class Base64 {
  private static final byte[] DECODE_TABLE;
  
  private static final char[] ENCODE_TABLE = new char[] { 
      'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
      'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
      'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 
      'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 
      'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 
      'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', 
      '8', '9', '+', '/', '=' };
  
  static {
    DECODE_TABLE = new byte[] { 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 
        54, 55, 56, 57, 58, 59, 60, 61, -1, -1, 
        -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 
        5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
        15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
        25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 
        29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
        39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
        49, 50, 51, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1 };
  }
  
  public static byte[] decode(String paramString) {
    int i = vaildLen(paramString);
    int j = i / 4 * 3;
    int k = i % 4;
    i = j;
    if (k == 3)
      i = j + 2; 
    j = i;
    if (k == 2)
      j = i + 1; 
    byte[] arrayOfByte = new byte[j];
    j = 0;
    k = 0;
    int m = 0;
    int n;
    for (n = 0; j < paramString.length(); n = i) {
      byte b;
      i = paramString.charAt(j);
      if (i > 255) {
        b = -1;
      } else {
        b = DECODE_TABLE[i];
      } 
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
          arrayOfByte[k] = (byte)(0xFF & m >> i);
          i2 = k + 1;
          i1 = m;
        } 
      } 
      j++;
      k = i2;
      m = i1;
    } 
    return (k != arrayOfByte.length) ? new byte[0] : arrayOfByte;
  }
  
  public static String encode(byte[] paramArrayOfbyte) {
    return encode(paramArrayOfbyte, paramArrayOfbyte.length);
  }
  
  public static String encode(byte[] paramArrayOfbyte, int paramInt) {
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
      char[] arrayOfChar1 = ENCODE_TABLE;
      i1 = 64;
      if (n) {
        n = m & 0x3F;
      } else {
        n = 64;
      } 
      arrayOfChar[i + 3] = arrayOfChar1[n];
      n = m >> 6;
      arrayOfChar1 = ENCODE_TABLE;
      m = i1;
      if (k != 0)
        m = n & 0x3F; 
      arrayOfChar[i + 2] = arrayOfChar1[m];
      k = n >> 6;
      arrayOfChar1 = ENCODE_TABLE;
      arrayOfChar[i + 1] = arrayOfChar1[k & 0x3F];
      arrayOfChar[i + 0] = arrayOfChar1[k >> 6 & 0x3F];
      j += 3;
    } 
    return new String(arrayOfChar);
  }
  
  private static int vaildLen(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual length : ()I
    //   4: istore_2
    //   5: iconst_0
    //   6: istore_1
    //   7: iload_1
    //   8: aload_0
    //   9: invokevirtual length : ()I
    //   12: if_icmpge -> 54
    //   15: aload_0
    //   16: iload_1
    //   17: invokevirtual charAt : (I)C
    //   20: istore #4
    //   22: iload #4
    //   24: sipush #255
    //   27: if_icmpgt -> 41
    //   30: iload_2
    //   31: istore_3
    //   32: getstatic com/huawei/hms/support/log/common/Base64.DECODE_TABLE : [B
    //   35: iload #4
    //   37: baload
    //   38: ifge -> 45
    //   41: iload_2
    //   42: iconst_1
    //   43: isub
    //   44: istore_3
    //   45: iload_1
    //   46: iconst_1
    //   47: iadd
    //   48: istore_1
    //   49: iload_3
    //   50: istore_2
    //   51: goto -> 7
    //   54: iload_2
    //   55: ireturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\log\common\Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */