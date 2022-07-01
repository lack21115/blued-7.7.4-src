package com.qiniu.android.utils;

import android.util.Base64;
import java.io.UnsupportedEncodingException;

public final class UrlSafeBase64 {
  public static byte[] decode(String paramString) {
    return Base64.decode(paramString, 10);
  }
  
  public static String encodeToString(String paramString) {
    try {
      return encodeToString(paramString.getBytes("utf-8"));
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      unsupportedEncodingException.printStackTrace();
      return null;
    } 
  }
  
  public static String encodeToString(byte[] paramArrayOfbyte) {
    return Base64.encodeToString(paramArrayOfbyte, 10);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\androi\\utils\UrlSafeBase64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */