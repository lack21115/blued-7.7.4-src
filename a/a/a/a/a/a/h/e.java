package a.a.a.a.a.a.h;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class e {
  public static int a = 12375;
  
  public static int b = 12374;
  
  public d c;
  
  public Object d = null;
  
  public int e = -1;
  
  public int f = -1;
  
  public e(d paramd) {
    this.c = paramd;
  }
  
  public int a() {
    int j = this.e;
    int i = j;
    if (j < 0)
      i = this.c.a(this.d, a); 
    return i;
  }
  
  public void a(int paramInt1, int paramInt2) {
    if (this.d == null) {
      this.d = this.c.a(paramInt1, paramInt2);
      this.e = paramInt1;
      this.f = paramInt2;
      return;
    } 
    throw new IllegalStateException("surface already created");
  }
  
  public void a(long paramLong) {
    this.c.a(this.d, paramLong);
  }
  
  public void a(Object paramObject) {
    if (this.d == null) {
      this.d = this.c.b(paramObject);
      return;
    } 
    throw new IllegalStateException("surface already created");
  }
  
  public int b() {
    int j = this.f;
    int i = j;
    if (j < 0)
      i = this.c.a(this.d, b); 
    return i;
  }
  
  public void c() {
    this.c.a(this.d);
    this.d = null;
    this.f = -1;
    this.e = -1;
  }
  
  public void d() {
    this.c.c(this.d);
  }
  
  public boolean e() {
    boolean bool = this.c.d(this.d);
    if (!bool)
      a.a.a.a.a.e.e.c.b("GlUtil", "WARNING: swapBuffers() failed"); 
    return bool;
  }
  
  public Bitmap f() {
    if (this.c.e(this.d)) {
      int i = a();
      int j = b();
      ByteBuffer byteBuffer = ByteBuffer.allocateDirect(i * j * 4);
      byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      GLES20.glReadPixels(0, 0, i, j, 6408, 5121, byteBuffer);
      f.b("glReadPixels");
      byteBuffer.rewind();
      Bitmap bitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      bitmap.copyPixelsFromBuffer(byteBuffer);
      a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.c;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("captured ");
      stringBuilder.append(i);
      stringBuilder.append("x");
      stringBuilder.append(j);
      e1.b("GlUtil", stringBuilder.toString());
      return bitmap;
    } 
    throw new RuntimeException("Expected EGL context/surface is not current");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\a\h\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */