package com.soft.blued.ui.discover.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.das.client.feed.FeedProtos;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.FloatFooterView;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.discover.presenter.ImageFeedPresenter;
import com.soft.blued.ui.feed.adapter.FeedListAdapterForRecyclerView;
import com.soft.blued.ui.feed.fragment.FeedPostFragment;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import java.util.ArrayList;
import java.util.List;

public class ImageFeedFragment extends MvpFragment<ImageFeedPresenter> {
  private Context d;
  
  private NoDataAndLoadFailView e;
  
  private FeedListAdapterForRecyclerView f;
  
  private RecyclerView.OnScrollListener g = new RecyclerView.OnScrollListener(this) {
      public void onScrollStateChanged(RecyclerView param1RecyclerView, int param1Int) {
        if (ImageFeedFragment.b(this.a) != null && (ImageFeedFragment.b(this.a)).p != null)
          (ImageFeedFragment.b(this.a)).p.onScrollStateChanged(param1RecyclerView, param1Int); 
        if (this.a.llFeedPost != null && param1Int == 0) {
          if (!param1RecyclerView.canScrollVertically(-1)) {
            this.a.llFeedPost.a();
            return;
          } 
          if (!param1RecyclerView.canScrollVertically(1))
            this.a.llFeedPost.b(); 
        } 
      }
      
      public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
        if (ImageFeedFragment.b(this.a) != null && (ImageFeedFragment.b(this.a)).p != null)
          (ImageFeedFragment.b(this.a)).p.onScrolled(param1RecyclerView, param1Int1, param1Int2); 
        if (this.a.llFeedPost != null) {
          if (param1Int2 < 0) {
            this.a.llFeedPost.a();
            return;
          } 
          if (param1Int2 > 0)
            this.a.llFeedPost.b(); 
        } 
      }
    };
  
  @BindView(2131298800)
  FloatFooterView llFeedPost;
  
  @BindView(2131299605)
  RecyclerView mRecyclerView;
  
  @BindView(2131299616)
  SmartRefreshLayout mRefreshLayout;
  
  @BindView(2131300273)
  CommonTopTitleNoTrans title;
  
  public static void a(Context paramContext) {
    TerminalActivity.d(paramContext, ImageFeedFragment.class, null);
  }
  
  private void b(boolean paramBoolean) {
    this.mRefreshLayout.g();
    this.mRefreshLayout.h();
    if (this.f.n().size() <= 0) {
      if (paramBoolean) {
        this.e.a();
        return;
      } 
      this.e.b();
    } 
  }
  
  private void k() {
    this.title.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.C();
          }
        });
    this.llFeedPost.setOnBtnClickListener(new FloatFooterView.OnBtnClickListener(this) {
          public void onPostFeedClick() {
            ImageFeedFragment.a(this.a);
          }
        });
    if (this.f == null) {
      this.f = new FeedListAdapterForRecyclerView(new ArrayList(), getContext(), (IRequestHost)w_(), this.mRecyclerView, 10);
      this.e = new NoDataAndLoadFailView(this.d);
      this.f.e((View)this.e);
    } 
    ((ImageFeedPresenter)s()).a(this.f);
    this.mRecyclerView.setAdapter((RecyclerView.Adapter)this.f);
    GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
    this.mRecyclerView.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
    this.mRecyclerView.addOnScrollListener(this.g);
    this.mRefreshLayout.a(new OnRefreshLoadMoreListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            ((ImageFeedPresenter)this.a.s()).f();
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            ((ImageFeedPresenter)this.a.s()).e();
          }
        });
  }
  
  private void l() {
    EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_BTN_CLICK, FeedProtos.FeedFrom.PUBLISH_PLAZA_IMAGE);
    FeedPostFragment.a(getContext(), true);
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.d = getContext();
    k();
  }
  
  public void a(String paramString, boolean paramBoolean) {
    super.a(paramString, paramBoolean);
    if (paramString == null)
      return; 
    byte b = -1;
    int i = paramString.hashCode();
    if (i != -1290256561) {
      if (i == 623698297 && paramString.equals("_load_type_loadmore_"))
        b = 1; 
    } else if (paramString.equals("_load_type_refresh_")) {
      b = 0;
    } 
    if (b != 0 && b != 1)
      return; 
    b(paramBoolean);
  }
  
  protected void a(List<BluedIngSelfFeed> paramList) {
    this.f.c(paramList);
  }
  
  public void aL_() {
    super.aL_();
    this.e = null;
  }
  
  public void b(String paramString) {
    super.b(paramString);
  }
  
  public void onPause() {
    super.onPause();
    FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.f;
    if (feedListAdapterForRecyclerView != null)
      feedListAdapterForRecyclerView.c(); 
  }
  
  public void onResume() {
    super.onResume();
    if (this.f != null && getUserVisibleHint())
      this.f.b(); 
  }
  
  public int p() {
    return 2131493158;
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.f;
    if (feedListAdapterForRecyclerView != null) {
      if (paramBoolean) {
        feedListAdapterForRecyclerView.b();
        return;
      } 
      feedListAdapterForRecyclerView.c();
    } 
  }
  
  public void u() {
    this.mRefreshLayout.i();
  }
  
  public void x() {
    super.x();
    this.mRefreshLayout.b(true);
  }
  
  public void y() {
    super.y();
    this.mRefreshLayout.b(false);
    AppMethods.d(2131756083);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\discover\fragment\ImageFeedFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */