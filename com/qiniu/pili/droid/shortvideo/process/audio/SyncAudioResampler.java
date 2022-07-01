package com.qiniu.pili.droid.shortvideo.process.audio;

import android.media.MediaFormat;
import com.qiniu.pili.droid.shortvideo.core.a;
import com.qiniu.pili.droid.shortvideo.d.b;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.f;
import com.qiniu.pili.droid.shortvideo.f.h;
import java.nio.ByteBuffer;

public class SyncAudioResampler {
  private static final boolean a = h.a().c();
  
  private volatile boolean b = false;
  
  private volatile boolean c = false;
  
  private volatile boolean d = false;
  
  private volatile boolean e = false;
  
  private long f = 0L;
  
  private long g = 0L;
  
  private long h = 0L;
  
  private int i = 0;
  
  private int j = 0;
  
  private boolean k = false;
  
  private double l = 1.0D;
  
  private a m = new a();
  
  private long mResamplerId = 0L;
  
  private b n;
  
  private boolean o;
  
  private Object p = new Object();
  
  private int q;
  
  private int r;
  
  private String s;
  
  private void e() {
    b b1 = this.n;
    if (b1 != null) {
      if (!b1.c()) {
        e e1 = e.r;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("stopExtractor : already stop, release native ");
        stringBuilder1.append(this.s);
        e1.c("SyncAudioResampler", stringBuilder1.toString());
        release();
        this.d = false;
        this.c = false;
      } 
      this.n = null;
    } 
    e e = e.r;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("stopExtractor : ");
    stringBuilder.append(this.s);
    e.c("SyncAudioResampler", stringBuilder.toString());
  }
  
  private native boolean init(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  private native int read(ByteBuffer paramByteBuffer);
  
  private native boolean release();
  
  private native boolean write(ByteBuffer paramByteBuffer, int paramInt, long paramLong, boolean paramBoolean);
  
  public int a(ByteBuffer paramByteBuffer) {
    if (!this.b) {
      e.r.c("resample not started or canceled !");
      return -1;
    } 
    int i = read(paramByteBuffer);
    if (i <= 0) {
      this.e = true;
      return -1;
    } 
    this.h += i;
    this.f = (int)((float)(this.h * 1000000L) * 8.0F / 16.0F / this.i / this.j) + this.g;
    e e = e.r;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getSampleData, ts = ");
    stringBuilder.append(this.f);
    e.a(stringBuilder.toString());
    return i;
  }
  
  public void a() {
    e e = e.r;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("cancel +");
    stringBuilder.append(this.s);
    e.c("SyncAudioResampler", stringBuilder.toString());
    this.c = true;
    e();
    this.b = false;
    e = e.r;
    stringBuilder = new StringBuilder();
    stringBuilder.append("cancel - ");
    stringBuilder.append(this.s);
    e.c("SyncAudioResampler", stringBuilder.toString());
  }
  
  public void a(double paramDouble) {
    this.l = paramDouble;
    this.m.a(this.l);
    this.m.a(new a.a(this) {
          public void a(ByteBuffer param1ByteBuffer, int param1Int, long param1Long) {
            SyncAudioResampler.a(this.a, param1ByteBuffer, param1Int, param1Long, false);
          }
        });
  }
  
  public void a(boolean paramBoolean) {
    this.k = paramBoolean;
  }
  
  public boolean a(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3) {
    long l;
    if (!a) {
      e.r.c("can't found pldroid_amix.so !");
      return false;
    } 
    if (this.b) {
      e.r.c("resample already started !");
      return false;
    } 
    if (paramInt1 <= 0 || paramInt2 <= 0 || paramInt3 <= 0) {
      e.r.d("invalid params !");
      return false;
    } 
    this.c = false;
    this.d = false;
    this.e = false;
    if (paramLong1 > 0L) {
      l = paramLong1;
    } else {
      l = 0L;
    } 
    this.g = l;
    this.h = 0L;
    this.i = paramInt1;
    this.j = paramInt2;
    this.s = paramString;
    f f = new f(paramString, false, true);
    this.n = new b(f.d(), f.f());
    this.n.a(paramString);
    this.n.a(new b.c(this) {
          public void a(ByteBuffer param1ByteBuffer, int param1Int, long param1Long1, long param1Long2, boolean param1Boolean) {
            if (!SyncAudioResampler.a(this.a) && !SyncAudioResampler.b(this.a)) {
              if (param1Boolean) {
                SyncAudioResampler syncAudioResampler = this.a;
                SyncAudioResampler.a(syncAudioResampler, param1ByteBuffer, param1Int, (long)(param1Long1 / SyncAudioResampler.c(syncAudioResampler)), param1Boolean);
                return;
              } 
              SyncAudioResampler.d(this.a).c(param1ByteBuffer, param1Int, param1Long1);
            } 
          }
        });
    this.n.a(new b.d(this, f) {
          public void a(MediaFormat param1MediaFormat) {
            int i;
            null = this.b;
            if (param1MediaFormat.containsKey("sample-rate")) {
              i = param1MediaFormat.getInteger("sample-rate");
            } else {
              i = this.a.o();
            } 
            SyncAudioResampler.a(null, i);
            null = this.b;
            if (param1MediaFormat.containsKey("channel-count")) {
              i = param1MediaFormat.getInteger("channel-count");
            } else {
              i = this.a.n();
            } 
            SyncAudioResampler.b(null, i);
            synchronized (SyncAudioResampler.e(this.b)) {
              SyncAudioResampler.a(this.b, true);
              SyncAudioResampler.e(this.b).notify();
              return;
            } 
          }
        });
    this.n.a(new b.b(this) {
          public void a() {
            if (SyncAudioResampler.a(this.a) || SyncAudioResampler.b(this.a)) {
              SyncAudioResampler.f(this.a);
              SyncAudioResampler.b(this.a, false);
              SyncAudioResampler.c(this.a, false);
              e e1 = e.r;
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("onExtractorStop : release native ");
              stringBuilder1.append(SyncAudioResampler.g(this.a));
              e1.c("SyncAudioResampler", stringBuilder1.toString());
            } 
            e e = e.r;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onExtractorStop ");
            stringBuilder.append(SyncAudioResampler.g(this.a));
            e.c("SyncAudioResampler", stringBuilder.toString());
          }
        });
    this.n.a(paramLong1, paramLong2);
    this.n.a(this.k);
    synchronized (this.p) {
      while (true) {
        boolean bool = this.o;
        if (!bool) {
          try {
            this.p.wait();
          } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
          } 
          continue;
        } 
        if (!init(this.q, this.r, paramInt1, paramInt2, paramInt3)) {
          e.r.d("failed to init !");
          return false;
        } 
        this.b = true;
        null = e.r;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("audio resample started: ");
        stringBuilder.append(paramString);
        null.b(stringBuilder.toString());
        return true;
      } 
    } 
  }
  
  public void b() {
    e e = e.r;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("destroy +");
    stringBuilder.append(this.s);
    e.c("SyncAudioResampler", stringBuilder.toString());
    this.d = true;
    e();
    this.b = false;
    e = e.r;
    stringBuilder = new StringBuilder();
    stringBuilder.append("destroy -");
    stringBuilder.append(this.s);
    e.c("SyncAudioResampler", stringBuilder.toString());
  }
  
  public boolean c() {
    return this.e;
  }
  
  public long d() {
    return this.f;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\process\audio\SyncAudioResampler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */