package com.bytedance.sdk.openadsdk;

public interface TTAppDownloadListener {
  void onDownloadActive(long paramLong1, long paramLong2, String paramString1, String paramString2);
  
  void onDownloadFailed(long paramLong1, long paramLong2, String paramString1, String paramString2);
  
  void onDownloadFinished(long paramLong, String paramString1, String paramString2);
  
  void onDownloadPaused(long paramLong1, long paramLong2, String paramString1, String paramString2);
  
  void onIdle();
  
  void onInstalled(String paramString1, String paramString2);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\TTAppDownloadListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */