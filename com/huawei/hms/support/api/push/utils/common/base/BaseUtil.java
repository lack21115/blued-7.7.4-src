package com.huawei.hms.support.api.push.utils.common.base;

import java.nio.charset.Charset;

public abstract class BaseUtil {
  public static final char[] HEX_DIGITS = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'A', 'B', 'C', 'D', 'E', 'F' };
  
  public static String byte2HexString(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null)
      return null; 
    if (paramArrayOfbyte.length == 0)
      return ""; 
    char[] arrayOfChar = new char[paramArrayOfbyte.length * 2];
    for (int i = 0; i < paramArrayOfbyte.length; i++) {
      byte b = paramArrayOfbyte[i];
      int j = i * 2;
      char[] arrayOfChar1 = HEX_DIGITS;
      arrayOfChar[j] = arrayOfChar1[(b & 0xF0) >> 4];
      arrayOfChar[j + 1] = arrayOfChar1[b & 0xF];
    } 
    return new String(arrayOfChar);
  }
  
  public static String byte2Str(byte[] paramArrayOfbyte) {
    return (paramArrayOfbyte == null) ? "" : new String(paramArrayOfbyte, PushConst.UTF_8);
  }
  
  public static byte[] hexString2ByteArray(String paramString) {
    byte[] arrayOfByte2 = new byte[paramString.length() / 2];
    byte[] arrayOfByte1 = paramString.getBytes(PushConst.UTF_8);
    for (int i = 0; i < arrayOfByte2.length; i++) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("0x");
      int j = i * 2;
      byte b1 = arrayOfByte1[j];
      Charset charset = PushConst.UTF_8;
      stringBuilder.append(new String(new byte[] { b1 }, charset));
      byte b2 = (byte)(Byte.decode(stringBuilder.toString()).byteValue() << 4);
      stringBuilder = new StringBuilder();
      stringBuilder.append("0x");
      b1 = arrayOfByte1[j + 1];
      charset = PushConst.UTF_8;
      stringBuilder.append(new String(new byte[] { b1 }, charset));
      arrayOfByte2[i] = (byte)(b2 ^ Byte.decode(stringBuilder.toString()).byteValue());
    } 
    return arrayOfByte2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\pus\\utils\common\base\BaseUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */