package com.soft.blued.ui.home;

import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;

public class HomeContract {
  static interface Presenter extends BasePresenter {
    void b();
    
    void bb_();
    
    void c();
    
    void d();
    
    void e();
  }
  
  public enum TabRefresh {
    a, b, c;
  }
  
  static interface View extends BaseView<Presenter> {
    void a(String param1String, int param1Int);
    
    void b(String param1String, int param1Int);
    
    boolean b(String param1String);
    
    void c(String param1String);
    
    void d(String param1String);
    
    void e(String param1String);
    
    void f(String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\home\HomeContract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */