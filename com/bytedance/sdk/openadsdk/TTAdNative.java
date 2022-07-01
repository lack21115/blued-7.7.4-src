package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.a.b;
import java.util.List;

public interface TTAdNative {
  void loadBannerAd(AdSlot paramAdSlot, BannerAdListener paramBannerAdListener);
  
  void loadBannerExpressAd(AdSlot paramAdSlot, NativeExpressAdListener paramNativeExpressAdListener);
  
  void loadDrawFeedAd(AdSlot paramAdSlot, DrawFeedAdListener paramDrawFeedAdListener);
  
  void loadExpressDrawFeedAd(AdSlot paramAdSlot, NativeExpressAdListener paramNativeExpressAdListener);
  
  void loadFeedAd(AdSlot paramAdSlot, FeedAdListener paramFeedAdListener);
  
  void loadFullScreenVideoAd(AdSlot paramAdSlot, FullScreenVideoAdListener paramFullScreenVideoAdListener);
  
  void loadInteractionAd(AdSlot paramAdSlot, InteractionAdListener paramInteractionAdListener);
  
  void loadInteractionExpressAd(AdSlot paramAdSlot, NativeExpressAdListener paramNativeExpressAdListener);
  
  void loadNativeAd(AdSlot paramAdSlot, NativeAdListener paramNativeAdListener);
  
  void loadNativeExpressAd(AdSlot paramAdSlot, NativeExpressAdListener paramNativeExpressAdListener);
  
  void loadRewardVideoAd(AdSlot paramAdSlot, RewardVideoAdListener paramRewardVideoAdListener);
  
  void loadSplashAd(AdSlot paramAdSlot, SplashAdListener paramSplashAdListener);
  
  void loadSplashAd(AdSlot paramAdSlot, SplashAdListener paramSplashAdListener, int paramInt);
  
  public static interface BannerAdListener extends b {
    void onBannerAdLoad(TTBannerAd param1TTBannerAd);
    
    void onError(int param1Int, String param1String);
  }
  
  public static interface DrawFeedAdListener extends b {
    void onDrawFeedAdLoad(List<TTDrawFeedAd> param1List);
    
    void onError(int param1Int, String param1String);
  }
  
  public static interface FeedAdListener extends b {
    void onError(int param1Int, String param1String);
    
    void onFeedAdLoad(List<TTFeedAd> param1List);
  }
  
  public static interface FullScreenVideoAdListener extends b {
    void onError(int param1Int, String param1String);
    
    void onFullScreenVideoAdLoad(TTFullScreenVideoAd param1TTFullScreenVideoAd);
    
    void onFullScreenVideoCached();
  }
  
  public static interface InteractionAdListener extends b {
    void onError(int param1Int, String param1String);
    
    void onInteractionAdLoad(TTInteractionAd param1TTInteractionAd);
  }
  
  public static interface NativeAdListener extends b {
    void onError(int param1Int, String param1String);
    
    void onNativeAdLoad(List<TTNativeAd> param1List);
  }
  
  public static interface NativeExpressAdListener extends b {
    void onError(int param1Int, String param1String);
    
    void onNativeExpressAdLoad(List<TTNativeExpressAd> param1List);
  }
  
  public static interface RewardVideoAdListener extends b {
    void onError(int param1Int, String param1String);
    
    void onRewardVideoAdLoad(TTRewardVideoAd param1TTRewardVideoAd);
    
    void onRewardVideoCached();
  }
  
  public static interface SplashAdListener extends b {
    void onError(int param1Int, String param1String);
    
    void onSplashAdLoad(TTSplashAd param1TTSplashAd);
    
    void onTimeout();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\TTAdNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */