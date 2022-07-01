package org.chromium.android_webview;

import org.chromium.base.Callback;

final class AwContentsClientCallbackHelper$OnSafeBrowsingHitInfo {
  final Callback mCallback;
  
  final AwContentsClient$AwWebResourceRequest mRequest;
  
  final int mThreatType;
  
  AwContentsClientCallbackHelper$OnSafeBrowsingHitInfo(AwContentsClient$AwWebResourceRequest paramAwContentsClient$AwWebResourceRequest, int paramInt, Callback paramCallback) {
    this.mRequest = paramAwContentsClient$AwWebResourceRequest;
    this.mThreatType = paramInt;
    this.mCallback = paramCallback;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwContentsClientCallbackHelper$OnSafeBrowsingHitInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */