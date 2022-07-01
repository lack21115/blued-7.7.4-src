package org.chromium.content.browser;

import android.view.Surface;
import org.chromium.base.UnguessableToken;
import org.chromium.content.common.IGpuProcessCallback;
import org.chromium.content.common.SurfaceWrapper;

class GpuProcessCallback extends IGpuProcessCallback.Stub {
  private static native void nativeCompleteScopedSurfaceRequest(UnguessableToken paramUnguessableToken, Surface paramSurface);
  
  private static native Surface nativeGetViewSurface(int paramInt);
  
  public final void forwardSurfaceForSurfaceRequest(UnguessableToken paramUnguessableToken, Surface paramSurface) {
    nativeCompleteScopedSurfaceRequest(paramUnguessableToken, paramSurface);
  }
  
  public final SurfaceWrapper getViewSurface(int paramInt) {
    Surface surface = nativeGetViewSurface(paramInt);
    return (surface == null) ? null : new SurfaceWrapper(surface);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\GpuProcessCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */