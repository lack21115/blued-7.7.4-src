package com.qiniu.pili.droid.shortvideo.transcoder.audio;

import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.h;
import java.nio.ByteBuffer;

public class AudioMixer {
  private static final boolean a = h.a().c();
  
  private AudioTransformer b;
  
  private ByteBuffer c;
  
  private float d = 1.0F;
  
  private float e = 1.0F;
  
  private long f = 0L;
  
  private long g = 0L;
  
  private native void destroy(long paramLong);
  
  private native long init(int paramInt);
  
  private native boolean mix(long paramLong, ByteBuffer paramByteBuffer1, int paramInt1, float paramFloat1, ByteBuffer paramByteBuffer2, int paramInt2, float paramFloat2, ByteBuffer paramByteBuffer3, int paramInt3, int paramInt4, int paramInt5);
  
  public void a(float paramFloat1, float paramFloat2) {
    this.d = paramFloat1;
    this.e = paramFloat2;
  }
  
  public boolean a() {
    if (!a) {
      e.q.e("AudioMixer", "AudioMixer is not available");
      return false;
    } 
    this.b.destroy(this.g);
    this.b = null;
    this.g = 0L;
    this.c = null;
    destroy(this.f);
    this.f = 0L;
    return true;
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!a) {
      e.q.e("AudioMixer", "AudioMixer is not available");
      return false;
    } 
    e e = e.q;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("main parameters sampleRate:");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" channels:");
    stringBuilder.append(paramInt2);
    e.c("AudioMixer", stringBuilder.toString());
    e = e.q;
    stringBuilder = new StringBuilder();
    stringBuilder.append("music parameters sampleRate:");
    stringBuilder.append(paramInt3);
    stringBuilder.append(" channels:");
    stringBuilder.append(paramInt4);
    e.c("AudioMixer", stringBuilder.toString());
    this.b = new AudioTransformer();
    this.g = this.b.init(paramInt3, paramInt4, 16, paramInt1, paramInt2, 16);
    return true;
  }
  
  public boolean a(ByteBuffer paramByteBuffer, int paramInt) {
    if (!a) {
      e.q.e("AudioMixer", "AudioMixer is not available");
      return true;
    } 
    if (this.f == 0L) {
      this.f = init(paramByteBuffer.capacity());
      e e1 = e.q;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("init AudioMixer with buffer size: ");
      stringBuilder1.append(paramByteBuffer.capacity());
      e1.c("AudioMixer", stringBuilder1.toString());
    } 
    if (this.c == null) {
      this.c = ByteBuffer.allocateDirect(paramByteBuffer.capacity() * 4);
      e e1 = e.q;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("init mResampledMainFramesBuffer with size: ");
      stringBuilder1.append(this.c.capacity());
      e1.c("AudioMixer", stringBuilder1.toString());
    } 
    if (this.c.position() >= paramInt) {
      mix(this.f, paramByteBuffer, 0, this.d, this.c, 0, this.e, paramByteBuffer, 0, 16, paramInt);
      int i = this.c.position();
      int j = i - paramInt;
      this.c.clear();
      paramByteBuffer = this.c;
      paramByteBuffer.put(paramByteBuffer.array(), this.c.arrayOffset() + paramInt, j);
      e e1 = e.q;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("mixed frames with buffer, origin: ");
      stringBuilder1.append(i);
      stringBuilder1.append(" remaining: ");
      stringBuilder1.append(j);
      stringBuilder1.append(" consumed: ");
      stringBuilder1.append(paramInt);
      e1.b("AudioMixer", stringBuilder1.toString());
      return true;
    } 
    e e = e.q;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("not enough frames in buffer, remaining: ");
    stringBuilder.append(this.c.position());
    stringBuilder.append(" require: ");
    stringBuilder.append(paramInt);
    e.b("AudioMixer", stringBuilder.toString());
    return false;
  }
  
  public void b(ByteBuffer paramByteBuffer, int paramInt) {
    if (!a) {
      e.q.e("AudioMixer", "AudioMixer is not available");
      return;
    } 
    AudioTransformer audioTransformer = this.b;
    long l = this.g;
    int i = paramByteBuffer.position();
    ByteBuffer byteBuffer = this.c;
    i = audioTransformer.resample(l, paramByteBuffer, i, paramInt, byteBuffer, byteBuffer.position(), 0);
    paramByteBuffer = this.c;
    paramByteBuffer.position(paramByteBuffer.position() + i);
    e e = e.q;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("resample music frames: ");
    stringBuilder.append(paramInt);
    stringBuilder.append(" to main frames: ");
    stringBuilder.append(i);
    stringBuilder.append(" and saved");
    e.b("AudioMixer", stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\transcoder\audio\AudioMixer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */