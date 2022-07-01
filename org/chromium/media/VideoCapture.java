package org.chromium.media;

import android.view.WindowManager;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.CalledByNative;

public abstract class VideoCapture {
  protected int mCameraNativeOrientation;
  
  protected VideoCaptureFormat mCaptureFormat;
  
  protected final int mId;
  
  protected boolean mInvertDeviceOrientationReadings;
  
  protected final long mNativeVideoCaptureDeviceAndroid;
  
  protected boolean mUseBackgroundThreadForTesting;
  
  VideoCapture(int paramInt, long paramLong) {
    this.mId = paramInt;
    this.mNativeVideoCaptureDeviceAndroid = paramLong;
  }
  
  protected static VideoCapture$FramerateRange getClosestFramerateRange(List<? extends VideoCapture$FramerateRange> paramList, int paramInt) {
    return Collections.<VideoCapture$FramerateRange>min(paramList, new VideoCapture$1(paramInt));
  }
  
  protected static int getDeviceRotation() {
    switch (((WindowManager)ContextUtils.sApplicationContext.getSystemService("window")).getDefaultDisplay().getRotation()) {
      default:
        return 0;
      case 3:
        return 270;
      case 2:
        return 180;
      case 1:
        break;
    } 
    return 90;
  }
  
  protected static int[] integerArrayListToArray(ArrayList paramArrayList) {
    int[] arrayOfInt = new int[paramArrayList.size()];
    for (int i = 0; i < paramArrayList.size(); i++)
      arrayOfInt[i] = ((Integer)paramArrayList.get(i)).intValue(); 
    return arrayOfInt;
  }
  
  @CalledByNative
  public abstract boolean allocate(int paramInt1, int paramInt2, int paramInt3);
  
  @CalledByNative
  public abstract void deallocate();
  
  protected final int getCameraRotation() {
    int i;
    if (this.mInvertDeviceOrientationReadings) {
      i = 360 - getDeviceRotation();
    } else {
      i = getDeviceRotation();
    } 
    return (this.mCameraNativeOrientation + i) % 360;
  }
  
  @CalledByNative
  public final int getColorspace() {
    int i = this.mCaptureFormat.mPixelFormat;
    return (i != 17) ? ((i != 35) ? ((i != 842094169) ? 0 : 842094169) : 35) : 17;
  }
  
  @CalledByNative
  public abstract PhotoCapabilities getPhotoCapabilities();
  
  public native void nativeOnError(long paramLong, String paramString);
  
  public native void nativeOnFrameAvailable(long paramLong, byte[] paramArrayOfbyte, int paramInt1, int paramInt2);
  
  public native void nativeOnI420FrameAvailable(long paramLong1, ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, ByteBuffer paramByteBuffer3, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong2);
  
  public native void nativeOnPhotoTaken(long paramLong1, long paramLong2, byte[] paramArrayOfbyte);
  
  public native void nativeOnStarted(long paramLong);
  
  @CalledByNative
  public final int queryFrameRate() {
    return this.mCaptureFormat.mFramerate;
  }
  
  @CalledByNative
  public final int queryHeight() {
    return this.mCaptureFormat.mHeight;
  }
  
  @CalledByNative
  public final int queryWidth() {
    return this.mCaptureFormat.mWidth;
  }
  
  @CalledByNative
  public abstract void setPhotoOptions(double paramDouble1, int paramInt1, int paramInt2, double paramDouble2, double paramDouble3, float[] paramArrayOffloat, boolean paramBoolean1, double paramDouble4, int paramInt3, double paramDouble5, boolean paramBoolean2, boolean paramBoolean3, int paramInt4, boolean paramBoolean4, boolean paramBoolean5, double paramDouble6);
  
  @CalledByNative
  public final void setTestMode() {
    this.mUseBackgroundThreadForTesting = true;
  }
  
  @CalledByNative
  public abstract boolean startCapture();
  
  @CalledByNative
  public abstract boolean stopCapture();
  
  @CalledByNative
  public abstract boolean takePhoto(long paramLong);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\VideoCapture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */