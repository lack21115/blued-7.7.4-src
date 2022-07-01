package com.qiniu.pili.droid.shortvideo;

import com.qiniu.pili.droid.shortvideo.e.a;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.g;
import com.qiniu.pili.droid.shortvideo.f.j;
import com.qiniu.pili.droid.shortvideo.process.audio.SyncAudioResampler;
import com.qiniu.pili.droid.shortvideo.transcoder.audio.d;
import java.io.IOException;
import java.nio.ByteBuffer;

public class PLMixAudioFile {
  private String a;
  
  private long b = 0L;
  
  private long c = 0L;
  
  private long d = 0L;
  
  private float e = 1.0F;
  
  private long f = 0L;
  
  private double g = 1.0D;
  
  private boolean h = false;
  
  private boolean i = true;
  
  private SyncAudioResampler j;
  
  private ByteBuffer k;
  
  private a l;
  
  public PLMixAudioFile(String paramString) throws IOException {
    this(paramString, true);
  }
  
  public PLMixAudioFile(String paramString, boolean paramBoolean) {
    this.a = paramString;
    long l = g.a(this.a) * 1000L;
    this.d = l;
    this.f = l;
    if (paramBoolean)
      h(); 
  }
  
  private void g() {
    d d = new d(this.c / 1000L, this.d / 1000L);
    a a1 = this.l;
    if (a1 != null)
      a1.a(d); 
  }
  
  private void h() {
    this.l = new a();
    this.l.a(this.a);
    this.l.a(this.e);
    this.l.a(this.h);
  }
  
  public a a() {
    return this.l;
  }
  
  public boolean a(long paramLong) {
    boolean bool1;
    boolean bool2;
    if (paramLong < this.b) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    long l = this.f;
    if (l != 0L && paramLong > this.b + l) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    return (!bool1 && !bool2);
  }
  
  public long b(long paramLong) {
    long l1 = (paramLong - this.b) / 1000L;
    long l2 = this.d - this.c;
    paramLong = 0L;
    if (l2 > 0L)
      paramLong = l1 % l2 / 1000L; 
    return this.c / 1000L + paramLong;
  }
  
  public SyncAudioResampler b() {
    if (this.j == null) {
      this.j = new SyncAudioResampler();
      this.j.a(this.g);
      if (this.h)
        this.j.a(true); 
    } 
    return this.j;
  }
  
  public void c() {
    SyncAudioResampler syncAudioResampler = this.j;
    if (syncAudioResampler != null) {
      syncAudioResampler.b();
      this.j = null;
    } 
  }
  
  public void d() {
    SyncAudioResampler syncAudioResampler = this.j;
    if (syncAudioResampler != null) {
      syncAudioResampler.a();
      this.j = null;
    } 
  }
  
  public ByteBuffer e() {
    if (this.k == null)
      this.k = ByteBuffer.allocateDirect(2048); 
    return this.k;
  }
  
  public boolean f() {
    return this.i;
  }
  
  public long getEndTime() {
    return this.d;
  }
  
  public String getFilepath() {
    return this.a;
  }
  
  public long getOffsetInVideo() {
    return this.b;
  }
  
  public long getStartTime() {
    return this.c;
  }
  
  public float getVolume() {
    return this.e;
  }
  
  public boolean isLooping() {
    return this.h;
  }
  
  public PLMixAudioFile setDurationInVideo(long paramLong) {
    this.f = paramLong;
    return this;
  }
  
  public PLMixAudioFile setEndTime(long paramLong) {
    if (paramLong < this.c) {
      e.q.e("PLMixAudioFile", "end time must bigger than start time !");
      return this;
    } 
    this.d = paramLong;
    g();
    return this;
  }
  
  public PLMixAudioFile setLooping(boolean paramBoolean) {
    this.h = paramBoolean;
    a a1 = this.l;
    if (a1 != null)
      a1.a(paramBoolean); 
    return this;
  }
  
  public void setNeedUpdatePosition(boolean paramBoolean) {
    this.i = paramBoolean;
  }
  
  public PLMixAudioFile setOffsetInVideo(long paramLong) {
    this.b = paramLong;
    return this;
  }
  
  public PLMixAudioFile setSpeed(double paramDouble) {
    if (j.a(paramDouble)) {
      e e = e.q;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("set speed to: ");
      stringBuilder.append(paramDouble);
      e.c("PLMixAudioFile", stringBuilder.toString());
      this.g = paramDouble;
      SyncAudioResampler syncAudioResampler = this.j;
      if (syncAudioResampler != null) {
        syncAudioResampler.a(this.g);
        return this;
      } 
    } else {
      e.q.d("PLMixAudioFile", "only support multiple of 2 !!!");
    } 
    return this;
  }
  
  public PLMixAudioFile setStartTime(long paramLong) {
    this.c = paramLong;
    g();
    return this;
  }
  
  public PLMixAudioFile setVolume(float paramFloat) {
    if (paramFloat >= 0.0F && paramFloat <= 1.0F) {
      this.e = paramFloat;
      a a1 = this.l;
      if (a1 != null)
        a1.a(paramFloat); 
      return this;
    } 
    throw new IllegalArgumentException("The volume range is 0.0f~1.0f !");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLMixAudioFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */