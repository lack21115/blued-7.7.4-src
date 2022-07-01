package com.blued.android.module.player.audio;

import android.os.Bundle;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.Log;
import com.tencent.rtmp.ITXVodPlayListener;
import com.tencent.rtmp.TXVodPlayConfig;
import com.tencent.rtmp.TXVodPlayer;

public class TXVodAudioPlayer implements IAudioPlayer, ITXVodPlayListener {
  private static int a = 0;
  
  private static boolean b = true;
  
  private TXVodPlayer c;
  
  private TXVodPlayConfig d;
  
  private IAudioPlayer.OnPreparedListener e;
  
  private IAudioPlayer.OnCompletionListener f;
  
  private IAudioPlayer.OnErrorListener g;
  
  private String h;
  
  private long i;
  
  private boolean j;
  
  public TXVodAudioPlayer() {
    d();
  }
  
  private void d() {
    this.c = new TXVodPlayer(AppInfo.d());
    this.c.setRequestAudioFocus(b);
    this.d = new TXVodPlayConfig();
    this.d.setProgressInterval(1000);
    this.d.setMaxBufferSize(a);
    this.j = false;
  }
  
  private boolean e() {
    if (TextUtils.isEmpty(this.h)) {
      Log.d("TXVodAudioPlayer", "play url can not empty!");
      return false;
    } 
    this.c.setVodListener(this);
    this.c.enableHardwareDecode(false);
    this.c.setConfig(this.d);
    this.c.setAutoPlay(true);
    if (this.c.startPlay(this.h) != 0)
      return false; 
    this.i = System.currentTimeMillis();
    Log.c("TXVodAudioPlayer", "start play");
    return true;
  }
  
  private void f() {
    TXVodPlayer tXVodPlayer = this.c;
    if (tXVodPlayer != null) {
      tXVodPlayer.setVodListener(null);
      this.c.stopPlay(true);
    } 
    this.j = false;
  }
  
  private void g() {
    TXVodPlayer tXVodPlayer = this.c;
    if (tXVodPlayer != null && this.j && !tXVodPlayer.isPlaying())
      this.c.resume(); 
  }
  
  public IAudioPlayer a() {
    Log.c("TXVodAudioPlayer", "start");
    if (this.j) {
      g();
      return this;
    } 
    this.j = e();
    return this;
  }
  
  public IAudioPlayer a(String paramString) {
    this.h = paramString;
    return this;
  }
  
  public IAudioPlayer a(boolean paramBoolean) {
    TXVodPlayer tXVodPlayer = this.c;
    if (tXVodPlayer != null)
      tXVodPlayer.setLoop(paramBoolean); 
    return this;
  }
  
  public void b() {
    Log.c("TXVodAudioPlayer", "stop");
    f();
  }
  
  public void c() {
    Log.b("TXVodAudioPlayer", "pause");
    TXVodPlayer tXVodPlayer = this.c;
    if (tXVodPlayer != null)
      tXVodPlayer.pause(); 
  }
  
  public void onNetStatus(TXVodPlayer paramTXVodPlayer, Bundle paramBundle) {}
  
  public void onPlayEvent(TXVodPlayer paramTXVodPlayer, int paramInt, Bundle paramBundle) {
    if (paramInt == 2014)
      Log.b("TXVodAudioPlayer", "PLAY_EVT_VOD_LOADING_END"); 
    if (paramInt == 2013) {
      IAudioPlayer.OnPreparedListener onPreparedListener = this.e;
      if (onPreparedListener != null)
        onPreparedListener.a(null); 
      Log.c("TXVodAudioPlayer", "PLAY_EVT_VOD_PLAY_PREPARED");
    } 
    if (paramInt == 2004) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("PLAY_EVT_PLAY_BEGIN, PlayFirstRender, cost=");
      stringBuilder.append(System.currentTimeMillis() - this.i);
      Log.c("TXVodAudioPlayer", stringBuilder.toString());
    } else {
      if (paramInt == 2005)
        return; 
      if (paramInt == -2301 || paramInt == 2006 || paramInt == -2303) {
        IAudioPlayer.OnCompletionListener onCompletionListener = this.f;
        if (onCompletionListener != null)
          onCompletionListener.a(null); 
        f();
      } else if (paramInt == 2007) {
        Log.b("TXVodAudioPlayer", "PLAY_EVT_PLAY_LOADING");
      } else if (paramInt == 2003) {
        Log.b("TXVodAudioPlayer", "PLAY_EVT_RCV_FIRST_I_FRAME");
      } else if (paramInt == -2305) {
        f();
      } else if (paramInt == 2103) {
        Log.c("TXVodAudioPlayer", "PLAY_WARNING_RECONNECT");
      } else if (paramInt == 2011) {
        return;
      } 
    } 
    if (paramInt < 0) {
      IAudioPlayer.OnErrorListener onErrorListener = this.g;
      if (onErrorListener != null)
        onErrorListener.a(null, paramInt, 0); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\player\audio\TXVodAudioPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */