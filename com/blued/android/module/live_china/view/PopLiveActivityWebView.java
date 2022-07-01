package com.blued.android.module.live_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.urlroute.BluedUrlParser;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.web.BluedWebView;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live.base.model.LiveGiftNumberModel;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.GrabRewardPayManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveRewardConfigModel;
import com.blued.android.module.live_china.model.LiveRewardDescribe;
import com.blued.android.module.live_china.model.LiveRewardModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.PayRemaining;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveGiftPayTools;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.web.LiveWebCallBack;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.List;
import java.util.Map;

public class PopLiveActivityWebView extends FrameLayout {
  public View a;
  
  public View b;
  
  public View c;
  
  public Context d;
  
  public LayoutInflater e;
  
  private View f;
  
  private TextView g;
  
  private ImageView h;
  
  private boolean i = false;
  
  private boolean j = false;
  
  private ProgressBar k;
  
  private BluedWebView l;
  
  private WebView m;
  
  private ImageView n;
  
  private FrameLayout o;
  
  private ImageView p;
  
  private TextView q;
  
  private Button r;
  
  private Fragment s;
  
  private boolean t = false;
  
  private short u = 4;
  
  private String v;
  
  private int w;
  
  private PopLiveWebEvent x;
  
  public PopLiveActivityWebView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public PopLiveActivityWebView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PopLiveActivityWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.d = paramContext;
    h();
  }
  
  private void a(LiveRewardConfigModel paramLiveRewardConfigModel) {
    Fragment fragment = this.s;
    if (!(fragment instanceof RecordingOnliveFragment))
      return; 
    RecordingOnliveFragment recordingOnliveFragment = (RecordingOnliveFragment)fragment;
    GrabRewardPayManager.a().a(this.d, (IRequestHost)recordingOnliveFragment.w_(), paramLiveRewardConfigModel, String.valueOf(recordingOnliveFragment.u), LiveRoomInfo.a().f(), true, "", new GrabRewardPayManager.BackGiftStatusListener(this, recordingOnliveFragment) {
          public void a() {}
          
          public void a(PayRemaining param1PayRemaining, LiveRewardDescribe param1LiveRewardDescribe, LiveRewardConfigModel param1LiveRewardConfigModel) {
            RecordingOnliveFragment recordingOnliveFragment;
            if (param1PayRemaining.sendGiftStatus == 3) {
              String str;
              Logger.a("drb", new Object[] { "支付成功" });
              if (param1LiveRewardConfigModel != null) {
                str = param1LiveRewardConfigModel.condition;
              } else {
                str = "";
              } 
              LiveRewardModel liveRewardModel = new LiveRewardModel(param1PayRemaining.hongbao_id, param1PayRemaining.start_second, param1PayRemaining.end_second, param1PayRemaining.is_anim, str);
              this.a.bk.setData(liveRewardModel);
              this.b.d();
              if (param1PayRemaining.is_anim == 1) {
                LiveGiftModel liveGiftModel = new LiveGiftModel();
                liveGiftModel.anim_code = "hongbao";
                this.a.cG.d(liveGiftModel);
                if (TextUtils.equals(param1LiveRewardConfigModel.size, "L")) {
                  LiveGiftModel liveGiftModel1 = new LiveGiftModel();
                  liveGiftModel1.anim_code = param1PayRemaining.ar_name;
                  liveGiftModel1.resource_url = param1PayRemaining.resource_url;
                  this.a.cG.a(liveGiftModel1);
                } 
              } 
              if (param1LiveRewardDescribe != null && param1LiveRewardDescribe.m_hb_activity != null) {
                if (param1LiveRewardDescribe.m_hb_activity.stage == 1) {
                  recordingOnliveFragment = this.a;
                  String str1 = this.b.d.getString(R.string.live_reward_special);
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append(param1LiveRewardDescribe.m_hb_activity.need_count);
                  stringBuilder.append("");
                  recordingOnliveFragment.b(String.format(str1, new Object[] { stringBuilder.toString(), CommonStringUtils.d(Double.toString(param1LiveRewardDescribe.m_hb_activity.beans)) }));
                  return;
                } 
                if (param1LiveRewardDescribe.m_hb_activity.stage == 2) {
                  recordingOnliveFragment = this.a;
                  String str1 = this.b.d.getString(R.string.live_reward_horn);
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append(param1LiveRewardDescribe.m_hb_activity.need_count);
                  stringBuilder.append("");
                  recordingOnliveFragment.b(String.format(str1, new Object[] { stringBuilder.toString(), CommonStringUtils.d(Double.toString(param1LiveRewardDescribe.m_hb_activity.beans)) }));
                  return;
                } 
              } 
            } else if (((PayRemaining)recordingOnliveFragment).sendGiftStatus == 2) {
              LiveRoomHttpUtils.a();
            } 
          }
        });
  }
  
  private void h() {
    this.e = LayoutInflater.from(this.d);
    a();
    this.b = this.a.findViewById(R.id.tv_bg);
    this.k = (ProgressBar)this.a.findViewById(R.id.pro_bar);
    this.b.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        });
    this.c = this.a.findViewById(R.id.ll_content);
    this.c.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        });
    this.n = (ImageView)this.a.findViewById(R.id.live_activity_close);
    this.o = (FrameLayout)findViewById(R.id.live_activity_result_layout);
    this.p = (ImageView)findViewById(R.id.live_activity_result_image);
    this.q = (TextView)findViewById(R.id.live_activity_result_text);
    this.r = (Button)findViewById(R.id.live_activity_result_btn);
    this.n.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.d();
          }
        });
    this.f = findViewById(R.id.ll_title_layout);
    this.g = (TextView)findViewById(R.id.tv_title);
    this.h = (ImageView)findViewById(R.id.iv_back);
    this.h.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.f();
          }
        });
  }
  
  private void i() {
    WebView webView = this.m;
    if (webView != null && webView.getVisibility() == 0)
      this.m.reload(); 
  }
  
  private void j() {
    this.m = (WebView)this.a.findViewById(R.id.live_activity_webview);
    this.m.setLongClickable(true);
    this.m.setOnLongClickListener(new View.OnLongClickListener(this) {
          public boolean onLongClick(View param1View) {
            return true;
          }
        });
    this.m.setBackgroundColor(0);
    this.l = new BluedWebView(this.s, this.m, null, (BluedWebView.WebCallback)new LiveWebCallBack(this) {
          public void a(BluedWebView param1BluedWebView, int param1Int) {}
          
          public void a(BluedWebView param1BluedWebView, int param1Int, String param1String1, String param1String2) {}
          
          public void a(BluedWebView param1BluedWebView, String param1String) {
            if (PopLiveActivityWebView.b(this.a))
              PopLiveActivityWebView.c(this.a).setText(param1String); 
          }
          
          public void a(BluedWebView param1BluedWebView, String param1String, boolean param1Boolean) {}
          
          public boolean a(BluedWebView param1BluedWebView, BluedUrlParser param1BluedUrlParser) {
            String str;
            if ("liveplay".equals(param1BluedUrlParser.a()) && !LiveRoomManager.a().C()) {
              String str3 = (String)param1BluedUrlParser.b().get("lid");
              String str2 = (String)param1BluedUrlParser.b().get("uid");
              String str1 = str2;
              if (!TextUtils.isEmpty(str2))
                str1 = EncryptTool.a(str2); 
              str2 = (String)param1BluedUrlParser.b().get("from");
              str = str2;
              if (TextUtils.isEmpty(str2))
                str = "web"; 
              LiveRoomData liveRoomData = new LiveRoomData(CommonTools.a(str3), 0, str, str1, "", "", 0);
              PlayingOnliveFragment.a(this.a.getContext(), liveRoomData);
              return true;
            } 
            boolean bool = "liveroom_card".equals(str.a());
            int i = 0;
            if (bool) {
              if (str.b() != null) {
                String str1 = EncryptTool.a((String)str.b().get("uid"));
                LiveSetDataObserver.a().a(str1, 1);
                return true;
              } 
            } else {
              if ("liveroom_gift".equals(str.a())) {
                Map map2;
                Map map3;
                Map map1 = str.b();
                String str1 = null;
                if (map1 != null) {
                  String str5 = (String)str.b().get("goods_id");
                  i = Integer.parseInt((String)str.b().get("count"));
                  String str3 = (String)str.b().get("images_static");
                  String str2 = (String)str.b().get("fun");
                  String str4 = (String)str.b().get("errfun");
                  str = str5;
                } else {
                  map2 = null;
                  map1 = map2;
                  Map map = map1;
                  map3 = map1;
                  str = str1;
                  map1 = map;
                } 
                LiveGiftModel liveGiftModel = new LiveGiftModel();
                liveGiftModel.goods_id = str;
                liveGiftModel.count = i;
                liveGiftModel.images_static = (String)map2;
                liveGiftModel.selectNumModel = new LiveGiftNumberModel();
                liveGiftModel.selectNumModel.count = i;
                this.a.a(liveGiftModel, (String)map1, (String)map3);
                return true;
              } 
              if ("liveroom_close_dialog".equals(str.a())) {
                this.a.d();
                return true;
              } 
              if ("live_sendRP".equals(str.a())) {
                if (str.b() != null) {
                  LiveRewardConfigModel liveRewardConfigModel = new LiveRewardConfigModel();
                  liveRewardConfigModel.beans = Integer.parseInt((String)str.b().get("beans"));
                  liveRewardConfigModel.count = Integer.parseInt((String)str.b().get("count"));
                  liveRewardConfigModel.condition = (String)str.b().get("condition");
                  liveRewardConfigModel.size = (String)str.b().get("size");
                  liveRewardConfigModel.hb_beans_id = Integer.parseInt((String)str.b().get("id"));
                  PopLiveActivityWebView.a(this.a, liveRewardConfigModel);
                } 
                return true;
              } 
            } 
            return false;
          }
          
          public void b(BluedWebView param1BluedWebView, String param1String, boolean param1Boolean) {
            PopLiveActivityWebView.a(this.a, true);
            PopLiveActivityWebView.d(this.a).setVisibility(8);
            if (PopLiveActivityWebView.e(this.a) == 0 || PopLiveActivityWebView.e(this.a) == -1) {
              PopLiveActivityWebView.f(this.a).setVisibility(8);
            } else {
              PopLiveActivityWebView.f(this.a).setVisibility(0);
            } 
            PopLiveActivityWebView.a(this.a).setVisibility(0);
            if (PopLiveActivityWebView.b(this.a))
              PopLiveActivityWebView.g(this.a).setVisibility(0); 
            if (!PopLiveActivityWebView.h(this.a)) {
              PopLiveActivityWebView.i(this.a).c().clearHistory();
              PopLiveActivityWebView.b(this.a, true);
              if (PopLiveActivityWebView.e(this.a) != -1) {
                if (PopLiveActivityWebView.e(this.a) == 0) {
                  this.a.c.startAnimation(AnimationUtils.loadAnimation(this.a.d, R.anim.pop_down_in));
                  return;
                } 
                this.a.c.startAnimation(AnimationUtils.loadAnimation(this.a.d, R.anim.push_center_in));
              } 
            } 
          }
        });
  }
  
  public void a() {
    this.a = this.e.inflate(R.layout.pop_live_activity, (ViewGroup)this);
  }
  
  public void a(Fragment paramFragment) {
    this.s = paramFragment;
    j();
  }
  
  public void a(LiveGiftModel paramLiveGiftModel, String paramString1, String paramString2) {
    long l;
    String str;
    if (LiveRoomManager.a().h() == null)
      return; 
    Fragment fragment = this.s;
    if (!(fragment instanceof BaseFragment))
      return; 
    BaseFragment baseFragment = (BaseFragment)fragment;
    if (baseFragment instanceof PlayingOnliveFragment) {
      l = ((PlayingOnliveFragment)baseFragment).u;
      str = LiveRoomManager.a().e();
    } else {
      l = ((RecordingOnliveFragment)str).u;
      str = LiveRoomInfo.a().f();
    } 
    LiveGiftPayTools.a().a(this.d, this.u, l, (IRequestHost)baseFragment.w_(), paramLiveGiftModel, str, "", paramLiveGiftModel.count, new LiveGiftPayTools.BackGiftStatusListener(this, paramString1, paramString2) {
          public void a() {}
          
          public void a(LiveGiftModel param1LiveGiftModel1, LiveGiftModel param1LiveGiftModel2, List<LiveGiftModel> param1List) {
            AppInfo.n().post(new Runnable(this, param1LiveGiftModel2) {
                  public void run() {
                    if (this.a.sendGiftStatus == 3) {
                      if (!TextUtils.isEmpty(this.b.a)) {
                        WebView webView = PopLiveActivityWebView.a(this.b.c);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("javascript:");
                        stringBuilder.append(this.b.a);
                        webView.loadUrl(stringBuilder.toString());
                        return;
                      } 
                    } else if (!TextUtils.isEmpty(this.b.b)) {
                      WebView webView = PopLiveActivityWebView.a(this.b.c);
                      StringBuilder stringBuilder = new StringBuilder();
                      stringBuilder.append("javascript:");
                      stringBuilder.append(this.b.b);
                      webView.loadUrl(stringBuilder.toString());
                    } 
                  }
                });
          }
        });
  }
  
  public void a(String paramString) {
    d();
    AppMethods.a(paramString);
  }
  
  public void a(String paramString, int paramInt) {
    String str;
    if (LiveRoomManager.a().h() == null)
      return; 
    Fragment fragment = this.s;
    if (!(fragment instanceof BaseFragment))
      return; 
    BaseFragment baseFragment = (BaseFragment)fragment;
    long l = 0L;
    if (baseFragment instanceof PlayingOnliveFragment) {
      l = ((PlayingOnliveFragment)baseFragment).u;
      str = LiveRoomManager.a().e();
    } else if (baseFragment instanceof RecordingOnliveFragment) {
      l = ((RecordingOnliveFragment)str).u;
      str = LiveRoomInfo.a().f();
    } else {
      str = "";
    } 
    LiveGiftModel liveGiftModel = new LiveGiftModel();
    liveGiftModel.goods_id = paramString;
    LiveGiftPayTools.a().a(this.d, this.u, l, (IRequestHost)baseFragment.w_(), liveGiftModel, str, "", 1, new LiveGiftPayTools.BackGiftStatusListener(this) {
          public void a() {}
          
          public void a(LiveGiftModel param1LiveGiftModel1, LiveGiftModel param1LiveGiftModel2, List<LiveGiftModel> param1List) {
            AppInfo.n().post(new Runnable(this, param1LiveGiftModel2, param1LiveGiftModel1) {
                  public void run() {
                    if (this.a.sendGiftStatus == 3) {
                      this.c.a.b();
                      return;
                    } 
                    if (!TextUtils.isEmpty(this.b.errorMessage))
                      this.c.a.a(this.b.errorMessage); 
                  }
                });
          }
        });
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean) {
    boolean bool;
    this.t = false;
    this.w = paramInt;
    this.v = paramString;
    setVisibility(0);
    this.f.setVisibility(8);
    if ((paramInt == 0 || paramInt == -1) && !TextUtils.isEmpty(paramString) && !paramString.contains("blued_mode=hide_nav")) {
      bool = true;
    } else {
      bool = false;
    } 
    this.i = bool;
    this.j = false;
    this.k.setVisibility(0);
    this.c.setVisibility(0);
    this.c.clearAnimation();
    this.m.stopLoading();
    if (paramBoolean)
      this.m.setVisibility(4); 
    this.l.a(paramString);
    this.o.setVisibility(8);
    this.n.setVisibility(8);
    if (paramInt != -1) {
      if (paramInt == 0) {
        this.b.setVisibility(8);
        LiveEventBus.get("live_show_dialog").post(Boolean.valueOf(true));
      } else {
        this.b.setVisibility(0);
      } 
      AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 0.5F);
      alphaAnimation.setDuration(300L);
      alphaAnimation.setFillAfter(true);
      this.b.startAnimation((Animation)alphaAnimation);
      alphaAnimation.setAnimationListener(new Animation.AnimationListener(this) {
            public void onAnimationEnd(Animation param1Animation) {}
            
            public void onAnimationRepeat(Animation param1Animation) {}
            
            public void onAnimationStart(Animation param1Animation) {}
          });
      return;
    } 
    this.b.setVisibility(8);
  }
  
  public void b() {
    d();
    int i = this.w;
    if (i == 1) {
      AppMethods.d(R.string.live_fist_top_up_success);
    } else if (i == 2) {
      AppMethods.d(R.string.live_top_up_success);
    } 
    LiveEventBus.get("live_playing_hide_activity_pop").post(Boolean.valueOf(false));
  }
  
  public void b(String paramString, int paramInt) {
    a(paramString, paramInt, true);
  }
  
  public void c() {
    i();
  }
  
  public void d() {
    if (this.c.getVisibility() == 8)
      return; 
    LiveEventBus.get("live_show_dialog").post(Boolean.valueOf(false));
    if (this.w != -1) {
      AlphaAnimation alphaAnimation = new AlphaAnimation(0.5F, 0.0F);
      alphaAnimation.setDuration(300L);
      alphaAnimation.setFillAfter(true);
      this.b.startAnimation((Animation)alphaAnimation);
      alphaAnimation.setAnimationListener(new Animation.AnimationListener(this) {
            public void onAnimationEnd(Animation param1Animation) {
              this.a.setVisibility(8);
            }
            
            public void onAnimationRepeat(Animation param1Animation) {}
            
            public void onAnimationStart(Animation param1Animation) {}
          });
      if (this.w == 0) {
        this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.pop_down_out));
      } else {
        this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_center_out));
      } 
      this.c.setVisibility(8);
      this.n.setVisibility(8);
    } 
    PopLiveWebEvent popLiveWebEvent = this.x;
    if (popLiveWebEvent != null)
      popLiveWebEvent.f(); 
  }
  
  public boolean e() {
    boolean bool;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("isShow =");
    if (getVisibility() == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    stringBuilder.append(bool);
    Log.v("pk", stringBuilder.toString());
    return (getVisibility() == 0);
  }
  
  public void f() {
    BluedWebView bluedWebView = this.l;
    if (bluedWebView != null && bluedWebView.c().canGoBack() && this.t) {
      this.l.c().goBack();
      return;
    } 
    d();
  }
  
  public void g() {
    BluedWebView bluedWebView = this.l;
    if (bluedWebView != null)
      bluedWebView.a(this.v); 
  }
  
  public void setPopLiveWebEvent(PopLiveWebEvent paramPopLiveWebEvent) {
    this.x = paramPopLiveWebEvent;
  }
  
  public static interface PopLiveWebEvent {
    void f();
  }
  
  public static interface URL_TYPE {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\PopLiveActivityWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */