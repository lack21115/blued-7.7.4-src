package com.soft.blued.ui.setting.Presenter;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.login_register.model.BluedCheckResult;
import com.soft.blued.ui.setting.Contract.BindingSecureEmailContract;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.view.tip.CommonAlertDialog;

public class BindingSecureEmailPresenter implements BindingSecureEmailContract.IPresenter {
  private static final String a = BindingSecureEmailPresenter.class.getSimpleName();
  
  private Context b;
  
  private BindingSecureEmailContract.IView c;
  
  private String d = "";
  
  public BindingSecureEmailPresenter(Context paramContext, BindingSecureEmailContract.IView paramIView) {
    if (paramContext != null && paramIView != null) {
      this.b = paramContext;
      this.c = paramIView;
    } 
  }
  
  public void a(String paramString) {
    this.d = paramString;
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3) {
    LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>(this, paramString2, paramString3, paramString1) {
          protected BluedEntityA<Object> a(String param1String) {
            Logger.b(BindingSecureEmailPresenter.d(), new Object[] { "===success", "responseJson:", param1String });
            return (BluedEntityA<Object>)super.parseData(param1String);
          }
          
          public void a(BluedEntityA<Object> param1BluedEntityA) {
            try {
              BindingSecureEmailPresenter.a(this.d).d();
              this.d.a(this.a, this.b);
              return;
            } catch (Exception exception) {
              exception.printStackTrace();
              BindingSecureEmailPresenter.a(this.d).c();
              return;
            } 
          }
          
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            Logger.b(BindingSecureEmailPresenter.d(), new Object[] { "===error", "responseCode:", Integer.valueOf(param1Int), ",responseJson:", param1String });
            super.onFailure(param1Throwable, param1Int, param1String);
            if (param1Int == 403) {
              param1Int = ((Integer)(BluedHttpUtils.a(param1Throwable, param1Int, param1String)).first).intValue();
              if (param1Int != 4036002) {
                if (param1Int != 4036104) {
                  if (!StringUtils.e(this.d.b())) {
                    AppInfo.n().post(new Runnable(this) {
                          public void run() {
                            BindingSecureEmailPresenter.a(this.a.d).a(this.a.d.b());
                          }
                        });
                    return;
                  } 
                } else {
                  CommonAlertDialog.a(BindingSecureEmailPresenter.c(this.d), null, BindingSecureEmailPresenter.c(this.d).getResources().getString(2131757819), BindingSecureEmailPresenter.c(this.d).getResources().getString(2131755597), new DialogInterface.OnClickListener(this) {
                        public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                          this.a.d.a(this.a.c, 1, this.a.a, this.a.b);
                        }
                      }null, null, null);
                  return;
                } 
              } else {
                BindingSecureEmailPresenter.a(this.d).e();
                this.d.a(LoginRegisterTools.a(param1String));
                if (!StringUtils.e(this.d.b())) {
                  AppInfo.n().post(new Runnable(this) {
                        public void run() {
                          BindingSecureEmailPresenter.a(this.a.d).a(this.a.d.b());
                        }
                      });
                  return;
                } 
              } 
            } else if (!StringUtils.e(this.d.b())) {
              AppInfo.n().post(new Runnable(this) {
                    public void run() {
                      BindingSecureEmailPresenter.a(this.a.d).a(this.a.d.b());
                    }
                  });
            } 
          }
          
          public void onUIFinish() {
            BindingSecureEmailPresenter.a(this.d).a();
          }
          
          public void onUIStart() {
            BindingSecureEmailPresenter.a(this.d).b();
          }
        }paramString1, paramInt, paramString2, null);
  }
  
  public void a(String paramString1, String paramString2) {
    Bundle bundle = new Bundle();
    bundle.putString("binding_type", paramString2);
    bundle.putString(LoginRegisterTools.c, this.d);
    bundle.putString("secure_email", paramString1);
    this.c.a(bundle);
  }
  
  public String b() {
    return this.d;
  }
  
  public void bb_() {
    c();
  }
  
  public void c() {
    LoginRegisterHttpUtils.e(new BluedUIHttpResponse<BluedEntityA<BluedCheckResult>>(this) {
          protected BluedEntityA<BluedCheckResult> a(String param1String) {
            BluedEntityA<BluedCheckResult> bluedEntityA = (BluedEntityA)super.parseData(param1String);
            if (bluedEntityA != null)
              try {
                if (bluedEntityA.hasData()) {
                  String str = AesCrypto.c(((BluedCheckResult)bluedEntityA.data.get(0)).get_());
                  Logger.b(BindingSecureEmailPresenter.d(), new Object[] { "解密：deData===", str });
                  BluedCheckResult bluedCheckResult = (BluedCheckResult)AppInfo.f().fromJson(str, BluedCheckResult.class);
                  bluedEntityA.data.set(0, bluedCheckResult);
                  return bluedEntityA;
                } 
              } catch (Exception exception) {
                exception.printStackTrace();
                BindingSecureEmailPresenter.a(this.a).c();
              }  
            return bluedEntityA;
          }
          
          public void a(BluedEntityA<BluedCheckResult> param1BluedEntityA) {
            try {
              if (param1BluedEntityA.data.get(0) != null) {
                BluedCheckResult bluedCheckResult = param1BluedEntityA.data.get(0);
                if (bluedCheckResult != null) {
                  this.a.a(bluedCheckResult.getCaptcha());
                  if (!StringUtils.e(this.a.b())) {
                    BindingSecureEmailPresenter.a(this.a).a(BindingSecureEmailPresenter.b(this.a));
                    return;
                  } 
                } 
              } 
            } catch (Exception exception) {
              exception.printStackTrace();
              BindingSecureEmailPresenter.a(this.a).c();
            } 
          }
          
          public void onUIFinish() {
            BindingSecureEmailPresenter.a(this.a).a();
          }
          
          public void onUIStart() {
            BindingSecureEmailPresenter.a(this.a).b();
          }
        }null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\Presenter\BindingSecureEmailPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */