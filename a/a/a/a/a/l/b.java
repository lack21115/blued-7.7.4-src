package a.a.a.a.a.l;

import a.a.a.a.a.e.e;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.view.Surface;

public final class b {
  public int a;
  
  public int b;
  
  public int c;
  
  public MediaProjection d;
  
  public VirtualDisplay e;
  
  public b(int paramInt1, int paramInt2, int paramInt3, MediaProjection paramMediaProjection) {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramMediaProjection;
  }
  
  public void a() {
    VirtualDisplay virtualDisplay = this.e;
    if (virtualDisplay != null) {
      virtualDisplay.release();
      this.e = null;
    } 
    MediaProjection mediaProjection = this.d;
    if (mediaProjection != null)
      mediaProjection.stop(); 
  }
  
  public void a(Surface paramSurface) {
    this.e = this.d.createVirtualDisplay("ScreenRecorder-display", this.a, this.b, this.c, 16, paramSurface, null, null);
    e e = e.g;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("created virtual display: ");
    stringBuilder.append(this.e);
    e.c("ScreenRecorder", stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\l\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */