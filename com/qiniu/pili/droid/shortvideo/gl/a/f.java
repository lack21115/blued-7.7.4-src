package com.qiniu.pili.droid.shortvideo.gl.a;

import android.view.Surface;

public class f extends e {
  private Surface b;
  
  private boolean c;
  
  public f(d paramd, Surface paramSurface, boolean paramBoolean) {
    super(paramd);
    a(paramSurface);
    this.b = paramSurface;
    this.c = paramBoolean;
  }
  
  public void d() {
    a();
    Surface surface = this.b;
    if (surface != null) {
      if (this.c)
        surface.release(); 
      this.b = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\gl\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */