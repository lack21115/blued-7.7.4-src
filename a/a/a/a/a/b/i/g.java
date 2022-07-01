package a.a.a.a.a.b.i;

import a.a.a.a.a.a.h.f;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class g {
  public int e;
  
  public int f;
  
  public int g;
  
  public int h;
  
  public int i;
  
  public int j;
  
  public int k;
  
  public float[] l;
  
  public int m;
  
  public int n;
  
  public int o;
  
  public int p;
  
  public int a() {
    return 3553;
  }
  
  public void a(int paramInt) {
    if (this.l == null)
      this.l = new float[16]; 
    this.g = paramInt;
    Matrix.setIdentityM(this.l, 0);
    Matrix.rotateM(this.l, 0, paramInt, 0.0F, 0.0F, -1.0F);
  }
  
  public void a(int paramInt, float[] paramArrayOffloat) {
    GLES20.glUseProgram(this.h);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(a(), paramInt);
    if (f.b()) {
      GLES30.glBindVertexArray(this.i);
    } else {
      k();
    } 
    paramInt = this.o;
    float[] arrayOfFloat = this.l;
    if (arrayOfFloat == null)
      arrayOfFloat = f.c; 
    GLES20.glUniformMatrix4fv(paramInt, 1, false, arrayOfFloat, 0);
    arrayOfFloat = paramArrayOffloat;
    if (paramArrayOffloat == null)
      arrayOfFloat = f.c; 
    GLES20.glUniformMatrix4fv(this.p, 1, false, arrayOfFloat, 0);
    GLES20.glViewport(c(), d(), this.e, this.f);
    i();
    GLES20.glDrawArrays(5, 0, 4);
    if (f.b())
      GLES30.glBindVertexArray(0); 
    GLES20.glBindBuffer(34962, 0);
    GLES20.glBindTexture(a(), 0);
  }
  
  public boolean a(int paramInt1, int paramInt2) {
    this.e = paramInt1;
    this.f = paramInt2;
    return !l() ? false : (!h() ? false : (!!j()));
  }
  
  public void b(int paramInt) {
    a(paramInt, (float[])null);
  }
  
  public String[] b() {
    return new String[] { "attribute vec2 a_pos;\nattribute vec2 a_tex;\nvarying vec2 v_tex;\nuniform mat4 u_mvp;\nuniform mat4 u_tex_trans;\nvoid main() {\n   gl_Position = u_mvp * vec4(a_pos, 0.0, 1.0);\n   v_tex = (u_tex_trans * vec4(a_tex, 0.0, 1.0)).st;\n}\n", "precision mediump float;\nuniform sampler2D u_tex;\nvarying vec2 v_tex;\nvoid main() {\n  gl_FragColor = texture2D(u_tex, v_tex);\n}\n" };
  }
  
  public int c() {
    return 0;
  }
  
  public int d() {
    return 0;
  }
  
  public float[] e() {
    return k.a;
  }
  
  public float[] f() {
    return k.d;
  }
  
  public void g() {
    int i = this.h;
    if (i != 0) {
      GLES20.glDeleteProgram(i);
      this.h = 0;
    } 
    i = this.j;
    if (i != 0) {
      GLES20.glDeleteBuffers(1, new int[] { i }, 0);
      this.j = 0;
    } 
    i = this.k;
    if (i != 0) {
      GLES20.glDeleteBuffers(1, new int[] { i }, 0);
      this.k = 0;
    } 
    i = this.i;
    if (i != 0) {
      GLES30.glDeleteVertexArrays(1, new int[] { i }, 0);
      this.i = 0;
    } 
  }
  
  public boolean h() {
    this.m = GLES20.glGetAttribLocation(this.h, "a_pos");
    this.n = GLES20.glGetAttribLocation(this.h, "a_tex");
    this.o = GLES20.glGetUniformLocation(this.h, "u_mvp");
    this.p = GLES20.glGetUniformLocation(this.h, "u_tex_trans");
    return f.b("TextureDrawer glBindAttribLocation");
  }
  
  public void i() {}
  
  public final boolean j() {
    float[] arrayOfFloat = e();
    if (Math.abs(this.g) == 90 || Math.abs(this.g) == 270) {
      float f1 = arrayOfFloat[4] - arrayOfFloat[0];
      float f2 = arrayOfFloat[3] - arrayOfFloat[1];
      arrayOfFloat[1] = arrayOfFloat[3] - f1;
      arrayOfFloat[4] = arrayOfFloat[0] + f2;
      arrayOfFloat[5] = arrayOfFloat[3] - f1;
      arrayOfFloat[6] = arrayOfFloat[0] + f2;
    } 
    ByteBuffer byteBuffer1 = ByteBuffer.allocateDirect(arrayOfFloat.length * 4);
    byteBuffer1.order(ByteOrder.nativeOrder());
    FloatBuffer floatBuffer1 = byteBuffer1.asFloatBuffer();
    floatBuffer1.put(arrayOfFloat);
    floatBuffer1.rewind();
    arrayOfFloat = f();
    ByteBuffer byteBuffer2 = ByteBuffer.allocateDirect(arrayOfFloat.length * 4);
    byteBuffer2.order(ByteOrder.nativeOrder());
    FloatBuffer floatBuffer2 = byteBuffer2.asFloatBuffer();
    floatBuffer2.put(arrayOfFloat);
    floatBuffer2.rewind();
    int[] arrayOfInt = new int[2];
    GLES20.glGenBuffers(2, arrayOfInt, 0);
    int i = arrayOfInt[0];
    this.j = i;
    this.k = arrayOfInt[1];
    GLES20.glBindBuffer(34962, i);
    GLES20.glBufferData(34962, 32, floatBuffer1, 35044);
    GLES20.glBindBuffer(34962, this.k);
    GLES20.glBufferData(34962, 32, floatBuffer2, 35044);
    GLES20.glBindBuffer(34962, 0);
    if (f.b()) {
      i = f.d();
      this.i = i;
      GLES30.glBindVertexArray(i);
    } 
    k();
    if (f.b())
      GLES30.glBindVertexArray(0); 
    GLES20.glBindBuffer(34962, 0);
    return f.b("TextureDrawer setup VAO, VBOs.");
  }
  
  public final void k() {
    GLES20.glBindBuffer(34962, this.j);
    GLES20.glEnableVertexAttribArray(this.m);
    GLES20.glVertexAttribPointer(this.m, 2, 5126, false, 0, 0);
    GLES20.glBindBuffer(34962, this.k);
    GLES20.glEnableVertexAttribArray(this.n);
    GLES20.glVertexAttribPointer(this.n, 2, 5126, false, 0, 0);
  }
  
  public final boolean l() {
    String[] arrayOfString = b();
    boolean bool = false;
    int i = f.a(arrayOfString[0], arrayOfString[1]);
    this.h = i;
    if (i != 0)
      bool = true; 
    return bool;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\b\i\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */