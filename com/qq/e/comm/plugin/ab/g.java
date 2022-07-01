package com.qq.e.comm.plugin.ab;

import android.content.Context;
import android.os.Build;
import android.view.View;
import com.qq.e.comm.plugin.ab.a.a;
import com.qq.e.comm.plugin.ab.a.b;
import com.qq.e.comm.plugin.ab.b.a;
import com.qq.e.comm.plugin.ab.c.e;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

class g implements h {
  private d a;
  
  private a b;
  
  private a c;
  
  public g(Context paramContext, c paramc) {
    this.a = new d(paramContext, paramc);
    this.b = new a(this);
    this.a.a(this.b);
    this.c = new a();
  }
  
  private boolean d(String paramString) {
    if (Build.VERSION.SDK_INT >= 19) {
      this.a.evaluateJavascript(paramString, null);
      return true;
    } 
    return false;
  }
  
  public View a() {
    return (View)this.a;
  }
  
  public void a(int paramInt) {
    this.a.setVisibility(paramInt);
  }
  
  public void a(a parama) {
    this.a.a(parama);
  }
  
  public void a(b paramb) {
    this.a.a(paramb);
  }
  
  public void a(h.a parama) {
    this.a.a(parama);
  }
  
  public void a(String paramString) {
    this.a.loadUrl(paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    this.a.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void a(Collection<e> paramCollection) {
    this.a.a(paramCollection);
  }
  
  public void a(Set<String> paramSet) {
    this.c.a(paramSet);
  }
  
  public void a(JSONObject paramJSONObject) {
    this.c.a(paramJSONObject);
  }
  
  public void a(boolean paramBoolean) {
    this.a.setVerticalScrollBarEnabled(paramBoolean);
  }
  
  public a b() {
    return this.a.a();
  }
  
  public void b(String paramString) {
    if (this.a.g())
      return; 
    try {
      if (!d(paramString)) {
        d d1 = this.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javascript:");
        stringBuilder.append(paramString);
        d1.loadUrl(stringBuilder.toString());
      } 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void b(boolean paramBoolean) {
    this.a.setHorizontalScrollBarEnabled(paramBoolean);
  }
  
  public void c() {
    this.a.f();
  }
  
  public void c(boolean paramBoolean) {
    this.a.setClickable(paramBoolean);
  }
  
  public boolean c(String paramString) {
    return this.c.a(paramString);
  }
  
  public List<b> d() {
    return this.a.c();
  }
  
  public void d(boolean paramBoolean) {
    this.a.setFocusable(paramBoolean);
  }
  
  public c e() {
    return this.a.d();
  }
  
  public void e(boolean paramBoolean) {
    this.a.setFocusableInTouchMode(paramBoolean);
  }
  
  public int f() {
    return this.a.getWidth();
  }
  
  public int f(boolean paramBoolean) {
    return this.a.a(paramBoolean);
  }
  
  public int g() {
    return this.a.getHeight();
  }
  
  public JSONObject h() {
    return this.c.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */