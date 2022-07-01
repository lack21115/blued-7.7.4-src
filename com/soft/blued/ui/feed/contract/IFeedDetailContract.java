package com.soft.blued.ui.feed.contract;

import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.FeedComment;
import com.soft.blued.ui.feed.model.FeedRepost;
import com.soft.blued.ui.find.model.BluedRecommendUsers;
import java.util.List;

public class IFeedDetailContract {
  public static interface IPresenter extends BasePresenter {}
  
  public static interface IView extends BaseView<IPresenter> {
    void a();
    
    void a(List<BluedRecommendUsers> param1List);
    
    void a(List<BluedIngSelfFeed> param1List, int param1Int, boolean param1Boolean);
    
    void b();
    
    void b(int param1Int);
    
    void bg_();
    
    void c(int param1Int);
    
    void c(BluedIngSelfFeed param1BluedIngSelfFeed);
    
    void d();
    
    void d(List<BluedRecommendUsers> param1List);
    
    void e();
    
    void e(List<FeedComment> param1List);
    
    void f(List<FeedComment> param1List);
    
    void g();
    
    void g(List<FeedRepost> param1List);
    
    void h();
    
    void h(List<FeedRepost> param1List);
    
    void i();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\contract\IFeedDetailContract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */