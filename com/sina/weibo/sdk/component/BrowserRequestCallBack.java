package com.sina.weibo.sdk.component;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;

interface BrowserRequestCallBack {
  void onPageFinishedCallBack(WebView paramWebView, String paramString);
  
  void onPageStartedCallBack(WebView paramWebView, String paramString, Bitmap paramBitmap);
  
  void onReceivedErrorCallBack(WebView paramWebView, int paramInt, String paramString1, String paramString2);
  
  void onReceivedSslErrorCallBack(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError);
  
  boolean shouldOverrideUrlLoadingCallBack(WebView paramWebView, String paramString);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\component\BrowserRequestCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */