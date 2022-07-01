package com.qq.e.comm.plugin.ab.e;

import android.content.Context;
import android.view.View;
import com.qq.e.comm.plugin.ab.f.e;
import com.qq.e.comm.plugin.ab.f.i;
import com.tencent.smtt.sdk.WebViewClient;

class h implements a {
  private final i a = new i();
  
  private final g b = new g();
  
  private final i c;
  
  public h(Context paramContext) {
    this.c = new i(paramContext, (WebViewClient)this.a, this.b, null);
  }
  
  public void a() {
    this.c.goBack();
  }
  
  public void a(f paramf) {
    this.a.a(paramf);
    this.b.a(paramf);
  }
  
  public boolean a(int paramInt) {
    return this.c.canGoBackOrForward(paramInt);
  }
  
  public void b() {
    this.c.destroy();
  }
  
  public void b(String paramString) {
    this.c.b(paramString);
  }
  
  public View c() {
    return (View)this.c;
  }
  
  public e d() {
    return this.c.d();
  }
  
  public void loadUrl(String paramString) {
    this.c.loadUrl(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\e\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */