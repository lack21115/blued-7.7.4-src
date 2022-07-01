package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;

class f implements Runnable {
  f(e parame, IOAdEvent paramIOAdEvent) {}
  
  public void run() {
    if ("AdLoaded".equals(this.a.getType())) {
      BaiduHybridAdManager.a(this.b.a).start();
      return;
    } 
    if ("AdStarted".equals(this.a.getType())) {
      BaiduHybridAdManager.b(this.b.a).onAdShow(0, null);
      return;
    } 
    if ("AdError".equals(this.a.getType()))
      return; 
    if ("AdUserClick".equals(this.a.getType())) {
      BaiduHybridAdManager.b(this.b.a).onAdClick(0, null);
      return;
    } 
    "AdUserClose".equals(this.a.getType());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */