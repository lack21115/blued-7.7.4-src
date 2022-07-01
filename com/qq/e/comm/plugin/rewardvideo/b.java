package com.qq.e.comm.plugin.rewardvideo;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import java.util.concurrent.atomic.AtomicInteger;

public class b {
  private AtomicInteger a = new AtomicInteger();
  
  public void a() {
    SM sM = GDTADManager.getInstance().getSM();
    if (sM != null) {
      this.a.set(sM.getInteger("rewardVideoLoadRetryTimes", 2) - 1);
      return;
    } 
    this.a.set(1);
  }
  
  public boolean b() {
    return (this.a.decrementAndGet() >= 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\rewardvideo\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */