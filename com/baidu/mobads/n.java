package com.baidu.mobads;

import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;

class n implements IOAdEventListener {
  n(InterstitialAd paramInterstitialAd) {}
  
  public void run(IOAdEvent paramIOAdEvent) {
    IXAdLogger iXAdLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
    String str = InterstitialAd.TAG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("evt.type=");
    stringBuilder.append(paramIOAdEvent.getType());
    iXAdLogger.i(str, stringBuilder.toString());
    XAdSDKFoundationFacade.getInstance().getCommonUtils().a(new o(this, paramIOAdEvent));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */