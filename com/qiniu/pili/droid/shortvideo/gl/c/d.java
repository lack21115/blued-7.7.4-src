package com.qiniu.pili.droid.shortvideo.gl.c;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.qiniu.pili.droid.shortvideo.f.e;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class d extends g {
  protected float a;
  
  protected float b;
  
  protected float c;
  
  protected float d;
  
  protected int e;
  
  protected int f;
  
  private int o;
  
  private int p;
  
  private float q;
  
  private int r;
  
  private Bitmap s;
  
  private boolean t = true;
  
  private boolean u;
  
  private k v;
  
  public d(int paramInt1, int paramInt2) {
    this.e = paramInt1;
    this.f = paramInt2;
  }
  
  public d(Bitmap paramBitmap) {
    this.s = paramBitmap;
  }
  
  private int a(int paramInt, boolean paramBoolean) {
    if (!k()) {
      e.j.d("Sticker is not setup.");
      return paramInt;
    } 
    paramInt = this.v.a(paramInt);
    GLES20.glBlendEquationSeparate(32774, 32774);
    GLES20.glBlendFuncSeparate(1, 771, 1, 1);
    GLES20.glEnable(3042);
    GLES20.glBindFramebuffer(36160, this.o);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt, 0);
    if (paramBoolean)
      GLES20.glClear(16384); 
    b(this.p);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glDisable(3042);
    return paramInt;
  }
  
  private void t() {
    this.v = new k();
    this.v.a(this.i, this.j);
    this.v.b();
  }
  
  private void u() {
    if (this.c == 0.0F)
      this.c = this.a + this.e * 1.0F / this.i; 
    if (this.d == 0.0F)
      this.d = this.b + this.f * 1.0F / this.j; 
    if (this.t) {
      float f = this.c;
      if (f > 1.0F) {
        this.a = 1.0F - f - this.a;
        this.c = 1.0F;
      } 
      f = this.d;
      if (f > 1.0F) {
        this.b = 1.0F - f - this.b;
        this.d = 1.0F;
      } 
    } 
    float f3 = this.i / this.j;
    float f1 = this.a;
    float f2 = f3 * 2.0F;
    this.a = f1 * f2;
    this.b *= 2.0F;
    this.c *= f2;
    this.d *= 2.0F;
    this.a -= f3;
    this.b--;
    this.c -= f3;
    this.d--;
    this.b *= -1.0F;
    this.d *= -1.0F;
    this.m = new float[16];
    float f4 = this.c;
    float f5 = this.a;
    f1 = this.d;
    f2 = this.b;
    Matrix.orthoM(this.m, 0, -f3, f3, -1.0F, 1.0F, -1.0F, 1.0F);
    float[] arrayOfFloat = this.m;
    f3 = this.a;
    f4 = (f4 - f5) / 2.0F;
    f5 = this.b;
    f1 = (f1 - f2) / 2.0F;
    Matrix.translateM(arrayOfFloat, 0, f3 + f4, f5 + f1, 0.0F);
    Matrix.rotateM(this.m, 0, this.k, 0.0F, 0.0F, -1.0F);
    Matrix.translateM(this.m, 0, -(this.a + f4), -(this.b + f1), 0.0F);
  }
  
  public int a(int paramInt) {
    return a(paramInt, false);
  }
  
  public int a(int paramInt1, int paramInt2, boolean paramBoolean) {
    this.p = paramInt2;
    paramInt1 = a(paramInt1, paramBoolean);
    this.p = 0;
    return paramInt1;
  }
  
  public void a(float paramFloat) {
    this.q = paramFloat;
  }
  
  public void a(float paramFloat1, float paramFloat2) {
    this.c = this.a + paramFloat1;
    this.d = this.b + paramFloat2;
  }
  
  public void a(boolean paramBoolean) {
    this.t = paramBoolean;
  }
  
  protected String[] a() {
    return this.u ? new String[] { "attribute vec2 a_pos;\nattribute vec2 a_tex;\nvarying vec2 v_tex_coord;\nuniform mat4 u_mvp;\nuniform mat4 u_tex_trans;\nvoid main() {\n   gl_Position = u_mvp * vec4(a_pos, 0.0, 1.0);\n   gl_Position.y = -gl_Position.y;\n   v_tex_coord = (u_tex_trans * vec4(a_tex, 0.0, 1.0)).st;\n}\n", "precision mediump float;\nuniform sampler2D u_tex;\nvarying vec2 v_tex_coord;\nuniform float u_alpha;\nvoid main() {\n    gl_FragColor = texture2D(u_tex, v_tex_coord) * u_alpha;\n}\n" } : new String[] { "attribute vec2 a_pos;\nattribute vec2 a_tex;\nvarying vec2 v_tex_coord;\nuniform mat4 u_mvp;\nuniform mat4 u_tex_trans;\nvoid main() {\n   gl_Position = u_mvp * vec4(a_pos, 0.0, 1.0);\n   v_tex_coord = (u_tex_trans * vec4(a_tex, 0.0, 1.0)).st;\n}\n", "precision mediump float;\nuniform sampler2D u_tex;\nvarying vec2 v_tex_coord;\nuniform float u_alpha;\nvoid main() {\n    gl_FragColor = texture2D(u_tex, v_tex_coord) * u_alpha;\n}\n" };
  }
  
  public void b(float paramFloat) {
    this.k = paramFloat;
  }
  
  public void b(float paramFloat1, float paramFloat2) {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  public void b(boolean paramBoolean) {
    this.u = paramBoolean;
  }
  
  public boolean b() {
    if (this.s == null && (this.e == 0 || this.f == 0)) {
      e.j.d("Sticker's bitmap is null, or it's width or height is 0, setup failed.");
      return false;
    } 
    this.o = com.qiniu.pili.droid.shortvideo.f.d.e();
    Bitmap bitmap = this.s;
    if (bitmap != null) {
      this.e = bitmap.getWidth();
      this.f = this.s.getHeight();
      ByteBuffer byteBuffer = ByteBuffer.allocateDirect(this.e * this.f * 4);
      byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      if (this.s.getConfig() == Bitmap.Config.ARGB_8888) {
        this.s.copyPixelsToBuffer(byteBuffer);
        byteBuffer.position(0);
      } 
      this.p = com.qiniu.pili.droid.shortvideo.f.d.a(byteBuffer, this.e, this.f, 6408);
    } 
    u();
    t();
    return super.b();
  }
  
  public void c(float paramFloat) {
    b(paramFloat);
    Matrix.rotateM(this.m, 0, this.k, 0.0F, 0.0F, -1.0F);
  }
  
  public void c(boolean paramBoolean) {
    if (paramBoolean) {
      k k1 = this.v;
      if (k1 != null) {
        this.i = 0;
        this.j = 0;
        k1.f();
        this.v = null;
      } 
    } 
    this.a = 0.0F;
    this.b = 0.0F;
    this.c = 0.0F;
    this.d = 0.0F;
    this.e = 0;
    this.f = 0;
  }
  
  protected boolean c() {
    this.r = GLES20.glGetUniformLocation(this.l, "u_alpha");
    return super.c();
  }
  
  protected void d() {
    super.d();
    GLES20.glUniform1f(this.r, this.q);
  }
  
  public void f() {
    super.f();
    int i = this.o;
    if (i != 0) {
      GLES20.glDeleteFramebuffers(1, new int[] { i }, 0);
      this.o = 0;
    } 
    i = this.p;
    if (i != 0) {
      GLES20.glDeleteTextures(1, new int[] { i }, 0);
      this.p = 0;
    } 
    k k1 = this.v;
    if (k1 != null) {
      k1.f();
      this.v = null;
    } 
  }
  
  public void h() {
    Bitmap bitmap = this.s;
    if (bitmap != null) {
      this.e = bitmap.getWidth();
      this.f = this.s.getHeight();
    } 
    u();
    if (this.v == null)
      t(); 
    q();
    r();
    s();
  }
  
  protected float[] i() {
    float f1 = this.a;
    float f2 = this.d;
    float f3 = this.b;
    float f4 = this.c;
    return new float[] { f1, f2, f1, f3, f4, f2, f4, f3 };
  }
  
  protected float[] j() {
    return com.qiniu.pili.droid.shortvideo.f.d.d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\gl\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */