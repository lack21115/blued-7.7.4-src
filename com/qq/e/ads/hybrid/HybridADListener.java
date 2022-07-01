package com.qq.e.ads.hybrid;

import com.qq.e.comm.util.AdError;

public interface HybridADListener {
  void onClose();
  
  void onError(AdError paramAdError);
  
  void onLoadFinished();
  
  void onPageShow();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\hybrid\HybridADListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */