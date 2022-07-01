package a.a.a.a.a.a.j.h;

import a.a.a.a.a.a.h.f;
import a.a.a.a.a.a.j.d;
import a.a.a.a.a.b.c;
import a.a.a.a.a.e.e;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class b extends a {
  public int o;
  
  public d p;
  
  public Object q = new Object();
  
  public b(Context paramContext, c paramc, a.a.a.a.a.a.b paramb, d paramd) {
    super(paramContext, paramc, paramb);
    this.p = paramd;
  }
  
  public void a() {
    d d1 = this.p;
    if (d1 == null) {
      e.c.e("TexturePictureStreamingManager", "mTextureMovieTransfer is null !!!");
      return;
    } 
    d1.a(this.o, System.nanoTime(), false);
  }
  
  public void a(Bitmap paramBitmap) {
    d d1 = this.p;
    if (d1 == null) {
      e.c.e("TexturePictureStreamingManager", "mTextureMovieTransfer is null !!!");
      return;
    } 
    d1.a(false);
    b(paramBitmap);
  }
  
  public void b() {
    this.o = 0;
    d d1 = this.p;
    if (d1 == null) {
      e.c.e("TexturePictureStreamingManager", "mTextureMovieTransfer is null !!!");
      return;
    } 
    d1.b(false);
  }
  
  public void b(Bitmap paramBitmap) {
    if (this.p.b().post(new a(this, paramBitmap)))
      synchronized (this.q) {
        int i = this.o;
        if (i == 0)
          try {
            this.q.wait();
          } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
          }  
        return;
      }  
  }
  
  public class a implements Runnable {
    public a(b this$0, Bitmap param1Bitmap) {}
    
    public void run() {
      Matrix matrix = new Matrix();
      matrix.postScale(1.0F, -1.0F, this.a.getWidth() / 2.0F, this.a.getHeight() / 2.0F);
      null = this.a;
      null = Bitmap.createBitmap(null, 0, 0, null.getWidth(), this.a.getHeight(), matrix, true);
      ByteBuffer byteBuffer = ByteBuffer.allocateDirect(null.getWidth() * null.getHeight() * 4);
      byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      if (null.getConfig() == Bitmap.Config.ARGB_8888) {
        null.copyPixelsToBuffer(byteBuffer);
        byteBuffer.position(0);
      } 
      synchronized (b.a(this.b)) {
        b.a(this.b, f.a(byteBuffer, null.getWidth(), null.getHeight(), 6408));
        b.a(this.b).notify();
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\a\j\h\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */