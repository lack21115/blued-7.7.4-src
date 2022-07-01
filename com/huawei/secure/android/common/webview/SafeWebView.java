package com.huawei.secure.android.common.webview;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huawei.secure.android.common.util.LogsUtil;
import java.util.Arrays;
import java.util.Map;

public class SafeWebView extends WebView {
  private String a;
  
  private String[] b;
  
  private String[] c;
  
  private String[] d;
  
  private WebViewLoadCallBack e;
  
  public SafeWebView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public SafeWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {
    SafeWebSettings.a(this);
    setWebViewClient(null);
  }
  
  private boolean b(String paramString) {
    return URLUtil.isHttpUrl(paramString);
  }
  
  public final void a(WebView paramWebView, String paramString) {
    LogsUtil.a("SafeWebView", "onCheckError url is not in white list ", paramString);
    paramWebView.stopLoading();
    String str = getDefaultErrorPage();
    if (!TextUtils.isEmpty(str)) {
      paramWebView.loadUrl(str);
      return;
    } 
    if (getWebViewLoadCallBack() != null) {
      Log.e("SafeWebView", "onPageStarted WebViewLoadCallBack");
      getWebViewLoadCallBack().a(paramString, WebViewLoadCallBack.ErrorCode.b);
    } 
  }
  
  public boolean a(String paramString) {
    if (TextUtils.isEmpty(paramString)) {
      LogsUtil.b("SafeWebView", "url is null");
      return false;
    } 
    if (!URLUtil.isNetworkUrl(paramString))
      return true; 
    String[] arrayOfString1 = getWhitelistWithPath();
    String[] arrayOfString2 = getWhitelistNotMathcSubDomain();
    String[] arrayOfString3 = getWhitelist();
    return (arrayOfString1 != null && arrayOfString1.length != 0) ? UriUtil.c(paramString, arrayOfString1) : ((arrayOfString2 != null && arrayOfString2.length != 0) ? UriUtil.b(paramString, arrayOfString2) : UriUtil.a(paramString, arrayOfString3));
  }
  
  public String getDefaultErrorPage() {
    return this.a;
  }
  
  public WebViewLoadCallBack getWebViewLoadCallBack() {
    return this.e;
  }
  
  @Deprecated
  public String[] getWhitelist() {
    String[] arrayOfString = this.b;
    return (arrayOfString == null) ? null : Arrays.<String>copyOf(arrayOfString, arrayOfString.length);
  }
  
  @Deprecated
  public String[] getWhitelistNotMathcSubDomain() {
    String[] arrayOfString = this.c;
    return (arrayOfString == null) ? null : Arrays.<String>copyOf(arrayOfString, arrayOfString.length);
  }
  
  public String[] getWhitelistWithPath() {
    String[] arrayOfString = this.d;
    return (arrayOfString == null) ? null : Arrays.<String>copyOf(arrayOfString, arrayOfString.length);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    if (b(paramString1)) {
      Log.e("SafeWebView", "loadDataWithBaseURL: http url , not safe");
      if (!TextUtils.isEmpty(this.a)) {
        super.loadDataWithBaseURL(this.a, paramString2, paramString3, paramString4, paramString5);
        return;
      } 
      if (getWebViewLoadCallBack() != null) {
        Log.e("SafeWebView", "WebViewLoadCallBack");
        getWebViewLoadCallBack().a(paramString1, WebViewLoadCallBack.ErrorCode.a);
      } 
      return;
    } 
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void loadUrl(String paramString) {
    if (b(paramString)) {
      Log.e("SafeWebView", "loadUrl: http url , not safe");
      if (!TextUtils.isEmpty(this.a)) {
        super.loadUrl(this.a);
        return;
      } 
      if (getWebViewLoadCallBack() != null) {
        Log.e("SafeWebView", "WebViewLoadCallBack");
        getWebViewLoadCallBack().a(paramString, WebViewLoadCallBack.ErrorCode.a);
      } 
      return;
    } 
    super.loadUrl(paramString);
  }
  
  public void loadUrl(String paramString, Map<String, String> paramMap) {
    if (b(paramString)) {
      Log.e("SafeWebView", "loadUrl: http url , not safe");
      if (!TextUtils.isEmpty(this.a)) {
        super.loadUrl(this.a, paramMap);
        return;
      } 
      if (getWebViewLoadCallBack() != null) {
        Log.e("SafeWebView", "WebViewLoadCallBack");
        getWebViewLoadCallBack().a(paramString, WebViewLoadCallBack.ErrorCode.a);
      } 
      return;
    } 
    super.loadUrl(paramString, paramMap);
  }
  
  public void postUrl(String paramString, byte[] paramArrayOfbyte) {
    if (b(paramString)) {
      Log.e("SafeWebView", "postUrl: http url , not safe");
      if (!TextUtils.isEmpty(this.a)) {
        super.postUrl(this.a, paramArrayOfbyte);
        return;
      } 
      if (getWebViewLoadCallBack() != null) {
        Log.e("SafeWebView", "WebViewLoadCallBack");
        getWebViewLoadCallBack().a(paramString, WebViewLoadCallBack.ErrorCode.a);
      } 
      return;
    } 
    super.postUrl(paramString, paramArrayOfbyte);
  }
  
  public void setDefaultErrorPage(String paramString) {
    this.a = paramString;
  }
  
  public void setWebViewClient(WebViewClient paramWebViewClient) {
    super.setWebViewClient(new c(paramWebViewClient, true));
  }
  
  public void setWebViewLoadCallBack(WebViewLoadCallBack paramWebViewLoadCallBack) {
    this.e = paramWebViewLoadCallBack;
  }
  
  @Deprecated
  public void setWhitelist(String[] paramArrayOfString) {
    if (paramArrayOfString == null) {
      paramArrayOfString = null;
    } else {
      paramArrayOfString = Arrays.<String>copyOf(paramArrayOfString, paramArrayOfString.length);
    } 
    this.b = paramArrayOfString;
  }
  
  @Deprecated
  public void setWhitelistNotMathcSubDomain(String[] paramArrayOfString) {
    if (paramArrayOfString == null) {
      paramArrayOfString = null;
    } else {
      paramArrayOfString = Arrays.<String>copyOf(paramArrayOfString, paramArrayOfString.length);
    } 
    this.c = paramArrayOfString;
  }
  
  public void setWhitelistWithPath(String[] paramArrayOfString) {
    if (paramArrayOfString == null) {
      paramArrayOfString = null;
    } else {
      paramArrayOfString = Arrays.<String>copyOf(paramArrayOfString, paramArrayOfString.length);
    } 
    this.d = paramArrayOfString;
  }
  
  static class a implements DialogInterface.OnClickListener {
    private final SslErrorHandler a;
    
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      this.a.cancel();
    }
  }
  
  static class b implements DialogInterface.OnClickListener {
    private final SslErrorHandler a;
    
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      this.a.proceed();
    }
  }
  
  final class c extends WebViewClient {
    private WebViewClient b;
    
    private boolean c;
    
    private c(SafeWebView this$0, WebViewClient param1WebViewClient, boolean param1Boolean) {
      this.b = param1WebViewClient;
      this.c = param1Boolean;
    }
    
    public void doUpdateVisitedHistory(WebView param1WebView, String param1String, boolean param1Boolean) {
      WebViewClient webViewClient = this.b;
      if (webViewClient != null) {
        webViewClient.doUpdateVisitedHistory(param1WebView, param1String, param1Boolean);
        return;
      } 
      super.doUpdateVisitedHistory(param1WebView, param1String, param1Boolean);
    }
    
    public void onFormResubmission(WebView param1WebView, Message param1Message1, Message param1Message2) {
      WebViewClient webViewClient = this.b;
      if (webViewClient != null) {
        webViewClient.onFormResubmission(param1WebView, param1Message1, param1Message2);
        return;
      } 
      super.onFormResubmission(param1WebView, param1Message1, param1Message2);
    }
    
    public void onLoadResource(WebView param1WebView, String param1String) {
      WebViewClient webViewClient = this.b;
      if (webViewClient != null) {
        webViewClient.onLoadResource(param1WebView, param1String);
        return;
      } 
      super.onLoadResource(param1WebView, param1String);
    }
    
    public void onPageCommitVisible(WebView param1WebView, String param1String) {
      WebViewClient webViewClient = this.b;
      if (webViewClient != null) {
        webViewClient.onPageCommitVisible(param1WebView, param1String);
        return;
      } 
      super.onPageCommitVisible(param1WebView, param1String);
    }
    
    public void onPageFinished(WebView param1WebView, String param1String) {
      WebViewClient webViewClient = this.b;
      if (webViewClient != null) {
        webViewClient.onPageFinished(param1WebView, param1String);
        return;
      } 
      super.onPageFinished(param1WebView, param1String);
    }
    
    public void onPageStarted(WebView param1WebView, String param1String, Bitmap param1Bitmap) {
      WebViewClient webViewClient = this.b;
      if (webViewClient != null && !this.c) {
        webViewClient.onPageStarted(param1WebView, param1String, param1Bitmap);
        return;
      } 
      if (!this.a.a(param1String)) {
        this.a.a(param1WebView, param1String);
        return;
      } 
      super.onPageStarted(param1WebView, param1String, param1Bitmap);
    }
    
    public void onReceivedClientCertRequest(WebView param1WebView, ClientCertRequest param1ClientCertRequest) {
      WebViewClient webViewClient = this.b;
      if (webViewClient != null) {
        webViewClient.onReceivedClientCertRequest(param1WebView, param1ClientCertRequest);
        return;
      } 
      super.onReceivedClientCertRequest(param1WebView, param1ClientCertRequest);
    }
    
    public void onReceivedError(WebView param1WebView, int param1Int, String param1String1, String param1String2) {
      WebViewClient webViewClient = this.b;
      if (webViewClient != null) {
        webViewClient.onReceivedError(param1WebView, param1Int, param1String1, param1String2);
        return;
      } 
      super.onReceivedError(param1WebView, param1Int, param1String1, param1String2);
    }
    
    public void onReceivedError(WebView param1WebView, WebResourceRequest param1WebResourceRequest, WebResourceError param1WebResourceError) {
      WebViewClient webViewClient = this.b;
      if (webViewClient != null) {
        webViewClient.onReceivedError(param1WebView, param1WebResourceRequest, param1WebResourceError);
        return;
      } 
      super.onReceivedError(param1WebView, param1WebResourceRequest, param1WebResourceError);
    }
    
    public void onReceivedHttpAuthRequest(WebView param1WebView, HttpAuthHandler param1HttpAuthHandler, String param1String1, String param1String2) {
      WebViewClient webViewClient = this.b;
      if (webViewClient != null) {
        webViewClient.onReceivedHttpAuthRequest(param1WebView, param1HttpAuthHandler, param1String1, param1String2);
        return;
      } 
      super.onReceivedHttpAuthRequest(param1WebView, param1HttpAuthHandler, param1String1, param1String2);
    }
    
    public void onReceivedHttpError(WebView param1WebView, WebResourceRequest param1WebResourceRequest, WebResourceResponse param1WebResourceResponse) {
      WebViewClient webViewClient = this.b;
      if (webViewClient != null) {
        webViewClient.onReceivedHttpError(param1WebView, param1WebResourceRequest, param1WebResourceResponse);
        return;
      } 
      super.onReceivedHttpError(param1WebView, param1WebResourceRequest, param1WebResourceResponse);
    }
    
    public void onReceivedLoginRequest(WebView param1WebView, String param1String1, String param1String2, String param1String3) {
      WebViewClient webViewClient = this.b;
      if (webViewClient != null) {
        webViewClient.onReceivedLoginRequest(param1WebView, param1String1, param1String2, param1String3);
        return;
      } 
      super.onReceivedLoginRequest(param1WebView, param1String1, param1String2, param1String3);
    }
    
    public void onReceivedSslError(WebView param1WebView, SslErrorHandler param1SslErrorHandler, SslError param1SslError) {
      WebViewClient webViewClient = this.b;
      if (webViewClient != null) {
        webViewClient.onReceivedSslError(param1WebView, param1SslErrorHandler, param1SslError);
        return;
      } 
      super.onReceivedSslError(param1WebView, param1SslErrorHandler, param1SslError);
    }
    
    public boolean onRenderProcessGone(WebView param1WebView, RenderProcessGoneDetail param1RenderProcessGoneDetail) {
      WebViewClient webViewClient = this.b;
      return (webViewClient != null) ? webViewClient.onRenderProcessGone(param1WebView, param1RenderProcessGoneDetail) : super.onRenderProcessGone(param1WebView, param1RenderProcessGoneDetail);
    }
    
    public void onSafeBrowsingHit(WebView param1WebView, WebResourceRequest param1WebResourceRequest, int param1Int, SafeBrowsingResponse param1SafeBrowsingResponse) {
      WebViewClient webViewClient = this.b;
      if (webViewClient != null) {
        webViewClient.onSafeBrowsingHit(param1WebView, param1WebResourceRequest, param1Int, param1SafeBrowsingResponse);
        return;
      } 
      super.onSafeBrowsingHit(param1WebView, param1WebResourceRequest, param1Int, param1SafeBrowsingResponse);
    }
    
    public void onScaleChanged(WebView param1WebView, float param1Float1, float param1Float2) {
      WebViewClient webViewClient = this.b;
      if (webViewClient != null) {
        webViewClient.onScaleChanged(param1WebView, param1Float1, param1Float2);
        return;
      } 
      super.onScaleChanged(param1WebView, param1Float1, param1Float2);
    }
    
    public void onTooManyRedirects(WebView param1WebView, Message param1Message1, Message param1Message2) {
      WebViewClient webViewClient = this.b;
      if (webViewClient != null) {
        webViewClient.onTooManyRedirects(param1WebView, param1Message1, param1Message2);
        return;
      } 
      super.onTooManyRedirects(param1WebView, param1Message1, param1Message2);
    }
    
    public void onUnhandledKeyEvent(WebView param1WebView, KeyEvent param1KeyEvent) {
      WebViewClient webViewClient = this.b;
      if (webViewClient != null) {
        webViewClient.onUnhandledKeyEvent(param1WebView, param1KeyEvent);
        return;
      } 
      super.onUnhandledKeyEvent(param1WebView, param1KeyEvent);
    }
    
    public WebResourceResponse shouldInterceptRequest(WebView param1WebView, WebResourceRequest param1WebResourceRequest) {
      WebViewClient webViewClient = this.b;
      return (webViewClient != null) ? webViewClient.shouldInterceptRequest(param1WebView, param1WebResourceRequest) : super.shouldInterceptRequest(param1WebView, param1WebResourceRequest);
    }
    
    public WebResourceResponse shouldInterceptRequest(WebView param1WebView, String param1String) {
      WebViewClient webViewClient = this.b;
      return (webViewClient != null) ? webViewClient.shouldInterceptRequest(param1WebView, param1String) : super.shouldInterceptRequest(param1WebView, param1String);
    }
    
    public boolean shouldOverrideKeyEvent(WebView param1WebView, KeyEvent param1KeyEvent) {
      WebViewClient webViewClient = this.b;
      return (webViewClient != null) ? webViewClient.shouldOverrideKeyEvent(param1WebView, param1KeyEvent) : super.shouldOverrideKeyEvent(param1WebView, param1KeyEvent);
    }
    
    public boolean shouldOverrideUrlLoading(WebView param1WebView, WebResourceRequest param1WebResourceRequest) {
      WebViewClient webViewClient = this.b;
      return (webViewClient != null) ? webViewClient.shouldOverrideUrlLoading(param1WebView, param1WebResourceRequest) : super.shouldOverrideUrlLoading(param1WebView, param1WebResourceRequest);
    }
    
    public boolean shouldOverrideUrlLoading(WebView param1WebView, String param1String) {
      WebViewClient webViewClient = this.b;
      return (webViewClient != null) ? webViewClient.shouldOverrideUrlLoading(param1WebView, param1String) : super.shouldOverrideUrlLoading(param1WebView, param1String);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\common\webview\SafeWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */