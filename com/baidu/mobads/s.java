package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;

class s implements IOAdEventListener {
  s(SplashAd paramSplashAd) {}
  
  public void run(IOAdEvent paramIOAdEvent) {
    if (SplashAd.a(this.a) != null)
      XAdSDKFoundationFacade.getInstance().getCommonUtils().a(new t(this, paramIOAdEvent)); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */