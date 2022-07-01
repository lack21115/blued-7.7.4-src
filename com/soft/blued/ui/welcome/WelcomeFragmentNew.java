package com.soft.blued.ui.welcome;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.urlroute.BluedURIRouter;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.module.device_identity.library.BluedDeviceIdentity;
import com.blued.android.ui.TimeoutFragment;
import com.blued.das.login.LoginAndRegisterProtos;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.http.BluedHttpUrl;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.http.HttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackLoginAndRegister;
import com.soft.blued.push.PushManager;
import com.soft.blued.ui.feed.model.BluedADExtra;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.home.manager.WelcomeADManager;
import com.soft.blued.ui.login_register.SignInActivity;
import com.soft.blued.ui.welcome.model.SplashEntity;
import com.soft.blued.ui.welcome.model.SplashExtraEntity;
import com.soft.blued.ui.welcome.observer.ADDownloadObserver;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.io.File;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class WelcomeFragmentNew extends TimeoutFragment implements View.OnClickListener, ADDownloadObserver.IADDownloadObserver {
  private static final String d = WelcomeFragmentNew.class.getSimpleName();
  
  private long A;
  
  private long B;
  
  private long C;
  
  private Runnable D = new Runnable(this) {
      public void run() {
        if (WelcomeFragmentNew.j(this.a))
          return; 
        if (WelcomeFragmentNew.k(this.a))
          return; 
        if (WelcomeFragmentNew.l(this.a) == 0) {
          WelcomeFragmentNew.a(this.a, "adsShowCountdownTask adsCountDown == 0");
          return;
        } 
        TextView textView = WelcomeFragmentNew.i(this.a);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(WelcomeFragmentNew.l(this.a));
        stringBuilder.append("");
        textView.setText(stringBuilder.toString());
        WelcomeFragmentNew.m(this.a);
        if (WelcomeFragmentNew.l(this.a) == 0) {
          AppInfo.n().post(this);
          return;
        } 
        AppInfo.n().postDelayed(this, 1000L);
      }
    };
  
  private boolean e = true;
  
  private boolean f = true;
  
  private Runnable g = null;
  
  private long h = 1000L;
  
  private Context i;
  
  private View j;
  
  private ImageView k;
  
  private TextView l;
  
  private ImageView m;
  
  private LinearLayout n;
  
  private boolean o;
  
  private boolean p;
  
  private boolean q;
  
  private int r = 5;
  
  private ImageView s;
  
  private Timer t;
  
  private boolean u = false;
  
  private boolean v = false;
  
  private long w;
  
  private final int x = 101;
  
  private final int y = 102;
  
  private final int z = 103;
  
  public static void a(Context paramContext, boolean paramBoolean) {
    a(paramContext, paramBoolean, true);
  }
  
  public static void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2) {
    Bundle bundle = new Bundle();
    bundle.putBoolean("arg_show_ad", paramBoolean1);
    bundle.putBoolean("arg_open_home", paramBoolean2);
    bundle.putInt("timeout_ms", 5000);
    WelcomeActivity.a(bundle);
    WelcomeActivity.b(paramContext, (Class)WelcomeFragmentNew.class, bundle);
  }
  
  public static void b(Context paramContext, boolean paramBoolean) {
    Logger.c(d, new Object[] { "welcomeadljx", "skipWelcome start" });
    BluedDeviceIdentity bluedDeviceIdentity = BluedDeviceIdentity.a();
    Context context = AppInfo.d();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/blued/device");
    bluedDeviceIdentity.a(context, stringBuilder.toString(), "com.bluecity.blued-KPiA1xP30QYJy", "3UOTFs6sc6mC8ZTmjKckn3cWfnk7hIbS");
    if (!GuideFragment.a(paramContext))
      if (UserInfo.a().j()) {
        if (paramBoolean) {
          String str = d;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("skipWelcome openHome:");
          stringBuilder1.append(paramBoolean);
          Logger.c(str, new Object[] { "welcomeadljx", stringBuilder1.toString() });
          HomeArgumentHelper.a(paramContext);
        } else {
          if (BluedApplicationLike.outUri != null) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("skipWelcome BluedApplicationLike.outUri:");
            stringBuilder1.append(BluedApplicationLike.outUri);
            Log.v("drb", stringBuilder1.toString());
            BluedURIRouter.a().a(paramContext, BluedApplicationLike.outUri);
            BluedApplicationLike.outUri = null;
          } 
          if (paramContext instanceof Activity) {
            Logger.c(d, new Object[] { "welcomeadljx", "((Activity) context).finish()" });
            ((Activity)paramContext).finish();
          } 
        } 
      } else {
        SignInActivity.a(paramContext, new Bundle[0]);
      }  
    DeviceUtils.a(paramContext);
  }
  
  private void b(String paramString) {
    if (!this.o) {
      this.o = true;
      if (this.p && !this.q)
        return; 
      if (this.g != null)
        AppInfo.n().postDelayed(this.g, this.h); 
    } 
  }
  
  private void q() {
    Bundle bundle = getArguments();
    if (bundle != null) {
      this.e = bundle.getBoolean("arg_show_ad");
      this.f = bundle.getBoolean("arg_open_home", this.f);
    } 
    if (this.g == null)
      this.g = new Runnable(this) {
          public void run() {
            if (CommonTools.a((Fragment)this.a)) {
              WelcomeFragmentNew.a(this.a, true);
              WelcomeFragmentNew.a(this.a);
            } 
          }
        }; 
  }
  
  private void r() {
    this.k = (ImageView)this.j.findViewById(2131297893);
    this.s = (ImageView)this.j.findViewById(2131301624);
    this.s.setImageDrawable(this.i.getResources().getDrawable(2131232391));
    this.s.setVisibility(0);
    this.l = (TextView)this.j.findViewById(2131300695);
    this.n = (LinearLayout)this.j.findViewById(2131298750);
    this.n.setOnClickListener(this);
    this.m = (ImageView)this.j.findViewById(2131297421);
  }
  
  private void s() {
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            WelcomeFragmentNew.a(this.a, "judgeLastTo StringDealwith.isEmpty(WelcomeADManager.getInstance().getTodayADPicUrl())||!RecyclingUtils.isFileDownloaded(WelcomeADManager.getInstance().getTodayADPicUrl())");
          }
        }500L);
  }
  
  private boolean t() {
    if (!this.e)
      return false; 
    this.h = 0L;
    try {
      AppInfo.n().post(new Runnable(this) {
            public void run() {
              WelcomeFragmentNew.a(this.a, System.currentTimeMillis());
              ImageLoader.a((IRequestHost)this.a.w_(), WelcomeADManager.a().g()).f().e(-1).a(new ImageLoadResult(this, (IRequestHost)this.a.w_()) {
                    public void a() {
                      if ((WelcomeADManager.a().e()).today != null)
                        FindHttpUtils.a((WelcomeADManager.a().e()).today.show_url); 
                      WelcomeFragmentNew.b(this.a.a, true);
                      AppInfo.n().post(WelcomeFragmentNew.e(this.a.a));
                      BluedPreferences.C(true);
                      WelcomeFragmentNew.f(this.a.a).setVisibility(8);
                      WelcomeFragmentNew.d(this.a.a).setVisibility(0);
                    }
                    
                    public void a(int param2Int, Exception param2Exception) {
                      WelcomeFragmentNew.a(this.a.a, "image onLoadingFailed");
                    }
                  }).a(WelcomeFragmentNew.d(this.a));
              if (WelcomeADManager.a().e() != null && (WelcomeADManager.a().e()).today != null && (WelcomeADManager.a().e()).today.is_show_adm_icon == 1) {
                WelcomeFragmentNew.g(this.a).setVisibility(0);
              } else {
                WelcomeFragmentNew.g(this.a).setVisibility(8);
              } 
              WelcomeFragmentNew.h(this.a).setVisibility(0);
              WelcomeFragmentNew.d(this.a).setOnClickListener(new -$$Lambda$WelcomeFragmentNew$6$W3uhQFVxCJW8AQ8xsEWVuqOdonw(this));
              WelcomeFragmentNew.i(this.a).setVisibility(8);
            }
          });
      return true;
    } catch (Exception exception) {
      exception.printStackTrace();
      b("showPicTimeDown try catch exception");
      return false;
    } 
  }
  
  private void u() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic a : ()Lcom/blued/android/module/device_identity/library/BluedDeviceIdentity;
    //   5: astore_1
    //   6: invokestatic d : ()Landroid/content/Context;
    //   9: astore_2
    //   10: new java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial <init> : ()V
    //   17: astore_3
    //   18: aload_3
    //   19: invokestatic n : ()Ljava/lang/String;
    //   22: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload_3
    //   27: ldc '/blued/device'
    //   29: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_1
    //   34: aload_2
    //   35: aload_3
    //   36: invokevirtual toString : ()Ljava/lang/String;
    //   39: ldc 'com.bluecity.blued-KPiA1xP30QYJy'
    //   41: ldc '3UOTFs6sc6mC8ZTmjKckn3cWfnk7hIbS'
    //   43: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_0
    //   47: getfield u : Z
    //   50: ifeq -> 75
    //   53: aload_0
    //   54: getfield j : Landroid/view/View;
    //   57: new com/soft/blued/ui/welcome/WelcomeFragmentNew$8
    //   60: dup
    //   61: aload_0
    //   62: invokespecial <init> : (Lcom/soft/blued/ui/welcome/WelcomeFragmentNew;)V
    //   65: lconst_0
    //   66: invokevirtual postDelayed : (Ljava/lang/Runnable;J)Z
    //   69: pop
    //   70: aload_0
    //   71: iconst_0
    //   72: putfield u : Z
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    // Exception table:
    //   from	to	target	type
    //   2	75	78	finally
  }
  
  public TimerTask a(String paramString) {
    return new TimerTask(this, paramString) {
        public void run() {
          SplashEntity splashEntity = WelcomeADManager.a().e();
          if (splashEntity != null && splashEntity.today != null) {
            if (!"0".equalsIgnoreCase(splashEntity.today.adms_type)) {
              this.b.a(splashEntity.today, splashEntity.third_id);
              return;
            } 
            if (!StringUtils.e(WelcomeADManager.a().g())) {
              ImageFileLoader.a((IRequestHost)this.b.w_()).b(WelcomeADManager.a().g()).a(new ImageFileLoader.OnLoadFileListener(this) {
                    public void onUIFinish(File param2File, Exception param2Exception) {
                      if (param2File != null && param2File.exists()) {
                        this.a.b.k();
                        return;
                      } 
                      WelcomeFragmentNew welcomeFragmentNew = this.a.b;
                      StringBuilder stringBuilder = new StringBuilder();
                      stringBuilder.append("getFinishTask:");
                      stringBuilder.append(this.a.a);
                      WelcomeFragmentNew.a(welcomeFragmentNew, stringBuilder.toString());
                    }
                  }).a();
              return;
            } 
            WelcomeFragmentNew welcomeFragmentNew1 = this.b;
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("getFinishTask:");
            stringBuilder1.append(this.a);
            WelcomeFragmentNew.a(welcomeFragmentNew1, stringBuilder1.toString());
            return;
          } 
          WelcomeFragmentNew welcomeFragmentNew = this.b;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("getFinishTask:");
          stringBuilder.append(this.a);
          WelcomeFragmentNew.a(welcomeFragmentNew, stringBuilder.toString());
        }
      };
  }
  
  public void a() {
    b(this.i, true);
  }
  
  public void a(SplashEntity.ShowEntity paramShowEntity, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("showThirdSplash:");
    stringBuilder.append(paramShowEntity.adms_type);
    Logger.a("drb", new Object[] { stringBuilder.toString() });
    if (paramShowEntity != null) {
      this.C = System.currentTimeMillis();
      if ("4".equalsIgnoreCase(paramShowEntity.adms_type)) {
        TTADSplashFragment.a((Fragment)this, paramShowEntity, paramString, 102);
        return;
      } 
      if ("3".equalsIgnoreCase(paramShowEntity.adms_type)) {
        TXSplashFragment.a((Fragment)this, paramShowEntity, 101);
        return;
      } 
      b("no_match_third_type");
    } 
  }
  
  public boolean j() {
    return false;
  }
  
  public void k() {
    Timer timer = this.t;
    if (timer != null) {
      timer.cancel();
      this.t.purge();
      this.t = null;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("judgeLastTo = ");
    stringBuilder.append(WelcomeADManager.a().g());
    Logger.e("xxx", new Object[] { stringBuilder.toString() });
    if (!StringUtils.e(WelcomeADManager.a().g())) {
      ImageFileLoader.a((IRequestHost)w_()).b(WelcomeADManager.a().g()).a(new ImageFileLoader.OnLoadFileListener(this) {
            public void onUIFinish(File param1File, Exception param1Exception) {
              if (param1File != null && param1File.exists()) {
                if (!WelcomeFragmentNew.b(this.a)) {
                  WelcomeFragmentNew.a(this.a, "judgeLastTo showPicTimeDown()==false");
                  return;
                } 
              } else {
                WelcomeFragmentNew.c(this.a);
              } 
            }
          }).a();
      return;
    } 
    s();
  }
  
  public void l() {
    if (WelcomeADManager.a().e() != null && (WelcomeADManager.a().e()).today != null) {
      if ((WelcomeADManager.a().e()).today.click_url != null && (WelcomeADManager.a().e()).today.click_url.length > 0) {
        for (int i = 0; i < (WelcomeADManager.a().e()).today.click_url.length; i++) {
          String str2 = (WelcomeADManager.a().e()).today.click_url[i];
          String str1 = str2;
          if (str2.startsWith(BluedHttpUrl.n()))
            if (this.v) {
              Map<String, String> map = BluedHttpTools.a();
              map.put("is_valid", "0");
              String str = HttpUtils.a(map, str2);
            } else {
              Map<String, String> map = BluedHttpTools.a();
              map.put("is_valid", "1");
              str1 = HttpUtils.a(map, str2);
            }  
          FindHttpUtils.a(str1);
        } 
        this.v = true;
      } 
      SplashEntity.ShowEntity showEntity = (WelcomeADManager.a().e()).today;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("intoADUrl adExtra.deep_link_url:");
      stringBuilder.append(((BluedADExtra)showEntity).deep_link_url);
      Log.v("drb", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append("intoADUrl adExtra.target_url:");
      stringBuilder.append(((BluedADExtra)showEntity).target_url);
      Log.v("drb", stringBuilder.toString());
      if (!TextUtils.isEmpty(((BluedADExtra)showEntity).deep_link_url)) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(((BluedADExtra)showEntity).deep_link_url));
        if (AppUtils.a(intent)) {
          EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.JD_AD_TO_APP);
          this.i.startActivity(intent);
          return;
        } 
        BluedApplicationLike.outUri = BluedURIRouter.a().d(((BluedADExtra)showEntity).target_url);
        if (BluedApplicationLike.outUri == null)
          BluedApplicationLike.outUri = BluedURIRouter.a().a(((BluedADExtra)showEntity).target_url, 9); 
        b("intoADUrl");
        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.JD_AD_TO_H5);
        return;
      } 
      BluedApplicationLike.outUri = BluedURIRouter.a().d(((BluedADExtra)showEntity).target_url);
      if (BluedApplicationLike.outUri == null)
        BluedApplicationLike.outUri = BluedURIRouter.a().a(((BluedADExtra)showEntity).target_url, 9); 
      b("intoADUrl");
      EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.JD_AD_TO_H5);
    } 
  }
  
  public void m() {
    SplashExtraEntity splashExtraEntity = WelcomeADManager.a().f();
    if (splashExtraEntity != null && splashExtraEntity.TIMEOUT > 2) {
      long l1 = Long.valueOf(System.currentTimeMillis()).longValue();
      long l2 = this.w;
      Long long_ = Long.valueOf((splashExtraEntity.TIMEOUT * 1000) - Long.valueOf(l1 - l2).longValue());
      if (long_.longValue() <= 0L) {
        k();
        return;
      } 
      Timer timer = this.t;
      if (timer != null) {
        timer.cancel();
        this.t.purge();
        this.t = null;
      } 
      this.t = new Timer();
      this.t.schedule(a("notifyGetADExtraSuccess"), long_.longValue());
    } 
  }
  
  public void n() {
    k();
  }
  
  public void o() {
    Logger.c(d, new Object[] { "welcomeadljx", "been notifyHTTPFinish" });
    if (WelcomeADManager.a().e() != null && (WelcomeADManager.a().e()).today != null && p()) {
      a((WelcomeADManager.a().e()).today, (WelcomeADManager.a().e()).third_id);
      Timer timer = this.t;
      if (timer != null) {
        timer.cancel();
        this.t.purge();
        this.t = null;
        return;
      } 
    } else {
      k();
    } 
  }
  
  public void onActivityCreated(Bundle paramBundle) {
    super.onActivityCreated(paramBundle);
    int i = WelcomeADManager.a().h();
    if (i != -1) {
      if (i != 0) {
        if (i != 1)
          return; 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("case WelcomeADManager.HAS_AD_STATUS.HAS_AD:");
        stringBuilder.append((WelcomeADManager.a().e()).today.adms_type);
        Log.v("drb", stringBuilder.toString());
        if (p()) {
          Timer timer1 = this.t;
          if (timer1 != null) {
            timer1.cancel();
            this.t.purge();
            this.t = null;
          } 
          a((WelcomeADManager.a().e()).today, (WelcomeADManager.a().e()).third_id);
          return;
        } 
        if (!StringUtils.e(WelcomeADManager.a().g())) {
          ImageFileLoader.a((IRequestHost)w_()).b(WelcomeADManager.a().g()).a(new ImageFileLoader.OnLoadFileListener(this) {
                public void onUIFinish(File param1File, Exception param1Exception) {
                  if (param1File != null && param1File.exists()) {
                    this.a.k();
                    return;
                  } 
                  this.a.m();
                  ADDownloadObserver.a().a(this.a);
                }
              }).a();
          return;
        } 
        m();
        ADDownloadObserver.a().a(this);
        return;
      } 
      k();
      return;
    } 
    long l2 = 2000L;
    long l1 = l2;
    if (this.w > 0L) {
      l1 = System.currentTimeMillis() - this.w;
      if (l1 < 2000L) {
        l1 = 2000L - l1;
      } else {
        k();
        l1 = l2;
      } 
    } 
    Timer timer = this.t;
    if (timer != null) {
      timer.cancel();
      this.t.purge();
      this.t = null;
    } 
    this.t = new Timer();
    this.t.schedule(a("onCreateView no response yet"), l1);
    ADDownloadObserver.a().a(this);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    // Byte code:
    //   0: aload_0
    //   1: getfield i : Landroid/content/Context;
    //   4: aload_0
    //   5: getfield f : Z
    //   8: invokestatic b : (Landroid/content/Context;Z)V
    //   11: aload_3
    //   12: ifnull -> 94
    //   15: aload_0
    //   16: getfield C : J
    //   19: aload_0
    //   20: getfield A : J
    //   23: lsub
    //   24: l2i
    //   25: istore #5
    //   27: aload_3
    //   28: ldc_w 'THIRD_UNVALID_DURATION'
    //   31: lconst_0
    //   32: invokevirtual getLongExtra : (Ljava/lang/String;J)J
    //   35: lstore #6
    //   37: lload #6
    //   39: lconst_0
    //   40: lcmp
    //   41: ifeq -> 69
    //   44: aload_0
    //   45: getfield C : J
    //   48: lstore #8
    //   50: lload #6
    //   52: lload #8
    //   54: lcmp
    //   55: ifle -> 69
    //   58: lload #6
    //   60: lload #8
    //   62: lsub
    //   63: l2i
    //   64: istore #4
    //   66: goto -> 72
    //   69: iconst_0
    //   70: istore #4
    //   72: aload_3
    //   73: ldc_w 'THIRD_HAS_CALL_BACK'
    //   76: iconst_0
    //   77: invokevirtual getBooleanExtra : (Ljava/lang/String;Z)Z
    //   80: istore #10
    //   82: getstatic com/blued/das/login/LoginAndRegisterProtos$Event.OPEN_PAGE_CREATE_TO_SHOW_DURATION : Lcom/blued/das/login/LoginAndRegisterProtos$Event;
    //   85: iload #5
    //   87: iload #4
    //   89: iload #10
    //   91: invokestatic a : (Lcom/blued/das/login/LoginAndRegisterProtos$Event;IIZ)V
    //   94: aload_0
    //   95: iload_1
    //   96: iload_2
    //   97: aload_3
    //   98: invokespecial onActivityResult : (IILandroid/content/Intent;)V
    //   101: return
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() != 2131298750)
      return; 
    InstantLog.a("splash_ad_skip");
    if (WelcomeADManager.a().e() != null && (WelcomeADManager.a().e()).today != null && (WelcomeADManager.a().e()).today.hidden_url != null && (WelcomeADManager.a().e()).today.hidden_url.length > 0)
      for (int i = 0; i < (WelcomeADManager.a().e()).today.hidden_url.length; i++)
        FindHttpUtils.a((WelcomeADManager.a().e()).today.hidden_url[i]);  
    b("onClick ll_click_skip");
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    TXSplashFragment.g = false;
    this.i = (Context)getActivity();
    PushManager.a().a((Activity)getActivity());
    WelcomeADManager.a().a(true);
    BluedPreferences.C(false);
    q();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    Logger.c("welcomeadljx", new Object[] { "welcome oncreate view" });
    this.w = System.currentTimeMillis();
    View view = this.j;
    if (view == null) {
      this.j = paramLayoutInflater.inflate(2131493367, paramViewGroup, false);
      r();
      u();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.j.getParent()).removeView(this.j);
    } 
    Logger.c("welcomeadljx", new Object[] { "welcome oncreate view finish" });
    return this.j;
  }
  
  public void onDestroy() {
    super.onDestroy();
    BluedPreferences.H(false);
    WelcomeADManager.a().a(false);
    if (this.g != null) {
      AppInfo.n().removeCallbacks(this.g);
      this.g = null;
    } 
    ADDownloadObserver.a().b(this);
    WelcomeADManager.a().d();
  }
  
  public void onStart() {
    super.onStart();
    BluedPreferences.H(true);
    if (this.p)
      if (this.q) {
        AppInfo.n().post(this.D);
      } else if (this.g != null) {
        AppInfo.n().postDelayed(this.g, this.h);
      }  
    this.p = false;
  }
  
  public void onStop() {
    super.onStop();
    this.p = true;
    if (this.g != null)
      AppInfo.n().removeCallbacks(this.g); 
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    this.A = System.currentTimeMillis();
  }
  
  public boolean p() {
    return ("4".equalsIgnoreCase((WelcomeADManager.a().e()).today.adms_type) || "3".equalsIgnoreCase((WelcomeADManager.a().e()).today.adms_type));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\welcome\WelcomeFragmentNew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */