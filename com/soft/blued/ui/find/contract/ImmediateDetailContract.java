package com.soft.blued.ui.find.contract;

import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;
import com.soft.blued.ui.find.model.ImmediateTabModel;
import com.soft.blued.ui.find.model.ImmediateUserModel;

public interface ImmediateDetailContract {
  public static interface IPresenter extends BasePresenter {}
  
  public static interface IView extends BaseView<IPresenter> {
    int a();
    
    void a(int param1Int);
    
    void a(ImmediateTabModel param1ImmediateTabModel);
    
    void a(ImmediateUserModel param1ImmediateUserModel);
    
    void b();
    
    void b(int param1Int);
    
    void c();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\contract\ImmediateDetailContract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */