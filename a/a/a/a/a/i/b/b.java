package a.a.a.a.a.i.b;

import a.a.a.a.a.a.h.f;
import a.a.a.a.a.e.e;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.util.Pair;
import com.qiniu.pili.droid.streaming.WatermarkSetting;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class b extends a {
  public int a;
  
  public int b;
  
  public int c;
  
  public int d;
  
  public int e;
  
  public int f;
  
  public a.a g;
  
  public float h;
  
  public b(int paramInt) {
    a.a a1 = a.a.a;
    this.g = a1;
    int i = a(a1);
    this.a = i;
    if (i != 0) {
      c();
      this.h = paramInt / 255.0F;
      return;
    } 
    throw new RuntimeException("Unable to create program");
  }
  
  public static ByteBuffer a(Bitmap paramBitmap) {
    ByteBuffer byteBuffer = ByteBuffer.allocateDirect(paramBitmap.getWidth() * paramBitmap.getHeight() * 4);
    byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    if (paramBitmap.getConfig() == Bitmap.Config.ARGB_8888) {
      paramBitmap.copyPixelsToBuffer(byteBuffer);
      byteBuffer.position(0);
    } 
    return byteBuffer;
  }
  
  public static FloatBuffer a() {
    return f.a(new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F });
  }
  
  public static FloatBuffer a(WatermarkSetting paramWatermarkSetting, int paramInt1, int paramInt2) {
    float[] arrayOfFloat;
    FloatBuffer floatBuffer;
    Pair pair = paramWatermarkSetting.calculateWHRatio(paramInt1, paramInt2);
    float f2 = ((Float)pair.first).floatValue() * 2.0F;
    float f1 = ((Float)pair.second).floatValue() * 2.0F;
    boolean bool = paramWatermarkSetting.isCustomPositionSet();
    pair = null;
    if (bool) {
      float f4 = paramWatermarkSetting.getCustomPositionX();
      float f3 = paramWatermarkSetting.getCustomPositionY();
      f4 = f4 * 2.0F - 1.0F;
      float f5 = (f3 * 2.0F - 1.0F) * -1.0F;
      f3 = f4;
      if (f4 + f2 > 1.0F)
        f3 = 1.0F - f2; 
      f4 = f5;
      if (f5 - f1 < -1.0F)
        f4 = -(1.0F - f1); 
      arrayOfFloat = new float[8];
      arrayOfFloat[0] = f3;
      f5 = f4 - f1;
      arrayOfFloat[1] = f5;
      f1 = f2 + f3;
      arrayOfFloat[2] = f1;
      arrayOfFloat[3] = f5;
      arrayOfFloat[4] = f3;
      arrayOfFloat[5] = f4;
      arrayOfFloat[6] = f1;
      arrayOfFloat[7] = f4;
    } else {
      WatermarkSetting.WATERMARK_LOCATION wATERMARK_LOCATION = arrayOfFloat.getWatermarkLocation();
      if (wATERMARK_LOCATION == WatermarkSetting.WATERMARK_LOCATION.NORTH_WEST) {
        arrayOfFloat = new float[8];
        arrayOfFloat[0] = -1.0F;
        float f3 = 1.0F - f1;
        arrayOfFloat[1] = f3;
        float f4 = f2 - 1.0F;
        arrayOfFloat[2] = f4;
        arrayOfFloat[3] = f3;
        arrayOfFloat[4] = -1.0F;
        arrayOfFloat[5] = 1.0F;
        arrayOfFloat[6] = f4;
        arrayOfFloat[7] = 1.0F;
      } else if (arrayOfFloat == WatermarkSetting.WATERMARK_LOCATION.NORTH_EAST) {
        arrayOfFloat = new float[8];
        float f3 = 1.0F - f2;
        arrayOfFloat[0] = f3;
        float f4 = 1.0F - f1;
        arrayOfFloat[1] = f4;
        arrayOfFloat[2] = 1.0F;
        arrayOfFloat[3] = f4;
        arrayOfFloat[4] = f3;
        arrayOfFloat[5] = 1.0F;
        arrayOfFloat[6] = 1.0F;
        arrayOfFloat[7] = 1.0F;
      } else if (arrayOfFloat == WatermarkSetting.WATERMARK_LOCATION.SOUTH_WEST) {
        arrayOfFloat = new float[8];
        arrayOfFloat[0] = -1.0F;
        arrayOfFloat[1] = -1.0F;
        float f3 = f2 - 1.0F;
        arrayOfFloat[2] = f3;
        arrayOfFloat[3] = -1.0F;
        arrayOfFloat[4] = -1.0F;
        float f4 = f1 - 1.0F;
        arrayOfFloat[5] = f4;
        arrayOfFloat[6] = f3;
        arrayOfFloat[7] = f4;
      } else if (arrayOfFloat == WatermarkSetting.WATERMARK_LOCATION.SOUTH_EAST) {
        arrayOfFloat = new float[8];
        float f = 1.0F - f2;
        arrayOfFloat[0] = f;
        arrayOfFloat[1] = -1.0F;
        arrayOfFloat[2] = 1.0F;
        arrayOfFloat[3] = -1.0F;
        arrayOfFloat[4] = f;
        f = f1 - 1.0F;
        arrayOfFloat[5] = f;
        arrayOfFloat[6] = 1.0F;
        arrayOfFloat[7] = f;
      } else {
        e.c.e("WatermarkFilter", "ERROR: pass in wrong location.");
        arrayOfFloat = null;
      } 
    } 
    if (arrayOfFloat != null)
      floatBuffer = f.a(arrayOfFloat); 
    return floatBuffer;
  }
  
  public int a(a.a parama) {
    return f.a("uniform mat4 uMVPMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = aTextureCoord.xy;\n}\n", "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D uTexture;\nuniform float uOpacity;\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTextureCoord) * uOpacity;\n}\n");
  }
  
  public void a(int paramInt) {
    GLES20.glActiveTexture(33984);
    f.b("active texture.");
    GLES20.glBindTexture(b(), paramInt);
    f.b("bind texture.");
    GLES20.glUniform1i(this.f, 0);
  }
  
  public void a(int paramInt1, int paramInt2) {
    GLES20.glBlendEquationSeparate(32774, 32774);
    GLES20.glBlendFuncSeparate(1, 771, 1, 1);
    GLES20.glEnable(3042);
    GLES20.glDrawArrays(5, paramInt1, paramInt2);
    f.b("Draw watermark");
    GLES20.glDisable(3042);
  }
  
  public void a(float[] paramArrayOffloat, FloatBuffer paramFloatBuffer1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, FloatBuffer paramFloatBuffer2, int paramInt5, int paramInt6) {
    f.b("draw start");
    d();
    a(paramInt5);
    a(paramArrayOffloat, paramFloatBuffer1, paramInt3, paramInt4, paramFloatBuffer2, paramInt6);
    a(paramInt1, paramInt2);
    e();
    f();
    g();
    f.b("draw start");
  }
  
  public void a(float[] paramArrayOffloat, FloatBuffer paramFloatBuffer1, int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer2, int paramInt3) {
    GLES20.glUniform1f(this.e, this.h);
    GLES20.glUniformMatrix4fv(this.c, 1, false, paramArrayOffloat, 0);
    GLES20.glEnableVertexAttribArray(this.b);
    GLES20.glVertexAttribPointer(this.b, paramInt1, 5126, false, paramInt2, paramFloatBuffer1);
    GLES20.glEnableVertexAttribArray(this.d);
    GLES20.glVertexAttribPointer(this.d, 2, 5126, false, paramInt3, paramFloatBuffer2);
  }
  
  public int b() {
    return 3553;
  }
  
  public void c() {
    this.f = GLES20.glGetUniformLocation(this.a, "uTexture");
    this.e = GLES20.glGetUniformLocation(this.a, "uOpacity");
    this.b = GLES20.glGetAttribLocation(this.a, "aPosition");
    this.c = GLES20.glGetUniformLocation(this.a, "uMVPMatrix");
    this.d = GLES20.glGetAttribLocation(this.a, "aTextureCoord");
  }
  
  public void d() {
    GLES20.glUseProgram(this.a);
    f.b("glUseProgram");
  }
  
  public void e() {
    GLES20.glDisableVertexAttribArray(this.b);
    GLES20.glDisableVertexAttribArray(this.d);
  }
  
  public void f() {
    GLES20.glBindTexture(b(), 0);
  }
  
  public void g() {
    GLES20.glUseProgram(0);
  }
  
  public void h() {
    GLES20.glDeleteProgram(this.a);
    this.a = -1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\i\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */