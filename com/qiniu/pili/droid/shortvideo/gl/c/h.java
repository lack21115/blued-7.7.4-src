package com.qiniu.pili.droid.shortvideo.gl.c;

import android.opengl.GLES20;
import com.qiniu.pili.droid.shortvideo.PLDisplayMode;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.j;

public class h extends k {
  private e c;
  
  private e d;
  
  private long e;
  
  private long f = -1L;
  
  public h(long paramLong) {
    this.e = paramLong;
    this.c = new e();
    this.d = new e();
  }
  
  private float a(long paramLong) {
    float f1;
    paramLong = (paramLong - this.f) / 1000000L;
    long l = this.e;
    if (l == 0L) {
      f1 = 1.0F;
    } else {
      f1 = (float)paramLong / (float)l;
    } 
    float f2 = f1;
    if (f1 > 1.0F)
      f2 = 1.0F; 
    return f2;
  }
  
  private void a(e parame, int paramInt, float paramFloat, boolean paramBoolean) {
    GLES20.glBlendEquationSeparate(32774, 32774);
    GLES20.glBlendFuncSeparate(1, 771, 1, 1);
    GLES20.glEnable(3042);
    parame.a(paramInt, paramFloat, (float[])null, this.b, paramBoolean);
    GLES20.glDisable(3042);
  }
  
  private boolean b(long paramLong) {
    return (a(paramLong) >= 1.0F);
  }
  
  private float c(long paramLong) {
    return 1.0F - a(paramLong);
  }
  
  public int a(int paramInt1, int paramInt2, long paramLong) {
    if (paramInt2 <= 0) {
      a(this.c, paramInt1, 1.0F, true);
      return this.b;
    } 
    if (j.a(this.e) < paramLong) {
      a(this.c, paramInt1, 1.0F, true);
      return this.b;
    } 
    if (this.f == -1L)
      this.f = 0L; 
    a(this.c, paramInt1, a(paramLong), true);
    a(this.d, paramInt2, c(paramLong), false);
    return this.b;
  }
  
  public int a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean) {
    if (paramBoolean)
      this.f = paramLong; 
    if (this.f == -1L) {
      e.t.e("TextureFadeProcessor", "no first frame to process!");
      a(this.d, paramInt2, 1.0F, true);
      return this.b;
    } 
    if (b(paramLong)) {
      a(this.d, paramInt2, 1.0F, true);
      return this.b;
    } 
    if (paramInt1 > 0) {
      a(this.c, paramInt1, c(paramLong), true);
      a(this.d, paramInt2, a(paramLong), false);
    } else {
      a(this.d, paramInt2, a(paramLong), true);
    } 
    return this.b;
  }
  
  public boolean a(int paramInt1, int paramInt2) {
    boolean bool1 = this.c.a(paramInt1, paramInt2);
    boolean bool2 = this.d.a(paramInt1, paramInt2);
    boolean bool3 = super.a(paramInt1, paramInt2);
    return (bool1 && bool2 && bool3);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, PLDisplayMode paramPLDisplayMode) {
    boolean bool1;
    boolean bool2;
    if (paramPLDisplayMode == PLDisplayMode.FIT) {
      bool1 = this.c.a(paramInt1, paramInt2, PLDisplayMode.FIT);
    } else {
      bool1 = this.c.b();
    } 
    if (paramPLDisplayMode == PLDisplayMode.FIT) {
      bool2 = this.d.a(paramInt3, paramInt4, PLDisplayMode.FIT);
    } else {
      bool2 = this.d.b();
    } 
    boolean bool3 = super.b();
    return (bool1 && bool2 && bool3);
  }
  
  public boolean b() {
    boolean bool1 = this.c.b();
    boolean bool2 = this.d.b();
    boolean bool3 = super.b();
    return (bool1 && bool2 && bool3);
  }
  
  public void f() {
    this.c.f();
    this.d.f();
    super.f();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\gl\c\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */