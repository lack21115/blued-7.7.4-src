package com.soft.blued.ui.setting.Contract;

import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;
import com.soft.blued.ui.setting.model.DeviceModel;
import com.soft.blued.ui.setting.model.LoginProtectionModel;
import java.util.List;

public interface LoginDeviceListContract {
  public static interface IPresenter extends BasePresenter {
    void a(String param1String1, String param1String2);
    
    List<DeviceModel> b();
  }
  
  public static interface IView extends BaseView<IPresenter> {
    void a();
    
    void a(LoginProtectionModel param1LoginProtectionModel);
    
    void a(String param1String);
    
    void a(boolean param1Boolean);
    
    void b();
    
    void c();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\Contract\LoginDeviceListContract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */