package com.blued.android.module.external_sense_library.test.gles;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.util.Log;
import com.blued.android.module.external_sense_library.utils.HandlerUtils;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class EglSurfaceBase {
  protected EglCore a;
  
  private EGLSurface b = EGL14.EGL_NO_SURFACE;
  
  private int c = -1;
  
  private int d = -1;
  
  protected EglSurfaceBase(EglCore paramEglCore) {
    this.a = paramEglCore;
  }
  
  public int a() {
    int j = this.c;
    int i = j;
    if (j < 0)
      i = this.a.a(this.b, 12375); 
    return i;
  }
  
  public void a(int paramInt1, int paramInt2) {
    if (this.b == EGL14.EGL_NO_SURFACE) {
      this.b = this.a.a(paramInt1, paramInt2);
      this.c = paramInt1;
      this.d = paramInt2;
      return;
    } 
    throw new IllegalStateException("surface already created");
  }
  
  public void a(File paramFile) throws IOException {
    if (this.a.c(this.b)) {
      String str = paramFile.toString();
      int i = a();
      int j = b();
      ByteBuffer byteBuffer = ByteBuffer.allocateDirect(i * j * 4);
      byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      GLES20.glReadPixels(0, 0, i, j, 6408, 5121, byteBuffer);
      GlUtil.a("glReadPixels");
      byteBuffer.rewind();
      try {
        Bitmap bitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        bitmap.copyPixelsFromBuffer(byteBuffer);
        HandlerUtils.a(new File(str), bitmap);
        bitmap.recycle();
      } catch (Exception exception) {}
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Saved ");
      stringBuilder.append(i);
      stringBuilder.append("x");
      stringBuilder.append(j);
      stringBuilder.append(" frame as '");
      stringBuilder.append(str);
      stringBuilder.append("'");
      Log.d("Grafika", stringBuilder.toString());
      return;
    } 
    throw new RuntimeException("Expected EGL context/surface is not current");
  }
  
  public int b() {
    int j = this.d;
    int i = j;
    if (j < 0)
      i = this.a.a(this.b, 12374); 
    return i;
  }
  
  public void c() {
    this.a.a(this.b);
    this.b = EGL14.EGL_NO_SURFACE;
    this.d = -1;
    this.c = -1;
  }
  
  public void d() {
    this.a.b(this.b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\test\gles\EglSurfaceBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */