package com.soft.blued.ui.live.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.activity.PreloadFragment;
import com.blued.android.framework.view.PauseOnScrollListener;
import com.blued.android.module.live_china.observer.LiveListPositionObserver;
import com.blued.android.module.live_china.observer.LiveSwipeRefreshObserver;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.ui.home.HomeTabClick;
import com.soft.blued.ui.live.adapter.LiveListAdapter;
import com.soft.blued.ui.live.contract.LiveListContract;
import com.soft.blued.ui.live.manager.LiveFloatRedBagViewScrollObserver;
import com.soft.blued.ui.live.model.BannerModel;
import com.soft.blued.ui.live.model.BluedLiveListData;
import com.soft.blued.ui.live.presenter.LiveListManager;
import com.soft.blued.ui.live.utils.LiveUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.NetworkUtils;
import java.util.List;

public class LiveListTabFragment extends PreloadFragment implements View.OnClickListener, LiveListPositionObserver.ILiveListPositionObserver, HomeTabClick.TabClickListener, LiveListContract.IView {
  private TextView A;
  
  private CommonTopTitleNoTrans B;
  
  private boolean C;
  
  public Context o;
  
  public PauseOnScrollListener p;
  
  private SmartRefreshLayout q;
  
  private RecyclerView r;
  
  private LiveListAdapter s;
  
  private LinearLayout t;
  
  private LiveListManager u;
  
  private String v = "";
  
  private String w = "";
  
  private int x;
  
  private NoDataAndLoadFailView y;
  
  private TextView z;
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt) {
    Bundle bundle = new Bundle();
    bundle.putString("tab_id", paramString1);
    bundle.putString("tab_name", paramString2);
    bundle.putInt("tab_type", paramInt);
    TerminalActivity.d(paramContext, LiveListTabFragment.class, bundle);
  }
  
  private void t() {
    LiveEventBus.get("live_float_dismiss", String.class).observe((LifecycleOwner)this, new -$$Lambda$LiveListTabFragment$EvqmNvepDRCUzKa2gkVAQ5cAWbo(this));
  }
  
  private void u() {
    this.o = (Context)getActivity();
    if (getArguments() != null) {
      this.v = getArguments().getString("tab_id");
      this.w = getArguments().getString("tab_name");
      this.x = getArguments().getInt("tab_type");
    } 
    this.u = LiveListManager.a();
    this.u.a(this, this.v, this.x);
    LiveListPositionObserver.a().a(this);
    this.p = new PauseOnScrollListener(false, true);
  }
  
  private void v() {
    this.B = (CommonTopTitleNoTrans)this.e.findViewById(2131300300);
    if (TextUtils.equals(this.v, "12")) {
      this.B.setVisibility(8);
    } else {
      this.B.setVisibility(0);
      this.B.e();
      this.B.a();
      this.B.setLeftImgDrawable(BluedSkinUtils.b(this.o, 2131232743));
      this.B.setCenterText(this.w);
      this.B.setLeftClickListener(this);
    } 
    this.q = (SmartRefreshLayout)this.e.findViewById(2131299618);
    this.q.a((OnMultiPurposeListener)new SimpleMultiPurposeListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            LiveListTabFragment.c(this.a).a(false, LiveListTabFragment.a(this.a), LiveListTabFragment.b(this.a));
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            if (LiveListTabFragment.d(this.a).getLayoutManager() != null)
              LiveListTabFragment.d(this.a).getLayoutManager().scrollToPosition(0); 
            if (LiveListTabFragment.e(this.a) != null)
              LiveListTabFragment.e(this.a).a(); 
            if (LiveListTabFragment.c(this.a) != null)
              LiveListTabFragment.c(this.a).a(true, LiveListTabFragment.a(this.a), LiveListTabFragment.b(this.a)); 
            if (TextUtils.equals(LiveListTabFragment.a(this.a), "12") && this.a.getParentFragment() instanceof LiveFragment)
              ((LiveFragment)this.a.getParentFragment()).k(); 
          }
        });
    this.r = (RecyclerView)this.e.findViewById(2131297289);
    GridLayoutManager gridLayoutManager = new GridLayoutManager(this.o, 2);
    this.r.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
    this.r.addOnScrollListener(new RecyclerView.OnScrollListener(this) {
          public void onScrollStateChanged(RecyclerView param1RecyclerView, int param1Int) {
            super.onScrollStateChanged(param1RecyclerView, param1Int);
            this.a.p.onScrollStateChanged(null, param1Int);
            if (param1Int == 0) {
              if (LiveListTabFragment.e(this.a) != null) {
                LiveListTabFragment.e(this.a).f(false);
                LiveListTabFragment.e(this.a).b();
                return;
              } 
            } else if (param1Int == 1 && LiveListTabFragment.e(this.a) != null) {
              LiveListTabFragment.e(this.a).f(true);
            } 
          }
          
          public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
            super.onScrolled(param1RecyclerView, param1Int1, param1Int2);
            if (TextUtils.equals(LiveListTabFragment.a(this.a), "12"))
              LiveFloatRedBagViewScrollObserver.a().a(param1RecyclerView, param1Int1, param1Int2); 
          }
        });
    this.t = (LinearLayout)this.e.findViewById(2131298771);
    this.y = (NoDataAndLoadFailView)this.e.findViewById(2131298984);
    this.A = (TextView)this.t.findViewById(2131300993);
    this.z = (TextView)this.t.findViewById(2131300992);
    this.z.setOnClickListener(this);
    this.s = new LiveListAdapter((IRequestHost)w_(), this.o, false, 2, this.v);
    this.r.setAdapter((RecyclerView.Adapter)this.s);
    gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(this) {
          public int getSpanSize(int param1Int) {
            LiveListAdapter liveListAdapter = LiveListTabFragment.e(this.c);
            byte b2 = 2;
            byte b1 = b2;
            if (liveListAdapter != null) {
              b1 = b2;
              if (LiveListTabFragment.e(this.c).e(param1Int) != null) {
                param1Int = LiveListTabFragment.e(this.c).getItemViewType(param1Int);
                b1 = b2;
                if (param1Int != 8) {
                  b1 = b2;
                  if (param1Int != 9)
                    b1 = 1; 
                } 
              } 
            } 
            return b1;
          }
        });
    LiveListManager liveListManager = this.u;
    if (liveListManager != null && liveListManager.c(this.v, this.x) > 0)
      this.u.b(this.v, this.x); 
    a(new Runnable(this) {
          public void run() {
            LiveListTabFragment.f(this.a).i();
          }
        },  300L);
  }
  
  public void a() {
    this.q.b(false);
  }
  
  public void a(int paramInt) {
    Logger.a("LiveListCategoryFragment", new Object[] { "showNoDataButton permission = ", Integer.valueOf(paramInt) });
    if (this.t.getVisibility() == 0) {
      if (paramInt == 1) {
        this.z.setVisibility(0);
        this.A.setVisibility(0);
        return;
      } 
      this.z.setVisibility(8);
      this.A.setVisibility(8);
    } 
  }
  
  public void a(int paramInt, long paramLong) {
    if (paramInt == -1)
      return; 
    try {
      if (this.r != null) {
        this.r.getLayoutManager().scrollToPosition(paramInt);
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public void a(View paramView) {
    LayoutInflater.from(this.o).inflate(2131493191, (ViewGroup)this.e, true);
    v();
  }
  
  public void a(List<BannerModel> paramList) {}
  
  public void a(List<BluedLiveListData> paramList, boolean paramBoolean) {
    this.r.stopScroll();
    if (paramList != null)
      if (!paramBoolean) {
        this.s.c(paramList);
      } else {
        this.s.a(paramList);
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.s.n().size());
    stringBuilder.append("tabId:");
    stringBuilder.append(this.v);
    Logger.a("LiveListCategoryFragment", new Object[] { "mAdapter.getData().size() = ", stringBuilder.toString() });
    if (this.s.n().size() > 0) {
      this.y.c();
      this.t.setVisibility(8);
      this.r.setVisibility(0);
      return;
    } 
    if (NetworkUtils.b()) {
      this.t.setVisibility(0);
      this.y.c();
    } else {
      this.y.b();
      this.t.setVisibility(8);
    } 
    this.r.setVisibility(8);
  }
  
  public void b() {
    this.q.h();
  }
  
  public void c() {
    this.q.g();
    LiveSwipeRefreshObserver.a().b();
  }
  
  public void c(String paramString) {
    if ("live".equals(paramString) && this.C)
      this.q.i(); 
  }
  
  public void d() {
    if (this.s.n().size() <= 0) {
      this.y.b();
      this.t.setVisibility(8);
    } 
  }
  
  public void d(String paramString) {
    if ("live".equals(paramString) && this.C)
      c(paramString); 
  }
  
  public void e() {
    this.q.b(true);
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131300992)
        return; 
      BluedPreferences.aI();
      LiveUtils.a(this.o, this.u.a(this.v, this.x));
      return;
    } 
    getActivity().finish();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    u();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (!TextUtils.equals(this.v, "12"))
      setUserVisibleHint(true); 
    t();
    return view;
  }
  
  public void onDestroy() {
    super.onDestroy();
    LiveListPositionObserver.a().b(this);
    HomeTabClick.b("live", this);
    LiveListManager liveListManager = this.u;
    if (liveListManager != null)
      liveListManager.d(this.v, this.x); 
  }
  
  public void onPause() {
    super.onPause();
    if (this.C) {
      Log.i("xpm", "List TAB onPause");
      LiveListAdapter liveListAdapter = this.s;
      if (liveListAdapter != null)
        liveListAdapter.a(); 
    } 
  }
  
  public void onResume() {
    super.onResume();
    if (this.C) {
      Log.i("xpm", "List TAB onResume");
      LiveListAdapter liveListAdapter = this.s;
      if (liveListAdapter != null)
        liveListAdapter.B(); 
    } 
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    this.C = paramBoolean;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("List TAB isVisibleToUser:");
    stringBuilder.append(paramBoolean);
    Log.i("xpm", stringBuilder.toString());
    if (paramBoolean && TextUtils.equals(this.v, "12"))
      HomeTabClick.a("live", this); 
    LiveListAdapter liveListAdapter = this.s;
    if (liveListAdapter != null)
      liveListAdapter.e(paramBoolean); 
    if (paramBoolean) {
      liveListAdapter = this.s;
      if (liveListAdapter != null) {
        liveListAdapter.B();
        return;
      } 
    } else {
      liveListAdapter = this.s;
      if (liveListAdapter != null)
        liveListAdapter.a(); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\fragment\LiveListTabFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */