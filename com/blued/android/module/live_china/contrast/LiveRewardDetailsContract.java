package com.blued.android.module.live_china.contrast;

import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;
import com.blued.android.module.live_china.model.LiveRewardExtraModel;
import com.blued.android.module.live_china.model.LiveRewardListModel;
import java.util.List;

public class LiveRewardDetailsContract {
  public static interface IPresenter extends BasePresenter {}
  
  public static interface IView extends BaseView<IPresenter> {
    void a(LiveRewardExtraModel param1LiveRewardExtraModel);
    
    void a(List<LiveRewardListModel> param1List, boolean param1Boolean);
    
    void c();
    
    void d();
    
    void e();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\contrast\LiveRewardDetailsContract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */