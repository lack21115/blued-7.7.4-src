package com.bytedance.sdk.openadsdk.activity;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.ITTAppDownloadListener;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.c.j;
import com.bytedance.sdk.openadsdk.component.reward.top.TopProxyLayout;
import com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialog;
import com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeToast;
import com.bytedance.sdk.openadsdk.core.a.e;
import com.bytedance.sdk.openadsdk.core.aa;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.g.a;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.h.l;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.b.a;
import com.bytedance.sdk.openadsdk.core.video.b.b;
import com.bytedance.sdk.openadsdk.core.video.c.d;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.widget.PlayableLoadingView;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.core.widget.a;
import com.bytedance.sdk.openadsdk.core.widget.c;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.widget.webview.a;
import com.bytedance.sdk.openadsdk.core.widget.webview.b;
import com.bytedance.sdk.openadsdk.core.widget.webview.c;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.downloadnew.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.e.a;
import com.bytedance.sdk.openadsdk.e.c;
import com.bytedance.sdk.openadsdk.e.d;
import com.bytedance.sdk.openadsdk.e.e;
import com.bytedance.sdk.openadsdk.e.f;
import com.bytedance.sdk.openadsdk.f.a;
import com.bytedance.sdk.openadsdk.f.a.d;
import com.bytedance.sdk.openadsdk.g.e;
import com.bytedance.sdk.openadsdk.i.a;
import com.bytedance.sdk.openadsdk.multipro.aidl.a;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.a;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.utils.HomeWatcherReceiver;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.ai;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.t;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public abstract class TTBaseVideoActivity extends Activity implements b, e, HomeWatcherReceiver.a, ak.a {
  protected static RemoteCallbackList<ITTAppDownloadListener> aa;
  
  c A;
  
  a B;
  
  x C;
  
  x D;
  
  HomeWatcherReceiver E;
  
  final ak F;
  
  final Map<String, a> G;
  
  String H;
  
  String I;
  
  int J;
  
  int K;
  
  protected String L;
  
  boolean M;
  
  int N;
  
  int O;
  
  int P;
  
  int Q;
  
  final AtomicBoolean R;
  
  final AtomicBoolean S;
  
  final AtomicBoolean T;
  
  final AtomicBoolean U;
  
  final AtomicBoolean V;
  
  final AtomicBoolean W;
  
  protected final AtomicBoolean X;
  
  protected a Y;
  
  protected final String Z;
  
  PlayableLoadingView a;
  
  View aA;
  
  protected a aB;
  
  protected d aC;
  
  protected c aD;
  
  ProgressBar aE;
  
  private e aF;
  
  private boolean aG;
  
  private f aH;
  
  private boolean aI;
  
  private AtomicBoolean aJ;
  
  private View.OnClickListener aK;
  
  private boolean aL;
  
  private int aM;
  
  protected IListenerManager ab;
  
  protected String ac;
  
  protected boolean ad;
  
  protected boolean ae;
  
  protected int af;
  
  LinearLayout ag;
  
  TTRoundRectImageView ah;
  
  TextView ai;
  
  TTRatingBar aj;
  
  TextView ak;
  
  TextView al;
  
  AtomicBoolean am;
  
  int an;
  
  String ao;
  
  int ap;
  
  boolean aq;
  
  TextView ar;
  
  long as;
  
  int at;
  
  long au;
  
  long av;
  
  AtomicBoolean aw;
  
  String ax;
  
  boolean ay;
  
  protected boolean az;
  
  TopProxyLayout b;
  
  RelativeLayout c;
  
  Context d;
  
  protected SSWebView e;
  
  SSWebView f;
  
  ImageView g;
  
  RelativeLayout h;
  
  TTRoundRectImageView i;
  
  TextView j;
  
  TextView k;
  
  TextView l;
  
  FrameLayout m;
  
  FrameLayout n;
  
  FrameLayout o;
  
  TTRatingBar p;
  
  k q;
  
  j r;
  
  String s;
  
  boolean t;
  
  long u;
  
  String v;
  
  int w;
  
  boolean x;
  
  RewardDislikeDialog y;
  
  RewardDislikeToast z;
  
  public TTBaseVideoActivity() {
    String str;
    this.t = true;
    this.x = false;
    this.F = new ak(Looper.getMainLooper(), this);
    this.G = Collections.synchronizedMap(new HashMap<String, a>());
    this.M = false;
    this.O = 5;
    this.P = 3;
    this.R = new AtomicBoolean(false);
    this.S = new AtomicBoolean(false);
    this.T = new AtomicBoolean(false);
    this.U = new AtomicBoolean(false);
    this.V = new AtomicBoolean(false);
    this.W = new AtomicBoolean(false);
    this.X = new AtomicBoolean(false);
    this.Z = Build.MODEL;
    this.ad = false;
    this.ae = false;
    this.af = 0;
    this.am = new AtomicBoolean(true);
    this.an = 0;
    this.ao = "";
    this.ap = 7;
    this.as = 0L;
    this.at = 0;
    this.au = 0L;
    this.av = 0L;
    this.aw = new AtomicBoolean(false);
    if (this instanceof TTRewardVideoActivity) {
      str = "rewarded_video";
    } else {
      str = "fullscreen_interstitial_ad";
    } 
    this.ax = str;
    this.ay = false;
    this.az = true;
    this.aI = true;
    this.aJ = new AtomicBoolean(false);
    this.aA = null;
    this.aK = new View.OnClickListener(this) {
        public void onClick(View param1View) {
          TTBaseVideoActivity.a(this.a, param1View);
        }
      };
    this.aL = false;
    this.aB = new a(this) {
        public int a() {
          byte b;
          if (this.a.e != null) {
            b = this.a.e.getMeasuredHeight();
          } else {
            b = -1;
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("mWebView>>>>height=");
          stringBuilder.append(b);
          t.c("TTAndroidObject", stringBuilder.toString());
          int i = b;
          if (b <= 0)
            i = ai.d(this.a.d); 
          return i;
        }
        
        public int b() {
          byte b;
          if (this.a.e != null) {
            b = this.a.e.getMeasuredWidth();
          } else {
            b = -1;
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("mWebView>>>>width=");
          stringBuilder.append(b);
          t.c("TTAndroidObject", stringBuilder.toString());
          int i = b;
          if (b <= 0)
            i = ai.c(this.a.d); 
          return i;
        }
      };
    this.aC = new d(this) {
        public void a() {
          TTBaseVideoActivity.d(this.a);
        }
      };
    this.aD = new c(this) {
        public void a() {
          if (this.a.isFinishing())
            return; 
          if (this.a.q != null && !this.a.q.o())
            return; 
          if (this.a.q != null && this.a.q.p()) {
            this.a.F.removeMessages(800);
            this.a.F.sendMessage(TTBaseVideoActivity.a(this.a, 1));
          } 
        }
      };
    this.aM = -1;
  }
  
  private String I() {
    String str2 = o.h().q();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getPlayableLoadH5Url->loadH5Url=");
    stringBuilder.append(str2);
    t.c("Playable", stringBuilder.toString());
    String str1 = str2;
    if (!TextUtils.isEmpty(str2)) {
      k k1 = this.q;
      str1 = str2;
      if (k1 != null) {
        if (k1.N() == null)
          return str2; 
        if (this.O == 15) {
          str1 = "portrait";
        } else {
          str1 = "landscape";
        } 
        String str3 = this.q.N().c();
        int i = this.q.N().e();
        int m = this.q.N().f();
        String str4 = this.q.C().a();
        String str5 = this.q.M();
        String str6 = this.q.N().d();
        String str7 = this.q.N().b();
        String str8 = this.q.N().c();
        String str9 = this.q.J();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("appname=");
        stringBuffer.append(URLEncoder.encode(str3));
        stringBuffer.append("&stars=");
        stringBuffer.append(i);
        stringBuffer.append("&comments=");
        stringBuffer.append(m);
        stringBuffer.append("&icon=");
        stringBuffer.append(URLEncoder.encode(str4));
        stringBuffer.append("&downloading=");
        stringBuffer.append(true);
        stringBuffer.append("&id=");
        stringBuffer.append(URLEncoder.encode(str5));
        stringBuffer.append("&pkg_name=");
        stringBuffer.append(URLEncoder.encode(str6));
        stringBuffer.append("&download_url=");
        stringBuffer.append(URLEncoder.encode(str7));
        stringBuffer.append("&name=");
        stringBuffer.append(URLEncoder.encode(str8));
        stringBuffer.append("&orientation=");
        stringBuffer.append(str1);
        stringBuffer.append("&apptitle=");
        stringBuffer.append(URLEncoder.encode(str9));
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str2);
        stringBuilder1.append("?");
        stringBuilder1.append(stringBuffer.toString());
        str1 = stringBuilder1.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Playable-loadH5Url=");
        stringBuilder2.append(str1);
        t.c("Playable", stringBuilder2.toString());
      } 
    } 
    return str1;
  }
  
  private void J() {
    if (this.aJ.getAndSet(true))
      return; 
    SSWebView sSWebView = this.e;
    if (sSWebView != null && this.f != null) {
      ai.a((View)sSWebView, 0);
      ai.a((View)this.f, 8);
    } 
  }
  
  private void K() {
    this.ag = (LinearLayout)findViewById(ab.e((Context)this, "tt_reward_full_endcard_backup"));
    this.ah = (TTRoundRectImageView)findViewById(ab.e((Context)this, "tt_reward_ad_icon_backup"));
    this.ai = (TextView)findViewById(ab.e((Context)this, "tt_reward_ad_appname_backup"));
    this.aj = (TTRatingBar)findViewById(ab.e((Context)this, "tt_rb_score_backup"));
    this.ak = (TextView)findViewById(ab.e((Context)this, "tt_comment_backup"));
    this.al = (TextView)findViewById(ab.e((Context)this, "tt_reward_ad_download_backup"));
    TTRatingBar tTRatingBar = this.aj;
    if (tTRatingBar != null) {
      tTRatingBar.setStarEmptyNum(1);
      this.aj.setStarFillNum(4);
      this.aj.setStarImageWidth(ai.c((Context)this, 16.0F));
      this.aj.setStarImageHeight(ai.c((Context)this, 16.0F));
      this.aj.setStarImagePadding(ai.c((Context)this, 4.0F));
      this.aj.a();
    } 
  }
  
  private void L() {
    k k1 = this.q;
    if (k1 == null)
      return; 
    int i = ah.d(k1.P());
    String str = ah.h(this.q.P());
    d d1 = d.b().a(this.ap).c(String.valueOf(i)).f(str);
    d1.b(this.an).g(this.ao);
    d1.h(this.q.P()).d(this.q.M());
    a.a().l(d1);
  }
  
  private void M() {
    c c1 = this.A;
    if (c1 != null) {
      if (c1.t() == null)
        return; 
      this.u = this.A.m();
      if (this.A.t().h() || !this.A.t().l()) {
        this.A.h();
        this.A.k();
        this.aL = true;
      } 
    } 
  }
  
  private void O() {
    TopProxyLayout topProxyLayout = this.b;
    if (topProxyLayout != null)
      topProxyLayout.setShowSound(false); 
  }
  
  private void Q() {
    if (o.h().m(String.valueOf(this.Q)) && !this.C.c())
      return; 
    int i = (o.h().r(String.valueOf(this.Q))).g;
    int m = o.h().o(String.valueOf(this.Q));
    if ((1.0F - this.at / m) * 100.0F >= i) {
      i = 1;
    } else {
      i = 0;
    } 
    if (i != 0)
      f(10000); 
  }
  
  private void R() {
    this.z.a("您已成功提交反馈，请勿重复提交哦！");
  }
  
  private void S() {
    this.z.a("感谢您的反馈！\n我们将为您带来更优质的广告体验");
  }
  
  private void a(View paramView) {
    if (paramView == null)
      return; 
    if (paramView.getId() == ab.e((Context)this, "tt_rb_score")) {
      a("click_play_star_level", (JSONObject)null);
      return;
    } 
    if (paramView.getId() == ab.e((Context)this, "tt_comment_vertical")) {
      a("click_play_star_nums", (JSONObject)null);
      return;
    } 
    if (paramView.getId() == ab.e((Context)this, "tt_reward_ad_appname")) {
      a("click_play_source", (JSONObject)null);
      return;
    } 
    if (paramView.getId() == ab.e((Context)this, "tt_reward_ad_icon")) {
      a("click_play_logo", (JSONObject)null);
      return;
    } 
    if (paramView.getId() == ab.e((Context)this, "tt_video_reward_bar") || paramView.getId() == ab.e((Context)this, "tt_click_lower_non_content_layout") || paramView.getId() == ab.e((Context)this, "tt_click_upper_non_content_layout")) {
      a("click_start_play_bar", v());
      return;
    } 
    if (paramView.getId() == ab.e((Context)this, "tt_reward_ad_download")) {
      a("click_start_play", v());
      return;
    } 
    if (paramView.getId() == ab.e((Context)this, "tt_video_reward_container")) {
      a("click_video", v());
      return;
    } 
    if (paramView.getId() == ab.e((Context)this, "tt_reward_ad_download_backup")) {
      a("click_start_play", v());
      return;
    } 
  }
  
  private void a(SSWebView paramSSWebView) {
    if (paramSSWebView == null)
      return; 
    a.a(this.d).a(false).b(false).a((WebView)paramSSWebView);
    paramSSWebView.getSettings().setUserAgentString(q.a((WebView)paramSSWebView, this.K));
    if (Build.VERSION.SDK_INT >= 21)
      paramSSWebView.getSettings().setMixedContentMode(0); 
  }
  
  private void a(String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3) {
    a.a().a(new Runnable(this, paramString1, paramLong1, paramLong2, paramString2, paramString3) {
          public void run() {
            try {
              return;
            } finally {
              Exception exception = null;
              t.c("TTBaseVideoActivity", "executeAppDownloadCallback execute throw Exception : ", exception);
            } 
          }
        }5);
  }
  
  private void a(String paramString1, String paramString2) {
    d.b((Context)this, this.q, paramString1, paramString2, null);
  }
  
  private void a(String paramString, JSONObject paramJSONObject) {
    if (this instanceof TTFullScreenVideoActivity)
      d.a(this.d, this.q, "fullscreen_interstitial_ad", paramString, null); 
    if (this instanceof TTRewardVideoActivity)
      d.a(this.d, this.q, "rewarded_video", paramString, paramJSONObject); 
  }
  
  private Message d(int paramInt) {
    Message message = Message.obtain();
    message.what = 800;
    message.arg1 = paramInt;
    return message;
  }
  
  private void e(boolean paramBoolean) {
    if (!paramBoolean) {
      TTRoundRectImageView tTRoundRectImageView = this.ah;
      if (tTRoundRectImageView != null) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)tTRoundRectImageView.getLayoutParams();
        layoutParams.setMargins(0, (int)ai.a((Context)this, 50.0F), 0, 0);
        this.ah.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      } 
      TextView textView = this.al;
      if (textView != null) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)textView.getLayoutParams();
        layoutParams.setMargins(0, (int)ai.a((Context)this, 35.0F), 0, 0);
        layoutParams.width = (int)ai.a((Context)this, 342.0F);
        this.al.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      } 
    } 
  }
  
  private String f(boolean paramBoolean) {
    k k1 = this.q;
    return (k1 == null) ? null : (paramBoolean ? ((k1.B() != 4) ? "查看" : "下载") : ((k1.B() != 4) ? "View" : "Install"));
  }
  
  protected void A() {
    if (this.S.getAndSet(false))
      return; 
    c c1 = this.A;
    if (c1 != null)
      if (c1.t() != null) {
        d d1 = this.A.t();
        if (d1.i() || d1.j()) {
          ((a)this.A).x();
          a(this.u, true);
          return;
        } 
      } else if (this.aL) {
        ((a)this.A).x();
        a(this.u, true);
        this.aL = false;
      }  
  }
  
  protected void B() {
    ak ak1 = this.F;
    if (ak1 != null)
      ak1.removeMessages(700); 
  }
  
  protected void C() {
    if (this.F != null) {
      Message message = Message.obtain();
      message.what = 700;
      message.arg1 = this.at;
      this.F.sendMessageDelayed(message, 1000L);
    } 
  }
  
  void D() {
    TopProxyLayout topProxyLayout = this.b;
    if (topProxyLayout != null) {
      topProxyLayout.setShowSkip(false);
      this.b.setShowCountDown(false);
      this.b.setShowDislike(false);
    } 
    RewardDislikeToast rewardDislikeToast = this.z;
    if (rewardDislikeToast != null)
      rewardDislikeToast.a(); 
    if (this.R.getAndSet(true))
      return; 
    this.U.set(true);
    if (!this.am.get()) {
      k k2 = this.q;
      if (k2 != null && !k2.q()) {
        ai.a((View)this.e, 8);
        ai.a((View)this.ag, 0);
        ai.a((View)this.g, 0);
        ai.a((View)this.h, 0);
        O();
        L();
        if (this instanceof TTFullScreenVideoActivity && this.A != null && r() && this.U.get()) {
          this.A.i();
          this.A.l();
        } 
        return;
      } 
    } 
    if (Build.VERSION.SDK_INT >= 11) {
      ai.a((View)this.e, 0.0F);
      ai.a((View)this.g, 0.0F);
      ai.a((View)this.h, 0.0F);
    } 
    ai.a((View)this.e, 0);
    k k1 = this.q;
    if (k1 != null && k1.q()) {
      int i = o.h().p(String.valueOf(this.Q));
      if (i == -1) {
        ai.a((View)this.g, 0);
        ai.a((View)this.h, 0);
      } else if (i >= 0) {
        this.F.sendEmptyMessageDelayed(600, i);
      } 
    } else {
      k1 = this.q;
      if (k1 != null && !k1.q()) {
        int i = o.h().l(String.valueOf(this.Q));
        if (i == -1) {
          ai.a((View)this.g, 0);
          ai.a((View)this.h, 0);
        } else if (i >= 0) {
          this.F.sendEmptyMessageDelayed(600, i);
        } 
      } 
    } 
    this.F.sendEmptyMessageDelayed(500, 100L);
    a(this.M, true);
    x x1 = this.C;
    if (x1 != null) {
      x1.b(true);
      b(true);
    } 
    m();
  }
  
  public void E() {
    this.ay = true;
  }
  
  public void F() {
    this.ay = true;
  }
  
  public double G() {
    k k1 = this.q;
    return (k1 != null && k1.z() != null) ? this.q.z().d() : 0.0D;
  }
  
  protected void H() {
    if (isFinishing())
      return; 
    if (this.W.get()) {
      R();
      return;
    } 
    if (this.y == null)
      z(); 
    this.y.a();
  }
  
  protected float a(Activity paramActivity) {
    return ai.b((Context)paramActivity, ai.g((Context)paramActivity));
  }
  
  protected IListenerManager a(int paramInt) {
    return a.asInterface(a.a(o.a()).a(paramInt));
  }
  
  void a() {
    if (this.O == 15) {
      TextView textView = this.j;
      if (textView != null)
        textView.setMaxWidth((int)ai.a((Context)this, 153.0F)); 
    } else {
      TextView textView = this.j;
      if (textView != null)
        textView.setMaxWidth((int)ai.a((Context)this, 404.0F)); 
      e(false);
      b();
    } 
    if (this instanceof TTFullScreenVideoActivity)
      ai.a((View)this.c, 0); 
  }
  
  protected void a(int paramInt1, int paramInt2) {
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("width", paramInt1);
      jSONObject.put("height", paramInt2);
      this.C.a("resize", jSONObject);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  protected void a(Context paramContext) {
    try {
      this.E = new HomeWatcherReceiver();
      this.E.a(this);
      IntentFilter intentFilter = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
      return;
    } finally {
      paramContext = null;
    } 
  }
  
  public void a(Message paramMessage) {
    SSWebView sSWebView;
    if (paramMessage.what == 500) {
      O();
      TopProxyLayout topProxyLayout = this.b;
      if (topProxyLayout != null)
        topProxyLayout.setShowCountDown(false); 
      sSWebView = this.e;
      if (sSWebView != null) {
        ai.a((View)sSWebView, 1.0F);
        ai.a((View)this.g, 1.0F);
        ai.a((View)this.h, 1.0F);
      } 
      if (this instanceof TTFullScreenVideoActivity && this.A != null && r() && this.U.get()) {
        this.A.i();
        this.A.l();
        return;
      } 
    } else {
      TopProxyLayout topProxyLayout;
      if (((Message)sSWebView).what == 600) {
        ai.a((View)this.g, 0);
        ai.a((View)this.h, 0);
        return;
      } 
      if (((Message)sSWebView).what == 700) {
        if (this.q.c() != 1)
          return; 
        int i = ((Message)sSWebView).arg1;
        if (i > 0) {
          TopProxyLayout topProxyLayout1 = this.b;
          if (topProxyLayout1 != null) {
            topProxyLayout1.setShowCountDown(true);
            this.b.a(String.valueOf(i), null);
          } 
          Message message = Message.obtain();
          message.what = 700;
          message.arg1 = --i;
          this.au--;
          this.F.sendMessageDelayed(message, 1000L);
          this.at = i;
        } else {
          topProxyLayout = this.b;
          if (topProxyLayout != null)
            topProxyLayout.setShowCountDown(false); 
          if (this instanceof TTRewardVideoActivity) {
            f(10001);
          } else {
            f(10002);
          } 
        } 
        if (this instanceof TTRewardVideoActivity) {
          Q();
          return;
        } 
      } else if (((Message)topProxyLayout).what == 800) {
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        hashMap.put("remove_loading_page_type", Integer.valueOf(((Message)topProxyLayout).arg1));
        if (this.q.z() != null)
          hashMap.put("playable_url", this.q.z().h()); 
        d.r((Context)this, this.q, this.ax, "remove_loading_page", hashMap);
        this.F.removeMessages(800);
        PlayableLoadingView playableLoadingView = this.a;
        if (playableLoadingView != null)
          playableLoadingView.a(); 
      } 
    } 
  }
  
  protected void a(String paramString) {
    SSWebView sSWebView = this.e;
    if (sSWebView == null)
      return; 
    this.r = (new j((Context)this, this.q, (WebView)sSWebView)).a(true);
    this.r.a(paramString);
    this.e.setWebViewClient((WebViewClient)new c(this, this.d, this.C, this.H, this.r) {
          public void onPageFinished(WebView param1WebView, String param1String) {
            // Byte code:
            //   0: aload_0
            //   1: aload_1
            //   2: aload_2
            //   3: invokespecial onPageFinished : (Landroid/webkit/WebView;Ljava/lang/String;)V
            //   6: aload_0
            //   7: getfield a : Lcom/bytedance/sdk/openadsdk/activity/TTBaseVideoActivity;
            //   10: getfield q : Lcom/bytedance/sdk/openadsdk/core/d/k;
            //   13: invokevirtual r : ()Z
            //   16: ifeq -> 77
            //   19: aload_0
            //   20: getfield a : Lcom/bytedance/sdk/openadsdk/activity/TTBaseVideoActivity;
            //   23: invokevirtual isFinishing : ()Z
            //   26: ifne -> 77
            //   29: aload_0
            //   30: getfield a : Lcom/bytedance/sdk/openadsdk/activity/TTBaseVideoActivity;
            //   33: getfield q : Lcom/bytedance/sdk/openadsdk/core/d/k;
            //   36: invokevirtual o : ()Z
            //   39: ifeq -> 77
            //   42: aload_0
            //   43: getfield a : Lcom/bytedance/sdk/openadsdk/activity/TTBaseVideoActivity;
            //   46: getfield q : Lcom/bytedance/sdk/openadsdk/core/d/k;
            //   49: invokevirtual p : ()Z
            //   52: ifne -> 77
            //   55: aload_0
            //   56: getfield a : Lcom/bytedance/sdk/openadsdk/activity/TTBaseVideoActivity;
            //   59: getfield F : Lcom/bytedance/sdk/openadsdk/utils/ak;
            //   62: aload_0
            //   63: getfield a : Lcom/bytedance/sdk/openadsdk/activity/TTBaseVideoActivity;
            //   66: iconst_0
            //   67: invokestatic a : (Lcom/bytedance/sdk/openadsdk/activity/TTBaseVideoActivity;I)Landroid/os/Message;
            //   70: ldc2_w 1000
            //   73: invokevirtual sendMessageDelayed : (Landroid/os/Message;J)Z
            //   76: pop
            //   77: aload_0
            //   78: getfield a : Lcom/bytedance/sdk/openadsdk/activity/TTBaseVideoActivity;
            //   81: getfield am : Ljava/util/concurrent/atomic/AtomicBoolean;
            //   84: invokevirtual get : ()Z
            //   87: ifeq -> 164
            //   90: aload_0
            //   91: getfield a : Lcom/bytedance/sdk/openadsdk/activity/TTBaseVideoActivity;
            //   94: getfield q : Lcom/bytedance/sdk/openadsdk/core/d/k;
            //   97: invokevirtual c : ()I
            //   100: iconst_1
            //   101: if_icmpne -> 164
            //   104: aload_0
            //   105: getfield a : Lcom/bytedance/sdk/openadsdk/activity/TTBaseVideoActivity;
            //   108: getfield q : Lcom/bytedance/sdk/openadsdk/core/d/k;
            //   111: invokevirtual q : ()Z
            //   114: ifeq -> 164
            //   117: aload_0
            //   118: getfield a : Lcom/bytedance/sdk/openadsdk/activity/TTBaseVideoActivity;
            //   121: invokestatic b : (Lcom/bytedance/sdk/openadsdk/activity/TTBaseVideoActivity;)V
            //   124: aload_0
            //   125: getfield a : Lcom/bytedance/sdk/openadsdk/activity/TTBaseVideoActivity;
            //   128: iconst_1
            //   129: invokevirtual b : (Z)V
            //   132: aload_0
            //   133: getfield b : Lcom/bytedance/sdk/openadsdk/core/x;
            //   136: ifnull -> 148
            //   139: aload_0
            //   140: getfield b : Lcom/bytedance/sdk/openadsdk/core/x;
            //   143: iconst_1
            //   144: invokevirtual b : (Z)Lcom/bytedance/sdk/openadsdk/core/x;
            //   147: pop
            //   148: aload_0
            //   149: getfield a : Lcom/bytedance/sdk/openadsdk/activity/TTBaseVideoActivity;
            //   152: aload_0
            //   153: getfield a : Lcom/bytedance/sdk/openadsdk/activity/TTBaseVideoActivity;
            //   156: getfield ax : Ljava/lang/String;
            //   159: ldc 'py_loading_success'
            //   161: invokestatic a : (Lcom/bytedance/sdk/openadsdk/activity/TTBaseVideoActivity;Ljava/lang/String;Ljava/lang/String;)V
            //   164: return
            //   165: astore_1
            //   166: goto -> 77
            //   169: astore_1
            //   170: return
            // Exception table:
            //   from	to	target	type
            //   6	77	165	finally
            //   77	148	169	finally
            //   148	164	169	finally
          }
          
          public void onPageStarted(WebView param1WebView, String param1String, Bitmap param1Bitmap) {
            super.onPageStarted(param1WebView, param1String, param1Bitmap);
            if (this.a.q != null && this.a.q.q() && this.a.q.c() == 1) {
              HashMap<Object, Object> hashMap;
              boolean bool = this.a instanceof TTRewardVideoActivity;
              int i = o.h().o(String.valueOf(this.a.Q));
              int j = o.h().a(String.valueOf(this.a.Q), bool);
              TTBaseVideoActivity tTBaseVideoActivity = this.a;
              long l = j;
              tTBaseVideoActivity.au = l;
              tTBaseVideoActivity.av = l;
              tTBaseVideoActivity.F.sendEmptyMessageDelayed(600, (j * 1000));
              Message message = Message.obtain();
              message.what = 700;
              message.arg1 = i;
              this.a.F.sendMessage(message);
              this.a.as = System.currentTimeMillis();
              message = null;
              if (!TextUtils.isEmpty(this.a.ac)) {
                hashMap = new HashMap<Object, Object>();
                hashMap.put("rit_scene", this.a.ac);
              } 
              if (bool) {
                d.a(this.c, this.a.q, "rewarded_video", hashMap);
              } else {
                d.a(this.c, this.a.q, "fullscreen_interstitial_ad", hashMap);
              } 
              this.a.N();
              this.a.aw.set(true);
            } 
          }
          
          public void onReceivedError(WebView param1WebView, int param1Int, String param1String1, String param1String2) {
            this.a.am.set(false);
            TTBaseVideoActivity tTBaseVideoActivity = this.a;
            tTBaseVideoActivity.an = param1Int;
            tTBaseVideoActivity.ao = param1String1;
            super.onReceivedError(param1WebView, param1Int, param1String1, param1String2);
          }
          
          public void onReceivedError(WebView param1WebView, WebResourceRequest param1WebResourceRequest, WebResourceError param1WebResourceError) {
            this.a.am.set(false);
            if (param1WebResourceError != null && param1WebResourceError.getDescription() != null) {
              this.a.an = param1WebResourceError.getErrorCode();
              this.a.ao = param1WebResourceError.getDescription().toString();
            } 
            super.onReceivedError(param1WebView, param1WebResourceRequest, param1WebResourceError);
          }
          
          public void onReceivedHttpError(WebView param1WebView, WebResourceRequest param1WebResourceRequest, WebResourceResponse param1WebResourceResponse) {
            if (param1WebResourceRequest != null && param1WebResourceRequest.getUrl() != null && this.a.L.equals(param1WebResourceRequest.getUrl().toString())) {
              this.a.am.set(false);
              if (param1WebResourceResponse != null) {
                this.a.an = param1WebResourceResponse.getStatusCode();
                this.a.ao = "onReceivedHttpError";
              } 
            } 
            super.onReceivedHttpError(param1WebView, param1WebResourceRequest, param1WebResourceResponse);
          }
          
          public WebResourceResponse shouldInterceptRequest(WebView param1WebView, WebResourceRequest param1WebResourceRequest) {
            try {
              return shouldInterceptRequest(param1WebView, param1WebResourceRequest.getUrl().toString());
            } finally {
              Exception exception = null;
              t.c("TTBaseVideoActivity", "shouldInterceptRequest error1", exception);
            } 
          }
          
          public WebResourceResponse shouldInterceptRequest(WebView param1WebView, String param1String) {
            String str;
            if (this.a.q.q()) {
              str = this.a.q.z().h();
              String str1 = this.a.q.z().i();
              return a.a().a(str1, str, param1String);
            } 
            return super.shouldInterceptRequest((WebView)str, param1String);
          }
        });
    a(this.e);
    if (this.q.c() == 1 && this.q.q()) {
      a(this.f);
      e();
    } 
    if (Build.VERSION.SDK_INT >= 19) {
      sSWebView = this.e;
      SSWebView.setWebContentsDebuggingEnabled(this.aq);
      if (this.aq)
        this.e.getSettings().setDomStorageEnabled(true); 
    } 
    f();
    if ("reward_endcard".equals(paramString) || "fullscreen_endcard".equals(paramString)) {
      this.e.setLayerType(1, null);
      this.e.setBackgroundColor(-1);
    } 
    this.e.getSettings().setDisplayZoomControls(false);
    this.e.setWebChromeClient((WebChromeClient)new b(this, this.C, this.r) {
          public void onProgressChanged(WebView param1WebView, int param1Int) {
            super.onProgressChanged(param1WebView, param1Int);
            try {
              return;
            } finally {
              param1WebView = null;
            } 
          }
        });
    this.e.setDownloadListener(new DownloadListener(this) {
          public void onDownloadStart(String param1String1, String param1String2, String param1String3, String param1String4, long param1Long) {
            a a;
            if (this.a.G.containsKey(param1String1)) {
              a = this.a.G.get(param1String1);
              if (a != null)
                a.f(); 
            } else {
              k k = this.a.q;
              param1String3 = null;
              param1String2 = param1String3;
              if (k != null)
                if (this.a.q.C() == null) {
                  param1String2 = param1String3;
                } else {
                  param1String2 = this.a.q.C().a();
                }  
              a a1 = a.a((Context)this.a, (String)a, param1String2);
              this.a.G.put(a, a1);
              a1.f();
            } 
            this.a.P();
          }
        });
  }
  
  protected void a(String paramString1, String paramString2, Map<String, Object> paramMap) {
    c c1 = this.A;
    if (c1 != null) {
      Map map = ah.a(this.q, c1.n(), this.A.t());
      if (paramMap != null)
        for (Map.Entry<String, Object> entry : paramMap.entrySet())
          map.put(entry.getKey(), entry.getValue());  
      d.a(this.d, this.q, paramString1, paramString2, this.A.o(), this.A.q(), map);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("event tag:");
      stringBuilder.append(paramString1);
      stringBuilder.append(", TotalPlayDuration=");
      stringBuilder.append(this.A.o());
      stringBuilder.append(",mBasevideoController.getPct()=");
      stringBuilder.append(this.A.q());
      t.b("TTBaseVideoActivity", stringBuilder.toString());
    } 
  }
  
  protected void a(String paramString, Map<String, Object> paramMap) {
    c c1 = this.A;
    if (c1 != null) {
      Map<String, Integer> map = ah.a(this.q, c1.n(), this.A.t());
      if (paramMap != null)
        for (Map.Entry<String, Object> entry : paramMap.entrySet())
          map.put(entry.getKey(), entry.getValue());  
      map.put("play_type", Integer.valueOf(ah.a(this.A, this.x)));
      d.a(this.d, this.q, paramString, "endcard_skip", this.A.o(), this.A.q(), map);
    } 
  }
  
  protected void a(boolean paramBoolean) {
    TopProxyLayout topProxyLayout = this.b;
    if (topProxyLayout != null)
      topProxyLayout.setSoundMute(paramBoolean); 
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2) {
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("endcard_mute", paramBoolean1);
      jSONObject.put("endcard_show", paramBoolean2);
      this.C.a("endcard_control_event", jSONObject);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  protected float b(Activity paramActivity) {
    return ai.b((Context)paramActivity, ai.h((Context)paramActivity));
  }
  
  protected IListenerManager b(int paramInt) {
    if (this.ab == null)
      this.ab = a.asInterface(a.a(o.a()).a(paramInt)); 
    return this.ab;
  }
  
  void b() {
    if (this.h != null) {
      k k1 = this.q;
      if (k1 != null) {
        if (k1.x() == null)
          return; 
        try {
          FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.h.getLayoutParams();
          layoutParams.rightMargin = ai.c((Context)this, 45.0F);
          this.h.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
          return;
        } catch (Exception exception) {
          return;
        } 
      } 
    } 
  }
  
  protected void b(Context paramContext) {
    try {
      this.E.a(null);
      return;
    } finally {
      paramContext = null;
    } 
  }
  
  protected void b(String paramString) {
    if (this.q.c() == 1 && this.q.q())
      return; 
    boolean bool = a(this.u, false);
    this.S.set(true);
    if (!bool) {
      q();
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("vbtt_skip_type", Integer.valueOf(1));
      a(paramString, (Map)hashMap);
    } 
  }
  
  protected void b(boolean paramBoolean) {
    try {
      boolean bool;
      JSONObject jSONObject = new JSONObject();
      if (paramBoolean) {
        bool = true;
      } else {
        bool = false;
      } 
      jSONObject.put("viewStatus", bool);
      this.C.a("viewableChange", jSONObject);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  void c() {
    this.P = this.q.n();
    if (this.P == -200) {
      l l = o.h();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.Q);
      stringBuilder.append("");
      this.P = l.k(stringBuilder.toString());
    } 
    if (this.P == -1 && this.t)
      ai.a((View)this.c, 0); 
  }
  
  public void c(int paramInt) {
    if (paramInt > 0) {
      if (this.aM > 0) {
        this.aM = paramInt;
        return;
      } 
      t.b("onVolumeChanged", "onVolumeChanged >>>> 变为非静音状态通知 h5");
      c(false);
      this.aM = paramInt;
      return;
    } 
    if (this.aM > 0) {
      t.b("onVolumeChanged", "onVolumeChanged >>>> 变为静音状态通知 h5");
      c(true);
      this.aM = paramInt;
      return;
    } 
    this.aM = paramInt;
  }
  
  void c(String paramString) {
    String str;
    if (!this.ay)
      return; 
    if (this instanceof TTRewardVideoActivity) {
      str = "rewarded_video";
    } else {
      str = "fullscreen_interstitial_ad";
    } 
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("duration", Long.valueOf(System.currentTimeMillis() - this.as));
    d.o((Context)this, this.q, str, paramString, hashMap);
    if ("return_foreground".equals(paramString))
      this.ay = false; 
  }
  
  protected void c(boolean paramBoolean) {
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("endcard_mute", paramBoolean);
      this.C.a("volumeChange", jSONObject);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  protected void d() {
    this.a = (PlayableLoadingView)findViewById(ab.e((Context)this, "tt_reward_playable_loading"));
    this.b = (TopProxyLayout)findViewById(ab.e((Context)this, "tt_top_layout_proxy"));
    TopProxyLayout topProxyLayout = this.b;
    if (topProxyLayout != null)
      topProxyLayout.a(this instanceof TTRewardVideoActivity, this.q); 
    this.f = (SSWebView)findViewById(ab.e((Context)this, "tt_browser_webview_loading"));
    this.e = (SSWebView)findViewById(ab.e((Context)this, "tt_reward_browser_webview"));
    this.h = (RelativeLayout)findViewById(ab.e((Context)this, "tt_video_ad_close_layout"));
    this.g = (ImageView)findViewById(ab.e((Context)this, "tt_video_ad_close"));
    this.ar = (TextView)findViewById(ab.e((Context)this, "tt_ad_logo"));
    this.m = (FrameLayout)findViewById(ab.e((Context)this, "tt_video_reward_container"));
    this.n = (FrameLayout)findViewById(ab.e((Context)this, "tt_click_upper_non_content_layout"));
    this.o = (FrameLayout)findViewById(ab.e((Context)this, "tt_click_lower_non_content_layout"));
    this.ag = (LinearLayout)findViewById(ab.e((Context)this, "tt_reward_full_endcard_backup"));
    this.l = (TextView)findViewById(ab.e((Context)this, "tt_reward_ad_download"));
    this.c = (RelativeLayout)findViewById(ab.e((Context)this, "tt_video_reward_bar"));
    this.i = (TTRoundRectImageView)findViewById(ab.e((Context)this, "tt_reward_ad_icon"));
    this.j = (TextView)findViewById(ab.e((Context)this, "tt_reward_ad_appname"));
    this.k = (TextView)findViewById(ab.e((Context)this, "tt_comment_vertical"));
    this.p = (TTRatingBar)findViewById(ab.e((Context)this, "tt_rb_score"));
    TTRatingBar tTRatingBar = this.p;
    if (tTRatingBar != null) {
      tTRatingBar.setStarEmptyNum(1);
      this.p.setStarFillNum(4);
      this.p.setStarImageWidth(ai.c((Context)this, 15.0F));
      this.p.setStarImageHeight(ai.c((Context)this, 14.0F));
      this.p.setStarImagePadding(ai.c((Context)this, 4.0F));
      this.p.a();
    } 
    k k1 = this.q;
    if (k1 != null && k1.q()) {
      this.e.setBackgroundColor(-16777216);
      this.f.setBackgroundColor(-16777216);
      if (this.q.c() == 1) {
        ai.a((View)this.m, 8);
        ai.a((View)this.n, 8);
        ai.a((View)this.o, 8);
        ai.a((View)this.c, 8);
        ai.a((View)this.j, 8);
        ai.a((View)this.i, 8);
        ai.a((View)this.k, 8);
        ai.a((View)this.p, 8);
        ai.a((View)this.g, 8);
        ai.a((View)this.h, 8);
        ai.a((View)this.e, 4);
        ai.a((View)this.f, 0);
        ai.a((View)this.l, 8);
        ai.a((View)this.ar, 8);
        TopProxyLayout topProxyLayout1 = this.b;
        if (topProxyLayout1 != null)
          topProxyLayout1.setShowSound(false); 
      } 
    } 
    SSWebView sSWebView = this.e;
    if (sSWebView != null)
      sSWebView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) {
            public void onGlobalLayout() {
              if (Build.VERSION.SDK_INT >= 16) {
                this.a.e.getViewTreeObserver().removeOnGlobalLayoutListener(this);
              } else {
                this.a.e.getViewTreeObserver().removeGlobalOnLayoutListener(this);
              } 
              int i = this.a.e.getMeasuredWidth();
              int j = this.a.e.getMeasuredHeight();
              if (this.a.e.getVisibility() == 0)
                this.a.a(i, j); 
            }
          }); 
    K();
    if (!this.t)
      ai.a((View)this.c, 4); 
    try {
      if (this.ad && this.q != null && this.q.Q() == 5) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)this.l.getLayoutParams();
        layoutParams.height = (int)ai.a((Context)this, 55.0F);
        layoutParams.topMargin = (int)ai.a((Context)this, 20.0F);
        this.l.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        layoutParams = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
        layoutParams.bottomMargin = (int)ai.a((Context)this, 12.0F);
        this.c.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      } 
    } finally {}
    if (this.q != null && this.ad && this.m != null) {
      int i = ai.c((Context)this);
      RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)this.m.getLayoutParams();
      layoutParams.width = i;
      i = i * 9 / 16;
      layoutParams.height = i;
      this.m.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      this.af = (ai.d((Context)this) - i) / 2;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("NonContentAreaHeight:");
      stringBuilder.append(this.af);
      t.e("TTBaseVideoActivity", stringBuilder.toString());
    } 
  }
  
  protected void d(boolean paramBoolean) {
    if (this.aE == null) {
      this.aE = new ProgressBar((Context)this);
      FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(120, 120);
      layoutParams.gravity = 17;
      this.aE.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      Drawable drawable = getResources().getDrawable(ab.d((Context)this, "tt_video_loading_progress_bar"));
      this.aE.setIndeterminateDrawable(drawable);
      this.m.addView((View)this.aE);
    } 
    if (paramBoolean) {
      this.aE.setVisibility(0);
      return;
    } 
    this.aE.setVisibility(8);
  }
  
  protected boolean e() {
    if (this.f == null)
      return false; 
    String str = I();
    if (TextUtils.isEmpty(str))
      return false; 
    this.f.setWebViewClient((WebViewClient)new c(this, this.d, this.D, this.q.M(), null) {
          public void onPageFinished(WebView param1WebView, String param1String) {
            if (TTBaseVideoActivity.a(this.a)) {
              TTBaseVideoActivity tTBaseVideoActivity = this.a;
              TTBaseVideoActivity.a(tTBaseVideoActivity, tTBaseVideoActivity.ax, "loading_h5_success");
            } 
            super.onPageFinished(param1WebView, param1String);
          }
          
          public void onReceivedError(WebView param1WebView, int param1Int, String param1String1, String param1String2) {
            super.onReceivedError(param1WebView, param1Int, param1String1, param1String2);
            TTBaseVideoActivity.a(this.a, false);
          }
          
          public void onReceivedError(WebView param1WebView, WebResourceRequest param1WebResourceRequest, WebResourceError param1WebResourceError) {
            super.onReceivedError(param1WebView, param1WebResourceRequest, param1WebResourceError);
            TTBaseVideoActivity.a(this.a, false);
          }
          
          public void onReceivedHttpError(WebView param1WebView, WebResourceRequest param1WebResourceRequest, WebResourceResponse param1WebResourceResponse) {
            super.onReceivedHttpError(param1WebView, param1WebResourceRequest, param1WebResourceResponse);
            TTBaseVideoActivity.a(this.a, false);
          }
        });
    this.f.loadUrl(str);
    this.f.getSettings().setDisplayZoomControls(false);
    this.f.setWebChromeClient((WebChromeClient)new b(this.D, this.r));
    this.f.setDownloadListener(new DownloadListener(this) {
          public void onDownloadStart(String param1String1, String param1String2, String param1String3, String param1String4, long param1Long) {
            a a;
            if (this.a.G.containsKey(param1String1)) {
              a = this.a.G.get(param1String1);
              if (a != null)
                a.f(); 
            } else {
              k k = this.a.q;
              param1String3 = null;
              param1String2 = param1String3;
              if (k != null)
                if (this.a.q.C() == null) {
                  param1String2 = param1String3;
                } else {
                  param1String2 = this.a.q.C().a();
                }  
              a a1 = a.a((Context)this.a, (String)a, param1String2);
              this.a.G.put(a, a1);
              a1.f();
            } 
            this.a.P();
          }
        });
    return true;
  }
  
  protected void f() {
    if (this.az)
      this.e.loadUrl(this.L); 
  }
  
  protected void g() {
    TextView textView = this.l;
    if (textView != null) {
      String str;
      if (this.ae) {
        str = x();
      } else {
        str = w();
      } 
      textView.setText(str);
    } 
  }
  
  protected void h() {
    if (this.k == null)
      return; 
    int i = 6870;
    if (this.q.N() != null)
      i = this.q.N().f(); 
    String str2 = ab.a((Context)this, "tt_comment_num");
    if (i > 10000) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(i / 10000);
      stringBuilder.append("万");
      str1 = stringBuilder.toString();
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(i);
      stringBuilder.append("");
      str1 = stringBuilder.toString();
    } 
    String str1 = String.format(str2, new Object[] { str1 });
    this.k.setText(str1);
  }
  
  protected void i() {
    if (this.i != null)
      if (this.q.C() != null && !TextUtils.isEmpty(this.q.C().a())) {
        e.a(this.d).a(this.q.C().a(), (ImageView)this.i);
      } else {
        this.i.setImageResource(ab.d((Context)this, "tt_ad_logo_small"));
      }  
    if (this.j != null) {
      if (this.O == 15 && this.q.N() != null && !TextUtils.isEmpty(this.q.N().c())) {
        this.j.setText(this.q.N().c());
        return;
      } 
      this.j.setText(this.q.J());
    } 
  }
  
  protected void j() {
    String str;
    if (this.q.z() != null) {
      str = this.q.z().h();
    } else {
      str = null;
    } 
    this.L = str;
    if (!TextUtils.isEmpty(this.L) && this.O == 15) {
      if (this.L.contains("?")) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(this.L);
        stringBuilder1.append("&orientation=portrait");
        this.L = stringBuilder1.toString();
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.L);
      stringBuilder.append("?orientation=portrait");
      this.L = stringBuilder.toString();
    } 
  }
  
  protected void k() {
    if (this.a == null)
      return; 
    k k1 = this.q;
    if (k1 == null || !k1.o() || !this.q.r()) {
      this.a.a();
      return;
    } 
    this.a.b();
    k1 = this.q;
    if (k1 != null && k1.r() && this.q.p())
      this.F.sendMessageDelayed(d(2), 10000L); 
  }
  
  protected void l() {
    if (this.q.q() && this.q.c() == 1) {
      TextView textView1 = this.ar;
      if (textView1 != null)
        ai.a((View)textView1, 8); 
      return;
    } 
    TextView textView = this.ar;
    if (textView != null)
      ai.a((View)textView, 0); 
  }
  
  protected void m() {
    TextView textView = this.ar;
    if (textView != null)
      ai.a((View)textView, 8); 
  }
  
  protected void n() {
    if (this.ah != null)
      if (this.q.C() != null && !TextUtils.isEmpty(this.q.C().a())) {
        e.a(this.d).a(this.q.C().a(), (ImageView)this.ah);
      } else {
        this.ah.setImageResource(ab.d((Context)this, "tt_ad_logo_small"));
      }  
    if (this.ai != null)
      if (this.q.N() != null && !TextUtils.isEmpty(this.q.N().c())) {
        this.ai.setText(this.q.N().c());
      } else {
        this.ai.setText(this.q.J());
      }  
    if (this.ak != null) {
      int i = 6870;
      if (this.q.N() != null)
        i = this.q.N().f(); 
      String str2 = ab.a((Context)this, "tt_comment_num_backup");
      if (i > 10000) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i / 10000);
        stringBuilder.append("万");
        str1 = stringBuilder.toString();
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append("");
        str1 = stringBuilder.toString();
      } 
      String str1 = String.format(str2, new Object[] { str1 });
      this.ak.setText(str1);
    } 
    TextView textView = this.al;
    if (textView != null)
      textView.setText(w()); 
  }
  
  protected void o() {
    if (this.c == null)
      return; 
    Keyframe keyframe1 = Keyframe.ofFloat(0.0F, 0.0F);
    Keyframe keyframe2 = Keyframe.ofFloat(0.65F, 1.0F);
    Keyframe keyframe3 = Keyframe.ofFloat(0.765F, 0.9F);
    Keyframe keyframe4 = Keyframe.ofFloat(0.88F, 1.0F);
    Keyframe keyframe5 = Keyframe.ofFloat(0.95F, 0.95F);
    Keyframe keyframe6 = Keyframe.ofFloat(1.0F, 1.0F);
    PropertyValuesHolder propertyValuesHolder1 = PropertyValuesHolder.ofKeyframe("scaleX", new Keyframe[] { keyframe1, keyframe2, keyframe3, keyframe4, keyframe5, keyframe6 });
    PropertyValuesHolder propertyValuesHolder2 = PropertyValuesHolder.ofKeyframe("scaleY", new Keyframe[] { keyframe1, keyframe2, keyframe3, keyframe4, keyframe5, keyframe6 });
    ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(this.c, new PropertyValuesHolder[] { propertyValuesHolder1, propertyValuesHolder2 });
    objectAnimator.setDuration(1000L);
    objectAnimator.start();
  }
  
  public void onBackPressed() {}
  
  protected void onCreate(Bundle paramBundle) {
    if (paramBundle != null)
      this.aG = paramBundle.getBoolean("is_bar_click_first"); 
    super.onCreate(paramBundle);
    if (h.c().l())
      getWindow().addFlags(2621440); 
    try {
      requestWindowFeature(1);
      getWindow().addFlags(1024);
      getWindow().addFlags(16777216);
    } finally {
      Exception exception;
    } 
    try {
      o.a((Context)this);
    } finally {
      Exception exception;
    } 
    if (paramBundle != null && paramBundle.getLong("video_current") > 0L)
      this.u = paramBundle.getLong("video_current", 0L); 
    this.d = (Context)this;
    this.aH = new f(getApplicationContext());
    this.aH.a(this);
    this.aM = this.aH.c();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onCreate >>>>>> mVolume = ");
    stringBuilder.append(this.aM);
    t.b("onVolumeChanged", stringBuilder.toString());
  }
  
  protected void onDestroy() {
    super.onDestroy();
    RewardDislikeToast rewardDislikeToast = this.z;
    if (rewardDislikeToast != null)
      rewardDislikeToast.b(); 
    ak ak1 = this.F;
    if (ak1 != null)
      ak1.removeCallbacksAndMessages(null); 
    aa.a(this.d, (WebView)this.e);
    aa.a((WebView)this.e);
    c c1 = this.A;
    if (c1 != null) {
      c1.k();
      this.A = null;
    } 
    this.e = null;
    x x1 = this.C;
    if (x1 != null)
      x1.i(); 
    a a1 = this.B;
    if (a1 != null)
      a1.d(); 
    j j1 = this.r;
    if (j1 != null)
      j1.c(); 
    f f1 = this.aH;
    if (f1 != null) {
      f1.b();
      this.aH.a(null);
    } 
    b(getApplicationContext());
    if (b.b())
      try {
        return;
      } finally {
        f1 = null;
      }  
  }
  
  protected void onPause() {
    super.onPause();
    if (Build.VERSION.SDK_INT >= 26 || "C8817D".equals(this.Z) || "M5".equals(this.Z) || "R7t".equals(this.Z)) {
      M();
    } else {
      try {
        if (r() && !this.V.get())
          this.A.h(); 
      } finally {
        Exception exception = null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onPause throw Exception :");
        stringBuilder.append(exception.getMessage());
      } 
    } 
    x x1 = this.C;
    if (x1 != null) {
      x1.h();
      this.C.b(false);
      b(false);
      a(true, false);
    } 
    a a1 = this.B;
    if (a1 != null)
      a1.c(); 
  }
  
  protected void onResume() {
    if (this.O == 15) {
      setRequestedOrientation(1);
    } else {
      setRequestedOrientation(0);
    } 
    super.onResume();
    f f1 = this.aH;
    if (f1 != null) {
      f1.a(this);
      this.aH.a();
    } 
    if (!this.R.get())
      if (Build.VERSION.SDK_INT >= 26 || "C8817D".equals(this.Z) || "M5".equals(this.Z) || "R7t".equals(this.Z)) {
        A();
      } else if (s() && !this.V.get()) {
        this.A.j();
      }  
    x x1 = this.C;
    if (x1 != null) {
      x1.g();
      SSWebView sSWebView = this.e;
      if (sSWebView != null)
        if (sSWebView.getVisibility() == 0) {
          this.C.b(true);
          b(true);
          a(false, true);
        } else {
          this.C.b(false);
          b(false);
          a(true, false);
        }  
    } 
    a a1 = this.B;
    if (a1 != null) {
      a1.a(this);
      this.B.b();
    } 
    j j1 = this.r;
    if (j1 != null)
      j1.a(); 
    if (this.aw.get()) {
      k k1 = this.q;
      if (k1 != null && k1.c() == 1 && this.q.q()) {
        c("return_foreground");
        this.F.sendEmptyMessageDelayed(600, this.au * 1000L);
        Message message = Message.obtain();
        message.what = 700;
        message.arg1 = this.at;
        this.F.sendMessage(message);
      } 
    } 
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {
    Bundle bundle = paramBundle;
    if (paramBundle == null)
      bundle = new Bundle(); 
    try {
      long l;
      if (this.q != null) {
        String str = this.q.ae().toString();
      } else {
        paramBundle = null;
      } 
      bundle.putString("material_meta", (String)paramBundle);
      bundle.putString("multi_process_meta_md5", this.s);
      if (this.A == null) {
        l = this.u;
      } else {
        l = this.A.m();
      } 
      bundle.putLong("video_current", l);
      bundle.putString("video_cache_url", this.v);
      bundle.putInt("orientation", this.w);
      bundle.putBoolean("is_mute", this.M);
      bundle.putBoolean("is_bar_click_first", this.aG);
    } finally {}
    super.onSaveInstanceState(bundle);
  }
  
  protected void onStop() {
    super.onStop();
    j j1 = this.r;
    if (j1 != null)
      j1.b(); 
    k k1 = this.q;
    if (k1 != null && k1.c() == 1 && this.q.q()) {
      this.F.removeMessages(700);
      this.F.removeMessages(600);
      c("go_background");
    } 
  }
  
  void p() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (!TextUtils.isEmpty(this.ac))
      hashMap.put("rit_scene", this.ac); 
    this.C = new x(this.d);
    this.C.a((WebView)this.e).a(this.q).a(this.H).b(this.I).a(this.J).a(this.aq).a(this.aB).a(this.aC).a(this.aD).c(ah.g(this.q)).a(hashMap);
    this.D = new x((Context)this);
    this.D.a((WebView)this.f).a(this.q).a(this.H).b(this.I).a(this.J).c(ah.g(this.q));
  }
  
  void q() {
    if (Build.VERSION.SDK_INT >= 17 && isDestroyed())
      return; 
    if (isFinishing())
      return; 
    a a1 = this.Y;
    if (a1 != null && a1.isShowing())
      this.Y.dismiss(); 
    RewardDislikeToast rewardDislikeToast = this.z;
    if (rewardDislikeToast != null)
      rewardDislikeToast.a(); 
    TopProxyLayout topProxyLayout = this.b;
    if (topProxyLayout != null) {
      topProxyLayout.setShowSkip(false);
      this.b.setShowCountDown(false);
      this.b.setShowDislike(false);
    } 
    if (this.R.getAndSet(true))
      return; 
    if (!this.am.get()) {
      k k2 = this.q;
      if (k2 != null && !k2.q()) {
        ai.a((View)this.e, 8);
        ai.a((View)this.ag, 0);
        ai.a((View)this.g, 0);
        ai.a((View)this.h, 0);
        O();
        L();
        return;
      } 
    } 
    ai.a((View)this.e, 0.0F);
    ai.a((View)this.g, 0.0F);
    ai.a((View)this.h, 0.0F);
    ai.a((View)this.e, 0);
    k k1 = this.q;
    if (k1 != null && k1.q()) {
      int i = o.h().p(String.valueOf(this.Q));
      if (i == -1) {
        ai.a((View)this.g, 0);
        ai.a((View)this.h, 0);
      } else if (i >= 0) {
        this.F.sendEmptyMessageDelayed(600, i);
      } 
    } else {
      k1 = this.q;
      if (k1 != null && !k1.q()) {
        int i = o.h().l(String.valueOf(this.Q));
        if (i == -1) {
          ai.a((View)this.g, 0);
          ai.a((View)this.h, 0);
        } else if (i >= 0) {
          this.F.sendEmptyMessageDelayed(600, i);
        } 
      } 
    } 
    this.F.sendEmptyMessageDelayed(500, 20L);
    a(this.M, true);
    b(true);
    m();
    x x1 = this.C;
    if (x1 != null)
      x1.b(true); 
  }
  
  boolean r() {
    c c1 = this.A;
    return (c1 != null && c1.t() != null && this.A.t().g());
  }
  
  protected boolean s() {
    c c1 = this.A;
    return (c1 != null && c1.t() != null && this.A.t().i());
  }
  
  protected boolean t() {
    c c1 = this.A;
    return (c1 != null && c1.w());
  }
  
  void u() {
    String str;
    if (this.q == null)
      return; 
    if (this instanceof TTRewardVideoActivity) {
      str = "rewarded_video";
    } else {
      str = "fullscreen_interstitial_ad";
    } 
    this.aF = new e(this, (Context)this, this.q, str, this.J, str) {
        public void a_(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
          boolean bool;
          this.b.a(param1View, param1Int1, param1Int2, param1Int3, param1Int4);
          TTBaseVideoActivity tTBaseVideoActivity = this.b;
          if (param1View.getId() == ab.e((Context)this.b, "tt_video_reward_bar")) {
            bool = true;
          } else {
            bool = false;
          } 
          TTBaseVideoActivity.b(tTBaseVideoActivity, bool);
          this.b.aA = param1View;
          if (param1View.getId() == ab.e((Context)this.b, "tt_playable_play") && this.b.q.r()) {
            HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
            if (this.b.q.z() != null)
              hashMap.put("playable_url", this.b.q.z().h()); 
            TTBaseVideoActivity tTBaseVideoActivity1 = this.b;
            d.r((Context)tTBaseVideoActivity1, tTBaseVideoActivity1.q, this.a, "click_playable_download_button_loading", hashMap);
          } 
          if (this.b.B == null) {
            TTBaseVideoActivity.a(this.b, param1View);
            return;
          } 
          if (param1View.getId() == ab.e((Context)this.b, "tt_rb_score")) {
            TTBaseVideoActivity.a(this.b, "click_play_star_level", (JSONObject)null);
            return;
          } 
          if (param1View.getId() == ab.e((Context)this.b, "tt_comment_vertical")) {
            TTBaseVideoActivity.a(this.b, "click_play_star_nums", (JSONObject)null);
            return;
          } 
          if (param1View.getId() == ab.e((Context)this.b, "tt_reward_ad_appname")) {
            TTBaseVideoActivity.a(this.b, "click_play_source", (JSONObject)null);
            return;
          } 
          if (param1View.getId() == ab.e((Context)this.b, "tt_reward_ad_icon"))
            TTBaseVideoActivity.a(this.b, "click_play_logo", (JSONObject)null); 
        }
      };
    this.aF.a((View)this.c);
    if (!TextUtils.isEmpty(this.ac)) {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("rit_scene", this.ac);
      this.aF.a(hashMap);
    } 
    a a1 = this.B;
    if (a1 != null) {
      this.aF.a(a1);
      this.B.a(1, new a.a(this) {
            public boolean a(int param1Int, k param1k, String param1String1, String param1String2, Object param1Object) {
              if (param1Int != 1)
                return true; 
              if (param1k != null && !TextUtils.isEmpty(param1String1)) {
                if (TextUtils.isEmpty(param1String2))
                  return true; 
                if (param1String1.equals("rewarded_video") && param1String2.equals("click_start")) {
                  TTBaseVideoActivity tTBaseVideoActivity = this.a;
                  TTBaseVideoActivity.a(tTBaseVideoActivity, tTBaseVideoActivity.aA);
                  this.a.aA = null;
                  return false;
                } 
                if (param1String1.equals("fullscreen_interstitial_ad") && param1String2.equals("click_start")) {
                  TTBaseVideoActivity tTBaseVideoActivity = this.a;
                  TTBaseVideoActivity.a(tTBaseVideoActivity, tTBaseVideoActivity.aA);
                  this.a.aA = null;
                  return false;
                } 
                if (param1String1.equals("fullscreen_interstitial_ad") || param1String1.equals("rewarded_video")) {
                  param1Int = -1;
                  int i = param1String2.hashCode();
                  if (i != -1297985154) {
                    if (i != -777040223) {
                      if (i == 1682049151 && param1String2.equals("click_pause"))
                        param1Int = 0; 
                    } else if (param1String2.equals("click_open")) {
                      param1Int = 2;
                    } 
                  } else if (param1String2.equals("click_continue")) {
                    param1Int = 1;
                  } 
                  if (param1Int != 0) {
                    if (param1Int != 1) {
                      if (param1Int == 2) {
                        d.p(this.a.d, this.a.q, param1String1, "click_play_open", null);
                        return false;
                      } 
                      return true;
                    } 
                    TTBaseVideoActivity tTBaseVideoActivity1 = this.a;
                    d.a((Context)tTBaseVideoActivity1, tTBaseVideoActivity1.q, param1String1, "click_play_continue", null);
                    return false;
                  } 
                  TTBaseVideoActivity tTBaseVideoActivity = this.a;
                  d.a((Context)tTBaseVideoActivity, tTBaseVideoActivity.q, param1String1, "click_play_pause", null);
                  return false;
                } 
                if (param1String1.equals("rewarded_video_landingpage") && "click_open".equals(param1String2) && this.a.q.q() && this.a.q.c() == 1) {
                  d.p(this.a.d, this.a.q, param1String1, "click_play_open", null);
                  return false;
                } 
                return true;
              } 
              return true;
            }
          });
    } 
    PlayableLoadingView playableLoadingView = this.a;
    if (playableLoadingView != null && playableLoadingView.getPlayView() != null) {
      k k2 = this.q;
      if (k2 != null && k2.r()) {
        this.a.getPlayView().setOnClickListener((View.OnClickListener)this.aF);
        this.a.getPlayView().setOnTouchListener((View.OnTouchListener)this.aF);
      } 
    } 
    k k1 = this.q;
    if (k1 != null && k1.i() != null) {
      if ((this.q.i()).e) {
        this.l.setOnClickListener((View.OnClickListener)this.aF);
        this.l.setOnTouchListener((View.OnTouchListener)this.aF);
      } else {
        this.l.setOnClickListener(this.aK);
      } 
      if (this.ad) {
        if ((this.q.i()).a) {
          ai.a((View)this.c, (View.OnClickListener)this.aF, "TTBaseVideoActivity#mRlDownloadBar");
          ai.a((View)this.c, (View.OnTouchListener)this.aF, "TTBaseVideoActivity#mRlDownloadBar");
          this.j.setOnClickListener((View.OnClickListener)this.aF);
          this.j.setOnTouchListener((View.OnTouchListener)this.aF);
          this.k.setOnClickListener((View.OnClickListener)this.aF);
          this.k.setOnTouchListener((View.OnTouchListener)this.aF);
          this.p.setOnClickListener((View.OnClickListener)this.aF);
          this.p.setOnTouchListener((View.OnTouchListener)this.aF);
          this.i.setOnClickListener((View.OnClickListener)this.aF);
          this.i.setOnTouchListener((View.OnTouchListener)this.aF);
        } else {
          ai.a((View)this.c, this.aK, "TTBaseVideoActivity#mRlDownloadBar");
          this.j.setOnClickListener(this.aK);
          this.k.setOnClickListener(this.aK);
          this.p.setOnClickListener(this.aK);
          this.i.setOnClickListener(this.aK);
        } 
      } else if ((this.q.i()).c) {
        ai.a((View)this.c, (View.OnClickListener)this.aF, "TTBaseVideoActivity#mRlDownloadBar");
        ai.a((View)this.c, (View.OnTouchListener)this.aF, "TTBaseVideoActivity#mRlDownloadBar");
      } else {
        ai.a((View)this.c, this.aK, "TTBaseVideoActivity#mRlDownloadBar");
      } 
    } 
    if (this.m != null) {
      k1 = this.q;
      if (k1 != null && k1.i() != null)
        if ((this.q.i()).f) {
          this.m.setOnClickListener((View.OnClickListener)this.aF);
        } else {
          this.m.setOnClickListener(new View.OnClickListener(this) {
                public void onClick(View param1View) {
                  TTBaseVideoActivity.a(this.a, param1View);
                }
              });
        }  
    } 
    if (this.ad) {
      if (this.q.i() != null) {
        FrameLayout frameLayout = this.n;
        if (frameLayout != null) {
          ai.a((View)frameLayout, 0);
          RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)this.n.getLayoutParams();
          layoutParams.height = this.af;
          this.n.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
          if ((this.q.i()).b) {
            this.n.setOnClickListener((View.OnClickListener)this.aF);
            this.n.setOnTouchListener((View.OnTouchListener)this.aF);
          } else {
            this.n.setOnClickListener(this.aK);
          } 
        } 
      } 
      if (this.q.i() != null) {
        FrameLayout frameLayout = this.o;
        if (frameLayout != null) {
          ai.a((View)frameLayout, 0);
          RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)this.o.getLayoutParams();
          layoutParams.height = this.af;
          this.o.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
          if ((this.q.i()).d) {
            this.o.setOnClickListener((View.OnClickListener)this.aF);
            this.o.setOnTouchListener((View.OnTouchListener)this.aF);
          } else {
            this.o.setOnClickListener(this.aK);
          } 
        } 
      } 
    } 
    ai.a((View)this.ag, new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        },  "TTBaseVideoActivity#mLLEndCardBackup");
    this.al.setOnClickListener((View.OnClickListener)this.aF);
    this.al.setOnTouchListener((View.OnTouchListener)this.aF);
  }
  
  protected JSONObject v() {
    try {
      boolean bool;
      long l;
      if (this.A != null) {
        l = this.A.p();
        bool = this.A.q();
      } else {
        l = 0L;
        bool = false;
      } 
      JSONObject jSONObject = new JSONObject();
      return jSONObject;
    } finally {
      Exception exception = null;
    } 
  }
  
  protected String w() {
    k k1 = this.q;
    String str = "立即下载";
    if (k1 == null)
      return "立即下载"; 
    if (TextUtils.isEmpty(k1.L())) {
      if (this.q.B() != 4)
        return "查看详情"; 
    } else {
      str = this.q.L();
    } 
    return str;
  }
  
  protected String x() {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic b : (Landroid/content/Context;)Ljava/lang/String;
    //   4: astore #4
    //   6: aload #4
    //   8: astore_3
    //   9: aload #4
    //   11: ifnonnull -> 17
    //   14: ldc ''
    //   16: astore_3
    //   17: aload_3
    //   18: getstatic java/util/Locale.CHINESE : Ljava/util/Locale;
    //   21: invokevirtual getLanguage : ()Ljava/lang/String;
    //   24: invokevirtual equals : (Ljava/lang/Object;)Z
    //   27: ifne -> 66
    //   30: aload_3
    //   31: getstatic java/util/Locale.CHINA : Ljava/util/Locale;
    //   34: invokevirtual getLanguage : ()Ljava/lang/String;
    //   37: invokevirtual equals : (Ljava/lang/Object;)Z
    //   40: ifne -> 66
    //   43: aload_3
    //   44: getstatic java/util/Locale.TRADITIONAL_CHINESE : Ljava/util/Locale;
    //   47: invokevirtual getLanguage : ()Ljava/lang/String;
    //   50: invokevirtual equals : (Ljava/lang/Object;)Z
    //   53: istore_2
    //   54: iload_2
    //   55: ifeq -> 61
    //   58: goto -> 66
    //   61: iconst_0
    //   62: istore_1
    //   63: goto -> 68
    //   66: iconst_1
    //   67: istore_1
    //   68: aload_3
    //   69: getstatic java/util/Locale.ENGLISH : Ljava/util/Locale;
    //   72: invokevirtual getLanguage : ()Ljava/lang/String;
    //   75: invokevirtual equals : (Ljava/lang/Object;)Z
    //   78: istore_2
    //   79: goto -> 86
    //   82: iconst_1
    //   83: istore_1
    //   84: iconst_0
    //   85: istore_2
    //   86: ldc_w '下载'
    //   89: astore #4
    //   91: iload_1
    //   92: ifeq -> 98
    //   95: goto -> 107
    //   98: iload_2
    //   99: ifeq -> 107
    //   102: ldc_w 'Install'
    //   105: astore #4
    //   107: aload_0
    //   108: getfield q : Lcom/bytedance/sdk/openadsdk/core/d/k;
    //   111: astore_3
    //   112: aload_3
    //   113: ifnonnull -> 119
    //   116: aload #4
    //   118: areturn
    //   119: aload_3
    //   120: invokevirtual L : ()Ljava/lang/String;
    //   123: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   126: ifeq -> 168
    //   129: aload #4
    //   131: astore_3
    //   132: aload_0
    //   133: getfield q : Lcom/bytedance/sdk/openadsdk/core/d/k;
    //   136: invokevirtual B : ()I
    //   139: iconst_4
    //   140: if_icmpeq -> 286
    //   143: iload_1
    //   144: ifeq -> 154
    //   147: ldc_w '查看'
    //   150: astore_3
    //   151: goto -> 286
    //   154: aload #4
    //   156: astore_3
    //   157: iload_2
    //   158: ifeq -> 286
    //   161: ldc_w 'View'
    //   164: astore_3
    //   165: goto -> 286
    //   168: aload_0
    //   169: getfield q : Lcom/bytedance/sdk/openadsdk/core/d/k;
    //   172: invokevirtual L : ()Ljava/lang/String;
    //   175: astore #4
    //   177: aload #4
    //   179: ifnull -> 228
    //   182: aload #4
    //   184: invokestatic j : (Ljava/lang/String;)Z
    //   187: ifeq -> 228
    //   190: aload #4
    //   192: invokevirtual length : ()I
    //   195: iconst_2
    //   196: if_icmple -> 228
    //   199: iload_1
    //   200: ifeq -> 212
    //   203: aload_0
    //   204: iconst_1
    //   205: invokespecial f : (Z)Ljava/lang/String;
    //   208: astore_3
    //   209: goto -> 286
    //   212: aload #4
    //   214: astore_3
    //   215: iload_2
    //   216: ifeq -> 286
    //   219: aload_0
    //   220: iconst_0
    //   221: invokespecial f : (Z)Ljava/lang/String;
    //   224: astore_3
    //   225: goto -> 286
    //   228: aload #4
    //   230: astore_3
    //   231: aload #4
    //   233: ifnull -> 286
    //   236: aload #4
    //   238: astore_3
    //   239: aload #4
    //   241: invokestatic j : (Ljava/lang/String;)Z
    //   244: ifne -> 286
    //   247: aload #4
    //   249: astore_3
    //   250: aload #4
    //   252: invokevirtual length : ()I
    //   255: bipush #7
    //   257: if_icmple -> 286
    //   260: iload_1
    //   261: ifeq -> 273
    //   264: aload_0
    //   265: iconst_1
    //   266: invokespecial f : (Z)Ljava/lang/String;
    //   269: astore_3
    //   270: goto -> 286
    //   273: aload #4
    //   275: astore_3
    //   276: iload_2
    //   277: ifeq -> 286
    //   280: aload_0
    //   281: iconst_0
    //   282: invokespecial f : (Z)Ljava/lang/String;
    //   285: astore_3
    //   286: iload_2
    //   287: ifeq -> 330
    //   290: aload_3
    //   291: invokestatic j : (Ljava/lang/String;)Z
    //   294: ifne -> 330
    //   297: aload_0
    //   298: getfield l : Landroid/widget/TextView;
    //   301: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   304: checkcast android/widget/LinearLayout$LayoutParams
    //   307: astore #4
    //   309: aload #4
    //   311: aload_0
    //   312: ldc_w 4.0
    //   315: invokestatic c : (Landroid/content/Context;F)I
    //   318: putfield bottomMargin : I
    //   321: aload_0
    //   322: getfield l : Landroid/widget/TextView;
    //   325: aload #4
    //   327: invokevirtual setLayoutParams : (Landroid/view/ViewGroup$LayoutParams;)V
    //   330: aload_3
    //   331: areturn
    //   332: astore_3
    //   333: goto -> 82
    //   336: astore_3
    //   337: goto -> 84
    // Exception table:
    //   from	to	target	type
    //   17	54	332	finally
    //   68	79	336	finally
  }
  
  void y() {
    if (this.ae) {
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = Color.parseColor("#0070FF");
      int i = ai.c((Context)this, 17.0F);
      int m = Color.parseColor("#80000000");
      int n = ai.c((Context)this, 3.0F);
      c.a a1 = (new c.a()).a(arrayOfInt[0]).b(m).a(arrayOfInt).c(i).d(0).e(n);
      c.a(findViewById(ab.e((Context)this, "tt_reward_ad_download_layout")), a1);
    } 
  }
  
  void z() {
    if (this.y == null) {
      this.y = new RewardDislikeDialog((Context)this, this.q);
      this.y.setCallback(new RewardDislikeDialog.a(this) {
            public void a(int param1Int, FilterWord param1FilterWord) {
              if (!this.a.W.get() && param1FilterWord != null && !param1FilterWord.hasSecondOptions()) {
                this.a.W.set(true);
                TTBaseVideoActivity.c(this.a);
              } 
            }
            
            public void a(View param1View) {
              this.a.V.set(true);
              if (this.a.r())
                this.a.A.h(); 
            }
            
            public void b(View param1View) {
              this.a.V.set(false);
              if (this.a.s())
                this.a.A.j(); 
            }
            
            public void c(View param1View) {}
          });
      ((FrameLayout)findViewById(16908290)).addView((View)this.y);
    } 
    if (this.z == null) {
      this.z = new RewardDislikeToast((Context)this);
      ((FrameLayout)findViewById(16908290)).addView((View)this.z);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\activity\TTBaseVideoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */