package com.qq.e.comm.plugin.ab.e;

import android.graphics.Bitmap;
import com.qq.e.comm.plugin.ab.f.j;
import com.tencent.smtt.sdk.WebView;

class i extends j {
  private f a;
  
  public void a(f paramf) {
    this.a = paramf;
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
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\e\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */