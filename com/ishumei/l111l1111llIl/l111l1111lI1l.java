package com.ishumei.l111l1111llIl;

import android.text.TextUtils;
import java.util.Locale;
import java.util.Random;

public final class l111l1111lI1l {
  public static String l1111l111111Il() {
    return String.format(Locale.CHINA, "%d-%05d", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf((new Random()).nextInt(100000)) });
  }
  
  private static String l1111l111111Il(int paramInt) {
    char[] arrayOfChar = new char[paramInt];
    Random random = new Random();
    for (int i = 0; i < paramInt; i++)
      arrayOfChar[i] = (char)(random.nextInt(26) + 97); 
    return new String(arrayOfChar);
  }
  
  private static String l1111l111111Il(byte[] paramArrayOfbyte) {
    StringBuilder stringBuilder = new StringBuilder(paramArrayOfbyte.length << 1);
    int j = paramArrayOfbyte.length;
    for (int i = 0; i < j; i++) {
      int k = paramArrayOfbyte[i];
      while (k < 0)
        k = k + 256; 
      if (k < 16)
        stringBuilder.append("0"); 
      stringBuilder.append(Integer.toString(k, 16));
    } 
    return stringBuilder.toString();
  }
  
  public static boolean l1111l111111Il(String paramString) {
    return (paramString == null || paramString.isEmpty());
  }
  
  public static boolean l1111l111111Il(String paramString1, String paramString2) {
    return TextUtils.equals(paramString1, paramString2);
  }
  
  public static boolean l111l11111I1l(String paramString) {
    if (paramString == null) {
      paramString = null;
    } else {
      paramString = paramString.trim();
    } 
    return l1111l111111Il(paramString);
  }
  
  public static String l111l11111Il(String paramString) {
    return new String(l111l11111lIl(l111l1111lIl(paramString)));
  }
  
  public static boolean l111l11111lIl(String paramString) {
    return !l1111l111111Il(paramString);
  }
  
  private static byte[] l111l11111lIl(byte[] paramArrayOfbyte) {
    byte[] arrayOfByte = new byte[paramArrayOfbyte.length];
    for (int i = 0; i < paramArrayOfbyte.length; i++)
      arrayOfByte[i] = (byte)paramArrayOfbyte[i]; 
    return arrayOfByte;
  }
  
  private static String l111l1111l1Il(String paramString) {
    return (paramString == null) ? null : paramString.trim();
  }
  
  private static String l111l1111lI1l(String paramString) {
    String str = paramString;
    if (paramString == null)
      str = ""; 
    return str;
  }
  
  private static byte[] l111l1111lIl(String paramString) {
    byte[] arrayOfByte1 = paramString.getBytes();
    int j = arrayOfByte1.length;
    byte[] arrayOfByte2 = new byte[j / 2];
    for (int i = 0; i < j; i += 2) {
      String str = new String(arrayOfByte1, i, 2);
      arrayOfByte2[i / 2] = (byte)Integer.parseInt(str, 16);
    } 
    return arrayOfByte2;
  }
  
  private static boolean l111l1111llIl(String paramString) {
    return !l111l11111I1l(paramString);
  }
  
  private static String l11l1111lIIl(String paramString) {
    byte[] arrayOfByte = l111l11111lIl(paramString.getBytes());
    StringBuilder stringBuilder = new StringBuilder(arrayOfByte.length << 1);
    int j = arrayOfByte.length;
    for (int i = 0; i < j; i++) {
      int k = arrayOfByte[i];
      while (k < 0)
        k = k + 256; 
      if (k < 16)
        stringBuilder.append("0"); 
      stringBuilder.append(Integer.toString(k, 16));
    } 
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l1111llIl\l111l1111lI1l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */