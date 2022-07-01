package com.baidu.mobads;

import com.baidu.mobads.command.c.a;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;

class t implements Runnable {
  t(s params, IOAdEvent paramIOAdEvent) {}
  
  public void run() {
    if ("AdLoaded".equals(this.a.getType())) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().i("SplashAd loaded");
      return;
    } 
    if ("AdStarted".equals(this.a.getType())) {
      SplashAd.a(this.b.a).onAdPresent();
      return;
    } 
    if ("AdUserClick".equals(this.a.getType())) {
      SplashAd.a(this.b.a).onAdClick();
      if (SplashAd.a(this.b.a) instanceof SplashLpCloseListener && (SplashAd.b(this.b.a)).d.getActionType() == 1) {
        a.a(SplashAd.c(this.b.a)).b();
        a.a(SplashAd.c(this.b.a)).addEventListener("AdLpClosed", SplashAd.d(this.b.a));
        return;
      } 
    } else {
      if ("AdStopped".equals(this.a.getType())) {
        SplashAd.b(this.b.a).removeAllListeners();
        SplashAd.a(this.b.a).onAdDismissed();
        return;
      } 
      if ("AdError".equals(this.a.getType())) {
        SplashAd.b(this.b.a).removeAllListeners();
        SplashAd.a(this.b.a).onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.a.getData()));
        return;
      } 
      if ("AdLpClosed".equals(this.a.getType()) && SplashAd.a(this.b.a) instanceof SplashLpCloseListener) {
        a.a(SplashAd.c(this.b.a)).removeEventListeners("AdLpClosed");
        a.a(SplashAd.c(this.b.a)).c();
        ((SplashLpCloseListener)SplashAd.a(this.b.a)).onLpClosed();
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */