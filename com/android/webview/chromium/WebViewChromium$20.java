package com.android.webview.chromium;

import android.webkit.ValueCallback;

final class WebViewChromium$20 implements Runnable {
  public final void run() {
    WebViewChromium.this.mAwContents.evaluateJavaScript(script, CallbackConverter.fromValueCallback(resultCallback));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebViewChromium$20.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */