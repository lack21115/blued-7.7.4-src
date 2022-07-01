package org.chromium.content.common;

import android.os.IInterface;
import android.view.Surface;
import org.chromium.base.UnguessableToken;

public interface IGpuProcessCallback extends IInterface {
  void forwardSurfaceForSurfaceRequest(UnguessableToken paramUnguessableToken, Surface paramSurface);
  
  SurfaceWrapper getViewSurface(int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\common\IGpuProcessCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */