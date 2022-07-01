package com.android.webview.chromium;

import android.graphics.Picture;
import android.webkit.WebView;

final class WebViewContentsClientAdapter$2 implements Runnable {
  public final void run() {
    if (WebViewContentsClientAdapter.access$000(WebViewContentsClientAdapter.this) != null) {
      Picture picture;
      WebView.PictureListener pictureListener = WebViewContentsClientAdapter.access$000(WebViewContentsClientAdapter.this);
      WebView webView = WebViewContentsClientAdapter.this.mWebView;
      if (WebViewContentsClientAdapter.access$100(WebViewContentsClientAdapter.this)) {
        picture = null;
      } else {
        picture = new Picture();
      } 
      pictureListener.onNewPicture(webView, picture);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebViewContentsClientAdapter$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */