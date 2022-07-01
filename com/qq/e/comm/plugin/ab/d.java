package com.qq.e.comm.plugin.ab;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.a.d.a;
import com.qq.e.comm.plugin.a.l;
import com.qq.e.comm.plugin.ab.a.a;
import com.qq.e.comm.plugin.ab.a.b;
import com.qq.e.comm.plugin.ab.b.a;
import com.qq.e.comm.plugin.ab.b.b;
import com.qq.e.comm.plugin.ab.c.e;
import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.util.aj;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

class d extends WebView {
  private static final b a = new b("webviewLayout", null);
  
  private a b;
  
  private List<b> c = new ArrayList<b>();
  
  private final c d;
  
  private Map<String, Object> e = new HashMap<String, Object>();
  
  private boolean f;
  
  private a g;
  
  private boolean h = false;
  
  private boolean i = false;
  
  private boolean j = false;
  
  private h.a k;
  
  private int l = -1;
  
  public d(Context paramContext, c paramc) {
    super(paramContext);
    setWebViewClient(new f());
    k();
    this.d = paramc;
    j();
    h();
    b();
    l();
    m();
    if (paramc != null && paramc.c() == e.i)
      i(); 
    WebSettings webSettings = getSettings();
    StringBuilder stringBuilder = new StringBuilder(webSettings.getUserAgentString());
    stringBuilder.append(" GDTMobSDK/");
    stringBuilder.append(SDKStatus.getSDKVersion());
    stringBuilder.append(".");
    stringBuilder.append(GDTADManager.getInstance().getPM().getPluginVersion());
    webSettings.setUserAgentString(stringBuilder.toString());
    resumeTimers();
  }
  
  private void h() {
    removeJavascriptInterface("searchBoxJavaBridge_");
    removeJavascriptInterface("accessibility");
    removeJavascriptInterface("accessibilityTraversal");
    getSettings().setSavePassword(false);
  }
  
  private void i() {
    setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            return (param1MotionEvent.getAction() == 2);
          }
        });
    setVerticalScrollBarEnabled(false);
    setHorizontalScrollBarEnabled(false);
    setOnLongClickListener(new View.OnLongClickListener(this) {
          public boolean onLongClick(View param1View) {
            return true;
          }
        });
  }
  
  private void j() {
    this.g = new a(this) {
        public void a(String param1String, int param1Int1, int param1Int2, long param1Long) {
          HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
          hashMap.put("pkgName", param1String);
          hashMap.put("status", Integer.valueOf(param1Int1));
          hashMap.put("progress", Integer.valueOf(param1Int2));
          hashMap.put("totalSize", Long.valueOf(param1Long));
          this.a.a().a(new b("apkStatusChange", new JSONObject(hashMap)));
        }
      };
  }
  
  private void k() {}
  
  private void l() {
    getSettings().setJavaScriptEnabled(true);
  }
  
  private void m() {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 19) {
      bool = true;
    } else {
      bool = true;
    } 
    setLayerType(bool, null);
  }
  
  private void n() {
    if (!this.h) {
      this.h = true;
      l.a().a(this.g);
    } 
  }
  
  private void o() {
    this.h = false;
    l.a().b(this.g);
  }
  
  public int a(boolean paramBoolean) {
    d d1 = this;
    while (d1 != null && (paramBoolean || (d1.getParent() != null && d1.getParent() instanceof View))) {
      if (d1.getVisibility() != 0)
        return d1.getVisibility(); 
      if (d1.getParent() == null || !(d1.getParent() instanceof View)) {
        d1 = null;
        continue;
      } 
      View view = (View)d1.getParent();
    } 
    return 0;
  }
  
  public a a() {
    return this.b;
  }
  
  public void a(a parama) {
    List<b> list = this.c;
    if (list != null) {
      Iterator<b> iterator = list.iterator();
      while (iterator.hasNext())
        ((b)iterator.next()).a(parama); 
    } 
  }
  
  public void a(b paramb) {
    this.c.add(paramb);
  }
  
  public void a(a parama) {
    this.b = parama;
  }
  
  public void a(h.a parama) {
    this.k = parama;
  }
  
  public void a(Collection<e> paramCollection) {
    if (paramCollection != null)
      for (e e : paramCollection)
        this.b.a(e.b(), e);  
  }
  
  public void b() {
    WebSettings webSettings = getSettings();
    String str = aj.a(getContext()).getAbsolutePath();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("AppCache Path=");
    stringBuilder.append(str);
    GDTLogger.d(stringBuilder.toString());
    webSettings.setAllowFileAccess(true);
    webSettings.setAppCachePath(str);
    webSettings.setAppCacheMaxSize(8388608L);
    webSettings.setAppCacheEnabled(true);
    webSettings.setLoadsImagesAutomatically(true);
    webSettings.setCacheMode(-1);
    webSettings.setDomStorageEnabled(true);
  }
  
  public List<b> c() {
    return this.c;
  }
  
  public c d() {
    return this.d;
  }
  
  public void e() {
    if (getParent() != null && getParent() instanceof ViewGroup)
      ((ViewGroup)getParent()).removeView((View)this); 
  }
  
  public void f() {
    if (this.j)
      return; 
    try {
      loadUrl("about:blank");
      e();
      removeAllViews();
      destroy();
      this.j = true;
      return;
    } catch (Exception exception) {
      GDTLogger.w("ExceptionWhileDestroyWebview", exception);
      return;
    } 
  }
  
  public boolean g() {
    return this.j;
  }
  
  protected void onAttachedToWindow() {
    GDTLogger.d("OnWebViewAttachedToWindow");
    super.onAttachedToWindow();
    this.f = true;
    n();
  }
  
  protected void onDetachedFromWindow() {
    GDTLogger.d("OnWebViewDetachedFromWindow");
    super.onDetachedFromWindow();
    this.f = false;
    o();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("GDTAdWebView getContentHeight() is ");
    stringBuilder.append(getContentHeight());
    stringBuilder.append(", lastHeight is ");
    stringBuilder.append(this.l);
    stringBuilder.append(", view is ");
    stringBuilder.append(hashCode());
    GDTLogger.d(stringBuilder.toString());
    if (getContentHeight() != this.l)
      this.l = getContentHeight(); 
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("InWebView OnLayout Method");
    stringBuilder.append(getVisibility());
    stringBuilder.append(":");
    stringBuilder.append(getWindowVisibility());
    stringBuilder.append(":");
    stringBuilder.append(getWidth());
    stringBuilder.append("/");
    stringBuilder.append(getHeight());
    GDTLogger.d(stringBuilder.toString());
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.i) {
      this.i = true;
      this.b.a(a);
    } 
    h.a a1 = this.k;
    if (a1 != null)
      a1.j(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */