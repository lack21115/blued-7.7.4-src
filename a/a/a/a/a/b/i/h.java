package a.a.a.a.a.b.i;

import a.a.a.a.a.a.h.f;
import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public abstract class h {
  public int m;
  
  public int n;
  
  public int o;
  
  public float[] p;
  
  public int q;
  
  public int r;
  
  public int s;
  
  public int t;
  
  public FloatBuffer u;
  
  public FloatBuffer v;
  
  public void a(int paramInt, float[] paramArrayOffloat) {
    GLES20.glUseProgram(this.o);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt);
    paramInt = this.s;
    float[] arrayOfFloat2 = this.p;
    float[] arrayOfFloat1 = arrayOfFloat2;
    if (arrayOfFloat2 == null)
      arrayOfFloat1 = f.c; 
    GLES20.glUniformMatrix4fv(paramInt, 1, false, arrayOfFloat1, 0);
    paramInt = this.t;
    arrayOfFloat1 = paramArrayOffloat;
    if (paramArrayOffloat == null)
      arrayOfFloat1 = f.c; 
    GLES20.glUniformMatrix4fv(paramInt, 1, false, arrayOfFloat1, 0);
    GLES20.glViewport(0, 0, this.m, this.n);
    this.u.put(e());
    this.u.rewind();
    GLES20.glEnableVertexAttribArray(this.q);
    GLES20.glVertexAttribPointer(this.q, 2, 5126, false, 0, this.u);
    GLES20.glEnableVertexAttribArray(this.r);
    GLES20.glVertexAttribPointer(this.r, 2, 5126, false, 0, this.v);
    f();
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glBindTexture(3553, 0);
  }
  
  public boolean a() {
    String[] arrayOfString = c();
    int i = f.a(arrayOfString[0], arrayOfString[1]);
    this.o = i;
    this.q = GLES20.glGetAttribLocation(i, "a_pos");
    this.r = GLES20.glGetAttribLocation(this.o, "a_tex");
    this.s = GLES20.glGetUniformLocation(this.o, "u_mvp");
    this.t = GLES20.glGetUniformLocation(this.o, "u_tex_trans");
    d();
    ByteBuffer byteBuffer = ByteBuffer.allocateDirect(32);
    byteBuffer.order(ByteOrder.nativeOrder());
    this.u = byteBuffer.asFloatBuffer();
    byteBuffer = ByteBuffer.allocateDirect(32);
    byteBuffer.order(ByteOrder.nativeOrder());
    FloatBuffer floatBuffer = byteBuffer.asFloatBuffer();
    this.v = floatBuffer;
    floatBuffer.put(g());
    this.v.rewind();
    return true;
  }
  
  public boolean a(int paramInt1, int paramInt2) {
    this.m = paramInt1;
    this.n = paramInt2;
    return true;
  }
  
  public void c(int paramInt) {
    a(paramInt, (float[])null);
  }
  
  public abstract String[] c();
  
  public abstract boolean d();
  
  public abstract float[] e();
  
  public void f() {}
  
  public abstract float[] g();
  
  public void h() {
    int i = this.o;
    if (i != 0) {
      GLES20.glDeleteProgram(i);
      this.o = 0;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\b\i\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */