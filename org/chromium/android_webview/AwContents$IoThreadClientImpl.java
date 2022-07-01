package org.chromium.android_webview;

final class AwContents$IoThreadClientImpl extends AwContentsIoThreadClient {
  private AwContents$IoThreadClientImpl() {}
  
  public final AwContentsBackgroundThreadClient getBackgroundThreadClient() {
    return AwContents.access$400(AwContents.this);
  }
  
  public final int getCacheMode() {
    return AwContents.access$300(AwContents.this).getCacheMode();
  }
  
  public final boolean getSafeBrowsingEnabled() {
    return AwContents.access$300(AwContents.this).getSafeBrowsingEnabled();
  }
  
  public final boolean shouldAcceptThirdPartyCookies() {
    return AwContents.access$300(AwContents.this).getAcceptThirdPartyCookies();
  }
  
  public final boolean shouldBlockContentUrls() {
    return !AwContents.access$300(AwContents.this).getAllowContentAccess();
  }
  
  public final boolean shouldBlockFileUrls() {
    return !AwContents.access$300(AwContents.this).getAllowFileAccess();
  }
  
  public final boolean shouldBlockNetworkLoads() {
    return AwContents.access$300(AwContents.this).getBlockNetworkLoads();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwContents$IoThreadClientImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */