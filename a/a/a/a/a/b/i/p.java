package a.a.a.a.a.b.i;

import a.a.a.a.a.a.h.f;
import a.a.a.a.a.e.e;
import a.a.a.a.a.i.b.b;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.qiniu.pili.droid.streaming.WatermarkSetting;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class p {
  public b a;
  
  public FloatBuffer b;
  
  public FloatBuffer c;
  
  public WatermarkSetting d;
  
  public int e;
  
  public int f;
  
  public int g;
  
  public int h;
  
  public int i;
  
  public int j;
  
  public int k;
  
  public int l;
  
  public int m;
  
  public int n;
  
  public void a() {
    b b1 = this.a;
    if (b1 != null) {
      b1.h();
      this.a = null;
    } 
    int i = this.e;
    if (i != 0) {
      GLES20.glDeleteTextures(1, new int[] { i }, 0);
      this.e = 0;
    } 
    i = this.n;
    if (i != 0) {
      GLES20.glDeleteFramebuffers(1, new int[] { i }, 0);
      this.n = 0;
    } 
  }
  
  public void a(int paramInt) {
    GLES20.glViewport(this.j, this.k, this.l, this.m);
    GLES20.glBindFramebuffer(36160, this.n);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt, 0);
    FloatBuffer floatBuffer = this.b;
    if (floatBuffer != null) {
      FloatBuffer floatBuffer1 = this.c;
      if (floatBuffer1 != null) {
        paramInt = this.e;
        if (paramInt != 0)
          this.a.a(f.c, floatBuffer, 0, this.f, this.g, this.i, floatBuffer1, paramInt, this.h); 
      } 
    } 
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  public boolean a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, WatermarkSetting paramWatermarkSetting) {
    float f = paramInt1;
    this.l = (int)(paramFloat3 * f);
    paramFloat3 = paramInt2;
    paramInt1 = (int)(paramFloat4 * paramFloat3);
    this.m = paramInt1;
    this.j = (int)(f * paramFloat1);
    this.k = (int)(paramFloat3 * (1.0F - paramFloat2)) - paramInt1;
    this.a = new b(paramWatermarkSetting.getAlpha());
    this.d = paramWatermarkSetting;
    this.g = 2;
    this.i = 8;
    this.f = 4;
    this.h = 8;
    b();
    return d();
  }
  
  public boolean a(int paramInt1, int paramInt2, WatermarkSetting paramWatermarkSetting) {
    return a(paramInt1, paramInt2, 0.0F, 0.0F, 1.0F, 1.0F, paramWatermarkSetting);
  }
  
  public final void b() {
    this.n = f.c();
  }
  
  public final void c() {
    WatermarkSetting watermarkSetting = this.d;
    if (watermarkSetting == null) {
      e.c.d("WatermarkSticker", "no settings for watermarkTexture");
      this.e = -1;
      return;
    } 
    Bitmap bitmap = watermarkSetting.getWatermarkBitmap();
    if (bitmap == null) {
      e.c.d("WatermarkSticker", "no resources for watermarkTexture");
      this.e = -1;
      return;
    } 
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    f.b("glGenTextures");
    this.e = arrayOfInt[0];
    e e = e.c;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("prepare watermark Texture:");
    stringBuilder.append(this.e);
    e.c("WatermarkSticker", stringBuilder.toString());
    GLES20.glBindTexture(3553, this.e);
    f.b("glBindTexture");
    ByteBuffer byteBuffer = b.a(bitmap);
    GLES20.glTexImage2D(3553, 0, 6408, bitmap.getWidth(), bitmap.getHeight(), 0, 6408, 5121, byteBuffer);
    f.b("glTexImage2D");
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glBindTexture(3553, 0);
    if (!bitmap.isRecycled())
      bitmap.recycle(); 
  }
  
  public final boolean d() {
    c();
    this.b = b.a(this.d, this.l, this.m);
    FloatBuffer floatBuffer = b.a();
    this.c = floatBuffer;
    return (this.e != -1 && this.b != null && floatBuffer != null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\b\i\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */