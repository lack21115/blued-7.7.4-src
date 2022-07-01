package com.qq.e.comm.pi;

import com.qq.e.ads.nativ.ADSize;
import com.qq.e.comm.adevent.ADListener;

public interface NEADVI {
  void destroy();
  
  void preloadVideo();
  
  void render();
  
  void reportAdNegative();
  
  void setAdListener(ADListener paramADListener);
  
  void setAdSize(ADSize paramADSize);
  
  void setBrowserType(int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\pi\NEADVI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */