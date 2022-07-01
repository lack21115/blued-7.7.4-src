package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.download.activate.IXMonitorActivation;

class g implements Runnable {
  g(f paramf) {}
  
  public void run() {
    try {
      if (b.a != null) {
        IXMonitorActivation iXMonitorActivation = b.a.getXMonitorActivation(this.a.a, this.a.b.u);
        iXMonitorActivation.setIXActivateListener(new b.a(this.a.b.f));
        iXMonitorActivation.startMonitor();
        return;
      } 
    } catch (Exception exception) {
      this.a.b.u.e(exception);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */