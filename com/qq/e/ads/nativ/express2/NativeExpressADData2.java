package com.qq.e.ads.nativ.express2;

import android.view.View;

public interface NativeExpressADData2 {
  void destroy();
  
  View getAdView();
  
  String getECPMLevel();
  
  int getVideoDuration();
  
  boolean isVideoAd();
  
  void render();
  
  void setAdEventListener(AdEventListener paramAdEventListener);
  
  void setMediaListener(MediaEventListener paramMediaEventListener);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\nativ\express2\NativeExpressADData2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */