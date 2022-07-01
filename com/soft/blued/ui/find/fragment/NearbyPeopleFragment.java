package com.soft.blued.ui.find.fragment;

import android.animation.ArgbEvaluator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live.base.utils.LiveSettingConfig;
import com.blued.das.guy.GuyProtos;
import com.blued.das.live.LiveProtos;
import com.blued.das.vip.VipProtos;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.google.android.material.appbar.AppBarLayout;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.OnTwoLevelListener;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import com.soft.blued.constant.ADConstants;
import com.soft.blued.control.LocationHelperNew;
import com.soft.blued.customview.BannerADView;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.PopMenu;
import com.soft.blued.customview.smartrefresh.BluedAdapterLoadMoreView;
import com.soft.blued.customview.smartrefresh.TwoLevelNearbyRefreshView;
import com.soft.blued.http.AppHttpUtils;
import com.soft.blued.http.BluedHttpUrl;
import com.soft.blued.http.HttpUtils;
import com.soft.blued.log.trackUtils.EventTrackGuy;
import com.soft.blued.log.trackUtils.EventTrackLive;
import com.soft.blued.ui.ab_test.models.ShortEntranceExtra;
import com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter;
import com.soft.blued.ui.find.adapter.PeopleListQuickAdapter;
import com.soft.blued.ui.find.manager.CallHelloManager;
import com.soft.blued.ui.find.manager.FilterHelper;
import com.soft.blued.ui.find.manager.MapFindManager;
import com.soft.blued.ui.find.model.CallHelloModel;
import com.soft.blued.ui.find.model.CallMeStatusData;
import com.soft.blued.ui.find.model.FindDataExtra;
import com.soft.blued.ui.find.model.FindRecommendExtra;
import com.soft.blued.ui.find.model.NearbyChatRoomModel;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.find.observer.NearbyViewModel;
import com.soft.blued.ui.find.presenter.NearbyPeoplePresenter;
import com.soft.blued.ui.find.view.NearbyChatRoomView;
import com.soft.blued.ui.find.view.RecommendViewMixedInNearby;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.home.HomeTabClick;
import com.soft.blued.ui.live.fragment.LiveTwoLevelFragment;
import com.soft.blued.ui.live.model.LiveTwoFloorModel;
import com.soft.blued.ui.live.view.CustomTwoLevelHeader;
import com.soft.blued.ui.login_register.model.NearbyPeopleTabModel;
import com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.utils.RefreshUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.click.SingleClickProxy;
import com.soft.blued.utils.third.TTADUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class NearbyPeopleFragment extends MvpFragment<NearbyPeoplePresenter> implements View.OnClickListener, HomeTabClick.TabClickListener {
  private TipHeaderHolder A;
  
  private List<Unbinder> B = new ArrayList<Unbinder>();
  
  private List<Unbinder> C = new ArrayList<Unbinder>();
  
  private Unbinder D;
  
  private AppBarLayout.OnOffsetChangedListener E = new AppBarLayout.OnOffsetChangedListener(this) {
      public void onOffsetChanged(AppBarLayout param1AppBarLayout, int param1Int) {
        if (param1Int < 0) {
          if (this.a.f) {
            NearbyPeopleFragment nearbyPeopleFragment = this.a;
            nearbyPeopleFragment.f = false;
            nearbyPeopleFragment.nearbyChatRoomView.d();
          } 
        } else if (!this.a.f) {
          NearbyPeopleFragment nearbyPeopleFragment = this.a;
          nearbyPeopleFragment.f = true;
          nearbyPeopleFragment.nearbyChatRoomView.c();
        } 
        NearbyPeopleFragment.b(this.a, -param1Int);
      }
    };
  
  private RecyclerView.OnScrollListener F = new RecyclerView.OnScrollListener(this) {
      public void onScrollStateChanged(RecyclerView param1RecyclerView, int param1Int) {
        super.onScrollStateChanged(param1RecyclerView, param1Int);
        if (!NearbyPeopleFragment.i(this.a))
          return; 
        if (param1Int == 0) {
          if (NearbyPeopleFragment.f(this.a) != null) {
            NearbyPeopleFragment.f(this.a).f(false);
            NearbyPeopleFragment.f(this.a).D();
          } 
          if (this.a.mRecommendViewMixedInNearby != null) {
            this.a.mRecommendViewMixedInNearby.a(NearbyPeopleFragment.j(this.a));
            return;
          } 
        } else if (param1Int == 1 && NearbyPeopleFragment.f(this.a) != null) {
          NearbyPeopleFragment.f(this.a).f(true);
        } 
      }
      
      public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
        super.onScrolled(param1RecyclerView, param1Int1, param1Int2);
      }
    };
  
  private boolean G = false;
  
  @BindView(2131296447)
  public AppBarLayout appbar;
  
  public View d;
  
  public BannerADView e;
  
  public boolean f = true;
  
  @BindView(2131297089)
  public FrameLayout flBanner;
  
  private Context g;
  
  private boolean h;
  
  @BindView(2131297358)
  public CustomTwoLevelHeader header;
  
  private PeopleGridQuickAdapter i;
  
  @BindView(2131297729)
  public ImageView iv_close;
  
  @BindView(2131297804)
  public ImageView iv_icon;
  
  private PeopleListQuickAdapter j;
  
  @BindView(2131298062)
  public LinearLayout layoutFilterReset;
  
  @BindView(2131299045)
  public LinearLayout llRefresh;
  
  @BindView(2131299690)
  public RelativeLayout mCallBtn;
  
  @BindView(2131299692)
  public RelativeLayout mCallBtnState;
  
  @BindView(2131299587)
  public RecommendViewMixedInNearby mRecommendViewMixedInNearby;
  
  @BindView(2131299605)
  public RecyclerView mRecyclerView;
  
  @BindView(2131299616)
  public SmartRefreshLayout mRefreshLayout;
  
  private List<UserFindResult> n;
  
  @BindView(2131299361)
  public NearbyChatRoomView nearbyChatRoomView;
  
  @BindView(2131299395)
  public NoDataAndLoadFailView noDataAndLoadFailView;
  
  private List<UserFindResult> o;
  
  private List<List<String>> p;
  
  private List<PopMenu> q = new ArrayList<PopMenu>();
  
  private int r = 0;
  
  @BindView(2131299618)
  public TwoLevelNearbyRefreshView refresh_view;
  
  @BindView(2131299717)
  public RelativeLayout rl_location_root;
  
  private boolean s = false;
  
  @BindView(2131299997)
  public LinearLayout sortTabBar;
  
  @BindView(2131300092)
  public ShapeTextView stvFilterReset;
  
  private boolean t = false;
  
  @BindView(2131300164)
  public LinearLayout tabBar;
  
  @BindView(2131300715)
  public TextView tv_distance;
  
  @BindView(2131300998)
  public TextView tv_location;
  
  private LiveTwoFloorModel u;
  
  private boolean v = false;
  
  private int w = 0;
  
  private boolean x;
  
  private List<TabHolder> y = new ArrayList<TabHolder>();
  
  private List<MenuHolder> z = new ArrayList<MenuHolder>();
  
  private void L() {
    if (this.e == null) {
      this.e = new BannerADView(this.g);
      this.e.setRadius(6.0F);
    } 
    this.flBanner.addView((View)this.e);
  }
  
  private void M() {
    this.stvFilterReset.setOnClickListener(this);
    this.mRecommendViewMixedInNearby.a((IRequestHost)w_());
    this.mRecommendViewMixedInNearby.a((View)this.mCallBtn, (View)this.mCallBtnState);
    if (MapFindManager.a().b())
      S(); 
  }
  
  private boolean N() {
    Iterator<PopMenu> iterator = this.q.iterator();
    boolean bool = false;
    while (iterator.hasNext()) {
      PopMenu popMenu = iterator.next();
      if (popMenu.a()) {
        popMenu.d();
        bool = true;
      } 
    } 
    return bool;
  }
  
  private void O() {
    FilterHelper.d().e();
  }
  
  private void P() {
    if (this.p == null)
      this.p = BluedConfig.b().b(this.g); 
    this.q.clear();
    this.y.clear();
    this.B.clear();
    this.z.clear();
    this.C.clear();
    for (int i = 0; i < this.p.size(); i++) {
      List<String> list = this.p.get(i);
      if (list != null && list.size() > 0) {
        View view = LayoutInflater.from(this.g).inflate(2131493778, null);
        TabHolder tabHolder = new TabHolder(this);
        Unbinder unbinder = ButterKnife.a(tabHolder, view);
        tabHolder.layoutSortTab.setTag(Boolean.valueOf(true));
        this.sortTabBar.addView(view);
        if (i < this.p.size() - 1) {
          tabHolder.tvDivider.setVisibility(0);
        } else {
          tabHolder.tvDivider.setVisibility(4);
        } 
        this.y.add(tabHolder);
        this.B.add(unbinder);
        tabHolder.tvSortTab.setTag(list.get(0));
        tabHolder.tvSortTab.setText(f(list.get(0)));
        view.setOnClickListener((View.OnClickListener)new SingleClickProxy(new View.OnClickListener(this, i, tabHolder) {
                public void onClick(View param1View) {
                  int i = NearbyPeopleFragment.b(this.c);
                  int j = this.a;
                  if (i == j) {
                    ((NearbyPeoplePresenter)this.c.s()).j = this.b.tvSortTab.getTag().toString();
                    NearbyPeopleFragment nearbyPeopleFragment1 = this.c;
                    NearbyPeopleFragment.a(nearbyPeopleFragment1, ((NearbyPeoplePresenter)nearbyPeopleFragment1.s()).j, 0);
                    return;
                  } 
                  NearbyPeopleFragment.a(this.c, j);
                  ((NearbyPeoplePresenter)this.c.s()).j = this.b.tvSortTab.getTag().toString();
                  NearbyPeopleFragment nearbyPeopleFragment = this.c;
                  NearbyPeopleFragment.a(nearbyPeopleFragment, ((NearbyPeoplePresenter)nearbyPeopleFragment.s()).j, 220);
                }
              }));
        if (TextUtils.isEmpty(((NearbyPeoplePresenter)s()).j))
          ((NearbyPeoplePresenter)s()).j = list.get(0); 
        if (((NearbyPeoplePresenter)s()).j.equals(list.get(0)))
          this.r = i; 
        if (list.size() > 1) {
          tabHolder.ivSortTab.setVisibility(0);
          tabHolder.ivSortTab.setImageDrawable(BluedSkinUtils.b(this.g, 2131232621));
          LinearLayout linearLayout = new LinearLayout(this.g);
          linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
          linearLayout.setOrientation(1);
          PopMenu popMenu = new PopMenu(this.g, (View)linearLayout);
          this.q.add(popMenu);
          popMenu.a(new PopMenu.onShowListener(this, tabHolder) {
                public void a() {
                  this.b.m();
                  this.a.ivSortTab.setImageDrawable(BluedSkinUtils.b(NearbyPeopleFragment.c(this.b), 2131232623));
                }
              });
          popMenu.a(new PopupWindow.OnDismissListener(this, tabHolder) {
                public void onDismiss() {
                  this.b.m();
                  this.a.ivSortTab.setImageDrawable(BluedSkinUtils.b(NearbyPeopleFragment.c(this.b), 2131232622));
                }
              });
          view.setOnClickListener((View.OnClickListener)new SingleClickProxy(new View.OnClickListener(this, i, popMenu, tabHolder) {
                  public void onClick(View param1View) {
                    int i = NearbyPeopleFragment.b(this.d);
                    int j = this.a;
                    if (i == j) {
                      if (this.d.mRefreshLayout.getState() == RefreshState.a && !NearbyPeopleFragment.d(this.d)) {
                        this.b.a((View)this.d.sortTabBar);
                        return;
                      } 
                    } else {
                      NearbyPeopleFragment.a(this.d, j);
                      ((NearbyPeoplePresenter)this.d.s()).j = this.c.tvSortTab.getTag().toString();
                      NearbyPeopleFragment nearbyPeopleFragment = this.d;
                      NearbyPeopleFragment.a(nearbyPeopleFragment, ((NearbyPeoplePresenter)nearbyPeopleFragment.s()).j, 220);
                    } 
                  }
                }));
          ArrayList<ImageView> arrayList = new ArrayList();
          boolean bool = false;
          for (int j = 0; j < list.size(); j++) {
            View view1 = LayoutInflater.from(this.g).inflate(2131493615, null);
            MenuHolder menuHolder = new MenuHolder(this);
            Unbinder unbinder1 = ButterKnife.a(menuHolder, view1);
            arrayList.add(menuHolder.ivSortMenu);
            String str = list.get(j);
            this.z.add(menuHolder);
            this.C.add(unbinder1);
            if (TextUtils.isEmpty(((NearbyPeoplePresenter)s()).j))
              ((NearbyPeoplePresenter)s()).j = str; 
            if (((NearbyPeoplePresenter)s()).j.equals(str)) {
              this.r = i;
              menuHolder.ivSortMenu.setVisibility(0);
              tabHolder.tvSortTab.setTag(list.get(j));
              tabHolder.tvSortTab.setText(f(list.get(j)));
              tabHolder.ivSortTab.setImageDrawable(BluedSkinUtils.b(this.g, 2131232622));
              bool = true;
            } 
            view1.setOnClickListener((View.OnClickListener)new SingleClickProxy(new View.OnClickListener(this, popMenu, arrayList, menuHolder, tabHolder, str) {
                    public void onClick(View param1View) {
                      this.a.d();
                      Iterator<ImageView> iterator = this.b.iterator();
                      while (iterator.hasNext())
                        ((ImageView)iterator.next()).setVisibility(8); 
                      this.c.ivSortMenu.setVisibility(0);
                      this.d.tvSortTab.setTag(this.e);
                      this.d.tvSortTab.setText(NearbyPeopleFragment.a(this.f, this.e));
                      ((NearbyPeoplePresenter)this.f.s()).j = this.e;
                      NearbyPeopleFragment nearbyPeopleFragment = this.f;
                      NearbyPeopleFragment.a(nearbyPeopleFragment, ((NearbyPeoplePresenter)nearbyPeopleFragment.s()).j, 220);
                    }
                  }));
            menuHolder.tvSortMenu.setText(f(list.get(j)));
            linearLayout.addView(view1);
          } 
          if (!bool)
            ((ImageView)arrayList.get(0)).setVisibility(0); 
        } else {
          tabHolder.ivSortTab.setVisibility(8);
        } 
      } 
    } 
  }
  
  private void Q() {
    this.mRefreshLayout.b(false);
    this.j = new PeopleListQuickAdapter(new ArrayList(), (Activity)getActivity(), (IRequestHost)w_(), ((NearbyPeoplePresenter)s()).j, this.mRecyclerView);
    this.j.a((LoadMoreView)new BluedAdapterLoadMoreView());
    this.j.c(this.o);
    this.j.a(new BaseQuickAdapter.RequestLoadMoreListener(this) {
          public void onLoadMoreRequested() {
            LiveEventBus.get("is_show_tip").post(Boolean.valueOf(true));
            ((NearbyPeoplePresenter)this.a.s()).f();
          }
        });
    this.j.a(new PeopleGridQuickAdapter.OnDrawPeopleListener(this) {
          public void a() {
            if (this.a.mRecommendViewMixedInNearby != null)
              this.a.a(new Runnable(this) {
                    public void run() {
                      this.a.a.mRecommendViewMixedInNearby.c();
                      this.a.a.mRecommendViewMixedInNearby.a(false);
                    }
                  },  500L); 
          }
        });
    this.j.c(this.mRecyclerView);
    this.i = new PeopleGridQuickAdapter(new ArrayList(), (Activity)getActivity(), (IRequestHost)w_(), ((NearbyPeoplePresenter)s()).j, this.mRecyclerView);
    this.i.a((LoadMoreView)new BluedAdapterLoadMoreView());
    this.i.c(this.n);
    this.i.a(new BaseQuickAdapter.RequestLoadMoreListener(this) {
          public void onLoadMoreRequested() {
            LiveEventBus.get("is_show_tip").post(Boolean.valueOf(true));
            ((NearbyPeoplePresenter)this.a.s()).f();
          }
        });
    this.i.a(new PeopleGridQuickAdapter.OnDrawPeopleListener(this) {
          public void a() {
            if (this.a.mRecommendViewMixedInNearby != null)
              this.a.a(new Runnable(this) {
                    public void run() {
                      this.a.a.mRecommendViewMixedInNearby.c();
                      this.a.a.mRecommendViewMixedInNearby.a(false);
                    }
                  },  500L); 
          }
        });
    this.i.c(this.mRecyclerView);
    this.i.a(true);
    this.noDataAndLoadFailView.setOnTouchEvent(false);
    this.noDataAndLoadFailView.setTopSpace(DensityUtils.a(this.g, 40.0F));
    this.noDataAndLoadFailView.setImageScale(0.7F);
    this.noDataAndLoadFailView.setNoDataStr(2131758356);
    this.noDataAndLoadFailView.setNoDataImg(2131232639);
    this.noDataAndLoadFailView.setNoDataBtnListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            NearbyPeopleFragment.e(this.a);
          }
        });
    ShapeTextView shapeTextView = this.noDataAndLoadFailView.getBtn();
    (shapeTextView.getLayoutParams()).width = DensityUtils.a(this.g, 160.0F);
    (shapeTextView.getLayoutParams()).height = DensityUtils.a(this.g, 44.0F);
    shapeTextView.setText(2131758355);
    ShapeHelper.b((ShapeHelper.ShapeView)shapeTextView, 2131100813);
    ShapeHelper.c((ShapeHelper.ShapeView)shapeTextView, 2131100876);
    ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView, DensityUtils.a(this.g, 18.0F));
    ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView, 2131100788);
    this.header.a(new OnTwoLevelListener(this) {
          public boolean a(RefreshLayout param1RefreshLayout) {
            return false;
          }
        });
    this.mRefreshLayout.a((OnMultiPurposeListener)new SimpleMultiPurposeListener(this) {
          public void a(RefreshHeader param1RefreshHeader, boolean param1Boolean, float param1Float, int param1Int1, int param1Int2, int param1Int3) {
            super.a(param1RefreshHeader, param1Boolean, param1Float, param1Int1, param1Int2, param1Int3);
            if (this.a.getParentFragment() instanceof NearbyHomeFragment)
              ((NearbyHomeFragment)this.a.getParentFragment()).a(param1Float, param1Int1); 
          }
          
          public void a(RefreshLayout param1RefreshLayout, RefreshState param1RefreshState1, RefreshState param1RefreshState2) {
            if (param1RefreshState2 == RefreshState.a) {
              NearbyPeopleFragment.g(this.a);
              if (NearbyPeopleFragment.h(this.a) != null && !TextUtils.isEmpty((NearbyPeopleFragment.h(this.a)).two_floor_picture))
                EventTrackLive.b(LiveProtos.Event.LIVE_HOME_REFRESH_IMAGE_SHOW, (NearbyPeopleFragment.h(this.a)).lid, (NearbyPeopleFragment.h(this.a)).uid, (NearbyPeopleFragment.h(this.a)).id); 
              if (NearbyPeopleFragment.h(this.a) != null) {
                EventTrackLive.b(LiveProtos.Event.LIVE_HOME_REFRESH_WORD_SHOW, (NearbyPeopleFragment.h(this.a)).lid, (NearbyPeopleFragment.h(this.a)).uid, (NearbyPeopleFragment.h(this.a)).id);
                return;
              } 
            } else {
              if (param1RefreshState2 == RefreshState.h)
                return; 
              if (param1RefreshState2 == RefreshState.i) {
                if (NearbyPeopleFragment.h(this.a) == null)
                  return; 
                if (TextUtils.equals("3", (NearbyPeopleFragment.h(this.a)).type) && !TextUtils.isEmpty((NearbyPeopleFragment.h(this.a)).activity_addr)) {
                  EventTrackLive.b(LiveProtos.Event.LIVE_HOME_REFRESH_LIVE_ENTER, (NearbyPeopleFragment.h(this.a)).lid, (NearbyPeopleFragment.h(this.a)).uid, (NearbyPeopleFragment.h(this.a)).id);
                  WebViewShowInfoFragment.show(NearbyPeopleFragment.c(this.a), (NearbyPeopleFragment.h(this.a)).activity_addr, 14);
                  return;
                } 
                if (TextUtils.equals("1", (NearbyPeopleFragment.h(this.a)).type)) {
                  EventTrackLive.b(LiveProtos.Event.LIVE_HOME_REFRESH_LIVE_ENTER, (NearbyPeopleFragment.h(this.a)).lid, (NearbyPeopleFragment.h(this.a)).uid, (NearbyPeopleFragment.h(this.a)).id);
                  LiveTwoLevelFragment.a(NearbyPeopleFragment.c(this.a), "two_floor_nearby", NearbyPeopleFragment.h(this.a));
                } 
              } 
            } 
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            DeviceUtils.a(new LocationHelperNew.LocationFinishListener(this) {
                  private void b() {
                    ((NearbyPeoplePresenter)this.a.a.s()).r();
                    if (HomeActivity.c != null)
                      ((NearbyViewModel)ViewModelProviders.of((FragmentActivity)HomeActivity.c).get(NearbyViewModel.class)).d.postValue(null); 
                  }
                  
                  public void a() {
                    ((NearbyPeoplePresenter)this.a.a.s()).e();
                    b();
                    ((NearbyPeoplePresenter)this.a.a.s()).a(false);
                  }
                  
                  public void a(int param2Int) {
                    ((NearbyPeoplePresenter)this.a.a.s()).e();
                    b();
                    ((NearbyPeoplePresenter)this.a.a.s()).a(false);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(NearbyPeopleFragment.c(this.a.a).getResources().getString(2131757794));
                    stringBuilder.append("(");
                    stringBuilder.append(param2Int);
                    stringBuilder.append(")");
                    AppMethods.a(stringBuilder.toString());
                  }
                });
            ((NearbyPeoplePresenter)this.a.s()).o();
            NearbyPeopleFragment.b(this.a, false);
            if (((NearbyPeoplePresenter)this.a.s()).t() && NearbyPeopleFragment.f(this.a) != null)
              NearbyPeopleFragment.f(this.a).C(); 
          }
        });
    this.mRecyclerView.addOnScrollListener(this.F);
    this.appbar.a(this.E);
  }
  
  private void R() {
    BluedConfig.b().b(new BluedConfig.UpdateBluedConfigListner(this) {
          public void a() {
            if (!BluedConfig.b().y()) {
              this.a.d = null;
              return;
            } 
            NearbyPeopleFragment nearbyPeopleFragment = this.a;
            nearbyPeopleFragment.d = LayoutInflater.from(NearbyPeopleFragment.c(nearbyPeopleFragment)).inflate(2131493777, null);
            nearbyPeopleFragment = this.a;
            NearbyPeopleFragment.a(nearbyPeopleFragment, new NearbyPeopleFragment.TipHeaderHolder(nearbyPeopleFragment));
            nearbyPeopleFragment = this.a;
            NearbyPeopleFragment.a(nearbyPeopleFragment, ButterKnife.a(NearbyPeopleFragment.k(nearbyPeopleFragment), this.a.d));
            ImageLoader.a((IRequestHost)this.a.w_(), (UserInfo.a().i()).avatar).a(2131234356).c().a((NearbyPeopleFragment.k(this.a)).imgHeader);
            this.a.d.setOnClickListener(new View.OnClickListener(this) {
                  public void onClick(View param2View) {
                    EventTrackGuy.b(GuyProtos.Event.COMPLETE_PROFILE_NEW_CLICK);
                    if (!PopMenuUtils.a(NearbyPeopleFragment.c(this.a.a)))
                      ModifyUserInfoFragment.a(NearbyPeopleFragment.c(this.a.a), 0, false); 
                  }
                });
            if (NearbyPeopleFragment.l(this.a) != null) {
              NearbyPeopleFragment.l(this.a).b(this.a.d);
              EventTrackGuy.b(GuyProtos.Event.COMPLETE_PROFILE_NEW_SHOW);
            } 
          }
          
          public void b() {}
        });
    LiveSettingConfig.a().a(AppHttpUtils.b());
  }
  
  private void S() {
    this.rl_location_root.setVisibility(8);
    this.iv_close.setOnClickListener(new -$$Lambda$NearbyPeopleFragment$STA4_qZKFi0-oyeYZRnZIXefFCI(this));
    this.rl_location_root.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            (new FindSearchMapDialogFragment()).show(this.a.getChildFragmentManager(), "");
          }
        });
    if (this.rl_location_root != null && MapFindManager.a().b()) {
      String str;
      this.rl_location_root.setVisibility(0);
      double d = (MapFindManager.a().c()).c;
      if (d < 100.0D) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(decimalFormat.format(d));
        stringBuilder.append(" km");
        str = stringBuilder.toString();
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d);
        stringBuilder.append(" km");
        str = stringBuilder.toString();
      } 
      this.rl_location_root.setBackgroundColor(BluedSkinUtils.a(getContext(), 2131100716));
      this.tv_distance.setText(str);
      this.tv_location.setText((MapFindManager.a().c()).d);
      ArgbEvaluator argbEvaluator = new ArgbEvaluator();
      int i = BluedSkinUtils.a(getContext(), 2131100716);
      int j = BluedSkinUtils.a(getContext(), 2131100733);
      ValueAnimator valueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      valueAnimator.setDuration(1500L);
      valueAnimator.setStartDelay(1500L);
      valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, argbEvaluator, i, j) {
            public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
              if (this.d.rl_location_root != null) {
                int i = ((Integer)this.a.evaluate(((Float)param1ValueAnimator.getAnimatedValue()).floatValue(), Integer.valueOf(this.b), Integer.valueOf(this.c))).intValue();
                this.d.rl_location_root.setBackgroundColor(i);
              } 
            }
          });
      valueAnimator.start();
    } 
  }
  
  private void T() {
    if (TextUtils.isEmpty(((NearbyPeoplePresenter)s()).j))
      ((NearbyPeoplePresenter)s()).j = BluedPreferences.az(); 
    if (TextUtils.isEmpty(((NearbyPeoplePresenter)s()).j) && BluedPreferences.ck()) {
      ((NearbyPeoplePresenter)s()).j = (BluedConfig.b().c()).default_home_tabs;
      BluedPreferences.cl();
    } 
    if (!h(((NearbyPeoplePresenter)s()).j))
      ((NearbyPeoplePresenter)s()).j = null; 
  }
  
  private boolean U() {
    if (FilterDialogFragment.a)
      return false; 
    (new FilterDialogFragment()).show(getChildFragmentManager(), "");
    return true;
  }
  
  private void V() {
    SmartRefreshLayout smartRefreshLayout = this.mRefreshLayout;
    if (smartRefreshLayout != null && smartRefreshLayout.getState() == RefreshState.a && getParentFragment() instanceof NearbyHomeFragment) {
      String str;
      this.header.a(this.v);
      LiveTwoFloorModel liveTwoFloorModel2 = this.u;
      if (liveTwoFloorModel2 != null) {
        str = liveTwoFloorModel2.two_floor_picture;
      } else {
        str = "";
      } 
      if (TextUtils.isEmpty(str)) {
        this.refresh_view.a(this.v, false);
      } else {
        this.refresh_view.a(this.v, true);
      } 
      ((NearbyHomeFragment)getParentFragment()).a(this.v, str);
      LiveTwoFloorModel liveTwoFloorModel1 = this.u;
      if (liveTwoFloorModel1 != null && liveTwoFloorModel1.anchor != null && !TextUtils.isEmpty(this.u.anchor.avatar))
        ImageFileLoader.a((IRequestHost)w_()).a(this.u.anchor.avatar).a(); 
    } 
  }
  
  private void W() {
    a(0);
  }
  
  private void X() {
    if ((UserInfo.a().i()).vip_grade != 0) {
      Y();
      return;
    } 
    EventTrackGuy.b(GuyProtos.Event.MAP_FIND_BUY_VIP_POP_SHOW);
    CommonAlertDialog.a(this.g, 2131233398, getString(2131757857), null, getString(2131757855), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            EventTrackGuy.b(GuyProtos.Event.MAP_FIND_BUY_VIP_POP_OPEN_CLICK);
            PayUtils.a((Context)this.a.getActivity(), 21, "map_find_pop", VipProtos.FromType.MAP_FIND_BUY);
          }
        }getString(2131757856), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            EventTrackGuy.b(GuyProtos.Event.MAP_FIND_BUY_VIP_POP_CLOSE_CLICK);
            NearbyPeopleFragment.m(this.a);
          }
        },  null, 1);
  }
  
  private void Y() {
    this.rl_location_root.setVisibility(8);
    MapFindManager.a().a(null);
    J();
  }
  
  private void a(int paramInt) {
    RecyclerView recyclerView = this.mRecyclerView;
    if (recyclerView != null) {
      if (this.mRefreshLayout == null)
        return; 
      recyclerView.scrollToPosition(0);
      RefreshUtils.a(this.appbar);
      this.mRefreshLayout.d(paramInt);
    } 
  }
  
  private void a(ShortEntranceExtra paramShortEntranceExtra, boolean paramBoolean) {
    if (paramShortEntranceExtra != null && paramShortEntranceExtra.ads != null && !StringUtils.e(paramShortEntranceExtra.ads.ads_pics)) {
      if (paramBoolean)
        for (int i = 0; i < paramShortEntranceExtra.ads.show_url.length; i++) {
          String str = paramShortEntranceExtra.ads.show_url[i].toLowerCase();
          if (str.startsWith(BluedHttpUrl.n())) {
            Map<String, String> map = BluedHttpTools.a();
            map.put("is_cache", "1");
            paramShortEntranceExtra.ads.show_url[i] = HttpUtils.a(map, str);
          } 
        }  
      this.e.a((IRequestHost)w_(), paramShortEntranceExtra.ads, ADConstants.AD_POSITION.e, new BannerADView.ADListener(this) {
            public void a() {
              this.a.e.setVisibility(8);
            }
            
            public void b() {
              if (this.a.e != null)
                this.a.e.setVisibility(8); 
            }
          });
      return;
    } 
    this.e.setVisibility(8);
  }
  
  private void a(FindDataExtra paramFindDataExtra, boolean paramBoolean) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(String paramString, int paramInt) {
    EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_SORT_CLICK, EventTrackGuy.c(((NearbyPeoplePresenter)s()).j), MapFindManager.a().b());
    g(paramString);
    this.mRecyclerView.scrollToPosition(0);
    ((NearbyPeoplePresenter)s()).e();
    if (this.mRefreshLayout.getState() == RefreshState.a)
      c(true); 
  }
  
  private void b(boolean paramBoolean) {
    for (TabHolder tabHolder : this.y) {
      if ((tabHolder.layoutSortTab.getTag() instanceof Boolean && ((Boolean)tabHolder.layoutSortTab.getTag()).booleanValue()) || paramBoolean) {
        ShapeHelper.a((ShapeHelper.ShapeView)tabHolder.tvSortTab, 2131100844);
        tabHolder.ivSortTab.setImageDrawable(BluedSkinUtils.b(this.g, 2131232621));
        tabHolder.layoutSortTab.setTag(Boolean.valueOf(false));
      } 
    } 
  }
  
  private void c(List<UserFindResult> paramList) {
    this.i.c(paramList);
    this.j.c(paramList);
  }
  
  private void c(boolean paramBoolean) {
    ValueAnimator valueAnimator;
    if (this.s == paramBoolean)
      return; 
    this.s = paramBoolean;
    this.llRefresh.clearAnimation();
    if (this.s) {
      valueAnimator = ValueAnimator.ofInt(new int[] { this.llRefresh.getHeight(), DensityUtils.a(this.g, 44.0F) });
      valueAnimator.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
    } else {
      valueAnimator = ValueAnimator.ofInt(new int[] { this.llRefresh.getHeight(), 0 });
      valueAnimator.setInterpolator((TimeInterpolator)new AccelerateInterpolator());
    } 
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            if (this.a.llRefresh != null) {
              int i = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
              (this.a.llRefresh.getLayoutParams()).height = i;
              this.a.llRefresh.requestLayout();
              return;
            } 
            param1ValueAnimator.cancel();
          }
        });
    valueAnimator.setDuration(300L);
    valueAnimator.start();
  }
  
  private void d(List<UserFindResult> paramList) {
    this.i.a(paramList);
    this.j.a(paramList);
  }
  
  private String f(String paramString) {
    List list = BluedConfig.b().a(this.g);
    String str = paramString;
    if (list != null) {
      str = paramString;
      if (list.size() > 0) {
        Iterator<NearbyPeopleTabModel> iterator = list.iterator();
        while (true) {
          str = paramString;
          if (iterator.hasNext()) {
            NearbyPeopleTabModel nearbyPeopleTabModel = iterator.next();
            if (nearbyPeopleTabModel.sort_by.equals(paramString)) {
              str = nearbyPeopleTabModel.getTitle();
              break;
            } 
            continue;
          } 
          break;
        } 
      } 
    } 
    return str;
  }
  
  private void g(String paramString) {
    ((NearbyPeoplePresenter)s()).j = paramString;
    ((NearbyPeoplePresenter)s()).j = paramString;
    if (TextUtils.isEmpty(paramString))
      ((NearbyPeoplePresenter)s()).j = (BluedConfig.b().c()).default_home_tabs; 
    this.j.b(((NearbyPeoplePresenter)s()).j);
    this.i.b(((NearbyPeoplePresenter)s()).j);
    BluedPreferences.x(((NearbyPeoplePresenter)s()).j);
    int i = this.z.size();
    int j = this.r;
    if (i > j) {
      TextView textView = ((MenuHolder)this.z.get(j)).tvSortMenu;
      textView.setTag(paramString);
      textView.setText(f(paramString));
    } 
    m();
  }
  
  private boolean h(String paramString) {
    if (this.p == null)
      this.p = BluedConfig.b().b(this.g); 
    List<List<String>> list = this.p;
    if (list != null && list.size() > 0) {
      Iterator<List<String>> iterator = this.p.iterator();
      while (iterator.hasNext()) {
        for (String str : iterator.next()) {
          if (!TextUtils.isEmpty(paramString) && paramString.equals(str))
            return true; 
        } 
      } 
    } 
    return false;
  }
  
  private int i(String paramString) {
    if (h(paramString)) {
      if (this.p == null)
        this.p = BluedConfig.b().b(this.g); 
      List<List<String>> list = this.p;
      if (list != null && list.size() > 0)
        for (int i = 0; i < this.p.size(); i++) {
          for (int j = 0; j < ((List)this.p.get(i)).size(); j++) {
            if (!TextUtils.isEmpty(paramString) && paramString.equals(((List)this.p.get(i)).get(j)))
              return i; 
          } 
        }  
    } 
    return -1;
  }
  
  public boolean A() {
    return true;
  }
  
  public void E() {
    if (((NearbyPeoplePresenter)s()).u()) {
      EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_LIST_BTN_CLICK, GuyProtos.ShowType.PALACE_SHOW);
      a(Integer.valueOf(0));
      return;
    } 
    EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_LIST_BTN_CLICK, GuyProtos.ShowType.LIST_SHOW);
    a(Integer.valueOf(1));
  }
  
  public void F() {
    if (((NearbyPeoplePresenter)s()).n == 1)
      c((List<UserFindResult>)null); 
  }
  
  public void G() {
    if (this.mRecommendViewMixedInNearby != null) {
      if (((NearbyPeoplePresenter)s()).t != null) {
        if (((NearbyPeoplePresenter)s()).t.hasData()) {
          this.mRecommendViewMixedInNearby.setMakeFriendRecommend(((NearbyPeoplePresenter)s()).t.data);
        } else {
          this.mRecommendViewMixedInNearby.setMakeFriendRecommendNoData((FindRecommendExtra)((NearbyPeoplePresenter)s()).t.extra);
        } 
        this.mRecommendViewMixedInNearby.setMakeFriendRecommendExtra((FindRecommendExtra)((NearbyPeoplePresenter)s()).t.extra);
        CallHelloManager.a().a(getContext(), (IRequestHost)w_(), this.mRecommendViewMixedInNearby.getFromPage(), null);
        return;
      } 
      this.mRecommendViewMixedInNearby.a();
    } 
  }
  
  public void H() {
    if (this.mRecommendViewMixedInNearby != null && ((NearbyPeoplePresenter)s()).n == 1) {
      this.mRecommendViewMixedInNearby.d();
      b(new Runnable(this) {
            public void run() {
              this.a.mRecommendViewMixedInNearby.a(true);
            }
          },  1500L);
    } 
  }
  
  public void I() {
    this.v = false;
    this.u = null;
    V();
  }
  
  public void J() {
    RecyclerView recyclerView = this.mRecyclerView;
    if (recyclerView != null)
      recyclerView.scrollToPosition(0); 
    ((NearbyPeoplePresenter)s()).e();
    SmartRefreshLayout smartRefreshLayout = this.mRefreshLayout;
    if (smartRefreshLayout != null && smartRefreshLayout.getState() == RefreshState.a)
      c(true); 
    O();
  }
  
  public void K() {
    W();
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.g = (Context)getActivity();
    this.s = false;
    ((NearbyPeoplePresenter)s()).m = 0;
    M();
    L();
    O();
    T();
    P();
    Q();
    R();
    g(((NearbyPeoplePresenter)s()).j);
    a(Integer.valueOf(((NearbyPeoplePresenter)s()).k));
    a(new Runnable(this) {
          public void run() {
            if (!NearbyPeopleFragment.a(this.a)) {
              this.a.mRefreshLayout.a((RefreshHeader)this.a.header);
              NearbyPeopleFragment.a(this.a, true);
            } 
          }
        });
    V();
    if (((NearbyPeoplePresenter)s()).n == 1 && !((NearbyPeoplePresenter)s()).o)
      ((NearbyPeoplePresenter)s()).o(); 
    ((NearbyPeoplePresenter)s()).o = false;
    RelativeLayout relativeLayout = this.rl_location_root;
    if (relativeLayout != null && relativeLayout.getVisibility() == 0)
      this.rl_location_root.setBackgroundColor(BluedSkinUtils.a(getContext(), 2131100733)); 
    if (((NearbyPeoplePresenter)s()).r != null) {
      a(((NearbyPeoplePresenter)s()).r);
      ((NearbyPeoplePresenter)s()).r = null;
    } 
    ((NearbyPeoplePresenter)s()).a(true);
  }
  
  public void a(ShortEntranceExtra paramShortEntranceExtra) {
    a(paramShortEntranceExtra, false);
  }
  
  public void a(CallHelloModel paramCallHelloModel) {
    RecommendViewMixedInNearby recommendViewMixedInNearby = this.mRecommendViewMixedInNearby;
    if (recommendViewMixedInNearby != null)
      recommendViewMixedInNearby.b(paramCallHelloModel.countDown); 
  }
  
  public void a(CallMeStatusData paramCallMeStatusData) {
    RecommendViewMixedInNearby recommendViewMixedInNearby = this.mRecommendViewMixedInNearby;
    if (recommendViewMixedInNearby != null)
      recommendViewMixedInNearby.a(paramCallMeStatusData); 
  }
  
  public void a(FindDataExtra paramFindDataExtra) {
    a(paramFindDataExtra, false);
  }
  
  public void a(NearbyChatRoomModel paramNearbyChatRoomModel) {
    if (paramNearbyChatRoomModel != null) {
      if (paramNearbyChatRoomModel.show) {
        this.nearbyChatRoomView.setVisibility(0);
        if (this.f) {
          this.nearbyChatRoomView.a();
        } else {
          this.nearbyChatRoomView.b();
        } 
        this.nearbyChatRoomView.setText(paramNearbyChatRoomModel.text);
        return;
      } 
      this.nearbyChatRoomView.setVisibility(8);
      return;
    } 
    this.nearbyChatRoomView.setVisibility(8);
  }
  
  public void a(Boolean paramBoolean) {
    if (paramBoolean.booleanValue()) {
      S();
      J();
      return;
    } 
    X();
  }
  
  public void a(Integer paramInteger) {
    if (this.mRecyclerView == null)
      return; 
    if (paramInteger.intValue() == 0) {
      this.mRecyclerView.setAdapter((RecyclerView.Adapter)this.i);
      GridLayoutManager gridLayoutManager = new GridLayoutManager(this.g, ((NearbyPeoplePresenter)s()).l);
      gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(this) {
            public int getSpanSize(int param1Int) {
              int j = ((NearbyPeoplePresenter)this.c.s()).l;
              int i = j;
              if (NearbyPeopleFragment.f(this.c) != null) {
                i = j;
                if (NearbyPeopleFragment.f(this.c).e(param1Int) != null) {
                  param1Int = NearbyPeopleFragment.f(this.c).getItemViewType(param1Int);
                  if (param1Int != 10)
                    return (param1Int != 11) ? ((NearbyPeoplePresenter)this.c.s()).l : ((NearbyPeoplePresenter)this.c.s()).l; 
                  i = 1;
                } 
              } 
              return i;
            }
          });
      this.mRecyclerView.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
      this.i.notifyDataSetChanged();
      (((NearbyPeoplePresenter)s()).s()).if_grid = true;
      ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.mRecyclerView.getLayoutParams();
      marginLayoutParams.leftMargin = DisplayUtil.a(this.g, 3.0F);
      this.mRecyclerView.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
      k();
    } else {
      this.mRecyclerView.setAdapter((RecyclerView.Adapter)this.j);
      GridLayoutManager gridLayoutManager = new GridLayoutManager(this.g, 1);
      gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(this) {
            public int getSpanSize(int param1Int) {
              return 1;
            }
          });
      this.mRecyclerView.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
      this.j.notifyDataSetChanged();
      (((NearbyPeoplePresenter)s()).s()).if_grid = false;
      ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.mRecyclerView.getLayoutParams();
      marginLayoutParams.leftMargin = DisplayUtil.a(this.g, 0.0F);
      this.mRecyclerView.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
      this.i.C();
    } 
    ((NearbyPeoplePresenter)s()).c(paramInteger.intValue());
  }
  
  public void a(String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iload_2
    //   3: invokespecial a : (Ljava/lang/String;Z)V
    //   6: aload_1
    //   7: invokevirtual hashCode : ()I
    //   10: istore_3
    //   11: iload_3
    //   12: ldc_w -1290256561
    //   15: if_icmpeq -> 43
    //   18: iload_3
    //   19: ldc_w 623698297
    //   22: if_icmpeq -> 28
    //   25: goto -> 58
    //   28: aload_1
    //   29: ldc_w '_load_type_loadmore_'
    //   32: invokevirtual equals : (Ljava/lang/Object;)Z
    //   35: ifeq -> 58
    //   38: iconst_1
    //   39: istore_3
    //   40: goto -> 60
    //   43: aload_1
    //   44: ldc_w '_load_type_refresh_'
    //   47: invokevirtual equals : (Ljava/lang/Object;)Z
    //   50: ifeq -> 58
    //   53: iconst_0
    //   54: istore_3
    //   55: goto -> 60
    //   58: iconst_m1
    //   59: istore_3
    //   60: iload_3
    //   61: ifeq -> 70
    //   64: iload_3
    //   65: iconst_1
    //   66: if_icmpeq -> 70
    //   69: return
    //   70: iload_2
    //   71: ifeq -> 152
    //   74: aload_0
    //   75: getfield i : Lcom/soft/blued/ui/find/adapter/PeopleGridQuickAdapter;
    //   78: invokevirtual n : ()Ljava/util/List;
    //   81: invokeinterface size : ()I
    //   86: ifne -> 99
    //   89: aload_0
    //   90: getfield noDataAndLoadFailView : Lcom/soft/blued/customview/NoDataAndLoadFailView;
    //   93: invokevirtual a : ()V
    //   96: goto -> 106
    //   99: aload_0
    //   100: getfield noDataAndLoadFailView : Lcom/soft/blued/customview/NoDataAndLoadFailView;
    //   103: invokevirtual c : ()V
    //   106: aload_0
    //   107: getfield i : Lcom/soft/blued/ui/find/adapter/PeopleGridQuickAdapter;
    //   110: invokevirtual getItemCount : ()I
    //   113: iconst_1
    //   114: if_icmplt -> 140
    //   117: aload_0
    //   118: getfield i : Lcom/soft/blued/ui/find/adapter/PeopleGridQuickAdapter;
    //   121: invokevirtual getItemCount : ()I
    //   124: bipush #9
    //   126: if_icmpgt -> 140
    //   129: aload_0
    //   130: getfield layoutFilterReset : Landroid/widget/LinearLayout;
    //   133: iconst_0
    //   134: invokevirtual setVisibility : (I)V
    //   137: goto -> 184
    //   140: aload_0
    //   141: getfield layoutFilterReset : Landroid/widget/LinearLayout;
    //   144: bipush #8
    //   146: invokevirtual setVisibility : (I)V
    //   149: goto -> 184
    //   152: aload_0
    //   153: getfield i : Lcom/soft/blued/ui/find/adapter/PeopleGridQuickAdapter;
    //   156: invokevirtual n : ()Ljava/util/List;
    //   159: invokeinterface size : ()I
    //   164: ifne -> 177
    //   167: aload_0
    //   168: getfield noDataAndLoadFailView : Lcom/soft/blued/customview/NoDataAndLoadFailView;
    //   171: invokevirtual b : ()V
    //   174: goto -> 184
    //   177: aload_0
    //   178: getfield noDataAndLoadFailView : Lcom/soft/blued/customview/NoDataAndLoadFailView;
    //   181: invokevirtual c : ()V
    //   184: aload_0
    //   185: invokevirtual k : ()V
    //   188: aload_0
    //   189: invokevirtual s : ()Lcom/blued/android/framework/ui/mvp/MvpPresenter;
    //   192: checkcast com/soft/blued/ui/find/presenter/NearbyPeoplePresenter
    //   195: astore_1
    //   196: aload_1
    //   197: aload_1
    //   198: getfield m : I
    //   201: iconst_1
    //   202: isub
    //   203: putfield m : I
    //   206: aload_0
    //   207: invokevirtual s : ()Lcom/blued/android/framework/ui/mvp/MvpPresenter;
    //   210: checkcast com/soft/blued/ui/find/presenter/NearbyPeoplePresenter
    //   213: getfield m : I
    //   216: ifne -> 224
    //   219: aload_0
    //   220: iconst_0
    //   221: invokespecial c : (Z)V
    //   224: aload_0
    //   225: getfield mRefreshLayout : Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
    //   228: invokevirtual g : ()Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
    //   231: pop
    //   232: aload_0
    //   233: getfield i : Lcom/soft/blued/ui/find/adapter/PeopleGridQuickAdapter;
    //   236: invokevirtual l : ()V
    //   239: aload_0
    //   240: getfield j : Lcom/soft/blued/ui/find/adapter/PeopleListQuickAdapter;
    //   243: invokevirtual l : ()V
    //   246: return
  }
  
  public void a(List<UserFindResult> paramList) {
    if (((NearbyPeoplePresenter)s()).n == 1) {
      c(paramList);
      return;
    } 
    d(paramList);
  }
  
  public void aL_() {
    PeopleListQuickAdapter peopleListQuickAdapter = this.j;
    if (peopleListQuickAdapter != null)
      this.o = peopleListQuickAdapter.n(); 
    PeopleGridQuickAdapter peopleGridQuickAdapter = this.i;
    if (peopleGridQuickAdapter != null)
      this.n = peopleGridQuickAdapter.n(); 
    RecommendViewMixedInNearby recommendViewMixedInNearby = this.mRecommendViewMixedInNearby;
    if (recommendViewMixedInNearby != null)
      recommendViewMixedInNearby.e(); 
    RecyclerView recyclerView = this.mRecyclerView;
    if (recyclerView != null)
      recyclerView.removeOnScrollListener(this.F); 
    AppBarLayout appBarLayout = this.appbar;
    if (appBarLayout != null)
      appBarLayout.b(this.E); 
    FrameLayout frameLayout = this.flBanner;
    if (frameLayout != null)
      frameLayout.removeAllViews(); 
    super.aL_();
    for (Unbinder unbinder1 : this.B) {
      if (unbinder1 != null)
        unbinder1.unbind(); 
    } 
    for (Unbinder unbinder1 : this.C) {
      if (unbinder1 != null)
        unbinder1.unbind(); 
    } 
    Unbinder unbinder = this.D;
    if (unbinder != null) {
      unbinder.unbind();
      this.D = null;
    } 
  }
  
  public void b(ShortEntranceExtra paramShortEntranceExtra) {
    a(paramShortEntranceExtra, true);
  }
  
  public void b(CallHelloModel paramCallHelloModel) {
    RecommendViewMixedInNearby recommendViewMixedInNearby = this.mRecommendViewMixedInNearby;
    if (recommendViewMixedInNearby != null && paramCallHelloModel != null)
      recommendViewMixedInNearby.a(paramCallHelloModel.isShowCount, paramCallHelloModel.count); 
  }
  
  public void b(FindDataExtra paramFindDataExtra) {
    a(paramFindDataExtra, true);
  }
  
  public void b(List<LiveTwoFloorModel> paramList) {
    this.u = paramList.get(0);
    LiveTwoFloorModel liveTwoFloorModel = this.u;
    if (liveTwoFloorModel == null) {
      this.v = false;
    } else if (TextUtils.equals("1", liveTwoFloorModel.type) && StringUtils.a(this.u.lid, 0) <= 0) {
      this.v = false;
    } else if (TextUtils.equals("3", this.u.type) && TextUtils.isEmpty(this.u.activity_addr)) {
      this.v = false;
    } else if (TextUtils.equals("2", this.u.type)) {
      this.v = false;
    } else {
      ImageFileLoader.a((IRequestHost)w_()).a(this.u.live_play).a();
      this.v = true;
    } 
    V();
  }
  
  public void c(String paramString) {
    if ("find".equals(paramString))
      W(); 
  }
  
  public void d(String paramString) {
    c(paramString);
  }
  
  public void e(String paramString) {
    if (!TextUtils.isEmpty(paramString) && h(paramString)) {
      int i = i(paramString);
      if (i >= 0 && i < this.y.size()) {
        this.r = i;
        g(paramString);
        W();
      } 
    } 
  }
  
  public void k() {
    a(new Runnable(this) {
          public void run() {
            if (((NearbyPeoplePresenter)this.a.s()).t() && NearbyPeopleFragment.f(this.a) != null) {
              NearbyPeopleFragment.f(this.a).e(NearbyPeopleFragment.i(this.a));
              if (NearbyPeopleFragment.i(this.a)) {
                NearbyPeopleFragment.f(this.a).B();
                return;
              } 
              NearbyPeopleFragment.f(this.a).C();
            } 
          }
        });
  }
  
  public void l() {
    a(new Runnable(this) {
          public void run() {
            if (this.a.header != null)
              this.a.header.b(); 
          }
        },  300L);
  }
  
  public void m() {
    int i = this.y.size();
    int j = this.r;
    if (i > j) {
      TabHolder tabHolder = this.y.get(j);
      b(false);
      ShapeHelper.a((ShapeHelper.ShapeView)tabHolder.tvSortTab, 2131100838);
      tabHolder.ivSortTab.setImageDrawable(BluedSkinUtils.b(this.g, 2131232622));
      tabHolder.layoutSortTab.setTag(Boolean.valueOf(true));
    } 
  }
  
  public void n() {
    if (this.x && ((NearbyPeoplePresenter)s()).h) {
      AdvertFloatFragment.a(this.g, ((NearbyPeoplePresenter)s()).i, ADConstants.AD_POSITION.h);
      ((NearbyPeoplePresenter)s()).h = false;
    } 
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() != 2131300092)
      return; 
    U();
  }
  
  public void onDestroy() {
    super.onDestroy();
    HomeTabClick.b("find", this);
  }
  
  public void onPause() {
    super.onPause();
    this.x = false;
    if (this.h && ((NearbyPeoplePresenter)s()).t()) {
      PeopleGridQuickAdapter peopleGridQuickAdapter = this.i;
      if (peopleGridQuickAdapter != null)
        peopleGridQuickAdapter.C(); 
    } 
  }
  
  public void onResume() {
    super.onResume();
    this.x = true;
    n();
    PeopleListQuickAdapter peopleListQuickAdapter = this.j;
    if (peopleListQuickAdapter != null)
      peopleListQuickAdapter.notifyDataSetChanged(); 
    k();
  }
  
  public void onStart() {
    super.onStart();
    O();
  }
  
  public void onStop() {
    super.onStop();
    N();
  }
  
  public int p() {
    return 2131493250;
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    this.h = paramBoolean;
    if (paramBoolean) {
      HomeTabClick.a("find", this);
      RecommendViewMixedInNearby recommendViewMixedInNearby = this.mRecommendViewMixedInNearby;
      if (recommendViewMixedInNearby != null)
        recommendViewMixedInNearby.b(CallHelloManager.a().b()); 
    } else {
      N();
    } 
    k();
  }
  
  public void u() {
    this.mRefreshLayout.i();
  }
  
  public void x() {
    super.x();
    this.i.c(true);
    this.j.c(true);
  }
  
  public void y() {
    super.y();
    this.i.c(false);
    this.j.c(false);
  }
  
  public class MenuHolder {
    @BindView(2131297924)
    ImageView ivSortMenu;
    
    @BindView(2131301348)
    TextView tvSortMenu;
    
    public MenuHolder(NearbyPeopleFragment this$0) {}
  }
  
  public class TabHolder {
    @BindView(2131297924)
    ImageView ivSortTab;
    
    @BindView(2131298094)
    ShapeLinearLayout layoutSortTab;
    
    @BindView(2131300720)
    TextView tvDivider;
    
    @BindView(2131301348)
    ShapeTextView tvSortTab;
    
    public TabHolder(NearbyPeopleFragment this$0) {}
  }
  
  public class TipHeaderHolder {
    @BindView(2131297362)
    ImageView imgHeader;
    
    public TipHeaderHolder(NearbyPeopleFragment this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\NearbyPeopleFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */