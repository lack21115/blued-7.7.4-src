package org.chromium.ui.gl;

import android.graphics.SurfaceTexture;

class SurfaceTextureListener implements SurfaceTexture.OnFrameAvailableListener {
  private final long mNativeSurfaceTextureListener;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  SurfaceTextureListener(long paramLong) {
    assert false;
    throw new AssertionError();
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void nativeFrameAvailable(long paramLong);
  
  protected void finalize() {
    try {
      nativeDestroy(this.mNativeSurfaceTextureListener);
      return;
    } finally {
      super.finalize();
    } 
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture) {
    nativeFrameAvailable(this.mNativeSurfaceTextureListener);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\gl\SurfaceTextureListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */