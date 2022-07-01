package com.soft.blued.ui.login_register.Contract;

import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;
import com.soft.blued.http.LoginRegisterHttpUtils;

public class LoginWithTypeContract {
  public static interface IPresenter extends BasePresenter {
    void a(LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE param1PHONE_CODE_LOGIN_STAGE, String param1String1, String param1String2, String param1String3);
    
    void a(String param1String);
    
    void a(String param1String1, String param1String2, String param1String3, String param1String4, String param1String5);
    
    String b();
    
    void b(String param1String);
    
    String c();
    
    String d();
  }
  
  public static interface IView extends BaseView<IPresenter> {
    void a();
    
    void a(String param1String, boolean param1Boolean);
    
    void a(boolean param1Boolean);
    
    void b();
    
    void c();
    
    void d();
    
    int e();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\Contract\LoginWithTypeContract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */