package com.blued.android.module.player.live.manager;

import android.util.Log;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.android.module.player.txplayer.view.BlLiveView;

public class LiveMediaPlayerManager {
  private AbsLiveManager a;
  
  public void a(OnMediaPlayerListener paramOnMediaPlayerListener) {
    AbsLiveManager absLiveManager = this.a;
    if (absLiveManager != null)
      absLiveManager.a(paramOnMediaPlayerListener); 
  }
  
  public void a(String paramString, BlLiveView paramBlLiveView) throws Exception {
    if (this.a == null && VideoPlayConfig.c() == 1) {
      this.a = new LiveMediaPlayerManagerTX();
      Log.d("liveMediaPlayerManager", "tencent player");
    } 
    this.a.a(paramString, paramBlLiveView);
  }
  
  public boolean a() {
    AbsLiveManager absLiveManager = this.a;
    return (absLiveManager != null) ? absLiveManager.a() : false;
  }
  
  public void b() {
    AbsLiveManager absLiveManager = this.a;
    if (absLiveManager != null)
      absLiveManager.b(); 
  }
  
  public void c() {
    AbsLiveManager absLiveManager = this.a;
    if (absLiveManager != null)
      absLiveManager.c(); 
  }
  
  public void d() {
    AbsLiveManager absLiveManager = this.a;
    if (absLiveManager != null)
      absLiveManager.d(); 
  }
  
  public void e() {
    AbsLiveManager absLiveManager = this.a;
    if (absLiveManager != null)
      absLiveManager.e(); 
  }
  
  public void f() {
    AbsLiveManager absLiveManager = this.a;
    if (absLiveManager != null)
      absLiveManager.f(); 
  }
  
  public void g() {
    AbsLiveManager absLiveManager = this.a;
    if (absLiveManager != null)
      absLiveManager.g(); 
  }
  
  public void h() {
    AbsLiveManager absLiveManager = this.a;
    if (absLiveManager != null) {
      absLiveManager.h();
      this.a = null;
    } 
  }
  
  public void i() {
    AbsLiveManager absLiveManager = this.a;
    if (absLiveManager != null)
      absLiveManager.i(); 
  }
  
  public void j() {
    AbsLiveManager absLiveManager = this.a;
    if (absLiveManager != null)
      absLiveManager.j(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\player\live\manager\LiveMediaPlayerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */