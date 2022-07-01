package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;

class i implements Runnable {
  i(h paramh, IOAdEvent paramIOAdEvent) {}
  
  public void run() {
    if ("AdStarted".equals(this.a.getType())) {
      BaiduNativeH5AdView.a(this.b.a, true);
      BaiduNativeH5AdView.a(this.b.a).setRequestStarted(false);
      this.b.a.recordImpression();
      if (BaiduNativeH5AdView.b(this.b.a) != null) {
        BaiduNativeH5AdView.b(this.b.a).onAdShow();
        return;
      } 
    } else if ("AdError".equals(this.a.getType())) {
      BaiduNativeH5AdView.a(this.b.a).setRequestStarted(false);
      if (BaiduNativeH5AdView.b(this.b.a) != null) {
        BaiduNativeH5AdView.b(this.b.a).onAdFail(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.a.getData()));
        return;
      } 
    } else if ("AdUserClick".equals(this.a.getType())) {
      BaiduNativeH5AdView.a(this.b.a).setClicked(true);
      if (BaiduNativeH5AdView.b(this.b.a) != null) {
        BaiduNativeH5AdView.b(this.b.a).onAdClick();
        return;
      } 
    } else {
      if ("AdImpression".equals(this.a.getType())) {
        BaiduNativeH5AdView.a(this.b.a).setWinSended(true);
        return;
      } 
      if ("AdLoadData".equals(this.a.getType())) {
        BaiduNativeH5AdView.b(this.b.a, true);
        if (BaiduNativeH5AdView.b(this.b.a) != null)
          BaiduNativeH5AdView.b(this.b.a).onAdDataLoaded(); 
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */