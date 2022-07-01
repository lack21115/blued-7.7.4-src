package com.tencent.bugly.proguard;

public final class e {
  private static final char[] a = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'A', 'B', 'C', 'D', 'E', 'F' };
  
  public static String a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0)
      return null; 
    char[] arrayOfChar = new char[paramArrayOfbyte.length * 2];
    for (int i = 0; i < paramArrayOfbyte.length; i++) {
      byte b = paramArrayOfbyte[i];
      int j = i * 2;
      char[] arrayOfChar1 = a;
      arrayOfChar[j + 1] = arrayOfChar1[b & 0xF];
      arrayOfChar[j] = arrayOfChar1[(byte)(b >>> 4) & 0xF];
    } 
    return new String(arrayOfChar);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\proguard\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */