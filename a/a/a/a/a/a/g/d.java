package a.a.a.a.a.a.g;

import a.a.a.a.a.a.i.c;
import a.a.a.a.a.a.j.f;
import a.a.a.a.a.e.e;
import android.view.Surface;
import com.qiniu.pili.droid.streaming.WatermarkSetting;
import com.qiniu.pili.droid.streaming.av.common.PLAVFrame;
import com.qiniu.pili.droid.streaming.av.common.PLBufferInfo;
import com.qiniu.pili.droid.streaming.av.encoder.PLAACEncoder;
import com.qiniu.pili.droid.streaming.av.encoder.PLH264Encoder;

public class d extends b {
  public PLH264Encoder b;
  
  public PLAACEncoder c;
  
  public d(PLAACEncoder.Parameters paramParameters) {
    this.c = new PLAACEncoder(paramParameters);
  }
  
  public d(PLH264Encoder.Parameters paramParameters) {
    PLH264Encoder pLH264Encoder = new PLH264Encoder();
    this.b = pLH264Encoder;
    pLH264Encoder.a(paramParameters);
  }
  
  public void a() {
    PLH264Encoder pLH264Encoder = this.b;
    if (pLH264Encoder != null) {
      pLH264Encoder.a();
      return;
    } 
    PLAACEncoder pLAACEncoder = this.c;
    if (pLAACEncoder != null)
      pLAACEncoder.release(); 
  }
  
  public void a(int paramInt) {
    PLH264Encoder pLH264Encoder = this.b;
    if (pLH264Encoder != null)
      pLH264Encoder.a(paramInt); 
  }
  
  public void a(a parama) {
    PLH264Encoder pLH264Encoder = this.b;
    if (pLH264Encoder != null) {
      pLH264Encoder.a(parama);
      return;
    } 
    PLAACEncoder pLAACEncoder = this.c;
    if (pLAACEncoder != null)
      pLAACEncoder.a(parama); 
  }
  
  public void a(c paramc, PLAVFrame paramPLAVFrame, PLBufferInfo paramPLBufferInfo, boolean paramBoolean) {
    e e = e.i;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("drainEncoder + endOfStream:");
    stringBuilder.append(paramBoolean);
    e.a("PLSWEncoder", stringBuilder.toString());
    if (this.b != null) {
      if (paramBoolean) {
        if (paramPLAVFrame == null) {
          paramc.a();
        } else {
          paramPLBufferInfo.flags |= 0x4;
          paramc.a(1, paramPLAVFrame.mSize, paramPLAVFrame, paramPLBufferInfo);
        } 
      } else {
        if ((paramPLBufferInfo.flags & 0x2) != 0)
          paramc.a(1); 
        paramc.a(1, paramPLAVFrame.mSize, paramPLAVFrame, paramPLBufferInfo);
      } 
    } else if (this.c != null) {
      if (paramBoolean) {
        if (paramPLAVFrame == null) {
          paramc.a();
        } else {
          paramPLBufferInfo.flags |= 0x4;
          paramc.a(0, paramPLAVFrame.mSize, paramPLAVFrame, paramPLBufferInfo);
        } 
      } else {
        if ((paramPLBufferInfo.flags & 0x2) != 0)
          paramc.a(0); 
        paramc.a(0, paramPLAVFrame.mSize, paramPLAVFrame, paramPLBufferInfo);
      } 
    } 
    e.i.a("PLSWEncoder", "drainEncoder -");
  }
  
  public void a(c paramc, boolean paramBoolean) {
    if (paramBoolean)
      paramc.a(); 
  }
  
  public void a(WatermarkSetting paramWatermarkSetting) {
    PLH264Encoder pLH264Encoder = this.b;
    if (pLH264Encoder != null)
      pLH264Encoder.a(paramWatermarkSetting); 
  }
  
  public void a(PLAVFrame paramPLAVFrame, int paramInt) {
    paramPLAVFrame.mBuffer.limit(0);
    paramPLAVFrame.mBuffer.clear();
    PLH264Encoder pLH264Encoder = this.b;
    if (pLH264Encoder != null) {
      pLH264Encoder.c(paramPLAVFrame);
      return;
    } 
    PLAACEncoder pLAACEncoder = this.c;
    if (pLAACEncoder != null)
      pLAACEncoder.b(paramPLAVFrame); 
  }
  
  public void a(PLAVFrame paramPLAVFrame, f.a parama, boolean paramBoolean) {
    PLH264Encoder pLH264Encoder = this.b;
    if (pLH264Encoder != null)
      pLH264Encoder.a(paramPLAVFrame, parama, paramBoolean); 
  }
  
  public PLAVFrame b(int paramInt) {
    PLH264Encoder pLH264Encoder = this.b;
    return (pLH264Encoder != null) ? pLH264Encoder.b(paramInt) : null;
  }
  
  public void b() {
    e.i.c("PLSWEncoder", "signalEndOfStream");
  }
  
  public Object c() {
    PLH264Encoder pLH264Encoder = this.b;
    if (pLH264Encoder != null)
      return pLH264Encoder; 
    PLAACEncoder pLAACEncoder = this.c;
    return (pLAACEncoder != null) ? pLAACEncoder : null;
  }
  
  public void d() {
    PLH264Encoder pLH264Encoder = this.b;
    if (pLH264Encoder != null)
      pLH264Encoder.b(); 
  }
  
  public Surface e() {
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\a\g\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */