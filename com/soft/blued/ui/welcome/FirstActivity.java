package com.soft.blued.ui.welcome;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.blued.android.core.ui.BaseActivity;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.init.InitTaskManager;
import com.blued.android.framework.urlroute.BluedURIRouter;
import com.blued.android.framework.utils.Logger;
import com.blued.das.authority.SystemAuthorityProtos;
import com.blued.das.settings.SettingsProtos;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.app.permission.PermissionHelper;
import com.soft.blued.constant.CommonConstants;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackSettings;
import com.soft.blued.log.trackUtils.EventTrackSystemAuthority;
import com.soft.blued.push.PushCommonUtils;
import com.soft.blued.push.PushManager;
import com.soft.blued.push.PushMsgModel;
import com.soft.blued.ui.home.manager.WelcomeADManager;
import com.soft.blued.ui.login_register.AdultVerifyFragment;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.umeng.analytics.MobclickAgent;
import java.io.Serializable;
import java.net.URLDecoder;
import skin.support.content.res.SkinCompatResources;

public class FirstActivity extends BaseFragmentActivity {
  private boolean c = true;
  
  private boolean d = true;
  
  private boolean e = false;
  
  public static void a(Context paramContext) {
    a(paramContext, true);
  }
  
  public static void a(Context paramContext, boolean paramBoolean) {
    BaseActivity.a = null;
    Intent intent = new Intent(paramContext, FirstActivity.class);
    if (paramBoolean)
      intent.setFlags(268468224); 
    intent.putExtra("extra_bool_open_welcome_page", false);
    try {
      paramContext.startActivity(intent);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  private void a(Intent paramIntent) {
    if (paramIntent == null)
      return; 
    try {
      this.c = paramIntent.getBooleanExtra("extra_bool_open_welcome_page", this.c);
      this.d = this.c;
      String str = paramIntent.getAction();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Intent action :");
      stringBuilder.append(str);
      Logger.d("FirstActivity", new Object[] { stringBuilder.toString() });
      if ("android.intent.action.VIEW".equals(str)) {
        Uri uri2 = paramIntent.getData();
        Uri uri1 = uri2;
        if (uri2 == null) {
          Bundle bundle = paramIntent.getExtras();
          uri1 = uri2;
          if (bundle != null) {
            String str1 = bundle.getString("url");
            uri1 = uri2;
            if (!TextUtils.isEmpty(str1))
              uri1 = Uri.parse(str1); 
          } 
        } 
        if (uri1 != null) {
          String str1 = uri1.toString();
          try {
            String str2 = URLDecoder.decode(str1, "UTF-8");
            str1 = str2;
          } catch (Exception exception) {}
          EventTrackSystemAuthority.a(SystemAuthorityProtos.Event.PUSH_CLICK, str1);
          BluedApplicationLike.outUri = BluedURIRouter.a().d(str1);
          if (BluedApplicationLike.outUri == null)
            BluedApplicationLike.outUri = BluedURIRouter.a().a(str1, 7); 
          if (uri1.toString().toLowerCase().contains("link_type=push")) {
            InstantLog.i("push_msg_navigate", str1);
            EventTrackSystemAuthority.b(SystemAuthorityProtos.Event.PUSH_MSG_NAVIGATE, str1);
            return;
          } 
          if (uri1.toString().toLowerCase().startsWith("blued:")) {
            InstantLog.a("deep_link_click", str1);
            EventTrackSettings.b(SettingsProtos.Event.DEEP_LINK_CLICK, str1);
          } 
        } 
      } 
      return;
    } catch (BadParcelableException badParcelableException) {
      Logger.d("FirstActivity", new Object[] { "Couldn't get string extra: malformed intent." });
      return;
    } 
  }
  
  private void a(Bundle paramBundle) {
    BluedApplicationLike.checkLaunchPermission = BluedPreferences.ew() ^ true;
    if (h()) {
      Logger.b("OPEN_APP_FINISH", new Object[] { "mayGoToShowPush" });
      finish();
      return;
    } 
    if (CommonConstants.c) {
      Logger.b("OPEN_APP_FINISH", new Object[] { "CommonConstants.exitApp" });
      finish();
      MobclickAgent.onKillProcess((Context)this);
      Process.killProcess(Process.myPid());
      System.exit(0);
      return;
    } 
    a(getIntent());
    if ((getIntent().getFlags() & 0x400000) > 0) {
      Logger.b("OPEN_APP_FINISH", new Object[] { "\"(getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT)> 0" });
      finish();
      return;
    } 
    if (BluedPreferences.aA() == -1)
      if (!StringUtils.e(BluedPreferences.D())) {
        BluedPreferences.d(1);
      } else {
        BluedPreferences.d(0);
      }  
    c((Context)this);
    if (this.e)
      overridePendingTransition(2130771986, 2130771986); 
  }
  
  private void b(Bundle paramBundle) {
    super.onCreate(paramBundle);
    StatusBarHelper.a((Activity)this, true);
  }
  
  private void c(Context paramContext) {
    if ((BluedPreferences.aA() != 1 && !BluedPreferences.aB()) || (BluedApplicationLike.checkLaunchPermission && !PermissionHelper.a())) {
      ClausePermissionFragment.a(paramContext);
      return;
    } 
    b(paramContext);
  }
  
  private boolean h() {
    Intent intent = getIntent();
    if (intent == null)
      return false; 
    if (!intent.getBooleanExtra("is_push_key", false))
      return false; 
    Serializable serializable = intent.getSerializableExtra("push_msg_model");
    if (serializable != null) {
      if (!(serializable instanceof PushMsgModel))
        return false; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("PushMsgModel : ");
      stringBuilder.append(serializable);
      Logger.c("FirstActivity", new Object[] { stringBuilder.toString() });
      PushCommonUtils.b((Context)this, (PushMsgModel)serializable);
      return true;
    } 
    return false;
  }
  
  public void b(Context paramContext) {
    Logger.c("FirstActivity", new Object[] { "login result is_kids", Integer.valueOf(UserInfo.a().i().getNeedAdultVerify()) });
    if (UserInfo.a().j() && UserInfo.a().i().getNeedAdultVerify() == 1) {
      AdultVerifyFragment.a(paramContext);
      return;
    } 
    if (this.c) {
      Logger.c("startDowload", new Object[0]);
      WelcomeADManager.a().i();
      WelcomeFragmentNew.a(paramContext, UserInfo.a().j());
    } else {
      WelcomeFragmentNew.b(paramContext, true);
    } 
    if (this.e)
      overridePendingTransition(2130771986, 2130771986); 
    Logger.b("OPEN_APP_FINISH", new Object[] { "checkGoingTo" });
    finish();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    PushManager.a().a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle) {
    BluedApplicationLike.initAppGlobal(getApplication());
    if (InitTaskManager.b()) {
      this.e = false;
      super.onCreate(paramBundle);
      a(paramBundle);
    } else {
      this.e = true;
      b(paramBundle);
      InitTaskManager.a().a(getApplication(), new InitTaskManager.OnResultListener(this, paramBundle) {
            public void a() {
              Logger.c("InitTaskManager", new Object[] { "onFinished = ", Long.valueOf(System.currentTimeMillis()) });
              FirstActivity.a(this.b, this.a);
            }
          });
    } 
    StatusBarHelper.c((Activity)this, SkinCompatResources.a().d());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\welcome\FirstActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */