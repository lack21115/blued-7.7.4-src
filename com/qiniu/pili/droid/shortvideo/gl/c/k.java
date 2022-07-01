package com.qiniu.pili.droid.shortvideo.gl.c;

import android.opengl.GLES20;
import com.qiniu.pili.droid.shortvideo.f.d;

public class k extends g {
  protected int a;
  
  protected int b;
  
  private boolean b(int paramInt1, int paramInt2) {
    this.b = d.a(null, paramInt1, paramInt2, 6408);
    return true;
  }
  
  private void h() {
    int i = this.b;
    if (i != 0) {
      GLES20.glDeleteTextures(1, new int[] { i }, 0);
      this.b = 0;
    } 
  }
  
  private void t() {
    this.a = d.e();
  }
  
  public int a(int paramInt) {
    return b(paramInt, (float[])null);
  }
  
  public int a(int paramInt1, float[] paramArrayOffloat, int paramInt2, int paramInt3) {
    GLES20.glBindFramebuffer(36160, this.a);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt2, 0);
    GLES20.glClear(16384);
    a(paramInt1, paramArrayOffloat, paramInt3);
    GLES20.glBindFramebuffer(36160, 0);
    return paramInt2;
  }
  
  public boolean a(int paramInt1, int paramInt2) {
    super.a(paramInt1, paramInt2);
    h();
    return b(paramInt1, paramInt2);
  }
  
  public int b(int paramInt, float[] paramArrayOffloat) {
    return b(paramInt, paramArrayOffloat, this.b);
  }
  
  public int b(int paramInt1, float[] paramArrayOffloat, int paramInt2) {
    return a(paramInt1, paramArrayOffloat, paramInt2, -1);
  }
  
  public boolean b() {
    t();
    return super.b();
  }
  
  public int c(int paramInt1, float[] paramArrayOffloat, int paramInt2) {
    return a(paramInt1, paramArrayOffloat, this.b, paramInt2);
  }
  
  public void f() {
    super.f();
    int i = this.a;
    if (i != 0) {
      GLES20.glDeleteFramebuffers(1, new int[] { i }, 0);
      this.a = 0;
    } 
    h();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\gl\c\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */