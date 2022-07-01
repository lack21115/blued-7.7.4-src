package com.soft.blued.ui.login_register.presenter;

import android.content.Context;
import android.os.Bundle;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto;
import com.google.gson.reflect.TypeToken;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.constant.LoginConstants;
import com.soft.blued.db.UserAccountsVDao;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.login_register.AdultVerifyFragment;
import com.soft.blued.ui.login_register.Contract.VerifyCodeContract;
import com.soft.blued.ui.login_register.model.AVConfigExtra;
import com.soft.blued.ui.login_register.model.BluedLoginResult;
import com.soft.blued.ui.user.fragment.AccountLockedFragment;
import com.soft.blued.user.AVConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;

public class VerifyCodePresenter implements VerifyCodeContract.IPresenter {
  private VerifyCodeContract.IView a;
  
  private Context b;
  
  private IRequestHost c;
  
  private String d;
  
  public VerifyCodePresenter(Context paramContext, VerifyCodeContract.IView paramIView, IRequestHost paramIRequestHost) {
    this.a = paramIView;
    this.b = paramContext;
    this.c = paramIRequestHost;
  }
  
  public BluedUIHttpResponse a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    return new BluedUIHttpResponse<BluedEntity<BluedLoginResult, AVConfigExtra>>(this, this.c, paramString3, paramString4, paramString5) {
        public boolean onUIFailure(int param1Int, String param1String1, String param1String2) {
          boolean bool1;
          boolean bool2 = false;
          if (param1Int != 4036501) {
            bool1 = true;
          } else {
            try {
              BluedEntityA bluedEntityA = (BluedEntityA)AppInfo.f().fromJson(param1String2, (new TypeToken<BluedEntityA<BluedLoginResult>>(this) {
                  
                  }).getType());
              bool1 = bool2;
              if (bluedEntityA != null) {
                bool1 = bool2;
                if (bluedEntityA.data != null) {
                  bool1 = bool2;
                  if (bluedEntityA.data.size() > 0) {
                    BluedLoginResult bluedLoginResult = bluedEntityA.data.get(0);
                    String str1 = bluedLoginResult.reason;
                    String str2 = bluedLoginResult.uid;
                    AccountLockedFragment.a(VerifyCodePresenter.b(this.d), str1, str2);
                    bool1 = bool2;
                  } 
                } 
              } 
            } catch (Exception exception) {
              bool1 = bool2;
            } 
          } 
          return bool1 ? onUIFailure(param1Int, param1String1) : true;
        }
        
        public void onUIFinish() {
          super.onUIFinish();
          VerifyCodePresenter.a(this.d).b();
        }
        
        public void onUIStart() {
          super.onUIStart();
          VerifyCodePresenter.a(this.d).a();
        }
        
        public void onUIUpdate(BluedEntity<BluedLoginResult, AVConfigExtra> param1BluedEntity) {
          if (param1BluedEntity != null)
            try {
              if (param1BluedEntity.hasData() && param1BluedEntity.data.get(0) != null) {
                byte b;
                boolean bool;
                if (param1BluedEntity.extra != null)
                  AVConfig.a().a(((AVConfigExtra)param1BluedEntity.extra).is_kids, false); 
                BluedLoginResult bluedLoginResult = param1BluedEntity.data.get(0);
                if (bluedLoginResult.getDevice_safe() == 1) {
                  bool = true;
                } else {
                  bool = false;
                } 
                BluedPreferences.D(bool);
                if ("mobile".equals(this.a)) {
                  b = 1;
                } else if ("email".equals(this.a)) {
                  b = 0;
                } else {
                  b = 2;
                } 
                Logger.b(VerifyCodePresenter.class.getSimpleName(), new Object[] { "VerifyCodePresenter", "===success", "加密：responseJson:", param1BluedEntity });
                UserInfo.a().a(this.b, b, VerifyCodePresenter.c(this.d), bluedLoginResult, new String[] { this.c });
                if (!StringUtils.e(this.c))
                  UserAccountsVDao.a().c(this.c); 
                if (bluedLoginResult != null && bluedLoginResult.getNeedAdultVerify() == 1) {
                  AdultVerifyFragment.a(VerifyCodePresenter.b(this.d));
                  return;
                } 
                Bundle bundle = new Bundle();
                bundle.putString("from_tag_page", "from_tag_login");
                HomeArgumentHelper.a(VerifyCodePresenter.b(this.d), null, bundle);
                LoginConstants.a = "";
                BluedApplicationLike.initAppLanguage();
                ChatManager.getInstance().initLanguage();
                return;
              } 
            } catch (Exception exception) {
              exception.printStackTrace();
              AppMethods.a(VerifyCodePresenter.b(this.d).getResources().getString(2131756082));
            }  
        }
        
        public BluedEntity<BluedLoginResult, AVConfigExtra> parseData(String param1String) {
          VerifyCodePresenter.a(this.d, param1String);
          BluedEntity<BluedLoginResult, AVConfigExtra> bluedEntity = super.parseData(param1String);
          if (bluedEntity != null)
            try {
              if (bluedEntity.hasData()) {
                String str = AesCrypto.c(((BluedLoginResult)bluedEntity.data.get(0)).get_());
                BluedLoginResult bluedLoginResult = (BluedLoginResult)AppInfo.f().fromJson(str, BluedLoginResult.class);
                bluedEntity.data.set(0, bluedLoginResult);
                return bluedEntity;
              } 
            } catch (Exception exception) {
              exception.printStackTrace();
              AppMethods.a(VerifyCodePresenter.b(this.d).getResources().getString(2131756082));
            }  
          return bluedEntity;
        }
      };
  }
  
  public void a(String paramString, int paramInt) {
    if (paramInt != 0) {
      if (paramInt != 1)
        return; 
      LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>(this, this.c) {
            protected void a(BluedEntityA<Object> param1BluedEntityA) {}
          }"reset", "", "", this.c);
      return;
    } 
    LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>(this, this.c) {
          protected void a(BluedEntityA<Object> param1BluedEntityA) {}
        }paramString, "reset", "", "", this.c);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6) {
    if (paramInt != 0) {
      if (paramInt != 1)
        return; 
      LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>(this, this.c) {
            protected void a(BluedEntityA<Object> param1BluedEntityA) {
              VerifyCodePresenter.a(this.a).c();
            }
          }"verify", paramString2, "", this.c);
      return;
    } 
    LoginRegisterHttpUtils.a(a(paramString1, paramString2, paramString3, paramString4, paramString6), paramString1, "verify", paramString2, "", this.c);
  }
  
  public void bb_() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\presenter\VerifyCodePresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */