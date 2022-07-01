package com.tencent.bugly.yaq.proguard;

public final class e {
  private static final char[] a = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'A', 'B', 'C', 'D', 'E', 'F' };
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0)
      return null; 
    char[] arrayOfChar = new char[paramArrayOfbyte.length * 2];
    for (int i = 0; i < paramArrayOfbyte.length; i++) {
      byte b = paramArrayOfbyte[i];
      arrayOfChar[i * 2 + 1] = a[b & 0xF];
      b = (byte)(b >>> 4);
      arrayOfChar[i * 2] = a[b & 0xF];
    } 
    return new String(arrayOfChar);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\proguard\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */