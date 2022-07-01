package com.android.webview.chromium;

import android.annotation.TargetApi;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import org.chromium.android_webview.AwRenderProcessGoneDetail;
import org.chromium.base.annotations.DoNotInline;

@TargetApi(26)
@DoNotInline
public final class ApiHelperForO {
  public static boolean onRenderProcessGone(WebViewClient paramWebViewClient, WebView paramWebView, AwRenderProcessGoneDetail paramAwRenderProcessGoneDetail) {
    return paramWebViewClient.onRenderProcessGone(paramWebView, new ApiHelperForO$1(paramAwRenderProcessGoneDetail));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\ApiHelperForO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */