package com.soft.blued.ui.setting.Contract;

import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;
import com.soft.blued.ui.setting.model.BluedBlackList;
import java.util.List;

public class IBlackListContract {
  public static interface IPresenter extends BasePresenter {
    void b();
    
    void c();
    
    void d();
  }
  
  public static interface IView extends BaseView<IPresenter> {
    void a();
    
    void a(List<BluedBlackList> param1List);
    
    void a(boolean param1Boolean);
    
    void b();
    
    void b(List<BluedBlackList> param1List);
    
    void ba_();
    
    void c();
    
    void d();
    
    void e();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\Contract\IBlackListContract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */