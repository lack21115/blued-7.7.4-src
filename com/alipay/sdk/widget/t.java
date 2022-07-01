package com.alipay.sdk.widget;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class t extends WebViewClient {
  t(p paramp) {}
  
  public void onPageFinished(WebView paramWebView, String paramString) {
    if (!p.f(this.a).c(this.a, paramString))
      super.onPageFinished(paramWebView, paramString); 
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
    if (!p.f(this.a).a(this.a, paramInt, paramString1, paramString2))
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2); 
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError) {
    if (!p.f(this.a).a(this.a, paramSslErrorHandler, paramSslError))
      super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError); 
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
    return !p.f(this.a).b(this.a, paramString) ? super.shouldOverrideUrlLoading(paramWebView, paramString) : true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\widget\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */