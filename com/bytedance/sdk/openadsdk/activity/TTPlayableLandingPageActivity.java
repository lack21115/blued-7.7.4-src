package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.c.j;
import com.bytedance.sdk.openadsdk.core.a.a;
import com.bytedance.sdk.openadsdk.core.a.d;
import com.bytedance.sdk.openadsdk.core.aa;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.u;
import com.bytedance.sdk.openadsdk.core.widget.PlayableLoadingView;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.widget.webview.a;
import com.bytedance.sdk.openadsdk.core.widget.webview.b;
import com.bytedance.sdk.openadsdk.core.widget.webview.c;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.downloadnew.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.e.c;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.ai;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class TTPlayableLandingPageActivity extends Activity implements d, ak.a {
  protected c a = new c(this) {
      public void a() {
        if (this.a.isFinishing())
          return; 
        if (TTPlayableLandingPageActivity.a(this.a) != null && !TTPlayableLandingPageActivity.a(this.a).o())
          return; 
        if (TTPlayableLandingPageActivity.a(this.a) != null && TTPlayableLandingPageActivity.a(this.a).p()) {
          TTPlayableLandingPageActivity.b(this.a).removeMessages(2);
          TTPlayableLandingPageActivity.b(this.a).sendMessage(TTPlayableLandingPageActivity.a(this.a, 1));
        } 
      }
    };
  
  private SSWebView b;
  
  private SSWebView c;
  
  private boolean d = true;
  
  private boolean e = true;
  
  private RelativeLayout f;
  
  private Context g;
  
  private int h;
  
  private ProgressBar i;
  
  private PlayableLoadingView j;
  
  private String k;
  
  private String l;
  
  private x m;
  
  private x n;
  
  private int o;
  
  private String p;
  
  private String q;
  
  private String r;
  
  private k s;
  
  private ak t = new ak(Looper.getMainLooper(), this);
  
  private boolean u;
  
  private boolean v;
  
  private a w;
  
  private AtomicBoolean x = new AtomicBoolean(false);
  
  private int y;
  
  private boolean z = false;
  
  private Message a(int paramInt) {
    Message message = Message.obtain();
    message.what = 2;
    message.arg1 = paramInt;
    return message;
  }
  
  private void a(Bundle paramBundle) {
    Intent intent = getIntent();
    if (intent != null) {
      this.h = intent.getIntExtra("sdk_version", 1);
      this.k = intent.getStringExtra("adid");
      this.l = intent.getStringExtra("log_extra");
      this.o = intent.getIntExtra("source", -1);
      this.u = intent.getBooleanExtra("ad_pending_download", false);
      this.p = intent.getStringExtra("url");
      this.q = intent.getStringExtra("web_title");
      this.r = intent.getStringExtra("event_tag");
    } 
    if (b.b()) {
      String str = intent.getStringExtra("multi_process_materialmeta");
      if (str != null)
        try {
          this.s = c.a(new JSONObject(str));
        } catch (Exception exception) {
          t.c("TTPlayableLandingPageActivity", "TTPlayableLandingPageActivity - onCreate MultiGlobalInfo : ", exception);
        }  
    } else {
      this.s = u.a().c();
      u.a().g();
    } 
    if (paramBundle != null)
      try {
        this.h = paramBundle.getInt("sdk_version", 1);
        this.k = paramBundle.getString("adid");
        this.l = paramBundle.getString("log_extra");
        this.o = paramBundle.getInt("source", -1);
        this.u = paramBundle.getBoolean("ad_pending_download", false);
        this.p = paramBundle.getString("url");
        this.q = paramBundle.getString("web_title");
        this.r = paramBundle.getString("event_tag");
        String str = paramBundle.getString("material_meta", null);
        if (!TextUtils.isEmpty(str))
          this.s = c.a(new JSONObject(str)); 
      } finally {} 
    if (this.s == null) {
      t.e("TTPlayableLandingPageActivity", "material is null, no data to display");
      finish();
    } 
  }
  
  private void a(SSWebView paramSSWebView) {
    if (paramSSWebView == null)
      return; 
    a.a(this.g).a(false).b(false).a((WebView)paramSSWebView);
    paramSSWebView.getSettings().setUserAgentString(q.a((WebView)paramSSWebView, this.h));
    if (Build.VERSION.SDK_INT >= 21)
      paramSSWebView.getSettings().setMixedContentMode(0); 
  }
  
  private void a(String paramString) {
    d.b((Context)this, this.s, this.r, paramString, null);
  }
  
  private void b() {
    this.j = (PlayableLoadingView)findViewById(ab.e((Context)this, "tt_playable_loading"));
    this.b = (SSWebView)findViewById(ab.e((Context)this, "tt_browser_webview"));
    this.c = (SSWebView)findViewById(ab.e((Context)this, "tt_browser_webview_loading"));
    this.f = (RelativeLayout)findViewById(ab.e((Context)this, "tt_playable_ad_close_layout"));
    RelativeLayout relativeLayout = this.f;
    if (relativeLayout != null)
      relativeLayout.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              TTPlayableLandingPageActivity.a(this.a, "playable_close");
              TTPlayableLandingPageActivity.i(this.a);
              this.a.finish();
            }
          }); 
    this.i = (ProgressBar)findViewById(ab.e((Context)this, "tt_browser_progress"));
  }
  
  private void c() {
    if (this.x.getAndSet(true))
      return; 
    SSWebView sSWebView = this.b;
    if (sSWebView != null && this.c != null) {
      ai.a((View)sSWebView, 0);
      ai.a((View)this.c, 8);
      int i = ah.d(this.s.P());
      i = (o.h().r(String.valueOf(i))).s;
      if (i >= 0) {
        this.t.sendEmptyMessageDelayed(1, (i * 1000));
        return;
      } 
      ai.a((View)this.f, 0);
    } 
  }
  
  private boolean d() {
    if (this.c == null)
      return false; 
    String str = e();
    if (TextUtils.isEmpty(str))
      return false; 
    this.c.setWebViewClient((WebViewClient)new c(this, this.g, this.n, this.k, null) {
          public void onPageFinished(WebView param1WebView, String param1String) {
            super.onPageFinished(param1WebView, param1String);
            if (TTPlayableLandingPageActivity.j(this.a))
              TTPlayableLandingPageActivity.a(this.a, "loading_h5_success"); 
          }
          
          public void onReceivedError(WebView param1WebView, int param1Int, String param1String1, String param1String2) {
            super.onReceivedError(param1WebView, param1Int, param1String1, param1String2);
            TTPlayableLandingPageActivity.b(this.a, false);
          }
          
          public void onReceivedError(WebView param1WebView, WebResourceRequest param1WebResourceRequest, WebResourceError param1WebResourceError) {
            super.onReceivedError(param1WebView, param1WebResourceRequest, param1WebResourceError);
            TTPlayableLandingPageActivity.b(this.a, false);
          }
          
          public void onReceivedHttpError(WebView param1WebView, WebResourceRequest param1WebResourceRequest, WebResourceResponse param1WebResourceResponse) {
            super.onReceivedHttpError(param1WebView, param1WebResourceRequest, param1WebResourceResponse);
            TTPlayableLandingPageActivity.b(this.a, false);
          }
        });
    this.c.loadUrl(str);
    return true;
  }
  
  private String e() {
    String str2 = o.h().p();
    String str1 = str2;
    if (!TextUtils.isEmpty(str2)) {
      k k1 = this.s;
      str1 = str2;
      if (k1 != null) {
        if (k1.N() == null)
          return str2; 
        str1 = this.s.N().c();
        int i = this.s.N().e();
        int j = this.s.N().f();
        String str3 = this.s.C().a();
        String str4 = this.s.M();
        String str5 = this.s.N().d();
        String str6 = this.s.N().b();
        String str7 = this.s.N().c();
        StringBuffer stringBuffer = new StringBuffer(str2);
        stringBuffer.append("?appname=");
        stringBuffer.append(str1);
        stringBuffer.append("&stars=");
        stringBuffer.append(i);
        stringBuffer.append("&comments=");
        stringBuffer.append(j);
        stringBuffer.append("&icon=");
        stringBuffer.append(str3);
        stringBuffer.append("&downloading=");
        stringBuffer.append(false);
        stringBuffer.append("&id=");
        stringBuffer.append(str4);
        stringBuffer.append("&pkg_name=");
        stringBuffer.append(str5);
        stringBuffer.append("&download_url=");
        stringBuffer.append(str6);
        stringBuffer.append("&name=");
        stringBuffer.append(str7);
        str1 = stringBuffer.toString();
      } 
    } 
    return str1;
  }
  
  private void f() {
    if (!this.v && this.u) {
      a a1 = this.w;
      if (a1 != null)
        a1.h(); 
    } 
  }
  
  private void g() {
    ArrayList<k> arrayList = new ArrayList();
    arrayList.add(this.s);
    this.m = new x((Context)this);
    this.m.a((WebView)this.b).a(this.s).a(arrayList).a(this.k).b(this.l).a(this.o).a(this).a(this.a).c(ah.g(this.s));
    this.n = new x((Context)this);
    this.n.a((WebView)this.c).a(this.s).a(this.k).b(this.l).a(this).a(this.o).c(false).c(ah.g(this.s));
  }
  
  private void h() {
    k k1 = this.s;
    if (k1 != null) {
      if (this.b == null)
        return; 
      if (!k1.q())
        return; 
      Bitmap bitmap = ai.a((WebView)this.b);
      if (bitmap == null)
        return; 
      ai.a(o.a(), this.s, this.r, "playable_show_status", bitmap);
    } 
  }
  
  protected void a() {
    PlayableLoadingView playableLoadingView = this.j;
    if (playableLoadingView == null)
      return; 
    if (!this.z) {
      playableLoadingView.a();
      return;
    } 
    k k1 = this.s;
    if (k1 == null || !k1.o() || !this.s.r()) {
      this.j.a();
      return;
    } 
    this.j.b();
    if (this.j.getPlayView() != null) {
      a a1 = new a(this, (Context)this, this.s, this.r, this.o) {
          public void a(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
            super.a(param1View, param1Int1, param1Int2, param1Int3, param1Int4);
            if (TTPlayableLandingPageActivity.a(this.a).r()) {
              HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
              if (TTPlayableLandingPageActivity.a(this.a).z() != null)
                hashMap.put("playable_url", TTPlayableLandingPageActivity.a(this.a).z().h()); 
              TTPlayableLandingPageActivity tTPlayableLandingPageActivity = this.a;
              d.r((Context)tTPlayableLandingPageActivity, TTPlayableLandingPageActivity.a(tTPlayableLandingPageActivity), this.e, "click_playable_download_button_loading", hashMap);
            } 
          }
        };
      this.j.getPlayView().setOnClickListener((View.OnClickListener)a1);
      this.j.getPlayView().setOnTouchListener((View.OnTouchListener)a1);
    } 
    k1 = this.s;
    if (k1 != null && k1.r() && this.s.p())
      this.t.sendMessageDelayed(a(2), 10000L); 
  }
  
  public void a(Message paramMessage) {
    if (paramMessage.what == 1) {
      ai.a((View)this.f, 0);
      return;
    } 
    if (paramMessage.what == 2) {
      if (!this.z)
        return; 
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("remove_loading_page_type", Integer.valueOf(paramMessage.arg1));
      if (this.s.z() != null)
        hashMap.put("playable_url", this.s.z().h()); 
      d.r((Context)this, this.s, this.r, "remove_loading_page", hashMap);
      this.t.removeMessages(2);
      PlayableLoadingView playableLoadingView = this.j;
      if (playableLoadingView != null)
        playableLoadingView.a(); 
    } 
  }
  
  public void a(boolean paramBoolean) {
    this.u = true;
    this.v = paramBoolean;
    if (!paramBoolean)
      Toast.makeText(this.g, "稍后开始下载", 0).show(); 
    if (this.v) {
      a a1 = this.w;
      if (a1 != null)
        a1.h(); 
    } 
  }
  
  public void onBackPressed() {
    super.onBackPressed();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    if (h.c().l())
      getWindow().addFlags(2621440); 
    try {
      requestWindowFeature(1);
      getWindow().addFlags(1024);
      getWindow().addFlags(16777216);
      o.a((Context)this);
    } finally {
      Exception exception;
    } 
    a(paramBundle);
    k k1 = this.s;
    if (k1 == null)
      return; 
    this.g = (Context)this;
    this.y = k1.Q();
    setContentView(ab.f((Context)this, "tt_activity_ttlandingpage_playable"));
    b();
    a();
    g();
    SSWebView sSWebView = this.b;
    if (sSWebView != null) {
      sSWebView.setWebViewClient((WebViewClient)new c(this, this.g, this.m, this.k, null) {
            public void onPageFinished(WebView param1WebView, String param1String) {
              // Byte code:
              //   0: aload_0
              //   1: aload_1
              //   2: aload_2
              //   3: invokespecial onPageFinished : (Landroid/webkit/WebView;Ljava/lang/String;)V
              //   6: aload_0
              //   7: getfield a : Lcom/bytedance/sdk/openadsdk/activity/TTPlayableLandingPageActivity;
              //   10: invokestatic c : (Lcom/bytedance/sdk/openadsdk/activity/TTPlayableLandingPageActivity;)Z
              //   13: ifeq -> 87
              //   16: aload_0
              //   17: getfield a : Lcom/bytedance/sdk/openadsdk/activity/TTPlayableLandingPageActivity;
              //   20: invokestatic a : (Lcom/bytedance/sdk/openadsdk/activity/TTPlayableLandingPageActivity;)Lcom/bytedance/sdk/openadsdk/core/d/k;
              //   23: invokevirtual r : ()Z
              //   26: ifeq -> 87
              //   29: aload_0
              //   30: getfield a : Lcom/bytedance/sdk/openadsdk/activity/TTPlayableLandingPageActivity;
              //   33: invokevirtual isFinishing : ()Z
              //   36: ifne -> 87
              //   39: aload_0
              //   40: getfield a : Lcom/bytedance/sdk/openadsdk/activity/TTPlayableLandingPageActivity;
              //   43: invokestatic a : (Lcom/bytedance/sdk/openadsdk/activity/TTPlayableLandingPageActivity;)Lcom/bytedance/sdk/openadsdk/core/d/k;
              //   46: invokevirtual o : ()Z
              //   49: ifeq -> 87
              //   52: aload_0
              //   53: getfield a : Lcom/bytedance/sdk/openadsdk/activity/TTPlayableLandingPageActivity;
              //   56: invokestatic a : (Lcom/bytedance/sdk/openadsdk/activity/TTPlayableLandingPageActivity;)Lcom/bytedance/sdk/openadsdk/core/d/k;
              //   59: invokevirtual p : ()Z
              //   62: ifne -> 87
              //   65: aload_0
              //   66: getfield a : Lcom/bytedance/sdk/openadsdk/activity/TTPlayableLandingPageActivity;
              //   69: invokestatic b : (Lcom/bytedance/sdk/openadsdk/activity/TTPlayableLandingPageActivity;)Lcom/bytedance/sdk/openadsdk/utils/ak;
              //   72: aload_0
              //   73: getfield a : Lcom/bytedance/sdk/openadsdk/activity/TTPlayableLandingPageActivity;
              //   76: iconst_0
              //   77: invokestatic a : (Lcom/bytedance/sdk/openadsdk/activity/TTPlayableLandingPageActivity;I)Landroid/os/Message;
              //   80: ldc2_w 1000
              //   83: invokevirtual sendMessageDelayed : (Landroid/os/Message;J)Z
              //   86: pop
              //   87: aload_0
              //   88: getfield a : Lcom/bytedance/sdk/openadsdk/activity/TTPlayableLandingPageActivity;
              //   91: invokestatic d : (Lcom/bytedance/sdk/openadsdk/activity/TTPlayableLandingPageActivity;)Landroid/widget/ProgressBar;
              //   94: ifnull -> 119
              //   97: aload_0
              //   98: getfield a : Lcom/bytedance/sdk/openadsdk/activity/TTPlayableLandingPageActivity;
              //   101: invokevirtual isFinishing : ()Z
              //   104: ifne -> 119
              //   107: aload_0
              //   108: getfield a : Lcom/bytedance/sdk/openadsdk/activity/TTPlayableLandingPageActivity;
              //   111: invokestatic d : (Lcom/bytedance/sdk/openadsdk/activity/TTPlayableLandingPageActivity;)Landroid/widget/ProgressBar;
              //   114: bipush #8
              //   116: invokevirtual setVisibility : (I)V
              //   119: aload_0
              //   120: getfield a : Lcom/bytedance/sdk/openadsdk/activity/TTPlayableLandingPageActivity;
              //   123: invokestatic e : (Lcom/bytedance/sdk/openadsdk/activity/TTPlayableLandingPageActivity;)Z
              //   126: ifeq -> 145
              //   129: aload_0
              //   130: getfield a : Lcom/bytedance/sdk/openadsdk/activity/TTPlayableLandingPageActivity;
              //   133: invokestatic f : (Lcom/bytedance/sdk/openadsdk/activity/TTPlayableLandingPageActivity;)V
              //   136: aload_0
              //   137: getfield a : Lcom/bytedance/sdk/openadsdk/activity/TTPlayableLandingPageActivity;
              //   140: ldc 'py_loading_success'
              //   142: invokestatic a : (Lcom/bytedance/sdk/openadsdk/activity/TTPlayableLandingPageActivity;Ljava/lang/String;)V
              //   145: return
              //   146: astore_1
              //   147: goto -> 87
              //   150: astore_1
              //   151: return
              // Exception table:
              //   from	to	target	type
              //   6	87	146	finally
              //   87	119	150	finally
              //   119	145	150	finally
            }
            
            public void onReceivedError(WebView param1WebView, int param1Int, String param1String1, String param1String2) {
              super.onReceivedError(param1WebView, param1Int, param1String1, param1String2);
              TTPlayableLandingPageActivity.a(this.a, false);
            }
            
            public void onReceivedError(WebView param1WebView, WebResourceRequest param1WebResourceRequest, WebResourceError param1WebResourceError) {
              super.onReceivedError(param1WebView, param1WebResourceRequest, param1WebResourceError);
              TTPlayableLandingPageActivity.a(this.a, false);
            }
            
            public void onReceivedHttpError(WebView param1WebView, WebResourceRequest param1WebResourceRequest, WebResourceResponse param1WebResourceResponse) {
              if (TTPlayableLandingPageActivity.g(this.a) != null && param1WebResourceRequest != null && param1WebResourceRequest.getUrl() != null && TTPlayableLandingPageActivity.g(this.a).equals(param1WebResourceRequest.getUrl().toString()))
                TTPlayableLandingPageActivity.a(this.a, false); 
              super.onReceivedHttpError(param1WebView, param1WebResourceRequest, param1WebResourceResponse);
            }
          });
      a(this.b);
      a(this.c);
      d();
      this.b.loadUrl(this.p);
      this.b.setWebChromeClient((WebChromeClient)new b(this, this.m, null) {
            public void onProgressChanged(WebView param1WebView, int param1Int) {
              super.onProgressChanged(param1WebView, param1Int);
              try {
                if (TTPlayableLandingPageActivity.c(this.a) && TTPlayableLandingPageActivity.a(this.a).r() && TTPlayableLandingPageActivity.a(this.a).o() && !this.a.isFinishing() && TTPlayableLandingPageActivity.h(this.a) != null)
                  TTPlayableLandingPageActivity.h(this.a).setProgress(param1Int); 
              } finally {}
              if (TTPlayableLandingPageActivity.d(this.a) != null && !this.a.isFinishing()) {
                if (param1Int == 100 && TTPlayableLandingPageActivity.d(this.a).isShown()) {
                  TTPlayableLandingPageActivity.d(this.a).setVisibility(8);
                  TTPlayableLandingPageActivity.f(this.a);
                  return;
                } 
                TTPlayableLandingPageActivity.d(this.a).setProgress(param1Int);
              } 
            }
          });
    } 
    if (this.s.B() == 4)
      this.w = a.a(this.g, this.s, this.r); 
  }
  
  protected void onDestroy() {
    super.onDestroy();
    ak ak1 = this.t;
    if (ak1 != null)
      ak1.removeCallbacksAndMessages(null); 
    try {
      if (getWindow() != null) {
        ViewGroup viewGroup = (ViewGroup)getWindow().getDecorView();
        if (viewGroup != null)
          viewGroup.removeAllViews(); 
      } 
    } finally {}
    aa.a(this.g, (WebView)this.b);
    aa.a((WebView)this.b);
    this.b = null;
    x x1 = this.m;
    if (x1 != null)
      x1.i(); 
    x1 = this.n;
    if (x1 != null)
      x1.i(); 
    f();
  }
  
  protected void onPause() {
    super.onPause();
    u.a().b(true);
    x x1 = this.m;
    if (x1 != null)
      x1.h(); 
    x1 = this.n;
    if (x1 != null)
      x1.h(); 
  }
  
  protected void onResume() {
    super.onResume();
    x x1 = this.m;
    if (x1 != null)
      x1.g(); 
    x1 = this.n;
    if (x1 != null)
      x1.g(); 
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {
    Bundle bundle = paramBundle;
    if (paramBundle == null)
      bundle = new Bundle(); 
    try {
      if (this.s != null) {
        String str = this.s.ae().toString();
      } else {
        paramBundle = null;
      } 
      bundle.putString("material_meta", (String)paramBundle);
      bundle.putInt("sdk_version", this.h);
      bundle.putString("adid", this.k);
      bundle.putString("log_extra", this.l);
      bundle.putInt("source", this.o);
      bundle.putBoolean("ad_pending_download", this.u);
      bundle.putString("url", this.p);
      bundle.putString("web_title", this.q);
      bundle.putString("event_tag", this.r);
    } finally {}
    super.onSaveInstanceState(bundle);
  }
  
  protected void onStop() {
    super.onStop();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\activity\TTPlayableLandingPageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */