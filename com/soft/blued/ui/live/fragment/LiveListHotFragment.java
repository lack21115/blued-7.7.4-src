package com.soft.blued.ui.live.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.TypeUtils;
import com.blued.android.framework.view.PauseOnScrollListener;
import com.blued.android.module.live_china.observer.LiveListPositionObserver;
import com.blued.android.module.live_china.observer.LiveSwipeRefreshObserver;
import com.blued.android.module.live_china.observer.LiveTabNewObserver;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import com.soft.blued.ui.live.adapter.LiveListAdapter;
import com.soft.blued.ui.live.manager.LiveFloatRedBagViewScrollObserver;
import com.soft.blued.ui.live.manager.LiveHotViewScrollObserver;
import com.soft.blued.ui.live.model.BluedLiveListData;
import com.soft.blued.ui.live.presenter.LiveListHotPresenter;
import com.soft.blued.utils.Logger;
import java.util.ArrayList;
import java.util.List;

public class LiveListHotFragment extends MvpFragment<LiveListHotPresenter> implements LiveListPositionObserver.ILiveListPositionObserver, LiveTabNewObserver.ILiveTabRefreshObserver {
  public Context d;
  
  public LiveListAdapter e;
  
  public PauseOnScrollListener f;
  
  private String g = "0";
  
  @BindView(2131297289)
  RecyclerView grid_view;
  
  private int h = 0;
  
  private boolean i = true;
  
  private boolean j;
  
  @BindView(2131298771)
  LinearLayout ll_default_empty;
  
  @BindView(2131299618)
  SmartRefreshLayout refresh_view;
  
  private void G() {
    this.f = new PauseOnScrollListener(false, true);
  }
  
  private void H() {
    this.refresh_view.c(false);
    this.refresh_view.a((OnMultiPurposeListener)new SimpleMultiPurposeListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            ((LiveListHotPresenter)this.a.s()).f();
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {}
        });
    this.grid_view.addOnScrollListener(new RecyclerView.OnScrollListener(this) {
          public void onScrollStateChanged(RecyclerView param1RecyclerView, int param1Int) {
            super.onScrollStateChanged(param1RecyclerView, param1Int);
            if (!LiveListHotFragment.a(this.a))
              return; 
            this.a.f.onScrollStateChanged(null, param1Int);
            if (param1Int == 0) {
              if (this.a.e != null) {
                this.a.e.f(false);
                this.a.e.b();
                return;
              } 
            } else if (param1Int == 1 && this.a.e != null) {
              this.a.e.f(true);
            } 
          }
          
          public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
            super.onScrolled(param1RecyclerView, param1Int1, param1Int2);
            LiveFloatRedBagViewScrollObserver.a().a(param1RecyclerView, param1Int1, param1Int2);
            LiveHotViewScrollObserver.a().a(param1RecyclerView, param1Int1, param1Int2);
          }
        });
    this.e = new LiveListAdapter((IRequestHost)w_(), this.d, true, 1, this.g);
    this.grid_view.setAdapter((RecyclerView.Adapter)this.e);
  }
  
  private void I() {
    if (this.grid_view.getLayoutManager() == null) {
      GridLayoutManager gridLayoutManager = new GridLayoutManager(this.d, 6);
      this.grid_view.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
      gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(this) {
            public int getSpanSize(int param1Int) {
              LiveListAdapter liveListAdapter = this.c.e;
              byte b = 2;
              if (liveListAdapter != null && this.c.e.e(param1Int) != null) {
                int i = this.c.e.getItemViewType(param1Int);
                if (i != 0) {
                  param1Int = b;
                  if (i != 2)
                    return 6; 
                } else {
                  return 3;
                } 
                return param1Int;
              } 
              return 6;
            }
          });
      this.e.notifyDataSetChanged();
    } 
  }
  
  private void b(List<BluedLiveListData> paramList) {
    if (paramList != null) {
      this.e.a(((Boolean)TypeUtils.a(Boolean.valueOf(((LiveListHotPresenter)s()).p()))).booleanValue());
      this.e.c(paramList);
    } 
    if (this.e.n().size() > 0) {
      this.ll_default_empty.setVisibility(8);
      this.grid_view.setVisibility(0);
    } else {
      this.ll_default_empty.setVisibility(0);
      this.grid_view.setVisibility(8);
    } 
    I();
  }
  
  public void E() {
    this.refresh_view.h();
  }
  
  public void F() {
    LiveSwipeRefreshObserver.a().b();
  }
  
  public void a(int paramInt, long paramLong) {
    Logger.a("rrb", new Object[] { "notifyLiveListPosition = ", Integer.valueOf(paramInt), "-- sessionId = ", Long.valueOf(paramLong) });
    if (!this.j)
      return; 
    if (paramInt == -1)
      return; 
    try {
      if (this.grid_view != null && this.e != null) {
        List list = this.e.n();
        int i = 0;
        while (true) {
          int j = paramInt;
          if (i < list.size())
            if (TextUtils.equals(((BluedLiveListData)list.get(i)).lid, String.valueOf(paramLong))) {
              j = i;
            } else {
              i++;
              continue;
            }  
          this.grid_view.getLayoutManager().scrollToPosition(j);
          Logger.a("rrb", new Object[] { "scrollToPosition position = ", Integer.valueOf(j) });
          return;
        } 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      Logger.a("rrb", new Object[] { "e = ", exception });
    } 
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    H();
    LiveTabNewObserver.a().a(this);
    LiveListPositionObserver.a().a(this);
    this.j = true;
  }
  
  public void a(String paramString, boolean paramBoolean) {
    super.a(paramString, paramBoolean);
    Log.i("xpm", "dismissDataLoading");
    F();
    E();
    this.grid_view.stopScroll();
  }
  
  public void a(List<BluedLiveListData> paramList) {
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("receive notifyListUpdate:");
    if (paramList != null) {
      Integer integer = Integer.valueOf(paramList.size());
    } else {
      str = "null";
    } 
    stringBuilder.append(str);
    Log.i("xpm", stringBuilder.toString());
    b(paramList);
  }
  
  public void aL_() {
    super.aL_();
    this.j = false;
    LiveTabNewObserver.a().b(this);
    LiveListPositionObserver.a().b(this);
  }
  
  public void b(String paramString) {
    super.b(paramString);
    Log.i("xpm", "showDataLoading");
  }
  
  public void c() {
    if (this.i) {
      Log.i("xpm", "notifyLiveDataRefresh");
      ((LiveListHotPresenter)s()).e();
    } 
  }
  
  public void d() {
    if (!this.j)
      return; 
    if (!this.grid_view.canScrollVertically(-1))
      this.grid_view.stopScroll(); 
  }
  
  public void e() {
    if (!this.j)
      return; 
    if (this.grid_view.getLayoutManager() != null)
      this.grid_view.getLayoutManager().scrollToPosition(0); 
  }
  
  public void k() {
    Log.i("xpm", "receive notifyListUpdateNoData");
    b(new ArrayList<BluedLiveListData>());
  }
  
  public boolean l() {
    if (s() != null && ((LiveListHotPresenter)s()).n() == 0) {
      LiveListAdapter liveListAdapter = this.e;
      if (liveListAdapter != null && liveListAdapter.getItemCount() <= 0)
        return true; 
    } 
    return false;
  }
  
  public void m() {
    this.refresh_view.b(true);
  }
  
  public void n() {
    this.refresh_view.b(false);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.d = getContext();
    G();
  }
  
  public int p() {
    return 2131493191;
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    this.i = paramBoolean;
  }
  
  public void x() {
    super.x();
    Log.i("xpm", "enableLoadMore");
    m();
  }
  
  public void y() {
    super.y();
    Log.i("xpm", "disableLoadMore");
    n();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\fragment\LiveListHotFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */