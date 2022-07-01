package com.bytedance.embedapplog.util;

public class TTEncryptUtils {
  static {
    try {
      System.loadLibrary("tobEmbedEncrypt");
      return;
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      h.a(unsatisfiedLinkError);
      return;
    } 
  }
  
  public static byte[] a(byte[] paramArrayOfbyte, int paramInt) {
    try {
      return ttEncrypt(paramArrayOfbyte, paramInt);
    } finally {
      paramArrayOfbyte = null;
    } 
  }
  
  public static byte[] b(byte[] paramArrayOfbyte, int paramInt) {
    try {
      return ttDecrypt(paramArrayOfbyte, paramInt);
    } finally {
      paramArrayOfbyte = null;
    } 
  }
  
  private static native byte[] ttDecrypt(byte[] paramArrayOfbyte, int paramInt);
  
  private static native byte[] ttEncrypt(byte[] paramArrayOfbyte, int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplo\\util\TTEncryptUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */