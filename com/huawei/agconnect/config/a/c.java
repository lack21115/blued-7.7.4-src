package com.huawei.agconnect.config.a;

public class c {
  private static final char[] a = "0123456789ABCDEF".toCharArray();
  
  public static String a(byte[] paramArrayOfbyte) {
    StringBuilder stringBuilder = new StringBuilder(paramArrayOfbyte.length * 2);
    int j = paramArrayOfbyte.length;
    for (int i = 0; i < j; i++) {
      byte b = paramArrayOfbyte[i];
      stringBuilder.append(a[b >> 4 & 0xF]);
      stringBuilder.append(a[b & 0xF]);
    } 
    return stringBuilder.toString();
  }
  
  public static byte[] a(String paramString) {
    return a(paramString.toCharArray());
  }
  
  private static byte[] a(char[] paramArrayOfchar) {
    if ((paramArrayOfchar.length & 0x1) == 0) {
      byte[] arrayOfByte = new byte[paramArrayOfchar.length >> 1];
      int j = 0;
      int i = 0;
      while (j < paramArrayOfchar.length) {
        int k = Character.digit(paramArrayOfchar[j], 16);
        if (k != -1) {
          int m = Character.digit(paramArrayOfchar[++j], 16);
          if (m != -1) {
            j++;
            arrayOfByte[i] = (byte)((k << 4 | m) & 0xFF);
            i++;
            continue;
          } 
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Illegal hexadecimal character at index ");
          stringBuilder1.append(j);
          throw new IllegalArgumentException(stringBuilder1.toString());
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Illegal hexadecimal character at index ");
        stringBuilder.append(j);
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      return arrayOfByte;
    } 
    throw new IllegalArgumentException("Odd number of characters.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\agconnect\config\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */