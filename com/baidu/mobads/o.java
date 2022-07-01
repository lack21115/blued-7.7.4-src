package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;

class o implements Runnable {
  o(n paramn, IOAdEvent paramIOAdEvent) {}
  
  public void run() {
    if ("AdLoaded".equals(this.a.getType())) {
      InterstitialAd.a(this.b.a).onAdReady();
      return;
    } 
    if ("AdError".equals(this.a.getType())) {
      InterstitialAd.a(this.b.a).onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.a.getData()));
      return;
    } 
    if ("AdStopped".equals(this.a.getType())) {
      InterstitialAd.a(this.b.a).onAdDismissed();
      return;
    } 
    if ("AdStarted".equals(this.a.getType())) {
      InterstitialAd.a(this.b.a).onAdPresent();
      return;
    } 
    if ("AdUserClick".equals(this.a.getType()))
      InterstitialAd.a(this.b.a).onAdClick(this.b.a); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */