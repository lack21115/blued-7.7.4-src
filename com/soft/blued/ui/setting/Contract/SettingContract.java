package com.soft.blued.ui.setting.Contract;

import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;
import com.soft.blued.ui.user.model.VerifyStatus;

public class SettingContract {
  public static interface IPresenter extends BasePresenter {
    void b();
    
    void c();
  }
  
  public static interface IView extends BaseView<IPresenter> {
    void a();
    
    void a(VerifyStatus[] param1ArrayOfVerifyStatus);
    
    void a(VerifyStatus[] param1ArrayOfVerifyStatus, String param1String1, String param1String2, String param1String3, String param1String4);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\Contract\SettingContract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */