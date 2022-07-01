package com.soft.blued.ui.discover.fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.SearchView;
import com.soft.blued.customview.smartrefresh.BluedAdapterLoadMoreView;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.discover.presenter.SuperTopicPresenter;
import com.soft.blued.ui.feed.adapter.SuperTopicAdapter;
import com.soft.blued.ui.feed.fragment.CreateSuperTopicFragment;
import com.soft.blued.ui.feed.fragment.MyTopicPageFragment;
import com.soft.blued.ui.feed.fragment.SuperTopicDetailFragment;
import com.soft.blued.ui.feed.fragment.SuperTopicSearchFragment;
import com.soft.blued.ui.feed.model.BluedTopic;
import com.soft.blued.utils.click.SingleItemClickProxy;
import java.util.List;

public class SuperTopicFragment extends MvpFragment<SuperTopicPresenter> {
  private SuperTopicAdapter d;
  
  private NoDataAndLoadFailView e;
  
  private boolean f = true;
  
  @BindView(2131297102)
  FrameLayout flCreateSuperTopic;
  
  private int g;
  
  private final RecyclerView.OnScrollListener h = new RecyclerView.OnScrollListener(this) {
      public void onScrollStateChanged(RecyclerView param1RecyclerView, int param1Int) {
        super.onScrollStateChanged(param1RecyclerView, param1Int);
        if (this.a.stvCreateSuperTopic != null && param1Int == 0)
          if (!param1RecyclerView.canScrollVertically(-1)) {
            if (!SuperTopicFragment.a(this.a)) {
              SuperTopicFragment.b(this.a);
              return;
            } 
          } else if (!param1RecyclerView.canScrollVertically(1) && !SuperTopicFragment.a(this.a)) {
            SuperTopicFragment.c(this.a);
          }  
      }
      
      public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
        super.onScrolled(param1RecyclerView, param1Int1, param1Int2);
        if (param1Int2 < 0) {
          if (!SuperTopicFragment.a(this.a)) {
            SuperTopicFragment.b(this.a);
            return;
          } 
        } else if (param1Int2 > 0 && SuperTopicFragment.a(this.a)) {
          SuperTopicFragment.c(this.a);
        } 
      }
    };
  
  @BindView(2131297736)
  ImageView ivCreateSuperTopic;
  
  @BindView(2131298127)
  LinearLayout linearLayout;
  
  @BindView(2131299605)
  RecyclerView recyclerView;
  
  @BindView(2131299616)
  SmartRefreshLayout refreshLayout;
  
  @BindView(2131299874)
  SearchView searchView;
  
  @BindView(2131300079)
  ShapeTextView stvCreateSuperTopic;
  
  @BindView(2131300273)
  CommonTopTitleNoTrans title;
  
  @BindView(2131301087)
  TextView tvMyTopic;
  
  private void E() {
    G();
    this.f = true;
  }
  
  private void F() {
    H();
    this.f = false;
  }
  
  private void G() {
    ShapeTextView shapeTextView = this.stvCreateSuperTopic;
    if (shapeTextView != null && shapeTextView.getWidth() != this.g) {
      ValueAnimator valueAnimator = ObjectAnimator.ofInt(new int[] { this.stvCreateSuperTopic.getWidth(), this.g });
      valueAnimator.setDuration(300L);
      valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
            public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
              int i = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
              FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.a.stvCreateSuperTopic.getLayoutParams();
              layoutParams.width = i;
              this.a.stvCreateSuperTopic.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            }
          });
      valueAnimator.start();
    } 
  }
  
  private void H() {
    ShapeTextView shapeTextView = this.stvCreateSuperTopic;
    if (shapeTextView != null && shapeTextView.getWidth() != 0) {
      ValueAnimator valueAnimator = ObjectAnimator.ofInt(new int[] { this.stvCreateSuperTopic.getWidth(), 0 });
      valueAnimator.setDuration(300L);
      valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
            public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
              int i = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
              FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.a.stvCreateSuperTopic.getLayoutParams();
              layoutParams.width = i;
              this.a.stvCreateSuperTopic.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            }
          });
      valueAnimator.start();
    } 
  }
  
  public static void a(Context paramContext) {
    TerminalActivity.d(paramContext, SuperTopicFragment.class, null);
  }
  
  private void b(boolean paramBoolean) {
    this.refreshLayout.g();
    this.refreshLayout.h();
    if (this.d.n().size() <= 0) {
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
  }
  
  private void l() {
    this.stvCreateSuperTopic.post(new Runnable(this) {
          public void run() {
            if (this.a.stvCreateSuperTopic != null) {
              SuperTopicFragment superTopicFragment = this.a;
              SuperTopicFragment.a(superTopicFragment, superTopicFragment.stvCreateSuperTopic.getWidth());
            } 
          }
        });
  }
  
  private void m() {
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    this.recyclerView.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.d = new SuperTopicAdapter(getContext(), (IRequestHost)w_());
    this.d.a(true);
    this.recyclerView.setAdapter((RecyclerView.Adapter)this.d);
    this.recyclerView.addOnScrollListener(this.h);
    this.e = new NoDataAndLoadFailView(getContext());
    this.d.e((View)this.e);
    this.d.d(true);
    this.d.a((BaseQuickAdapter.OnItemClickListener)new SingleItemClickProxy(new BaseQuickAdapter.OnItemClickListener(this) {
            public void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
              if (param1BaseQuickAdapter.e(param1Int) != null && param1BaseQuickAdapter.e(param1Int) instanceof BluedTopic) {
                EventTrackFeed.a(FeedProtos.Event.SUPER_TOPIC_DETAIL_SHOW, FeedProtos.DetailFrom.FIND_SUPER_TOPIC_LIST);
                BluedTopic bluedTopic = (BluedTopic)param1BaseQuickAdapter.e(param1Int);
                SuperTopicDetailFragment.a(this.a.getContext(), bluedTopic.super_did);
              } 
            }
          }));
    this.d.a(new SuperTopicAdapter.OnShowListener(this) {
          public void a(String param1String) {
            EventTrackFeed.d(FeedProtos.Event.SUPER_TOPIC_DRAW, param1String);
          }
        });
    this.d.a((LoadMoreView)new BluedAdapterLoadMoreView());
    this.refreshLayout.a(new OnRefreshLoadMoreListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            ((SuperTopicPresenter)this.a.s()).f();
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            ((SuperTopicPresenter)this.a.s()).e();
          }
        });
  }
  
  private void n() {
    this.searchView.setMaskLayerOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            SuperTopicSearchFragment.a(this.a.getContext());
          }
        });
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    k();
    l();
    n();
    m();
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
  
  protected void a(List<BluedTopic> paramList) {
    this.d.c(paramList);
  }
  
  public void aL_() {
    super.aL_();
    this.e = null;
  }
  
  public void b(String paramString) {
    super.b(paramString);
  }
  
  @OnClick({2131301087, 2131297102})
  public void onViewClicked(View paramView) {
    int i = paramView.getId();
    if (i != 2131297102) {
      if (i != 2131301087)
        return; 
      EventTrackFeed.a(FeedProtos.Event.SUPER_TOPIC_MINE_BTN_CLICK);
      MyTopicPageFragment.a(getContext());
      return;
    } 
    EventTrackFeed.a(FeedProtos.Event.SUPER_TOPIC_CREATE_BTN_CLICK);
    CreateSuperTopicFragment.a(getContext());
  }
  
  public int p() {
    return 2131493326;
  }
  
  public void u() {
    this.refreshLayout.i();
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
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\discover\fragment\SuperTopicFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */