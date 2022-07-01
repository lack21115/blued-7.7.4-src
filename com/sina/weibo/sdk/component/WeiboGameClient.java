package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.utils.Utility;

class WeiboGameClient extends WeiboWebViewClient {
  private Activity mAct;
  
  private GameRequestParam mGameRequestParam;
  
  private WeiboAuthListener mListener;
  
  public WeiboGameClient(Activity paramActivity, GameRequestParam paramGameRequestParam) {
    this.mAct = paramActivity;
    this.mGameRequestParam = paramGameRequestParam;
    this.mListener = this.mGameRequestParam.getAuthListener();
  }
  
  private void handleRedirectUrl(String paramString) {
    WeiboAuthListener weiboAuthListener;
    Bundle bundle = Utility.parseUrl(paramString);
    if (bundle.getString("error") == null) {
      paramString = "";
    } else {
      paramString = bundle.getString("error");
    } 
    String str1 = bundle.getString("code");
    String str2 = bundle.getString("msg");
    if (paramString == null && str1 == null) {
      weiboAuthListener = this.mListener;
      if (weiboAuthListener != null) {
        weiboAuthListener.onComplete(bundle);
        return;
      } 
    } else {
      WeiboAuthListener weiboAuthListener1 = this.mListener;
      if (weiboAuthListener1 != null)
        weiboAuthListener1.onWeiboException((WeiboException)new WeiboAuthException(str1, (String)weiboAuthListener, str2)); 
    } 
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
    Bundle bundle;
    WeiboAuthListener weiboAuthListener;
    if (this.mCallBack != null)
      this.mCallBack.shouldOverrideUrlLoadingCallBack(paramWebView, paramString); 
    if (paramString.startsWith("sinaweibo://browser/close")) {
      bundle = Utility.parseUri(paramString);
      if (!bundle.isEmpty()) {
        weiboAuthListener = this.mListener;
        if (weiboAuthListener != null)
          weiboAuthListener.onComplete(bundle); 
      } 
      WeiboSdkBrowser.closeBrowser(this.mAct, this.mGameRequestParam.getAuthListenerKey(), null);
      return true;
    } 
    return super.shouldOverrideUrlLoading((WebView)bundle, (String)weiboAuthListener);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\component\WeiboGameClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */