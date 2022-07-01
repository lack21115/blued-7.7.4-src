package a.a.a.a.a.a;

import a.a.a.a.a.a.g.b;
import a.a.a.a.a.a.i.c;
import a.a.a.a.a.a.j.a;
import a.a.a.a.a.a.j.f;
import a.a.a.a.a.e.e;
import android.media.MediaCodec;
import com.qiniu.pili.droid.streaming.WatermarkSetting;
import com.qiniu.pili.droid.streaming.av.common.PLAVFrame;
import com.qiniu.pili.droid.streaming.av.encoder.PLAACEncoder;

public abstract class a implements c.d {
  public c a;
  
  public b b;
  
  public int c;
  
  public a(c paramc) {
    this.a = paramc;
    int i = paramc.d().r();
    a.a().a(i);
  }
  
  public void a() {
    b b1 = this.b;
    if (b1 != null)
      b1.b(); 
  }
  
  public void a(int paramInt) {
    b b1 = this.b;
    if (b1 != null)
      b1.a(paramInt); 
  }
  
  public void a(WatermarkSetting paramWatermarkSetting) {
    b b1 = this.b;
    if (b1 != null)
      b1.a(paramWatermarkSetting); 
  }
  
  public void a(PLAVFrame paramPLAVFrame, int paramInt) {
    b b1 = this.b;
    if (b1 != null)
      b1.a(paramPLAVFrame, paramInt); 
  }
  
  public void a(PLAVFrame paramPLAVFrame, f.a parama, boolean paramBoolean) {
    b b1 = this.b;
    if (b1 != null)
      b1.a(paramPLAVFrame, parama, paramBoolean); 
  }
  
  public void a(boolean paramBoolean) {
    b b1 = this.b;
    if (b1 != null)
      try {
        b1.a(this.a, paramBoolean);
        return;
      } catch (IllegalStateException illegalStateException) {
        illegalStateException.printStackTrace();
      }  
  }
  
  public PLAVFrame b(int paramInt) {
    b b1 = this.b;
    return (b1 != null) ? b1.b(paramInt) : null;
  }
  
  public void b() {
    c c1 = this.a;
    if (c1 != null)
      c1.b(this.c); 
    b b1 = this.b;
    if (b1 != null)
      b1.a(); 
  }
  
  public MediaCodec c() {
    if (this.b.c() instanceof MediaCodec)
      return (MediaCodec)this.b.c(); 
    e.i.e("Encoder", "error, it's not a MediaCodec");
    return null;
  }
  
  public PLAACEncoder d() {
    if (this.b.c() instanceof PLAACEncoder)
      return (PLAACEncoder)this.b.c(); 
    e.i.e("Encoder", "error, it's not a PLAACEncoder");
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */