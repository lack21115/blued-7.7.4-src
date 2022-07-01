package a.a.a.a.a.a.i;

import a.a.a.a.a.a.b;
import a.a.a.a.a.e.e;
import com.qiniu.pili.droid.streaming.core.PLDroidStreamingCore;

public class a extends d {
  public a() {
    super(2);
  }
  
  public boolean a(b paramb) {
    e.f.c("PLAVMuxer", "prepare");
    if (this.C) {
      e.f.c("PLAVMuxer", "mStreamingPaused");
      return false;
    } 
    b(paramb);
    d().a(b.c.b, null);
    r();
    this.X = 0L;
    u();
    if (i())
      this.f = new byte[1024]; 
    s();
    a("PLAVMuxer");
    return this.k ^ true;
  }
  
  public int a_(c.g paramg) {
    return a(paramg);
  }
  
  public void b(c.g paramg) {
    if (paramg.b == 1) {
      e.f.b("PLAVMuxer", "Capture SPS + PPS");
      c(paramg.d.mBuffer, paramg.a);
      e e = e.f;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("VIDEO CONFIG LENGTH: ");
      stringBuilder.append(this.p.length);
      stringBuilder.append(", pts:");
      stringBuilder.append(paramg.a.presentationTimeUs / 1000L);
      e.b("PLAVMuxer", stringBuilder.toString());
      PLDroidStreamingCore pLDroidStreamingCore = this.g;
      byte[] arrayOfByte = this.p;
      pLDroidStreamingCore.writeVideoSeqHeader(arrayOfByte, arrayOfByte.length, paramg.a.presentationTimeUs / 1000L);
    } else {
      a(paramg.d.mBuffer, paramg.a);
      e e = e.f;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("AUDIO CONFIG LENGTH: ");
      stringBuilder.append(this.q.length);
      stringBuilder.append(", pts:");
      stringBuilder.append(paramg.a.presentationTimeUs / 1000L);
      e.b("PLAVMuxer", stringBuilder.toString());
      PLDroidStreamingCore pLDroidStreamingCore = this.g;
      byte[] arrayOfByte = this.q;
      pLDroidStreamingCore.writeAudioSeqHeader(arrayOfByte, arrayOfByte.length, paramg.a.presentationTimeUs / 1000L);
    } 
    if (this.p != null && this.q != null && d().s() != b.c.e) {
      d().a(b.c.d, null);
      e e = e.f;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("writeHeader :mIsNeedUpdateAVOption=");
      stringBuilder.append(this.D);
      e.c("PLAVMuxer", stringBuilder.toString());
    } 
    a(paramg.a, paramg.d, paramg.c, paramg.b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\a\i\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */