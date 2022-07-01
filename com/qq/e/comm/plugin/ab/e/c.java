package com.qq.e.comm.plugin.ab.e;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.webkit.WebViewClient;
import com.qq.e.comm.plugin.ab.f.e;

class c implements a {
  private final d a;
  
  private final b b;
  
  private final com.qq.e.comm.plugin.ab.f.c c;
  
  public c(Context paramContext) {
    com.qq.e.comm.plugin.ab.f.c c1;
    this.a = new d();
    this.b = new b();
    try {
      com.qq.e.comm.plugin.ab.f.c c2 = new com.qq.e.comm.plugin.ab.f.c(paramContext, (WebViewClient)this.a, this.b, null);
      c1 = c2;
    } catch (android.content.res.Resources.NotFoundException notFoundException) {
      if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT < 23) {
        c1 = new com.qq.e.comm.plugin.ab.f.c(c1.createConfigurationContext(new Configuration()), (WebViewClient)this.a, this.b, null);
      } else {
        c1 = new com.qq.e.comm.plugin.ab.f.c(c1.getApplicationContext(), (WebViewClient)this.a, this.b, null);
      } 
    } 
    this.c = c1;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\e\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */