package com.huawei.secure.android.common.util;

public class EncodeUtil {
  private static final String a = EncodeUtil.class.getSimpleName();
  
  private static final char[] b = new char[] { ',', '.', '-' };
  
  private static final String[] c = new String[256];
  
  static {
    for (char c = Character.MIN_VALUE; c < 'ÿ'; c = (char)(c + 1)) {
      if ((c < '0' || c > '9') && (c < 'A' || c > 'Z') && (c < 'a' || c > 'z')) {
        c[c] = a(c).intern();
      } else {
        c[c] = null;
      } 
    } 
  }
  
  private static String a(char paramChar) {
    return Integer.toHexString(paramChar);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\commo\\util\EncodeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */