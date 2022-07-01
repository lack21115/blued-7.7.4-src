package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.utils.t;
import java.lang.ref.WeakReference;

public class a {
  private WeakReference<Context> a;
  
  private boolean b = true;
  
  private boolean c = true;
  
  private boolean d = true;
  
  private boolean e = true;
  
  private boolean f = true;
  
  private boolean g = true;
  
  private boolean h = true;
  
  private a(Context paramContext) {
    this.a = new WeakReference<Context>(paramContext);
  }
  
  public static a a(Context paramContext) {
    return new a(paramContext);
  }
  
  public static String a(String paramString1, String paramString2) {
    if (TextUtils.isEmpty(paramString1) || TextUtils.isEmpty(paramString2) || "0".equals(paramString2) || !paramString1.contains("{{ad_id}}"))
      return null; 
    paramString1 = paramString1.replace("{{ad_id}}", paramString2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("javascript:(function () {    var JS_ACTLOG_URL = '");
    stringBuilder.append(paramString1);
    stringBuilder.append("';    var head = document.getElementsByTagName('head')[0];    var script = document.createElement('script');    script.type = 'text/javascript';    script.src = JS_ACTLOG_URL;    head.appendChild(script);})();");
    return stringBuilder.toString();
  }
  
  private void a(WebSettings paramWebSettings) {
    try {
      if (Build.VERSION.SDK_INT >= 17)
        return; 
    } finally {
      paramWebSettings = null;
    } 
  }
  
  private void b(WebView paramWebView) {
    try {
      paramWebView.removeJavascriptInterface("searchBoxJavaBridge_");
      return;
    } finally {
      paramWebView = null;
      t.b(paramWebView.toString());
    } 
  }
  
  public a a(boolean paramBoolean) {
    this.h = paramBoolean;
    return this;
  }
  
  public void a(WebView paramWebView) {
    if (paramWebView != null) {
      if (this.a.get() == null)
        return; 
      b(paramWebView);
      WebSettings webSettings = paramWebView.getSettings();
      a(webSettings);
      if (webSettings == null)
        return; 
      try {
        webSettings.setJavaScriptEnabled(true);
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
      try {
      
      } finally {
        Exception exception = null;
      } 
      webSettings.setLoadWithOverviewMode(true);
      webSettings.setUseWideViewPort(this.d);
      webSettings.setDomStorageEnabled(this.e);
      webSettings.setAllowFileAccess(this.f);
      webSettings.setBlockNetworkImage(true ^ this.g);
      try {
        if (Build.VERSION.SDK_INT >= 11 && !this.h)
          return; 
      } finally {
        paramWebView = null;
      } 
    } 
  }
  
  public a b(boolean paramBoolean) {
    this.c = paramBoolean;
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\widget\webview\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */