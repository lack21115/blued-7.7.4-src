package com.soft.blued.ui.live.contract;

import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;
import com.soft.blued.ui.live.model.BluedLiveListData;
import com.soft.blued.ui.live.model.LiveRecommendModel;
import java.util.List;

public class LiveListFollowContract {
  public static interface IPresenter extends BasePresenter {
    void a(BluedLiveListData param1BluedLiveListData);
    
    void a(boolean param1Boolean);
    
    void b();
  }
  
  public static interface IView extends BaseView<IPresenter> {
    void a();
    
    void a(BluedLiveListData param1BluedLiveListData);
    
    void a(List<BluedLiveListData> param1List);
    
    void a(boolean param1Boolean);
    
    void aM_();
    
    void aN_();
    
    void aO_();
    
    void b();
    
    void b(List<LiveRecommendModel> param1List);
    
    void b(boolean param1Boolean);
    
    void c();
    
    void c(List<LiveRecommendModel> param1List);
    
    void d();
    
    void e();
    
    void h();
    
    void i();
    
    void k();
    
    void l();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\contract\LiveListFollowContract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */