package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.c.j;
import com.bytedance.sdk.openadsdk.core.a.a;
import com.bytedance.sdk.openadsdk.core.aa;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.d.a;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.u;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.widget.webview.a;
import com.bytedance.sdk.openadsdk.core.widget.webview.b;
import com.bytedance.sdk.openadsdk.core.widget.webview.c;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.d.d;
import com.bytedance.sdk.openadsdk.downloadnew.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.ai;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TTLandingPageActivity extends Activity implements d {
  private static final String b = TTLandingPageActivity.class.getSimpleName();
  
  j a;
  
  private SSWebView c;
  
  private ImageView d;
  
  private ImageView e;
  
  private TextView f;
  
  private Context g;
  
  private int h;
  
  private ViewStub i;
  
  private ViewStub j;
  
  private ViewStub k;
  
  private Button l;
  
  private ProgressBar m;
  
  private String n;
  
  private String o;
  
  private x p;
  
  private int q;
  
  private String r;
  
  private k s;
  
  private String t;
  
  private AtomicBoolean u = new AtomicBoolean(true);
  
  private JSONArray v = null;
  
  private a w;
  
  private final Map<String, a> x = Collections.synchronizedMap(new HashMap<String, a>());
  
  private String y = "立即下载";
  
  private TTAppDownloadListener z = new TTAppDownloadListener(this) {
      public void onDownloadActive(long param1Long1, long param1Long2, String param1String1, String param1String2) {
        TTLandingPageActivity.a(this.a, "下载中...");
      }
      
      public void onDownloadFailed(long param1Long1, long param1Long2, String param1String1, String param1String2) {
        TTLandingPageActivity.a(this.a, "下载失败");
      }
      
      public void onDownloadFinished(long param1Long, String param1String1, String param1String2) {
        TTLandingPageActivity.a(this.a, "点击安装");
      }
      
      public void onDownloadPaused(long param1Long1, long param1Long2, String param1String1, String param1String2) {
        TTLandingPageActivity.a(this.a, "暂停");
      }
      
      public void onIdle() {
        TTLandingPageActivity tTLandingPageActivity = this.a;
        TTLandingPageActivity.a(tTLandingPageActivity, TTLandingPageActivity.d(tTLandingPageActivity));
      }
      
      public void onInstalled(String param1String1, String param1String2) {
        TTLandingPageActivity.a(this.a, "点击打开");
      }
    };
  
  private void a() {
    k k1 = this.s;
    if (k1 != null && k1.B() == 4) {
      this.k.setVisibility(0);
      this.l = (Button)findViewById(ab.e((Context)this, "tt_browser_download_btn"));
      if (this.l != null) {
        a(b());
        if (this.w == null) {
          String str;
          if (TextUtils.isEmpty(this.r)) {
            str = ah.a(this.q);
          } else {
            str = this.r;
          } 
          this.w = a.a((Context)this, this.s, str);
          this.w.a(this.z, false);
        } 
        this.w.a(this);
        a a1 = new a((Context)this, this.s, this.r, this.q);
        a1.a(false);
        this.l.setOnClickListener((View.OnClickListener)a1);
        this.l.setOnTouchListener((View.OnTouchListener)a1);
        a1.a(this.w);
      } 
    } 
  }
  
  private void a(int paramInt) {
    if (this.e != null) {
      if (!e())
        return; 
      ai.a((View)this.e, paramInt);
    } 
  }
  
  private void a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    Button button = this.l;
    if (button != null)
      button.post(new Runnable(this, paramString) {
            public void run() {
              if (TTLandingPageActivity.e(this.b) != null && !this.b.isFinishing())
                TTLandingPageActivity.e(this.b).setText(this.a); 
            }
          }); 
  }
  
  private void a(boolean paramBoolean) {
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("isBackIntercept", paramBoolean);
      this.p.a("temai_back_event", jSONObject);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private String b() {
    k k1 = this.s;
    if (k1 != null && !TextUtils.isEmpty(k1.L()))
      this.y = this.s.L(); 
    return this.y;
  }
  
  private JSONArray b(String paramString) {
    JSONArray jSONArray = this.v;
    if (jSONArray != null && jSONArray.length() > 0)
      return this.v; 
    if (TextUtils.isEmpty(paramString))
      return null; 
    int m = paramString.indexOf("?id=");
    int i = paramString.indexOf("&");
    if (m != -1 && i != -1) {
      m += 4;
      if (m >= i)
        return null; 
      paramString = paramString.substring(m, i);
      if (TextUtils.isEmpty(paramString))
        return null; 
      jSONArray = new JSONArray();
      jSONArray.put(paramString);
      return jSONArray;
    } 
    return null;
  }
  
  private void c() {
    this.c = (SSWebView)findViewById(ab.e((Context)this, "tt_browser_webview"));
    this.k = (ViewStub)findViewById(ab.e((Context)this, "tt_browser_download_btn_stub"));
    this.i = (ViewStub)findViewById(ab.e((Context)this, "tt_browser_titlebar_view_stub"));
    this.j = (ViewStub)findViewById(ab.e((Context)this, "tt_browser_titlebar_dark_view_stub"));
    int i = h.c().j();
    if (i != 0) {
      if (i == 1)
        this.j.setVisibility(0); 
    } else {
      this.i.setVisibility(0);
    } 
    this.d = (ImageView)findViewById(ab.e((Context)this, "tt_titlebar_back"));
    ImageView imageView = this.d;
    if (imageView != null)
      imageView.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (TTLandingPageActivity.f(this.a) != null) {
                if (TTLandingPageActivity.f(this.a).canGoBack()) {
                  TTLandingPageActivity.f(this.a).goBack();
                  return;
                } 
                if (TTLandingPageActivity.g(this.a)) {
                  this.a.onBackPressed();
                  return;
                } 
                this.a.finish();
              } 
            }
          }); 
    this.e = (ImageView)findViewById(ab.e((Context)this, "tt_titlebar_close"));
    imageView = this.e;
    if (imageView != null)
      imageView.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              this.a.finish();
            }
          }); 
    this.f = (TextView)findViewById(ab.e((Context)this, "tt_titlebar_title"));
    this.m = (ProgressBar)findViewById(ab.e((Context)this, "tt_browser_progress"));
  }
  
  private void d() {
    ArrayList<k> arrayList = new ArrayList();
    arrayList.add(this.s);
    this.p = new x((Context)this);
    this.p.a((WebView)this.c).a(this.s).a(arrayList).a(this.n).b(this.o).a(this.q).c(ah.g(this.s)).a(this);
  }
  
  private boolean e() {
    return (!TextUtils.isEmpty(this.t) && this.t.contains("__luban_sdk"));
  }
  
  private void f() {
    if (this.s == null)
      return; 
    JSONArray jSONArray = b(this.t);
    int i = ah.d(this.o);
    int m = ah.c(this.o);
    p p = o.f();
    if (jSONArray != null && p != null && i > 0) {
      if (m <= 0)
        return; 
      l l = new l();
      l.d = jSONArray;
      AdSlot adSlot = this.s.j();
      if (adSlot == null)
        return; 
      adSlot.setAdCount(6);
      p.a(adSlot, l, m, new p.b(this) {
            public void a(int param1Int, String param1String) {
              TTLandingPageActivity.a(this.a, 0);
            }
            
            public void a(a param1a) {
              if (param1a != null)
                try {
                  TTLandingPageActivity.h(this.a).set(false);
                  JSONObject jSONObject = new JSONObject(param1a.d());
                  TTLandingPageActivity.i(this.a).b(jSONObject);
                  return;
                } catch (Exception exception) {
                  TTLandingPageActivity.a(this.a, 0);
                }  
            }
          });
    } 
  }
  
  public void a(boolean paramBoolean, JSONArray paramJSONArray) {
    if (paramBoolean && paramJSONArray != null && paramJSONArray.length() > 0) {
      this.v = paramJSONArray;
      f();
    } 
  }
  
  public void onBackPressed() {
    if (e() && !this.u.getAndSet(true)) {
      a(true);
      a(0);
      return;
    } 
    super.onBackPressed();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
    a();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    if (h.c().l())
      getWindow().addFlags(2621440); 
    try {
      o.a((Context)this);
    } finally {}
    setContentView(ab.f((Context)this, "tt_activity_ttlandingpage"));
    c();
    this.g = (Context)this;
    a.a(this.g).a(false).b(false).a((WebView)this.c);
    Intent intent = getIntent();
    this.h = intent.getIntExtra("sdk_version", 1);
    this.n = intent.getStringExtra("adid");
    this.o = intent.getStringExtra("log_extra");
    this.q = intent.getIntExtra("source", -1);
    String str1 = intent.getStringExtra("url");
    this.t = str1;
    a(4);
    String str2 = intent.getStringExtra("web_title");
    intent.getStringExtra("icon_url");
    this.r = intent.getStringExtra("event_tag");
    if (b.b()) {
      String str = intent.getStringExtra("multi_process_materialmeta");
      if (str != null)
        try {
          this.s = c.a(new JSONObject(str));
        } catch (Exception exception) {
          t.c(b, "TTLandingPageActivity - onCreate MultiGlobalInfo : ", exception);
        }  
    } else {
      this.s = u.a().c();
      u.a().g();
    } 
    this.a = (new j((Context)this, this.s, (WebView)this.c)).a(true);
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("adid", this.n);
      jSONObject.put("url", str1);
      jSONObject.put("web_title", str2);
      jSONObject.put("is_multi_process", b.b());
      jSONObject.put("event_tag", this.r);
    } catch (JSONException jSONException) {}
    this.a.a(jSONObject);
    d();
    this.c.setWebViewClient((WebViewClient)new c(this, this.g, this.p, this.n, this.a) {
          public void onPageFinished(WebView param1WebView, String param1String) {
            super.onPageFinished(param1WebView, param1String);
            try {
              return;
            } finally {
              param1WebView = null;
            } 
          }
        });
    this.c.getSettings().setUserAgentString(q.a((WebView)this.c, this.h));
    if (Build.VERSION.SDK_INT >= 21)
      this.c.getSettings().setMixedContentMode(0); 
    this.c.loadUrl(str1);
    this.c.setWebChromeClient((WebChromeClient)new b(this, this.p, this.a) {
          public void onProgressChanged(WebView param1WebView, int param1Int) {
            super.onProgressChanged(param1WebView, param1Int);
            if (TTLandingPageActivity.a(this.a) != null && !this.a.isFinishing()) {
              if (param1Int == 100 && TTLandingPageActivity.a(this.a).isShown()) {
                TTLandingPageActivity.a(this.a).setVisibility(8);
                return;
              } 
              TTLandingPageActivity.a(this.a).setProgress(param1Int);
            } 
          }
        });
    this.c.setDownloadListener(new DownloadListener(this) {
          public void onDownloadStart(String param1String1, String param1String2, String param1String3, String param1String4, long param1Long) {
            a a;
            if (TTLandingPageActivity.b(this.a).containsKey(param1String1)) {
              a = (a)TTLandingPageActivity.b(this.a).get(param1String1);
              if (a != null) {
                a.f();
                return;
              } 
            } else {
              k k = TTLandingPageActivity.c(this.a);
              param1String3 = null;
              param1String2 = param1String3;
              if (k != null)
                if (TTLandingPageActivity.c(this.a).C() == null) {
                  param1String2 = param1String3;
                } else {
                  param1String2 = TTLandingPageActivity.c(this.a).C().a();
                }  
              a a1 = a.a((Context)this.a, (String)a, param1String2);
              TTLandingPageActivity.b(this.a).put(a, a1);
              a1.f();
            } 
          }
        });
    TextView textView = this.f;
    if (textView != null) {
      str1 = str2;
      if (TextUtils.isEmpty(str2))
        str1 = ab.a((Context)this, "tt_web_title_default"); 
      textView.setText(str1);
    } 
    a();
  }
  
  protected void onDestroy() {
    super.onDestroy();
    try {
      if (getWindow() != null) {
        ViewGroup viewGroup = (ViewGroup)getWindow().getDecorView();
        if (viewGroup != null)
          viewGroup.removeAllViews(); 
      } 
    } finally {
      Exception exception;
    } 
    aa.a(this.g, (WebView)this.c);
    aa.a((WebView)this.c);
    this.c = null;
    x x1 = this.p;
    if (x1 != null)
      x1.i(); 
    a a1 = this.w;
    if (a1 != null)
      a1.d(); 
    Map<String, a> map = this.x;
    if (map != null) {
      for (Map.Entry<String, a> entry : map.entrySet()) {
        if (entry.getValue() != null)
          ((a)entry.getValue()).d(); 
      } 
      this.x.clear();
    } 
    j j1 = this.a;
    if (j1 != null)
      j1.c(); 
  }
  
  protected void onPause() {
    super.onPause();
    u.a().b(true);
    x x1 = this.p;
    if (x1 != null)
      x1.h(); 
    a a1 = this.w;
    if (a1 != null)
      a1.c(); 
    Map<String, a> map = this.x;
    if (map != null)
      for (Map.Entry<String, a> entry : map.entrySet()) {
        if (entry.getValue() != null)
          ((a)entry.getValue()).c(); 
      }  
  }
  
  protected void onResume() {
    super.onResume();
    x x1 = this.p;
    if (x1 != null)
      x1.g(); 
    a a1 = this.w;
    if (a1 != null)
      a1.b(); 
    Map<String, a> map = this.x;
    if (map != null)
      for (Map.Entry<String, a> entry : map.entrySet()) {
        if (entry.getValue() != null)
          ((a)entry.getValue()).b(); 
      }  
    j j1 = this.a;
    if (j1 != null)
      j1.a(); 
    f();
  }
  
  protected void onStop() {
    super.onStop();
    j j1 = this.a;
    if (j1 != null)
      j1.b(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\activity\TTLandingPageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */