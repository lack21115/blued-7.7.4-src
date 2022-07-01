package com.soft.blued.ui.web;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.FixAndroid7WebviewCrashActivity;
import com.blued.android.framework.urlroute.BluedUrlParser;
import com.blued.android.framework.urlroute.BluedUrlUtils;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.RegExpUtils;
import com.blued.android.framework.web.BluedWebView;
import com.blued.android.web.SimpleWebCallBack;
import com.blued.das.client.feed.FeedProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.customview.WebViewProgressBar;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.live.utils.LiveUtils;
import com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter;
import com.soft.blued.utils.ActivityChangeAnimationUtils;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.view.tip.dialog.BluedAlertDialog;
import java.util.Map;

public class WebViewShowInfoFragment extends BaseFragment implements View.OnClickListener {
  private TextView A;
  
  private ImageView B;
  
  private ImageView C;
  
  private ImageView D;
  
  private ImageView E;
  
  private WebViewProgressBar F;
  
  private Context G;
  
  private SimpleWebCallBack H;
  
  protected String d = "";
  
  protected ViewGroup e;
  
  protected BluedWebView f;
  
  protected LinearLayout g;
  
  protected LinearLayout h;
  
  protected LinearLayout i;
  
  protected TextView j;
  
  protected FrameLayout k;
  
  protected TextView l;
  
  protected ImageView m;
  
  public ShareOptionRecyclerAdapter.ShareOptionsItemClickListener n;
  
  public boolean o = false;
  
  private boolean p;
  
  private int q = 0;
  
  private String r = "";
  
  private boolean s = false;
  
  private boolean t = false;
  
  private boolean u = false;
  
  private boolean v = false;
  
  private boolean w = false;
  
  private boolean x = false;
  
  private ViewGroup y;
  
  private TextView z;
  
  private void a(int paramInt) {
    this.u = true;
    Animation animation = AnimationUtils.loadAnimation((Context)getActivity(), 2130772063);
    if (paramInt != -1) {
      if (paramInt != 1) {
        this.g.setBackgroundColor(getResources().getColor(2131099783));
        this.A.setText(2131758276);
        this.g.setVisibility(0);
        this.g.startAnimation(animation);
        AppInfo.n().postDelayed(new Runnable(this) {
              public void run() {
                if (CommonTools.a((Fragment)this.a) && WebViewShowInfoFragment.h(this.a)) {
                  WebViewShowInfoFragment.c(this.a, false);
                  Animation animation = AnimationUtils.loadAnimation((Context)this.a.getActivity(), 2130772064);
                  this.a.g.setVisibility(8);
                  this.a.g.startAnimation(animation);
                } 
              }
            }3500L);
        return;
      } 
      this.g.setVisibility(8);
      return;
    } 
    this.g.setBackgroundColor(getResources().getColor(2131100611));
    this.A.setText(2131756509);
    this.g.setVisibility(0);
    this.g.startAnimation(animation);
    a(new Runnable(this) {
          public void run() {
            if (CommonTools.a((Fragment)this.a) && WebViewShowInfoFragment.h(this.a)) {
              WebViewShowInfoFragment.c(this.a, false);
              Animation animation = AnimationUtils.loadAnimation((Context)this.a.getActivity(), 2130772064);
              this.a.g.setVisibility(8);
              this.a.g.startAnimation(animation);
            } 
          }
        }3500L);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt) {
    a(paramContext, paramString1, paramString2, true, paramInt);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, int paramInt) {
    if (BluedWebView.a(paramContext, paramString1, (BluedWebView.WebCallback)new SimpleWebCallBack())) {
      if (paramInt == 14)
        LiveEventBus.get("live_back_to_two_level").post(""); 
      return;
    } 
    Bundle bundle = new Bundle();
    bundle.putString("web_url", paramString1);
    bundle.putString("title_name", paramString2);
    bundle.putInt("from_tag", paramInt);
    bundle.putBoolean("auto_finish", paramBoolean);
    for (Map.Entry entry : BluedUrlUtils.b(paramString1).entrySet())
      bundle.putString((String)entry.getKey(), (String)entry.getValue()); 
    FixAndroid7WebviewCrashActivity.b(paramContext, WebViewShowInfoFragment.class, bundle);
  }
  
  private void m() {
    LiveEventBus.get("LIVE_WEB_PAGE_REFRESH", String.class).observe((LifecycleOwner)this, new Observer<String>(this) {
          public void a(String param1String) {
            if (this.a.f != null) {
              this.a.f.c().reload();
              this.a.f.c().setVisibility(0);
            } 
            if (this.a.h != null)
              this.a.h.setVisibility(8); 
          }
        });
  }
  
  private void q() {
    if (this.f.c().canGoBack()) {
      this.D.setVisibility(0);
      return;
    } 
    this.D.setVisibility(8);
  }
  
  public static void show(Context paramContext, String paramString) {
    a(paramContext, paramString, "", -1);
  }
  
  public static void show(Context paramContext, String paramString, int paramInt) {
    a(paramContext, paramString, "", paramInt);
  }
  
  public boolean V_() {
    return p();
  }
  
  public ViewGroup a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup) {
    return (ViewGroup)paramLayoutInflater.inflate(2131492916, paramViewGroup, false);
  }
  
  public void a() {
    int i = this.q;
    if (i == 10 || i == 11 || i == 16)
      getActivity().getWindow().setSoftInputMode(18); 
    this.F = (WebViewProgressBar)this.e.findViewById(2131299157);
    this.E = (ImageView)this.e.findViewById(2131300891);
    this.g = (LinearLayout)this.e.findViewById(2131298878);
    this.A = (TextView)this.e.findViewById(2131300890);
    this.h = (LinearLayout)this.e.findViewById(2131299007);
    this.h.setOnClickListener(this);
    this.h.setVisibility(8);
    this.j = (TextView)this.h.findViewById(2131300704);
    this.i = (LinearLayout)this.e.findViewById(2131299088);
    this.k = (FrameLayout)this.e.findViewById(2131299941);
    this.l = (TextView)this.e.findViewById(2131299944);
    this.m = (ImageView)this.e.findViewById(2131299943);
    this.i.setVisibility(8);
    this.E.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.k.setOnClickListener(this);
    WebView webView = (WebView)this.e.findViewById(2131301766);
    webView.setBackgroundColor(0);
    webView.requestFocus(130);
    this.H = new SimpleWebCallBack(this) {
        public void a(BluedWebView param1BluedWebView, int param1Int) {
          WebViewShowInfoFragment.a(this.c).setProgress(param1Int);
        }
        
        public void a(BluedWebView param1BluedWebView, int param1Int, String param1String1, String param1String2) {
          param1BluedWebView.c().setVisibility(8);
          this.c.h.setVisibility(0);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(param1Int);
          stringBuilder.append(";");
          stringBuilder.append(param1String1);
          stringBuilder.append(";");
          stringBuilder.append(param1String2);
          Logger.a("webterror", stringBuilder.toString());
          this.c.i.setVisibility(8);
          this.c.j.setText(String.format(WebViewShowInfoFragment.f(this.c).getResources().getString(2131758338), new Object[] { param1String2 }));
        }
        
        public void a(BluedWebView param1BluedWebView, String param1String) {
          if (CommonTools.a((Fragment)this.c))
            this.c.c(param1String); 
        }
        
        public void a(BluedWebView param1BluedWebView, String param1String, boolean param1Boolean) {
          if (param1Boolean) {
            WebViewShowInfoFragment.a(this.c, true);
            Map map = BluedUrlUtils.b(param1String);
            if (map != null && map.size() > 0 && map.containsKey("blued_mode")) {
              param1String = (String)map.get("blued_mode");
              if (!StringUtils.e(param1String)) {
                if (param1String.contains("fullscreen")) {
                  WebViewShowInfoFragment.b(this.c, true);
                  this.c.getActivity().getWindow().setFlags(1024, 1024);
                  WebViewShowInfoFragment.b(this.c).setVisibility(8);
                } 
                if (param1String.contains("hide_opt"))
                  WebViewShowInfoFragment.c(this.c).setVisibility(8); 
              } 
              String str = (String)map.get("screen_orientation");
              if ("landscape".equalsIgnoreCase(str)) {
                this.c.getActivity().setRequestedOrientation(0);
                return;
              } 
              if ("portrait".equalsIgnoreCase(str)) {
                this.c.getActivity().setRequestedOrientation(1);
                return;
              } 
              if (!WebViewShowInfoFragment.d(this.c))
                this.c.getActivity().setRequestedOrientation(4); 
            } 
          } 
        }
        
        public void a(String param1String) {
          if ("show".equals(param1String)) {
            WebViewShowInfoFragment.c(this.c).setVisibility(0);
            return;
          } 
          if ("hide".equals(param1String))
            WebViewShowInfoFragment.c(this.c).setVisibility(8); 
        }
        
        public boolean a(BluedWebView param1BluedWebView, BluedUrlParser param1BluedUrlParser) {
          return this.c.a(param1BluedWebView, param1BluedUrlParser);
        }
        
        public void b(BluedWebView param1BluedWebView, int param1Int) {
          this.c.a(new Runnable(this, param1Int) {
                public void run() {
                  WebViewShowInfoFragment.a(this.b.c, this.a);
                }
              });
        }
        
        public void b(BluedWebView param1BluedWebView, String param1String, boolean param1Boolean) {
          if (param1Boolean)
            WebViewShowInfoFragment.a(this.c, true); 
          if (CommonTools.a((Activity)this.c.getActivity())) {
            WebViewShowInfoFragment.e(this.c);
            this.c.o();
          } 
        }
      };
    this.n = new -$$Lambda$WebViewShowInfoFragment$4dDJDW9jazeBaFniXQ3Jf4RyeHc(this);
    this.H.a(this.n);
    this.f = new BluedWebView((Fragment)this, webView, this.e, (BluedWebView.WebCallback)this.H);
    this.f.b(this.q);
    if (this.q == 13) {
      this.f.c().getSettings().setBuiltInZoomControls(false);
      this.f.a(DensityUtils.a((Context)getActivity(), 44.0F));
      return;
    } 
    webView.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            if (param1MotionEvent.getAction() == 1) {
              if (this.a.f.c().canGoBack()) {
                WebViewShowInfoFragment.g(this.a).setVisibility(0);
              } else {
                WebViewShowInfoFragment.g(this.a).setVisibility(8);
              } 
              String str = this.a.f.d();
              if (!StringUtils.e(str) && str.contains("file:///android_asset/")) {
                this.a.f.c().clearCache(false);
                WebViewShowInfoFragment webViewShowInfoFragment = this.a;
                webViewShowInfoFragment.b(webViewShowInfoFragment.d);
              } 
            } 
            return false;
          }
        });
  }
  
  public void a(String paramString1, String paramString2) {
    BluedWebView bluedWebView = this.f;
    if (bluedWebView != null && !bluedWebView.a(paramString1, paramString2)) {
      this.i.setVisibility(0);
      this.z.setText("");
      this.h.setVisibility(8);
      this.f.c().setVisibility(8);
    } 
  }
  
  public boolean a(BluedWebView paramBluedWebView, BluedUrlParser paramBluedUrlParser) {
    return false;
  }
  
  public void b(String paramString) {
    a(paramString, this.r);
  }
  
  public void c(String paramString) {
    if (StringUtils.e(paramString)) {
      this.z.setText("");
    } else {
      this.z.setText(paramString);
    } 
    if (!StringUtils.e(this.r) && this.s)
      this.z.setText(this.r); 
  }
  
  public void k() {
    if (w_() != null && w_().isActive() && !this.o)
      getActivity().finish(); 
  }
  
  protected void l() {
    ViewGroup viewGroup = this.e;
    if (viewGroup != null) {
      this.y = (ViewGroup)viewGroup.findViewById(2131301751);
      if (this.x) {
        this.y.setVisibility(8);
      } else {
        this.y.setVisibility(0);
      } 
      this.B = (ImageView)this.y.findViewById(2131296863);
      this.B.setOnClickListener(this);
      this.z = (TextView)this.y.findViewById(2131296857);
      this.z.setText(getResources().getString(2131755632));
      this.C = (ImageView)this.y.findViewById(2131296867);
      this.C.setOnClickListener(this);
      this.D = (ImageView)this.y.findViewById(2131296862);
      this.D.setOnClickListener(this);
      int i = this.q;
      if (i != 0) {
        if (i != 1) {
          if (i != 2) {
            if (i != 7) {
              if (i != 15) {
                if (i != 16) {
                  switch (i) {
                    default:
                      this.C.setVisibility(0);
                      this.t = false;
                      this.s = false;
                      break;
                    case 11:
                      this.C.setVisibility(0);
                      this.t = false;
                      this.s = false;
                      break;
                    case 10:
                      this.C.setVisibility(8);
                      this.t = true;
                      this.s = false;
                      break;
                    case 9:
                      this.C.setVisibility(0);
                      this.t = false;
                      this.s = false;
                      break;
                  } 
                } else {
                  this.C.setVisibility(8);
                  this.t = true;
                  this.s = true;
                } 
              } else {
                this.C.setVisibility(8);
                this.t = false;
                this.s = false;
              } 
            } else {
              this.C.setVisibility(0);
              this.t = false;
              this.s = false;
            } 
          } else {
            this.C.setVisibility(0);
            this.t = true;
            this.s = true;
          } 
        } else {
          this.C.setVisibility(8);
          this.t = true;
          this.s = true;
        } 
      } else {
        this.C.setVisibility(8);
        this.t = true;
        this.s = false;
      } 
      if (this.p)
        this.y.setVisibility(8); 
    } 
  }
  
  public String n() {
    String str = this.d;
    return (str != null) ? str : "";
  }
  
  public void o() {
    String str = this.z.getText().toString();
    if (getResources().getString(2131755632).equals(str))
      c(""); 
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    this.f.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView) {
    switch (paramView.getId()) {
      default:
        return;
      case 2131300891:
        this.u = false;
        if (this.g.getVisibility() == 0) {
          Animation animation = AnimationUtils.loadAnimation((Context)getActivity(), 2130772064);
          this.g.setVisibility(8);
          this.g.startAnimation(animation);
          return;
        } 
        break;
      case 2131299944:
        EventTrackFeed.a(FeedProtos.Event.SHARE_PASSWORD_POP_PASTE_CLICK, this.H.a, false);
        startActivity(getActivity().getPackageManager().getLaunchIntentForPackage("com.tencent.mm"));
        this.k.setVisibility(8);
        return;
      case 2131299943:
        this.k.setVisibility(8);
        return;
      case 2131299007:
        this.f.c().reload();
        this.f.c().setVisibility(0);
        this.h.setVisibility(8);
        return;
      case 2131296867:
        this.f.b("");
        return;
      case 2131296863:
        V_();
        return;
      case 2131296862:
        k();
        break;
      case 2131299941:
        break;
    } 
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial onConfigurationChanged : (Landroid/content/res/Configuration;)V
    //   5: aload_0
    //   6: getfield p : Z
    //   9: ifne -> 46
    //   12: aload_1
    //   13: getfield orientation : I
    //   16: iconst_1
    //   17: if_icmpeq -> 38
    //   20: aload_0
    //   21: getfield y : Landroid/view/ViewGroup;
    //   24: astore_2
    //   25: aload_2
    //   26: ifnull -> 38
    //   29: aload_2
    //   30: bipush #8
    //   32: invokevirtual setVisibility : (I)V
    //   35: goto -> 46
    //   38: aload_0
    //   39: getfield y : Landroid/view/ViewGroup;
    //   42: iconst_0
    //   43: invokevirtual setVisibility : (I)V
    //   46: aload_1
    //   47: getfield orientation : I
    //   50: iconst_1
    //   51: if_icmpeq -> 55
    //   54: return
    //   55: aload_0
    //   56: invokevirtual getActivity : ()Landroidx/fragment/app/FragmentActivity;
    //   59: ldc ''
    //   61: ldc ''
    //   63: ldc ''
    //   65: aconst_null
    //   66: aconst_null
    //   67: iconst_0
    //   68: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnDismissListener;I)Lcom/soft/blued/view/tip/dialog/BluedAlertDialog;
    //   71: astore_1
    //   72: invokestatic n : ()Landroid/os/Handler;
    //   75: new com/soft/blued/ui/web/WebViewShowInfoFragment$2
    //   78: dup
    //   79: aload_0
    //   80: aload_1
    //   81: invokespecial <init> : (Lcom/soft/blued/ui/web/WebViewShowInfoFragment;Lcom/soft/blued/view/tip/dialog/BluedAlertDialog;)V
    //   84: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   87: pop
    //   88: return
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    if (getArguments() != null)
      this.q = getArguments().getInt("from_tag"); 
    if (this.q == 14) {
      ActivityChangeAnimationUtils.b((Activity)getActivity());
      LiveEventBus.get("live_back_to_two_level").post("");
    } 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.G = (Context)getActivity();
    getActivity().getWindow().setSoftInputMode(18);
    ViewGroup viewGroup = this.e;
    if (viewGroup == null)
      try {
        String str;
        this.e = a(paramLayoutInflater, paramViewGroup);
        if (getArguments() != null) {
          str = getArguments().getString("web_url");
          String str1 = str;
          if (!str.contains("://")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("http://");
            stringBuilder.append(str);
            str1 = stringBuilder.toString();
          } 
          this.d = str1;
          this.r = getArguments().getString("title_name");
          this.x = getArguments().getBoolean("hide_title");
          this.w = getArguments().getBoolean("auto_finish", false);
          str = str1;
          if ("fullscreen".equals(getArguments().getString("blued_mode"))) {
            this.p = true;
            getActivity().getWindow().setFlags(1024, 1024);
            str = str1;
          } 
        } else {
          str = "";
        } 
        l();
        a();
        a(str, this.r);
        return (View)this.e;
      } catch (InflateException inflateException) {
        getActivity().finish();
        AppMethods.a("请前往系统应用商店安装系统浏览器~");
        return null;
      }  
    if (viewGroup.getParent() != null)
      ((ViewGroup)this.e.getParent()).removeView((View)this.e); 
    return (View)this.e;
  }
  
  public void onDestroy() {
    super.onDestroy();
    BluedWebView bluedWebView = this.f;
    if (bluedWebView != null)
      bluedWebView.h(); 
    LiveUtils.a("", "", 0);
  }
  
  public void onPause() {
    super.onPause();
    BluedWebView bluedWebView = this.f;
    if (bluedWebView != null)
      bluedWebView.g(); 
  }
  
  public void onResume() {
    super.onResume();
    BluedWebView bluedWebView = this.f;
    if (bluedWebView != null)
      bluedWebView.f(); 
  }
  
  public void onStop() {
    super.onStop();
    if (!this.v && this.w)
      k(); 
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    m();
  }
  
  public boolean p() {
    BluedWebView bluedWebView = this.f;
    if (bluedWebView != null && bluedWebView.c().canGoBack()) {
      this.f.c().goBack();
      return true;
    } 
    k();
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\web\WebViewShowInfoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */