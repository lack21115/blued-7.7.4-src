package com.heytap.mcssdk.utils;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class CryptoUtil {
  private static String a() {
    byte[] arrayOfByte = a(a("com.nearme.mcs"));
    return (arrayOfByte != null) ? new String(arrayOfByte, Charset.forName("UTF-8")) : "";
  }
  
  public static byte[] a(String paramString) {
    if (paramString == null)
      return new byte[0]; 
    try {
      return paramString.getBytes("UTF-8");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      return new byte[0];
    } 
  }
  
  public static byte[] a(byte[] paramArrayOfbyte) {
    int i;
    if (paramArrayOfbyte.length % 2 == 0) {
      i = paramArrayOfbyte.length;
    } else {
      i = paramArrayOfbyte.length - 1;
    } 
    for (int j = 0; j < i; j += 2) {
      byte b = paramArrayOfbyte[j];
      int k = j + 1;
      paramArrayOfbyte[j] = paramArrayOfbyte[k];
      paramArrayOfbyte[k] = b;
    } 
    return paramArrayOfbyte;
  }
  
  public static String b(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      try {
        return DESUtil.a(paramString, a());
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder("desDecrypt-");
        stringBuilder.append(exception.getMessage());
        LogUtil.b(stringBuilder.toString());
      }  
    return "";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\heytap\mcssd\\utils\CryptoUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */