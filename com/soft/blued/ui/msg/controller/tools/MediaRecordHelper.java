package com.soft.blued.ui.msg.controller.tools;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.Log;
import com.blued.android.module.media.audio.audio_manager.BLAudioManager;
import com.blued.android.third_library.BluedMp3Recorder;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import java.io.IOException;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class MediaRecordHelper {
  public boolean a = false;
  
  private boolean b = false;
  
  private String c;
  
  private BluedMp3Recorder d;
  
  private MediaPlayer e;
  
  private BLAudioManager f;
  
  private BLAudioManager.AudioManagerEvents g;
  
  private BLAudioManager.AudioDevice h;
  
  private OnRecordingListener i;
  
  private long j = 0L;
  
  private Timer k;
  
  private final int l = 0;
  
  private final int m = 1;
  
  private int n = 0;
  
  private final Handler o = new Handler(this) {
      public void handleMessage(Message param1Message) {
        MediaRecordHelper.a(this.a);
        MediaRecordHelper.b(this.a);
      }
    };
  
  private MediaPlayer.OnCompletionListener p;
  
  private final Handler q = new Handler(this) {
      public void handleMessage(Message param1Message) {
        if (MediaRecordHelper.c(this.a) != null)
          MediaRecordHelper.c(this.a).a(param1Message.arg1, param1Message.arg2); 
      }
    };
  
  public MediaRecordHelper() {}
  
  public MediaRecordHelper(String paramString) {
    this.c = paramString;
  }
  
  private void d() {
    f();
    i();
  }
  
  private boolean e() {
    MediaPlayer mediaPlayer = this.e;
    return (mediaPlayer != null && mediaPlayer.isPlaying());
  }
  
  private void f() {
    if (e())
      return; 
    IMV4Constant.b = true;
    this.e = new MediaPlayer();
    this.e.setAudioStreamType(3);
    this.e.setOnCompletionListener(new -$$Lambda$MediaRecordHelper$NcL1B2J1zyLcwnWEWrA57rjOWF0(this));
    this.e.setOnErrorListener(new -$$Lambda$MediaRecordHelper$EBf3oSwFGMf7aVNPKzp4KC8mKvo(this));
    try {
      this.e.setDataSource(this.c);
      this.e.prepare();
      this.e.start();
      return;
    } catch (IOException iOException) {
      iOException.printStackTrace();
      return;
    } 
  }
  
  private void g() {
    MediaPlayer mediaPlayer = this.e;
    if (mediaPlayer == null)
      return; 
    if (mediaPlayer.isPlaying())
      this.e.stop(); 
    this.e.release();
    this.e = null;
  }
  
  private void h() {
    this.o.removeCallbacksAndMessages(null);
    this.o.sendEmptyMessage(0);
  }
  
  private void i() {
    BLAudioManager.AudioSwitchMode audioSwitchMode;
    if (this.f == null) {
      this.f = BLAudioManager.a(AppInfo.d());
      this.g = new -$$Lambda$MediaRecordHelper$fHSdCsq0AeUfT2tC-R5tWFIrGvc(this);
    } 
    if (BluedPreferences.aW()) {
      audioSwitchMode = BLAudioManager.AudioSwitchMode.b;
    } else {
      audioSwitchMode = BLAudioManager.AudioSwitchMode.a;
    } 
    this.f.a(audioSwitchMode);
    this.f.a(this.g);
    this.f.a();
  }
  
  private void j() {
    BLAudioManager bLAudioManager = this.f;
    if (bLAudioManager != null) {
      bLAudioManager.a(null);
      this.f.b();
    } 
  }
  
  public void a() throws IllegalStateException, IOException {
    if (System.currentTimeMillis() - this.j <= 500L) {
      OnRecordingListener onRecordingListener = this.i;
      if (onRecordingListener != null)
        onRecordingListener.a(); 
      return;
    } 
    if (this.b)
      return; 
    this.b = true;
    if (this.n != 0) {
      OnRecordingListener onRecordingListener = this.i;
      if (onRecordingListener != null)
        onRecordingListener.b(); 
      return;
    } 
    try {
      this.d = new BluedMp3Recorder(this.c);
      this.d.a();
      this.n = 1;
      this.k = new Timer();
      this.k.schedule(new TimerTask(this) {
            private int b = 0;
            
            private int c = 0;
            
            public void run() {
              if (MediaRecordHelper.d(this.a) != null) {
                int i = ++this.b;
                if (i % 5 == 0)
                  this.c = i / 5; 
                byte b = 100;
                i = b;
                try {
                  if (MediaRecordHelper.d(this.a) != null)
                    i = MediaRecordHelper.d(this.a).d(); 
                } catch (Exception exception) {
                  i = b;
                  if (this.a.a) {
                    Logger.e("debug", new Object[] { "录音-->getMaxAmplitude异常-->", exception });
                    i = b;
                  } 
                } 
                Message message = new Message();
                message.arg1 = this.c;
                message.arg2 = i;
                MediaRecordHelper.e(this.a).sendMessage(message);
                return;
              } 
              cancel();
            }
          }0L, 200L);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public void a(MediaPlayer.OnCompletionListener paramOnCompletionListener) {
    this.p = paramOnCompletionListener;
  }
  
  public void a(OnRecordingListener paramOnRecordingListener) {
    this.i = paramOnRecordingListener;
  }
  
  public void a(String paramString) {
    this.c = paramString;
  }
  
  public void a(boolean paramBoolean) {
    this.j = System.currentTimeMillis();
    Timer timer = this.k;
    if (timer != null) {
      timer.cancel();
      this.k = null;
    } 
    try {
      if (!this.b)
        return; 
      if (paramBoolean)
        SystemClock.sleep(1000L); 
      this.b = false;
      this.d.b();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    this.n = 0;
  }
  
  public void b() {
    IMV4Constant.b = false;
    this.o.removeCallbacksAndMessages(null);
    g();
    j();
    a((MediaPlayer.OnCompletionListener)null);
  }
  
  public void b(String paramString) {
    this.c = paramString;
    d();
  }
  
  public boolean c() {
    BluedMp3Recorder bluedMp3Recorder = this.d;
    return (bluedMp3Recorder != null) ? bluedMp3Recorder.c() : false;
  }
  
  public static interface OnRecordingListener {
    void a();
    
    void a(int param1Int1, int param1Int2);
    
    void b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\controller\tools\MediaRecordHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */