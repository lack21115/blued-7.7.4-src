package com.soft.blued.ui.feed.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.soft.blued.customview.FeedSendRecyclerView;
import com.soft.blued.customview.FloatFooterView;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.feed.adapter.AttentionRecommendLiveAdapter;
import com.soft.blued.ui.feed.adapter.FeedListAdapterForRecyclerView;
import com.soft.blued.ui.feed.model.AttentionLiveRecommendData;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.presenter.AttentionFeedPresenter;
import com.soft.blued.ui.home.HomeTabClick;
import com.soft.blued.ui.live.view.RecommendLoadMoreView;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import java.util.ArrayList;
import java.util.List;

public class AttentionFeedFragment extends MvpFragment<AttentionFeedPresenter> implements HomeTabClick.TabClickListener {
  @BindView(2131296447)
  AppBarLayout appbar;
  
  @BindView(2131296843)
  CoordinatorLayout coordinator;
  
  private Context d;
  
  private FeedListAdapterForRecyclerView e;
  
  private NoDataAndLoadFailView f;
  
  @BindView(2131297048)
  FeedSendRecyclerView feedSendList;
  
  private AttentionRecommendLiveAdapter g;
  
  private RecyclerView.OnScrollListener h = new RecyclerView.OnScrollListener(this) {
      public void onScrollStateChanged(RecyclerView param1RecyclerView, int param1Int) {
        if (AttentionFeedFragment.a(this.a) != null && (AttentionFeedFragment.a(this.a)).p != null)
          (AttentionFeedFragment.a(this.a)).p.onScrollStateChanged(param1RecyclerView, param1Int); 
        if (this.a.llFeedPost != null && param1Int == 0) {
          if (!param1RecyclerView.canScrollVertically(-1)) {
            this.a.llFeedPost.a();
            return;
          } 
          if (!param1RecyclerView.canScrollVertically(1)) {
            if (!((AttentionFeedPresenter)this.a.s()).m())
              AppMethods.a(AttentionFeedFragment.b(this.a).getResources().getString(2131758247)); 
            this.a.llFeedPost.b();
          } 
        } 
      }
      
      public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
        if (AttentionFeedFragment.a(this.a) != null && (AttentionFeedFragment.a(this.a)).p != null)
          (AttentionFeedFragment.a(this.a)).p.onScrolled(param1RecyclerView, param1Int1, param1Int2); 
        if (param1Int2 < 0) {
          this.a.llFeedPost.a();
          return;
        } 
        if (param1Int2 > 0)
          this.a.llFeedPost.b(); 
      }
    };
  
  @BindView(2131297981)
  RelativeLayout keyboardRelativeLayout;
  
  @BindView(2131298800)
  FloatFooterView llFeedPost;
  
  @BindView(2131298921)
  LinearLayout llLiveRecommend;
  
  @BindView(2131299605)
  RecyclerView recyclerView;
  
  @BindView(2131299616)
  SmartRefreshLayout refreshLayout;
  
  @BindView(2131299779)
  RecyclerView rvLiveRecommend;
  
  @BindView(2131301683)
  View viewSendListCut;
  
  private void E() {
    if (this.g == null) {
      this.g = new AttentionRecommendLiveAdapter(this.d, (IRequestHost)w_());
      this.g.c(true);
      this.g.a((LoadMoreView)new RecommendLoadMoreView());
    } 
    this.g.a(new BaseQuickAdapter.RequestLoadMoreListener(this) {
          public void onLoadMoreRequested() {
            ((AttentionFeedPresenter)this.a.s()).a(false);
          }
        },  this.rvLiveRecommend);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.d);
    linearLayoutManager.setOrientation(0);
    this.rvLiveRecommend.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.rvLiveRecommend.setAdapter((RecyclerView.Adapter)this.g);
  }
  
  private void b(boolean paramBoolean) {
    this.refreshLayout.g();
    this.refreshLayout.h();
    if (paramBoolean) {
      this.f.a();
      return;
    } 
    this.f.b();
  }
  
  private void m() {
    InstantLog.b("feed_post_btn_click", 1);
    EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_BTN_CLICK, FeedProtos.FeedFrom.FOLLOW);
    FeedPostFragment.a(this.d);
  }
  
  private void n() {
    this.llFeedPost.setOnBtnClickListener(new FloatFooterView.OnBtnClickListener(this) {
          public void onPostFeedClick() {
            AttentionFeedFragment.c(this.a);
          }
        });
    this.feedSendList.setRequestHost((IRequestHost)w_());
    this.viewSendListCut.setVisibility(8);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.d);
    this.recyclerView.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    if (this.e == null) {
      this.e = new FeedListAdapterForRecyclerView(new ArrayList(), this.d, (IRequestHost)w_(), this.recyclerView, 0);
      this.f = new NoDataAndLoadFailView(getContext());
      this.e.e((View)this.f);
    } 
    ((AttentionFeedPresenter)s()).a(this.e);
    this.recyclerView.setAdapter((RecyclerView.Adapter)this.e);
    this.recyclerView.addOnScrollListener(this.h);
    this.refreshLayout.a(new OnRefreshLoadMoreListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            ((AttentionFeedPresenter)this.a.s()).f();
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            ((AttentionFeedPresenter)this.a.s()).e();
            ChatHelperV4.a().a(13L);
          }
        });
    InstantLog.b("first_auto_load", 3);
    this.feedSendList.v();
  }
  
  public boolean A() {
    return true;
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.d = getContext();
    n();
    E();
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
  
  protected void a(List<AttentionLiveRecommendData> paramList) {
    this.llLiveRecommend.setVisibility(0);
    this.g.c(paramList);
    if (((AttentionFeedPresenter)s()).n() == 1)
      this.rvLiveRecommend.scrollToPosition(0); 
    this.g.l();
    this.g.c(((AttentionFeedPresenter)s()).m());
  }
  
  public void aL_() {
    this.recyclerView.setAdapter(null);
    super.aL_();
    RecyclerView recyclerView = this.recyclerView;
    if (recyclerView != null)
      recyclerView.removeOnScrollListener(this.h); 
  }
  
  public void b(String paramString) {
    super.b(paramString);
  }
  
  protected void b(List<BluedIngSelfFeed> paramList) {
    this.e.c(paramList);
  }
  
  public void c(String paramString) {
    if ("feed".equals(paramString) && this.refreshLayout != null) {
      RecyclerView recyclerView = this.recyclerView;
      if (recyclerView != null) {
        recyclerView.scrollToPosition(0);
        this.refreshLayout.i();
        ChatHelperV4.a().a(13L);
      } 
    } 
  }
  
  public void d(String paramString) {
    c(paramString);
  }
  
  protected void k() {
    this.llLiveRecommend.setVisibility(8);
  }
  
  protected void l() {
    FeedSendRecyclerView feedSendRecyclerView = this.feedSendList;
    if (feedSendRecyclerView != null && feedSendRecyclerView.getAdapter() != null && this.feedSendList.getAdapter().getItemCount() != 0) {
      this.viewSendListCut.setVisibility(0);
      return;
    } 
    this.viewSendListCut.setVisibility(8);
  }
  
  public void onDestroyView() {
    HomeTabClick.b("feed", this);
    FeedSendRecyclerView feedSendRecyclerView = this.feedSendList;
    if (feedSendRecyclerView != null)
      feedSendRecyclerView.w(); 
    super.onDestroyView();
  }
  
  public void onPause() {
    super.onPause();
    FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.e;
    if (feedListAdapterForRecyclerView != null)
      feedListAdapterForRecyclerView.c(); 
  }
  
  public void onResume() {
    super.onResume();
    if (this.e != null && getUserVisibleHint())
      this.e.b(); 
    if (getUserVisibleHint())
      HomeTabClick.a("feed", this); 
  }
  
  public int p() {
    return 2131493124;
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
      HomeTabClick.a("feed", this); 
    FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.e;
    if (feedListAdapterForRecyclerView != null) {
      if (paramBoolean) {
        feedListAdapterForRecyclerView.b();
        return;
      } 
      feedListAdapterForRecyclerView.c();
    } 
  }
  
  public void x() {
    super.x();
    this.refreshLayout.b(true);
  }
  
  public void y() {
    super.y();
    this.refreshLayout.b(false);
    AppMethods.d(2131756083);
  }
  
  public boolean z() {
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\fragment\AttentionFeedFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */