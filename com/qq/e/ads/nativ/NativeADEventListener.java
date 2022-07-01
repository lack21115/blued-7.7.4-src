package com.qq.e.ads.nativ;

import com.qq.e.comm.util.AdError;

public interface NativeADEventListener {
  void onADClicked();
  
  void onADError(AdError paramAdError);
  
  void onADExposed();
  
  void onADStatusChanged();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\nativ\NativeADEventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */