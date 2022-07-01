package com.qiniu.pili.droid.shortvideo.transcoder.audio;

import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.h;
import java.nio.ByteBuffer;

public class b {
  private static final boolean a = h.a().c();
  
  private AudioTransformer b;
  
  private ByteBuffer c;
  
  private a d;
  
  private int e = 0;
  
  private long f = 0L;
  
  public void a() {
    if (!a) {
      e.r.e("AudioResampler", "AudioResampler is not available");
      return;
    } 
    AudioTransformer audioTransformer = this.b;
    if (audioTransformer != null) {
      audioTransformer.destroy(this.f);
      this.b = null;
      this.f = 0L;
      this.c.clear();
    } 
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    if (!a) {
      e.r.e("AudioResampler", "AudioResampler is not available");
      return;
    } 
    this.b = new AudioTransformer();
    this.f = this.b.init(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    this.e = 2048 * paramInt5;
    e e = e.r;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("from parameters sampleRate:");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" channels:");
    stringBuilder.append(paramInt2);
    e.c("AudioResampler", stringBuilder.toString());
    e = e.r;
    stringBuilder = new StringBuilder();
    stringBuilder.append("to parameters sampleRate:");
    stringBuilder.append(paramInt4);
    stringBuilder.append(" channels:");
    stringBuilder.append(paramInt5);
    e.c("AudioResampler", stringBuilder.toString());
  }
  
  public void a(a parama) {
    this.d = parama;
  }
  
  public void a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2) {
    if (!a) {
      e.r.e("AudioResampler", "AudioResampler is not available");
      return;
    } 
    if (this.c == null) {
      this.c = ByteBuffer.allocateDirect(paramByteBuffer.capacity() * 4);
      e e = e.q;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("init mResampledFramesBuffer with size: ");
      stringBuilder.append(paramByteBuffer.capacity());
      e.c("AudioResampler", stringBuilder.toString());
    } 
    AudioTransformer audioTransformer = this.b;
    long l = this.f;
    ByteBuffer byteBuffer = this.c;
    paramInt1 = audioTransformer.resample(l, paramByteBuffer, paramInt1, paramInt2, byteBuffer, byteBuffer.position(), 0);
    paramByteBuffer = this.c;
    paramByteBuffer.position(paramByteBuffer.position() + paramInt1);
    while (this.c.position() >= this.e) {
      paramInt1 = this.c.position();
      paramInt2 = this.e;
      this.c.flip();
      a a1 = this.d;
      if (a1 != null)
        a1.a(this.c, this.e); 
      this.c.clear();
      ByteBuffer byteBuffer1 = this.c;
      byteBuffer1.put(byteBuffer1.array(), this.c.arrayOffset() + this.e, paramInt1 - paramInt2);
    } 
  }
  
  public static interface a {
    void a(ByteBuffer param1ByteBuffer, int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\transcoder\audio\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */