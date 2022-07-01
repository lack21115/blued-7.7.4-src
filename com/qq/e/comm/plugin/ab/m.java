package com.qq.e.comm.plugin.ab;

import android.graphics.Bitmap;
import com.qq.e.comm.plugin.ab.a.a;
import com.qq.e.comm.plugin.ab.a.c;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

class m extends WebViewClient {
  public void onLoadResource(WebView paramWebView, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("X5 LoadingResource:");
    stringBuilder.append(paramString);
    GDTLogger.d(stringBuilder.toString());
    super.onLoadResource(paramWebView, paramString);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("X5 onPageFinished====>");
    stringBuilder.append(paramString);
    GDTLogger.d(stringBuilder.toString());
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("X5 onPageStarted====>");
    stringBuilder.append(paramString);
    GDTLogger.d(stringBuilder.toString());
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("X5 onReceivedError. errorCode:");
    stringBuilder.append(paramInt);
    stringBuilder.append(".description:");
    stringBuilder.append(paramString1);
    stringBuilder.append("failingUrl:");
    stringBuilder.append(paramString2);
    GDTLogger.d(stringBuilder.toString());
    if (paramWebView instanceof l)
      ((l)paramWebView).a(new a(c.i, null)); 
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("X5 shouldOverrideUrlLoading:");
    stringBuilder.append(paramString);
    GDTLogger.d(stringBuilder.toString());
    try {
    
    } finally {
      paramWebView = null;
    } 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */