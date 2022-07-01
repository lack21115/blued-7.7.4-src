package com.soft.blued.ui.live.contract;

import com.blued.android.module.live_china.model.BluedLiveState;
import com.soft.blued.ui.live.model.BannerModel;
import com.soft.blued.ui.live.model.BluedLiveListData;
import java.util.List;

public class LiveListContract {
  public static interface IPresenter {
    BluedLiveState a();
    
    void a(LiveListContract.IView param1IView);
    
    void a(boolean param1Boolean);
    
    void b();
    
    void c();
    
    int d();
    
    void e();
    
    void f();
  }
  
  public static interface IView {
    void a();
    
    void a(int param1Int);
    
    void a(List<BannerModel> param1List);
    
    void a(List<BluedLiveListData> param1List, boolean param1Boolean);
    
    void b();
    
    void c();
    
    void d();
    
    void e();
  }
  
  public static interface ServicePresenter {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\contract\LiveListContract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */