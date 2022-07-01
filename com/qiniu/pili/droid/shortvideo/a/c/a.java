package com.qiniu.pili.droid.shortvideo.a.c;

import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.f.e;

public final class a {
  private int a;
  
  private int b;
  
  private int c;
  
  private MediaProjection d;
  
  private VirtualDisplay e;
  
  public a(int paramInt1, int paramInt2, int paramInt3, MediaProjection paramMediaProjection) {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramMediaProjection;
  }
  
  public void a() {
    VirtualDisplay virtualDisplay = this.e;
    if (virtualDisplay != null)
      virtualDisplay.release(); 
    MediaProjection mediaProjection = this.d;
    if (mediaProjection != null)
      mediaProjection.stop(); 
  }
  
  public void a(Surface paramSurface) {
    this.e = this.d.createVirtualDisplay("ScreenRecorder-display", this.a, this.b, this.c, 16, paramSurface, null, null);
    e e = e.f;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("created virtual display: ");
    stringBuilder.append(this.e);
    e.c("ScreenRecorder", stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\a\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */