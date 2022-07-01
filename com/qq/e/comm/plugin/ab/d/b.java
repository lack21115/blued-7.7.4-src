package com.qq.e.comm.plugin.ab.d;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.qq.e.comm.plugin.ab.f.b;
import com.qq.e.comm.plugin.util.ak;

class b extends b {
  private f a;
  
  public void a(f paramf) {
    this.a = paramf;
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt) {
    super.onProgressChanged(paramWebView, paramInt);
    f f1 = this.a;
    if (f1 != null)
      f1.a(paramInt); 
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString) {
    super.onReceivedTitle(paramWebView, paramString);
    f f1 = this.a;
    if (f1 != null)
      f1.c(paramString); 
  }
  
  public boolean onShowFileChooser(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams) {
    boolean bool2 = false;
    ak.b("gdt_tag_inner_webview", "onShowFileChooser(%s,%s)", new Object[] { paramValueCallback, paramFileChooserParams });
    boolean bool1 = bool2;
    if (this.a != null) {
      bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 21) {
        bool1 = bool2;
        if (paramFileChooserParams != null)
          bool1 = this.a.b(paramValueCallback, paramFileChooserParams.createIntent()); 
      } 
    } 
    return bool1;
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString) {
    ak.b("gdt_tag_inner_webview", "openFileChooser(%s,%s)", new Object[] { paramValueCallback, paramString });
    openFileChooser(paramValueCallback, paramString, null);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2) {
    ak.b("gdt_tag_inner_webview", "openFileChooser(%s,%s,%s)", new Object[] { paramValueCallback, paramString1, paramString2 });
    if (this.a != null) {
      Intent intent = new Intent("android.intent.action.GET_CONTENT");
      intent.addCategory("android.intent.category.OPENABLE");
      paramString2 = paramString1;
      if (TextUtils.isEmpty(paramString1))
        paramString2 = "*/*"; 
      intent.setType(paramString2);
      this.a.a(paramValueCallback, intent);
      return;
    } 
    if (paramValueCallback != null)
      paramValueCallback.onReceiveValue(null); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */