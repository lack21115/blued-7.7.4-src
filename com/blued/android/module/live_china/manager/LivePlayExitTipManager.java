package com.blued.android.module.live_china.manager;

import android.os.Handler;
import com.blued.android.core.AppInfo;

public class LivePlayExitTipManager {
  private boolean a = false;
  
  private Handler b = new Handler();
  
  private ExitTipTask c = new ExitTipTask(this);
  
  public void a() {
    this.a = false;
    AppInfo.n().removeCallbacks(this.c);
  }
  
  public void b() {
    this.b.postDelayed(this.c, 180000L);
  }
  
  public void c() {
    this.b.removeCallbacksAndMessages(null);
  }
  
  public boolean d() {
    return this.a;
  }
  
  class ExitTipTask implements Runnable {
    ExitTipTask(LivePlayExitTipManager this$0) {}
    
    public void run() {
      LivePlayExitTipManager.a(this.a, true);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\manager\LivePlayExitTipManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */