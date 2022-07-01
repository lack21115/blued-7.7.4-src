package com.qq.e.comm.plugin.ab.f;

import android.util.Pair;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.qq.e.comm.plugin.util.bb;
import java.io.InputStream;

public class d extends WebViewClient {
  private boolean a;
  
  private g b = new g();
  
  public void a() {
    this.a = true;
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest) {
    Pair<? extends InputStream, bb.a> pair = this.b.a(this.a, paramWebResourceRequest.getUrl());
    if (pair != null) {
      InputStream inputStream = (InputStream)pair.first;
      bb.a a = (bb.a)pair.second;
      if (inputStream != null)
        return new WebResourceResponse(a.a(), "UTF-8", inputStream); 
    } 
    return super.shouldInterceptRequest(paramWebView, paramWebResourceRequest);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
    return this.b.a(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\f\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */