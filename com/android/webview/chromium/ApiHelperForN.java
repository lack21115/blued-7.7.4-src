package com.android.webview.chromium;

import android.annotation.TargetApi;
import android.webkit.ServiceWorkerController;
import android.webkit.TokenBindingService;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import org.chromium.android_webview.AwContentsClient;
import org.chromium.base.annotations.DoNotInline;

@TargetApi(24)
@DoNotInline
public final class ApiHelperForN {
  public static ServiceWorkerController createServiceWorkerControllerAdapter(WebViewChromiumAwInit paramWebViewChromiumAwInit) {
    return new ServiceWorkerControllerAdapter(paramWebViewChromiumAwInit.getServiceWorkerController());
  }
  
  public static TokenBindingService createTokenBindingManagerAdapter(WebViewChromiumFactoryProvider paramWebViewChromiumFactoryProvider) {
    return new TokenBindingManagerAdapter(paramWebViewChromiumFactoryProvider);
  }
  
  public static boolean shouldOverrideUrlLoading(WebViewClient paramWebViewClient, WebView paramWebView, AwContentsClient.AwWebResourceRequest paramAwWebResourceRequest) {
    return paramWebViewClient.shouldOverrideUrlLoading(paramWebView, new WebResourceRequestAdapter(paramAwWebResourceRequest));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\ApiHelperForN.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */