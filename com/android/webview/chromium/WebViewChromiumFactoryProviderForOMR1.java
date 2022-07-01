package com.android.webview.chromium;

import android.webkit.WebViewDelegate;

class WebViewChromiumFactoryProviderForOMR1 extends WebViewChromiumFactoryProvider {
  private WebViewChromiumFactoryProviderForOMR1(WebViewDelegate paramWebViewDelegate) {
    super(paramWebViewDelegate);
  }
  
  public static WebViewChromiumFactoryProvider create(WebViewDelegate paramWebViewDelegate) {
    return new WebViewChromiumFactoryProviderForOMR1(paramWebViewDelegate);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebViewChromiumFactoryProviderForOMR1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */