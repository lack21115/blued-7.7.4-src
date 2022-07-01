package com.soft.blued.ui.live.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.live_china.mine.LiveRouteUtil;
import com.blued.android.module.live_china.model.LiveLiangModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.observer.LiveSwipeRefreshObserver;
import com.blued.android.module.live_china.observer.LiveTabNewObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.api.OnTwoLevelListener;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.customview.AutoScrollViewPager;
import com.soft.blued.customview.LinePageIndicator;
import com.soft.blued.customview.LiveHotPullToRefreshLayout;
import com.soft.blued.customview.smartrefresh.TwoLevelRefreshView;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackLive;
import com.soft.blued.ui.discover.observer.LiveTagsSetSelectedTab;
import com.soft.blued.ui.home.HomeTabClick;
import com.soft.blued.ui.live.adapter.LiveCategoryAdapter;
import com.soft.blued.ui.live.manager.LiveHotViewScrollObserver;
import com.soft.blued.ui.live.model.BannerModel;
import com.soft.blued.ui.live.model.LiveClassifyTabModel;
import com.soft.blued.ui.live.model.LiveTabInfo;
import com.soft.blued.ui.live.model.LiveTabModel;
import com.soft.blued.ui.live.model.LiveTwoFloorModel;
import com.soft.blued.ui.live.presenter.LiveHomePresenter;
import com.soft.blued.ui.live.view.CustomTwoLevelHeader;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class LiveHomeFragment extends MvpFragment<LiveHomePresenter> implements View.OnClickListener, LiveSwipeRefreshObserver.IEnableRefeshObserver, LiveTabNewObserver.ILiveTabRefreshObserver, LiveTagsSetSelectedTab.iLiveTagsSetSelectedTab, HomeTabClick.TabClickListener, LiveHotViewScrollObserver.IScrollObserver {
  private Observer<String> A = new Observer<String>(this) {
      public void a(String param1String) {
        Log.i("xpm", "KEY_EVENT_BACK_TWO_LEVEL");
        this.a.b(new Runnable(this) {
              public void run() {
                if (this.a.a.header != null)
                  this.a.a.header.b(); 
              }
            },  300L);
      }
    };
  
  @BindView(2131296471)
  AutoScrollViewPager asvp_banner_hot_new;
  
  @BindView(2131296472)
  FrameLayout asvp_banner_hot_parent;
  
  public List<LiveTabModel> d;
  
  public List<LiveTabModel> e;
  
  public LiveTabModel f;
  
  public boolean g = false;
  
  public boolean h = false;
  
  @BindView(2131297358)
  CustomTwoLevelHeader header;
  
  private Context i;
  
  private List<View> j = new ArrayList<View>();
  
  @BindView(2131298175)
  FrameLayout live_banner;
  
  @BindView(2131298684)
  ShapeLinearLayout living_count;
  
  @BindView(2131298924)
  LinearLayout ll_live_tips;
  
  @BindView(2131299091)
  View ll_tab;
  
  @BindView(2131299176)
  LinePageIndicator lpi_line;
  
  @BindView(2131299193)
  ViewPager main_live_new_viewpager;
  
  private List<BannerViewHolder> n = new ArrayList<BannerViewHolder>();
  
  private List<Unbinder> o = new ArrayList<Unbinder>();
  
  private BannerPagerAdapter p;
  
  private List<BannerModel> q = new ArrayList<BannerModel>();
  
  private int r = 6;
  
  @BindView(2131299599)
  RecyclerView recycle_view_cateroty;
  
  @BindView(2131299613)
  RefreshLayout refreshLayout;
  
  @BindView(2131299618)
  TwoLevelRefreshView refresh_view;
  
  private MyAdapter s;
  
  @BindView(2131300148)
  LiveHotPullToRefreshLayout swipe_view;
  
  private LiveCategoryAdapter t;
  
  @BindView(2131300996)
  TextView tv_living_count;
  
  private LiveTwoFloorModel u;
  
  private boolean v;
  
  private long w;
  
  private boolean x = false;
  
  private boolean y;
  
  private Observer<String> z = new Observer<String>(this) {
      public void a(String param1String) {
        Log.i("xpm", "KEY_EVENT_LIVE_FLOAT_DISMISS");
        LiveListHotFragment liveListHotFragment = this.a.I();
        if (liveListHotFragment != null && liveListHotFragment.e != null && LiveHomeFragment.a(this.a))
          liveListHotFragment.e.B(); 
      }
    };
  
  private void J() {
    LiveEventBus.get("live_float_dismiss", String.class).observeForever(this.z);
    LiveEventBus.get("live_back_to_two_level", String.class).observeForever(this.A);
    LiveEventBus.get(LiveEventBusUtil.e, Integer.class).observe((LifecycleOwner)this, new -$$Lambda$LiveHomeFragment$Y1MOXMNypXbXTd1NrNckxJ09svc(this));
  }
  
  private void K() {
    LiveEventBus.get("live_float_dismiss", String.class).removeObserver(this.z);
    LiveEventBus.get("live_back_to_two_level", String.class).removeObserver(this.A);
  }
  
  private void L() {
    this.d = new ArrayList<LiveTabModel>();
    this.e = new ArrayList<LiveTabModel>();
    this.d.add(0, new LiveTabModel("0", this.i.getString(2131757407), 0, 0));
  }
  
  private void M() {
    if (LiveRoomPreferences.w() <= 0) {
      Date date = new Date(System.currentTimeMillis());
      if (date.getYear() * 10000 + (date.getMonth() + 1) * 100 + date.getDate() > LiveRoomPreferences.x())
        LiveRoomHttpUtils.d(); 
    } 
  }
  
  private void N() {
    this.p = new BannerPagerAdapter(this);
    this.asvp_banner_hot_new.setAdapter(this.p);
    this.asvp_banner_hot_new.setInterval(3000L);
    this.lpi_line.setViewPager((ViewPager)this.asvp_banner_hot_new);
    this.ll_tab.setVisibility(8);
    this.header.b(300);
    this.header.a(new OnTwoLevelListener(this) {
          public boolean a(RefreshLayout param1RefreshLayout) {
            return false;
          }
        });
    this.refreshLayout.i(false);
    this.refreshLayout.b((OnMultiPurposeListener)new SimpleMultiPurposeListener(this) {
          public void a(RefreshHeader param1RefreshHeader, boolean param1Boolean, float param1Float, int param1Int1, int param1Int2, int param1Int3) {
            super.a(param1RefreshHeader, param1Boolean, param1Float, param1Int1, param1Int2, param1Int3);
            if (!LiveHomeFragment.b(this.a))
              return; 
            if (this.a.getParentFragment() instanceof LiveFragment)
              ((LiveFragment)this.a.getParentFragment()).a(param1Float, param1Int1); 
          }
          
          public void a(RefreshLayout param1RefreshLayout, RefreshState param1RefreshState1, RefreshState param1RefreshState2) {
            if (!LiveHomeFragment.b(this.a))
              return; 
            if (param1RefreshState2 == RefreshState.a) {
              this.a.F();
              if (LiveHomeFragment.c(this.a) != null && !TextUtils.isEmpty((LiveHomeFragment.c(this.a)).two_floor_picture))
                EventTrackLive.b(LiveProtos.Event.LIVE_HOME_REFRESH_IMAGE_SHOW, (LiveHomeFragment.c(this.a)).lid, (LiveHomeFragment.c(this.a)).uid, (LiveHomeFragment.c(this.a)).id); 
              if (LiveHomeFragment.c(this.a) != null && StringUtils.a((LiveHomeFragment.c(this.a)).lid, 0L) > 0L) {
                EventTrackLive.b(LiveProtos.Event.LIVE_HOME_REFRESH_WORD_SHOW, (LiveHomeFragment.c(this.a)).lid, (LiveHomeFragment.c(this.a)).uid, (LiveHomeFragment.c(this.a)).id);
                return;
              } 
            } else {
              if (param1RefreshState2 == RefreshState.h)
                return; 
              if (param1RefreshState2 == RefreshState.i) {
                ((LiveHomePresenter)this.a.s()).n();
                if (LiveHomeFragment.c(this.a) == null)
                  return; 
                if (TextUtils.equals("3", (LiveHomeFragment.c(this.a)).type) && !TextUtils.isEmpty((LiveHomeFragment.c(this.a)).activity_addr)) {
                  WebViewShowInfoFragment.show(LiveHomeFragment.d(this.a), (LiveHomeFragment.c(this.a)).activity_addr, 14);
                  return;
                } 
                if (TextUtils.equals("1", (LiveHomeFragment.c(this.a)).type) && StringUtils.a((LiveHomeFragment.c(this.a)).lid, 0L) > 0L)
                  LiveTwoLevelFragment.a(LiveHomeFragment.d(this.a), "two_floor_live", LiveHomeFragment.c(this.a)); 
              } 
            } 
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            if (!LiveHomeFragment.b(this.a))
              return; 
            LiveListHotFragment liveListHotFragment = this.a.I();
            if (liveListHotFragment != null && liveListHotFragment.e != null)
              liveListHotFragment.e.a(); 
            LiveTabNewObserver.a().b();
            LiveTabNewObserver.a().d();
            LiveTabNewObserver.a().c();
            this.a.swipe_view.a();
            ((LiveHomePresenter)this.a.s()).e();
            if (this.a.getParentFragment() instanceof LiveFragment)
              ((LiveFragment)this.a.getParentFragment()).k(); 
          }
        });
    if (this.s == null)
      this.s = new MyAdapter(this, getChildFragmentManager()); 
    this.main_live_new_viewpager.setAdapter((PagerAdapter)this.s);
    this.main_live_new_viewpager.setOffscreenPageLimit(1);
    GridLayoutManager gridLayoutManager = new GridLayoutManager(this.i, 5);
    this.recycle_view_cateroty.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
    this.t = new LiveCategoryAdapter(this);
    this.recycle_view_cateroty.setAdapter((RecyclerView.Adapter)this.t);
    O();
    ShapeHelper.b((ShapeHelper.ShapeView)this.living_count, 2131100848);
    this.living_count.setOnClickListener(this);
    b(new Runnable(this) {
          public void run() {
            if (!LiveHomeFragment.b(this.a))
              return; 
            this.a.refreshLayout.b((RefreshHeader)this.a.header);
          }
        });
    ((LiveHomePresenter)s()).o();
    F();
  }
  
  private void O() {
    if (BluedPreferences.aJ()) {
      Animation animation = AnimationUtils.loadAnimation(this.i, 2130772032);
      this.ll_live_tips.startAnimation(animation);
      b(new Runnable(this) {
            public void run() {
              if (LiveHomeFragment.e(this.a) == 0) {
                Animation animation = AnimationUtils.loadAnimation(LiveHomeFragment.d(this.a), 2130772033);
                if (this.a.ll_live_tips != null) {
                  this.a.ll_live_tips.startAnimation(animation);
                  this.a.ll_live_tips.setVisibility(8);
                } 
                return;
              } 
              LiveHomeFragment.f(this.a);
              if (LiveHomeFragment.e(this.a) == 0) {
                this.a.b(this);
                return;
              } 
              this.a.b(this, 1000L);
            }
          });
      BluedPreferences.aK();
      return;
    } 
    this.ll_live_tips.setVisibility(8);
  }
  
  private void b(int paramInt) {
    LogUtils.c("count");
    if (paramInt == 0) {
      Date date = new Date(System.currentTimeMillis());
      LiveRoomPreferences.l(date.getYear() * 10000 + (date.getMonth() + 1) * 100 + date.getDate());
      LiveRouteUtil.a((BaseFragment)this, 0, 10020);
    } 
  }
  
  public void E() {
    int i = 0;
    this.g = false;
    ArrayList<LiveTabModel> arrayList = new ArrayList();
    if (this.e.size() > 10) {
      for (i = 0; i < this.e.size(); i++) {
        if (i <= 8)
          arrayList.add(this.e.get(i)); 
      } 
      LiveTabModel liveTabModel1 = new LiveTabModel("15", getText(2131757512).toString(), 0, 0);
      LiveTabModel liveTabModel2 = this.f;
      if (liveTabModel2 != null) {
        liveTabModel1.less_cate_icon = liveTabModel2.less_cate_icon;
        liveTabModel1.more_cate_icon = this.f.more_cate_icon;
      } 
      arrayList.add(liveTabModel1);
    } else {
      while (i < this.e.size()) {
        arrayList.add(this.e.get(i));
        i++;
      } 
    } 
    this.t.a(arrayList);
  }
  
  public void F() {
    RefreshLayout refreshLayout = this.refreshLayout;
    if (refreshLayout != null && refreshLayout.getState() == RefreshState.a && getParentFragment() instanceof LiveFragment) {
      String str;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("setTwoLevelEnable:");
      stringBuilder.append(this.x);
      Log.i("xpm", stringBuilder.toString());
      this.header.a(this.x);
      LiveTwoFloorModel liveTwoFloorModel2 = this.u;
      if (liveTwoFloorModel2 != null) {
        str = liveTwoFloorModel2.two_floor_picture;
      } else {
        str = "";
      } 
      if (TextUtils.isEmpty(str)) {
        this.refresh_view.a(this.x, false);
      } else {
        this.refresh_view.a(this.x, true);
      } 
      ((LiveFragment)getParentFragment()).a(this.x, str);
      LiveTwoFloorModel liveTwoFloorModel1 = this.u;
      if (liveTwoFloorModel1 != null && liveTwoFloorModel1.anchor != null && !TextUtils.isEmpty(this.u.anchor.avatar))
        ImageFileLoader.a((IRequestHost)w_()).a(this.u.anchor.avatar).a(); 
    } 
  }
  
  public void G() {
    LiveClassifyTabModel liveClassifyTabModel = H();
    if (liveClassifyTabModel == null)
      return; 
    int j = liveClassifyTabModel.getTabModelList().size();
    int i = 0;
    if (j > 0) {
      List<LiveTabModel> list = liveClassifyTabModel.getTabModelList();
      for (i = 0; i < this.e.size(); i++) {
        LiveTabModel liveTabModel = this.e.get(i);
        j = 0;
        boolean bool = false;
        while (j < list.size()) {
          LiveTabModel liveTabModel1 = list.get(j);
          if (TextUtils.equals(liveTabModel.id, liveTabModel1.id)) {
            if (liveTabModel.vcode > 0 && liveTabModel.vcode != liveTabModel1.vcode) {
              liveTabModel.showNew = true;
              this.h = true;
              Logger.a("drb", new Object[] { "showTabNew = ", Integer.valueOf(i) });
            } 
            bool = true;
          } 
          j++;
        } 
        if (!bool && liveTabModel.vcode > 0) {
          liveTabModel.showNew = true;
          this.h = true;
        } 
      } 
    } else {
      liveClassifyTabModel = new LiveClassifyTabModel();
      liveClassifyTabModel.initTabModelList(this.e);
      BluedPreferences.aa(AppInfo.f().toJson(liveClassifyTabModel));
      while (i < this.e.size()) {
        LiveTabModel liveTabModel = this.e.get(i);
        if (liveTabModel.vcode > 0) {
          liveTabModel.showNew = true;
          this.h = true;
        } 
        i++;
      } 
    } 
  }
  
  public LiveClassifyTabModel H() {
    String str = BluedPreferences.bL();
    return TextUtils.isEmpty(str) ? new LiveClassifyTabModel() : (LiveClassifyTabModel)AppInfo.f().fromJson(str, LiveClassifyTabModel.class);
  }
  
  public LiveListHotFragment I() {
    if (isAdded() && getChildFragmentManager() != null && getChildFragmentManager().getFragments() != null && getChildFragmentManager().getFragments().size() > 0) {
      Fragment fragment = getChildFragmentManager().getFragments().get(0);
      if (fragment instanceof LiveListHotFragment)
        return (LiveListHotFragment)fragment; 
    } 
    return null;
  }
  
  public void a(int paramInt) {
    if (this.e.size() > paramInt) {
      LiveTabModel liveTabModel = this.e.get(paramInt);
      liveTabModel.showNew = false;
      b(liveTabModel);
    } 
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    N();
    LiveHotViewScrollObserver.a().a(this);
    LiveSwipeRefreshObserver.a().a(this);
    LiveTabNewObserver.a().a(this);
    LiveTagsSetSelectedTab.a().a(this);
    J();
    this.y = true;
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {
    if (!this.y)
      return; 
    if (paramInt2 == 0);
  }
  
  public void a(LiveTabInfo paramLiveTabInfo) {
    Log.i("xpm", "receive showLiveTab");
    if (paramLiveTabInfo == null || paramLiveTabInfo.liveTabs.size() == 0) {
      this.ll_tab.setVisibility(8);
      return;
    } 
    View view = this.ll_tab;
    int i = 0;
    view.setVisibility(0);
    this.e.clear();
    this.e.addAll(paramLiveTabInfo.liveTabs);
    this.f = paramLiveTabInfo.liveTabModelExtra;
    G();
    E();
    if (this.f != null) {
      LiveTabModel liveTabModel1;
      view = null;
      View view1 = view;
      if (this.e != null)
        while (true) {
          view1 = view;
          if (i < this.e.size()) {
            if (TextUtils.equals(this.f.default_cate_id, ((LiveTabModel)this.e.get(i)).id)) {
              liveTabModel1 = this.e.get(i);
              break;
            } 
            i++;
            continue;
          } 
          break;
        }  
      LiveTabModel liveTabModel2 = liveTabModel1;
      if (liveTabModel1 == null) {
        liveTabModel2 = this.f;
        liveTabModel2.id = liveTabModel2.default_cate_id;
      } 
      a(liveTabModel2);
    } 
  }
  
  public void a(LiveTabModel paramLiveTabModel) {
    ViewPager viewPager;
    if (paramLiveTabModel == null)
      return; 
    boolean bool = TextUtils.equals(paramLiveTabModel.id, "0");
    LiveTabModel liveTabModel = null;
    Fragment fragment = null;
    if (bool || TextUtils.isEmpty(paramLiveTabModel.id)) {
      LiveFragment liveFragment;
      fragment = getActivity().getSupportFragmentManager().findFragmentByTag("live");
      paramLiveTabModel = liveTabModel;
      if (fragment != null) {
        paramLiveTabModel = liveTabModel;
        if (fragment instanceof LiveFragment)
          liveFragment = (LiveFragment)fragment; 
      } 
      if (liveFragment != null) {
        viewPager = liveFragment.l();
        if (viewPager != null)
          viewPager.setCurrentItem(1); 
      } 
      return;
    } 
    if (TextUtils.equals(((LiveTabModel)viewPager).id, "12")) {
      LiveFragment liveFragment;
      Fragment fragment2 = getActivity().getSupportFragmentManager().findFragmentByTag("live");
      Fragment fragment1 = fragment;
      if (fragment2 != null) {
        fragment1 = fragment;
        if (fragment2 instanceof LiveFragment)
          liveFragment = (LiveFragment)fragment2; 
      } 
      if (liveFragment != null) {
        viewPager = liveFragment.l();
        if (viewPager != null) {
          viewPager.setCurrentItem(0);
          return;
        } 
      } 
    } else {
      LiveListTabFragment.a(this.i, ((LiveTabModel)viewPager).id, ((LiveTabModel)viewPager).name, ((LiveTabModel)viewPager).type);
    } 
  }
  
  public void a(List<BannerModel> paramList) {
    Log.i("xpm", "receive showBanner");
    if (paramList != null && paramList.size() > 0) {
      this.lpi_line.setVisibility(0);
      if (paramList.size() == 1)
        this.lpi_line.setVisibility(8); 
      this.p.a(paramList);
      this.asvp_banner_hot_parent.setVisibility(0);
      this.asvp_banner_hot_new.f();
      this.asvp_banner_hot_new.setCurrentItem(0, false);
      this.lpi_line.a((ViewPager)this.asvp_banner_hot_new, 0);
      return;
    } 
    this.asvp_banner_hot_parent.setVisibility(8);
    this.lpi_line.setVisibility(8);
  }
  
  public void aL_() {
    super.aL_();
    this.y = false;
    List<Unbinder> list = this.o;
    if (list != null) {
      Iterator<Unbinder> iterator = list.iterator();
      while (iterator.hasNext())
        ((Unbinder)iterator.next()).unbind(); 
      this.o.clear();
    } 
    this.j.clear();
    this.n.clear();
    K();
    LiveHotViewScrollObserver.a().b(this);
    LiveSwipeRefreshObserver.a().b(this);
    LiveTabNewObserver.a().b(this);
    LiveTagsSetSelectedTab.a().b(this);
  }
  
  public void b() {
    this.refreshLayout.j();
  }
  
  public void b(LiveTabModel paramLiveTabModel) {
    LiveClassifyTabModel liveClassifyTabModel = H();
    if (liveClassifyTabModel == null)
      return; 
    LiveTabModel liveTabModel = liveClassifyTabModel.findTabModel(paramLiveTabModel.id);
    if (liveTabModel == null) {
      liveClassifyTabModel.addItem(paramLiveTabModel);
    } else {
      liveTabModel.update(paramLiveTabModel);
    } 
    BluedPreferences.ab(AppInfo.f().toJson(liveClassifyTabModel));
  }
  
  public void b(List<LiveTwoFloorModel> paramList) {
    Log.i("xpm", "receive setTwoLevel");
    if (paramList != null && paramList.size() > 0) {
      this.u = paramList.get(0);
      LiveTwoFloorModel liveTwoFloorModel = this.u;
      if (liveTwoFloorModel != null) {
        if (TextUtils.equals("1", liveTwoFloorModel.type) && StringUtils.a(this.u.lid, 0L) > 0L) {
          this.x = true;
        } else if (TextUtils.equals("3", this.u.type) && !TextUtils.isEmpty(this.u.activity_addr)) {
          this.x = true;
        } else {
          this.x = false;
        } 
      } else {
        this.x = false;
      } 
    } else {
      this.x = false;
    } 
    F();
  }
  
  public void c() {}
  
  public void c(String paramString) {
    if (!this.y)
      return; 
    if ("live".equals(paramString) && this.v) {
      Log.i("xpm", "autoRefresh 4");
      this.refreshLayout.i();
    } 
  }
  
  public void c(List<LiveLiangModel> paramList) {
    Log.i("xpm", "receive LIVE_LIANG_ID");
  }
  
  public void d() {}
  
  public void d(String paramString) {
    if (!this.y)
      return; 
    if ("live".equals(paramString) && this.v)
      c(paramString); 
  }
  
  public void d_(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: getfield y : Z
    //   4: ifne -> 8
    //   7: return
    //   8: aload_1
    //   9: ldc '0'
    //   11: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   14: istore_2
    //   15: aconst_null
    //   16: astore #4
    //   18: aconst_null
    //   19: astore_3
    //   20: iload_2
    //   21: ifne -> 203
    //   24: aload_1
    //   25: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   28: ifeq -> 34
    //   31: goto -> 203
    //   34: aload_1
    //   35: ldc_w '12'
    //   38: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   41: ifeq -> 101
    //   44: aload_0
    //   45: invokevirtual getActivity : ()Landroidx/fragment/app/FragmentActivity;
    //   48: invokevirtual getSupportFragmentManager : ()Landroidx/fragment/app/FragmentManager;
    //   51: ldc_w 'live'
    //   54: invokevirtual findFragmentByTag : (Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    //   57: astore #4
    //   59: aload_3
    //   60: astore_1
    //   61: aload #4
    //   63: ifnull -> 82
    //   66: aload_3
    //   67: astore_1
    //   68: aload #4
    //   70: instanceof com/soft/blued/ui/live/fragment/LiveFragment
    //   73: ifeq -> 82
    //   76: aload #4
    //   78: checkcast com/soft/blued/ui/live/fragment/LiveFragment
    //   81: astore_1
    //   82: aload_1
    //   83: ifnull -> 202
    //   86: aload_1
    //   87: invokevirtual l : ()Landroidx/viewpager/widget/ViewPager;
    //   90: astore_1
    //   91: aload_1
    //   92: ifnull -> 202
    //   95: aload_1
    //   96: iconst_0
    //   97: invokevirtual setCurrentItem : (I)V
    //   100: return
    //   101: aload_0
    //   102: getfield t : Lcom/soft/blued/ui/live/adapter/LiveCategoryAdapter;
    //   105: astore_3
    //   106: aload_3
    //   107: ifnull -> 202
    //   110: aload_3
    //   111: invokevirtual n : ()Ljava/util/List;
    //   114: invokeinterface size : ()I
    //   119: ifle -> 202
    //   122: aload_0
    //   123: getfield t : Lcom/soft/blued/ui/live/adapter/LiveCategoryAdapter;
    //   126: invokevirtual n : ()Ljava/util/List;
    //   129: invokeinterface iterator : ()Ljava/util/Iterator;
    //   134: astore #4
    //   136: aload #4
    //   138: invokeinterface hasNext : ()Z
    //   143: ifeq -> 177
    //   146: aload #4
    //   148: invokeinterface next : ()Ljava/lang/Object;
    //   153: checkcast com/soft/blued/ui/live/model/LiveTabModel
    //   156: astore_3
    //   157: aload_3
    //   158: ifnull -> 136
    //   161: aload_3
    //   162: getfield id : Ljava/lang/String;
    //   165: aload_1
    //   166: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   169: ifeq -> 136
    //   172: aload_3
    //   173: astore_1
    //   174: goto -> 179
    //   177: aconst_null
    //   178: astore_1
    //   179: aload_1
    //   180: ifnull -> 202
    //   183: aload_0
    //   184: getfield i : Landroid/content/Context;
    //   187: aload_1
    //   188: getfield id : Ljava/lang/String;
    //   191: aload_1
    //   192: getfield name : Ljava/lang/String;
    //   195: aload_1
    //   196: getfield type : I
    //   199: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V
    //   202: return
    //   203: aload_0
    //   204: invokevirtual getActivity : ()Landroidx/fragment/app/FragmentActivity;
    //   207: invokevirtual getSupportFragmentManager : ()Landroidx/fragment/app/FragmentManager;
    //   210: ldc_w 'live'
    //   213: invokevirtual findFragmentByTag : (Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    //   216: astore_3
    //   217: aload #4
    //   219: astore_1
    //   220: aload_3
    //   221: ifnull -> 239
    //   224: aload #4
    //   226: astore_1
    //   227: aload_3
    //   228: instanceof com/soft/blued/ui/live/fragment/LiveFragment
    //   231: ifeq -> 239
    //   234: aload_3
    //   235: checkcast com/soft/blued/ui/live/fragment/LiveFragment
    //   238: astore_1
    //   239: aload_1
    //   240: ifnull -> 257
    //   243: aload_1
    //   244: invokevirtual l : ()Landroidx/viewpager/widget/ViewPager;
    //   247: astore_1
    //   248: aload_1
    //   249: ifnull -> 257
    //   252: aload_1
    //   253: iconst_1
    //   254: invokevirtual setCurrentItem : (I)V
    //   257: return
  }
  
  public void e() {}
  
  public void k() {}
  
  public void l() {
    Log.i("xpm", "receive showBannerNodata");
    this.asvp_banner_hot_parent.setVisibility(8);
    this.lpi_line.setVisibility(8);
  }
  
  public void m() {
    Log.i("xpm", "receive setTwoLevelNodata");
    this.x = false;
    this.u = null;
    F();
  }
  
  public void n() {
    this.g = true;
    ArrayList<LiveTabModel> arrayList = new ArrayList();
    int j = this.e.size();
    int i = 0;
    if (j > 10) {
      for (i = 0; i <= 8; i++)
        arrayList.add(this.e.get(i)); 
      LiveTabModel liveTabModel1 = new LiveTabModel("15", getText(2131757438).toString(), 0, 0);
      LiveTabModel liveTabModel2 = this.f;
      if (liveTabModel2 != null) {
        liveTabModel1.less_cate_icon = liveTabModel2.less_cate_icon;
        liveTabModel1.more_cate_icon = this.f.more_cate_icon;
      } 
      arrayList.add(liveTabModel1);
      for (i = 9; i < this.e.size(); i++)
        arrayList.add(this.e.get(i)); 
    } else {
      while (i < this.e.size()) {
        arrayList.add(this.e.get(i));
        i++;
      } 
    } 
    this.t.a(arrayList);
  }
  
  public void onClick(View paramView) {
    LiveFragment liveFragment;
    if (paramView.getId() != 2131298684)
      return; 
    View view = null;
    Fragment fragment = getActivity().getSupportFragmentManager().findFragmentByTag("live");
    paramView = view;
    if (fragment != null) {
      paramView = view;
      if (fragment instanceof LiveFragment)
        liveFragment = (LiveFragment)fragment; 
    } 
    if (liveFragment != null) {
      ViewPager viewPager = liveFragment.l();
      if (viewPager != null)
        viewPager.setCurrentItem(2); 
    } 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.i = (Context)getActivity();
    L();
  }
  
  public void onDestroy() {
    super.onDestroy();
    HomeTabClick.b("live", this);
  }
  
  public void onPause() {
    super.onPause();
    if (this.w == 0L)
      this.w = System.currentTimeMillis(); 
    if (this.v) {
      LiveListHotFragment liveListHotFragment = I();
      if (liveListHotFragment != null && liveListHotFragment.e != null) {
        Log.i("xpm", "LiveHome onPause");
        liveListHotFragment.e.a();
      } 
    } 
  }
  
  public void onResume() {
    super.onResume();
    if (this.v && this.w != 0L) {
      if (System.currentTimeMillis() - this.w > 300000L) {
        Log.i("xpm", "autoRefresh 2");
        this.refreshLayout.i();
      } 
      this.w = 0L;
    } 
    if (this.v) {
      LiveListHotFragment liveListHotFragment = I();
      if (liveListHotFragment != null && liveListHotFragment.e != null) {
        Log.i("xpm", "LiveHome onResume");
        liveListHotFragment.e.B();
      } 
    } 
    ShapeLinearLayout shapeLinearLayout = this.living_count;
    if (shapeLinearLayout != null)
      ShapeHelper.b((ShapeHelper.ShapeView)shapeLinearLayout, 2131100848); 
  }
  
  public void onStart() {
    super.onStart();
    if (BluedApplicationLike.SPECIAL_DEVICE_FOR_VIEW_OVERFLOW) {
      MyAdapter myAdapter = this.s;
      if (myAdapter != null && myAdapter.getCount() > 1)
        this.main_live_new_viewpager.setOffscreenPageLimit(this.s.getCount()); 
    } 
  }
  
  public void onStop() {
    super.onStop();
    if (BluedApplicationLike.SPECIAL_DEVICE_FOR_VIEW_OVERFLOW)
      this.main_live_new_viewpager.setOffscreenPageLimit(1); 
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.asvp_banner_hot_parent.getLayoutParams();
    layoutParams.width = AppInfo.l - DisplayUtil.a(getContext(), 20.0F);
    layoutParams.height = (int)(layoutParams.width * 125.0F / 726.0F);
    this.asvp_banner_hot_parent.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    M();
  }
  
  public int p() {
    return 2131493183;
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    this.v = paramBoolean;
    if (paramBoolean)
      HomeTabClick.a("live", this); 
    LiveListHotFragment liveListHotFragment = I();
    if (liveListHotFragment != null && liveListHotFragment.e != null) {
      liveListHotFragment.e.e(paramBoolean);
      if (this.v) {
        liveListHotFragment.e.B();
        return;
      } 
      liveListHotFragment.e.a();
    } 
  }
  
  class BannerPagerAdapter extends PagerAdapter {
    BannerPagerAdapter(LiveHomeFragment this$0) {}
    
    public void a(List<BannerModel> param1List) {
      if (param1List != null) {
        if (LiveHomeFragment.g(this.a) != null) {
          LiveHomeFragment.g(this.a).clear();
        } else {
          LiveHomeFragment.a(this.a, new ArrayList());
        } 
        LiveHomeFragment.g(this.a).addAll(param1List);
      } 
      notifyDataSetChanged();
    }
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      param1ViewGroup.removeView((View)param1Object);
    }
    
    public int getCount() {
      return (LiveHomeFragment.g(this.a) != null) ? LiveHomeFragment.g(this.a).size() : 0;
    }
    
    public int getItemPosition(Object param1Object) {
      return -2;
    }
    
    public Object instantiateItem(ViewGroup param1ViewGroup, int param1Int) {
      String str = ((BannerModel)LiveHomeFragment.g(this.a).get(param1Int)).url;
      while (LiveHomeFragment.h(this.a).size() < LiveHomeFragment.g(this.a).size()) {
        LiveHomeFragment.BannerViewHolder bannerViewHolder1 = new LiveHomeFragment.BannerViewHolder(this.a);
        View view1 = LayoutInflater.from(LiveHomeFragment.d(this.a)).inflate(2131493555, param1ViewGroup, false);
        Unbinder unbinder = ButterKnife.a(bannerViewHolder1, view1);
        LiveHomeFragment.h(this.a).add(view1);
        LiveHomeFragment.i(this.a).add(bannerViewHolder1);
        LiveHomeFragment.j(this.a).add(unbinder);
      } 
      LiveHomeFragment.BannerViewHolder bannerViewHolder = LiveHomeFragment.i(this.a).get(param1Int);
      ImageLoader.a((IRequestHost)this.a.w_(), ((BannerModel)LiveHomeFragment.g(this.a).get(param1Int)).imgurl).a(2131231369).a(bannerViewHolder.aariv_banner);
      if (!((BannerModel)LiveHomeFragment.g(this.a).get(param1Int)).isShowUrlVisited) {
        FindHttpUtils.a(((BannerModel)LiveHomeFragment.g(this.a).get(param1Int)).show_url);
        ((BannerModel)LiveHomeFragment.g(this.a).get(param1Int)).isShowUrlVisited = true;
      } 
      bannerViewHolder.aariv_banner.setOnClickListener(new View.OnClickListener(this, param1Int, str) {
            public void onClick(View param2View) {
              FindHttpUtils.a(((BannerModel)LiveHomeFragment.g(this.c.a).get(this.a)).click_url);
              WebViewShowInfoFragment.show(LiveHomeFragment.d(this.c.a), this.b, 9);
            }
          });
      View view = LiveHomeFragment.h(this.a).get(param1Int);
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
    null(LiveHomeFragment this$0, int param1Int, String param1String) {}
    
    public void onClick(View param1View) {
      FindHttpUtils.a(((BannerModel)LiveHomeFragment.g(this.c.a).get(this.a)).click_url);
      WebViewShowInfoFragment.show(LiveHomeFragment.d(this.c.a), this.b, 9);
    }
  }
  
  class BannerViewHolder {
    @BindView(2131296339)
    ImageView aariv_banner;
    
    BannerViewHolder(LiveHomeFragment this$0) {}
  }
  
  public class MyAdapter extends FragmentStatePagerAdapter {
    private LiveListHotFragment b = null;
    
    public MyAdapter(LiveHomeFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      super.destroyItem(param1ViewGroup, param1Int, param1Object);
    }
    
    public int getCount() {
      return this.a.d.size();
    }
    
    public Fragment getItem(int param1Int) {
      return (Fragment)new LiveListHotFragment();
    }
    
    public CharSequence getPageTitle(int param1Int) {
      return ((LiveTabModel)this.a.d.get(param1Int)).name;
    }
    
    public Object instantiateItem(ViewGroup param1ViewGroup, int param1Int) {
      return super.instantiateItem(param1ViewGroup, param1Int);
    }
    
    public void setPrimaryItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      super.setPrimaryItem(param1ViewGroup, param1Int, param1Object);
      this.b = (LiveListHotFragment)param1Object;
      if (this.b.l()) {
        Log.i("xpm", "autoRefresh 1");
        this.a.refreshLayout.i();
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\fragment\LiveHomeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */