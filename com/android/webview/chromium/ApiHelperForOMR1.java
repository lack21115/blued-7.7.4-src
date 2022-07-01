package com.android.webview.chromium;

import android.annotation.TargetApi;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import org.chromium.android_webview.AwContentsClient;
import org.chromium.base.Callback;
import org.chromium.base.annotations.DoNotInline;

@TargetApi(27)
@DoNotInline
public final class ApiHelperForOMR1 {
  public static void onSafeBrowsingHit(WebViewClient paramWebViewClient, WebView paramWebView, AwContentsClient.AwWebResourceRequest paramAwWebResourceRequest, int paramInt, Callback paramCallback) {
    paramWebViewClient.onSafeBrowsingHit(paramWebView, new WebResourceRequestAdapter(paramAwWebResourceRequest), paramInt, new SafeBrowsingResponseAdapter(paramCallback));
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\ApiHelperForOMR1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */