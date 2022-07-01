package com.android.webview.chromium;

import android.webkit.WebViewDelegate;

public class WebViewChromiumFactoryProviderForP extends WebViewChromiumFactoryProvider {
  private WebViewChromiumFactoryProviderForP(WebViewDelegate paramWebViewDelegate) {
    super(paramWebViewDelegate);
  }
  
  public static WebViewChromiumFactoryProvider create(WebViewDelegate paramWebViewDelegate) {
    return new WebViewChromiumFactoryProviderForP(paramWebViewDelegate);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebViewChromiumFactoryProviderForP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */