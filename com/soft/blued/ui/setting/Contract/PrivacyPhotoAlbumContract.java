package com.soft.blued.ui.setting.Contract;

import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;
import com.soft.blued.ui.find.model.UserFindResult;
import java.util.List;

public class PrivacyPhotoAlbumContract {
  public static interface IPresenter extends BasePresenter {
    void a(int param1Int1, int param1Int2);
    
    void a(String param1String);
    
    void a(String param1String, int param1Int);
    
    void a(boolean param1Boolean);
    
    void b();
    
    boolean c();
  }
  
  public static interface IView extends BaseView<IPresenter> {
    void a();
    
    void a(int param1Int);
    
    void a(String param1String);
    
    void a(List<UserFindResult> param1List);
    
    void b();
    
    void c();
    
    void d();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\Contract\PrivacyPhotoAlbumContract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */