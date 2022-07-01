package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.widget.webview.a.a;
import com.bytedance.sdk.openadsdk.core.widget.webview.a.e;
import com.bytedance.sdk.openadsdk.core.widget.webview.c;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.g.a.a;
import com.bytedance.sdk.openadsdk.utils.t;
import java.io.File;
import java.util.Iterator;

public class f extends c {
  private k a;
  
  public f(Context paramContext, x paramx, k paramk) {
    super(paramContext, paramx, paramk.M(), null);
    this.a = paramk;
  }
  
  private WebResourceResponse a(WebView paramWebView, String paramString) {
    j j;
    boolean bool = TextUtils.isEmpty(paramString);
    WebView webView = null;
    if (bool)
      return null; 
    e.a a = e.a(paramString);
    paramWebView = webView;
    if (a != e.a.d) {
      Iterator<j> iterator = this.a.F().iterator();
      while (true) {
        paramWebView = webView;
        if (iterator.hasNext()) {
          j j1 = iterator.next();
          if (!TextUtils.isEmpty(j1.a()) && !TextUtils.isEmpty(paramString)) {
            String str2 = j1.a();
            String str1 = str2;
            if (str2.startsWith("https"))
              str1 = str2.replaceFirst("https", "http"); 
            if (paramString.startsWith("https")) {
              str2 = paramString.replaceFirst("https", "http");
            } else {
              str2 = paramString;
            } 
            if (str2.equals(str1)) {
              j = j1;
              break;
            } 
          } 
          continue;
        } 
        break;
      } 
    } 
    return (a == e.a.d || j != null) ? a(paramString) : a.a(paramString, a);
  }
  
  private WebResourceResponse a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    try {
      paramString = a.a().a(paramString, 0, 0, null);
      File file = a.a().a(paramString);
    } finally {
      paramString = null;
    } 
    return null;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString) {
    this.f = false;
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {
    this.g = false;
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest) {
    try {
      return shouldInterceptRequest(paramWebView, paramWebResourceRequest.getUrl().toString());
    } finally {
      Exception exception = null;
      t.c("ExpressClient", "shouldInterceptRequest error1", exception);
    } 
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString) {
    try {
      WebResourceResponse webResourceResponse = a(paramWebView, paramString);
    } finally {
      Exception exception = null;
    } 
    return super.shouldInterceptRequest(paramWebView, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\nativeexpress\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */