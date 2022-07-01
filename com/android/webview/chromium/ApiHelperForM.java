package com.android.webview.chromium;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import org.chromium.android_webview.AwContentsClient;
import org.chromium.android_webview.AwWebResourceResponse;
import org.chromium.base.annotations.DoNotInline;

@TargetApi(23)
@DoNotInline
public final class ApiHelperForM {
  public static void onPageCommitVisible(WebViewClient paramWebViewClient, WebView paramWebView, String paramString) {
    paramWebViewClient.onPageCommitVisible(paramWebView, paramString);
  }
  
  public static void onReceivedError(WebViewClient paramWebViewClient, WebView paramWebView, AwContentsClient.AwWebResourceRequest paramAwWebResourceRequest, AwContentsClient.AwWebResourceError paramAwWebResourceError) {
    paramWebViewClient.onReceivedError(paramWebView, new WebResourceRequestAdapter(paramAwWebResourceRequest), new WebResourceErrorAdapter(paramAwWebResourceError));
  }
  
  public static void onReceivedHttpError(WebViewClient paramWebViewClient, WebView paramWebView, AwContentsClient.AwWebResourceRequest paramAwWebResourceRequest, AwWebResourceResponse paramAwWebResourceResponse) {
    paramWebViewClient.onReceivedHttpError(paramWebView, new WebResourceRequestAdapter(paramAwWebResourceRequest), new WebResourceResponse(true, paramAwWebResourceResponse.getMimeType(), paramAwWebResourceResponse.getCharset(), paramAwWebResourceResponse.getStatusCode(), paramAwWebResourceResponse.getReasonPhrase(), paramAwWebResourceResponse.mResponseHeaders, paramAwWebResourceResponse.getData()));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\ApiHelperForM.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */