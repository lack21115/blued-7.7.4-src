package com.blued.android.module.external_sense_library.encoder;

import android.opengl.EGLContext;
import android.view.Surface;
import com.blued.android.module.external_sense_library.encoder.utils.RenderHandler;

public class MediaVideoEncoder extends MediaEncoder {
  protected static int[] j = new int[] { 2130708361 };
  
  private RenderHandler k;
  
  private Surface l;
  
  protected void a() {
    Surface surface = this.l;
    if (surface != null) {
      surface.release();
      this.l = null;
    } 
    RenderHandler renderHandler = this.k;
    if (renderHandler != null) {
      renderHandler.a();
      this.k = null;
    } 
    super.a();
  }
  
  public void a(EGLContext paramEGLContext, int paramInt) {
    this.k.a(paramEGLContext, paramInt, this.l, true);
  }
  
  public boolean a(float[] paramArrayOffloat) {
    boolean bool = super.c();
    if (bool)
      this.k.a(paramArrayOffloat); 
    return bool;
  }
  
  public boolean c() {
    boolean bool = super.c();
    if (bool)
      this.k.a(null); 
    return bool;
  }
  
  protected void d() {
    this.g.signalEndOfInputStream();
    this.d = true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\encoder\MediaVideoEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */