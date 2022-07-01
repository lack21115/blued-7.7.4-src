package com.alipay.sdk.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alipay.sdk.app.b;
import com.alipay.sdk.app.j;
import com.alipay.sdk.app.k;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.util.n;

public class h extends g {
  private b b;
  
  private WebView c;
  
  public h(Activity paramActivity, a parama) {
    super(paramActivity);
    this.c = new WebView((Context)paramActivity);
    a((Context)paramActivity);
    addView((View)this.c);
    this.b = new b(paramActivity, parama);
    this.c.setWebViewClient((WebViewClient)this.b);
  }
  
  private void a(Context paramContext) {
    WebSettings webSettings = this.c.getSettings();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(webSettings.getUserAgentString());
    stringBuilder.append(n.c(paramContext));
    webSettings.setUserAgentString(stringBuilder.toString());
    webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
    webSettings.setSupportMultipleWindows(true);
    webSettings.setJavaScriptEnabled(true);
    webSettings.setSavePassword(false);
    webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    webSettings.setMinimumFontSize(webSettings.getMinimumFontSize() + 8);
    webSettings.setAllowFileAccess(false);
    webSettings.setTextSize(WebSettings.TextSize.NORMAL);
    webSettings.setDomStorageEnabled(true);
    webSettings.setCacheMode(1);
    this.c.resumeTimers();
    this.c.setVerticalScrollbarOverlay(true);
    this.c.setDownloadListener(new i(this));
    try {
      this.c.removeJavascriptInterface("searchBoxJavaBridge_");
      this.c.removeJavascriptInterface("accessibility");
      return;
    } finally {
      paramContext = null;
    } 
  }
  
  public void a() {
    this.b.a();
    removeAllViews();
  }
  
  public void a(String paramString) {
    this.c.loadUrl(paramString);
  }
  
  public boolean b() {
    if (this.c.canGoBack()) {
      if (this.b.b()) {
        k k = k.b(k.d.a());
        j.a(j.a(k.a(), k.b(), ""));
        this.a.finish();
      } 
    } else {
      j.a(j.c());
      this.a.finish();
    } 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\widget\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */