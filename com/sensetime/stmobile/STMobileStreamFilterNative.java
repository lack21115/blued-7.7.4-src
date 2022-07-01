package com.sensetime.stmobile;

public class STMobileStreamFilterNative {
  private long nativeHandle;
  
  public native int createInstance();
  
  public native void destroyInstance();
  
  public native int processBuffer(byte[] paramArrayOfbyte1, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfbyte2, int paramInt4);
  
  public native int processTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native int processTextureAndOutputBuffer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfbyte, int paramInt5);
  
  public native int setParam(int paramInt, float paramFloat);
  
  public native int setStyle(String paramString);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sensetime\stmobile\STMobileStreamFilterNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */