package com.soft.blued.ui.setting.Presenter;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.ActivityStack;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.AppUtils;
import com.blued.das.settings.SettingsProtos;
import com.soft.blued.db.UserAccountsVDao;
import com.soft.blued.db.model.UserAccountsModel;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackSettings;
import com.soft.blued.push.PushManager;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.login_register.SignInActivity;
import com.soft.blued.ui.login_register.model.AVConfigExtra;
import com.soft.blued.ui.login_register.model.BluedLoginResult;
import com.soft.blued.ui.welcome.FirstActivity;
import com.soft.blued.user.AVConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.sql.SQLException;
import java.util.concurrent.CopyOnWriteArrayList;

public class SwitchAccountPresenter extends MvpPresenter {
  public static final String h = SwitchAccountPresenter.class.getSimpleName();
  
  private CopyOnWriteArrayList<UserAccountsModel> i;
  
  private void a(String paramString1, int paramInt, String paramString2, BluedLoginResult paramBluedLoginResult) {
    ActivityStack.a().c();
    UserInfo.a().a(paramString1, paramInt, paramString2, paramBluedLoginResult, new String[0]);
    PushManager.a().d();
    FirstActivity.a((Context)h());
  }
  
  private void b(UserAccountsModel paramUserAccountsModel) {
    String str;
    int i = paramUserAccountsModel.getLoginType();
    if (i != 0) {
      if (i != 1) {
        if (i != 2) {
          str = null;
        } else {
          str = "weixin";
        } 
      } else {
        str = "mobile";
      } 
    } else {
      str = "email";
    } 
    LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntity<BluedLoginResult, AVConfigExtra>>(this, paramUserAccountsModel, i) {
          String a = "";
          
          public boolean onUIFailure(int param1Int, String param1String1, String param1String2) {
            ThreadManager.a().a(new ThreadExecutor(this, "", param1Int) {
                  public void execute() {
                    if (this.b.b != null)
                      SwitchAccountPresenter.a(this.b.d, this.b.b); 
                    if (this.a == 401)
                      return; 
                    AppInfo.n().post(new Runnable(this) {
                          public void run() {
                            SwitchAccountPresenter.b(this.a.b.d, this.a.b.b);
                          }
                        });
                  }
                });
            return super.onUIFailure(param1Int, param1String1, param1String2);
          }
          
          public void onUIUpdate(BluedEntity<BluedLoginResult, AVConfigExtra> param1BluedEntity) {
            if (param1BluedEntity != null && param1BluedEntity.data != null && param1BluedEntity.data.size() > 0) {
              if (param1BluedEntity.extra != null)
                AVConfig.a().a(((AVConfigExtra)param1BluedEntity.extra).is_kids, false); 
              String str = ((BluedLoginResult)param1BluedEntity.data.get(0)).get_();
              try {
                str = AesCrypto.c(str);
                BluedLoginResult bluedLoginResult = (BluedLoginResult)AppInfo.f().fromJson(str, BluedLoginResult.class);
                SwitchAccountPresenter.a(this.d, this.b.getUsername(), this.c, this.a, bluedLoginResult);
                return;
              } catch (Exception exception) {
                return;
              } 
            } 
          }
          
          public BluedEntity<BluedLoginResult, AVConfigExtra> parseData(String param1String) {
            this.a = param1String;
            return super.parseData(param1String);
          }
        }str, LoginRegisterTools.g(paramUserAccountsModel.getAccessToken()), paramUserAccountsModel.getUid());
  }
  
  private void c(UserAccountsModel paramUserAccountsModel) {
    if (paramUserAccountsModel != null) {
      paramUserAccountsModel.setAccessToken("");
      paramUserAccountsModel.setLastHandleTime(System.currentTimeMillis());
      try {
        UserAccountsVDao.a().b().update(paramUserAccountsModel);
        return;
      } catch (SQLException sQLException) {
        sQLException.printStackTrace();
      } 
    } 
  }
  
  private void d(UserAccountsModel paramUserAccountsModel) {
    if (!g().isActive())
      return; 
    CommonAlertDialog.a((Context)h(), 0, "", h().getResources().getString(2131758986), null, AppUtils.a(2131755609), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            param1DialogInterface.dismiss();
            FirstActivity.a(AppInfo.d());
          }
        },  null, null, null, false, 1, 0, false, false);
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    ThreadManager.a().a(new ThreadExecutor(this, "FetchAccount", paramIFetchDataListener) {
          public void execute() {
            SwitchAccountPresenter.a(this.b, UserAccountsVDao.a().g());
            this.a.a("data_account", SwitchAccountPresenter.a(this.b));
            this.a.a(true);
          }
        });
  }
  
  public void a(UserAccountsModel paramUserAccountsModel) {
    if (StringUtils.e(paramUserAccountsModel.getAccessToken())) {
      UserInfo.a().a(true);
      c(paramUserAccountsModel);
      FirstActivity.a(AppInfo.d());
      return;
    } 
    b(paramUserAccountsModel);
  }
  
  public void a(boolean paramBoolean) {
    UserRelationshipUtils.a(new Runnable(this, paramBoolean) {
          public void run() {
            if (this.a)
              this.b.p(); 
            if (SwitchAccountPresenter.a(this.b) != null) {
              if (SwitchAccountPresenter.a(this.b).size() < 2)
                return; 
              UserAccountsModel userAccountsModel = SwitchAccountPresenter.a(this.b).get(1);
              if (!this.a)
                EventTrackSettings.a(SettingsProtos.Event.CHANGE_ACCOUNT_CLICK, userAccountsModel.getUid()); 
              this.b.a(userAccountsModel);
            } 
          }
        }"switch_Acc");
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {}
  
  public void m() {
    CopyOnWriteArrayList<UserAccountsModel> copyOnWriteArrayList = this.i;
    if (copyOnWriteArrayList != null) {
      if (copyOnWriteArrayList.size() < 1)
        return; 
      b(this.i.get(0));
    } 
  }
  
  public void n() {
    if (h() == null)
      return; 
    CopyOnWriteArrayList<UserAccountsModel> copyOnWriteArrayList = this.i;
    if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
      UserAccountsModel userAccountsModel = this.i.get(0);
      Bundle bundle = new Bundle();
      bundle.putString("aliasUserId", userAccountsModel.getUid());
      SignInActivity.a((Context)h(), new Bundle[] { bundle });
    } 
  }
  
  public void o() {
    CopyOnWriteArrayList<UserAccountsModel> copyOnWriteArrayList = this.i;
    if (copyOnWriteArrayList != null) {
      if (copyOnWriteArrayList.size() < 2)
        return; 
      this.i.remove(1);
      a("data_account", this.i);
    } 
  }
  
  public void p() {
    if (this.i == null)
      return; 
    ThreadManager.a().a(new ThreadExecutor(this, "deleteAliasUserId") {
          public void execute() {
            for (UserAccountsModel userAccountsModel : SwitchAccountPresenter.a(this.a)) {
              userAccountsModel.setAliasUserId("");
              try {
                UserAccountsVDao.a().b().update(userAccountsModel);
              } catch (SQLException sQLException) {
                sQLException.printStackTrace();
              } 
            } 
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\Presenter\SwitchAccountPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */