package com.qq.e.comm.plugin.ab.d;

import android.content.Context;
import android.view.View;
import com.qq.e.comm.plugin.ab.f.e;
import com.qq.e.comm.plugin.ab.f.i;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.WebViewClient;
import org.json.JSONObject;

class h implements a {
  private final i a = new i();
  
  private final g b = new g();
  
  private final i c;
  
  public h(Context paramContext, JSONObject paramJSONObject) {
    this.c = new i(paramContext, (WebViewClient)this.a, this.b, paramJSONObject);
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
    View view = this.c.getView();
    if (view != null) {
      view.setHorizontalScrollBarEnabled(paramBoolean);
      view.setVerticalScrollBarEnabled(paramBoolean);
    } 
    IX5WebViewExtension iX5WebViewExtension = this.c.getX5WebViewExtension();
    if (iX5WebViewExtension != null) {
      iX5WebViewExtension.setHorizontalScrollBarEnabled(paramBoolean);
      iX5WebViewExtension.setVerticalScrollBarEnabled(paramBoolean);
    } 
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\d\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */