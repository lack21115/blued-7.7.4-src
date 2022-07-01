package com.qq.e.comm.plugin.ab;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.a.d.a;
import com.qq.e.comm.plugin.ab.a.a;
import com.qq.e.comm.plugin.ab.a.b;
import com.qq.e.comm.plugin.ab.b.a;
import com.qq.e.comm.plugin.ab.b.b;
import com.qq.e.comm.plugin.ab.c.e;
import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.util.aj;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

class l extends WebView {
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
  
  private final String[] m = new String[] { "searchBoxJavaBridge_", "accessibility", "accessibilityTraversal" };
  
  public l(Context paramContext, c paramc) {
    super(paramContext);
    setWillNotDraw(false);
    this.d = paramc;
    setWebViewClient(new m());
    j();
    k();
    l();
    b();
    m();
    n();
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
    IX5WebViewExtension iX5WebViewExtension = getX5WebViewExtension();
    if (iX5WebViewExtension != null)
      iX5WebViewExtension.setScrollBarFadingEnabled(false); 
  }
  
  private void j() {}
  
  private void k() {
    this.g = new a(this) {
        public void a(String param1String, int param1Int1, int param1Int2, long param1Long) {
          HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
          hashMap.put("pkgName", param1String);
          hashMap.put("status", Integer.valueOf(param1Int1));
          hashMap.put("progress", Integer.valueOf(param1Int2));
          hashMap.put("totalSize", Long.valueOf(param1Long));
          this.a.c().a(new b("apkStatusChange", new JSONObject(hashMap)));
        }
      };
  }
  
  private void l() {
    try {
      int i;
      String[] arrayOfString = this.m;
      int j = arrayOfString.length;
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  private void m() {
    getSettings().setJavaScriptEnabled(true);
  }
  
  private void n() {
    if (Build.VERSION.SDK_INT >= 11)
      setLayerType(1, null); 
  }
  
  private void o() {
    if (!this.h) {
      this.h = true;
      com.qq.e.comm.plugin.a.l.a().a(this.g);
    } 
  }
  
  private void p() {
    this.h = false;
    com.qq.e.comm.plugin.a.l.a().b(this.g);
  }
  
  public int a(boolean paramBoolean) {
    l l1 = this;
    while (l1 != null && (paramBoolean || (l1.getParent() != null && l1.getParent() instanceof View))) {
      if (l1.getVisibility() != 0)
        return l1.getVisibility(); 
      if (l1.getParent() == null || !(l1.getParent() instanceof View)) {
        l1 = null;
        continue;
      } 
      View view = (View)l1.getParent();
    } 
    return 0;
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
  
  public a c() {
    return this.b;
  }
  
  public List<b> d() {
    return this.c;
  }
  
  public c e() {
    return this.d;
  }
  
  public void f() {
    if (getParent() != null && getParent() instanceof ViewGroup)
      ((ViewGroup)getParent()).removeView((View)this); 
  }
  
  public void g() {
    if (this.j)
      return; 
    try {
      loadUrl("about:blank");
      f();
      removeAllViews();
      destroy();
      this.j = true;
      return;
    } catch (Exception exception) {
      GDTLogger.w("X5 ExceptionWhileDestroyWebview", exception);
      return;
    } 
  }
  
  public boolean h() {
    return this.j;
  }
  
  protected void onAttachedToWindow() {
    GDTLogger.d("X5 OnWebViewAttachedToWindow");
    super.onAttachedToWindow();
    this.f = true;
    o();
  }
  
  public void onDetachedFromWindow() {
    GDTLogger.d("X5 OnWebViewDetachedFromWindow");
    super.onDetachedFromWindow();
    this.f = false;
    p();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("X5AdWebView onDraw getContentHeight() is ");
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
    stringBuilder.append("X5-InWebView OnLayout Method");
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */