package com.soft.blued.ui.live.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.activity.PreloadFragment;
import com.blued.android.framework.view.PauseOnScrollListener;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.live_china.observer.LiveListPositionObserver;
import com.blued.android.module.live_china.observer.LiveSwipeRefreshObserver;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import com.soft.blued.customview.AutoScrollViewPager;
import com.soft.blued.customview.LinePageIndicator;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.ui.home.HomeTabClick;
import com.soft.blued.ui.live.adapter.LiveListAdapter;
import com.soft.blued.ui.live.contract.LiveListContract;
import com.soft.blued.ui.live.manager.LiveFloatRedBagViewScrollObserver;
import com.soft.blued.ui.live.model.BannerModel;
import com.soft.blued.ui.live.model.BluedLiveListData;
import com.soft.blued.ui.live.presenter.LiveListManager;
import com.soft.blued.ui.live.utils.LiveUtils;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.NetworkUtils;
import java.util.ArrayList;
import java.util.List;

public class LiveRecommendFragment extends PreloadFragment implements View.OnClickListener, LiveListPositionObserver.ILiveListPositionObserver, HomeTabClick.TabClickListener, LiveListContract.IView {
  private String A = "";
  
  private String B = "";
  
  private int C;
  
  private NoDataAndLoadFailView D;
  
  private TextView E;
  
  private TextView F;
  
  private List<BannerModel> G = new ArrayList<BannerModel>();
  
  private List<View> H = new ArrayList<View>();
  
  private List<BannerViewHolder> I = new ArrayList<BannerViewHolder>();
  
  private List<Unbinder> J = new ArrayList<Unbinder>();
  
  private boolean K;
  
  public Context o;
  
  public PauseOnScrollListener p;
  
  private FrameLayout q;
  
  private BannerPagerAdapter r;
  
  private AutoScrollViewPager s;
  
  private LinePageIndicator t;
  
  private SmartRefreshLayout u;
  
  private RecyclerView v;
  
  private LiveListAdapter w;
  
  private LinearLayout x;
  
  private TextView y;
  
  private LiveListManager z;
  
  public static LiveRecommendFragment a(String paramString, int paramInt) {
    LiveRecommendFragment liveRecommendFragment = new LiveRecommendFragment();
    Bundle bundle = new Bundle();
    bundle.putString("tab_id", paramString);
    bundle.putString("tab_name", "");
    bundle.putInt("tab_type", paramInt);
    liveRecommendFragment.setArguments(bundle);
    return liveRecommendFragment;
  }
  
  private void u() {
    LiveEventBus.get("live_float_dismiss", String.class).observe((LifecycleOwner)this, new -$$Lambda$LiveRecommendFragment$cfdvd3kEZ4-z0ff41sv9MwEqybk(this));
  }
  
  private void v() {
    this.o = (Context)getActivity();
    if (getArguments() != null) {
      this.A = getArguments().getString("tab_id");
      this.B = getArguments().getString("tab_name");
      this.C = getArguments().getInt("tab_type");
    } 
    this.z = LiveListManager.a();
    this.z.a(this, this.A, this.C);
    LiveListPositionObserver.a().a(this);
    this.p = new PauseOnScrollListener(false, true);
  }
  
  private void w() {
    this.q = (FrameLayout)this.e.findViewById(2131296472);
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.q.getLayoutParams();
    layoutParams.width = AppInfo.l - DisplayUtil.a(getContext(), 20.0F);
    layoutParams.height = (int)(layoutParams.width * 125.0F / 726.0F);
    this.q.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.s = (AutoScrollViewPager)this.e.findViewById(2131296471);
    this.t = (LinePageIndicator)this.e.findViewById(2131299176);
    this.r = new BannerPagerAdapter(this);
    this.s.setAdapter(this.r);
    this.s.setInterval(3000L);
    this.t.setViewPager((ViewPager)this.s);
    this.u = (SmartRefreshLayout)this.e.findViewById(2131299618);
    this.u.a((OnMultiPurposeListener)new SimpleMultiPurposeListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            LiveRecommendFragment.c(this.a).a(false, LiveRecommendFragment.a(this.a), LiveRecommendFragment.b(this.a));
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            if (LiveRecommendFragment.d(this.a).getLayoutManager() != null)
              LiveRecommendFragment.d(this.a).getLayoutManager().scrollToPosition(0); 
            if (LiveRecommendFragment.e(this.a) != null)
              LiveRecommendFragment.e(this.a).a(); 
            if (LiveRecommendFragment.c(this.a) != null) {
              LiveRecommendFragment.c(this.a).a(true, LiveRecommendFragment.a(this.a), LiveRecommendFragment.b(this.a));
              LiveRecommendFragment.c(this.a).e(LiveRecommendFragment.a(this.a), LiveRecommendFragment.b(this.a));
            } 
            if (this.a.getParentFragment() instanceof LiveFragment)
              ((LiveFragment)this.a.getParentFragment()).k(); 
          }
        });
    this.v = (RecyclerView)this.e.findViewById(2131297289);
    GridLayoutManager gridLayoutManager = new GridLayoutManager(this.o, 2);
    this.v.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
    this.v.addOnScrollListener(new RecyclerView.OnScrollListener(this) {
          public void onScrollStateChanged(RecyclerView param1RecyclerView, int param1Int) {
            super.onScrollStateChanged(param1RecyclerView, param1Int);
            this.a.p.onScrollStateChanged(null, param1Int);
            if (param1Int == 0) {
              if (LiveRecommendFragment.e(this.a) != null) {
                LiveRecommendFragment.e(this.a).f(false);
                LiveRecommendFragment.e(this.a).b();
                return;
              } 
            } else if (param1Int == 1 && LiveRecommendFragment.e(this.a) != null) {
              LiveRecommendFragment.e(this.a).f(true);
            } 
          }
          
          public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
            super.onScrolled(param1RecyclerView, param1Int1, param1Int2);
            LiveFloatRedBagViewScrollObserver.a().a(param1RecyclerView, param1Int1, param1Int2);
          }
        });
    this.x = (LinearLayout)this.e.findViewById(2131298771);
    this.y = (TextView)this.x.findViewById(2131300976);
    if (BluedPreferences.cZ())
      this.y.setTextColor(Color.parseColor("#454545")); 
    this.D = (NoDataAndLoadFailView)this.e.findViewById(2131298984);
    this.F = (TextView)this.x.findViewById(2131300993);
    this.E = (TextView)this.x.findViewById(2131300992);
    this.E.setOnClickListener(this);
    this.w = new LiveListAdapter((IRequestHost)w_(), this.o, false, 2, this.A);
    this.v.setAdapter((RecyclerView.Adapter)this.w);
    gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(this) {
          public int getSpanSize(int param1Int) {
            LiveListAdapter liveListAdapter = LiveRecommendFragment.e(this.c);
            byte b2 = 2;
            byte b1 = b2;
            if (liveListAdapter != null) {
              b1 = b2;
              if (LiveRecommendFragment.e(this.c).e(param1Int) != null) {
                param1Int = LiveRecommendFragment.e(this.c).getItemViewType(param1Int);
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
    LiveListManager liveListManager = this.z;
    if (liveListManager != null && liveListManager.c(this.A, this.C) > 0)
      this.z.b(this.A, this.C); 
    a(new Runnable(this) {
          public void run() {
            LiveRecommendFragment.f(this.a).i();
          }
        },  300L);
    this.z.e(this.A, this.C);
  }
  
  public void a() {
    this.u.b(false);
  }
  
  public void a(int paramInt) {
    Logger.a("LiveListCategoryFragment", new Object[] { "showNoDataButton permission = ", Integer.valueOf(paramInt) });
    if (this.x.getVisibility() == 0) {
      if (paramInt == 1) {
        this.E.setVisibility(0);
        this.F.setVisibility(0);
        return;
      } 
      this.E.setVisibility(8);
      this.F.setVisibility(8);
    } 
  }
  
  public void a(int paramInt, long paramLong) {
    if (paramInt == -1)
      return; 
    try {
      if (this.v != null) {
        this.v.getLayoutManager().scrollToPosition(paramInt);
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public void a(View paramView) {
    LayoutInflater.from(this.o).inflate(2131493206, (ViewGroup)this.e, true);
    w();
  }
  
  public void a(List<BannerModel> paramList) {
    b(paramList);
  }
  
  public void a(List<BluedLiveListData> paramList, boolean paramBoolean) {
    this.v.stopScroll();
    if (paramList != null)
      if (!paramBoolean) {
        this.w.c(paramList);
      } else {
        this.w.a(paramList);
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.w.n().size());
    stringBuilder.append("tabId:");
    stringBuilder.append(this.A);
    Logger.a("LiveListCategoryFragment", new Object[] { "mAdapter.getData().size() = ", stringBuilder.toString() });
    if (this.w.n().size() > 0) {
      this.D.c();
      this.x.setVisibility(8);
      this.v.setVisibility(0);
      return;
    } 
    if (NetworkUtils.b()) {
      this.x.setVisibility(0);
      this.D.c();
    } else {
      this.D.b();
      this.x.setVisibility(8);
    } 
    this.v.setVisibility(8);
  }
  
  public void b() {
    this.u.h();
  }
  
  public void b(List<BannerModel> paramList) {
    Log.i("xpm", "receive showBanner");
    if (paramList != null && paramList.size() > 0) {
      this.t.setVisibility(0);
      if (paramList.size() == 1)
        this.t.setVisibility(8); 
      this.r.a(paramList);
      this.q.setVisibility(0);
      this.s.f();
      this.s.setCurrentItem(0, false);
      this.t.a((ViewPager)this.s, 0);
      return;
    } 
    t();
  }
  
  public void c() {
    this.u.g();
    LiveSwipeRefreshObserver.a().b();
  }
  
  public void c(String paramString) {
    if ("live".equals(paramString) && this.K)
      this.u.i(); 
  }
  
  public void d() {
    if (this.w.n().size() <= 0) {
      this.D.b();
      this.x.setVisibility(8);
    } 
  }
  
  public void d(String paramString) {
    if ("live".equals(paramString) && this.K)
      c(paramString); 
  }
  
  public void e() {
    this.u.b(true);
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131300992)
        return; 
      BluedPreferences.aI();
      LiveUtils.a(this.o, this.z.a(this.A, this.C));
      return;
    } 
    getActivity().finish();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    v();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    u();
    return view;
  }
  
  public void onDestroy() {
    super.onDestroy();
    LiveListPositionObserver.a().b(this);
    HomeTabClick.b("live", this);
    LiveListManager liveListManager = this.z;
    if (liveListManager != null)
      liveListManager.d(this.A, this.C); 
  }
  
  public void onPause() {
    super.onPause();
    if (this.K) {
      Log.i("xpm", "List TAB onPause");
      LiveListAdapter liveListAdapter = this.w;
      if (liveListAdapter != null)
        liveListAdapter.a(); 
    } 
  }
  
  public void onResume() {
    super.onResume();
    if (this.K) {
      Log.i("xpm", "List TAB onResume");
      LiveListAdapter liveListAdapter = this.w;
      if (liveListAdapter != null)
        liveListAdapter.B(); 
    } 
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    this.K = paramBoolean;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("List TAB isVisibleToUser:");
    stringBuilder.append(paramBoolean);
    Log.i("xpm", stringBuilder.toString());
    if (paramBoolean)
      HomeTabClick.a("live", this); 
    LiveListAdapter liveListAdapter = this.w;
    if (liveListAdapter != null)
      liveListAdapter.e(paramBoolean); 
    if (paramBoolean) {
      liveListAdapter = this.w;
      if (liveListAdapter != null) {
        liveListAdapter.B();
        return;
      } 
    } else {
      liveListAdapter = this.w;
      if (liveListAdapter != null)
        liveListAdapter.a(); 
    } 
  }
  
  public void t() {
    Log.i("xpm", "receive showBannerNodata");
    this.q.setVisibility(8);
    this.t.setVisibility(8);
  }
  
  class BannerPagerAdapter extends PagerAdapter {
    BannerPagerAdapter(LiveRecommendFragment this$0) {}
    
    public void a(List<BannerModel> param1List) {
      if (param1List != null) {
        if (LiveRecommendFragment.g(this.a) != null) {
          LiveRecommendFragment.g(this.a).clear();
        } else {
          LiveRecommendFragment.a(this.a, new ArrayList());
        } 
        LiveRecommendFragment.g(this.a).addAll(param1List);
      } 
      notifyDataSetChanged();
    }
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      param1ViewGroup.removeView((View)param1Object);
    }
    
    public int getCount() {
      return (LiveRecommendFragment.g(this.a) != null) ? LiveRecommendFragment.g(this.a).size() : 0;
    }
    
    public int getItemPosition(Object param1Object) {
      return -2;
    }
    
    public Object instantiateItem(ViewGroup param1ViewGroup, int param1Int) {
      String str = ((BannerModel)LiveRecommendFragment.g(this.a).get(param1Int)).url;
      while (LiveRecommendFragment.h(this.a).size() < LiveRecommendFragment.g(this.a).size()) {
        LiveRecommendFragment.BannerViewHolder bannerViewHolder1 = new LiveRecommendFragment.BannerViewHolder(this.a);
        View view1 = LayoutInflater.from(this.a.o).inflate(2131493555, param1ViewGroup, false);
        Unbinder unbinder = ButterKnife.a(bannerViewHolder1, view1);
        LiveRecommendFragment.h(this.a).add(view1);
        LiveRecommendFragment.i(this.a).add(bannerViewHolder1);
        LiveRecommendFragment.j(this.a).add(unbinder);
      } 
      LiveRecommendFragment.BannerViewHolder bannerViewHolder = LiveRecommendFragment.i(this.a).get(param1Int);
      ImageLoader.a((IRequestHost)this.a.w_(), ((BannerModel)LiveRecommendFragment.g(this.a).get(param1Int)).imgurl).a(2131231369).a(bannerViewHolder.aariv_banner);
      if (!((BannerModel)LiveRecommendFragment.g(this.a).get(param1Int)).isShowUrlVisited) {
        FindHttpUtils.a(((BannerModel)LiveRecommendFragment.g(this.a).get(param1Int)).show_url);
        ((BannerModel)LiveRecommendFragment.g(this.a).get(param1Int)).isShowUrlVisited = true;
      } 
      bannerViewHolder.aariv_banner.setOnClickListener(new View.OnClickListener(this, param1Int, str) {
            public void onClick(View param2View) {
              FindHttpUtils.a(((BannerModel)LiveRecommendFragment.g(this.c.a).get(this.a)).click_url);
              WebViewShowInfoFragment.show(this.c.a.o, this.b, 9);
            }
          });
      View view = LiveRecommendFragment.h(this.a).get(param1Int);
      if (view != null && view.getParent() != null)
        ((ViewGroup)view).removeView(view); 
      param1ViewGroup.addView(view);
      return view;
    }
    
    public boolean isViewFromObject(View param1View, Object param1Object) {
      return (param1View == param1Object);
    }
  }
  
  class null implements View.OnClickListener {
    null(LiveRecommendFragment this$0, int param1Int, String param1String) {}
    
    public void onClick(View param1View) {
      FindHttpUtils.a(((BannerModel)LiveRecommendFragment.g(this.c.a).get(this.a)).click_url);
      WebViewShowInfoFragment.show(this.c.a.o, this.b, 9);
    }
  }
  
  class BannerViewHolder {
    @BindView(2131296339)
    ImageView aariv_banner;
    
    BannerViewHolder(LiveRecommendFragment this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\fragment\LiveRecommendFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */