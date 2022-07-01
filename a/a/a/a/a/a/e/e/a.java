package a.a.a.a.a.a.e.e;

import a.a.a.a.a.a.a;
import a.a.a.a.a.a.g.a;
import a.a.a.a.a.a.g.b;
import a.a.a.a.a.a.g.d;
import a.a.a.a.a.a.i.c;
import com.qiniu.pili.droid.streaming.av.common.PLAVFrame;
import com.qiniu.pili.droid.streaming.av.common.PLBufferInfo;
import com.qiniu.pili.droid.streaming.av.encoder.PLAACEncoder;

public class a extends a implements a {
  public a(c paramc) {
    super(paramc);
    paramc.b((c.d)this);
    a.a.a.a.a.a.e.a a1 = paramc.d().j();
    d d = new d(new PLAACEncoder.Parameters(a1.c(), a1.a(), a1.b(), 16));
    this.b = (b)d;
    d.d();
    this.b.a(this);
    this.c = 0;
  }
  
  public void a(PLAVFrame paramPLAVFrame, PLBufferInfo paramPLBufferInfo) {
    this.b.a(this.a, paramPLAVFrame, paramPLBufferInfo, false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\a\e\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */