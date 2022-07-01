package com.amap.api.mapcore2d;

public class co {
  private static byte[] a = dq.a;
  
  private static byte[] b = dq.b;
  
  private static int c = 6;
  
  public static byte[] a(byte[] paramArrayOfbyte) {
    try {
      return cv.b(a, paramArrayOfbyte, b);
    } finally {
      paramArrayOfbyte = null;
    } 
  }
  
  public static byte[] b(byte[] paramArrayOfbyte) {
    try {
      return cv.a(a, paramArrayOfbyte, b);
    } catch (Exception exception) {
      return new byte[0];
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\co.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */