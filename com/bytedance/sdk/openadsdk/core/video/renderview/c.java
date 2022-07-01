package com.bytedance.sdk.openadsdk.core.video.renderview;

import android.view.SurfaceHolder;
import java.lang.ref.WeakReference;

public class c implements SurfaceHolder.Callback {
  private final WeakReference<SurfaceHolder.Callback> a;
  
  public c(SurfaceHolder.Callback paramCallback) {
    this.a = new WeakReference<SurfaceHolder.Callback>(paramCallback);
  }
  
  public SurfaceHolder.Callback a() {
    return this.a.get();
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {
    SurfaceHolder.Callback callback = this.a.get();
    if (callback != null)
      callback.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3); 
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder) {
    SurfaceHolder.Callback callback = this.a.get();
    if (callback != null)
      callback.surfaceCreated(paramSurfaceHolder); 
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder) {
    SurfaceHolder.Callback callback = this.a.get();
    if (callback != null)
      callback.surfaceDestroyed(paramSurfaceHolder); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\video\renderview\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */