package com.qiniu.pili.droid.shortvideo.gl.c;

import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.Matrix;
import com.qiniu.pili.droid.shortvideo.PLDisplayMode;
import com.qiniu.pili.droid.shortvideo.f.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class g {
  private int a;
  
  private int b;
  
  private int c;
  
  private float d = 1.0F;
  
  private float e = 1.0F;
  
  private int f;
  
  protected int g;
  
  protected int h;
  
  protected int i;
  
  protected int j;
  
  protected float k;
  
  protected int l;
  
  protected float[] m;
  
  protected float[] n;
  
  private int o;
  
  private int p;
  
  private int q;
  
  private float[] r = d.b;
  
  private float[] s = d.c;
  
  private int t;
  
  private int u;
  
  private volatile boolean v;
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    float f1 = this.i * 1.0F / this.j;
    float f2 = f1 * 2.0F;
    paramFloat1 = paramFloat1 * f2 - f1;
    paramFloat2 = f2 * paramFloat2 - f1;
    paramFloat3 = (paramFloat3 * 2.0F - 1.0F) * -1.0F;
    paramFloat4 = (2.0F * paramFloat4 - 1.0F) * -1.0F;
    this.m = new float[16];
    Matrix.orthoM(this.m, 0, -f1, f1, -1.0F, 1.0F, -1.0F, 1.0F);
    Matrix.rotateM(this.m, 0, this.k, 0.0F, 0.0F, -1.0F);
    this.r = new float[] { paramFloat1, paramFloat4, paramFloat1, paramFloat3, paramFloat2, paramFloat4, paramFloat2, paramFloat3 };
  }
  
  private void b(int paramInt1, int paramInt2) {
    this.r = d.b;
    float f1 = this.i * 1.0F / this.j;
    float f2 = paramInt1;
    float f3 = paramInt2;
    if (f2 * 1.0F / f3 < f1) {
      f1 = (f3 - f2 / f1) / 2.0F / f3;
      f2 = 1.0F - f1;
      this.s = new float[] { 0.0F, f1, 0.0F, f2, 1.0F, f1, 1.0F, f2 };
      return;
    } 
    f1 = (f2 - f3 * f1) / 2.0F / f2;
    f2 = 1.0F - f1;
    this.s = new float[] { f1, 0.0F, f1, 1.0F, f2, 0.0F, f2, 1.0F };
  }
  
  private void c(int paramInt1, int paramInt2) {
    float f3;
    this.s = d.c;
    int i = this.i;
    float f1 = i;
    int j = this.j;
    f1 = f1 * 1.0F / j;
    float f2 = paramInt1 * 1.0F / paramInt2;
    float f4 = 0.0F;
    if (f2 < f1) {
      f1 = j * f2;
      f3 = 0.5F - f1 / i / 2.0F;
      f2 = f1 / i / 2.0F + 0.5F;
      this.t = (int)(i * f3);
      f1 = 1.0F;
    } else {
      f1 = i / f2;
      f4 = 0.5F - f1 / j / 2.0F;
      f1 = f1 / j / 2.0F + 0.5F;
      this.u = (int)(j * f4);
      f3 = 0.0F;
      f2 = 1.0F;
    } 
    a(f3, f2, f4, f1);
  }
  
  private void h() {
    GLES20.glBindBuffer(34962, this.b);
    GLES20.glEnableVertexAttribArray(this.f);
    GLES20.glVertexAttribPointer(this.f, 2, 5126, false, 0, 0);
    GLES20.glBindBuffer(34962, this.c);
    GLES20.glEnableVertexAttribArray(this.o);
    GLES20.glVertexAttribPointer(this.o, 2, 5126, false, 0, 0);
  }
  
  private boolean t() {
    String[] arrayOfString = a();
    boolean bool = false;
    this.l = d.a(arrayOfString[0], arrayOfString[1]);
    if (this.l != 0)
      bool = true; 
    return bool;
  }
  
  public void a(int paramInt, float[] paramArrayOffloat) {
    a(paramInt, paramArrayOffloat, -1);
  }
  
  public void a(int paramInt1, float[] paramArrayOffloat, int paramInt2) {
    GLES20.glUseProgram(this.l);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(g(), paramInt1);
    if (d.a()) {
      GLES30.glBindVertexArray(this.a);
    } else {
      h();
    } 
    if (paramInt2 != -1 && this.n == null) {
      this.n = new float[16];
      Matrix.setIdentityM(this.n, 0);
      Matrix.rotateM(this.n, 0, paramInt2, 0.0F, 0.0F, -1.0F);
    } 
    if (this.d != 1.0F || this.e != 1.0F) {
      float[] arrayOfFloat1 = this.n;
      if (arrayOfFloat1 != null)
        Matrix.scaleM(arrayOfFloat1, 0, this.d, this.e, 1.0F); 
      arrayOfFloat1 = this.m;
      if (arrayOfFloat1 != null) {
        Matrix.scaleM(arrayOfFloat1, 0, this.d, this.e, 1.0F);
      } else {
        this.m = new float[16];
        Matrix.setIdentityM(this.m, 0);
        Matrix.scaleM(this.m, 0, this.d, this.e, 1.0F);
      } 
      this.d = 1.0F;
      this.e = 1.0F;
    } 
    if (paramInt2 == -1) {
      paramInt1 = this.p;
      float[] arrayOfFloat1 = this.m;
      if (arrayOfFloat1 == null)
        arrayOfFloat1 = d.f; 
      GLES20.glUniformMatrix4fv(paramInt1, 1, false, arrayOfFloat1, 0);
    } else {
      GLES20.glUniformMatrix4fv(this.p, 1, false, this.n, 0);
    } 
    float[] arrayOfFloat = paramArrayOffloat;
    if (paramArrayOffloat == null)
      arrayOfFloat = d.f; 
    GLES20.glUniformMatrix4fv(this.q, 1, false, arrayOfFloat, 0);
    GLES20.glViewport(this.g, this.h, this.i, this.j);
    d();
    GLES20.glDrawArrays(5, 0, 4);
    e();
    if (d.a())
      GLES30.glBindVertexArray(0); 
    GLES20.glBindBuffer(34962, 0);
    GLES20.glBindTexture(g(), 0);
  }
  
  public void a(float[] paramArrayOffloat) {
    this.s = paramArrayOffloat;
  }
  
  public boolean a(int paramInt1, int paramInt2) {
    this.i = paramInt1;
    this.j = paramInt2;
    return true;
  }
  
  public boolean a(int paramInt1, int paramInt2, PLDisplayMode paramPLDisplayMode) {
    if (paramPLDisplayMode == PLDisplayMode.FULL) {
      b(paramInt1, paramInt2);
    } else if (paramPLDisplayMode == PLDisplayMode.FIT) {
      c(paramInt1, paramInt2);
    } 
    return b();
  }
  
  protected String[] a() {
    return new String[] { "attribute vec2 a_pos;\nattribute vec2 a_tex;\nvarying vec2 v_tex_coord;\nuniform mat4 u_mvp;\nuniform mat4 u_tex_trans;\nvoid main() {\n   gl_Position = u_mvp * vec4(a_pos, 0.0, 1.0);\n   v_tex_coord = (u_tex_trans * vec4(a_tex, 0.0, 1.0)).st;\n}\n", "precision mediump float;\nuniform sampler2D u_tex;\nvarying vec2 v_tex_coord;\nvoid main() {\n  gl_FragColor = texture2D(u_tex, v_tex_coord);\n}\n" };
  }
  
  public void b(float paramFloat) {
    if (this.m == null)
      this.m = new float[16]; 
    this.k = paramFloat;
    Matrix.setIdentityM(this.m, 0);
    Matrix.rotateM(this.m, 0, paramFloat, 0.0F, 0.0F, -1.0F);
  }
  
  public void b(int paramInt) {
    a(paramInt, (float[])null);
  }
  
  public boolean b() {
    if (!t())
      return false; 
    if (!c())
      return false; 
    if (!s())
      return false; 
    this.v = true;
    return true;
  }
  
  public void c(float paramFloat1, float paramFloat2) {
    this.d = paramFloat1;
    this.e = paramFloat2;
  }
  
  public boolean c() {
    this.f = GLES20.glGetAttribLocation(this.l, "a_pos");
    this.o = GLES20.glGetAttribLocation(this.l, "a_tex");
    this.p = GLES20.glGetUniformLocation(this.l, "u_mvp");
    this.q = GLES20.glGetUniformLocation(this.l, "u_tex_trans");
    return d.a("TextureDrawer glBindAttribLocation");
  }
  
  public void d() {}
  
  public void e() {}
  
  public void f() {
    this.v = false;
    p();
    q();
    r();
  }
  
  protected int g() {
    return 3553;
  }
  
  protected float[] i() {
    return this.r;
  }
  
  protected float[] j() {
    return this.s;
  }
  
  public boolean k() {
    return this.v;
  }
  
  public int l() {
    return this.t;
  }
  
  public int m() {
    return this.u;
  }
  
  public int n() {
    return this.i;
  }
  
  public int o() {
    return this.j;
  }
  
  protected void p() {
    int i = this.l;
    if (i != 0) {
      GLES20.glDeleteProgram(i);
      this.l = 0;
    } 
  }
  
  protected void q() {
    int i = this.b;
    if (i != 0) {
      GLES20.glDeleteBuffers(1, new int[] { i }, 0);
      this.b = 0;
    } 
    i = this.c;
    if (i != 0) {
      GLES20.glDeleteBuffers(1, new int[] { i }, 0);
      this.c = 0;
    } 
  }
  
  protected void r() {
    int i = this.a;
    if (i != 0) {
      GLES30.glDeleteVertexArrays(1, new int[] { i }, 0);
      this.a = 0;
    } 
  }
  
  protected boolean s() {
    float[] arrayOfFloat = i();
    ByteBuffer byteBuffer1 = ByteBuffer.allocateDirect(arrayOfFloat.length * 4);
    byteBuffer1.order(ByteOrder.nativeOrder());
    FloatBuffer floatBuffer1 = byteBuffer1.asFloatBuffer();
    floatBuffer1.put(arrayOfFloat);
    floatBuffer1.rewind();
    arrayOfFloat = j();
    ByteBuffer byteBuffer2 = ByteBuffer.allocateDirect(arrayOfFloat.length * 4);
    byteBuffer2.order(ByteOrder.nativeOrder());
    FloatBuffer floatBuffer2 = byteBuffer2.asFloatBuffer();
    floatBuffer2.put(arrayOfFloat);
    floatBuffer2.rewind();
    int[] arrayOfInt = new int[2];
    GLES20.glGenBuffers(2, arrayOfInt, 0);
    this.b = arrayOfInt[0];
    this.c = arrayOfInt[1];
    GLES20.glBindBuffer(34962, this.b);
    GLES20.glBufferData(34962, 32, floatBuffer1, 35044);
    GLES20.glBindBuffer(34962, this.c);
    GLES20.glBufferData(34962, 32, floatBuffer2, 35044);
    GLES20.glBindBuffer(34962, 0);
    if (d.a()) {
      this.a = d.d();
      GLES30.glBindVertexArray(this.a);
    } 
    h();
    if (d.a())
      GLES30.glBindVertexArray(0); 
    GLES20.glBindBuffer(34962, 0);
    return d.a("TextureDrawer setup VAO, VBOs.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\gl\c\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */