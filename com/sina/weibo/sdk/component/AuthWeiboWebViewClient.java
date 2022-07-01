package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.utils.Utility;

class AuthWeiboWebViewClient extends WeiboWebViewClient {
  private boolean isCallBacked = false;
  
  private Activity mAct;
  
  private AuthRequestParam mAuthRequestParam;
  
  private WeiboAuthListener mListener;
  
  public AuthWeiboWebViewClient(Activity paramActivity, AuthRequestParam paramAuthRequestParam) {
    this.mAct = paramActivity;
    this.mAuthRequestParam = paramAuthRequestParam;
    this.mListener = this.mAuthRequestParam.getAuthListener();
  }
  
  private void handleRedirectUrl(String paramString) {
    WeiboAuthListener weiboAuthListener;
    Bundle bundle = Utility.parseUrl(paramString);
    String str1 = bundle.getString("error");
    String str2 = bundle.getString("error_code");
    String str3 = bundle.getString("error_description");
    if (str1 == null && str2 == null) {
      weiboAuthListener = this.mListener;
      if (weiboAuthListener != null) {
        weiboAuthListener.onComplete(bundle);
        return;
      } 
    } else {
      WeiboAuthListener weiboAuthListener1 = this.mListener;
      if (weiboAuthListener1 != null)
        weiboAuthListener1.onWeiboException((WeiboException)new WeiboAuthException(str2, (String)weiboAuthListener, str3)); 
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
    if (paramString.startsWith(this.mAuthRequestParam.getAuthInfo().getRedirectUrl()) && !this.isCallBacked) {
      this.isCallBacked = true;
      handleRedirectUrl(paramString);
      paramWebView.stopLoading();
      WeiboSdkBrowser.closeBrowser(this.mAct, this.mAuthRequestParam.getAuthListenerKey(), null);
      return;
    } 
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
    WeiboAuthListener weiboAuthListener;
    if (this.mCallBack != null)
      this.mCallBack.shouldOverrideUrlLoadingCallBack(paramWebView, paramString); 
    if (paramString.startsWith("sms:")) {
      Intent intent = new Intent("android.intent.action.VIEW");
      intent.putExtra("address", paramString.replace("sms:", ""));
      intent.setType("vnd.android-dir/mms-sms");
      this.mAct.startActivity(intent);
      return true;
    } 
    if (paramString.startsWith("sinaweibo://browser/close")) {
      weiboAuthListener = this.mListener;
      if (weiboAuthListener != null)
        weiboAuthListener.onCancel(); 
      WeiboSdkBrowser.closeBrowser(this.mAct, this.mAuthRequestParam.getAuthListenerKey(), null);
      return true;
    } 
    return super.shouldOverrideUrlLoading((WebView)weiboAuthListener, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\component\AuthWeiboWebViewClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */