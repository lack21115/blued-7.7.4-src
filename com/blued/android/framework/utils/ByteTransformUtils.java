package com.blued.android.framework.utils;

public class ByteTransformUtils {
  private static byte a(String paramString1, String paramString2) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("0x");
    stringBuilder2.append(paramString1);
    byte b = (byte)(Byte.decode(stringBuilder2.toString()).byteValue() << 4);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("0x");
    stringBuilder1.append(paramString2);
    return (byte)(b | Byte.decode(stringBuilder1.toString()).byteValue());
  }
  
  public static String a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    StringBuffer stringBuffer = new StringBuffer();
    while (paramInt1 < paramInt2) {
      String str = Integer.toHexString(paramArrayOfbyte[paramInt1] & 0xFF);
      if (str.length() == 1) {
        stringBuffer.append("0");
        stringBuffer.append(str);
      } else {
        stringBuffer.append(str);
      } 
      paramInt1++;
    } 
    return stringBuffer.toString().toUpperCase();
  }
  
  public static byte[] a(String paramString) {
    int j = paramString.length() / 2;
    System.out.println(j);
    byte[] arrayOfByte = new byte[j];
    for (int i = 0; i < j; i++) {
      int k = i * 2;
      int m = k + 1;
      arrayOfByte[i] = a(paramString.substring(k, m), paramString.substring(m, m + 1));
    } 
    return arrayOfByte;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\utils\ByteTransformUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */