package a.a.a.a.a.a.i;

import a.a.a.a.a.a.f.a;
import a.a.a.a.a.e.e;
import a.a.a.a.a.e.h;
import com.qiniu.pili.droid.streaming.av.common.PLAVFrame;
import com.qiniu.pili.droid.streaming.av.common.PLBufferInfo;
import com.qiniu.pili.droid.streaming.core.PLDroidStreamingCore;

public class b extends c {
  public a a;
  
  public b() {
    super(1);
  }
  
  public int a(c.g paramg) {
    if (!d().t())
      d().a(a.a.a.a.a.a.b.c.e, null); 
    return super.a(paramg);
  }
  
  public void a() {
    e.f.c("PLAudioMuxer", "forceStop");
    if (!this.i) {
      e e = e.f;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("forceStop return immediately:mReady=");
      stringBuilder.append(this.i);
      e.c("PLAudioMuxer", stringBuilder.toString());
      return;
    } 
    this.m = true;
    e(new c.g(0, 0, null, null));
  }
  
  public void a(int paramInt1, int paramInt2, PLAVFrame paramPLAVFrame, PLBufferInfo paramPLBufferInfo) {
    super.a(paramInt1, paramInt2, paramPLAVFrame, paramPLBufferInfo);
    synchronized (this.h) {
      if (this.i) {
        e e = e.f;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("writeSampleData ====");
        stringBuilder.append(String.valueOf(paramInt1));
        stringBuilder.append(",frame.mBuffer:");
        stringBuilder.append(paramPLAVFrame.mBuffer.toString());
        e.a("PLAudioMuxer", stringBuilder.toString());
        try {
          synchronized (this.a) {
            PLAVFrame pLAVFrame = this.a.a(paramPLAVFrame.mBuffer.capacity());
            pLAVFrame.mBuffer.clear();
            pLAVFrame.mBuffer.put(paramPLAVFrame.mBuffer);
            pLAVFrame.mBuffer.position(0);
            a(paramInt1, paramPLAVFrame, paramInt2);
            e(new c.g(paramInt1, paramInt2, pLAVFrame, paramPLBufferInfo));
          } 
          return;
        } catch (OutOfMemoryError outOfMemoryError) {
          e.f.e("PLAudioMuxer", "OOM exception!");
          a(paramInt1, paramPLAVFrame, paramInt2);
          return;
        } 
      } 
      e.f.d("PLAudioMuxer", "Dropping frame because Muxer not ready!");
      a(paramInt1, paramPLAVFrame, paramInt2);
      return;
    } 
  }
  
  public void a(PLBufferInfo paramPLBufferInfo, PLAVFrame paramPLAVFrame, int paramInt1, int paramInt2) {
    synchronized (this.n) {
      if (!this.o) {
        e.f.a("PLAudioMuxer", " releaseOutputBufer encodedData.clear()!");
        paramPLAVFrame.mBuffer.clear();
        synchronized (this.a) {
          this.a.a(paramPLAVFrame);
        } 
      } 
      return;
    } 
  }
  
  public boolean a(a.a.a.a.a.a.b paramb) {
    e.f.c("PLAudioMuxer", "prepare");
    super.a(paramb);
    d().a(a.a.a.a.a.a.b.c.b, null);
    this.i = false;
    this.q = null;
    if (i())
      this.f = new byte[1024]; 
    if (this.a == null)
      this.a = new a(10); 
    a("PLAudioMuxer");
    return this.k ^ true;
  }
  
  public void b() {
    while (true) {
      c.g g = j();
      if (!this.m) {
        if (g.d == null)
          return; 
        if (c(g) < 0)
          return; 
        if (h.b(g.a)) {
          e e = e.f;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("handling BUFFER_FLAG_CODEC_CONFIG for track ");
          stringBuilder.append(g.b);
          e.c("PLAudioMuxer", stringBuilder.toString());
          if (g.a.size > 0) {
            b(g);
            continue;
          } 
          e.f.e("PLAudioMuxer", "error config buffer");
          return;
        } 
        if (!g() && h()) {
          int i = a(g);
          a(g.a, g.d, g.c, g.b);
          if (!d(i))
            return; 
        } else {
          a(g.a, g.d, g.c, g.b);
        } 
        if (!this.C && g()) {
          e.f.c("PLAudioMuxer", "Shutting down on last frame");
          break;
        } 
        continue;
      } 
      break;
    } 
  }
  
  public final void b(c.g paramg) {
    a(paramg.d.mBuffer, paramg.a);
    e e = e.f;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("AUDIO CONFIG LENGTH: ");
    stringBuilder.append(this.q.length);
    e.b("PLAudioMuxer", stringBuilder.toString());
    PLDroidStreamingCore pLDroidStreamingCore = this.g;
    byte[] arrayOfByte = this.q;
    pLDroidStreamingCore.writeAudioSeqHeader(arrayOfByte, arrayOfByte.length, paramg.a.presentationTimeUs / 1000L);
    if (this.q != null) {
      d().a(a.a.a.a.a.a.b.c.d, null);
      e e1 = e.f;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("writeHeader :mIsNeedUpdateAVOption=");
      stringBuilder1.append(this.D);
      e1.c("PLAudioMuxer", stringBuilder1.toString());
    } 
    a(paramg.a, paramg.d, paramg.c, paramg.b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\a\i\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */