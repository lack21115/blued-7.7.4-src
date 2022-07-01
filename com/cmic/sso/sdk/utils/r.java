package com.cmic.sso.sdk.utils;

import java.util.Locale;

class r {
  private static char[] a = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'A', 'B', 'C', 'D', 'E', 'F' };
  
  static String a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder(paramArrayOfbyte.length * 2);
    int j = paramArrayOfbyte.length;
    for (int i = 0; i < j; i++) {
      byte b = paramArrayOfbyte[i];
      stringBuilder.append(a[b >>> 4 & 0xF]);
      stringBuilder.append(a[b & 0xF]);
    } 
    return stringBuilder.toString().toUpperCase(Locale.getDefault());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sd\\utils\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */