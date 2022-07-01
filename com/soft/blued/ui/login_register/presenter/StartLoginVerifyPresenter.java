package com.soft.blued.ui.login_register.presenter;

import android.content.Context;
import android.os.Bundle;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.ui.login_register.Contract.StartLoginVerifyContract;
import com.soft.blued.ui.login_register.View.VerifyCodeFragment;

public class StartLoginVerifyPresenter implements StartLoginVerifyContract.IPresenter {
  private StartLoginVerifyContract.IView a;
  
  private Context b;
  
  private IRequestHost c;
  
  public StartLoginVerifyPresenter(Context paramContext, StartLoginVerifyContract.IView paramIView, IRequestHost paramIRequestHost) {
    this.a = paramIView;
    this.b = paramContext;
    this.c = paramIRequestHost;
  }
  
  public void a(Bundle paramBundle) {
    String str1;
    String str2;
    if (paramBundle != null) {
      str1 = paramBundle.getString("token");
      str2 = paramBundle.getString("safe_device_type");
    } else {
      str1 = "";
      str2 = str1;
    } 
    LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>(this, this.c, paramBundle) {
          protected void a(BluedEntityA<Object> param1BluedEntityA) {
            VerifyCodeFragment.a(StartLoginVerifyPresenter.a(this.b), this.a);
          }
        }str1, "send", "", str2, this.c);
  }
  
  public void bb_() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\presenter\StartLoginVerifyPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */