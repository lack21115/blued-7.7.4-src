package com.facebook.stetho.common;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class Utf8Charset {
  public static final Charset INSTANCE = Charset.forName("UTF-8");
  
  public static final String NAME = "UTF-8";
  
  public static String decodeUTF8(byte[] paramArrayOfbyte) {
    return new String(paramArrayOfbyte, INSTANCE);
  }
  
  public static byte[] encodeUTF8(String paramString) {
    try {
      return paramString.getBytes("UTF-8");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new RuntimeException(unsupportedEncodingException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\common\Utf8Charset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */