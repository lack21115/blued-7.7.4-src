package com.soft.blued.sdk.ui;

import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;

public class SDKPayContract {
  static interface IPresenter extends BasePresenter {
    void a(String param1String);
    
    void a(boolean param1Boolean);
    
    void b();
    
    void c();
  }
  
  static interface IView extends BaseView<IPresenter> {
    void a();
    
    void a(double param1Double);
    
    void a(int param1Int);
    
    void a(String param1String);
    
    void aD_();
    
    void aE_();
    
    void aF_();
    
    void b();
    
    void b(String param1String);
    
    void c(String param1String);
    
    void e();
    
    void h();
    
    void i();
    
    ActivityFragmentActive w_();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\sd\\ui\SDKPayContract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */