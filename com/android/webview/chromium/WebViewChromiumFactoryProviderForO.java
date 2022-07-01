package com.android.webview.chromium;

import android.webkit.WebViewDelegate;

class WebViewChromiumFactoryProviderForO extends WebViewChromiumFactoryProvider {
  private WebViewChromiumFactoryProviderForO(WebViewDelegate paramWebViewDelegate) {
    super(paramWebViewDelegate);
  }
  
  public static WebViewChromiumFactoryProvider create(WebViewDelegate paramWebViewDelegate) {
    return new WebViewChromiumFactoryProviderForO(paramWebViewDelegate);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebViewChromiumFactoryProviderForO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */