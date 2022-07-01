package org.chromium.android_webview;

import java.util.HashMap;
import org.chromium.base.annotations.CalledByNative;

public abstract class AwContentsBackgroundThreadClient {
  @CalledByNative
  private AwWebResourceResponse shouldInterceptRequestFromNative(String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2) {
    AwContentsClient$AwWebResourceRequest awContentsClient$AwWebResourceRequest = new AwContentsClient$AwWebResourceRequest();
    awContentsClient$AwWebResourceRequest.url = paramString1;
    awContentsClient$AwWebResourceRequest.isMainFrame = paramBoolean1;
    awContentsClient$AwWebResourceRequest.hasUserGesture = paramBoolean2;
    awContentsClient$AwWebResourceRequest.method = paramString2;
    awContentsClient$AwWebResourceRequest.requestHeaders = new HashMap<Object, Object>(paramArrayOfString1.length);
    int i;
    for (i = 0; i < paramArrayOfString1.length; i++)
      awContentsClient$AwWebResourceRequest.requestHeaders.put(paramArrayOfString1[i], paramArrayOfString2[i]); 
    return shouldInterceptRequest(awContentsClient$AwWebResourceRequest);
  }
  
  public abstract AwWebResourceResponse shouldInterceptRequest(AwContentsClient$AwWebResourceRequest paramAwContentsClient$AwWebResourceRequest);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwContentsBackgroundThreadClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */