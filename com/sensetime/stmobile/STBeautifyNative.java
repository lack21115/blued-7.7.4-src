package com.sensetime.stmobile;

import com.sensetime.stmobile.model.STHumanAction;

public class STBeautifyNative {
  private long nativeHandle;
  
  static {
    System.loadLibrary("st_mobile");
    System.loadLibrary("stmobile_jni");
  }
  
  public native int createInstance();
  
  public native void destroyBeautify();
  
  public native int processBufferInGLContext(byte[] paramArrayOfbyte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, STHumanAction paramSTHumanAction1, byte[] paramArrayOfbyte2, int paramInt5, STHumanAction paramSTHumanAction2);
  
  public native int processBufferNotInGLContext(byte[] paramArrayOfbyte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, STHumanAction paramSTHumanAction1, byte[] paramArrayOfbyte2, int paramInt5, STHumanAction paramSTHumanAction2);
  
  public native int processTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4, STHumanAction paramSTHumanAction1, int paramInt5, STHumanAction paramSTHumanAction2);
  
  public native int processTextureAndOutputBuffer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, STHumanAction paramSTHumanAction1, int paramInt5, byte[] paramArrayOfbyte, int paramInt6, STHumanAction paramSTHumanAction2);
  
  public native int setParam(int paramInt, float paramFloat);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sensetime\stmobile\STBeautifyNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */