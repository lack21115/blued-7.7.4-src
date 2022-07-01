package com.qq.e.ads.nativ;

import com.qq.e.comm.util.AdError;

public interface NativeExpressMediaListener {
  void onVideoCached(NativeExpressADView paramNativeExpressADView);
  
  void onVideoComplete(NativeExpressADView paramNativeExpressADView);
  
  void onVideoError(NativeExpressADView paramNativeExpressADView, AdError paramAdError);
  
  void onVideoInit(NativeExpressADView paramNativeExpressADView);
  
  void onVideoLoading(NativeExpressADView paramNativeExpressADView);
  
  void onVideoPageClose(NativeExpressADView paramNativeExpressADView);
  
  void onVideoPageOpen(NativeExpressADView paramNativeExpressADView);
  
  void onVideoPause(NativeExpressADView paramNativeExpressADView);
  
  void onVideoReady(NativeExpressADView paramNativeExpressADView, long paramLong);
  
  void onVideoStart(NativeExpressADView paramNativeExpressADView);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\nativ\NativeExpressMediaListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */