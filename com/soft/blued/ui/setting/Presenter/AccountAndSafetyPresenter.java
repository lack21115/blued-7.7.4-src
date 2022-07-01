package com.soft.blued.ui.setting.Presenter;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.model.BluedLoginResultVerBinding;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.setting.Contract.AccountAndSafetyContract;
import com.soft.blued.ui.setting.model.WechatModel;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import com.soft.blued.wxapi.WXLoginBean;
import com.soft.blued.wxapi.WXProvider;

public class AccountAndSafetyPresenter implements AccountAndSafetyContract.IPresenter {
  private Context a;
  
  private AccountAndSafetyContract.IView b;
  
  private IRequestHost c;
  
  private BluedUIHttpResponse d = new BluedUIHttpResponse<BluedEntityA<WechatModel>>(this, this.c) {
      public void a(BluedEntityA<WechatModel> param1BluedEntityA) {
        if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
          String str = ((WechatModel)param1BluedEntityA.data.get(0)).status;
          if (TextUtils.equals(str, "0")) {
            CommonAlertDialog.a(AccountAndSafetyPresenter.d(this.a), null, AccountAndSafetyPresenter.d(this.a).getString(2131759352), AccountAndSafetyPresenter.d(this.a).getString(2131755609), null, null, null);
            return;
          } 
          if (TextUtils.equals(str, "1")) {
            UserInfo.a().e("1");
            this.a.e();
            AppMethods.a(AccountAndSafetyPresenter.d(this.a).getString(2131759351));
          } 
        } 
      }
      
      public void onUIFinish() {
        AccountAndSafetyPresenter.c(this.a).b();
      }
    };
  
  private BluedUIHttpResponse e = new BluedUIHttpResponse<BluedEntityA<WechatModel>>(this, this.c) {
      public void a(BluedEntityA<WechatModel> param1BluedEntityA) {
        if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
          String str = ((WechatModel)param1BluedEntityA.data.get(0)).status;
          if (!TextUtils.equals(str, "0") && TextUtils.equals(str, "1"))
            AppMethods.a(AccountAndSafetyPresenter.d(this.a).getString(2131759356)); 
          UserInfo.a().e("");
          if (UserInfo.a().i() != null) {
            BluedLoginResultVerBinding bluedLoginResultVerBinding = UserInfo.a().i().getVerified_bindings();
            if (bluedLoginResultVerBinding != null)
              bluedLoginResultVerBinding.third_weixin = ""; 
          } 
          this.a.e();
        } 
      }
      
      public void onUIFinish() {
        AccountAndSafetyPresenter.c(this.a).b();
      }
      
      public void onUIStart() {
        AccountAndSafetyPresenter.c(this.a).a();
      }
    };
  
  public AccountAndSafetyPresenter(Context paramContext, AccountAndSafetyContract.IView paramIView, IRequestHost paramIRequestHost) {
    this.a = paramContext;
    this.b = paramIView;
    this.c = paramIRequestHost;
  }
  
  public void b() {
    this.b.a();
    LiveFloatManager.a().l();
    WXProvider.a().a(new WXProvider.ILoginCallback(this) {
          public void a() {
            LiveFloatManager.a().k();
            AccountAndSafetyPresenter.c(this.a).b();
            ToastUtils.a(AccountAndSafetyPresenter.d(this.a).getString(2131755512));
          }
          
          public void a(WXLoginBean param1WXLoginBean) {
            if (param1WXLoginBean != null) {
              LoginRegisterHttpUtils.a(AccountAndSafetyPresenter.a(this.a), 1, param1WXLoginBean.code, AccountAndSafetyPresenter.b(this.a));
            } else {
              AccountAndSafetyPresenter.c(this.a).b();
            } 
            LiveFloatManager.a().k();
          }
          
          public void b() {
            LiveFloatManager.a().k();
            AccountAndSafetyPresenter.c(this.a).b();
            ToastUtils.a(AccountAndSafetyPresenter.d(this.a).getString(2131755512));
          }
        });
    WXProvider.a().a(this.a);
  }
  
  public void bb_() {
    d();
    e();
  }
  
  public void c() {
    if (!StringUtils.e(LoginRegisterTools.b())) {
      LoginRegisterHttpUtils.a(this.e, 2, "", this.c);
      return;
    } 
    Context context = this.a;
    CommonAlertDialog.a(context, null, context.getString(2131759354), this.a.getString(2131755609), null, null, null);
  }
  
  public void d() {
    String str = LoginRegisterTools.d();
    this.b.b(str);
  }
  
  public void e() {
    String str = LoginRegisterTools.c();
    this.b.a(str);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\Presenter\AccountAndSafetyPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */