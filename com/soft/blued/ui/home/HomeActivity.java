package com.soft.blued.ui.home;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityStack;
import com.blued.android.core.ui.BaseActivity;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.badgeview.Badge;
import com.blued.android.framework.view.badgeview.QBadgeContainer;
import com.blued.das.authority.SystemAuthorityProtos;
import com.blued.das.message.MessageProtos;
import com.blued.das.settings.SettingsProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.constant.CommonConstants;
import com.soft.blued.customview.MyFragmentTabHost;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.http.H5Url;
import com.soft.blued.http.NearbyHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackMessage;
import com.soft.blued.log.trackUtils.EventTrackSettings;
import com.soft.blued.log.trackUtils.EventTrackSystemAuthority;
import com.soft.blued.push.PushManager;
import com.soft.blued.ui.discover.fragment.DiscoveryPageFragment;
import com.soft.blued.ui.discover.fragment.SendFeedFloatManager;
import com.soft.blued.ui.discover.observer.SystemNoticeViewModel;
import com.soft.blued.ui.find.fragment.NearbyHomeFragment;
import com.soft.blued.ui.find.observer.UserInfoDataObserver;
import com.soft.blued.ui.home.model.PhoneDialogModel;
import com.soft.blued.ui.live.fragment.LiveFragment;
import com.soft.blued.ui.live.presenter.LiveListManager;
import com.soft.blued.ui.login_register.model.MarketPraiseGuide;
import com.soft.blued.ui.mine.fragment.MineFragment;
import com.soft.blued.ui.msg.MessagePageFragment;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.model.MsgBoxSettingResponse;
import com.soft.blued.ui.notify.model.ViewpointNoticeCount;
import com.soft.blued.ui.setting.fragment.LockPatternSetupFragment;
import com.soft.blued.ui.user.manager.VipBubbleManager;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.ExperimentConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.DurationUtils;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.MarketTool;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import com.soft.blued.view.tip.dialog.BluedAlertDialog;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HomeActivity extends BaseFragmentActivity implements View.OnClickListener, HomeContract.View {
  public static HomeActivity c;
  
  public boolean d = false;
  
  private MyFragmentTabHost e;
  
  private String f = "";
  
  private String g = "";
  
  private LinearLayout h;
  
  private TabHost.TabSpec i;
  
  private Map<String, TabItem> j = (Map<String, TabItem>)new ArrayMap();
  
  private HomeContract.Presenter k;
  
  private View l;
  
  private boolean m = false;
  
  private List<QBadgeContainer> n = new ArrayList<QBadgeContainer>();
  
  private void a(Intent paramIntent) {
    this.n.clear();
    this.l = findViewById(2131296555);
    this.l.setBackgroundColor(BluedSkinUtils.a((Context)this, 2131100840));
    this.h = (LinearLayout)findViewById(2131299196);
    this.e = (MyFragmentTabHost)findViewById(16908306);
    this.e.setup((Context)this, getSupportFragmentManager(), 16908305);
    TabItem tabItem = new TabItem();
    tabItem.a = (ViewGroup)findViewById(2131298934);
    tabItem.f = (QBadgeContainer)findViewById(2131297060);
    tabItem.f.a((View)tabItem.a);
    tabItem.b = (ImageView)findViewById(2131297842);
    tabItem.c = 2131232504;
    tabItem.d = 2131232502;
    tabItem.e = (TextView)findViewById(2131301015);
    tabItem.h = findViewById(2131300770);
    tabItem.g = (ImageView)findViewById(2131297771);
    tabItem.a.setOnClickListener(this);
    tabItem.f.setBackgroundColor(BluedSkinUtils.a((Context)this, 2131100728));
    tabItem.f.a(BluedSkinUtils.a((Context)this, 2131100728), 1.0F, true);
    this.j.put("find", tabItem);
    this.i = this.e.newTabSpec("find").setIndicator("find");
    this.e.addTab(this.i, NearbyHomeFragment.class, HomeArgumentHelper.a(paramIntent));
    this.n.add(tabItem.f);
    tabItem = new TabItem();
    tabItem.a = (ViewGroup)findViewById(2131298935);
    tabItem.f = (QBadgeContainer)findViewById(2131298174);
    tabItem.f.a((View)tabItem.a);
    tabItem.a.setVisibility(0);
    tabItem.b = (ImageView)findViewById(2131297843);
    tabItem.c = 2131232570;
    tabItem.d = 2131232564;
    tabItem.e = (TextView)findViewById(2131301016);
    tabItem.g = (ImageView)findViewById(2131297832);
    tabItem.h = findViewById(2131300977);
    tabItem.a.setOnClickListener(this);
    tabItem.f.setBackgroundColor(BluedSkinUtils.a((Context)this, 2131100728));
    tabItem.f.a(BluedSkinUtils.a((Context)this, 2131100728), 1.0F, true);
    this.j.put("live", tabItem);
    this.i = this.e.newTabSpec("live").setIndicator("live");
    this.e.addTab(this.i, LiveFragment.class, HomeArgumentHelper.a(paramIntent));
    if (BluedPreferences.aP()) {
      d("live");
    } else {
      e("live");
    } 
    this.n.add(tabItem.f);
    tabItem = new TabItem();
    tabItem.a = (ViewGroup)findViewById(2131298933);
    tabItem.f = (QBadgeContainer)findViewById(2131297033);
    tabItem.f.a((View)tabItem.a);
    tabItem.b = (ImageView)findViewById(2131297841);
    tabItem.c = 2131232471;
    tabItem.d = 2131232470;
    tabItem.e = (TextView)findViewById(2131301014);
    tabItem.g = (ImageView)findViewById(2131297764);
    tabItem.h = findViewById(2131300758);
    tabItem.a.setOnClickListener(this);
    tabItem.f.setBackgroundColor(BluedSkinUtils.a((Context)this, 2131100728));
    tabItem.f.a(BluedSkinUtils.a((Context)this, 2131100728), 1.0F, true);
    this.j.put("feed", tabItem);
    this.i = this.e.newTabSpec("feed").setIndicator("feed");
    this.e.addTab(this.i, DiscoveryPageFragment.class, HomeArgumentHelper.a(paramIntent));
    this.n.add(tabItem.f);
    tabItem = new TabItem();
    tabItem.a = (ViewGroup)findViewById(2131298936);
    tabItem.f = (QBadgeContainer)findViewById(2131299233);
    tabItem.f.a((View)tabItem.a);
    tabItem.b = (ImageView)findViewById(2131297844);
    tabItem.c = 2131232612;
    tabItem.d = 2131232610;
    tabItem.e = (TextView)findViewById(2131301017);
    tabItem.h = findViewById(2131301062);
    tabItem.g = (ImageView)findViewById(2131297865);
    tabItem.a.setOnClickListener(this);
    tabItem.f.setBackgroundColor(BluedSkinUtils.a((Context)this, 2131100728));
    tabItem.f.b(5.0F, true);
    tabItem.f.a.a(BluedSkinUtils.a((Context)this, 2131100728), 1.0F, true);
    this.j.put("msg", tabItem);
    this.i = this.e.newTabSpec("msg").setIndicator("msg");
    this.e.addTab(this.i, MessagePageFragment.class, HomeArgumentHelper.a(paramIntent));
    this.n.add(tabItem.f);
    tabItem = new TabItem();
    tabItem.a = (ViewGroup)findViewById(2131298937);
    tabItem.f = (QBadgeContainer)findViewById(2131299430);
    tabItem.f.a((View)tabItem.a);
    tabItem.b = (ImageView)findViewById(2131297845);
    tabItem.c = 2131232587;
    tabItem.d = 2131232586;
    tabItem.e = (TextView)findViewById(2131301018);
    tabItem.g = (ImageView)findViewById(2131297887);
    tabItem.h = findViewById(2131301151);
    tabItem.a.setOnClickListener(this);
    tabItem.f.setBackgroundColor(BluedSkinUtils.a((Context)this, 2131100728));
    tabItem.f.a(BluedSkinUtils.a((Context)this, 2131100728), 1.0F, true);
    this.j.put("mine", tabItem);
    this.i = this.e.newTabSpec("mine").setIndicator("mine");
    this.e.addTab(this.i, MineFragment.class, HomeArgumentHelper.a(paramIntent));
    if (BluedPreferences.bG())
      d("mine"); 
    this.n.add(tabItem.f);
    if (TextUtils.isEmpty(this.f) || !this.j.containsKey(this.f))
      this.f = "find"; 
    ((TabItem)this.j.get(this.f)).a(true);
    a(this.f);
    this.e.setCurrentTabByTag(this.f);
  }
  
  private void a(boolean paramBoolean, Intent paramIntent) {
    if (paramIntent != null) {
      String str = HomeArgumentHelper.b(paramIntent, "arg_select_tab_tag");
      this.g = HomeArgumentHelper.a(paramIntent, "to_message_tab");
      if ("0".equals(this.g))
        LiveEventBus.get("notice_need_refresh").postDelay(null, 500L); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("toMessageTab = ");
      stringBuilder.append(this.g);
      Logger.c("HomeActivity", new Object[] { stringBuilder.toString() });
      if (!TextUtils.isEmpty(str))
        if (paramBoolean) {
          this.f = str;
        } else if (!TextUtils.isEmpty(str) && !TextUtils.equals(this.f, str)) {
          h(str);
        }  
      HomeArgumentHelper.a((Context)this, paramIntent);
      HomeArgumentHelper.b((Context)this, paramIntent);
    } 
  }
  
  private void b(boolean paramBoolean) {
    NearbyHttpUtils.a(new BluedUIHttpResponse(this) {
          public void onUIUpdate(BluedEntity param1BluedEntity) {}
        },  paramBoolean);
  }
  
  private void h(String paramString) {
    a(paramString, HomeContract.TabRefresh.a);
  }
  
  private void i(String paramString) {
    for (Map.Entry<String, TabItem> entry : this.j.entrySet()) {
      ((TabItem)entry.getValue()).f.setBackgroundColor(BluedSkinUtils.a((Context)this, 2131100728));
      if (TextUtils.equals((CharSequence)entry.getKey(), paramString)) {
        ((TabItem)entry.getValue()).a(true);
        continue;
      } 
      ((TabItem)entry.getValue()).a(false);
    } 
  }
  
  private void l() {}
  
  private void m() {
    NearbyHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<PhoneDialogModel>>(this, (IRequestHost)a()) {
          protected void a(BluedEntityA<PhoneDialogModel> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.getSingleData() != null && ((PhoneDialogModel)param1BluedEntityA.getSingleData()).is_need == 1) {
              EventTrackSystemAuthority.a(SystemAuthorityProtos.Event.PHONE_CONFIRM_POP_SHOW);
              HomeActivity homeActivity = this.a;
              BluedAlertDialog bluedAlertDialog = CommonAlertDialog.a((Context)homeActivity, 0, homeActivity.getResources().getString(2131757906), "", this.a.getResources().getString(2131757908), new -$$Lambda$HomeActivity$3$ANP1_A7xOk6lDH6480BE-w1tv0g(this), this.a.getResources().getString(2131757907), new -$$Lambda$HomeActivity$3$L-DS3HaesJ_rxkayLpIwo2ZOQqc(this), null, 1);
              bluedAlertDialog.b().setTextAlignment(2);
              bluedAlertDialog.c().setVisibility(8);
              bluedAlertDialog.d().setVisibility(8);
              bluedAlertDialog.setCancelable(false);
              TextView textView = new TextView((Context)this.a);
              textView.setTextSize(18.0F);
              textView.setTextColor(BluedSkinUtils.a((Context)this.a, 2131100838));
              textView.setText(((PhoneDialogModel)param1BluedEntityA.getSingleData()).mobile);
              FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
              layoutParams.topMargin = DensityUtils.a((Context)this.a, 5.0F);
              layoutParams.gravity = 1;
              textView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
              textView.setTextAlignment(4);
              FrameLayout frameLayout = (FrameLayout)bluedAlertDialog.a();
              frameLayout.setVisibility(0);
              frameLayout.addView((View)textView);
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            return true;
          }
        }(IRequestHost)a());
  }
  
  private void n() {
    ChatHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<MsgBoxSettingResponse>>(this, (IRequestHost)a()) {
          protected void a(BluedEntityA<MsgBoxSettingResponse> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.data != null) {
              if (param1BluedEntityA.data.size() == 0)
                return; 
              BluedPreferences.aj(((MsgBoxSettingResponse)param1BluedEntityA.data.get(0)).source);
              if (StringUtils.e(((MsgBoxSettingResponse)param1BluedEntityA.data.get(0)).distance)) {
                BluedPreferences.ak("0-0");
              } else {
                BluedPreferences.ak(((MsgBoxSettingResponse)param1BluedEntityA.data.get(0)).distance);
              } 
              int i = ((MsgBoxSettingResponse)param1BluedEntityA.data.get(0)).is_open;
              boolean bool = true;
              if (i != 1)
                bool = false; 
              BluedPreferences.P(bool);
            } 
          }
        }(IRequestHost)a());
  }
  
  private void o() {
    ((SystemNoticeViewModel)ViewModelProviders.of((FragmentActivity)this).get(SystemNoticeViewModel.class)).d.observe((LifecycleOwner)this, new Observer<Integer>(this) {
          public void a(Integer param1Integer) {
            this.a.a("msg", param1Integer.intValue());
          }
        });
  }
  
  private void p() {
    List<QBadgeContainer> list = this.n;
    if (list != null) {
      if (list.isEmpty())
        return; 
      Iterator<QBadgeContainer> iterator = this.n.iterator();
      while (iterator.hasNext())
        ((QBadgeContainer)iterator.next()).a(BluedSkinUtils.a((Context)this, 2131100728), 1.0F, true); 
    } 
  }
  
  public void a(String paramString) {
    for (String str : this.j.keySet()) {
      TabItem tabItem = this.j.get(str);
      if (TextUtils.equals(paramString, str)) {
        tabItem.f.a(new Badge.OnDragStateChangedListener(this) {
              public void a(int param1Int, Badge param1Badge, View param1View) {
                switch (param1View.getId()) {
                  default:
                    return;
                  case 2131298936:
                    if (param1Int == 5) {
                      EventTrackMessage.a(MessageProtos.Event.MSG_UNREAD_DRAG_REMOVE);
                      SystemNoticeViewModel systemNoticeViewModel = (SystemNoticeViewModel)ViewModelProviders.of((FragmentActivity)this.a).get(SystemNoticeViewModel.class);
                      systemNoticeViewModel.b = new ViewpointNoticeCount();
                      systemNoticeViewModel.c = 0;
                      systemNoticeViewModel.a = 0;
                      systemNoticeViewModel.f.postValue(Integer.valueOf(0));
                      LiveEventBus.get("clear_message_chat").post(null);
                      LiveEventBus.get("clear_message_notify").post(null);
                      return;
                    } 
                    break;
                  case 2131298933:
                    if (param1Int == 5) {
                      ChatHelperV4.a().a(3L);
                      ChatHelperV4.a().a(11L);
                      ChatHelperV4.a().a(22L);
                    } 
                    break;
                  case 2131298934:
                  case 2131298935:
                  case 2131298937:
                    break;
                } 
              }
            });
        continue;
      } 
      tabItem.f.a(null);
    } 
  }
  
  public void a(String paramString, int paramInt) {
    TabItem tabItem = this.j.get(paramString);
    if (tabItem != null) {
      if (tabItem.g.getVisibility() != 0)
        tabItem.f.setBageVisible(0); 
      tabItem.f.a(paramInt);
    } 
  }
  
  public void a(String paramString, HomeContract.TabRefresh paramTabRefresh) {
    try {
      this.f = paramString;
      if ((paramTabRefresh == HomeContract.TabRefresh.a && TextUtils.equals(paramString, this.e.getCurrentTabTag())) || paramTabRefresh == HomeContract.TabRefresh.c) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("selectTab===");
        stringBuilder.append(paramString);
        Logger.e("MsgFragment", new Object[] { stringBuilder.toString() });
        HomeTabClick.a(paramString);
      } 
      this.e.setCurrentTabByTag(paramString);
      i(paramString);
      a(paramString);
      boolean bool = "find".equals(paramString);
      if (bool) {
        EventTrackSettings.a(SettingsProtos.Event.APP_NEARBY_CLICK);
      } else if ("msg".equals(paramString)) {
        EventTrackSettings.a(SettingsProtos.Event.APP_MSG_CLICK);
      } else if ("live".equals(paramString)) {
        EventTrackSettings.a(SettingsProtos.Event.APP_LIVE_CLICK);
      } else if ("feed".equals(paramString)) {
        EventTrackSettings.a(SettingsProtos.Event.APP_FIND_CLICK);
      } else if ("mine".equals(paramString)) {
        EventTrackSettings.a(SettingsProtos.Event.APP_ME_CLICK);
      } 
      if ("feed".equals(paramString) && g("feed"))
        e("feed"); 
      if ("live".equals(paramString) && g("live")) {
        e("live");
        BluedPreferences.aQ();
      } 
      if ("msg".equals(paramString))
        LiveEventBus.get("notice_need_refresh").post(null); 
      if ("mine".equals(paramString))
        BluedPreferences.bH(); 
      if ("mine".equals(paramString) && g("mine")) {
        e("mine");
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public void b(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    this.g = stringBuilder.toString();
  }
  
  public void b(String paramString, int paramInt) {
    TabItem tabItem = this.j.get(paramString);
    if (tabItem != null && tabItem.g != null) {
      tabItem.h.setVisibility(8);
      tabItem.f.setBageVisible(4);
      tabItem.g.setImageResource(paramInt);
      tabItem.g.setVisibility(0);
    } 
  }
  
  public boolean b(String paramString) {
    TabItem tabItem = this.j.get(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (tabItem != null) {
      bool1 = bool2;
      if (tabItem.f.getBageVisible() == 0) {
        if (tabItem.f.getBadgeNumber() == 0)
          return false; 
        bool1 = bool2;
        if (tabItem.f.getBageVisible() == 0)
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  public void c(String paramString) {
    TabItem tabItem = this.j.get(paramString);
    if (tabItem != null)
      tabItem.f.b(true); 
  }
  
  public void d(String paramString) {
    if (TextUtils.equals(paramString, "msg"))
      this.d = true; 
    TabItem tabItem = this.j.get(paramString);
    if (tabItem != null) {
      if (this.f == "live")
        return; 
      tabItem.h.setVisibility(0);
    } 
  }
  
  public void e(String paramString) {
    if (TextUtils.equals(paramString, "msg"))
      this.d = false; 
    TabItem tabItem = this.j.get(paramString);
    if (tabItem != null)
      tabItem.h.setVisibility(4); 
  }
  
  public void f(String paramString) {
    TabItem tabItem = this.j.get(paramString);
    if (tabItem != null && tabItem.g != null) {
      tabItem.g.setVisibility(8);
      String str = tabItem.f.getBadgeText();
      if (!TextUtils.isEmpty(str) && !str.equals("0"))
        tabItem.f.setBageVisible(0); 
    } 
  }
  
  public void finish() {
    super.finish();
    Logger.e("HomeActivity", new Object[] { "finish ... " });
  }
  
  public void g() {
    StatusBarHelper.a((Activity)this);
    super.g();
    Log.e("HomeActivity", "HomeActivity apply skin");
    View view = this.l;
    if (view != null)
      view.setBackgroundColor(BluedSkinUtils.a((Context)this, 2131100840)); 
    i(this.f);
    p();
  }
  
  public boolean g(String paramString) {
    TabItem tabItem = this.j.get(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (tabItem != null) {
      bool1 = bool2;
      if (tabItem.h.getVisibility() == 0)
        bool1 = true; 
    } 
    return bool1;
  }
  
  public String h() {
    return this.f;
  }
  
  public int i() {
    return StringUtils.a(this.g, 1);
  }
  
  public void j() {
    MarketPraiseGuide marketPraiseGuide = BluedConfig.b().w();
    if (marketPraiseGuide != null && marketPraiseGuide.count > 0) {
      UserHttpUtils.a("show", 0, marketPraiseGuide.type);
      MarketTool marketTool = MarketTool.a();
      String str1 = marketPraiseGuide.title;
      String str2 = marketPraiseGuide.content;
      String str3 = marketPraiseGuide.confirm;
      String str4 = marketPraiseGuide.cancel;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(marketPraiseGuide.type);
      stringBuilder.append("");
      marketTool.a((Context)this, str1, str2, str3, str4, stringBuilder.toString());
    } 
  }
  
  public void k() {
    String str = BluedPreferences.a("com.soft.blued.icon0");
    if ("com.soft.blued.icon0".equals(str))
      return; 
    PackageManager packageManager = getPackageManager();
    packageManager.setComponentEnabledSetting(new ComponentName((Context)this, str), 2, 1);
    packageManager.setComponentEnabledSetting(new ComponentName((Context)this, "com.soft.blued.icon0"), 1, 1);
    BluedPreferences.b("com.soft.blued.icon0");
  }
  
  public void onBackPressed() {
    this.k.e();
  }
  
  public void onClick(View paramView) {
    switch (paramView.getId()) {
      default:
        return;
      case 2131298937:
        h("mine");
        return;
      case 2131298936:
        h("msg");
        return;
      case 2131298935:
        h("live");
        return;
      case 2131298934:
        h("find");
        return;
      case 2131298933:
        break;
    } 
    h("feed");
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
    AreaUtils.a();
    UserInfoDataObserver.a().b();
  }
  
  public void onCreate(Bundle paramBundle) {
    c = this;
    if (AppInfo.p())
      this.m = StatusBarHelper.a((Activity)this); 
    LiveListManager.a().a((LifecycleOwner)this);
    super.onCreate(paramBundle);
    a(false);
    BluedPreferences.R(true);
    BaseActivity.a = "";
    this.k = new HomePresenter((Context)this, HomeArgumentHelper.a(getIntent(), "from_tag_page"), this, (IRequestHost)a());
    HomeTabClick.a(getClass());
    setContentView(2131492904);
    PushManager.a(getBaseContext());
    if (paramBundle != null)
      this.f = paramBundle.getString("current_tag"); 
    a(true, getIntent());
    a(getIntent());
    o();
    if (!BluedPreferences.A()) {
      if (!BluedPreferences.aZ()) {
        InstantLog.a("pattern_lock_close");
        EventTrackSettings.a(SettingsProtos.Event.PATTERN_LOCK_CLOSE);
      } else {
        InstantLog.a("pattern_lock_open");
        EventTrackSettings.a(SettingsProtos.Event.PATTERN_LOCK_OPEN);
      } 
      BluedPreferences.B();
    } 
    if (!DeviceUtils.b((Context)this))
      InstantLog.a("close_push"); 
    if (UserInfo.a().i() != null && (UserInfo.a().i()).vip_grade == 0)
      k(); 
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            BluedConfig.b().e();
            if (Build.VERSION.SDK_INT >= 19)
              try {
                EventTrackSystemAuthority.a(SystemAuthorityProtos.Event.SYSTEM_AUTHORITY, SystemAuthorityProtos.Type.PUSH, NotificationManagerCompat.from((Context)this.a.getApplication()).areNotificationsEnabled());
              } catch (SecurityException securityException) {
                securityException.printStackTrace();
              }  
            this.a.j();
            ExperimentConfig.a().c();
          }
        }2000L);
    InstantLog.a("app_start");
    if (BluedPreferences.aA() == -1)
      if (!StringUtils.e(BluedPreferences.D())) {
        BluedPreferences.d(1);
      } else {
        BluedPreferences.d(0);
      }  
    n();
    l();
    VipBubbleManager.a().a(null, null);
    ActivityStack.a().a(HomeActivity.class);
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            HomeActivity.TabItem tabItem = (HomeActivity.TabItem)HomeActivity.a(this.a).get("mine");
            if (tabItem != null)
              UserInfo.a().a(tabItem); 
            HomeActivity.b(this.a);
          }
        },  1000L);
    DurationUtils.a("App启动");
  }
  
  public void onDestroy() {
    super.onDestroy();
    Logger.e("HomeActivity", new Object[] { "onDestroy ... " });
    HomeTabClick.a();
    this.k.c();
    c = null;
  }
  
  public void onNewIntent(Intent paramIntent) {
    super.onNewIntent(paramIntent);
    a(false, paramIntent);
  }
  
  public void onPause() {
    super.onPause();
    MobclickAgent.onPause((Context)this);
  }
  
  public void onPostCreate(Bundle paramBundle) {
    super.onPostCreate(paramBundle);
    SendFeedFloatManager.a().a(getApplicationContext());
  }
  
  public void onResume() {
    super.onResume();
    MobclickAgent.onResume((Context)this);
    this.k.d();
    if (CommonConstants.a.booleanValue()) {
      TerminalActivity.d((Context)this, LockPatternSetupFragment.class, null);
    } else if (CommonConstants.e) {
      WebViewShowInfoFragment.show((Context)this, H5Url.a(50), 0);
      CommonConstants.e = false;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("bluedAppHandoverListener");
    stringBuilder.append(BluedApplicationLike.bluedAppHandoverListener.b());
    Log.e("HomeActivity", stringBuilder.toString());
    if (BluedApplicationLike.bluedAppHandoverListener != null && !BluedApplicationLike.bluedAppHandoverListener.b())
      BluedApplicationLike.bluedAppHandoverListener.a((Activity)this); 
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {
    try {
      super.onSaveInstanceState(paramBundle);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    if (!TextUtils.isEmpty(this.f))
      paramBundle.putString("current_tag", this.f); 
  }
  
  public void onStart() {
    super.onStart();
    this.k.d();
    this.k.bb_();
  }
  
  public void onStop() {
    super.onStop();
    this.k.b();
  }
  
  public static class TabItem {
    public ViewGroup a;
    
    public ImageView b;
    
    public int c;
    
    public int d;
    
    public TextView e;
    
    public QBadgeContainer f;
    
    public ImageView g;
    
    public View h;
    
    public void a(boolean param1Boolean) {
      this.e.setSelected(param1Boolean);
      this.b.setSelected(param1Boolean);
      if (param1Boolean) {
        ImageView imageView1 = this.b;
        imageView1.setImageDrawable(BluedSkinUtils.b(imageView1.getContext(), this.c));
        return;
      } 
      ImageView imageView = this.b;
      imageView.setImageDrawable(BluedSkinUtils.b(imageView.getContext(), this.d));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\home\HomeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */