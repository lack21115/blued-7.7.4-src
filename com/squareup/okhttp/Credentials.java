package com.squareup.okhttp;

import java.io.UnsupportedEncodingException;
import okio.ByteString;

public final class Credentials {
  public static String basic(String paramString1, String paramString2) {
    try {
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(paramString1);
      stringBuilder2.append(":");
      stringBuilder2.append(paramString2);
      paramString1 = ByteString.of(stringBuilder2.toString().getBytes("ISO-8859-1")).base64();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Basic ");
      stringBuilder1.append(paramString1);
      return stringBuilder1.toString();
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new AssertionError();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\Credentials.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */