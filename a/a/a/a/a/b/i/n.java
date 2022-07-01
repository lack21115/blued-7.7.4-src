package a.a.a.a.a.b.i;

import a.a.a.a.a.a.h.f;
import android.opengl.GLES20;
import android.opengl.GLES30;
import com.qiniu.pili.droid.streaming.av.encoder.PLH264Encoder;
import java.nio.ByteBuffer;

public class n extends g {
  public int a;
  
  public int b;
  
  public int c;
  
  public int d;
  
  public int q;
  
  public String r;
  
  public final boolean a(int paramInt1, int paramInt2, int paramInt3) {
    paramInt1 = f.b(paramInt1 * paramInt2 * paramInt3);
    this.b = paramInt1;
    return (paramInt1 != 0);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString) {
    this.d = paramInt3;
    this.q = paramInt5;
    this.r = paramString;
    o();
    boolean bool = f.b();
    boolean bool1 = false;
    if (bool && !a(paramInt1, paramInt2, paramInt3))
      return false; 
    bool = bool1;
    if (a(paramInt1, paramInt2)) {
      bool = bool1;
      if (b(paramInt1, paramInt2, paramInt4))
        bool = true; 
    } 
    return bool;
  }
  
  public void b(int paramInt) {
    GLES20.glBindFramebuffer(36160, this.a);
    GLES20.glFramebufferRenderbuffer(36160, 36064, 36161, this.c);
    super.b(paramInt);
    if (f.b()) {
      GLES20.glBindBuffer(35051, this.b);
      PLH264Encoder.getPixelFromPBO(0, 0, this.e, this.f, this.q, 5121, 0);
    } 
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  public final boolean b(int paramInt1, int paramInt2, int paramInt3) {
    paramInt1 = f.a(paramInt3, paramInt1, paramInt2);
    this.c = paramInt1;
    return (paramInt1 != 0);
  }
  
  public String[] b() {
    return new String[] { "attribute vec2 a_pos;\nattribute vec2 a_tex;\nvarying vec2 v_tex;\nuniform mat4 u_mvp;\nuniform mat4 u_tex_trans;\nvoid main() {\n   gl_Position = u_mvp * vec4(a_pos, 0.0, 1.0);\n   v_tex = (u_tex_trans * vec4(a_tex, 0.0, 1.0)).st;\n}\n", this.r };
  }
  
  public float[] e() {
    return k.c;
  }
  
  public void g() {
    super.g();
    int i = this.a;
    if (i != 0) {
      GLES20.glDeleteFramebuffers(1, new int[] { i }, 0);
      this.a = 0;
    } 
    i = this.b;
    if (i != 0) {
      GLES20.glDeleteBuffers(1, new int[] { i }, 0);
      this.b = 0;
    } 
    i = this.c;
    if (i != 0) {
      GLES20.glDeleteRenderbuffers(1, new int[] { i }, 0);
      this.c = 0;
    } 
  }
  
  public ByteBuffer m() {
    if (f.b()) {
      GLES20.glBindBuffer(35051, this.b);
      return (ByteBuffer)GLES30.glMapBufferRange(35051, 0, this.e * this.f * this.d, 1);
    } 
    ByteBuffer byteBuffer = ByteBuffer.allocateDirect(this.e * this.f * this.d);
    GLES20.glBindFramebuffer(36160, this.a);
    GLES20.glFramebufferRenderbuffer(36160, 36064, 36161, this.c);
    GLES20.glReadPixels(0, 0, this.e, this.f, this.q, 5121, byteBuffer);
    GLES20.glBindFramebuffer(36160, 0);
    return byteBuffer;
  }
  
  public void n() {
    if (f.b()) {
      GLES20.glBindBuffer(35051, this.b);
      GLES30.glUnmapBuffer(35051);
      GLES20.glBindBuffer(35051, 0);
    } 
  }
  
  public final void o() {
    this.a = f.c();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\b\i\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */