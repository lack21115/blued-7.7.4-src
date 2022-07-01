package com.qq.e.comm.plugin.ab.d;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.qq.e.comm.plugin.ab.b.a;
import com.qq.e.comm.plugin.ab.f.d;
import com.qq.e.comm.plugin.ab.f.e;
import com.qq.e.comm.plugin.util.r;
import com.qq.e.comm.util.GDTLogger;

public class d extends d {
  private f a;
  
  private e b;
  
  public void a(f paramf) {
    this.a = paramf;
  }
  
  public void a(e parame) {
    this.b = parame;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString) {
    super.onPageFinished(paramWebView, paramString);
    f f1 = this.a;
    if (f1 != null)
      f1.a(paramString); 
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    f f1 = this.a;
    if (f1 != null)
      f1.a(paramString, paramBitmap); 
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    f f1 = this.a;
    if (f1 != null)
      f1.a(paramInt, paramString1, paramString2); 
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError) {
    if (paramSslErrorHandler != null)
      paramSslErrorHandler.cancel(); 
    r.a(paramSslError);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("InnerAndroidWebViewClient shouldOverrideUrlLoading, url : ");
    stringBuilder.append(paramString);
    GDTLogger.d(stringBuilder.toString());
    boolean bool = super.shouldOverrideUrlLoading(paramWebView, paramString);
    f f1 = this.a;
    if (f1 != null) {
      if (bool)
        f1.d_(); 
      this.a.b(paramString);
    } 
    if (this.b != null && a.a(Uri.parse(paramString)))
      this.b.a(paramString); 
    return bool;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\d\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */