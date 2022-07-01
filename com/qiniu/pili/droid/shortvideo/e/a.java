package com.qiniu.pili.droid.shortvideo.e;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.transcoder.audio.d;
import java.io.IOException;

public class a implements MediaPlayer.OnCompletionListener {
  private MediaPlayer a;
  
  private String b;
  
  private AssetFileDescriptor c;
  
  private boolean d = true;
  
  private d e = new d(0L, 0L);
  
  private boolean f = false;
  
  private Handler g;
  
  private float h = 1.0F;
  
  private void h() {
    Handler handler = this.g;
    if (handler != null) {
      handler.removeCallbacksAndMessages(null);
      this.g = null;
    } 
  }
  
  private void i() {
    long l = this.e.b();
    if (l > 0L) {
      if (l > this.a.getDuration()) {
        h();
        return;
      } 
      Handler handler = this.g;
      if (handler == null) {
        this.g = new Handler();
      } else {
        handler.removeCallbacksAndMessages(null);
      } 
      this.g.postDelayed(new Runnable(this) {
            public void run() {
              if (a.a(this.a)) {
                a a1 = this.a;
                a1.a(a.b(a1).a());
                return;
              } 
              this.a.e();
            }
          },  this.e.c());
    } 
  }
  
  private void j() {
    if (this.a != null) {
      e.k.d("AudioPlayer", "media player already inited");
      return;
    } 
    this.a = new MediaPlayer();
    this.a.setOnCompletionListener(this);
    try {
      if (g()) {
        if (this.c.getDeclaredLength() < 0L) {
          this.a.setDataSource(this.c.getFileDescriptor());
        } else {
          this.a.setDataSource(this.c.getFileDescriptor(), this.c.getStartOffset(), this.c.getLength());
        } 
      } else {
        this.a.setDataSource(this.b);
      } 
      this.a.prepare();
      this.a.setVolume(this.h, this.h);
      return;
    } catch (IOException iOException) {
      iOException.printStackTrace();
      return;
    } 
  }
  
  public int a() {
    MediaPlayer mediaPlayer = this.a;
    if (mediaPlayer == null) {
      e.k.d("AudioPlayer", "not playing !");
      return -1;
    } 
    int i = mediaPlayer.getDuration();
    e e = e.k;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("duration: ");
    stringBuilder.append(i);
    e.b("AudioPlayer", stringBuilder.toString());
    return i;
  }
  
  public void a(float paramFloat) {
    MediaPlayer mediaPlayer = this.a;
    if (mediaPlayer == null) {
      e.k.d("AudioPlayer", "not playing !");
      return;
    } 
    this.h = paramFloat;
    float f = this.h;
    mediaPlayer.setVolume(f, f);
    e e = e.k;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("set volume: ");
    stringBuilder.append(paramFloat);
    e.b("AudioPlayer", stringBuilder.toString());
  }
  
  public void a(long paramLong) {
    e.k.c("AudioPlayer", "seekTo +");
    if (this.a == null) {
      e.k.d("AudioPlayer", "not playing !");
      return;
    } 
    if (Build.VERSION.SDK_INT < 26) {
      this.a.seekTo((int)paramLong);
    } else {
      this.a.seekTo((int)paramLong, 3);
    } 
    if (!this.f)
      i(); 
    e e = e.k;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("seekTo: ");
    stringBuilder.append(paramLong);
    e.c("AudioPlayer", stringBuilder.toString());
  }
  
  public void a(AssetFileDescriptor paramAssetFileDescriptor) {
    this.c = paramAssetFileDescriptor;
    this.b = null;
    j();
  }
  
  public void a(d paramd) {
    this.e = paramd;
    MediaPlayer mediaPlayer = this.a;
    if (mediaPlayer != null && mediaPlayer.isPlaying())
      i(); 
  }
  
  public void a(String paramString) {
    this.b = paramString;
    this.c = null;
    j();
  }
  
  public void a(boolean paramBoolean) {
    this.d = paramBoolean;
  }
  
  public void b() {
    this.f = false;
    j();
    this.a.start();
    a(this.e.a());
  }
  
  public boolean c() {
    MediaPlayer mediaPlayer = this.a;
    return (mediaPlayer != null) ? mediaPlayer.isPlaying() : false;
  }
  
  public void d() {
    e.k.c("AudioPlayer", "stop +");
    h();
    MediaPlayer mediaPlayer = this.a;
    if (mediaPlayer == null)
      return; 
    mediaPlayer.stop();
    this.a.release();
    this.a = null;
    e.k.c("AudioPlayer", "stop -");
  }
  
  public void e() {
    e.k.c("AudioPlayer", "pause +");
    MediaPlayer mediaPlayer = this.a;
    if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
      e.k.d("AudioPlayer", "not playing !");
      return;
    } 
    this.a.pause();
    this.f = true;
    e.k.c("AudioPlayer", "pause -");
  }
  
  public void f() {
    e.k.c("AudioPlayer", "resume +");
    MediaPlayer mediaPlayer = this.a;
    if (mediaPlayer == null || mediaPlayer.isPlaying()) {
      e.k.d("AudioPlayer", "not in pause state !");
      return;
    } 
    this.a.start();
    this.f = false;
    h();
    e.k.c("AudioPlayer", "resume -");
  }
  
  public boolean g() {
    return (this.c != null);
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer) {
    if (this.d) {
      if (!this.f) {
        this.a.start();
        if (Build.VERSION.SDK_INT < 26) {
          this.a.seekTo((int)this.e.a());
          return;
        } 
        this.a.seekTo((int)this.e.a(), 3);
        return;
      } 
    } else {
      this.f = true;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */