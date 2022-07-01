package com.huawei.secure.android.common.encrypt.utils;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public final class HexUtil {
  public static String a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < paramArrayOfbyte.length; i++) {
      String str = Integer.toHexString(paramArrayOfbyte[i] & 0xFF);
      if (str.length() == 1)
        stringBuilder.append('0'); 
      stringBuilder.append(str);
    } 
    return stringBuilder.toString();
  }
  
  public static byte[] a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return new byte[0]; 
    paramString = paramString.toUpperCase(Locale.ENGLISH);
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
      stringBuilder.append("hex string 2 byte array exception : ");
      stringBuilder.append(unsupportedEncodingException.getMessage());
      b.c("HexUtil", stringBuilder.toString());
    } catch (NumberFormatException numberFormatException) {}
    return arrayOfByte;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\common\encryp\\utils\HexUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */