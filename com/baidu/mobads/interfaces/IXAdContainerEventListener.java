package com.baidu.mobads.interfaces;

import java.util.HashMap;

public interface IXAdContainerEventListener {
  void onAdClicked(IXAdContainer paramIXAdContainer, IXAdInstanceInfo paramIXAdInstanceInfo, Boolean paramBoolean, HashMap<String, Object> paramHashMap);
  
  void onAdCustomEvent(String paramString, IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap);
  
  void onAdDurationChange(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap);
  
  void onAdError(IXAdContainer paramIXAdContainer, IXAdInstanceInfo paramIXAdInstanceInfo, Boolean paramBoolean, HashMap<String, Object> paramHashMap);
  
  void onAdExpandedChange(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap);
  
  void onAdImpression(IXAdContainer paramIXAdContainer, IXAdInstanceInfo paramIXAdInstanceInfo, Boolean paramBoolean, HashMap<String, Object> paramHashMap);
  
  void onAdInteraction(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap);
  
  void onAdLinearChange(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap);
  
  void onAdLoaded(IXAdContainer paramIXAdContainer, IXAdInstanceInfo paramIXAdInstanceInfo, Boolean paramBoolean, HashMap<String, Object> paramHashMap);
  
  void onAdPaused(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap);
  
  void onAdPlaying(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap);
  
  void onAdRemainingTimeChange(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap);
  
  void onAdSizeChange(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap);
  
  void onAdSkippableStateChange(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap);
  
  void onAdSkipped(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap);
  
  void onAdStarted(IXAdContainer paramIXAdContainer, IXAdInstanceInfo paramIXAdInstanceInfo, Boolean paramBoolean, HashMap<String, Object> paramHashMap);
  
  void onAdStoped(IXAdContainer paramIXAdContainer, IXAdInstanceInfo paramIXAdInstanceInfo, Boolean paramBoolean1, Boolean paramBoolean2, HashMap<String, Object> paramHashMap);
  
  void onAdUserAcceptInvitation(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap);
  
  void onAdUserClosed(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap);
  
  void onAdUserMinimize(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap);
  
  void onAdVideoComplete(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap);
  
  void onAdVideoFirstQuartile(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap);
  
  void onAdVideoMidpoint(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap);
  
  void onAdVideoStart(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap);
  
  void onAdVideoThirdQuartile(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap);
  
  void onAdVolumeChange(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\interfaces\IXAdContainerEventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */