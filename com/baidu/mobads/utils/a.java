package com.baidu.mobads.utils;

import android.text.TextUtils;
import com.baidu.mobads.interfaces.utils.IBase64;

public class a implements IBase64 {
  private static final byte[] a = new byte[] { 
      48, 75, 97, 106, 68, 55, 65, 90, 99, 70, 
      50, 81, 110, 80, 114, 53, 102, 119, 105, 72, 
      82, 78, 121, 103, 109, 117, 112, 85, 84, 73, 
      88, 120, 54, 57, 66, 87, 98, 45, 104, 77, 
      67, 71, 74, 111, 95, 86, 56, 69, 115, 107, 
      122, 49, 89, 100, 118, 76, 51, 52, 108, 101, 
      116, 113, 83, 79 };
  
  private static final byte[] b = new byte[128];
  
  static {
    int i = 0;
    while (true) {
      byte[] arrayOfByte = a;
      if (i < arrayOfByte.length) {
        b[arrayOfByte[i]] = (byte)i;
        i++;
        continue;
      } 
      break;
    } 
  }
  
  private boolean a(byte paramByte) {
    return (paramByte == 36) ? true : ((paramByte >= 0) ? ((paramByte >= 128) ? false : (!(b[paramByte] == -1))) : false);
  }
  
  private byte[] a(String paramString) {
    if (b(paramString))
      return null; 
    if (paramString != null) {
      byte[] arrayOfByte;
      if (paramString.length() < 4)
        return null; 
      if (paramString.charAt(paramString.length() - 2) == '$') {
        arrayOfByte = new byte[(paramString.length() / 4 - 1) * 3 + 1];
      } else if (paramString.charAt(paramString.length() - 1) == '$') {
        arrayOfByte = new byte[(paramString.length() / 4 - 1) * 3 + 2];
      } else {
        arrayOfByte = new byte[paramString.length() / 4 * 3];
      } 
      int j = 0;
      int i;
      for (i = 0; j < paramString.length() - 4; i += 3) {
        byte b3 = b[paramString.charAt(j)];
        byte b4 = b[paramString.charAt(j + 1)];
        byte b5 = b[paramString.charAt(j + 2)];
        byte b6 = b[paramString.charAt(j + 3)];
        arrayOfByte[i] = (byte)(b3 << 2 | b4 >> 4);
        arrayOfByte[i + 1] = (byte)(b4 << 4 | b5 >> 2);
        arrayOfByte[i + 2] = (byte)(b5 << 6 | b6);
        j += 4;
      } 
      if (paramString.charAt(paramString.length() - 2) == '$') {
        i = b[paramString.charAt(paramString.length() - 4)];
        j = b[paramString.charAt(paramString.length() - 3)];
        arrayOfByte[arrayOfByte.length - 1] = (byte)(j >> 4 | i << 2);
        return arrayOfByte;
      } 
      if (paramString.charAt(paramString.length() - 1) == '$') {
        i = b[paramString.charAt(paramString.length() - 4)];
        j = b[paramString.charAt(paramString.length() - 3)];
        byte b = b[paramString.charAt(paramString.length() - 2)];
        arrayOfByte[arrayOfByte.length - 2] = (byte)(i << 2 | j >> 4);
        arrayOfByte[arrayOfByte.length - 1] = (byte)(b >> 2 | j << 4);
        return arrayOfByte;
      } 
      i = b[paramString.charAt(paramString.length() - 4)];
      j = b[paramString.charAt(paramString.length() - 3)];
      byte b1 = b[paramString.charAt(paramString.length() - 2)];
      byte b2 = b[paramString.charAt(paramString.length() - 1)];
      arrayOfByte[arrayOfByte.length - 3] = (byte)(i << 2 | j >> 4);
      arrayOfByte[arrayOfByte.length - 2] = (byte)(j << 4 | b1 >> 2);
      arrayOfByte[arrayOfByte.length - 1] = (byte)(b2 | b1 << 6);
      return arrayOfByte;
    } 
    return null;
  }
  
  private boolean b(String paramString) {
    if (paramString == null)
      return true; 
    for (int i = 0; i < paramString.length(); i++) {
      if (!a((byte)paramString.charAt(i)))
        return true; 
    } 
    return false;
  }
  
  public String decodeStr(String paramString) {
    if (paramString == null || paramString.length() < 4)
      return null; 
    try {
      for (paramString = new String(a(paramString)); paramString.endsWith("$"); paramString = paramString.substring(0, paramString.length() - 1));
      return paramString;
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public String encode(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return ""; 
    int i;
    for (i = (paramString.getBytes()).length % 3; i > 0 && i < 3; i++) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append("$");
      paramString = stringBuilder.toString();
    } 
    byte[] arrayOfByte1 = paramString.getBytes();
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length / 3 * 4];
    int j = 0;
    for (i = 0; j < arrayOfByte1.length; i += 4) {
      byte[] arrayOfByte = a;
      arrayOfByte2[i] = arrayOfByte[(arrayOfByte1[j] & 0xFC) >> 2];
      byte b = arrayOfByte1[j];
      int k = j + 1;
      arrayOfByte2[i + 1] = arrayOfByte[((b & 0x3) << 4) + ((arrayOfByte1[k] & 0xF0) >> 4)];
      b = arrayOfByte1[k];
      k = j + 2;
      arrayOfByte2[i + 2] = arrayOfByte[((b & 0xF) << 2) + ((arrayOfByte1[k] & 0xC0) >> 6)];
      arrayOfByte2[i + 3] = arrayOfByte[arrayOfByte1[k] & 0x3F];
      j += 3;
    } 
    return new String(arrayOfByte2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\\utils\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */