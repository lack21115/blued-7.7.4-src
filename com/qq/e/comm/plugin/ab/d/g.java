package com.qq.e.comm.plugin.ab.d;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.qq.e.comm.plugin.ab.f.h;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.y.u;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

class g extends h {
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
    ak.b("gdt_tag_inner_webview", "X5onShowFileChooser(%s,%s)", new Object[] { paramValueCallback, paramFileChooserParams });
    f f1 = this.a;
    if (f1 != null && paramFileChooserParams != null)
      try {
        return f1.b((ValueCallback<Uri[]>)paramValueCallback, paramFileChooserParams.createIntent());
      } finally {
        f1 = null;
      }  
    return false;
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2) {
    try {
      ak.b("gdt_tag_inner_webview", "X5openFileChooser(%s,%s,%s)", new Object[] { paramValueCallback, paramString1, paramString2 });
      if (this.a != null) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        boolean bool = TextUtils.isEmpty(paramString1);
        if (bool)
          paramString1 = "*/*"; 
        intent.setType(paramString1);
        this.a.a((ValueCallback<Uri>)paramValueCallback, intent);
        return;
      } 
      if (paramValueCallback != null) {
        paramValueCallback.onReceiveValue(null);
        return;
      } 
    } catch (NullPointerException nullPointerException) {
      u.a(1130002, null);
      nullPointerException.printStackTrace();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\d\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */