package a.a.a.a.a.a.j.i;

import a.a.a.a.a.a.a;
import a.a.a.a.a.a.b;
import a.a.a.a.a.a.g.a;
import a.a.a.a.a.a.g.b;
import a.a.a.a.a.a.g.d;
import a.a.a.a.a.a.i.c;
import a.a.a.a.a.a.j.f;
import a.a.a.a.a.e.e;
import a.a.a.a.a.e.f;
import android.graphics.Point;
import com.qiniu.pili.droid.streaming.StreamingProfile;
import com.qiniu.pili.droid.streaming.WatermarkSetting;
import com.qiniu.pili.droid.streaming.av.common.PLAVFrame;
import com.qiniu.pili.droid.streaming.av.common.PLBufferInfo;
import com.qiniu.pili.droid.streaming.av.encoder.PLH264Encoder;

public class a extends a implements a {
  public a(f.a parama) {
    super(parama.a);
    WatermarkSetting watermarkSetting;
    parama.a.a((c.d)this);
    b b = parama.a.d();
    e e = e.f;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("encodingSize.width:");
    stringBuilder.append(b.a().a());
    stringBuilder.append(", encodingSize.height:");
    stringBuilder.append(b.a().b());
    stringBuilder.append(",rotation:");
    stringBuilder.append(parama.e);
    e.c("PLSoftVideoEncoderCore", stringBuilder.toString());
    int i = b.a().a();
    int j = b.a().b();
    Point point = b.c();
    f f = b.b();
    int k = b.r();
    int m = b.d();
    int n = b.p();
    boolean bool1 = b.f().b();
    int i1 = parama.b;
    int i2 = parama.c;
    int i3 = parama.d;
    int i4 = point.x;
    int i5 = point.y;
    int i6 = f.a();
    int i7 = f.b();
    boolean bool2 = parama.m;
    int i8 = parama.e;
    int i9 = parama.f;
    StreamingProfile.EncoderRCModes encoderRCModes = b.f().getEncoderRCMode();
    StreamingProfile.a a1 = b.f().getCPUWorkload();
    StreamingProfile.H264Profile h264Profile = b.f().getVideoProfile().getH264Profile();
    if (parama.j) {
      parama = null;
    } else {
      watermarkSetting = parama.h;
    } 
    d d = new d(new PLH264Encoder.Parameters(i1, i2, i3, i4, i5, i6, i7, i, j, k, m, n, bool2, i8, i9, encoderRCModes, a1, h264Profile, watermarkSetting, bool1));
    this.b = (b)d;
    d.a(this);
    this.b.d();
    this.c = 1;
  }
  
  public void a(PLAVFrame paramPLAVFrame, PLBufferInfo paramPLBufferInfo) {
    this.b.a(this.a, paramPLAVFrame, paramPLBufferInfo, false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\a\j\i\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */