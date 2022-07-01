package a.a.a.a.a.a.j.h;

import a.a.a.a.a.a.b;
import a.a.a.a.a.a.j.f;
import a.a.a.a.a.a.j.g;
import a.a.a.a.a.e.e;
import a.a.a.a.a.e.h;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.qiniu.pili.droid.streaming.StreamingPreviewCallback;
import com.qiniu.pili.droid.streaming.av.common.PLFourCC;
import java.nio.ByteBuffer;

public class c extends a {
  public g o;
  
  public f.a p;
  
  public ByteBuffer q;
  
  public StreamingPreviewCallback r;
  
  public c(Context paramContext, a.a.a.a.a.b.c paramc, b paramb, g paramg, f.a parama, StreamingPreviewCallback paramStreamingPreviewCallback) {
    super(paramContext, paramc, paramb);
    this.o = paramg;
    this.p = parama;
    this.r = paramStreamingPreviewCallback;
  }
  
  public void a() {
    if (d()) {
      g g1 = this.o;
      if (g1 == null) {
        e.c.e("YUVPictureStreamingManager", "mYuvDataTransfer is null !!!");
        return;
      } 
      ByteBuffer byteBuffer = this.q;
      g1.a(byteBuffer, byteBuffer.capacity(), System.nanoTime());
    } 
    StreamingPreviewCallback streamingPreviewCallback = this.r;
    if (streamingPreviewCallback != null) {
      byte[] arrayOfByte = this.q.array();
      f.a a1 = this.p;
      streamingPreviewCallback.onPreviewFrame(arrayOfByte, a1.b, a1.c, a1.e, a1.f, System.nanoTime());
    } 
  }
  
  public void a(f.a parama) {
    boolean bool = this.p.m;
    this.p = parama;
    parama.m = bool;
    String str = this.b;
    if (str != null) {
      a(str);
      return;
    } 
    a(this.c);
  }
  
  public void a(Bitmap paramBitmap) {
    if (this.p == null) {
      e.c.e("YUVPictureStreamingManager", "mCurrentTransferSessionCfg is null !!!");
      return;
    } 
    if (d()) {
      this.o.b(false);
      this.o.a(this.p);
      this.o.a(false);
    } 
    b(paramBitmap);
  }
  
  public void b() {
    this.q = null;
    if (!d())
      return; 
    g g1 = this.o;
    if (g1 == null) {
      e.c.e("YUVPictureStreamingManager", "mYuvDataTransfer is null !!!");
      return;
    } 
    g1.b(false);
  }
  
  public void b(Bitmap paramBitmap) {
    Matrix matrix = new Matrix();
    matrix.postRotate(-this.p.e);
    if (this.p.m)
      matrix.postScale(1.0F, -1.0F, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F); 
    paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), matrix, true);
    f.a a1 = this.p;
    int i = a1.b;
    int j = a1.c;
    boolean bool = true;
    paramBitmap = Bitmap.createScaledBitmap(paramBitmap, i, j, true);
    i = paramBitmap.getWidth();
    j = paramBitmap.getHeight();
    if (this.p.f != PLFourCC.FOURCC_NV21)
      bool = false; 
    this.q = ByteBuffer.wrap(h.a(i, j, paramBitmap, bool));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\a\j\h\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */