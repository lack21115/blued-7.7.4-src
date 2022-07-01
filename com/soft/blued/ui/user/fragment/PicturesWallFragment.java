package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.activity.PreloadFragment;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.framework.view.pulltorefresh.RecyclerViewLoadMoreView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.http.FeedHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.FeedComment;
import com.soft.blued.ui.feed.model.FeedRepost;
import com.soft.blued.ui.feed.observer.AlbumViewObserver;
import com.soft.blued.ui.feed.observer.IFeedDataObserver;
import com.soft.blued.ui.find.observer.UserInfoDataObserver;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.ui.photo.manager.AlbumViewDataManager;
import com.soft.blued.ui.photo.observer.PhotoListPositionObserver;
import com.soft.blued.ui.user.adapter.WaterfallPicturesAdapter;
import com.soft.blued.ui.user.model.AlbumFlow;
import com.soft.blued.ui.user.model.AlbumForDataTrans;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.List;

public class PicturesWallFragment extends PreloadFragment implements BaseQuickAdapter.RequestLoadMoreListener, AlbumViewObserver.IAblumViewObserver, IFeedDataObserver, PhotoListPositionObserver.IPhotoListPositionObserver {
  private int A = 1;
  
  private boolean B = false;
  
  private boolean C = false;
  
  private boolean D = false;
  
  private final int o = 10;
  
  private final int p = 2;
  
  private Context q;
  
  private View r;
  
  private ProgressBar s;
  
  private RecyclerView t;
  
  private WaterfallPicturesAdapter u;
  
  private PullToRefreshRecyclerView v;
  
  private StaggeredGridLayoutManager w;
  
  private String x = "";
  
  private AlbumForDataTrans y;
  
  private BluedUIHttpResponse z;
  
  public static PicturesWallFragment a(String paramString) {
    PicturesWallFragment picturesWallFragment = new PicturesWallFragment();
    Bundle bundle = new Bundle();
    bundle.putString("tab_id", paramString);
    picturesWallFragment.setArguments(bundle);
    return picturesWallFragment;
  }
  
  private void a(BluedEntityA<AlbumFlow> paramBluedEntityA) {
    if (paramBluedEntityA != null && paramBluedEntityA.hasData()) {
      if (this.A == 1) {
        this.u.c(paramBluedEntityA.data);
        this.y.data.clear();
        a(this.u.n());
        AlbumViewDataManager.a().a(paramBluedEntityA.hasMore());
      } else {
        this.u.a(paramBluedEntityA.data);
        a(this.u.a());
        AlbumViewDataManager.a().a(paramBluedEntityA.hasMore(), this.y.data);
      } 
      if (paramBluedEntityA.hasMore()) {
        this.u.c(true);
        return;
      } 
      this.u.b(true);
      this.u.c(false);
      return;
    } 
    int i = this.A;
    if (i != 1)
      this.A = i - 1; 
    this.u.c(false);
  }
  
  private void a(AlbumFlow paramAlbumFlow) {
    FeedHttpUtils.a(this.q, new BluedUIHttpResponse<BluedEntity>(this) {
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            BluedHttpUtils.b(param1Throwable, param1Int, param1String);
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {}
        }UserInfo.a().i().getUid(), paramAlbumFlow.feed_id, paramAlbumFlow.is_ads, (IRequestHost)w_());
  }
  
  private void a(AlbumFlow paramAlbumFlow, int paramInt, String paramString) {
    FeedHttpUtils.a(this.q, new BluedUIHttpResponse<BluedEntity>(this) {
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            BluedHttpUtils.b(param1Throwable, param1Int, param1String);
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {}
        }UserInfo.a().i().getUid(), paramAlbumFlow.feed_id, paramInt, paramString, (IRequestHost)w_());
  }
  
  private void a(List<AlbumFlow> paramList) {
    for (AlbumFlow albumFlow : paramList)
      this.y.data.add((AlbumFlow)albumFlow.clone()); 
  }
  
  private void d(View paramView) {
    if (paramView == null)
      return; 
    this.u = new WaterfallPicturesAdapter(this.q, (IRequestHost)w_());
    this.y = new AlbumForDataTrans();
    this.s = (ProgressBar)paramView.findViewById(2131299526);
    this.s.setVisibility(8);
    this.w = new StaggeredGridLayoutManager(2, 1);
    this.v = (PullToRefreshRecyclerView)paramView.findViewById(2131299533);
    this.t = (RecyclerView)this.v.getRefreshableView();
    this.u.a((LoadMoreView)new RecyclerViewLoadMoreView());
    this.u.c(false);
    this.u.a(this, this.t);
    this.u.a(new BaseQuickAdapter.OnItemClickListener(this) {
          public void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            BasePhotoFragment.a(PicturesWallFragment.a(this.a), PicturesWallFragment.b(this.a), param1Int, null, 10, "", "");
            InstantLog.a("picture_lib_click");
          }
        });
    this.u.a(new BaseQuickAdapter.OnItemChildClickListener(this) {
          public void onItemChildClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            AlbumFlow albumFlow = param1BaseQuickAdapter.n().get(param1Int);
            if (param1View.getId() != 2131297806)
              return; 
            if (!UserRelationshipUtils.a(albumFlow.relationship)) {
              if (albumFlow.iliked == 0) {
                albumFlow.iliked = 1;
                PicturesWallFragment.a(this.a, albumFlow, albumFlow.is_ads, albumFlow.liked_url);
              } else {
                albumFlow.iliked = 0;
                PicturesWallFragment.a(this.a, albumFlow);
              } 
              LiveEventBus.get("feed_like_change").post(albumFlow);
              UserInfoDataObserver.a().c();
            } 
          }
        });
    this.u.a(new BaseQuickAdapter.OnItemChildClickListener(this) {
          public void onItemChildClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            AlbumFlow albumFlow = param1BaseQuickAdapter.n().get(param1Int);
            if (param1View.getId() != 2131297806)
              return; 
            if (!UserRelationshipUtils.a(albumFlow.relationship)) {
              if (albumFlow.iliked == 0) {
                albumFlow.iliked = 1;
                PicturesWallFragment.a(this.a, albumFlow, albumFlow.is_ads, albumFlow.liked_url);
              } else {
                albumFlow.iliked = 0;
                PicturesWallFragment.a(this.a, albumFlow);
              } 
              LiveEventBus.get("feed_like_change").post(albumFlow);
              UserInfoDataObserver.a().c();
            } 
          }
        });
    this.v.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>(this) {
          public void a(PullToRefreshBase<RecyclerView> param1PullToRefreshBase) {
            PicturesWallFragment.c(this.a).refresh();
            PicturesWallFragment.a(this.a, 1);
            PicturesWallFragment.d(this.a);
          }
        });
    this.t.addItemDecoration(new SpacingItemDecoration(this, DensityUtils.a(this.q, 10.0F)));
    this.t.setLayoutManager((RecyclerView.LayoutManager)this.w);
    this.t.setAdapter((RecyclerView.Adapter)this.u);
    NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(this.q);
    noDataAndLoadFailView.b();
    this.u.e((View)noDataAndLoadFailView);
    this.z = new BluedUIHttpResponse<BluedEntityA<AlbumFlow>>(this, this.x, (IRequestHost)w_()) {
        boolean a = false;
        
        protected void a(BluedEntityA<AlbumFlow> param1BluedEntityA) {
          super.onUICache((BluedEntity)param1BluedEntityA);
          if (param1BluedEntityA == null) {
            PicturesWallFragment.b(this.b, false);
          } else {
            PicturesWallFragment.b(this.b, true);
          } 
          PicturesWallFragment.a(this.b, param1BluedEntityA);
        }
        
        protected void b(BluedEntityA<AlbumFlow> param1BluedEntityA) {
          PicturesWallFragment.a(this.b, param1BluedEntityA);
        }
        
        public boolean onUIFailure(int param1Int, String param1String) {
          this.a = true;
          AlbumViewDataManager.a().c();
          return super.onUIFailure(param1Int, param1String);
        }
        
        public void onUIFinish() {
          super.onUIFinish();
          if (PicturesWallFragment.e(this.b) == 1) {
            PicturesWallFragment.f(this.b).j();
            if (this.a && !PicturesWallFragment.g(this.b))
              PicturesWallFragment.h(this.b).setVisibility(0); 
            PicturesWallFragment.i(this.b).f();
          } else if (this.a) {
            if (PicturesWallFragment.e(this.b) != 1)
              PicturesWallFragment.j(this.b); 
            PicturesWallFragment.i(this.b).m();
          } else if (PicturesWallFragment.i(this.b).a() != null && PicturesWallFragment.i(this.b).a().size() >= 0) {
            PicturesWallFragment.i(this.b).l();
          } else {
            PicturesWallFragment.i(this.b).m();
          } 
          PicturesWallFragment.i(this.b).notifyDataSetChanged();
          PicturesWallFragment.a(this.b, false);
        }
        
        public void onUIStart() {
          super.onUIStart();
          PicturesWallFragment.a(this.b, true);
        }
      };
    this.z.refresh();
    this.v.k();
  }
  
  private void u() {
    FeedHttpUtils.a(this.z, String.valueOf(this.A), "15", this.x, (IRequestHost)w_());
  }
  
  public void a() {
    this.A++;
    u();
  }
  
  public void a(int paramInt) {}
  
  public void a(View paramView) {
    LayoutInflater.from(this.q).inflate(2131493270, (ViewGroup)paramView, true);
    d(paramView);
  }
  
  public void a(BluedIngSelfFeed paramBluedIngSelfFeed) {}
  
  public void a(FeedComment paramFeedComment) {}
  
  public void a(FeedRepost paramFeedRepost) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void b(int paramInt) {}
  
  public void b(String paramString, int paramInt) {}
  
  public void b(String paramString1, String paramString2) {}
  
  public void c(int paramInt) {
    this.w.scrollToPositionWithOffset(paramInt - 1, 30);
  }
  
  public void c(String paramString, int paramInt) {
    this.u.a(paramString, paramInt);
    this.y.data.clear();
    a(this.u.n());
  }
  
  public void d(String paramString) {}
  
  public void e(String paramString) {}
  
  public void onAttach(Context paramContext) {
    super.onAttach(paramContext);
    this.q = paramContext;
    if (getArguments() != null)
      this.x = getArguments().getString("tab_id"); 
  }
  
  public void onLoadMoreRequested() {
    this.A++;
    u();
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean) {
      if (!this.B) {
        this.B = true;
        AlbumViewObserver.a().a(this);
        PhotoListPositionObserver.a().a(this);
        return;
      } 
    } else {
      this.B = false;
      AlbumViewDataManager.a().a(false);
      AlbumViewObserver.a().b(this);
      PhotoListPositionObserver.a().b(this);
    } 
  }
  
  public void t() {
    RecyclerView recyclerView = this.t;
    if (recyclerView != null)
      recyclerView.smoothScrollToPosition(0); 
  }
  
  public class SpacingItemDecoration extends RecyclerView.ItemDecoration {
    private int b;
    
    public SpacingItemDecoration(PicturesWallFragment this$0, int param1Int) {
      this.b = param1Int;
    }
    
    public void getItemOffsets(Rect param1Rect, View param1View, RecyclerView param1RecyclerView, RecyclerView.State param1State) {
      int i = this.b;
      param1Rect.left = i / 2;
      param1Rect.bottom = i;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\PicturesWallFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */