package com.huawei.secure.android.common.webview;

import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class SafeWebSettings {
  public static void a(WebSettings paramWebSettings) {
    paramWebSettings.setAllowFileAccess(false);
    if (Build.VERSION.SDK_INT >= 16) {
      paramWebSettings.setAllowFileAccessFromFileURLs(false);
      paramWebSettings.setAllowUniversalAccessFromFileURLs(false);
    } 
  }
  
  public static void a(WebView paramWebView) {
    WebSettings webSettings = paramWebView.getSettings();
    a(webSettings);
    b(paramWebView);
    b(webSettings);
    c(webSettings);
    d(webSettings);
    e(webSettings);
  }
  
  public static void b(WebSettings paramWebSettings) {
    if (Build.VERSION.SDK_INT <= 18)
      paramWebSettings.setSavePassword(false); 
  }
  
  public static void b(WebView paramWebView) {
    if (Build.VERSION.SDK_INT >= 11) {
      paramWebView.removeJavascriptInterface("searchBoxJavaBridge_");
      paramWebView.removeJavascriptInterface("accessibility");
      paramWebView.removeJavascriptInterface("accessibilityTraversal");
    } 
  }
  
  public static void c(WebSettings paramWebSettings) {
    paramWebSettings.setGeolocationEnabled(false);
  }
  
  public static void d(WebSettings paramWebSettings) {
    if (Build.VERSION.SDK_INT >= 21)
      paramWebSettings.setMixedContentMode(1); 
  }
  
  public static void e(WebSettings paramWebSettings) {
    if (Build.VERSION.SDK_INT >= 11)
      paramWebSettings.setAllowContentAccess(false); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\common\webview\SafeWebSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */