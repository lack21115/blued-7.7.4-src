package com.baidu.mobads;

import android.content.Context;

public class BaiduNativeH5AdViewManager {
  private static BaiduNativeH5AdViewManager a;
  
  public static BaiduNativeH5AdViewManager getInstance() {
    // Byte code:
    //   0: ldc com/baidu/mobads/BaiduNativeH5AdViewManager
    //   2: monitorenter
    //   3: getstatic com/baidu/mobads/BaiduNativeH5AdViewManager.a : Lcom/baidu/mobads/BaiduNativeH5AdViewManager;
    //   6: ifnonnull -> 19
    //   9: new com/baidu/mobads/BaiduNativeH5AdViewManager
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/baidu/mobads/BaiduNativeH5AdViewManager.a : Lcom/baidu/mobads/BaiduNativeH5AdViewManager;
    //   19: getstatic com/baidu/mobads/BaiduNativeH5AdViewManager.a : Lcom/baidu/mobads/BaiduNativeH5AdViewManager;
    //   22: astore_0
    //   23: ldc com/baidu/mobads/BaiduNativeH5AdViewManager
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/baidu/mobads/BaiduNativeH5AdViewManager
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	23	28	finally
  }
  
  public BaiduNativeH5AdView getBaiduNativeH5AdView(Context paramContext, BaiduNativeAdPlacement paramBaiduNativeAdPlacement, int paramInt) {
    BaiduNativeH5AdView baiduNativeH5AdView = paramBaiduNativeAdPlacement.getAdView();
    if (paramBaiduNativeAdPlacement.getAdView() == null) {
      baiduNativeH5AdView = new BaiduNativeH5AdView(paramContext, paramInt);
      baiduNativeH5AdView.setAdPlacement(paramBaiduNativeAdPlacement);
      paramBaiduNativeAdPlacement.setAdView(baiduNativeH5AdView);
    } 
    return baiduNativeH5AdView;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\BaiduNativeH5AdViewManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */