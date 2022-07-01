package com.blued.android.framework.web.cache;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BluedWebViewCacheClient extends WebViewClient {
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest) {
    WebResourceResponse webResourceResponse = BluedWebViewCache.a(paramWebResourceRequest);
    return (webResourceResponse == null) ? super.shouldInterceptRequest(paramWebView, paramWebResourceRequest) : webResourceResponse;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\web\cache\BluedWebViewCacheClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */