package org.chromium.support_lib_boundary;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.lang.reflect.InvocationHandler;

public interface WebViewClientBoundaryInterface extends FeatureFlagHolderBoundaryInterface {
  void onPageCommitVisible(WebView paramWebView, String paramString);
  
  void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, InvocationHandler paramInvocationHandler);
  
  void onReceivedHttpError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse);
  
  void onSafeBrowsingHit(WebView paramWebView, WebResourceRequest paramWebResourceRequest, int paramInt, InvocationHandler paramInvocationHandler);
  
  boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\support_lib_boundary\WebViewClientBoundaryInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */