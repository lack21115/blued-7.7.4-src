package com.datavisor.vangogh.bridge;

public class crypto {
  public static native byte[] a2d(byte[] paramArrayOfbyte);
  
  public static native String convert(String paramString);
  
  public static native byte[] d2a(byte[] paramArrayOfbyte);
  
  public static native byte[] decrypt(byte[] paramArrayOfbyte);
  
  public static native byte[] decryptL(byte[] paramArrayOfbyte, String paramString1, String paramString2);
  
  public static native byte[] decryptV(byte[] paramArrayOfbyte);
  
  public static native byte[] encrypt(byte[] paramArrayOfbyte);
  
  public static native byte[] encryptL(byte[] paramArrayOfbyte, String paramString1, String paramString2);
  
  public static native byte[] encryptV(byte[] paramArrayOfbyte);
  
  public static native byte[] encryptVV(String paramString, int paramInt);
  
  public static native long geti(String paramString);
  
  public static native byte[] reduce(byte[] paramArrayOfbyte);
  
  public static native byte[] sign(byte[] paramArrayOfbyte);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\datavisor\vangogh\bridge\crypto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */