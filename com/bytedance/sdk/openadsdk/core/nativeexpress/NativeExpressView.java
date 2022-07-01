package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.i;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.d.m;
import com.bytedance.sdk.openadsdk.core.d.o;
import com.bytedance.sdk.openadsdk.core.d.p;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.widget.webview.a.f;
import com.bytedance.sdk.openadsdk.core.widget.webview.b;
import com.bytedance.sdk.openadsdk.core.widget.webview.d;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.f.a.d;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.ai;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.t;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class NativeExpressView extends FrameLayout implements j {
  private final AtomicBoolean A = new AtomicBoolean(false);
  
  private String B = null;
  
  private float C;
  
  private float D;
  
  private final AtomicBoolean E = new AtomicBoolean(false);
  
  private String F = "{\"id\":0,\"tplId\":0,\"title\":\"\",\"data\":{\"id\":\"root\",\"type\":\"vessel\",\"values\":{\"widthMode\":\"fixed\",\"width\":320,\"height\":320},\"children\":[[{\"type\":\"text\",\"values\":{\"fontSize\":19,\"fontWeight\":500,\"color\":\"#222222\",\"lineHeight\":1.3,\"data\":\"title\"}}],[{\"type\":\"text\",\"values\":{\"fontSize\":15,\"fontWeight\":500,\"color\":\"#999999\",\"lineHeight\":1,\"data\":\"subtitle\"}}],[{\"type\":\"image\",\"values\":{},\"children\":[]}],[{\"type\":\"vessel\",\"values\":{\"height\":40,\"paddingTop\":10,\"paddingRight\":15,\"paddingBottom\":10,\"paddingLeft\":15},\"children\":[[{\"type\":\"logo\",\"values\":{}},{\"type\":\"text\",\"values\":{\"widthMode\":\"auto\",\"paddingTop\":3,\"paddingRight\":0,\"paddingBottom\":3,\"paddingLeft\":6,\"fontSize\":12,\"color\":\"#999999\",\"lineHeight\":1,\"data\":\"source\"}},{\"type\":\"text\",\"values\":{\"widthMode\":\"auto\",\"paddingTop\":3,\"paddingRight\":0,\"paddingBottom\":3,\"paddingLeft\":10,\"fontSize\":12,\"color\":\"#999999\",\"lineHeight\":1,\"data\":\"time\"}},{\"type\":\"empty\",\"values\":{\"height\":18}},{\"type\":\"dislike\",\"values\":{}}]]}]]}}";
  
  private TTAdDislike a;
  
  private TTDislikeDialogAbstract b;
  
  private String c;
  
  private String d;
  
  protected final AtomicBoolean e = new AtomicBoolean(false);
  
  protected final Context f;
  
  protected WeakReference<SSWebView> g;
  
  protected x h;
  
  protected String i = "embeded_ad";
  
  protected AdSlot j;
  
  public k k;
  
  protected TTNativeExpressAd.ExpressVideoAdListener l;
  
  protected FrameLayout m;
  
  protected boolean n;
  
  protected boolean o = false;
  
  protected ScheduledFuture<?> p;
  
  protected c q;
  
  protected boolean r = false;
  
  protected BackupView s;
  
  private int t;
  
  private int u;
  
  private TTNativeExpressAd.ExpressAdInteractionListener v;
  
  private d w;
  
  private e x;
  
  private final Map<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> y = Collections.synchronizedMap(new HashMap<String, com.bytedance.sdk.openadsdk.downloadnew.core.a>());
  
  private final AtomicBoolean z = new AtomicBoolean(false);
  
  public NativeExpressView(Context paramContext, k paramk, AdSlot paramAdSlot, String paramString) {
    super(paramContext);
    this.i = paramString;
    this.f = paramContext;
    this.k = paramk;
    a(paramAdSlot);
    a();
  }
  
  private void a(float paramFloat1, float paramFloat2) {
    if (paramFloat1 > 0.0F) {
      if (paramFloat2 <= 0.0F)
        return; 
      int i = (int)ai.a(this.f, paramFloat1);
      int m = (int)ai.a(this.f, paramFloat2);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("width:");
      stringBuilder.append(i);
      t.e("ExpressView", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append("height:");
      stringBuilder.append(m);
      t.e("ExpressView", stringBuilder.toString());
      FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams)getWebView().getLayoutParams();
      FrameLayout.LayoutParams layoutParams1 = layoutParams2;
      if (layoutParams2 == null)
        layoutParams1 = new FrameLayout.LayoutParams(i, m); 
      layoutParams1.width = i;
      layoutParams1.height = m;
      getWebView().setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    } 
  }
  
  private void a(int paramInt) {
    d d1 = d.b().a(getAdSlotType()).c(this.B).f(ah.h(this.d)).b(paramInt).g(g.a(paramInt));
    com.bytedance.sdk.openadsdk.f.a.a().h(d1);
  }
  
  private void a(AdSlot paramAdSlot) {
    this.j = paramAdSlot;
    paramAdSlot = this.j;
    if (paramAdSlot == null)
      return; 
    this.C = paramAdSlot.getExpressViewAcceptedWidth();
    this.D = this.j.getExpressViewAcceptedHeight();
  }
  
  private void a(SSWebView paramSSWebView) {
    if (paramSSWebView == null)
      return; 
    try {
      com.bytedance.sdk.openadsdk.core.widget.webview.a.a(this.f).a(false).a((WebView)paramSSWebView);
      paramSSWebView.setVerticalScrollBarEnabled(false);
      paramSSWebView.setHorizontalScrollBarEnabled(false);
      paramSSWebView.clearCache(true);
      paramSSWebView.clearHistory();
      WebSettings webSettings = paramSSWebView.getSettings();
      webSettings.setUserAgentString(q.a((WebView)paramSSWebView, this.u));
      if (Build.VERSION.SDK_INT >= 21)
        webSettings.setMixedContentMode(0); 
      webSettings.setJavaScriptEnabled(true);
      webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
      webSettings.setCacheMode(2);
      webSettings.setDomStorageEnabled(true);
      webSettings.setDatabaseEnabled(true);
      webSettings.setAppCacheEnabled(true);
      webSettings.setAllowFileAccess(true);
      webSettings.setSupportZoom(true);
      webSettings.setBuiltInZoomControls(true);
      webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
      webSettings.setUseWideViewPort(true);
      return;
    } catch (Exception exception) {
      t.e("NativeExpressView", exception.toString());
      return;
    } 
  }
  
  private void b(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt) {
    AtomicBoolean atomicBoolean = this.e;
    boolean bool = true;
    if (atomicBoolean.getAndSet(true))
      return; 
    if (paramBoolean) {
      a(paramFloat1, paramFloat2);
      TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this.v;
      if (expressAdInteractionListener != null) {
        expressAdInteractionListener.onRenderSuccess((View)this, paramFloat1, paramFloat2);
        return;
      } 
    } else {
      c c1 = this.q;
      if (c1 != null && c1.a(this, paramInt)) {
        paramBoolean = bool;
      } else {
        paramBoolean = false;
      } 
      this.r = paramBoolean;
      if (this.r) {
        d.o(o.a(), this.k, this.i, "dynamic_backup_render", null);
        this.s = (BackupView)findViewWithTag("tt_express_backup_fl_tag_26");
        TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this.v;
        if (expressAdInteractionListener != null)
          expressAdInteractionListener.onRenderSuccess((View)this, this.s.getRealWidth(), this.s.getRealHeight()); 
      } else {
        TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this.v;
        if (expressAdInteractionListener != null)
          expressAdInteractionListener.onRenderFail((View)this, g.a(paramInt), paramInt); 
      } 
      a(paramInt);
    } 
  }
  
  private void c() {
    this.c = this.k.M();
    this.d = this.k.P();
    this.u = 2956;
    this.t = ah.a(this.i);
    this.B = this.j.getCodeId();
  }
  
  private void d() {
    a(getWebView());
    getWebView().setWebViewClient((WebViewClient)new f(this.f, this.h, this.k));
    getWebView().setWebChromeClient((WebChromeClient)new b(this.h, null));
    getWebView().setDownloadListener(new DownloadListener(this) {
          public void onDownloadStart(String param1String1, String param1String2, String param1String3, String param1String4, long param1Long) {
            com.bytedance.sdk.openadsdk.downloadnew.core.a a;
            if (NativeExpressView.a(this.a).containsKey(param1String1)) {
              a = (com.bytedance.sdk.openadsdk.downloadnew.core.a)NativeExpressView.a(this.a).get(param1String1);
              if (a != null) {
                a.f();
                return;
              } 
            } else {
              k k = this.a.k;
              param1String3 = null;
              param1String2 = param1String3;
              if (k != null)
                if (this.a.k.C() == null) {
                  param1String2 = param1String3;
                } else {
                  param1String2 = this.a.k.C().a();
                }  
              com.bytedance.sdk.openadsdk.downloadnew.core.a a1 = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.a.f, (String)a, param1String2);
              NativeExpressView.a(this.a).put(a, a1);
              a1.f();
            } 
          }
        });
  }
  
  private boolean e() {
    k k1 = this.k;
    if (k1 != null) {
      if (k1.x() == null)
        return false; 
      if (!TextUtils.isEmpty(this.k.x().e()))
        return true; 
    } 
    return false;
  }
  
  private boolean f() {
    k k1 = this.k;
    null = true;
    if (k1 != null && k1.e() == 1)
      if (this.k.Q() != 5) {
        if (this.k.Q() == 15)
          return true; 
      } else {
        return null;
      }  
    return false;
  }
  
  private int getAdSlotType() {
    byte b;
    String str = this.i;
    switch (str.hashCode()) {
      default:
        b = -1;
        break;
      case 1912999166:
        if (str.equals("draw_ad")) {
          b = 1;
          break;
        } 
      case -712491894:
        if (str.equals("embeded_ad")) {
          b = 0;
          break;
        } 
      case -764631662:
        if (str.equals("fullscreen_interstitial_ad")) {
          b = 3;
          break;
        } 
      case -1364000502:
        if (str.equals("rewarded_video")) {
          b = 2;
          break;
        } 
    } 
    return (b != 0) ? ((b != 1) ? ((b != 2) ? ((b != 3) ? 5 : 8) : 7) : 9) : 5;
  }
  
  private JSONObject getCreativeJson() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("button_text", this.k.L());
      if (this.k.C() != null)
        jSONObject.put("icon", this.k.C().a()); 
      JSONArray jSONArray = new JSONArray();
      if (this.k.F() != null)
        for (int i = 0; i < this.k.F().size(); i++) {
          j j1 = this.k.F().get(i);
          JSONObject jSONObject1 = new JSONObject();
          jSONObject1.put("height", j1.c());
          jSONObject1.put("width", j1.b());
          jSONObject1.put("url", j1.a());
          jSONArray.put(jSONObject1);
        }  
      jSONObject.put("image", jSONArray);
      jSONObject.put("image_mode", this.k.Q());
      jSONObject.put("interaction_type", this.k.B());
      jSONObject.put("title", this.k.J());
      jSONObject.put("description", this.k.K());
      jSONObject.put("source", this.k.A());
      if (this.k.N() != null) {
        jSONObject.put("comment_num", this.k.N().f());
        jSONObject.put("score", this.k.N().e());
        jSONObject.put("app_size", this.k.N().g());
        jSONObject.put("app", this.k.N().h());
      } 
      if (this.k.z() != null)
        jSONObject.put("video", this.k.z().k()); 
      if (this.k.x() != null)
        jSONObject.put("dynamic_creative", this.k.x().g()); 
      return jSONObject;
    } catch (Exception exception) {
      return null;
    } 
  }
  
  private JSONObject getTemplateInfo() {
    JSONObject jSONObject = new JSONObject();
    try {
      JSONObject jSONObject2;
      jSONObject.put("platform", "android");
      JSONObject jSONObject1 = new JSONObject();
      jSONObject1.put("width", this.C);
      jSONObject1.put("height", this.D);
      if (this.o)
        jSONObject1.put("isLandscape", true); 
      jSONObject.put("AdSize", jSONObject1);
      jSONObject.put("creative", getCreativeJson());
      if (this.k.x() != null) {
        String str1 = this.k.x().e();
        String str2 = this.k.x().f();
      } else {
        jSONObject1 = null;
        jSONObject2 = jSONObject1;
      } 
      if (!TextUtils.isEmpty((CharSequence)jSONObject1)) {
        this.F = (String)jSONObject1;
      } else if (com.bytedance.sdk.openadsdk.core.widget.webview.a.a.b(this.k) != null) {
        this.F = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.b(this.k).e();
      } 
      jSONObject.put("template_Plugin", this.F);
      jSONObject.put("diff_template_Plugin", jSONObject2);
      return jSONObject;
    } catch (Exception exception) {
      return null;
    } 
  }
  
  private void n() {
    if (this.z.getAndSet(false) && getWebView().getParent() == null && !this.r) {
      t.e("webviewpool", "attachCallback+++========-----------===========");
      a();
      h();
    } 
  }
  
  private void o() {
    if (!this.z.getAndSet(true) && !this.r)
      d.a().a((ViewGroup)this, this.g, j()); 
  }
  
  private void p() {
    try {
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  public void a() {
    setBackgroundColor(0);
    if (getWebView().getParent() != null)
      ((ViewGroup)getWebView().getParent()).removeView((View)getWebView()); 
    getWebView().setBackgroundColor(0);
    addView((View)getWebView(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    c();
    b();
    d();
    getWebView().addJavascriptInterface(this.h, "SDK_INJECT_GLOBAL");
  }
  
  public void a(int paramInt, i parami) {
    if (paramInt != -1) {
      TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener;
      if (parami == null)
        return; 
      int m = parami.a;
      int n = parami.b;
      int i1 = parami.c;
      int i2 = parami.d;
      if (paramInt != 1) {
        TTAdDislike tTAdDislike;
        if (paramInt != 2) {
          if (paramInt != 3) {
            if (paramInt != 4)
              return; 
            FrameLayout frameLayout = this.m;
            if (frameLayout != null)
              frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0F, 0.0F, 0)); 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("创意....mAdType=");
            stringBuilder.append(this.i);
            stringBuilder.append(",!mVideoPause=");
            stringBuilder.append(true ^ this.n);
            stringBuilder.append("，isAutoPlay=");
            stringBuilder.append(ah.h(this.k));
            t.b("ClickCreativeListener", stringBuilder.toString());
            if ("embeded_ad".equals(this.i) && f() && !this.n && ah.h(this.k)) {
              t.b("ClickCreativeListener", "创意....");
              d d1 = this.w;
              if (d1 != null) {
                d1.a(parami);
                this.w.a((View)this, m, n, i1, i2);
              } 
            } else {
              t.b("ClickCreativeListener", "普通....");
              e e1 = this.x;
              if (e1 != null) {
                e1.a(parami);
                this.x.a((View)this, m, n, i1, i2);
              } 
            } 
            expressAdInteractionListener = this.v;
            if (expressAdInteractionListener != null) {
              expressAdInteractionListener.onAdClicked((View)this, this.k.B());
              return;
            } 
          } else {
            TTDislikeDialogAbstract tTDislikeDialogAbstract = this.b;
            if (tTDislikeDialogAbstract != null) {
              tTDislikeDialogAbstract.show();
              return;
            } 
            tTAdDislike = this.a;
            if (tTAdDislike != null) {
              tTAdDislike.showDislikeDialog();
              return;
            } 
          } 
        } else {
          d d1 = this.w;
          if (d1 != null) {
            d1.a((i)tTAdDislike);
            this.w.a((View)this, m, n, i1, i2);
          } 
          expressAdInteractionListener = this.v;
          if (expressAdInteractionListener != null) {
            expressAdInteractionListener.onAdClicked((View)this, this.k.B());
            return;
          } 
        } 
      } else {
        FrameLayout frameLayout = this.m;
        if (frameLayout != null)
          frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0F, 0.0F, 0)); 
        e e1 = this.x;
        if (e1 != null) {
          e1.a((i)expressAdInteractionListener);
          this.x.a((View)this, m, n, i1, i2);
        } 
        expressAdInteractionListener = this.v;
        if (expressAdInteractionListener != null)
          expressAdInteractionListener.onAdClicked((View)this, this.k.B()); 
      } 
    } 
  }
  
  public void a(m paramm) {
    int i = 0;
    if (paramm == null) {
      a(false, 0.0F, 0.0F, 105);
      return;
    } 
    boolean bool = paramm.a();
    float f1 = (float)paramm.b();
    float f2 = (float)paramm.c();
    if (!bool)
      i = paramm.h(); 
    a(bool, f1, f2, i);
  }
  
  protected void a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt) {
    p();
    if (Looper.myLooper() == Looper.getMainLooper()) {
      b(paramBoolean, paramFloat1, paramFloat2, paramInt);
      return;
    } 
    (new Handler(Looper.getMainLooper())).post(new Runnable(this, paramBoolean, paramFloat1, paramFloat2, paramInt) {
          public void run() {
            NativeExpressView.a(this.e, this.a, this.b, this.c, this.d);
          }
        });
  }
  
  public void b() {
    this.h = new x(this.f);
    this.h.a((WebView)getWebView()).a(this.k).a(this.c).b(this.d).a(this.t).c(ah.g(this.k)).a(this).a(getTemplateInfo());
  }
  
  public void g() {
    if (this.h != null) {
      if (this.E.get())
        return; 
      try {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("expressShow", true);
        this.h.a("expressShow", jSONObject);
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
    } 
  }
  
  public d getClickCreativeListener() {
    return this.w;
  }
  
  public e getClickListener() {
    return this.x;
  }
  
  public int getExpectExpressHeight() {
    return Float.valueOf(this.D).intValue();
  }
  
  public int getExpectExpressWidth() {
    return Float.valueOf(this.C).intValue();
  }
  
  public SSWebView getWebView() {
    WeakReference<SSWebView> weakReference = this.g;
    if (weakReference != null && weakReference.get() != null)
      return this.g.get(); 
    this.g = d.a().c();
    return this.g.get();
  }
  
  public void h() {
    this.A.set(true);
    int i = o.h().R();
    this.p = com.bytedance.sdk.openadsdk.i.a.a().a(new a(this, 1), i);
    if (Build.VERSION.SDK_INT <= 20) {
      a(false, 0.0F, 0.0F, 110);
      return;
    } 
    if (!com.bytedance.sdk.openadsdk.core.widget.webview.a.a.g()) {
      a(false, 0.0F, 0.0F, 102);
      return;
    } 
    o o = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.f();
    String str1 = null;
    if (o != null) {
      String str = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.f().c();
    } else {
      o = null;
    } 
    if (TextUtils.isEmpty((CharSequence)o)) {
      a(false, 0.0F, 0.0F, 102);
      return;
    } 
    p p = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.b(this.k);
    if (p == null && !e()) {
      a(false, 0.0F, 0.0F, 103);
      return;
    } 
    if (p != null)
      str1 = p.f(); 
    String str2 = str1;
    if (e()) {
      str2 = str1;
      if (!TextUtils.isEmpty(this.k.x().a()))
        str2 = this.k.x().a(); 
    } 
    if (f.b(str2) && !"https://sf3-ttcdn-tos.pstatp.com/obj/ad-pattern/renderer/latest/index.html".equals(o)) {
      a(false, 0.0F, 0.0F, 102);
      return;
    } 
    getWebView().loadUrl((String)o);
  }
  
  public void i() {
    if (getWebView() != null) {
      if (this.E.get())
        return; 
      try {
        com.bytedance.sdk.openadsdk.core.widget.webview.a.a(this.f).a(true).a((WebView)getWebView());
        getWebView().resumeTimers();
        return;
      } catch (Exception exception) {
        return;
      } 
    } 
  }
  
  boolean j() {
    if ("embeded_ad".equals(this.i) || "draw_ad".equals(this.i))
      return false; 
    this.E.set(true);
    return true;
  }
  
  public void k() {
    try {
      d.a().a((ViewGroup)this, this.g, true);
      this.E.set(true);
      this.h = null;
      this.a = null;
      this.b = null;
      this.j = null;
      this.k = null;
      this.v = null;
      this.w = null;
      this.x = null;
      this.y.clear();
      this.l = null;
      removeAllViews();
      return;
    } finally {
      Exception exception = null;
      t.c("NativeExpressView", "detach error", exception);
    } 
  }
  
  public void l() {
    try {
      d.a().a((ViewGroup)this, this.g, true);
      this.E.set(true);
    } finally {
      Exception exception = null;
    } 
  }
  
  public boolean m() {
    return this.r;
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    t.e("webviewpool", "onAttachedToWindow+++");
    n();
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    o();
    t.e("webviewpool", "onDetachedFromWindow===");
  }
  
  public void onFinishTemporaryDetach() {
    super.onFinishTemporaryDetach();
    t.e("webviewpool", "onFinishTemporaryDetach+++");
    n();
  }
  
  public void onStartTemporaryDetach() {
    super.onStartTemporaryDetach();
    o();
  }
  
  public void setBackupListener(c paramc) {
    this.q = paramc;
  }
  
  public void setClickCreativeListener(d paramd) {
    this.w = paramd;
  }
  
  public void setClickListener(e parame) {
    this.x = parame;
  }
  
  public void setDislike(TTAdDislike paramTTAdDislike) {
    BackupView backupView = this.s;
    if (backupView != null)
      backupView.setDislikeInner(paramTTAdDislike); 
    this.a = paramTTAdDislike;
  }
  
  public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener paramExpressAdInteractionListener) {
    this.v = paramExpressAdInteractionListener;
  }
  
  public void setOuterDislike(TTDislikeDialogAbstract paramTTDislikeDialogAbstract) {
    BackupView backupView = this.s;
    if (backupView != null)
      backupView.setDislikeOuter(paramTTDislikeDialogAbstract); 
    this.b = paramTTDislikeDialogAbstract;
  }
  
  public void setVideoAdListener(TTNativeExpressAd.ExpressVideoAdListener paramExpressVideoAdListener) {
    this.l = paramExpressVideoAdListener;
  }
  
  class a implements Runnable {
    private int b;
    
    public a(NativeExpressView this$0, int param1Int) {
      this.b = param1Int;
    }
    
    public void run() {
      if (this.b == 1) {
        t.c("NativeExpressView", "MSG_RENDER_TIME_OUT-->OnAdRenderRunnable......run....");
        this.a.a(false, 0.0F, 0.0F, 107);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\nativeexpress\NativeExpressView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */