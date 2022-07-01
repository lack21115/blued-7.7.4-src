package com.soft.blued.ui.yy_room.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.view.BluedGridLayoutManager;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.yy_china.adapter.YYTopicAdapter;
import com.blued.android.module.yy_china.fragment.YYApplyFinishFragment;
import com.blued.android.module.yy_china.fragment.YYApplyFragment;
import com.blued.android.module.yy_china.fragment.YYCodeOfConductDialogFragment;
import com.blued.android.module.yy_china.listener.ITextWatcher;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYBannerModel;
import com.blued.android.module.yy_china.model.YYChatRoomFollowedModel;
import com.blued.android.module.yy_china.model.YYLiveState;
import com.blued.android.module.yy_china.model.YYRoomExtraModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYTopicModel;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.android.module.yy_china.trtc_audio.permission.PermissionHelper;
import com.blued.android.module.yy_china.utils.EnglishCharFilter;
import com.blued.android.module.yy_china.utils.PopupwindowFactory;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.soft.blued.customview.AutoScrollViewPager;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.HorizontalScrollView;
import com.soft.blued.customview.LinePageIndicator;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.VerticalTextView;
import com.soft.blued.ui.yy_room.adapter.BannerPagerAdapter;
import com.soft.blued.ui.yy_room.adapter.YYFollowAdapter;
import com.soft.blued.ui.yy_room.adapter.YYRoomAdapter;
import com.soft.blued.ui.yy_room.adapter.YYRoomTabsAdapter;
import com.soft.blued.ui.yy_room.presenter.YYChatRoomsPresenter;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class YYChatRoomsFragment extends MvpFragment<YYChatRoomsPresenter> implements View.OnClickListener, YYCodeOfConductDialogFragment.OnClickHintFragmentLister {
  @BindView(2131296447)
  AppBarLayout appbar;
  
  @BindView(2131301772)
  AutoScrollViewPager asvpBannerHotNew;
  
  @BindView(2131301773)
  ConstraintLayout asvpBannerHotParent;
  
  @BindView(2131296843)
  CoordinatorLayout coordinator;
  
  YYCodeOfConductDialogFragment d;
  
  YYLiveState e;
  
  private List<Unbinder> f = new ArrayList<Unbinder>();
  
  @BindView(2131297098)
  FrameLayout flCodeOfCondutLayout;
  
  @BindView(2131297122)
  FrameLayout flLoadingView;
  
  private YYRoomTabsAdapter g;
  
  private YYFollowAdapter h;
  
  private PopupWindow i;
  
  private int j;
  
  @BindView(2131298730)
  ShapeLinearLayout llBottomView;
  
  @BindView(2131298810)
  LinearLayout llFollowView;
  
  @BindView(2131299045)
  LinearLayout llRefresh;
  
  @BindView(2131301779)
  LinePageIndicator lpiLine;
  
  private int n;
  
  private BannerPagerAdapter o;
  
  private YYRoomAdapter p;
  
  private NoDataAndLoadFailView q;
  
  private String r;
  
  @BindView(2131299616)
  SmartRefreshLayout refreshLayout;
  
  @BindView(2131299389)
  NoDataAndLoadFailView roomNoDataView;
  
  @BindView(2131299772)
  RecyclerView rvFollowList;
  
  @BindView(2131299790)
  RecyclerView rvRoomListVew;
  
  @BindView(2131300164)
  RecyclerView rvRoomTabs;
  
  @BindView(2131299842)
  HorizontalScrollView scrollView;
  
  @BindView(2131300300)
  CommonTopTitleNoTrans topTitle;
  
  @BindView(2131300683)
  TextView tvCreateRoom;
  
  @BindView(2131300780)
  VerticalTextView tvFollowedMore;
  
  @BindView(2131301051)
  TextView tvMoreFollowed;
  
  @BindView(2131301213)
  TextView tvRandomEnter;
  
  private void J() {
    this.o = new BannerPagerAdapter(getContext(), (IRequestHost)w_());
    this.asvpBannerHotNew.setAdapter((PagerAdapter)this.o);
    this.asvpBannerHotNew.setInterval(3000L);
    this.lpiLine.setViewPager((ViewPager)this.asvpBannerHotNew);
  }
  
  private void K() {
    this.h = new YYFollowAdapter(getContext(), (IRequestHost)w_());
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    linearLayoutManager.setOrientation(0);
    this.rvFollowList.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.rvFollowList.setAdapter((RecyclerView.Adapter)this.h);
    this.rvFollowList.addItemDecoration(new RecyclerView.ItemDecoration(this) {
          public void getItemOffsets(Rect param1Rect, View param1View, RecyclerView param1RecyclerView, RecyclerView.State param1State) {
            if (param1RecyclerView.getChildLayoutPosition(param1View) == 0) {
              param1Rect.set(YYChatRoomsFragment.c(this.a), 0, YYChatRoomsFragment.d(this.a), 0);
              return;
            } 
            param1Rect.set(0, 0, YYChatRoomsFragment.d(this.a), 0);
          }
        });
    this.h.a(new BaseQuickAdapter.OnItemClickListener(this) {
          public void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            YYChatRoomFollowedModel.DataBean dataBean = YYChatRoomsFragment.b(this.a).a(param1Int);
            YYRoomInfoManager.d().a((BaseFragmentActivity)this.a.getActivity(), dataBean.room_id, "chat_room_followed_list");
          }
        });
  }
  
  private void L() {
    BluedGridLayoutManager bluedGridLayoutManager = new BluedGridLayoutManager(getContext(), 2);
    this.rvRoomListVew.setLayoutManager((RecyclerView.LayoutManager)bluedGridLayoutManager);
    this.p = new YYRoomAdapter(getContext(), this, this.r);
    this.rvRoomListVew.setAdapter((RecyclerView.Adapter)this.p);
    this.rvRoomListVew.addItemDecoration(new RecyclerView.ItemDecoration(this) {
          public void getItemOffsets(Rect param1Rect, View param1View, RecyclerView param1RecyclerView, RecyclerView.State param1State) {
            if (param1RecyclerView.getChildAdapterPosition(param1View) % 2 == 0) {
              param1Rect.right = DensityUtils.a(this.a.getContext(), 5.0F);
            } else {
              param1Rect.left = DensityUtils.a(this.a.getContext(), 5.0F);
            } 
            param1Rect.bottom = DensityUtils.a(this.a.getContext(), 10.0F);
          }
        });
    this.q = new NoDataAndLoadFailView(getContext());
    this.q.setNoDataImg(2131232640);
    this.q.setNoDataStr(2131759477);
    this.p.e((View)this.q);
    this.p.a(new BaseQuickAdapter.OnItemClickListener(this) {
          public void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            if (ClickUtils.a(param1View.getId()))
              return; 
            if (LiveFloatManager.a().x()) {
              ToastUtils.a("你正在直播间内，需要退出后操作");
              return;
            } 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("view id: ");
            stringBuilder.append(param1View.getId());
            Logger.d("setOnItemClickListener", new Object[] { stringBuilder.toString() });
            YYRoomModel yYRoomModel = YYChatRoomsFragment.a(this.a).n().get(param1Int);
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_TAB_PAGE_ROOM_CLICK, yYRoomModel.room_id, yYRoomModel.uid, ((YYChatRoomsPresenter)this.a.s()).q(), yYRoomModel.room_type, YYChatRoomsFragment.f(this.a));
            this.a.a(yYRoomModel);
          }
        });
  }
  
  public static void a(Context paramContext, String paramString) {
    Bundle bundle = new Bundle();
    bundle.putString("from_source", paramString);
    TerminalActivity.a(bundle);
    TerminalActivity.d(paramContext, YYChatRoomsFragment.class, bundle);
  }
  
  private void d(String paramString) {
    SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
    if (smartRefreshLayout != null) {
      smartRefreshLayout.g();
      this.refreshLayout.h();
    } 
    RecyclerView recyclerView = this.rvRoomListVew;
    if (recyclerView != null)
      recyclerView.scrollToPosition(0); 
    ((YYChatRoomsPresenter)s()).c(paramString, true);
  }
  
  private void f(List<YYTopicModel> paramList) {
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    linearLayoutManager.setOrientation(0);
    this.rvRoomTabs.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.g = new YYRoomTabsAdapter(getContext(), this.r);
    this.rvRoomTabs.setAdapter((RecyclerView.Adapter)this.g);
    this.g.a(new BaseQuickAdapter.OnItemClickListener(this) {
          public void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            if (YYChatRoomsFragment.a(this.a) != null) {
              YYChatRoomsFragment.a(this.a).a();
              YYChatRoomsFragment.a(this.a).n().clear();
              YYChatRoomsFragment.a(this.a).notifyDataSetChanged();
            } 
            YYChatRoomsFragment.e(this.a).a(param1Int);
            this.a.llRefresh.setVisibility(0);
            YYTopicModel yYTopicModel = YYChatRoomsFragment.e(this.a).n().get(param1Int);
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_HOME_PAGE_TAB_SHOW, "", "", yYTopicModel.type_id, YYChatRoomsFragment.f(this.a));
            this.a.a(new Runnable(this, yYTopicModel) {
                  public void run() {
                    YYChatRoomsFragment.a(this.b.a, this.a.type_id);
                  }
                }300L);
          }
        });
    String str = ((YYChatRoomsPresenter)s()).q();
    int i = 0;
    int j = 0;
    while (i < paramList.size()) {
      YYTopicModel yYTopicModel = paramList.get(i);
      if (TextUtils.equals(yYTopicModel.type_id, str)) {
        yYTopicModel.isChecked = true;
        j = i;
      } else {
        yYTopicModel.isChecked = false;
      } 
      i++;
    } 
    this.g.c(paramList);
    this.rvRoomTabs.smoothScrollToPosition(j);
    EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_HOME_PAGE_TAB_SHOW, "", "", str, this.r);
    ((YYChatRoomsPresenter)s()).c(str, true);
  }
  
  public boolean A() {
    return true;
  }
  
  public void E() {
    this.p.c(null);
    this.q.a();
  }
  
  public void F() {
    this.llRefresh.setVisibility(8);
    this.refreshLayout.g();
    this.refreshLayout.h();
  }
  
  public void G() {
    this.flLoadingView.setVisibility(0);
  }
  
  public void H() {
    this.flLoadingView.setVisibility(8);
  }
  
  public void I() {
    PopupWindow popupWindow = this.i;
    if (popupWindow != null)
      popupWindow.dismiss(); 
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.r = getArguments().getString("from_source");
    this.j = DisplayUtil.a(AppInfo.d(), 10.0F);
    this.n = DisplayUtil.a(AppInfo.d(), 8.0F);
    this.topTitle.e();
    this.topTitle.a();
    this.topTitle.setLeftImg(2131232743);
    this.topTitle.setCenterText(getString(2131759418));
    this.topTitle.setLeftClickListener(this);
    this.topTitle.e();
    this.topTitle.setCenterTextColor(2131100838);
    if (StatusBarHelper.a()) {
      RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)this.topTitle.getLayoutParams();
      layoutParams.topMargin = StatusBarHelper.a(getContext());
      this.topTitle.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    } 
    this.tvMoreFollowed.setOnClickListener(this);
    this.tvCreateRoom.setOnClickListener(this);
    this.tvRandomEnter.setOnClickListener(this);
    J();
    K();
    L();
    this.refreshLayout.a(new OnRefreshLoadMoreListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            ((YYChatRoomsPresenter)this.a.s()).f();
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            if (YYChatRoomsFragment.a(this.a) != null)
              YYChatRoomsFragment.a(this.a).a(); 
            ((YYChatRoomsPresenter)this.a.s()).e();
          }
        });
    this.scrollView.setOnReleaseListener(new HorizontalScrollView.OnReleaseListener(this) {
          public void a() {
            if (YYChatRoomsFragment.b(this.a).n().size() > 5)
              YYFollowedFragment.a(this.a.getContext()); 
          }
        });
    for (Fragment fragment : getChildFragmentManager().getFragments()) {
      if (fragment instanceof YYCodeOfConductDialogFragment) {
        this.d = (YYCodeOfConductDialogFragment)fragment;
        this.d.a(this);
        break;
      } 
    } 
  }
  
  public void a(YYLiveState paramYYLiveState) {
    if (LiveFloatManager.a().x()) {
      ToastUtils.a("你正在直播间内，需要退出后操作");
      return;
    } 
    if (AudioChannelManager.e().h()) {
      ToastUtils.a("你正在聊天室房间内，需要退出后操作");
      return;
    } 
    if (paramYYLiveState.is_read_norms == 0) {
      b(paramYYLiveState);
      return;
    } 
    if (paramYYLiveState.chatroom_audited == 1) {
      EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_CREATE_CLICK, this.r, ChatRoomProtos.UserType.APPLY_SUCCESS_USER);
      c(((YYChatRoomsPresenter)s()).q());
      return;
    } 
    if (paramYYLiveState.chatroom_audited == 0) {
      EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_CREATE_CLICK, this.r, ChatRoomProtos.UserType.APPLYING_USER);
      YYApplyFinishFragment.a(getContext(), paramYYLiveState.chatroom_audited);
      return;
    } 
    EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_CREATE_CLICK, this.r, ChatRoomProtos.UserType.COMMON_USER);
    YYApplyFragment.a(getContext());
  }
  
  public void a(YYRoomExtraModel paramYYRoomExtraModel) {
    if (TextUtils.equals(paramYYRoomExtraModel.is_chatroom_wlist, "1")) {
      this.llBottomView.setVisibility(0);
      EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_CREATE_SHOW, "", "", "", this.r);
      return;
    } 
    this.llBottomView.setVisibility(8);
  }
  
  public void a(YYRoomModel paramYYRoomModel) {
    YYRoomInfoManager.d().a((BaseFragmentActivity)getActivity(), paramYYRoomModel.room_id, "");
  }
  
  public void a(List<YYBannerModel> paramList) {
    this.lpiLine.setVisibility(0);
    if (paramList.size() == 1)
      this.lpiLine.setVisibility(8); 
    this.o.a(paramList);
    this.asvpBannerHotParent.setVisibility(0);
    this.asvpBannerHotNew.f();
    this.asvpBannerHotNew.setCurrentItem(0, false);
    this.lpiLine.a((ViewPager)this.asvpBannerHotNew, 0);
  }
  
  public void aL_() {
    super.aL_();
    List<Unbinder> list = this.f;
    if (list != null) {
      Iterator<Unbinder> iterator = list.iterator();
      while (iterator.hasNext())
        ((Unbinder)iterator.next()).unbind(); 
      this.f.clear();
    } 
  }
  
  public void b() {
    FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
    if (this.d != null) {
      this.flCodeOfCondutLayout.setBackgroundColor(0);
      fragmentTransaction.setCustomAnimations(2130772044, 2130772045);
      fragmentTransaction.remove((Fragment)this.d).commitNowAllowingStateLoss();
    } 
  }
  
  public void b(YYLiveState paramYYLiveState) {
    this.e = paramYYLiveState;
    FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
    this.d = new YYCodeOfConductDialogFragment();
    this.flCodeOfCondutLayout.setBackgroundColor(1291845632);
    fragmentTransaction.setCustomAnimations(2130772044, 2130772045);
    fragmentTransaction.add(2131297098, (Fragment)this.d, "CodeOfCondut");
    this.d.a(this);
    fragmentTransaction.commitNowAllowingStateLoss();
  }
  
  public void b(List<YYChatRoomFollowedModel.DataBean> paramList) {
    LinearLayout linearLayout = this.llFollowView;
    byte b = 0;
    linearLayout.setVisibility(0);
    VerticalTextView verticalTextView = this.tvFollowedMore;
    if (paramList.size() <= 4)
      b = 8; 
    verticalTextView.setVisibility(b);
    this.h.c(paramList);
  }
  
  public void c() {
    YYLiveState yYLiveState = this.e;
    if (yYLiveState != null) {
      yYLiveState.is_read_norms = 1;
      a(yYLiveState);
      this.e = null;
      return;
    } 
    ((YYChatRoomsPresenter)s()).n();
  }
  
  public void c(String paramString) {
    View view = LayoutInflater.from(getContext()).inflate(2131494233, null);
    CreateRoomHolder createRoomHolder = new CreateRoomHolder(this);
    Unbinder unbinder = ButterKnife.a(createRoomHolder, view);
    this.f.add(unbinder);
    createRoomHolder.etRoomName.addTextChangedListener((TextWatcher)new ITextWatcher(this, createRoomHolder) {
          public void afterTextChanged(Editable param1Editable) {
            if (TextUtils.isEmpty((CharSequence)param1Editable)) {
              this.a.tvCreate.setEnabled(false);
              ShapeHelper.a((ShapeHelper.ShapeView)this.a.tvCreate, 2131100808, 2131100808);
              return;
            } 
            this.a.tvCreate.setEnabled(true);
            ShapeHelper.a((ShapeHelper.ShapeView)this.a.tvCreate, 2131100658, 2131100672);
          }
        });
    createRoomHolder.etRoomName.setFilters(new InputFilter[] { (InputFilter)new EnglishCharFilter(32) });
    createRoomHolder.etRoomName.setText(String.format(getResources().getString(2131758639), new Object[] { UserInfo.a().i().getName() }));
    GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
    createRoomHolder.listView.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
    createRoomHolder.listView.addItemDecoration(new RecyclerView.ItemDecoration(this) {
          public void getItemOffsets(Rect param1Rect, View param1View, RecyclerView param1RecyclerView, RecyclerView.State param1State) {
            param1Rect.bottom = YYChatRoomsFragment.c(this.a);
          }
        });
    YYTopicAdapter yYTopicAdapter = new YYTopicAdapter(getContext(), ((YYChatRoomsPresenter)s()).q(), this.r);
    createRoomHolder.listView.setAdapter((RecyclerView.Adapter)yYTopicAdapter);
    createRoomHolder.tvCancel.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            YYChatRoomsFragment.g(this.a).dismiss();
          }
        });
    createRoomHolder.tvCreate.setOnClickListener(new View.OnClickListener(this, yYTopicAdapter, createRoomHolder) {
          public void onClick(View param1View) {
            if (ClickUtils.a(2131300682))
              return; 
            if (this.a.a() == null) {
              ToastUtils.b("请选择房间类型");
              return;
            } 
            String str = this.b.etRoomName.getText().toString().trim();
            if (TextUtils.isEmpty(str)) {
              ToastUtils.b("房间名不能为空");
              return;
            } 
            EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_CREATE_CONFIRM_CLICK, str, (this.a.a()).type_id, YYChatRoomsFragment.f(this.c));
            YYChatRoomsFragment.g(this.c).dismiss();
            ((YYChatRoomsPresenter)this.c.s()).a((this.a.a()).type_id, this.b.etRoomName.getText().toString().trim());
          }
        });
    yYTopicAdapter.a(new BaseQuickAdapter.OnItemClickListener(this, yYTopicAdapter) {
          public void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            this.a.a(param1Int);
          }
        });
    ArrayList<YYTopicModel> arrayList = new ArrayList();
    Iterator<YYTopicModel> iterator = ((YYChatRoomsPresenter)s()).p().iterator();
    boolean bool = false;
    while (iterator.hasNext()) {
      YYTopicModel yYTopicModel1 = iterator.next();
      YYTopicModel yYTopicModel2 = new YYTopicModel();
      yYTopicModel2.type_id = yYTopicModel1.type_id;
      yYTopicModel2.room_type = yYTopicModel1.room_type;
      yYTopicModel2.type_img = yYTopicModel1.type_img;
      if (TextUtils.equals(paramString, yYTopicModel1.type_id)) {
        yYTopicModel2.isChecked = true;
        bool = true;
      } else {
        yYTopicModel2.isChecked = yYTopicModel1.isChecked;
      } 
      arrayList.add(yYTopicModel2);
    } 
    if (!bool)
      ((YYTopicModel)arrayList.get(0)).isChecked = true; 
    yYTopicAdapter.c(arrayList);
    this.i = (new PopupwindowFactory.Builder(getContext())).a(view).a(80).c(-2).b(AppInfo.l).d(2131100726).h();
    a(new Runnable(this, createRoomHolder) {
          public void run() {
            YYChatRoomsFragment.CreateRoomHolder createRoomHolder = this.a;
            if (createRoomHolder != null) {
              if (createRoomHolder.etRoomName == null)
                return; 
              this.a.etRoomName.setFocusableInTouchMode(true);
              this.a.etRoomName.setFocusable(true);
              this.a.etRoomName.requestFocus();
              ((InputMethodManager)this.b.getContext().getSystemService("input_method")).showSoftInput((View)this.a.etRoomName, 0);
              this.a.etRoomName.setSelection(this.a.etRoomName.getText().length());
            } 
          }
        }250L);
  }
  
  public void c(List<YYTopicModel> paramList) {
    Logger.e("cache", new Object[] { "setRoomTypes ... " });
    ArrayList<YYTopicModel> arrayList = new ArrayList();
    YYTopicModel yYTopicModel = new YYTopicModel();
    yYTopicModel.room_type = "热门房间";
    yYTopicModel.type_id = "0";
    arrayList.add(yYTopicModel);
    arrayList.addAll(paramList);
    f(arrayList);
  }
  
  public void d(List<YYRoomModel> paramList) {
    this.p.a(paramList);
  }
  
  public void e(List<YYRoomModel> paramList) {
    this.p.a(((YYChatRoomsPresenter)s()).q());
    this.p.c(paramList);
    this.q.c();
  }
  
  public void k() {
    this.asvpBannerHotParent.setVisibility(8);
    this.lpiLine.setVisibility(8);
  }
  
  public void l() {
    this.llFollowView.setVisibility(8);
    this.h.c(new ArrayList());
  }
  
  public void m() {
    this.q.setNoDataImg(2131232640);
    this.q.setNoDataStr(2131758232);
    this.roomNoDataView.a();
    this.roomNoDataView.setVisibility(0);
  }
  
  public void n() {
    YYRoomTabsAdapter yYRoomTabsAdapter = this.g;
    if (yYRoomTabsAdapter == null || yYRoomTabsAdapter.getItemCount() <= 0)
      E(); 
    this.refreshLayout.g();
    this.refreshLayout.b(false);
  }
  
  public void onActivityCreated(Bundle paramBundle) {
    super.onActivityCreated(paramBundle);
    EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_ENTER_CLICK, "", "", "", this.r);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0)
      return; 
    if (paramInt1 != 100)
      return; 
    if (paramIntent != null) {
      boolean bool = paramIntent.getBooleanExtra("auth_upload_state", false);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("success:");
      stringBuilder.append(bool);
      Log.i("YYChatRoomsFragment", stringBuilder.toString());
      if (bool)
        YYApplyFinishFragment.a(getContext(), 0); 
    } 
  }
  
  public void onClick(View paramView) {
    if (ClickUtils.a(2131300683))
      return; 
    switch (paramView.getId()) {
      default:
        return;
      case 2131301213:
        YYApplyFragment.a(getContext());
        return;
      case 2131301051:
        YYFollowedFragment.a(getContext());
        return;
      case 2131300683:
        if (LiveFloatManager.a().x()) {
          ToastUtils.a("你正在直播间内，需要退出后操作");
          return;
        } 
        if (AudioChannelManager.e().h()) {
          ToastUtils.a("你正在聊天室房间内，需要退出后操作");
          return;
        } 
        PermissionHelper.a(new PermissionCallbacks(this) {
              public void a(String[] param1ArrayOfString) {
                AppMethods.a("麦克风已被禁用，请在设置中授权麦克风使用");
              }
              
              public void aa_() {
                ((YYChatRoomsPresenter)this.a.s()).n();
              }
            });
        return;
      case 2131296863:
        break;
    } 
    C();
  }
  
  public void onResume() {
    super.onResume();
    SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
    if (smartRefreshLayout != null)
      smartRefreshLayout.i(); 
  }
  
  public int p() {
    return 2131493371;
  }
  
  public void x() {
    super.x();
    Logger.d("YYChatRoomsFragment", new Object[] { "enableLoadMore ... " });
    this.refreshLayout.b(true);
  }
  
  public void y() {
    super.y();
    Logger.d("YYChatRoomsFragment", new Object[] { "disableLoadMore ... " });
    this.refreshLayout.b(false);
  }
  
  public class CreateRoomHolder {
    @BindView(2131297013)
    EditText etRoomName;
    
    @BindView(2131300305)
    RecyclerView listView;
    
    @BindView(2131300611)
    ImageView tvCancel;
    
    @BindView(2131300682)
    ShapeTextView tvCreate;
    
    public CreateRoomHolder(YYChatRoomsFragment this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\yy_room\fragment\YYChatRoomsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */