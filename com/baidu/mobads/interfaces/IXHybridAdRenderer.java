package com.baidu.mobads.interfaces;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;

public interface IXHybridAdRenderer extends IXAdContainer {
  String getJavaScriptBridge();
  
  void onPageFinished(WebView paramWebView, String paramString);
  
  void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap);
  
  void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2);
  
  void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError);
  
  void setCustomerWebView(WebView paramWebView);
  
  boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\interfaces\IXHybridAdRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */