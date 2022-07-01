package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.utils.Utility;

class WidgetWeiboWebViewClient extends WeiboWebViewClient {
  private Activity mAct;
  
  private WeiboAuthListener mListener;
  
  private WidgetRequestParam.WidgetRequestCallback mWidgetCallback;
  
  private WidgetRequestParam mWidgetRequestParam;
  
  public WidgetWeiboWebViewClient(Activity paramActivity, WidgetRequestParam paramWidgetRequestParam) {
    this.mAct = paramActivity;
    this.mWidgetRequestParam = paramWidgetRequestParam;
    this.mWidgetCallback = paramWidgetRequestParam.getWidgetRequestCallback();
    this.mListener = paramWidgetRequestParam.getAuthListener();
  }
  
  public void onPageFinished(WebView paramWebView, String paramString) {
    if (this.mCallBack != null)
      this.mCallBack.onPageFinishedCallBack(paramWebView, paramString); 
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {
    if (this.mCallBack != null)
      this.mCallBack.onPageStartedCallBack(paramWebView, paramString, paramBitmap); 
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
    if (this.mCallBack != null)
      this.mCallBack.onReceivedErrorCallBack(paramWebView, paramInt, paramString1, paramString2); 
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError) {
    if (this.mCallBack != null)
      this.mCallBack.onReceivedSslErrorCallBack(paramWebView, paramSslErrorHandler, paramSslError); 
    super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
    WidgetRequestParam.WidgetRequestCallback widgetRequestCallback;
    if (this.mCallBack != null)
      this.mCallBack.shouldOverrideUrlLoadingCallBack(paramWebView, paramString); 
    boolean bool = paramString.startsWith("sinaweibo://browser/close");
    if (paramString.startsWith("sinaweibo://browser/close") || paramString.startsWith("sinaweibo://browser/datatransfer")) {
      Bundle bundle = Utility.parseUri(paramString);
      if (!bundle.isEmpty()) {
        WeiboAuthListener weiboAuthListener = this.mListener;
        if (weiboAuthListener != null)
          weiboAuthListener.onComplete(bundle); 
      } 
      widgetRequestCallback = this.mWidgetCallback;
      if (widgetRequestCallback != null)
        widgetRequestCallback.onWebViewResult(paramString); 
      if (bool)
        WeiboSdkBrowser.closeBrowser(this.mAct, this.mWidgetRequestParam.getAuthListenerKey(), this.mWidgetRequestParam.getWidgetRequestCallbackKey()); 
      return true;
    } 
    return super.shouldOverrideUrlLoading((WebView)widgetRequestCallback, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\component\WidgetWeiboWebViewClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */