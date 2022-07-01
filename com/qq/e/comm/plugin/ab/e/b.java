package com.qq.e.comm.plugin.ab.e;

import android.webkit.WebView;
import com.qq.e.comm.plugin.ab.f.b;

class b extends b {
  private f a;
  
  public void a(f paramf) {
    this.a = paramf;
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString) {
    super.onReceivedTitle(paramWebView, paramString);
    f f1 = this.a;
    if (f1 != null)
      f1.b(paramString); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */