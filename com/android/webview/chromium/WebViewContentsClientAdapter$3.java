package com.android.webview.chromium;

import android.webkit.SslErrorHandler;
import org.chromium.base.Callback;

final class WebViewContentsClientAdapter$3 extends SslErrorHandler {
  public final void cancel() {
    callback.onResult(Boolean.valueOf(false));
  }
  
  public final void proceed() {
    callback.onResult(Boolean.valueOf(true));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebViewContentsClientAdapter$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */