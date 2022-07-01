package com.soft.blued.ui.find.contract;

import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;
import com.soft.blued.ui.find.model.ImmediateTabModel;
import java.util.List;

public interface ImmediateTabsContract {
  public static interface IPresenter extends BasePresenter {}
  
  public static interface IView extends BaseView<IPresenter> {
    void a(List<ImmediateTabModel.Tab> param1List);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\contract\ImmediateTabsContract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */