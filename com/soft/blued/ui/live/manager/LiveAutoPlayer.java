package com.soft.blued.ui.live.manager;

import android.text.TextUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.player.live.manager.LiveMediaPlayerManager;
import com.blued.android.module.player.live.manager.OnMediaPlayerListener;
import com.blued.android.module.player.txplayer.view.BlLiveView;

public class LiveAutoPlayer {
  private String a;
  
  private LiveMediaPlayerManager b = new LiveMediaPlayerManager();
  
  private BlLiveView c;
  
  private LiveAutoPlayerListener d;
  
  private OnMediaPlayerListener e = new OnMediaPlayerListener(this) {
      public void a() {
        Logger.c("LiveAutoPlayer", new Object[] { "onMediaBufferStart" });
        if (LiveAutoPlayer.a(this.a) != null)
          LiveAutoPlayer.a(this.a).a(); 
      }
      
      public void a(int param1Int1, int param1Int2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onSizeChange: w = ");
        stringBuilder.append(param1Int1);
        stringBuilder.append(", h = ");
        stringBuilder.append(param1Int2);
        Logger.b("LiveAutoPlayer", new Object[] { stringBuilder.toString() });
        if (LiveAutoPlayer.a(this.a) != null)
          LiveAutoPlayer.a(this.a).a(param1Int1, param1Int2); 
      }
      
      public void b() {
        Logger.c("LiveAutoPlayer", new Object[] { "onMediaBufferEnd" });
        if (LiveAutoPlayer.a(this.a) != null)
          LiveAutoPlayer.a(this.a).b(); 
      }
      
      public void c() {
        Logger.b("LiveAutoPlayer", new Object[] { "onMediaVideoStart" });
        if (LiveAutoPlayer.a(this.a) != null)
          LiveAutoPlayer.a(this.a).c(); 
      }
      
      public void d() {
        if (LiveAutoPlayer.a(this.a) != null)
          LiveAutoPlayer.a(this.a).d(); 
      }
      
      public void e() {
        Logger.b("LiveAutoPlayer", new Object[] { "onCompletion" });
        if (LiveAutoPlayer.a(this.a) != null)
          LiveAutoPlayer.a(this.a).e(); 
      }
    };
  
  public void a(LiveAutoPlayerListener paramLiveAutoPlayerListener) {
    this.d = paramLiveAutoPlayerListener;
  }
  
  public void a(String paramString, BlLiveView paramBlLiveView) {
    if (TextUtils.isEmpty(paramString)) {
      Logger.b("LiveAutoPlayer", new Object[] { "prepare discard, mVideoPath is empty" });
      return;
    } 
    if (paramBlLiveView == null) {
      Logger.b("LiveAutoPlayer", new Object[] { "prepare discard, mPlayView is null" });
      return;
    } 
    Logger.b("LiveAutoPlayer", new Object[] { "prepare mVideoPath = ", paramString });
    this.a = paramString;
    this.c = paramBlLiveView;
    if (!a())
      this.b = new LiveMediaPlayerManager(); 
    try {
      Logger.b("LiveAutoPlayer", new Object[] { "prepare play" });
      this.c.a();
      this.b.a(this.a, this.c);
      this.b.a(this.e);
      this.b.f();
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public boolean a() {
    return (this.b != null);
  }
  
  public boolean b() {
    LiveMediaPlayerManager liveMediaPlayerManager = this.b;
    return (liveMediaPlayerManager != null && liveMediaPlayerManager.a());
  }
  
  public void c() {
    if (a()) {
      Logger.b("LiveAutoPlayer", new Object[] { "start" });
      this.b.c();
    } 
  }
  
  public void d() {
    if (a())
      this.b.d(); 
  }
  
  public void e() {
    if (a() && this.b.a())
      try {
        this.b.b();
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public void f() {
    if (a()) {
      Logger.b("LiveAutoPlayer", new Object[] { "release player" });
      this.b.d();
      this.b.h();
      this.b = null;
    } 
  }
  
  public static interface LiveAutoPlayerListener {
    void a();
    
    void a(int param1Int1, int param1Int2);
    
    void b();
    
    void c();
    
    void d();
    
    void e();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\manager\LiveAutoPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */