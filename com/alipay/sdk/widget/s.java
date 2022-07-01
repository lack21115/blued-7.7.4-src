package com.alipay.sdk.widget;

import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

class s extends WebChromeClient {
  s(p paramp) {}
  
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult) {
    return p.e(this.a).a(this.a, paramString1, paramString2, paramString3, paramJsPromptResult);
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt) {
    if (paramInt == 100) {
      p.d(this.a).setVisibility(4);
      return;
    } 
    if (4 == p.d(this.a).getVisibility())
      p.d(this.a).setVisibility(0); 
    p.d(this.a).setProgress(paramInt);
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString) {
    p.e(this.a).a(this.a, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\widget\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */