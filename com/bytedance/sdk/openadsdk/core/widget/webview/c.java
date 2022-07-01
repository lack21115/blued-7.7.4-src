package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.sdk.openadsdk.c.j;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.downloadnew.a.b.b;
import com.bytedance.sdk.openadsdk.downloadnew.a.d;
import com.bytedance.sdk.openadsdk.utils.b;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.s;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.w;

public class c extends WebViewClient {
  protected final x b;
  
  protected final Context c;
  
  protected final String d;
  
  protected j e;
  
  protected boolean f = true;
  
  protected boolean g = true;
  
  public c(Context paramContext, x paramx, String paramString, j paramj) {
    this.c = paramContext;
    this.b = paramx;
    this.d = paramString;
    this.e = paramj;
  }
  
  public void onLoadResource(WebView paramWebView, String paramString) {
    super.onLoadResource(paramWebView, paramString);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString) {
    if (t.a()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onPageFinished ");
      stringBuilder.append(paramString);
      t.a("WebChromeClient", stringBuilder.toString());
    } 
    j j1 = this.e;
    if (j1 != null)
      j1.a(paramWebView, paramString); 
    if (paramWebView != null && this.f)
      try {
        String str = a.a(o.h().j(), this.d);
        if (!TextUtils.isEmpty(str))
          s.a(paramWebView, str); 
      } finally {} 
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    j j1 = this.e;
    if (j1 != null)
      j1.a(paramWebView, paramString, paramBitmap); 
    if (this.g) {
      boolean bool;
      if (Build.VERSION.SDK_INT >= 19) {
        bool = true;
      } else {
        bool = false;
      } 
      a.a(this.c).a(bool).a(paramWebView);
    } 
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    j j1 = this.e;
    if (j1 != null)
      j1.a(paramWebView, paramInt, paramString1, paramString2); 
  }
  
  public void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError) {
    super.onReceivedError(paramWebView, paramWebResourceRequest, paramWebResourceError);
    j j1 = this.e;
    if (j1 != null && paramWebResourceError != null)
      j1.a(paramWebView, paramWebResourceError.getErrorCode(), String.valueOf(paramWebResourceError.getDescription()), null); 
  }
  
  public void onReceivedHttpError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse) {
    super.onReceivedHttpError(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
    j j1 = this.e;
    if (j1 != null && paramWebResourceResponse != null)
      j1.a(paramWebView, paramWebResourceResponse.getStatusCode(), String.valueOf(paramWebResourceResponse.getReasonPhrase()), null); 
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError) {
    super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
    if (this.e != null) {
      int k = 0;
      int i = 0;
      String str2 = "SslError: unknown";
      String str1 = str2;
      if (paramSslError != null) {
        i = k;
        try {
          k = paramSslError.getPrimaryError();
          i = k;
          StringBuilder stringBuilder = new StringBuilder();
          i = k;
          stringBuilder.append("SslError: ");
          i = k;
          stringBuilder.append(String.valueOf(paramSslError));
          i = k;
          String str = stringBuilder.toString();
        } finally {
          str1 = null;
        } 
      } 
      this.e.a(paramWebView, i, str1, null);
    } 
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest) {
    j j1 = this.e;
    if (j1 != null)
      j1.a(paramWebView, paramWebResourceRequest); 
    return super.shouldInterceptRequest(paramWebView, paramWebResourceRequest);
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString) {
    return super.shouldInterceptRequest(paramWebView, paramString);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("shouldOverrideUrlLoading ");
    stringBuilder.append(paramString);
    t.b("WebChromeClient", stringBuilder.toString());
    try {
      Uri uri = Uri.parse(paramString);
      String str = uri.getScheme().toLowerCase();
      if ("bytedance".equals(str)) {
        q.a(uri, this.b);
        return true;
      } 
      if ("market".equals(str) && this.b != null && this.b.a() != null) {
        com.ss.android.downloadad.a.a.c c1 = b.a(this.b.f(), this.b.a(), null).a();
        if (d.d().e().a(this.c, uri, (com.ss.android.a.a.b.c)c1))
          return true; 
      } 
      if (!w.a(paramString)) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.addFlags(268435456);
        b.a(this.c, intent, null);
        return true;
      } 
    } catch (Exception exception) {
      t.b("WebChromeClient", "shouldOverrideUrlLoading", exception);
      x x1 = this.b;
      if (x1 != null && x1.b())
        return true; 
    } 
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\widget\webview\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */