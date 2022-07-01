package org.chromium.android_webview;

import org.chromium.base.annotations.CalledByNative;

public abstract class AwContentsIoThreadClient {
  @CalledByNative
  public abstract AwContentsBackgroundThreadClient getBackgroundThreadClient();
  
  @CalledByNative
  public abstract int getCacheMode();
  
  @CalledByNative
  public abstract boolean getSafeBrowsingEnabled();
  
  @CalledByNative
  public abstract boolean shouldAcceptThirdPartyCookies();
  
  @CalledByNative
  public abstract boolean shouldBlockContentUrls();
  
  @CalledByNative
  public abstract boolean shouldBlockFileUrls();
  
  @CalledByNative
  public abstract boolean shouldBlockNetworkLoads();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwContentsIoThreadClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */