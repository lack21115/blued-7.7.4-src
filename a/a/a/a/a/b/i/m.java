package a.a.a.a.a.b.i;

import a.a.a.a.a.a.h.f;
import android.opengl.GLES20;

public class m extends g {
  public int b;
  
  public int c;
  
  public boolean a(int paramInt1, int paramInt2) {
    m();
    return (super.a(paramInt1, paramInt2) && b(paramInt1, paramInt2));
  }
  
  public int b(int paramInt, float[] paramArrayOffloat) {
    GLES20.glBindFramebuffer(36160, this.b);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.c, 0);
    a(paramInt, paramArrayOffloat);
    GLES20.glBindFramebuffer(36160, 0);
    return this.c;
  }
  
  public final boolean b(int paramInt1, int paramInt2) {
    this.c = f.a(null, paramInt1, paramInt2, 6408);
    return true;
  }
  
  public int d(int paramInt) {
    return b(paramInt, (float[])null);
  }
  
  public void g() {
    super.g();
    int i = this.b;
    if (i != 0) {
      GLES20.glDeleteFramebuffers(1, new int[] { i }, 0);
      this.b = 0;
    } 
    i = this.c;
    if (i != 0) {
      GLES20.glDeleteTextures(1, new int[] { i }, 0);
      this.c = 0;
    } 
  }
  
  public final void m() {
    this.b = f.c();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\b\i\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */