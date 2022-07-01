package com.alipay.sdk.app;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.SystemClock;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alipay.sdk.app.statistic.a;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.util.n;

public class b extends WebViewClient {
  private Activity a;
  
  private boolean b;
  
  private final a c;
  
  public b(Activity paramActivity, a parama) {
    this.a = paramActivity;
    this.c = parama;
  }
  
  public void a() {
    this.a = null;
  }
  
  public boolean b() {
    return this.b;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString) {
    a a1 = this.c;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(SystemClock.elapsedRealtime());
    stringBuilder.append("|");
    stringBuilder.append(n.e(paramString));
    a.b(a1, "biz", "h5ldd", stringBuilder.toString());
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {
    a a1 = this.c;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(SystemClock.elapsedRealtime());
    stringBuilder.append("|");
    stringBuilder.append(n.e(paramString));
    a.b(a1, "biz", "h5ld", stringBuilder.toString());
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
    this.b = true;
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError) {
    Activity activity = this.a;
    if (activity == null)
      return; 
    a a1 = this.c;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("1");
    stringBuilder.append(paramSslError);
    a.a(a1, "net", "SSLError", stringBuilder.toString());
    activity.runOnUiThread(new c(this, activity, paramSslErrorHandler));
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
    return n.a(this.c, paramWebView, paramString, this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\app\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */