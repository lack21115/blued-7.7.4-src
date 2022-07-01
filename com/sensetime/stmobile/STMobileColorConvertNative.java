package com.sensetime.stmobile;

public class STMobileColorConvertNative {
  private long colorConvertNativeHandle;
  
  static {
    System.loadLibrary("st_mobile");
    System.loadLibrary("stmobile_jni");
  }
  
  public native int createInstance();
  
  public native void destroyInstance();
  
  public native int nv12BufferToRgbaTexture(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, byte[] paramArrayOfbyte, int paramInt4);
  
  public native int nv21BufferToRgbaTexture(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, byte[] paramArrayOfbyte, int paramInt4);
  
  public native int rgbaTextureToNv12Buffer(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfbyte);
  
  public native int rgbaTextureToNv21Buffer(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfbyte);
  
  public native int setTextureSize(int paramInt1, int paramInt2);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sensetime\stmobile\STMobileColorConvertNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */