package com.soft.blued.ui.setting.Contract;

import android.os.Bundle;
import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;

public class BindingSecureEmailContract {
  public static interface IPresenter extends BasePresenter {
    void a(String param1String1, int param1Int, String param1String2, String param1String3);
    
    String b();
  }
  
  public static interface IView extends BaseView<IPresenter> {
    void a();
    
    void a(Bundle param1Bundle);
    
    void a(String param1String);
    
    void b();
    
    void c();
    
    void d();
    
    void e();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\Contract\BindingSecureEmailContract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */