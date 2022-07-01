package com.soft.blued.ui.find.fragment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.das.client.feed.FeedProtos;
import com.google.android.material.appbar.AppBarLayout;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.soft.blued.customview.FloatFooterView;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.bluedad.BluedADConstraintLayout;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.feed.adapter.FeedListAdapterForRecyclerView;
import com.soft.blued.ui.feed.fragment.FeedPostFragment;
import com.soft.blued.ui.feed.model.BluedADExtra;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.find.model.NearbyOperate;
import com.soft.blued.ui.find.presenter.NearbyFeedPresenter;
import com.soft.blued.ui.home.HomeTabClick;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NearbyFeedFragment extends MvpFragment<NearbyFeedPresenter> implements HomeTabClick.TabClickListener {
  @BindView(2131296447)
  AppBarLayout appbar;
  
  private Context d;
  
  private List<Unbinder> e = new ArrayList<Unbinder>();
  
  private NoDataAndLoadFailView f;
  
  private FeedListAdapterForRecyclerView g;
  
  private boolean h;
  
  private RecyclerView.OnScrollListener i = new RecyclerView.OnScrollListener(this) {
      public void onScrollStateChanged(RecyclerView param1RecyclerView, int param1Int) {
        if (NearbyFeedFragment.a(this.a) != null && (NearbyFeedFragment.a(this.a)).p != null)
          (NearbyFeedFragment.a(this.a)).p.onScrollStateChanged(param1RecyclerView, param1Int); 
        if (this.a.llFeedPost != null && param1Int == 0) {
          if (!param1RecyclerView.canScrollVertically(-1)) {
            this.a.llFeedPost.a();
            return;
          } 
          if (!param1RecyclerView.canScrollVertically(1)) {
            if (!((NearbyFeedPresenter)this.a.s()).m())
              AppMethods.a(NearbyFeedFragment.b(this.a).getResources().getString(2131758247)); 
            this.a.llFeedPost.b();
          } 
        } 
      }
      
      public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
        if (NearbyFeedFragment.a(this.a) != null && (NearbyFeedFragment.a(this.a)).p != null)
          (NearbyFeedFragment.a(this.a)).p.onScrolled(param1RecyclerView, param1Int1, param1Int2); 
        if (param1Int2 < 0) {
          this.a.llFeedPost.a();
          return;
        } 
        if (param1Int2 > 0)
          this.a.llFeedPost.b(); 
      }
    };
  
  @BindView(2131298800)
  FloatFooterView llFeedPost;
  
  @BindView(2131299605)
  RecyclerView mRecyclerView;
  
  @BindView(2131299616)
  SmartRefreshLayout mRefreshLayout;
  
  @BindView(2131301590)
  ViewFlipper vfFeedOperate;
  
  private void b(boolean paramBoolean) {
    this.mRefreshLayout.g();
    this.mRefreshLayout.g(paramBoolean);
    if (this.g.n().size() <= 0) {
      NoDataAndLoadFailView noDataAndLoadFailView = this.f;
      if (noDataAndLoadFailView != null) {
        if (paramBoolean) {
          noDataAndLoadFailView.a();
          return;
        } 
        noDataAndLoadFailView.b();
      } 
    } 
  }
  
  private void k() {
    InstantLog.b("feed_post_btn_click", 0);
    EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_BTN_CLICK, FeedProtos.FeedFrom.PUBLISH_PLAZA_NEARBY);
    FeedPostFragment.a(this.d);
  }
  
  private void l() {
    this.llFeedPost.setOnBtnClickListener(new FloatFooterView.OnBtnClickListener(this) {
          public void onPostFeedClick() {
            NearbyFeedFragment.c(this.a);
          }
        });
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.d);
    this.mRecyclerView.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    if (this.g == null) {
      this.g = new FeedListAdapterForRecyclerView(new ArrayList(), this.d, (IRequestHost)w_(), this.mRecyclerView, 4);
      this.f = new NoDataAndLoadFailView(this.d);
      this.g.e((View)this.f);
      ((NearbyFeedPresenter)s()).a(this.g);
    } 
    this.mRecyclerView.setAdapter((RecyclerView.Adapter)this.g);
    this.mRecyclerView.addOnScrollListener(this.i);
    this.mRefreshLayout.a(new OnRefreshLoadMoreListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            ((NearbyFeedPresenter)this.a.s()).f();
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            ((NearbyFeedPresenter)this.a.s()).e();
          }
        });
    InstantLog.b("first_auto_load", 1);
  }
  
  public boolean A() {
    return true;
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.d = (Context)getActivity();
    l();
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
    this.g.c(paramList);
  }
  
  public void aL_() {
    this.mRecyclerView.setAdapter(null);
    super.aL_();
    List<Unbinder> list = this.e;
    if (list != null) {
      Iterator<Unbinder> iterator = list.iterator();
      while (iterator.hasNext())
        ((Unbinder)iterator.next()).unbind(); 
      this.e.clear();
    } 
    RecyclerView recyclerView = this.mRecyclerView;
    if (recyclerView != null)
      recyclerView.removeOnScrollListener(this.i); 
  }
  
  public void b(List<NearbyOperate.DataBean> paramList) {
    this.vfFeedOperate.removeAllViews();
    if (paramList != null && paramList.size() > 0) {
      AppBarLayout appBarLayout = this.appbar;
      int i = 0;
      appBarLayout.setVisibility(0);
      this.vfFeedOperate.setVisibility(0);
      while (i < paramList.size()) {
        NearbyOperate.DataBean dataBean = paramList.get(i);
        if (!TextUtils.isEmpty(dataBean.content)) {
          NearbyOperateViewHolder nearbyOperateViewHolder = new NearbyOperateViewHolder(this);
          View view = getLayoutInflater().inflate(2131493512, null);
          Unbinder unbinder = ButterKnife.a(nearbyOperateViewHolder, view);
          this.e.add(unbinder);
          nearbyOperateViewHolder.tvVfCircleTitle.setText(dataBean.content);
          nearbyOperateViewHolder.tvRecommend.setText(dataBean.title);
          nearbyOperateViewHolder.tvRecommend.getBackground().setAlpha(10);
          nearbyOperateViewHolder.adConstraintLayout.a((BluedADExtra)dataBean, new View.OnClickListener(this, dataBean, paramList) {
                public void onClick(View param1View) {
                  WebViewShowInfoFragment.show(NearbyFeedFragment.b(this.c), this.a.target_url, 15);
                  EventTrackFeed.h(FeedProtos.Event.CITY_TOP_CLICK, String.valueOf(this.a.ads_id), ((NearbyOperate.DataBean)this.b.get(this.c.vfFeedOperate.getDisplayedChild())).target_url);
                }
              });
          this.vfFeedOperate.addView(view);
        } 
        i++;
      } 
      this.vfFeedOperate.getInAnimation().setAnimationListener(new Animation.AnimationListener(this, paramList) {
            public void onAnimationEnd(Animation param1Animation) {
              if (this.b.vfFeedOperate.getGlobalVisibleRect(new Rect())) {
                List list = this.a;
                if (list != null && list.size() > this.b.vfFeedOperate.getDisplayedChild())
                  EventTrackFeed.h(FeedProtos.Event.CITY_TOP_SHOW, String.valueOf(((NearbyOperate.DataBean)this.a.get(this.b.vfFeedOperate.getDisplayedChild())).ads_id), ((NearbyOperate.DataBean)this.a.get(this.b.vfFeedOperate.getDisplayedChild())).target_url); 
              } 
              if (this.a.size() <= 1)
                this.b.vfFeedOperate.stopFlipping(); 
            }
            
            public void onAnimationRepeat(Animation param1Animation) {
              if (this.a.size() > 1) {
                this.b.vfFeedOperate.startFlipping();
                return;
              } 
              this.b.vfFeedOperate.stopFlipping();
            }
            
            public void onAnimationStart(Animation param1Animation) {}
          });
      return;
    } 
    this.vfFeedOperate.setVisibility(8);
    this.appbar.setVisibility(8);
  }
  
  public void c(String paramString) {
    if ("find".equals(paramString) && this.mRefreshLayout != null) {
      RecyclerView recyclerView = this.mRecyclerView;
      if (recyclerView != null) {
        recyclerView.scrollToPosition(0);
        this.mRefreshLayout.i();
      } 
    } 
  }
  
  public void d(String paramString) {
    c(paramString);
  }
  
  public void onDestroyView() {
    HomeTabClick.b("feed", this);
    super.onDestroyView();
  }
  
  public void onPause() {
    super.onPause();
    FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.g;
    if (feedListAdapterForRecyclerView != null)
      feedListAdapterForRecyclerView.c(); 
  }
  
  public void onResume() {
    super.onResume();
    FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.g;
    if (feedListAdapterForRecyclerView != null && this.h)
      feedListAdapterForRecyclerView.b(); 
  }
  
  public int p() {
    return 2131493248;
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    this.h = paramBoolean;
    LiveEventBus.get("set_tip_visibility").post(Boolean.valueOf(true));
    if (paramBoolean)
      HomeTabClick.a("find", this); 
    FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.g;
    if (feedListAdapterForRecyclerView != null) {
      if (this.h) {
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
  }
  
  class NearbyOperateViewHolder {
    @BindView(2131296537)
    BluedADConstraintLayout adConstraintLayout;
    
    @BindView(2131301238)
    TextView tvRecommend;
    
    @BindView(2131301491)
    TextView tvVfCircleTitle;
    
    NearbyOperateViewHolder(NearbyFeedFragment this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\NearbyFeedFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */