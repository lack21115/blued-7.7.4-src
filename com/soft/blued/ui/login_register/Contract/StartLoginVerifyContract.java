package com.soft.blued.ui.login_register.Contract;

import android.os.Bundle;
import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;

public interface StartLoginVerifyContract {
  public static interface IPresenter extends BasePresenter {
    void a(Bundle param1Bundle);
  }
  
  public static interface IView extends BaseView<IPresenter> {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\Contract\StartLoginVerifyContract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */