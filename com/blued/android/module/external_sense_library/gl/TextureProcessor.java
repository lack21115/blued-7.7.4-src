package com.blued.android.module.external_sense_library.gl;

import android.opengl.GLES20;
import android.opengl.GLES30;
import com.blued.android.module.external_sense_library.contract.IGetBufferCallback;
import com.blued.android.module.external_sense_library.glutils.GlUtil;
import com.blued.android.module.external_sense_library.glutils.OpenGLUtils;
import com.blued.android.module.external_sense_library.glutils.TextureRotationUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class TextureProcessor {
  protected float[] a = TextureRotationUtil.a;
  
  private int b;
  
  private int c;
  
  private int d;
  
  private int e;
  
  private int f;
  
  private int g;
  
  private int h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private float[] l = TextureRotationUtil.f;
  
  private volatile boolean m;
  
  private int n;
  
  private int o;
  
  public TextureProcessor(int paramInt) {
    if (paramInt != 1) {
      if (paramInt != 2) {
        this.a = TextureRotationUtil.a;
        return;
      } 
      this.a = TextureRotationUtil.c;
      return;
    } 
    this.a = TextureRotationUtil.h;
  }
  
  private boolean b(int paramInt1, int paramInt2) {
    this.o = OpenGLUtils.a(paramInt1, paramInt2);
    return (this.o != 0);
  }
  
  private void d() {
    int i = this.d;
    if (i != 0) {
      GLES20.glDeleteProgram(i);
      this.d = 0;
    } 
  }
  
  private void e() {
    int i = this.f;
    if (i != 0) {
      GLES20.glDeleteBuffers(1, new int[] { i }, 0);
      this.f = 0;
    } 
    i = this.g;
    if (i != 0) {
      GLES20.glDeleteBuffers(1, new int[] { i }, 0);
      this.g = 0;
    } 
  }
  
  private void f() {
    int i = this.e;
    if (i != 0) {
      GLES30.glDeleteVertexArrays(1, new int[] { i }, 0);
      this.e = 0;
    } 
  }
  
  private void g() {
    float[] arrayOfFloat = l();
    ByteBuffer byteBuffer1 = ByteBuffer.allocateDirect(arrayOfFloat.length * 4);
    byteBuffer1.order(ByteOrder.nativeOrder());
    FloatBuffer floatBuffer1 = byteBuffer1.asFloatBuffer();
    floatBuffer1.put(arrayOfFloat);
    floatBuffer1.rewind();
    arrayOfFloat = m();
    ByteBuffer byteBuffer2 = ByteBuffer.allocateDirect(arrayOfFloat.length * 4);
    byteBuffer2.order(ByteOrder.nativeOrder());
    FloatBuffer floatBuffer2 = byteBuffer2.asFloatBuffer();
    floatBuffer2.put(arrayOfFloat);
    floatBuffer2.rewind();
    int[] arrayOfInt = new int[2];
    GLES20.glGenBuffers(2, arrayOfInt, 0);
    this.f = arrayOfInt[0];
    this.g = arrayOfInt[1];
    GLES20.glBindBuffer(34962, this.f);
    GLES20.glBufferData(34962, 32, floatBuffer1, 35044);
    GLES20.glBindBuffer(34962, this.g);
    GLES20.glBufferData(34962, 32, floatBuffer2, 35044);
    GLES20.glBindBuffer(34962, 0);
    h();
    GLES20.glBindBuffer(34962, 0);
  }
  
  private void h() {
    GLES20.glBindBuffer(34962, this.f);
    GLES20.glEnableVertexAttribArray(this.h);
    GLES20.glVertexAttribPointer(this.h, 2, 5126, false, 0, 0);
    GLES20.glBindBuffer(34962, this.g);
    GLES20.glEnableVertexAttribArray(this.i);
    GLES20.glVertexAttribPointer(this.i, 2, 5126, false, 0, 0);
  }
  
  private boolean i() {
    String[] arrayOfString = o();
    boolean bool = false;
    this.d = OpenGLUtils.a(arrayOfString[0], arrayOfString[1]);
    if (this.d != 0)
      bool = true; 
    return bool;
  }
  
  private void j() {
    this.n = GlUtil.a();
  }
  
  private void k() {
    int i = this.o;
    if (i != 0) {
      GLES20.glDeleteTextures(1, new int[] { i }, 0);
      this.o = 0;
    } 
  }
  
  private float[] l() {
    return this.l;
  }
  
  private float[] m() {
    return this.a;
  }
  
  private int n() {
    return 3553;
  }
  
  private String[] o() {
    return new String[] { "attribute vec2 a_pos;\nattribute vec2 a_tex;\nvarying vec2 v_tex_coord;\nuniform mat4 u_mvp;\nuniform mat4 u_tex_trans;\nvoid main() {\n   gl_Position = u_mvp * vec4(a_pos, 0.0, 1.0);\n   v_tex_coord = (u_tex_trans * vec4(a_tex, 0.0, 1.0)).st;\n}\n", "precision mediump float;\nuniform sampler2D u_tex;\nvarying vec2 v_tex_coord;\nvoid main() {\n  gl_FragColor = texture2D(u_tex, v_tex_coord);\n}\n" };
  }
  
  public int a(int paramInt) {
    return a(paramInt, (IGetBufferCallback)null);
  }
  
  public int a(int paramInt, IGetBufferCallback paramIGetBufferCallback) {
    GLES20.glBindFramebuffer(36160, this.n);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.o, 0);
    GLES20.glClear(16384);
    GLES20.glUseProgram(this.d);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(n(), paramInt);
    h();
    GLES20.glUniformMatrix4fv(this.j, 1, false, GlUtil.a, 0);
    GLES20.glUniformMatrix4fv(this.k, 1, false, GlUtil.a, 0);
    GLES20.glViewport(0, 0, this.b, this.c);
    GLES20.glDrawArrays(5, 0, 4);
    if (this.a == TextureRotationUtil.a) {
      paramInt = this.b;
      int i = this.c;
      byte[] arrayOfByte = new byte[paramInt * i * 4];
      ByteBuffer byteBuffer = ByteBuffer.allocateDirect(paramInt * i * 4);
      byteBuffer.position(0);
      GLES20.glReadPixels(0, 0, this.b, this.c, 6408, 5121, byteBuffer);
      byteBuffer.get(arrayOfByte, 0, arrayOfByte.length);
      arrayOfByte = GlUtil.a(arrayOfByte, this.b, this.c);
      if (paramIGetBufferCallback != null)
        paramIGetBufferCallback.readBuffer(arrayOfByte); 
    } 
    GLES20.glBindBuffer(34962, 0);
    GLES20.glBindTexture(n(), 0);
    GLES20.glBindFramebuffer(36160, 0);
    return this.o;
  }
  
  public boolean a() {
    if (!i())
      return false; 
    c();
    g();
    j();
    this.m = true;
    return true;
  }
  
  public boolean a(int paramInt1, int paramInt2) {
    this.b = paramInt1;
    this.c = paramInt2;
    k();
    b(paramInt1, paramInt2);
    return true;
  }
  
  public void b() {
    this.m = false;
    int i = this.n;
    if (i != 0) {
      GLES20.glDeleteFramebuffers(1, new int[] { i }, 0);
      this.n = 0;
    } 
    k();
    d();
    e();
    f();
  }
  
  protected void c() {
    this.h = GLES20.glGetAttribLocation(this.d, "a_pos");
    this.i = GLES20.glGetAttribLocation(this.d, "a_tex");
    this.j = GLES20.glGetUniformLocation(this.d, "u_mvp");
    this.k = GLES20.glGetUniformLocation(this.d, "u_tex_trans");
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface TextureType {
    public static final int BACK = 1;
    
    public static final int FRONT = 2;
    
    public static final int MIRO = 0;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\gl\TextureProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */