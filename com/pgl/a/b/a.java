package com.pgl.a.b;

public class a {
  public static String a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null)
      return null; 
    char[] arrayOfChar1 = "0123456789abcdef".toCharArray();
    char[] arrayOfChar2 = new char[paramArrayOfbyte.length * 2];
    for (int i = 0; i < paramArrayOfbyte.length; i++) {
      int j = paramArrayOfbyte[i] & 0xFF;
      int k = i * 2;
      arrayOfChar2[k] = arrayOfChar1[j >>> 4];
      arrayOfChar2[k + 1] = arrayOfChar1[j & 0xF];
    } 
    return new String(arrayOfChar2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\pgl\a\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */