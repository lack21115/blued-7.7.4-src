package a.a.a.a.a.a.h;

import android.view.Surface;

public class h extends e {
  public Surface g;
  
  public boolean h;
  
  public h(d paramd, Surface paramSurface, boolean paramBoolean) {
    super(paramd);
    a(paramSurface);
    this.g = paramSurface;
    this.h = paramBoolean;
  }
  
  public void g() {
    c();
    Surface surface = this.g;
    if (surface != null) {
      if (this.h)
        surface.release(); 
      this.g = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\a\h\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */