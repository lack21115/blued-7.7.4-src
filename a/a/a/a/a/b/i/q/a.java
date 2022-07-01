package a.a.a.a.a.b.i.q;

import a.a.a.a.a.a.h.f;
import a.a.a.a.a.b.i.b;
import a.a.a.a.a.b.i.c;
import a.a.a.a.a.b.i.e;
import android.opengl.GLES20;
import android.opengl.GLES30;
import com.qiniu.pili.droid.streaming.av.encoder.PLH264Encoder;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class a {
  public static final FloatBuffer a = f.a(new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F });
  
  public static final FloatBuffer b = f.a(new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F });
  
  public final c c;
  
  public final b d;
  
  public final int e;
  
  public final int f;
  
  public final int g;
  
  public int h;
  
  public final b i;
  
  public boolean j;
  
  public ByteBuffer k;
  
  public ByteBuffer l;
  
  public a() {
    b b2 = new b();
    this.i = b2;
    this.j = false;
    b2.a();
    this.c = new c(6408);
    b b1 = new b("varying vec2 interp_tc;\nattribute vec4 in_pos;\nattribute vec4 in_tc;\n\nuniform mat4 texMatrix;\n\nvoid main() {\n    gl_Position = in_pos;\n    interp_tc = (texMatrix * in_tc).xy;\n}\n", "precision mediump float;\nvarying vec2 interp_tc;\n\nuniform sampler2D oesTex;\nuniform vec2 xUnit;\nuniform vec4 coeffs;\n\nvoid main() {\n  gl_FragColor.r = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc - 1.5 * xUnit).rgb);\n  gl_FragColor.g = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc - 0.5 * xUnit).rgb);\n  gl_FragColor.b = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc + 0.5 * xUnit).rgb);\n  gl_FragColor.a = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc + 1.5 * xUnit).rgb);\n}\n");
    this.d = b1;
    b1.a();
    this.e = this.d.b("texMatrix");
    this.f = this.d.b("xUnit");
    this.g = this.d.b("coeffs");
    GLES20.glUniform1i(this.d.b("oesTex"), 0);
    f.a("Initialize fragment shader uniform values.");
    this.d.a("in_pos", 2, a);
    this.d.a("in_tc", 2, b);
  }
  
  public ByteBuffer a(int paramInt1, int paramInt2, int paramInt3) {
    this.i.a();
    if (!this.j) {
      if (paramInt2 % 8 == 0) {
        this.d.a();
        int n = (paramInt2 + 3) / 4;
        int i = (paramInt2 + 7) / 8;
        int j = (paramInt3 + 1) / 2;
        int k = paramInt3 + j;
        float[] arrayOfFloat = e.a(f.c, e.a());
        int m = paramInt2 / 4;
        this.c.a(m, k);
        GLES20.glBindFramebuffer(36160, this.c.a());
        f.a("glBindFramebuffer");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, paramInt1);
        GLES20.glUniformMatrix4fv(this.e, 1, false, arrayOfFloat, 0);
        GLES20.glViewport(0, 0, n, paramInt3);
        paramInt1 = this.f;
        float f1 = arrayOfFloat[0];
        float f2 = paramInt2;
        GLES20.glUniform2f(paramInt1, f1 / f2, arrayOfFloat[1] / f2);
        GLES20.glUniform4f(this.g, 0.299F, 0.587F, 0.114F, 0.0F);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glViewport(0, paramInt3, i, j);
        GLES20.glUniform2f(this.f, arrayOfFloat[0] * 2.0F / f2, arrayOfFloat[1] * 2.0F / f2);
        GLES20.glUniform4f(this.g, -0.169F, -0.331F, 0.499F, 0.5F);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glViewport(paramInt2 / 8, paramInt3, i, j);
        GLES20.glUniform4f(this.g, 0.499F, -0.418F, -0.0813F, 0.5F);
        GLES20.glDrawArrays(5, 0, 4);
        if (f.b()) {
          if (this.h == 0)
            this.h = f.b(paramInt2 * paramInt3 * 3 / 2); 
          GLES20.glBindBuffer(35051, this.h);
          PLH264Encoder.getPixelFromPBO(0, 0, m, k, 6408, 5121, 0);
          this.k = (ByteBuffer)GLES30.glMapBufferRange(35051, 0, paramInt2 * paramInt3 * 3 / 2, 1);
        } else {
          if (this.k == null)
            this.k = ByteBuffer.allocate(paramInt2 * paramInt3 * 3 / 2); 
          this.k.clear();
          GLES20.glReadPixels(0, 0, m, k, 6408, 5121, this.k);
        } 
        f.a("YuvConverter.convert");
        if (this.l == null)
          this.l = ByteBuffer.allocate(paramInt2 * paramInt3 * 3 / 2); 
        this.l.clear();
        ByteBuffer byteBuffer = this.k;
        if (byteBuffer != null) {
          byteBuffer.clear();
          this.k.position(0);
          this.k.limit(paramInt2 * paramInt3);
          this.l.put(this.k);
          i = paramInt3;
          while (true) {
            j = paramInt3 * 3 / 2;
            paramInt1 = paramInt3;
            if (i < j) {
              this.k.clear();
              byteBuffer = this.k;
              paramInt1 = i * paramInt2;
              byteBuffer.position(paramInt1);
              this.k.limit(paramInt1 + paramInt2 / 2);
              this.l.put(this.k);
              i++;
              continue;
            } 
            break;
          } 
          while (paramInt1 < j) {
            this.k.clear();
            byteBuffer = this.k;
            paramInt3 = paramInt2 / 2;
            i = paramInt1 * paramInt2 + paramInt3;
            byteBuffer.position(i);
            this.k.limit(i + paramInt3);
            this.l.put(this.k);
            paramInt1++;
          } 
          this.l.clear();
        } 
        if (f.b()) {
          GLES30.glUnmapBuffer(35051);
          GLES20.glBindBuffer(35051, 0);
        } 
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(3553, 0);
        return this.l;
      } 
      throw new IllegalArgumentException("Invalid stride, must be a multiple of 8");
    } 
    throw new IllegalStateException("YuvConverter.convert called on released object");
  }
  
  public void a() {
    this.i.a();
    this.j = true;
    this.d.b();
    this.c.b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\b\i\q\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */