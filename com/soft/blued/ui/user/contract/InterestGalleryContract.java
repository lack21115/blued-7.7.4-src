package com.soft.blued.ui.user.contract;

import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;
import com.soft.blued.ui.user.model.PictureTabModel;
import java.util.List;

public class InterestGalleryContract {
  public static interface IPresenter extends BasePresenter {}
  
  public static interface IView extends BaseView<IPresenter> {
    void a();
    
    void a(List<PictureTabModel> param1List);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\contract\InterestGalleryContract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */