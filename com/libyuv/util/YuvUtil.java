package com.libyuv.util;

public class YuvUtil {
  static {
    System.loadLibrary("yuvutil");
  }
  
  public static native void compressYUV(byte[] paramArrayOfbyte1, int paramInt1, int paramInt2, byte[] paramArrayOfbyte2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean);
  
  public static native void cropYUV(byte[] paramArrayOfbyte1, int paramInt1, int paramInt2, byte[] paramArrayOfbyte2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  public static native void init(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public static native void yuvI420ToNV21(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, int paramInt1, int paramInt2);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\libyu\\util\YuvUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */