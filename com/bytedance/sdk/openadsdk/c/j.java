package com.bytedance.sdk.openadsdk.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.core.d.c;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.h.l;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.widget.webview.a.e;
import com.bytedance.sdk.openadsdk.utils.s;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.w;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class j {
  private int a = 1;
  
  private boolean b = false;
  
  private boolean c = false;
  
  private boolean d = false;
  
  private int e = -1;
  
  private String f;
  
  private final Context g;
  
  private final k h;
  
  private String i = "landingpage";
  
  private long j = 0L;
  
  private long k = 0L;
  
  private long l = 0L;
  
  private long m = 0L;
  
  private boolean n = false;
  
  private AtomicInteger o = new AtomicInteger(0);
  
  private WebView p;
  
  private boolean q = false;
  
  private AtomicInteger r = new AtomicInteger(0);
  
  private List<c> s;
  
  private ConcurrentHashMap<String, c> t;
  
  private String u = "";
  
  private JSONObject v;
  
  public j(Context paramContext, k paramk, WebView paramWebView) {
    this.g = paramContext;
    this.h = paramk;
    this.p = paramWebView;
    this.s = new ArrayList<c>();
    this.t = new ConcurrentHashMap<String, c>();
    if (Build.VERSION.SDK_INT >= 19)
      this.p.addJavascriptInterface(new a(), "JS_LANDING_PAGE_LOG_OBJ"); 
  }
  
  private void a(String paramString, JSONObject paramJSONObject) {
    if (!this.q)
      return; 
    if (this.h != null) {
      if (TextUtils.isEmpty(paramString))
        return; 
      JSONObject jSONObject2 = null;
      JSONObject jSONObject1 = jSONObject2;
      if (paramJSONObject != null) {
        try {
          boolean bool1;
          boolean bool = this.h.q();
          boolean bool2 = true;
          if (bool) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          paramJSONObject.put("is_playable", bool1);
          if (com.bytedance.sdk.openadsdk.core.g.a.a().a(this.h)) {
            bool1 = bool2;
          } else {
            bool1 = false;
          } 
          paramJSONObject.put("usecache", bool1);
        } catch (JSONException jSONException) {}
        try {
          jSONObject1 = new JSONObject();
          try {
            jSONObject1.put("ad_extra_data", paramJSONObject.toString());
          } catch (JSONException jSONException) {}
        } catch (JSONException jSONException) {
          jSONObject1 = jSONObject2;
        } 
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("sendEvent: ");
      stringBuilder.append(String.valueOf(this.i));
      stringBuilder.append(", ");
      stringBuilder.append(String.valueOf(paramString));
      stringBuilder.append(", ext=");
      stringBuilder.append(String.valueOf(jSONObject1));
      t.b("LandingPageLog", stringBuilder.toString());
      d.b(this.g, this.h, this.i, paramString, jSONObject1);
    } 
  }
  
  private boolean b(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      k k1 = this.h;
      if (k1 != null) {
        if (k1.m() == 0)
          return false; 
        if (e.a(paramString) != e.a.a)
          return false; 
        l l = o.h();
        return (l == null) ? false : (!(l.o() <= this.r.get()));
      } 
    } 
    return false;
  }
  
  private void d() {
    List<c> list = this.s;
    if (list != null) {
      if (list.size() == 0)
        return; 
      if (o.h().v() && w.c(o.a()) != 4)
        return; 
      com.bytedance.sdk.openadsdk.f.a.a().a(this.s, this.h, this.v);
    } 
  }
  
  public j a(boolean paramBoolean) {
    this.q = paramBoolean;
    return this;
  }
  
  public void a() {
    t.b("LandingPageLog", "onResume");
    this.j = System.currentTimeMillis();
  }
  
  public void a(WebView paramWebView, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onWebProgress: ");
    stringBuilder.append(paramInt);
    t.b("LandingPageLog", stringBuilder.toString());
    if (this.l == 0L && paramInt > 0) {
      this.l = System.currentTimeMillis();
      return;
    } 
    if (this.m == 0L && paramInt == 100)
      this.m = System.currentTimeMillis(); 
  }
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onWebError: ");
    stringBuilder.append(paramInt);
    stringBuilder.append(", ");
    stringBuilder.append(String.valueOf(paramString1));
    stringBuilder.append(", ");
    stringBuilder.append(String.valueOf(paramString2));
    t.b("LandingPageLog", stringBuilder.toString());
    this.a = 3;
    this.e = paramInt;
    this.f = paramString1;
  }
  
  public void a(WebView paramWebView, WebResourceRequest paramWebResourceRequest) {
    if (paramWebResourceRequest != null) {
      c c;
      if (TextUtils.isEmpty(paramWebResourceRequest.getUrl().toString()))
        return; 
      String str = paramWebResourceRequest.getUrl().toString();
      if (!b(str))
        return; 
      if (this.t == null)
        this.t = new ConcurrentHashMap<String, c>(); 
      if (this.t.containsKey(str)) {
        c = this.t.get(str);
      } else {
        c = new c();
        this.t.put(str, c);
        c.a(str);
      } 
      c.a(paramWebResourceRequest.getRequestHeaders());
    } 
  }
  
  public void a(WebView paramWebView, String paramString) {
    boolean bool;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onWebFinished: ");
    stringBuilder.append(String.valueOf(paramString));
    t.b("LandingPageLog", stringBuilder.toString());
    if (paramWebView != null && !this.n) {
      this.n = true;
      s.a(paramWebView, "javascript:\nfunction sendScroll(){\n   var totalH = document.body.scrollHeight || document.documentElement.scrollHeight;\n   var clientH = window.innerHeight || document.documentElement.clientHeight;\n   var scrollH = document.body.scrollTop || document.documentElement.scrollTop;\n   var validH = scrollH + clientH;\n   var result = (validH/totalH*100).toFixed(2);\n   console.log('LandingPageLogscroll status: (' + scrollH + '+' + clientH + ')/' + totalH + '=' + result);\n   window.JS_LANDING_PAGE_LOG_OBJ.readPercent(result);\n}\nsendScroll();\nwindow.addEventListener('scroll', function(e){\n    sendScroll();\n});");
      if (b(paramString)) {
        this.u = paramString;
        s.a(paramWebView, "javascript:var url = window.JS_LANDING_PAGE_LOG_OBJ.getUrl();window.JS_LANDING_PAGE_LOG_OBJ.readHtml(url,document.documentElement.outerHTML);");
        this.r.incrementAndGet();
      } 
    } 
    if (this.a != 3)
      this.a = 2; 
    if (this.a == 2) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      long l1 = this.m;
      long l2 = this.l;
      if (!this.c) {
        this.c = true;
        JSONObject jSONObject = new JSONObject();
        try {
          jSONObject.put("load_duration", l1 - l2);
        } catch (Exception exception) {}
        a("load_finish", jSONObject);
        return;
      } 
    } else if (!this.d) {
      this.d = true;
      JSONObject jSONObject = new JSONObject();
      try {
        jSONObject.put("error_code", this.e);
        jSONObject.put("error_msg", this.f);
      } catch (Exception exception) {}
      a("load_fail", jSONObject);
    } 
  }
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onWebStarted: ");
    stringBuilder.append(String.valueOf(paramString));
    t.b("LandingPageLog", stringBuilder.toString());
    if (!this.b) {
      this.b = true;
      a("load_start", new JSONObject());
    } 
  }
  
  public void a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    this.i = paramString;
  }
  
  public void a(JSONObject paramJSONObject) {
    this.v = paramJSONObject;
  }
  
  public void b() {
    t.b("LandingPageLog", "onStop");
    int i = this.a;
    int m = 0;
    if (i == 2) {
      i = 1;
    } else {
      i = 0;
    } 
    this.k = System.currentTimeMillis();
    long l1 = this.k;
    long l2 = this.j;
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("load_status", this.a);
      jSONObject.put("stay_page_duration", l1 - l2);
      if (i != 0)
        m = this.o.get(); 
      jSONObject.put("max_scroll_percent", m);
    } catch (JSONException jSONException) {}
    a("landing_close", jSONObject);
  }
  
  public void c() {
    t.b("LandingPageLog", "onDestroy");
    d();
    this.p = null;
  }
  
  class a {
    private a(j this$0) {}
    
    @JavascriptInterface
    public String getUrl() {
      return j.c(this.a);
    }
    
    @JavascriptInterface
    public void readHtml(String param1String1, String param1String2) {
      if (!TextUtils.isEmpty(param1String1)) {
        c c;
        if (TextUtils.isEmpty(param1String2))
          return; 
        if (j.d(this.a) == null)
          j.a(this.a, new ConcurrentHashMap<Object, Object>()); 
        if (j.d(this.a).containsKey(param1String1)) {
          c = (c)j.d(this.a).get(param1String1);
        } else {
          c c1 = new c();
          j.d(this.a).put(c, c1);
          c1.a((String)c);
          c = c1;
        } 
        c.b(param1String2);
        if (j.e(this.a) == null)
          j.a(this.a, new ArrayList()); 
        j.e(this.a).add(c);
      } 
    }
    
    @JavascriptInterface
    public void readPercent(String param1String) {
      int i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("measure height: ");
      WebView webView = j.a(this.a);
      boolean bool = false;
      if (webView == null) {
        i = 0;
      } else {
        i = j.a(this.a).getMeasuredHeight();
      } 
      stringBuilder.append(i);
      t.b("LandingPageLog", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append("read percent: ");
      stringBuilder.append(String.valueOf(param1String));
      t.b("LandingPageLog", stringBuilder.toString());
      try {
        i = Float.valueOf(param1String).intValue();
      } finally {
        param1String = null;
      } 
      j.b(this.a).set(i);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\c\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */