package com.soft.blued.ui.feed.contract;

import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;
import com.soft.blued.ui.feed.adapter.CommentListAdapter;
import com.soft.blued.ui.feed.model.FeedComment;
import java.util.List;

public class IHotCommentsContract {
  public static interface IPresenter extends BasePresenter {
    void a(String param1String);
    
    void a(String param1String, boolean param1Boolean);
    
    void a(boolean param1Boolean);
    
    void b();
    
    void b(String param1String);
    
    void c();
    
    CommentListAdapter.FeedCommentListner d();
  }
  
  public static interface IView extends BaseView<IPresenter> {
    void a();
    
    void a(String param1String);
    
    void a(List<FeedComment> param1List);
    
    void aH_();
    
    void aI_();
    
    void b();
    
    void b(List<FeedComment> param1List);
    
    void d();
    
    void e();
    
    void h();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\contract\IHotCommentsContract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */