package com.soft.blued.ui.login_register.Contract;

import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;

public interface VerifyCodeContract {
  public static interface IPresenter extends BasePresenter {
    void a(String param1String, int param1Int);
    
    void a(String param1String1, String param1String2, String param1String3, String param1String4, String param1String5, int param1Int, String param1String6);
  }
  
  public static interface IView extends BaseView<IPresenter> {
    void a();
    
    void b();
    
    void c();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\Contract\VerifyCodeContract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */