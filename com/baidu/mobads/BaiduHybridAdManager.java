package com.baidu.mobads;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.production.d.a;

public class BaiduHybridAdManager {
  IOAdEventListener a = new e(this);
  
  private BaiduHybridAdViewListener b = new d(this);
  
  private a c;
  
  private WebView d;
  
  private boolean e = false;
  
  public void injectJavaScriptBridge(WebView paramWebView) {
    if (!this.e) {
      this.d = paramWebView;
      this.c = new a(this.d);
      this.c.addEventListener("AdLoaded", this.a);
      this.c.addEventListener("AdError", this.a);
      this.c.addEventListener("AdStarted", this.a);
      this.c.addEventListener("AdUserClick", this.a);
      this.c.addEventListener("AdUserClose", this.a);
      this.c.request();
    } 
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {
    this.e = false;
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
    this.e = true;
  }
  
  public void setBaiduHybridAdViewListener(BaiduHybridAdViewListener paramBaiduHybridAdViewListener) {
    this.b = paramBaiduHybridAdViewListener;
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
    if (!this.e) {
      a a1 = this.c;
      if (a1 != null)
        a1.a(paramWebView, paramString); 
    } 
    try {
      Uri uri = Uri.parse(paramString);
      if (!"mobadssdk".equals(uri.getScheme())) {
        boolean bool = "mobads".equals(uri.getScheme());
        if (bool)
          return true; 
      } else {
        return true;
      } 
    } catch (Exception exception) {
      System.err.println(exception);
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\BaiduHybridAdManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */