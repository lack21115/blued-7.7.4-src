package com.qq.e.comm.plugin.ab.d;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.webkit.WebViewClient;
import com.qq.e.comm.plugin.ab.f.e;
import org.json.JSONObject;

class c implements a {
  private final d a;
  
  private final b b;
  
  private final com.qq.e.comm.plugin.ab.f.c c;
  
  public c(Context paramContext, JSONObject paramJSONObject) {
    com.qq.e.comm.plugin.ab.f.c c1;
    this.a = new d();
    this.b = new b();
    try {
      com.qq.e.comm.plugin.ab.f.c c2 = new com.qq.e.comm.plugin.ab.f.c(paramContext, (WebViewClient)this.a, this.b, paramJSONObject);
      c1 = c2;
    } catch (android.content.res.Resources.NotFoundException notFoundException) {
      if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT < 23) {
        c1 = new com.qq.e.comm.plugin.ab.f.c(c1.createConfigurationContext(new Configuration()), (WebViewClient)this.a, this.b, paramJSONObject);
      } else {
        c1 = new com.qq.e.comm.plugin.ab.f.c(c1.getApplicationContext(), (WebViewClient)this.a, this.b, paramJSONObject);
      } 
    } 
    this.c = c1;
  }
  
  public void a() {
    this.c.destroy();
  }
  
  public void a(f paramf) {
    this.a.a(paramf);
    this.b.a(paramf);
  }
  
  public void a(String paramString) {
    this.c.loadUrl(paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    this.c.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void a(boolean paramBoolean) {
    this.c.setHorizontalScrollBarEnabled(paramBoolean);
    this.c.setVerticalScrollBarEnabled(paramBoolean);
  }
  
  public View b() {
    return (View)this.c;
  }
  
  public e c() {
    return this.c.d();
  }
  
  public boolean d() {
    return this.c.canGoBack();
  }
  
  public void e() {
    this.c.goBack();
  }
  
  public void f() {
    this.a.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */