package com.sensetime.stmobile;

import com.sensetime.stmobile.model.STRect;

public class STMobileObjectTrackNative {
  private long objectTrackNativeHandle;
  
  public native int createInstance();
  
  public native void destroyInstance();
  
  public native STRect objectTrack(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOffloat);
  
  public native void reset();
  
  public native int setTarget(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, STRect paramSTRect);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sensetime\stmobile\STMobileObjectTrackNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */