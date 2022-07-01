package org.chromium.ui.gl;

import android.graphics.SurfaceTexture;
import android.util.Log;
import org.chromium.base.annotations.CalledByNative;

class SurfaceTexturePlatformWrapper {
  @CalledByNative
  private static void attachToGLContext(SurfaceTexture paramSurfaceTexture, int paramInt) {
    paramSurfaceTexture.attachToGLContext(paramInt);
  }
  
  @CalledByNative
  private static SurfaceTexture create(int paramInt) {
    return new SurfaceTexture(paramInt);
  }
  
  @CalledByNative
  private static void destroy(SurfaceTexture paramSurfaceTexture) {
    paramSurfaceTexture.setOnFrameAvailableListener(null);
    paramSurfaceTexture.release();
  }
  
  @CalledByNative
  private static void detachFromGLContext(SurfaceTexture paramSurfaceTexture) {
    paramSurfaceTexture.detachFromGLContext();
  }
  
  @CalledByNative
  private static void getTransformMatrix(SurfaceTexture paramSurfaceTexture, float[] paramArrayOffloat) {
    paramSurfaceTexture.getTransformMatrix(paramArrayOffloat);
  }
  
  @CalledByNative
  private static void release(SurfaceTexture paramSurfaceTexture) {
    paramSurfaceTexture.release();
  }
  
  @CalledByNative
  private static void setDefaultBufferSize(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {
    paramSurfaceTexture.setDefaultBufferSize(paramInt1, paramInt2);
  }
  
  @CalledByNative
  private static void setFrameAvailableCallback(SurfaceTexture paramSurfaceTexture, long paramLong) {
    paramSurfaceTexture.setOnFrameAvailableListener(new SurfaceTextureListener(paramLong));
  }
  
  @CalledByNative
  private static void updateTexImage(SurfaceTexture paramSurfaceTexture) {
    try {
      paramSurfaceTexture.updateTexImage();
      return;
    } catch (RuntimeException runtimeException) {
      Log.e("SurfaceTexturePlatformWrapper", "Error calling updateTexImage", runtimeException);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\gl\SurfaceTexturePlatformWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */