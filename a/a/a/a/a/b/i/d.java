package a.a.a.a.a.b.i;

import a.a.a.a.a.a.h.f;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class d extends h {
  public static float[] a = new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F };
  
  public Bitmap b;
  
  public int c;
  
  public int d;
  
  public float e;
  
  public float f;
  
  public float g;
  
  public float h;
  
  public float[] i = new float[8];
  
  public int j;
  
  public float k;
  
  public int l;
  
  public d(Bitmap paramBitmap) {
    this.b = paramBitmap;
  }
  
  public void a(float paramFloat) {
    this.k = paramFloat;
  }
  
  public void a(float paramFloat1, float paramFloat2) {
    this.g = this.e + paramFloat1;
    this.h = this.f + paramFloat2;
  }
  
  public void a(int paramInt) {
    this.l = paramInt;
  }
  
  public boolean a() {
    this.c = f.c();
    ByteBuffer byteBuffer = ByteBuffer.allocateDirect(this.b.getWidth() * this.b.getHeight() * 4);
    byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    if (this.b.getConfig() == Bitmap.Config.ARGB_8888) {
      this.b.copyPixelsToBuffer(byteBuffer);
      byteBuffer.position(0);
    } 
    this.d = f.a(byteBuffer, this.b.getWidth(), this.b.getHeight(), 6408);
    this.p = new float[16];
    b();
    return super.a();
  }
  
  public int b(int paramInt) {
    GLES20.glBlendEquationSeparate(32774, 32774);
    GLES20.glBlendFuncSeparate(1, 771, 1, 1);
    GLES20.glEnable(3042);
    GLES20.glBindFramebuffer(36160, this.c);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt, 0);
    c(this.d);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glDisable(3042);
    return paramInt;
  }
  
  public void b() {
    if (this.g == 0.0F)
      this.g = this.e + this.b.getWidth() * 1.0F / this.m; 
    if (this.h == 0.0F)
      this.h = this.f + this.b.getHeight() * 1.0F / this.n; 
    float f1 = this.m / this.n;
    float f3 = this.e;
    float f4 = this.f;
    float f5 = this.g;
    float f2 = this.h;
    f3 = f3 * 2.0F * f1 - f1;
    f5 = f5 * 2.0F * f1 - f1;
    f4 = (f4 * 2.0F - 1.0F) * -1.0F;
    f2 = (f2 * 2.0F - 1.0F) * -1.0F;
    float[] arrayOfFloat = this.i;
    arrayOfFloat[0] = f3;
    arrayOfFloat[1] = f2;
    arrayOfFloat[2] = f3;
    arrayOfFloat[3] = f4;
    arrayOfFloat[4] = f5;
    arrayOfFloat[5] = f2;
    arrayOfFloat[6] = f5;
    arrayOfFloat[7] = f4;
    Matrix.orthoM(this.p, 0, -f1, f1, -1.0F, 1.0F, -1.0F, 1.0F);
    arrayOfFloat = this.p;
    f1 = f3 + (f5 - f3) / 2.0F;
    f2 = f4 + (f2 - f4) / 2.0F;
    Matrix.translateM(arrayOfFloat, 0, f1, f2, 0.0F);
    Matrix.rotateM(this.p, 0, this.l, 0.0F, 0.0F, -1.0F);
    Matrix.translateM(this.p, 0, -f1, -f2, 0.0F);
  }
  
  public void b(float paramFloat1, float paramFloat2) {
    this.e = paramFloat1;
    this.f = paramFloat2;
  }
  
  public String[] c() {
    return new String[] { "attribute vec2 a_pos;\nattribute vec2 a_tex;\nvarying vec2 v_tex;\nuniform mat4 u_mvp;\nuniform mat4 u_tex_trans;\nvoid main() {\n   gl_Position = u_mvp * vec4(a_pos, 0.0, 1.0);\n   v_tex = (u_tex_trans * vec4(a_tex, 0.0, 1.0)).st;\n}\n", "precision mediump float;\nuniform sampler2D u_tex;\nvarying vec2 v_tex;\nuniform float u_alpha;\nvoid main() {\n    gl_FragColor = texture2D(u_tex, v_tex) * u_alpha;\n}\n" };
  }
  
  public boolean d() {
    this.j = GLES20.glGetUniformLocation(this.o, "u_alpha");
    return true;
  }
  
  public float[] e() {
    return this.i;
  }
  
  public void f() {
    super.f();
    GLES20.glUniform1f(this.j, this.k);
  }
  
  public float[] g() {
    return a;
  }
  
  public void h() {
    super.h();
    int i = this.c;
    if (i != 0) {
      GLES20.glDeleteFramebuffers(1, new int[] { i }, 0);
      this.c = 0;
    } 
    i = this.d;
    if (i != 0) {
      GLES20.glDeleteTextures(1, new int[] { i }, 0);
      this.d = 0;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\b\i\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */