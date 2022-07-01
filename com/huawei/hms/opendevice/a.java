package com.huawei.hms.opendevice;

import com.huawei.hms.support.log.HMSLog;
import java.io.UnsupportedEncodingException;

public abstract class a {
  public static final char[] a = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'A', 'B', 'C', 'D', 'E', 'F' };
  
  public static String a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null)
      return null; 
    if (paramArrayOfbyte.length == 0)
      return ""; 
    char[] arrayOfChar = new char[paramArrayOfbyte.length * 2];
    for (int i = 0; i < paramArrayOfbyte.length; i++) {
      byte b = paramArrayOfbyte[i];
      int j = i * 2;
      char[] arrayOfChar1 = a;
      arrayOfChar[j] = arrayOfChar1[(b & 0xF0) >> 4];
      arrayOfChar[j + 1] = arrayOfChar1[b & 0xF];
    } 
    return new String(arrayOfChar);
  }
  
  public static byte[] a(String paramString) {
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    try {
      byte[] arrayOfByte1 = paramString.getBytes("UTF-8");
      for (int i = 0; i < arrayOfByte.length; i++) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0x");
        int j = i * 2;
        stringBuilder.append(new String(new byte[] { arrayOfByte1[j] }, "UTF-8"));
        byte b = (byte)(Byte.decode(stringBuilder.toString()).byteValue() << 4);
        stringBuilder = new StringBuilder();
        stringBuilder.append("0x");
        stringBuilder.append(new String(new byte[] { arrayOfByte1[j + 1] }, "UTF-8"));
        arrayOfByte[i] = (byte)(b ^ Byte.decode(stringBuilder.toString()).byteValue());
      } 
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("hexString2ByteArray error");
      stringBuilder.append(unsupportedEncodingException.getMessage());
      HMSLog.e("BaseUtil", stringBuilder.toString());
    } catch (NumberFormatException numberFormatException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("hexString2ByteArray error");
      stringBuilder.append(numberFormatException.getMessage());
      HMSLog.e("BaseUtil", stringBuilder.toString());
      return arrayOfByte;
    } 
    return arrayOfByte;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\opendevice\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */