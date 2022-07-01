package com.qiniu.pili.droid.streaming.processing.image.mm;

import android.content.Context;
import java.nio.ByteBuffer;

public class JNIControl {
  public static native int getOutputTexture();
  
  public static native void handlePreview(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public static native void onSurfaceChanged(int paramInt1, int paramInt2);
  
  public static native void onSurfaceCreated(Context paramContext, int paramInt);
  
  public static native void reInit();
  
  public static native void setBeautify(float paramFloat);
  
  public static native void setCurrentDirection(int paramInt);
  
  public static native void setDrawRotate180(boolean paramBoolean);
  
  public static native void setFrontCamera(boolean paramBoolean);
  
  public static native void setGLES(int paramInt);
  
  public static native void setIsPortraitDisplay(boolean paramBoolean);
  
  public static native void setRedden(float paramFloat);
  
  public static native void setSurfaceTextureID(int paramInt);
  
  public static native void setWhiten(float paramFloat);
  
  public static native boolean updateNV21Frame(ByteBuffer paramByteBuffer, int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\streaming\processing\image\mm\JNIControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */