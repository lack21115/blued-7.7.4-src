package com.android.webview.chromium;

import android.os.Handler;
import android.os.Message;
import android.webkit.WebView;

final class WebViewContentsClientAdapter$1 extends Handler {
  public final void handleMessage(Message paramMessage) {
    if (paramMessage.what == 100) {
      WebView webView = ((WebView.WebViewTransport)paramMessage.obj).getWebView();
      if (webView != WebViewContentsClientAdapter.this.mWebView) {
        if (webView == null || webView.copyBackForwardList().getSize() == 0) {
          WebViewChromium.completeWindowCreation(WebViewContentsClientAdapter.this.mWebView, webView);
          return;
        } 
        throw new IllegalArgumentException("New WebView for popup window must not have been  previously navigated.");
      } 
      throw new IllegalArgumentException("Parent WebView cannot host it's own popup window. Please use WebSettings.setSupportMultipleWindows(false)");
    } 
    throw new IllegalStateException();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebViewContentsClientAdapter$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */