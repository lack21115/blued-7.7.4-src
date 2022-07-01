package com.qiniu.pili.droid.shortvideo.a.b;

import android.media.AudioRecord;
import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.NoiseSuppressor;
import com.qiniu.pili.droid.shortvideo.PLAudioFrameListener;
import com.qiniu.pili.droid.shortvideo.PLMicrophoneSetting;
import com.qiniu.pili.droid.shortvideo.f.e;
import java.util.Arrays;

public final class a {
  private AudioRecord a;
  
  private PLMicrophoneSetting b;
  
  private int c;
  
  private Thread d;
  
  private boolean e = false;
  
  private boolean f = false;
  
  private volatile boolean g = false;
  
  private byte[] h;
  
  private long i = 0L;
  
  private long j = 0L;
  
  private PLAudioFrameListener k;
  
  private NoiseSuppressor l;
  
  private AcousticEchoCanceler m;
  
  private final Runnable n = new Runnable(this) {
      public void run() {
        while (!a.a(this.a)) {
          if (a.b(this.a) == null) {
            a a2 = this.a;
            a.a(a2, new byte[a.c(a2) * 1024 * 2]);
          } 
          int i = a.d(this.a).read(a.b(this.a), 0, (a.b(this.a)).length);
          e e = e.f;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("audio frame read size:");
          stringBuilder.append(i);
          e.a("AudioManager", stringBuilder.toString());
          if (i < 0) {
            a.a(this.a, i);
            continue;
          } 
          a a1 = this.a;
          a.b(a1, a.b(a1));
        } 
      }
    };
  
  public a(PLMicrophoneSetting paramPLMicrophoneSetting) {
    this.b = paramPLMicrophoneSetting;
  }
  
  private long a(long paramLong1, long paramLong2) {
    if (!this.b.isAudioPtsOptimizeEnabled())
      return paramLong1; 
    long l2 = paramLong2 * 1000000L / this.b.getSampleRate();
    long l3 = paramLong1 - l2;
    if (this.j == 0L) {
      this.i = l3;
      this.j = 0L;
    } 
    long l1 = this.i + this.j * 1000000L / this.b.getSampleRate();
    paramLong1 = l1;
    if (l3 - l1 >= l2 * 2L) {
      this.i = l3;
      this.j = 0L;
      paramLong1 = this.i;
    } 
    this.j += paramLong2;
    return paramLong1;
  }
  
  private void a(int paramInt) {
    e e = e.f;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onAudioRecordFailed: ");
    stringBuilder.append(paramInt);
    e.e("AudioManager", stringBuilder.toString());
    PLAudioFrameListener pLAudioFrameListener = this.k;
    if (pLAudioFrameListener != null)
      pLAudioFrameListener.onAudioRecordFailed(paramInt); 
  }
  
  private void a(byte[] paramArrayOfbyte) {
    if (this.k == null)
      return; 
    if (this.f)
      Arrays.fill(paramArrayOfbyte, (byte)0); 
    long l = a(System.nanoTime() / 1000L, (paramArrayOfbyte.length / this.c / 2));
    this.k.onAudioFrameAvailable(paramArrayOfbyte, l * 1000L);
  }
  
  private boolean c() {
    PLMicrophoneSetting pLMicrophoneSetting = this.b;
    return (pLMicrophoneSetting != null && pLMicrophoneSetting.isNSEnabled());
  }
  
  private boolean d() {
    PLMicrophoneSetting pLMicrophoneSetting = this.b;
    return (pLMicrophoneSetting != null && pLMicrophoneSetting.isAECEnabled());
  }
  
  public void a(PLAudioFrameListener paramPLAudioFrameListener) {
    this.k = paramPLAudioFrameListener;
  }
  
  public void a(boolean paramBoolean) {
    this.f = paramBoolean;
  }
  
  public boolean a() {
    e.f.c("AudioManager", "start audio recording +");
    if (this.e) {
      e.f.d("AudioManager", "recording already started !");
      return false;
    } 
    if (this.b.getChannelConfig() == 12) {
      i = 2;
    } else {
      i = 1;
    } 
    this.c = i;
    int i = AudioRecord.getMinBufferSize(this.b.getSampleRate(), this.b.getChannelConfig(), this.b.getAudioFormat());
    if (i == -2) {
      e.f.e("AudioManager", "invalid parameter !");
      return false;
    } 
    try {
      this.a = new AudioRecord(this.b.getAudioSource(), this.b.getSampleRate(), this.b.getChannelConfig(), this.b.getAudioFormat(), i * 4);
      if (c()) {
        this.l = NoiseSuppressor.create(this.a.getAudioSessionId());
        if (this.l != null) {
          e.f.c("AudioManager", "set noise suppressor enabled");
          this.l.setEnabled(true);
        } 
      } 
      if (d()) {
        this.m = AcousticEchoCanceler.create(this.a.getAudioSessionId());
        if (this.m != null) {
          e.f.c("AudioManager", "set acoustic echo canceler enabled");
          this.m.setEnabled(true);
        } 
      } 
      if (this.a.getState() == 0) {
        e.f.e("AudioManager", "AudioRecord initialize fail !");
        return false;
      } 
      this.a.startRecording();
      if (this.a.getRecordingState() != 3) {
        e.f.e("AudioManager", "AudioRecord cannot recording !");
        return false;
      } 
      this.j = 0L;
      this.i = 0L;
      this.g = false;
      this.d = new Thread(this.n);
      this.d.setPriority(10);
      this.d.start();
      this.e = true;
      e.f.c("AudioManager", "start audio recording -");
      return true;
    } catch (IllegalArgumentException illegalArgumentException) {
      e e = e.f;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Create AudioRecord failed : ");
      stringBuilder.append(illegalArgumentException.getMessage());
      e.e("AudioManager", stringBuilder.toString());
      return false;
    } 
  }
  
  public void b() {
    e.f.c("AudioManager", "stop audio recording +");
    if (!this.e) {
      e.f.d("AudioManager", "recording already stopped !");
      return;
    } 
    this.g = true;
    try {
      this.d.interrupt();
      this.d.join(1000L);
    } catch (InterruptedException interruptedException) {
      interruptedException.printStackTrace();
    } 
    if (this.a.getRecordingState() == 3)
      this.a.stop(); 
    this.a.release();
    if (this.l != null) {
      e.f.c("AudioManager", "set noise suppressor disabled");
      this.l.setEnabled(false);
      this.l.release();
    } 
    if (this.m != null) {
      e.f.c("AudioManager", "set acoustic echo canceler disabled");
      this.m.setEnabled(false);
      this.m.release();
    } 
    this.e = false;
    e.f.c("AudioManager", "stop audio recording -");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\a\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */