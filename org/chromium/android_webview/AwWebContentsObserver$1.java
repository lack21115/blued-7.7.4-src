package org.chromium.android_webview;

final class AwWebContentsObserver$1 extends AwContents$VisualStateCallback {
  public final void onComplete(long paramLong) {
    AwContentsClient awContentsClient = AwWebContentsObserver.this.mAwContentsClient.get();
    if (awContentsClient == null)
      return; 
    awContentsClient.onPageCommitVisible(url);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwWebContentsObserver$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */