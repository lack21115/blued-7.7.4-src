package com.soft.blued.ui.discover.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.FloatFooterView;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.SpacesItemDecoration;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.discover.adapter.ShineVideoListAdapter;
import com.soft.blued.ui.feed.fragment.FeedPostFragment;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.video.manager.ShineVideoDataManager;
import java.util.List;

public class ShineVideoListFragment extends BaseFragment implements BaseQuickAdapter.RequestLoadMoreListener, ShineVideoDataManager.IShineVideoDataDownloadListner {
  public static String d = "KEY_FROM_INDEPENDENT";
  
  private Context e;
  
  private View f;
  
  private CommonTopTitleNoTrans g;
  
  private PullToRefreshRecyclerView h;
  
  private RecyclerView i;
  
  private NoDataAndLoadFailView j;
  
  private ShineVideoListAdapter k;
  
  private FloatFooterView l;
  
  private Long m;
  
  private int n;
  
  private float o;
  
  public static void a(Context paramContext) {
    TerminalActivity.d(paramContext, ShineVideoListFragment.class, null);
  }
  
  private void k() {
    InstantLog.b("feed_post_btn_click", 4);
    EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_BTN_CLICK, FeedProtos.FeedFrom.FLASH);
    FeedPostFragment.a(getContext(), true);
  }
  
  public void a() {
    this.g = (CommonTopTitleNoTrans)this.f.findViewById(2131300273);
    this.g.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.getActivity().finish();
          }
        });
    this.l = (FloatFooterView)this.f.findViewById(2131298800);
    this.l.setOnBtnClickListener(new FloatFooterView.OnBtnClickListener(this) {
          public void onPostFeedClick() {
            ShineVideoListFragment.a(this.a);
          }
        });
    this.j = new NoDataAndLoadFailView(this.e);
    this.j.a();
    this.h = (PullToRefreshRecyclerView)this.f.findViewById(2131298144);
    this.i = (RecyclerView)this.h.getRefreshableView();
    StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
    this.i.setLayoutManager((RecyclerView.LayoutManager)staggeredGridLayoutManager);
    SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(DensityUtils.a(this.e, 2.5F));
    spacesItemDecoration.a(5);
    spacesItemDecoration.a(true, true, true, true);
    spacesItemDecoration.a(DensityUtils.a(this.e, 7.5F), DensityUtils.a(this.e, 9.5F), DensityUtils.a(this.e, 7.5F), 0);
    this.i.addItemDecoration((RecyclerView.ItemDecoration)spacesItemDecoration);
    this.k = new ShineVideoListAdapter(this.e, (IRequestHost)w_());
    this.i.setAdapter((RecyclerView.Adapter)this.k);
    this.k.e((View)this.j);
    this.k.a(this, this.i);
    this.h.setRefreshEnabled(true);
    ShineVideoDataManager.a().i().refresh();
    this.h.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>(this) {
          public void a(PullToRefreshBase<RecyclerView> param1PullToRefreshBase) {
            InstantLog.a(0, 0);
            ShineVideoDataManager.a().i().refresh();
            ShineVideoDataManager.a().a(true, (IRequestHost)this.a.w_());
          }
        });
    this.h.k();
    this.i.setOnScrollListener(new RecyclerView.OnScrollListener(this) {
          public void onScrollStateChanged(RecyclerView param1RecyclerView, int param1Int) {
            super.onScrollStateChanged(param1RecyclerView, param1Int);
          }
          
          public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
            param1Int1 = ((StaggeredGridLayoutManager)param1RecyclerView.getLayoutManager()).findFirstVisibleItemPositions(null)[0];
            if (param1RecyclerView.getChildAt(0) != null) {
              param1Int2 = param1RecyclerView.getChildAt(0).getTop();
              if (ShineVideoListFragment.b(this.a) == null)
                ShineVideoListFragment.a(this.a, Long.valueOf(System.currentTimeMillis())); 
              long l = System.currentTimeMillis() - ShineVideoListFragment.b(this.a).longValue();
              if (param1Int1 == 0 && param1Int2 == 0) {
                ShineVideoListFragment.c(this.a).a();
              } else if (ShineVideoListFragment.d(this.a) < param1Int1) {
                ShineVideoListFragment.c(this.a).b();
              } else if (ShineVideoListFragment.d(this.a) == param1Int1) {
                float f1 = ShineVideoListFragment.e(this.a);
                float f2 = param1Int2;
                int i = (int)Math.abs(f1 - f2);
                if (ShineVideoListFragment.e(this.a) < f2 && l != 0L && (i * 1000) / l > 2000L) {
                  ShineVideoListFragment.c(this.a).a();
                } else if (ShineVideoListFragment.e(this.a) > f2 && i > 10) {
                  ShineVideoListFragment.c(this.a).b();
                } 
              } 
              ShineVideoListFragment.a(this.a, param1Int1);
              ShineVideoListFragment.a(this.a, param1Int2);
              ShineVideoListFragment.a(this.a, Long.valueOf(System.currentTimeMillis()));
            } 
          }
        });
    InstantLog.b("first_auto_load", 6);
  }
  
  public void a(BluedIngSelfFeed paramBluedIngSelfFeed) {}
  
  public void a(List<BluedIngSelfFeed> paramList) {
    if (paramList != null) {
      if (ShineVideoDataManager.a().f() == 1) {
        this.k.c(paramList);
        return;
      } 
      this.k.a(paramList);
    } 
  }
  
  public void a(boolean paramBoolean) {
    if (this.k.getItemCount() == 0) {
      if (paramBoolean) {
        this.j.b();
      } else {
        this.j.a();
      } 
      this.k.notifyDataSetChanged();
    } 
    if (ShineVideoDataManager.a().f() == 1)
      this.h.j(); 
    if (paramBoolean) {
      this.k.m();
      return;
    } 
    this.k.l();
  }
  
  public void a(boolean paramBoolean, List<BluedIngSelfFeed> paramList) {
    a(paramList);
    if (paramBoolean && paramList != null && paramList.size() > 0) {
      this.k.c(true);
      return;
    } 
    this.k.k();
    this.k.c(false);
    AppMethods.a(this.e.getResources().getString(2131758247));
  }
  
  public void b(BluedIngSelfFeed paramBluedIngSelfFeed) {
    if (ShineVideoDataManager.a().b() != null)
      this.k.c(ShineVideoDataManager.a().b()); 
  }
  
  public void b(List<BluedIngSelfFeed> paramList) {
    a(paramList);
  }
  
  public void c(List<BluedIngSelfFeed> paramList) {
    if (paramList != null)
      this.k.c(paramList); 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.e = (Context)getActivity();
    View view = this.f;
    if (view == null) {
      this.f = LayoutInflater.from(this.e).inflate(2131493318, null);
      a();
      ShineVideoDataManager.a().a(this);
    } else {
      ((ViewGroup)view.getParent()).removeView(this.f);
    } 
    return this.f;
  }
  
  public void onDestroy() {
    super.onDestroy();
    ShineVideoDataManager.a().b(this);
  }
  
  public void onLoadMoreRequested() {
    InstantLog.a(1, 0);
    ShineVideoDataManager.a().a(false, (IRequestHost)w_());
  }
  
  public void onPause() {
    super.onPause();
  }
  
  public void onResume() {
    super.onResume();
    if (ShineVideoDataManager.a().j() != -1) {
      RecyclerView recyclerView = this.i;
      if (recyclerView != null)
        recyclerView.scrollToPosition(ShineVideoDataManager.a().j()); 
    } 
  }
  
  public void onStop() {
    super.onStop();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\discover\fragment\ShineVideoListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */