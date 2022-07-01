package com.qq.e.comm.plugin.ab;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.qq.e.comm.plugin.ab.a.a;
import com.qq.e.comm.plugin.ab.a.c;
import com.qq.e.comm.plugin.util.ak;

class f extends WebViewClient {
  private static final String a = f.class.getSimpleName();
  
  public void onLoadResource(WebView paramWebView, String paramString) {
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("LoadingResource:");
    stringBuilder.append(paramString);
    ak.a(str, stringBuilder.toString());
    super.onLoadResource(paramWebView, paramString);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString) {
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onPageFinished====>");
    stringBuilder.append(paramString);
    ak.a(str, stringBuilder.toString());
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onPageStarted====>");
    stringBuilder.append(paramString);
    ak.a(str, stringBuilder.toString());
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onReceivedError. errorCode:");
    stringBuilder.append(paramInt);
    stringBuilder.append(".description:");
    stringBuilder.append(paramString1);
    stringBuilder.append("failingUrl:");
    stringBuilder.append(paramString2);
    ak.a(str, stringBuilder.toString());
    if (paramWebView instanceof d)
      ((d)paramWebView).a(new a(c.i, null)); 
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
    try {
    
    } finally {
      paramWebView = null;
    } 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */