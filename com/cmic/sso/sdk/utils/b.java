package com.cmic.sso.sdk.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class b {
  private static final char[] a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
  
  private static int a(char paramChar) {
    if (paramChar >= 'A' && paramChar <= 'Z')
      return paramChar - 65; 
    if (paramChar >= 'a' && paramChar <= 'z') {
      int i = paramChar - 97;
      return i + 26;
    } 
    if (paramChar >= '0' && paramChar <= '9') {
      int i = paramChar - 48 + 26;
      return i + 26;
    } 
    if (paramChar != '+') {
      if (paramChar != '/') {
        if (paramChar == '=')
          return 0; 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unexpected code: ");
        stringBuilder.append(paramChar);
        throw new RuntimeException(stringBuilder.toString());
      } 
      return 63;
    } 
    return 62;
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    int j = paramArrayOfbyte.length;
    StringBuffer stringBuffer = new StringBuffer(paramArrayOfbyte.length * 3 / 2);
    int i = 0;
    label19: while (true) {
      int k;
      for (k = 0; i <= j - 3; k++) {
        int m = (paramArrayOfbyte[i] & 0xFF) << 16 | (paramArrayOfbyte[i + 1] & 0xFF) << 8 | paramArrayOfbyte[i + 2] & 0xFF;
        stringBuffer.append(a[m >> 18 & 0x3F]);
        stringBuffer.append(a[m >> 12 & 0x3F]);
        stringBuffer.append(a[m >> 6 & 0x3F]);
        stringBuffer.append(a[m & 0x3F]);
        i += 3;
        if (k >= 14) {
          stringBuffer.append(" ");
          continue label19;
        } 
      } 
      k = 0 + j;
      if (i == k - 2) {
        k = paramArrayOfbyte[i];
        i = (paramArrayOfbyte[i + 1] & 0xFF) << 8 | (k & 0xFF) << 16;
        stringBuffer.append(a[i >> 18 & 0x3F]);
        stringBuffer.append(a[i >> 12 & 0x3F]);
        stringBuffer.append(a[i >> 6 & 0x3F]);
        stringBuffer.append("=");
      } else if (i == k - 1) {
        i = (paramArrayOfbyte[i] & 0xFF) << 16;
        stringBuffer.append(a[i >> 18 & 0x3F]);
        stringBuffer.append(a[i >> 12 & 0x3F]);
        stringBuffer.append("==");
      } 
      return stringBuffer.toString();
    } 
  }
  
  private static void a(String paramString, OutputStream paramOutputStream) throws IOException {
    int j = paramString.length();
    for (int i = 0;; i += 4) {
      if (i < j && paramString.charAt(i) <= ' ') {
        i++;
        continue;
      } 
      if (i == j)
        return; 
      int n = a(paramString.charAt(i));
      int i1 = a(paramString.charAt(i + 1));
      int k = i + 2;
      int i2 = a(paramString.charAt(k));
      int m = i + 3;
      n = (n << 18) + (i1 << 12) + (i2 << 6) + a(paramString.charAt(m));
      paramOutputStream.write(n >> 16 & 0xFF);
      if (paramString.charAt(k) == '=')
        return; 
      paramOutputStream.write(n >> 8 & 0xFF);
      if (paramString.charAt(m) == '=')
        return; 
      paramOutputStream.write(n & 0xFF);
    } 
  }
  
  public static byte[] a(String paramString) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try {
      a(paramString, byteArrayOutputStream);
      byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
      try {
        byteArrayOutputStream.close();
        return arrayOfByte;
      } catch (IOException iOException) {
        PrintStream printStream = System.err;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Error while decoding BASE64: ");
        stringBuilder.append(iOException.toString());
        printStream.println(stringBuilder.toString());
        return arrayOfByte;
      } 
    } catch (IOException iOException) {
      throw new RuntimeException();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sd\\utils\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */