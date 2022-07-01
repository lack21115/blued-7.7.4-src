package com.qiniu.pili.droid.beauty;

import android.content.Context;

public class JNIControl {
  public static native int getOutputTexture();
  
  public static native void onSurfaceChanged(int paramInt1, int paramInt2);
  
  public static native void onSurfaceCreated(Context paramContext, int paramInt);
  
  public static native void processThrough(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public static native void reInit();
  
  public static native void setBeautify(float paramFloat);
  
  public static native void setCurrentDirection(int paramInt);
  
  public static native void setGLES(int paramInt);
  
  public static native void setIsPortraitDisplay(boolean paramBoolean);
  
  public static native void setRedden(float paramFloat);
  
  public static native void setSurfaceTextureID(int paramInt);
  
  public static native void setWhiten(float paramFloat);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\beauty\JNIControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */