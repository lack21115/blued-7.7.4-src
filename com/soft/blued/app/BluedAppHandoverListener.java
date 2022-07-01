package com.soft.blued.app;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.blued.android.chat.BluedChat;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.AppHandoverListener;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.UiUtils;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.android.statistics.BluedStatistics;
import com.soft.blued.BluedConstant;
import com.soft.blued.app.permission.PermissionHelper;
import com.soft.blued.constant.CommonConstants;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.sdk.SDKActionManager;
import com.soft.blued.ui.discover.fragment.SendFeedFloatManager;
import com.soft.blued.ui.find.manager.FlashZegoApiManager;
import com.soft.blued.ui.home.manager.WelcomeADManager;
import com.soft.blued.ui.msg.customview.GlobalTaskFloatManager;
import com.soft.blued.ui.setting.fragment.LockPatternStartupFragment;
import com.soft.blued.ui.user.utils.CommandManager;
import com.soft.blued.ui.welcome.ClausePermissionFragment;
import com.soft.blued.ui.welcome.WelcomeFragmentNew;
import com.soft.blued.ui.welcome.model.SplashEntity;
import com.soft.blued.ui.welcome.model.SplashExtraEntity;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.BuglyCrashRecorder;
import com.soft.blued.utils.Logger;
import java.lang.ref.WeakReference;

public class BluedAppHandoverListener implements AppHandoverListener {
  public BluedUIHttpResponse a = new BluedUIHttpResponse<BluedEntity<SplashEntity, SplashExtraEntity>>(this, null) {
      public void onUIUpdate(BluedEntity<SplashEntity, SplashExtraEntity> param1BluedEntity) {
        if (param1BluedEntity != null && param1BluedEntity.extra != null)
          BluedPreferences.a(((SplashExtraEntity)param1BluedEntity.extra).RECALL); 
      }
    };
  
  private Context b;
  
  private boolean c = false;
  
  private WeakReference<Activity> d;
  
  private long e;
  
  private Runnable f = null;
  
  private Runnable g = null;
  
  public BluedAppHandoverListener(Context paramContext) {
    this.b = paramContext.getApplicationContext();
    this.f = new Runnable(this) {
        public void run() {
          BluedChat.getInstance().pauseIMService();
        }
      };
    this.g = new Runnable(this) {
        public void run() {
          BluedChat.getInstance().resumeIMService();
        }
      };
  }
  
  public void a() {
    this.d = null;
    Logger.c("tempTest", new Object[] { "onAppBack, last_isAppOnForeground:", Boolean.valueOf(this.c) });
    if (this.c) {
      this.c = false;
      BluedStatistics.e().d();
      long l = System.currentTimeMillis();
      if (!CommonConstants.b.booleanValue())
        BluedPreferences.b(l); 
      BluedPreferences.c(l);
      SDKActionManager.a();
      ChatManager.getInstance().appActiveChanged(false);
      if (BluedConstant.b)
        AppInfo.n().postDelayed(this.f, 3000L); 
    } 
    LiveFloatManager.a().l();
    SendFeedFloatManager.a().i();
    FlashZegoApiManager.a().d();
    AudioChannelManager.e().b();
    GlobalTaskFloatManager.a().d();
  }
  
  public void a(Activity paramActivity) {
    this.d = new WeakReference<Activity>(paramActivity);
    if (paramActivity != null)
      BuglyCrashRecorder.a = paramActivity.getClass().getName(); 
    if (Build.VERSION.SDK_INT < 29 || !BluedPreferences.dO()) {
      BluedPreferences.Q(false);
    } else {
      BluedPreferences.Q(true);
      BluedPreferences.I(BluedSkinUtils.a(paramActivity));
    } 
    Logger.e("tempTest", new Object[] { "skin auto system : ", Boolean.valueOf(BluedPreferences.dO()) });
    Logger.e("tempTest", new Object[] { "skin current type : ", Boolean.valueOf(BluedPreferences.cZ()) });
    Logger.c("tempTest", new Object[] { "onAppFore, last_isAppOnForeground:", Boolean.valueOf(this.c) });
    if (!this.c) {
      this.c = true;
      BluedStatistics.e().c();
      BluedChat.getInstance().startIMService(AppInfo.d());
      ChatManager.getInstance().appActiveChanged(true);
      AppInfo.n().removeCallbacks(this.f);
      AppInfo.n().post(this.g);
      long l2 = System.currentTimeMillis();
      if (c() != null) {
        int j = (int)(BluedPreferences.aV() * 60.0F * 1000.0F);
        int i = j;
        if (j <= 0)
          i = 900000; 
        if (BluedApplicationLike.checkLaunchPermission && !PermissionHelper.a()) {
          ClausePermissionFragment.a((Context)c());
          return;
        } 
        if (l2 - BluedPreferences.be().longValue() > i && UserInfo.a().j() && !ShortVideoProxy.e().b()) {
          if (!WelcomeADManager.a().c()) {
            if (!WelcomeADManager.a().b())
              WelcomeADManager.a().i(); 
            WelcomeFragmentNew.a((Context)c(), true, false);
          } 
        } else {
          a((Context)c());
        } 
      } 
      this.e = l2;
      long l3 = BluedPreferences.bd().longValue();
      long l1 = l3;
      if (l3 == 0L) {
        l1 = l3;
        if (!BluedApplicationLike.isMainApplication(this.b))
          l1 = l2; 
      } 
      if (BluedPreferences.aZ() && UserInfo.a().j() && !CommonConstants.b.booleanValue()) {
        if (l2 - l1 > 30000L) {
          CommonConstants.b = Boolean.valueOf(true);
          if (c() != null) {
            TerminalActivity.d((Context)c(), LockPatternStartupFragment.class, null);
            return;
          } 
        } else {
          LiveFloatManager.a().k();
          AudioChannelManager.e().a();
          GlobalTaskFloatManager.a().e();
          return;
        } 
      } else {
        LiveFloatManager.a().k();
        CommandManager.a().a((Context)paramActivity);
        AudioChannelManager.e().a();
        GlobalTaskFloatManager.a().e();
      } 
    } 
  }
  
  public void a(Context paramContext) {
    LoginRegisterHttpUtils.a(paramContext, BluedPreferences.aU(), this.a, null);
  }
  
  public boolean b() {
    return this.c;
  }
  
  public Activity c() {
    WeakReference<Activity> weakReference = this.d;
    if (weakReference != null) {
      Activity activity = weakReference.get();
      if (UiUtils.a(activity))
        return activity; 
    } 
    return null;
  }
  
  public long d() {
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\app\BluedAppHandoverListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */