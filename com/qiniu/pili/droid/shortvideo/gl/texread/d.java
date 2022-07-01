package com.qiniu.pili.droid.shortvideo.gl.texread;

import android.opengl.GLES20;
import android.opengl.GLES30;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class d {
  private static final FloatBuffer a = GlUtil.a(new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F });
  
  private FloatBuffer b = GlUtil.a(new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F });
  
  private final b c;
  
  private final a d;
  
  private final int e;
  
  private final int f;
  
  private final int g;
  
  private int h;
  
  private final e.a i = new e.a();
  
  private boolean j = false;
  
  private ByteBuffer k;
  
  private ByteBuffer l;
  
  private int m;
  
  private int n;
  
  private int o;
  
  private int p;
  
  public d(int paramInt1, int paramInt2) {
    this.m = paramInt1;
    this.o = paramInt1;
    this.n = paramInt2;
    this.p = paramInt2;
    this.i.a();
    this.c = new b(6408);
    this.d = new a("varying vec2 interp_tc;\nattribute vec4 in_pos;\nattribute vec4 in_tc;\n\nuniform mat4 texMatrix;\n\nvoid main() {\n    gl_Position = in_pos;\n    interp_tc = (texMatrix * in_tc).xy;\n}\n", "precision mediump float;\nvarying vec2 interp_tc;\n\nuniform sampler2D oesTex;\nuniform vec2 xUnit;\nuniform vec4 coeffs;\n\nvoid main() {\n  gl_FragColor.r = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc - 1.5 * xUnit).rgb);\n  gl_FragColor.g = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc - 0.5 * xUnit).rgb);\n  gl_FragColor.b = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc + 0.5 * xUnit).rgb);\n  gl_FragColor.a = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc + 1.5 * xUnit).rgb);\n}\n");
    this.d.a();
    this.e = this.d.b("texMatrix");
    this.f = this.d.b("xUnit");
    this.g = this.d.b("coeffs");
    GLES20.glUniform1i(this.d.b("oesTex"), 0);
    GlUtil.a("Initialize fragment shader uniform values.");
  }
  
  public ByteBuffer a(int paramInt) {
    this.i.a();
    if (!this.j) {
      int i = this.o;
      if (i % 8 == 0) {
        this.d.a();
        this.d.a("in_pos", 2, a);
        this.d.a("in_tc", 2, this.b);
        int j = this.o;
        int i1 = (j + 3) / 4;
        j = (j + 7) / 8;
        int m = this.p;
        int k = (m + 1) / 2;
        m += k;
        float[] arrayOfFloat = c.a(GlUtil.a, c.a());
        int n = i / 4;
        this.c.a(n, m);
        GLES20.glBindFramebuffer(36160, this.c.a());
        GlUtil.a("glBindFramebuffer");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, paramInt);
        GLES20.glUniformMatrix4fv(this.e, 1, false, arrayOfFloat, 0);
        GLES20.glViewport(0, 0, i1, this.p);
        paramInt = this.f;
        float f = arrayOfFloat[0];
        i1 = this.o;
        GLES20.glUniform2f(paramInt, f / i1, arrayOfFloat[1] / i1);
        GLES20.glUniform4f(this.g, 0.299F, 0.587F, 0.114F, 0.0F);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glViewport(0, this.p, j, k);
        paramInt = this.f;
        f = arrayOfFloat[0];
        i1 = this.o;
        GLES20.glUniform2f(paramInt, f * 2.0F / i1, arrayOfFloat[1] * 2.0F / i1);
        GLES20.glUniform4f(this.g, -0.169F, -0.331F, 0.499F, 0.5F);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glViewport(i / 8, this.p, j, k);
        GLES20.glUniform4f(this.g, 0.499F, -0.418F, -0.0813F, 0.5F);
        GLES20.glDrawArrays(5, 0, 4);
        if (GlUtil.a()) {
          if (this.h == 0)
            this.h = GlUtil.b(this.o * this.p * 3 / 2); 
          GLES20.glBindBuffer(35051, this.h);
          GlUtil.read(0, 0, n, m, 6408, 5121, 0);
          this.k = (ByteBuffer)GLES30.glMapBufferRange(35051, 0, this.o * this.p * 3 / 2, 1);
        } else {
          if (this.k == null)
            this.k = ByteBuffer.allocate(this.o * this.p * 3 / 2); 
          this.k.clear();
          GLES20.glReadPixels(0, 0, n, m, 6408, 5121, this.k);
        } 
        GlUtil.a("YuvReader.read");
        if (this.l == null)
          this.l = ByteBuffer.allocate(this.o * this.p * 3 / 2); 
        this.l.clear();
        ByteBuffer byteBuffer = this.k;
        if (byteBuffer != null) {
          byteBuffer.clear();
          this.k.position(0);
          this.k.limit(this.o * this.p);
          this.l.put(this.k);
          j = this.p;
          while (true) {
            k = this.p;
            paramInt = k;
            if (j < k * 3 / 2) {
              this.k.clear();
              byteBuffer = this.k;
              paramInt = j * i;
              byteBuffer.position(paramInt);
              this.k.limit(paramInt + i / 2);
              this.l.put(this.k);
              j++;
              continue;
            } 
            break;
          } 
          while (paramInt < this.p * 3 / 2) {
            this.k.clear();
            byteBuffer = this.k;
            j = i / 2;
            k = paramInt * i + j;
            byteBuffer.position(k);
            this.k.limit(k + j);
            this.l.put(this.k);
            paramInt++;
          } 
          this.l.clear();
        } 
        if (GlUtil.a()) {
          GLES30.glUnmapBuffer(35051);
          GLES20.glBindBuffer(35051, 0);
        } 
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(3553, 0);
        return this.l;
      } 
      throw new IllegalArgumentException("Invalid stride, must be a multiple of 8");
    } 
    throw new IllegalStateException("YuvReader.read called on released object");
  }
  
  public void a() {
    this.i.a();
    this.j = true;
    this.d.b();
    this.c.b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\gl\texread\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */