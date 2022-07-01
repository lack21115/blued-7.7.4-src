package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityManager;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Map;

public class SSWebView extends WebView {
  public SSWebView(Context paramContext) {
    super(paramContext);
    a(paramContext);
  }
  
  public SSWebView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public SSWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a() {
    try {
      removeJavascriptInterface("searchBoxJavaBridge_");
      removeJavascriptInterface("accessibility");
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  private void a(Context paramContext) {
    b(paramContext);
    b();
    a();
  }
  
  private void b() {
    WebSettings webSettings = getSettings();
    if (webSettings != null)
      webSettings.setSavePassword(false); 
  }
  
  private static void b(Context paramContext) {
    if (Build.VERSION.SDK_INT == 17 && paramContext != null)
      try {
        AccessibilityManager accessibilityManager = (AccessibilityManager)paramContext.getSystemService("accessibility");
        return;
      } finally {
        paramContext = null;
      }  
  }
  
  private void setJavaScriptEnabled(String paramString) {
    try {
      if (TextUtils.isEmpty(paramString))
        return; 
      WebSettings webSettings = getSettings();
      if (webSettings == null)
        return; 
      if (paramString.startsWith("file://"))
        return; 
      return;
    } finally {
      paramString = null;
    } 
  }
  
  public boolean canGoBack() {
    try {
      return super.canGoBack();
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public boolean canGoBackOrForward(int paramInt) {
    try {
      return super.canGoBackOrForward(paramInt);
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public boolean canGoForward() {
    try {
      return super.canGoForward();
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public void clearCache(boolean paramBoolean) {
    try {
      super.clearCache(paramBoolean);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void clearFormData() {
    try {
      super.clearFormData();
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void clearHistory() {
    try {
      super.clearHistory();
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void computeScroll() {
    try {
      super.computeScroll();
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public int getContentHeight() {
    try {
      return super.getContentHeight();
    } catch (Exception exception) {
      return 1;
    } 
  }
  
  public String getOriginalUrl() {
    try {
      String str2 = super.getOriginalUrl();
      String str1 = str2;
      if (str2 != null) {
        str1 = str2;
        if (str2.startsWith("data:text/html")) {
          String str = super.getUrl();
          str1 = str2;
          if (str != null) {
            boolean bool = str.startsWith("file://");
            str1 = str2;
            if (bool)
              str1 = str; 
          } 
        } 
      } 
      return str1;
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public int getProgress() {
    try {
      return super.getProgress();
    } catch (Exception exception) {
      return 100;
    } 
  }
  
  public String getUrl() {
    try {
      return super.getUrl();
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public void goBack() {
    try {
      super.goBack();
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void goBackOrForward(int paramInt) {
    try {
      super.goBackOrForward(paramInt);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void goForward() {
    try {
      super.goForward();
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3) {
    try {
      super.loadData(paramString1, paramString2, paramString3);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    try {
      setJavaScriptEnabled(paramString1);
      super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void loadUrl(String paramString) {
    try {
      setJavaScriptEnabled(paramString);
      super.loadUrl(paramString);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void loadUrl(String paramString, Map<String, String> paramMap) {
    try {
      setJavaScriptEnabled(paramString);
      super.loadUrl(paramString, paramMap);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    try {
      return super.onTouchEvent(paramMotionEvent);
    } finally {
      paramMotionEvent = null;
    } 
  }
  
  public void postUrl(String paramString, byte[] paramArrayOfbyte) {
    try {
      setJavaScriptEnabled(paramString);
      super.postUrl(paramString, paramArrayOfbyte);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void reload() {
    try {
      super.reload();
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void setBackgroundColor(int paramInt) {
    try {
      super.setBackgroundColor(paramInt);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void setDownloadListener(DownloadListener paramDownloadListener) {
    try {
      super.setDownloadListener(paramDownloadListener);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void setLayerType(int paramInt, Paint paramPaint) {
    try {
      return;
    } finally {
      paramPaint = null;
    } 
  }
  
  public void setNetworkAvailable(boolean paramBoolean) {
    try {
      super.setNetworkAvailable(paramBoolean);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void setOverScrollMode(int paramInt) {
    try {
      super.setOverScrollMode(paramInt);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void setWebChromeClient(WebChromeClient paramWebChromeClient) {
    try {
      super.setWebChromeClient(paramWebChromeClient);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void setWebViewClient(WebViewClient paramWebViewClient) {
    try {
      super.setWebViewClient(paramWebViewClient);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void stopLoading() {
    try {
      super.stopLoading();
      return;
    } catch (Exception exception) {
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\widget\webview\SSWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */