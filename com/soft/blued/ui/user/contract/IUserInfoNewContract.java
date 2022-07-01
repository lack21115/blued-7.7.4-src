package com.soft.blued.ui.user.contract;

import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;
import com.soft.blued.ui.user.model.UserInfoEntity;

public class IUserInfoNewContract {
  public static interface IPresenter extends BasePresenter {}
  
  public static interface IView extends BaseView<IPresenter> {
    void a(UserInfoEntity param1UserInfoEntity);
    
    void a(UserInfoEntity param1UserInfoEntity, int param1Int);
    
    boolean a();
    
    void b(UserInfoEntity param1UserInfoEntity);
    
    void d();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\contract\IUserInfoNewContract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */