package com.blued.android.framework.web;

import android.text.TextUtils;
import android.webkit.WebView;

public class JSExecutor {
  private WebView a;
  
  private String b;
  
  public void a() {
    this.a = null;
  }
  
  public void a(WebView paramWebView) {
    this.a = paramWebView;
  }
  
  public void a(String paramString) {
    this.b = paramString;
  }
  
  public boolean a(String paramString1, String paramString2) {
    if (this.a != null && !TextUtils.isEmpty(paramString2)) {
      this.a.post(new Runnable(this, paramString2) {
            public void run() {
              if (JSExecutor.a(this.b) != null)
                JSExecutor.a(this.b).loadUrl(this.a); 
            }
          });
      return true;
    } 
    return false;
  }
  
  public String b() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\web\JSExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */