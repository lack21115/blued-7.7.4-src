package com.blued.android.module.live_china.manager;

import android.view.View;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.player.live.view.BLVideoView;

public class RecordingPlayerManager {
  private BLVideoView a;
  
  private View b;
  
  public RecordingPlayerManager(BLVideoView paramBLVideoView, View paramView) {
    this.a = paramBLVideoView;
    this.b = paramView;
    d();
  }
  
  private void d() {
    this.a.a(this.b);
  }
  
  public void a() {
    this.a.a();
    Logger.a("rrb", new Object[] { "onStart" });
  }
  
  public void a(int paramInt1, int paramInt2) {
    this.a.a(paramInt1, paramInt2);
    Logger.a("ddrb", new Object[] { "setSurfaceWidthHeight width = ", Integer.valueOf(paramInt1), " -- height = ", Integer.valueOf(paramInt2) });
  }
  
  public void a(String paramString) {
    this.a.setVideoPath(paramString);
  }
  
  public void b() {
    this.a.b();
    Logger.a("rrb", new Object[] { "onPause" });
  }
  
  public void c() {
    this.a.c();
    Logger.a("rrb", new Object[] { "onDestroy" });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\manager\RecordingPlayerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */