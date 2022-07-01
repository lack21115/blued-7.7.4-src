package com.bytedance.sdk.openadsdk;

public interface TTGlobalAppDownloadListener {
  void onDownloadActive(TTAppDownloadInfo paramTTAppDownloadInfo);
  
  void onDownloadFailed(TTAppDownloadInfo paramTTAppDownloadInfo);
  
  void onDownloadFinished(TTAppDownloadInfo paramTTAppDownloadInfo);
  
  void onDownloadPaused(TTAppDownloadInfo paramTTAppDownloadInfo);
  
  void onInstalled(String paramString1, String paramString2, long paramLong, int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\TTGlobalAppDownloadListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */