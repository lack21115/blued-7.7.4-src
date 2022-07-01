package com.google.zxing.pdf417.encoder;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

final class PDF417HighLevelEncoder {
  private static final byte[] a = new byte[] { 
      48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 
      38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 
      43, 37, 42, 61, 94, 0, 32, 0, 0, 0 };
  
  private static final byte[] b = new byte[] { 
      59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 
      33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 
      34, 124, 42, 40, 41, 63, 123, 125, 39, 0 };
  
  private static final byte[] c = new byte[128];
  
  private static final byte[] d = new byte[128];
  
  private static final Charset e = StandardCharsets.ISO_8859_1;
  
  static {
    Arrays.fill(c, (byte)-1);
    byte b = 0;
    int i = 0;
    while (true) {
      byte[] arrayOfByte = a;
      if (i < arrayOfByte.length) {
        byte b1 = arrayOfByte[i];
        if (b1 > 0)
          c[b1] = (byte)i; 
        i++;
        continue;
      } 
      Arrays.fill(d, (byte)-1);
      i = b;
      while (true) {
        arrayOfByte = b;
        if (i < arrayOfByte.length) {
          b = arrayOfByte[i];
          if (b > 0)
            d[b] = (byte)i; 
          i++;
          continue;
        } 
        break;
      } 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\pdf417\encoder\PDF417HighLevelEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */