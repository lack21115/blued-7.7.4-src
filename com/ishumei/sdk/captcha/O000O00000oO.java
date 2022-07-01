package com.ishumei.sdk.captcha;

import android.text.TextUtils;
import java.util.Random;

public class O000O00000oO {
  public static String O0000O000000oO(int paramInt) {
    char[] arrayOfChar = new char[paramInt];
    Random random = new Random();
    for (int i = 0; i < paramInt; i++)
      arrayOfChar[i] = (char)(random.nextInt(26) + 97); 
    return new String(arrayOfChar);
  }
  
  public static String O0000O000000oO(String paramString) {
    return new String(O0000O000000oO(O000O00000o0O(paramString)));
  }
  
  public static boolean O0000O000000oO(String paramString1, String paramString2) {
    return TextUtils.equals(paramString1, paramString2);
  }
  
  public static byte[] O0000O000000oO(byte[] paramArrayOfbyte) {
    byte[] arrayOfByte = new byte[paramArrayOfbyte.length];
    for (int i = 0; i < paramArrayOfbyte.length; i++)
      arrayOfByte[i] = (byte)paramArrayOfbyte[i]; 
    return arrayOfByte;
  }
  
  public static boolean O000O00000OoO(String paramString) {
    return (paramString == null) ? true : paramString.isEmpty();
  }
  
  public static byte[] O000O00000o0O(String paramString) {
    byte[] arrayOfByte1 = paramString.getBytes();
    int j = arrayOfByte1.length;
    byte[] arrayOfByte2 = new byte[j / 2];
    for (int i = 0; i < j; i += 2) {
      String str = new String(arrayOfByte1, i, 2);
      arrayOfByte2[i / 2] = (byte)Integer.parseInt(str, 16);
    } 
    return arrayOfByte2;
  }
  
  public static boolean O000O00000oO(String paramString) {
    return O000O00000OoO(paramString) ^ true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\sdk\captcha\O000O00000oO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */