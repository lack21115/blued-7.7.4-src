package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.c.j;
import com.bytedance.sdk.openadsdk.core.a.a;
import com.bytedance.sdk.openadsdk.core.aa;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.d.a;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.u;
import com.bytedance.sdk.openadsdk.core.video.c.d;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.a;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.e;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.f;
import com.bytedance.sdk.openadsdk.core.widget.RoundImageView;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.widget.webview.a;
import com.bytedance.sdk.openadsdk.core.widget.webview.b;
import com.bytedance.sdk.openadsdk.core.widget.webview.c;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.d.d;
import com.bytedance.sdk.openadsdk.downloadnew.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.g.e;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import com.bytedance.sdk.openadsdk.multipro.d.a;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.ai;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TTVideoLandingPageActivity extends Activity implements d {
  private Button A;
  
  private ProgressBar B;
  
  private a C;
  
  private final Map<String, a> D = Collections.synchronizedMap(new HashMap<String, a>());
  
  private boolean E = false;
  
  private h F;
  
  private String G;
  
  private boolean H = false;
  
  private boolean I = true;
  
  private boolean J = false;
  
  private String K = null;
  
  private int L;
  
  private a M;
  
  private j N;
  
  private AtomicBoolean O = new AtomicBoolean(true);
  
  private JSONArray P = null;
  
  private String Q = "立即下载";
  
  private TTAppDownloadListener R = new TTAppDownloadListener(this) {
      public void onDownloadActive(long param1Long1, long param1Long2, String param1String1, String param1String2) {
        TTVideoLandingPageActivity.a(this.a, "下载中...");
      }
      
      public void onDownloadFailed(long param1Long1, long param1Long2, String param1String1, String param1String2) {
        TTVideoLandingPageActivity.a(this.a, "下载失败");
      }
      
      public void onDownloadFinished(long param1Long, String param1String1, String param1String2) {
        TTVideoLandingPageActivity.a(this.a, "点击安装");
      }
      
      public void onDownloadPaused(long param1Long1, long param1Long2, String param1String1, String param1String2) {
        TTVideoLandingPageActivity.a(this.a, "暂停");
      }
      
      public void onIdle() {
        TTVideoLandingPageActivity tTVideoLandingPageActivity = this.a;
        TTVideoLandingPageActivity.a(tTVideoLandingPageActivity, TTVideoLandingPageActivity.d(tTVideoLandingPageActivity));
      }
      
      public void onInstalled(String param1String1, String param1String2) {
        TTVideoLandingPageActivity.a(this.a, "点击打开");
      }
    };
  
  private a S = null;
  
  private final e T = new e(this) {
      public void a(boolean param1Boolean) {
        TTVideoLandingPageActivity.a(this.a, param1Boolean);
        if (!this.a.isFinishing()) {
          if (param1Boolean) {
            ai.a((View)TTVideoLandingPageActivity.f(this.a), 8);
            ai.a((View)TTVideoLandingPageActivity.k(this.a), 8);
            ViewGroup.MarginLayoutParams marginLayoutParams1 = (ViewGroup.MarginLayoutParams)TTVideoLandingPageActivity.l(this.a).getLayoutParams();
            TTVideoLandingPageActivity.a(this.a, marginLayoutParams1.leftMargin);
            TTVideoLandingPageActivity.b(this.a, marginLayoutParams1.topMargin);
            TTVideoLandingPageActivity.c(this.a, marginLayoutParams1.width);
            TTVideoLandingPageActivity.d(this.a, marginLayoutParams1.height);
            marginLayoutParams1.width = -1;
            marginLayoutParams1.height = -1;
            marginLayoutParams1.topMargin = 0;
            marginLayoutParams1.leftMargin = 0;
            TTVideoLandingPageActivity.l(this.a).setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams1);
            return;
          } 
          ai.a((View)TTVideoLandingPageActivity.f(this.a), 0);
          ai.a((View)TTVideoLandingPageActivity.k(this.a), 0);
          ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)TTVideoLandingPageActivity.l(this.a).getLayoutParams();
          marginLayoutParams.width = TTVideoLandingPageActivity.m(this.a);
          marginLayoutParams.height = TTVideoLandingPageActivity.n(this.a);
          marginLayoutParams.leftMargin = TTVideoLandingPageActivity.o(this.a);
          marginLayoutParams.topMargin = TTVideoLandingPageActivity.p(this.a);
          TTVideoLandingPageActivity.l(this.a).setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
        } 
      }
    };
  
  private boolean U = false;
  
  private final BroadcastReceiver V = new BroadcastReceiver(this) {
      public void onReceive(Context param1Context, Intent param1Intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(param1Intent.getAction())) {
          int i = w.c(this.a.getApplicationContext());
          if (TTVideoLandingPageActivity.q(this.a) == 0 && i != 0 && TTVideoLandingPageActivity.f(this.a) != null && TTVideoLandingPageActivity.r(this.a) != null)
            TTVideoLandingPageActivity.f(this.a).loadUrl(TTVideoLandingPageActivity.r(this.a)); 
          if (TTVideoLandingPageActivity.h(this.a) != null && TTVideoLandingPageActivity.h(this.a).getNativeVideoController() != null && !TTVideoLandingPageActivity.s(this.a) && TTVideoLandingPageActivity.q(this.a) != i)
            ((f)TTVideoLandingPageActivity.h(this.a).getNativeVideoController()).a(param1Context); 
          TTVideoLandingPageActivity.e(this.a, i);
        } 
      }
    };
  
  private SSWebView a;
  
  private ImageView b;
  
  private ImageView c;
  
  private TextView d;
  
  private Context e;
  
  private int f;
  
  private String g;
  
  private String h;
  
  private x i;
  
  private int j;
  
  private RelativeLayout k;
  
  private FrameLayout l;
  
  private int m = -1;
  
  private NativeVideoTsView n;
  
  private long o;
  
  private k p;
  
  private int q = 0;
  
  private int r = 0;
  
  private int s = 0;
  
  private int t = 0;
  
  private RelativeLayout u;
  
  private TextView v;
  
  private RoundImageView w;
  
  private TextView x;
  
  private TextView y;
  
  private ViewStub z;
  
  private void a(int paramInt) {
    if (this.c != null) {
      if (!n())
        return; 
      ai.a((View)this.c, paramInt);
    } 
  }
  
  private void a(c paramc) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("initFeedNaitiveControllerData-isComplete=");
    stringBuilder.append(paramc.v());
    stringBuilder.append(",position=");
    stringBuilder.append(paramc.m());
    stringBuilder.append(",totalPlayDuration=");
    stringBuilder.append(paramc.o());
    stringBuilder.append(",duration=");
    stringBuilder.append(paramc.r());
    t.e("mutilproces", stringBuilder.toString());
    Boolean bool = Boolean.valueOf(true);
    a.a("sp_multi_native_video_data", "key_video_is_update_flag", bool);
    a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", bool);
    a.a("sp_multi_native_video_data", "key_native_video_complete", Boolean.valueOf(paramc.v()));
    a.a("sp_multi_native_video_data", "key_video_current_play_position", Long.valueOf(paramc.m()));
    a.a("sp_multi_native_video_data", "key_video_total_play_duration", Long.valueOf(paramc.o()));
    a.a("sp_multi_native_video_data", "key_video_duration", Long.valueOf(paramc.r()));
  }
  
  private void a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    Button button = this.A;
    if (button != null)
      button.post(new Runnable(this, paramString) {
            public void run() {
              if (TTVideoLandingPageActivity.e(this.b) != null && !this.b.isFinishing())
                TTVideoLandingPageActivity.e(this.b).setText(this.a); 
            }
          }); 
  }
  
  private void a(boolean paramBoolean) {
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("isBackIntercept", paramBoolean);
      this.i.a("temai_back_event", jSONObject);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private JSONArray b(String paramString) {
    JSONArray jSONArray = this.P;
    if (jSONArray != null && jSONArray.length() > 0)
      return this.P; 
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
    k k1 = this.p;
    if (k1 != null && k1.B() == 4) {
      this.z.setVisibility(0);
      this.A = (Button)findViewById(ab.e((Context)this, "tt_browser_download_btn"));
      if (this.A != null) {
        a(d());
        if (this.C != null) {
          if (TextUtils.isEmpty(this.G)) {
            ah.a(this.j);
          } else {
            String str = this.G;
          } 
          this.C.a(this.R, false);
        } 
        this.A.setOnClickListener((View.OnClickListener)this.S);
        this.A.setOnTouchListener((View.OnTouchListener)this.S);
      } 
    } 
  }
  
  private String d() {
    k k1 = this.p;
    if (k1 != null && !TextUtils.isEmpty(k1.L()))
      this.Q = this.p.L(); 
    return this.Q;
  }
  
  private void e() {
    this.B = (ProgressBar)findViewById(ab.e((Context)this, "tt_browser_progress"));
    this.z = (ViewStub)findViewById(ab.e((Context)this, "tt_browser_download_btn_stub"));
    this.a = (SSWebView)findViewById(ab.e((Context)this, "tt_browser_webview"));
    this.b = (ImageView)findViewById(ab.e((Context)this, "tt_titlebar_back"));
    ImageView imageView = this.b;
    if (imageView != null)
      imageView.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (TTVideoLandingPageActivity.f(this.a) != null) {
                Map map;
                if (TTVideoLandingPageActivity.f(this.a).canGoBack()) {
                  TTVideoLandingPageActivity.f(this.a).goBack();
                  return;
                } 
                if (TTVideoLandingPageActivity.g(this.a)) {
                  this.a.onBackPressed();
                  return;
                } 
                View view = null;
                param1View = view;
                if (TTVideoLandingPageActivity.h(this.a) != null) {
                  param1View = view;
                  if (TTVideoLandingPageActivity.h(this.a).getNativeVideoController() != null)
                    map = ah.a(TTVideoLandingPageActivity.c(this.a), TTVideoLandingPageActivity.h(this.a).getNativeVideoController().n(), TTVideoLandingPageActivity.h(this.a).getNativeVideoController().t()); 
                } 
                TTVideoLandingPageActivity tTVideoLandingPageActivity = this.a;
                d.a((Context)tTVideoLandingPageActivity, TTVideoLandingPageActivity.c(tTVideoLandingPageActivity), "embeded_ad", "detail_back", TTVideoLandingPageActivity.i(this.a), TTVideoLandingPageActivity.j(this.a), map);
                this.a.finish();
              } 
            }
          }); 
    this.c = (ImageView)findViewById(ab.e((Context)this, "tt_titlebar_close"));
    imageView = this.c;
    if (imageView != null)
      imageView.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (TTVideoLandingPageActivity.h(this.a) != null) {
                Map map;
                param1View = null;
                if (TTVideoLandingPageActivity.h(this.a).getNativeVideoController() != null)
                  map = ah.a(TTVideoLandingPageActivity.c(this.a), TTVideoLandingPageActivity.h(this.a).getNativeVideoController().n(), TTVideoLandingPageActivity.h(this.a).getNativeVideoController().t()); 
                TTVideoLandingPageActivity tTVideoLandingPageActivity = this.a;
                d.a((Context)tTVideoLandingPageActivity, TTVideoLandingPageActivity.c(tTVideoLandingPageActivity), "embeded_ad", "detail_skip", TTVideoLandingPageActivity.i(this.a), TTVideoLandingPageActivity.j(this.a), map);
              } 
              this.a.finish();
            }
          }); 
    this.d = (TextView)findViewById(ab.e((Context)this, "tt_titlebar_title"));
    this.l = (FrameLayout)findViewById(ab.e((Context)this, "tt_native_video_container"));
    this.k = (RelativeLayout)findViewById(ab.e((Context)this, "tt_native_video_titlebar"));
    this.u = (RelativeLayout)findViewById(ab.e((Context)this, "tt_rl_download"));
    this.v = (TextView)findViewById(ab.e((Context)this, "tt_video_btn_ad_image_tv"));
    this.x = (TextView)findViewById(ab.e((Context)this, "tt_video_ad_name"));
    this.y = (TextView)findViewById(ab.e((Context)this, "tt_video_ad_button"));
    this.w = (RoundImageView)findViewById(ab.e((Context)this, "tt_video_ad_logo_image"));
    i();
  }
  
  private void f() {
    if (this.m == 5) {
      try {
        this.n = new NativeVideoTsView(this.e, this.p, true);
        if (this.n.getNativeVideoController() != null)
          this.n.getNativeVideoController().b(false); 
        if (this.H) {
          this.l.setVisibility(0);
          this.l.removeAllViews();
          this.l.addView((View)this.n);
          this.n.b(true);
        } else {
          if (!this.J)
            this.o = 0L; 
          if (this.M != null && this.n.getNativeVideoController() != null) {
            this.n.getNativeVideoController().b(this.M.g);
            this.n.getNativeVideoController().c(this.M.e);
          } 
          if (this.n.a(this.o, this.I, this.H)) {
            this.l.setVisibility(0);
            this.l.removeAllViews();
            this.l.addView((View)this.n);
          } 
          if (this.n.getNativeVideoController() != null) {
            this.n.getNativeVideoController().b(false);
            this.n.getNativeVideoController().a(this.T);
            this.n.setIsQuiet(false);
          } 
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
      if (w.c((Context)this) == 0)
        Toast.makeText((Context)this, ab.b((Context)this, "tt_no_network"), 0).show(); 
    } 
  }
  
  private long g() {
    NativeVideoTsView nativeVideoTsView = this.n;
    return (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) ? this.n.getNativeVideoController().o() : 0L;
  }
  
  private int h() {
    NativeVideoTsView nativeVideoTsView = this.n;
    return (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) ? this.n.getNativeVideoController().q() : 0;
  }
  
  private void i() {
    k k1 = this.p;
    if (k1 != null) {
      String str;
      if (k1.B() != 4)
        return; 
      ai.a((View)this.u, 0);
      if (!TextUtils.isEmpty(this.p.J())) {
        str = this.p.J();
      } else if (!TextUtils.isEmpty(this.p.K())) {
        str = this.p.K();
      } else if (!TextUtils.isEmpty(this.p.A())) {
        str = this.p.A();
      } else {
        str = "";
      } 
      if (this.p.C() != null && this.p.C().a() != null) {
        ai.a((View)this.w, 0);
        ai.a((View)this.v, 4);
        e.a(this.e).a(this.p.C().a(), (ImageView)this.w);
      } else if (!TextUtils.isEmpty(str)) {
        ai.a((View)this.w, 4);
        ai.a((View)this.v, 0);
        this.v.setText(str.substring(0, 1));
      } 
      if (!TextUtils.isEmpty(str))
        this.x.setText(str); 
      ai.a((View)this.x, 0);
      ai.a((View)this.y, 0);
    } 
  }
  
  private void j() {
    k k1 = this.p;
    if (k1 != null) {
      if (k1.B() != 4)
        return; 
      this.C = a.a((Context)this, this.p, this.G);
      this.C.a(this);
      this.S = new a((Context)this, this.p, this.G, this.j);
      this.S.a(false);
      this.y.setOnClickListener((View.OnClickListener)this.S);
      this.y.setOnTouchListener((View.OnTouchListener)this.S);
      this.S.a(this.C);
    } 
  }
  
  private void k() {
    ArrayList<k> arrayList = new ArrayList();
    arrayList.add(this.p);
    this.i = new x((Context)this);
    this.i.a((WebView)this.a).a(this.p).a(arrayList).a(this.g).b(this.h).a(this.j).c(ah.g(this.p));
  }
  
  private void l() {
    NativeVideoTsView nativeVideoTsView = this.n;
    if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
      this.n.setIsQuiet(false);
      d d1 = this.n.getNativeVideoController().t();
      if (d1 != null && d1.i()) {
        this.n.a(this.o, this.I, this.H);
        return;
      } 
      if ((d1 == null && this.U) || (d1 != null && d1.j())) {
        this.U = false;
        this.n.a(this.o, this.I, this.H);
      } 
    } 
  }
  
  private void m() {
    NativeVideoTsView nativeVideoTsView = this.n;
    if (nativeVideoTsView != null) {
      d d1 = nativeVideoTsView.getNativeVideoController().t();
      if (d1 != null && d1.h()) {
        this.U = true;
        ((f)this.n.getNativeVideoController()).e(this.n.getNativeVideoController().o());
        this.n.getNativeVideoController().a(false);
        return;
      } 
      if (d1 != null && !d1.l()) {
        ((f)this.n.getNativeVideoController()).e(this.n.getNativeVideoController().o());
        this.n.getNativeVideoController().a(false);
      } 
    } 
  }
  
  private boolean n() {
    return (!TextUtils.isEmpty(this.K) && this.K.contains("__luban_sdk"));
  }
  
  private void o() {
    if (this.p == null)
      return; 
    JSONArray jSONArray = b(this.K);
    int i = ah.d(this.h);
    int m = ah.c(this.h);
    p p = o.f();
    if (jSONArray != null && p != null && i > 0) {
      if (m <= 0)
        return; 
      l l = new l();
      l.d = jSONArray;
      AdSlot adSlot = this.p.j();
      if (adSlot == null)
        return; 
      adSlot.setAdCount(6);
      p.a(adSlot, l, m, new p.b(this) {
            public void a(int param1Int, String param1String) {
              TTVideoLandingPageActivity.f(this.a, 0);
            }
            
            public void a(a param1a) {
              if (param1a != null)
                try {
                  TTVideoLandingPageActivity.t(this.a).set(false);
                  JSONObject jSONObject = new JSONObject(param1a.d());
                  TTVideoLandingPageActivity.u(this.a).b(jSONObject);
                  return;
                } catch (Exception exception) {
                  TTVideoLandingPageActivity.f(this.a, 0);
                }  
            }
          });
    } 
  }
  
  protected void a() {
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    try {
      this.e.registerReceiver(this.V, intentFilter);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void a(boolean paramBoolean, JSONArray paramJSONArray) {
    if (paramBoolean && paramJSONArray != null && paramJSONArray.length() > 0) {
      this.P = paramJSONArray;
      o();
    } 
  }
  
  protected void b() {
    try {
      this.e.unregisterReceiver(this.V);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void onBackPressed() {
    if (this.E) {
      NativeVideoTsView nativeVideoTsView = this.n;
      if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
        ((a)this.n.getNativeVideoController()).e(null, null);
        this.E = false;
        return;
      } 
    } 
    if (n() && !this.O.getAndSet(true)) {
      a(true);
      a(0);
      return;
    } 
    super.onBackPressed();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
    c();
  }
  
  protected void onCreate(Bundle paramBundle) {
    boolean bool;
    super.onCreate(paramBundle);
    if (h.c().l())
      getWindow().addFlags(2621440); 
    try {
      getWindow().addFlags(16777216);
    } finally {
      Exception exception;
    } 
    try {
      o.a((Context)this);
    } finally {
      Exception exception;
    } 
    this.L = w.c(getApplicationContext());
    setContentView(ab.f((Context)this, "tt_activity_videolandingpage"));
    this.e = (Context)this;
    Intent intent = getIntent();
    this.f = intent.getIntExtra("sdk_version", 1);
    this.g = intent.getStringExtra("adid");
    this.h = intent.getStringExtra("log_extra");
    this.j = intent.getIntExtra("source", -1);
    this.K = intent.getStringExtra("url");
    String str1 = intent.getStringExtra("web_title");
    this.G = intent.getStringExtra("event_tag");
    this.J = intent.getBooleanExtra("video_is_auto_play", true);
    if (paramBundle != null && paramBundle.getLong("video_play_position") > 0L)
      this.o = paramBundle.getLong("video_play_position", 0L); 
    String str2 = intent.getStringExtra("multi_process_data");
    if (b.b()) {
      String str = intent.getStringExtra("multi_process_materialmeta");
      if (str != null)
        try {
          this.p = c.a(new JSONObject(str));
        } catch (Exception exception) {} 
      k k1 = this.p;
      if (k1 != null)
        this.m = k1.Q(); 
    } else {
      this.p = u.a().c();
      k k1 = this.p;
      if (k1 != null)
        this.m = k1.Q(); 
      u.a().g();
    } 
    if (str2 != null) {
      try {
        this.M = a.a(new JSONObject(str2));
      } catch (Exception exception) {}
      a a1 = this.M;
      if (a1 != null) {
        this.o = a1.g;
        this.H = this.M.a;
      } 
    } 
    if (paramBundle != null) {
      str2 = paramBundle.getString("material_meta");
      if (this.p == null)
        try {
          this.p = c.a(new JSONObject(str2));
        } finally {} 
      long l = paramBundle.getLong("video_play_position");
      bool = paramBundle.getBoolean("is_complete");
      if (l > 0L)
        this.o = l; 
      if (bool)
        this.H = bool; 
    } 
    this.F = new h(this.p, this.G);
    e();
    j();
    k();
    a(4);
    if (Build.VERSION.SDK_INT >= 16) {
      bool = true;
    } else {
      bool = false;
    } 
    a.a(this.e).a(bool).b(false).a((WebView)this.a);
    this.N = (new j((Context)this, this.p, (WebView)this.a)).a(true);
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("adid", this.g);
      jSONObject.put("url", this.K);
      jSONObject.put("web_title", str1);
      jSONObject.put("is_multi_process", b.b());
      jSONObject.put("event_tag", this.G);
    } catch (JSONException jSONException) {}
    this.N.a(jSONObject);
    this.a.setWebViewClient((WebViewClient)new c(this, this.e, this.i, this.g, this.N) {
          public void onPageFinished(WebView param1WebView, String param1String) {
            super.onPageFinished(param1WebView, param1String);
            try {
              return;
            } finally {
              param1WebView = null;
            } 
          }
        });
    this.a.getSettings().setUserAgentString(q.a((WebView)this.a, this.f));
    if (Build.VERSION.SDK_INT >= 21)
      this.a.getSettings().setMixedContentMode(0); 
    this.a.loadUrl(this.K);
    this.a.setWebChromeClient((WebChromeClient)new b(this, this.i, this.N) {
          public void onProgressChanged(WebView param1WebView, int param1Int) {
            super.onProgressChanged(param1WebView, param1Int);
            if (TTVideoLandingPageActivity.a(this.a) != null && !this.a.isFinishing()) {
              if (param1Int == 100 && TTVideoLandingPageActivity.a(this.a).isShown()) {
                TTVideoLandingPageActivity.a(this.a).setVisibility(8);
                return;
              } 
              TTVideoLandingPageActivity.a(this.a).setProgress(param1Int);
            } 
          }
        });
    this.a.setDownloadListener(new DownloadListener(this) {
          public void onDownloadStart(String param1String1, String param1String2, String param1String3, String param1String4, long param1Long) {
            a a;
            if (TTVideoLandingPageActivity.b(this.a).containsKey(param1String1)) {
              a = (a)TTVideoLandingPageActivity.b(this.a).get(param1String1);
              if (a != null) {
                a.f();
                return;
              } 
            } else {
              k k = TTVideoLandingPageActivity.c(this.a);
              param1String3 = null;
              param1String2 = param1String3;
              if (k != null)
                if (TTVideoLandingPageActivity.c(this.a).C() == null) {
                  param1String2 = param1String3;
                } else {
                  param1String2 = TTVideoLandingPageActivity.c(this.a).C().a();
                }  
              a a1 = a.a((Context)this.a, (String)a, param1String2);
              TTVideoLandingPageActivity.b(this.a).put(a, a1);
              a1.f();
            } 
          }
        });
    TextView textView = this.d;
    if (textView != null) {
      String str = str1;
      if (TextUtils.isEmpty(str1))
        str = ab.a((Context)this, "tt_web_title_default"); 
      textView.setText(str);
    } 
    a();
    f();
    c();
  }
  
  protected void onDestroy() {
    super.onDestroy();
    b();
    try {
      if (getWindow() != null) {
        ViewGroup viewGroup = (ViewGroup)getWindow().getDecorView();
        if (viewGroup != null)
          viewGroup.removeAllViews(); 
      } 
    } finally {
      Exception exception;
    } 
    aa.a(this.e, (WebView)this.a);
    aa.a((WebView)this.a);
    this.a = null;
    a a1 = this.C;
    if (a1 != null)
      a1.d(); 
    Map<String, a> map = this.D;
    if (map != null) {
      for (Map.Entry<String, a> entry : map.entrySet()) {
        if (entry.getValue() != null)
          ((a)entry.getValue()).d(); 
      } 
      this.D.clear();
    } 
    x x1 = this.i;
    if (x1 != null)
      x1.i(); 
    NativeVideoTsView nativeVideoTsView = this.n;
    if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null)
      this.n.getNativeVideoController().l(); 
    this.n = null;
    this.p = null;
    j j1 = this.N;
    if (j1 != null)
      j1.c(); 
  }
  
  protected void onPause() {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial onPause : ()V
    //   4: aload_0
    //   5: getfield i : Lcom/bytedance/sdk/openadsdk/core/x;
    //   8: astore_1
    //   9: aload_1
    //   10: ifnull -> 17
    //   13: aload_1
    //   14: invokevirtual h : ()V
    //   17: aload_0
    //   18: invokespecial m : ()V
    //   21: aload_0
    //   22: getfield C : Lcom/bytedance/sdk/openadsdk/downloadnew/core/a;
    //   25: astore_1
    //   26: aload_1
    //   27: ifnull -> 36
    //   30: aload_1
    //   31: invokeinterface c : ()V
    //   36: aload_0
    //   37: getfield D : Ljava/util/Map;
    //   40: astore_1
    //   41: aload_1
    //   42: ifnull -> 102
    //   45: aload_1
    //   46: invokeinterface entrySet : ()Ljava/util/Set;
    //   51: invokeinterface iterator : ()Ljava/util/Iterator;
    //   56: astore_1
    //   57: aload_1
    //   58: invokeinterface hasNext : ()Z
    //   63: ifeq -> 102
    //   66: aload_1
    //   67: invokeinterface next : ()Ljava/lang/Object;
    //   72: checkcast java/util/Map$Entry
    //   75: astore_2
    //   76: aload_2
    //   77: invokeinterface getValue : ()Ljava/lang/Object;
    //   82: ifnull -> 57
    //   85: aload_2
    //   86: invokeinterface getValue : ()Ljava/lang/Object;
    //   91: checkcast com/bytedance/sdk/openadsdk/downloadnew/core/a
    //   94: invokeinterface c : ()V
    //   99: goto -> 57
    //   102: aload_0
    //   103: getfield H : Z
    //   106: ifne -> 140
    //   109: aload_0
    //   110: getfield n : Lcom/bytedance/sdk/openadsdk/core/video/nativevideo/NativeVideoTsView;
    //   113: astore_1
    //   114: aload_1
    //   115: ifnull -> 178
    //   118: aload_1
    //   119: invokevirtual getNativeVideoController : ()Lcom/bytedance/sdk/openadsdk/core/video/nativevideo/c;
    //   122: ifnull -> 178
    //   125: aload_0
    //   126: getfield n : Lcom/bytedance/sdk/openadsdk/core/video/nativevideo/NativeVideoTsView;
    //   129: invokevirtual getNativeVideoController : ()Lcom/bytedance/sdk/openadsdk/core/video/nativevideo/c;
    //   132: invokeinterface v : ()Z
    //   137: ifeq -> 178
    //   140: aload_0
    //   141: iconst_1
    //   142: putfield H : Z
    //   145: ldc 'sp_multi_native_video_data'
    //   147: ldc 'key_video_is_update_flag'
    //   149: iconst_1
    //   150: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   153: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V
    //   156: ldc 'sp_multi_native_video_data'
    //   158: ldc 'key_native_video_complete'
    //   160: iconst_1
    //   161: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   164: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V
    //   167: ldc 'sp_multi_native_video_data'
    //   169: ldc 'key_video_isfromvideodetailpage'
    //   171: iconst_1
    //   172: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   175: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V
    //   178: aload_0
    //   179: getfield H : Z
    //   182: ifne -> 212
    //   185: aload_0
    //   186: getfield n : Lcom/bytedance/sdk/openadsdk/core/video/nativevideo/NativeVideoTsView;
    //   189: astore_1
    //   190: aload_1
    //   191: ifnull -> 212
    //   194: aload_1
    //   195: invokevirtual getNativeVideoController : ()Lcom/bytedance/sdk/openadsdk/core/video/nativevideo/c;
    //   198: ifnull -> 212
    //   201: aload_0
    //   202: aload_0
    //   203: getfield n : Lcom/bytedance/sdk/openadsdk/core/video/nativevideo/NativeVideoTsView;
    //   206: invokevirtual getNativeVideoController : ()Lcom/bytedance/sdk/openadsdk/core/video/nativevideo/c;
    //   209: invokespecial a : (Lcom/bytedance/sdk/openadsdk/core/video/nativevideo/c;)V
    //   212: return
  }
  
  protected void onResume() {
    super.onResume();
    this.I = false;
    x x1 = this.i;
    if (x1 != null)
      x1.g(); 
    l();
    a a1 = this.C;
    if (a1 != null)
      a1.b(); 
    Map<String, a> map = this.D;
    if (map != null)
      for (Map.Entry<String, a> entry : map.entrySet()) {
        if (entry.getValue() != null)
          ((a)entry.getValue()).b(); 
      }  
    j j1 = this.N;
    if (j1 != null)
      j1.a(); 
    o();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {
    Bundle bundle = paramBundle;
    if (paramBundle == null)
      bundle = new Bundle(); 
    k k1 = this.p;
    if (k1 != null) {
      String str = k1.ae().toString();
    } else {
      k1 = null;
    } 
    bundle.putString("material_meta", (String)k1);
    bundle.putLong("video_play_position", this.o);
    bundle.putBoolean("is_complete", this.H);
    long l2 = this.o;
    NativeVideoTsView nativeVideoTsView = this.n;
    long l1 = l2;
    if (nativeVideoTsView != null) {
      l1 = l2;
      if (nativeVideoTsView.getNativeVideoController() != null)
        l1 = this.n.getNativeVideoController().m(); 
    } 
    bundle.putLong("video_play_position", l1);
    super.onSaveInstanceState(bundle);
  }
  
  protected void onStop() {
    super.onStop();
    j j1 = this.N;
    if (j1 != null)
      j1.b(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\activity\TTVideoLandingPageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */